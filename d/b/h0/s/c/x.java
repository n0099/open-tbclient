package d.b.h0.s.c;

import android.text.TextUtils;
import com.baidu.tbadk.core.atomData.LowFlowsActivityConfig;
import org.json.JSONObject;
/* loaded from: classes3.dex */
public class x {

    /* renamed from: a  reason: collision with root package name */
    public int f51658a;

    /* renamed from: b  reason: collision with root package name */
    public String f51659b;

    /* renamed from: c  reason: collision with root package name */
    public String f51660c;

    /* renamed from: d  reason: collision with root package name */
    public String f51661d;

    /* renamed from: e  reason: collision with root package name */
    public boolean f51662e;

    public boolean a() {
        return TextUtils.isEmpty(this.f51659b) || this.f51658a <= 0;
    }

    public void b(JSONObject jSONObject) {
        if (jSONObject == null || jSONObject == null) {
            return;
        }
        this.f51658a = jSONObject.optInt("tab_type");
        this.f51659b = jSONObject.optString("tab_name");
        this.f51660c = jSONObject.optString(LowFlowsActivityConfig.TAB_CODE);
        this.f51661d = jSONObject.optString("tab_version");
    }
}
