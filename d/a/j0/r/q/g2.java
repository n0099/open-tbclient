package d.a.j0.r.q;

import org.json.JSONObject;
import tbclient.BirthdayInfo;
/* loaded from: classes3.dex */
public class g2 {

    /* renamed from: a  reason: collision with root package name */
    public long f49990a;

    /* renamed from: b  reason: collision with root package name */
    public String f49991b;

    /* renamed from: c  reason: collision with root package name */
    public int f49992c;

    /* renamed from: d  reason: collision with root package name */
    public int f49993d;

    public void a(JSONObject jSONObject) {
        if (jSONObject == null) {
            return;
        }
        this.f49990a = jSONObject.optLong("birthday_time", 0L);
        this.f49993d = jSONObject.optInt("birthday_show_status", 0);
        this.f49991b = jSONObject.optString("constellation", "");
        this.f49992c = jSONObject.optInt("age", 0);
    }

    public void b(BirthdayInfo birthdayInfo) {
        if (birthdayInfo == null) {
            return;
        }
        this.f49990a = birthdayInfo.birthday_time.longValue();
        this.f49993d = birthdayInfo.birthday_show_status.intValue();
        this.f49991b = birthdayInfo.constellation;
        this.f49992c = birthdayInfo.age.intValue();
    }
}
