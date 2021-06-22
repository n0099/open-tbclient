package d.a.m0.a.d2;

import d.a.m0.a.e2.c.f;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;
/* loaded from: classes3.dex */
public class a {

    /* renamed from: a  reason: collision with root package name */
    public static final Map<String, Boolean> f45100a = new ConcurrentHashMap();

    /* renamed from: b  reason: collision with root package name */
    public static final Map<String, Boolean> f45101b = new ConcurrentHashMap();

    /* renamed from: d.a.m0.a.d2.a$a  reason: collision with other inner class name */
    /* loaded from: classes3.dex */
    public static class C0652a implements d.a.m0.a.v2.e1.b<f> {

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ String f45102e;

        /* renamed from: f  reason: collision with root package name */
        public final /* synthetic */ d.a.m0.a.v2.e1.b f45103f;

        public C0652a(String str, d.a.m0.a.v2.e1.b bVar) {
            this.f45102e = str;
            this.f45103f = bVar;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // d.a.m0.a.v2.e1.b
        /* renamed from: a */
        public void onCallback(f fVar) {
            boolean z = true;
            z = (fVar == null || fVar.f45481d || fVar.j != 1) ? false : false;
            a.f45100a.put(this.f45102e, Boolean.valueOf(z));
            this.f45103f.onCallback(Boolean.valueOf(z));
        }
    }

    public static void b(d.a.m0.a.v2.e1.b<Boolean> bVar) {
        String appId = d.a.m0.a.a2.d.g().getAppId();
        Boolean bool = f45100a.get(appId);
        if (bool != null) {
            bVar.onCallback(bool);
        } else {
            d.a.m0.a.a2.d.g().r().T().e("mapp_custom_screenshot_image", new C0652a(appId, bVar));
        }
    }

    public static boolean c() {
        Boolean bool = f45101b.get(d.a.m0.a.a2.d.g().getAppId());
        if (bool != null) {
            return bool.booleanValue();
        }
        return false;
    }

    public static void d() {
        f45101b.clear();
        f45100a.clear();
    }

    public static void e(boolean z) {
        f45101b.put(d.a.m0.a.a2.d.g().getAppId(), Boolean.valueOf(z));
    }
}
