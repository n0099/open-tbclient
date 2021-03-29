package d.b.k0;

import android.text.TextUtils;
import android.util.Log;
import com.baidu.android.common.others.url.UrlUtil;
import com.baidu.android.util.io.GZIP;
import com.baidu.common.param.CommonUrlParamManager;
import com.baidu.searchbox.config.AppConfig;
import com.baidu.searchbox.logsystem.basic.upload.BaseContentUploader;
import com.baidu.searchbox.logsystem.basic.upload.LogSystemUploaderStrategy;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;
import org.json.JSONObject;
/* loaded from: classes5.dex */
public abstract class a implements u {

    /* renamed from: b  reason: collision with root package name */
    public static final boolean f63868b = AppConfig.isDebug();

    /* renamed from: a  reason: collision with root package name */
    public d0 f63869a = new d0();

    @Override // d.b.k0.u
    public boolean a(JSONObject jSONObject, boolean z) {
        return b(BaseContentUploader.ONLINE_URL, jSONObject, z);
    }

    public boolean b(String str, JSONObject jSONObject, boolean z) {
        String str2;
        boolean isUBCDebug = this.f63869a.isUBCDebug();
        if (isUBCDebug) {
            str2 = "http://bjyz-mco-searchbox201609-m12xi3-044.bjyz.baidu.com:8080/ztbox?action=zubc";
        } else {
            str2 = str + "/ztbox?action=zubc";
        }
        String processUrl = CommonUrlParamManager.getInstance().processUrl(str2);
        if (isUBCDebug && !TextUtils.isEmpty(processUrl)) {
            processUrl = UrlUtil.addParam(processUrl, "debug", "1");
        }
        if (z) {
            processUrl = UrlUtil.addParam(processUrl, "reallog", "1");
        }
        if (g.m().u()) {
            processUrl = UrlUtil.addParam(processUrl, "beta", "1");
        }
        HashMap hashMap = new HashMap(2);
        hashMap.put("Content-type", "application/x-www-form-urlencoded");
        hashMap.put(BaseContentUploader.NB, "1");
        try {
            byte[] gZip = GZIP.gZip(jSONObject.toString().getBytes());
            if (gZip.length < 2) {
                return false;
            }
            gZip[0] = LogSystemUploaderStrategy.ContentUtil.GZIP_HEAD_1;
            gZip[1] = LogSystemUploaderStrategy.ContentUtil.GZIP_HEAD_2;
            b0 c2 = c(processUrl, gZip, hashMap);
            if (!c2.d()) {
                if (f63868b) {
                    Log.d("UploadManager", "postByteRequest, fail: " + c2.c());
                } else {
                    a0.a().h(c2.c(), null);
                }
                c2.a();
                return false;
            }
            try {
                int i = new JSONObject(c2.b()).getInt("error");
                if (i != 0) {
                    if (f63868b) {
                        Log.d("UploadManager", "server error");
                    }
                    if (!f63868b) {
                        a0.a().j(i);
                    }
                }
            } catch (Exception e2) {
                if (f63868b) {
                    Log.d("UploadManager", "body tostring fail:" + e2.getMessage());
                } else {
                    a0.a().i(Log.getStackTraceString(e2));
                }
            }
            c2.a();
            return true;
        } catch (Exception e3) {
            if (f63868b) {
                Log.d("UploadManager", "postByteRequest, Exception: ", e3);
            } else {
                a0.a().h(null, Log.getStackTraceString(e3));
            }
            return false;
        }
    }

    public abstract b0 c(String str, byte[] bArr, Map<String, String> map) throws IOException;
}
