package d.a.l.c;

import android.os.Build;
import android.text.TextUtils;
import com.baidu.mobads.sdk.internal.XAdSDKPorxyConfig;
/* loaded from: classes2.dex */
public class b {

    /* renamed from: a  reason: collision with root package name */
    public String f44338a;

    /* renamed from: b  reason: collision with root package name */
    public String f44339b;

    /* renamed from: c  reason: collision with root package name */
    public String f44340c;

    /* renamed from: d  reason: collision with root package name */
    public String f44341d;

    public b() {
        b();
    }

    public String a() {
        return this.f44341d;
    }

    public final void b() {
        String str = Build.MODEL;
        this.f44338a = str;
        if (TextUtils.isEmpty(str)) {
            this.f44338a = "NUL";
        } else {
            this.f44338a = this.f44338a.replace("_", "-");
        }
        String str2 = Build.MANUFACTURER;
        this.f44339b = str2;
        if (TextUtils.isEmpty(str2)) {
            this.f44339b = "NUL";
        } else {
            this.f44339b = this.f44339b.replace("_", "-");
        }
        String str3 = Build.VERSION.RELEASE;
        this.f44340c = str3;
        if (TextUtils.isEmpty(str3)) {
            this.f44340c = XAdSDKPorxyConfig.REMOTE_VERSION_DEFAULT;
        } else {
            this.f44340c = this.f44340c.replace("_", "-");
        }
        this.f44341d = c();
    }

    public final String c() {
        String str = this.f44338a;
        String str2 = this.f44340c;
        int i2 = Build.VERSION.SDK_INT;
        String str3 = this.f44339b;
        return str + "_" + str2 + "_" + i2 + "_" + str3;
    }
}
