package d.a.h0.a.y0;

import android.os.Bundle;
import android.text.TextUtils;
import androidx.annotation.NonNull;
import d.a.h0.a.k;
import d.a.h0.a.y0.a;
import java.util.Map;
/* loaded from: classes2.dex */
public class b extends d.a.h0.a.n1.a.a.a {

    /* renamed from: h  reason: collision with root package name */
    public static Map<String, d.a.h0.a.i2.u0.b<Bundle>> f45228h;

    /* renamed from: f  reason: collision with root package name */
    public int f45229f = -1;

    /* renamed from: g  reason: collision with root package name */
    public String f45230g = "";

    /* loaded from: classes2.dex */
    public class a implements d.a.h0.a.i2.u0.b<Bundle> {

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ String f45231e;

        public a(String str) {
            this.f45231e = str;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // d.a.h0.a.i2.u0.b
        /* renamed from: a */
        public void onCallback(Bundle bundle) {
            b.this.f45230g = bundle.getString("key_launch_app_id");
            b.this.f45229f = bundle.getInt("key_launch_status");
            if (TextUtils.equals(this.f45231e, b.this.f45230g)) {
                b bVar = b.this;
                bVar.f43404d.putInt("ok", bVar.f45229f);
                b.this.c();
            }
            b.f45228h.remove(this.f45231e);
        }
    }

    /* renamed from: d.a.h0.a.y0.b$b  reason: collision with other inner class name */
    /* loaded from: classes2.dex */
    public static class C0852b implements d.a.h0.a.i2.u0.b<Bundle> {

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ String f45233e;

        /* renamed from: f  reason: collision with root package name */
        public final /* synthetic */ a.d f45234f;

        public C0852b(String str, a.d dVar) {
            this.f45233e = str;
            this.f45234f = dVar;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // d.a.h0.a.i2.u0.b
        /* renamed from: a */
        public void onCallback(Bundle bundle) {
            String string = bundle.getString("key_launch_app_id");
            int i2 = bundle.getInt("key_launch_status");
            if (TextUtils.equals(this.f45233e, string)) {
                if (i2 == 0) {
                    this.f45234f.b();
                } else {
                    this.f45234f.a();
                }
            }
            b.f45228h.remove(this.f45233e);
        }
    }

    static {
        boolean z = k.f43101a;
        f45228h = new d.a.h0.m.a.c.a();
    }

    public static void j(String str, a.d dVar) {
        if (TextUtils.isEmpty(str) || dVar == null) {
            return;
        }
        f45228h.put(str, new C0852b(str, dVar));
    }

    public static void k(String str) {
        d.a.h0.a.i2.u0.b<Bundle> bVar = f45228h.get(str);
        if (bVar != null) {
            Bundle bundle = new Bundle();
            bundle.putString("key_launch_app_id", str);
            bundle.putInt("key_launch_status", 1);
            bVar.onCallback(bundle);
        }
    }

    public static void l(String str) {
        d.a.h0.a.i2.u0.b<Bundle> bVar = f45228h.get(str);
        if (bVar != null) {
            Bundle bundle = new Bundle();
            bundle.putString("key_launch_app_id", str);
            bundle.putInt("key_launch_status", 0);
            bVar.onCallback(bundle);
        }
    }

    @Override // d.a.h0.a.n1.a.a.a
    public void b(@NonNull Bundle bundle) {
        String string = bundle.getString("desAppId");
        f45228h.put(string, new a(string));
    }
}
