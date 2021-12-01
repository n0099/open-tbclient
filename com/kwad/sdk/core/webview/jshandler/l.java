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
import com.kwad.sdk.core.download.a.a;
import com.kwad.sdk.core.report.p;
import com.kwad.sdk.core.response.model.AdTemplate;
import com.kwad.sdk.core.webview.jshandler.b;
import org.json.JSONException;
import org.json.JSONObject;
/* loaded from: classes2.dex */
public class l implements com.kwad.sdk.core.webview.kwai.a {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public final com.kwad.sdk.core.webview.a a;

    /* renamed from: b  reason: collision with root package name */
    public final Handler f58038b;
    @Nullable

    /* renamed from: c  reason: collision with root package name */
    public final b f58039c;

    /* loaded from: classes2.dex */
    public static final class a extends com.kwad.sdk.core.response.kwai.a {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public boolean a;

        /* renamed from: b  reason: collision with root package name */
        public String f58043b;

        /* renamed from: c  reason: collision with root package name */
        public int f58044c;

        /* renamed from: d  reason: collision with root package name */
        public b.C2032b f58045d;

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
    public interface b {
        @MainThread
        void a();
    }

    @Override // com.kwad.sdk.core.webview.kwai.a
    @NonNull
    public String a() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) ? "clickAction" : (String) invokeV.objValue;
    }

    @Override // com.kwad.sdk.core.webview.kwai.a
    public void a(String str, @NonNull com.kwad.sdk.core.webview.kwai.c cVar) {
        com.kwad.sdk.core.download.a.b bVar;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, str, cVar) == null) {
            a aVar = new a();
            AdTemplate adTemplate = new AdTemplate();
            try {
                aVar.parseJson(new JSONObject(str));
                adTemplate.parseJson(new JSONObject(aVar.f58043b));
            } catch (JSONException e2) {
                com.kwad.sdk.core.d.a.a(e2);
            }
            if (com.kwad.sdk.core.response.a.d.c(adTemplate)) {
                if (this.a.f57960g != null) {
                    bVar = this.a.f57960g.a(com.kwad.sdk.core.response.a.d.j(adTemplate).downloadId);
                } else {
                    bVar = null;
                }
                if (this.a.f57961h) {
                    this.f58038b.post(new Runnable(this, aVar, adTemplate, bVar) { // from class: com.kwad.sdk.core.webview.jshandler.l.1
                        public static /* synthetic */ Interceptable $ic;
                        public transient /* synthetic */ FieldHolder $fh;
                        public final /* synthetic */ a a;

                        /* renamed from: b  reason: collision with root package name */
                        public final /* synthetic */ AdTemplate f58040b;

                        /* renamed from: c  reason: collision with root package name */
                        public final /* synthetic */ com.kwad.sdk.core.download.a.b f58041c;

                        /* renamed from: d  reason: collision with root package name */
                        public final /* synthetic */ l f58042d;

                        {
                            Interceptable interceptable2 = $ic;
                            if (interceptable2 != null) {
                                InitContext newInitContext = TitanRuntime.newInitContext();
                                newInitContext.initArgs = r2;
                                Object[] objArr = {this, aVar, adTemplate, bVar};
                                interceptable2.invokeUnInit(65536, newInitContext);
                                int i2 = newInitContext.flag;
                                if ((i2 & 1) != 0) {
                                    int i3 = i2 & 2;
                                    newInitContext.thisArg = this;
                                    interceptable2.invokeInitBody(65536, newInitContext);
                                    return;
                                }
                            }
                            this.f58042d = this;
                            this.a = aVar;
                            this.f58040b = adTemplate;
                            this.f58041c = bVar;
                        }

                        @Override // java.lang.Runnable
                        public void run() {
                            Interceptable interceptable2 = $ic;
                            if (interceptable2 == null || interceptable2.invokeV(1048576, this) == null) {
                                p.a aVar2 = new p.a();
                                aVar2.f57687h = this.a.f58045d.a;
                                com.kwad.sdk.core.download.a.a.a(new a.C2015a(this.f58042d.a.f57957d.getContext()).a(this.f58040b).a(this.f58041c).a(this.a.f58044c).a(true).a(aVar2).c(true).a(new a.b(this) { // from class: com.kwad.sdk.core.webview.jshandler.l.1.1
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
                                            int i2 = newInitContext.flag;
                                            if ((i2 & 1) != 0) {
                                                int i3 = i2 & 2;
                                                newInitContext.thisArg = this;
                                                interceptable3.invokeInitBody(65536, newInitContext);
                                                return;
                                            }
                                        }
                                        this.a = this;
                                    }

                                    @Override // com.kwad.sdk.core.download.a.a.b
                                    public void a() {
                                        Interceptable interceptable3 = $ic;
                                        if (!(interceptable3 == null || interceptable3.invokeV(1048576, this) == null) || this.a.f58042d.f58039c == null) {
                                            return;
                                        }
                                        this.a.f58042d.f58039c.a();
                                    }
                                }));
                            }
                        }
                    });
                } else if (this.f58039c != null) {
                    this.f58038b.post(new Runnable(this) { // from class: com.kwad.sdk.core.webview.jshandler.l.2
                        public static /* synthetic */ Interceptable $ic;
                        public transient /* synthetic */ FieldHolder $fh;
                        public final /* synthetic */ l a;

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
                            this.a = this;
                        }

                        @Override // java.lang.Runnable
                        public void run() {
                            Interceptable interceptable2 = $ic;
                            if (!(interceptable2 == null || interceptable2.invokeV(1048576, this) == null) || this.a.f58039c == null) {
                                return;
                            }
                            this.a.f58039c.a();
                        }
                    });
                }
                cVar.a(null);
            }
        }
    }

    @Override // com.kwad.sdk.core.webview.kwai.a
    public void b() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this) == null) {
            this.f58038b.removeCallbacksAndMessages(null);
        }
    }
}
