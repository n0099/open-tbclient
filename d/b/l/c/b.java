package d.b.l.c;

import android.os.Build;
import android.text.TextUtils;
/* loaded from: classes.dex */
public class b {

    /* renamed from: a  reason: collision with root package name */
    public String f64013a;

    /* renamed from: b  reason: collision with root package name */
    public String f64014b;

    /* renamed from: c  reason: collision with root package name */
    public String f64015c;

    /* renamed from: d  reason: collision with root package name */
    public String f64016d;

    public b() {
        b();
    }

    public String a() {
        return this.f64016d;
    }

    public final void b() {
        String str = Build.MODEL;
        this.f64013a = str;
        if (TextUtils.isEmpty(str)) {
            this.f64013a = "NUL";
        } else {
            this.f64013a = this.f64013a.replace("_", "-");
        }
        String str2 = Build.MANUFACTURER;
        this.f64014b = str2;
        if (TextUtils.isEmpty(str2)) {
            this.f64014b = "NUL";
        } else {
            this.f64014b = this.f64014b.replace("_", "-");
        }
        String str3 = Build.VERSION.RELEASE;
        this.f64015c = str3;
        if (TextUtils.isEmpty(str3)) {
            this.f64015c = "0.0";
        } else {
            this.f64015c = this.f64015c.replace("_", "-");
        }
        this.f64016d = c();
    }

    public final String c() {
        String str = this.f64013a;
        String str2 = this.f64015c;
        int i = Build.VERSION.SDK_INT;
        String str3 = this.f64014b;
        return str + "_" + str2 + "_" + i + "_" + str3;
    }
}
