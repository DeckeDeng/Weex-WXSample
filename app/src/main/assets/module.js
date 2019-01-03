<template>
  <div>
    <text onclick="click">testMyModule</text>
  </div>
</template>

<script>
  module.exports = {
    methods: {
      click: function() {
        weex.requireModule('MyModule').printLog("I am a weex Module");
      }
    }
  }
</script>