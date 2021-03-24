package d.b.g0.a.s0.h;

import androidx.annotation.NonNull;
import com.baidu.searchbox.unitedscheme.UnitedSchemeEntity;
import d.b.g0.a.i2.k0;
import d.b.g0.a.t1.j;
import java.util.List;
/* loaded from: classes3.dex */
public class c extends b {

    /* loaded from: classes3.dex */
    public class a implements Runnable {

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ List f45849e;

        /* renamed from: f  reason: collision with root package name */
        public final /* synthetic */ d.b.g0.a.s0.j.b f45850f;

        public a(c cVar, List list, d.b.g0.a.s0.j.b bVar) {
            this.f45849e = list;
            this.f45850f = bVar;
        }

        @Override // java.lang.Runnable
        public void run() {
            for (String str : this.f45849e) {
                this.f45850f.e(str);
            }
        }
    }

    public c(j jVar) {
        super(jVar, "/swanAPI/removeComponentFromFullScreenSync");
    }

    @Override // d.b.g0.a.s0.h.b
    public boolean j(@NonNull UnitedSchemeEntity unitedSchemeEntity, @NonNull d.b.g0.a.s0.j.b bVar, @NonNull List<String> list) {
        k0.T(new a(this, list, bVar));
        return true;
    }
}
