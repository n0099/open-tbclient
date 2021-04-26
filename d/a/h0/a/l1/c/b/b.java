package d.a.h0.a.l1.c.b;

import android.text.TextUtils;
import org.json.JSONObject;
/* loaded from: classes3.dex */
public class b {

    /* renamed from: a  reason: collision with root package name */
    public String f43243a;

    /* renamed from: b  reason: collision with root package name */
    public String f43244b;

    /* renamed from: c  reason: collision with root package name */
    public String f43245c;

    /* renamed from: d  reason: collision with root package name */
    public String f43246d;

    /* renamed from: e  reason: collision with root package name */
    public String f43247e;

    /* renamed from: f  reason: collision with root package name */
    public String f43248f;

    /* renamed from: g  reason: collision with root package name */
    public JSONObject f43249g;

    /* renamed from: h  reason: collision with root package name */
    public String f43250h;

    /* renamed from: i  reason: collision with root package name */
    public d.a.h0.a.t.e.b f43251i;

    public boolean a() {
        return (TextUtils.isEmpty(this.f43243a) || TextUtils.isEmpty(this.f43245c) || TextUtils.isEmpty(this.f43246d) || TextUtils.isEmpty(this.f43248f) || TextUtils.isEmpty(this.f43247e)) ? false : true;
    }

    public boolean b() {
        d.a.h0.a.t.e.b bVar = this.f43251i;
        return (bVar == null || bVar.a()) ? false : true;
    }

    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("SwanPluginFunPageModel{providerAppKey='");
        sb.append(this.f43243a);
        sb.append('\'');
        sb.append(", providerRootPath='");
        sb.append(this.f43245c);
        sb.append('\'');
        sb.append(", providerVersion='");
        sb.append(this.f43246d);
        sb.append('\'');
        sb.append(", componentId='");
        sb.append(this.f43248f);
        sb.append('\'');
        sb.append(", cb='");
        sb.append(this.f43250h);
        sb.append('\'');
        sb.append(", pageParams=");
        sb.append(this.f43249g);
        sb.append(", swanApiResult=");
        d.a.h0.a.t.e.b bVar = this.f43251i;
        sb.append(bVar == null ? null : bVar.b());
        sb.append('}');
        return sb.toString();
    }
}
