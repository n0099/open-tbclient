package d.a.d0.a;

import org.json.JSONException;
import org.json.JSONObject;
/* loaded from: classes2.dex */
public class b {

    /* renamed from: a  reason: collision with root package name */
    public JSONObject f40527a;

    /* renamed from: d.a.d0.a.b$b  reason: collision with other inner class name */
    /* loaded from: classes2.dex */
    public static class C0532b {

        /* renamed from: a  reason: collision with root package name */
        public JSONObject f40528a = new JSONObject();

        public C0532b(String str, String str2) {
            F("material_type", str);
            F("material_url", str2);
        }

        public C0532b A(int i2) {
            try {
                this.f40528a.put("skip_btn_width", i2);
            } catch (JSONException e2) {
                d.a.d0.a.k.b.i().g(e2);
            }
            return this;
        }

        public C0532b B(int i2) {
            try {
                this.f40528a.put("skipTime", i2);
            } catch (JSONException e2) {
                d.a.d0.a.k.b.i().g(e2);
            }
            return this;
        }

        public C0532b C(int i2) {
            try {
                this.f40528a.put("small_logo_height", i2);
            } catch (JSONException e2) {
                d.a.d0.a.k.b.i().g(e2);
            }
            return this;
        }

        public C0532b D(int i2) {
            try {
                this.f40528a.put("small_logo_width", i2);
            } catch (JSONException e2) {
                d.a.d0.a.k.b.i().g(e2);
            }
            return this;
        }

        public C0532b E(JSONObject jSONObject) {
            try {
                this.f40528a.put("style", jSONObject);
            } catch (JSONException e2) {
                d.a.d0.a.k.b.i().g(e2);
            }
            return this;
        }

        public final void F(String str, String str2) {
            try {
                this.f40528a.put(str, str2);
            } catch (Throwable th) {
                d.a.d0.a.k.b.i().g(th);
            }
        }

        public b a() {
            return new b(this.f40528a);
        }

        public C0532b b(int i2) {
            try {
                this.f40528a.put("ad_click_opt", i2);
            } catch (JSONException e2) {
                d.a.d0.a.k.b.i().g(e2);
            }
            return this;
        }

        public C0532b c(String str) {
            try {
                this.f40528a.put("ad_label", str);
            } catch (JSONException e2) {
                d.a.d0.a.k.b.i().g(e2);
            }
            return this;
        }

        public C0532b d(int i2) {
            try {
                this.f40528a.put("ad_label_height", i2);
            } catch (JSONException e2) {
                d.a.d0.a.k.b.i().g(e2);
            }
            return this;
        }

        public C0532b e(int i2) {
            try {
                this.f40528a.put("ad_label_width", i2);
            } catch (JSONException e2) {
                d.a.d0.a.k.b.i().g(e2);
            }
            return this;
        }

        public C0532b f(String str) {
            try {
                this.f40528a.put("publisher", str);
            } catch (JSONException e2) {
                d.a.d0.a.k.b.i().g(e2);
            }
            return this;
        }

        public C0532b g(String str) {
            try {
                this.f40528a.put("app_version", str);
            } catch (JSONException e2) {
                d.a.d0.a.k.b.i().g(e2);
            }
            return this;
        }

        public C0532b h(int i2) {
            try {
                this.f40528a.put("bottom_logo_height", i2);
            } catch (JSONException e2) {
                d.a.d0.a.k.b.i().g(e2);
            }
            return this;
        }

        public C0532b i(int i2) {
            try {
                this.f40528a.put("close_type", i2);
            } catch (JSONException e2) {
                d.a.d0.a.k.b.i().g(e2);
            }
            return this;
        }

        public C0532b j(boolean z) {
            try {
                this.f40528a.put("displayMantle", z);
            } catch (JSONException e2) {
                d.a.d0.a.k.b.i().g(e2);
            }
            return this;
        }

        public C0532b k(int i2) {
            try {
                this.f40528a.put("bitmapDisplayMode", i2);
            } catch (JSONException e2) {
                d.a.d0.a.k.b.i().g(e2);
            }
            return this;
        }

        public C0532b l(boolean z) {
            try {
                this.f40528a.put("full_screen", z);
            } catch (JSONException e2) {
                d.a.d0.a.k.b.i().g(e2);
            }
            return this;
        }

        public C0532b m(int i2) {
            try {
                this.f40528a.put("host_big_logo_res_id", i2);
            } catch (JSONException e2) {
                d.a.d0.a.k.b.i().g(e2);
            }
            return this;
        }

        public C0532b n(int i2) {
            try {
                this.f40528a.put("host_small_logo_res_id", i2);
            } catch (JSONException e2) {
                d.a.d0.a.k.b.i().g(e2);
            }
            return this;
        }

        public C0532b o(boolean z) {
            try {
                this.f40528a.put("show_host_small_logo", z);
            } catch (JSONException e2) {
                d.a.d0.a.k.b.i().g(e2);
            }
            return this;
        }

        public C0532b p(JSONObject jSONObject) {
            try {
                this.f40528a.put("inner_style", jSONObject);
            } catch (JSONException e2) {
                d.a.d0.a.k.b.i().g(e2);
            }
            return this;
        }

        public C0532b q(String str) {
            F("lottie_url", str);
            return this;
        }

        public C0532b r(String str) {
            try {
                this.f40528a.put("mantleActionText", str);
            } catch (JSONException e2) {
                d.a.d0.a.k.b.i().g(e2);
            }
            return this;
        }

        public C0532b s(int i2) {
            try {
                this.f40528a.put("mantleBottomMargin", i2);
            } catch (JSONException e2) {
                d.a.d0.a.k.b.i().g(e2);
            }
            return this;
        }

        public C0532b t(String str) {
            F("prod", str);
            return this;
        }

        public C0532b u(boolean z) {
            try {
                this.f40528a.put("hide_bd_logo", z);
            } catch (JSONException e2) {
                d.a.d0.a.k.b.i().g(e2);
            }
            return this;
        }

        public C0532b v(boolean z) {
            try {
                this.f40528a.put("Display_Down_Info", z);
            } catch (JSONException e2) {
                d.a.d0.a.k.b.i().g(e2);
            }
            return this;
        }

        public C0532b w(boolean z) {
            try {
                this.f40528a.put("lottie_show", z);
            } catch (JSONException e2) {
                d.a.d0.a.k.b.i().g(e2);
            }
            return this;
        }

        public C0532b x(boolean z) {
            try {
                this.f40528a.put("show_wifi_view", z);
            } catch (JSONException e2) {
                d.a.d0.a.k.b.i().g(e2);
            }
            return this;
        }

        public C0532b y(int i2) {
            try {
                this.f40528a.put("skip_btn_height", i2);
            } catch (JSONException e2) {
                d.a.d0.a.k.b.i().g(e2);
            }
            return this;
        }

        public C0532b z(int i2) {
            try {
                this.f40528a.put("skip_btn_type", i2);
            } catch (JSONException e2) {
                d.a.d0.a.k.b.i().g(e2);
            }
            return this;
        }
    }

    public JSONObject a() {
        return this.f40527a;
    }

    public b(JSONObject jSONObject) {
        this.f40527a = jSONObject;
    }
}
