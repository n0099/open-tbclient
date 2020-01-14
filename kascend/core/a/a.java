package kascend.core.a;

import android.content.Context;
import android.text.TextUtils;
import kascend.core.KSDevice;
/* loaded from: classes4.dex */
public abstract class a {
    protected Context context;
    protected a nAP;
    protected KSDevice nAQ;

    public abstract void RR(String str);

    public abstract String getDS();

    public a(Context context) {
        this.context = context;
    }

    public void a(a aVar) {
        this.nAP = aVar;
    }

    public void a(KSDevice kSDevice) {
        this.nAQ = kSDevice;
    }

    public String dIL() {
        String ds = getDS();
        if (TextUtils.isEmpty(ds)) {
            if (this.nAP == null) {
                return dIM();
            }
            return this.nAP.dIL();
        }
        return ds;
    }

    public void RQ(String str) {
        RR(str);
        if (this.nAP != null) {
            this.nAP.RR(str);
        }
    }

    public String dIM() {
        return this.nAQ != null ? this.nAQ.getDeviceId() : "";
    }
}
