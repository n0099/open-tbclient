package d.b.g0.a.l1.c.b;

import android.text.TextUtils;
import org.json.JSONObject;
/* loaded from: classes2.dex */
public class b {

    /* renamed from: a  reason: collision with root package name */
    public String f45579a;

    /* renamed from: b  reason: collision with root package name */
    public String f45580b;

    /* renamed from: c  reason: collision with root package name */
    public String f45581c;

    /* renamed from: d  reason: collision with root package name */
    public String f45582d;

    /* renamed from: e  reason: collision with root package name */
    public String f45583e;

    /* renamed from: f  reason: collision with root package name */
    public String f45584f;

    /* renamed from: g  reason: collision with root package name */
    public JSONObject f45585g;

    /* renamed from: h  reason: collision with root package name */
    public String f45586h;
    public d.b.g0.a.t.e.b i;

    public boolean a() {
        return (TextUtils.isEmpty(this.f45579a) || TextUtils.isEmpty(this.f45581c) || TextUtils.isEmpty(this.f45582d) || TextUtils.isEmpty(this.f45584f) || TextUtils.isEmpty(this.f45583e)) ? false : true;
    }

    public boolean b() {
        d.b.g0.a.t.e.b bVar = this.i;
        return (bVar == null || bVar.b()) ? false : true;
    }

    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("SwanPluginFunPageModel{providerAppKey='");
        sb.append(this.f45579a);
        sb.append('\'');
        sb.append(", providerRootPath='");
        sb.append(this.f45581c);
        sb.append('\'');
        sb.append(", providerVersion='");
        sb.append(this.f45582d);
        sb.append('\'');
        sb.append(", componentId='");
        sb.append(this.f45584f);
        sb.append('\'');
        sb.append(", cb='");
        sb.append(this.f45586h);
        sb.append('\'');
        sb.append(", pageParams=");
        sb.append(this.f45585g);
        sb.append(", swanApiResult=");
        d.b.g0.a.t.e.b bVar = this.i;
        sb.append(bVar == null ? null : bVar.a());
        sb.append('}');
        return sb.toString();
    }
}
