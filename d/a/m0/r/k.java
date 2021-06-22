package d.a.m0.r;

import android.text.TextUtils;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;
/* loaded from: classes3.dex */
public class k {

    /* renamed from: a  reason: collision with root package name */
    public String f52190a;

    /* renamed from: b  reason: collision with root package name */
    public int f52191b;

    /* renamed from: c  reason: collision with root package name */
    public String f52192c;

    /* renamed from: d  reason: collision with root package name */
    public JSONObject f52193d;

    /* renamed from: e  reason: collision with root package name */
    public long f52194e;

    /* renamed from: f  reason: collision with root package name */
    public long f52195f;

    /* renamed from: g  reason: collision with root package name */
    public int f52196g;

    /* renamed from: h  reason: collision with root package name */
    public String f52197h;

    /* renamed from: i  reason: collision with root package name */
    public String f52198i;
    public String j;
    public JSONArray k;
    public boolean l = false;

    public k() {
    }

    public void a() {
        if (d.g().a(this.f52190a)) {
            this.f52198i = e.h().h();
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
        this.f52190a = str;
        this.f52191b = i2;
        this.f52192c = str2;
        this.f52196g = i3;
    }
}
