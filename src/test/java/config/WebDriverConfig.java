package config;

import org.aeonbits.owner.Config;

@Config.Sources({
        "classpath:${env}.properties",
        "classpath:local.properties"

})


public interface WebDriverConfig extends Config {

    @Key("baseUrl")
//    @DefaultValue("https://www.tbank.ru/")
    String getBaseUrl();

    @Key("browser")
    @DefaultValue("chrome")
    String getBrowser();

    @Key("browserVersion")
    @DefaultValue("147")
    String getBrowserVersion();

    @Key("browserSize")
    @DefaultValue("1920x1024")
    String getBrowserSize();

    @Key("isRemote")
    @DefaultValue("false")
    boolean isRemote();

    @Key("remoteUrl")
    String getRemoteUrl();

    @Key("remoteUsername")
    String getRemoteUsername();

    @Key("remotePassword")
    String getRemotePassword();


}
