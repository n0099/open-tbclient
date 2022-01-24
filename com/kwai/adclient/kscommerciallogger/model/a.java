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
    public final BusinessType f58173b;

    /* renamed from: c  reason: collision with root package name */
    public final SubBusinessType f58174c;

    /* renamed from: d  reason: collision with root package name */
    public final String f58175d;

    /* renamed from: e  reason: collision with root package name */
    public final b f58176e;

    /* renamed from: f  reason: collision with root package name */
    public final JSONObject f58177f;

    /* renamed from: g  reason: collision with root package name */
    public final JSONObject f58178g;

    /* renamed from: h  reason: collision with root package name */
    public final String f58179h;

    /* renamed from: com.kwai.adclient.kscommerciallogger.model.a$1  reason: invalid class name */
    /* loaded from: classes3.dex */
    public static /* synthetic */ class AnonymousClass1 {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
    }

    /* renamed from: com.kwai.adclient.kscommerciallogger.model.a$a  reason: collision with other inner class name */
    /* loaded from: classes3.dex */
    public static class C2159a {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final String a;

        /* renamed from: b  reason: collision with root package name */
        public BusinessType f58180b;

        /* renamed from: c  reason: collision with root package name */
        public SubBusinessType f58181c;

        /* renamed from: d  reason: collision with root package name */
        public String f58182d;

        /* renamed from: e  reason: collision with root package name */
        public b f58183e;

        /* renamed from: f  reason: collision with root package name */
        public JSONObject f58184f;

        /* renamed from: g  reason: collision with root package name */
        public JSONObject f58185g;

        /* renamed from: h  reason: collision with root package name */
        public String f58186h;

        public C2159a(@NonNull String str) {
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

        public static C2159a a() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            return (interceptable == null || (invokeV = interceptable.invokeV(65537, null)) == null) ? new C2159a("ad_client_error_log") : (C2159a) invokeV.objValue;
        }

        public static C2159a b() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            return (interceptable == null || (invokeV = interceptable.invokeV(InputDeviceCompat.SOURCE_TRACKBALL, null)) == null) ? new C2159a("ad_client_apm_log") : (C2159a) invokeV.objValue;
        }

        public C2159a a(BusinessType businessType) {
            InterceptResult invokeL;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeL = interceptable.invokeL(1048576, this, businessType)) == null) {
                this.f58180b = businessType;
                return this;
            }
            return (C2159a) invokeL.objValue;
        }

        public C2159a a(@NonNull String str) {
            InterceptResult invokeL;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeL = interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, str)) == null) {
                this.f58182d = str;
                return this;
            }
            return (C2159a) invokeL.objValue;
        }

        public C2159a a(JSONObject jSONObject) {
            InterceptResult invokeL;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeL = interceptable.invokeL(Constants.METHOD_SEND_USER_MSG, this, jSONObject)) == null) {
                this.f58184f = jSONObject;
                return this;
            }
            return (C2159a) invokeL.objValue;
        }

        public C2159a b(@NonNull String str) {
            InterceptResult invokeL;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeL = interceptable.invokeL(1048579, this, str)) == null) {
                this.f58186h = str;
                return this;
            }
            return (C2159a) invokeL.objValue;
        }

        public a c() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeV = interceptable.invokeV(1048580, this)) == null) {
                if (com.kwai.adclient.kscommerciallogger.a.a().c() && (TextUtils.isEmpty(this.a) || TextUtils.isEmpty(this.f58182d) || TextUtils.isEmpty(this.f58186h))) {
                    throw new IllegalArgumentException("param is error, please check it");
                }
                if (com.kwai.adclient.kscommerciallogger.a.a().b() != null) {
                    this.f58185g = com.kwai.adclient.kscommerciallogger.a.a().b();
                }
                return new a(this, null);
            }
            return (a) invokeV.objValue;
        }
    }

    public a(C2159a c2159a) {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {c2159a};
            interceptable.invokeUnInit(65536, newInitContext);
            int i2 = newInitContext.flag;
            if ((i2 & 1) != 0) {
                int i3 = i2 & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
        this.a = c2159a.a;
        this.f58173b = c2159a.f58180b;
        this.f58174c = c2159a.f58181c;
        this.f58175d = c2159a.f58182d;
        this.f58176e = c2159a.f58183e;
        this.f58177f = c2159a.f58184f;
        this.f58178g = c2159a.f58185g;
        this.f58179h = c2159a.f58186h;
    }

    public /* synthetic */ a(C2159a c2159a, AnonymousClass1 anonymousClass1) {
        this(c2159a);
    }

    public String a() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) ? this.a : (String) invokeV.objValue;
    }

    public BusinessType b() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this)) == null) ? this.f58173b : (BusinessType) invokeV.objValue;
    }

    public SubBusinessType c() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this)) == null) ? this.f58174c : (SubBusinessType) invokeV.objValue;
    }

    public String d() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048579, this)) == null) ? this.f58175d : (String) invokeV.objValue;
    }

    public b e() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048580, this)) == null) ? this.f58176e : (b) invokeV.objValue;
    }

    public JSONObject f() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048581, this)) == null) ? this.f58177f : (JSONObject) invokeV.objValue;
    }

    public JSONObject g() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048582, this)) == null) ? this.f58178g : (JSONObject) invokeV.objValue;
    }

    public String h() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048583, this)) == null) ? this.f58179h : (String) invokeV.objValue;
    }

    public String toString() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(InputDeviceCompat.SOURCE_TOUCHPAD, this)) == null) {
            JSONObject jSONObject = new JSONObject();
            try {
                if (this.f58173b != null) {
                    jSONObject.put("biz", this.f58173b.value);
                }
                if (this.f58174c != null) {
                    jSONObject.put("sub_biz", this.f58174c.value);
                }
                jSONObject.put("tag", this.f58175d);
                if (this.f58176e != null) {
                    jSONObject.put("type", this.f58176e.a());
                }
                if (this.f58177f != null) {
                    jSONObject.put("msg", this.f58177f);
                }
                if (this.f58178g != null) {
                    jSONObject.put("extra_param", this.f58178g);
                }
                jSONObject.put("event_id", this.f58179h);
            } catch (JSONException e2) {
                e2.printStackTrace();
            }
            return jSONObject.toString();
        }
        return (String) invokeV.objValue;
    }
}
