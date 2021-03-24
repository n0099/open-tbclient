package d.b.g0.a.s0.h;

import androidx.annotation.NonNull;
import com.baidu.searchbox.unitedscheme.UnitedSchemeEntity;
import d.b.g0.a.i2.k0;
import d.b.g0.a.t1.j;
import java.util.List;
/* loaded from: classes3.dex */
public class a extends b {

    /* renamed from: d.b.g0.a.s0.h.a$a  reason: collision with other inner class name */
    /* loaded from: classes3.dex */
    public class RunnableC0786a implements Runnable {

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ List f45847e;

        /* renamed from: f  reason: collision with root package name */
        public final /* synthetic */ d.b.g0.a.s0.j.b f45848f;

        public RunnableC0786a(a aVar, List list, d.b.g0.a.s0.j.b bVar) {
            this.f45847e = list;
            this.f45848f = bVar;
        }

        @Override // java.lang.Runnable
        public void run() {
            for (String str : this.f45847e) {
                this.f45848f.c(str);
            }
        }
    }

    public a(j jVar) {
        super(jVar, "/swanAPI/addComponentToFullScreenSync");
    }

    @Override // d.b.g0.a.s0.h.b
    public boolean j(@NonNull UnitedSchemeEntity unitedSchemeEntity, @NonNull d.b.g0.a.s0.j.b bVar, @NonNull List<String> list) {
        k0.T(new RunnableC0786a(this, list, bVar));
        return true;
    }
}
