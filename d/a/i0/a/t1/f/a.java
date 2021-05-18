package d.a.i0.a.t1.f;

import android.text.TextUtils;
import androidx.annotation.NonNull;
import d.a.i0.a.a2.n.e;
import d.a.i0.a.a2.n.f;
import d.a.i0.a.b1.c;
import d.a.i0.a.b1.d;
import org.json.JSONObject;
/* loaded from: classes3.dex */
public class a implements Cloneable {
    public static final e<a> l = new C0818a();
    public static final f<a> m = new b();

    /* renamed from: e  reason: collision with root package name */
    public String f44615e;

    /* renamed from: f  reason: collision with root package name */
    public String f44616f;

    /* renamed from: g  reason: collision with root package name */
    public long f44617g;

    /* renamed from: h  reason: collision with root package name */
    public String f44618h;

    /* renamed from: i  reason: collision with root package name */
    public int f44619i;
    public String j;
    public String k;

    /* renamed from: d.a.i0.a.t1.f.a$a  reason: collision with other inner class name */
    /* loaded from: classes3.dex */
    public static class C0818a extends e<a> {
        /* JADX DEBUG: Method merged with bridge method */
        @Override // d.a.i0.a.a2.n.e
        /* renamed from: c */
        public a b(@NonNull c cVar) throws Exception {
            a aVar = new a();
            aVar.f44615e = cVar.s();
            aVar.f44616f = cVar.s();
            aVar.f44617g = cVar.readLong();
            aVar.f44618h = cVar.s();
            aVar.f44619i = cVar.readInt();
            aVar.j = cVar.s();
            aVar.k = cVar.s();
            return aVar;
        }
    }

    /* loaded from: classes3.dex */
    public static class b extends f<a> {
        /* JADX DEBUG: Method merged with bridge method */
        @Override // d.a.i0.a.a2.n.f
        /* renamed from: c */
        public void b(@NonNull a aVar, @NonNull d dVar) throws Exception {
            dVar.n(aVar.f44615e);
            dVar.n(aVar.f44616f);
            dVar.writeLong(aVar.f44617g);
            dVar.n(aVar.f44618h);
            dVar.writeInt(aVar.f44619i);
            dVar.n(aVar.j);
            dVar.n(aVar.k);
        }
    }

    public a() {
        this.f44617g = -1L;
        this.f44619i = 4;
    }

    public boolean b() {
        return !TextUtils.isEmpty(this.f44618h) && (this.f44617g >= 0 || !TextUtils.isEmpty(this.f44616f));
    }

    public Object clone() throws CloneNotSupportedException {
        return super.clone();
    }

    public String toString() {
        return "SwanPluginModel{pluginAlias='" + this.f44615e + "', pluginVersionName='" + this.f44616f + "', pluginVersionCode='" + this.f44617g + "', pluginName='" + this.f44618h + "', pluginCategory=" + this.f44619i + ", pluginPath='" + this.j + "', pluginPagesConfigFileName='" + this.k + "'}";
    }

    public a(JSONObject jSONObject, int i2) {
        this.f44617g = -1L;
        this.f44619i = 4;
        if (jSONObject == null) {
            return;
        }
        this.f44616f = jSONObject.optString("version");
        this.f44617g = jSONObject.optLong("version_code", -1L);
        this.f44618h = jSONObject.optString("provider");
        this.j = jSONObject.optString("path");
        this.k = jSONObject.optString("config");
        this.f44619i = i2;
    }
}
