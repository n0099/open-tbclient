package kascend.core.a;

import android.content.Context;
import android.text.TextUtils;
import kascend.core.KSDevice;
/* loaded from: classes9.dex */
public abstract class a {
    protected Context context;
    protected a pTm;
    protected KSDevice pTn;

    public abstract void Zw(String str);

    public abstract String getDS();

    public a(Context context) {
        this.context = context;
    }

    public void a(a aVar) {
        this.pTm = aVar;
    }

    public void a(KSDevice kSDevice) {
        this.pTn = kSDevice;
    }

    public String eBp() {
        String ds = getDS();
        if (TextUtils.isEmpty(ds)) {
            if (this.pTm == null) {
                return eBq();
            }
            return this.pTm.eBp();
        }
        return ds;
    }

    public void Zv(String str) {
        Zw(str);
        if (this.pTm != null) {
            this.pTm.Zw(str);
        }
    }

    public String eBq() {
        return this.pTn != null ? this.pTn.getDeviceId() : "";
    }
}
