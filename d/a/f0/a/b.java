package d.a.f0.a;

import android.text.TextUtils;
import org.json.JSONException;
import org.json.JSONObject;
/* loaded from: classes2.dex */
public class b {

    /* renamed from: a  reason: collision with root package name */
    public JSONObject f43439a;

    /* renamed from: d.a.f0.a.b$b  reason: collision with other inner class name */
    /* loaded from: classes2.dex */
    public static class C0581b {

        /* renamed from: a  reason: collision with root package name */
        public JSONObject f43440a = new JSONObject();

        public C0581b(String str, String str2) {
            F("material_type", str);
            F("material_url", str2);
        }

        public C0581b A(int i2) {
            try {
                this.f43440a.put("skip_btn_width", i2);
            } catch (JSONException e2) {
                d.a.f0.a.k.b.i().g(e2);
            }
            return this;
        }

        public C0581b B(int i2) {
            try {
                this.f43440a.put("skipTime", i2);
            } catch (JSONException e2) {
                d.a.f0.a.k.b.i().g(e2);
            }
            return this;
        }

        public C0581b C(int i2) {
            try {
                this.f43440a.put("small_logo_height", i2);
            } catch (JSONException e2) {
                d.a.f0.a.k.b.i().g(e2);
            }
            return this;
        }

        public C0581b D(int i2) {
            try {
                this.f43440a.put("small_logo_width", i2);
            } catch (JSONException e2) {
                d.a.f0.a.k.b.i().g(e2);
            }
            return this;
        }

        public C0581b E(JSONObject jSONObject) {
            try {
                this.f43440a.put("style", jSONObject);
            } catch (JSONException e2) {
                d.a.f0.a.k.b.i().g(e2);
            }
            return this;
        }

        public final void F(String str, String str2) {
            try {
                this.f43440a.put(str, str2);
            } catch (Throwable th) {
                d.a.f0.a.k.b.i().g(th);
            }
        }

        public b a() {
            return new b(this.f43440a);
        }

        public C0581b b(int i2) {
            try {
                this.f43440a.put("ad_click_opt", i2);
            } catch (JSONException e2) {
                d.a.f0.a.k.b.i().g(e2);
            }
            return this;
        }

        public C0581b c(String str) {
            try {
                this.f43440a.put("ad_label", str);
                if (TextUtils.isEmpty(str)) {
                    this.f43440a.put("hide_ad_logo", false);
                }
            } catch (JSONException e2) {
                d.a.f0.a.k.b.i().g(e2);
            }
            return this;
        }

        public C0581b d(int i2) {
            try {
                this.f43440a.put("ad_label_height", i2);
            } catch (JSONException e2) {
                d.a.f0.a.k.b.i().g(e2);
            }
            return this;
        }

        public C0581b e(int i2) {
            try {
                this.f43440a.put("ad_label_width", i2);
            } catch (JSONException e2) {
                d.a.f0.a.k.b.i().g(e2);
            }
            return this;
        }

        public C0581b f(String str) {
            try {
                this.f43440a.put("publisher", str);
            } catch (JSONException e2) {
                d.a.f0.a.k.b.i().g(e2);
            }
            return this;
        }

        public C0581b g(String str) {
            try {
                this.f43440a.put("app_version", str);
            } catch (JSONException e2) {
                d.a.f0.a.k.b.i().g(e2);
            }
            return this;
        }

        public C0581b h(int i2) {
            try {
                this.f43440a.put("bottom_logo_height", i2);
            } catch (JSONException e2) {
                d.a.f0.a.k.b.i().g(e2);
            }
            return this;
        }

        public C0581b i(int i2) {
            try {
                this.f43440a.put("close_type", i2);
            } catch (JSONException e2) {
                d.a.f0.a.k.b.i().g(e2);
            }
            return this;
        }

        public C0581b j(boolean z) {
            try {
                this.f43440a.put("displayMantle", z);
            } catch (JSONException e2) {
                d.a.f0.a.k.b.i().g(e2);
            }
            return this;
        }

        public C0581b k(int i2) {
            try {
                this.f43440a.put("bitmapDisplayMode", i2);
            } catch (JSONException e2) {
                d.a.f0.a.k.b.i().g(e2);
            }
            return this;
        }

        public C0581b l(boolean z) {
            try {
                this.f43440a.put("full_screen", z);
            } catch (JSONException e2) {
                d.a.f0.a.k.b.i().g(e2);
            }
            return this;
        }

        public C0581b m(int i2) {
            try {
                this.f43440a.put("host_big_logo_res_id", i2);
            } catch (JSONException e2) {
                d.a.f0.a.k.b.i().g(e2);
            }
            return this;
        }

        public C0581b n(int i2) {
            try {
                this.f43440a.put("host_small_logo_res_id", i2);
            } catch (JSONException e2) {
                d.a.f0.a.k.b.i().g(e2);
            }
            return this;
        }

        public C0581b o(boolean z) {
            try {
                this.f43440a.put("show_host_small_logo", z);
            } catch (JSONException e2) {
                d.a.f0.a.k.b.i().g(e2);
            }
            return this;
        }

        public C0581b p(JSONObject jSONObject) {
            try {
                this.f43440a.put("inner_style", jSONObject);
            } catch (JSONException e2) {
                d.a.f0.a.k.b.i().g(e2);
            }
            return this;
        }

        public C0581b q(String str) {
            F("lottie_url", str);
            return this;
        }

        public C0581b r(String str) {
            try {
                this.f43440a.put("mantleActionText", str);
            } catch (JSONException e2) {
                d.a.f0.a.k.b.i().g(e2);
            }
            return this;
        }

        public C0581b s(int i2) {
            try {
                this.f43440a.put("mantleBottomMargin", i2);
            } catch (JSONException e2) {
                d.a.f0.a.k.b.i().g(e2);
            }
            return this;
        }

        public C0581b t(String str) {
            F("prod", str);
            return this;
        }

        public C0581b u(boolean z) {
            try {
                this.f43440a.put("hide_bd_logo", z);
            } catch (JSONException e2) {
                d.a.f0.a.k.b.i().g(e2);
            }
            return this;
        }

        public C0581b v(boolean z) {
            try {
                this.f43440a.put("Display_Down_Info", z);
            } catch (JSONException e2) {
                d.a.f0.a.k.b.i().g(e2);
            }
            return this;
        }

        public C0581b w(boolean z) {
            try {
                this.f43440a.put("lottie_show", z);
            } catch (JSONException e2) {
                d.a.f0.a.k.b.i().g(e2);
            }
            return this;
        }

        public C0581b x(boolean z) {
            try {
                this.f43440a.put("show_wifi_view", z);
            } catch (JSONException e2) {
                d.a.f0.a.k.b.i().g(e2);
            }
            return this;
        }

        public C0581b y(int i2) {
            try {
                this.f43440a.put("skip_btn_height", i2);
            } catch (JSONException e2) {
                d.a.f0.a.k.b.i().g(e2);
            }
            return this;
        }

        public C0581b z(int i2) {
            try {
                this.f43440a.put("skip_btn_type", i2);
            } catch (JSONException e2) {
                d.a.f0.a.k.b.i().g(e2);
            }
            return this;
        }
    }

    public JSONObject a() {
        return this.f43439a;
    }

    public b(JSONObject jSONObject) {
        this.f43439a = jSONObject;
    }
}
