package com.kwad.sdk.core.webview.jshandler;

import android.os.Handler;
import android.os.Looper;
import androidx.annotation.NonNull;
import androidx.annotation.WorkerThread;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import com.kwad.sdk.core.download.b.a;
import org.json.JSONObject;
/* loaded from: classes10.dex */
public class t implements com.kwad.sdk.core.webview.a.a {
    public static /* synthetic */ Interceptable $ic;

    /* renamed from: c  reason: collision with root package name */
    public static Handler f72959c;
    public transient /* synthetic */ FieldHolder $fh;

    /* renamed from: a  reason: collision with root package name */
    public com.kwad.sdk.core.webview.a f72960a;

    /* renamed from: b  reason: collision with root package name */
    public com.kwad.sdk.core.download.b.b f72961b;

    /* renamed from: d  reason: collision with root package name */
    public b f72962d;

    /* loaded from: classes10.dex */
    public static class a extends com.kwad.sdk.core.response.a.a implements com.kwad.sdk.core.b {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: a  reason: collision with root package name */
        public int f72966a;

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

    /* loaded from: classes10.dex */
    public interface b {
        @WorkerThread
        void a(int i2);
    }

    public t(com.kwad.sdk.core.webview.a aVar, com.kwad.sdk.core.download.b.b bVar, b bVar2) {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {aVar, bVar, bVar2};
            interceptable.invokeUnInit(65536, newInitContext);
            int i2 = newInitContext.flag;
            if ((i2 & 1) != 0) {
                int i3 = i2 & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
        this.f72960a = aVar;
        this.f72961b = bVar;
        this.f72962d = bVar2;
        if (f72959c == null) {
            f72959c = new Handler(Looper.getMainLooper());
        }
    }

    @Override // com.kwad.sdk.core.webview.a.a
    @NonNull
    public String a() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) ? "playableConvert" : (String) invokeV.objValue;
    }

    @Override // com.kwad.sdk.core.webview.a.a
    public void a(String str, @NonNull com.kwad.sdk.core.webview.a.c cVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, str, cVar) == null) {
            try {
                a aVar = new a();
                aVar.parseJson(new JSONObject(str));
                f72959c.post(new Runnable(this, aVar.f72966a) { // from class: com.kwad.sdk.core.webview.jshandler.t.1
                    public static /* synthetic */ Interceptable $ic;
                    public transient /* synthetic */ FieldHolder $fh;

                    /* renamed from: a  reason: collision with root package name */
                    public final /* synthetic */ int f72963a;

                    /* renamed from: b  reason: collision with root package name */
                    public final /* synthetic */ t f72964b;

                    {
                        Interceptable interceptable2 = $ic;
                        if (interceptable2 != null) {
                            InitContext newInitContext = TitanRuntime.newInitContext();
                            newInitContext.initArgs = r2;
                            Object[] objArr = {this, Integer.valueOf(r7)};
                            interceptable2.invokeUnInit(65536, newInitContext);
                            int i2 = newInitContext.flag;
                            if ((i2 & 1) != 0) {
                                int i3 = i2 & 2;
                                newInitContext.thisArg = this;
                                interceptable2.invokeInitBody(65536, newInitContext);
                                return;
                            }
                        }
                        this.f72964b = this;
                        this.f72963a = r7;
                    }

                    @Override // java.lang.Runnable
                    public void run() {
                        Interceptable interceptable2 = $ic;
                        if (interceptable2 == null || interceptable2.invokeV(1048576, this) == null) {
                            com.kwad.sdk.core.download.b.a.a(this.f72964b.f72960a.f72780e.getContext(), this.f72964b.f72960a.f72777b, new a.InterfaceC1992a(this) { // from class: com.kwad.sdk.core.webview.jshandler.t.1.1
                                public static /* synthetic */ Interceptable $ic;
                                public transient /* synthetic */ FieldHolder $fh;

                                /* renamed from: a  reason: collision with root package name */
                                public final /* synthetic */ AnonymousClass1 f72965a;

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
                                    this.f72965a = this;
                                }

                                @Override // com.kwad.sdk.core.download.b.a.InterfaceC1992a
                                public void a() {
                                    Interceptable interceptable3 = $ic;
                                    if (!(interceptable3 == null || interceptable3.invokeV(1048576, this) == null) || this.f72965a.f72964b.f72962d == null) {
                                        return;
                                    }
                                    this.f72965a.f72964b.f72962d.a(this.f72965a.f72963a);
                                }
                            }, this.f72964b.f72961b, false);
                        }
                    }
                });
            } catch (Exception e2) {
                com.kwad.sdk.core.d.a.a(e2);
            }
        }
    }

    @Override // com.kwad.sdk.core.webview.a.a
    public void b() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this) == null) {
        }
    }
}
