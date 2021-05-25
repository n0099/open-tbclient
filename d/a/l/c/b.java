package d.a.l.c;

import android.os.Build;
import android.text.TextUtils;
import com.baidu.mobads.sdk.internal.XAdSDKPorxyConfig;
/* loaded from: classes.dex */
public class b {

    /* renamed from: a  reason: collision with root package name */
    public String f40561a;

    /* renamed from: b  reason: collision with root package name */
    public String f40562b;

    /* renamed from: c  reason: collision with root package name */
    public String f40563c;

    /* renamed from: d  reason: collision with root package name */
    public String f40564d;

    public b() {
        b();
    }

    public String a() {
        return this.f40564d;
    }

    public final void b() {
        String str = Build.MODEL;
        this.f40561a = str;
        if (TextUtils.isEmpty(str)) {
            this.f40561a = "NUL";
        } else {
            this.f40561a = this.f40561a.replace("_", "-");
        }
        String str2 = Build.MANUFACTURER;
        this.f40562b = str2;
        if (TextUtils.isEmpty(str2)) {
            this.f40562b = "NUL";
        } else {
            this.f40562b = this.f40562b.replace("_", "-");
        }
        String str3 = Build.VERSION.RELEASE;
        this.f40563c = str3;
        if (TextUtils.isEmpty(str3)) {
            this.f40563c = XAdSDKPorxyConfig.REMOTE_VERSION_DEFAULT;
        } else {
            this.f40563c = this.f40563c.replace("_", "-");
        }
        this.f40564d = c();
    }

    public final String c() {
        String str = this.f40561a;
        String str2 = this.f40563c;
        int i2 = Build.VERSION.SDK_INT;
        String str3 = this.f40562b;
        return str + "_" + str2 + "_" + i2 + "_" + str3;
    }
}
