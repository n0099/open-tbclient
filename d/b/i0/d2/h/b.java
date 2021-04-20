package d.b.i0.d2.h;

import com.baidu.tbadk.core.atomData.CardBoxMemberPayActivityConfig;
import org.json.JSONObject;
import tbclient.SendCardInfo;
/* loaded from: classes3.dex */
public class b {

    /* renamed from: a  reason: collision with root package name */
    public long f53803a;

    /* renamed from: b  reason: collision with root package name */
    public String f53804b;

    /* renamed from: c  reason: collision with root package name */
    public String f53805c;

    /* renamed from: d  reason: collision with root package name */
    public String f53806d;

    /* renamed from: e  reason: collision with root package name */
    public int f53807e;

    /* renamed from: f  reason: collision with root package name */
    public String f53808f;

    public boolean a() {
        return this.f53807e == 3;
    }

    public boolean b() {
        return this.f53807e == 1;
    }

    public void c(JSONObject jSONObject) {
        if (jSONObject != null) {
            this.f53804b = jSONObject.optString("card_logo");
            this.f53805c = jSONObject.optString("card_name");
            this.f53806d = jSONObject.optString("card_pro");
            this.f53807e = jSONObject.optInt("card_get_status");
            this.f53803a = jSONObject.optLong(CardBoxMemberPayActivityConfig.PACKET_ID);
            this.f53808f = jSONObject.optString("card_num");
        }
    }

    public void d(SendCardInfo sendCardInfo) {
        if (sendCardInfo != null) {
            this.f53804b = sendCardInfo.card_logo;
            this.f53805c = sendCardInfo.card_name;
            this.f53806d = sendCardInfo.card_pro;
            this.f53807e = sendCardInfo.card_get_status.intValue();
            this.f53803a = sendCardInfo.packet_id.longValue();
        }
    }
}
