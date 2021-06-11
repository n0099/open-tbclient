package d.a.l0.a.y0.h;

import androidx.annotation.NonNull;
import com.baidu.searchbox.unitedscheme.UnitedSchemeEntity;
import d.a.l0.a.c2.e;
import d.a.l0.a.v2.q0;
import java.util.List;
/* loaded from: classes3.dex */
public class a extends b {

    /* renamed from: d.a.l0.a.y0.h.a$a  reason: collision with other inner class name */
    /* loaded from: classes3.dex */
    public class RunnableC0970a implements Runnable {

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ List f49512e;

        /* renamed from: f  reason: collision with root package name */
        public final /* synthetic */ d.a.l0.a.y0.j.b f49513f;

        public RunnableC0970a(a aVar, List list, d.a.l0.a.y0.j.b bVar) {
            this.f49512e = list;
            this.f49513f = bVar;
        }

        @Override // java.lang.Runnable
        public void run() {
            for (String str : this.f49512e) {
                this.f49513f.c(str);
            }
        }
    }

    public a(e eVar) {
        super(eVar, "/swanAPI/addComponentToFullScreenSync");
    }

    @Override // d.a.l0.a.y0.h.b
    public boolean j(@NonNull UnitedSchemeEntity unitedSchemeEntity, @NonNull d.a.l0.a.y0.j.b bVar, @NonNull List<String> list) {
        q0.X(new RunnableC0970a(this, list, bVar));
        return true;
    }
}
