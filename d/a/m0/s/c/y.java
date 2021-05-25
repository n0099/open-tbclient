package d.a.m0.s.c;

import android.text.TextUtils;
import com.baidu.tbadk.core.atomData.LowFlowsActivityConfig;
import org.json.JSONObject;
/* loaded from: classes3.dex */
public class y {

    /* renamed from: a  reason: collision with root package name */
    public int f50544a;

    /* renamed from: b  reason: collision with root package name */
    public String f50545b;

    /* renamed from: c  reason: collision with root package name */
    public String f50546c;

    /* renamed from: d  reason: collision with root package name */
    public String f50547d;

    /* renamed from: e  reason: collision with root package name */
    public boolean f50548e;

    public boolean a() {
        return TextUtils.isEmpty(this.f50545b) || this.f50544a <= 0;
    }

    public void b(JSONObject jSONObject) {
        if (jSONObject == null || jSONObject == null) {
            return;
        }
        this.f50544a = jSONObject.optInt("tab_type");
        this.f50545b = jSONObject.optString("tab_name");
        this.f50546c = jSONObject.optString(LowFlowsActivityConfig.TAB_CODE);
        this.f50547d = jSONObject.optString("tab_version");
    }
}
