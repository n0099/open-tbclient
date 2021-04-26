package d.b.b;

import android.content.Context;
import android.content.Intent;
import android.os.IBinder;
import com.bytedance.embedapplog.h;
import d.b.b.n1;
/* loaded from: classes5.dex */
public final class m1 extends u0<com.bytedance.embedapplog.h> {

    /* loaded from: classes5.dex */
    public class a implements n1.b<com.bytedance.embedapplog.h, String> {
        public a(m1 m1Var) {
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // d.b.b.n1.b
        /* renamed from: b */
        public com.bytedance.embedapplog.h a(IBinder iBinder) {
            return h.a.a(iBinder);
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // d.b.b.n1.b
        /* renamed from: c */
        public String a(com.bytedance.embedapplog.h hVar) {
            return hVar.a();
        }
    }

    public m1() {
        super("com.samsung.android.deviceidservice");
    }

    @Override // d.b.b.u0
    public n1.b<com.bytedance.embedapplog.h, String> b() {
        return new a(this);
    }

    @Override // d.b.b.u0
    public Intent d(Context context) {
        Intent intent = new Intent();
        intent.setClassName("com.samsung.android.deviceidservice", "com.samsung.android.deviceidservice.DeviceIdService");
        return intent;
    }
}
