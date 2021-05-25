package d.a.l0.a.t1.c.b;

import android.text.TextUtils;
import org.json.JSONObject;
/* loaded from: classes3.dex */
public class b {

    /* renamed from: a  reason: collision with root package name */
    public String f44752a;

    /* renamed from: b  reason: collision with root package name */
    public String f44753b;

    /* renamed from: c  reason: collision with root package name */
    public String f44754c;

    /* renamed from: d  reason: collision with root package name */
    public String f44755d;

    /* renamed from: e  reason: collision with root package name */
    public String f44756e;

    /* renamed from: f  reason: collision with root package name */
    public String f44757f;

    /* renamed from: g  reason: collision with root package name */
    public JSONObject f44758g;

    /* renamed from: h  reason: collision with root package name */
    public String f44759h;

    /* renamed from: i  reason: collision with root package name */
    public d.a.l0.a.u.h.b f44760i;

    public boolean a() {
        return (TextUtils.isEmpty(this.f44752a) || TextUtils.isEmpty(this.f44754c) || TextUtils.isEmpty(this.f44755d) || TextUtils.isEmpty(this.f44757f) || TextUtils.isEmpty(this.f44756e)) ? false : true;
    }

    public boolean b() {
        d.a.l0.a.u.h.b bVar = this.f44760i;
        return (bVar == null || bVar.a()) ? false : true;
    }

    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("SwanPluginFunPageModel{providerAppKey='");
        sb.append(this.f44752a);
        sb.append('\'');
        sb.append(", providerRootPath='");
        sb.append(this.f44754c);
        sb.append('\'');
        sb.append(", providerVersion='");
        sb.append(this.f44755d);
        sb.append('\'');
        sb.append(", componentId='");
        sb.append(this.f44757f);
        sb.append('\'');
        sb.append(", cb='");
        sb.append(this.f44759h);
        sb.append('\'');
        sb.append(", pageParams=");
        sb.append(this.f44758g);
        sb.append(", swanApiResult=");
        d.a.l0.a.u.h.b bVar = this.f44760i;
        sb.append(bVar == null ? null : bVar.b());
        sb.append('}');
        return sb.toString();
    }
}
