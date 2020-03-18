package kascend.core.a;

import android.content.Context;
import android.text.TextUtils;
import kascend.core.KSDevice;
/* loaded from: classes5.dex */
public abstract class a {
    protected Context context;
    protected a nDr;
    protected KSDevice nDs;

    public abstract void Sc(String str);

    public abstract String getDS();

    public a(Context context) {
        this.context = context;
    }

    public void a(a aVar) {
        this.nDr = aVar;
    }

    public void a(KSDevice kSDevice) {
        this.nDs = kSDevice;
    }

    public String dKv() {
        String ds = getDS();
        if (TextUtils.isEmpty(ds)) {
            if (this.nDr == null) {
                return dKw();
            }
            return this.nDr.dKv();
        }
        return ds;
    }

    public void Sb(String str) {
        Sc(str);
        if (this.nDr != null) {
            this.nDr.Sc(str);
        }
    }

    public String dKw() {
        return this.nDs != null ? this.nDs.getDeviceId() : "";
    }
}
