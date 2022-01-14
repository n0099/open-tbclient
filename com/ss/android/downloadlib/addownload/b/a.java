package com.ss.android.downloadlib.addownload.b;

import com.ss.android.downloadlib.g.l;
import org.json.JSONException;
import org.json.JSONObject;
/* loaded from: classes3.dex */
public class a {
    public long a;

    /* renamed from: b  reason: collision with root package name */
    public long f59434b;

    /* renamed from: c  reason: collision with root package name */
    public long f59435c;

    /* renamed from: d  reason: collision with root package name */
    public String f59436d;

    /* renamed from: e  reason: collision with root package name */
    public String f59437e;

    /* renamed from: f  reason: collision with root package name */
    public String f59438f;

    /* renamed from: g  reason: collision with root package name */
    public String f59439g;

    /* renamed from: h  reason: collision with root package name */
    public volatile long f59440h;

    public a() {
    }

    public JSONObject a() {
        JSONObject jSONObject = new JSONObject();
        try {
            jSONObject.put("mDownloadId", this.a);
            jSONObject.put("mAdId", this.f59434b);
            jSONObject.put("mExtValue", this.f59435c);
            jSONObject.put("mPackageName", this.f59436d);
            jSONObject.put("mAppName", this.f59437e);
            jSONObject.put("mLogExtra", this.f59438f);
            jSONObject.put("mFileName", this.f59439g);
            jSONObject.put("mTimeStamp", this.f59440h);
        } catch (JSONException e2) {
            e2.printStackTrace();
        }
        return jSONObject;
    }

    public a(long j2, long j3, long j4, String str, String str2, String str3, String str4) {
        this.a = j2;
        this.f59434b = j3;
        this.f59435c = j4;
        this.f59436d = str;
        this.f59437e = str2;
        this.f59438f = str3;
        this.f59439g = str4;
    }

    public static a a(JSONObject jSONObject) {
        if (jSONObject == null) {
            return null;
        }
        a aVar = new a();
        try {
            aVar.a = l.a(jSONObject, "mDownloadId");
            aVar.f59434b = l.a(jSONObject, "mAdId");
            aVar.f59435c = l.a(jSONObject, "mExtValue");
            aVar.f59436d = jSONObject.optString("mPackageName");
            aVar.f59437e = jSONObject.optString("mAppName");
            aVar.f59438f = jSONObject.optString("mLogExtra");
            aVar.f59439g = jSONObject.optString("mFileName");
            aVar.f59440h = l.a(jSONObject, "mTimeStamp");
            return aVar;
        } catch (Exception e2) {
            e2.printStackTrace();
            return null;
        }
    }
}
