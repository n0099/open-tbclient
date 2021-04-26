package d.a.j0.e3;

import android.content.Context;
import android.os.Handler;
import android.text.TextUtils;
import android.view.View;
import com.baidu.permissionhelper.context.ContextCompat;
import com.baidu.tbadk.TbPageContext;
import com.baidu.tbadk.core.util.StatisticItem;
import com.baidu.tbadk.core.util.TbadkCoreStatisticKey;
import com.baidu.tbadk.core.util.TiebaStatic;
import com.baidu.tbadk.core.util.UrlManager;
import com.kwad.sdk.core.imageloader.utils.StorageUtils;
import d.a.c.e.m.e;
import d.a.c.e.p.j;
import d.a.c.e.p.l;
import d.a.j0.c3.c;
import d.a.j0.e3.c.a;
import d.a.j0.e3.d.a;
/* loaded from: classes5.dex */
public class a implements d.a.i0.w0.a {

    /* renamed from: a  reason: collision with root package name */
    public Context f53968a;

    /* renamed from: b  reason: collision with root package name */
    public final d.a.j0.e3.d.a f53969b;

    /* renamed from: c  reason: collision with root package name */
    public d.a.i0.w0.b f53970c;

    /* renamed from: d  reason: collision with root package name */
    public final d.a.j0.e3.c.a f53971d;

    /* renamed from: e  reason: collision with root package name */
    public final Handler f53972e = new Handler();

    /* renamed from: f  reason: collision with root package name */
    public boolean f53973f = true;

    /* renamed from: g  reason: collision with root package name */
    public a.c f53974g = new C1244a();

    /* renamed from: h  reason: collision with root package name */
    public a.d f53975h = new b();

    /* renamed from: d.a.j0.e3.a$a  reason: collision with other inner class name */
    /* loaded from: classes5.dex */
    public class C1244a implements a.c {

        /* renamed from: d.a.j0.e3.a$a$a  reason: collision with other inner class name */
        /* loaded from: classes5.dex */
        public class RunnableC1245a implements Runnable {
            public RunnableC1245a() {
            }

            @Override // java.lang.Runnable
            public void run() {
                if (j.z() && j.H()) {
                    a.this.f53971d.g();
                }
            }
        }

        public C1244a() {
        }

        @Override // d.a.j0.e3.c.a.c
        public void a() {
            if (a.this.f53973f && a.this.f53970c != null) {
                a.this.f53970c.a();
            }
        }

        @Override // d.a.j0.e3.c.a.c
        public void b(d.a.j0.e3.b.a aVar) {
            if (j.z()) {
                a.this.f53971d.e();
            } else if (a.this.f53970c != null) {
                a.this.f53970c.a();
            }
            if (a.this.f53973f) {
                a.this.f53972e.postDelayed(new RunnableC1245a(), 800L);
            } else if (j.z() && j.H()) {
                a.this.f53971d.g();
            }
        }

        @Override // d.a.j0.e3.c.a.c
        public void c(Object obj) {
            d.a.j0.e3.b.b c2;
            if (!a.this.f53973f || (c2 = a.this.f53971d.c()) == null) {
                return;
            }
            StatisticItem h2 = d.a.j0.c3.a.h("a064", "common_fill", true, 1);
            if (d.a.c.a.j.a(a.this.f53968a) != null) {
                c.g().c(d.a.c.a.j.a(a.this.f53968a).getUniqueId(), h2);
            }
            a.this.f53969b.f(obj, ((int) c2.f53984c) / 1000);
            if (a.this.f53970c != null) {
                a.this.f53970c.c(String.valueOf(c2.f53982a), c2.c(), c2.a());
            }
        }
    }

    /* loaded from: classes5.dex */
    public class b implements a.d {

        /* renamed from: d.a.j0.e3.a$b$a  reason: collision with other inner class name */
        /* loaded from: classes5.dex */
        public class RunnableC1246a implements Runnable {

            /* renamed from: e  reason: collision with root package name */
            public final /* synthetic */ String f53979e;

            public RunnableC1246a(b bVar, String str) {
                this.f53979e = str;
            }

            @Override // java.lang.Runnable
            public void run() {
                UrlManager.getInstance().dealOneLink((TbPageContext) d.a.c.a.j.a(d.a.c.a.b.f().b()), new String[]{this.f53979e}, true);
            }
        }

        public b() {
        }

        @Override // d.a.j0.e3.d.a.d
        public void a() {
            d.a.j0.e3.b.b c2 = a.this.f53971d.c();
            if (c2 != null) {
                if (a.this.f53970c != null) {
                    a.this.f53970c.b(String.valueOf(c2.f53982a), c2.c());
                }
                if (TextUtils.isEmpty(c2.f53987f)) {
                    return;
                }
                if (!a.this.j(c2.f53987f)) {
                    UrlManager.getInstance().dealOneLink((TbPageContext) d.a.c.a.j.a(a.this.f53968a), new String[]{c2.f53987f}, true);
                } else {
                    e.a().postDelayed(new RunnableC1246a(this, c2.f53987f), 500L);
                }
            }
        }

        @Override // d.a.j0.e3.d.a.d
        public void b() {
            boolean z = false;
            if (a.this.getView() != null) {
                if (a.this.getView().getHeight() == l.i(a.this.getView().getContext())) {
                    z = true;
                }
            }
            TiebaStatic.log(new StatisticItem(TbadkCoreStatisticKey.KEY_VIDEO_SPLASH_SKIP).param("obj_source", 2).param("obj_type", z ? 2 : 1));
            if (a.this.f53970c != null) {
                a.this.f53970c.onAdDismiss();
            }
        }
    }

    public a(Context context) {
        this.f53968a = context;
        d.a.j0.e3.c.a aVar = new d.a.j0.e3.c.a();
        this.f53971d = aVar;
        aVar.h(this.f53974g);
        this.f53969b = new d.a.j0.e3.d.a(context, this.f53975h);
    }

    @Override // d.a.i0.w0.a
    public void a() {
        this.f53971d.d();
    }

    @Override // d.a.i0.w0.a
    public void b(d.a.i0.w0.b bVar) {
        this.f53970c = bVar;
    }

    @Override // d.a.i0.w0.a
    public View getView() {
        return this.f53969b.b();
    }

    public final boolean j(String str) {
        if (TextUtils.isEmpty(str)) {
            return false;
        }
        if (str.contains("/swan/") || str.contains("/swangame/")) {
            return !ContextCompat.checkPermissionGranted(d.a.c.a.b.f().b(), StorageUtils.EXTERNAL_STORAGE_PERMISSION);
        }
        return false;
    }

    @Override // d.a.i0.w0.a
    public void release() {
        this.f53973f = false;
        this.f53972e.removeCallbacksAndMessages(null);
    }
}
