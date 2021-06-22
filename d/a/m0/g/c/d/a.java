package d.a.m0.g.c.d;

import android.os.Environment;
import android.text.TextUtils;
import androidx.annotation.NonNull;
import com.baidu.down.manage.Download;
import com.baidu.searchbox.common.runtime.AppRuntime;
import d.a.m0.a.k;
import java.io.File;
import org.json.JSONException;
import org.json.JSONObject;
/* loaded from: classes3.dex */
public class a {

    /* renamed from: e  reason: collision with root package name */
    public static final boolean f50782e = k.f46983a;

    /* renamed from: a  reason: collision with root package name */
    public String f50783a;

    /* renamed from: b  reason: collision with root package name */
    public String f50784b;

    /* renamed from: c  reason: collision with root package name */
    public String f50785c;

    /* renamed from: d  reason: collision with root package name */
    public long f50786d;

    public a() {
        this.f50783a = "";
        this.f50785c = "";
        this.f50786d = System.currentTimeMillis();
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
        this.f50785c = str;
        return this;
    }

    public Download b() {
        Download download = new Download();
        download.setUrl(this.f50783a);
        download.setKeyByUser(this.f50784b);
        JSONObject jSONObject = new JSONObject();
        try {
            jSONObject.put("apk_id", this.f50785c);
            jSONObject.put("download_time", this.f50786d);
        } catch (JSONException e2) {
            if (f50782e) {
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
        return this.f50785c;
    }

    public long e() {
        return this.f50786d;
    }

    public a f(String str) {
        this.f50784b = str;
        return this;
    }

    public a g(String str) {
        this.f50783a = str;
        return this;
    }

    public a(@NonNull Download download) {
        this.f50783a = "";
        this.f50785c = "";
        this.f50786d = System.currentTimeMillis();
        this.f50783a = download.getUrl();
        this.f50784b = download.getKeyByUser();
        String fromParam = download.getFromParam();
        if (TextUtils.isEmpty(fromParam)) {
            return;
        }
        try {
            JSONObject jSONObject = new JSONObject(fromParam);
            this.f50785c = jSONObject.optString("apk_id");
            this.f50786d = jSONObject.optLong("download_time", System.currentTimeMillis());
        } catch (JSONException e2) {
            if (f50782e) {
                e2.printStackTrace();
            }
        }
    }
}
