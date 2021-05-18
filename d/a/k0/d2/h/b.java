package d.a.k0.d2.h;

import com.baidu.tbadk.core.atomData.CardBoxMemberPayActivityConfig;
import org.json.JSONObject;
import tbclient.SendCardInfo;
/* loaded from: classes4.dex */
public class b {

    /* renamed from: a  reason: collision with root package name */
    public long f52702a;

    /* renamed from: b  reason: collision with root package name */
    public String f52703b;

    /* renamed from: c  reason: collision with root package name */
    public String f52704c;

    /* renamed from: d  reason: collision with root package name */
    public String f52705d;

    /* renamed from: e  reason: collision with root package name */
    public int f52706e;

    /* renamed from: f  reason: collision with root package name */
    public String f52707f;

    public boolean a() {
        return this.f52706e == 3;
    }

    public boolean b() {
        return this.f52706e == 1;
    }

    public void c(JSONObject jSONObject) {
        if (jSONObject != null) {
            this.f52703b = jSONObject.optString("card_logo");
            this.f52704c = jSONObject.optString("card_name");
            this.f52705d = jSONObject.optString("card_pro");
            this.f52706e = jSONObject.optInt("card_get_status");
            this.f52702a = jSONObject.optLong(CardBoxMemberPayActivityConfig.PACKET_ID);
            this.f52707f = jSONObject.optString("card_num");
        }
    }

    public void d(SendCardInfo sendCardInfo) {
        if (sendCardInfo != null) {
            this.f52703b = sendCardInfo.card_logo;
            this.f52704c = sendCardInfo.card_name;
            this.f52705d = sendCardInfo.card_pro;
            this.f52706e = sendCardInfo.card_get_status.intValue();
            this.f52702a = sendCardInfo.packet_id.longValue();
        }
    }
}
