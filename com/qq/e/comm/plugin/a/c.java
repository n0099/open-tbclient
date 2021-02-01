package com.qq.e.comm.plugin.a;

import android.graphics.Bitmap;
import android.os.Bundle;
import android.os.Parcel;
import android.os.Parcelable;
import android.text.TextUtils;
import com.baidu.tbadk.core.atomData.FrsActivityConfig;
import com.qq.e.comm.util.GDTLogger;
import com.qq.e.comm.util.StringUtil;
import com.tencent.mm.opensdk.constants.ConstantsAPI;
import org.json.JSONException;
import org.json.JSONObject;
/* loaded from: classes15.dex */
public final class c implements Parcelable {

    /* renamed from: a  reason: collision with root package name */
    public static final Parcelable.Creator<c> f11605a = new Parcelable.Creator<c>() { // from class: com.qq.e.comm.plugin.a.c.1
        /* JADX DEBUG: Method merged with bridge method */
        @Override // android.os.Parcelable.Creator
        /* renamed from: a */
        public c createFromParcel(Parcel parcel) {
            return new c(parcel);
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // android.os.Parcelable.Creator
        /* renamed from: a */
        public c[] newArray(int i) {
            return new c[i];
        }
    };

    /* renamed from: b  reason: collision with root package name */
    private int f11606b;
    private final int c;
    private int d;
    private final String e;
    private final String f;
    private final String g;
    private final String h;
    private final String i;
    private final String j;
    private final String k;
    private final String l;
    private final String m;
    private final long n;
    private int o;
    private final Bundle p;
    private boolean q;
    private transient Bitmap r;

    private c(Bundle bundle) {
        this(bundle.getString("adId"), bundle.getString("targetId"), bundle.getString("clickId"), bundle.getString("iconUrl"), bundle.getString("targetUrl"), bundle.getString("targetAppName"), bundle.getString("targetPkgName"), bundle.getBundle("property"), bundle.getInt("createNetType"), bundle.getLong("createTime"), bundle.getInt("status"), bundle.getString("title"), bundle.getString("desc"));
        b(bundle.getInt("taskId"));
        c(bundle.getInt(FrsActivityConfig.FLAG));
    }

    private c(Parcel parcel) {
        this(parcel.readString(), parcel.readString(), parcel.readString(), parcel.readString(), parcel.readString(), parcel.readString(), parcel.readString(), parcel.readBundle(), parcel.readInt(), parcel.readLong(), parcel.readInt(), parcel.readString(), parcel.readString());
        b(parcel.readInt());
        c(parcel.readInt());
    }

    public c(String str, String str2, String str3, String str4, String str5, String str6, String str7, int i, String str8, String str9) {
        this(str, str2, str3, str4, str5, str6, str7, new Bundle(), i, System.currentTimeMillis(), 0, str8, str9);
    }

    public c(String str, String str2, String str3, String str4, String str5, String str6, String str7, Bundle bundle, int i, long j, int i2, String str8, String str9) {
        this.o = 0;
        this.e = str;
        this.f = str2;
        this.g = str3;
        this.h = str4;
        this.k = str5;
        this.l = str6;
        this.m = str7;
        this.c = i;
        this.d = i2;
        this.n = j;
        this.i = str8;
        this.j = str9;
        this.p = bundle == null ? new Bundle() : bundle;
        a("notifyId", 0);
        a("notifyTag", "GDT_DOWNLOAD_NOTIFY_TAG_" + h());
        a("autoInstall", true);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static c a(Bundle bundle) {
        if (bundle == null) {
            return null;
        }
        return new c(bundle);
    }

    private Bundle v() {
        return this.p;
    }

    public String a() {
        return this.i;
    }

    public String a(String str) {
        return this.p.getString(str);
    }

    public void a(int i) {
        this.d = i;
    }

    public void a(Bitmap bitmap) {
        this.r = bitmap;
    }

    public void a(String str, int i) {
        this.p.putInt(str, i);
    }

    public void a(String str, long j) {
        this.p.putLong(str, j);
    }

    public void a(String str, String str2) {
        if (TextUtils.isEmpty(str) || TextUtils.isEmpty(str2)) {
            return;
        }
        this.p.putString(str, str2);
    }

    public void a(String str, JSONObject jSONObject, boolean z) {
        JSONObject jSONObject2 = new JSONObject();
        try {
            jSONObject2.put("customized_invoke_url", str);
            jSONObject2.put("reportUrl", jSONObject);
            jSONObject2.put("autoInstall", z);
        } catch (JSONException e) {
        }
        a(ConstantsAPI.Token.WX_LAUNCH_PARAM_KEY, jSONObject2.toString());
    }

    public void a(String str, boolean z) {
        this.p.putBoolean(str, z);
    }

    public void a(JSONObject jSONObject) {
        if (jSONObject != null) {
            a(ConstantsAPI.Token.WX_LAUNCH_PARAM_KEY, jSONObject.toString());
        }
    }

    public void a(boolean z) {
        this.q = z;
    }

    public int b(String str) {
        return this.p.getInt(str);
    }

    public String b() {
        return this.j;
    }

    public void b(int i) {
        this.f11606b = i;
    }

    public void b(boolean z) {
        if (z) {
            d(4);
        } else {
            e(4);
        }
    }

    public long c(String str) {
        return this.p.getLong(str);
    }

    public void c(int i) {
        this.o = i;
    }

    public boolean c() {
        return this.q;
    }

    public long d() {
        return this.n;
    }

    public void d(int i) {
        this.o |= i;
    }

    public boolean d(String str) {
        return this.p.getBoolean(str);
    }

    @Override // android.os.Parcelable
    public int describeContents() {
        return 0;
    }

    public int e() {
        return this.c;
    }

    public void e(int i) {
        this.o &= i ^ (-1);
    }

    public void e(String str) {
        a("failReason", str);
    }

    public String f() {
        return this.l;
    }

    public String g() {
        return this.k;
    }

    public String h() {
        return this.m;
    }

    public String i() {
        return this.h;
    }

    public String j() {
        return this.f;
    }

    public String k() {
        return this.g;
    }

    public String l() {
        return this.e;
    }

    public int m() {
        return this.f11606b;
    }

    public int n() {
        return this.o;
    }

    public int o() {
        return this.d;
    }

    public Bitmap p() {
        return this.r;
    }

    public boolean q() {
        return (this.o & 1) != 0;
    }

    public boolean r() {
        return (this.o & 4) != 0;
    }

    public JSONObject s() {
        String a2 = a(ConstantsAPI.Token.WX_LAUNCH_PARAM_KEY);
        try {
            if (StringUtil.isEmpty(a2)) {
                return null;
            }
            return new JSONObject(a2);
        } catch (JSONException e) {
            GDTLogger.report("JSON Parse launchParam Error,launchParam : " + a2, e);
            return null;
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public String t() {
        JSONObject s = s();
        if (s != null) {
            return s.optString("customized_invoke_url");
        }
        return null;
    }

    public String toString() {
        return "ApkDownloadTask{taskId=" + this.f11606b + ", createNetType=" + this.c + ", status=" + this.d + ", targetAppName='" + this.l + "', targetPkgName='" + this.m + "', createTime=" + this.n + ", isReturned=" + this.q + '}';
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public Bundle u() {
        Bundle bundle = new Bundle();
        bundle.putString("adId", this.e);
        bundle.putInt("taskId", this.f11606b);
        bundle.putString("targetId", this.f);
        bundle.putString("clickId", this.g);
        bundle.putString("iconUrl", this.h);
        bundle.putString("targetUrl", this.k);
        bundle.putString("targetAppName", this.l);
        bundle.putString("targetPkgName", this.m);
        bundle.putInt("createNetType", this.c);
        bundle.putLong("createTime", this.n);
        bundle.putInt("status", this.d);
        bundle.putInt(FrsActivityConfig.FLAG, this.o);
        bundle.putBundle("property", this.p);
        bundle.putString("title", this.i);
        bundle.putString("desc", this.j);
        return bundle;
    }

    @Override // android.os.Parcelable
    public void writeToParcel(Parcel parcel, int i) {
        parcel.writeString(l());
        parcel.writeString(j());
        parcel.writeString(k());
        parcel.writeString(i());
        parcel.writeString(g());
        parcel.writeString(f());
        parcel.writeString(h());
        parcel.writeBundle(v());
        parcel.writeInt(e());
        parcel.writeLong(d());
        parcel.writeInt(o());
        parcel.writeString(a());
        parcel.writeString(b());
        parcel.writeInt(m());
        parcel.writeInt(n());
    }
}
