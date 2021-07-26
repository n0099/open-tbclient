package d.a.q0.m3;

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
/* loaded from: classes8.dex */
public class c {
    public static /* synthetic */ Interceptable $ic;

    /* renamed from: b  reason: collision with root package name */
    public static c f61023b;
    public transient /* synthetic */ FieldHolder $fh;

    /* renamed from: a  reason: collision with root package name */
    public a f61024a;

    /* loaded from: classes8.dex */
    public interface a {
        void a(Context context);

        void b(Context context, WebView webView, WebChromeClient webChromeClient);

        void c(Context context, String str, boolean z);
    }

    public c() {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            interceptable.invokeUnInit(65536, newInitContext);
            int i2 = newInitContext.flag;
            if ((i2 & 1) != 0) {
                int i3 = i2 & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
        this.f61024a = c();
    }

    public static c b() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(65537, null)) == null) {
            if (f61023b == null) {
                synchronized (c.class) {
                    if (f61023b == null) {
                        f61023b = new c();
                    }
                }
            }
            return f61023b;
        }
        return (c) invokeV.objValue;
    }

    public void a(Context context) {
        a aVar;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeL(1048576, this, context) == null) && PermissionUtil.isAgreePrivacyPolicy() && (aVar = this.f61024a) != null) {
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
        return (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this)) == null) ? d.a.p0.s.d0.b.j().k("pref_key_stat_sdk_enable", 1) != 0 : invokeV.booleanValue;
    }

    public void e(Context context, String str, boolean z) {
        a aVar;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeLLZ(1048579, this, context, str, z) == null) && PermissionUtil.isAgreePrivacyPolicy() && (aVar = this.f61024a) != null) {
            aVar.c(context, str, z);
        }
    }

    public void f(Context context, WebView webView, WebChromeClient webChromeClient) {
        a aVar;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeLLL(1048580, this, context, webView, webChromeClient) == null) && PermissionUtil.isAgreePrivacyPolicy() && (aVar = this.f61024a) != null) {
            aVar.b(context, webView, webChromeClient);
        }
    }
}
