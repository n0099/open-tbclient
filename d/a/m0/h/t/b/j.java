package d.a.m0.h.t.b;

import com.baidu.pyramid.annotation.Service;
import d.a.m0.a.q1.b;
import d.a.m0.h.b.a;
@Service
/* loaded from: classes3.dex */
public class j implements d.a.m0.a.p.b.a.c {

    /* loaded from: classes3.dex */
    public class a implements a.d {

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ b.j f51461a;

        public a(j jVar, b.j jVar2) {
            this.f51461a = jVar2;
        }

        @Override // d.a.m0.h.b.a.d
        public void onFail(String str) {
            b.j jVar = this.f51461a;
            if (jVar != null) {
                jVar.onFail(str);
            }
        }

        @Override // d.a.m0.h.b.a.d
        public void onSuccess() {
            b.j jVar = this.f51461a;
            if (jVar != null) {
                jVar.onSuccess();
            }
        }
    }

    @Override // d.a.m0.a.p.b.a.c
    public void a(String str, b.j jVar) {
        d.a.m0.h.b.d.p().j(str, new a(this, jVar));
    }
}
