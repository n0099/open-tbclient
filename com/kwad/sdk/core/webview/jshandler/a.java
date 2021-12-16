package com.kwad.sdk.core.webview.jshandler;

import android.os.Handler;
import android.os.Looper;
import android.text.TextUtils;
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
import com.kwad.sdk.core.view.AdBaseFrameLayout;
import com.kwad.sdk.core.webview.jshandler.b;
import java.util.ArrayList;
import java.util.List;
import org.json.JSONException;
import org.json.JSONObject;
/* loaded from: classes3.dex */
public class a implements com.kwad.sdk.core.webview.kwai.a {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public final com.kwad.sdk.core.webview.a a;

    /* renamed from: b  reason: collision with root package name */
    public Handler f58552b;

    /* renamed from: c  reason: collision with root package name */
    public boolean f58553c;

    /* renamed from: d  reason: collision with root package name */
    public List<com.kwad.sdk.core.download.a.b> f58554d;
    @Nullable

    /* renamed from: e  reason: collision with root package name */
    public b.c f58555e;
    @Nullable

    /* renamed from: f  reason: collision with root package name */
    public b.d f58556f;

    /* JADX WARN: 'this' call moved to the top of the method (can break code semantics) */
    public a(@NonNull com.kwad.sdk.core.webview.a aVar, @Nullable com.kwad.sdk.core.download.a.b bVar, @Nullable b.c cVar) {
        this(aVar, bVar, cVar, false);
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {aVar, bVar, cVar};
            interceptable.invokeUnInit(65536, newInitContext);
            int i2 = newInitContext.flag;
            if ((i2 & 1) != 0) {
                int i3 = i2 & 2;
                Object[] objArr2 = newInitContext.callArgs;
                this((com.kwad.sdk.core.webview.a) objArr2[0], (com.kwad.sdk.core.download.a.b) objArr2[1], (b.c) objArr2[2], ((Boolean) objArr2[3]).booleanValue());
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
    }

    public a(@NonNull com.kwad.sdk.core.webview.a aVar, @Nullable com.kwad.sdk.core.download.a.b bVar, @Nullable b.c cVar, boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {aVar, bVar, cVar, Boolean.valueOf(z)};
            interceptable.invokeUnInit(65537, newInitContext);
            int i2 = newInitContext.flag;
            if ((i2 & 1) != 0) {
                int i3 = i2 & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65537, newInitContext);
                return;
            }
        }
        this.f58553c = false;
        this.f58554d = new ArrayList();
        this.f58553c = z;
        this.f58552b = new Handler(Looper.getMainLooper());
        this.a = aVar;
        if (bVar != null) {
            bVar.a(1);
            this.f58554d.add(bVar);
        }
        this.f58555e = cVar;
    }

    /* JADX WARN: 'this' call moved to the top of the method (can break code semantics) */
    public a(@NonNull com.kwad.sdk.core.webview.a aVar, @Nullable List<com.kwad.sdk.core.download.a.b> list, @Nullable b.c cVar) {
        this(aVar, null, cVar, false);
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {aVar, list, cVar};
            interceptable.invokeUnInit(65538, newInitContext);
            int i2 = newInitContext.flag;
            if ((i2 & 1) != 0) {
                int i3 = i2 & 2;
                Object[] objArr2 = newInitContext.callArgs;
                this((com.kwad.sdk.core.webview.a) objArr2[0], (com.kwad.sdk.core.download.a.b) objArr2[1], (b.c) objArr2[2], ((Boolean) objArr2[3]).booleanValue());
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65538, newInitContext);
                return;
            }
        }
        if (list != null) {
            this.f58554d.addAll(list);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public boolean a(b.a aVar) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeL = interceptable.invokeL(65541, this, aVar)) == null) ? aVar.f58569c == 1 : invokeL.booleanValue;
    }

    @Nullable
    public com.kwad.sdk.core.download.a.b a(long j2) {
        InterceptResult invokeJ;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeJ = interceptable.invokeJ(1048576, this, j2)) == null) {
            List<com.kwad.sdk.core.download.a.b> list = this.f58554d;
            if (list == null) {
                return null;
            }
            if (j2 >= 0 || list.size() != 1) {
                for (com.kwad.sdk.core.download.a.b bVar : this.f58554d) {
                    if (com.kwad.sdk.core.response.a.d.y(bVar.e()) == j2) {
                        return bVar;
                    }
                }
                return null;
            }
            return this.f58554d.get(0);
        }
        return (com.kwad.sdk.core.download.a.b) invokeJ.objValue;
    }

    @Override // com.kwad.sdk.core.webview.kwai.a
    @NonNull
    public String a() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this)) == null) ? "clickAction" : (String) invokeV.objValue;
    }

    @Override // com.kwad.sdk.core.webview.kwai.a
    public void a(String str, @NonNull com.kwad.sdk.core.webview.kwai.c cVar) {
        Handler handler;
        Runnable runnable;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(Constants.METHOD_SEND_USER_MSG, this, str, cVar) == null) {
            if (this.a.c()) {
                cVar.a(-1, "native adTemplate is null");
                return;
            }
            b.a aVar = new b.a();
            try {
                aVar.parseJson(new JSONObject(str));
            } catch (JSONException e2) {
                com.kwad.sdk.core.d.a.a(e2);
            }
            if (!this.a.f58542h) {
                if (this.f58555e != null) {
                    handler = this.f58552b;
                    runnable = new Runnable(this, aVar) { // from class: com.kwad.sdk.core.webview.jshandler.a.2
                        public static /* synthetic */ Interceptable $ic;
                        public transient /* synthetic */ FieldHolder $fh;
                        public final /* synthetic */ b.a a;

                        /* renamed from: b  reason: collision with root package name */
                        public final /* synthetic */ a f58558b;

                        {
                            Interceptable interceptable2 = $ic;
                            if (interceptable2 != null) {
                                InitContext newInitContext = TitanRuntime.newInitContext();
                                newInitContext.initArgs = r2;
                                Object[] objArr = {this, aVar};
                                interceptable2.invokeUnInit(65536, newInitContext);
                                int i2 = newInitContext.flag;
                                if ((i2 & 1) != 0) {
                                    int i3 = i2 & 2;
                                    newInitContext.thisArg = this;
                                    interceptable2.invokeInitBody(65536, newInitContext);
                                    return;
                                }
                            }
                            this.f58558b = this;
                            this.a = aVar;
                        }

                        @Override // java.lang.Runnable
                        public void run() {
                            Interceptable interceptable2 = $ic;
                            if (!(interceptable2 == null || interceptable2.invokeV(1048576, this) == null) || this.f58558b.f58555e == null) {
                                return;
                            }
                            this.f58558b.f58555e.a(this.a);
                        }
                    };
                }
                cVar.a(null);
            }
            handler = this.f58552b;
            runnable = new Runnable(this, aVar) { // from class: com.kwad.sdk.core.webview.jshandler.a.1
                public static /* synthetic */ Interceptable $ic;
                public transient /* synthetic */ FieldHolder $fh;
                public final /* synthetic */ b.a a;

                /* renamed from: b  reason: collision with root package name */
                public final /* synthetic */ a f58557b;

                {
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 != null) {
                        InitContext newInitContext = TitanRuntime.newInitContext();
                        newInitContext.initArgs = r2;
                        Object[] objArr = {this, aVar};
                        interceptable2.invokeUnInit(65536, newInitContext);
                        int i2 = newInitContext.flag;
                        if ((i2 & 1) != 0) {
                            int i3 = i2 & 2;
                            newInitContext.thisArg = this;
                            interceptable2.invokeInitBody(65536, newInitContext);
                            return;
                        }
                    }
                    this.f58557b = this;
                    this.a = aVar;
                }

                @Override // java.lang.Runnable
                public void run() {
                    Interceptable interceptable2 = $ic;
                    if ((interceptable2 == null || interceptable2.invokeV(1048576, this) == null) && this.f58557b.a.f58543i) {
                        p.a aVar2 = new p.a();
                        b.C2093b c2093b = this.a.f58570d;
                        if (c2093b != null && !TextUtils.isEmpty(c2093b.a)) {
                            aVar2.f58268h = this.a.f58570d.a;
                        }
                        AdBaseFrameLayout adBaseFrameLayout = this.f58557b.a.f58536b;
                        if (adBaseFrameLayout != null) {
                            aVar2.f58267g = adBaseFrameLayout.getTouchCoords();
                        }
                        int i2 = (this.a.f58571e > 0L ? 1 : (this.a.f58571e == 0L ? 0 : -1));
                        com.kwad.sdk.core.webview.a aVar3 = this.f58557b.a;
                        int a = com.kwad.sdk.core.download.a.a.a(new a.C2076a(this.f58557b.a.f58538d.getContext()).a(i2 >= 0 ? aVar3.a(this.a.f58571e) : aVar3.a()).a(this.f58557b.a(this.a.f58571e)).a(this.f58557b.a(this.a)).b(this.f58557b.f58553c).a(this.f58557b.a.f58537c).a(this.a.f58569c).c(true).a(aVar2).a(new a.b(this) { // from class: com.kwad.sdk.core.webview.jshandler.a.1.1
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
                                    int i3 = newInitContext.flag;
                                    if ((i3 & 1) != 0) {
                                        int i4 = i3 & 2;
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
                                if (!(interceptable3 == null || interceptable3.invokeV(1048576, this) == null) || this.a.f58557b.f58555e == null) {
                                    return;
                                }
                                this.a.f58557b.f58555e.a(this.a.a);
                            }
                        }));
                        if (this.f58557b.f58556f != null) {
                            this.f58557b.f58556f.a(a);
                        }
                    }
                }
            };
            handler.post(runnable);
            cVar.a(null);
        }
    }

    @Override // com.kwad.sdk.core.webview.kwai.a
    public void b() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048579, this) == null) {
            this.f58552b.removeCallbacksAndMessages(null);
            this.f58555e = null;
        }
    }
}
