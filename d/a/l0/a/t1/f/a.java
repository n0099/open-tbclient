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
    public static final e<a> l = new C0829a();
    public static final f<a> m = new b();

    /* renamed from: e  reason: collision with root package name */
    public String f44791e;

    /* renamed from: f  reason: collision with root package name */
    public String f44792f;

    /* renamed from: g  reason: collision with root package name */
    public long f44793g;

    /* renamed from: h  reason: collision with root package name */
    public String f44794h;

    /* renamed from: i  reason: collision with root package name */
    public int f44795i;
    public String j;
    public String k;

    /* renamed from: d.a.l0.a.t1.f.a$a  reason: collision with other inner class name */
    /* loaded from: classes3.dex */
    public static class C0829a extends e<a> {
        /* JADX DEBUG: Method merged with bridge method */
        @Override // d.a.l0.a.a2.n.e
        /* renamed from: c */
        public a b(@NonNull c cVar) throws Exception {
            a aVar = new a();
            aVar.f44791e = cVar.s();
            aVar.f44792f = cVar.s();
            aVar.f44793g = cVar.readLong();
            aVar.f44794h = cVar.s();
            aVar.f44795i = cVar.readInt();
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
            dVar.n(aVar.f44791e);
            dVar.n(aVar.f44792f);
            dVar.writeLong(aVar.f44793g);
            dVar.n(aVar.f44794h);
            dVar.writeInt(aVar.f44795i);
            dVar.n(aVar.j);
            dVar.n(aVar.k);
        }
    }

    public a() {
        this.f44793g = -1L;
        this.f44795i = 4;
    }

    public boolean b() {
        return !TextUtils.isEmpty(this.f44794h) && (this.f44793g >= 0 || !TextUtils.isEmpty(this.f44792f));
    }

    public Object clone() throws CloneNotSupportedException {
        return super.clone();
    }

    public String toString() {
        return "SwanPluginModel{pluginAlias='" + this.f44791e + "', pluginVersionName='" + this.f44792f + "', pluginVersionCode='" + this.f44793g + "', pluginName='" + this.f44794h + "', pluginCategory=" + this.f44795i + ", pluginPath='" + this.j + "', pluginPagesConfigFileName='" + this.k + "'}";
    }

    public a(JSONObject jSONObject, int i2) {
        this.f44793g = -1L;
        this.f44795i = 4;
        if (jSONObject == null) {
            return;
        }
        this.f44792f = jSONObject.optString("version");
        this.f44793g = jSONObject.optLong("version_code", -1L);
        this.f44794h = jSONObject.optString("provider");
        this.j = jSONObject.optString("path");
        this.k = jSONObject.optString("config");
        this.f44795i = i2;
    }
}
