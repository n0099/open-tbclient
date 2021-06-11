package d.a.m0.a;

import com.baidu.tbadk.core.util.UtilHelper;
import org.json.JSONArray;
/* loaded from: classes3.dex */
public class a0 {

    /* renamed from: a  reason: collision with root package name */
    public long f52281a;

    /* renamed from: b  reason: collision with root package name */
    public long f52282b;

    public long a() {
        return this.f52282b + UtilHelper.getTimesMorning();
    }

    public long b() {
        return this.f52281a + UtilHelper.getTimesMorning();
    }

    public void c(JSONArray jSONArray) {
        if (jSONArray == null || jSONArray.length() != 2) {
            return;
        }
        this.f52281a = jSONArray.optLong(0, 0L) * 1000;
        this.f52282b = jSONArray.optLong(1, 0L) * 1000;
    }
}
