package d.b.d0.a;

import org.json.JSONException;
import org.json.JSONObject;
/* loaded from: classes2.dex */
public class b {

    /* renamed from: a  reason: collision with root package name */
    public JSONObject f43290a;

    /* renamed from: d.b.d0.a.b$b  reason: collision with other inner class name */
    /* loaded from: classes2.dex */
    public static class C0593b {

        /* renamed from: a  reason: collision with root package name */
        public JSONObject f43291a = new JSONObject();

        public C0593b(String str, String str2) {
            F("material_type", str);
            F("material_url", str2);
        }

        public C0593b A(int i) {
            try {
                this.f43291a.put("skip_btn_width", i);
            } catch (JSONException e2) {
                d.b.d0.a.k.b.i().g(e2);
            }
            return this;
        }

        public C0593b B(int i) {
            try {
                this.f43291a.put("skipTime", i);
            } catch (JSONException e2) {
                d.b.d0.a.k.b.i().g(e2);
            }
            return this;
        }

        public C0593b C(int i) {
            try {
                this.f43291a.put("small_logo_height", i);
            } catch (JSONException e2) {
                d.b.d0.a.k.b.i().g(e2);
            }
            return this;
        }

        public C0593b D(int i) {
            try {
                this.f43291a.put("small_logo_width", i);
            } catch (JSONException e2) {
                d.b.d0.a.k.b.i().g(e2);
            }
            return this;
        }

        public C0593b E(JSONObject jSONObject) {
            try {
                this.f43291a.put("style", jSONObject);
            } catch (JSONException e2) {
                d.b.d0.a.k.b.i().g(e2);
            }
            return this;
        }

        public final void F(String str, String str2) {
            try {
                this.f43291a.put(str, str2);
            } catch (Throwable th) {
                d.b.d0.a.k.b.i().g(th);
            }
        }

        public b a() {
            return new b(this.f43291a);
        }

        public C0593b b(int i) {
            try {
                this.f43291a.put("ad_click_opt", i);
            } catch (JSONException e2) {
                d.b.d0.a.k.b.i().g(e2);
            }
            return this;
        }

        public C0593b c(String str) {
            try {
                this.f43291a.put("ad_label", str);
            } catch (JSONException e2) {
                d.b.d0.a.k.b.i().g(e2);
            }
            return this;
        }

        public C0593b d(int i) {
            try {
                this.f43291a.put("ad_label_height", i);
            } catch (JSONException e2) {
                d.b.d0.a.k.b.i().g(e2);
            }
            return this;
        }

        public C0593b e(int i) {
            try {
                this.f43291a.put("ad_label_width", i);
            } catch (JSONException e2) {
                d.b.d0.a.k.b.i().g(e2);
            }
            return this;
        }

        public C0593b f(String str) {
            try {
                this.f43291a.put("publisher", str);
            } catch (JSONException e2) {
                d.b.d0.a.k.b.i().g(e2);
            }
            return this;
        }

        public C0593b g(String str) {
            try {
                this.f43291a.put("app_version", str);
            } catch (JSONException e2) {
                d.b.d0.a.k.b.i().g(e2);
            }
            return this;
        }

        public C0593b h(int i) {
            try {
                this.f43291a.put("bottom_logo_height", i);
            } catch (JSONException e2) {
                d.b.d0.a.k.b.i().g(e2);
            }
            return this;
        }

        public C0593b i(int i) {
            try {
                this.f43291a.put("close_type", i);
            } catch (JSONException e2) {
                d.b.d0.a.k.b.i().g(e2);
            }
            return this;
        }

        public C0593b j(boolean z) {
            try {
                this.f43291a.put("displayMantle", z);
            } catch (JSONException e2) {
                d.b.d0.a.k.b.i().g(e2);
            }
            return this;
        }

        public C0593b k(int i) {
            try {
                this.f43291a.put("bitmapDisplayMode", i);
            } catch (JSONException e2) {
                d.b.d0.a.k.b.i().g(e2);
            }
            return this;
        }

        public C0593b l(boolean z) {
            try {
                this.f43291a.put("full_screen", z);
            } catch (JSONException e2) {
                d.b.d0.a.k.b.i().g(e2);
            }
            return this;
        }

        public C0593b m(int i) {
            try {
                this.f43291a.put("host_big_logo_res_id", i);
            } catch (JSONException e2) {
                d.b.d0.a.k.b.i().g(e2);
            }
            return this;
        }

        public C0593b n(int i) {
            try {
                this.f43291a.put("host_small_logo_res_id", i);
            } catch (JSONException e2) {
                d.b.d0.a.k.b.i().g(e2);
            }
            return this;
        }

        public C0593b o(boolean z) {
            try {
                this.f43291a.put("show_host_small_logo", z);
            } catch (JSONException e2) {
                d.b.d0.a.k.b.i().g(e2);
            }
            return this;
        }

        public C0593b p(JSONObject jSONObject) {
            try {
                this.f43291a.put("inner_style", jSONObject);
            } catch (JSONException e2) {
                d.b.d0.a.k.b.i().g(e2);
            }
            return this;
        }

        public C0593b q(String str) {
            F("lottie_url", str);
            return this;
        }

        public C0593b r(String str) {
            try {
                this.f43291a.put("mantleActionText", str);
            } catch (JSONException e2) {
                d.b.d0.a.k.b.i().g(e2);
            }
            return this;
        }

        public C0593b s(int i) {
            try {
                this.f43291a.put("mantleBottomMargin", i);
            } catch (JSONException e2) {
                d.b.d0.a.k.b.i().g(e2);
            }
            return this;
        }

        public C0593b t(String str) {
            F("prod", str);
            return this;
        }

        public C0593b u(boolean z) {
            try {
                this.f43291a.put("hide_bd_logo", z);
            } catch (JSONException e2) {
                d.b.d0.a.k.b.i().g(e2);
            }
            return this;
        }

        public C0593b v(boolean z) {
            try {
                this.f43291a.put("Display_Down_Info", z);
            } catch (JSONException e2) {
                d.b.d0.a.k.b.i().g(e2);
            }
            return this;
        }

        public C0593b w(boolean z) {
            try {
                this.f43291a.put("lottie_show", z);
            } catch (JSONException e2) {
                d.b.d0.a.k.b.i().g(e2);
            }
            return this;
        }

        public C0593b x(boolean z) {
            try {
                this.f43291a.put("show_wifi_view", z);
            } catch (JSONException e2) {
                d.b.d0.a.k.b.i().g(e2);
            }
            return this;
        }

        public C0593b y(int i) {
            try {
                this.f43291a.put("skip_btn_height", i);
            } catch (JSONException e2) {
                d.b.d0.a.k.b.i().g(e2);
            }
            return this;
        }

        public C0593b z(int i) {
            try {
                this.f43291a.put("skip_btn_type", i);
            } catch (JSONException e2) {
                d.b.d0.a.k.b.i().g(e2);
            }
            return this;
        }
    }

    public JSONObject a() {
        return this.f43290a;
    }

    public b(JSONObject jSONObject) {
        this.f43290a = jSONObject;
    }
}
