package d.a.m0.r.q;

import com.baidu.adp.lib.util.BdLog;
import com.baidu.mobstat.Config;
import com.baidu.tbadk.core.data.UserData;
import java.util.ArrayList;
import org.json.JSONArray;
import org.json.JSONObject;
/* loaded from: classes3.dex */
public class g1 {

    /* renamed from: a  reason: collision with root package name */
    public ArrayList<UserData> f53701a = new ArrayList<>();

    /* renamed from: b  reason: collision with root package name */
    public ArrayList<UserData> f53702b = new ArrayList<>();

    /* renamed from: c  reason: collision with root package name */
    public z0 f53703c = new z0();

    /* renamed from: d  reason: collision with root package name */
    public int f53704d;

    /* renamed from: e  reason: collision with root package name */
    public int f53705e;

    /* renamed from: f  reason: collision with root package name */
    public boolean f53706f;

    /* renamed from: g  reason: collision with root package name */
    public String f53707g;

    /* renamed from: h  reason: collision with root package name */
    public int f53708h;

    /* renamed from: i  reason: collision with root package name */
    public String f53709i;
    public int j;

    public ArrayList<UserData> a() {
        return this.f53702b;
    }

    public ArrayList<UserData> b() {
        return this.f53701a;
    }

    public void c(JSONObject jSONObject) {
        if (jSONObject == null) {
            return;
        }
        try {
            boolean z = true;
            if (jSONObject.optJSONObject("page") != null) {
                JSONArray optJSONArray = jSONObject.optJSONArray("user_list");
                JSONArray optJSONArray2 = jSONObject.optJSONArray("common_user_list");
                if (optJSONArray != null) {
                    for (int i2 = 0; i2 < optJSONArray.length(); i2++) {
                        UserData userData = new UserData();
                        userData.parserJson(optJSONArray.getJSONObject(i2));
                        this.f53701a.add(userData);
                    }
                }
                if (optJSONArray2 != null) {
                    for (int i3 = 0; i3 < optJSONArray2.length(); i3++) {
                        UserData userData2 = new UserData();
                        userData2.parserJson(optJSONArray2.getJSONObject(i3));
                        userData2.mAttentionType = 1;
                        this.f53702b.add(userData2);
                    }
                }
                this.f53703c.i(jSONObject.optJSONObject("page"));
                if (this.f53703c != null) {
                    this.f53704d = this.f53703c.a();
                    this.f53705e = this.f53703c.f();
                    if (this.f53703c.b() != 1) {
                        z = false;
                    }
                    this.f53706f = z;
                }
                jSONObject.optInt("tafriendnum", 0);
                jSONObject.optInt("commonfriendnum", 0);
            } else {
                JSONArray optJSONArray3 = jSONObject.optJSONArray("follow_list");
                JSONArray optJSONArray4 = jSONObject.optJSONArray("common_follow_list");
                if (optJSONArray3 != null) {
                    for (int i4 = 0; i4 < optJSONArray3.length(); i4++) {
                        UserData userData3 = new UserData();
                        userData3.parserJson(optJSONArray3.getJSONObject(i4));
                        this.f53701a.add(userData3);
                    }
                }
                if (optJSONArray4 != null) {
                    for (int i5 = 0; i5 < optJSONArray4.length(); i5++) {
                        UserData userData4 = new UserData();
                        userData4.parserJson(optJSONArray4.getJSONObject(i5));
                        userData4.mAttentionType = 1;
                        userData4.setHave_attention(1);
                        this.f53702b.add(userData4);
                    }
                }
                this.f53704d = jSONObject.optInt(Config.PACKAGE_NAME);
                this.f53705e = jSONObject.optInt("total_follow_num", 0);
                if (jSONObject.optInt("has_more", 0) != 1) {
                    z = false;
                }
                this.f53706f = z;
                this.j = jSONObject.optInt("follow_list_switch", 0);
            }
            this.f53709i = jSONObject.optString("tips_text");
            this.f53708h = jSONObject.optInt("type", 0);
            this.f53707g = jSONObject.optString("block_text");
        } catch (Exception e2) {
            BdLog.detailException(e2);
        }
    }
}
