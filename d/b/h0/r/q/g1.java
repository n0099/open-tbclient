package d.b.h0.r.q;

import com.baidu.adp.lib.util.BdLog;
import com.baidu.mobstat.Config;
import com.baidu.tbadk.core.data.UserData;
import java.util.ArrayList;
import org.json.JSONArray;
import org.json.JSONObject;
/* loaded from: classes3.dex */
public class g1 {

    /* renamed from: a  reason: collision with root package name */
    public ArrayList<UserData> f51199a = new ArrayList<>();

    /* renamed from: b  reason: collision with root package name */
    public ArrayList<UserData> f51200b = new ArrayList<>();

    /* renamed from: c  reason: collision with root package name */
    public z0 f51201c = new z0();

    /* renamed from: d  reason: collision with root package name */
    public int f51202d;

    /* renamed from: e  reason: collision with root package name */
    public int f51203e;

    /* renamed from: f  reason: collision with root package name */
    public boolean f51204f;

    /* renamed from: g  reason: collision with root package name */
    public String f51205g;

    /* renamed from: h  reason: collision with root package name */
    public int f51206h;

    public ArrayList<UserData> a() {
        return this.f51200b;
    }

    public ArrayList<UserData> b() {
        return this.f51199a;
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
                        this.f51199a.add(userData);
                    }
                }
                if (optJSONArray2 != null) {
                    for (int i2 = 0; i2 < optJSONArray2.length(); i2++) {
                        UserData userData2 = new UserData();
                        userData2.parserJson(optJSONArray2.getJSONObject(i2));
                        userData2.mAttentionType = 1;
                        this.f51200b.add(userData2);
                    }
                }
                this.f51201c.i(jSONObject.optJSONObject("page"));
                if (this.f51201c != null) {
                    this.f51202d = this.f51201c.a();
                    this.f51203e = this.f51201c.f();
                    if (this.f51201c.b() != 1) {
                        z = false;
                    }
                    this.f51204f = z;
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
                        this.f51199a.add(userData3);
                    }
                }
                if (optJSONArray4 != null) {
                    for (int i4 = 0; i4 < optJSONArray4.length(); i4++) {
                        UserData userData4 = new UserData();
                        userData4.parserJson(optJSONArray4.getJSONObject(i4));
                        userData4.mAttentionType = 1;
                        userData4.setHave_attention(1);
                        this.f51200b.add(userData4);
                    }
                }
                this.f51202d = jSONObject.optInt(Config.PACKAGE_NAME);
                this.f51203e = jSONObject.optInt("total_follow_num", 0);
                if (jSONObject.optInt("has_more", 0) != 1) {
                    z = false;
                }
                this.f51204f = z;
            }
            this.f51206h = jSONObject.optInt("type", 0);
            this.f51205g = jSONObject.optString("block_text");
        } catch (Exception e2) {
            BdLog.detailException(e2);
        }
    }
}
