package com.kwad.components.core.webview.jshandler;

import android.os.Handler;
import android.os.Looper;
import android.text.TextUtils;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.core.view.InputDeviceCompat;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import com.kwad.components.core.c.a.a;
import com.kwad.sdk.core.report.u;
import com.kwad.sdk.core.response.model.AdTemplate;
import com.kwad.sdk.utils.y;
import java.util.ArrayList;
import java.util.List;
import org.json.JSONException;
import org.json.JSONObject;
/* loaded from: classes5.dex */
public final class d implements com.kwad.sdk.core.webview.kwai.a {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public final com.kwad.sdk.core.webview.b a;
    public Handler b;
    public int c;
    public boolean d;
    public final boolean e;
    public List<com.kwad.components.core.c.a.b> f;
    @Nullable
    public com.kwad.sdk.core.webview.a.kwai.a g;

    /* JADX WARN: 'this' call moved to the top of the method (can break code semantics) */
    public d(@NonNull com.kwad.sdk.core.webview.b bVar, @Nullable com.kwad.components.core.c.a.b bVar2, @Nullable com.kwad.sdk.core.webview.a.kwai.a aVar) {
        this(bVar, bVar2, aVar, false, 0, false);
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
                this((com.kwad.sdk.core.webview.b) objArr2[0], (com.kwad.components.core.c.a.b) objArr2[1], (com.kwad.sdk.core.webview.a.kwai.a) objArr2[2], ((Boolean) objArr2[3]).booleanValue(), ((Integer) objArr2[4]).intValue(), ((Boolean) objArr2[5]).booleanValue());
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
    }

