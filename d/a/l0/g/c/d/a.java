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
    public static final boolean f50674e = k.f46875a;

    /* renamed from: a  reason: collision with root package name */
    public String f50675a;

    /* renamed from: b  reason: collision with root package name */
    public String f50676b;

    /* renamed from: c  reason: collision with root package name */
    public String f50677c;

    /* renamed from: d  reason: collision with root package name */
    public long f50678d;

    public a() {
        this.f50675a = "";
        this.f50677c = "";
        this.f50678d = System.currentTimeMillis();
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
        this.f50677c = str;
        return this;
    }

    public Download b() {
        Download download = new Download();
        download.setUrl(this.f50675a);
        download.setKeyByUser(this.f50676b);
        JSONObject jSONObject = new JSONObject();
        try {
            jSONObject.put("apk_id", this.f50677c);
            jSONObject.put("download_time", this.f50678d);
        } catch (JSONException e2) {
            if (f50674e) {
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
        return this.f50677c;
    }

    public long e() {
        return this.f50678d;
    }

    public a f(String str) {
        this.f50676b = str;
        return this;
    }

    public a g(String str) {
        this.f50675a = str;
        return this;
    }

    public a(@NonNull Download download) {
        this.f50675a = "";
        this.f50677c = "";
        this.f50678d = System.currentTimeMillis();
        this.f50675a = download.getUrl();
        this.f50676b = download.getKeyByUser();
        String fromParam = download.getFromParam();
        if (TextUtils.isEmpty(fromParam)) {
            return;
        }
        try {
            JSONObject jSONObject = new JSONObject(fromParam);
            this.f50677c = jSONObject.optString("apk_id");
            this.f50678d = jSONObject.optLong("download_time", System.currentTimeMillis());
        } catch (JSONException e2) {
            if (f50674e) {
                e2.printStackTrace();
            }
        }
    }
}
