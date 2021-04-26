package d.a.i0.s.c;

import android.text.TextUtils;
import com.baidu.tbadk.core.atomData.LowFlowsActivityConfig;
import org.json.JSONObject;
/* loaded from: classes3.dex */
public class x {

    /* renamed from: a  reason: collision with root package name */
    public int f49649a;

    /* renamed from: b  reason: collision with root package name */
    public String f49650b;

    /* renamed from: c  reason: collision with root package name */
    public String f49651c;

    /* renamed from: d  reason: collision with root package name */
    public String f49652d;

    /* renamed from: e  reason: collision with root package name */
    public boolean f49653e;

    public boolean a() {
        return TextUtils.isEmpty(this.f49650b) || this.f49649a <= 0;
    }

    public void b(JSONObject jSONObject) {
        if (jSONObject == null || jSONObject == null) {
            return;
        }
        this.f49649a = jSONObject.optInt("tab_type");
        this.f49650b = jSONObject.optString("tab_name");
        this.f49651c = jSONObject.optString(LowFlowsActivityConfig.TAB_CODE);
        this.f49652d = jSONObject.optString("tab_version");
    }
}
