package kascend.core.a;

import android.content.Context;
import android.text.TextUtils;
import kascend.core.KSDevice;
/* loaded from: classes6.dex */
public abstract class a {
    protected Context context;
    protected a orE;
    protected KSDevice orF;

    public abstract void We(String str);

    public abstract String getDS();

    public a(Context context) {
        this.context = context;
    }

    public void a(a aVar) {
        this.orE = aVar;
    }

    public void a(KSDevice kSDevice) {
        this.orF = kSDevice;
    }

    public String efI() {
        String ds = getDS();
        if (TextUtils.isEmpty(ds)) {
            if (this.orE == null) {
                return efJ();
            }
            return this.orE.efI();
        }
        return ds;
    }

    public void Wd(String str) {
        We(str);
        if (this.orE != null) {
            this.orE.We(str);
        }
    }

    public String efJ() {
        return this.orF != null ? this.orF.getDeviceId() : "";
    }
}
