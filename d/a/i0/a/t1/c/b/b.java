package d.a.i0.a.t1.c.b;

import android.text.TextUtils;
import org.json.JSONObject;
/* loaded from: classes3.dex */
public class b {

    /* renamed from: a  reason: collision with root package name */
    public String f44576a;

    /* renamed from: b  reason: collision with root package name */
    public String f44577b;

    /* renamed from: c  reason: collision with root package name */
    public String f44578c;

    /* renamed from: d  reason: collision with root package name */
    public String f44579d;

    /* renamed from: e  reason: collision with root package name */
    public String f44580e;

    /* renamed from: f  reason: collision with root package name */
    public String f44581f;

    /* renamed from: g  reason: collision with root package name */
    public JSONObject f44582g;

    /* renamed from: h  reason: collision with root package name */
    public String f44583h;

    /* renamed from: i  reason: collision with root package name */
    public d.a.i0.a.u.h.b f44584i;

    public boolean a() {
        return (TextUtils.isEmpty(this.f44576a) || TextUtils.isEmpty(this.f44578c) || TextUtils.isEmpty(this.f44579d) || TextUtils.isEmpty(this.f44581f) || TextUtils.isEmpty(this.f44580e)) ? false : true;
    }

    public boolean b() {
        d.a.i0.a.u.h.b bVar = this.f44584i;
        return (bVar == null || bVar.a()) ? false : true;
    }

    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("SwanPluginFunPageModel{providerAppKey='");
        sb.append(this.f44576a);
        sb.append('\'');
        sb.append(", providerRootPath='");
        sb.append(this.f44578c);
        sb.append('\'');
        sb.append(", providerVersion='");
        sb.append(this.f44579d);
        sb.append('\'');
        sb.append(", componentId='");
        sb.append(this.f44581f);
        sb.append('\'');
        sb.append(", cb='");
        sb.append(this.f44583h);
        sb.append('\'');
        sb.append(", pageParams=");
        sb.append(this.f44582g);
        sb.append(", swanApiResult=");
        d.a.i0.a.u.h.b bVar = this.f44584i;
        sb.append(bVar == null ? null : bVar.b());
        sb.append('}');
        return sb.toString();
    }
}
