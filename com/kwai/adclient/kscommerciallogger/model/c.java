package com.kwai.adclient.kscommerciallogger.model;

import android.text.TextUtils;
import androidx.annotation.NonNull;
import androidx.core.view.InputDeviceCompat;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import com.kwad.components.offline.api.core.api.ILoggerReporter;
import com.qq.e.comm.constants.Constants;
import org.json.JSONException;
import org.json.JSONObject;
/* loaded from: classes5.dex */
public final class c {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public final String a;
    public final BusinessType b;
    public final SubBusinessType c;
    public final String d;
    public final d e;
    public final JSONObject f;
    public final JSONObject g;
    public final String h;

    /* loaded from: classes5.dex */
    public static class a {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final String a;
        public BusinessType b;
        public SubBusinessType c;
        public String d;
        public d e;
        public JSONObject f;
        public JSONObject g;
        public String h;

        public a(@NonNull String str) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {str};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = str;
        }

        public static a a() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            return (interceptable == null || (invokeV = interceptable.invokeV(65537, null)) == null) ? new a(ILoggerReporter.Category.ERROR_LOG) : (a) invokeV.objValue;
        }

        public static a b() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            return (interceptable == null || (invokeV = interceptable.invokeV(InputDeviceCompat.SOURCE_TRACKBALL, null)) == null) ? new a(ILoggerReporter.Category.APM_LOG) : (a) invokeV.objValue;
        }

        public final a a(BusinessType businessType) {
            InterceptResult invokeL;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeL = interceptable.invokeL(1048576, this, businessType)) == null) {
                this.b = businessType;
                return this;
            }
            return (a) invokeL.objValue;
        }

        public final a a(d dVar) {
            InterceptResult invokeL;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeL = interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, dVar)) == null) {
                this.e = dVar;
                return this;
            }
            return (a) invokeL.objValue;
        }

        public final a a(@NonNull String str) {
            InterceptResult invokeL;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeL = interceptable.invokeL(Constants.METHOD_SEND_USER_MSG, this, str)) == null) {
                this.d = str;
                return this;
            }
            return (a) invokeL.objValue;
        }

        public final a a(JSONObject jSONObject) {
            InterceptResult invokeL;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeL = interceptable.invokeL(1048579, this, jSONObject)) == null) {
                this.f = jSONObject;
                return this;
            }
            return (a) invokeL.objValue;
        }

        public final a b(@NonNull String str) {
            InterceptResult invokeL;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeL = interceptable.invokeL(1048580, this, str)) == null) {
                this.h = str;
                return this;
            }
            return (a) invokeL.objValue;
        }

        public final c c() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeV = interceptable.invokeV(1048581, this)) == null) {
                if (com.kwai.adclient.kscommerciallogger.a.a().c()) {
                    if (TextUtils.isEmpty(this.a) || TextUtils.isEmpty(this.d) || TextUtils.isEmpty(this.h)) {
                        throw new IllegalArgumentException("param is error, please check it");
                    }
                    if (com.kwai.adclient.kscommerciallogger.a.a().d() && !com.kwai.adclient.kscommerciallogger.b.a(this.h)) {
                        throw new IllegalArgumentException("event_id format error, please check it");
                    }
                } else if (TextUtils.isEmpty(this.a) || TextUtils.isEmpty(this.d) || TextUtils.isEmpty(this.h)) {
                    return null;
                } else {
                    if (com.kwai.adclient.kscommerciallogger.a.a().d() && !com.kwai.adclient.kscommerciallogger.b.a(this.h)) {
                        return null;
                    }
                }
                if (com.kwai.adclient.kscommerciallogger.a.a().b() != null) {
                    this.g = com.kwai.adclient.kscommerciallogger.a.a().b();
                }
                return new c(this, (byte) 0);
            }
            return (c) invokeV.objValue;
        }
    }

    public c(a aVar) {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {aVar};
            interceptable.invokeUnInit(65536, newInitContext);
            int i = newInitContext.flag;
            if ((i & 1) != 0) {
                int i2 = i & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
        this.a = aVar.a;
        this.b = aVar.b;
        this.c = aVar.c;
        this.d = aVar.d;
        this.e = aVar.e;
        this.f = aVar.f;
        this.g = aVar.g;
        this.h = aVar.h;
    }

    public /* synthetic */ c(a aVar, byte b) {
        this(aVar);
    }

    public final String a() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) ? this.a : (String) invokeV.objValue;
    }

    public final BusinessType b() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this)) == null) ? this.b : (BusinessType) invokeV.objValue;
    }

    public final SubBusinessType c() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this)) == null) ? this.c : (SubBusinessType) invokeV.objValue;
    }

    public final String d() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048579, this)) == null) ? this.d : (String) invokeV.objValue;
    }

    public final d e() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048580, this)) == null) ? this.e : (d) invokeV.objValue;
    }

    public final JSONObject f() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048581, this)) == null) ? this.f : (JSONObject) invokeV.objValue;
    }

    public final JSONObject g() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048582, this)) == null) ? this.g : (JSONObject) invokeV.objValue;
    }

    public final String h() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048583, this)) == null) ? this.h : (String) invokeV.objValue;
    }

    public final String toString() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(InputDeviceCompat.SOURCE_TOUCHPAD, this)) == null) {
            JSONObject jSONObject = new JSONObject();
            try {
                if (this.b != null) {
                    jSONObject.put(Constants.KEYS.BIZ, this.b.value);
                }
                if (this.c != null) {
                    jSONObject.put("sub_biz", this.c.value);
                }
                jSONObject.put("tag", this.d);
                if (this.e != null) {
                    jSONObject.put("type", this.e.a());
                }
                if (this.f != null) {
                    jSONObject.put("msg", this.f);
                }
                if (this.g != null) {
                    jSONObject.put("extra_param", this.g);
                }
                jSONObject.put("event_id", this.h);
            } catch (JSONException e) {
                e.printStackTrace();
            }
            return jSONObject.toString();
        }
        return (String) invokeV.objValue;
    }
}
