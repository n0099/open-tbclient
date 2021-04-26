package d.a.a0;

import android.content.Context;
import android.os.Bundle;
import com.baidu.poly.widget.PolyActivity;
import org.json.JSONObject;
/* loaded from: classes2.dex */
public class a {

    /* renamed from: a  reason: collision with root package name */
    public long f39087a;

    /* renamed from: d.a.a0.a$a  reason: collision with other inner class name */
    /* loaded from: classes2.dex */
    public static class C0487a {

        /* renamed from: b  reason: collision with root package name */
        public Context f39089b;

        /* renamed from: a  reason: collision with root package name */
        public int f39088a = 1;

        /* renamed from: c  reason: collision with root package name */
        public boolean f39090c = false;

        public a d() {
            return new a(this);
        }

        public C0487a e(Context context) {
            this.f39089b = context;
            return this;
        }

        public C0487a f(boolean z) {
            this.f39090c = z;
            return this;
        }

        public C0487a g(int i2) {
            this.f39088a = i2;
            return this;
        }
    }

    /* loaded from: classes2.dex */
    public static abstract class b {
        public abstract void a(int i2, String str);
    }

    public void a(Context context, Bundle bundle, d.a.a0.o.a.c cVar, b bVar) {
        if (context == null) {
            throw new IllegalArgumentException("context can not be null");
        }
        if (bundle == null) {
            throw new IllegalArgumentException("arguments can not be null");
        }
        if (cVar != null) {
            long currentTimeMillis = System.currentTimeMillis();
            if (currentTimeMillis - this.f39087a < 1000) {
                d.a.a0.n.d.e("cashier pay time interval less than 1s");
                return;
            }
            this.f39087a = currentTimeMillis;
            d.a.a0.n.d.e("cashier pay");
            d.a.a0.k.h.a.c(Long.valueOf(currentTimeMillis));
            d.a.a0.k.h.d.b(new d.a.a0.k.h.b("0"));
            PolyActivity.a(context, cVar, bVar, bundle);
            return;
        }
        throw new IllegalArgumentException("channelPay can not be null");
    }

    public void b(int i2, JSONObject jSONObject, d.a.a0.l.a aVar) {
        if (i2 == 1) {
            d.a.a0.k.b.a.b(jSONObject, aVar);
        } else if (i2 == 2) {
            d.a.a0.k.c.a.a(aVar);
        } else if (aVar != null) {
            aVar.a(1, "unknown command");
        }
    }

    public a(C0487a c0487a) {
        this.f39087a = 0L;
        if (c0487a != null) {
            if (c0487a.f39089b != null) {
                d.a.a0.k.b.a.c(c0487a.f39088a);
                d.a.a0.k.d.b.a(d.a.a0.k.d.a.e(c0487a.f39089b.getApplicationContext()));
                d.a.a0.n.g.b(c0487a.f39089b.getApplicationContext());
                d.a.a0.n.d.f39231d = c0487a.f39090c;
                return;
            }
            throw new IllegalArgumentException("context can not be null");
        }
        throw new IllegalArgumentException("builder can not be null");
    }
}
