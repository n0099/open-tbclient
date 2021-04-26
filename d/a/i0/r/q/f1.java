package d.a.i0.r.q;

import com.baidu.adp.lib.util.BdLog;
import com.baidu.tbadk.core.data.UserData;
import java.util.ArrayList;
import org.json.JSONArray;
import org.json.JSONObject;
/* loaded from: classes3.dex */
public class f1 {

    /* renamed from: a  reason: collision with root package name */
    public ArrayList<UserData> f49157a = new ArrayList<>();

    /* renamed from: b  reason: collision with root package name */
    public ArrayList<UserData> f49158b = new ArrayList<>();

    /* renamed from: c  reason: collision with root package name */
    public z0 f49159c = new z0();

    /* renamed from: d  reason: collision with root package name */
    public int f49160d = 0;

    /* renamed from: e  reason: collision with root package name */
    public int f49161e = 0;

    public int a() {
        return this.f49161e;
    }

    public ArrayList<UserData> b() {
        return this.f49158b;
    }

    public int c() {
        return this.f49160d;
    }

    public z0 d() {
        return this.f49159c;
    }

    public ArrayList<UserData> e() {
        return this.f49157a;
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
                    this.f49157a.add(userData);
                }
            }
            if (optJSONArray2 != null) {
                for (int i3 = 0; i3 < optJSONArray2.length(); i3++) {
                    UserData userData2 = new UserData();
                    userData2.parserJson(optJSONArray2.getJSONObject(i3));
                    userData2.mAttentionType = 1;
                    this.f49158b.add(userData2);
                }
            }
            this.f49159c.i(jSONObject.optJSONObject("page"));
            this.f49160d = jSONObject.optInt("tafriendnum", 0);
            this.f49161e = jSONObject.optInt("commonfriendnum", 0);
        } catch (Exception e2) {
            BdLog.detailException(e2);
        }
    }

    public void h(z0 z0Var) {
        this.f49159c = z0Var;
    }
}
