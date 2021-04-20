package d.b.g0.a.d0;

import android.content.ContentValues;
import android.text.TextUtils;
import com.baidu.searchbox.common.runtime.AppRuntime;
import d.b.g0.a.h;
import org.json.JSONObject;
/* loaded from: classes2.dex */
public class a {
    public String A;
    public String B;
    public String C;
    public String D;
    public String E;

    /* renamed from: a  reason: collision with root package name */
    public String f44209a;

    /* renamed from: b  reason: collision with root package name */
    public String f44210b;

    /* renamed from: c  reason: collision with root package name */
    public String f44211c;

    /* renamed from: d  reason: collision with root package name */
    public String f44212d;

    /* renamed from: e  reason: collision with root package name */
    public String f44213e;

    /* renamed from: f  reason: collision with root package name */
    public String f44214f;

    /* renamed from: g  reason: collision with root package name */
    public String f44215g;

    /* renamed from: h  reason: collision with root package name */
    public String f44216h;
    public String i;
    public String j;
    public String k;
    public String l;
    public String m;
    public String n;
    public String o;
    public String p;
    public String q;
    public String r;
    public String s;
    public String t;
    public String u;
    public String v;
    public String w;
    public String x;
    public String y;
    public String z;

    public static a a(JSONObject jSONObject) {
        a aVar = new a();
        if (jSONObject != null) {
            jSONObject.optString("photoFilePath");
            aVar.f44209a = jSONObject.optString("nickName");
            aVar.f44210b = jSONObject.optString("lastName");
            aVar.f44211c = jSONObject.optString("middleName");
            aVar.f44212d = jSONObject.optString("firstName");
            aVar.f44213e = jSONObject.optString("remark");
            aVar.f44214f = jSONObject.optString("mobilePhoneNumber");
            aVar.f44215g = jSONObject.optString("weChatNumber");
            aVar.f44216h = jSONObject.optString("addressCountry");
            aVar.i = jSONObject.optString("addressState");
            aVar.j = jSONObject.optString("addressCity");
            aVar.k = jSONObject.optString("addressStreet");
            aVar.l = jSONObject.optString("addressPostalCode");
            aVar.m = jSONObject.optString("organization");
            aVar.n = jSONObject.optString("title");
            aVar.o = jSONObject.optString("workFaxNumber");
            aVar.p = jSONObject.optString("workPhoneNumber");
            aVar.q = jSONObject.optString("hostNumber");
            aVar.r = jSONObject.optString("email");
            aVar.s = jSONObject.optString("url");
            aVar.t = jSONObject.optString("workAddressCountry");
            aVar.u = jSONObject.optString("workAddressState");
            aVar.v = jSONObject.optString("workAddressCity");
            aVar.w = jSONObject.optString("workAddressStreet");
            aVar.x = jSONObject.optString("workAddressPostalCode");
            aVar.y = jSONObject.optString("homeFaxNumber");
            aVar.z = jSONObject.optString("homePhoneNumber");
            aVar.A = jSONObject.optString("homeAddressCountry");
            aVar.B = jSONObject.optString("homeAddressState");
            aVar.C = jSONObject.optString("homeAddressCity");
            aVar.D = jSONObject.optString("homeAddressStreet");
            aVar.E = jSONObject.optString("homeAddressPostalCode");
        }
        return aVar;
    }

    public ContentValues b() {
        ContentValues contentValues = new ContentValues();
        contentValues.put("mimetype", "vnd.android.cursor.item/postal-address_v2");
        contentValues.put("data2", (Integer) 3);
        contentValues.put("data1", c());
        contentValues.put("data9", this.l);
        return contentValues;
    }

    public String c() {
        StringBuilder sb = new StringBuilder();
        if (!TextUtils.isEmpty(this.f44216h)) {
            sb.append(this.f44216h);
        }
        if (!TextUtils.isEmpty(this.i)) {
            sb.append(this.i);
        }
        if (!TextUtils.isEmpty(this.j)) {
            sb.append(this.j);
        }
        if (!TextUtils.isEmpty(this.k)) {
            sb.append(this.k);
        }
        if (!TextUtils.isEmpty(this.l)) {
            sb.append(" ");
            sb.append(this.l);
        }
        return sb.toString();
    }

    public String d() {
        StringBuilder sb = new StringBuilder();
        if (!TextUtils.isEmpty(this.f44210b)) {
            sb.append(this.f44210b);
        }
        if (!TextUtils.isEmpty(this.f44211c)) {
            sb.append(this.f44211c);
        }
        if (!TextUtils.isEmpty(this.f44212d)) {
            sb.append(this.f44212d);
        }
        return sb.toString();
    }

    public ContentValues e() {
        ContentValues contentValues = new ContentValues();
        contentValues.put("mimetype", "vnd.android.cursor.item/postal-address_v2");
        contentValues.put("data2", (Integer) 1);
        contentValues.put("data1", f());
        contentValues.put("data9", this.E);
        return contentValues;
    }

