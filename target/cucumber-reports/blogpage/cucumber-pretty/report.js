$(document).ready(function() {var formatter = new CucumberHTML.DOMFormatter($('.cucumber-report'));formatter.uri("file:src/test/resources/features/BlogPage/01_VerifyPageName_BlogPage.feature");
formatter.feature({
  "name": "Home Page Verifications",
  "description": "",
  "keyword": "Feature"
});
formatter.scenario({
  "name": "Check page display",
  "description": "",
  "keyword": "Scenario",
  "tags": [
    {
      "name": "@blog_page"
    }
  ]
});
formatter.before({
  "status": "passed"
});
formatter.beforestep({
  "status": "passed"
});
formatter.step({
  "name": "User navigates to QATechTesting HomePage",
  "keyword": "Given "
});
formatter.match({});
formatter.result({
  "status": "undefined"
});
formatter.beforestep({
  "status": "skipped"
});
formatter.step({
  "name": "User verify that Blog Link is displayed",
  "keyword": "Then "
});
formatter.match({});
formatter.result({
  "status": "undefined"
});
formatter.beforestep({
  "status": "skipped"
});
formatter.step({
  "name": "User verify that Blog page title is displayed",
  "keyword": "And "
});
formatter.match({
  "location": "BlogPageSteps.blogPageIsDisplayed()"
});
formatter.result({
  "status": "skipped"
});
formatter.after({
  "status": "passed"
});
});