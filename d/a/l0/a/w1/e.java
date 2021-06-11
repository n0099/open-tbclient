package d.a.l0.a.w1;

import android.os.Bundle;
import com.baidu.swan.apps.media.chooser.model.MediaModel;
import com.baidu.swan.apps.publisher.ReplyEditorParams;
import d.a.l0.a.h0.g.f;
import java.lang.ref.WeakReference;
/* loaded from: classes3.dex */
public class e {

    /* renamed from: c  reason: collision with root package name */
    public static e f49232c;

    /* renamed from: a  reason: collision with root package name */
    public b f49233a;

    /* renamed from: b  reason: collision with root package name */
    public WeakReference<d> f49234b;

    /* loaded from: classes3.dex */
    public class b {

        /* renamed from: a  reason: collision with root package name */
        public WeakReference<d.a.l0.a.a2.e> f49235a;

        /* renamed from: b  reason: collision with root package name */
        public WeakReference<f> f49236b;

        /* renamed from: c  reason: collision with root package name */
        public String f49237c;

        /* renamed from: d  reason: collision with root package name */
        public MediaModel f49238d;

        public b(e eVar) {
        }
    }

    public static e c() {
        if (f49232c == null) {
            synchronized (e.class) {
                if (f49232c == null) {
                    f49232c = new e();
                }
            }
        }
        return f49232c;
    }

    public void a() {
        this.f49233a = null;
    }

    public boolean b() {
        d dVar = this.f49234b.get();
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
            this.f49233a = bVar;
            bVar.f49235a = new WeakReference<>(i2);
            this.f49233a.f49236b = new WeakReference<>(J);
            b bVar2 = this.f49233a;
            bVar2.f49237c = str;
            bVar2.f49238d = mediaModel;
            return;
        }
        this.f49233a = null;
    }

    public void e(d.a.l0.a.a2.e eVar, ReplyEditorParams replyEditorParams, d.a.l0.a.w1.a aVar) {
        f J = d.a.l0.a.g1.f.V().J();
        if (J == null || eVar == null) {
            return;
        }
        Bundle bundle = new Bundle();
        bundle.putParcelable("params", replyEditorParams);
        b bVar = this.f49233a;
        if (bVar != null && eVar == bVar.f49235a.get() && J == this.f49233a.f49236b.get()) {
            bundle.putBoolean("draft", true);
            bundle.putString("content", this.f49233a.f49237c);
            bundle.putParcelable("image", this.f49233a.f49238d);
        }
        d dVar = new d();
        dVar.j1(bundle);
        dVar.P1(aVar);
        dVar.t1(J.u(), "ReplyEditor");
        this.f49234b = new WeakReference<>(dVar);
    }
}
