package d.a.n0.m2;

import com.baidu.cyberplayer.sdk.statistics.DpStatConstants;
import com.baidu.tieba.VideoPlatformStatic;
import org.json.JSONObject;
/* loaded from: classes5.dex */
public interface b {

    /* loaded from: classes5.dex */
    public static abstract class a implements b {

        /* renamed from: a  reason: collision with root package name */
        public final int f57455a;

        /* renamed from: b  reason: collision with root package name */
        public final long f57456b = System.currentTimeMillis();

        public a(int i2) {
            this.f57455a = i2;
        }

        @Override // d.a.n0.m2.b
        public JSONObject a() {
            JSONObject jSONObject = new JSONObject();
            try {
                jSONObject.put("type", this.f57455a);
                jSONObject.put("timestamp", this.f57456b);
                jSONObject.put(DpStatConstants.KEY_NETWORK_STATUS, VideoPlatformStatic.d());
            } catch (Exception e2) {
                e2.printStackTrace();
            }
            return jSONObject;
        }
    }

    /* renamed from: d.a.n0.m2.b$b  reason: collision with other inner class name */
    /* loaded from: classes5.dex */
    public static abstract class AbstractC1438b implements b {

        /* renamed from: a  reason: collision with root package name */
        public final int f57457a;

        /* renamed from: b  reason: collision with root package name */
        public final String f57458b;

        /* renamed from: c  reason: collision with root package name */
        public final long f57459c = System.currentTimeMillis();

        public AbstractC1438b(int i2, String str) {
            this.f57457a = i2;
            this.f57458b = str;
        }

        @Override // d.a.n0.m2.b
        public JSONObject a() {
            JSONObject jSONObject = new JSONObject();
            try {
                jSONObject.put("type", this.f57457a);
                jSONObject.put("source", this.f57458b);
                jSONObject.put("timestamp", this.f57459c);
            } catch (Exception e2) {
                e2.printStackTrace();
            }
            return jSONObject;
        }
    }

    JSONObject a();
}
