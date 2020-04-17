package kascend.core.a;

import android.content.Context;
import android.text.TextUtils;
import kascend.core.KSDevice;
/* loaded from: classes5.dex */
public abstract class a {
    protected Context context;
    protected a mWQ;
    protected KSDevice mWR;

    public abstract void Ps(String str);

    public abstract String getDS();

    public a(Context context) {
        this.context = context;
    }

    public void a(a aVar) {
        this.mWQ = aVar;
    }

    public void a(KSDevice kSDevice) {
        this.mWR = kSDevice;
    }

    public String dDu() {
        String ds = getDS();
        if (TextUtils.isEmpty(ds)) {
            if (this.mWQ == null) {
                return dDv();
            }
            return this.mWQ.dDu();
        }
        return ds;
    }

    public void Pr(String str) {
        Ps(str);
        if (this.mWQ != null) {
            this.mWQ.Ps(str);
        }
    }

    public String dDv() {
        return this.mWR != null ? this.mWR.getDeviceId() : "";
    }
}
