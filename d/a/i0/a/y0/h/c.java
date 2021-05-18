package d.a.i0.a.y0.h;

import androidx.annotation.NonNull;
import com.baidu.searchbox.unitedscheme.UnitedSchemeEntity;
import d.a.i0.a.c2.e;
import d.a.i0.a.v2.q0;
import java.util.List;
/* loaded from: classes.dex */
public class c extends b {

    /* loaded from: classes.dex */
    public class a implements Runnable {

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ List f45664e;

        /* renamed from: f  reason: collision with root package name */
        public final /* synthetic */ d.a.i0.a.y0.j.b f45665f;

        public a(c cVar, List list, d.a.i0.a.y0.j.b bVar) {
            this.f45664e = list;
            this.f45665f = bVar;
        }

        @Override // java.lang.Runnable
        public void run() {
            for (String str : this.f45664e) {
                this.f45665f.e(str);
            }
        }
    }

    public c(e eVar) {
        super(eVar, "/swanAPI/removeComponentFromFullScreenSync");
    }

    @Override // d.a.i0.a.y0.h.b
    public boolean j(@NonNull UnitedSchemeEntity unitedSchemeEntity, @NonNull d.a.i0.a.y0.j.b bVar, @NonNull List<String> list) {
        q0.X(new a(this, list, bVar));
        return true;
    }
}
