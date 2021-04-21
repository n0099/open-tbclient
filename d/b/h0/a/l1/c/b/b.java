package d.b.h0.a.l1.c.b;

import android.text.TextUtils;
import org.json.JSONObject;
/* loaded from: classes2.dex */
public class b {

    /* renamed from: a  reason: collision with root package name */
    public String f45908a;

    /* renamed from: b  reason: collision with root package name */
    public String f45909b;

    /* renamed from: c  reason: collision with root package name */
    public String f45910c;

    /* renamed from: d  reason: collision with root package name */
    public String f45911d;

    /* renamed from: e  reason: collision with root package name */
    public String f45912e;

    /* renamed from: f  reason: collision with root package name */
    public String f45913f;

    /* renamed from: g  reason: collision with root package name */
    public JSONObject f45914g;

    /* renamed from: h  reason: collision with root package name */
    public String f45915h;
    public d.b.h0.a.t.e.b i;

    public boolean a() {
        return (TextUtils.isEmpty(this.f45908a) || TextUtils.isEmpty(this.f45910c) || TextUtils.isEmpty(this.f45911d) || TextUtils.isEmpty(this.f45913f) || TextUtils.isEmpty(this.f45912e)) ? false : true;
    }

    public boolean b() {
        d.b.h0.a.t.e.b bVar = this.i;
        return (bVar == null || bVar.b()) ? false : true;
    }

    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("SwanPluginFunPageModel{providerAppKey='");
        sb.append(this.f45908a);
        sb.append('\'');
        sb.append(", providerRootPath='");
        sb.append(this.f45910c);
        sb.append('\'');
        sb.append(", providerVersion='");
        sb.append(this.f45911d);
        sb.append('\'');
        sb.append(", componentId='");
        sb.append(this.f45913f);
        sb.append('\'');
        sb.append(", cb='");
        sb.append(this.f45915h);
        sb.append('\'');
        sb.append(", pageParams=");
        sb.append(this.f45914g);
        sb.append(", swanApiResult=");
        d.b.h0.a.t.e.b bVar = this.i;
        sb.append(bVar == null ? null : bVar.a());
        sb.append('}');
        return sb.toString();
    }
}
