package d.b.i0.z0.d.c;

import com.baidu.fsg.face.base.b.c;
import d.b.h0.r.q.o;
import org.json.JSONObject;
import tbclient.RecomVertical.SubClassItem;
/* loaded from: classes4.dex */
public class a extends o {

    /* renamed from: a  reason: collision with root package name */
    public int f62894a;

    /* renamed from: b  reason: collision with root package name */
    public String f62895b;

    /* renamed from: c  reason: collision with root package name */
    public String f62896c;

    /* renamed from: d  reason: collision with root package name */
    public int f62897d;

    public void a(SubClassItem subClassItem) {
        if (subClassItem == null) {
            return;
        }
        this.f62894a = subClassItem.sub_class_id.intValue();
        this.f62895b = subClassItem.sub_class_name;
        this.f62896c = subClassItem.sub_class_icon;
        this.f62897d = subClassItem.enable.intValue();
    }

    @Override // d.b.h0.r.q.o
    public void parserJson(JSONObject jSONObject) {
        if (jSONObject == null) {
            return;
        }
        this.f62894a = jSONObject.optInt("sub_class_id");
        this.f62895b = jSONObject.optString("sub_class_name");
        this.f62896c = jSONObject.optString("sub_class_icon");
        this.f62897d = jSONObject.optInt(c.l);
    }
}