    /* JADX WARN: 'this' call moved to the top of the method (can break code semantics) */
    public d(@NonNull com.kwad.sdk.core.webview.b bVar, @Nullable com.kwad.components.core.c.a.b bVar2, @Nullable com.kwad.sdk.core.webview.a.kwai.a aVar, int i) {
        this(bVar, bVar2, aVar, false, 1, false);
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {bVar, bVar2, aVar, Integer.valueOf(i)};
            interceptable.invokeUnInit(65537, newInitContext);
            int i2 = newInitContext.flag;
            if ((i2 & 1) != 0) {
                int i3 = i2 & 2;
                Object[] objArr2 = newInitContext.callArgs;
                this((com.kwad.sdk.core.webview.b) objArr2[0], (com.kwad.components.core.c.a.b) objArr2[1], (com.kwad.sdk.core.webview.a.kwai.a) objArr2[2], ((Boolean) objArr2[3]).booleanValue(), ((Integer) objArr2[4]).intValue(), ((Boolean) objArr2[5]).booleanValue());
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65537, newInitContext);
                return;
            }
        }
    }

    /* JADX WARN: 'this' call moved to the top of the method (can break code semantics) */
    public d(@NonNull com.kwad.sdk.core.webview.b bVar, @Nullable com.kwad.components.core.c.a.b bVar2, @Nullable com.kwad.sdk.core.webview.a.kwai.a aVar, int i, boolean z) {
        this(bVar, bVar2, null, false, 2, z);
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {bVar, bVar2, aVar, Integer.valueOf(i), Boolean.valueOf(z)};
            interceptable.invokeUnInit(65538, newInitContext);
            int i2 = newInitContext.flag;
            if ((i2 & 1) != 0) {
                int i3 = i2 & 2;
                Object[] objArr2 = newInitContext.callArgs;
                this((com.kwad.sdk.core.webview.b) objArr2[0], (com.kwad.components.core.c.a.b) objArr2[1], (com.kwad.sdk.core.webview.a.kwai.a) objArr2[2], ((Boolean) objArr2[3]).booleanValue(), ((Integer) objArr2[4]).intValue(), ((Boolean) objArr2[5]).booleanValue());
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65538, newInitContext);
                return;
            }
        }
    }

    public d(@NonNull com.kwad.sdk.core.webview.b bVar, @Nullable com.kwad.components.core.c.a.b bVar2, @Nullable com.kwad.sdk.core.webview.a.kwai.a aVar, boolean z, int i, boolean z2) {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {bVar, bVar2, aVar, Boolean.valueOf(z), Integer.valueOf(i), Boolean.valueOf(z2)};
            interceptable.invokeUnInit(65539, newInitContext);
            int i2 = newInitContext.flag;
            if ((i2 & 1) != 0) {
                int i3 = i2 & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65539, newInitContext);
                return;
            }
        }
        this.d = false;
        this.f = new ArrayList();
        this.d = z;
        this.b = new Handler(Looper.getMainLooper());
        this.a = bVar;
        this.c = i;
        if (bVar2 != null) {
            bVar2.a(1);
            this.f.add(bVar2);
        }
        this.g = aVar;
        this.e = z2;
    }

    /* JADX WARN: 'this' call moved to the top of the method (can break code semantics) */
    public d(@NonNull com.kwad.sdk.core.webview.b bVar, @Nullable List<com.kwad.components.core.c.a.b> list, @Nullable com.kwad.sdk.core.webview.a.kwai.a aVar) {
        this(bVar, null, aVar, false, 0, false);
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {bVar, list, aVar};
            interceptable.invokeUnInit(InputDeviceCompat.SOURCE_TRACKBALL, newInitContext);
            int i = newInitContext.flag;
            if ((i & 1) != 0) {
                int i2 = i & 2;
                Object[] objArr2 = newInitContext.callArgs;
                this((com.kwad.sdk.core.webview.b) objArr2[0], (com.kwad.components.core.c.a.b) objArr2[1], (com.kwad.sdk.core.webview.a.kwai.a) objArr2[2], ((Boolean) objArr2[3]).booleanValue(), ((Integer) objArr2[4]).intValue(), ((Boolean) objArr2[5]).booleanValue());
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(InputDeviceCompat.SOURCE_TRACKBALL, newInitContext);
                return;
            }
        }
        if (list != null) {
            this.f.addAll(list);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    @NonNull
    public u.b a(com.kwad.sdk.core.webview.a.a.a aVar, AdTemplate adTemplate) {
        InterceptResult invokeLL;
        com.kwad.sdk.core.webview.a.a.c cVar;
        int i;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(65542, this, aVar, adTemplate)) == null) {
            u.b bVar = new u.b();
            com.kwad.sdk.core.webview.a.a.c cVar2 = aVar.d;
            if (cVar2 != null && !TextUtils.isEmpty(cVar2.b)) {
                bVar.j = aVar.d.b;
            }
            com.kwad.sdk.core.webview.a.a.c cVar3 = aVar.d;
            if (cVar3 != null && (i = cVar3.a) != 0) {
                bVar.P = i;
            }
            if (!a(adTemplate) || (cVar = aVar.d) == null || cVar.c == null) {
                com.kwad.sdk.widget.e eVar = this.a.b;
                if (eVar != null) {
                    bVar.i = eVar.getTouchCoords();
                }
            } else {
                y.a aVar2 = new y.a();
                com.kwad.sdk.core.webview.a.a.b bVar2 = aVar.d.c;
                aVar2.b((float) bVar2.a, (float) bVar2.b);
                com.kwad.sdk.core.webview.a.a.b bVar3 = aVar.d.c;
                aVar2.a((float) bVar3.a, (float) bVar3.b);
                com.kwad.sdk.core.webview.a.a.b bVar4 = aVar.d.c;
                aVar2.a(bVar4.c, bVar4.d);
                bVar.i = aVar2;
            }
            return bVar;
        }
        return (u.b) invokeLL.objValue;
    }

    public static boolean a(AdTemplate adTemplate) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeL = interceptable.invokeL(65545, null, adTemplate)) == null) ? com.kwad.sdk.core.response.a.d.d(adTemplate) == 13 : invokeL.booleanValue;
    }

    public static boolean a(com.kwad.sdk.core.webview.a.a.a aVar) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeL = interceptable.invokeL(65546, null, aVar)) == null) ? aVar.c == 1 : invokeL.booleanValue;
    }

    @Nullable
    public final com.kwad.components.core.c.a.b a(long j) {
        InterceptResult invokeJ;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeJ = interceptable.invokeJ(1048576, this, j)) == null) {
            List<com.kwad.components.core.c.a.b> list = this.f;
            if (list == null) {
                return null;
            }
            if (j >= 0 || list.size() != 1) {
                for (com.kwad.components.core.c.a.b bVar : this.f) {
                    if (com.kwad.sdk.core.response.a.d.t(bVar.e()) == j) {
                        return bVar;
                    }
                }
                return null;
            }
            return this.f.get(0);
        }
        return (com.kwad.components.core.c.a.b) invokeJ.objValue;
    }

    @Override // com.kwad.sdk.core.webview.kwai.a
    @NonNull
    public final String a() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this)) == null) ? "clickAction" : (String) invokeV.objValue;
    }

    @Override // com.kwad.sdk.core.webview.kwai.a
    public final void a(String str, @NonNull com.kwad.sdk.core.webview.kwai.c cVar) {
        Handler handler;
        Runnable runnable;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(Constants.METHOD_SEND_USER_MSG, this, str, cVar) == null) {
            if (this.a.c()) {
                cVar.a(-1, "native adTemplate is null");
                return;
            }
            com.kwad.sdk.core.webview.a.a.a aVar = new com.kwad.sdk.core.webview.a.a.a();
            try {
                aVar.parseJson(new JSONObject(str));
            } catch (JSONException e) {
                com.kwad.sdk.core.d.b.a(e);
            }
            if (!this.a.g) {
                if (this.g != null) {
                    handler = this.b;
                    runnable = new Runnable(this, aVar) { // from class: com.kwad.components.core.webview.jshandler.d.2
                        public static /* synthetic */ Interceptable $ic;
                        public transient /* synthetic */ FieldHolder $fh;
                        public final /* synthetic */ com.kwad.sdk.core.webview.a.a.a a;
                        public final /* synthetic */ d b;

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
                            if (!(interceptable2 == null || interceptable2.invokeV(1048576, this) == null) || this.b.g == null) {
                                return;
                            }
                            this.b.g.a(this.a);
                        }
                    };
                }
                cVar.a(null);
            }
            handler = this.b;
            runnable = new Runnable(this, aVar) { // from class: com.kwad.components.core.webview.jshandler.d.1
                public static /* synthetic */ Interceptable $ic;
                public transient /* synthetic */ FieldHolder $fh;
                public final /* synthetic */ com.kwad.sdk.core.webview.a.a.a a;
                public final /* synthetic */ d b;

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
                    AdTemplate a;
                    Interceptable interceptable2 = $ic;
                    if ((interceptable2 == null || interceptable2.invokeV(1048576, this) == null) && this.b.a.h) {
                        int i = (this.a.f > 0L ? 1 : (this.a.f == 0L ? 0 : -1));
                        com.kwad.sdk.core.webview.b bVar = this.b.a;
                        if (i >= 0) {
                            List<AdTemplate> b = bVar.b();
                            com.kwad.sdk.core.webview.a.a.a aVar2 = this.a;
                            a = com.kwad.sdk.core.response.a.d.a(b, aVar2.f, aVar2.g);
                        } else {
                            a = bVar.a();
                        }
                        a.C0507a a2 = new a.C0507a(this.b.a.d.getContext()).a(a).a(this.b.a(this.a.f));
                        d dVar = this.b;
                        com.kwad.components.core.c.a.a.a(a2.a(d.a(this.a)).b(this.b.d).a(this.b.a.c).a(this.a.c).c(this.b.e || this.a.e).c(this.b.c).a(this.b.a(this.a, a)).a(new a.b(this) { // from class: com.kwad.components.core.webview.jshandler.d.1.1
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

                            @Override // com.kwad.components.core.c.a.a.b
                            public final void a() {
                                Interceptable interceptable3 = $ic;
                                if (!(interceptable3 == null || interceptable3.invokeV(1048576, this) == null) || this.a.b.g == null) {
                                    return;
                                }
                                this.a.b.g.a(this.a.a);
                            }
                        }));
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
        if (interceptable == null || interceptable.invokeV(1048579, this) == null) {
            this.b.removeCallbacksAndMessages(null);
            this.g = null;
        }
    }
}
