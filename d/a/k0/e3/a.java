package d.a.k0.e3;

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
import d.a.k0.c3.c;
import d.a.k0.e3.c.a;
import d.a.k0.e3.d.a;
/* loaded from: classes5.dex */
public class a implements d.a.j0.w0.a {

    /* renamed from: a  reason: collision with root package name */
    public Context f54675a;

    /* renamed from: b  reason: collision with root package name */
    public final d.a.k0.e3.d.a f54676b;

    /* renamed from: c  reason: collision with root package name */
    public d.a.j0.w0.b f54677c;

    /* renamed from: d  reason: collision with root package name */
    public final d.a.k0.e3.c.a f54678d;

    /* renamed from: e  reason: collision with root package name */
    public final Handler f54679e = new Handler();

    /* renamed from: f  reason: collision with root package name */
    public boolean f54680f = true;

    /* renamed from: g  reason: collision with root package name */
    public a.c f54681g = new C1316a();

    /* renamed from: h  reason: collision with root package name */
    public a.d f54682h = new b();

    /* renamed from: d.a.k0.e3.a$a  reason: collision with other inner class name */
    /* loaded from: classes5.dex */
    public class C1316a implements a.c {

        /* renamed from: d.a.k0.e3.a$a$a  reason: collision with other inner class name */
        /* loaded from: classes5.dex */
        public class RunnableC1317a implements Runnable {
            public RunnableC1317a() {
            }

            @Override // java.lang.Runnable
            public void run() {
                if (j.z() && j.H()) {
                    a.this.f54678d.g();
                }
            }
        }

        public C1316a() {
        }

        @Override // d.a.k0.e3.c.a.c
        public void a() {
            if (a.this.f54680f && a.this.f54677c != null) {
                a.this.f54677c.a();
            }
        }

        @Override // d.a.k0.e3.c.a.c
        public void b(d.a.k0.e3.b.a aVar) {
            if (j.z()) {
                a.this.f54678d.e();
            } else if (a.this.f54677c != null) {
                a.this.f54677c.a();
            }
            if (a.this.f54680f) {
                a.this.f54679e.postDelayed(new RunnableC1317a(), 800L);
            } else if (j.z() && j.H()) {
                a.this.f54678d.g();
            }
        }

        @Override // d.a.k0.e3.c.a.c
        public void c(Object obj) {
            d.a.k0.e3.b.b c2;
            if (!a.this.f54680f || (c2 = a.this.f54678d.c()) == null) {
                return;
            }
            StatisticItem h2 = d.a.k0.c3.a.h("a064", "common_fill", true, 1);
            if (d.a.c.a.j.a(a.this.f54675a) != null) {
                c.g().c(d.a.c.a.j.a(a.this.f54675a).getUniqueId(), h2);
            }
            a.this.f54676b.f(obj, ((int) c2.f54691c) / 1000);
            if (a.this.f54677c != null) {
                a.this.f54677c.c(String.valueOf(c2.f54689a), c2.c(), c2.a());
            }
        }
    }

    /* loaded from: classes5.dex */
    public class b implements a.d {

        /* renamed from: d.a.k0.e3.a$b$a  reason: collision with other inner class name */
        /* loaded from: classes5.dex */
        public class RunnableC1318a implements Runnable {

            /* renamed from: e  reason: collision with root package name */
            public final /* synthetic */ String f54686e;

            public RunnableC1318a(b bVar, String str) {
                this.f54686e = str;
            }

            @Override // java.lang.Runnable
            public void run() {
                UrlManager.getInstance().dealOneLink((TbPageContext) d.a.c.a.j.a(d.a.c.a.b.f().b()), new String[]{this.f54686e}, true);
            }
        }

        public b() {
        }

        @Override // d.a.k0.e3.d.a.d
        public void a() {
            d.a.k0.e3.b.b c2 = a.this.f54678d.c();
            if (c2 != null) {
                if (a.this.f54677c != null) {
                    a.this.f54677c.b(String.valueOf(c2.f54689a), c2.c());
                }
                if (TextUtils.isEmpty(c2.f54694f)) {
                    return;
                }
                if (!a.this.j(c2.f54694f)) {
                    UrlManager.getInstance().dealOneLink((TbPageContext) d.a.c.a.j.a(a.this.f54675a), new String[]{c2.f54694f}, true);
                } else {
                    e.a().postDelayed(new RunnableC1318a(this, c2.f54694f), 500L);
                }
            }
        }

        @Override // d.a.k0.e3.d.a.d
        public void b() {
            boolean z = false;
            if (a.this.getView() != null) {
                if (a.this.getView().getHeight() == l.i(a.this.getView().getContext())) {
                    z = true;
                }
            }
            TiebaStatic.log(new StatisticItem(TbadkCoreStatisticKey.KEY_VIDEO_SPLASH_SKIP).param("obj_source", 2).param("obj_type", z ? 2 : 1));
            if (a.this.f54677c != null) {
                a.this.f54677c.onAdDismiss();
            }
        }
    }

    public a(Context context) {
        this.f54675a = context;
        d.a.k0.e3.c.a aVar = new d.a.k0.e3.c.a();
        this.f54678d = aVar;
        aVar.h(this.f54681g);
        this.f54676b = new d.a.k0.e3.d.a(context, this.f54682h);
    }

    @Override // d.a.j0.w0.a
    public void a() {
        this.f54678d.d();
    }

    @Override // d.a.j0.w0.a
    public void b(d.a.j0.w0.b bVar) {
        this.f54677c = bVar;
    }

    @Override // d.a.j0.w0.a
    public View getView() {
        return this.f54676b.b();
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

    @Override // d.a.j0.w0.a
    public void release() {
        this.f54680f = false;
        this.f54679e.removeCallbacksAndMessages(null);
    }
}
