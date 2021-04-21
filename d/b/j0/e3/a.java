package d.b.j0.e3;

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
import d.b.c.e.m.e;
import d.b.c.e.p.j;
import d.b.c.e.p.l;
import d.b.j0.c3.c;
import d.b.j0.e3.c.a;
import d.b.j0.e3.d.a;
/* loaded from: classes5.dex */
public class a implements d.b.i0.w0.a {

    /* renamed from: a  reason: collision with root package name */
    public Context f56094a;

    /* renamed from: b  reason: collision with root package name */
    public final d.b.j0.e3.d.a f56095b;

    /* renamed from: c  reason: collision with root package name */
    public d.b.i0.w0.b f56096c;

    /* renamed from: d  reason: collision with root package name */
    public final d.b.j0.e3.c.a f56097d;

    /* renamed from: e  reason: collision with root package name */
    public final Handler f56098e = new Handler();

    /* renamed from: f  reason: collision with root package name */
    public boolean f56099f = true;

    /* renamed from: g  reason: collision with root package name */
    public a.c f56100g = new C1305a();

    /* renamed from: h  reason: collision with root package name */
    public a.d f56101h = new b();

    /* renamed from: d.b.j0.e3.a$a  reason: collision with other inner class name */
    /* loaded from: classes5.dex */
    public class C1305a implements a.c {

        /* renamed from: d.b.j0.e3.a$a$a  reason: collision with other inner class name */
        /* loaded from: classes5.dex */
        public class RunnableC1306a implements Runnable {
            public RunnableC1306a() {
            }

            @Override // java.lang.Runnable
            public void run() {
                if (j.z() && j.H()) {
                    a.this.f56097d.g();
                }
            }
        }

        public C1305a() {
        }

        @Override // d.b.j0.e3.c.a.c
        public void a() {
            if (a.this.f56099f && a.this.f56096c != null) {
                a.this.f56096c.b();
            }
        }

        @Override // d.b.j0.e3.c.a.c
        public void b(Object obj) {
            d.b.j0.e3.b.b c2;
            if (!a.this.f56099f || (c2 = a.this.f56097d.c()) == null) {
                return;
            }
            StatisticItem h2 = d.b.j0.c3.a.h("a064", "common_fill", true, 1);
            if (d.b.c.a.j.a(a.this.f56094a) != null) {
                c.g().c(d.b.c.a.j.a(a.this.f56094a).getUniqueId(), h2);
            }
            a.this.f56095b.f(obj, ((int) c2.f56110c) / 1000);
            if (a.this.f56096c != null) {
                a.this.f56096c.a(String.valueOf(c2.f56108a), c2.c(), c2.a());
            }
        }

        @Override // d.b.j0.e3.c.a.c
        public void c(d.b.j0.e3.b.a aVar) {
            if (j.z()) {
                a.this.f56097d.e();
            } else if (a.this.f56096c != null) {
                a.this.f56096c.b();
            }
            if (a.this.f56099f) {
                a.this.f56098e.postDelayed(new RunnableC1306a(), 800L);
            } else if (j.z() && j.H()) {
                a.this.f56097d.g();
            }
        }
    }

    /* loaded from: classes5.dex */
    public class b implements a.d {

        /* renamed from: d.b.j0.e3.a$b$a  reason: collision with other inner class name */
        /* loaded from: classes5.dex */
        public class RunnableC1307a implements Runnable {

            /* renamed from: e  reason: collision with root package name */
            public final /* synthetic */ String f56105e;

            public RunnableC1307a(b bVar, String str) {
                this.f56105e = str;
            }

            @Override // java.lang.Runnable
            public void run() {
                UrlManager.getInstance().dealOneLink((TbPageContext) d.b.c.a.j.a(d.b.c.a.b.f().b()), new String[]{this.f56105e}, true);
            }
        }

        public b() {
        }

        @Override // d.b.j0.e3.d.a.d
        public void a() {
            d.b.j0.e3.b.b c2 = a.this.f56097d.c();
            if (c2 != null) {
                if (a.this.f56096c != null) {
                    a.this.f56096c.c(String.valueOf(c2.f56108a), c2.c());
                }
                if (TextUtils.isEmpty(c2.f56113f)) {
                    return;
                }
                if (!a.this.j(c2.f56113f)) {
                    UrlManager.getInstance().dealOneLink((TbPageContext) d.b.c.a.j.a(a.this.f56094a), new String[]{c2.f56113f}, true);
                } else {
                    e.a().postDelayed(new RunnableC1307a(this, c2.f56113f), 500L);
                }
            }
        }

        @Override // d.b.j0.e3.d.a.d
        public void b() {
            boolean z = false;
            if (a.this.getView() != null) {
                if (a.this.getView().getHeight() == l.i(a.this.getView().getContext())) {
                    z = true;
                }
            }
            TiebaStatic.log(new StatisticItem(TbadkCoreStatisticKey.KEY_VIDEO_SPLASH_SKIP).param("obj_source", 2).param("obj_type", z ? 2 : 1));
            if (a.this.f56096c != null) {
                a.this.f56096c.onAdDismiss();
            }
        }
    }

    public a(Context context) {
        this.f56094a = context;
        d.b.j0.e3.c.a aVar = new d.b.j0.e3.c.a();
        this.f56097d = aVar;
        aVar.h(this.f56100g);
        this.f56095b = new d.b.j0.e3.d.a(context, this.f56101h);
    }

    @Override // d.b.i0.w0.a
    public void a() {
        this.f56097d.d();
    }

    @Override // d.b.i0.w0.a
    public void b(d.b.i0.w0.b bVar) {
        this.f56096c = bVar;
    }

    @Override // d.b.i0.w0.a
    public View getView() {
        return this.f56095b.b();
    }

    public final boolean j(String str) {
        if (TextUtils.isEmpty(str)) {
            return false;
        }
        if (str.contains("/swan/") || str.contains("/swangame/")) {
            return !ContextCompat.checkPermissionGranted(d.b.c.a.b.f().b(), StorageUtils.EXTERNAL_STORAGE_PERMISSION);
        }
        return false;
    }

    @Override // d.b.i0.w0.a
    public void release() {
        this.f56099f = false;
        this.f56098e.removeCallbacksAndMessages(null);
    }
}
