package com.repackage;

import android.net.Uri;
import android.webkit.WebResourceResponse;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.pyramid.annotation.Inject;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
/* loaded from: classes5.dex */
public interface di4 {

    /* loaded from: classes5.dex */
    public static class a implements di4 {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final di4 a;

        public a(di4 delegation) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {delegation};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            Intrinsics.checkNotNullParameter(delegation, "delegation");
            this.a = delegation;
        }

        @Override // com.repackage.di4
        public String a(String url) {
            InterceptResult invokeL;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeL = interceptable.invokeL(1048576, this, url)) == null) {
                Intrinsics.checkNotNullParameter(url, "url");
                return this.a.a(url);
            }
            return (String) invokeL.objValue;
        }

        @Override // com.repackage.di4
        public WebResourceResponse b(Uri url) {
            InterceptResult invokeL;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeL = interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, url)) == null) {
                Intrinsics.checkNotNullParameter(url, "url");
                return this.a.b(url);
            }
            return (WebResourceResponse) invokeL.objValue;
        }

        @Override // com.repackage.di4
        public <Target> Target c(WebResourceResponse webResourceResponse, Function1<? super WebResourceResponse, ? extends Target> transform) {
            InterceptResult invokeLL;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeLL = interceptable.invokeLL(Constants.METHOD_SEND_USER_MSG, this, webResourceResponse, transform)) == null) {
                Intrinsics.checkNotNullParameter(transform, "transform");
                return (Target) this.a.c(webResourceResponse, transform);
            }
            return (Target) invokeLL.objValue;
        }
    }

    /* loaded from: classes5.dex */
    public static class b {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        @Inject
        public qb1<di4> a;

        public b() {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            b();
        }

        public final qb1<di4> a() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) {
                qb1<di4> qb1Var = this.a;
                if (qb1Var == null) {
                    Intrinsics.throwUninitializedPropertyAccessException("impl");
                }
                return qb1Var;
            }
            return (qb1) invokeV.objValue;
        }

        public void b() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this) == null) {
                ob1 b = ob1.b();
                this.a = b;
                b.a(new ei4());
            }
        }
    }

    /* loaded from: classes5.dex */
    public static class c extends a {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* JADX WARN: Illegal instructions before constructor call */
        /*
            Code decompiled incorrectly, please refer to instructions dump.
        */
        public c(b ioc) {
            super(r7);
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {ioc};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    super((di4) newInitContext.callArgs[0]);
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            Intrinsics.checkNotNullParameter(ioc, "ioc");
            di4 di4Var = ioc.a().get();
            Intrinsics.checkNotNullExpressionValue(di4Var, "ioc.impl.get()");
        }
    }

    String a(String str);

    WebResourceResponse b(Uri uri);

    <Target> Target c(WebResourceResponse webResourceResponse, Function1<? super WebResourceResponse, ? extends Target> function1);
}
