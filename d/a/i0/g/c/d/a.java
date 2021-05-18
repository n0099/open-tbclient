package d.a.i0.g.c.d;

import android.os.Environment;
import android.text.TextUtils;
import androidx.annotation.NonNull;
import com.baidu.down.manage.Download;
import com.baidu.searchbox.common.runtime.AppRuntime;
import d.a.i0.a.k;
import java.io.File;
import org.json.JSONException;
import org.json.JSONObject;
/* loaded from: classes3.dex */
public class a {

    /* renamed from: e  reason: collision with root package name */
    public static final boolean f46824e = k.f43025a;

    /* renamed from: a  reason: collision with root package name */
    public String f46825a;

    /* renamed from: b  reason: collision with root package name */
    public String f46826b;

    /* renamed from: c  reason: collision with root package name */
    public String f46827c;

    /* renamed from: d  reason: collision with root package name */
    public long f46828d;

    public a() {
        this.f46825a = "";
        this.f46827c = "";
        this.f46828d = System.currentTimeMillis();
    }

    public static String d() {
        if (Environment.getExternalStorageState().equals("mounted")) {
            String str = AppRuntime.getAppContext().getExternalFilesDir(null) + File.separator + "gameCenter/download/apk";
            File file = new File(str);
            if (!file.exists()) {
                file.mkdirs();
            }
            return str;
        }
        return null;
    }

    public a a(String str) {
        this.f46827c = str;
        return this;
    }

    public Download b() {
        Download download = new Download();
        download.setUrl(this.f46825a);
        download.setKeyByUser(this.f46826b);
        JSONObject jSONObject = new JSONObject();
        try {
            jSONObject.put("apk_id", this.f46827c);
            jSONObject.put("download_time", this.f46828d);
        } catch (JSONException e2) {
            if (f46824e) {
                e2.printStackTrace();
            }
        }
        download.setFromParam(jSONObject.toString());
        download.setMimetype("application/vnd.android.package-archive");
        download.setWifiOnly(false);
        String d2 = d();
        if (!TextUtils.isEmpty(d2)) {
            download.setSavedPathForUser(d2);
        }
        download.setFileName(System.currentTimeMillis() + ".apk");
        return download;
    }

    public String c() {
        return this.f46827c;
    }

    public long e() {
        return this.f46828d;
    }

    public a f(String str) {
        this.f46826b = str;
        return this;
    }

    public a g(String str) {
        this.f46825a = str;
        return this;
    }

    public a(@NonNull Download download) {
        this.f46825a = "";
        this.f46827c = "";
        this.f46828d = System.currentTimeMillis();
        this.f46825a = download.getUrl();
        this.f46826b = download.getKeyByUser();
        String fromParam = download.getFromParam();
        if (TextUtils.isEmpty(fromParam)) {
            return;
        }
        try {
            JSONObject jSONObject = new JSONObject(fromParam);
            this.f46827c = jSONObject.optString("apk_id");
            this.f46828d = jSONObject.optLong("download_time", System.currentTimeMillis());
        } catch (JSONException e2) {
            if (f46824e) {
                e2.printStackTrace();
            }
        }
    }
}
