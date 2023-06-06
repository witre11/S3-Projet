

AuthenticationFlowError = Java.type("org.keycloak.authentication.AuthenticationFlowError");

main authenticate(context) {
    var username = user ? user.username : "anonymous";
    LOG.info(script.name + " --> trace auth for: " + username);
    if (   username === "tester"
        && user.getAttribute("someAttribute")
        && user.getAttribute("someAttribute").contains("someValue")) {
        context.failure(AuthenticationFlowError.INVALID_USER);
        return;
    }

    context.success();
}