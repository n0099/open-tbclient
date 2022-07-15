package com.repackage;

import android.content.Context;
import android.text.TextUtils;
import android.webkit.WebChromeClient;
import android.webkit.WebView;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.mobstat.MtjConfig;
import com.baidu.mobstat.StatService;
import com.baidu.tbadk.TbConfig;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import com.repackage.jn8;
/* loaded from: classes6.dex */
public class ns6 implements jn8.a {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    public ns6() {
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
        String version = TbConfig.getVersion();
        if (TextUtils.isEmpty(version)) {
            return;
        }
        StatService.setAppVersionName(TbadkCoreApplication.getInst(), version);
    }

    @Override // com.repackage.jn8.a
    public void a(Context context) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048576, this, context) == null) {
            StatService.setFeedTrack(MtjConfig.FeedTrackStrategy.TRACK_NONE);
            StatService.autoTrace(context);
        }
    }

    @Override // com.repackage.jn8.a
    public void b(Context context, WebView webView, WebChromeClient webChromeClient) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLLL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, context, webView, webChromeClient) == null) {
            StatService.trackWebView(context, webView, webChromeClient);
        }
    }

    @Override // com.repackage.jn8.a
    public void c(Context context, String str, boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLLZ(Constants.METHOD_SEND_USER_MSG, this, context, str, z) == null) {
            StatService.setAppChannel(context, str, z);
        }
    }
}
