package d.a.r.a.b;

import android.content.Context;
import android.os.Build;
import android.text.TextUtils;
import android.util.DisplayMetrics;
import com.baidu.mobads.sdk.internal.XAdSDKPorxyConfig;
import com.baidu.searchbox.logsystem.basic.upload.BaseContentUploader;
import com.baidu.searchbox.logsystem.basic.upload.identity.NetworkParam;
import d.a.r.a.e.f;
import java.util.HashMap;
import java.util.Map;
/* loaded from: classes2.dex */
public final class d implements b, c {

    /* renamed from: a  reason: collision with root package name */
    public final Context f64355a;

    public d(Context context) {
        this.f64355a = context;
    }

    @Override // d.a.r.a.b.b
    public final String a() {
        Integer num;
        String str = d.a.r.a.a.d().c() != d.a.r.a.e.a.f64365a ? "http://bjyz-mco-searchbox201609-m12xi3-044.bjyz.baidu.com:8080/ztbox" : "https://tcbox.baidu.com/ztbox";
        StringBuilder sb = new StringBuilder();
        sb.append(str);
        sb.append("?");
        StringBuilder sb2 = new StringBuilder();
        sb2.append("action=zubc");
        sb2.append("&appname=imsdk");
        sb2.append("&uid=");
        sb2.append(d.a.r.a.a.d().a());
        sb2.append("&ua=");
        Context context = this.f64355a;
        DisplayMetrics a2 = f.a(context);
        int i2 = a2 != null ? a2.widthPixels : 0;
        DisplayMetrics a3 = f.a(context);
        int i3 = a3 != null ? a3.heightPixels : 0;
        DisplayMetrics a4 = f.a(context);
        int i4 = a4 != null ? a4.densityDpi : 0;
        sb2.append(i2 + "_" + i3 + "_android_" + f.b(context) + "_" + i4);
        sb2.append("&ut=");
        String str2 = Build.MODEL;
        String replace = TextUtils.isEmpty(str2) ? "NUL" : str2.replace("_", "-");
        String str3 = Build.VERSION.RELEASE;
        String replace2 = TextUtils.isEmpty(str3) ? XAdSDKPorxyConfig.REMOTE_VERSION_DEFAULT : str3.replace("_", "-");
        int i5 = Build.VERSION.SDK_INT;
        String str4 = Build.MANUFACTURER;
        sb2.append(replace + "_" + replace2 + "_" + i5 + "_" + (TextUtils.isEmpty(str4) ? "NUL" : str4.replace("_", "-")));
        sb2.append("&network=");
        d.a.r.a.e.d dVar = new d.a.r.a.e.d(this.f64355a);
        boolean isEmpty = TextUtils.isEmpty(dVar.f64369a);
        String str5 = NetworkParam.NET_TYPE_ID_DISCONNECT;
        if (!isEmpty && (num = d.a.r.a.e.d.f64368c.get(dVar.f64369a)) != null) {
            str5 = num + "_" + dVar.f64370b;
        }
        if (str5 == null) {
            str5 = "unknown";
        }
        sb2.append(str5);
        sb2.append("&appversion=");
        sb2.append(f.b(this.f64355a));
        if (d.a.r.a.a.d().c() != d.a.r.a.e.a.f64365a) {
            sb2.append("&debug=1");
        }
        sb.append(sb2.toString());
        return sb.toString();
    }

    @Override // d.a.r.a.b.c
    public final void a(int i2, byte[] bArr) {
        String str = new String(bArr);
        d.a.r.a.e.c.a("UBCRequest", "ubc upload errorcode:" + i2 + ", resultContent:" + str);
    }

    @Override // d.a.r.a.b.b
    public final String b() {
        return "POST";
    }

    @Override // d.a.r.a.b.c
    public final void b(int i2, byte[] bArr) {
        String str = new String(bArr);
        d.a.r.a.e.c.a("UBCRequest", "ubc upload errorcode:" + i2 + ", resultContent:" + str);
    }

    @Override // d.a.r.a.b.b
    public final String c() {
        return "application/octet-stream";
    }

    @Override // d.a.r.a.b.b
    public final Map<String, String> d() {
        HashMap hashMap = new HashMap();
        hashMap.put(BaseContentUploader.NB, "1");
        return hashMap;
    }
}
