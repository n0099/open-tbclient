package d.a.o0.m2;

import com.baidu.cyberplayer.sdk.statistics.DpStatConstants;
import com.baidu.tieba.VideoPlatformStatic;
import org.json.JSONObject;
/* loaded from: classes5.dex */
public interface b {

    /* loaded from: classes5.dex */
    public static abstract class a implements b {

        /* renamed from: a  reason: collision with root package name */
        public final int f61269a;

        /* renamed from: b  reason: collision with root package name */
        public final long f61270b = System.currentTimeMillis();

        public a(int i2) {
            this.f61269a = i2;
        }

        @Override // d.a.o0.m2.b
        public JSONObject a() {
            JSONObject jSONObject = new JSONObject();
            try {
                jSONObject.put("type", this.f61269a);
                jSONObject.put("timestamp", this.f61270b);
                jSONObject.put(DpStatConstants.KEY_NETWORK_STATUS, VideoPlatformStatic.d());
            } catch (Exception e2) {
                e2.printStackTrace();
            }
            return jSONObject;
        }
    }

    /* renamed from: d.a.o0.m2.b$b  reason: collision with other inner class name */
    /* loaded from: classes5.dex */
    public static abstract class AbstractC1498b implements b {

        /* renamed from: a  reason: collision with root package name */
        public final int f61271a;

        /* renamed from: b  reason: collision with root package name */
        public final String f61272b;

        /* renamed from: c  reason: collision with root package name */
        public final long f61273c = System.currentTimeMillis();

        public AbstractC1498b(int i2, String str) {
            this.f61271a = i2;
            this.f61272b = str;
        }

        @Override // d.a.o0.m2.b
        public JSONObject a() {
            JSONObject jSONObject = new JSONObject();
            try {
                jSONObject.put("type", this.f61271a);
                jSONObject.put("source", this.f61272b);
                jSONObject.put("timestamp", this.f61273c);
            } catch (Exception e2) {
                e2.printStackTrace();
            }
            return jSONObject;
        }
    }

    JSONObject a();
}
