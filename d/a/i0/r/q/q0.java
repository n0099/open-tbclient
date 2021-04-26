package d.a.i0.r.q;

import com.baidu.adp.lib.util.BdLog;
import com.baidu.tbadk.core.atomData.SubPbActivityConfig;
import com.baidu.tbadk.core.data.AntiData;
import com.baidu.tbadk.core.data.UserData;
import java.util.ArrayList;
import org.json.JSONArray;
import org.json.JSONObject;
/* loaded from: classes3.dex */
public class q0 {

    /* renamed from: a  reason: collision with root package name */
    public UserData f49237a = new UserData();

    /* renamed from: b  reason: collision with root package name */
    public AntiData f49238b = new AntiData();

    /* renamed from: c  reason: collision with root package name */
    public ArrayList<String> f49239c;

    public q0() {
        this.f49239c = null;
        this.f49239c = new ArrayList<>();
        e(0);
    }

    public AntiData a() {
        return this.f49238b;
    }

    public UserData b() {
        return this.f49237a;
    }

    public void c(String str) {
        try {
            d(new JSONObject(str));
        } catch (Exception e2) {
            BdLog.e(e2.getMessage());
        }
    }

    public void d(JSONObject jSONObject) {
        try {
            this.f49237a.parserJson(jSONObject.optJSONObject("user"));
            this.f49238b.parserJson(jSONObject.optJSONObject(SubPbActivityConfig.KEY_ANTI));
            JSONArray optJSONArray = jSONObject.optJSONArray("suggnames");
            if (optJSONArray != null) {
                for (int i2 = 0; i2 < optJSONArray.length(); i2++) {
                    this.f49239c.add(optJSONArray.optString(i2, null));
                }
            }
            e(jSONObject.optInt("retrytime"));
        } catch (Exception e2) {
            BdLog.e(e2.getMessage());
        }
    }

    public void e(int i2) {
    }
}
