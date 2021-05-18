package d.a.k0.a1.d.c;

import com.baidu.fsg.face.base.b.c;
import d.a.j0.r.q.o;
import org.json.JSONObject;
import tbclient.RecomVertical.SubClassItem;
/* loaded from: classes4.dex */
public class a extends o {

    /* renamed from: a  reason: collision with root package name */
    public int f51332a;

    /* renamed from: b  reason: collision with root package name */
    public String f51333b;

    /* renamed from: c  reason: collision with root package name */
    public String f51334c;

    /* renamed from: d  reason: collision with root package name */
    public int f51335d;

    public void a(SubClassItem subClassItem) {
        if (subClassItem == null) {
            return;
        }
        this.f51332a = subClassItem.sub_class_id.intValue();
        this.f51333b = subClassItem.sub_class_name;
        this.f51334c = subClassItem.sub_class_icon;
        this.f51335d = subClassItem.enable.intValue();
    }

    @Override // d.a.j0.r.q.o
    public void parserJson(JSONObject jSONObject) {
        if (jSONObject == null) {
            return;
        }
        this.f51332a = jSONObject.optInt("sub_class_id");
        this.f51333b = jSONObject.optString("sub_class_name");
        this.f51334c = jSONObject.optString("sub_class_icon");
        this.f51335d = jSONObject.optInt(c.l);
    }
}
