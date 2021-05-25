package d.a.l0.a.w1;

import android.os.Bundle;
import com.baidu.swan.apps.media.chooser.model.MediaModel;
import com.baidu.swan.apps.publisher.ReplyEditorParams;
import d.a.l0.a.h0.g.f;
import java.lang.ref.WeakReference;
/* loaded from: classes3.dex */
public class e {

    /* renamed from: c  reason: collision with root package name */
    public static e f45558c;

    /* renamed from: a  reason: collision with root package name */
    public b f45559a;

    /* renamed from: b  reason: collision with root package name */
    public WeakReference<d> f45560b;

    /* loaded from: classes3.dex */
    public class b {

        /* renamed from: a  reason: collision with root package name */
        public WeakReference<d.a.l0.a.a2.e> f45561a;

        /* renamed from: b  reason: collision with root package name */
        public WeakReference<f> f45562b;

        /* renamed from: c  reason: collision with root package name */
        public String f45563c;

        /* renamed from: d  reason: collision with root package name */
        public MediaModel f45564d;

        public b(e eVar) {
        }
    }

    public static e c() {
        if (f45558c == null) {
            synchronized (e.class) {
                if (f45558c == null) {
                    f45558c = new e();
                }
            }
        }
        return f45558c;
    }

    public void a() {
        this.f45559a = null;
    }

    public boolean b() {
        d dVar = this.f45560b.get();
        if (dVar != null) {
            dVar.C1();
            return true;
        }
        return false;
    }

    public void d(String str, MediaModel mediaModel) {
        d.a.l0.a.a2.e i2 = d.a.l0.a.a2.e.i();
        f J = d.a.l0.a.g1.f.V().J();
        if (i2 != null && J != null) {
            b bVar = new b();
            this.f45559a = bVar;
            bVar.f45561a = new WeakReference<>(i2);
            this.f45559a.f45562b = new WeakReference<>(J);
            b bVar2 = this.f45559a;
            bVar2.f45563c = str;
            bVar2.f45564d = mediaModel;
            return;
        }
        this.f45559a = null;
    }

    public void e(d.a.l0.a.a2.e eVar, ReplyEditorParams replyEditorParams, d.a.l0.a.w1.a aVar) {
        f J = d.a.l0.a.g1.f.V().J();
        if (J == null || eVar == null) {
            return;
        }
        Bundle bundle = new Bundle();
        bundle.putParcelable("params", replyEditorParams);
        b bVar = this.f45559a;
        if (bVar != null && eVar == bVar.f45561a.get() && J == this.f45559a.f45562b.get()) {
            bundle.putBoolean("draft", true);
            bundle.putString("content", this.f45559a.f45563c);
            bundle.putParcelable("image", this.f45559a.f45564d);
        }
        d dVar = new d();
        dVar.j1(bundle);
        dVar.P1(aVar);
        dVar.t1(J.u(), "ReplyEditor");
        this.f45560b = new WeakReference<>(dVar);
    }
}
