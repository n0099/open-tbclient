package d.b.g0.f.f.d;

import android.os.Environment;
import android.text.TextUtils;
import androidx.annotation.NonNull;
import com.baidu.down.manage.Download;
import com.baidu.searchbox.common.runtime.AppRuntime;
import d.b.g0.a.k;
import java.io.File;
import org.json.JSONException;
import org.json.JSONObject;
/* loaded from: classes3.dex */
public class a {

    /* renamed from: e  reason: collision with root package name */
    public static final boolean f48172e = k.f45443a;

    /* renamed from: a  reason: collision with root package name */
    public String f48173a;

    /* renamed from: b  reason: collision with root package name */
    public String f48174b;

    /* renamed from: c  reason: collision with root package name */
    public String f48175c;

    /* renamed from: d  reason: collision with root package name */
    public long f48176d;

    public a() {
        this.f48173a = "";
        this.f48175c = "";
        this.f48176d = System.currentTimeMillis();
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
        this.f48175c = str;
        return this;
    }

    public Download b() {
        Download download = new Download();
        download.setUrl(this.f48173a);
        download.setKeyByUser(this.f48174b);
        JSONObject jSONObject = new JSONObject();
        try {
            jSONObject.put("apk_id", this.f48175c);
            jSONObject.put("download_time", this.f48176d);
        } catch (JSONException e2) {
            if (f48172e) {
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
        return this.f48175c;
    }

    public long e() {
        return this.f48176d;
    }

    public a f(String str) {
        this.f48174b = str;
        return this;
    }

    public a g(String str) {
        this.f48173a = str;
        return this;
    }

    public a(@NonNull Download download) {
        this.f48173a = "";
        this.f48175c = "";
        this.f48176d = System.currentTimeMillis();
        this.f48173a = download.getUrl();
        this.f48174b = download.getKeyByUser();
        String fromParam = download.getFromParam();
        if (TextUtils.isEmpty(fromParam)) {
            return;
        }
        try {
            JSONObject jSONObject = new JSONObject(fromParam);
            this.f48175c = jSONObject.optString("apk_id");
            this.f48176d = jSONObject.optLong("download_time", System.currentTimeMillis());
        } catch (JSONException e2) {
            if (f48172e) {
                e2.printStackTrace();
            }
        }
    }
}
