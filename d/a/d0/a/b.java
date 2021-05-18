package d.a.d0.a;

import org.json.JSONException;
import org.json.JSONObject;
/* loaded from: classes2.dex */
public class b {

    /* renamed from: a  reason: collision with root package name */
    public JSONObject f39772a;

    /* renamed from: d.a.d0.a.b$b  reason: collision with other inner class name */
    /* loaded from: classes2.dex */
    public static class C0519b {

        /* renamed from: a  reason: collision with root package name */
        public JSONObject f39773a = new JSONObject();

        public C0519b(String str, String str2) {
            F("material_type", str);
            F("material_url", str2);
        }

        public C0519b A(int i2) {
            try {
                this.f39773a.put("skip_btn_width", i2);
            } catch (JSONException e2) {
                d.a.d0.a.k.b.i().g(e2);
            }
            return this;
        }

        public C0519b B(int i2) {
            try {
                this.f39773a.put("skipTime", i2);
            } catch (JSONException e2) {
                d.a.d0.a.k.b.i().g(e2);
            }
            return this;
        }

        public C0519b C(int i2) {
            try {
                this.f39773a.put("small_logo_height", i2);
            } catch (JSONException e2) {
                d.a.d0.a.k.b.i().g(e2);
            }
            return this;
        }

        public C0519b D(int i2) {
            try {
                this.f39773a.put("small_logo_width", i2);
            } catch (JSONException e2) {
                d.a.d0.a.k.b.i().g(e2);
            }
            return this;
        }

        public C0519b E(JSONObject jSONObject) {
            try {
                this.f39773a.put("style", jSONObject);
            } catch (JSONException e2) {
                d.a.d0.a.k.b.i().g(e2);
            }
            return this;
        }

        public final void F(String str, String str2) {
            try {
                this.f39773a.put(str, str2);
            } catch (Throwable th) {
                d.a.d0.a.k.b.i().g(th);
            }
        }

        public b a() {
            return new b(this.f39773a);
        }

        public C0519b b(int i2) {
            try {
                this.f39773a.put("ad_click_opt", i2);
            } catch (JSONException e2) {
                d.a.d0.a.k.b.i().g(e2);
            }
            return this;
        }

        public C0519b c(String str) {
            try {
                this.f39773a.put("ad_label", str);
            } catch (JSONException e2) {
                d.a.d0.a.k.b.i().g(e2);
            }
            return this;
        }

        public C0519b d(int i2) {
            try {
                this.f39773a.put("ad_label_height", i2);
            } catch (JSONException e2) {
                d.a.d0.a.k.b.i().g(e2);
            }
            return this;
        }

        public C0519b e(int i2) {
            try {
                this.f39773a.put("ad_label_width", i2);
            } catch (JSONException e2) {
                d.a.d0.a.k.b.i().g(e2);
            }
            return this;
        }

        public C0519b f(String str) {
            try {
                this.f39773a.put("publisher", str);
            } catch (JSONException e2) {
                d.a.d0.a.k.b.i().g(e2);
            }
            return this;
        }

        public C0519b g(String str) {
            try {
                this.f39773a.put("app_version", str);
            } catch (JSONException e2) {
                d.a.d0.a.k.b.i().g(e2);
            }
            return this;
        }

        public C0519b h(int i2) {
            try {
                this.f39773a.put("bottom_logo_height", i2);
            } catch (JSONException e2) {
                d.a.d0.a.k.b.i().g(e2);
            }
            return this;
        }

        public C0519b i(int i2) {
            try {
                this.f39773a.put("close_type", i2);
            } catch (JSONException e2) {
                d.a.d0.a.k.b.i().g(e2);
            }
            return this;
        }

        public C0519b j(boolean z) {
            try {
                this.f39773a.put("displayMantle", z);
            } catch (JSONException e2) {
                d.a.d0.a.k.b.i().g(e2);
            }
            return this;
        }

        public C0519b k(int i2) {
            try {
                this.f39773a.put("bitmapDisplayMode", i2);
            } catch (JSONException e2) {
                d.a.d0.a.k.b.i().g(e2);
            }
            return this;
        }

        public C0519b l(boolean z) {
            try {
                this.f39773a.put("full_screen", z);
            } catch (JSONException e2) {
                d.a.d0.a.k.b.i().g(e2);
            }
            return this;
        }

        public C0519b m(int i2) {
            try {
                this.f39773a.put("host_big_logo_res_id", i2);
            } catch (JSONException e2) {
                d.a.d0.a.k.b.i().g(e2);
            }
            return this;
        }

        public C0519b n(int i2) {
            try {
                this.f39773a.put("host_small_logo_res_id", i2);
            } catch (JSONException e2) {
                d.a.d0.a.k.b.i().g(e2);
            }
            return this;
        }

        public C0519b o(boolean z) {
            try {
                this.f39773a.put("show_host_small_logo", z);
            } catch (JSONException e2) {
                d.a.d0.a.k.b.i().g(e2);
            }
            return this;
        }

        public C0519b p(JSONObject jSONObject) {
            try {
                this.f39773a.put("inner_style", jSONObject);
            } catch (JSONException e2) {
                d.a.d0.a.k.b.i().g(e2);
            }
            return this;
        }

        public C0519b q(String str) {
            F("lottie_url", str);
            return this;
        }

        public C0519b r(String str) {
            try {
                this.f39773a.put("mantleActionText", str);
            } catch (JSONException e2) {
                d.a.d0.a.k.b.i().g(e2);
            }
            return this;
        }

        public C0519b s(int i2) {
            try {
                this.f39773a.put("mantleBottomMargin", i2);
            } catch (JSONException e2) {
                d.a.d0.a.k.b.i().g(e2);
            }
            return this;
        }

        public C0519b t(String str) {
            F("prod", str);
            return this;
        }

        public C0519b u(boolean z) {
            try {
                this.f39773a.put("hide_bd_logo", z);
            } catch (JSONException e2) {
                d.a.d0.a.k.b.i().g(e2);
            }
            return this;
        }

        public C0519b v(boolean z) {
            try {
                this.f39773a.put("Display_Down_Info", z);
            } catch (JSONException e2) {
                d.a.d0.a.k.b.i().g(e2);
            }
            return this;
        }

        public C0519b w(boolean z) {
            try {
                this.f39773a.put("lottie_show", z);
            } catch (JSONException e2) {
                d.a.d0.a.k.b.i().g(e2);
            }
            return this;
        }

        public C0519b x(boolean z) {
            try {
                this.f39773a.put("show_wifi_view", z);
            } catch (JSONException e2) {
                d.a.d0.a.k.b.i().g(e2);
            }
            return this;
        }

        public C0519b y(int i2) {
            try {
                this.f39773a.put("skip_btn_height", i2);
            } catch (JSONException e2) {
                d.a.d0.a.k.b.i().g(e2);
            }
            return this;
        }

        public C0519b z(int i2) {
            try {
                this.f39773a.put("skip_btn_type", i2);
            } catch (JSONException e2) {
                d.a.d0.a.k.b.i().g(e2);
            }
            return this;
        }
    }

    public JSONObject a() {
        return this.f39772a;
    }

    public b(JSONObject jSONObject) {
        this.f39772a = jSONObject;
    }
}
