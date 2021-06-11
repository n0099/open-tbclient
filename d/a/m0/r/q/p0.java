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
    public static int f53768g = 1;

    /* renamed from: a  reason: collision with root package name */
    public String f53769a;

    /* renamed from: b  reason: collision with root package name */
    public String f53770b;

    /* renamed from: c  reason: collision with root package name */
    public String f53771c;

    /* renamed from: d  reason: collision with root package name */
    public String f53772d;

    /* renamed from: e  reason: collision with root package name */
    public int f53773e = 0;

    /* renamed from: f  reason: collision with root package name */
    public boolean f53774f = false;

    public String a() {
        return this.f53771c;
    }

    public String b() {
        return this.f53772d;
    }

    public int c() {
        return this.f53773e;
    }

    public String d() {
        return this.f53770b;
    }

    public String e() {
        return this.f53769a;
    }

    public boolean f() {
        return this.f53774f;
    }

    public void g(JSONObject jSONObject) {
        if (jSONObject == null) {
            return;
        }
        this.f53769a = jSONObject.optString("link_url");
        JSONArray optJSONArray = jSONObject.optJSONArray("link_content");
        if (optJSONArray != null && optJSONArray.length() > 0) {
            try {
                JSONObject jSONObject2 = optJSONArray.getJSONObject(0);
                if (jSONObject2 != null) {
                    this.f53770b = jSONObject2.optString("link_title");
                    this.f53771c = jSONObject2.optString("link_abstract");
                    this.f53772d = jSONObject2.optString("link_head_small_pic");
                    this.f53773e = jSONObject2.optInt("link_type");
                    if (d.a.c.e.p.k.isEmpty(this.f53770b) && d.a.c.e.p.k.isEmpty(this.f53771c)) {
                        this.f53774f = true;
                    }
                } else {
                    this.f53774f = true;
                }
                return;
            } catch (JSONException unused) {
                this.f53774f = true;
                return;
            }
        }
        this.f53774f = true;
    }

    public void h(LinkThreadInfo linkThreadInfo) {
        if (linkThreadInfo == null) {
            return;
        }
        this.f53769a = linkThreadInfo.link_url;
        LinkThreadContent linkThreadContent = (LinkThreadContent) ListUtils.getItem(linkThreadInfo.link_content, 0);
        if (linkThreadContent != null) {
            this.f53770b = linkThreadContent.link_title;
            this.f53771c = linkThreadContent.link_abstract;
            this.f53772d = linkThreadContent.link_head_small_pic;
            this.f53773e = linkThreadContent.link_type.intValue();
            if (d.a.c.e.p.k.isEmpty(this.f53770b) && d.a.c.e.p.k.isEmpty(this.f53771c)) {
                this.f53774f = true;
                return;
            }
            return;
        }
        this.f53774f = true;
    }
}
