package com.kwad.sdk.core.webview.jshandler;

import android.os.Handler;
import android.os.Looper;
import androidx.annotation.MainThread;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.annotation.WorkerThread;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import com.kwad.sdk.core.download.b.a;
import org.json.JSONException;
import org.json.JSONObject;
/* loaded from: classes10.dex */
public class a implements com.kwad.sdk.core.webview.a.a {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    /* renamed from: a  reason: collision with root package name */
    public final com.kwad.sdk.core.webview.a f72822a;

    /* renamed from: b  reason: collision with root package name */
    public Handler f72823b;

    /* renamed from: c  reason: collision with root package name */
    public boolean f72824c;
    @Nullable

    /* renamed from: d  reason: collision with root package name */
    public final com.kwad.sdk.core.download.b.b f72825d;
    @Nullable

    /* renamed from: e  reason: collision with root package name */
    public b f72826e;
    @Nullable

    /* renamed from: f  reason: collision with root package name */
    public c f72827f;

    /* renamed from: com.kwad.sdk.core.webview.jshandler.a$a  reason: collision with other inner class name */
    /* loaded from: classes10.dex */
    public static final class C2006a extends com.kwad.sdk.core.response.a.a implements com.kwad.sdk.core.b {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: a  reason: collision with root package name */
        public boolean f72833a;

        public C2006a() {
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
        void a(@Nullable C2006a c2006a);
    }

    /* loaded from: classes10.dex */
    public interface c {
        @MainThread
        void a(int i2);
    }

