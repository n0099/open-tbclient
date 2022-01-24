package com.ss.android.downloadlib.addownload.b;

import com.ss.android.downloadlib.g.l;
import org.json.JSONException;
import org.json.JSONObject;
/* loaded from: classes4.dex */
public class a {
    public long a;

    /* renamed from: b  reason: collision with root package name */
    public long f59479b;

    /* renamed from: c  reason: collision with root package name */
    public long f59480c;

    /* renamed from: d  reason: collision with root package name */
    public String f59481d;

    /* renamed from: e  reason: collision with root package name */
    public String f59482e;

    /* renamed from: f  reason: collision with root package name */
    public String f59483f;

    /* renamed from: g  reason: collision with root package name */
    public String f59484g;

    /* renamed from: h  reason: collision with root package name */
    public volatile long f59485h;

    public a() {
    }

    public JSONObject a() {
        JSONObject jSONObject = new JSONObject();
        try {
            jSONObject.put("mDownloadId", this.a);
            jSONObject.put("mAdId", this.f59479b);
            jSONObject.put("mExtValue", this.f59480c);
            jSONObject.put("mPackageName", this.f59481d);
            jSONObject.put("mAppName", this.f59482e);
            jSONObject.put("mLogExtra", this.f59483f);
            jSONObject.put("mFileName", this.f59484g);
            jSONObject.put("mTimeStamp", this.f59485h);
        } catch (JSONException e2) {
            e2.printStackTrace();
        }
        return jSONObject;
    }

    public a(long j2, long j3, long j4, String str, String str2, String str3, String str4) {
        this.a = j2;
        this.f59479b = j3;
        this.f59480c = j4;
        this.f59481d = str;
        this.f59482e = str2;
        this.f59483f = str3;
        this.f59484g = str4;
    }

    public static a a(JSONObject jSONObject) {
        if (jSONObject == null) {
            return null;
        }
        a aVar = new a();
        try {
            aVar.a = l.a(jSONObject, "mDownloadId");
            aVar.f59479b = l.a(jSONObject, "mAdId");
            aVar.f59480c = l.a(jSONObject, "mExtValue");
            aVar.f59481d = jSONObject.optString("mPackageName");
            aVar.f59482e = jSONObject.optString("mAppName");
            aVar.f59483f = jSONObject.optString("mLogExtra");
            aVar.f59484g = jSONObject.optString("mFileName");
            aVar.f59485h = l.a(jSONObject, "mTimeStamp");
            return aVar;
        } catch (Exception e2) {
            e2.printStackTrace();
            return null;
        }
    }
}
