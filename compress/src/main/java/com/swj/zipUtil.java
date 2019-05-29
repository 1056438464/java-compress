package com.swj;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.OutputStream;
import java.util.List;
import java.util.zip.ZipEntry;
import java.util.zip.ZipOutputStream;


public class zipUtil {
	private static final int BUFFER_SIZE = 2 * 1024;

	/**
	 * 压缩成ZIP 方法
	 * 
	 * @param srcDir
	 *            压缩文件夹路径
	 * @param out
	 *            压缩文件输出流
	 * @param KeepDirStructure
	 *            是否保留原来的目录结构,true:保留目录结构;
	 *            false:所有文件跑到压缩包根目录下(注意：不保留目录结构可能会出现同名文件,会压缩失败)
	 * @throws RuntimeException
	 *             压缩失败会抛出运行时异常
	 */
	public static void toZip(String srcDir, OutputStream out, boolean KeepDirStructure) throws RuntimeException {


		ZipOutputStream zos = null;

		try {

			zos = new ZipOutputStream(out);
			File sourceFile = new File(srcDir);
			compress(sourceFile, zos, sourceFile.getName(), KeepDirStructure);

		} catch (Exception e) {
			throw new RuntimeException("zip error from ZipUtils", e);
		} finally {
			if (zos != null) {
				try {
					zos.close();
				} catch (IOException e) {
					e.printStackTrace();
				}

			}

		}

	}

	/**
	 * 
	 * 压缩成ZIP 方法2
	 * 
	 * @param srcFiles
	 *            需要压缩的文件列表
	 * 
	 * @param out
	 *            压缩文件输出流
	 * 
	 * @throws RuntimeException
	 *             压缩失败会抛出运行时异常
	 * 
	 */

	public static void toZip(List<File> srcFiles, OutputStream out) throws RuntimeException {

		long start = System.currentTimeMillis();
		ZipOutputStream zos = null;

		try {

			zos = new ZipOutputStream(out);

			for (File srcFile : srcFiles) {

				byte[] buf = new byte[BUFFER_SIZE];
				zos.putNextEntry(new ZipEntry(srcFile.getName()));
				int len;

				FileInputStream in = new FileInputStream(srcFile);

				while ((len = in.read(buf)) != -1) {

					zos.write(buf, 0, len);

				}

				zos.closeEntry();
				in.close();

			}

		} catch (Exception e) {

			throw new RuntimeException("zip error from ZipUtils", e);

		} finally {

			if (zos != null) {

				try {

					zos.close();

				} catch (IOException e) {

					e.printStackTrace();

				}

			}

		}

	}


	public static void compress(File file, ZipOutputStream zos, String name, boolean KeepDirStructure) throws Exception {

		byte[] buf = new byte[BUFFER_SIZE];

		if(file.isFile()){
			zos.putNextEntry(new ZipEntry(name));

			FileInputStream fin = new FileInputStream(file);
			int len = 0;
			while((len = fin.read(buf))>0){

				zos.write(buf,0,len);

			}

			zos.closeEntry();
			fin.close();
		}else{

			File[] files = file.listFiles();
			if(files == null && files.length == 0){

				if(KeepDirStructure){
					zos.putNextEntry(new ZipEntry(name+"/"));
					zos.closeEntry();
				}

			}else{

				for (File tempFile:files) {

					if(KeepDirStructure){

						compress(tempFile, zos, name+"/"+tempFile.getName(),KeepDirStructure);

					}else{

						compress(tempFile, zos, tempFile.getName(),KeepDirStructure);

					}

				}

			}

		}
	}
}
