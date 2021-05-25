package d.a.n0.e2.h;

import com.baidu.tbadk.core.atomData.CardBoxMemberPayActivityConfig;
import org.json.JSONObject;
import tbclient.SendCardInfo;
/* loaded from: classes4.dex */
public class b {

    /* renamed from: a  reason: collision with root package name */
    public long f52907a;

    /* renamed from: b  reason: collision with root package name */
    public String f52908b;

    /* renamed from: c  reason: collision with root package name */
    public String f52909c;

    /* renamed from: d  reason: collision with root package name */
    public String f52910d;

    /* renamed from: e  reason: collision with root package name */
    public int f52911e;

    /* renamed from: f  reason: collision with root package name */
    public String f52912f;

    public boolean a() {
        return this.f52911e == 3;
    }

    public boolean b() {
        return this.f52911e == 1;
    }

    public void c(JSONObject jSONObject) {
        if (jSONObject != null) {
            this.f52908b = jSONObject.optString("card_logo");
            this.f52909c = jSONObject.optString("card_name");
            this.f52910d = jSONObject.optString("card_pro");
            this.f52911e = jSONObject.optInt("card_get_status");
            this.f52907a = jSONObject.optLong(CardBoxMemberPayActivityConfig.PACKET_ID);
            this.f52912f = jSONObject.optString("card_num");
        }
    }

    public void d(SendCardInfo sendCardInfo) {
        if (sendCardInfo != null) {
            this.f52908b = sendCardInfo.card_logo;
            this.f52909c = sendCardInfo.card_name;
            this.f52910d = sendCardInfo.card_pro;
            this.f52911e = sendCardInfo.card_get_status.intValue();
            this.f52907a = sendCardInfo.packet_id.longValue();
        }
    }
}
