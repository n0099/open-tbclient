package d.a.l0.r;

import android.text.TextUtils;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;
/* loaded from: classes3.dex */
public class k {

    /* renamed from: a  reason: collision with root package name */
    public String f52082a;

    /* renamed from: b  reason: collision with root package name */
    public int f52083b;

    /* renamed from: c  reason: collision with root package name */
    public String f52084c;

    /* renamed from: d  reason: collision with root package name */
    public JSONObject f52085d;

    /* renamed from: e  reason: collision with root package name */
    public long f52086e;

    /* renamed from: f  reason: collision with root package name */
    public long f52087f;

    /* renamed from: g  reason: collision with root package name */
    public int f52088g;

    /* renamed from: h  reason: collision with root package name */
    public String f52089h;

    /* renamed from: i  reason: collision with root package name */
    public String f52090i;
    public String j;
    public JSONArray k;
    public boolean l = false;

    public k() {
    }

    public void a() {
        if (d.g().a(this.f52082a)) {
            this.f52090i = e.h().h();
        }
    }

    public void b(String str) {
        if (TextUtils.isEmpty(str)) {
            return;
        }
        try {
            this.k = new JSONArray(str);
        } catch (JSONException e2) {
            e2.printStackTrace();
        }
    }

    public k(String str, int i2, String str2, int i3, boolean z) {
        this.f52082a = str;
        this.f52083b = i2;
        this.f52084c = str2;
        this.f52088g = i3;
    }
}
