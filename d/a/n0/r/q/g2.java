package d.a.n0.r.q;

import org.json.JSONObject;
import tbclient.BirthdayInfo;
/* loaded from: classes3.dex */
public class g2 {

    /* renamed from: a  reason: collision with root package name */
    public long f53817a;

    /* renamed from: b  reason: collision with root package name */
    public String f53818b;

    /* renamed from: c  reason: collision with root package name */
    public int f53819c;

    /* renamed from: d  reason: collision with root package name */
    public int f53820d;

    public void a(JSONObject jSONObject) {
        if (jSONObject == null) {
            return;
        }
        this.f53817a = jSONObject.optLong("birthday_time", 0L);
        this.f53820d = jSONObject.optInt("birthday_show_status", 0);
        this.f53818b = jSONObject.optString("constellation", "");
        this.f53819c = jSONObject.optInt("age", 0);
    }

    public void b(BirthdayInfo birthdayInfo) {
        if (birthdayInfo == null) {
            return;
        }
        this.f53817a = birthdayInfo.birthday_time.longValue();
        this.f53820d = birthdayInfo.birthday_show_status.intValue();
        this.f53818b = birthdayInfo.constellation;
        this.f53819c = birthdayInfo.age.intValue();
    }
}
