package kascend.core.a;

import android.content.Context;
import android.text.TextUtils;
import kascend.core.KSDevice;
/* loaded from: classes5.dex */
public abstract class a {
    protected Context context;
    protected a nrV;
    protected KSDevice nrW;

    public abstract void RB(String str);

    public abstract String getDS();

    public a(Context context) {
        this.context = context;
    }

    public void a(a aVar) {
        this.nrV = aVar;
    }

    public void a(KSDevice kSDevice) {
        this.nrW = kSDevice;
    }

    public String dLl() {
        String ds = getDS();
        if (TextUtils.isEmpty(ds)) {
            if (this.nrV == null) {
                return dLm();
            }
            return this.nrV.dLl();
        }
        return ds;
    }

    public void RA(String str) {
        RB(str);
        if (this.nrV != null) {
            this.nrV.RB(str);
        }
    }

    public String dLm() {
        return this.nrW != null ? this.nrW.getDeviceId() : "";
    }
}
