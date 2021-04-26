package d.a.i0.a;

import com.baidu.tbadk.core.util.UtilHelper;
import org.json.JSONArray;
/* loaded from: classes3.dex */
public class x {

    /* renamed from: a  reason: collision with root package name */
    public long f47937a;

    /* renamed from: b  reason: collision with root package name */
    public long f47938b;

    public long a() {
        return this.f47938b + UtilHelper.getTimesMorning();
    }

    public long b() {
        return this.f47937a + UtilHelper.getTimesMorning();
    }

    public void c(JSONArray jSONArray) {
        if (jSONArray == null || jSONArray.length() != 2) {
            return;
        }
        this.f47937a = jSONArray.optLong(0, 0L) * 1000;
        this.f47938b = jSONArray.optLong(1, 0L) * 1000;
    }
}
