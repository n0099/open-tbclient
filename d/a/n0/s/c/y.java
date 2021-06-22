package d.a.n0.s.c;

import android.text.TextUtils;
import com.baidu.tbadk.core.atomData.LowFlowsActivityConfig;
import org.json.JSONObject;
/* loaded from: classes3.dex */
public class y {

    /* renamed from: a  reason: collision with root package name */
    public int f54327a;

    /* renamed from: b  reason: collision with root package name */
    public String f54328b;

    /* renamed from: c  reason: collision with root package name */
    public String f54329c;

    /* renamed from: d  reason: collision with root package name */
    public String f54330d;

    /* renamed from: e  reason: collision with root package name */
    public String f54331e;

    /* renamed from: f  reason: collision with root package name */
    public boolean f54332f;

    public boolean a() {
        return TextUtils.isEmpty(this.f54328b) || this.f54327a <= 0;
    }

    public void b(JSONObject jSONObject) {
        if (jSONObject == null || jSONObject == null) {
            return;
        }
        this.f54327a = jSONObject.optInt("tab_type");
        this.f54328b = jSONObject.optString("tab_name");
        this.f54329c = jSONObject.optString(LowFlowsActivityConfig.TAB_CODE);
        this.f54330d = jSONObject.optString("tab_url");
        this.f54331e = jSONObject.optString("tab_version");
    }
}
