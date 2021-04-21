package d.b.i0.r.q;

import com.baidu.tbadk.core.util.ListUtils;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;
import tbclient.LinkThreadContent;
import tbclient.LinkThreadInfo;
/* loaded from: classes3.dex */
public class p0 {

    /* renamed from: g  reason: collision with root package name */
    public static int f51598g = 1;

    /* renamed from: a  reason: collision with root package name */
    public String f51599a;

    /* renamed from: b  reason: collision with root package name */
    public String f51600b;

    /* renamed from: c  reason: collision with root package name */
    public String f51601c;

    /* renamed from: d  reason: collision with root package name */
    public String f51602d;

    /* renamed from: e  reason: collision with root package name */
    public int f51603e = 0;

    /* renamed from: f  reason: collision with root package name */
    public boolean f51604f = false;

    public String a() {
        return this.f51601c;
    }

    public String b() {
        return this.f51602d;
    }

    public int c() {
        return this.f51603e;
    }

    public String d() {
        return this.f51600b;
    }

    public String e() {
        return this.f51599a;
    }

    public boolean f() {
        return this.f51604f;
    }

    public void g(JSONObject jSONObject) {
        if (jSONObject == null) {
            return;
        }
        this.f51599a = jSONObject.optString("link_url");
        JSONArray optJSONArray = jSONObject.optJSONArray("link_content");
        if (optJSONArray != null && optJSONArray.length() > 0) {
            try {
                JSONObject jSONObject2 = optJSONArray.getJSONObject(0);
                if (jSONObject2 != null) {
                    this.f51600b = jSONObject2.optString("link_title");
                    this.f51601c = jSONObject2.optString("link_abstract");
                    this.f51602d = jSONObject2.optString("link_head_small_pic");
                    this.f51603e = jSONObject2.optInt("link_type");
                    if (d.b.c.e.p.k.isEmpty(this.f51600b) && d.b.c.e.p.k.isEmpty(this.f51601c)) {
                        this.f51604f = true;
                    }
                } else {
                    this.f51604f = true;
                }
                return;
            } catch (JSONException unused) {
                this.f51604f = true;
                return;
            }
        }
        this.f51604f = true;
    }

    public void h(LinkThreadInfo linkThreadInfo) {
        if (linkThreadInfo == null) {
            return;
        }
        this.f51599a = linkThreadInfo.link_url;
        LinkThreadContent linkThreadContent = (LinkThreadContent) ListUtils.getItem(linkThreadInfo.link_content, 0);
        if (linkThreadContent != null) {
            this.f51600b = linkThreadContent.link_title;
            this.f51601c = linkThreadContent.link_abstract;
            this.f51602d = linkThreadContent.link_head_small_pic;
            this.f51603e = linkThreadContent.link_type.intValue();
            if (d.b.c.e.p.k.isEmpty(this.f51600b) && d.b.c.e.p.k.isEmpty(this.f51601c)) {
                this.f51604f = true;
                return;
            }
            return;
        }
        this.f51604f = true;
    }
}
