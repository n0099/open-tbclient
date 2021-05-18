package d.a.i0.a.w1;

import android.os.Bundle;
import com.baidu.swan.apps.media.chooser.model.MediaModel;
import com.baidu.swan.apps.publisher.ReplyEditorParams;
import d.a.i0.a.h0.g.f;
import java.lang.ref.WeakReference;
/* loaded from: classes3.dex */
public class e {

    /* renamed from: c  reason: collision with root package name */
    public static e f45382c;

    /* renamed from: a  reason: collision with root package name */
    public b f45383a;

    /* renamed from: b  reason: collision with root package name */
    public WeakReference<d> f45384b;

    /* loaded from: classes3.dex */
    public class b {

        /* renamed from: a  reason: collision with root package name */
        public WeakReference<d.a.i0.a.a2.e> f45385a;

        /* renamed from: b  reason: collision with root package name */
        public WeakReference<f> f45386b;

        /* renamed from: c  reason: collision with root package name */
        public String f45387c;

        /* renamed from: d  reason: collision with root package name */
        public MediaModel f45388d;

        public b(e eVar) {
        }
    }

    public static e c() {
        if (f45382c == null) {
            synchronized (e.class) {
                if (f45382c == null) {
                    f45382c = new e();
                }
            }
        }
        return f45382c;
    }

    public void a() {
        this.f45383a = null;
    }

    public boolean b() {
        d dVar = this.f45384b.get();
        if (dVar != null) {
            dVar.C1();
            return true;
        }
        return false;
    }

    public void d(String str, MediaModel mediaModel) {
        d.a.i0.a.a2.e i2 = d.a.i0.a.a2.e.i();
        f J = d.a.i0.a.g1.f.V().J();
        if (i2 != null && J != null) {
            b bVar = new b();
            this.f45383a = bVar;
            bVar.f45385a = new WeakReference<>(i2);
            this.f45383a.f45386b = new WeakReference<>(J);
            b bVar2 = this.f45383a;
            bVar2.f45387c = str;
            bVar2.f45388d = mediaModel;
            return;
        }
        this.f45383a = null;
    }

    public void e(d.a.i0.a.a2.e eVar, ReplyEditorParams replyEditorParams, d.a.i0.a.w1.a aVar) {
        f J = d.a.i0.a.g1.f.V().J();
        if (J == null || eVar == null) {
            return;
        }
        Bundle bundle = new Bundle();
        bundle.putParcelable("params", replyEditorParams);
        b bVar = this.f45383a;
        if (bVar != null && eVar == bVar.f45385a.get() && J == this.f45383a.f45386b.get()) {
            bundle.putBoolean("draft", true);
            bundle.putString("content", this.f45383a.f45387c);
            bundle.putParcelable("image", this.f45383a.f45388d);
        }
        d dVar = new d();
        dVar.j1(bundle);
        dVar.P1(aVar);
        dVar.t1(J.u(), "ReplyEditor");
        this.f45384b = new WeakReference<>(dVar);
    }
}
