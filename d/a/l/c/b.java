package d.a.l.c;

import android.os.Build;
import android.text.TextUtils;
import com.baidu.mobads.sdk.internal.XAdSDKPorxyConfig;
/* loaded from: classes2.dex */
public class b {

    /* renamed from: a  reason: collision with root package name */
    public String f44237a;

    /* renamed from: b  reason: collision with root package name */
    public String f44238b;

    /* renamed from: c  reason: collision with root package name */
    public String f44239c;

    /* renamed from: d  reason: collision with root package name */
    public String f44240d;

    public b() {
        b();
    }

    public String a() {
        return this.f44240d;
    }

    public final void b() {
        String str = Build.MODEL;
        this.f44237a = str;
        if (TextUtils.isEmpty(str)) {
            this.f44237a = "NUL";
        } else {
            this.f44237a = this.f44237a.replace("_", "-");
        }
        String str2 = Build.MANUFACTURER;
        this.f44238b = str2;
        if (TextUtils.isEmpty(str2)) {
            this.f44238b = "NUL";
        } else {
            this.f44238b = this.f44238b.replace("_", "-");
        }
        String str3 = Build.VERSION.RELEASE;
        this.f44239c = str3;
        if (TextUtils.isEmpty(str3)) {
            this.f44239c = XAdSDKPorxyConfig.REMOTE_VERSION_DEFAULT;
        } else {
            this.f44239c = this.f44239c.replace("_", "-");
        }
        this.f44240d = c();
    }

    public final String c() {
        String str = this.f44237a;
        String str2 = this.f44239c;
        int i2 = Build.VERSION.SDK_INT;
        String str3 = this.f44238b;
        return str + "_" + str2 + "_" + i2 + "_" + str3;
    }
}
