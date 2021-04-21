package d.b.j0.d2.h;

import com.baidu.tbadk.core.atomData.CardBoxMemberPayActivityConfig;
import org.json.JSONObject;
import tbclient.SendCardInfo;
/* loaded from: classes3.dex */
public class b {

    /* renamed from: a  reason: collision with root package name */
    public long f54224a;

    /* renamed from: b  reason: collision with root package name */
    public String f54225b;

    /* renamed from: c  reason: collision with root package name */
    public String f54226c;

    /* renamed from: d  reason: collision with root package name */
    public String f54227d;

    /* renamed from: e  reason: collision with root package name */
    public int f54228e;

    /* renamed from: f  reason: collision with root package name */
    public String f54229f;

    public boolean a() {
        return this.f54228e == 3;
    }

    public boolean b() {
        return this.f54228e == 1;
    }

    public void c(JSONObject jSONObject) {
        if (jSONObject != null) {
            this.f54225b = jSONObject.optString("card_logo");
            this.f54226c = jSONObject.optString("card_name");
            this.f54227d = jSONObject.optString("card_pro");
            this.f54228e = jSONObject.optInt("card_get_status");
            this.f54224a = jSONObject.optLong(CardBoxMemberPayActivityConfig.PACKET_ID);
            this.f54229f = jSONObject.optString("card_num");
        }
    }

    public void d(SendCardInfo sendCardInfo) {
        if (sendCardInfo != null) {
            this.f54225b = sendCardInfo.card_logo;
            this.f54226c = sendCardInfo.card_name;
            this.f54227d = sendCardInfo.card_pro;
            this.f54228e = sendCardInfo.card_get_status.intValue();
            this.f54224a = sendCardInfo.packet_id.longValue();
        }
    }
}
