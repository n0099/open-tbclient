package com.repackage;

import android.content.Context;
import android.webkit.WebChromeClient;
import android.webkit.WebView;
import com.baidu.adp.framework.MessageManager;
import com.baidu.adp.framework.message.CustomResponsedMessage;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.tbadk.core.util.PermissionUtil;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
/* loaded from: classes6.dex */
public class jn8 {
    public static /* synthetic */ Interceptable $ic;
    public static jn8 b;
    public transient /* synthetic */ FieldHolder $fh;
    public a a;

    /* loaded from: classes6.dex */
    public interface a {
        void a(Context context);

        void b(Context context, WebView webView, WebChromeClient webChromeClient);

        void c(Context context, String str, boolean z);
    }

    public jn8() {
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
        this.a = c();
    }

    public static jn8 b() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(65537, null)) == null) {
            if (b == null) {
                synchronized (jn8.class) {
                    if (b == null) {
                        b = new jn8();
                    }
                }
            }
            return b;
        }
        return (jn8) invokeV.objValue;
    }

    public void a(Context context) {
        a aVar;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeL(1048576, this, context) == null) && PermissionUtil.isAgreePrivacyPolicy() && (aVar = this.a) != null) {
            aVar.a(context);
        }
    }

    public final a c() {
        InterceptResult invokeV;
        CustomResponsedMessage runTask;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this)) == null) {
            if (!d() || (runTask = MessageManager.getInstance().runTask(2156671, a.class)) == null) {
                return null;
            }
            return (a) runTask.getData();
        }
        return (a) invokeV.objValue;
    }

    public final boolean d() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this)) == null) ? xt4.k().l("pref_key_stat_sdk_enable", 1) != 0 : invokeV.booleanValue;
    }

    public void e(Context context, String str, boolean z) {
        a aVar;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeLLZ(1048579, this, context, str, z) == null) && PermissionUtil.isAgreePrivacyPolicy() && (aVar = this.a) != null) {
            aVar.c(context, str, z);
        }
    }

    public void f(Context context, WebView webView, WebChromeClient webChromeClient) {
        a aVar;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeLLL(1048580, this, context, webView, webChromeClient) == null) && PermissionUtil.isAgreePrivacyPolicy() && (aVar = this.a) != null) {
            aVar.b(context, webView, webChromeClient);
        }
    }
}
