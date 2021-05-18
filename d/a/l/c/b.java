package d.a.l.c;

import android.os.Build;
import android.text.TextUtils;
import com.baidu.mobads.sdk.internal.XAdSDKPorxyConfig;
/* loaded from: classes.dex */
public class b {

    /* renamed from: a  reason: collision with root package name */
    public String f63769a;

    /* renamed from: b  reason: collision with root package name */
    public String f63770b;

    /* renamed from: c  reason: collision with root package name */
    public String f63771c;

    /* renamed from: d  reason: collision with root package name */
    public String f63772d;

    public b() {
        b();
    }

    public String a() {
        return this.f63772d;
    }

    public final void b() {
        String str = Build.MODEL;
        this.f63769a = str;
        if (TextUtils.isEmpty(str)) {
            this.f63769a = "NUL";
        } else {
            this.f63769a = this.f63769a.replace("_", "-");
        }
        String str2 = Build.MANUFACTURER;
        this.f63770b = str2;
        if (TextUtils.isEmpty(str2)) {
            this.f63770b = "NUL";
        } else {
            this.f63770b = this.f63770b.replace("_", "-");
        }
        String str3 = Build.VERSION.RELEASE;
        this.f63771c = str3;
        if (TextUtils.isEmpty(str3)) {
            this.f63771c = XAdSDKPorxyConfig.REMOTE_VERSION_DEFAULT;
        } else {
            this.f63771c = this.f63771c.replace("_", "-");
        }
        this.f63772d = c();
    }

    public final String c() {
        String str = this.f63769a;
        String str2 = this.f63771c;
        int i2 = Build.VERSION.SDK_INT;
        String str3 = this.f63770b;
        return str + "_" + str2 + "_" + i2 + "_" + str3;
    }
}
