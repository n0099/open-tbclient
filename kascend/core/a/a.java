package kascend.core.a;

import android.content.Context;
import android.text.TextUtils;
import kascend.core.KSDevice;
/* loaded from: classes5.dex */
public abstract class a {
    protected Context context;
    protected a nOV;
    protected KSDevice nOW;

    public abstract void Sp(String str);

    public abstract String getDS();

    public a(Context context) {
        this.context = context;
    }

    public void a(a aVar) {
        this.nOV = aVar;
    }

    public void a(KSDevice kSDevice) {
        this.nOW = kSDevice;
    }

    public String dQj() {
        String ds = getDS();
        if (TextUtils.isEmpty(ds)) {
            if (this.nOV == null) {
                return dQk();
            }
            return this.nOV.dQj();
        }
        return ds;
    }

    public void So(String str) {
        Sp(str);
        if (this.nOV != null) {
            this.nOV.Sp(str);
        }
    }

    public String dQk() {
        return this.nOW != null ? this.nOW.getDeviceId() : "";
    }
}
