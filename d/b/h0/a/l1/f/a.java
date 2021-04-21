package d.b.h0.a.l1.f;

import android.text.TextUtils;
import org.json.JSONObject;
/* loaded from: classes2.dex */
public class a implements Cloneable {

    /* renamed from: e  reason: collision with root package name */
    public String f45944e;

    /* renamed from: f  reason: collision with root package name */
    public String f45945f;

    /* renamed from: g  reason: collision with root package name */
    public String f45946g;

    /* renamed from: h  reason: collision with root package name */
    public int f45947h;
    public String i;
    public String j;

    public a(JSONObject jSONObject, int i) {
        this.f45947h = 4;
        if (jSONObject == null) {
            return;
        }
        this.f45945f = jSONObject.optString("version");
        this.f45946g = jSONObject.optString("provider");
        this.i = jSONObject.optString("path");
        this.j = jSONObject.optString("config");
        this.f45947h = i;
    }

    public boolean b() {
        return (TextUtils.isEmpty(this.f45946g) || TextUtils.isEmpty(this.f45945f)) ? false : true;
    }

    public Object clone() throws CloneNotSupportedException {
        return super.clone();
    }

    public String toString() {
        return "SwanPluginModel{pluginAlias='" + this.f45944e + "', pluginVersion='" + this.f45945f + "', pluginName='" + this.f45946g + "', pluginCategory=" + this.f45947h + ", pluginPath='" + this.i + "', pluginPagesConfigFileName='" + this.j + "'}";
    }
}
