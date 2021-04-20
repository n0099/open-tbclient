package d.b.i0.a1.d.c;

import com.baidu.fsg.face.base.b.c;
import d.b.h0.r.q.o;
import org.json.JSONObject;
import tbclient.RecomVertical.SubClassItem;
/* loaded from: classes4.dex */
public class a extends o {

    /* renamed from: a  reason: collision with root package name */
    public int f52514a;

    /* renamed from: b  reason: collision with root package name */
    public String f52515b;

    /* renamed from: c  reason: collision with root package name */
    public String f52516c;

    /* renamed from: d  reason: collision with root package name */
    public int f52517d;

    public void a(SubClassItem subClassItem) {
        if (subClassItem == null) {
            return;
        }
        this.f52514a = subClassItem.sub_class_id.intValue();
        this.f52515b = subClassItem.sub_class_name;
        this.f52516c = subClassItem.sub_class_icon;
        this.f52517d = subClassItem.enable.intValue();
    }

    @Override // d.b.h0.r.q.o
    public void parserJson(JSONObject jSONObject) {
        if (jSONObject == null) {
            return;
        }
        this.f52514a = jSONObject.optInt("sub_class_id");
        this.f52515b = jSONObject.optString("sub_class_name");
        this.f52516c = jSONObject.optString("sub_class_icon");
        this.f52517d = jSONObject.optInt(c.l);
    }
}
