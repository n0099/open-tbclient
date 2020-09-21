package kascend.core.a;

import android.content.Context;
import android.text.TextUtils;
import kascend.core.KSDevice;
/* loaded from: classes6.dex */
public abstract class a {
    protected Context context;
    protected a oBD;
    protected KSDevice oBE;

    public abstract void WG(String str);

    public abstract String getDS();

    public a(Context context) {
        this.context = context;
    }

    public void a(a aVar) {
        this.oBD = aVar;
    }

    public void a(KSDevice kSDevice) {
        this.oBE = kSDevice;
    }

    public String ejO() {
        String ds = getDS();
        if (TextUtils.isEmpty(ds)) {
            if (this.oBD == null) {
                return ejP();
            }
            return this.oBD.ejO();
        }
        return ds;
    }

    public void WF(String str) {
        WG(str);
        if (this.oBD != null) {
            this.oBD.WG(str);
        }
    }

    public String ejP() {
        return this.oBE != null ? this.oBE.getDeviceId() : "";
    }
}
