package d.b.b;

import android.content.Context;
import android.content.Intent;
import android.os.IBinder;
import com.bytedance.embedapplog.i;
import d.b.b.n1;
/* loaded from: classes5.dex */
public final class b1 extends u0<com.bytedance.embedapplog.i> {

    /* loaded from: classes5.dex */
    public class a implements n1.b<com.bytedance.embedapplog.i, String> {
        public a(b1 b1Var) {
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // d.b.b.n1.b
        /* renamed from: b */
        public com.bytedance.embedapplog.i a(IBinder iBinder) {
            return i.a.a(iBinder);
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // d.b.b.n1.b
        /* renamed from: c */
        public String a(com.bytedance.embedapplog.i iVar) {
            if (iVar == null) {
                return null;
            }
            return iVar.a();
        }
    }

    public b1() {
        super("com.zui.deviceidservice");
    }

    @Override // d.b.b.u0
    public n1.b<com.bytedance.embedapplog.i, String> b() {
        return new a(this);
    }

    @Override // d.b.b.u0
    public Intent d(Context context) {
        Intent intent = new Intent();
        intent.setClassName("com.zui.deviceidservice", "com.zui.deviceidservice.DeviceidService");
        return intent;
    }
}
