package d.a.h0.a.s0.h;

import androidx.annotation.NonNull;
import com.baidu.searchbox.unitedscheme.UnitedSchemeEntity;
import d.a.h0.a.i2.k0;
import d.a.h0.a.t1.j;
import java.util.List;
/* loaded from: classes2.dex */
public class a extends b {

    /* renamed from: d.a.h0.a.s0.h.a$a  reason: collision with other inner class name */
    /* loaded from: classes2.dex */
    public class RunnableC0758a implements Runnable {

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ List f43936e;

        /* renamed from: f  reason: collision with root package name */
        public final /* synthetic */ d.a.h0.a.s0.j.b f43937f;

        public RunnableC0758a(a aVar, List list, d.a.h0.a.s0.j.b bVar) {
            this.f43936e = list;
            this.f43937f = bVar;
        }

        @Override // java.lang.Runnable
        public void run() {
            for (String str : this.f43936e) {
                this.f43937f.c(str);
            }
        }
    }

    public a(j jVar) {
        super(jVar, "/swanAPI/addComponentToFullScreenSync");
    }

    @Override // d.a.h0.a.s0.h.b
    public boolean j(@NonNull UnitedSchemeEntity unitedSchemeEntity, @NonNull d.a.h0.a.s0.j.b bVar, @NonNull List<String> list) {
        k0.T(new RunnableC0758a(this, list, bVar));
        return true;
    }
}
