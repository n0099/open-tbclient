package d.a.m0.a.w1;

import android.os.Bundle;
import com.baidu.swan.apps.media.chooser.model.MediaModel;
import com.baidu.swan.apps.publisher.ReplyEditorParams;
import d.a.m0.a.h0.g.f;
import java.lang.ref.WeakReference;
/* loaded from: classes3.dex */
public class e {

    /* renamed from: c  reason: collision with root package name */
    public static e f49340c;

    /* renamed from: a  reason: collision with root package name */
    public b f49341a;

    /* renamed from: b  reason: collision with root package name */
    public WeakReference<d> f49342b;

    /* loaded from: classes3.dex */
    public class b {

        /* renamed from: a  reason: collision with root package name */
        public WeakReference<d.a.m0.a.a2.e> f49343a;

        /* renamed from: b  reason: collision with root package name */
        public WeakReference<f> f49344b;

        /* renamed from: c  reason: collision with root package name */
        public String f49345c;

        /* renamed from: d  reason: collision with root package name */
        public MediaModel f49346d;

        public b(e eVar) {
        }
    }

    public static e c() {
        if (f49340c == null) {
            synchronized (e.class) {
                if (f49340c == null) {
                    f49340c = new e();
                }
            }
        }
        return f49340c;
    }

    public void a() {
        this.f49341a = null;
    }

    public boolean b() {
        d dVar = this.f49342b.get();
        if (dVar != null) {
            dVar.C1();
            return true;
        }
        return false;
    }

    public void d(String str, MediaModel mediaModel) {
        d.a.m0.a.a2.e i2 = d.a.m0.a.a2.e.i();
        f J = d.a.m0.a.g1.f.V().J();
        if (i2 != null && J != null) {
            b bVar = new b();
            this.f49341a = bVar;
            bVar.f49343a = new WeakReference<>(i2);
            this.f49341a.f49344b = new WeakReference<>(J);
            b bVar2 = this.f49341a;
            bVar2.f49345c = str;
            bVar2.f49346d = mediaModel;
            return;
        }
        this.f49341a = null;
    }

    public void e(d.a.m0.a.a2.e eVar, ReplyEditorParams replyEditorParams, d.a.m0.a.w1.a aVar) {
        f J = d.a.m0.a.g1.f.V().J();
        if (J == null || eVar == null) {
            return;
        }
        Bundle bundle = new Bundle();
        bundle.putParcelable("params", replyEditorParams);
        b bVar = this.f49341a;
        if (bVar != null && eVar == bVar.f49343a.get() && J == this.f49341a.f49344b.get()) {
            bundle.putBoolean("draft", true);
            bundle.putString("content", this.f49341a.f49345c);
            bundle.putParcelable("image", this.f49341a.f49346d);
        }
        d dVar = new d();
        dVar.j1(bundle);
        dVar.P1(aVar);
        dVar.t1(J.u(), "ReplyEditor");
        this.f49342b = new WeakReference<>(dVar);
    }
}
