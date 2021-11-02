package com.ss.android.downloadlib.addownload.b;

import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import com.ss.android.downloadlib.g.l;
import org.json.JSONException;
import org.json.JSONObject;
/* loaded from: classes2.dex */
public class a {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    /* renamed from: a  reason: collision with root package name */
    public long f68479a;

    /* renamed from: b  reason: collision with root package name */
    public long f68480b;

    /* renamed from: c  reason: collision with root package name */
    public long f68481c;

    /* renamed from: d  reason: collision with root package name */
    public String f68482d;

    /* renamed from: e  reason: collision with root package name */
    public String f68483e;

    /* renamed from: f  reason: collision with root package name */
    public String f68484f;

    /* renamed from: g  reason: collision with root package name */
    public String f68485g;

    /* renamed from: h  reason: collision with root package name */
    public volatile long f68486h;

    public a() {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            interceptable.invokeUnInit(65536, newInitContext);
            int i2 = newInitContext.flag;
            if ((i2 & 1) != 0) {
                int i3 = i2 & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
            }
        }
    }

    public JSONObject a() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) {
            JSONObject jSONObject = new JSONObject();
            try {
                jSONObject.put("mDownloadId", this.f68479a);
                jSONObject.put("mAdId", this.f68480b);
                jSONObject.put("mExtValue", this.f68481c);
                jSONObject.put("mPackageName", this.f68482d);
                jSONObject.put("mAppName", this.f68483e);
                jSONObject.put("mLogExtra", this.f68484f);
                jSONObject.put("mFileName", this.f68485g);
                jSONObject.put("mTimeStamp", this.f68486h);
            } catch (JSONException e2) {
                e2.printStackTrace();
            }
            return jSONObject;
        }
        return (JSONObject) invokeV.objValue;
    }

    public a(long j, long j2, long j3, String str, String str2, String str3, String str4) {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {Long.valueOf(j), Long.valueOf(j2), Long.valueOf(j3), str, str2, str3, str4};
            interceptable.invokeUnInit(65537, newInitContext);
            int i2 = newInitContext.flag;
            if ((i2 & 1) != 0) {
                int i3 = i2 & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65537, newInitContext);
                return;
            }
        }
        this.f68479a = j;
        this.f68480b = j2;
        this.f68481c = j3;
        this.f68482d = str;
        this.f68483e = str2;
        this.f68484f = str3;
        this.f68485g = str4;
    }

    public static a a(JSONObject jSONObject) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65538, null, jSONObject)) == null) {
            if (jSONObject == null) {
                return null;
            }
            a aVar = new a();
            try {
                aVar.f68479a = l.a(jSONObject, "mDownloadId");
                aVar.f68480b = l.a(jSONObject, "mAdId");
                aVar.f68481c = l.a(jSONObject, "mExtValue");
                aVar.f68482d = jSONObject.optString("mPackageName");
                aVar.f68483e = jSONObject.optString("mAppName");
                aVar.f68484f = jSONObject.optString("mLogExtra");
                aVar.f68485g = jSONObject.optString("mFileName");
                aVar.f68486h = l.a(jSONObject, "mTimeStamp");
                return aVar;
            } catch (Exception e2) {
                e2.printStackTrace();
                return null;
            }
        }
        return (a) invokeL.objValue;
    }
}
