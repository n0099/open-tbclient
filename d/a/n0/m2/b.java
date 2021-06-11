package d.a.n0.m2;

import com.baidu.cyberplayer.sdk.statistics.DpStatConstants;
import com.baidu.tieba.VideoPlatformStatic;
import org.json.JSONObject;
/* loaded from: classes5.dex */
public interface b {

    /* loaded from: classes5.dex */
    public static abstract class a implements b {

        /* renamed from: a  reason: collision with root package name */
        public final int f61144a;

        /* renamed from: b  reason: collision with root package name */
        public final long f61145b = System.currentTimeMillis();

        public a(int i2) {
            this.f61144a = i2;
        }

        @Override // d.a.n0.m2.b
        public JSONObject a() {
            JSONObject jSONObject = new JSONObject();
            try {
                jSONObject.put("type", this.f61144a);
                jSONObject.put("timestamp", this.f61145b);
                jSONObject.put(DpStatConstants.KEY_NETWORK_STATUS, VideoPlatformStatic.d());
            } catch (Exception e2) {
                e2.printStackTrace();
            }
            return jSONObject;
        }
    }

    /* renamed from: d.a.n0.m2.b$b  reason: collision with other inner class name */
    /* loaded from: classes5.dex */
    public static abstract class AbstractC1494b implements b {

        /* renamed from: a  reason: collision with root package name */
        public final int f61146a;

        /* renamed from: b  reason: collision with root package name */
        public final String f61147b;

        /* renamed from: c  reason: collision with root package name */
        public final long f61148c = System.currentTimeMillis();

        public AbstractC1494b(int i2, String str) {
            this.f61146a = i2;
            this.f61147b = str;
        }

        @Override // d.a.n0.m2.b
        public JSONObject a() {
            JSONObject jSONObject = new JSONObject();
            try {
                jSONObject.put("type", this.f61146a);
                jSONObject.put("source", this.f61147b);
                jSONObject.put("timestamp", this.f61148c);
            } catch (Exception e2) {
                e2.printStackTrace();
            }
            return jSONObject;
        }
    }

    JSONObject a();
}
