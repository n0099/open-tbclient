package com.ss.android.downloadlib.addownload.b;

import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import com.ss.android.downloadlib.g.l;
import org.json.JSONException;
import org.json.JSONObject;
/* loaded from: classes3.dex */
public class a {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
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
        return (JSONObject) invokeV.objValue;
    }

    public a(long j2, long j3, long j4, String str, String str2, String str3, String str4) {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {Long.valueOf(j2), Long.valueOf(j3), Long.valueOf(j4), str, str2, str3, str4};
            interceptable.invokeUnInit(65537, newInitContext);
            int i2 = newInitContext.flag;
            if ((i2 & 1) != 0) {
                int i3 = i2 & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65537, newInitContext);
                return;
            }
        }
        this.a = j2;
        this.f61774b = j3;
        this.f61775c = j4;
        this.f61776d = str;
        this.f61777e = str2;
        this.f61778f = str3;
        this.f61779g = str4;
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
        return (a) invokeL.objValue;
    }
}
