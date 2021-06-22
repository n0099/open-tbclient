package d.a.o0.f3;

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
import d.a.o0.d3.c;
import d.a.o0.f3.c.a;
import d.a.o0.f3.d.a;
/* loaded from: classes5.dex */
public class a implements d.a.n0.w0.a {

    /* renamed from: a  reason: collision with root package name */
    public Context f58679a;

    /* renamed from: b  reason: collision with root package name */
    public final d.a.o0.f3.d.a f58680b;

    /* renamed from: c  reason: collision with root package name */
    public d.a.n0.w0.b f58681c;

    /* renamed from: d  reason: collision with root package name */
    public final d.a.o0.f3.c.a f58682d;

    /* renamed from: e  reason: collision with root package name */
    public final Handler f58683e = new Handler();

    /* renamed from: f  reason: collision with root package name */
    public boolean f58684f = true;

    /* renamed from: g  reason: collision with root package name */
    public a.c f58685g = new C1394a();

    /* renamed from: h  reason: collision with root package name */
    public a.d f58686h = new b();

    /* renamed from: d.a.o0.f3.a$a  reason: collision with other inner class name */
    /* loaded from: classes5.dex */
    public class C1394a implements a.c {

        /* renamed from: d.a.o0.f3.a$a$a  reason: collision with other inner class name */
        /* loaded from: classes5.dex */
        public class RunnableC1395a implements Runnable {
            public RunnableC1395a() {
            }

            @Override // java.lang.Runnable
            public void run() {
                if (j.z() && j.H()) {
                    a.this.f58682d.g();
                }
            }
        }

        public C1394a() {
        }

        @Override // d.a.o0.f3.c.a.c
        public void a() {
            if (a.this.f58684f && a.this.f58681c != null) {
                a.this.f58681c.a();
            }
        }

        @Override // d.a.o0.f3.c.a.c
        public void b(d.a.o0.f3.b.a aVar) {
            if (j.z()) {
                a.this.f58682d.e();
            } else if (a.this.f58681c != null) {
                a.this.f58681c.a();
            }
            if (a.this.f58684f) {
                a.this.f58683e.postDelayed(new RunnableC1395a(), 800L);
            } else if (j.z() && j.H()) {
                a.this.f58682d.g();
            }
        }

        @Override // d.a.o0.f3.c.a.c
        public void c(Object obj) {
            d.a.o0.f3.b.b c2;
            if (!a.this.f58684f || (c2 = a.this.f58682d.c()) == null) {
                return;
            }
            StatisticItem h2 = d.a.o0.d3.a.h("a064", "common_fill", true, 1);
            if (d.a.c.a.j.a(a.this.f58679a) != null) {
                c.g().c(d.a.c.a.j.a(a.this.f58679a).getUniqueId(), h2);
            }
            a.this.f58680b.f(obj, ((int) c2.f58695c) / 1000);
            if (a.this.f58681c != null) {
                a.this.f58681c.c(String.valueOf(c2.f58693a), c2.c(), c2.a());
            }
        }
    }

    /* loaded from: classes5.dex */
    public class b implements a.d {

        /* renamed from: d.a.o0.f3.a$b$a  reason: collision with other inner class name */
        /* loaded from: classes5.dex */
        public class RunnableC1396a implements Runnable {

            /* renamed from: e  reason: collision with root package name */
            public final /* synthetic */ String f58690e;

            public RunnableC1396a(b bVar, String str) {
                this.f58690e = str;
            }

            @Override // java.lang.Runnable
            public void run() {
                UrlManager.getInstance().dealOneLink((TbPageContext) d.a.c.a.j.a(d.a.c.a.b.f().b()), new String[]{this.f58690e}, true);
            }
        }

        public b() {
        }

        @Override // d.a.o0.f3.d.a.d
        public void a() {
            d.a.o0.f3.b.b c2 = a.this.f58682d.c();
            if (c2 != null) {
                if (a.this.f58681c != null) {
                    a.this.f58681c.b(String.valueOf(c2.f58693a), c2.c());
                }
                if (TextUtils.isEmpty(c2.f58698f)) {
                    return;
                }
                if (!a.this.j(c2.f58698f)) {
                    UrlManager.getInstance().dealOneLink((TbPageContext) d.a.c.a.j.a(a.this.f58679a), new String[]{c2.f58698f}, true);
                } else {
                    e.a().postDelayed(new RunnableC1396a(this, c2.f58698f), 500L);
                }
            }
        }

        @Override // d.a.o0.f3.d.a.d
        public void b() {
            boolean z = false;
            if (a.this.getView() != null) {
                if (a.this.getView().getHeight() == l.i(a.this.getView().getContext())) {
                    z = true;
                }
            }
            TiebaStatic.log(new StatisticItem(TbadkCoreStatisticKey.KEY_VIDEO_SPLASH_SKIP).param("obj_source", 2).param("obj_type", z ? 2 : 1));
            if (a.this.f58681c != null) {
                a.this.f58681c.onAdDismiss();
            }
        }
    }

    public a(Context context) {
        this.f58679a = context;
        d.a.o0.f3.c.a aVar = new d.a.o0.f3.c.a();
        this.f58682d = aVar;
        aVar.h(this.f58685g);
        this.f58680b = new d.a.o0.f3.d.a(context, this.f58686h);
    }

    @Override // d.a.n0.w0.a
    public void a() {
        this.f58682d.d();
    }

    @Override // d.a.n0.w0.a
    public void b(d.a.n0.w0.b bVar) {
        this.f58681c = bVar;
    }

    @Override // d.a.n0.w0.a
    public View getView() {
        return this.f58680b.b();
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

    @Override // d.a.n0.w0.a
    public void release() {
        this.f58684f = false;
        this.f58683e.removeCallbacksAndMessages(null);
    }
}
