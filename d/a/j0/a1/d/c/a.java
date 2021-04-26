package d.a.j0.a1.d.c;

import com.baidu.fsg.face.base.b.c;
import d.a.i0.r.q.o;
import org.json.JSONObject;
import tbclient.RecomVertical.SubClassItem;
/* loaded from: classes4.dex */
public class a extends o {

    /* renamed from: a  reason: collision with root package name */
    public int f50635a;

    /* renamed from: b  reason: collision with root package name */
    public String f50636b;

    /* renamed from: c  reason: collision with root package name */
    public String f50637c;

    /* renamed from: d  reason: collision with root package name */
    public int f50638d;

    public void a(SubClassItem subClassItem) {
        if (subClassItem == null) {
            return;
        }
        this.f50635a = subClassItem.sub_class_id.intValue();
        this.f50636b = subClassItem.sub_class_name;
        this.f50637c = subClassItem.sub_class_icon;
        this.f50638d = subClassItem.enable.intValue();
    }

    @Override // d.a.i0.r.q.o
    public void parserJson(JSONObject jSONObject) {
        if (jSONObject == null) {
            return;
        }
        this.f50635a = jSONObject.optInt("sub_class_id");
        this.f50636b = jSONObject.optString("sub_class_name");
        this.f50637c = jSONObject.optString("sub_class_icon");
        this.f50638d = jSONObject.optInt(c.l);
    }
}
