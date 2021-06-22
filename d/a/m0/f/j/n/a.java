package d.a.m0.f.j.n;

import android.os.Environment;
import android.text.TextUtils;
import androidx.annotation.NonNull;
import com.baidu.down.manage.Download;
import com.baidu.searchbox.common.runtime.AppRuntime;
import com.baidu.swan.game.guide.GameGuideConfigInfo;
import d.a.m0.a.k;
import java.io.File;
import org.json.JSONException;
import org.json.JSONObject;
/* loaded from: classes3.dex */
public class a {

    /* renamed from: i  reason: collision with root package name */
    public static final boolean f50662i = k.f46983a;

    /* renamed from: a  reason: collision with root package name */
    public String f50663a;

    /* renamed from: b  reason: collision with root package name */
    public String f50664b;

    /* renamed from: c  reason: collision with root package name */
    public String f50665c;

    /* renamed from: d  reason: collision with root package name */
    public String f50666d;

    /* renamed from: e  reason: collision with root package name */
    public String f50667e;

    /* renamed from: f  reason: collision with root package name */
    public String f50668f;

    /* renamed from: g  reason: collision with root package name */
    public long f50669g;

    /* renamed from: h  reason: collision with root package name */
    public Download f50670h;

    public a() {
        this.f50663a = "";
        this.f50665c = "";
        this.f50666d = "";
        this.f50667e = "";
        this.f50668f = "";
        this.f50669g = System.currentTimeMillis();
    }

    public static String g() {
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
        this.f50665c = str;
        return this;
    }

    public Download b() {
        Download download = new Download();
        download.setUrl(this.f50663a);
        download.setKeyByUser(this.f50664b);
        JSONObject jSONObject = new JSONObject();
        try {
            jSONObject.put("apk_id", this.f50665c);
            jSONObject.put("download_time", this.f50669g);
            jSONObject.put("from_view", this.f50666d);
            jSONObject.put("from_value", this.f50667e);
            jSONObject.put(GameGuideConfigInfo.KEY_CONFIG_NAME, this.f50668f);
        } catch (JSONException e2) {
            if (f50662i) {
                e2.printStackTrace();
            }
        }
        download.setFromParam(jSONObject.toString());
        download.setMimetype("application/vnd.android.package-archive");
        download.setWifiOnly(false);
        String g2 = g();
        if (!TextUtils.isEmpty(g2)) {
            download.setSavedPathForUser(g2);
        }
        download.setFileName(System.currentTimeMillis() + ".apk");
        return download;
    }

    public a c(String str) {
        this.f50668f = str;
        return this;
    }

    public a d(String str) {
        this.f50667e = str;
        return this;
    }

    public a e(String str) {
        this.f50666d = str;
        return this;
    }

    public String f() {
        return this.f50665c;
    }

    public String h() {
        Download download = this.f50670h;
        if (download == null) {
            return null;
        }
        return download.getFromParam();
    }

    public long i() {
        return this.f50669g;
    }

    public String j() {
        return this.f50663a;
    }

    public String k() {
        return this.f50664b;
    }

    public a l(String str) {
        this.f50664b = str;
        return this;
    }

    public <T> void m(String str, T t) {
        Download download = this.f50670h;
        if (download == null) {
            return;
        }
        String fromParam = download.getFromParam();
        if (TextUtils.isEmpty(fromParam)) {
            return;
        }
        try {
            JSONObject jSONObject = new JSONObject(fromParam);
            jSONObject.put(str, t);
            this.f50670h.setFromParam(jSONObject.toString());
        } catch (JSONException e2) {
            e2.printStackTrace();
        }
    }

    public a n(String str) {
        this.f50663a = str;
        return this;
    }

    public a(@NonNull Download download) {
        this.f50663a = "";
        this.f50665c = "";
        this.f50666d = "";
        this.f50667e = "";
        this.f50668f = "";
        this.f50669g = System.currentTimeMillis();
        this.f50670h = download;
        this.f50663a = download.getUrl();
        this.f50664b = download.getKeyByUser();
        String fromParam = download.getFromParam();
        if (TextUtils.isEmpty(fromParam)) {
            return;
        }
        try {
            JSONObject jSONObject = new JSONObject(fromParam);
            this.f50665c = jSONObject.optString("apk_id");
            this.f50666d = jSONObject.optString("from_view");
            this.f50667e = jSONObject.optString("from_value");
            this.f50668f = jSONObject.optString(GameGuideConfigInfo.KEY_CONFIG_NAME);
            this.f50669g = jSONObject.optLong("download_time", System.currentTimeMillis());
        } catch (JSONException e2) {
            if (f50662i) {
                e2.printStackTrace();
            }
        }
    }
}
