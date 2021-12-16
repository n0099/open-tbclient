package com.ss.android.download.api.model;

import com.baidu.android.imsdk.internal.Constants;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
/* loaded from: classes3.dex */
public class a {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public String a;

    /* renamed from: b  reason: collision with root package name */
    public String f61652b;

    /* renamed from: c  reason: collision with root package name */
    public String f61653c;

    /* renamed from: d  reason: collision with root package name */
    public String f61654d;

    /* renamed from: e  reason: collision with root package name */
    public String f61655e;

    /* renamed from: com.ss.android.download.api.model.a$a  reason: collision with other inner class name */
    /* loaded from: classes3.dex */
    public static class C2154a {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public String a;

        /* renamed from: b  reason: collision with root package name */
        public String f61656b;

        /* renamed from: c  reason: collision with root package name */
        public String f61657c;

        /* renamed from: d  reason: collision with root package name */
        public String f61658d;

        /* renamed from: e  reason: collision with root package name */
        public String f61659e;

        public C2154a() {
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

        public C2154a a(String str) {
            InterceptResult invokeL;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeL = interceptable.invokeL(1048576, this, str)) == null) {
                this.a = str;
                return this;
            }
            return (C2154a) invokeL.objValue;
        }

        public C2154a b(String str) {
            InterceptResult invokeL;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeL = interceptable.invokeL(Constants.METHOD_SEND_USER_MSG, this, str)) == null) {
                this.f61656b = str;
                return this;
            }
            return (C2154a) invokeL.objValue;
        }

        public C2154a c(String str) {
            InterceptResult invokeL;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeL = interceptable.invokeL(1048579, this, str)) == null) {
                this.f61658d = str;
                return this;
            }
            return (C2154a) invokeL.objValue;
        }

        public C2154a d(String str) {
            InterceptResult invokeL;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeL = interceptable.invokeL(1048580, this, str)) == null) {
                this.f61659e = str;
                return this;
            }
            return (C2154a) invokeL.objValue;
        }

        public a a() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            return (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this)) == null) ? new a(this) : (a) invokeV.objValue;
        }
    }

    public a(C2154a c2154a) {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {c2154a};
            interceptable.invokeUnInit(65536, newInitContext);
            int i2 = newInitContext.flag;
            if ((i2 & 1) != 0) {
                int i3 = i2 & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
        this.f61652b = "";
        this.a = c2154a.a;
        this.f61652b = c2154a.f61656b;
        this.f61653c = c2154a.f61657c;
        this.f61654d = c2154a.f61658d;
        this.f61655e = c2154a.f61659e;
    }
}
