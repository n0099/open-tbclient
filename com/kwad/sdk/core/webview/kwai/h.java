package com.kwad.sdk.core.webview.kwai;

import android.text.TextUtils;
import android.webkit.JavascriptInterface;
import android.webkit.WebView;
import androidx.core.view.InputDeviceCompat;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import com.kwad.sdk.api.KsAppDownloadListener;
import com.kwad.sdk.core.response.model.AdTemplate;
import com.kwad.sdk.utils.bf;
import org.json.JSONException;
import org.json.JSONObject;
/* loaded from: classes2.dex */
public class h {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public WebView a;

    /* renamed from: b  reason: collision with root package name */
    public AdTemplate f58103b;

    /* renamed from: c  reason: collision with root package name */
    public com.kwad.sdk.core.webview.a f58104c;

    /* renamed from: d  reason: collision with root package name */
    public KsAppDownloadListener f58105d;

    /* renamed from: e  reason: collision with root package name */
    public boolean f58106e;

    /* renamed from: f  reason: collision with root package name */
    public com.kwad.sdk.core.download.a.b f58107f;

    /* renamed from: g  reason: collision with root package name */
    public int f58108g;

    /* renamed from: h  reason: collision with root package name */
    public int f58109h;

    /* loaded from: classes2.dex */
    public static final class a extends com.kwad.sdk.core.response.kwai.a {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public String a;

        /* renamed from: b  reason: collision with root package name */
        public String f58111b;

        public a() {
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
    }

    /* loaded from: classes2.dex */
    public static final class b extends com.kwad.sdk.core.response.kwai.a {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public int a;

        /* renamed from: b  reason: collision with root package name */
        public int f58112b;

        public b() {
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
    }

    public h(WebView webView, com.kwad.sdk.core.webview.a aVar) {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {webView, aVar};
            interceptable.invokeUnInit(65536, newInitContext);
            int i2 = newInitContext.flag;
            if ((i2 & 1) != 0) {
                int i3 = i2 & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
        this.f58108g = -100;
        this.f58109h = 0;
        this.a = webView;
        this.f58103b = aVar.a();
        this.f58104c = aVar;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(int i2, int i3) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeII(65537, this, i2, i3) == null) {
            this.f58109h = i3;
            if (this.f58108g != i2) {
                this.f58108g = i2;
                c("onDownLoadStatusCallback", i2 + "");
            }
        }
    }

    private void a(String str, String str2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(65539, this, str, str2) == null) {
            this.f58107f = new com.kwad.sdk.core.download.a.b(this.f58103b, null, str, str2);
            if (this.f58105d == null) {
                KsAppDownloadListener b2 = b();
                this.f58105d = b2;
                this.f58107f.a(b2);
            }
        }
    }

