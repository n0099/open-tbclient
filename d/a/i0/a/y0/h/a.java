package d.a.i0.a.y0.h;

import androidx.annotation.NonNull;
import com.baidu.searchbox.unitedscheme.UnitedSchemeEntity;
import d.a.i0.a.c2.e;
import d.a.i0.a.v2.q0;
import java.util.List;
/* loaded from: classes.dex */
public class a extends b {

    /* renamed from: d.a.i0.a.y0.h.a$a  reason: collision with other inner class name */
    /* loaded from: classes.dex */
    public class RunnableC0903a implements Runnable {

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ List f45662e;

        /* renamed from: f  reason: collision with root package name */
        public final /* synthetic */ d.a.i0.a.y0.j.b f45663f;

        public RunnableC0903a(a aVar, List list, d.a.i0.a.y0.j.b bVar) {
            this.f45662e = list;
            this.f45663f = bVar;
        }

        @Override // java.lang.Runnable
        public void run() {
            for (String str : this.f45662e) {
                this.f45663f.c(str);
            }
        }
    }

    public a(e eVar) {
        super(eVar, "/swanAPI/addComponentToFullScreenSync");
    }

    @Override // d.a.i0.a.y0.h.b
    public boolean j(@NonNull UnitedSchemeEntity unitedSchemeEntity, @NonNull d.a.i0.a.y0.j.b bVar, @NonNull List<String> list) {
        q0.X(new RunnableC0903a(this, list, bVar));
        return true;
    }
}
