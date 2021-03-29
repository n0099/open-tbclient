package d.b.g0.a.l1.f;

import android.text.TextUtils;
import org.json.JSONObject;
/* loaded from: classes2.dex */
public class a implements Cloneable {

    /* renamed from: e  reason: collision with root package name */
    public String f45223e;

    /* renamed from: f  reason: collision with root package name */
    public String f45224f;

    /* renamed from: g  reason: collision with root package name */
    public String f45225g;

    /* renamed from: h  reason: collision with root package name */
    public int f45226h;
    public String i;
    public String j;

    public a(JSONObject jSONObject, int i) {
        this.f45226h = 4;
        if (jSONObject == null) {
            return;
        }
        this.f45224f = jSONObject.optString("version");
        this.f45225g = jSONObject.optString("provider");
        this.i = jSONObject.optString("path");
        this.j = jSONObject.optString("config");
        this.f45226h = i;
    }

    public boolean b() {
        return (TextUtils.isEmpty(this.f45225g) || TextUtils.isEmpty(this.f45224f)) ? false : true;
    }

    public Object clone() throws CloneNotSupportedException {
        return super.clone();
    }

    public String toString() {
        return "SwanPluginModel{pluginAlias='" + this.f45223e + "', pluginVersion='" + this.f45224f + "', pluginName='" + this.f45225g + "', pluginCategory=" + this.f45226h + ", pluginPath='" + this.i + "', pluginPagesConfigFileName='" + this.j + "'}";
    }
}
