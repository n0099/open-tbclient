package d.b.h0.r.q;

import com.baidu.adp.lib.util.BdLog;
import com.baidu.tbadk.core.data.UserData;
import java.util.ArrayList;
import org.json.JSONArray;
import org.json.JSONObject;
/* loaded from: classes3.dex */
public class f1 {

    /* renamed from: a  reason: collision with root package name */
    public ArrayList<UserData> f50786a = new ArrayList<>();

    /* renamed from: b  reason: collision with root package name */
    public ArrayList<UserData> f50787b = new ArrayList<>();

    /* renamed from: c  reason: collision with root package name */
    public z0 f50788c = new z0();

    /* renamed from: d  reason: collision with root package name */
    public int f50789d = 0;

    /* renamed from: e  reason: collision with root package name */
    public int f50790e = 0;

    public int a() {
        return this.f50790e;
    }

    public ArrayList<UserData> b() {
        return this.f50787b;
    }

    public int c() {
        return this.f50789d;
    }

    public z0 d() {
        return this.f50788c;
    }

    public ArrayList<UserData> e() {
        return this.f50786a;
    }

    public void f(String str) {
        try {
            g(new JSONObject(str));
        } catch (Exception e2) {
            BdLog.detailException(e2);
        }
    }

    public void g(JSONObject jSONObject) {
        if (jSONObject == null) {
            return;
        }
        try {
            JSONArray optJSONArray = jSONObject.optJSONArray("user_list");
            JSONArray optJSONArray2 = jSONObject.optJSONArray("common_user_list");
            if (optJSONArray != null) {
                for (int i = 0; i < optJSONArray.length(); i++) {
                    UserData userData = new UserData();
                    userData.parserJson(optJSONArray.getJSONObject(i));
                    userData.mAttentionType = 2;
                    this.f50786a.add(userData);
                }
            }
            if (optJSONArray2 != null) {
                for (int i2 = 0; i2 < optJSONArray2.length(); i2++) {
                    UserData userData2 = new UserData();
                    userData2.parserJson(optJSONArray2.getJSONObject(i2));
                    userData2.mAttentionType = 1;
                    this.f50787b.add(userData2);
                }
            }
            this.f50788c.i(jSONObject.optJSONObject("page"));
            this.f50789d = jSONObject.optInt("tafriendnum", 0);
            this.f50790e = jSONObject.optInt("commonfriendnum", 0);
        } catch (Exception e2) {
            BdLog.detailException(e2);
        }
    }

    public void h(z0 z0Var) {
        this.f50788c = z0Var;
    }
}
