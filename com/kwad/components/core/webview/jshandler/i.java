package com.kwad.components.core.webview.jshandler;

import android.os.Handler;
import android.os.Looper;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import com.kwad.components.core.c.a.a;
import org.json.JSONException;
import org.json.JSONObject;
/* loaded from: classes5.dex */
public final class i implements com.kwad.sdk.core.webview.kwai.a {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public final com.kwad.sdk.core.webview.b Lk;
    public Handler Ll;
    public boolean Ln;
    @Nullable
    public com.kwad.sdk.core.webview.a.kwai.a bJ;
    @Nullable
    public final com.kwad.components.core.c.a.c mApkDownloadHelper;

    /* JADX WARN: 'this' call moved to the top of the method (can break code semantics) */
    public i(@NonNull com.kwad.sdk.core.webview.b bVar, @Nullable com.kwad.components.core.c.a.c cVar, @Nullable com.kwad.sdk.core.webview.a.kwai.a aVar) {
        this(bVar, cVar, aVar, false);
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {bVar, cVar, aVar};
            interceptable.invokeUnInit(65536, newInitContext);
            int i = newInitContext.flag;
            if ((i & 1) != 0) {
                int i2 = i & 2;
                Object[] objArr2 = newInitContext.callArgs;
                this((com.kwad.sdk.core.webview.b) objArr2[0], (com.kwad.components.core.c.a.c) objArr2[1], (com.kwad.sdk.core.webview.a.kwai.a) objArr2[2], ((Boolean) objArr2[3]).booleanValue());
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
    }

    public i(@NonNull com.kwad.sdk.core.webview.b bVar, @Nullable com.kwad.components.core.c.a.c cVar, @Nullable com.kwad.sdk.core.webview.a.kwai.a aVar, boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {bVar, cVar, aVar, Boolean.valueOf(z)};
            interceptable.invokeUnInit(65537, newInitContext);
            int i = newInitContext.flag;
            if ((i & 1) != 0) {
                int i2 = i & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65537, newInitContext);
                return;
            }
        }
        this.Ln = false;
        this.Ln = z;
        this.Ll = new Handler(Looper.getMainLooper());
        this.Lk = bVar;
        this.mApkDownloadHelper = cVar;
        if (cVar != null) {
            cVar.ah(1);
        }
        this.bJ = aVar;
    }

    @Override // com.kwad.sdk.core.webview.kwai.a
    public final void a(String str, @NonNull com.kwad.sdk.core.webview.kwai.c cVar) {
        Handler handler;
        Runnable runnable;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(1048576, this, str, cVar) == null) {
            if (this.Lk.wh()) {
                cVar.onError(-1, "native adTemplate is null");
                return;
            }
            com.kwad.sdk.core.webview.a.a.a aVar = new com.kwad.sdk.core.webview.a.a.a();
            try {
                aVar.parseJson(new JSONObject(str));
                aVar.DS = true;
            } catch (JSONException e) {
                com.kwad.sdk.core.e.b.printStackTrace(e);
            }
            if (!this.Lk.agf) {
                if (this.bJ != null) {
                    handler = this.Ll;
                    runnable = new Runnable(this, aVar) { // from class: com.kwad.components.core.webview.jshandler.i.2
                        public static /* synthetic */ Interceptable $ic;
                        public transient /* synthetic */ FieldHolder $fh;
                        public final /* synthetic */ com.kwad.sdk.core.webview.a.a.a Lq;
                        public final /* synthetic */ i Lw;

                        {
                            Interceptable interceptable2 = $ic;
                            if (interceptable2 != null) {
                                InitContext newInitContext = TitanRuntime.newInitContext();
                                newInitContext.initArgs = r2;
                                Object[] objArr = {this, aVar};
                                interceptable2.invokeUnInit(65536, newInitContext);
                                int i = newInitContext.flag;
                                if ((i & 1) != 0) {
                                    int i2 = i & 2;
                                    newInitContext.thisArg = this;
                                    interceptable2.invokeInitBody(65536, newInitContext);
                                    return;
                                }
                            }
                            this.Lw = this;
                            this.Lq = aVar;
                        }

                        @Override // java.lang.Runnable
                        public final void run() {
                            Interceptable interceptable2 = $ic;
                            if (!(interceptable2 == null || interceptable2.invokeV(1048576, this) == null) || this.Lw.bJ == null) {
                                return;
                            }
                            this.Lw.bJ.a(this.Lq);
                        }
                    };
                }
                cVar.a(null);
            }
            handler = this.Ll;
            runnable = new Runnable(this, aVar) { // from class: com.kwad.components.core.webview.jshandler.i.1
                public static /* synthetic */ Interceptable $ic;
                public transient /* synthetic */ FieldHolder $fh;
                public final /* synthetic */ com.kwad.sdk.core.webview.a.a.a Lq;
                public final /* synthetic */ i Lw;

                {
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 != null) {
                        InitContext newInitContext = TitanRuntime.newInitContext();
                        newInitContext.initArgs = r2;
                        Object[] objArr = {this, aVar};
                        interceptable2.invokeUnInit(65536, newInitContext);
                        int i = newInitContext.flag;
                        if ((i & 1) != 0) {
                            int i2 = i & 2;
                            newInitContext.thisArg = this;
                            interceptable2.invokeInitBody(65536, newInitContext);
                            return;
                        }
                    }
                    this.Lw = this;
                    this.Lq = aVar;
                }

                @Override // java.lang.Runnable
                public final void run() {
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 == null || interceptable2.invokeV(1048576, this) == null) {
                        if (this.Lw.Lk.agg || this.Lq.Mv) {
                            com.kwad.components.core.c.a.a.a(this.Lw.Lk.Gl.getContext(), this.Lw.Lk.getAdTemplate(), new a.b(this) { // from class: com.kwad.components.core.webview.jshandler.i.1.1
                                public static /* synthetic */ Interceptable $ic;
                                public transient /* synthetic */ FieldHolder $fh;
                                public final /* synthetic */ AnonymousClass1 Lx;

                                {
                                    Interceptable interceptable3 = $ic;
                                    if (interceptable3 != null) {
                                        InitContext newInitContext = TitanRuntime.newInitContext();
                                        newInitContext.initArgs = r2;
                                        Object[] objArr = {this};
                                        interceptable3.invokeUnInit(65536, newInitContext);
                                        int i = newInitContext.flag;
                                        if ((i & 1) != 0) {
                                            int i2 = i & 2;
                                            newInitContext.thisArg = this;
                                            interceptable3.invokeInitBody(65536, newInitContext);
                                            return;
                                        }
                                    }
                                    this.Lx = this;
                                }

                                @Override // com.kwad.components.core.c.a.a.b
                                public final void onAdClicked() {
                                    Interceptable interceptable3 = $ic;
                                    if (!(interceptable3 == null || interceptable3.invokeV(1048576, this) == null) || this.Lx.Lw.bJ == null) {
                                        return;
                                    }
                                    this.Lx.Lw.bJ.a(this.Lx.Lq);
                                }
                            }, this.Lw.mApkDownloadHelper, this.Lq.Mv, this.Lw.Ln);
                        }
                    }
                }
            };
            handler.post(runnable);
            cVar.a(null);
        }
    }

    @Override // com.kwad.sdk.core.webview.kwai.a
    @NonNull
    public final String getKey() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this)) == null) ? "convert" : (String) invokeV.objValue;
    }

    @Override // com.kwad.sdk.core.webview.kwai.a
    public final void onDestroy() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this) == null) {
            this.Ll.removeCallbacksAndMessages(null);
            this.bJ = null;
        }
    }
}
