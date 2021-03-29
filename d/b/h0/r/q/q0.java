package d.b.h0.r.q;

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
    public UserData f50863a = new UserData();

    /* renamed from: b  reason: collision with root package name */
    public AntiData f50864b = new AntiData();

    /* renamed from: c  reason: collision with root package name */
    public ArrayList<String> f50865c;

    public q0() {
        this.f50865c = null;
        this.f50865c = new ArrayList<>();
        e(0);
    }

    public AntiData a() {
        return this.f50864b;
    }

    public UserData b() {
        return this.f50863a;
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
            this.f50863a.parserJson(jSONObject.optJSONObject("user"));
            this.f50864b.parserJson(jSONObject.optJSONObject(SubPbActivityConfig.KEY_ANTI));
            JSONArray optJSONArray = jSONObject.optJSONArray("suggnames");
            if (optJSONArray != null) {
                for (int i = 0; i < optJSONArray.length(); i++) {
                    this.f50865c.add(optJSONArray.optString(i, null));
                }
            }
            e(jSONObject.optInt("retrytime"));
        } catch (Exception e2) {
            BdLog.e(e2.getMessage());
        }
    }

    public void e(int i) {
    }
}
