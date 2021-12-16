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
/* loaded from: classes3.dex */
public class a {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public final String a;

    /* renamed from: b  reason: collision with root package name */
    public final BusinessType f60418b;

    /* renamed from: c  reason: collision with root package name */
    public final SubBusinessType f60419c;

    /* renamed from: d  reason: collision with root package name */
    public final String f60420d;

    /* renamed from: e  reason: collision with root package name */
    public final b f60421e;

    /* renamed from: f  reason: collision with root package name */
    public final JSONObject f60422f;

    /* renamed from: g  reason: collision with root package name */
    public final JSONObject f60423g;

    /* renamed from: h  reason: collision with root package name */
    public final String f60424h;

    /* renamed from: com.kwai.adclient.kscommerciallogger.model.a$1  reason: invalid class name */
    /* loaded from: classes3.dex */
    public static /* synthetic */ class AnonymousClass1 {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
    }

    /* renamed from: com.kwai.adclient.kscommerciallogger.model.a$a  reason: collision with other inner class name */
    /* loaded from: classes3.dex */
    public static class C2129a {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final String a;

        /* renamed from: b  reason: collision with root package name */
        public BusinessType f60425b;

        /* renamed from: c  reason: collision with root package name */
        public SubBusinessType f60426c;

        /* renamed from: d  reason: collision with root package name */
        public String f60427d;

        /* renamed from: e  reason: collision with root package name */
        public b f60428e;

        /* renamed from: f  reason: collision with root package name */
        public JSONObject f60429f;

        /* renamed from: g  reason: collision with root package name */
        public JSONObject f60430g;

        /* renamed from: h  reason: collision with root package name */
        public String f60431h;

        public C2129a(@NonNull String str) {
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

        public static C2129a a() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            return (interceptable == null || (invokeV = interceptable.invokeV(65537, null)) == null) ? new C2129a("ad_client_error_log") : (C2129a) invokeV.objValue;
        }

        public static C2129a b() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            return (interceptable == null || (invokeV = interceptable.invokeV(InputDeviceCompat.SOURCE_TRACKBALL, null)) == null) ? new C2129a("ad_client_apm_log") : (C2129a) invokeV.objValue;
        }

        public C2129a a(BusinessType businessType) {
            InterceptResult invokeL;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeL = interceptable.invokeL(1048576, this, businessType)) == null) {
                this.f60425b = businessType;
                return this;
            }
            return (C2129a) invokeL.objValue;
        }

        public C2129a a(@NonNull String str) {
            InterceptResult invokeL;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeL = interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, str)) == null) {
                this.f60427d = str;
                return this;
            }
            return (C2129a) invokeL.objValue;
        }

        public C2129a a(JSONObject jSONObject) {
            InterceptResult invokeL;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeL = interceptable.invokeL(Constants.METHOD_SEND_USER_MSG, this, jSONObject)) == null) {
                this.f60429f = jSONObject;
                return this;
            }
            return (C2129a) invokeL.objValue;
        }

        public C2129a b(@NonNull String str) {
            InterceptResult invokeL;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeL = interceptable.invokeL(1048579, this, str)) == null) {
                this.f60431h = str;
                return this;
            }
            return (C2129a) invokeL.objValue;
        }

        public a c() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeV = interceptable.invokeV(1048580, this)) == null) {
                if (com.kwai.adclient.kscommerciallogger.a.a().c() && (TextUtils.isEmpty(this.a) || TextUtils.isEmpty(this.f60427d) || TextUtils.isEmpty(this.f60431h))) {
                    throw new IllegalArgumentException("param is error, please check it");
                }
                if (com.kwai.adclient.kscommerciallogger.a.a().b() != null) {
                    this.f60430g = com.kwai.adclient.kscommerciallogger.a.a().b();
                }
                return new a(this, null);
            }
            return (a) invokeV.objValue;
        }
    }

    public a(C2129a c2129a) {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {c2129a};
            interceptable.invokeUnInit(65536, newInitContext);
            int i2 = newInitContext.flag;
            if ((i2 & 1) != 0) {
                int i3 = i2 & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
        this.a = c2129a.a;
        this.f60418b = c2129a.f60425b;
        this.f60419c = c2129a.f60426c;
        this.f60420d = c2129a.f60427d;
        this.f60421e = c2129a.f60428e;
        this.f60422f = c2129a.f60429f;
        this.f60423g = c2129a.f60430g;
        this.f60424h = c2129a.f60431h;
    }

    public /* synthetic */ a(C2129a c2129a, AnonymousClass1 anonymousClass1) {
        this(c2129a);
    }

    public String a() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) ? this.a : (String) invokeV.objValue;
    }

    public BusinessType b() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this)) == null) ? this.f60418b : (BusinessType) invokeV.objValue;
    }

    public SubBusinessType c() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this)) == null) ? this.f60419c : (SubBusinessType) invokeV.objValue;
    }

    public String d() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048579, this)) == null) ? this.f60420d : (String) invokeV.objValue;
    }

    public b e() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048580, this)) == null) ? this.f60421e : (b) invokeV.objValue;
    }

    public JSONObject f() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048581, this)) == null) ? this.f60422f : (JSONObject) invokeV.objValue;
    }

    public JSONObject g() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048582, this)) == null) ? this.f60423g : (JSONObject) invokeV.objValue;
    }

    public String h() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048583, this)) == null) ? this.f60424h : (String) invokeV.objValue;
    }

    public String toString() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(InputDeviceCompat.SOURCE_TOUCHPAD, this)) == null) {
            JSONObject jSONObject = new JSONObject();
            try {
                if (this.f60418b != null) {
                    jSONObject.put("biz", this.f60418b.value);
                }
                if (this.f60419c != null) {
                    jSONObject.put("sub_biz", this.f60419c.value);
                }
                jSONObject.put("tag", this.f60420d);
                if (this.f60421e != null) {
                    jSONObject.put("type", this.f60421e.a());
                }
                if (this.f60422f != null) {
                    jSONObject.put("msg", this.f60422f);
                }
                if (this.f60423g != null) {
                    jSONObject.put("extra_param", this.f60423g);
                }
                jSONObject.put("event_id", this.f60424h);
            } catch (JSONException e2) {
                e2.printStackTrace();
            }
            return jSONObject.toString();
        }
        return (String) invokeV.objValue;
    }
}
