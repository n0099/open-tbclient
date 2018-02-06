package com.sina.weibo.sdk.cmd;

import android.text.TextUtils;
import com.baidu.fsg.base.widget.textfilter.EditTextPasteFilterUtils;
import com.sina.weibo.sdk.exception.WeiboException;
import com.xiaomi.mipush.sdk.Constants;
import java.util.Arrays;
import java.util.List;
import org.json.JSONObject;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes3.dex */
public class AppInstallCmd extends BaseCmd {
    private List<String> appPackages;
    private String appSign;
    private long appVersion;
    private String downloadUrl;

    public AppInstallCmd() {
    }

    public AppInstallCmd(String str) throws WeiboException {
        super(str);
    }

    public AppInstallCmd(JSONObject jSONObject) {
        super(jSONObject);
    }

    @Override // com.sina.weibo.sdk.cmd.BaseCmd
    public void initFromJsonObj(JSONObject jSONObject) {
        super.initFromJsonObj(jSONObject);
        this.downloadUrl = jSONObject.optString("download_url");
        String optString = jSONObject.optString("app_package");
        if (!TextUtils.isEmpty(optString)) {
            this.appPackages = Arrays.asList(optString.split(EditTextPasteFilterUtils.EDITTEXT_PASTE_INTERCEPTOR_SEPERATOR));
        }
        this.appSign = jSONObject.optString("app_sign");
        this.appVersion = jSONObject.optLong(Constants.EXTRA_KEY_APP_VERSION);
    }

    public long getAppVersion() {
        return this.appVersion;
    }

    public void setAppVersion(long j) {
        this.appVersion = j;
    }

    public List<String> getAppPackage() {
        return this.appPackages;
    }

    public void setAppPackage(List<String> list) {
        this.appPackages = list;
    }

    public String getAppSign() {
        return this.appSign;
    }

    public void setAppSign(String str) {
        this.appSign = str;
    }

    public String getDownloadUrl() {
        return this.downloadUrl;
    }

    public void setDownloadUrl(String str) {
        this.downloadUrl = str;
    }
}
