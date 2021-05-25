package d.a.l0.g.c.d;

import android.os.Environment;
import android.text.TextUtils;
import androidx.annotation.NonNull;
import com.baidu.down.manage.Download;
import com.baidu.searchbox.common.runtime.AppRuntime;
import d.a.l0.a.k;
import java.io.File;
import org.json.JSONException;
import org.json.JSONObject;
/* loaded from: classes3.dex */
public class a {

    /* renamed from: e  reason: collision with root package name */
    public static final boolean f47000e = k.f43199a;

    /* renamed from: a  reason: collision with root package name */
    public String f47001a;

    /* renamed from: b  reason: collision with root package name */
    public String f47002b;

    /* renamed from: c  reason: collision with root package name */
    public String f47003c;

    /* renamed from: d  reason: collision with root package name */
    public long f47004d;

    public a() {
        this.f47001a = "";
        this.f47003c = "";
        this.f47004d = System.currentTimeMillis();
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
        this.f47003c = str;
        return this;
    }

    public Download b() {
        Download download = new Download();
        download.setUrl(this.f47001a);
        download.setKeyByUser(this.f47002b);
        JSONObject jSONObject = new JSONObject();
        try {
            jSONObject.put("apk_id", this.f47003c);
            jSONObject.put("download_time", this.f47004d);
        } catch (JSONException e2) {
            if (f47000e) {
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
        return this.f47003c;
    }

    public long e() {
        return this.f47004d;
    }

    public a f(String str) {
        this.f47002b = str;
        return this;
    }

    public a g(String str) {
        this.f47001a = str;
        return this;
    }

    public a(@NonNull Download download) {
        this.f47001a = "";
        this.f47003c = "";
        this.f47004d = System.currentTimeMillis();
        this.f47001a = download.getUrl();
        this.f47002b = download.getKeyByUser();
        String fromParam = download.getFromParam();
        if (TextUtils.isEmpty(fromParam)) {
            return;
        }
        try {
            JSONObject jSONObject = new JSONObject(fromParam);
            this.f47003c = jSONObject.optString("apk_id");
            this.f47004d = jSONObject.optLong("download_time", System.currentTimeMillis());
        } catch (JSONException e2) {
            if (f47000e) {
                e2.printStackTrace();
            }
        }
    }
}
