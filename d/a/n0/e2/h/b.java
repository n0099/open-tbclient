package d.a.n0.e2.h;

import com.baidu.tbadk.core.atomData.CardBoxMemberPayActivityConfig;
import org.json.JSONObject;
import tbclient.SendCardInfo;
/* loaded from: classes5.dex */
public class b {

    /* renamed from: a  reason: collision with root package name */
    public long f56596a;

    /* renamed from: b  reason: collision with root package name */
    public String f56597b;

    /* renamed from: c  reason: collision with root package name */
    public String f56598c;

    /* renamed from: d  reason: collision with root package name */
    public String f56599d;

    /* renamed from: e  reason: collision with root package name */
    public int f56600e;

    /* renamed from: f  reason: collision with root package name */
    public String f56601f;

    public boolean a() {
        return this.f56600e == 3;
    }

    public boolean b() {
        return this.f56600e == 1;
    }

    public void c(JSONObject jSONObject) {
        if (jSONObject != null) {
            this.f56597b = jSONObject.optString("card_logo");
            this.f56598c = jSONObject.optString("card_name");
            this.f56599d = jSONObject.optString("card_pro");
            this.f56600e = jSONObject.optInt("card_get_status");
            this.f56596a = jSONObject.optLong(CardBoxMemberPayActivityConfig.PACKET_ID);
            this.f56601f = jSONObject.optString("card_num");
        }
    }

    public void d(SendCardInfo sendCardInfo) {
        if (sendCardInfo != null) {
            this.f56597b = sendCardInfo.card_logo;
            this.f56598c = sendCardInfo.card_name;
            this.f56599d = sendCardInfo.card_pro;
            this.f56600e = sendCardInfo.card_get_status.intValue();
            this.f56596a = sendCardInfo.packet_id.longValue();
        }
    }
}
