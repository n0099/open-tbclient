package d.a.m0.a.y0.h;

import androidx.annotation.NonNull;
import com.baidu.searchbox.unitedscheme.UnitedSchemeEntity;
import d.a.m0.a.c2.e;
import d.a.m0.a.v2.q0;
import java.util.List;
/* loaded from: classes3.dex */
public class a extends b {

    /* renamed from: d.a.m0.a.y0.h.a$a  reason: collision with other inner class name */
    /* loaded from: classes3.dex */
    public class RunnableC0973a implements Runnable {

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ List f49620e;

        /* renamed from: f  reason: collision with root package name */
        public final /* synthetic */ d.a.m0.a.y0.j.b f49621f;

        public RunnableC0973a(a aVar, List list, d.a.m0.a.y0.j.b bVar) {
            this.f49620e = list;
            this.f49621f = bVar;
        }

        @Override // java.lang.Runnable
        public void run() {
            for (String str : this.f49620e) {
                this.f49621f.c(str);
            }
        }
    }

    public a(e eVar) {
        super(eVar, "/swanAPI/addComponentToFullScreenSync");
    }

    @Override // d.a.m0.a.y0.h.b
    public boolean j(@NonNull UnitedSchemeEntity unitedSchemeEntity, @NonNull d.a.m0.a.y0.j.b bVar, @NonNull List<String> list) {
        q0.X(new RunnableC0973a(this, list, bVar));
        return true;
    }
}
