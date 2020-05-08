package kascend.core.a;

import android.content.Context;
import android.text.TextUtils;
import kascend.core.KSDevice;
/* loaded from: classes5.dex */
public abstract class a {
    protected Context context;
    protected a mWT;
    protected KSDevice mWU;

    public abstract void Pv(String str);

    public abstract String getDS();

    public a(Context context) {
        this.context = context;
    }

    public void a(a aVar) {
        this.mWT = aVar;
    }

    public void a(KSDevice kSDevice) {
        this.mWU = kSDevice;
    }

    public String dDq() {
        String ds = getDS();
        if (TextUtils.isEmpty(ds)) {
            if (this.mWT == null) {
                return dDr();
            }
            return this.mWT.dDq();
        }
        return ds;
    }

    public void Pu(String str) {
        Pv(str);
        if (this.mWT != null) {
            this.mWT.Pv(str);
        }
    }

    public String dDr() {
        return this.mWU != null ? this.mWU.getDeviceId() : "";
    }
}
