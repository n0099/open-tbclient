package d.a.g0.a;

import android.text.TextUtils;
import org.json.JSONException;
import org.json.JSONObject;
/* loaded from: classes2.dex */
public class b {

    /* renamed from: a  reason: collision with root package name */
    public JSONObject f43575a;

    /* renamed from: d.a.g0.a.b$b  reason: collision with other inner class name */
    /* loaded from: classes2.dex */
    public static class C0584b {

        /* renamed from: a  reason: collision with root package name */
        public JSONObject f43576a = new JSONObject();

        public C0584b(String str, String str2) {
            F("material_type", str);
            F("material_url", str2);
        }

        public C0584b A(int i2) {
            try {
                this.f43576a.put("skip_btn_width", i2);
            } catch (JSONException e2) {
                d.a.g0.a.k.b.i().g(e2);
            }
            return this;
        }

        public C0584b B(int i2) {
            try {
                this.f43576a.put("skipTime", i2);
            } catch (JSONException e2) {
                d.a.g0.a.k.b.i().g(e2);
            }
            return this;
        }

        public C0584b C(int i2) {
            try {
                this.f43576a.put("small_logo_height", i2);
            } catch (JSONException e2) {
                d.a.g0.a.k.b.i().g(e2);
            }
            return this;
        }

        public C0584b D(int i2) {
            try {
                this.f43576a.put("small_logo_width", i2);
            } catch (JSONException e2) {
                d.a.g0.a.k.b.i().g(e2);
            }
            return this;
        }

        public C0584b E(JSONObject jSONObject) {
            try {
                this.f43576a.put("style", jSONObject);
            } catch (JSONException e2) {
                d.a.g0.a.k.b.i().g(e2);
            }
            return this;
        }

        public final void F(String str, String str2) {
            try {
                this.f43576a.put(str, str2);
            } catch (Throwable th) {
                d.a.g0.a.k.b.i().g(th);
            }
        }

        public b a() {
            return new b(this.f43576a);
        }

        public C0584b b(int i2) {
            try {
                this.f43576a.put("ad_click_opt", i2);
            } catch (JSONException e2) {
                d.a.g0.a.k.b.i().g(e2);
            }
            return this;
        }

        public C0584b c(String str) {
            try {
                this.f43576a.put("ad_label", str);
                if (TextUtils.isEmpty(str)) {
                    this.f43576a.put("hide_ad_logo", false);
                }
            } catch (JSONException e2) {
                d.a.g0.a.k.b.i().g(e2);
            }
            return this;
        }

        public C0584b d(int i2) {
            try {
                this.f43576a.put("ad_label_height", i2);
            } catch (JSONException e2) {
                d.a.g0.a.k.b.i().g(e2);
            }
            return this;
        }

        public C0584b e(int i2) {
            try {
                this.f43576a.put("ad_label_width", i2);
            } catch (JSONException e2) {
                d.a.g0.a.k.b.i().g(e2);
            }
            return this;
        }

        public C0584b f(String str) {
            try {
                this.f43576a.put("publisher", str);
            } catch (JSONException e2) {
                d.a.g0.a.k.b.i().g(e2);
            }
            return this;
        }

        public C0584b g(String str) {
            try {
                this.f43576a.put("app_version", str);
            } catch (JSONException e2) {
                d.a.g0.a.k.b.i().g(e2);
            }
            return this;
        }

        public C0584b h(int i2) {
            try {
                this.f43576a.put("bottom_logo_height", i2);
            } catch (JSONException e2) {
                d.a.g0.a.k.b.i().g(e2);
            }
            return this;
        }

        public C0584b i(int i2) {
            try {
                this.f43576a.put("close_type", i2);
            } catch (JSONException e2) {
                d.a.g0.a.k.b.i().g(e2);
            }
            return this;
        }

        public C0584b j(boolean z) {
            try {
                this.f43576a.put("displayMantle", z);
            } catch (JSONException e2) {
                d.a.g0.a.k.b.i().g(e2);
            }
            return this;
        }

        public C0584b k(int i2) {
            try {
                this.f43576a.put("bitmapDisplayMode", i2);
            } catch (JSONException e2) {
                d.a.g0.a.k.b.i().g(e2);
            }
            return this;
        }

        public C0584b l(boolean z) {
            try {
                this.f43576a.put("full_screen", z);
            } catch (JSONException e2) {
                d.a.g0.a.k.b.i().g(e2);
            }
            return this;
        }

        public C0584b m(int i2) {
            try {
                this.f43576a.put("host_big_logo_res_id", i2);
            } catch (JSONException e2) {
                d.a.g0.a.k.b.i().g(e2);
            }
            return this;
        }

        public C0584b n(int i2) {
            try {
                this.f43576a.put("host_small_logo_res_id", i2);
            } catch (JSONException e2) {
                d.a.g0.a.k.b.i().g(e2);
            }
            return this;
        }

        public C0584b o(boolean z) {
            try {
                this.f43576a.put("show_host_small_logo", z);
            } catch (JSONException e2) {
                d.a.g0.a.k.b.i().g(e2);
            }
            return this;
        }

        public C0584b p(JSONObject jSONObject) {
            try {
                this.f43576a.put("inner_style", jSONObject);
            } catch (JSONException e2) {
                d.a.g0.a.k.b.i().g(e2);
            }
            return this;
        }

        public C0584b q(String str) {
            F("lottie_url", str);
            return this;
        }

        public C0584b r(String str) {
            try {
                this.f43576a.put("mantleActionText", str);
            } catch (JSONException e2) {
                d.a.g0.a.k.b.i().g(e2);
            }
            return this;
        }

        public C0584b s(int i2) {
            try {
                this.f43576a.put("mantleBottomMargin", i2);
            } catch (JSONException e2) {
                d.a.g0.a.k.b.i().g(e2);
            }
            return this;
        }

        public C0584b t(String str) {
            F("prod", str);
            return this;
        }

        public C0584b u(boolean z) {
            try {
                this.f43576a.put("hide_bd_logo", z);
            } catch (JSONException e2) {
                d.a.g0.a.k.b.i().g(e2);
            }
            return this;
        }

        public C0584b v(boolean z) {
            try {
                this.f43576a.put("Display_Down_Info", z);
            } catch (JSONException e2) {
                d.a.g0.a.k.b.i().g(e2);
            }
            return this;
        }

        public C0584b w(boolean z) {
            try {
                this.f43576a.put("lottie_show", z);
            } catch (JSONException e2) {
                d.a.g0.a.k.b.i().g(e2);
            }
            return this;
        }

        public C0584b x(boolean z) {
            try {
                this.f43576a.put("show_wifi_view", z);
            } catch (JSONException e2) {
                d.a.g0.a.k.b.i().g(e2);
            }
            return this;
        }

        public C0584b y(int i2) {
            try {
                this.f43576a.put("skip_btn_height", i2);
            } catch (JSONException e2) {
                d.a.g0.a.k.b.i().g(e2);
            }
            return this;
        }

        public C0584b z(int i2) {
            try {
                this.f43576a.put("skip_btn_type", i2);
            } catch (JSONException e2) {
                d.a.g0.a.k.b.i().g(e2);
            }
            return this;
        }
    }

    public JSONObject a() {
        return this.f43575a;
    }

    public b(JSONObject jSONObject) {
        this.f43575a = jSONObject;
    }
}
