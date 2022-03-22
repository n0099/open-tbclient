package com.ss.android.downloadlib.addownload.b;

import com.ss.android.downloadlib.g.l;
import org.json.JSONException;
import org.json.JSONObject;
/* loaded from: classes7.dex */
public class a {
    public long a;

    /* renamed from: b  reason: collision with root package name */
    public long f42746b;

    /* renamed from: c  reason: collision with root package name */
    public long f42747c;

    /* renamed from: d  reason: collision with root package name */
    public String f42748d;

    /* renamed from: e  reason: collision with root package name */
    public String f42749e;

    /* renamed from: f  reason: collision with root package name */
    public String f42750f;

    /* renamed from: g  reason: collision with root package name */
    public String f42751g;

    /* renamed from: h  reason: collision with root package name */
    public volatile long f42752h;

    public a() {
    }

    public JSONObject a() {
        JSONObject jSONObject = new JSONObject();
        try {
            jSONObject.put("mDownloadId", this.a);
            jSONObject.put("mAdId", this.f42746b);
            jSONObject.put("mExtValue", this.f42747c);
            jSONObject.put("mPackageName", this.f42748d);
            jSONObject.put("mAppName", this.f42749e);
            jSONObject.put("mLogExtra", this.f42750f);
            jSONObject.put("mFileName", this.f42751g);
            jSONObject.put("mTimeStamp", this.f42752h);
        } catch (JSONException e2) {
            e2.printStackTrace();
        }
        return jSONObject;
    }

    public a(long j, long j2, long j3, String str, String str2, String str3, String str4) {
        this.a = j;
        this.f42746b = j2;
        this.f42747c = j3;
        this.f42748d = str;
        this.f42749e = str2;
        this.f42750f = str3;
        this.f42751g = str4;
    }

    public static a a(JSONObject jSONObject) {
        if (jSONObject == null) {
            return null;
        }
        a aVar = new a();
        try {
            aVar.a = l.a(jSONObject, "mDownloadId");
            aVar.f42746b = l.a(jSONObject, "mAdId");
            aVar.f42747c = l.a(jSONObject, "mExtValue");
            aVar.f42748d = jSONObject.optString("mPackageName");
            aVar.f42749e = jSONObject.optString("mAppName");
            aVar.f42750f = jSONObject.optString("mLogExtra");
            aVar.f42751g = jSONObject.optString("mFileName");
            aVar.f42752h = l.a(jSONObject, "mTimeStamp");
            return aVar;
        } catch (Exception e2) {
            e2.printStackTrace();
            return null;
        }
    }
}
