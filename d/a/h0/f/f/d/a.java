package d.a.h0.f.f.d;

import android.os.Environment;
import android.text.TextUtils;
import androidx.annotation.NonNull;
import com.baidu.down.manage.Download;
import com.baidu.searchbox.common.runtime.AppRuntime;
import d.a.h0.a.k;
import java.io.File;
import org.json.JSONException;
import org.json.JSONObject;
/* loaded from: classes3.dex */
public class a {

    /* renamed from: e  reason: collision with root package name */
    public static final boolean f45961e = k.f43101a;

    /* renamed from: a  reason: collision with root package name */
    public String f45962a;

    /* renamed from: b  reason: collision with root package name */
    public String f45963b;

    /* renamed from: c  reason: collision with root package name */
    public String f45964c;

    /* renamed from: d  reason: collision with root package name */
    public long f45965d;

    public a() {
        this.f45962a = "";
        this.f45964c = "";
        this.f45965d = System.currentTimeMillis();
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
        this.f45964c = str;
        return this;
    }

    public Download b() {
        Download download = new Download();
        download.setUrl(this.f45962a);
        download.setKeyByUser(this.f45963b);
        JSONObject jSONObject = new JSONObject();
        try {
            jSONObject.put("apk_id", this.f45964c);
            jSONObject.put("download_time", this.f45965d);
        } catch (JSONException e2) {
            if (f45961e) {
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
        return this.f45964c;
    }

    public long e() {
        return this.f45965d;
    }

    public a f(String str) {
        this.f45963b = str;
        return this;
    }

    public a g(String str) {
        this.f45962a = str;
        return this;
    }

    public a(@NonNull Download download) {
        this.f45962a = "";
        this.f45964c = "";
        this.f45965d = System.currentTimeMillis();
        this.f45962a = download.getUrl();
        this.f45963b = download.getKeyByUser();
        String fromParam = download.getFromParam();
        if (TextUtils.isEmpty(fromParam)) {
            return;
        }
        try {
            JSONObject jSONObject = new JSONObject(fromParam);
            this.f45964c = jSONObject.optString("apk_id");
            this.f45965d = jSONObject.optLong("download_time", System.currentTimeMillis());
        } catch (JSONException e2) {
            if (f45961e) {
                e2.printStackTrace();
            }
        }
    }
}
