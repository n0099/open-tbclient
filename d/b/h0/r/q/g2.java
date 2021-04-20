package d.b.h0.r.q;

import org.json.JSONObject;
import tbclient.BirthdayInfo;
/* loaded from: classes3.dex */
public class g2 {

    /* renamed from: a  reason: collision with root package name */
    public long f51207a;

    /* renamed from: b  reason: collision with root package name */
    public String f51208b;

    /* renamed from: c  reason: collision with root package name */
    public int f51209c;

    /* renamed from: d  reason: collision with root package name */
    public int f51210d;

    public void a(JSONObject jSONObject) {
        if (jSONObject == null) {
            return;
        }
        this.f51207a = jSONObject.optLong("birthday_time", 0L);
        this.f51210d = jSONObject.optInt("birthday_show_status", 0);
        this.f51208b = jSONObject.optString("constellation", "");
        this.f51209c = jSONObject.optInt("age", 0);
    }

    public void b(BirthdayInfo birthdayInfo) {
        if (birthdayInfo == null) {
            return;
        }
        this.f51207a = birthdayInfo.birthday_time.longValue();
        this.f51210d = birthdayInfo.birthday_show_status.intValue();
        this.f51208b = birthdayInfo.constellation;
        this.f51209c = birthdayInfo.age.intValue();
    }
}
