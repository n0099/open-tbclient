package d.a.i0.f.j.n;

import android.os.Environment;
import android.text.TextUtils;
import androidx.annotation.NonNull;
import com.baidu.down.manage.Download;
import com.baidu.searchbox.common.runtime.AppRuntime;
import com.baidu.swan.game.guide.GameGuideConfigInfo;
import d.a.i0.a.k;
import java.io.File;
import org.json.JSONException;
import org.json.JSONObject;
/* loaded from: classes3.dex */
public class a {

    /* renamed from: i  reason: collision with root package name */
    public static final boolean f46704i = k.f43025a;

    /* renamed from: a  reason: collision with root package name */
    public String f46705a;

    /* renamed from: b  reason: collision with root package name */
    public String f46706b;

    /* renamed from: c  reason: collision with root package name */
    public String f46707c;

    /* renamed from: d  reason: collision with root package name */
    public String f46708d;

    /* renamed from: e  reason: collision with root package name */
    public String f46709e;

    /* renamed from: f  reason: collision with root package name */
    public String f46710f;

    /* renamed from: g  reason: collision with root package name */
    public long f46711g;

    /* renamed from: h  reason: collision with root package name */
    public Download f46712h;

    public a() {
        this.f46705a = "";
        this.f46707c = "";
        this.f46708d = "";
        this.f46709e = "";
        this.f46710f = "";
        this.f46711g = System.currentTimeMillis();
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
        this.f46707c = str;
        return this;
    }

    public Download b() {
        Download download = new Download();
        download.setUrl(this.f46705a);
        download.setKeyByUser(this.f46706b);
        JSONObject jSONObject = new JSONObject();
        try {
            jSONObject.put("apk_id", this.f46707c);
            jSONObject.put("download_time", this.f46711g);
            jSONObject.put("from_view", this.f46708d);
            jSONObject.put("from_value", this.f46709e);
            jSONObject.put(GameGuideConfigInfo.KEY_CONFIG_NAME, this.f46710f);
        } catch (JSONException e2) {
            if (f46704i) {
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
        this.f46710f = str;
        return this;
    }

    public a d(String str) {
        this.f46709e = str;
        return this;
    }

    public a e(String str) {
        this.f46708d = str;
        return this;
    }

    public String f() {
        return this.f46707c;
    }

    public String h() {
        Download download = this.f46712h;
        if (download == null) {
            return null;
        }
        return download.getFromParam();
    }

    public long i() {
        return this.f46711g;
    }

    public String j() {
        return this.f46705a;
    }

    public String k() {
        return this.f46706b;
    }

    public a l(String str) {
        this.f46706b = str;
        return this;
    }

    public <T> void m(String str, T t) {
        Download download = this.f46712h;
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
            this.f46712h.setFromParam(jSONObject.toString());
        } catch (JSONException e2) {
            e2.printStackTrace();
        }
    }

    public a n(String str) {
        this.f46705a = str;
        return this;
    }

    public a(@NonNull Download download) {
        this.f46705a = "";
        this.f46707c = "";
        this.f46708d = "";
        this.f46709e = "";
        this.f46710f = "";
        this.f46711g = System.currentTimeMillis();
        this.f46712h = download;
        this.f46705a = download.getUrl();
        this.f46706b = download.getKeyByUser();
        String fromParam = download.getFromParam();
        if (TextUtils.isEmpty(fromParam)) {
            return;
        }
        try {
            JSONObject jSONObject = new JSONObject(fromParam);
            this.f46707c = jSONObject.optString("apk_id");
            this.f46708d = jSONObject.optString("from_view");
            this.f46709e = jSONObject.optString("from_value");
            this.f46710f = jSONObject.optString(GameGuideConfigInfo.KEY_CONFIG_NAME);
            this.f46711g = jSONObject.optLong("download_time", System.currentTimeMillis());
        } catch (JSONException e2) {
            if (f46704i) {
                e2.printStackTrace();
            }
        }
    }
}
