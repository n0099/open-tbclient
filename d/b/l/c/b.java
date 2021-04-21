package d.b.l.c;

import android.os.Build;
import android.text.TextUtils;
import com.baidu.mobads.sdk.internal.XAdSDKPorxyConfig;
/* loaded from: classes.dex */
public class b {

    /* renamed from: a  reason: collision with root package name */
    public String f64839a;

    /* renamed from: b  reason: collision with root package name */
    public String f64840b;

    /* renamed from: c  reason: collision with root package name */
    public String f64841c;

    /* renamed from: d  reason: collision with root package name */
    public String f64842d;

    public b() {
        b();
    }

    public String a() {
        return this.f64842d;
    }

    public final void b() {
        String str = Build.MODEL;
        this.f64839a = str;
        if (TextUtils.isEmpty(str)) {
            this.f64839a = "NUL";
        } else {
            this.f64839a = this.f64839a.replace("_", "-");
        }
        String str2 = Build.MANUFACTURER;
        this.f64840b = str2;
        if (TextUtils.isEmpty(str2)) {
            this.f64840b = "NUL";
        } else {
            this.f64840b = this.f64840b.replace("_", "-");
        }
        String str3 = Build.VERSION.RELEASE;
        this.f64841c = str3;
        if (TextUtils.isEmpty(str3)) {
            this.f64841c = XAdSDKPorxyConfig.REMOTE_VERSION_DEFAULT;
        } else {
            this.f64841c = this.f64841c.replace("_", "-");
        }
        this.f64842d = c();
    }

    public final String c() {
        String str = this.f64839a;
        String str2 = this.f64841c;
        int i = Build.VERSION.SDK_INT;
        String str3 = this.f64840b;
        return str + "_" + str2 + "_" + i + "_" + str3;
    }
}
