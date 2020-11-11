package kascend.core.a;

import android.content.Context;
import android.text.TextUtils;
import kascend.core.KSDevice;
/* loaded from: classes18.dex */
public abstract class a {
    protected Context context;
    protected a pRJ;
    protected KSDevice pRK;

    public abstract void ZL(String str);

    public abstract String getDS();

    public a(Context context) {
        this.context = context;
    }

    public void a(a aVar) {
        this.pRJ = aVar;
    }

    public void a(KSDevice kSDevice) {
        this.pRK = kSDevice;
    }

    public String eBo() {
        String ds = getDS();
        if (TextUtils.isEmpty(ds)) {
            if (this.pRJ == null) {
                return eBp();
            }
            return this.pRJ.eBo();
        }
        return ds;
    }

    public void ZK(String str) {
        ZL(str);
        if (this.pRJ != null) {
            this.pRJ.ZL(str);
        }
    }

    public String eBp() {
        return this.pRK != null ? this.pRK.getDeviceId() : "";
    }
}
