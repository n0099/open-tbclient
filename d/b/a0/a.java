package d.b.a0;

import android.content.Context;
import android.os.Bundle;
import com.baidu.poly.widget.PolyActivity;
import org.json.JSONObject;
/* loaded from: classes2.dex */
public class a {

    /* renamed from: a  reason: collision with root package name */
    public long f41910a;

    /* renamed from: d.b.a0.a$a  reason: collision with other inner class name */
    /* loaded from: classes2.dex */
    public static class C0548a {

        /* renamed from: b  reason: collision with root package name */
        public Context f41912b;

        /* renamed from: a  reason: collision with root package name */
        public int f41911a = 1;

        /* renamed from: c  reason: collision with root package name */
        public boolean f41913c = false;

        public a d() {
            return new a(this);
        }

        public C0548a e(Context context) {
            this.f41912b = context;
            return this;
        }

        public C0548a f(boolean z) {
            this.f41913c = z;
            return this;
        }

        public C0548a g(int i) {
            this.f41911a = i;
            return this;
        }
    }

    /* loaded from: classes2.dex */
    public static abstract class b {
        public abstract void a(int i, String str);
    }

    public void a(Context context, Bundle bundle, d.b.a0.o.a.c cVar, b bVar) {
        if (context == null) {
            throw new IllegalArgumentException("context can not be null");
        }
        if (bundle == null) {
            throw new IllegalArgumentException("arguments can not be null");
        }
        if (cVar != null) {
            long currentTimeMillis = System.currentTimeMillis();
            if (currentTimeMillis - this.f41910a < 1000) {
                d.b.a0.n.d.e("cashier pay time interval less than 1s");
                return;
            }
            this.f41910a = currentTimeMillis;
            d.b.a0.n.d.e("cashier pay");
            d.b.a0.k.h.a.c(Long.valueOf(currentTimeMillis));
            d.b.a0.k.h.d.b(new d.b.a0.k.h.b("0"));
            PolyActivity.a(context, cVar, bVar, bundle);
            return;
        }
        throw new IllegalArgumentException("channelPay can not be null");
    }

    public void b(int i, JSONObject jSONObject, d.b.a0.l.a aVar) {
        if (i == 1) {
            d.b.a0.k.b.a.b(jSONObject, aVar);
        } else if (i == 2) {
            d.b.a0.k.c.a.a(aVar);
        } else if (aVar != null) {
            aVar.a(1, "unknown command");
        }
    }

    public a(C0548a c0548a) {
        this.f41910a = 0L;
        if (c0548a != null) {
            if (c0548a.f41912b != null) {
                d.b.a0.k.b.a.c(c0548a.f41911a);
                d.b.a0.k.d.b.a(d.b.a0.k.d.a.e(c0548a.f41912b.getApplicationContext()));
                d.b.a0.n.g.b(c0548a.f41912b.getApplicationContext());
                d.b.a0.n.d.f42050d = c0548a.f41913c;
                return;
            }
            throw new IllegalArgumentException("context can not be null");
        }
        throw new IllegalArgumentException("builder can not be null");
    }
}
