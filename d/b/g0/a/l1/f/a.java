package d.b.g0.a.l1.f;

import android.text.TextUtils;
import org.json.JSONObject;
/* loaded from: classes3.dex */
public class a implements Cloneable {

    /* renamed from: e  reason: collision with root package name */
    public String f45222e;

    /* renamed from: f  reason: collision with root package name */
    public String f45223f;

    /* renamed from: g  reason: collision with root package name */
    public String f45224g;

    /* renamed from: h  reason: collision with root package name */
    public int f45225h;
    public String i;
    public String j;

    public a(JSONObject jSONObject, int i) {
        this.f45225h = 4;
        if (jSONObject == null) {
            return;
        }
        this.f45223f = jSONObject.optString("version");
        this.f45224g = jSONObject.optString("provider");
        this.i = jSONObject.optString("path");
        this.j = jSONObject.optString("config");
        this.f45225h = i;
    }

    public boolean b() {
        return (TextUtils.isEmpty(this.f45224g) || TextUtils.isEmpty(this.f45223f)) ? false : true;
    }

    public Object clone() throws CloneNotSupportedException {
        return super.clone();
    }

    public String toString() {
        return "SwanPluginModel{pluginAlias='" + this.f45222e + "', pluginVersion='" + this.f45223f + "', pluginName='" + this.f45224g + "', pluginCategory=" + this.f45225h + ", pluginPath='" + this.i + "', pluginPagesConfigFileName='" + this.j + "'}";
    }
}
