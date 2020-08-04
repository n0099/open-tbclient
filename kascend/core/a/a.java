package kascend.core.a;

import android.content.Context;
import android.text.TextUtils;
import kascend.core.KSDevice;
/* loaded from: classes12.dex */
public abstract class a {
    protected Context context;
    protected a nXG;
    protected KSDevice nXH;

    public abstract void Ta(String str);

    public abstract String getDS();

    public a(Context context) {
        this.context = context;
    }

    public void a(a aVar) {
        this.nXG = aVar;
    }

    public void a(KSDevice kSDevice) {
        this.nXH = kSDevice;
    }

    public String dTG() {
        String ds = getDS();
        if (TextUtils.isEmpty(ds)) {
            if (this.nXG == null) {
                return dTH();
            }
            return this.nXG.dTG();
        }
        return ds;
    }

    public void SZ(String str) {
        Ta(str);
        if (this.nXG != null) {
            this.nXG.Ta(str);
        }
    }

    public String dTH() {
        return this.nXH != null ? this.nXH.getDeviceId() : "";
    }
}
