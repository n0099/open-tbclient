package kascend.core.a;

import android.content.Context;
import android.text.TextUtils;
import kascend.core.KSDevice;
/* loaded from: classes5.dex */
public abstract class a {
    protected Context context;
    protected a nOS;
    protected KSDevice nOT;

    public abstract void So(String str);

    public abstract String getDS();

    public a(Context context) {
        this.context = context;
    }

    public void a(a aVar) {
        this.nOS = aVar;
    }

    public void a(KSDevice kSDevice) {
        this.nOT = kSDevice;
    }

    public String dQf() {
        String ds = getDS();
        if (TextUtils.isEmpty(ds)) {
            if (this.nOS == null) {
                return dQg();
            }
            return this.nOS.dQf();
        }
        return ds;
    }

    public void Sn(String str) {
        So(str);
        if (this.nOS != null) {
            this.nOS.So(str);
        }
    }

    public String dQg() {
        return this.nOT != null ? this.nOT.getDeviceId() : "";
    }
}
