package com.kwad.sdk.core.webview.jshandler;

import android.os.Handler;
import androidx.annotation.MainThread;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import com.kwad.sdk.core.download.b.a;
import com.kwad.sdk.core.response.model.AdTemplate;
import org.json.JSONException;
import org.json.JSONObject;
/* loaded from: classes6.dex */
public class k implements com.kwad.sdk.core.webview.a.a {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    /* renamed from: a  reason: collision with root package name */
    public final com.kwad.sdk.core.webview.a f35413a;

    /* renamed from: b  reason: collision with root package name */
    public Handler f35414b;
    @Nullable

    /* renamed from: c  reason: collision with root package name */
    public b f35415c;

    /* loaded from: classes6.dex */
    public static final class a extends com.kwad.sdk.core.response.a.a implements com.kwad.sdk.core.b {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: a  reason: collision with root package name */
        public boolean f35421a;

        /* renamed from: b  reason: collision with root package name */
        public String f35422b;

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

    /* loaded from: classes6.dex */
    public interface b {
        @MainThread
        void a();
    }

    @Override // com.kwad.sdk.core.webview.a.a
    @NonNull
    public String a() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) ? "convert" : (String) invokeV.objValue;
    }

    @Override // com.kwad.sdk.core.webview.a.a
    public void a(String str, @NonNull com.kwad.sdk.core.webview.a.c cVar) {
        com.kwad.sdk.core.download.b.b bVar;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, str, cVar) == null) {
            a aVar = new a();
            AdTemplate adTemplate = new AdTemplate();
            try {
                aVar.parseJson(new JSONObject(str));
                adTemplate.parseJson(new JSONObject(aVar.f35422b));
            } catch (JSONException e2) {
                com.kwad.sdk.core.d.a.a(e2);
            }
            if (com.kwad.sdk.core.response.b.c.b(adTemplate)) {
                if (this.f35413a.f35293g != null) {
                    bVar = this.f35413a.f35293g.a(com.kwad.sdk.core.response.b.c.i(adTemplate).downloadId);
                } else {
                    bVar = null;
                }
                if (this.f35413a.f35294h) {
                    this.f35414b.post(new Runnable(this, adTemplate, bVar) { // from class: com.kwad.sdk.core.webview.jshandler.k.1
                        public static /* synthetic */ Interceptable $ic;
                        public transient /* synthetic */ FieldHolder $fh;

                        /* renamed from: a  reason: collision with root package name */
                        public final /* synthetic */ AdTemplate f35416a;

                        /* renamed from: b  reason: collision with root package name */
                        public final /* synthetic */ com.kwad.sdk.core.download.b.b f35417b;

                        /* renamed from: c  reason: collision with root package name */
                        public final /* synthetic */ k f35418c;

                        {
                            Interceptable interceptable2 = $ic;
                            if (interceptable2 != null) {
                                InitContext newInitContext = TitanRuntime.newInitContext();
                                newInitContext.initArgs = r2;
                                Object[] objArr = {this, adTemplate, bVar};
                                interceptable2.invokeUnInit(65536, newInitContext);
                                int i2 = newInitContext.flag;
                                if ((i2 & 1) != 0) {
                                    int i3 = i2 & 2;
                                    newInitContext.thisArg = this;
                                    interceptable2.invokeInitBody(65536, newInitContext);
                                    return;
                                }
                            }
                            this.f35418c = this;
                            this.f35416a = adTemplate;
                            this.f35417b = bVar;
                        }

                        @Override // java.lang.Runnable
                        public void run() {
                            Interceptable interceptable2 = $ic;
                            if (interceptable2 == null || interceptable2.invokeV(1048576, this) == null) {
                                com.kwad.sdk.core.download.b.a.a(this.f35418c.f35413a.f35291e.getContext(), this.f35416a, new a.InterfaceC0415a(this) { // from class: com.kwad.sdk.core.webview.jshandler.k.1.1
                                    public static /* synthetic */ Interceptable $ic;
                                    public transient /* synthetic */ FieldHolder $fh;

                                    /* renamed from: a  reason: collision with root package name */
                                    public final /* synthetic */ AnonymousClass1 f35419a;

                                    {
                                        Interceptable interceptable3 = $ic;
                                        if (interceptable3 != null) {
                                            InitContext newInitContext = TitanRuntime.newInitContext();
                                            newInitContext.initArgs = r2;
                                            Object[] objArr = {this};
                                            interceptable3.invokeUnInit(65536, newInitContext);
                                            int i2 = newInitContext.flag;
                                            if ((i2 & 1) != 0) {
                                                int i3 = i2 & 2;
                                                newInitContext.thisArg = this;
                                                interceptable3.invokeInitBody(65536, newInitContext);
                                                return;
                                            }
                                        }
                                        this.f35419a = this;
                                    }

                                    @Override // com.kwad.sdk.core.download.b.a.InterfaceC0415a
                                    public void a() {
                                        Interceptable interceptable3 = $ic;
                                        if (!(interceptable3 == null || interceptable3.invokeV(1048576, this) == null) || this.f35419a.f35418c.f35415c == null) {
                                            return;
                                        }
                                        this.f35419a.f35418c.f35415c.a();
                                    }
                                }, this.f35417b, true);
                            }
                        }
                    });
                } else if (this.f35415c != null) {
                    this.f35414b.post(new Runnable(this) { // from class: com.kwad.sdk.core.webview.jshandler.k.2
                        public static /* synthetic */ Interceptable $ic;
                        public transient /* synthetic */ FieldHolder $fh;

                        /* renamed from: a  reason: collision with root package name */
                        public final /* synthetic */ k f35420a;

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
                            this.f35420a = this;
                        }

                        @Override // java.lang.Runnable
                        public void run() {
                            Interceptable interceptable2 = $ic;
                            if (!(interceptable2 == null || interceptable2.invokeV(1048576, this) == null) || this.f35420a.f35415c == null) {
                                return;
                            }
                            this.f35420a.f35415c.a();
                        }
                    });
                }
                cVar.a(null);
            }
        }
    }

    @Override // com.kwad.sdk.core.webview.a.a
    public void b() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this) == null) {
            this.f35414b.removeCallbacksAndMessages(null);
        }
    }
}
