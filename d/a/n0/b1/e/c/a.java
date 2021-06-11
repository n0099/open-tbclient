package d.a.n0.b1.e.c;

import com.baidu.fsg.face.base.b.c;
import d.a.m0.r.q.o;
import org.json.JSONObject;
import tbclient.RecomVertical.SubClassItem;
/* loaded from: classes4.dex */
public class a extends o {

    /* renamed from: a  reason: collision with root package name */
    public int f55180a;

    /* renamed from: b  reason: collision with root package name */
    public String f55181b;

    /* renamed from: c  reason: collision with root package name */
    public String f55182c;

    /* renamed from: d  reason: collision with root package name */
    public int f55183d;

    public void a(SubClassItem subClassItem) {
        if (subClassItem == null) {
            return;
        }
        this.f55180a = subClassItem.sub_class_id.intValue();
        this.f55181b = subClassItem.sub_class_name;
        this.f55182c = subClassItem.sub_class_icon;
        this.f55183d = subClassItem.enable.intValue();
    }

    @Override // d.a.m0.r.q.o
    public void parserJson(JSONObject jSONObject) {
        if (jSONObject == null) {
            return;
        }
        this.f55180a = jSONObject.optInt("sub_class_id");
        this.f55181b = jSONObject.optString("sub_class_name");
        this.f55182c = jSONObject.optString("sub_class_icon");
        this.f55183d = jSONObject.optInt(c.l);
    }
}