    public String f() {
        StringBuilder sb = new StringBuilder();
        if (!TextUtils.isEmpty(this.A)) {
            sb.append(this.A);
        }
        if (!TextUtils.isEmpty(this.B)) {
            sb.append(this.B);
        }
        if (!TextUtils.isEmpty(this.C)) {
            sb.append(this.C);
        }
        if (!TextUtils.isEmpty(this.D)) {
            sb.append(this.D);
        }
        if (!TextUtils.isEmpty(this.E)) {
            sb.append(" ");
            sb.append(this.E);
        }
        return sb.toString();
    }

    public ContentValues g() {
        ContentValues contentValues = new ContentValues();
        contentValues.put("mimetype", "vnd.android.cursor.item/phone_v2");
        contentValues.put("data2", (Integer) 5);
        contentValues.put("data1", this.y);
        return contentValues;
    }

    public ContentValues h() {
        ContentValues contentValues = new ContentValues();
        contentValues.put("mimetype", "vnd.android.cursor.item/phone_v2");
        contentValues.put("data2", (Integer) 1);
        contentValues.put("data1", this.z);
        return contentValues;
    }

    public ContentValues i() {
        ContentValues contentValues = new ContentValues();
        contentValues.put("mimetype", "vnd.android.cursor.item/phone_v2");
        contentValues.put("data2", (Integer) 10);
        contentValues.put("data1", this.q);
        return contentValues;
    }

    public ContentValues j() {
        ContentValues contentValues = new ContentValues();
        contentValues.put("mimetype", "vnd.android.cursor.item/phone_v2");
        contentValues.put("data2", (Integer) 2);
        contentValues.put("data1", this.f44214f);
        return contentValues;
    }

    public ContentValues k() {
        ContentValues contentValues = new ContentValues();
        contentValues.put("mimetype", "vnd.android.cursor.item/nickname");
        contentValues.put("data2", (Integer) 1);
        contentValues.put("data1", this.f44209a);
        return contentValues;
    }

    public ContentValues l() {
        ContentValues contentValues = new ContentValues();
        contentValues.put("mimetype", "vnd.android.cursor.item/organization");
        contentValues.put("data2", (Integer) 1);
        contentValues.put("data1", this.m);
        contentValues.put("data4", this.n);
        return contentValues;
    }

    public ContentValues m() {
        ContentValues contentValues = new ContentValues();
        contentValues.put("mimetype", "vnd.android.cursor.item/note");
        contentValues.put("data1", this.f44213e);
        return contentValues;
    }

    public ContentValues n() {
        ContentValues contentValues = new ContentValues();
        contentValues.put("mimetype", "vnd.android.cursor.item/website");
        contentValues.put("data2", (Integer) 1);
        contentValues.put("data1", this.s);
        return contentValues;
    }

    public ContentValues o() {
        ContentValues contentValues = new ContentValues();
        contentValues.put("mimetype", "vnd.android.cursor.item/im");
        contentValues.put("data5", (Integer) (-1));
        contentValues.put("data6", AppRuntime.getAppContext().getString(h.aiapps_cantact_wechat_lable));
        contentValues.put("data1", this.f44215g);
        return contentValues;
    }

    public ContentValues p() {
        ContentValues contentValues = new ContentValues();
        contentValues.put("mimetype", "vnd.android.cursor.item/postal-address_v2");
        contentValues.put("data2", (Integer) 2);
        contentValues.put("data1", q());
        contentValues.put("data9", this.x);
        return contentValues;
    }

    public String q() {
        StringBuilder sb = new StringBuilder();
        if (!TextUtils.isEmpty(this.t)) {
            sb.append(this.t);
        }
        if (!TextUtils.isEmpty(this.u)) {
            sb.append(this.u);
        }
        if (!TextUtils.isEmpty(this.v)) {
            sb.append(this.v);
        }
        if (!TextUtils.isEmpty(this.w)) {
            sb.append(this.w);
        }
        if (!TextUtils.isEmpty(this.x)) {
            sb.append(" ");
            sb.append(this.x);
        }
        return sb.toString();
    }

    public ContentValues r() {
        ContentValues contentValues = new ContentValues();
        contentValues.put("mimetype", "vnd.android.cursor.item/phone_v2");
        contentValues.put("data2", (Integer) 4);
        contentValues.put("data1", this.o);
        return contentValues;
    }

    public ContentValues s() {
        ContentValues contentValues = new ContentValues();
        contentValues.put("mimetype", "vnd.android.cursor.item/phone_v2");
        contentValues.put("data2", (Integer) 3);
        contentValues.put("data1", this.p);
        return contentValues;
    }

    public boolean t() {
        return !TextUtils.isEmpty(this.f44212d);
    }
}
