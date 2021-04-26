package d.a.j0.d2.h;

import com.baidu.tbadk.core.atomData.CardBoxMemberPayActivityConfig;
import org.json.JSONObject;
import tbclient.SendCardInfo;
/* loaded from: classes3.dex */
public class b {

    /* renamed from: a  reason: collision with root package name */
    public long f52003a;

    /* renamed from: b  reason: collision with root package name */
    public String f52004b;

    /* renamed from: c  reason: collision with root package name */
    public String f52005c;

    /* renamed from: d  reason: collision with root package name */
    public String f52006d;

    /* renamed from: e  reason: collision with root package name */
    public int f52007e;

    /* renamed from: f  reason: collision with root package name */
    public String f52008f;

    public boolean a() {
        return this.f52007e == 3;
    }

    public boolean b() {
        return this.f52007e == 1;
    }

    public void c(JSONObject jSONObject) {
        if (jSONObject != null) {
            this.f52004b = jSONObject.optString("card_logo");
            this.f52005c = jSONObject.optString("card_name");
            this.f52006d = jSONObject.optString("card_pro");
            this.f52007e = jSONObject.optInt("card_get_status");
            this.f52003a = jSONObject.optLong(CardBoxMemberPayActivityConfig.PACKET_ID);
            this.f52008f = jSONObject.optString("card_num");
        }
    }

    public void d(SendCardInfo sendCardInfo) {
        if (sendCardInfo != null) {
            this.f52004b = sendCardInfo.card_logo;
            this.f52005c = sendCardInfo.card_name;
            this.f52006d = sendCardInfo.card_pro;
            this.f52007e = sendCardInfo.card_get_status.intValue();
            this.f52003a = sendCardInfo.packet_id.longValue();
        }
    }
}
