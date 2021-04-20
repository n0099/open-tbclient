package d.b.l.c;

import android.os.Build;
import android.text.TextUtils;
import com.baidu.mobads.sdk.internal.XAdSDKPorxyConfig;
/* loaded from: classes.dex */
public class b {

    /* renamed from: a  reason: collision with root package name */
    public String f64713a;

    /* renamed from: b  reason: collision with root package name */
    public String f64714b;

    /* renamed from: c  reason: collision with root package name */
    public String f64715c;

    /* renamed from: d  reason: collision with root package name */
    public String f64716d;

    public b() {
        b();
    }

    public String a() {
        return this.f64716d;
    }

    public final void b() {
        String str = Build.MODEL;
        this.f64713a = str;
        if (TextUtils.isEmpty(str)) {
            this.f64713a = "NUL";
        } else {
            this.f64713a = this.f64713a.replace("_", "-");
        }
        String str2 = Build.MANUFACTURER;
        this.f64714b = str2;
        if (TextUtils.isEmpty(str2)) {
            this.f64714b = "NUL";
        } else {
            this.f64714b = this.f64714b.replace("_", "-");
        }
        String str3 = Build.VERSION.RELEASE;
        this.f64715c = str3;
        if (TextUtils.isEmpty(str3)) {
            this.f64715c = XAdSDKPorxyConfig.REMOTE_VERSION_DEFAULT;
        } else {
            this.f64715c = this.f64715c.replace("_", "-");
        }
        this.f64716d = c();
    }

    public final String c() {
        String str = this.f64713a;
        String str2 = this.f64715c;
        int i = Build.VERSION.SDK_INT;
        String str3 = this.f64714b;
        return str + "_" + str2 + "_" + i + "_" + str3;
    }
}
