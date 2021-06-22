package d.a.m0.a.t1.f;

import android.text.TextUtils;
import androidx.annotation.NonNull;
import d.a.m0.a.a2.n.e;
import d.a.m0.a.a2.n.f;
import d.a.m0.a.b1.c;
import d.a.m0.a.b1.d;
import org.json.JSONObject;
/* loaded from: classes3.dex */
public class a implements Cloneable {
    public static final e<a> l = new C0888a();
    public static final f<a> m = new b();

    /* renamed from: e  reason: collision with root package name */
    public String f48573e;

    /* renamed from: f  reason: collision with root package name */
    public String f48574f;

    /* renamed from: g  reason: collision with root package name */
    public long f48575g;

    /* renamed from: h  reason: collision with root package name */
    public String f48576h;

    /* renamed from: i  reason: collision with root package name */
    public int f48577i;
    public String j;
    public String k;

    /* renamed from: d.a.m0.a.t1.f.a$a  reason: collision with other inner class name */
    /* loaded from: classes3.dex */
    public static class C0888a extends e<a> {
        /* JADX DEBUG: Method merged with bridge method */
        @Override // d.a.m0.a.a2.n.e
        /* renamed from: c */
        public a b(@NonNull c cVar) throws Exception {
            a aVar = new a();
            aVar.f48573e = cVar.s();
            aVar.f48574f = cVar.s();
            aVar.f48575g = cVar.readLong();
            aVar.f48576h = cVar.s();
            aVar.f48577i = cVar.readInt();
            aVar.j = cVar.s();
            aVar.k = cVar.s();
            return aVar;
        }
    }

    /* loaded from: classes3.dex */
    public static class b extends f<a> {
        /* JADX DEBUG: Method merged with bridge method */
        @Override // d.a.m0.a.a2.n.f
        /* renamed from: c */
        public void b(@NonNull a aVar, @NonNull d dVar) throws Exception {
            dVar.n(aVar.f48573e);
            dVar.n(aVar.f48574f);
            dVar.writeLong(aVar.f48575g);
            dVar.n(aVar.f48576h);
            dVar.writeInt(aVar.f48577i);
            dVar.n(aVar.j);
            dVar.n(aVar.k);
        }
    }

    public a() {
        this.f48575g = -1L;
        this.f48577i = 4;
    }

    public boolean b() {
        return !TextUtils.isEmpty(this.f48576h) && (this.f48575g >= 0 || !TextUtils.isEmpty(this.f48574f));
    }

    public Object clone() throws CloneNotSupportedException {
        return super.clone();
    }

    public String toString() {
        return "SwanPluginModel{pluginAlias='" + this.f48573e + "', pluginVersionName='" + this.f48574f + "', pluginVersionCode='" + this.f48575g + "', pluginName='" + this.f48576h + "', pluginCategory=" + this.f48577i + ", pluginPath='" + this.j + "', pluginPagesConfigFileName='" + this.k + "'}";
    }

    public a(JSONObject jSONObject, int i2) {
        this.f48575g = -1L;
        this.f48577i = 4;
        if (jSONObject == null) {
            return;
        }
        this.f48574f = jSONObject.optString("version");
        this.f48575g = jSONObject.optLong("version_code", -1L);
        this.f48576h = jSONObject.optString("provider");
        this.j = jSONObject.optString("path");
        this.k = jSONObject.optString("config");
        this.f48577i = i2;
    }
}
