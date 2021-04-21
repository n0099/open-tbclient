package d.b.h0.a.y0;

import android.os.Bundle;
import android.text.TextUtils;
import androidx.annotation.NonNull;
import d.b.h0.a.k;
import d.b.h0.a.y0.a;
import java.util.Map;
/* loaded from: classes2.dex */
public class b extends d.b.h0.a.n1.a.a.a {

    /* renamed from: h  reason: collision with root package name */
    public static Map<String, d.b.h0.a.i2.u0.b<Bundle>> f47794h;

    /* renamed from: f  reason: collision with root package name */
    public int f47795f = -1;

    /* renamed from: g  reason: collision with root package name */
    public String f47796g = "";

    /* loaded from: classes2.dex */
    public class a implements d.b.h0.a.i2.u0.b<Bundle> {

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ String f47797e;

        public a(String str) {
            this.f47797e = str;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // d.b.h0.a.i2.u0.b
        /* renamed from: a */
        public void onCallback(Bundle bundle) {
            b.this.f47796g = bundle.getString("key_launch_app_id");
            b.this.f47795f = bundle.getInt("key_launch_status");
            if (TextUtils.equals(this.f47797e, b.this.f47796g)) {
                b bVar = b.this;
                bVar.f46061d.putInt("ok", bVar.f47795f);
                b.this.c();
            }
            b.f47794h.remove(this.f47797e);
        }
    }

    /* renamed from: d.b.h0.a.y0.b$b  reason: collision with other inner class name */
    /* loaded from: classes2.dex */
    public static class C0913b implements d.b.h0.a.i2.u0.b<Bundle> {

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ String f47799e;

        /* renamed from: f  reason: collision with root package name */
        public final /* synthetic */ a.d f47800f;

        public C0913b(String str, a.d dVar) {
            this.f47799e = str;
            this.f47800f = dVar;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // d.b.h0.a.i2.u0.b
        /* renamed from: a */
        public void onCallback(Bundle bundle) {
            String string = bundle.getString("key_launch_app_id");
            int i = bundle.getInt("key_launch_status");
            if (TextUtils.equals(this.f47799e, string)) {
                if (i == 0) {
                    this.f47800f.a();
                } else {
                    this.f47800f.b();
                }
            }
            b.f47794h.remove(this.f47799e);
        }
    }

    static {
        boolean z = k.f45772a;
        f47794h = new d.b.h0.m.a.c.a();
    }

    public static void j(String str, a.d dVar) {
        if (TextUtils.isEmpty(str) || dVar == null) {
            return;
        }
        f47794h.put(str, new C0913b(str, dVar));
    }

    public static void k(String str) {
        d.b.h0.a.i2.u0.b<Bundle> bVar = f47794h.get(str);
        if (bVar != null) {
            Bundle bundle = new Bundle();
            bundle.putString("key_launch_app_id", str);
            bundle.putInt("key_launch_status", 1);
            bVar.onCallback(bundle);
        }
    }

    public static void l(String str) {
        d.b.h0.a.i2.u0.b<Bundle> bVar = f47794h.get(str);
        if (bVar != null) {
            Bundle bundle = new Bundle();
            bundle.putString("key_launch_app_id", str);
            bundle.putInt("key_launch_status", 0);
            bVar.onCallback(bundle);
        }
    }

    @Override // d.b.h0.a.n1.a.a.a
    public void b(@NonNull Bundle bundle) {
        String string = bundle.getString("desAppId");
        f47794h.put(string, new a(string));
    }
}
