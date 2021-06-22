package d.a.m0.b.n.g;

import android.os.Bundle;
import androidx.annotation.NonNull;
import com.baidu.swan.bdprivate.extensions.quicklogin.QuickLoginInfo;
/* loaded from: classes3.dex */
public class b extends d.a.m0.a.v1.a.a.a {

    /* loaded from: classes3.dex */
    public class a implements d.a.m0.a.v2.e1.b<Bundle> {
        public a() {
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // d.a.m0.a.v2.e1.b
        /* renamed from: a */
        public void onCallback(Bundle bundle) {
            if (bundle != null) {
                b.this.f49054d.putParcelable("quick_login_info", bundle.getParcelable("quick_login_info_result"));
            }
            b.this.c();
        }
    }

    /* renamed from: d.a.m0.b.n.g.b$b  reason: collision with other inner class name */
    /* loaded from: classes3.dex */
    public class C1015b implements c {

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ d.a.m0.a.v2.e1.b f50177a;

        public C1015b(d.a.m0.a.v2.e1.b bVar) {
            this.f50177a = bVar;
        }

        @Override // d.a.m0.b.n.g.c
        public void a(QuickLoginInfo quickLoginInfo) {
            if (quickLoginInfo == null) {
                this.f50177a.onCallback(null);
                return;
            }
            b.this.f49054d.putParcelable("quick_login_info_result", quickLoginInfo);
            this.f50177a.onCallback(b.this.f49054d);
        }
    }

    @Override // d.a.m0.a.v1.a.a.a
    public void b(@NonNull Bundle bundle) {
        e(new a());
    }

    public void e(d.a.m0.a.v2.e1.b<Bundle> bVar) {
        f.a(new C1015b(bVar));
    }
}
