package d.a.l0.r;

import android.text.TextUtils;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;
/* loaded from: classes3.dex */
public class k {

    /* renamed from: a  reason: collision with root package name */
    public String f48408a;

    /* renamed from: b  reason: collision with root package name */
    public int f48409b;

    /* renamed from: c  reason: collision with root package name */
    public String f48410c;

    /* renamed from: d  reason: collision with root package name */
    public JSONObject f48411d;

    /* renamed from: e  reason: collision with root package name */
    public long f48412e;

    /* renamed from: f  reason: collision with root package name */
    public long f48413f;

    /* renamed from: g  reason: collision with root package name */
    public int f48414g;

    /* renamed from: h  reason: collision with root package name */
    public String f48415h;

    /* renamed from: i  reason: collision with root package name */
    public String f48416i;
    public String j;
    public JSONArray k;
    public boolean l = false;

    public k() {
    }

    public void a() {
        if (d.g().a(this.f48408a)) {
            this.f48416i = e.h().h();
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
        this.f48408a = str;
        this.f48409b = i2;
        this.f48410c = str2;
        this.f48414g = i3;
    }
}
