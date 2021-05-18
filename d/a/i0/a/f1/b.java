package d.a.i0.a.f1;

import android.os.Bundle;
import android.text.TextUtils;
import androidx.annotation.NonNull;
import d.a.i0.a.f1.a;
import d.a.i0.a.k;
import java.util.Map;
/* loaded from: classes3.dex */
public class b extends d.a.i0.a.v1.a.a.a {

    /* renamed from: h  reason: collision with root package name */
    public static Map<String, d.a.i0.a.v2.e1.b<Bundle>> f41644h;

    /* renamed from: f  reason: collision with root package name */
    public int f41645f = -1;

    /* renamed from: g  reason: collision with root package name */
    public String f41646g = "";

    /* loaded from: classes3.dex */
    public class a implements d.a.i0.a.v2.e1.b<Bundle> {

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ String f41647e;

        public a(String str) {
            this.f41647e = str;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // d.a.i0.a.v2.e1.b
        /* renamed from: a */
        public void onCallback(Bundle bundle) {
            b.this.f41646g = bundle.getString("key_launch_app_id");
            b.this.f41645f = bundle.getInt("key_launch_status");
            if (TextUtils.equals(this.f41647e, b.this.f41646g)) {
                b bVar = b.this;
                bVar.f45096d.putInt("ok", bVar.f41645f);
                b.this.c();
            }
            b.f41644h.remove(this.f41647e);
        }
    }

    /* renamed from: d.a.i0.a.f1.b$b  reason: collision with other inner class name */
    /* loaded from: classes3.dex */
    public static class C0617b implements d.a.i0.a.v2.e1.b<Bundle> {

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ String f41649e;

        /* renamed from: f  reason: collision with root package name */
        public final /* synthetic */ a.d f41650f;

        public C0617b(String str, a.d dVar) {
            this.f41649e = str;
            this.f41650f = dVar;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // d.a.i0.a.v2.e1.b
        /* renamed from: a */
        public void onCallback(Bundle bundle) {
            String string = bundle.getString("key_launch_app_id");
            int i2 = bundle.getInt("key_launch_status");
            if (TextUtils.equals(this.f41649e, string)) {
                if (i2 == 0) {
                    this.f41650f.b();
                } else {
                    this.f41650f.a();
                }
            }
            b.f41644h.remove(this.f41649e);
        }
    }

    static {
        boolean z = k.f43025a;
        f41644h = new d.a.i0.o.a.c.a();
    }

    public static void j(String str, a.d dVar) {
        if (TextUtils.isEmpty(str) || dVar == null) {
            return;
        }
        f41644h.put(str, new C0617b(str, dVar));
    }

    public static void k(String str) {
        d.a.i0.a.v2.e1.b<Bundle> bVar = f41644h.get(str);
        if (bVar != null) {
            Bundle bundle = new Bundle();
            bundle.putString("key_launch_app_id", str);
            bundle.putInt("key_launch_status", 1);
            bVar.onCallback(bundle);
        }
    }

    public static void l(String str) {
        d.a.i0.a.v2.e1.b<Bundle> bVar = f41644h.get(str);
        if (bVar != null) {
            Bundle bundle = new Bundle();
            bundle.putString("key_launch_app_id", str);
            bundle.putInt("key_launch_status", 0);
            bVar.onCallback(bundle);
        }
    }

    @Override // d.a.i0.a.v1.a.a.a
    public void b(@NonNull Bundle bundle) {
        String string = bundle.getString("desAppId");
        f41644h.put(string, new a(string));
    }
}
