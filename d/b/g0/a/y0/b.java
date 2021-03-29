package d.b.g0.a.y0;

import android.os.Bundle;
import android.text.TextUtils;
import androidx.annotation.NonNull;
import d.b.g0.a.k;
import d.b.g0.a.y0.a;
import java.util.Map;
/* loaded from: classes2.dex */
public class b extends d.b.g0.a.n1.a.a.a {

    /* renamed from: h  reason: collision with root package name */
    public static Map<String, d.b.g0.a.i2.u0.b<Bundle>> f47073h;

    /* renamed from: f  reason: collision with root package name */
    public int f47074f = -1;

    /* renamed from: g  reason: collision with root package name */
    public String f47075g = "";

    /* loaded from: classes2.dex */
    public class a implements d.b.g0.a.i2.u0.b<Bundle> {

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ String f47076e;

        public a(String str) {
            this.f47076e = str;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // d.b.g0.a.i2.u0.b
        /* renamed from: a */
        public void onCallback(Bundle bundle) {
            b.this.f47075g = bundle.getString("key_launch_app_id");
            b.this.f47074f = bundle.getInt("key_launch_status");
            if (TextUtils.equals(this.f47076e, b.this.f47075g)) {
                b bVar = b.this;
                bVar.f45340d.putInt("ok", bVar.f47074f);
                b.this.c();
            }
            b.f47073h.remove(this.f47076e);
        }
    }

    /* renamed from: d.b.g0.a.y0.b$b  reason: collision with other inner class name */
    /* loaded from: classes2.dex */
    public static class C0881b implements d.b.g0.a.i2.u0.b<Bundle> {

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ String f47078e;

        /* renamed from: f  reason: collision with root package name */
        public final /* synthetic */ a.d f47079f;

        public C0881b(String str, a.d dVar) {
            this.f47078e = str;
            this.f47079f = dVar;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // d.b.g0.a.i2.u0.b
        /* renamed from: a */
        public void onCallback(Bundle bundle) {
            String string = bundle.getString("key_launch_app_id");
            int i = bundle.getInt("key_launch_status");
            if (TextUtils.equals(this.f47078e, string)) {
                if (i == 0) {
                    this.f47079f.a();
                } else {
                    this.f47079f.b();
                }
            }
            b.f47073h.remove(this.f47078e);
        }
    }

    static {
        boolean z = k.f45051a;
        f47073h = new d.b.g0.m.a.c.a();
    }

    public static void j(String str, a.d dVar) {
        if (TextUtils.isEmpty(str) || dVar == null) {
            return;
        }
        f47073h.put(str, new C0881b(str, dVar));
    }

    public static void k(String str) {
        d.b.g0.a.i2.u0.b<Bundle> bVar = f47073h.get(str);
        if (bVar != null) {
            Bundle bundle = new Bundle();
            bundle.putString("key_launch_app_id", str);
            bundle.putInt("key_launch_status", 1);
            bVar.onCallback(bundle);
        }
    }

    public static void l(String str) {
        d.b.g0.a.i2.u0.b<Bundle> bVar = f47073h.get(str);
        if (bVar != null) {
            Bundle bundle = new Bundle();
            bundle.putString("key_launch_app_id", str);
            bundle.putInt("key_launch_status", 0);
            bVar.onCallback(bundle);
        }
    }

    @Override // d.b.g0.a.n1.a.a.a
    public void b(@NonNull Bundle bundle) {
        String string = bundle.getString("desAppId");
        f47073h.put(string, new a(string));
    }
}
