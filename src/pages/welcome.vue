
<template>
  <div class="window">
    <div id="text">
        <li style="list-style:none" >Welcome...</li>
      <input type="text" name="" id='in'>
    </div>
  </div>
</template>

<script>

import HelloWorld from '@/components/HelloWorld.vue'

export default {
  name: 'Welcome',
  components: {
    HelloWorld: HelloWorld
  }
}
</script>

<style scoped>
  body {
    background-color: #000000;
  }
  .window {
    background-color: #000000;
    height: 100%;
  }
  #text {
    background-color: #000;
  }
  #text li {
    color: #FFFFFF;
  }
  input {
    background-color: #000;
    border: 0;
    color: #FFFFFF;
    font-size:12px;
    width: 100%;
    outline:none;
  }
</style>
