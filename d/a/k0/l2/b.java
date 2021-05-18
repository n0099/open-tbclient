package d.a.k0.l2;

import com.baidu.cyberplayer.sdk.statistics.DpStatConstants;
import com.baidu.tieba.VideoPlatformStatic;
import org.json.JSONObject;
/* loaded from: classes5.dex */
public interface b {

    /* loaded from: classes5.dex */
    public static abstract class a implements b {

        /* renamed from: a  reason: collision with root package name */
        public final int f57265a;

        /* renamed from: b  reason: collision with root package name */
        public final long f57266b = System.currentTimeMillis();

        public a(int i2) {
            this.f57265a = i2;
        }

        @Override // d.a.k0.l2.b
        public JSONObject a() {
            JSONObject jSONObject = new JSONObject();
            try {
                jSONObject.put("type", this.f57265a);
                jSONObject.put("timestamp", this.f57266b);
                jSONObject.put(DpStatConstants.KEY_NETWORK_STATUS, VideoPlatformStatic.d());
            } catch (Exception e2) {
                e2.printStackTrace();
            }
            return jSONObject;
        }
    }

    /* renamed from: d.a.k0.l2.b$b  reason: collision with other inner class name */
    /* loaded from: classes5.dex */
    public static abstract class AbstractC1420b implements b {

        /* renamed from: a  reason: collision with root package name */
        public final int f57267a;

        /* renamed from: b  reason: collision with root package name */
        public final String f57268b;

        /* renamed from: c  reason: collision with root package name */
        public final long f57269c = System.currentTimeMillis();

        public AbstractC1420b(int i2, String str) {
            this.f57267a = i2;
            this.f57268b = str;
        }

        @Override // d.a.k0.l2.b
        public JSONObject a() {
            JSONObject jSONObject = new JSONObject();
            try {
                jSONObject.put("type", this.f57267a);
                jSONObject.put("source", this.f57268b);
                jSONObject.put("timestamp", this.f57269c);
            } catch (Exception e2) {
                e2.printStackTrace();
            }
            return jSONObject;
        }
    }

    JSONObject a();
}
