package d.a.l0.f.j.n;

import android.os.Environment;
import android.text.TextUtils;
import androidx.annotation.NonNull;
import com.baidu.down.manage.Download;
import com.baidu.searchbox.common.runtime.AppRuntime;
import com.baidu.swan.game.guide.GameGuideConfigInfo;
import d.a.l0.a.k;
import java.io.File;
import org.json.JSONException;
import org.json.JSONObject;
/* loaded from: classes3.dex */
public class a {

    /* renamed from: i  reason: collision with root package name */
    public static final boolean f46880i = k.f43199a;

    /* renamed from: a  reason: collision with root package name */
    public String f46881a;

    /* renamed from: b  reason: collision with root package name */
    public String f46882b;

    /* renamed from: c  reason: collision with root package name */
    public String f46883c;

    /* renamed from: d  reason: collision with root package name */
    public String f46884d;

    /* renamed from: e  reason: collision with root package name */
    public String f46885e;

    /* renamed from: f  reason: collision with root package name */
    public String f46886f;

    /* renamed from: g  reason: collision with root package name */
    public long f46887g;

    /* renamed from: h  reason: collision with root package name */
    public Download f46888h;

    public a() {
        this.f46881a = "";
        this.f46883c = "";
        this.f46884d = "";
        this.f46885e = "";
        this.f46886f = "";
        this.f46887g = System.currentTimeMillis();
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
        this.f46883c = str;
        return this;
    }

    public Download b() {
        Download download = new Download();
        download.setUrl(this.f46881a);
        download.setKeyByUser(this.f46882b);
        JSONObject jSONObject = new JSONObject();
        try {
            jSONObject.put("apk_id", this.f46883c);
            jSONObject.put("download_time", this.f46887g);
            jSONObject.put("from_view", this.f46884d);
            jSONObject.put("from_value", this.f46885e);
            jSONObject.put(GameGuideConfigInfo.KEY_CONFIG_NAME, this.f46886f);
        } catch (JSONException e2) {
            if (f46880i) {
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
        this.f46886f = str;
        return this;
    }

    public a d(String str) {
        this.f46885e = str;
        return this;
    }

    public a e(String str) {
        this.f46884d = str;
        return this;
    }

    public String f() {
        return this.f46883c;
    }

    public String h() {
        Download download = this.f46888h;
        if (download == null) {
            return null;
        }
        return download.getFromParam();
    }

    public long i() {
        return this.f46887g;
    }

    public String j() {
        return this.f46881a;
    }

    public String k() {
        return this.f46882b;
    }

    public a l(String str) {
        this.f46882b = str;
        return this;
    }

    public <T> void m(String str, T t) {
        Download download = this.f46888h;
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
            this.f46888h.setFromParam(jSONObject.toString());
        } catch (JSONException e2) {
            e2.printStackTrace();
        }
    }

    public a n(String str) {
        this.f46881a = str;
        return this;
    }

    public a(@NonNull Download download) {
        this.f46881a = "";
        this.f46883c = "";
        this.f46884d = "";
        this.f46885e = "";
        this.f46886f = "";
        this.f46887g = System.currentTimeMillis();
        this.f46888h = download;
        this.f46881a = download.getUrl();
        this.f46882b = download.getKeyByUser();
        String fromParam = download.getFromParam();
        if (TextUtils.isEmpty(fromParam)) {
            return;
        }
        try {
            JSONObject jSONObject = new JSONObject(fromParam);
            this.f46883c = jSONObject.optString("apk_id");
            this.f46884d = jSONObject.optString("from_view");
            this.f46885e = jSONObject.optString("from_value");
            this.f46886f = jSONObject.optString(GameGuideConfigInfo.KEY_CONFIG_NAME);
            this.f46887g = jSONObject.optLong("download_time", System.currentTimeMillis());
        } catch (JSONException e2) {
            if (f46880i) {
                e2.printStackTrace();
            }
        }
    }
}
