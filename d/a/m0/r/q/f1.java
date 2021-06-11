package d.a.m0.r.q;

import com.baidu.adp.lib.util.BdLog;
import com.baidu.tbadk.core.data.UserData;
import java.util.ArrayList;
import org.json.JSONArray;
import org.json.JSONObject;
/* loaded from: classes3.dex */
public class f1 {

    /* renamed from: a  reason: collision with root package name */
    public ArrayList<UserData> f53696a = new ArrayList<>();

    /* renamed from: b  reason: collision with root package name */
    public ArrayList<UserData> f53697b = new ArrayList<>();

    /* renamed from: c  reason: collision with root package name */
    public z0 f53698c = new z0();

    /* renamed from: d  reason: collision with root package name */
    public int f53699d = 0;

    /* renamed from: e  reason: collision with root package name */
    public int f53700e = 0;

    public int a() {
        return this.f53700e;
    }

    public ArrayList<UserData> b() {
        return this.f53697b;
    }

    public int c() {
        return this.f53699d;
    }

    public z0 d() {
        return this.f53698c;
    }

    public ArrayList<UserData> e() {
        return this.f53696a;
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
                for (int i2 = 0; i2 < optJSONArray.length(); i2++) {
                    UserData userData = new UserData();
                    userData.parserJson(optJSONArray.getJSONObject(i2));
                    userData.mAttentionType = 2;
                    this.f53696a.add(userData);
                }
            }
            if (optJSONArray2 != null) {
                for (int i3 = 0; i3 < optJSONArray2.length(); i3++) {
                    UserData userData2 = new UserData();
                    userData2.parserJson(optJSONArray2.getJSONObject(i3));
                    userData2.mAttentionType = 1;
                    this.f53697b.add(userData2);
                }
            }
            this.f53698c.i(jSONObject.optJSONObject("page"));
            this.f53699d = jSONObject.optInt("tafriendnum", 0);
            this.f53700e = jSONObject.optInt("commonfriendnum", 0);
        } catch (Exception e2) {
            BdLog.detailException(e2);
        }
    }

    public void h(z0 z0Var) {
        this.f53698c = z0Var;
    }
}
