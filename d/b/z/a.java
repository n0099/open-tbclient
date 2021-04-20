package d.b.z;

import android.content.Context;
import android.os.Bundle;
import com.baidu.poly.widget.PolyActivity;
import org.json.JSONObject;
/* loaded from: classes2.dex */
public class a {

    /* renamed from: a  reason: collision with root package name */
    public long f65608a;

    /* renamed from: d.b.z.a$a  reason: collision with other inner class name */
    /* loaded from: classes2.dex */
    public static class C1796a {

        /* renamed from: b  reason: collision with root package name */
        public Context f65610b;

        /* renamed from: a  reason: collision with root package name */
        public int f65609a = 1;

        /* renamed from: c  reason: collision with root package name */
        public boolean f65611c = false;

        public a d() {
            return new a(this);
        }

        public C1796a e(Context context) {
            this.f65610b = context;
            return this;
        }

        public C1796a f(boolean z) {
            this.f65611c = z;
            return this;
        }

        public C1796a g(int i) {
            this.f65609a = i;
            return this;
        }
    }

    /* loaded from: classes2.dex */
    public static abstract class b {
        public abstract void a(int i, String str);
    }

    public void a(Context context, Bundle bundle, d.b.z.o.a.c cVar, b bVar) {
        if (context == null) {
            throw new IllegalArgumentException("context can not be null");
        }
        if (bundle == null) {
            throw new IllegalArgumentException("arguments can not be null");
        }
        if (cVar != null) {
            long currentTimeMillis = System.currentTimeMillis();
            if (currentTimeMillis - this.f65608a < 1000) {
                d.b.z.n.d.e("cashier pay time interval less than 1s");
                return;
            }
            this.f65608a = currentTimeMillis;
            d.b.z.n.d.e("cashier pay");
            d.b.z.k.h.a.c(Long.valueOf(currentTimeMillis));
            d.b.z.k.h.d.b(new d.b.z.k.h.b("0"));
            PolyActivity.a(context, cVar, bVar, bundle);
            return;
        }
        throw new IllegalArgumentException("channelPay can not be null");
    }

    public void b(int i, JSONObject jSONObject, d.b.z.l.a aVar) {
        if (i == 1) {
            d.b.z.k.b.a.b(jSONObject, aVar);
        } else if (i == 2) {
            d.b.z.k.c.a.a(aVar);
        } else if (aVar != null) {
            aVar.a(1, "unknown command");
        }
    }

    public a(C1796a c1796a) {
        this.f65608a = 0L;
        if (c1796a != null) {
            if (c1796a.f65610b != null) {
                d.b.z.k.b.a.c(c1796a.f65609a);
                d.b.z.k.d.b.a(d.b.z.k.d.a.e(c1796a.f65610b.getApplicationContext()));
                d.b.z.n.g.b(c1796a.f65610b.getApplicationContext());
                d.b.z.n.d.f65748d = c1796a.f65611c;
                return;
            }
            throw new IllegalArgumentException("context can not be null");
        }
        throw new IllegalArgumentException("builder can not be null");
    }
}
