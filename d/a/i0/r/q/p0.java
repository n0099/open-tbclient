package d.a.i0.r.q;

import com.baidu.tbadk.core.util.ListUtils;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;
import tbclient.LinkThreadContent;
import tbclient.LinkThreadInfo;
/* loaded from: classes3.dex */
public class p0 {

    /* renamed from: g  reason: collision with root package name */
    public static int f49229g = 1;

    /* renamed from: a  reason: collision with root package name */
    public String f49230a;

    /* renamed from: b  reason: collision with root package name */
    public String f49231b;

    /* renamed from: c  reason: collision with root package name */
    public String f49232c;

    /* renamed from: d  reason: collision with root package name */
    public String f49233d;

    /* renamed from: e  reason: collision with root package name */
    public int f49234e = 0;

    /* renamed from: f  reason: collision with root package name */
    public boolean f49235f = false;

    public String a() {
        return this.f49232c;
    }

    public String b() {
        return this.f49233d;
    }

    public int c() {
        return this.f49234e;
    }

    public String d() {
        return this.f49231b;
    }

    public String e() {
        return this.f49230a;
    }

    public boolean f() {
        return this.f49235f;
    }

    public void g(JSONObject jSONObject) {
        if (jSONObject == null) {
            return;
        }
        this.f49230a = jSONObject.optString("link_url");
        JSONArray optJSONArray = jSONObject.optJSONArray("link_content");
        if (optJSONArray != null && optJSONArray.length() > 0) {
            try {
                JSONObject jSONObject2 = optJSONArray.getJSONObject(0);
                if (jSONObject2 != null) {
                    this.f49231b = jSONObject2.optString("link_title");
                    this.f49232c = jSONObject2.optString("link_abstract");
                    this.f49233d = jSONObject2.optString("link_head_small_pic");
                    this.f49234e = jSONObject2.optInt("link_type");
                    if (d.a.c.e.p.k.isEmpty(this.f49231b) && d.a.c.e.p.k.isEmpty(this.f49232c)) {
                        this.f49235f = true;
                    }
                } else {
                    this.f49235f = true;
                }
                return;
            } catch (JSONException unused) {
                this.f49235f = true;
                return;
            }
        }
        this.f49235f = true;
    }

    public void h(LinkThreadInfo linkThreadInfo) {
        if (linkThreadInfo == null) {
            return;
        }
        this.f49230a = linkThreadInfo.link_url;
        LinkThreadContent linkThreadContent = (LinkThreadContent) ListUtils.getItem(linkThreadInfo.link_content, 0);
        if (linkThreadContent != null) {
            this.f49231b = linkThreadContent.link_title;
            this.f49232c = linkThreadContent.link_abstract;
            this.f49233d = linkThreadContent.link_head_small_pic;
            this.f49234e = linkThreadContent.link_type.intValue();
            if (d.a.c.e.p.k.isEmpty(this.f49231b) && d.a.c.e.p.k.isEmpty(this.f49232c)) {
                this.f49235f = true;
                return;
            }
            return;
        }
        this.f49235f = true;
    }
}
