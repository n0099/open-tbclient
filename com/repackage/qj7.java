package com.repackage;

import android.app.Activity;
import android.content.Context;
import android.net.Uri;
import com.baidu.adp.lib.util.StringUtils;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.searchbox.live.interfaces.service.RouterService;
import com.baidu.tbadk.TbPageContext;
import com.baidu.tbadk.browser.WebViewBroadcastReceiver;
import com.baidu.tbadk.core.util.UrlManager;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
/* loaded from: classes7.dex */
public class qj7 implements RouterService {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    public qj7() {
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

    @Override // com.baidu.searchbox.live.interfaces.service.RouterService
    public void invoke(Context context, String str) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeLL(1048576, this, context, str) == null) || StringUtils.isNull(str)) {
            return;
        }
        StringBuilder sb = new StringBuilder();
        sb.append(str);
        if (str.indexOf("?") > 0) {
            sb.append("&");
        } else {
            sb.append("?");
        }
        sb.append(WebViewBroadcastReceiver.INTENT_LOCALE_RECEV_CLOSE);
        sb.append("=1");
        sb.append("&page_from=live");
        Activity b = z8.g().b();
        if (b != null) {
            UrlManager.getInstance().dealOneLink((TbPageContext) h9.a(b), new String[]{sb.toString()}, true);
        }
    }

    @Override // com.baidu.searchbox.live.interfaces.service.RouterService
    public void invokeScheme(Context context, String str) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeLL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, context, str) == null) || StringUtils.isNull(str)) {
            return;
        }
        StringBuilder sb = new StringBuilder();
        sb.append(str);
        if (str.indexOf("?") > 0) {
            sb.append("&");
        } else {
            sb.append("?");
        }
        sb.append(WebViewBroadcastReceiver.INTENT_LOCALE_RECEV_CLOSE);
        sb.append("=1");
        sb.append("&page_from=live");
        Activity b = z8.g().b();
        if (b != null) {
            UrlManager.getInstance().dealOneLink((TbPageContext) h9.a(b), new String[]{sb.toString()}, true);
        }
    }

    @Override // com.baidu.searchbox.live.interfaces.service.RouterService
    public boolean invokeSchemeWithCallBack(Context context, Uri uri, String str, RouterService.LiveShowSchemeCallBack liveShowSchemeCallBack) {
        InterceptResult invokeLLLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLLLL = interceptable.invokeLLLL(1048579, this, context, uri, str, liveShowSchemeCallBack)) == null) {
            return false;
        }
        return invokeLLLL.booleanValue;
    }

    @Override // com.baidu.searchbox.live.interfaces.service.RouterService
    public void openScheme(String str) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(1048580, this, str) == null) || StringUtils.isNull(str)) {
            return;
        }
        StringBuilder sb = new StringBuilder();
        sb.append(str);
        if (str.indexOf("?") > 0) {
            sb.append("&");
        } else {
            sb.append("?");
        }
        sb.append(WebViewBroadcastReceiver.INTENT_LOCALE_RECEV_CLOSE);
        sb.append("=1");
        sb.append("&page_from=live");
        Activity b = z8.g().b();
        if (b != null) {
            UrlManager.getInstance().dealOneLink((TbPageContext) h9.a(b), new String[]{sb.toString()}, true);
        }
    }

    @Override // com.baidu.searchbox.live.interfaces.service.RouterService
    public boolean invokeScheme(Uri uri, String str, RouterService.LiveShowSchemeCallBack liveShowSchemeCallBack) {
        InterceptResult invokeLLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLLL = interceptable.invokeLLL(Constants.METHOD_SEND_USER_MSG, this, uri, str, liveShowSchemeCallBack)) == null) {
            openScheme(uri.toString());
            return true;
        }
        return invokeLLL.booleanValue;
    }
}
