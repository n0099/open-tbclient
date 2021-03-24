package d.b.l.c;

import android.os.Build;
import android.text.TextUtils;
/* loaded from: classes2.dex */
public class b {

    /* renamed from: a  reason: collision with root package name */
    public String f64012a;

    /* renamed from: b  reason: collision with root package name */
    public String f64013b;

    /* renamed from: c  reason: collision with root package name */
    public String f64014c;

    /* renamed from: d  reason: collision with root package name */
    public String f64015d;

    public b() {
        b();
    }

    public String a() {
        return this.f64015d;
    }

    public final void b() {
        String str = Build.MODEL;
        this.f64012a = str;
        if (TextUtils.isEmpty(str)) {
            this.f64012a = "NUL";
        } else {
            this.f64012a = this.f64012a.replace("_", "-");
        }
        String str2 = Build.MANUFACTURER;
        this.f64013b = str2;
        if (TextUtils.isEmpty(str2)) {
            this.f64013b = "NUL";
        } else {
            this.f64013b = this.f64013b.replace("_", "-");
        }
        String str3 = Build.VERSION.RELEASE;
        this.f64014c = str3;
        if (TextUtils.isEmpty(str3)) {
            this.f64014c = "0.0";
        } else {
            this.f64014c = this.f64014c.replace("_", "-");
        }
        this.f64015d = c();
    }

    public final String c() {
        String str = this.f64012a;
        String str2 = this.f64014c;
        int i = Build.VERSION.SDK_INT;
        String str3 = this.f64013b;
        return str + "_" + str2 + "_" + i + "_" + str3;
    }
}
