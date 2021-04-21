package d.b.h0.a.s0.h;

import androidx.annotation.NonNull;
import com.baidu.searchbox.unitedscheme.UnitedSchemeEntity;
import d.b.h0.a.i2.k0;
import d.b.h0.a.t1.j;
import java.util.List;
/* loaded from: classes2.dex */
public class a extends b {

    /* renamed from: d.b.h0.a.s0.h.a$a  reason: collision with other inner class name */
    /* loaded from: classes2.dex */
    public class RunnableC0819a implements Runnable {

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ List f46569e;

        /* renamed from: f  reason: collision with root package name */
        public final /* synthetic */ d.b.h0.a.s0.j.b f46570f;

        public RunnableC0819a(a aVar, List list, d.b.h0.a.s0.j.b bVar) {
            this.f46569e = list;
            this.f46570f = bVar;
        }

        @Override // java.lang.Runnable
        public void run() {
            for (String str : this.f46569e) {
                this.f46570f.c(str);
            }
        }
    }

    public a(j jVar) {
        super(jVar, "/swanAPI/addComponentToFullScreenSync");
    }

    @Override // d.b.h0.a.s0.h.b
    public boolean j(@NonNull UnitedSchemeEntity unitedSchemeEntity, @NonNull d.b.h0.a.s0.j.b bVar, @NonNull List<String> list) {
        k0.T(new RunnableC0819a(this, list, bVar));
        return true;
    }
}
