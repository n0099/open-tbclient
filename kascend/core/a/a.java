package kascend.core.a;

import android.content.Context;
import android.text.TextUtils;
import kascend.core.KSDevice;
/* loaded from: classes18.dex */
public abstract class a {
    protected Context context;
    protected a pIp;
    protected KSDevice pIq;

    public abstract void Zh(String str);

    public abstract String getDS();

    public a(Context context) {
        this.context = context;
    }

    public void a(a aVar) {
        this.pIp = aVar;
    }

    public void a(KSDevice kSDevice) {
        this.pIq = kSDevice;
    }

    public String exz() {
        String ds = getDS();
        if (TextUtils.isEmpty(ds)) {
            if (this.pIp == null) {
                return exA();
            }
            return this.pIp.exz();
        }
        return ds;
    }

    public void Zg(String str) {
        Zh(str);
        if (this.pIp != null) {
            this.pIp.Zh(str);
        }
    }

    public String exA() {
        return this.pIq != null ? this.pIq.getDeviceId() : "";
    }
}
