package d.b.b;

import android.content.ComponentName;
import android.content.Context;
import android.content.Intent;
import android.os.IBinder;
import com.bytedance.embedapplog.j;
import d.b.b.n1;
/* loaded from: classes6.dex */
public final class k0 extends u0<com.bytedance.embedapplog.j> {

    /* loaded from: classes6.dex */
    public class a implements n1.b<com.bytedance.embedapplog.j, String> {
        public a(k0 k0Var) {
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // d.b.b.n1.b
        /* renamed from: b */
        public com.bytedance.embedapplog.j a(IBinder iBinder) {
            return j.a.a(iBinder);
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // d.b.b.n1.b
        /* renamed from: c */
        public String a(com.bytedance.embedapplog.j jVar) {
            if (jVar == null) {
                return null;
            }
            return jVar.c();
        }
    }

    public k0() {
        super("com.asus.msa.SupplementaryDID");
    }

    @Override // d.b.b.u0
    public n1.b<com.bytedance.embedapplog.j, String> b() {
        return new a(this);
    }

    @Override // d.b.b.u0
    public Intent d(Context context) {
        Intent intent = new Intent();
        intent.setAction("com.asus.msa.action.ACCESS_DID");
        intent.setComponent(new ComponentName("com.asus.msa.SupplementaryDID", "com.asus.msa.SupplementaryDID.SupplementaryDIDService"));
        return intent;
    }
}
