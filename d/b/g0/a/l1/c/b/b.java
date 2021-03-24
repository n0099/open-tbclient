package d.b.g0.a.l1.c.b;

import android.text.TextUtils;
import org.json.JSONObject;
/* loaded from: classes3.dex */
public class b {

    /* renamed from: a  reason: collision with root package name */
    public String f45186a;

    /* renamed from: b  reason: collision with root package name */
    public String f45187b;

    /* renamed from: c  reason: collision with root package name */
    public String f45188c;

    /* renamed from: d  reason: collision with root package name */
    public String f45189d;

    /* renamed from: e  reason: collision with root package name */
    public String f45190e;

    /* renamed from: f  reason: collision with root package name */
    public String f45191f;

    /* renamed from: g  reason: collision with root package name */
    public JSONObject f45192g;

    /* renamed from: h  reason: collision with root package name */
    public String f45193h;
    public d.b.g0.a.t.e.b i;

    public boolean a() {
        return (TextUtils.isEmpty(this.f45186a) || TextUtils.isEmpty(this.f45188c) || TextUtils.isEmpty(this.f45189d) || TextUtils.isEmpty(this.f45191f) || TextUtils.isEmpty(this.f45190e)) ? false : true;
    }

    public boolean b() {
        d.b.g0.a.t.e.b bVar = this.i;
        return (bVar == null || bVar.b()) ? false : true;
    }

    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("SwanPluginFunPageModel{providerAppKey='");
        sb.append(this.f45186a);
        sb.append('\'');
        sb.append(", providerRootPath='");
        sb.append(this.f45188c);
        sb.append('\'');
        sb.append(", providerVersion='");
        sb.append(this.f45189d);
        sb.append('\'');
        sb.append(", componentId='");
        sb.append(this.f45191f);
        sb.append('\'');
        sb.append(", cb='");
        sb.append(this.f45193h);
        sb.append('\'');
        sb.append(", pageParams=");
        sb.append(this.f45192g);
        sb.append(", swanApiResult=");
        d.b.g0.a.t.e.b bVar = this.i;
        sb.append(bVar == null ? null : bVar.a());
        sb.append('}');
        return sb.toString();
    }
}
