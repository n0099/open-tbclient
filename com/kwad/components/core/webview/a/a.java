package com.kwad.components.core.webview.a;

import android.text.TextUtils;
import android.webkit.JavascriptInterface;
import android.webkit.WebView;
import androidx.annotation.WorkerThread;
import androidx.core.view.InputDeviceCompat;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import com.ksad.json.annotation.KsJson;
import com.kwad.components.core.c.a.a;
import com.kwad.components.core.c.a.c;
import com.kwad.sdk.api.KsAppDownloadListener;
import com.kwad.sdk.core.response.model.AdTemplate;
import com.kwad.sdk.utils.bd;
import com.kwad.sdk.utils.bh;
import org.json.JSONException;
import org.json.JSONObject;
/* loaded from: classes8.dex */
public final class a {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public c DV;
    public WebView Fv;
    public boolean KE;
    public KsAppDownloadListener KW;
    public int KX;
    public int KY;
    public AdTemplate mAdTemplate;
    public com.kwad.sdk.core.webview.b mJsBridgeContext;

    @KsJson
    /* renamed from: com.kwad.components.core.webview.a.a$a  reason: collision with other inner class name */
    /* loaded from: classes8.dex */
    public static final class C0606a extends com.kwad.sdk.core.response.kwai.a {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public String packageName;
        public String url;

        public C0606a() {
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
    }

