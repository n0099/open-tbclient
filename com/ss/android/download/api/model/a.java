package com.ss.android.download.api.model;

import com.baidu.android.imsdk.internal.Constants;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
/* loaded from: classes2.dex */
public class a {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public String a;

    /* renamed from: b  reason: collision with root package name */
    public String f61071b;

    /* renamed from: c  reason: collision with root package name */
    public String f61072c;

    /* renamed from: d  reason: collision with root package name */
    public String f61073d;

    /* renamed from: e  reason: collision with root package name */
    public String f61074e;

    /* renamed from: com.ss.android.download.api.model.a$a  reason: collision with other inner class name */
    /* loaded from: classes2.dex */
    public static class C2093a {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public String a;

        /* renamed from: b  reason: collision with root package name */
        public String f61075b;

        /* renamed from: c  reason: collision with root package name */
        public String f61076c;

        /* renamed from: d  reason: collision with root package name */
        public String f61077d;

        /* renamed from: e  reason: collision with root package name */
        public String f61078e;

        public C2093a() {
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

        public C2093a a(String str) {
            InterceptResult invokeL;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeL = interceptable.invokeL(1048576, this, str)) == null) {
                this.a = str;
                return this;
            }
            return (C2093a) invokeL.objValue;
        }

        public C2093a b(String str) {
            InterceptResult invokeL;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeL = interceptable.invokeL(Constants.METHOD_SEND_USER_MSG, this, str)) == null) {
                this.f61075b = str;
                return this;
            }
            return (C2093a) invokeL.objValue;
        }

        public C2093a c(String str) {
            InterceptResult invokeL;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeL = interceptable.invokeL(1048579, this, str)) == null) {
                this.f61077d = str;
                return this;
            }
            return (C2093a) invokeL.objValue;
        }

        public C2093a d(String str) {
            InterceptResult invokeL;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeL = interceptable.invokeL(1048580, this, str)) == null) {
                this.f61078e = str;
                return this;
            }
            return (C2093a) invokeL.objValue;
        }

        public a a() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            return (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this)) == null) ? new a(this) : (a) invokeV.objValue;
        }
    }

    public a(C2093a c2093a) {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {c2093a};
            interceptable.invokeUnInit(65536, newInitContext);
            int i2 = newInitContext.flag;
            if ((i2 & 1) != 0) {
                int i3 = i2 & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
        this.f61071b = "";
        this.a = c2093a.a;
        this.f61071b = c2093a.f61075b;
        this.f61072c = c2093a.f61076c;
        this.f61073d = c2093a.f61077d;
        this.f61074e = c2093a.f61078e;
    }
}
