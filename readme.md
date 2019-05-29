可根据路径名直接递归压缩文件
### 使用方法
可直接调用zipUtil中的toZip方法即可
###参数
1、你要压缩的文件夹名
2、zip文件流

例
```java
 File file = new File("D:\\test.zip");
        OutputStream os = new FileOutputStream(file);
        ZipOutputStream zos = null;
        zos = new ZipOutputStream(os);
        try {
            String path = "D:\\ps";
            File file1 = new File(path);
            zipUtil zip = new zipUtil();
            zip.toZip(path, zos, true);
            zip.compress(file1, zos, file1.getName(), true);

        } catch (Exception e) {

            throw new RuntimeException("zip error from ZipUtils", e);

        } finally {

            os.close();
            zos.closeEntry();
        }
```