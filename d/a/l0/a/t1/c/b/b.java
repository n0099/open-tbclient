package d.a.l0.a.t1.c.b;

import android.text.TextUtils;
import org.json.JSONObject;
/* loaded from: classes3.dex */
public class b {

    /* renamed from: a  reason: collision with root package name */
    public String f48426a;

    /* renamed from: b  reason: collision with root package name */
    public String f48427b;

    /* renamed from: c  reason: collision with root package name */
    public String f48428c;

    /* renamed from: d  reason: collision with root package name */
    public String f48429d;

    /* renamed from: e  reason: collision with root package name */
    public String f48430e;

    /* renamed from: f  reason: collision with root package name */
    public String f48431f;

    /* renamed from: g  reason: collision with root package name */
    public JSONObject f48432g;

    /* renamed from: h  reason: collision with root package name */
    public String f48433h;

    /* renamed from: i  reason: collision with root package name */
    public d.a.l0.a.u.h.b f48434i;

    public boolean a() {
        return (TextUtils.isEmpty(this.f48426a) || TextUtils.isEmpty(this.f48428c) || TextUtils.isEmpty(this.f48429d) || TextUtils.isEmpty(this.f48431f) || TextUtils.isEmpty(this.f48430e)) ? false : true;
    }

    public boolean b() {
        d.a.l0.a.u.h.b bVar = this.f48434i;
        return (bVar == null || bVar.isSuccess()) ? false : true;
    }

    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("SwanPluginFunPageModel{providerAppKey='");
        sb.append(this.f48426a);
        sb.append('\'');
        sb.append(", providerRootPath='");
        sb.append(this.f48428c);
        sb.append('\'');
        sb.append(", providerVersion='");
        sb.append(this.f48429d);
        sb.append('\'');
        sb.append(", componentId='");
        sb.append(this.f48431f);
        sb.append('\'');
        sb.append(", cb='");
        sb.append(this.f48433h);
        sb.append('\'');
        sb.append(", pageParams=");
        sb.append(this.f48432g);
        sb.append(", swanApiResult=");
        d.a.l0.a.u.h.b bVar = this.f48434i;
        sb.append(bVar == null ? null : bVar.a());
        sb.append('}');
        return sb.toString();
    }
}
