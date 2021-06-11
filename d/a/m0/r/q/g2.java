package d.a.m0.r.q;

import org.json.JSONObject;
import tbclient.BirthdayInfo;
/* loaded from: classes3.dex */
public class g2 {

    /* renamed from: a  reason: collision with root package name */
    public long f53710a;

    /* renamed from: b  reason: collision with root package name */
    public String f53711b;

    /* renamed from: c  reason: collision with root package name */
    public int f53712c;

    /* renamed from: d  reason: collision with root package name */
    public int f53713d;

    public void a(JSONObject jSONObject) {
        if (jSONObject == null) {
            return;
        }
        this.f53710a = jSONObject.optLong("birthday_time", 0L);
        this.f53713d = jSONObject.optInt("birthday_show_status", 0);
        this.f53711b = jSONObject.optString("constellation", "");
        this.f53712c = jSONObject.optInt("age", 0);
    }

    public void b(BirthdayInfo birthdayInfo) {
        if (birthdayInfo == null) {
            return;
        }
        this.f53710a = birthdayInfo.birthday_time.longValue();
        this.f53713d = birthdayInfo.birthday_show_status.intValue();
        this.f53711b = birthdayInfo.constellation;
        this.f53712c = birthdayInfo.age.intValue();
    }
}
