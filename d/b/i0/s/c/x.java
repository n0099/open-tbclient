package d.b.i0.s.c;

import android.text.TextUtils;
import com.baidu.tbadk.core.atomData.LowFlowsActivityConfig;
import org.json.JSONObject;
/* loaded from: classes3.dex */
public class x {

    /* renamed from: a  reason: collision with root package name */
    public int f51994a;

    /* renamed from: b  reason: collision with root package name */
    public String f51995b;

    /* renamed from: c  reason: collision with root package name */
    public String f51996c;

    /* renamed from: d  reason: collision with root package name */
    public String f51997d;

    /* renamed from: e  reason: collision with root package name */
    public boolean f51998e;

    public boolean a() {
        return TextUtils.isEmpty(this.f51995b) || this.f51994a <= 0;
    }

    public void b(JSONObject jSONObject) {
        if (jSONObject == null || jSONObject == null) {
            return;
        }
        this.f51994a = jSONObject.optInt("tab_type");
        this.f51995b = jSONObject.optString("tab_name");
        this.f51996c = jSONObject.optString(LowFlowsActivityConfig.TAB_CODE);
        this.f51997d = jSONObject.optString("tab_version");
    }
}