    private KsAppDownloadListener b() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(InputDeviceCompat.SOURCE_TRACKBALL, this)) == null) ? new com.kwad.sdk.core.download.a.c(this) { // from class: com.kwad.sdk.core.webview.kwai.h.1
            public static /* synthetic */ Interceptable $ic;
            public transient /* synthetic */ FieldHolder $fh;

            /* renamed from: b  reason: collision with root package name */
            public final /* synthetic */ h f58110b;

            {
                Interceptable interceptable2 = $ic;
                if (interceptable2 != null) {
                    InitContext newInitContext = TitanRuntime.newInitContext();
                    newInitContext.initArgs = r2;
                    Object[] objArr = {this};
                    interceptable2.invokeUnInit(65536, newInitContext);
                    int i2 = newInitContext.flag;
                    if ((i2 & 1) != 0) {
                        int i3 = i2 & 2;
                        newInitContext.thisArg = this;
                        interceptable2.invokeInitBody(65536, newInitContext);
                        return;
                    }
                }
                this.f58110b = this;
            }

            @Override // com.kwad.sdk.core.download.a.c
            public void a(int i2) {
                Interceptable interceptable2 = $ic;
                if (interceptable2 == null || interceptable2.invokeI(1048576, this, i2) == null) {
                    this.f58110b.a(4, i2);
                }
            }

            @Override // com.kwad.sdk.api.KsAppDownloadListener
            public void onDownloadFailed() {
                Interceptable interceptable2 = $ic;
                if (interceptable2 == null || interceptable2.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this) == null) {
                    this.f58110b.a(0, 0);
                }
            }

            @Override // com.kwad.sdk.api.KsAppDownloadListener
            public void onDownloadFinished() {
                Interceptable interceptable2 = $ic;
                if (interceptable2 == null || interceptable2.invokeV(Constants.METHOD_SEND_USER_MSG, this) == null) {
                    this.f58110b.a(8, 100);
                }
            }

            @Override // com.kwad.sdk.api.KsAppDownloadListener
            public void onIdle() {
                Interceptable interceptable2 = $ic;
                if (interceptable2 == null || interceptable2.invokeV(1048579, this) == null) {
                    this.f58110b.a(0, 0);
                }
            }

            @Override // com.kwad.sdk.api.KsAppDownloadListener
            public void onInstalled() {
                Interceptable interceptable2 = $ic;
                if (interceptable2 == null || interceptable2.invokeV(1048580, this) == null) {
                    this.f58110b.a(12, 100);
                }
            }

            @Override // com.kwad.sdk.api.KsAppDownloadListener
            public void onProgressUpdate(int i2) {
                Interceptable interceptable2 = $ic;
                if (interceptable2 == null || interceptable2.invokeI(1048581, this, i2) == null) {
                    if (i2 == 0) {
                        this.f58110b.a(1, 0);
                    } else {
                        this.f58110b.a(2, i2);
                    }
                }
            }
        } : (KsAppDownloadListener) invokeV.objValue;
    }

    private boolean b(String str, String str2) {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeLL = interceptable.invokeLL(65541, this, str, str2)) == null) ? TextUtils.isEmpty(str) || TextUtils.isEmpty(str2) : invokeLL.booleanValue;
    }

    private void c(String str, String str2) {
        WebView webView;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeLL(65542, this, str, str2) == null) || this.f58106e || TextUtils.isEmpty(str) || (webView = this.a) == null) {
            return;
        }
        bf.a(webView, str, str2);
    }

    public void a() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
            this.f58106e = true;
            com.kwad.sdk.core.download.a.b bVar = this.f58107f;
            if (bVar != null) {
                bVar.b(this.f58105d);
            }
        }
    }

    @JavascriptInterface
    public int getDownLoadStatus(String str, String str2) {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, str, str2)) == null) {
            if (b(str, str2)) {
                return 0;
            }
            if (this.f58107f == null) {
                a(str, str2);
            }
            return this.f58107f.c();
        }
        return invokeLL.intValue;
    }

    @JavascriptInterface
    public int getProgress(String str, String str2) {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(Constants.METHOD_SEND_USER_MSG, this, str, str2)) == null) {
            if (b(str, str2)) {
                return 0;
            }
            if (this.f58107f == null) {
                a(str, str2);
            }
            return this.f58109h;
        }
        return invokeLL.intValue;
    }

    @JavascriptInterface
    public void handleAdClick(String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048579, this, str) == null) {
            try {
                a aVar = new a();
                aVar.parseJson(new JSONObject(str));
                if (b(aVar.a, aVar.f58111b)) {
                    return;
                }
                if (this.f58107f == null) {
                    a(aVar.a, aVar.f58111b);
                }
                if (this.f58107f.f()) {
                    return;
                }
                this.f58107f.c(this.f58105d);
                this.f58107f.a(this.f58104c.f57958e.getContext(), true);
            } catch (JSONException e2) {
                com.kwad.sdk.core.d.a.a(e2);
            }
        }
    }
}
