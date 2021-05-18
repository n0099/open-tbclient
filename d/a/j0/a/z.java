package d.a.j0.a;

import com.baidu.tbadk.core.util.UtilHelper;
import org.json.JSONArray;
/* loaded from: classes3.dex */
public class z {

    /* renamed from: a  reason: collision with root package name */
    public long f48781a;

    /* renamed from: b  reason: collision with root package name */
    public long f48782b;

    public long a() {
        return this.f48782b + UtilHelper.getTimesMorning();
    }

    public long b() {
        return this.f48781a + UtilHelper.getTimesMorning();
    }

    public void c(JSONArray jSONArray) {
        if (jSONArray == null || jSONArray.length() != 2) {
            return;
        }
        this.f48781a = jSONArray.optLong(0, 0L) * 1000;
        this.f48782b = jSONArray.optLong(1, 0L) * 1000;
    }
}
