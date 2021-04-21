package d.b.j0.l2;

import com.baidu.cyberplayer.sdk.statistics.DpStatConstants;
import com.baidu.tieba.VideoPlatformStatic;
import org.json.JSONObject;
/* loaded from: classes3.dex */
public interface b {

    /* loaded from: classes3.dex */
    public static abstract class a implements b {

        /* renamed from: a  reason: collision with root package name */
        public final int f58549a;

        /* renamed from: b  reason: collision with root package name */
        public final long f58550b = System.currentTimeMillis();

        public a(int i) {
            this.f58549a = i;
        }

        @Override // d.b.j0.l2.b
        public JSONObject a() {
            JSONObject jSONObject = new JSONObject();
            try {
                jSONObject.put("type", this.f58549a);
                jSONObject.put("timestamp", this.f58550b);
                jSONObject.put(DpStatConstants.KEY_NETWORK_STATUS, VideoPlatformStatic.d());
            } catch (Exception e2) {
                e2.printStackTrace();
            }
            return jSONObject;
        }
    }

    /* renamed from: d.b.j0.l2.b$b  reason: collision with other inner class name */
    /* loaded from: classes3.dex */
    public static abstract class AbstractC1409b implements b {

        /* renamed from: a  reason: collision with root package name */
        public final int f58551a;

        /* renamed from: b  reason: collision with root package name */
        public final String f58552b;

        /* renamed from: c  reason: collision with root package name */
        public final long f58553c = System.currentTimeMillis();

        public AbstractC1409b(int i, String str) {
            this.f58551a = i;
            this.f58552b = str;
        }

        @Override // d.b.j0.l2.b
        public JSONObject a() {
            JSONObject jSONObject = new JSONObject();
            try {
                jSONObject.put("type", this.f58551a);
                jSONObject.put("source", this.f58552b);
                jSONObject.put("timestamp", this.f58553c);
            } catch (Exception e2) {
                e2.printStackTrace();
            }
            return jSONObject;
        }
    }

    JSONObject a();
}
