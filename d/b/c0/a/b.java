package d.b.c0.a;

import org.json.JSONException;
import org.json.JSONObject;
/* loaded from: classes2.dex */
public class b {

    /* renamed from: a  reason: collision with root package name */
    public JSONObject f42968a;

    /* renamed from: d.b.c0.a.b$b  reason: collision with other inner class name */
    /* loaded from: classes2.dex */
    public static class C0571b {

        /* renamed from: a  reason: collision with root package name */
        public JSONObject f42969a = new JSONObject();

        public C0571b(String str, String str2) {
            F("material_type", str);
            F("material_url", str2);
        }

        public C0571b A(int i) {
            try {
                this.f42969a.put("skip_btn_width", i);
            } catch (JSONException e2) {
                d.b.c0.a.k.b.i().g(e2);
            }
            return this;
        }

        public C0571b B(int i) {
            try {
                this.f42969a.put("skipTime", i);
            } catch (JSONException e2) {
                d.b.c0.a.k.b.i().g(e2);
            }
            return this;
        }

        public C0571b C(int i) {
            try {
                this.f42969a.put("small_logo_height", i);
            } catch (JSONException e2) {
                d.b.c0.a.k.b.i().g(e2);
            }
            return this;
        }

        public C0571b D(int i) {
            try {
                this.f42969a.put("small_logo_width", i);
            } catch (JSONException e2) {
                d.b.c0.a.k.b.i().g(e2);
            }
            return this;
        }

        public C0571b E(JSONObject jSONObject) {
            try {
                this.f42969a.put("style", jSONObject);
            } catch (JSONException e2) {
                d.b.c0.a.k.b.i().g(e2);
            }
            return this;
        }

        public final void F(String str, String str2) {
            try {
                this.f42969a.put(str, str2);
            } catch (Throwable th) {
                d.b.c0.a.k.b.i().g(th);
            }
        }

        public b a() {
            return new b(this.f42969a);
        }

        public C0571b b(int i) {
            try {
                this.f42969a.put("ad_click_opt", i);
            } catch (JSONException e2) {
                d.b.c0.a.k.b.i().g(e2);
            }
            return this;
        }

        public C0571b c(String str) {
            try {
                this.f42969a.put("ad_label", str);
            } catch (JSONException e2) {
                d.b.c0.a.k.b.i().g(e2);
            }
            return this;
        }

        public C0571b d(int i) {
            try {
                this.f42969a.put("ad_label_height", i);
            } catch (JSONException e2) {
                d.b.c0.a.k.b.i().g(e2);
            }
            return this;
        }

        public C0571b e(int i) {
            try {
                this.f42969a.put("ad_label_width", i);
            } catch (JSONException e2) {
                d.b.c0.a.k.b.i().g(e2);
            }
            return this;
        }

        public C0571b f(String str) {
            try {
                this.f42969a.put("publisher", str);
            } catch (JSONException e2) {
                d.b.c0.a.k.b.i().g(e2);
            }
            return this;
        }

        public C0571b g(String str) {
            try {
                this.f42969a.put("app_version", str);
            } catch (JSONException e2) {
                d.b.c0.a.k.b.i().g(e2);
            }
            return this;
        }

        public C0571b h(int i) {
            try {
                this.f42969a.put("bottom_logo_height", i);
            } catch (JSONException e2) {
                d.b.c0.a.k.b.i().g(e2);
            }
            return this;
        }

        public C0571b i(int i) {
            try {
                this.f42969a.put("close_type", i);
            } catch (JSONException e2) {
                d.b.c0.a.k.b.i().g(e2);
            }
            return this;
        }

        public C0571b j(boolean z) {
            try {
                this.f42969a.put("displayMantle", z);
            } catch (JSONException e2) {
                d.b.c0.a.k.b.i().g(e2);
            }
            return this;
        }

        public C0571b k(int i) {
            try {
                this.f42969a.put("bitmapDisplayMode", i);
            } catch (JSONException e2) {
                d.b.c0.a.k.b.i().g(e2);
            }
            return this;
        }

        public C0571b l(boolean z) {
            try {
                this.f42969a.put("full_screen", z);
            } catch (JSONException e2) {
                d.b.c0.a.k.b.i().g(e2);
            }
            return this;
        }

        public C0571b m(int i) {
            try {
                this.f42969a.put("host_big_logo_res_id", i);
            } catch (JSONException e2) {
                d.b.c0.a.k.b.i().g(e2);
            }
            return this;
        }

        public C0571b n(int i) {
            try {
                this.f42969a.put("host_small_logo_res_id", i);
            } catch (JSONException e2) {
                d.b.c0.a.k.b.i().g(e2);
            }
            return this;
        }

        public C0571b o(boolean z) {
            try {
                this.f42969a.put("show_host_small_logo", z);
            } catch (JSONException e2) {
                d.b.c0.a.k.b.i().g(e2);
            }
            return this;
        }

        public C0571b p(JSONObject jSONObject) {
            try {
                this.f42969a.put("inner_style", jSONObject);
            } catch (JSONException e2) {
                d.b.c0.a.k.b.i().g(e2);
            }
            return this;
        }

        public C0571b q(String str) {
            F("lottie_url", str);
            return this;
        }

        public C0571b r(String str) {
            try {
                this.f42969a.put("mantleActionText", str);
            } catch (JSONException e2) {
                d.b.c0.a.k.b.i().g(e2);
            }
            return this;
        }

        public C0571b s(int i) {
            try {
                this.f42969a.put("mantleBottomMargin", i);
            } catch (JSONException e2) {
                d.b.c0.a.k.b.i().g(e2);
            }
            return this;
        }

        public C0571b t(String str) {
            F("prod", str);
            return this;
        }

        public C0571b u(boolean z) {
            try {
                this.f42969a.put("hide_bd_logo", z);
            } catch (JSONException e2) {
                d.b.c0.a.k.b.i().g(e2);
            }
            return this;
        }

        public C0571b v(boolean z) {
            try {
                this.f42969a.put("Display_Down_Info", z);
            } catch (JSONException e2) {
                d.b.c0.a.k.b.i().g(e2);
            }
            return this;
        }

        public C0571b w(boolean z) {
            try {
                this.f42969a.put("lottie_show", z);
            } catch (JSONException e2) {
                d.b.c0.a.k.b.i().g(e2);
            }
            return this;
        }

        public C0571b x(boolean z) {
            try {
                this.f42969a.put("show_wifi_view", z);
            } catch (JSONException e2) {
                d.b.c0.a.k.b.i().g(e2);
            }
            return this;
        }

        public C0571b y(int i) {
            try {
                this.f42969a.put("skip_btn_height", i);
            } catch (JSONException e2) {
                d.b.c0.a.k.b.i().g(e2);
            }
            return this;
        }

        public C0571b z(int i) {
            try {
                this.f42969a.put("skip_btn_type", i);
            } catch (JSONException e2) {
                d.b.c0.a.k.b.i().g(e2);
            }
            return this;
        }
    }

    public JSONObject a() {
        return this.f42968a;
    }

    public b(JSONObject jSONObject) {
        this.f42968a = jSONObject;
    }
}
