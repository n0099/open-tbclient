package d.b.h0.r.q;

import org.json.JSONObject;
import tbclient.BirthdayInfo;
/* loaded from: classes3.dex */
public class g2 {

    /* renamed from: a  reason: collision with root package name */
    public long f50800a;

    /* renamed from: b  reason: collision with root package name */
    public String f50801b;

    /* renamed from: c  reason: collision with root package name */
    public int f50802c;

    /* renamed from: d  reason: collision with root package name */
    public int f50803d;

    public void a(JSONObject jSONObject) {
        if (jSONObject == null) {
            return;
        }
        this.f50800a = jSONObject.optLong("birthday_time", 0L);
        this.f50803d = jSONObject.optInt("birthday_show_status", 0);
        this.f50801b = jSONObject.optString("constellation", "");
        this.f50802c = jSONObject.optInt("age", 0);
    }

    public void b(BirthdayInfo birthdayInfo) {
        if (birthdayInfo == null) {
            return;
        }
        this.f50800a = birthdayInfo.birthday_time.longValue();
        this.f50803d = birthdayInfo.birthday_show_status.intValue();
        this.f50801b = birthdayInfo.constellation;
        this.f50802c = birthdayInfo.age.intValue();
    }
}
