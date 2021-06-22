package d.a.c0;

import android.content.Context;
import android.os.Bundle;
import com.baidu.poly.widget.PolyActivity;
import org.json.JSONObject;
/* loaded from: classes2.dex */
public class a {

    /* renamed from: a  reason: collision with root package name */
    public long f43136a;

    /* renamed from: d.a.c0.a$a  reason: collision with other inner class name */
    /* loaded from: classes2.dex */
    public static class C0559a {

        /* renamed from: b  reason: collision with root package name */
        public Context f43138b;

        /* renamed from: a  reason: collision with root package name */
        public int f43137a = 1;

        /* renamed from: c  reason: collision with root package name */
        public boolean f43139c = false;

        public a d() {
            return new a(this);
        }

        public C0559a e(Context context) {
            this.f43138b = context;
            return this;
        }

        public C0559a f(boolean z) {
            this.f43139c = z;
            return this;
        }

        public C0559a g(int i2) {
            this.f43137a = i2;
            return this;
        }
    }

    /* loaded from: classes2.dex */
    public static abstract class b {
        public abstract void a(int i2, String str);
    }

    public void a(Context context, Bundle bundle, d.a.c0.o.a.c cVar, b bVar) {
        if (context == null) {
            throw new IllegalArgumentException("context can not be null");
        }
        if (bundle == null) {
            throw new IllegalArgumentException("arguments can not be null");
        }
        if (cVar != null) {
            long currentTimeMillis = System.currentTimeMillis();
            if (currentTimeMillis - this.f43136a < 1000) {
                d.a.c0.n.d.e("cashier pay time interval less than 1s");
                return;
            }
            this.f43136a = currentTimeMillis;
            d.a.c0.n.d.e("cashier pay");
            d.a.c0.k.h.a.c(Long.valueOf(currentTimeMillis));
            d.a.c0.k.h.d.b(new d.a.c0.k.h.b("0"));
            PolyActivity.a(context, cVar, bVar, bundle);
            return;
        }
        throw new IllegalArgumentException("channelPay can not be null");
    }

    public void b(int i2, JSONObject jSONObject, d.a.c0.l.a aVar) {
        if (i2 == 1) {
            d.a.c0.k.b.a.b(jSONObject, aVar);
        } else if (i2 == 2) {
            d.a.c0.k.c.a.a(aVar);
        } else if (aVar != null) {
            aVar.a(1, "unknown command");
        }
    }

    public a(C0559a c0559a) {
        this.f43136a = 0L;
        if (c0559a != null) {
            if (c0559a.f43138b != null) {
                d.a.c0.k.b.a.c(c0559a.f43137a);
                d.a.c0.k.d.b.a(d.a.c0.k.d.a.e(c0559a.f43138b.getApplicationContext()));
                d.a.c0.n.g.b(c0559a.f43138b.getApplicationContext());
                d.a.c0.n.d.f43280d = c0559a.f43139c;
                return;
            }
            throw new IllegalArgumentException("context can not be null");
        }
        throw new IllegalArgumentException("builder can not be null");
    }
}
