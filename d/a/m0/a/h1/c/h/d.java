package d.a.m0.a.h1.c.h;

import android.annotation.SuppressLint;
import android.text.TextUtils;
import androidx.core.app.NotificationCompatJellybean;
import d.a.m0.a.v2.n0;
import org.json.JSONException;
import org.json.JSONObject;
@SuppressLint({"SwanCommentWar"})
/* loaded from: classes3.dex */
public class d implements d.a.m0.a.l1.a {

    /* renamed from: f  reason: collision with root package name */
    public d.a.m0.a.h1.c.h.c f46460f;
    public b m;
    public c n;
    public a o;

    /* renamed from: e  reason: collision with root package name */
    public String f46459e = "";

    /* renamed from: g  reason: collision with root package name */
    public String f46461g = "";

    /* renamed from: h  reason: collision with root package name */
    public String f46462h = "";

    /* renamed from: i  reason: collision with root package name */
    public double f46463i = 0.0d;
    public double j = 1.0d;
    public int k = -1;
    public int l = -1;

    @SuppressLint({"SwanCommentWar"})
    /* loaded from: classes3.dex */
    public static class a implements d.a.m0.a.l1.a {

        /* renamed from: e  reason: collision with root package name */
        public double f46464e = 0.5d;

        /* renamed from: f  reason: collision with root package name */
        public double f46465f = 1.0d;

        @Override // d.a.m0.a.l1.a
        public void a(JSONObject jSONObject) throws JSONException {
            if (jSONObject == null) {
                return;
            }
            this.f46464e = Math.abs(jSONObject.optDouble("x", 0.5d));
            double d2 = 1.0d;
            this.f46465f = Math.abs(jSONObject.optDouble("y", 1.0d));
            double d3 = this.f46464e;
            if (d3 < 0.0d) {
                d3 = 0.0d;
            } else if (d3 > 1.0d) {
                d3 = 1.0d;
            }
            this.f46464e = d3;
            double d4 = this.f46465f;
            if (d4 < 0.0d) {
                d2 = 0.0d;
            } else if (d4 <= 1.0d) {
                d2 = d4;
            }
            this.f46465f = d2;
        }

        @Override // d.a.m0.a.l1.a
        public boolean isValid() {
            return true;
        }
    }

    @SuppressLint({"SwanCommentWar"})
    /* loaded from: classes3.dex */
    public static class b extends C0761d {
        public float j;
        public String k;
        public int l;

        public b(d dVar) {
            super(dVar);
            this.j = 0.0f;
            this.k = "BYCLICK";
            this.l = -1;
        }

        @Override // d.a.m0.a.h1.c.h.d.C0761d, d.a.m0.a.l1.a
        public void a(JSONObject jSONObject) throws JSONException {
            if (jSONObject == null) {
                return;
            }
            super.a(jSONObject);
            this.j = (float) jSONObject.optDouble("borderRadius", 0.0d);
            jSONObject.optDouble("borderWidth", 0.0d);
            this.k = jSONObject.has("display") ? jSONObject.optString("display") : "BYCLICK";
            this.l = d.a.m0.a.h1.c.d.a(jSONObject.optString("bgColor"), -1);
            d.a.m0.a.h1.c.d.a(jSONObject.optString("borderColor"), this.l);
        }
    }

    @SuppressLint({"SwanCommentWar"})
    /* loaded from: classes3.dex */
    public static class c extends C0761d implements d.a.m0.a.l1.a {
        public float j;
        public float k;
        public float l;
        public int m;
        public float n;

        public c(d dVar) {
            super(dVar);
            this.j = 0.0f;
            this.k = 0.0f;
            this.l = 0.0f;
            this.m = 0;
            this.n = 0.0f;
        }

