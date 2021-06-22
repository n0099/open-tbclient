package d.a.m0.a.t1.c.b;

import android.text.TextUtils;
import org.json.JSONObject;
/* loaded from: classes3.dex */
public class b {

    /* renamed from: a  reason: collision with root package name */
    public String f48534a;

    /* renamed from: b  reason: collision with root package name */
    public String f48535b;

    /* renamed from: c  reason: collision with root package name */
    public String f48536c;

    /* renamed from: d  reason: collision with root package name */
    public String f48537d;

    /* renamed from: e  reason: collision with root package name */
    public String f48538e;

    /* renamed from: f  reason: collision with root package name */
    public String f48539f;

    /* renamed from: g  reason: collision with root package name */
    public JSONObject f48540g;

    /* renamed from: h  reason: collision with root package name */
    public String f48541h;

    /* renamed from: i  reason: collision with root package name */
    public d.a.m0.a.u.h.b f48542i;

    public boolean a() {
        return (TextUtils.isEmpty(this.f48534a) || TextUtils.isEmpty(this.f48536c) || TextUtils.isEmpty(this.f48537d) || TextUtils.isEmpty(this.f48539f) || TextUtils.isEmpty(this.f48538e)) ? false : true;
    }

    public boolean b() {
        d.a.m0.a.u.h.b bVar = this.f48542i;
        return (bVar == null || bVar.isSuccess()) ? false : true;
    }

    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("SwanPluginFunPageModel{providerAppKey='");
        sb.append(this.f48534a);
        sb.append('\'');
        sb.append(", providerRootPath='");
        sb.append(this.f48536c);
        sb.append('\'');
        sb.append(", providerVersion='");
        sb.append(this.f48537d);
        sb.append('\'');
        sb.append(", componentId='");
        sb.append(this.f48539f);
        sb.append('\'');
        sb.append(", cb='");
        sb.append(this.f48541h);
        sb.append('\'');
        sb.append(", pageParams=");
        sb.append(this.f48540g);
        sb.append(", swanApiResult=");
        d.a.m0.a.u.h.b bVar = this.f48542i;
        sb.append(bVar == null ? null : bVar.a());
        sb.append('}');
        return sb.toString();
    }
}
