package kascend.core.a;

import android.content.Context;
import android.text.TextUtils;
import kascend.core.KSDevice;
/* loaded from: classes5.dex */
public abstract class a {
    protected Context context;
    protected a ntf;
    protected KSDevice ntg;

    public abstract void RC(String str);

    public abstract String getDS();

    public a(Context context) {
        this.context = context;
    }

    public void a(a aVar) {
        this.ntf = aVar;
    }

    public void a(KSDevice kSDevice) {
        this.ntg = kSDevice;
    }

    public String dLz() {
        String ds = getDS();
        if (TextUtils.isEmpty(ds)) {
            if (this.ntf == null) {
                return dLA();
            }
            return this.ntf.dLz();
        }
        return ds;
    }

    public void RB(String str) {
        RC(str);
        if (this.ntf != null) {
            this.ntf.RC(str);
        }
    }

    public String dLA() {
        return this.ntg != null ? this.ntg.getDeviceId() : "";
    }
}
