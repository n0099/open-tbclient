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
import org.json.JSONException;
import org.json.JSONObject;
/* loaded from: classes8.dex */
public class a {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public final String a;

    /* renamed from: b  reason: collision with root package name */
    public final BusinessType f56690b;

    /* renamed from: c  reason: collision with root package name */
    public final SubBusinessType f56691c;

    /* renamed from: d  reason: collision with root package name */
    public final String f56692d;

    /* renamed from: e  reason: collision with root package name */
    public final b f56693e;

    /* renamed from: f  reason: collision with root package name */
    public final JSONObject f56694f;

    /* renamed from: g  reason: collision with root package name */
    public final JSONObject f56695g;

    /* renamed from: h  reason: collision with root package name */
    public final String f56696h;

    /* renamed from: com.kwai.adclient.kscommerciallogger.model.a$1  reason: invalid class name */
    /* loaded from: classes8.dex */
    public static /* synthetic */ class AnonymousClass1 {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
    }

    /* renamed from: com.kwai.adclient.kscommerciallogger.model.a$a  reason: collision with other inner class name */
    /* loaded from: classes8.dex */
    public static class C2148a {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final String a;

        /* renamed from: b  reason: collision with root package name */
        public BusinessType f56697b;

        /* renamed from: c  reason: collision with root package name */
        public SubBusinessType f56698c;

        /* renamed from: d  reason: collision with root package name */
        public String f56699d;

        /* renamed from: e  reason: collision with root package name */
        public b f56700e;

        /* renamed from: f  reason: collision with root package name */
        public JSONObject f56701f;

        /* renamed from: g  reason: collision with root package name */
        public JSONObject f56702g;

        /* renamed from: h  reason: collision with root package name */
        public String f56703h;

        public C2148a(@NonNull String str) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {str};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = str;
        }

        public static C2148a a() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            return (interceptable == null || (invokeV = interceptable.invokeV(65537, null)) == null) ? new C2148a("ad_client_error_log") : (C2148a) invokeV.objValue;
        }

        public static C2148a b() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            return (interceptable == null || (invokeV = interceptable.invokeV(InputDeviceCompat.SOURCE_TRACKBALL, null)) == null) ? new C2148a("ad_client_apm_log") : (C2148a) invokeV.objValue;
        }

        public C2148a a(BusinessType businessType) {
            InterceptResult invokeL;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeL = interceptable.invokeL(1048576, this, businessType)) == null) {
                this.f56697b = businessType;
                return this;
            }
            return (C2148a) invokeL.objValue;
        }

        public C2148a a(@NonNull String str) {
            InterceptResult invokeL;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeL = interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, str)) == null) {
                this.f56699d = str;
                return this;
            }
            return (C2148a) invokeL.objValue;
        }

        public C2148a a(JSONObject jSONObject) {
            InterceptResult invokeL;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeL = interceptable.invokeL(Constants.METHOD_SEND_USER_MSG, this, jSONObject)) == null) {
                this.f56701f = jSONObject;
                return this;
            }
            return (C2148a) invokeL.objValue;
        }

        public C2148a b(@NonNull String str) {
            InterceptResult invokeL;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeL = interceptable.invokeL(1048579, this, str)) == null) {
                this.f56703h = str;
                return this;
            }
            return (C2148a) invokeL.objValue;
        }

        public a c() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeV = interceptable.invokeV(1048580, this)) == null) {
                if (com.kwai.adclient.kscommerciallogger.a.a().c() && (TextUtils.isEmpty(this.a) || TextUtils.isEmpty(this.f56699d) || TextUtils.isEmpty(this.f56703h))) {
                    throw new IllegalArgumentException("param is error, please check it");
                }
                if (com.kwai.adclient.kscommerciallogger.a.a().b() != null) {
                    this.f56702g = com.kwai.adclient.kscommerciallogger.a.a().b();
                }
                return new a(this, null);
            }
            return (a) invokeV.objValue;
        }
    }

    public a(C2148a c2148a) {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {c2148a};
            interceptable.invokeUnInit(65536, newInitContext);
            int i2 = newInitContext.flag;
            if ((i2 & 1) != 0) {
                int i3 = i2 & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
        this.a = c2148a.a;
        this.f56690b = c2148a.f56697b;
        this.f56691c = c2148a.f56698c;
        this.f56692d = c2148a.f56699d;
        this.f56693e = c2148a.f56700e;
        this.f56694f = c2148a.f56701f;
        this.f56695g = c2148a.f56702g;
        this.f56696h = c2148a.f56703h;
    }

    public /* synthetic */ a(C2148a c2148a, AnonymousClass1 anonymousClass1) {
        this(c2148a);
    }

    public String a() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) ? this.a : (String) invokeV.objValue;
    }

    public BusinessType b() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this)) == null) ? this.f56690b : (BusinessType) invokeV.objValue;
    }

    public SubBusinessType c() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this)) == null) ? this.f56691c : (SubBusinessType) invokeV.objValue;
    }

    public String d() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048579, this)) == null) ? this.f56692d : (String) invokeV.objValue;
    }

    public b e() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048580, this)) == null) ? this.f56693e : (b) invokeV.objValue;
    }

    public JSONObject f() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048581, this)) == null) ? this.f56694f : (JSONObject) invokeV.objValue;
    }

    public JSONObject g() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048582, this)) == null) ? this.f56695g : (JSONObject) invokeV.objValue;
    }

    public String h() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048583, this)) == null) ? this.f56696h : (String) invokeV.objValue;
    }

    public String toString() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(InputDeviceCompat.SOURCE_TOUCHPAD, this)) == null) {
            JSONObject jSONObject = new JSONObject();
            try {
                if (this.f56690b != null) {
                    jSONObject.put("biz", this.f56690b.value);
                }
                if (this.f56691c != null) {
                    jSONObject.put("sub_biz", this.f56691c.value);
                }
                jSONObject.put("tag", this.f56692d);
                if (this.f56693e != null) {
                    jSONObject.put("type", this.f56693e.a());
                }
                if (this.f56694f != null) {
                    jSONObject.put("msg", this.f56694f);
                }
                if (this.f56695g != null) {
                    jSONObject.put("extra_param", this.f56695g);
                }
                jSONObject.put("event_id", this.f56696h);
            } catch (JSONException e2) {
                e2.printStackTrace();
            }
            return jSONObject.toString();
        }
        return (String) invokeV.objValue;
    }
}
