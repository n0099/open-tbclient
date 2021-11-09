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
/* loaded from: classes2.dex */
public class a implements com.kwad.sdk.core.webview.a.a {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    /* renamed from: a  reason: collision with root package name */
    public final com.kwad.sdk.core.webview.a f65271a;

    /* renamed from: b  reason: collision with root package name */
    public Handler f65272b;

    /* renamed from: c  reason: collision with root package name */
    public boolean f65273c;
    @Nullable

    /* renamed from: d  reason: collision with root package name */
    public final com.kwad.sdk.core.download.b.b f65274d;
    @Nullable

    /* renamed from: e  reason: collision with root package name */
    public b f65275e;
    @Nullable

    /* renamed from: f  reason: collision with root package name */
    public c f65276f;

    /* renamed from: com.kwad.sdk.core.webview.jshandler.a$a  reason: collision with other inner class name */
    /* loaded from: classes2.dex */
    public static final class C1916a extends com.kwad.sdk.core.response.a.a implements com.kwad.sdk.core.b {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: a  reason: collision with root package name */
        public boolean f65282a;

        public C1916a() {
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
        @WorkerThread
        void a(@Nullable C1916a c1916a);
    }

    /* loaded from: classes2.dex */
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
        this.f65273c = false;
        this.f65273c = z;
        this.f65272b = new Handler(Looper.getMainLooper());
        this.f65271a = aVar;
        this.f65274d = bVar;
        if (bVar != null) {
            bVar.a(1);
        }
        this.f65275e = bVar2;
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
            if (this.f65271a.f65226b == null) {
                cVar.a(-1, "native adTemplate is null");
                return;
            }
            C1916a c1916a = new C1916a();
            try {
                c1916a.parseJson(new JSONObject(str));
            } catch (JSONException e2) {
                com.kwad.sdk.core.d.a.a(e2);
            }
            if (!this.f65271a.f65232h) {
                if (this.f65275e != null) {
                    handler = this.f65272b;
                    runnable = new Runnable(this, c1916a) { // from class: com.kwad.sdk.core.webview.jshandler.a.2
                        public static /* synthetic */ Interceptable $ic;
                        public transient /* synthetic */ FieldHolder $fh;

                        /* renamed from: a  reason: collision with root package name */
                        public final /* synthetic */ C1916a f65280a;

                        /* renamed from: b  reason: collision with root package name */
                        public final /* synthetic */ a f65281b;

                        {
                            Interceptable interceptable2 = $ic;
                            if (interceptable2 != null) {
                                InitContext newInitContext = TitanRuntime.newInitContext();
                                newInitContext.initArgs = r2;
                                Object[] objArr = {this, c1916a};
                                interceptable2.invokeUnInit(65536, newInitContext);
                                int i2 = newInitContext.flag;
                                if ((i2 & 1) != 0) {
                                    int i3 = i2 & 2;
                                    newInitContext.thisArg = this;
                                    interceptable2.invokeInitBody(65536, newInitContext);
                                    return;
                                }
                            }
                            this.f65281b = this;
                            this.f65280a = c1916a;
                        }

                        @Override // java.lang.Runnable
                        public void run() {
                            Interceptable interceptable2 = $ic;
                            if (!(interceptable2 == null || interceptable2.invokeV(1048576, this) == null) || this.f65281b.f65275e == null) {
                                return;
                            }
                            this.f65281b.f65275e.a(this.f65280a);
                        }
                    };
                }
                cVar.a(null);
            }
            handler = this.f65272b;
            runnable = new Runnable(this, c1916a) { // from class: com.kwad.sdk.core.webview.jshandler.a.1
                public static /* synthetic */ Interceptable $ic;
                public transient /* synthetic */ FieldHolder $fh;

                /* renamed from: a  reason: collision with root package name */
                public final /* synthetic */ C1916a f65277a;

                /* renamed from: b  reason: collision with root package name */
                public final /* synthetic */ a f65278b;

                {
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 != null) {
                        InitContext newInitContext = TitanRuntime.newInitContext();
                        newInitContext.initArgs = r2;
                        Object[] objArr = {this, c1916a};
                        interceptable2.invokeUnInit(65536, newInitContext);
                        int i2 = newInitContext.flag;
                        if ((i2 & 1) != 0) {
                            int i3 = i2 & 2;
                            newInitContext.thisArg = this;
                            interceptable2.invokeInitBody(65536, newInitContext);
                            return;
                        }
                    }
                    this.f65278b = this;
                    this.f65277a = c1916a;
                }

                @Override // java.lang.Runnable
                public void run() {
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 == null || interceptable2.invokeV(1048576, this) == null) {
                        if (this.f65278b.f65271a.f65233i || this.f65277a.f65282a) {
                            int a2 = com.kwad.sdk.core.download.b.a.a(this.f65278b.f65271a.f65229e.getContext(), this.f65278b.f65271a.f65226b, new a.InterfaceC1901a(this) { // from class: com.kwad.sdk.core.webview.jshandler.a.1.1
                                public static /* synthetic */ Interceptable $ic;
                                public transient /* synthetic */ FieldHolder $fh;

                                /* renamed from: a  reason: collision with root package name */
                                public final /* synthetic */ AnonymousClass1 f65279a;

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
                                    this.f65279a = this;
                                }

                                @Override // com.kwad.sdk.core.download.b.a.InterfaceC1901a
                                public void a() {
                                    Interceptable interceptable3 = $ic;
                                    if (!(interceptable3 == null || interceptable3.invokeV(1048576, this) == null) || this.f65279a.f65278b.f65275e == null) {
                                        return;
                                    }
                                    this.f65279a.f65278b.f65275e.a(this.f65279a.f65277a);
                                }
                            }, this.f65278b.f65274d, this.f65277a.f65282a, this.f65278b.f65273c);
                            if (this.f65278b.f65276f != null) {
                                this.f65278b.f65276f.a(a2);
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
            this.f65272b.removeCallbacksAndMessages(null);
            this.f65275e = null;
        }
    }
}
