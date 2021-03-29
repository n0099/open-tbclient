package d.b.i0.k2;

import com.baidu.cyberplayer.sdk.statistics.DpStatConstants;
import com.baidu.tieba.VideoPlatformStatic;
import org.json.JSONObject;
/* loaded from: classes5.dex */
public interface b {

    /* loaded from: classes5.dex */
    public static abstract class a implements b {

        /* renamed from: a  reason: collision with root package name */
        public final int f56457a;

        /* renamed from: b  reason: collision with root package name */
        public final long f56458b = System.currentTimeMillis();

        public a(int i) {
            this.f56457a = i;
        }

        @Override // d.b.i0.k2.b
        public JSONObject a() {
            JSONObject jSONObject = new JSONObject();
            try {
                jSONObject.put("type", this.f56457a);
                jSONObject.put("timestamp", this.f56458b);
                jSONObject.put(DpStatConstants.KEY_NETWORK_STATUS, VideoPlatformStatic.d());
            } catch (Exception e2) {
                e2.printStackTrace();
            }
            return jSONObject;
        }
    }

    /* renamed from: d.b.i0.k2.b$b  reason: collision with other inner class name */
    /* loaded from: classes5.dex */
    public static abstract class AbstractC1324b implements b {

        /* renamed from: a  reason: collision with root package name */
        public final int f56459a;

        /* renamed from: b  reason: collision with root package name */
        public final String f56460b;

        /* renamed from: c  reason: collision with root package name */
        public final long f56461c = System.currentTimeMillis();

        public AbstractC1324b(int i, String str) {
            this.f56459a = i;
            this.f56460b = str;
        }

        @Override // d.b.i0.k2.b
        public JSONObject a() {
            JSONObject jSONObject = new JSONObject();
            try {
                jSONObject.put("type", this.f56459a);
                jSONObject.put("source", this.f56460b);
                jSONObject.put("timestamp", this.f56461c);
            } catch (Exception e2) {
                e2.printStackTrace();
            }
            return jSONObject;
        }
    }

    JSONObject a();
}
