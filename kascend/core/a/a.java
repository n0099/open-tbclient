package kascend.core.a;

import android.content.Context;
import android.text.TextUtils;
import kascend.core.KSDevice;
/* loaded from: classes5.dex */
public abstract class a {
    protected Context context;
    protected a nBr;
    protected KSDevice nBs;

    public abstract void Sc(String str);

    public abstract String getDS();

    public a(Context context) {
        this.context = context;
    }

    public void a(a aVar) {
        this.nBr = aVar;
    }

    public void a(KSDevice kSDevice) {
        this.nBs = kSDevice;
    }

    public String dJS() {
        String ds = getDS();
        if (TextUtils.isEmpty(ds)) {
            if (this.nBr == null) {
                return dJT();
            }
            return this.nBr.dJS();
        }
        return ds;
    }

    public void Sb(String str) {
        Sc(str);
        if (this.nBr != null) {
            this.nBr.Sc(str);
        }
    }

    public String dJT() {
        return this.nBs != null ? this.nBs.getDeviceId() : "";
    }
}
