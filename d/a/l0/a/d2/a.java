package d.a.l0.a.d2;

import d.a.l0.a.e2.c.f;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;
/* loaded from: classes3.dex */
public class a {

    /* renamed from: a  reason: collision with root package name */
    public static final Map<String, Boolean> f41316a = new ConcurrentHashMap();

    /* renamed from: b  reason: collision with root package name */
    public static final Map<String, Boolean> f41317b = new ConcurrentHashMap();

    /* renamed from: d.a.l0.a.d2.a$a  reason: collision with other inner class name */
    /* loaded from: classes3.dex */
    public static class C0593a implements d.a.l0.a.v2.e1.b<f> {

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ String f41318e;

        /* renamed from: f  reason: collision with root package name */
        public final /* synthetic */ d.a.l0.a.v2.e1.b f41319f;

        public C0593a(String str, d.a.l0.a.v2.e1.b bVar) {
            this.f41318e = str;
            this.f41319f = bVar;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // d.a.l0.a.v2.e1.b
        /* renamed from: a */
        public void onCallback(f fVar) {
            boolean z = true;
            z = (fVar == null || fVar.f41697d || fVar.j != 1) ? false : false;
            a.f41316a.put(this.f41318e, Boolean.valueOf(z));
            this.f41319f.onCallback(Boolean.valueOf(z));
        }
    }

    public static void b(d.a.l0.a.v2.e1.b<Boolean> bVar) {
        String appId = d.a.l0.a.a2.d.g().getAppId();
        Boolean bool = f41316a.get(appId);
        if (bool != null) {
            bVar.onCallback(bool);
        } else {
            d.a.l0.a.a2.d.g().r().T().e("mapp_custom_screenshot_image", new C0593a(appId, bVar));
        }
    }

    public static boolean c() {
        Boolean bool = f41317b.get(d.a.l0.a.a2.d.g().getAppId());
        if (bool != null) {
            return bool.booleanValue();
        }
        return false;
    }

    public static void d() {
        f41317b.clear();
        f41316a.clear();
    }

    public static void e(boolean z) {
        f41317b.put(d.a.l0.a.a2.d.g().getAppId(), Boolean.valueOf(z));
    }
}
