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
    public UserData f50862a = new UserData();

    /* renamed from: b  reason: collision with root package name */
    public AntiData f50863b = new AntiData();

    /* renamed from: c  reason: collision with root package name */
    public ArrayList<String> f50864c;

    public q0() {
        this.f50864c = null;
        this.f50864c = new ArrayList<>();
        e(0);
    }

    public AntiData a() {
        return this.f50863b;
    }

    public UserData b() {
        return this.f50862a;
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
            this.f50862a.parserJson(jSONObject.optJSONObject("user"));
            this.f50863b.parserJson(jSONObject.optJSONObject(SubPbActivityConfig.KEY_ANTI));
            JSONArray optJSONArray = jSONObject.optJSONArray("suggnames");
            if (optJSONArray != null) {
                for (int i = 0; i < optJSONArray.length(); i++) {
                    this.f50864c.add(optJSONArray.optString(i, null));
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
