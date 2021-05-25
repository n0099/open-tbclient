package d.a.l0.a.f1;

import android.os.Bundle;
import android.text.TextUtils;
import androidx.annotation.NonNull;
import d.a.l0.a.f1.a;
import d.a.l0.a.k;
import java.util.Map;
/* loaded from: classes3.dex */
public class b extends d.a.l0.a.v1.a.a.a {

    /* renamed from: h  reason: collision with root package name */
    public static Map<String, d.a.l0.a.v2.e1.b<Bundle>> f41818h;

    /* renamed from: f  reason: collision with root package name */
    public int f41819f = -1;

    /* renamed from: g  reason: collision with root package name */
    public String f41820g = "";

    /* loaded from: classes3.dex */
    public class a implements d.a.l0.a.v2.e1.b<Bundle> {

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ String f41821e;

        public a(String str) {
            this.f41821e = str;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // d.a.l0.a.v2.e1.b
        /* renamed from: a */
        public void onCallback(Bundle bundle) {
            b.this.f41820g = bundle.getString("key_launch_app_id");
            b.this.f41819f = bundle.getInt("key_launch_status");
            if (TextUtils.equals(this.f41821e, b.this.f41820g)) {
                b bVar = b.this;
                bVar.f45272d.putInt("ok", bVar.f41819f);
                b.this.c();
            }
            b.f41818h.remove(this.f41821e);
        }
    }

    /* renamed from: d.a.l0.a.f1.b$b  reason: collision with other inner class name */
    /* loaded from: classes3.dex */
    public static class C0628b implements d.a.l0.a.v2.e1.b<Bundle> {

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ String f41823e;

        /* renamed from: f  reason: collision with root package name */
        public final /* synthetic */ a.d f41824f;

        public C0628b(String str, a.d dVar) {
            this.f41823e = str;
            this.f41824f = dVar;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // d.a.l0.a.v2.e1.b
        /* renamed from: a */
        public void onCallback(Bundle bundle) {
            String string = bundle.getString("key_launch_app_id");
            int i2 = bundle.getInt("key_launch_status");
            if (TextUtils.equals(this.f41823e, string)) {
                if (i2 == 0) {
                    this.f41824f.b();
                } else {
                    this.f41824f.a();
                }
            }
            b.f41818h.remove(this.f41823e);
        }
    }

    static {
        boolean z = k.f43199a;
        f41818h = new d.a.l0.o.a.c.a();
    }

    public static void j(String str, a.d dVar) {
        if (TextUtils.isEmpty(str) || dVar == null) {
            return;
        }
        f41818h.put(str, new C0628b(str, dVar));
    }

    public static void k(String str) {
        d.a.l0.a.v2.e1.b<Bundle> bVar = f41818h.get(str);
        if (bVar != null) {
            Bundle bundle = new Bundle();
            bundle.putString("key_launch_app_id", str);
            bundle.putInt("key_launch_status", 1);
            bVar.onCallback(bundle);
        }
    }

    public static void l(String str) {
        d.a.l0.a.v2.e1.b<Bundle> bVar = f41818h.get(str);
        if (bVar != null) {
            Bundle bundle = new Bundle();
            bundle.putString("key_launch_app_id", str);
            bundle.putInt("key_launch_status", 0);
            bVar.onCallback(bundle);
        }
    }

    @Override // d.a.l0.a.v1.a.a.a
    public void b(@NonNull Bundle bundle) {
        String string = bundle.getString("desAppId");
        f41818h.put(string, new a(string));
    }
}
