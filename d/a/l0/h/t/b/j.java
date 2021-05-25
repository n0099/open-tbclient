package d.a.l0.h.t.b;

import com.baidu.pyramid.annotation.Service;
import d.a.l0.a.q1.b;
import d.a.l0.h.b.a;
@Service
/* loaded from: classes3.dex */
public class j implements d.a.l0.a.p.b.a.c {

    /* loaded from: classes3.dex */
    public class a implements a.d {

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ b.j f47679a;

        public a(j jVar, b.j jVar2) {
            this.f47679a = jVar2;
        }

        @Override // d.a.l0.h.b.a.d
        public void a(String str) {
            b.j jVar = this.f47679a;
            if (jVar != null) {
                jVar.a(str);
            }
        }

        @Override // d.a.l0.h.b.a.d
        public void onSuccess() {
            b.j jVar = this.f47679a;
            if (jVar != null) {
                jVar.onSuccess();
            }
        }
    }

    @Override // d.a.l0.a.p.b.a.c
    public void a(String str, b.j jVar) {
        d.a.l0.h.b.d.p().j(str, new a(this, jVar));
    }
}
