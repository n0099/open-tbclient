package d.b.g0.f.f.d;

import android.os.Environment;
import android.text.TextUtils;
import androidx.annotation.NonNull;
import com.baidu.down.manage.Download;
import com.baidu.nps.utils.Constant;
import com.baidu.searchbox.common.runtime.AppRuntime;
import d.b.g0.a.k;
import java.io.File;
import org.json.JSONException;
import org.json.JSONObject;
/* loaded from: classes3.dex */
public class a {

    /* renamed from: e  reason: collision with root package name */
    public static final boolean f47779e = k.f45050a;

    /* renamed from: a  reason: collision with root package name */
    public String f47780a;

    /* renamed from: b  reason: collision with root package name */
    public String f47781b;

    /* renamed from: c  reason: collision with root package name */
    public String f47782c;

    /* renamed from: d  reason: collision with root package name */
    public long f47783d;

    public a() {
        this.f47780a = "";
        this.f47782c = "";
        this.f47783d = System.currentTimeMillis();
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
        this.f47782c = str;
        return this;
    }

    public Download b() {
        Download download = new Download();
        download.setUrl(this.f47780a);
        download.setKeyByUser(this.f47781b);
        JSONObject jSONObject = new JSONObject();
        try {
            jSONObject.put("apk_id", this.f47782c);
            jSONObject.put("download_time", this.f47783d);
        } catch (JSONException e2) {
            if (f47779e) {
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
        download.setFileName(System.currentTimeMillis() + Constant.FILE.SUFFIX.BUNDLE_SUFFIX);
        return download;
    }

    public String c() {
        return this.f47782c;
    }

    public long e() {
        return this.f47783d;
    }

    public a f(String str) {
        this.f47781b = str;
        return this;
    }

    public a g(String str) {
        this.f47780a = str;
        return this;
    }

    public a(@NonNull Download download) {
        this.f47780a = "";
        this.f47782c = "";
        this.f47783d = System.currentTimeMillis();
        this.f47780a = download.getUrl();
        this.f47781b = download.getKeyByUser();
        String fromParam = download.getFromParam();
        if (TextUtils.isEmpty(fromParam)) {
            return;
        }
        try {
            JSONObject jSONObject = new JSONObject(fromParam);
            this.f47782c = jSONObject.optString("apk_id");
            this.f47783d = jSONObject.optLong("download_time", System.currentTimeMillis());
        } catch (JSONException e2) {
            if (f47779e) {
                e2.printStackTrace();
            }
        }
    }
}
