package d.a.i0.a.d2;

import d.a.i0.a.e2.c.f;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;
/* loaded from: classes3.dex */
public class a {

    /* renamed from: a  reason: collision with root package name */
    public static final Map<String, Boolean> f41142a = new ConcurrentHashMap();

    /* renamed from: b  reason: collision with root package name */
    public static final Map<String, Boolean> f41143b = new ConcurrentHashMap();

    /* renamed from: d.a.i0.a.d2.a$a  reason: collision with other inner class name */
    /* loaded from: classes3.dex */
    public static class C0582a implements d.a.i0.a.v2.e1.b<f> {

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ String f41144e;

        /* renamed from: f  reason: collision with root package name */
        public final /* synthetic */ d.a.i0.a.v2.e1.b f41145f;

        public C0582a(String str, d.a.i0.a.v2.e1.b bVar) {
            this.f41144e = str;
            this.f41145f = bVar;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // d.a.i0.a.v2.e1.b
        /* renamed from: a */
        public void onCallback(f fVar) {
            boolean z = true;
            z = (fVar == null || fVar.f41523d || fVar.j != 1) ? false : false;
            a.f41142a.put(this.f41144e, Boolean.valueOf(z));
            this.f41145f.onCallback(Boolean.valueOf(z));
        }
    }

    public static void b(d.a.i0.a.v2.e1.b<Boolean> bVar) {
        String appId = d.a.i0.a.a2.d.g().getAppId();
        Boolean bool = f41142a.get(appId);
        if (bool != null) {
            bVar.onCallback(bool);
        } else {
            d.a.i0.a.a2.d.g().r().T().e("mapp_custom_screenshot_image", new C0582a(appId, bVar));
        }
    }

    public static boolean c() {
        Boolean bool = f41143b.get(d.a.i0.a.a2.d.g().getAppId());
        if (bool != null) {
            return bool.booleanValue();
        }
        return false;
    }

    public static void d() {
        f41143b.clear();
        f41142a.clear();
    }

    public static void e(boolean z) {
        f41143b.put(d.a.i0.a.a2.d.g().getAppId(), Boolean.valueOf(z));
    }
}
