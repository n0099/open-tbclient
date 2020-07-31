package kascend.core.a;

import android.content.Context;
import android.text.TextUtils;
import kascend.core.KSDevice;
/* loaded from: classes12.dex */
public abstract class a {
    protected Context context;
    protected a nXE;
    protected KSDevice nXF;

    public abstract void Ta(String str);

    public abstract String getDS();

    public a(Context context) {
        this.context = context;
    }

    public void a(a aVar) {
        this.nXE = aVar;
    }

    public void a(KSDevice kSDevice) {
        this.nXF = kSDevice;
    }

    public String dTF() {
        String ds = getDS();
        if (TextUtils.isEmpty(ds)) {
            if (this.nXE == null) {
                return dTG();
            }
            return this.nXE.dTF();
        }
        return ds;
    }

    public void SZ(String str) {
        Ta(str);
        if (this.nXE != null) {
            this.nXE.Ta(str);
        }
    }

    public String dTG() {
        return this.nXF != null ? this.nXF.getDeviceId() : "";
    }
}
