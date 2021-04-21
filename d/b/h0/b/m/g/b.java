package d.b.h0.b.m.g;

import android.os.Bundle;
import androidx.annotation.NonNull;
import com.baidu.swan.bdprivate.extensions.quicklogin.QuickLoginInfo;
/* loaded from: classes3.dex */
public class b extends d.b.h0.a.n1.a.a.a {

    /* loaded from: classes3.dex */
    public class a implements d.b.h0.a.i2.u0.b<Bundle> {
        public a() {
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // d.b.h0.a.i2.u0.b
        /* renamed from: a */
        public void onCallback(Bundle bundle) {
            if (bundle != null) {
                b.this.f46061d.putParcelable("quick_login_info", bundle.getParcelable("quick_login_info_result"));
            }
            b.this.c();
        }
    }

    /* renamed from: d.b.h0.b.m.g.b$b  reason: collision with other inner class name */
    /* loaded from: classes3.dex */
    public class C0945b implements c {

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ d.b.h0.a.i2.u0.b f48154a;

        public C0945b(d.b.h0.a.i2.u0.b bVar) {
            this.f48154a = bVar;
        }

        @Override // d.b.h0.b.m.g.c
        public void a(QuickLoginInfo quickLoginInfo) {
            if (quickLoginInfo == null) {
                this.f48154a.onCallback(null);
                return;
            }
            b.this.f46061d.putParcelable("quick_login_info_result", quickLoginInfo);
            this.f48154a.onCallback(b.this.f46061d);
        }
    }

    @Override // d.b.h0.a.n1.a.a.a
    public void b(@NonNull Bundle bundle) {
        e(new a());
    }

    public void e(d.b.h0.a.i2.u0.b<Bundle> bVar) {
        f.a(new C0945b(bVar));
    }
}
