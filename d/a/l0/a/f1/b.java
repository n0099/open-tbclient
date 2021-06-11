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
    public static Map<String, d.a.l0.a.v2.e1.b<Bundle>> f45494h;

    /* renamed from: f  reason: collision with root package name */
    public int f45495f = -1;

    /* renamed from: g  reason: collision with root package name */
    public String f45496g = "";

    /* loaded from: classes3.dex */
    public class a implements d.a.l0.a.v2.e1.b<Bundle> {

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ String f45497e;

        public a(String str) {
            this.f45497e = str;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // d.a.l0.a.v2.e1.b
        /* renamed from: a */
        public void onCallback(Bundle bundle) {
            b.this.f45496g = bundle.getString("key_launch_app_id");
            b.this.f45495f = bundle.getInt("key_launch_status");
            if (TextUtils.equals(this.f45497e, b.this.f45496g)) {
                b bVar = b.this;
                bVar.f48946d.putInt("ok", bVar.f45495f);
                b.this.c();
            }
            b.f45494h.remove(this.f45497e);
        }
    }

    /* renamed from: d.a.l0.a.f1.b$b  reason: collision with other inner class name */
    /* loaded from: classes3.dex */
    public static class C0684b implements d.a.l0.a.v2.e1.b<Bundle> {

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ String f45499e;

        /* renamed from: f  reason: collision with root package name */
        public final /* synthetic */ a.d f45500f;

        public C0684b(String str, a.d dVar) {
            this.f45499e = str;
            this.f45500f = dVar;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // d.a.l0.a.v2.e1.b
        /* renamed from: a */
        public void onCallback(Bundle bundle) {
            String string = bundle.getString("key_launch_app_id");
            int i2 = bundle.getInt("key_launch_status");
            if (TextUtils.equals(this.f45499e, string)) {
                if (i2 == 0) {
                    this.f45500f.b();
                } else {
                    this.f45500f.a();
                }
            }
            b.f45494h.remove(this.f45499e);
        }
    }

    static {
        boolean z = k.f46875a;
        f45494h = new d.a.l0.o.a.c.a();
    }

    public static void j(String str, a.d dVar) {
        if (TextUtils.isEmpty(str) || dVar == null) {
            return;
        }
        f45494h.put(str, new C0684b(str, dVar));
    }

    public static void k(String str) {
        d.a.l0.a.v2.e1.b<Bundle> bVar = f45494h.get(str);
        if (bVar != null) {
            Bundle bundle = new Bundle();
            bundle.putString("key_launch_app_id", str);
            bundle.putInt("key_launch_status", 1);
            bVar.onCallback(bundle);
        }
    }

    public static void l(String str) {
        d.a.l0.a.v2.e1.b<Bundle> bVar = f45494h.get(str);
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
        f45494h.put(string, new a(string));
    }
}
