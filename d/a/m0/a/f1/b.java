package d.a.m0.a.f1;

import android.os.Bundle;
import android.text.TextUtils;
import androidx.annotation.NonNull;
import d.a.m0.a.f1.a;
import d.a.m0.a.k;
import java.util.Map;
/* loaded from: classes3.dex */
public class b extends d.a.m0.a.v1.a.a.a {

    /* renamed from: h  reason: collision with root package name */
    public static Map<String, d.a.m0.a.v2.e1.b<Bundle>> f45602h;

    /* renamed from: f  reason: collision with root package name */
    public int f45603f = -1;

    /* renamed from: g  reason: collision with root package name */
    public String f45604g = "";

    /* loaded from: classes3.dex */
    public class a implements d.a.m0.a.v2.e1.b<Bundle> {

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ String f45605e;

        public a(String str) {
            this.f45605e = str;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // d.a.m0.a.v2.e1.b
        /* renamed from: a */
        public void onCallback(Bundle bundle) {
            b.this.f45604g = bundle.getString("key_launch_app_id");
            b.this.f45603f = bundle.getInt("key_launch_status");
            if (TextUtils.equals(this.f45605e, b.this.f45604g)) {
                b bVar = b.this;
                bVar.f49054d.putInt("ok", bVar.f45603f);
                b.this.c();
            }
            b.f45602h.remove(this.f45605e);
        }
    }

    /* renamed from: d.a.m0.a.f1.b$b  reason: collision with other inner class name */
    /* loaded from: classes3.dex */
    public static class C0687b implements d.a.m0.a.v2.e1.b<Bundle> {

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ String f45607e;

        /* renamed from: f  reason: collision with root package name */
        public final /* synthetic */ a.d f45608f;

        public C0687b(String str, a.d dVar) {
            this.f45607e = str;
            this.f45608f = dVar;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // d.a.m0.a.v2.e1.b
        /* renamed from: a */
        public void onCallback(Bundle bundle) {
            String string = bundle.getString("key_launch_app_id");
            int i2 = bundle.getInt("key_launch_status");
            if (TextUtils.equals(this.f45607e, string)) {
                if (i2 == 0) {
                    this.f45608f.b();
                } else {
                    this.f45608f.a();
                }
            }
            b.f45602h.remove(this.f45607e);
        }
    }

    static {
        boolean z = k.f46983a;
        f45602h = new d.a.m0.o.a.c.a();
    }

    public static void j(String str, a.d dVar) {
        if (TextUtils.isEmpty(str) || dVar == null) {
            return;
        }
        f45602h.put(str, new C0687b(str, dVar));
    }

    public static void k(String str) {
        d.a.m0.a.v2.e1.b<Bundle> bVar = f45602h.get(str);
        if (bVar != null) {
            Bundle bundle = new Bundle();
            bundle.putString("key_launch_app_id", str);
            bundle.putInt("key_launch_status", 1);
            bVar.onCallback(bundle);
        }
    }

    public static void l(String str) {
        d.a.m0.a.v2.e1.b<Bundle> bVar = f45602h.get(str);
        if (bVar != null) {
            Bundle bundle = new Bundle();
            bundle.putString("key_launch_app_id", str);
            bundle.putInt("key_launch_status", 0);
            bVar.onCallback(bundle);
        }
    }

    @Override // d.a.m0.a.v1.a.a.a
    public void b(@NonNull Bundle bundle) {
        String string = bundle.getString("desAppId");
        f45602h.put(string, new a(string));
    }
}
