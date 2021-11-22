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
    public String f69249a;

    /* renamed from: b  reason: collision with root package name */
    public String f69250b;

    /* renamed from: c  reason: collision with root package name */
    public String f69251c;

    /* renamed from: d  reason: collision with root package name */
    public String f69252d;

    /* renamed from: e  reason: collision with root package name */
    public String f69253e;

    /* renamed from: com.ss.android.download.api.model.a$a  reason: collision with other inner class name */
    /* loaded from: classes2.dex */
    public static class C2002a {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: a  reason: collision with root package name */
        public String f69254a;

        /* renamed from: b  reason: collision with root package name */
        public String f69255b;

        /* renamed from: c  reason: collision with root package name */
        public String f69256c;

        /* renamed from: d  reason: collision with root package name */
        public String f69257d;

        /* renamed from: e  reason: collision with root package name */
        public String f69258e;

        public C2002a() {
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

        public C2002a a(String str) {
            InterceptResult invokeL;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeL = interceptable.invokeL(1048576, this, str)) == null) {
                this.f69254a = str;
                return this;
            }
            return (C2002a) invokeL.objValue;
        }

        public C2002a b(String str) {
            InterceptResult invokeL;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeL = interceptable.invokeL(Constants.METHOD_SEND_USER_MSG, this, str)) == null) {
                this.f69255b = str;
                return this;
            }
            return (C2002a) invokeL.objValue;
        }

        public C2002a c(String str) {
            InterceptResult invokeL;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeL = interceptable.invokeL(1048579, this, str)) == null) {
                this.f69257d = str;
                return this;
            }
            return (C2002a) invokeL.objValue;
        }

        public C2002a d(String str) {
            InterceptResult invokeL;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeL = interceptable.invokeL(1048580, this, str)) == null) {
                this.f69258e = str;
                return this;
            }
            return (C2002a) invokeL.objValue;
        }

        public a a() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            return (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this)) == null) ? new a(this) : (a) invokeV.objValue;
        }
    }

    public a(C2002a c2002a) {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {c2002a};
            interceptable.invokeUnInit(65536, newInitContext);
            int i2 = newInitContext.flag;
            if ((i2 & 1) != 0) {
                int i3 = i2 & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
        this.f69250b = "";
        this.f69249a = c2002a.f69254a;
        this.f69250b = c2002a.f69255b;
        this.f69251c = c2002a.f69256c;
        this.f69252d = c2002a.f69257d;
        this.f69253e = c2002a.f69258e;
    }
}
