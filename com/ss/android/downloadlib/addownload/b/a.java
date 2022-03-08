package com.ss.android.downloadlib.addownload.b;

import com.ss.android.downloadlib.g.l;
import org.json.JSONException;
import org.json.JSONObject;
/* loaded from: classes8.dex */
public class a {
    public long a;

    /* renamed from: b  reason: collision with root package name */
    public long f57996b;

    /* renamed from: c  reason: collision with root package name */
    public long f57997c;

    /* renamed from: d  reason: collision with root package name */
    public String f57998d;

    /* renamed from: e  reason: collision with root package name */
    public String f57999e;

    /* renamed from: f  reason: collision with root package name */
    public String f58000f;

    /* renamed from: g  reason: collision with root package name */
    public String f58001g;

    /* renamed from: h  reason: collision with root package name */
    public volatile long f58002h;

    public a() {
    }

    public JSONObject a() {
        JSONObject jSONObject = new JSONObject();
        try {
            jSONObject.put("mDownloadId", this.a);
            jSONObject.put("mAdId", this.f57996b);
            jSONObject.put("mExtValue", this.f57997c);
            jSONObject.put("mPackageName", this.f57998d);
            jSONObject.put("mAppName", this.f57999e);
            jSONObject.put("mLogExtra", this.f58000f);
            jSONObject.put("mFileName", this.f58001g);
            jSONObject.put("mTimeStamp", this.f58002h);
        } catch (JSONException e2) {
            e2.printStackTrace();
        }
        return jSONObject;
    }

    public a(long j2, long j3, long j4, String str, String str2, String str3, String str4) {
        this.a = j2;
        this.f57996b = j3;
        this.f57997c = j4;
        this.f57998d = str;
        this.f57999e = str2;
        this.f58000f = str3;
        this.f58001g = str4;
    }

    public static a a(JSONObject jSONObject) {
        if (jSONObject == null) {
            return null;
        }
        a aVar = new a();
        try {
            aVar.a = l.a(jSONObject, "mDownloadId");
            aVar.f57996b = l.a(jSONObject, "mAdId");
            aVar.f57997c = l.a(jSONObject, "mExtValue");
            aVar.f57998d = jSONObject.optString("mPackageName");
            aVar.f57999e = jSONObject.optString("mAppName");
            aVar.f58000f = jSONObject.optString("mLogExtra");
            aVar.f58001g = jSONObject.optString("mFileName");
            aVar.f58002h = l.a(jSONObject, "mTimeStamp");
            return aVar;
        } catch (Exception e2) {
            e2.printStackTrace();
            return null;
        }
    }
}
