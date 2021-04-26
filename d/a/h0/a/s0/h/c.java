package d.a.h0.a.s0.h;

import androidx.annotation.NonNull;
import com.baidu.searchbox.unitedscheme.UnitedSchemeEntity;
import d.a.h0.a.i2.k0;
import d.a.h0.a.t1.j;
import java.util.List;
/* loaded from: classes2.dex */
public class c extends b {

    /* loaded from: classes2.dex */
    public class a implements Runnable {

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ List f43938e;

        /* renamed from: f  reason: collision with root package name */
        public final /* synthetic */ d.a.h0.a.s0.j.b f43939f;

        public a(c cVar, List list, d.a.h0.a.s0.j.b bVar) {
            this.f43938e = list;
            this.f43939f = bVar;
        }

        @Override // java.lang.Runnable
        public void run() {
            for (String str : this.f43938e) {
                this.f43939f.e(str);
            }
        }
    }

    public c(j jVar) {
        super(jVar, "/swanAPI/removeComponentFromFullScreenSync");
    }

    @Override // d.a.h0.a.s0.h.b
    public boolean j(@NonNull UnitedSchemeEntity unitedSchemeEntity, @NonNull d.a.h0.a.s0.j.b bVar, @NonNull List<String> list) {
        k0.T(new a(this, list, bVar));
        return true;
    }
}
