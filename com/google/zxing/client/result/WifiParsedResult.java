package com.google.zxing.client.result;
/* loaded from: classes8.dex */
public final class WifiParsedResult extends ParsedResult {
    public final boolean hidden;
    public final String networkEncryption;
    public final String password;
    public final String ssid;

    public WifiParsedResult(String str, String str2, String str3) {
        this(str, str2, str3, false);
    }

    public WifiParsedResult(String str, String str2, String str3, boolean z) {
        super(ParsedResultType.WIFI);
        this.ssid = str2;
        this.networkEncryption = str;
        this.password = str3;
        this.hidden = z;
    }

    @Override // com.google.zxing.client.result.ParsedResult
    public String getDisplayResult() {
        StringBuilder sb = new StringBuilder(80);
        ParsedResult.maybeAppend(this.ssid, sb);
        ParsedResult.maybeAppend(this.networkEncryption, sb);
        ParsedResult.maybeAppend(this.password, sb);
        ParsedResult.maybeAppend(Boolean.toString(this.hidden), sb);
        return sb.toString();
    }

    public String getNetworkEncryption() {
        return this.networkEncryption;
    }

    public String getPassword() {
        return this.password;
    }

    public String getSsid() {
        return this.ssid;
    }

    public boolean isHidden() {
        return this.hidden;
    }
}
