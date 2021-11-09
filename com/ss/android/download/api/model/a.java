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

    /* renamed from: a  reason: collision with root package name */
    public String f68329a;

    /* renamed from: b  reason: collision with root package name */
    public String f68330b;

    /* renamed from: c  reason: collision with root package name */
    public String f68331c;

    /* renamed from: d  reason: collision with root package name */
    public String f68332d;

    /* renamed from: e  reason: collision with root package name */
    public String f68333e;

    /* renamed from: com.ss.android.download.api.model.a$a  reason: collision with other inner class name */
    /* loaded from: classes2.dex */
    public static class C1964a {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: a  reason: collision with root package name */
        public String f68334a;

        /* renamed from: b  reason: collision with root package name */
        public String f68335b;

        /* renamed from: c  reason: collision with root package name */
        public String f68336c;

        /* renamed from: d  reason: collision with root package name */
        public String f68337d;

        /* renamed from: e  reason: collision with root package name */
        public String f68338e;

        public C1964a() {
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

        public C1964a a(String str) {
            InterceptResult invokeL;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeL = interceptable.invokeL(1048576, this, str)) == null) {
                this.f68334a = str;
                return this;
            }
            return (C1964a) invokeL.objValue;
        }

        public C1964a b(String str) {
            InterceptResult invokeL;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeL = interceptable.invokeL(Constants.METHOD_SEND_USER_MSG, this, str)) == null) {
                this.f68335b = str;
                return this;
            }
            return (C1964a) invokeL.objValue;
        }

        public C1964a c(String str) {
            InterceptResult invokeL;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeL = interceptable.invokeL(1048579, this, str)) == null) {
                this.f68337d = str;
                return this;
            }
            return (C1964a) invokeL.objValue;
        }

        public C1964a d(String str) {
            InterceptResult invokeL;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeL = interceptable.invokeL(1048580, this, str)) == null) {
                this.f68338e = str;
                return this;
            }
            return (C1964a) invokeL.objValue;
        }

        public a a() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            return (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this)) == null) ? new a(this) : (a) invokeV.objValue;
        }
    }

    public a(C1964a c1964a) {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {c1964a};
            interceptable.invokeUnInit(65536, newInitContext);
            int i2 = newInitContext.flag;
            if ((i2 & 1) != 0) {
                int i3 = i2 & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
        this.f68330b = "";
        this.f68329a = c1964a.f68334a;
        this.f68330b = c1964a.f68335b;
        this.f68331c = c1964a.f68336c;
        this.f68332d = c1964a.f68337d;
        this.f68333e = c1964a.f68338e;
    }
}
