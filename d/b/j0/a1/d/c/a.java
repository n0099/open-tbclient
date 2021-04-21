package d.b.j0.a1.d.c;

import com.baidu.fsg.face.base.b.c;
import d.b.i0.r.q.o;
import org.json.JSONObject;
import tbclient.RecomVertical.SubClassItem;
/* loaded from: classes4.dex */
public class a extends o {

    /* renamed from: a  reason: collision with root package name */
    public int f52935a;

    /* renamed from: b  reason: collision with root package name */
    public String f52936b;

    /* renamed from: c  reason: collision with root package name */
    public String f52937c;

    /* renamed from: d  reason: collision with root package name */
    public int f52938d;

    public void a(SubClassItem subClassItem) {
        if (subClassItem == null) {
            return;
        }
        this.f52935a = subClassItem.sub_class_id.intValue();
        this.f52936b = subClassItem.sub_class_name;
        this.f52937c = subClassItem.sub_class_icon;
        this.f52938d = subClassItem.enable.intValue();
    }

    @Override // d.b.i0.r.q.o
    public void parserJson(JSONObject jSONObject) {
        if (jSONObject == null) {
            return;
        }
        this.f52935a = jSONObject.optInt("sub_class_id");
        this.f52936b = jSONObject.optString("sub_class_name");
        this.f52937c = jSONObject.optString("sub_class_icon");
        this.f52938d = jSONObject.optInt(c.l);
    }
}
