package d.a.o0.e2.h;

import com.baidu.tbadk.core.atomData.CardBoxMemberPayActivityConfig;
import org.json.JSONObject;
import tbclient.SendCardInfo;
/* loaded from: classes5.dex */
public class b {

    /* renamed from: a  reason: collision with root package name */
    public long f56721a;

    /* renamed from: b  reason: collision with root package name */
    public String f56722b;

    /* renamed from: c  reason: collision with root package name */
    public String f56723c;

    /* renamed from: d  reason: collision with root package name */
    public String f56724d;

    /* renamed from: e  reason: collision with root package name */
    public int f56725e;

    /* renamed from: f  reason: collision with root package name */
    public String f56726f;

    public boolean a() {
        return this.f56725e == 3;
    }

    public boolean b() {
        return this.f56725e == 1;
    }

    public void c(JSONObject jSONObject) {
        if (jSONObject != null) {
            this.f56722b = jSONObject.optString("card_logo");
            this.f56723c = jSONObject.optString("card_name");
            this.f56724d = jSONObject.optString("card_pro");
            this.f56725e = jSONObject.optInt("card_get_status");
            this.f56721a = jSONObject.optLong(CardBoxMemberPayActivityConfig.PACKET_ID);
            this.f56726f = jSONObject.optString("card_num");
        }
    }

    public void d(SendCardInfo sendCardInfo) {
        if (sendCardInfo != null) {
            this.f56722b = sendCardInfo.card_logo;
            this.f56723c = sendCardInfo.card_name;
            this.f56724d = sendCardInfo.card_pro;
            this.f56725e = sendCardInfo.card_get_status.intValue();
            this.f56721a = sendCardInfo.packet_id.longValue();
        }
    }
}
