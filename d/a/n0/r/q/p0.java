package d.a.n0.r.q;

import com.baidu.tbadk.core.util.ListUtils;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;
import tbclient.LinkThreadContent;
import tbclient.LinkThreadInfo;
/* loaded from: classes3.dex */
public class p0 {

    /* renamed from: g  reason: collision with root package name */
    public static int f53875g = 1;

    /* renamed from: a  reason: collision with root package name */
    public String f53876a;

    /* renamed from: b  reason: collision with root package name */
    public String f53877b;

    /* renamed from: c  reason: collision with root package name */
    public String f53878c;

    /* renamed from: d  reason: collision with root package name */
    public String f53879d;

    /* renamed from: e  reason: collision with root package name */
    public int f53880e = 0;

    /* renamed from: f  reason: collision with root package name */
    public boolean f53881f = false;

    public String a() {
        return this.f53878c;
    }

    public String b() {
        return this.f53879d;
    }

    public int c() {
        return this.f53880e;
    }

    public String d() {
        return this.f53877b;
    }

    public String e() {
        return this.f53876a;
    }

    public boolean f() {
        return this.f53881f;
    }

    public void g(JSONObject jSONObject) {
        if (jSONObject == null) {
            return;
        }
        this.f53876a = jSONObject.optString("link_url");
        JSONArray optJSONArray = jSONObject.optJSONArray("link_content");
        if (optJSONArray != null && optJSONArray.length() > 0) {
            try {
                JSONObject jSONObject2 = optJSONArray.getJSONObject(0);
                if (jSONObject2 != null) {
                    this.f53877b = jSONObject2.optString("link_title");
                    this.f53878c = jSONObject2.optString("link_abstract");
                    this.f53879d = jSONObject2.optString("link_head_small_pic");
                    this.f53880e = jSONObject2.optInt("link_type");
                    if (d.a.c.e.p.k.isEmpty(this.f53877b) && d.a.c.e.p.k.isEmpty(this.f53878c)) {
                        this.f53881f = true;
                    }
                } else {
                    this.f53881f = true;
                }
                return;
            } catch (JSONException unused) {
                this.f53881f = true;
                return;
            }
        }
        this.f53881f = true;
    }

    public void h(LinkThreadInfo linkThreadInfo) {
        if (linkThreadInfo == null) {
            return;
        }
        this.f53876a = linkThreadInfo.link_url;
        LinkThreadContent linkThreadContent = (LinkThreadContent) ListUtils.getItem(linkThreadInfo.link_content, 0);
        if (linkThreadContent != null) {
            this.f53877b = linkThreadContent.link_title;
            this.f53878c = linkThreadContent.link_abstract;
            this.f53879d = linkThreadContent.link_head_small_pic;
            this.f53880e = linkThreadContent.link_type.intValue();
            if (d.a.c.e.p.k.isEmpty(this.f53877b) && d.a.c.e.p.k.isEmpty(this.f53878c)) {
                this.f53881f = true;
                return;
            }
            return;
        }
        this.f53881f = true;
    }
}
