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
    public static int f50854g = 1;

    /* renamed from: a  reason: collision with root package name */
    public String f50855a;

    /* renamed from: b  reason: collision with root package name */
    public String f50856b;

    /* renamed from: c  reason: collision with root package name */
    public String f50857c;

    /* renamed from: d  reason: collision with root package name */
    public String f50858d;

    /* renamed from: e  reason: collision with root package name */
    public int f50859e = 0;

    /* renamed from: f  reason: collision with root package name */
    public boolean f50860f = false;

    public String a() {
        return this.f50857c;
    }

    public String b() {
        return this.f50858d;
    }

    public int c() {
        return this.f50859e;
    }

    public String d() {
        return this.f50856b;
    }

    public String e() {
        return this.f50855a;
    }

    public boolean f() {
        return this.f50860f;
    }

    public void g(JSONObject jSONObject) {
        if (jSONObject == null) {
            return;
        }
        this.f50855a = jSONObject.optString("link_url");
        JSONArray optJSONArray = jSONObject.optJSONArray("link_content");
        if (optJSONArray != null && optJSONArray.length() > 0) {
            try {
                JSONObject jSONObject2 = optJSONArray.getJSONObject(0);
                if (jSONObject2 != null) {
                    this.f50856b = jSONObject2.optString("link_title");
                    this.f50857c = jSONObject2.optString("link_abstract");
                    this.f50858d = jSONObject2.optString("link_head_small_pic");
                    this.f50859e = jSONObject2.optInt("link_type");
                    if (d.b.b.e.p.k.isEmpty(this.f50856b) && d.b.b.e.p.k.isEmpty(this.f50857c)) {
                        this.f50860f = true;
                    }
                } else {
                    this.f50860f = true;
                }
                return;
            } catch (JSONException unused) {
                this.f50860f = true;
                return;
            }
        }
        this.f50860f = true;
    }

    public void h(LinkThreadInfo linkThreadInfo) {
        if (linkThreadInfo == null) {
            return;
        }
        this.f50855a = linkThreadInfo.link_url;
        LinkThreadContent linkThreadContent = (LinkThreadContent) ListUtils.getItem(linkThreadInfo.link_content, 0);
        if (linkThreadContent != null) {
            this.f50856b = linkThreadContent.link_title;
            this.f50857c = linkThreadContent.link_abstract;
            this.f50858d = linkThreadContent.link_head_small_pic;
            this.f50859e = linkThreadContent.link_type.intValue();
            if (d.b.b.e.p.k.isEmpty(this.f50856b) && d.b.b.e.p.k.isEmpty(this.f50857c)) {
                this.f50860f = true;
                return;
            }
            return;
        }
        this.f50860f = true;
    }
}
