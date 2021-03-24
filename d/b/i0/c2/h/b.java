package d.b.i0.c2.h;

import com.baidu.tbadk.core.atomData.CardBoxMemberPayActivityConfig;
import org.json.JSONObject;
import tbclient.SendCardInfo;
/* loaded from: classes4.dex */
public class b {

    /* renamed from: a  reason: collision with root package name */
    public long f52407a;

    /* renamed from: b  reason: collision with root package name */
    public String f52408b;

    /* renamed from: c  reason: collision with root package name */
    public String f52409c;

    /* renamed from: d  reason: collision with root package name */
    public String f52410d;

    /* renamed from: e  reason: collision with root package name */
    public int f52411e;

    /* renamed from: f  reason: collision with root package name */
    public String f52412f;

    public boolean a() {
        return this.f52411e == 3;
    }

    public boolean b() {
        return this.f52411e == 1;
    }

    public void c(JSONObject jSONObject) {
        if (jSONObject != null) {
            this.f52408b = jSONObject.optString("card_logo");
            this.f52409c = jSONObject.optString("card_name");
            this.f52410d = jSONObject.optString("card_pro");
            this.f52411e = jSONObject.optInt("card_get_status");
            this.f52407a = jSONObject.optLong(CardBoxMemberPayActivityConfig.PACKET_ID);
            this.f52412f = jSONObject.optString("card_num");
        }
    }

    public void d(SendCardInfo sendCardInfo) {
        if (sendCardInfo != null) {
            this.f52408b = sendCardInfo.card_logo;
            this.f52409c = sendCardInfo.card_name;
            this.f52410d = sendCardInfo.card_pro;
            this.f52411e = sendCardInfo.card_get_status.intValue();
            this.f52407a = sendCardInfo.packet_id.longValue();
        }
    }
}
