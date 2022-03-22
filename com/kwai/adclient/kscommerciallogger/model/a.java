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
import com.qq.e.comm.constants.Constants;
import org.json.JSONException;
import org.json.JSONObject;
/* loaded from: classes7.dex */
public class a {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public final String a;

    /* renamed from: b  reason: collision with root package name */
    public final BusinessType f41566b;

    /* renamed from: c  reason: collision with root package name */
    public final SubBusinessType f41567c;

    /* renamed from: d  reason: collision with root package name */
    public final String f41568d;

    /* renamed from: e  reason: collision with root package name */
    public final b f41569e;

    /* renamed from: f  reason: collision with root package name */
    public final JSONObject f41570f;

    /* renamed from: g  reason: collision with root package name */
    public final JSONObject f41571g;

    /* renamed from: h  reason: collision with root package name */
    public final String f41572h;

    /* renamed from: com.kwai.adclient.kscommerciallogger.model.a$1  reason: invalid class name */
    /* loaded from: classes7.dex */
    public static /* synthetic */ class AnonymousClass1 {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
    }

    /* renamed from: com.kwai.adclient.kscommerciallogger.model.a$a  reason: collision with other inner class name */
    /* loaded from: classes7.dex */
    public static class C2009a {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final String a;

        /* renamed from: b  reason: collision with root package name */
        public BusinessType f41573b;

        /* renamed from: c  reason: collision with root package name */
        public SubBusinessType f41574c;

        /* renamed from: d  reason: collision with root package name */
        public String f41575d;

        /* renamed from: e  reason: collision with root package name */
        public b f41576e;

        /* renamed from: f  reason: collision with root package name */
        public JSONObject f41577f;

        /* renamed from: g  reason: collision with root package name */
        public JSONObject f41578g;

        /* renamed from: h  reason: collision with root package name */
        public String f41579h;

        public C2009a(@NonNull String str) {
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

        public static C2009a a() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            return (interceptable == null || (invokeV = interceptable.invokeV(65537, null)) == null) ? new C2009a("ad_client_error_log") : (C2009a) invokeV.objValue;
        }

        public static C2009a b() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            return (interceptable == null || (invokeV = interceptable.invokeV(InputDeviceCompat.SOURCE_TRACKBALL, null)) == null) ? new C2009a("ad_client_apm_log") : (C2009a) invokeV.objValue;
        }

        public C2009a a(BusinessType businessType) {
            InterceptResult invokeL;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeL = interceptable.invokeL(1048576, this, businessType)) == null) {
                this.f41573b = businessType;
                return this;
            }
            return (C2009a) invokeL.objValue;
        }

        public C2009a a(@NonNull String str) {
            InterceptResult invokeL;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeL = interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, str)) == null) {
                this.f41575d = str;
                return this;
            }
            return (C2009a) invokeL.objValue;
        }

        public C2009a a(JSONObject jSONObject) {
            InterceptResult invokeL;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeL = interceptable.invokeL(Constants.METHOD_SEND_USER_MSG, this, jSONObject)) == null) {
                this.f41577f = jSONObject;
                return this;
            }
            return (C2009a) invokeL.objValue;
        }

        public C2009a b(@NonNull String str) {
            InterceptResult invokeL;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeL = interceptable.invokeL(1048579, this, str)) == null) {
                this.f41579h = str;
                return this;
            }
            return (C2009a) invokeL.objValue;
        }

        public a c() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeV = interceptable.invokeV(1048580, this)) == null) {
                if (com.kwai.adclient.kscommerciallogger.a.a().c() && (TextUtils.isEmpty(this.a) || TextUtils.isEmpty(this.f41575d) || TextUtils.isEmpty(this.f41579h))) {
                    throw new IllegalArgumentException("param is error, please check it");
                }
                if (com.kwai.adclient.kscommerciallogger.a.a().b() != null) {
                    this.f41578g = com.kwai.adclient.kscommerciallogger.a.a().b();
                }
                return new a(this, null);
            }
            return (a) invokeV.objValue;
        }
    }

    public a(C2009a c2009a) {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {c2009a};
            interceptable.invokeUnInit(65536, newInitContext);
            int i = newInitContext.flag;
            if ((i & 1) != 0) {
                int i2 = i & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
        this.a = c2009a.a;
        this.f41566b = c2009a.f41573b;
        this.f41567c = c2009a.f41574c;
        this.f41568d = c2009a.f41575d;
        this.f41569e = c2009a.f41576e;
        this.f41570f = c2009a.f41577f;
        this.f41571g = c2009a.f41578g;
        this.f41572h = c2009a.f41579h;
    }

    public /* synthetic */ a(C2009a c2009a, AnonymousClass1 anonymousClass1) {
        this(c2009a);
    }

    public String a() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) ? this.a : (String) invokeV.objValue;
    }

    public BusinessType b() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this)) == null) ? this.f41566b : (BusinessType) invokeV.objValue;
    }

    public SubBusinessType c() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this)) == null) ? this.f41567c : (SubBusinessType) invokeV.objValue;
    }

    public String d() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048579, this)) == null) ? this.f41568d : (String) invokeV.objValue;
    }

    public b e() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048580, this)) == null) ? this.f41569e : (b) invokeV.objValue;
    }

    public JSONObject f() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048581, this)) == null) ? this.f41570f : (JSONObject) invokeV.objValue;
    }

    public JSONObject g() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048582, this)) == null) ? this.f41571g : (JSONObject) invokeV.objValue;
    }

    public String h() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048583, this)) == null) ? this.f41572h : (String) invokeV.objValue;
    }

    public String toString() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(InputDeviceCompat.SOURCE_TOUCHPAD, this)) == null) {
            JSONObject jSONObject = new JSONObject();
            try {
                if (this.f41566b != null) {
                    jSONObject.put(Constants.KEYS.BIZ, this.f41566b.value);
                }
                if (this.f41567c != null) {
                    jSONObject.put("sub_biz", this.f41567c.value);
                }
                jSONObject.put("tag", this.f41568d);
                if (this.f41569e != null) {
                    jSONObject.put("type", this.f41569e.a());
                }
                if (this.f41570f != null) {
                    jSONObject.put("msg", this.f41570f);
                }
                if (this.f41571g != null) {
                    jSONObject.put("extra_param", this.f41571g);
                }
                jSONObject.put("event_id", this.f41572h);
            } catch (JSONException e2) {
                e2.printStackTrace();
            }
            return jSONObject.toString();
        }
        return (String) invokeV.objValue;
    }
}
