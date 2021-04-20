package d.b.i0.l2;

import com.baidu.cyberplayer.sdk.statistics.DpStatConstants;
import com.baidu.tieba.VideoPlatformStatic;
import org.json.JSONObject;
/* loaded from: classes3.dex */
public interface b {

    /* loaded from: classes3.dex */
    public static abstract class a implements b {

        /* renamed from: a  reason: collision with root package name */
        public final int f58128a;

        /* renamed from: b  reason: collision with root package name */
        public final long f58129b = System.currentTimeMillis();

        public a(int i) {
            this.f58128a = i;
        }

        @Override // d.b.i0.l2.b
        public JSONObject a() {
            JSONObject jSONObject = new JSONObject();
            try {
                jSONObject.put("type", this.f58128a);
                jSONObject.put("timestamp", this.f58129b);
                jSONObject.put(DpStatConstants.KEY_NETWORK_STATUS, VideoPlatformStatic.d());
            } catch (Exception e2) {
                e2.printStackTrace();
            }
            return jSONObject;
        }
    }

    /* renamed from: d.b.i0.l2.b$b  reason: collision with other inner class name */
    /* loaded from: classes3.dex */
    public static abstract class AbstractC1386b implements b {

        /* renamed from: a  reason: collision with root package name */
        public final int f58130a;

        /* renamed from: b  reason: collision with root package name */
        public final String f58131b;

        /* renamed from: c  reason: collision with root package name */
        public final long f58132c = System.currentTimeMillis();

        public AbstractC1386b(int i, String str) {
            this.f58130a = i;
            this.f58131b = str;
        }

        @Override // d.b.i0.l2.b
        public JSONObject a() {
            JSONObject jSONObject = new JSONObject();
            try {
                jSONObject.put("type", this.f58130a);
                jSONObject.put("source", this.f58131b);
                jSONObject.put("timestamp", this.f58132c);
            } catch (Exception e2) {
                e2.printStackTrace();
            }
            return jSONObject;
        }
    }

    JSONObject a();
}