        @Override // d.a.m0.a.h1.c.h.d.C0761d, d.a.m0.a.l1.a
        public void a(JSONObject jSONObject) throws JSONException {
            if (jSONObject == null) {
                return;
            }
            super.a(jSONObject);
            this.j = d.a.m0.a.h1.c.d.b(jSONObject.optDouble("x", 0.0d));
            float b2 = d.a.m0.a.h1.c.d.b(jSONObject.optDouble("y", 0.0d));
            this.k = b2;
            if (this.j == 0.0f && b2 == 0.0f) {
                this.j = d.a.m0.a.h1.c.d.b(jSONObject.optDouble("anchorX", 0.0d));
                this.k = d.a.m0.a.h1.c.d.b(jSONObject.optDouble("anchorY", 0.0d));
            }
            this.l = (float) jSONObject.optDouble("borderWidth", 0.0d);
            this.m = d.a.m0.a.h1.c.d.a(jSONObject.optString("borderColor"), 0);
            this.n = (float) jSONObject.optDouble("borderRadius", 0.0d);
        }
    }

    @SuppressLint({"SwanCommentWar"})
    /* renamed from: d.a.m0.a.h1.c.h.d$d  reason: collision with other inner class name */
    /* loaded from: classes3.dex */
    public static class C0761d implements d.a.m0.a.l1.a {

        /* renamed from: e  reason: collision with root package name */
        public String f46466e = "";

        /* renamed from: f  reason: collision with root package name */
        public int f46467f = -16777216;

        /* renamed from: g  reason: collision with root package name */
        public float f46468g = d.a.m0.a.h1.c.d.b(10.0d);

        /* renamed from: h  reason: collision with root package name */
        public int f46469h = 0;

        /* renamed from: i  reason: collision with root package name */
        public float f46470i = 0.0f;

        public C0761d(d dVar) {
        }

        @Override // d.a.m0.a.l1.a
        public void a(JSONObject jSONObject) throws JSONException {
            float b2;
            if (jSONObject != null && jSONObject.has("content")) {
                this.f46466e = jSONObject.optString("content");
                this.f46467f = d.a.m0.a.h1.c.d.a(jSONObject.optString("color"), -16777216);
                if (jSONObject.has("fontSize")) {
                    b2 = Math.abs(d.a.m0.a.h1.c.d.b(jSONObject.optDouble("fontSize", 10.0d)));
                } else {
                    b2 = d.a.m0.a.h1.c.d.b(10.0d);
                }
                this.f46468g = b2;
                this.f46469h = d.a.m0.a.h1.c.d.a(jSONObject.optString("bgColor"), 0);
                this.f46470i = d.a.m0.a.h1.c.d.b(jSONObject.optDouble("padding", 0.0d));
                if (jSONObject.has("textAlign")) {
                    jSONObject.optString("textAlign");
                }
            }
        }

        @Override // d.a.m0.a.l1.a
        public boolean isValid() {
            return !TextUtils.isEmpty(this.f46466e);
        }
    }

    @Override // d.a.m0.a.l1.a
    public void a(JSONObject jSONObject) throws JSONException {
        if (jSONObject == null) {
            return;
        }
        d.a.m0.a.h1.c.h.c cVar = new d.a.m0.a.h1.c.h.c();
        this.f46460f = cVar;
        cVar.a(jSONObject);
        if (this.f46460f.isValid()) {
            String optString = jSONObject.optString("markerId");
            this.f46459e = optString;
            if (TextUtils.isEmpty(optString)) {
                this.f46459e = jSONObject.optString("id");
            }
            this.f46461g = jSONObject.optString("title");
            this.f46462h = jSONObject.optString("iconPath");
            this.f46463i = jSONObject.optDouble("rotate", 0.0d);
            this.j = Math.abs(jSONObject.optDouble("alpha", 1.0d));
            this.k = jSONObject.has("width") ? Math.abs(n0.g(jSONObject.optInt("width"))) : -1;
            this.l = jSONObject.has("height") ? Math.abs(n0.g(jSONObject.optInt("height"))) : -1;
            jSONObject.optInt("zIndex", 0);
            b bVar = new b(this);
            this.m = bVar;
            bVar.a(jSONObject.optJSONObject("callout"));
            c cVar2 = new c(this);
            this.n = cVar2;
            cVar2.a(jSONObject.optJSONObject(NotificationCompatJellybean.KEY_LABEL));
            a aVar = new a();
            this.o = aVar;
            aVar.a(jSONObject.optJSONObject("anchor"));
        }
    }

    @Override // d.a.m0.a.l1.a
    public boolean isValid() {
        d.a.m0.a.h1.c.h.c cVar = this.f46460f;
        return cVar != null && cVar.isValid();
    }
}
