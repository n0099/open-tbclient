package d.a.l0.a.t1.f;

import android.text.TextUtils;
import androidx.annotation.NonNull;
import d.a.l0.a.a2.n.e;
import d.a.l0.a.a2.n.f;
import d.a.l0.a.b1.c;
import d.a.l0.a.b1.d;
import org.json.JSONObject;
/* loaded from: classes3.dex */
public class a implements Cloneable {
    public static final e<a> l = new C0885a();
    public static final f<a> m = new b();

    /* renamed from: e  reason: collision with root package name */
    public String f48465e;

    /* renamed from: f  reason: collision with root package name */
    public String f48466f;

    /* renamed from: g  reason: collision with root package name */
    public long f48467g;

    /* renamed from: h  reason: collision with root package name */
    public String f48468h;

    /* renamed from: i  reason: collision with root package name */
    public int f48469i;
    public String j;
    public String k;

    /* renamed from: d.a.l0.a.t1.f.a$a  reason: collision with other inner class name */
    /* loaded from: classes3.dex */
    public static class C0885a extends e<a> {
        /* JADX DEBUG: Method merged with bridge method */
        @Override // d.a.l0.a.a2.n.e
        /* renamed from: c */
        public a b(@NonNull c cVar) throws Exception {
            a aVar = new a();
            aVar.f48465e = cVar.s();
            aVar.f48466f = cVar.s();
            aVar.f48467g = cVar.readLong();
            aVar.f48468h = cVar.s();
            aVar.f48469i = cVar.readInt();
            aVar.j = cVar.s();
            aVar.k = cVar.s();
            return aVar;
        }
    }

    /* loaded from: classes3.dex */
    public static class b extends f<a> {
        /* JADX DEBUG: Method merged with bridge method */
        @Override // d.a.l0.a.a2.n.f
        /* renamed from: c */
        public void b(@NonNull a aVar, @NonNull d dVar) throws Exception {
            dVar.n(aVar.f48465e);
            dVar.n(aVar.f48466f);
            dVar.writeLong(aVar.f48467g);
            dVar.n(aVar.f48468h);
            dVar.writeInt(aVar.f48469i);
            dVar.n(aVar.j);
            dVar.n(aVar.k);
        }
    }

    public a() {
        this.f48467g = -1L;
        this.f48469i = 4;
    }

    public boolean b() {
        return !TextUtils.isEmpty(this.f48468h) && (this.f48467g >= 0 || !TextUtils.isEmpty(this.f48466f));
    }

    public Object clone() throws CloneNotSupportedException {
        return super.clone();
    }

    public String toString() {
        return "SwanPluginModel{pluginAlias='" + this.f48465e + "', pluginVersionName='" + this.f48466f + "', pluginVersionCode='" + this.f48467g + "', pluginName='" + this.f48468h + "', pluginCategory=" + this.f48469i + ", pluginPath='" + this.j + "', pluginPagesConfigFileName='" + this.k + "'}";
    }

    public a(JSONObject jSONObject, int i2) {
        this.f48467g = -1L;
        this.f48469i = 4;
        if (jSONObject == null) {
            return;
        }
        this.f48466f = jSONObject.optString("version");
        this.f48467g = jSONObject.optLong("version_code", -1L);
        this.f48468h = jSONObject.optString("provider");
        this.j = jSONObject.optString("path");
        this.k = jSONObject.optString("config");
        this.f48469i = i2;
    }
}
