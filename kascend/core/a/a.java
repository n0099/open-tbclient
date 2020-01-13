package kascend.core.a;

import android.content.Context;
import android.text.TextUtils;
import kascend.core.KSDevice;
/* loaded from: classes4.dex */
public abstract class a {
    protected Context context;
    protected a nAK;
    protected KSDevice nAL;

    public abstract void RR(String str);

    public abstract String getDS();

    public a(Context context) {
        this.context = context;
    }

    public void a(a aVar) {
        this.nAK = aVar;
    }

    public void a(KSDevice kSDevice) {
        this.nAL = kSDevice;
    }

    public String dIJ() {
        String ds = getDS();
        if (TextUtils.isEmpty(ds)) {
            if (this.nAK == null) {
                return dIK();
            }
            return this.nAK.dIJ();
        }
        return ds;
    }

    public void RQ(String str) {
        RR(str);
        if (this.nAK != null) {
            this.nAK.RR(str);
        }
    }

    public String dIK() {
        return this.nAL != null ? this.nAL.getDeviceId() : "";
    }
}
