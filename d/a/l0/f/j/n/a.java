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
    public static final boolean f50554i = k.f46875a;

    /* renamed from: a  reason: collision with root package name */
    public String f50555a;

    /* renamed from: b  reason: collision with root package name */
    public String f50556b;

    /* renamed from: c  reason: collision with root package name */
    public String f50557c;

    /* renamed from: d  reason: collision with root package name */
    public String f50558d;

    /* renamed from: e  reason: collision with root package name */
    public String f50559e;

    /* renamed from: f  reason: collision with root package name */
    public String f50560f;

    /* renamed from: g  reason: collision with root package name */
    public long f50561g;

    /* renamed from: h  reason: collision with root package name */
    public Download f50562h;

    public a() {
        this.f50555a = "";
        this.f50557c = "";
        this.f50558d = "";
        this.f50559e = "";
        this.f50560f = "";
        this.f50561g = System.currentTimeMillis();
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
        this.f50557c = str;
        return this;
    }

    public Download b() {
        Download download = new Download();
        download.setUrl(this.f50555a);
        download.setKeyByUser(this.f50556b);
        JSONObject jSONObject = new JSONObject();
        try {
            jSONObject.put("apk_id", this.f50557c);
            jSONObject.put("download_time", this.f50561g);
            jSONObject.put("from_view", this.f50558d);
            jSONObject.put("from_value", this.f50559e);
            jSONObject.put(GameGuideConfigInfo.KEY_CONFIG_NAME, this.f50560f);
        } catch (JSONException e2) {
            if (f50554i) {
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
        this.f50560f = str;
        return this;
    }

    public a d(String str) {
        this.f50559e = str;
        return this;
    }

    public a e(String str) {
        this.f50558d = str;
        return this;
    }

    public String f() {
        return this.f50557c;
    }

    public String h() {
        Download download = this.f50562h;
        if (download == null) {
            return null;
        }
        return download.getFromParam();
    }

    public long i() {
        return this.f50561g;
    }

    public String j() {
        return this.f50555a;
    }

    public String k() {
        return this.f50556b;
    }

    public a l(String str) {
        this.f50556b = str;
        return this;
    }

    public <T> void m(String str, T t) {
        Download download = this.f50562h;
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
            this.f50562h.setFromParam(jSONObject.toString());
        } catch (JSONException e2) {
            e2.printStackTrace();
        }
    }

    public a n(String str) {
        this.f50555a = str;
        return this;
    }

    public a(@NonNull Download download) {
        this.f50555a = "";
        this.f50557c = "";
        this.f50558d = "";
        this.f50559e = "";
        this.f50560f = "";
        this.f50561g = System.currentTimeMillis();
        this.f50562h = download;
        this.f50555a = download.getUrl();
        this.f50556b = download.getKeyByUser();
        String fromParam = download.getFromParam();
        if (TextUtils.isEmpty(fromParam)) {
            return;
        }
        try {
            JSONObject jSONObject = new JSONObject(fromParam);
            this.f50557c = jSONObject.optString("apk_id");
            this.f50558d = jSONObject.optString("from_view");
            this.f50559e = jSONObject.optString("from_value");
            this.f50560f = jSONObject.optString(GameGuideConfigInfo.KEY_CONFIG_NAME);
            this.f50561g = jSONObject.optLong("download_time", System.currentTimeMillis());
        } catch (JSONException e2) {
            if (f50554i) {
                e2.printStackTrace();
            }
        }
    }
}
