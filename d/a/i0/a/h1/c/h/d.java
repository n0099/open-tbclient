package d.a.i0.a.h1.c.h;

import android.annotation.SuppressLint;
import android.text.TextUtils;
import androidx.core.app.NotificationCompatJellybean;
import d.a.i0.a.v2.n0;
import org.json.JSONException;
import org.json.JSONObject;
@SuppressLint({"SwanCommentWar"})
/* loaded from: classes3.dex */
public class d implements d.a.i0.a.l1.a {

    /* renamed from: f  reason: collision with root package name */
    public d.a.i0.a.h1.c.h.c f42502f;
    public b m;
    public c n;
    public a o;

    /* renamed from: e  reason: collision with root package name */
    public String f42501e = "";

    /* renamed from: g  reason: collision with root package name */
    public String f42503g = "";

    /* renamed from: h  reason: collision with root package name */
    public String f42504h = "";

    /* renamed from: i  reason: collision with root package name */
    public double f42505i = 0.0d;
    public double j = 1.0d;
    public int k = -1;
    public int l = -1;

    @SuppressLint({"SwanCommentWar"})
    /* loaded from: classes3.dex */
    public static class a implements d.a.i0.a.l1.a {

        /* renamed from: e  reason: collision with root package name */
        public double f42506e = 0.5d;

        /* renamed from: f  reason: collision with root package name */
        public double f42507f = 1.0d;

        @Override // d.a.i0.a.l1.a
        public void a(JSONObject jSONObject) throws JSONException {
            if (jSONObject == null) {
                return;
            }
            this.f42506e = Math.abs(jSONObject.optDouble("x", 0.5d));
            double d2 = 1.0d;
            this.f42507f = Math.abs(jSONObject.optDouble("y", 1.0d));
            double d3 = this.f42506e;
            if (d3 < 0.0d) {
                d3 = 0.0d;
            } else if (d3 > 1.0d) {
                d3 = 1.0d;
            }
            this.f42506e = d3;
            double d4 = this.f42507f;
            if (d4 < 0.0d) {
                d2 = 0.0d;
            } else if (d4 <= 1.0d) {
                d2 = d4;
            }
            this.f42507f = d2;
        }

        @Override // d.a.i0.a.l1.a
        public boolean isValid() {
            return true;
        }
    }

    @SuppressLint({"SwanCommentWar"})
    /* loaded from: classes3.dex */
    public static class b extends C0691d {
        public float j;
        public String k;
        public int l;

        public b(d dVar) {
            super(dVar);
            this.j = 0.0f;
            this.k = "BYCLICK";
            this.l = -1;
        }

        @Override // d.a.i0.a.h1.c.h.d.C0691d, d.a.i0.a.l1.a
        public void a(JSONObject jSONObject) throws JSONException {
            if (jSONObject == null) {
                return;
            }
            super.a(jSONObject);
            this.j = (float) jSONObject.optDouble("borderRadius", 0.0d);
            jSONObject.optDouble("borderWidth", 0.0d);
            this.k = jSONObject.has("display") ? jSONObject.optString("display") : "BYCLICK";
            this.l = d.a.i0.a.h1.c.d.a(jSONObject.optString("bgColor"), -1);
            d.a.i0.a.h1.c.d.a(jSONObject.optString("borderColor"), this.l);
        }
    }

    @SuppressLint({"SwanCommentWar"})
    /* loaded from: classes3.dex */
    public static class c extends C0691d implements d.a.i0.a.l1.a {
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

        @Override // d.a.i0.a.h1.c.h.d.C0691d, d.a.i0.a.l1.a
        public void a(JSONObject jSONObject) throws JSONException {
            if (jSONObject == null) {
                return;
            }
            super.a(jSONObject);
            this.j = d.a.i0.a.h1.c.d.b(jSONObject.optDouble("x", 0.0d));
            float b2 = d.a.i0.a.h1.c.d.b(jSONObject.optDouble("y", 0.0d));
            this.k = b2;
            if (this.j == 0.0f && b2 == 0.0f) {
                this.j = d.a.i0.a.h1.c.d.b(jSONObject.optDouble("anchorX", 0.0d));
                this.k = d.a.i0.a.h1.c.d.b(jSONObject.optDouble("anchorY", 0.0d));
            }
            this.l = (float) jSONObject.optDouble("borderWidth", 0.0d);
            this.m = d.a.i0.a.h1.c.d.a(jSONObject.optString("borderColor"), 0);
            this.n = (float) jSONObject.optDouble("borderRadius", 0.0d);
        }
    }

    @SuppressLint({"SwanCommentWar"})
    /* renamed from: d.a.i0.a.h1.c.h.d$d  reason: collision with other inner class name */
    /* loaded from: classes3.dex */
    public static class C0691d implements d.a.i0.a.l1.a {

        /* renamed from: e  reason: collision with root package name */
        public String f42508e = "";

        /* renamed from: f  reason: collision with root package name */
        public int f42509f = -16777216;

        /* renamed from: g  reason: collision with root package name */
        public float f42510g = d.a.i0.a.h1.c.d.b(10.0d);

        /* renamed from: h  reason: collision with root package name */
        public int f42511h = 0;

        /* renamed from: i  reason: collision with root package name */
        public float f42512i = 0.0f;

        public C0691d(d dVar) {
        }

        @Override // d.a.i0.a.l1.a
        public void a(JSONObject jSONObject) throws JSONException {
            float b2;
            if (jSONObject != null && jSONObject.has("content")) {
                this.f42508e = jSONObject.optString("content");
                this.f42509f = d.a.i0.a.h1.c.d.a(jSONObject.optString("color"), -16777216);
                if (jSONObject.has("fontSize")) {
                    b2 = Math.abs(d.a.i0.a.h1.c.d.b(jSONObject.optDouble("fontSize", 10.0d)));
                } else {
                    b2 = d.a.i0.a.h1.c.d.b(10.0d);
                }
                this.f42510g = b2;
                this.f42511h = d.a.i0.a.h1.c.d.a(jSONObject.optString("bgColor"), 0);
                this.f42512i = d.a.i0.a.h1.c.d.b(jSONObject.optDouble("padding", 0.0d));
                if (jSONObject.has("textAlign")) {
                    jSONObject.optString("textAlign");
                }
            }
        }

        @Override // d.a.i0.a.l1.a
        public boolean isValid() {
            return !TextUtils.isEmpty(this.f42508e);
        }
    }

    @Override // d.a.i0.a.l1.a
    public void a(JSONObject jSONObject) throws JSONException {
        if (jSONObject == null) {
            return;
        }
        d.a.i0.a.h1.c.h.c cVar = new d.a.i0.a.h1.c.h.c();
        this.f42502f = cVar;
        cVar.a(jSONObject);
        if (this.f42502f.isValid()) {
            String optString = jSONObject.optString("markerId");
            this.f42501e = optString;
            if (TextUtils.isEmpty(optString)) {
                this.f42501e = jSONObject.optString("id");
            }
            this.f42503g = jSONObject.optString("title");
            this.f42504h = jSONObject.optString("iconPath");
            this.f42505i = jSONObject.optDouble("rotate", 0.0d);
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

    @Override // d.a.i0.a.l1.a
    public boolean isValid() {
        d.a.i0.a.h1.c.h.c cVar = this.f42502f;
        return cVar != null && cVar.isValid();
    }
}
