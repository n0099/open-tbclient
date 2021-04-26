package d.a.l.c;

import android.os.Build;
import android.text.TextUtils;
import com.baidu.mobads.sdk.internal.XAdSDKPorxyConfig;
/* loaded from: classes.dex */
public class b {

    /* renamed from: a  reason: collision with root package name */
    public String f63137a;

    /* renamed from: b  reason: collision with root package name */
    public String f63138b;

    /* renamed from: c  reason: collision with root package name */
    public String f63139c;

    /* renamed from: d  reason: collision with root package name */
    public String f63140d;

    public b() {
        b();
    }

    public String a() {
        return this.f63140d;
    }

    public final void b() {
        String str = Build.MODEL;
        this.f63137a = str;
        if (TextUtils.isEmpty(str)) {
            this.f63137a = "NUL";
        } else {
            this.f63137a = this.f63137a.replace("_", "-");
        }
        String str2 = Build.MANUFACTURER;
        this.f63138b = str2;
        if (TextUtils.isEmpty(str2)) {
            this.f63138b = "NUL";
        } else {
            this.f63138b = this.f63138b.replace("_", "-");
        }
        String str3 = Build.VERSION.RELEASE;
        this.f63139c = str3;
        if (TextUtils.isEmpty(str3)) {
            this.f63139c = XAdSDKPorxyConfig.REMOTE_VERSION_DEFAULT;
        } else {
            this.f63139c = this.f63139c.replace("_", "-");
        }
        this.f63140d = c();
    }

    public final String c() {
        String str = this.f63137a;
        String str2 = this.f63139c;
        int i2 = Build.VERSION.SDK_INT;
        String str3 = this.f63138b;
        return str + "_" + str2 + "_" + i2 + "_" + str3;
    }
}
