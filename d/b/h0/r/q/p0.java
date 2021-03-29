package d.b.h0.r.q;

import com.baidu.tbadk.core.util.ListUtils;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;
import tbclient.LinkThreadContent;
import tbclient.LinkThreadInfo;
/* loaded from: classes3.dex */
public class p0 {

    /* renamed from: g  reason: collision with root package name */
    public static int f50855g = 1;

    /* renamed from: a  reason: collision with root package name */
    public String f50856a;

    /* renamed from: b  reason: collision with root package name */
    public String f50857b;

    /* renamed from: c  reason: collision with root package name */
    public String f50858c;

    /* renamed from: d  reason: collision with root package name */
    public String f50859d;

    /* renamed from: e  reason: collision with root package name */
    public int f50860e = 0;

    /* renamed from: f  reason: collision with root package name */
    public boolean f50861f = false;

    public String a() {
        return this.f50858c;
    }

    public String b() {
        return this.f50859d;
    }

    public int c() {
        return this.f50860e;
    }

    public String d() {
        return this.f50857b;
    }

    public String e() {
        return this.f50856a;
    }

    public boolean f() {
        return this.f50861f;
    }

    public void g(JSONObject jSONObject) {
        if (jSONObject == null) {
            return;
        }
        this.f50856a = jSONObject.optString("link_url");
        JSONArray optJSONArray = jSONObject.optJSONArray("link_content");
        if (optJSONArray != null && optJSONArray.length() > 0) {
            try {
                JSONObject jSONObject2 = optJSONArray.getJSONObject(0);
                if (jSONObject2 != null) {
                    this.f50857b = jSONObject2.optString("link_title");
                    this.f50858c = jSONObject2.optString("link_abstract");
                    this.f50859d = jSONObject2.optString("link_head_small_pic");
                    this.f50860e = jSONObject2.optInt("link_type");
                    if (d.b.b.e.p.k.isEmpty(this.f50857b) && d.b.b.e.p.k.isEmpty(this.f50858c)) {
                        this.f50861f = true;
                    }
                } else {
                    this.f50861f = true;
                }
                return;
            } catch (JSONException unused) {
                this.f50861f = true;
                return;
            }
        }
        this.f50861f = true;
    }

    public void h(LinkThreadInfo linkThreadInfo) {
        if (linkThreadInfo == null) {
            return;
        }
        this.f50856a = linkThreadInfo.link_url;
        LinkThreadContent linkThreadContent = (LinkThreadContent) ListUtils.getItem(linkThreadInfo.link_content, 0);
        if (linkThreadContent != null) {
            this.f50857b = linkThreadContent.link_title;
            this.f50858c = linkThreadContent.link_abstract;
            this.f50859d = linkThreadContent.link_head_small_pic;
            this.f50860e = linkThreadContent.link_type.intValue();
            if (d.b.b.e.p.k.isEmpty(this.f50857b) && d.b.b.e.p.k.isEmpty(this.f50858c)) {
                this.f50861f = true;
                return;
            }
            return;
        }
        this.f50861f = true;
    }
}
