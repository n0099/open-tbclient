package kascend.core.a;

import android.content.Context;
import android.text.TextUtils;
import kascend.core.KSDevice;
/* loaded from: classes6.dex */
public abstract class a {
    protected Context context;
    protected a orW;
    protected KSDevice orX;

    public abstract void We(String str);

    public abstract String getDS();

    public a(Context context) {
        this.context = context;
    }

    public void a(a aVar) {
        this.orW = aVar;
    }

    public void a(KSDevice kSDevice) {
        this.orX = kSDevice;
    }

    public String efR() {
        String ds = getDS();
        if (TextUtils.isEmpty(ds)) {
            if (this.orW == null) {
                return efS();
            }
            return this.orW.efR();
        }
        return ds;
    }

    public void Wd(String str) {
        We(str);
        if (this.orW != null) {
            this.orW.We(str);
        }
    }

    public String efS() {
        return this.orX != null ? this.orX.getDeviceId() : "";
    }
}
