// https://eslint.org/docs/user-guide/configuring

module.exports = {
  root: true,
  parserOptions: {
    parser: 'babel-eslint'
  },
  env: {
    browser: true,
  },
  extends: [
    // https://github.com/vuejs/eslint-plugin-vue#priority-a-essential-error-prevention
    // consider switching to `plugin:vue/strongly-recommended` or `plugin:vue/recommended` for stricter rules.
    'plugin:vue/essential',
    // https://github.com/standard/standard/blob/master/docs/RULES-en.md
    'standard'

],
  // required to lint *.vue files
  plugins: [
     'vue'
  ],
  // add your custom rules here
  rules: {
    // allow async-await
    // 'generator-star-spacing': 'off',
    // allow debugger during development
    // 'no-debugger': process.env.NODE_ENV === 'production' ? 'error' : 'off',

    "linebreak-style": [
      "error",
      "unix"
    ],
    //"semi": ["error", "always"],
    "no-empty": 0,
    "comma-dangle": 0,
    "no-unused-vars": 0,
    "no-console": 0,
    "no-const-assign": 2,
    "no-dupe-class-members": 2,
    "no-duplicate-case": 2,
    "no-extra-parens": [2, "functions"],
    "no-self-compare": 2,
    "accessor-pairs": 2,
    "comma-spacing": [2, {
      "before": false,
      "after": true
    }],
    "constructor-super": 2,
    "new-cap": [2, {
      "newIsCap": true,
      "capIsNew": false
    }],
    "new-parens": 2,
    "no-array-constructor": 2,
    "no-class-assign": 2,
    "no-cond-assign": 2

  }
}