    /* JADX WARN: 'this' call moved to the top of the method (can break code semantics) */
    public a(@NonNull com.kwad.sdk.core.webview.a aVar, @Nullable com.kwad.sdk.core.download.b.b bVar, @Nullable b bVar2) {
        this(aVar, bVar, bVar2, false);
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {aVar, bVar, bVar2};
            interceptable.invokeUnInit(65536, newInitContext);
            int i2 = newInitContext.flag;
            if ((i2 & 1) != 0) {
                int i3 = i2 & 2;
                Object[] objArr2 = newInitContext.callArgs;
                this((com.kwad.sdk.core.webview.a) objArr2[0], (com.kwad.sdk.core.download.b.b) objArr2[1], (b) objArr2[2], ((Boolean) objArr2[3]).booleanValue());
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
    }

    public a(@NonNull com.kwad.sdk.core.webview.a aVar, @Nullable com.kwad.sdk.core.download.b.b bVar, @Nullable b bVar2, boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {aVar, bVar, bVar2, Boolean.valueOf(z)};
            interceptable.invokeUnInit(65537, newInitContext);
            int i2 = newInitContext.flag;
            if ((i2 & 1) != 0) {
                int i3 = i2 & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65537, newInitContext);
                return;
            }
        }
        this.f72824c = false;
        this.f72824c = z;
        this.f72823b = new Handler(Looper.getMainLooper());
        this.f72822a = aVar;
        this.f72825d = bVar;
        if (bVar != null) {
            bVar.a(1);
        }
        this.f72826e = bVar2;
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
        Handler handler;
        Runnable runnable;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, str, cVar) == null) {
            if (this.f72822a.f72777b == null) {
                cVar.a(-1, "native adTemplate is null");
                return;
            }
            C2006a c2006a = new C2006a();
            try {
                c2006a.parseJson(new JSONObject(str));
            } catch (JSONException e2) {
                com.kwad.sdk.core.d.a.a(e2);
            }
            if (!this.f72822a.f72783h) {
                if (this.f72826e != null) {
                    handler = this.f72823b;
                    runnable = new Runnable(this, c2006a) { // from class: com.kwad.sdk.core.webview.jshandler.a.2
                        public static /* synthetic */ Interceptable $ic;
                        public transient /* synthetic */ FieldHolder $fh;

                        /* renamed from: a  reason: collision with root package name */
                        public final /* synthetic */ C2006a f72831a;

                        /* renamed from: b  reason: collision with root package name */
                        public final /* synthetic */ a f72832b;

                        {
                            Interceptable interceptable2 = $ic;
                            if (interceptable2 != null) {
                                InitContext newInitContext = TitanRuntime.newInitContext();
                                newInitContext.initArgs = r2;
                                Object[] objArr = {this, c2006a};
                                interceptable2.invokeUnInit(65536, newInitContext);
                                int i2 = newInitContext.flag;
                                if ((i2 & 1) != 0) {
                                    int i3 = i2 & 2;
                                    newInitContext.thisArg = this;
                                    interceptable2.invokeInitBody(65536, newInitContext);
                                    return;
                                }
                            }
                            this.f72832b = this;
                            this.f72831a = c2006a;
                        }

                        @Override // java.lang.Runnable
                        public void run() {
                            Interceptable interceptable2 = $ic;
                            if (!(interceptable2 == null || interceptable2.invokeV(1048576, this) == null) || this.f72832b.f72826e == null) {
                                return;
                            }
                            this.f72832b.f72826e.a(this.f72831a);
                        }
                    };
                }
                cVar.a(null);
            }
            handler = this.f72823b;
            runnable = new Runnable(this, c2006a) { // from class: com.kwad.sdk.core.webview.jshandler.a.1
                public static /* synthetic */ Interceptable $ic;
                public transient /* synthetic */ FieldHolder $fh;

                /* renamed from: a  reason: collision with root package name */
                public final /* synthetic */ C2006a f72828a;

                /* renamed from: b  reason: collision with root package name */
                public final /* synthetic */ a f72829b;

                {
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 != null) {
                        InitContext newInitContext = TitanRuntime.newInitContext();
                        newInitContext.initArgs = r2;
                        Object[] objArr = {this, c2006a};
                        interceptable2.invokeUnInit(65536, newInitContext);
                        int i2 = newInitContext.flag;
                        if ((i2 & 1) != 0) {
                            int i3 = i2 & 2;
                            newInitContext.thisArg = this;
                            interceptable2.invokeInitBody(65536, newInitContext);
                            return;
                        }
                    }
                    this.f72829b = this;
                    this.f72828a = c2006a;
                }

                @Override // java.lang.Runnable
                public void run() {
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 == null || interceptable2.invokeV(1048576, this) == null) {
                        if (this.f72829b.f72822a.f72784i || this.f72828a.f72833a) {
                            int a2 = com.kwad.sdk.core.download.b.a.a(this.f72829b.f72822a.f72780e.getContext(), this.f72829b.f72822a.f72777b, new a.InterfaceC1992a(this) { // from class: com.kwad.sdk.core.webview.jshandler.a.1.1
                                public static /* synthetic */ Interceptable $ic;
                                public transient /* synthetic */ FieldHolder $fh;

                                /* renamed from: a  reason: collision with root package name */
                                public final /* synthetic */ AnonymousClass1 f72830a;

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
                                    this.f72830a = this;
                                }

                                @Override // com.kwad.sdk.core.download.b.a.InterfaceC1992a
                                public void a() {
                                    Interceptable interceptable3 = $ic;
                                    if (!(interceptable3 == null || interceptable3.invokeV(1048576, this) == null) || this.f72830a.f72829b.f72826e == null) {
                                        return;
                                    }
                                    this.f72830a.f72829b.f72826e.a(this.f72830a.f72828a);
                                }
                            }, this.f72829b.f72825d, this.f72828a.f72833a, this.f72829b.f72824c);
                            if (this.f72829b.f72827f != null) {
                                this.f72829b.f72827f.a(a2);
                            }
                        }
                    }
                }
            };
            handler.post(runnable);
            cVar.a(null);
        }
    }

    @Override // com.kwad.sdk.core.webview.a.a
    public void b() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this) == null) {
            this.f72823b.removeCallbacksAndMessages(null);
            this.f72826e = null;
        }
    }
}
