package d.a.h0.b.m.g;

import android.os.Bundle;
import androidx.annotation.NonNull;
import com.baidu.swan.bdprivate.extensions.quicklogin.QuickLoginInfo;
/* loaded from: classes3.dex */
public class b extends d.a.h0.a.n1.a.a.a {

    /* loaded from: classes3.dex */
    public class a implements d.a.h0.a.i2.u0.b<Bundle> {
        public a() {
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // d.a.h0.a.i2.u0.b
        /* renamed from: a */
        public void onCallback(Bundle bundle) {
            if (bundle != null) {
                b.this.f43404d.putParcelable("quick_login_info", bundle.getParcelable("quick_login_info_result"));
            }
            b.this.c();
        }
    }

    /* renamed from: d.a.h0.b.m.g.b$b  reason: collision with other inner class name */
    /* loaded from: classes3.dex */
    public class C0884b implements c {

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ d.a.h0.a.i2.u0.b f45600a;

        public C0884b(d.a.h0.a.i2.u0.b bVar) {
            this.f45600a = bVar;
        }

        @Override // d.a.h0.b.m.g.c
        public void a(QuickLoginInfo quickLoginInfo) {
            if (quickLoginInfo == null) {
                this.f45600a.onCallback(null);
                return;
            }
            b.this.f43404d.putParcelable("quick_login_info_result", quickLoginInfo);
            this.f45600a.onCallback(b.this.f43404d);
        }
    }

    @Override // d.a.h0.a.n1.a.a.a
    public void b(@NonNull Bundle bundle) {
        e(new a());
    }

    public void e(d.a.h0.a.i2.u0.b<Bundle> bVar) {
        f.a(new C0884b(bVar));
    }
}
