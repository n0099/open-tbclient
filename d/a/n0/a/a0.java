package d.a.n0.a;

import com.baidu.tbadk.core.util.UtilHelper;
import org.json.JSONArray;
/* loaded from: classes3.dex */
public class a0 {

    /* renamed from: a  reason: collision with root package name */
    public long f52388a;

    /* renamed from: b  reason: collision with root package name */
    public long f52389b;

    public long a() {
        return this.f52389b + UtilHelper.getTimesMorning();
    }

    public long b() {
        return this.f52388a + UtilHelper.getTimesMorning();
    }

    public void c(JSONArray jSONArray) {
        if (jSONArray == null || jSONArray.length() != 2) {
            return;
        }
        this.f52388a = jSONArray.optLong(0, 0L) * 1000;
        this.f52389b = jSONArray.optLong(1, 0L) * 1000;
    }
}
