package d.c.b;

import android.content.Context;
import android.content.pm.PackageInfo;
import android.content.pm.Signature;
import org.json.JSONObject;
/* loaded from: classes5.dex */
public class u extends h2 {

    /* renamed from: e  reason: collision with root package name */
    public final Context f65078e;

    public u(Context context) {
        super(true, false);
        this.f65078e = context;
    }

    @Override // d.c.b.h2
    public boolean b(JSONObject jSONObject) {
        PackageInfo packageInfo;
        Signature[] signatureArr;
        Signature signature;
        String str = null;
        try {
            packageInfo = this.f65078e.getPackageManager().getPackageInfo(this.f65078e.getPackageName(), 64);
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
