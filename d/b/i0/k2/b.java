package d.b.i0.k2;

import com.baidu.cyberplayer.sdk.statistics.DpStatConstants;
import com.baidu.tieba.VideoPlatformStatic;
import org.json.JSONObject;
/* loaded from: classes5.dex */
public interface b {

    /* loaded from: classes5.dex */
    public static abstract class a implements b {

        /* renamed from: a  reason: collision with root package name */
        public final int f56456a;

        /* renamed from: b  reason: collision with root package name */
        public final long f56457b = System.currentTimeMillis();

        public a(int i) {
            this.f56456a = i;
        }

        @Override // d.b.i0.k2.b
        public JSONObject a() {
            JSONObject jSONObject = new JSONObject();
            try {
                jSONObject.put("type", this.f56456a);
                jSONObject.put("timestamp", this.f56457b);
                jSONObject.put(DpStatConstants.KEY_NETWORK_STATUS, VideoPlatformStatic.d());
            } catch (Exception e2) {
                e2.printStackTrace();
            }
            return jSONObject;
        }
    }

    /* renamed from: d.b.i0.k2.b$b  reason: collision with other inner class name */
    /* loaded from: classes5.dex */
    public static abstract class AbstractC1323b implements b {

        /* renamed from: a  reason: collision with root package name */
        public final int f56458a;

        /* renamed from: b  reason: collision with root package name */
        public final String f56459b;

        /* renamed from: c  reason: collision with root package name */
        public final long f56460c = System.currentTimeMillis();

        public AbstractC1323b(int i, String str) {
            this.f56458a = i;
            this.f56459b = str;
        }

        @Override // d.b.i0.k2.b
        public JSONObject a() {
            JSONObject jSONObject = new JSONObject();
            try {
                jSONObject.put("type", this.f56458a);
                jSONObject.put("source", this.f56459b);
                jSONObject.put("timestamp", this.f56460c);
            } catch (Exception e2) {
                e2.printStackTrace();
            }
            return jSONObject;
        }
    }

    JSONObject a();
}
