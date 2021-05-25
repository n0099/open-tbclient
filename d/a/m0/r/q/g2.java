package d.a.m0.r.q;

import org.json.JSONObject;
import tbclient.BirthdayInfo;
/* loaded from: classes3.dex */
public class g2 {

    /* renamed from: a  reason: collision with root package name */
    public long f50034a;

    /* renamed from: b  reason: collision with root package name */
    public String f50035b;

    /* renamed from: c  reason: collision with root package name */
    public int f50036c;

    /* renamed from: d  reason: collision with root package name */
    public int f50037d;

    public void a(JSONObject jSONObject) {
        if (jSONObject == null) {
            return;
        }
        this.f50034a = jSONObject.optLong("birthday_time", 0L);
        this.f50037d = jSONObject.optInt("birthday_show_status", 0);
        this.f50035b = jSONObject.optString("constellation", "");
        this.f50036c = jSONObject.optInt("age", 0);
    }

    public void b(BirthdayInfo birthdayInfo) {
        if (birthdayInfo == null) {
            return;
        }
        this.f50034a = birthdayInfo.birthday_time.longValue();
        this.f50037d = birthdayInfo.birthday_show_status.intValue();
        this.f50035b = birthdayInfo.constellation;
        this.f50036c = birthdayInfo.age.intValue();
    }
}
