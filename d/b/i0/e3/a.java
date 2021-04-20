package d.b.i0.e3;

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
import d.b.i0.c3.c;
import d.b.i0.e3.c.a;
import d.b.i0.e3.d.a;
/* loaded from: classes5.dex */
public class a implements d.b.h0.w0.a {

    /* renamed from: a  reason: collision with root package name */
    public Context f55673a;

    /* renamed from: b  reason: collision with root package name */
    public final d.b.i0.e3.d.a f55674b;

    /* renamed from: c  reason: collision with root package name */
    public d.b.h0.w0.b f55675c;

    /* renamed from: d  reason: collision with root package name */
    public final d.b.i0.e3.c.a f55676d;

    /* renamed from: e  reason: collision with root package name */
    public final Handler f55677e = new Handler();

    /* renamed from: f  reason: collision with root package name */
    public boolean f55678f = true;

    /* renamed from: g  reason: collision with root package name */
    public a.c f55679g = new C1282a();

    /* renamed from: h  reason: collision with root package name */
    public a.d f55680h = new b();

    /* renamed from: d.b.i0.e3.a$a  reason: collision with other inner class name */
    /* loaded from: classes5.dex */
    public class C1282a implements a.c {

        /* renamed from: d.b.i0.e3.a$a$a  reason: collision with other inner class name */
        /* loaded from: classes5.dex */
        public class RunnableC1283a implements Runnable {
            public RunnableC1283a() {
            }

            @Override // java.lang.Runnable
            public void run() {
                if (j.z() && j.H()) {
                    a.this.f55676d.g();
                }
            }
        }

        public C1282a() {
        }

        @Override // d.b.i0.e3.c.a.c
        public void a() {
            if (a.this.f55678f && a.this.f55675c != null) {
                a.this.f55675c.b();
            }
        }

        @Override // d.b.i0.e3.c.a.c
        public void b(Object obj) {
            d.b.i0.e3.b.b c2;
            if (!a.this.f55678f || (c2 = a.this.f55676d.c()) == null) {
                return;
            }
            StatisticItem h2 = d.b.i0.c3.a.h("a064", "common_fill", true, 1);
            if (d.b.c.a.j.a(a.this.f55673a) != null) {
                c.g().c(d.b.c.a.j.a(a.this.f55673a).getUniqueId(), h2);
            }
            a.this.f55674b.f(obj, ((int) c2.f55689c) / 1000);
            if (a.this.f55675c != null) {
                a.this.f55675c.a(String.valueOf(c2.f55687a), c2.c(), c2.a());
            }
        }

        @Override // d.b.i0.e3.c.a.c
        public void c(d.b.i0.e3.b.a aVar) {
            if (j.z()) {
                a.this.f55676d.e();
            } else if (a.this.f55675c != null) {
                a.this.f55675c.b();
            }
            if (a.this.f55678f) {
                a.this.f55677e.postDelayed(new RunnableC1283a(), 800L);
            } else if (j.z() && j.H()) {
                a.this.f55676d.g();
            }
        }
    }

    /* loaded from: classes5.dex */
    public class b implements a.d {

        /* renamed from: d.b.i0.e3.a$b$a  reason: collision with other inner class name */
        /* loaded from: classes5.dex */
        public class RunnableC1284a implements Runnable {

            /* renamed from: e  reason: collision with root package name */
            public final /* synthetic */ String f55684e;

            public RunnableC1284a(b bVar, String str) {
                this.f55684e = str;
            }

            @Override // java.lang.Runnable
            public void run() {
                UrlManager.getInstance().dealOneLink((TbPageContext) d.b.c.a.j.a(d.b.c.a.b.f().b()), new String[]{this.f55684e}, true);
            }
        }

        public b() {
        }

        @Override // d.b.i0.e3.d.a.d
        public void a() {
            d.b.i0.e3.b.b c2 = a.this.f55676d.c();
            if (c2 != null) {
                if (a.this.f55675c != null) {
                    a.this.f55675c.c(String.valueOf(c2.f55687a), c2.c());
                }
                if (TextUtils.isEmpty(c2.f55692f)) {
                    return;
                }
                if (!a.this.j(c2.f55692f)) {
                    UrlManager.getInstance().dealOneLink((TbPageContext) d.b.c.a.j.a(a.this.f55673a), new String[]{c2.f55692f}, true);
                } else {
                    e.a().postDelayed(new RunnableC1284a(this, c2.f55692f), 500L);
                }
            }
        }

        @Override // d.b.i0.e3.d.a.d
        public void b() {
            boolean z = false;
            if (a.this.getView() != null) {
                if (a.this.getView().getHeight() == l.i(a.this.getView().getContext())) {
                    z = true;
                }
            }
            TiebaStatic.log(new StatisticItem(TbadkCoreStatisticKey.KEY_VIDEO_SPLASH_SKIP).param("obj_source", 2).param("obj_type", z ? 2 : 1));
            if (a.this.f55675c != null) {
                a.this.f55675c.onAdDismiss();
            }
        }
    }

    public a(Context context) {
        this.f55673a = context;
        d.b.i0.e3.c.a aVar = new d.b.i0.e3.c.a();
        this.f55676d = aVar;
        aVar.h(this.f55679g);
        this.f55674b = new d.b.i0.e3.d.a(context, this.f55680h);
    }

    @Override // d.b.h0.w0.a
    public void a() {
        this.f55676d.d();
    }

    @Override // d.b.h0.w0.a
    public void b(d.b.h0.w0.b bVar) {
        this.f55675c = bVar;
    }

    @Override // d.b.h0.w0.a
    public View getView() {
        return this.f55674b.b();
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

    @Override // d.b.h0.w0.a
    public void release() {
        this.f55678f = false;
        this.f55677e.removeCallbacksAndMessages(null);
    }
}
