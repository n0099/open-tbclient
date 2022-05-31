package com.repackage;

import android.text.TextUtils;
import com.baidu.android.imsdk.chatmessage.request.IMAudioTransRequest;
import com.baidu.nadcore.exp.ADConfigError;
import com.baidu.nadcore.net.request.Headers;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import java.io.UnsupportedEncodingException;
import java.net.URLEncoder;
/* loaded from: classes7.dex */
public class yj0 {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    /* loaded from: classes7.dex */
    public static class a extends wn0<String> {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        public a() {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                }
            }
        }

        @Override // com.repackage.un0
        public void a(Exception exc, int i) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeLI(1048576, this, exc, i) == null) {
            }
        }

        @Override // com.repackage.vn0
        public /* bridge */ /* synthetic */ Object d(Headers headers, String str, int i) throws Exception {
            f(headers, str, i);
            return str;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.repackage.vn0
        /* renamed from: e */
        public void b(Headers headers, String str, int i) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeLLI(1048579, this, headers, str, i) == null) {
            }
        }

        public String f(Headers headers, String str, int i) {
            InterceptResult invokeLLI;
            Interceptable interceptable = $ic;
            return (interceptable == null || (invokeLLI = interceptable.invokeLLI(1048580, this, headers, str, i)) == null) ? str : (String) invokeLLI.objValue;
        }
    }

    public static yx0 a(ADConfigError aDConfigError, int i, boolean z) {
        InterceptResult invokeCommon;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeCommon = interceptable.invokeCommon(65536, null, new Object[]{aDConfigError, Integer.valueOf(i), Boolean.valueOf(z)})) == null) {
            yx0 yx0Var = new yx0();
            yx0Var.f("1042").a("f1", b(aDConfigError.code)).a("f2", b(String.valueOf(i))).a("f3", b(z ? "0" : "1"));
            return yx0Var;
        }
        return (yx0) invokeCommon.objValue;
    }

    public static String b(String str) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65537, null, str)) == null) {
            if (!TextUtils.isEmpty(str)) {
                try {
                    return URLEncoder.encode(str, IMAudioTransRequest.CHARSET);
                } catch (UnsupportedEncodingException e) {
                    e.printStackTrace();
                }
            }
            return "";
        }
        return (String) invokeL.objValue;
    }

    public static void c(ADConfigError aDConfigError, int i, boolean z) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeCommon(65538, null, new Object[]{aDConfigError, Integer.valueOf(i), Boolean.valueOf(z)}) == null) || aDConfigError == null) {
            return;
        }
        rx0.d(a(aDConfigError, i, z), new a());
    }
}
