package d.b.g0.a.a1.c.h;

import android.annotation.SuppressLint;
import android.text.TextUtils;
import androidx.core.app.NotificationCompatJellybean;
import d.b.g0.a.i2.h0;
import org.json.JSONException;
import org.json.JSONObject;
@SuppressLint({"SwanCommentWar"})
/* loaded from: classes3.dex */
public class d implements d.b.g0.a.e1.a {

    /* renamed from: f  reason: collision with root package name */
    public d.b.g0.a.a1.c.h.c f43193f;
    public b m;
    public c n;
    public a o;

    /* renamed from: e  reason: collision with root package name */
    public String f43192e = "";

    /* renamed from: g  reason: collision with root package name */
    public String f43194g = "";

    /* renamed from: h  reason: collision with root package name */
    public String f43195h = "";
    public double i = 0.0d;
    public double j = 1.0d;
    public int k = -1;
    public int l = -1;

    @SuppressLint({"SwanCommentWar"})
    /* loaded from: classes3.dex */
    public static class a implements d.b.g0.a.e1.a {

        /* renamed from: e  reason: collision with root package name */
        public double f43196e = 0.5d;

        /* renamed from: f  reason: collision with root package name */
        public double f43197f = 1.0d;

        @Override // d.b.g0.a.e1.a
        public void a(JSONObject jSONObject) throws JSONException {
            if (jSONObject == null) {
                return;
            }
            this.f43196e = Math.abs(jSONObject.optDouble("x", 0.5d));
            double d2 = 1.0d;
            this.f43197f = Math.abs(jSONObject.optDouble("y", 1.0d));
            double d3 = this.f43196e;
            if (d3 < 0.0d) {
                d3 = 0.0d;
            } else if (d3 > 1.0d) {
                d3 = 1.0d;
            }
            this.f43196e = d3;
            double d4 = this.f43197f;
            if (d4 < 0.0d) {
                d2 = 0.0d;
            } else if (d4 <= 1.0d) {
                d2 = d4;
            }
            this.f43197f = d2;
        }

        @Override // d.b.g0.a.e1.a
        public boolean isValid() {
            return true;
        }
    }

    @SuppressLint({"SwanCommentWar"})
    /* loaded from: classes3.dex */
    public static class b extends C0596d {
        public float j;
        public String k;
        public int l;

        public b(d dVar) {
            super(dVar);
            this.j = 0.0f;
            this.k = "BYCLICK";
            this.l = -1;
        }

        @Override // d.b.g0.a.a1.c.h.d.C0596d, d.b.g0.a.e1.a
        public void a(JSONObject jSONObject) throws JSONException {
            if (jSONObject == null) {
                return;
            }
            super.a(jSONObject);
            this.j = (float) jSONObject.optDouble("borderRadius", 0.0d);
            jSONObject.optDouble("borderWidth", 0.0d);
            d.b.g0.a.a1.c.d.a(jSONObject.optString("borderColor"), -7829368);
            this.k = jSONObject.has("display") ? jSONObject.optString("display") : "BYCLICK";
            this.l = d.b.g0.a.a1.c.d.a(jSONObject.optString("bgColor"), -1);
        }
    }

    @SuppressLint({"SwanCommentWar"})
    /* loaded from: classes3.dex */
    public static class c extends C0596d implements d.b.g0.a.e1.a {
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

        @Override // d.b.g0.a.a1.c.h.d.C0596d, d.b.g0.a.e1.a
        public void a(JSONObject jSONObject) throws JSONException {
            if (jSONObject == null) {
                return;
            }
            super.a(jSONObject);
            this.j = d.b.g0.a.a1.c.d.b(jSONObject.optDouble("x", 0.0d));
            float b2 = d.b.g0.a.a1.c.d.b(jSONObject.optDouble("y", 0.0d));
            this.k = b2;
            if (this.j == 0.0f && b2 == 0.0f) {
                this.j = d.b.g0.a.a1.c.d.b(jSONObject.optDouble("anchorX", 0.0d));
                this.k = d.b.g0.a.a1.c.d.b(jSONObject.optDouble("anchorY", 0.0d));
            }
            this.l = (float) jSONObject.optDouble("borderWidth", 0.0d);
            this.m = d.b.g0.a.a1.c.d.a(jSONObject.optString("borderColor"), 0);
            this.n = (float) jSONObject.optDouble("borderRadius", 0.0d);
        }
    }

    @SuppressLint({"SwanCommentWar"})
    /* renamed from: d.b.g0.a.a1.c.h.d$d  reason: collision with other inner class name */
    /* loaded from: classes3.dex */
    public static class C0596d implements d.b.g0.a.e1.a {

        /* renamed from: e  reason: collision with root package name */
        public String f43198e = "";

        /* renamed from: f  reason: collision with root package name */
        public int f43199f = -16777216;

        /* renamed from: g  reason: collision with root package name */
        public float f43200g = d.b.g0.a.a1.c.d.b(10.0d);

        /* renamed from: h  reason: collision with root package name */
        public int f43201h = 0;
        public float i = 0.0f;

        public C0596d(d dVar) {
        }

        @Override // d.b.g0.a.e1.a
        public void a(JSONObject jSONObject) throws JSONException {
            float b2;
            if (jSONObject != null && jSONObject.has("content")) {
                this.f43198e = jSONObject.optString("content");
                this.f43199f = d.b.g0.a.a1.c.d.a(jSONObject.optString("color"), -16777216);
                if (jSONObject.has("fontSize")) {
                    b2 = Math.abs(d.b.g0.a.a1.c.d.b(jSONObject.optDouble("fontSize", 10.0d)));
                } else {
                    b2 = d.b.g0.a.a1.c.d.b(10.0d);
                }
                this.f43200g = b2;
                this.f43201h = d.b.g0.a.a1.c.d.a(jSONObject.optString("bgColor"), 0);
                this.i = d.b.g0.a.a1.c.d.b(jSONObject.optDouble("padding", 0.0d));
                if (jSONObject.has("textAlign")) {
                    jSONObject.optString("textAlign");
                }
            }
        }

        @Override // d.b.g0.a.e1.a
        public boolean isValid() {
            return !TextUtils.isEmpty(this.f43198e);
        }
    }

    @Override // d.b.g0.a.e1.a
    public void a(JSONObject jSONObject) throws JSONException {
        if (jSONObject == null) {
            return;
        }
        d.b.g0.a.a1.c.h.c cVar = new d.b.g0.a.a1.c.h.c();
        this.f43193f = cVar;
        cVar.a(jSONObject);
        if (this.f43193f.isValid()) {
            String optString = jSONObject.optString("markerId");
            this.f43192e = optString;
            if (TextUtils.isEmpty(optString)) {
                this.f43192e = jSONObject.optString("id");
            }
            this.f43194g = jSONObject.optString("title");
            this.f43195h = jSONObject.optString("iconPath");
            this.i = jSONObject.optDouble("rotate", 0.0d);
            this.j = Math.abs(jSONObject.optDouble("alpha", 1.0d));
            this.k = jSONObject.has("width") ? Math.abs(h0.f(jSONObject.optInt("width"))) : -1;
            this.l = jSONObject.has("height") ? Math.abs(h0.f(jSONObject.optInt("height"))) : -1;
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

    @Override // d.b.g0.a.e1.a
    public boolean isValid() {
        d.b.g0.a.a1.c.h.c cVar = this.f43193f;
        return cVar != null && cVar.isValid();
    }
}
