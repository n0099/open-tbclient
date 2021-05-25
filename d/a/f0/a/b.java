package d.a.f0.a;

import android.text.TextUtils;
import org.json.JSONException;
import org.json.JSONObject;
/* loaded from: classes2.dex */
public class b {

    /* renamed from: a  reason: collision with root package name */
    public JSONObject f39758a;

    /* renamed from: d.a.f0.a.b$b  reason: collision with other inner class name */
    /* loaded from: classes2.dex */
    public static class C0525b {

        /* renamed from: a  reason: collision with root package name */
        public JSONObject f39759a = new JSONObject();

        public C0525b(String str, String str2) {
            F("material_type", str);
            F("material_url", str2);
        }

        public C0525b A(int i2) {
            try {
                this.f39759a.put("skip_btn_width", i2);
            } catch (JSONException e2) {
                d.a.f0.a.k.b.i().g(e2);
            }
            return this;
        }

        public C0525b B(int i2) {
            try {
                this.f39759a.put("skipTime", i2);
            } catch (JSONException e2) {
                d.a.f0.a.k.b.i().g(e2);
            }
            return this;
        }

        public C0525b C(int i2) {
            try {
                this.f39759a.put("small_logo_height", i2);
            } catch (JSONException e2) {
                d.a.f0.a.k.b.i().g(e2);
            }
            return this;
        }

        public C0525b D(int i2) {
            try {
                this.f39759a.put("small_logo_width", i2);
            } catch (JSONException e2) {
                d.a.f0.a.k.b.i().g(e2);
            }
            return this;
        }

        public C0525b E(JSONObject jSONObject) {
            try {
                this.f39759a.put("style", jSONObject);
            } catch (JSONException e2) {
                d.a.f0.a.k.b.i().g(e2);
            }
            return this;
        }

        public final void F(String str, String str2) {
            try {
                this.f39759a.put(str, str2);
            } catch (Throwable th) {
                d.a.f0.a.k.b.i().g(th);
            }
        }

        public b a() {
            return new b(this.f39759a);
        }

        public C0525b b(int i2) {
            try {
                this.f39759a.put("ad_click_opt", i2);
            } catch (JSONException e2) {
                d.a.f0.a.k.b.i().g(e2);
            }
            return this;
        }

        public C0525b c(String str) {
            try {
                this.f39759a.put("ad_label", str);
                if (TextUtils.isEmpty(str)) {
                    this.f39759a.put("hide_ad_logo", false);
                }
            } catch (JSONException e2) {
                d.a.f0.a.k.b.i().g(e2);
            }
            return this;
        }

        public C0525b d(int i2) {
            try {
                this.f39759a.put("ad_label_height", i2);
            } catch (JSONException e2) {
                d.a.f0.a.k.b.i().g(e2);
            }
            return this;
        }

        public C0525b e(int i2) {
            try {
                this.f39759a.put("ad_label_width", i2);
            } catch (JSONException e2) {
                d.a.f0.a.k.b.i().g(e2);
            }
            return this;
        }

        public C0525b f(String str) {
            try {
                this.f39759a.put("publisher", str);
            } catch (JSONException e2) {
                d.a.f0.a.k.b.i().g(e2);
            }
            return this;
        }

        public C0525b g(String str) {
            try {
                this.f39759a.put("app_version", str);
            } catch (JSONException e2) {
                d.a.f0.a.k.b.i().g(e2);
            }
            return this;
        }

        public C0525b h(int i2) {
            try {
                this.f39759a.put("bottom_logo_height", i2);
            } catch (JSONException e2) {
                d.a.f0.a.k.b.i().g(e2);
            }
            return this;
        }

        public C0525b i(int i2) {
            try {
                this.f39759a.put("close_type", i2);
            } catch (JSONException e2) {
                d.a.f0.a.k.b.i().g(e2);
            }
            return this;
        }

        public C0525b j(boolean z) {
            try {
                this.f39759a.put("displayMantle", z);
            } catch (JSONException e2) {
                d.a.f0.a.k.b.i().g(e2);
            }
            return this;
        }

        public C0525b k(int i2) {
            try {
                this.f39759a.put("bitmapDisplayMode", i2);
            } catch (JSONException e2) {
                d.a.f0.a.k.b.i().g(e2);
            }
            return this;
        }

        public C0525b l(boolean z) {
            try {
                this.f39759a.put("full_screen", z);
            } catch (JSONException e2) {
                d.a.f0.a.k.b.i().g(e2);
            }
            return this;
        }

        public C0525b m(int i2) {
            try {
                this.f39759a.put("host_big_logo_res_id", i2);
            } catch (JSONException e2) {
                d.a.f0.a.k.b.i().g(e2);
            }
            return this;
        }

        public C0525b n(int i2) {
            try {
                this.f39759a.put("host_small_logo_res_id", i2);
            } catch (JSONException e2) {
                d.a.f0.a.k.b.i().g(e2);
            }
            return this;
        }

        public C0525b o(boolean z) {
            try {
                this.f39759a.put("show_host_small_logo", z);
            } catch (JSONException e2) {
                d.a.f0.a.k.b.i().g(e2);
            }
            return this;
        }

        public C0525b p(JSONObject jSONObject) {
            try {
                this.f39759a.put("inner_style", jSONObject);
            } catch (JSONException e2) {
                d.a.f0.a.k.b.i().g(e2);
            }
            return this;
        }

        public C0525b q(String str) {
            F("lottie_url", str);
            return this;
        }

        public C0525b r(String str) {
            try {
                this.f39759a.put("mantleActionText", str);
            } catch (JSONException e2) {
                d.a.f0.a.k.b.i().g(e2);
            }
            return this;
        }

        public C0525b s(int i2) {
            try {
                this.f39759a.put("mantleBottomMargin", i2);
            } catch (JSONException e2) {
                d.a.f0.a.k.b.i().g(e2);
            }
            return this;
        }

        public C0525b t(String str) {
            F("prod", str);
            return this;
        }

        public C0525b u(boolean z) {
            try {
                this.f39759a.put("hide_bd_logo", z);
            } catch (JSONException e2) {
                d.a.f0.a.k.b.i().g(e2);
            }
            return this;
        }

        public C0525b v(boolean z) {
            try {
                this.f39759a.put("Display_Down_Info", z);
            } catch (JSONException e2) {
                d.a.f0.a.k.b.i().g(e2);
            }
            return this;
        }

        public C0525b w(boolean z) {
            try {
                this.f39759a.put("lottie_show", z);
            } catch (JSONException e2) {
                d.a.f0.a.k.b.i().g(e2);
            }
            return this;
        }

        public C0525b x(boolean z) {
            try {
                this.f39759a.put("show_wifi_view", z);
            } catch (JSONException e2) {
                d.a.f0.a.k.b.i().g(e2);
            }
            return this;
        }

        public C0525b y(int i2) {
            try {
                this.f39759a.put("skip_btn_height", i2);
            } catch (JSONException e2) {
                d.a.f0.a.k.b.i().g(e2);
            }
            return this;
        }

        public C0525b z(int i2) {
            try {
                this.f39759a.put("skip_btn_type", i2);
            } catch (JSONException e2) {
                d.a.f0.a.k.b.i().g(e2);
            }
            return this;
        }
    }

    public JSONObject a() {
        return this.f39758a;
    }

    public b(JSONObject jSONObject) {
        this.f39758a = jSONObject;
    }
}
