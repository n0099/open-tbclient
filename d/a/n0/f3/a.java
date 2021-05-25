package d.a.n0.f3;

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
import d.a.n0.d3.c;
import d.a.n0.f3.c.a;
import d.a.n0.f3.d.a;
/* loaded from: classes5.dex */
public class a implements d.a.m0.w0.a {

    /* renamed from: a  reason: collision with root package name */
    public Context f54865a;

    /* renamed from: b  reason: collision with root package name */
    public final d.a.n0.f3.d.a f54866b;

    /* renamed from: c  reason: collision with root package name */
    public d.a.m0.w0.b f54867c;

    /* renamed from: d  reason: collision with root package name */
    public final d.a.n0.f3.c.a f54868d;

    /* renamed from: e  reason: collision with root package name */
    public final Handler f54869e = new Handler();

    /* renamed from: f  reason: collision with root package name */
    public boolean f54870f = true;

    /* renamed from: g  reason: collision with root package name */
    public a.c f54871g = new C1334a();

    /* renamed from: h  reason: collision with root package name */
    public a.d f54872h = new b();

    /* renamed from: d.a.n0.f3.a$a  reason: collision with other inner class name */
    /* loaded from: classes5.dex */
    public class C1334a implements a.c {

        /* renamed from: d.a.n0.f3.a$a$a  reason: collision with other inner class name */
        /* loaded from: classes5.dex */
        public class RunnableC1335a implements Runnable {
            public RunnableC1335a() {
            }

            @Override // java.lang.Runnable
            public void run() {
                if (j.z() && j.H()) {
                    a.this.f54868d.g();
                }
            }
        }

        public C1334a() {
        }

        @Override // d.a.n0.f3.c.a.c
        public void a() {
            if (a.this.f54870f && a.this.f54867c != null) {
                a.this.f54867c.a();
            }
        }

        @Override // d.a.n0.f3.c.a.c
        public void b(d.a.n0.f3.b.a aVar) {
            if (j.z()) {
                a.this.f54868d.e();
            } else if (a.this.f54867c != null) {
                a.this.f54867c.a();
            }
            if (a.this.f54870f) {
                a.this.f54869e.postDelayed(new RunnableC1335a(), 800L);
            } else if (j.z() && j.H()) {
                a.this.f54868d.g();
            }
        }

        @Override // d.a.n0.f3.c.a.c
        public void c(Object obj) {
            d.a.n0.f3.b.b c2;
            if (!a.this.f54870f || (c2 = a.this.f54868d.c()) == null) {
                return;
            }
            StatisticItem h2 = d.a.n0.d3.a.h("a064", "common_fill", true, 1);
            if (d.a.c.a.j.a(a.this.f54865a) != null) {
                c.g().c(d.a.c.a.j.a(a.this.f54865a).getUniqueId(), h2);
            }
            a.this.f54866b.f(obj, ((int) c2.f54881c) / 1000);
            if (a.this.f54867c != null) {
                a.this.f54867c.c(String.valueOf(c2.f54879a), c2.c(), c2.a());
            }
        }
    }

    /* loaded from: classes5.dex */
    public class b implements a.d {

        /* renamed from: d.a.n0.f3.a$b$a  reason: collision with other inner class name */
        /* loaded from: classes5.dex */
        public class RunnableC1336a implements Runnable {

            /* renamed from: e  reason: collision with root package name */
            public final /* synthetic */ String f54876e;

            public RunnableC1336a(b bVar, String str) {
                this.f54876e = str;
            }

            @Override // java.lang.Runnable
            public void run() {
                UrlManager.getInstance().dealOneLink((TbPageContext) d.a.c.a.j.a(d.a.c.a.b.f().b()), new String[]{this.f54876e}, true);
            }
        }

        public b() {
        }

        @Override // d.a.n0.f3.d.a.d
        public void a() {
            d.a.n0.f3.b.b c2 = a.this.f54868d.c();
            if (c2 != null) {
                if (a.this.f54867c != null) {
                    a.this.f54867c.b(String.valueOf(c2.f54879a), c2.c());
                }
                if (TextUtils.isEmpty(c2.f54884f)) {
                    return;
                }
                if (!a.this.j(c2.f54884f)) {
                    UrlManager.getInstance().dealOneLink((TbPageContext) d.a.c.a.j.a(a.this.f54865a), new String[]{c2.f54884f}, true);
                } else {
                    e.a().postDelayed(new RunnableC1336a(this, c2.f54884f), 500L);
                }
            }
        }

        @Override // d.a.n0.f3.d.a.d
        public void b() {
            boolean z = false;
            if (a.this.getView() != null) {
                if (a.this.getView().getHeight() == l.i(a.this.getView().getContext())) {
                    z = true;
                }
            }
            TiebaStatic.log(new StatisticItem(TbadkCoreStatisticKey.KEY_VIDEO_SPLASH_SKIP).param("obj_source", 2).param("obj_type", z ? 2 : 1));
            if (a.this.f54867c != null) {
                a.this.f54867c.onAdDismiss();
            }
        }
    }

    public a(Context context) {
        this.f54865a = context;
        d.a.n0.f3.c.a aVar = new d.a.n0.f3.c.a();
        this.f54868d = aVar;
        aVar.h(this.f54871g);
        this.f54866b = new d.a.n0.f3.d.a(context, this.f54872h);
    }

    @Override // d.a.m0.w0.a
    public void a() {
        this.f54868d.d();
    }

    @Override // d.a.m0.w0.a
    public void b(d.a.m0.w0.b bVar) {
        this.f54867c = bVar;
    }

    @Override // d.a.m0.w0.a
    public View getView() {
        return this.f54866b.b();
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

    @Override // d.a.m0.w0.a
    public void release() {
        this.f54870f = false;
        this.f54869e.removeCallbacksAndMessages(null);
    }
}
