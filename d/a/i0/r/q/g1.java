package d.a.i0.r.q;

import com.baidu.adp.lib.util.BdLog;
import com.baidu.mobstat.Config;
import com.baidu.tbadk.core.data.UserData;
import java.util.ArrayList;
import org.json.JSONArray;
import org.json.JSONObject;
/* loaded from: classes3.dex */
public class g1 {

    /* renamed from: a  reason: collision with root package name */
    public ArrayList<UserData> f49162a = new ArrayList<>();

    /* renamed from: b  reason: collision with root package name */
    public ArrayList<UserData> f49163b = new ArrayList<>();

    /* renamed from: c  reason: collision with root package name */
    public z0 f49164c = new z0();

    /* renamed from: d  reason: collision with root package name */
    public int f49165d;

    /* renamed from: e  reason: collision with root package name */
    public int f49166e;

    /* renamed from: f  reason: collision with root package name */
    public boolean f49167f;

    /* renamed from: g  reason: collision with root package name */
    public String f49168g;

    /* renamed from: h  reason: collision with root package name */
    public int f49169h;

    /* renamed from: i  reason: collision with root package name */
    public String f49170i;

    public ArrayList<UserData> a() {
        return this.f49163b;
    }

    public ArrayList<UserData> b() {
        return this.f49162a;
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
                        this.f49162a.add(userData);
                    }
                }
                if (optJSONArray2 != null) {
                    for (int i3 = 0; i3 < optJSONArray2.length(); i3++) {
                        UserData userData2 = new UserData();
                        userData2.parserJson(optJSONArray2.getJSONObject(i3));
                        userData2.mAttentionType = 1;
                        this.f49163b.add(userData2);
                    }
                }
                this.f49164c.i(jSONObject.optJSONObject("page"));
                if (this.f49164c != null) {
                    this.f49165d = this.f49164c.a();
                    this.f49166e = this.f49164c.f();
                    if (this.f49164c.b() != 1) {
                        z = false;
                    }
                    this.f49167f = z;
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
                        this.f49162a.add(userData3);
                    }
                }
                if (optJSONArray4 != null) {
                    for (int i5 = 0; i5 < optJSONArray4.length(); i5++) {
                        UserData userData4 = new UserData();
                        userData4.parserJson(optJSONArray4.getJSONObject(i5));
                        userData4.mAttentionType = 1;
                        userData4.setHave_attention(1);
                        this.f49163b.add(userData4);
                    }
                }
                this.f49165d = jSONObject.optInt(Config.PACKAGE_NAME);
                this.f49166e = jSONObject.optInt("total_follow_num", 0);
                if (jSONObject.optInt("has_more", 0) != 1) {
                    z = false;
                }
                this.f49167f = z;
            }
            this.f49170i = jSONObject.optString("tips_text");
            this.f49169h = jSONObject.optInt("type", 0);
            this.f49168g = jSONObject.optString("block_text");
        } catch (Exception e2) {
            BdLog.detailException(e2);
        }
    }
}
