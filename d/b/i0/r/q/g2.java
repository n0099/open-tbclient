package d.b.i0.r.q;

import org.json.JSONObject;
import tbclient.BirthdayInfo;
/* loaded from: classes3.dex */
public class g2 {

    /* renamed from: a  reason: collision with root package name */
    public long f51543a;

    /* renamed from: b  reason: collision with root package name */
    public String f51544b;

    /* renamed from: c  reason: collision with root package name */
    public int f51545c;

    /* renamed from: d  reason: collision with root package name */
    public int f51546d;

    public void a(JSONObject jSONObject) {
        if (jSONObject == null) {
            return;
        }
        this.f51543a = jSONObject.optLong("birthday_time", 0L);
        this.f51546d = jSONObject.optInt("birthday_show_status", 0);
        this.f51544b = jSONObject.optString("constellation", "");
        this.f51545c = jSONObject.optInt("age", 0);
    }

    public void b(BirthdayInfo birthdayInfo) {
        if (birthdayInfo == null) {
            return;
        }
        this.f51543a = birthdayInfo.birthday_time.longValue();
        this.f51546d = birthdayInfo.birthday_show_status.intValue();
        this.f51544b = birthdayInfo.constellation;
        this.f51545c = birthdayInfo.age.intValue();
    }
}
