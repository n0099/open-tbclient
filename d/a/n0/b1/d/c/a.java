package d.a.n0.b1.d.c;

import com.baidu.fsg.face.base.b.c;
import d.a.m0.r.q.o;
import org.json.JSONObject;
import tbclient.RecomVertical.SubClassItem;
/* loaded from: classes4.dex */
public class a extends o {

    /* renamed from: a  reason: collision with root package name */
    public int f51497a;

    /* renamed from: b  reason: collision with root package name */
    public String f51498b;

    /* renamed from: c  reason: collision with root package name */
    public String f51499c;

    /* renamed from: d  reason: collision with root package name */
    public int f51500d;

    public void a(SubClassItem subClassItem) {
        if (subClassItem == null) {
            return;
        }
        this.f51497a = subClassItem.sub_class_id.intValue();
        this.f51498b = subClassItem.sub_class_name;
        this.f51499c = subClassItem.sub_class_icon;
        this.f51500d = subClassItem.enable.intValue();
    }

    @Override // d.a.m0.r.q.o
    public void parserJson(JSONObject jSONObject) {
        if (jSONObject == null) {
            return;
        }
        this.f51497a = jSONObject.optInt("sub_class_id");
        this.f51498b = jSONObject.optString("sub_class_name");
        this.f51499c = jSONObject.optString("sub_class_icon");
        this.f51500d = jSONObject.optInt(c.l);
    }
}
