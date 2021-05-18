package d.a.i0.r;

import android.text.TextUtils;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;
/* loaded from: classes3.dex */
public class k {

    /* renamed from: a  reason: collision with root package name */
    public String f48232a;

    /* renamed from: b  reason: collision with root package name */
    public int f48233b;

    /* renamed from: c  reason: collision with root package name */
    public String f48234c;

    /* renamed from: d  reason: collision with root package name */
    public JSONObject f48235d;

    /* renamed from: e  reason: collision with root package name */
    public long f48236e;

    /* renamed from: f  reason: collision with root package name */
    public long f48237f;

    /* renamed from: g  reason: collision with root package name */
    public int f48238g;

    /* renamed from: h  reason: collision with root package name */
    public String f48239h;

    /* renamed from: i  reason: collision with root package name */
    public String f48240i;
    public String j;
    public JSONArray k;
    public boolean l = false;

    public k() {
    }

    public void a() {
        if (d.g().a(this.f48232a)) {
            this.f48240i = e.h().h();
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
        this.f48232a = str;
        this.f48233b = i2;
        this.f48234c = str2;
        this.f48238g = i3;
    }
}
