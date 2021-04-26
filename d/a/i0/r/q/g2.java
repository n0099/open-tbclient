package d.a.i0.r.q;

import org.json.JSONObject;
import tbclient.BirthdayInfo;
/* loaded from: classes3.dex */
public class g2 {

    /* renamed from: a  reason: collision with root package name */
    public long f49171a;

    /* renamed from: b  reason: collision with root package name */
    public String f49172b;

    /* renamed from: c  reason: collision with root package name */
    public int f49173c;

    /* renamed from: d  reason: collision with root package name */
    public int f49174d;

    public void a(JSONObject jSONObject) {
        if (jSONObject == null) {
            return;
        }
        this.f49171a = jSONObject.optLong("birthday_time", 0L);
        this.f49174d = jSONObject.optInt("birthday_show_status", 0);
        this.f49172b = jSONObject.optString("constellation", "");
        this.f49173c = jSONObject.optInt("age", 0);
    }

    public void b(BirthdayInfo birthdayInfo) {
        if (birthdayInfo == null) {
            return;
        }
        this.f49171a = birthdayInfo.birthday_time.longValue();
        this.f49174d = birthdayInfo.birthday_show_status.intValue();
        this.f49172b = birthdayInfo.constellation;
        this.f49173c = birthdayInfo.age.intValue();
    }
}
