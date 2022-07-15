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
public final class f implements com.kwad.sdk.core.webview.kwai.a {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public final com.kwad.sdk.core.webview.b a;
    public Handler b;
    public boolean c;
    @Nullable
    public final com.kwad.components.core.c.a.b d;
    @Nullable
    public com.kwad.sdk.core.webview.a.kwai.a e;

    /* JADX WARN: 'this' call moved to the top of the method (can break code semantics) */
    public f(@NonNull com.kwad.sdk.core.webview.b bVar, @Nullable com.kwad.components.core.c.a.b bVar2, @Nullable com.kwad.sdk.core.webview.a.kwai.a aVar) {
        this(bVar, bVar2, aVar, false);
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {bVar, bVar2, aVar};
            interceptable.invokeUnInit(65536, newInitContext);
            int i = newInitContext.flag;
            if ((i & 1) != 0) {
                int i2 = i & 2;
                Object[] objArr2 = newInitContext.callArgs;
                this((com.kwad.sdk.core.webview.b) objArr2[0], (com.kwad.components.core.c.a.b) objArr2[1], (com.kwad.sdk.core.webview.a.kwai.a) objArr2[2], ((Boolean) objArr2[3]).booleanValue());
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
    }

    public f(@NonNull com.kwad.sdk.core.webview.b bVar, @Nullable com.kwad.components.core.c.a.b bVar2, @Nullable com.kwad.sdk.core.webview.a.kwai.a aVar, boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {bVar, bVar2, aVar, Boolean.valueOf(z)};
            interceptable.invokeUnInit(65537, newInitContext);
            int i = newInitContext.flag;
            if ((i & 1) != 0) {
                int i2 = i & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65537, newInitContext);
                return;
            }
        }
        this.c = false;
        this.c = z;
        this.b = new Handler(Looper.getMainLooper());
        this.a = bVar;
        this.d = bVar2;
        if (bVar2 != null) {
            bVar2.a(1);
        }
        this.e = aVar;
    }

    @Override // com.kwad.sdk.core.webview.kwai.a
    @NonNull
    public final String a() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) ? "convert" : (String) invokeV.objValue;
    }

    @Override // com.kwad.sdk.core.webview.kwai.a
    public final void a(String str, @NonNull com.kwad.sdk.core.webview.kwai.c cVar) {
        Handler handler;
        Runnable runnable;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, str, cVar) == null) {
            if (this.a.c()) {
                cVar.a(-1, "native adTemplate is null");
                return;
            }
            com.kwad.sdk.core.webview.a.a.a aVar = new com.kwad.sdk.core.webview.a.a.a();
            try {
                aVar.parseJson(new JSONObject(str));
                aVar.a = true;
            } catch (JSONException e) {
                com.kwad.sdk.core.d.b.a(e);
            }
            if (!this.a.g) {
                if (this.e != null) {
                    handler = this.b;
                    runnable = new Runnable(this, aVar) { // from class: com.kwad.components.core.webview.jshandler.f.2
                        public static /* synthetic */ Interceptable $ic;
                        public transient /* synthetic */ FieldHolder $fh;
                        public final /* synthetic */ com.kwad.sdk.core.webview.a.a.a a;
                        public final /* synthetic */ f b;

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
                            this.b = this;
                            this.a = aVar;
                        }

                        @Override // java.lang.Runnable
                        public final void run() {
                            Interceptable interceptable2 = $ic;
                            if (!(interceptable2 == null || interceptable2.invokeV(1048576, this) == null) || this.b.e == null) {
                                return;
                            }
                            this.b.e.a(this.a);
                        }
                    };
                }
                cVar.a(null);
            }
            handler = this.b;
            runnable = new Runnable(this, aVar) { // from class: com.kwad.components.core.webview.jshandler.f.1
                public static /* synthetic */ Interceptable $ic;
                public transient /* synthetic */ FieldHolder $fh;
                public final /* synthetic */ com.kwad.sdk.core.webview.a.a.a a;
                public final /* synthetic */ f b;

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
                    this.b = this;
                    this.a = aVar;
                }

                @Override // java.lang.Runnable
                public final void run() {
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 == null || interceptable2.invokeV(1048576, this) == null) {
                        if (this.b.a.h || this.a.b) {
                            com.kwad.components.core.c.a.a.a(this.b.a.d.getContext(), this.b.a.a(), new a.b(this) { // from class: com.kwad.components.core.webview.jshandler.f.1.1
                                public static /* synthetic */ Interceptable $ic;
                                public transient /* synthetic */ FieldHolder $fh;
                                public final /* synthetic */ AnonymousClass1 a;

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
                                    this.a = this;
                                }

                                @Override // com.kwad.components.core.c.a.a.b
                                public final void a() {
                                    Interceptable interceptable3 = $ic;
                                    if (!(interceptable3 == null || interceptable3.invokeV(1048576, this) == null) || this.a.b.e == null) {
                                        return;
                                    }
                                    this.a.b.e.a(this.a.a);
                                }
                            }, this.b.d, this.a.b, this.b.c);
                        }
                    }
                }
            };
            handler.post(runnable);
            cVar.a(null);
        }
    }

    @Override // com.kwad.sdk.core.webview.kwai.a
    public final void b() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this) == null) {
            this.b.removeCallbacksAndMessages(null);
            this.e = null;
        }
    }
}
