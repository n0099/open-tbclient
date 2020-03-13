package kascend.core.a;

import android.content.Context;
import android.text.TextUtils;
import kascend.core.KSDevice;
/* loaded from: classes5.dex */
public abstract class a {
    protected Context context;
    protected a nBE;
    protected KSDevice nBF;

    public abstract void Sd(String str);

    public abstract String getDS();

    public a(Context context) {
        this.context = context;
    }

    public void a(a aVar) {
        this.nBE = aVar;
    }

    public void a(KSDevice kSDevice) {
        this.nBF = kSDevice;
    }

    public String dJV() {
        String ds = getDS();
        if (TextUtils.isEmpty(ds)) {
            if (this.nBE == null) {
                return dJW();
            }
            return this.nBE.dJV();
        }
        return ds;
    }

    public void Sc(String str) {
        Sd(str);
        if (this.nBE != null) {
            this.nBE.Sd(str);
        }
    }

    public String dJW() {
        return this.nBF != null ? this.nBF.getDeviceId() : "";
    }
}
