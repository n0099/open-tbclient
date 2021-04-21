package d.b.i0.r.q;

import com.baidu.adp.lib.util.BdLog;
import com.baidu.mobstat.Config;
import com.baidu.tbadk.core.data.UserData;
import java.util.ArrayList;
import org.json.JSONArray;
import org.json.JSONObject;
/* loaded from: classes3.dex */
public class g1 {

    /* renamed from: a  reason: collision with root package name */
    public ArrayList<UserData> f51535a = new ArrayList<>();

    /* renamed from: b  reason: collision with root package name */
    public ArrayList<UserData> f51536b = new ArrayList<>();

    /* renamed from: c  reason: collision with root package name */
    public z0 f51537c = new z0();

    /* renamed from: d  reason: collision with root package name */
    public int f51538d;

    /* renamed from: e  reason: collision with root package name */
    public int f51539e;

    /* renamed from: f  reason: collision with root package name */
    public boolean f51540f;

    /* renamed from: g  reason: collision with root package name */
    public String f51541g;

    /* renamed from: h  reason: collision with root package name */
    public int f51542h;

    public ArrayList<UserData> a() {
        return this.f51536b;
    }

    public ArrayList<UserData> b() {
        return this.f51535a;
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
                    for (int i = 0; i < optJSONArray.length(); i++) {
                        UserData userData = new UserData();
                        userData.parserJson(optJSONArray.getJSONObject(i));
                        this.f51535a.add(userData);
                    }
                }
                if (optJSONArray2 != null) {
                    for (int i2 = 0; i2 < optJSONArray2.length(); i2++) {
                        UserData userData2 = new UserData();
                        userData2.parserJson(optJSONArray2.getJSONObject(i2));
                        userData2.mAttentionType = 1;
                        this.f51536b.add(userData2);
                    }
                }
                this.f51537c.i(jSONObject.optJSONObject("page"));
                if (this.f51537c != null) {
                    this.f51538d = this.f51537c.a();
                    this.f51539e = this.f51537c.f();
                    if (this.f51537c.b() != 1) {
                        z = false;
                    }
                    this.f51540f = z;
                }
                jSONObject.optInt("tafriendnum", 0);
                jSONObject.optInt("commonfriendnum", 0);
            } else {
                JSONArray optJSONArray3 = jSONObject.optJSONArray("follow_list");
                JSONArray optJSONArray4 = jSONObject.optJSONArray("common_follow_list");
                if (optJSONArray3 != null) {
                    for (int i3 = 0; i3 < optJSONArray3.length(); i3++) {
                        UserData userData3 = new UserData();
                        userData3.parserJson(optJSONArray3.getJSONObject(i3));
                        this.f51535a.add(userData3);
                    }
                }
                if (optJSONArray4 != null) {
                    for (int i4 = 0; i4 < optJSONArray4.length(); i4++) {
                        UserData userData4 = new UserData();
                        userData4.parserJson(optJSONArray4.getJSONObject(i4));
                        userData4.mAttentionType = 1;
                        userData4.setHave_attention(1);
                        this.f51536b.add(userData4);
                    }
                }
                this.f51538d = jSONObject.optInt(Config.PACKAGE_NAME);
                this.f51539e = jSONObject.optInt("total_follow_num", 0);
                if (jSONObject.optInt("has_more", 0) != 1) {
                    z = false;
                }
                this.f51540f = z;
            }
            this.f51542h = jSONObject.optInt("type", 0);
            this.f51541g = jSONObject.optString("block_text");
        } catch (Exception e2) {
            BdLog.detailException(e2);
        }
    }
}
