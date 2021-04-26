package d.a.h0.a.l1.f;

import android.text.TextUtils;
import org.json.JSONObject;
/* loaded from: classes3.dex */
public class a implements Cloneable {

    /* renamed from: e  reason: collision with root package name */
    public String f43281e;

    /* renamed from: f  reason: collision with root package name */
    public String f43282f;

    /* renamed from: g  reason: collision with root package name */
    public String f43283g;

    /* renamed from: h  reason: collision with root package name */
    public int f43284h;

    /* renamed from: i  reason: collision with root package name */
    public String f43285i;
    public String j;

    public a(JSONObject jSONObject, int i2) {
        this.f43284h = 4;
        if (jSONObject == null) {
            return;
        }
        this.f43282f = jSONObject.optString("version");
        this.f43283g = jSONObject.optString("provider");
        this.f43285i = jSONObject.optString("path");
        this.j = jSONObject.optString("config");
        this.f43284h = i2;
    }

    public boolean b() {
        return (TextUtils.isEmpty(this.f43283g) || TextUtils.isEmpty(this.f43282f)) ? false : true;
    }

    public Object clone() throws CloneNotSupportedException {
        return super.clone();
    }

    public String toString() {
        return "SwanPluginModel{pluginAlias='" + this.f43281e + "', pluginVersion='" + this.f43282f + "', pluginName='" + this.f43283g + "', pluginCategory=" + this.f43284h + ", pluginPath='" + this.f43285i + "', pluginPagesConfigFileName='" + this.j + "'}";
    }
}
