package com.qiniu.android.http;

import com.baidu.android.imsdk.IMConstants;
import com.qiniu.android.collect.Config;
import com.qiniu.android.collect.UploadInfoCollector;
import com.qiniu.android.storage.UpToken;
import com.qiniu.android.utils.StringUtils;
import com.xiaomi.mipush.sdk.Constants;
import java.util.Locale;
import org.json.JSONObject;
/* loaded from: classes5.dex */
public final class ResponseInfo {
    public final long duration;
    public final String error;
    public final String host;
    public final String ip;
    public final long mLV;
    public final String mMe;
    public final String mMf;
    public final long mMg;
    public final UpToken mMh;
    public final JSONObject mMi;
    public final String path;
    public final int port;
    public final String reqId;
    public final int statusCode;
    public final String id = UserAgent.dAv().id;
    public final long timeStamp = System.currentTimeMillis() / 1000;

    private ResponseInfo(JSONObject jSONObject, int i, String str, String str2, String str3, String str4, String str5, String str6, int i2, long j, long j2, String str7, UpToken upToken, long j3) {
        this.mMi = jSONObject;
        this.statusCode = i;
        this.reqId = str;
        this.mMe = str2;
        this.mMf = str3;
        this.host = str4;
        this.path = str5;
        this.duration = j;
        this.error = str7;
        this.ip = str6;
        this.port = i2;
        this.mMg = j2;
        this.mMh = upToken;
        this.mLV = j3;
    }

    public static ResponseInfo a(JSONObject jSONObject, final int i, final String str, String str2, String str3, final String str4, final String str5, String str6, final int i2, final long j, final long j2, String str7, UpToken upToken, final long j3) {
        String str8 = (str6 + "").split(":")[0];
        final String substring = str8.substring(Math.max(0, str8.indexOf("/") + 1));
        ResponseInfo responseInfo = new ResponseInfo(jSONObject, i, str, str2, str3, str4, str5, substring, i2, j, j2, str7, upToken, j3);
        if (Config.mLg || upToken != null) {
            final String str9 = responseInfo.timeStamp + "";
            UploadInfoCollector.a(upToken, new UploadInfoCollector.RecordMsg() { // from class: com.qiniu.android.http.ResponseInfo.1
                @Override // com.qiniu.android.collect.UploadInfoCollector.RecordMsg
                public String dAn() {
                    return StringUtils.b(new String[]{i + "", str, str4, substring, i2 + "", j + "", str9, j2 + "", ResponseInfo.Pa(str5), j3 + ""}, Constants.ACCEPT_TIME_SEPARATOR_SP);
                }
            });
        }
        return responseInfo;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static String Pa(String str) {
        if (str == null || !str.startsWith("/")) {
            return "";
        }
        if ("/".equals(str)) {
            return IMConstants.SERVICE_TYPE_FORM;
        }
        int indexOf = str.indexOf(47, 1);
        if (indexOf < 1) {
            return "";
        }
        String substring = str.substring(1, indexOf);
        char c = 65535;
        switch (substring.hashCode()) {
            case -1072430054:
                if (substring.equals("mkfile")) {
                    c = 2;
                    break;
                }
                break;
            case 111375:
                if (substring.equals("put")) {
                    c = 3;
                    break;
                }
                break;
            case 3030893:
                if (substring.equals("bput")) {
                    c = 1;
                    break;
                }
                break;
            case 103949059:
                if (substring.equals("mkblk")) {
                    c = 0;
                    break;
                }
                break;
        }
        switch (c) {
            case 0:
                return "mkblk";
            case 1:
                return "bput";
            case 2:
                return "mkfile";
            case 3:
                return "put";
            default:
                return "";
        }
    }

    public static ResponseInfo a(UpToken upToken) {
        return a(null, -6, "", "", "", "", "", "", 80, 0L, 0L, "file or data size is zero", upToken, 0L);
    }

    public static ResponseInfo b(UpToken upToken) {
        return a(null, -2, "", "", "", "", "", "", 80, -1L, -1L, "cancelled by user", upToken, 0L);
    }

    public static ResponseInfo a(String str, UpToken upToken) {
        return a(null, -4, "", "", "", "", "", "", 80, 0L, 0L, str, upToken, 0L);
    }

    public static ResponseInfo Pb(String str) {
        return a(null, -5, "", "", "", "", "", "", 80, 0L, 0L, str, null, 0L);
    }

    public static ResponseInfo a(Exception exc, UpToken upToken) {
        return a(null, -3, "", "", "", "", "", "", 80, 0L, 0L, exc.getMessage(), upToken, 0L);
    }

    public static ResponseInfo a(int i, UpToken upToken) {
        return a(null, i, "", "", "", "", "", "", 80, 0L, 0L, "Network error during preQuery", upToken, 0L);
    }

    public static boolean IO(int i) {
        return i == -1 || i == -1003 || i == -1004 || i == -1001 || i == -1005;
    }

    public boolean isCancelled() {
        return this.statusCode == -2;
    }

    public boolean dAo() {
        return this.statusCode == 200 && this.error == null && (dAu() || this.mMi != null);
    }

    public boolean dAp() {
        return this.statusCode == -1 || this.statusCode == -1003 || this.statusCode == -1004 || this.statusCode == -1001 || this.statusCode == -1005;
    }

    public boolean dAq() {
        return (this.statusCode >= 500 && this.statusCode < 600 && this.statusCode != 579) || this.statusCode == 996;
    }

    public boolean dAr() {
        return dAp() || dAq();
    }

    public boolean dAs() {
        return !isCancelled() && (dAr() || this.statusCode == 406 || ((this.statusCode == 200 && this.error != null) || (dAt() && !this.mMh.dAC())));
    }

    public boolean dAt() {
        return this.statusCode < 500 && this.statusCode >= 200 && !dAu() && this.mMi == null;
    }

    public String toString() {
        return String.format(Locale.ENGLISH, "{ver:%s,ResponseInfo:%s,status:%d, reqId:%s, xlog:%s, xvia:%s, host:%s, path:%s, ip:%s, port:%d, duration:%d s, time:%d, sent:%d,error:%s}", "7.3.13", this.id, Integer.valueOf(this.statusCode), this.reqId, this.mMe, this.mMf, this.host, this.path, this.ip, Integer.valueOf(this.port), Long.valueOf(this.duration), Long.valueOf(this.timeStamp), Long.valueOf(this.mMg), this.error);
    }

    public boolean dAu() {
        return this.reqId != null;
    }
}
