package d.b.c0;

import android.content.Context;
import android.os.Bundle;
import com.baidu.poly.widget.PolyActivity;
import org.json.JSONObject;
/* loaded from: classes2.dex */
public class a {

    /* renamed from: a  reason: collision with root package name */
    public long f42539a;

    /* renamed from: d.b.c0.a$a  reason: collision with other inner class name */
    /* loaded from: classes2.dex */
    public static class C0558a {

        /* renamed from: b  reason: collision with root package name */
        public Context f42541b;

        /* renamed from: a  reason: collision with root package name */
        public int f42540a = 1;

        /* renamed from: c  reason: collision with root package name */
        public boolean f42542c = false;

        public a d() {
            return new a(this);
        }

        public C0558a e(Context context) {
            this.f42541b = context;
            return this;
        }

        public C0558a f(boolean z) {
            this.f42542c = z;
            return this;
        }

        public C0558a g(int i) {
            this.f42540a = i;
            return this;
        }
    }

    /* loaded from: classes2.dex */
    public static abstract class b {
        public abstract void a(int i, String str);
    }

    public void a(Context context, Bundle bundle, d.b.c0.o.a.c cVar, b bVar) {
        if (context == null) {
            throw new IllegalArgumentException("context can not be null");
        }
        if (bundle == null) {
            throw new IllegalArgumentException("arguments can not be null");
        }
        if (cVar != null) {
            long currentTimeMillis = System.currentTimeMillis();
            if (currentTimeMillis - this.f42539a < 1000) {
                d.b.c0.n.d.e("cashier pay time interval less than 1s");
                return;
            }
            this.f42539a = currentTimeMillis;
            d.b.c0.n.d.e("cashier pay");
            d.b.c0.k.h.a.c(Long.valueOf(currentTimeMillis));
            d.b.c0.k.h.d.b(new d.b.c0.k.h.b("0"));
            PolyActivity.a(context, cVar, bVar, bundle);
            return;
        }
        throw new IllegalArgumentException("channelPay can not be null");
    }

    public void b(int i, JSONObject jSONObject, d.b.c0.l.a aVar) {
        if (i == 1) {
            d.b.c0.k.b.a.b(jSONObject, aVar);
        } else if (i == 2) {
            d.b.c0.k.c.a.a(aVar);
        } else if (aVar != null) {
            aVar.a(1, "unknown command");
        }
    }

    public a(C0558a c0558a) {
        this.f42539a = 0L;
        if (c0558a != null) {
            if (c0558a.f42541b != null) {
                d.b.c0.k.b.a.c(c0558a.f42540a);
                d.b.c0.k.d.b.a(d.b.c0.k.d.a.e(c0558a.f42541b.getApplicationContext()));
                d.b.c0.n.g.b(c0558a.f42541b.getApplicationContext());
                d.b.c0.n.d.f42679d = c0558a.f42542c;
                return;
            }
            throw new IllegalArgumentException("context can not be null");
        }
        throw new IllegalArgumentException("builder can not be null");
    }
}
