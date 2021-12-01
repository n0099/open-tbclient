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
/* loaded from: classes2.dex */
public class a {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public final String a;

    /* renamed from: b  reason: collision with root package name */
    public final BusinessType f59837b;

    /* renamed from: c  reason: collision with root package name */
    public final SubBusinessType f59838c;

    /* renamed from: d  reason: collision with root package name */
    public final String f59839d;

    /* renamed from: e  reason: collision with root package name */
    public final b f59840e;

    /* renamed from: f  reason: collision with root package name */
    public final JSONObject f59841f;

    /* renamed from: g  reason: collision with root package name */
    public final JSONObject f59842g;

    /* renamed from: h  reason: collision with root package name */
    public final String f59843h;

    /* renamed from: com.kwai.adclient.kscommerciallogger.model.a$1  reason: invalid class name */
    /* loaded from: classes2.dex */
    public static /* synthetic */ class AnonymousClass1 {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
    }

    /* renamed from: com.kwai.adclient.kscommerciallogger.model.a$a  reason: collision with other inner class name */
    /* loaded from: classes2.dex */
    public static class C2068a {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final String a;

        /* renamed from: b  reason: collision with root package name */
        public BusinessType f59844b;

        /* renamed from: c  reason: collision with root package name */
        public SubBusinessType f59845c;

        /* renamed from: d  reason: collision with root package name */
        public String f59846d;

        /* renamed from: e  reason: collision with root package name */
        public b f59847e;

        /* renamed from: f  reason: collision with root package name */
        public JSONObject f59848f;

        /* renamed from: g  reason: collision with root package name */
        public JSONObject f59849g;

        /* renamed from: h  reason: collision with root package name */
        public String f59850h;

        public C2068a(@NonNull String str) {
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

        public static C2068a a() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            return (interceptable == null || (invokeV = interceptable.invokeV(65537, null)) == null) ? new C2068a("ad_client_error_log") : (C2068a) invokeV.objValue;
        }

        public static C2068a b() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            return (interceptable == null || (invokeV = interceptable.invokeV(InputDeviceCompat.SOURCE_TRACKBALL, null)) == null) ? new C2068a("ad_client_apm_log") : (C2068a) invokeV.objValue;
        }

        public C2068a a(BusinessType businessType) {
            InterceptResult invokeL;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeL = interceptable.invokeL(1048576, this, businessType)) == null) {
                this.f59844b = businessType;
                return this;
            }
            return (C2068a) invokeL.objValue;
        }

        public C2068a a(@NonNull String str) {
            InterceptResult invokeL;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeL = interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, str)) == null) {
                this.f59846d = str;
                return this;
            }
            return (C2068a) invokeL.objValue;
        }

        public C2068a a(JSONObject jSONObject) {
            InterceptResult invokeL;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeL = interceptable.invokeL(Constants.METHOD_SEND_USER_MSG, this, jSONObject)) == null) {
                this.f59848f = jSONObject;
                return this;
            }
            return (C2068a) invokeL.objValue;
        }

        public C2068a b(@NonNull String str) {
            InterceptResult invokeL;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeL = interceptable.invokeL(1048579, this, str)) == null) {
                this.f59850h = str;
                return this;
            }
            return (C2068a) invokeL.objValue;
        }

        public a c() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeV = interceptable.invokeV(1048580, this)) == null) {
                if (com.kwai.adclient.kscommerciallogger.a.a().c() && (TextUtils.isEmpty(this.a) || TextUtils.isEmpty(this.f59846d) || TextUtils.isEmpty(this.f59850h))) {
                    throw new IllegalArgumentException("param is error, please check it");
                }
                if (com.kwai.adclient.kscommerciallogger.a.a().b() != null) {
                    this.f59849g = com.kwai.adclient.kscommerciallogger.a.a().b();
                }
                return new a(this, null);
            }
            return (a) invokeV.objValue;
        }
    }

    public a(C2068a c2068a) {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {c2068a};
            interceptable.invokeUnInit(65536, newInitContext);
            int i2 = newInitContext.flag;
            if ((i2 & 1) != 0) {
                int i3 = i2 & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
        this.a = c2068a.a;
        this.f59837b = c2068a.f59844b;
        this.f59838c = c2068a.f59845c;
        this.f59839d = c2068a.f59846d;
        this.f59840e = c2068a.f59847e;
        this.f59841f = c2068a.f59848f;
        this.f59842g = c2068a.f59849g;
        this.f59843h = c2068a.f59850h;
    }

    public /* synthetic */ a(C2068a c2068a, AnonymousClass1 anonymousClass1) {
        this(c2068a);
    }

    public String a() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) ? this.a : (String) invokeV.objValue;
    }

    public BusinessType b() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this)) == null) ? this.f59837b : (BusinessType) invokeV.objValue;
    }

    public SubBusinessType c() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this)) == null) ? this.f59838c : (SubBusinessType) invokeV.objValue;
    }

    public String d() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048579, this)) == null) ? this.f59839d : (String) invokeV.objValue;
    }

    public b e() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048580, this)) == null) ? this.f59840e : (b) invokeV.objValue;
    }

    public JSONObject f() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048581, this)) == null) ? this.f59841f : (JSONObject) invokeV.objValue;
    }

    public JSONObject g() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048582, this)) == null) ? this.f59842g : (JSONObject) invokeV.objValue;
    }

    public String h() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048583, this)) == null) ? this.f59843h : (String) invokeV.objValue;
    }

    public String toString() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(InputDeviceCompat.SOURCE_TOUCHPAD, this)) == null) {
            JSONObject jSONObject = new JSONObject();
            try {
                if (this.f59837b != null) {
                    jSONObject.put("biz", this.f59837b.value);
                }
                if (this.f59838c != null) {
                    jSONObject.put("sub_biz", this.f59838c.value);
                }
                jSONObject.put("tag", this.f59839d);
                if (this.f59840e != null) {
                    jSONObject.put("type", this.f59840e.a());
                }
                if (this.f59841f != null) {
                    jSONObject.put("msg", this.f59841f);
                }
                if (this.f59842g != null) {
                    jSONObject.put("extra_param", this.f59842g);
                }
                jSONObject.put("event_id", this.f59843h);
            } catch (JSONException e2) {
                e2.printStackTrace();
            }
            return jSONObject.toString();
        }
        return (String) invokeV.objValue;
    }
}