    @KsJson
    /* loaded from: classes8.dex */
    public static final class b extends com.kwad.sdk.core.response.kwai.a {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public int progress;
        public int status;

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
                }
            }
        }
    }

    public a(WebView webView, com.kwad.sdk.core.webview.b bVar) {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {webView, bVar};
            interceptable.invokeUnInit(65536, newInitContext);
            int i = newInitContext.flag;
            if ((i & 1) != 0) {
                int i2 = i & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
        this.KX = -100;
        this.KY = 0;
        this.Fv = webView;
        this.mAdTemplate = bVar.getAdTemplate();
        this.mJsBridgeContext = bVar;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void aD(String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(65539, this, str) == null) {
            try {
                C0606a c0606a = new C0606a();
                c0606a.parseJson(new JSONObject(str));
                if (k(c0606a.url, c0606a.packageName)) {
                    return;
                }
                if (this.DV == null) {
                    j(c0606a.url, c0606a.packageName);
                }
                if (this.DV.mR()) {
                    return;
                }
                this.DV.d(this.KW);
                this.DV.m(new a.C0594a(this.mJsBridgeContext.Fv.getContext()).aj(true).ak(false).L(this.mAdTemplate).am(false));
            } catch (JSONException e) {
                com.kwad.sdk.core.e.b.printStackTrace(e);
            }
        }
    }

    private void h(String str, String str2) {
        WebView webView;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeLL(InputDeviceCompat.SOURCE_TRACKBALL, this, str, str2) == null) || this.KE || TextUtils.isEmpty(str) || (webView = this.Fv) == null) {
            return;
        }
        bh.a(webView, str, str2);
    }

    private synchronized void j(String str, String str2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(65541, this, str, str2) == null) {
            synchronized (this) {
                this.DV = new c(this.mAdTemplate, null, str, str2);
                if (this.KW == null) {
                    KsAppDownloadListener pu = pu();
                    this.KW = pu;
                    this.DV.b(pu);
                }
            }
        }
    }

    public static boolean k(String str, String str2) {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeLL = interceptable.invokeLL(65542, null, str, str2)) == null) ? TextUtils.isEmpty(str) || TextUtils.isEmpty(str2) : invokeLL.booleanValue;
    }

    /* JADX DEBUG: TODO: convert one arg to string using `String.valueOf()`, args: [(r5v0 int)] */
    /* JADX INFO: Access modifiers changed from: private */
    public void m(int i, int i2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeII(65543, this, i, i2) == null) {
            this.KY = i2;
            if (this.KX != i) {
                this.KX = i;
                StringBuilder sb = new StringBuilder();
                sb.append(i);
                h("onDownLoadStatusCallback", sb.toString());
            }
        }
    }

    private KsAppDownloadListener pu() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(65544, this)) == null) ? new com.kwad.sdk.core.download.kwai.a(this) { // from class: com.kwad.components.core.webview.a.a.2
            public static /* synthetic */ Interceptable $ic;
            public transient /* synthetic */ FieldHolder $fh;
            public final /* synthetic */ a La;

            {
                Interceptable interceptable2 = $ic;
                if (interceptable2 != null) {
                    InitContext newInitContext = TitanRuntime.newInitContext();
                    newInitContext.initArgs = r2;
                    Object[] objArr = {this};
                    interceptable2.invokeUnInit(65536, newInitContext);
                    int i = newInitContext.flag;
                    if ((i & 1) != 0) {
                        int i2 = i & 2;
                        newInitContext.thisArg = this;
                        interceptable2.invokeInitBody(65536, newInitContext);
                        return;
                    }
                }
                this.La = this;
            }

            @Override // com.kwad.sdk.api.KsAppDownloadListener
            public final void onDownloadFailed() {
                Interceptable interceptable2 = $ic;
                if (interceptable2 == null || interceptable2.invokeV(1048576, this) == null) {
                    this.La.m(0, 0);
                }
            }

            @Override // com.kwad.sdk.api.KsAppDownloadListener
            public final void onDownloadFinished() {
                Interceptable interceptable2 = $ic;
                if (interceptable2 == null || interceptable2.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this) == null) {
                    this.La.m(8, 100);
                }
            }

            @Override // com.kwad.sdk.api.KsAppDownloadListener
            public final void onIdle() {
                Interceptable interceptable2 = $ic;
                if (interceptable2 == null || interceptable2.invokeV(Constants.METHOD_SEND_USER_MSG, this) == null) {
                    this.La.m(0, 0);
                }
            }

            @Override // com.kwad.sdk.api.KsAppDownloadListener
            public final void onInstalled() {
                Interceptable interceptable2 = $ic;
                if (interceptable2 == null || interceptable2.invokeV(1048579, this) == null) {
                    this.La.m(12, 100);
                }
            }

            @Override // com.kwad.sdk.core.download.kwai.a
            public final void onPaused(int i) {
                Interceptable interceptable2 = $ic;
                if (interceptable2 == null || interceptable2.invokeI(1048580, this, i) == null) {
                    this.La.m(4, i);
                }
            }

            @Override // com.kwad.sdk.api.KsAppDownloadListener
            public final void onProgressUpdate(int i) {
                Interceptable interceptable2 = $ic;
                if (interceptable2 == null || interceptable2.invokeI(1048581, this, i) == null) {
                    if (i == 0) {
                        this.La.m(1, 0);
                    } else {
                        this.La.m(2, i);
                    }
                }
            }
        } : (KsAppDownloadListener) invokeV.objValue;
    }

    public final void destroy() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
            this.KE = true;
            c cVar = this.DV;
            if (cVar != null) {
                cVar.c(this.KW);
            }
        }
    }

    @JavascriptInterface
    public final int getDownLoadStatus(String str, String str2) {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, str, str2)) == null) {
            if (k(str, str2)) {
                return 0;
            }
            if (this.DV == null) {
                j(str, str2);
            }
            return this.DV.mI();
        }
        return invokeLL.intValue;
    }

    @JavascriptInterface
    public final int getProgress(String str, String str2) {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(Constants.METHOD_SEND_USER_MSG, this, str, str2)) == null) {
            if (k(str, str2)) {
                return 0;
            }
            if (this.DV == null) {
                j(str, str2);
            }
            return this.KY;
        }
        return invokeLL.intValue;
    }

    @JavascriptInterface
    @WorkerThread
    public final void handleAdClick(String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048579, this, str) == null) {
            bd.runOnUiThread(new Runnable(this, str) { // from class: com.kwad.components.core.webview.a.a.1
                public static /* synthetic */ Interceptable $ic;
                public transient /* synthetic */ FieldHolder $fh;
                public final /* synthetic */ String KZ;
                public final /* synthetic */ a La;

                {
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 != null) {
                        InitContext newInitContext = TitanRuntime.newInitContext();
                        newInitContext.initArgs = r2;
                        Object[] objArr = {this, str};
                        interceptable2.invokeUnInit(65536, newInitContext);
                        int i = newInitContext.flag;
                        if ((i & 1) != 0) {
                            int i2 = i & 2;
                            newInitContext.thisArg = this;
                            interceptable2.invokeInitBody(65536, newInitContext);
                            return;
                        }
                    }
                    this.La = this;
                    this.KZ = str;
                }

                @Override // java.lang.Runnable
                public final void run() {
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 == null || interceptable2.invokeV(1048576, this) == null) {
                        this.La.aD(this.KZ);
                    }
                }
            });
        }
    }
}
