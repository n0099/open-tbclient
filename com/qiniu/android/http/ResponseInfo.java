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
    public final long nDc;
    public final String nDl;
    public final String nDm;
    public final long nDn;
    public final UpToken nDo;
    public final JSONObject nDp;
    public final String path;
    public final int port;
    public final String reqId;
    public final int statusCode;
    public final String id = UserAgent.dMN().id;
    public final long timeStamp = System.currentTimeMillis() / 1000;

    private ResponseInfo(JSONObject jSONObject, int i, String str, String str2, String str3, String str4, String str5, String str6, int i2, long j, long j2, String str7, UpToken upToken, long j3) {
        this.nDp = jSONObject;
        this.statusCode = i;
        this.reqId = str;
        this.nDl = str2;
        this.nDm = str3;
        this.host = str4;
        this.path = str5;
        this.duration = j;
        this.error = str7;
        this.ip = str6;
        this.port = i2;
        this.nDn = j2;
        this.nDo = upToken;
        this.nDc = j3;
    }

    public static ResponseInfo a(JSONObject jSONObject, final int i, final String str, String str2, String str3, final String str4, final String str5, String str6, final int i2, final long j, final long j2, String str7, UpToken upToken, final long j3) {
        String str8 = (str6 + "").split(":")[0];
        final String substring = str8.substring(Math.max(0, str8.indexOf("/") + 1));
        ResponseInfo responseInfo = new ResponseInfo(jSONObject, i, str, str2, str3, str4, str5, substring, i2, j, j2, str7, upToken, j3);
        if (Config.nCn || upToken != null) {
            final String str9 = responseInfo.timeStamp + "";
            UploadInfoCollector.a(upToken, new UploadInfoCollector.RecordMsg() { // from class: com.qiniu.android.http.ResponseInfo.1
                @Override // com.qiniu.android.collect.UploadInfoCollector.RecordMsg
                public String dMF() {
                    return StringUtils.b(new String[]{i + "", str, str4, substring, i2 + "", j + "", str9, j2 + "", ResponseInfo.RE(str5), j3 + ""}, Constants.ACCEPT_TIME_SEPARATOR_SP);
                }
            });
        }
        return responseInfo;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static String RE(String str) {
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

    public static ResponseInfo RF(String str) {
        return a(null, -5, "", "", "", "", "", "", 80, 0L, 0L, str, null, 0L);
    }

    public static ResponseInfo a(Exception exc, UpToken upToken) {
        return a(null, -3, "", "", "", "", "", "", 80, 0L, 0L, exc.getMessage(), upToken, 0L);
    }

    public static ResponseInfo a(int i, UpToken upToken) {
        return a(null, i, "", "", "", "", "", "", 80, 0L, 0L, "Network error during preQuery", upToken, 0L);
    }

    public static boolean KI(int i) {
        return i == -1 || i == -1003 || i == -1004 || i == -1001 || i == -1005;
    }

    public boolean isCancelled() {
        return this.statusCode == -2;
    }

    public boolean dMG() {
        return this.statusCode == 200 && this.error == null && (dMM() || this.nDp != null);
    }

    public boolean dMH() {
        return this.statusCode == -1 || this.statusCode == -1003 || this.statusCode == -1004 || this.statusCode == -1001 || this.statusCode == -1005;
    }

    public boolean dMI() {
        return (this.statusCode >= 500 && this.statusCode < 600 && this.statusCode != 579) || this.statusCode == 996;
    }

    public boolean dMJ() {
        return dMH() || dMI();
    }

    public boolean dMK() {
        return !isCancelled() && (dMJ() || this.statusCode == 406 || ((this.statusCode == 200 && this.error != null) || (dML() && !this.nDo.dMU())));
    }

    public boolean dML() {
        return this.statusCode < 500 && this.statusCode >= 200 && !dMM() && this.nDp == null;
    }

    public String toString() {
        return String.format(Locale.ENGLISH, "{ver:%s,ResponseInfo:%s,status:%d, reqId:%s, xlog:%s, xvia:%s, host:%s, path:%s, ip:%s, port:%d, duration:%d s, time:%d, sent:%d,error:%s}", "7.3.13", this.id, Integer.valueOf(this.statusCode), this.reqId, this.nDl, this.nDm, this.host, this.path, this.ip, Integer.valueOf(this.port), Long.valueOf(this.duration), Long.valueOf(this.timeStamp), Long.valueOf(this.nDn), this.error);
    }

    public boolean dMM() {
        return this.reqId != null;
    }
}
