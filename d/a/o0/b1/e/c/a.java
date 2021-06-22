package d.a.o0.b1.e.c;

import com.baidu.fsg.face.base.b.c;
import d.a.n0.r.q.o;
import org.json.JSONObject;
import tbclient.RecomVertical.SubClassItem;
/* loaded from: classes4.dex */
public class a extends o {

    /* renamed from: a  reason: collision with root package name */
    public int f55305a;

    /* renamed from: b  reason: collision with root package name */
    public String f55306b;

    /* renamed from: c  reason: collision with root package name */
    public String f55307c;

    /* renamed from: d  reason: collision with root package name */
    public int f55308d;

    public void a(SubClassItem subClassItem) {
        if (subClassItem == null) {
            return;
        }
        this.f55305a = subClassItem.sub_class_id.intValue();
        this.f55306b = subClassItem.sub_class_name;
        this.f55307c = subClassItem.sub_class_icon;
        this.f55308d = subClassItem.enable.intValue();
    }

    @Override // d.a.n0.r.q.o
    public void parserJson(JSONObject jSONObject) {
        if (jSONObject == null) {
            return;
        }
        this.f55305a = jSONObject.optInt("sub_class_id");
        this.f55306b = jSONObject.optString("sub_class_name");
        this.f55307c = jSONObject.optString("sub_class_icon");
        this.f55308d = jSONObject.optInt(c.l);
    }
}
