package d.b.b;

import android.content.Context;
import android.content.pm.PackageInfo;
import android.content.pm.Signature;
import org.json.JSONObject;
/* loaded from: classes6.dex */
public class u extends h2 {

    /* renamed from: e  reason: collision with root package name */
    public final Context f68839e;

    public u(Context context) {
        super(true, false);
        this.f68839e = context;
    }

    @Override // d.b.b.h2
    public boolean b(JSONObject jSONObject) {
        PackageInfo packageInfo;
        Signature[] signatureArr;
        Signature signature;
        String str = null;
        try {
            packageInfo = this.f68839e.getPackageManager().getPackageInfo(this.f68839e.getPackageName(), 64);
        } catch (Throwable th) {
            r0.b(th);
            packageInfo = null;
        }
        if (packageInfo != null && (signatureArr = packageInfo.signatures) != null && signatureArr.length > 0 && (signature = signatureArr[0]) != null) {
            str = m0.c(signature.toByteArray());
        }
        if (str != null) {
            jSONObject.put("sig_hash", str);
            return true;
        }
        return true;
    }
}
