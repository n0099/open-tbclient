package d.b.i0.c2.h;

import com.baidu.tbadk.core.atomData.CardBoxMemberPayActivityConfig;
import org.json.JSONObject;
import tbclient.SendCardInfo;
/* loaded from: classes4.dex */
public class b {

    /* renamed from: a  reason: collision with root package name */
    public long f52408a;

    /* renamed from: b  reason: collision with root package name */
    public String f52409b;

    /* renamed from: c  reason: collision with root package name */
    public String f52410c;

    /* renamed from: d  reason: collision with root package name */
    public String f52411d;

    /* renamed from: e  reason: collision with root package name */
    public int f52412e;

    /* renamed from: f  reason: collision with root package name */
    public String f52413f;

    public boolean a() {
        return this.f52412e == 3;
    }

    public boolean b() {
        return this.f52412e == 1;
    }

    public void c(JSONObject jSONObject) {
        if (jSONObject != null) {
            this.f52409b = jSONObject.optString("card_logo");
            this.f52410c = jSONObject.optString("card_name");
            this.f52411d = jSONObject.optString("card_pro");
            this.f52412e = jSONObject.optInt("card_get_status");
            this.f52408a = jSONObject.optLong(CardBoxMemberPayActivityConfig.PACKET_ID);
            this.f52413f = jSONObject.optString("card_num");
        }
    }

    public void d(SendCardInfo sendCardInfo) {
        if (sendCardInfo != null) {
            this.f52409b = sendCardInfo.card_logo;
            this.f52410c = sendCardInfo.card_name;
            this.f52411d = sendCardInfo.card_pro;
            this.f52412e = sendCardInfo.card_get_status.intValue();
            this.f52408a = sendCardInfo.packet_id.longValue();
        }
    }
}
