package d.b.b;

import android.content.Context;
import android.content.Intent;
import android.os.IBinder;
import com.bytedance.embedapplog.f;
import d.b.b.g1;
import d.b.b.n1;
/* loaded from: classes5.dex */
public final class w0 extends u0<com.bytedance.embedapplog.f> {

    /* loaded from: classes5.dex */
    public class a implements n1.b<com.bytedance.embedapplog.f, String> {
        public a(w0 w0Var) {
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // d.b.b.n1.b
        /* renamed from: b */
        public com.bytedance.embedapplog.f a(IBinder iBinder) {
            return f.a.a(iBinder);
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // d.b.b.n1.b
        /* renamed from: c */
        public String a(com.bytedance.embedapplog.f fVar) {
            if (fVar == null) {
                return null;
            }
            return fVar.c();
        }
    }

    public w0() {
        super("com.mdid.msa");
    }

    @Override // d.b.b.u0, d.b.b.g1
    public g1.a b(Context context) {
        e(context, context.getPackageName());
        return super.b(context);
    }

    @Override // d.b.b.u0
    public Intent d(Context context) {
        Intent intent = new Intent();
        intent.setClassName("com.mdid.msa", "com.mdid.msa.service.MsaIdService");
        intent.setAction("com.bun.msa.action.bindto.service");
        intent.putExtra("com.bun.msa.param.pkgname", context.getPackageName());
        return intent;
    }

    public final void e(Context context, String str) {
        Intent intent = new Intent();
        intent.setClassName("com.mdid.msa", "com.mdid.msa.service.MsaKlService");
        intent.setAction("com.bun.msa.action.start.service");
        intent.putExtra("com.bun.msa.param.pkgname", str);
        try {
            intent.putExtra("com.bun.msa.param.runinset", true);
            context.startService(intent);
        } catch (Exception e2) {
            e2.printStackTrace();
        }
    }

    @Override // d.b.b.u0
    public n1.b<com.bytedance.embedapplog.f, String> b() {
        return new a(this);
    }
}
