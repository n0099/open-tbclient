package com.ss.android.downloadlib.addownload.b;

import com.ss.android.downloadlib.g.l;
import org.json.JSONException;
import org.json.JSONObject;
/* loaded from: classes3.dex */
public class a {
    public long a;

    /* renamed from: b  reason: collision with root package name */
    public long f61774b;

    /* renamed from: c  reason: collision with root package name */
    public long f61775c;

    /* renamed from: d  reason: collision with root package name */
    public String f61776d;

    /* renamed from: e  reason: collision with root package name */
    public String f61777e;

    /* renamed from: f  reason: collision with root package name */
    public String f61778f;

    /* renamed from: g  reason: collision with root package name */
    public String f61779g;

    /* renamed from: h  reason: collision with root package name */
    public volatile long f61780h;

    public a() {
    }

    public JSONObject a() {
        JSONObject jSONObject = new JSONObject();
        try {
            jSONObject.put("mDownloadId", this.a);
            jSONObject.put("mAdId", this.f61774b);
            jSONObject.put("mExtValue", this.f61775c);
            jSONObject.put("mPackageName", this.f61776d);
            jSONObject.put("mAppName", this.f61777e);
            jSONObject.put("mLogExtra", this.f61778f);
            jSONObject.put("mFileName", this.f61779g);
            jSONObject.put("mTimeStamp", this.f61780h);
        } catch (JSONException e2) {
            e2.printStackTrace();
        }
        return jSONObject;
    }

    public a(long j2, long j3, long j4, String str, String str2, String str3, String str4) {
        this.a = j2;
        this.f61774b = j3;
        this.f61775c = j4;
        this.f61776d = str;
        this.f61777e = str2;
        this.f61778f = str3;
        this.f61779g = str4;
    }

    public static a a(JSONObject jSONObject) {
        if (jSONObject == null) {
            return null;
        }
        a aVar = new a();
        try {
            aVar.a = l.a(jSONObject, "mDownloadId");
            aVar.f61774b = l.a(jSONObject, "mAdId");
            aVar.f61775c = l.a(jSONObject, "mExtValue");
            aVar.f61776d = jSONObject.optString("mPackageName");
            aVar.f61777e = jSONObject.optString("mAppName");
            aVar.f61778f = jSONObject.optString("mLogExtra");
            aVar.f61779g = jSONObject.optString("mFileName");
            aVar.f61780h = l.a(jSONObject, "mTimeStamp");
            return aVar;
        } catch (Exception e2) {
            e2.printStackTrace();
            return null;
        }
    }
}
