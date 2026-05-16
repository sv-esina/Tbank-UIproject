package config;

import org.aeonbits.owner.Config;

@Config.Sources({
        "classpath:${env}.properties",
        "classpath:local.properties"

})


public interface WebDriverConfig extends Config {

    @Key("baseUrl")
    @DefaultValue("https://www.tbank.ru/")
    String getBaseUrl();

    @Key("browser")
    String getBrowser();

    @Key("browserVersion")
    String getBrowserVersion();

    @Key("browserSize")
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
