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
import com.kwad.sdk.api.KsAppDownloadListener;
import com.kwad.sdk.core.response.model.AdTemplate;
import com.kwad.sdk.utils.az;
import com.kwad.sdk.utils.bd;
import org.json.JSONException;
import org.json.JSONObject;
/* loaded from: classes5.dex */
public final class a {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public WebView a;
    public AdTemplate b;
    public com.kwad.sdk.core.webview.b c;
    public KsAppDownloadListener d;
    public boolean e;
    public com.kwad.components.core.c.a.b f;
    public int g;
    public int h;

    @KsJson
    /* renamed from: com.kwad.components.core.webview.a.a$a  reason: collision with other inner class name */
    /* loaded from: classes5.dex */
    public static final class C0519a extends com.kwad.sdk.core.response.kwai.a {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public String a;
        public String b;

        public C0519a() {
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
    /* loaded from: classes5.dex */
    public static final class b extends com.kwad.sdk.core.response.kwai.a {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public int a;
        public int b;

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
        this.g = -100;
        this.h = 0;
        this.a = webView;
        this.b = bVar.a();
        this.c = bVar;
    }

    /* JADX DEBUG: TODO: convert one arg to string using `String.valueOf()`, args: [(r5v0 int)] */
    /* JADX INFO: Access modifiers changed from: private */
    public void a(int i, int i2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeII(65537, this, i, i2) == null) {
            this.h = i2;
            if (this.g != i) {
                this.g = i;
                StringBuilder sb = new StringBuilder();
                sb.append(i);
                c("onDownLoadStatusCallback", sb.toString());
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(InputDeviceCompat.SOURCE_TRACKBALL, this, str) == null) {
            try {
                C0519a c0519a = new C0519a();
                c0519a.parseJson(new JSONObject(str));
                if (b(c0519a.a, c0519a.b)) {
                    return;
                }
                if (this.f == null) {
                    a(c0519a.a, c0519a.b);
                }
                if (this.f.f()) {
                    return;
                }
                this.f.c(this.d);
                this.f.a(new a.C0507a(this.c.e.getContext()).a(true).b(false).a(this.b).d(false));
            } catch (JSONException e) {
                com.kwad.sdk.core.d.b.a(e);
            }
        }
    }

    private synchronized void a(String str, String str2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(65541, this, str, str2) == null) {
            synchronized (this) {
                this.f = new com.kwad.components.core.c.a.b(this.b, null, str, str2);
                if (this.d == null) {
                    KsAppDownloadListener b2 = b();
                    this.d = b2;
                    this.f.a(b2);
                }
            }
        }
    }

    private KsAppDownloadListener b() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(65542, this)) == null) ? new com.kwad.sdk.core.download.kwai.a(this) { // from class: com.kwad.components.core.webview.a.a.2
            public static /* synthetic */ Interceptable $ic;
            public transient /* synthetic */ FieldHolder $fh;
            public final /* synthetic */ a a;

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
                this.a = this;
            }

            @Override // com.kwad.sdk.core.download.kwai.a
            public final void a(int i) {
                Interceptable interceptable2 = $ic;
                if (interceptable2 == null || interceptable2.invokeI(1048576, this, i) == null) {
                    this.a.a(4, i);
                }
            }

            @Override // com.kwad.sdk.api.KsAppDownloadListener
            public final void onDownloadFailed() {
                Interceptable interceptable2 = $ic;
                if (interceptable2 == null || interceptable2.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this) == null) {
                    this.a.a(0, 0);
                }
            }

            @Override // com.kwad.sdk.api.KsAppDownloadListener
            public final void onDownloadFinished() {
                Interceptable interceptable2 = $ic;
                if (interceptable2 == null || interceptable2.invokeV(Constants.METHOD_SEND_USER_MSG, this) == null) {
                    this.a.a(8, 100);
                }
            }

            @Override // com.kwad.sdk.api.KsAppDownloadListener
            public final void onIdle() {
                Interceptable interceptable2 = $ic;
                if (interceptable2 == null || interceptable2.invokeV(1048579, this) == null) {
                    this.a.a(0, 0);
                }
            }

            @Override // com.kwad.sdk.api.KsAppDownloadListener
            public final void onInstalled() {
                Interceptable interceptable2 = $ic;
                if (interceptable2 == null || interceptable2.invokeV(1048580, this) == null) {
                    this.a.a(12, 100);
                }
            }

            @Override // com.kwad.sdk.api.KsAppDownloadListener
            public final void onProgressUpdate(int i) {
                Interceptable interceptable2 = $ic;
                if (interceptable2 == null || interceptable2.invokeI(1048581, this, i) == null) {
                    if (i == 0) {
                        this.a.a(1, 0);
                    } else {
                        this.a.a(2, i);
                    }
                }
            }
        } : (KsAppDownloadListener) invokeV.objValue;
    }

    public static boolean b(String str, String str2) {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeLL = interceptable.invokeLL(65543, null, str, str2)) == null) ? TextUtils.isEmpty(str) || TextUtils.isEmpty(str2) : invokeLL.booleanValue;
    }

    private void c(String str, String str2) {
        WebView webView;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeLL(65544, this, str, str2) == null) || this.e || TextUtils.isEmpty(str) || (webView = this.a) == null) {
            return;
        }
        bd.a(webView, str, str2);
    }

    public final void a() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
            this.e = true;
            com.kwad.components.core.c.a.b bVar = this.f;
            if (bVar != null) {
                bVar.b(this.d);
            }
        }
    }

    @JavascriptInterface
    public final int getDownLoadStatus(String str, String str2) {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, str, str2)) == null) {
            if (b(str, str2)) {
                return 0;
            }
            if (this.f == null) {
                a(str, str2);
            }
            return this.f.a();
        }
        return invokeLL.intValue;
    }

    @JavascriptInterface
    public final int getProgress(String str, String str2) {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(Constants.METHOD_SEND_USER_MSG, this, str, str2)) == null) {
            if (b(str, str2)) {
                return 0;
            }
            if (this.f == null) {
                a(str, str2);
            }
            return this.h;
        }
        return invokeLL.intValue;
    }

    @JavascriptInterface
    @WorkerThread
    public final void handleAdClick(String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048579, this, str) == null) {
            az.a(new Runnable(this, str) { // from class: com.kwad.components.core.webview.a.a.1
                public static /* synthetic */ Interceptable $ic;
                public transient /* synthetic */ FieldHolder $fh;
                public final /* synthetic */ String a;
                public final /* synthetic */ a b;

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
                    this.b = this;
                    this.a = str;
                }

                @Override // java.lang.Runnable
                public final void run() {
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 == null || interceptable2.invokeV(1048576, this) == null) {
                        this.b.a(this.a);
                    }
                }
            });
        }
    }
}
