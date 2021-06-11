package d.a.l0.a.d2;

import d.a.l0.a.e2.c.f;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;
/* loaded from: classes3.dex */
public class a {

    /* renamed from: a  reason: collision with root package name */
    public static final Map<String, Boolean> f44992a = new ConcurrentHashMap();

    /* renamed from: b  reason: collision with root package name */
    public static final Map<String, Boolean> f44993b = new ConcurrentHashMap();

    /* renamed from: d.a.l0.a.d2.a$a  reason: collision with other inner class name */
    /* loaded from: classes3.dex */
    public static class C0649a implements d.a.l0.a.v2.e1.b<f> {

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ String f44994e;

        /* renamed from: f  reason: collision with root package name */
        public final /* synthetic */ d.a.l0.a.v2.e1.b f44995f;

        public C0649a(String str, d.a.l0.a.v2.e1.b bVar) {
            this.f44994e = str;
            this.f44995f = bVar;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // d.a.l0.a.v2.e1.b
        /* renamed from: a */
        public void onCallback(f fVar) {
            boolean z = true;
            z = (fVar == null || fVar.f45373d || fVar.j != 1) ? false : false;
            a.f44992a.put(this.f44994e, Boolean.valueOf(z));
            this.f44995f.onCallback(Boolean.valueOf(z));
        }
    }

    public static void b(d.a.l0.a.v2.e1.b<Boolean> bVar) {
        String appId = d.a.l0.a.a2.d.g().getAppId();
        Boolean bool = f44992a.get(appId);
        if (bool != null) {
            bVar.onCallback(bool);
        } else {
            d.a.l0.a.a2.d.g().r().T().e("mapp_custom_screenshot_image", new C0649a(appId, bVar));
        }
    }

    public static boolean c() {
        Boolean bool = f44993b.get(d.a.l0.a.a2.d.g().getAppId());
        if (bool != null) {
            return bool.booleanValue();
        }
        return false;
    }

    public static void d() {
        f44993b.clear();
        f44992a.clear();
    }

    public static void e(boolean z) {
        f44993b.put(d.a.l0.a.a2.d.g().getAppId(), Boolean.valueOf(z));
    }
}
