package com.ss.android.downloadlib.addownload.b;

import com.ss.android.downloadlib.g.l;
import org.json.JSONException;
import org.json.JSONObject;
/* loaded from: classes4.dex */
public class a {
    public long a;

    /* renamed from: b  reason: collision with root package name */
    public long f59646b;

    /* renamed from: c  reason: collision with root package name */
    public long f59647c;

    /* renamed from: d  reason: collision with root package name */
    public String f59648d;

    /* renamed from: e  reason: collision with root package name */
    public String f59649e;

    /* renamed from: f  reason: collision with root package name */
    public String f59650f;

    /* renamed from: g  reason: collision with root package name */
    public String f59651g;

    /* renamed from: h  reason: collision with root package name */
    public volatile long f59652h;

    public a() {
    }

    public JSONObject a() {
        JSONObject jSONObject = new JSONObject();
        try {
            jSONObject.put("mDownloadId", this.a);
            jSONObject.put("mAdId", this.f59646b);
            jSONObject.put("mExtValue", this.f59647c);
            jSONObject.put("mPackageName", this.f59648d);
            jSONObject.put("mAppName", this.f59649e);
            jSONObject.put("mLogExtra", this.f59650f);
            jSONObject.put("mFileName", this.f59651g);
            jSONObject.put("mTimeStamp", this.f59652h);
        } catch (JSONException e2) {
            e2.printStackTrace();
        }
        return jSONObject;
    }

    public a(long j2, long j3, long j4, String str, String str2, String str3, String str4) {
        this.a = j2;
        this.f59646b = j3;
        this.f59647c = j4;
        this.f59648d = str;
        this.f59649e = str2;
        this.f59650f = str3;
        this.f59651g = str4;
    }

    public static a a(JSONObject jSONObject) {
        if (jSONObject == null) {
            return null;
        }
        a aVar = new a();
        try {
            aVar.a = l.a(jSONObject, "mDownloadId");
            aVar.f59646b = l.a(jSONObject, "mAdId");
            aVar.f59647c = l.a(jSONObject, "mExtValue");
            aVar.f59648d = jSONObject.optString("mPackageName");
            aVar.f59649e = jSONObject.optString("mAppName");
            aVar.f59650f = jSONObject.optString("mLogExtra");
            aVar.f59651g = jSONObject.optString("mFileName");
            aVar.f59652h = l.a(jSONObject, "mTimeStamp");
            return aVar;
        } catch (Exception e2) {
            e2.printStackTrace();
            return null;
        }
    }
}
