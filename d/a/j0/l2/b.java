package d.a.j0.l2;

import com.baidu.cyberplayer.sdk.statistics.DpStatConstants;
import com.baidu.tieba.VideoPlatformStatic;
import org.json.JSONObject;
/* loaded from: classes4.dex */
public interface b {

    /* loaded from: classes4.dex */
    public static abstract class a implements b {

        /* renamed from: a  reason: collision with root package name */
        public final int f56558a;

        /* renamed from: b  reason: collision with root package name */
        public final long f56559b = System.currentTimeMillis();

        public a(int i2) {
            this.f56558a = i2;
        }

        @Override // d.a.j0.l2.b
        public JSONObject a() {
            JSONObject jSONObject = new JSONObject();
            try {
                jSONObject.put("type", this.f56558a);
                jSONObject.put("timestamp", this.f56559b);
                jSONObject.put(DpStatConstants.KEY_NETWORK_STATUS, VideoPlatformStatic.d());
            } catch (Exception e2) {
                e2.printStackTrace();
            }
            return jSONObject;
        }
    }

    /* renamed from: d.a.j0.l2.b$b  reason: collision with other inner class name */
    /* loaded from: classes4.dex */
    public static abstract class AbstractC1348b implements b {

        /* renamed from: a  reason: collision with root package name */
        public final int f56560a;

        /* renamed from: b  reason: collision with root package name */
        public final String f56561b;

        /* renamed from: c  reason: collision with root package name */
        public final long f56562c = System.currentTimeMillis();

        public AbstractC1348b(int i2, String str) {
            this.f56560a = i2;
            this.f56561b = str;
        }

        @Override // d.a.j0.l2.b
        public JSONObject a() {
            JSONObject jSONObject = new JSONObject();
            try {
                jSONObject.put("type", this.f56560a);
                jSONObject.put("source", this.f56561b);
                jSONObject.put("timestamp", this.f56562c);
            } catch (Exception e2) {
                e2.printStackTrace();
            }
            return jSONObject;
        }
    }

    JSONObject a();
}
