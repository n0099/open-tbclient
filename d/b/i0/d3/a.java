package d.b.i0.d3;

import android.content.Context;
import android.os.Handler;
import android.text.TextUtils;
import android.view.View;
import com.baidu.permissionhelper.context.ContextCompat;
import com.baidu.tbadk.TbPageContext;
import com.baidu.tbadk.core.util.StatisticItem;
import com.baidu.tbadk.core.util.UrlManager;
import com.kwad.sdk.core.imageloader.utils.StorageUtils;
import d.b.b.e.m.e;
import d.b.b.e.p.j;
import d.b.i0.b3.c;
import d.b.i0.d3.c.a;
import d.b.i0.d3.d.a;
/* loaded from: classes5.dex */
public class a implements d.b.h0.w0.a {

    /* renamed from: a  reason: collision with root package name */
    public Context f54151a;

    /* renamed from: b  reason: collision with root package name */
    public final d.b.i0.d3.d.a f54152b;

    /* renamed from: c  reason: collision with root package name */
    public d.b.h0.w0.b f54153c;

    /* renamed from: d  reason: collision with root package name */
    public final d.b.i0.d3.c.a f54154d;

    /* renamed from: e  reason: collision with root package name */
    public final Handler f54155e = new Handler();

    /* renamed from: f  reason: collision with root package name */
    public boolean f54156f = true;

    /* renamed from: g  reason: collision with root package name */
    public a.c f54157g = new C1219a();

    /* renamed from: h  reason: collision with root package name */
    public a.d f54158h = new b();

    /* renamed from: d.b.i0.d3.a$a  reason: collision with other inner class name */
    /* loaded from: classes5.dex */
    public class C1219a implements a.c {

        /* renamed from: d.b.i0.d3.a$a$a  reason: collision with other inner class name */
        /* loaded from: classes5.dex */
        public class RunnableC1220a implements Runnable {
            public RunnableC1220a() {
            }

            @Override // java.lang.Runnable
            public void run() {
                if (j.z() && j.H()) {
                    a.this.f54154d.g();
                }
            }
        }

        public C1219a() {
        }

        @Override // d.b.i0.d3.c.a.c
        public void a() {
            if (a.this.f54156f && a.this.f54153c != null) {
                a.this.f54153c.b();
            }
        }

        @Override // d.b.i0.d3.c.a.c
        public void b(Object obj) {
            d.b.i0.d3.b.b c2;
            if (!a.this.f54156f || (c2 = a.this.f54154d.c()) == null) {
                return;
            }
            StatisticItem h2 = d.b.i0.b3.a.h("a064", "common_fill", true, 1);
            if (d.b.b.a.j.a(a.this.f54151a) != null) {
                c.g().c(d.b.b.a.j.a(a.this.f54151a).getUniqueId(), h2);
            }
            a.this.f54152b.f(obj, ((int) c2.f54167c) / 1000);
            if (a.this.f54153c != null) {
                a.this.f54153c.a(String.valueOf(c2.f54165a), c2.c(), c2.a());
            }
        }

        @Override // d.b.i0.d3.c.a.c
        public void c(d.b.i0.d3.b.a aVar) {
            if (j.z()) {
                a.this.f54154d.e();
            } else if (a.this.f54153c != null) {
                a.this.f54153c.b();
            }
            if (a.this.f54156f) {
                a.this.f54155e.postDelayed(new RunnableC1220a(), 800L);
            } else if (j.z() && j.H()) {
                a.this.f54154d.g();
            }
        }
    }

    /* loaded from: classes5.dex */
    public class b implements a.d {

        /* renamed from: d.b.i0.d3.a$b$a  reason: collision with other inner class name */
        /* loaded from: classes5.dex */
        public class RunnableC1221a implements Runnable {

            /* renamed from: e  reason: collision with root package name */
            public final /* synthetic */ String f54162e;

            public RunnableC1221a(b bVar, String str) {
                this.f54162e = str;
            }

            @Override // java.lang.Runnable
            public void run() {
                UrlManager.getInstance().dealOneLink((TbPageContext) d.b.b.a.j.a(d.b.b.a.b.f().b()), new String[]{this.f54162e}, true);
            }
        }

        public b() {
        }

        @Override // d.b.i0.d3.d.a.d
        public void a() {
            d.b.i0.d3.b.b c2 = a.this.f54154d.c();
            if (c2 != null) {
                if (a.this.f54153c != null) {
                    a.this.f54153c.c(String.valueOf(c2.f54165a), c2.c());
                }
                if (TextUtils.isEmpty(c2.f54170f)) {
                    return;
                }
                if (!a.this.j(c2.f54170f)) {
                    UrlManager.getInstance().dealOneLink((TbPageContext) d.b.b.a.j.a(a.this.f54151a), new String[]{c2.f54170f}, true);
                } else {
                    e.a().postDelayed(new RunnableC1221a(this, c2.f54170f), 500L);
                }
            }
        }

        @Override // d.b.i0.d3.d.a.d
        public void b() {
            if (a.this.f54153c != null) {
                a.this.f54153c.onAdDismiss();
            }
        }
    }

    public a(Context context) {
        this.f54151a = context;
        d.b.i0.d3.c.a aVar = new d.b.i0.d3.c.a();
        this.f54154d = aVar;
        aVar.h(this.f54157g);
        this.f54152b = new d.b.i0.d3.d.a(context, this.f54158h);
    }

    @Override // d.b.h0.w0.a
    public void a() {
        this.f54154d.d();
    }

    @Override // d.b.h0.w0.a
    public void b(d.b.h0.w0.b bVar) {
        this.f54153c = bVar;
    }

    @Override // d.b.h0.w0.a
    public View getView() {
        return this.f54152b.b();
    }

    public final boolean j(String str) {
        if (TextUtils.isEmpty(str)) {
            return false;
        }
        if (str.contains("/swan/") || str.contains("/swangame/")) {
            return !ContextCompat.checkPermissionGranted(d.b.b.a.b.f().b(), StorageUtils.EXTERNAL_STORAGE_PERMISSION);
        }
        return false;
    }

    @Override // d.b.h0.w0.a
    public void release() {
        this.f54156f = false;
        this.f54155e.removeCallbacksAndMessages(null);
    }
}
