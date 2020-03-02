package kascend.core.a;

import android.content.Context;
import android.text.TextUtils;
import kascend.core.KSDevice;
/* loaded from: classes5.dex */
public abstract class a {
    protected Context context;
    protected a nBt;
    protected KSDevice nBu;

    public abstract void Sc(String str);

    public abstract String getDS();

    public a(Context context) {
        this.context = context;
    }

    public void a(a aVar) {
        this.nBt = aVar;
    }

    public void a(KSDevice kSDevice) {
        this.nBu = kSDevice;
    }

    public String dJU() {
        String ds = getDS();
        if (TextUtils.isEmpty(ds)) {
            if (this.nBt == null) {
                return dJV();
            }
            return this.nBt.dJU();
        }
        return ds;
    }

    public void Sb(String str) {
        Sc(str);
        if (this.nBt != null) {
            this.nBt.Sc(str);
        }
    }

    public String dJV() {
        return this.nBu != null ? this.nBu.getDeviceId() : "";
    }
}
