package d.a.m0.r.q;

import com.baidu.tbadk.core.util.ListUtils;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;
import tbclient.LinkThreadContent;
import tbclient.LinkThreadInfo;
/* loaded from: classes3.dex */
public class p0 {

    /* renamed from: g  reason: collision with root package name */
    public static int f50092g = 1;

    /* renamed from: a  reason: collision with root package name */
    public String f50093a;

    /* renamed from: b  reason: collision with root package name */
    public String f50094b;

    /* renamed from: c  reason: collision with root package name */
    public String f50095c;

    /* renamed from: d  reason: collision with root package name */
    public String f50096d;

    /* renamed from: e  reason: collision with root package name */
    public int f50097e = 0;

    /* renamed from: f  reason: collision with root package name */
    public boolean f50098f = false;

    public String a() {
        return this.f50095c;
    }

    public String b() {
        return this.f50096d;
    }

    public int c() {
        return this.f50097e;
    }

    public String d() {
        return this.f50094b;
    }

    public String e() {
        return this.f50093a;
    }

    public boolean f() {
        return this.f50098f;
    }

    public void g(JSONObject jSONObject) {
        if (jSONObject == null) {
            return;
        }
        this.f50093a = jSONObject.optString("link_url");
        JSONArray optJSONArray = jSONObject.optJSONArray("link_content");
        if (optJSONArray != null && optJSONArray.length() > 0) {
            try {
                JSONObject jSONObject2 = optJSONArray.getJSONObject(0);
                if (jSONObject2 != null) {
                    this.f50094b = jSONObject2.optString("link_title");
                    this.f50095c = jSONObject2.optString("link_abstract");
                    this.f50096d = jSONObject2.optString("link_head_small_pic");
                    this.f50097e = jSONObject2.optInt("link_type");
                    if (d.a.c.e.p.k.isEmpty(this.f50094b) && d.a.c.e.p.k.isEmpty(this.f50095c)) {
                        this.f50098f = true;
                    }
                } else {
                    this.f50098f = true;
                }
                return;
            } catch (JSONException unused) {
                this.f50098f = true;
                return;
            }
        }
        this.f50098f = true;
    }

    public void h(LinkThreadInfo linkThreadInfo) {
        if (linkThreadInfo == null) {
            return;
        }
        this.f50093a = linkThreadInfo.link_url;
        LinkThreadContent linkThreadContent = (LinkThreadContent) ListUtils.getItem(linkThreadInfo.link_content, 0);
        if (linkThreadContent != null) {
            this.f50094b = linkThreadContent.link_title;
            this.f50095c = linkThreadContent.link_abstract;
            this.f50096d = linkThreadContent.link_head_small_pic;
            this.f50097e = linkThreadContent.link_type.intValue();
            if (d.a.c.e.p.k.isEmpty(this.f50094b) && d.a.c.e.p.k.isEmpty(this.f50095c)) {
                this.f50098f = true;
                return;
            }
            return;
        }
        this.f50098f = true;
    }
}
