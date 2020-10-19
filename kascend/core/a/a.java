package kascend.core.a;

import android.content.Context;
import android.text.TextUtils;
import kascend.core.KSDevice;
/* loaded from: classes18.dex */
public abstract class a {
    protected Context context;
    protected a oQS;
    protected KSDevice oQT;

    public abstract void Xu(String str);

    public abstract String getDS();

    public a(Context context) {
        this.context = context;
    }

    public void a(a aVar) {
        this.oQS = aVar;
    }

    public void a(KSDevice kSDevice) {
        this.oQT = kSDevice;
    }

    public String enA() {
        String ds = getDS();
        if (TextUtils.isEmpty(ds)) {
            if (this.oQS == null) {
                return enB();
            }
            return this.oQS.enA();
        }
        return ds;
    }

    public void Xt(String str) {
        Xu(str);
        if (this.oQS != null) {
            this.oQS.Xu(str);
        }
    }

    public String enB() {
        return this.oQT != null ? this.oQT.getDeviceId() : "";
    }
}
