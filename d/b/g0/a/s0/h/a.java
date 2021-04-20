package d.b.g0.a.s0.h;

import androidx.annotation.NonNull;
import com.baidu.searchbox.unitedscheme.UnitedSchemeEntity;
import d.b.g0.a.i2.k0;
import d.b.g0.a.t1.j;
import java.util.List;
/* loaded from: classes2.dex */
public class a extends b {

    /* renamed from: d.b.g0.a.s0.h.a$a  reason: collision with other inner class name */
    /* loaded from: classes2.dex */
    public class RunnableC0799a implements Runnable {

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ List f46240e;

        /* renamed from: f  reason: collision with root package name */
        public final /* synthetic */ d.b.g0.a.s0.j.b f46241f;

        public RunnableC0799a(a aVar, List list, d.b.g0.a.s0.j.b bVar) {
            this.f46240e = list;
            this.f46241f = bVar;
        }

        @Override // java.lang.Runnable
        public void run() {
            for (String str : this.f46240e) {
                this.f46241f.c(str);
            }
        }
    }

    public a(j jVar) {
        super(jVar, "/swanAPI/addComponentToFullScreenSync");
    }

    @Override // d.b.g0.a.s0.h.b
    public boolean j(@NonNull UnitedSchemeEntity unitedSchemeEntity, @NonNull d.b.g0.a.s0.j.b bVar, @NonNull List<String> list) {
        k0.T(new RunnableC0799a(this, list, bVar));
        return true;
    }
}
