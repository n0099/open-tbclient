package com.ss.android.downloadlib.a.b;

import com.ss.android.downloadlib.f.i;
import org.json.JSONException;
import org.json.JSONObject;
/* loaded from: classes6.dex */
public class a {

    /* renamed from: a  reason: collision with root package name */
    public long f7691a;
    public long b;
    public long c;
    public String d;
    public String e;
    public String f;
    public String g;
    public volatile long h;

    public a() {
    }

    public a(long j, long j2, long j3, String str, String str2, String str3, String str4) {
        this.f7691a = j;
        this.b = j2;
        this.c = j3;
        this.d = str;
        this.e = str2;
        this.f = str3;
        this.g = str4;
    }

    public JSONObject a() {
        JSONObject jSONObject = new JSONObject();
        try {
            jSONObject.put("mDownloadId", this.f7691a);
            jSONObject.put("mAdId", this.b);
            jSONObject.put("mExtValue", this.c);
            jSONObject.put("mPackageName", this.d);
            jSONObject.put("mAppName", this.e);
            jSONObject.put("mLogExtra", this.f);
            jSONObject.put("mFileName", this.g);
            jSONObject.put("mTimeStamp", this.h);
        } catch (JSONException e) {
            e.printStackTrace();
        }
        return jSONObject;
    }

    public static a fg(JSONObject jSONObject) {
        if (jSONObject == null) {
            return null;
        }
        a aVar = new a();
        try {
            aVar.f7691a = i.C(jSONObject, "mDownloadId");
            aVar.b = i.C(jSONObject, "mAdId");
            aVar.c = i.C(jSONObject, "mExtValue");
            aVar.d = jSONObject.optString("mPackageName");
            aVar.e = jSONObject.optString("mAppName");
            aVar.f = jSONObject.optString("mLogExtra");
            aVar.g = jSONObject.optString("mFileName");
            aVar.h = i.C(jSONObject, "mTimeStamp");
            return aVar;
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }
}
