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
import com.kwad.sdk.utils.aa;
import java.util.ArrayList;
import java.util.List;
import org.json.JSONException;
import org.json.JSONObject;
/* loaded from: classes5.dex */
public class f implements com.kwad.sdk.core.webview.kwai.a {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public final com.kwad.sdk.core.webview.b Lk;
    public Handler Ll;
    public int Lm;
    public boolean Ln;
    public final boolean Lo;
    public List<com.kwad.components.core.c.a.c> Lp;
    @Nullable
    public com.kwad.sdk.core.webview.a.kwai.a bJ;

    /* JADX WARN: 'this' call moved to the top of the method (can break code semantics) */
    public f(@NonNull com.kwad.sdk.core.webview.b bVar, @Nullable com.kwad.components.core.c.a.c cVar, @Nullable com.kwad.sdk.core.webview.a.kwai.a aVar) {
        this(bVar, cVar, aVar, false, 0, false);
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
                this((com.kwad.sdk.core.webview.b) objArr2[0], (com.kwad.components.core.c.a.c) objArr2[1], (com.kwad.sdk.core.webview.a.kwai.a) objArr2[2], ((Boolean) objArr2[3]).booleanValue(), ((Integer) objArr2[4]).intValue(), ((Boolean) objArr2[5]).booleanValue());
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
    }

    /* JADX WARN: 'this' call moved to the top of the method (can break code semantics) */
    public f(@NonNull com.kwad.sdk.core.webview.b bVar, @Nullable com.kwad.components.core.c.a.c cVar, @Nullable com.kwad.sdk.core.webview.a.kwai.a aVar, int i) {
        this(bVar, cVar, aVar, false, 1, false);
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {bVar, cVar, aVar, Integer.valueOf(i)};
            interceptable.invokeUnInit(65537, newInitContext);
            int i2 = newInitContext.flag;
            if ((i2 & 1) != 0) {
                int i3 = i2 & 2;
                Object[] objArr2 = newInitContext.callArgs;
                this((com.kwad.sdk.core.webview.b) objArr2[0], (com.kwad.components.core.c.a.c) objArr2[1], (com.kwad.sdk.core.webview.a.kwai.a) objArr2[2], ((Boolean) objArr2[3]).booleanValue(), ((Integer) objArr2[4]).intValue(), ((Boolean) objArr2[5]).booleanValue());
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65537, newInitContext);
                return;
            }
        }
    }

    /* JADX WARN: 'this' call moved to the top of the method (can break code semantics) */
    public f(@NonNull com.kwad.sdk.core.webview.b bVar, @Nullable com.kwad.components.core.c.a.c cVar, @Nullable com.kwad.sdk.core.webview.a.kwai.a aVar, int i, boolean z) {
        this(bVar, cVar, null, false, 2, z);
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {bVar, cVar, aVar, Integer.valueOf(i), Boolean.valueOf(z)};
            interceptable.invokeUnInit(65538, newInitContext);
            int i2 = newInitContext.flag;
            if ((i2 & 1) != 0) {
                int i3 = i2 & 2;
                Object[] objArr2 = newInitContext.callArgs;
                this((com.kwad.sdk.core.webview.b) objArr2[0], (com.kwad.components.core.c.a.c) objArr2[1], (com.kwad.sdk.core.webview.a.kwai.a) objArr2[2], ((Boolean) objArr2[3]).booleanValue(), ((Integer) objArr2[4]).intValue(), ((Boolean) objArr2[5]).booleanValue());
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65538, newInitContext);
                return;
            }
        }
    }

    public f(@NonNull com.kwad.sdk.core.webview.b bVar, @Nullable com.kwad.components.core.c.a.c cVar, @Nullable com.kwad.sdk.core.webview.a.kwai.a aVar, boolean z, int i, boolean z2) {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {bVar, cVar, aVar, Boolean.valueOf(z), Integer.valueOf(i), Boolean.valueOf(z2)};
            interceptable.invokeUnInit(65539, newInitContext);
            int i2 = newInitContext.flag;
            if ((i2 & 1) != 0) {
                int i3 = i2 & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65539, newInitContext);
                return;
            }
        }
        this.Ln = false;
        this.Lp = new ArrayList();
        this.Ln = z;
        this.Ll = new Handler(Looper.getMainLooper());
        this.Lk = bVar;
        this.Lm = i;
        if (cVar != null) {
            cVar.ah(1);
            this.Lp.add(cVar);
        }
        this.bJ = aVar;
        this.Lo = z2;
    }

    /* JADX WARN: 'this' call moved to the top of the method (can break code semantics) */
    public f(@NonNull com.kwad.sdk.core.webview.b bVar, @Nullable List<com.kwad.components.core.c.a.c> list, @Nullable com.kwad.sdk.core.webview.a.kwai.a aVar) {
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
                this((com.kwad.sdk.core.webview.b) objArr2[0], (com.kwad.components.core.c.a.c) objArr2[1], (com.kwad.sdk.core.webview.a.kwai.a) objArr2[2], ((Boolean) objArr2[3]).booleanValue(), ((Integer) objArr2[4]).intValue(), ((Boolean) objArr2[5]).booleanValue());
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(InputDeviceCompat.SOURCE_TRACKBALL, newInitContext);
                return;
            }
        }
        if (list != null) {
            this.Lp.addAll(list);
        }
    }

    public static boolean S(AdTemplate adTemplate) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeL = interceptable.invokeL(65541, null, adTemplate)) == null) ? com.kwad.sdk.core.response.a.d.bL(adTemplate) == 13 : invokeL.booleanValue;
    }

    public static boolean b(com.kwad.sdk.core.webview.a.a.a aVar) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeL = interceptable.invokeL(65545, null, aVar)) == null) ? aVar.Mx == 1 : invokeL.booleanValue;
    }

    @NonNull
    public u.b a(com.kwad.sdk.core.webview.a.a.a aVar, AdTemplate adTemplate) {
        InterceptResult invokeLL;
        com.kwad.sdk.core.webview.a.a.c cVar;
        int i;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(1048576, this, aVar, adTemplate)) == null) {
            u.b bVar = new u.b();
            com.kwad.sdk.core.webview.a.a.c cVar2 = aVar.My;
            if (cVar2 != null && !TextUtils.isEmpty(cVar2.Mn)) {
                bVar.Mn = aVar.My.Mn;
            }
            com.kwad.sdk.core.webview.a.a.c cVar3 = aVar.My;
            if (cVar3 != null && (i = cVar3.agq) != 0) {
                bVar.acg = i;
            }
            if (!S(adTemplate) || (cVar = aVar.My) == null || cVar.agr == null) {
                com.kwad.sdk.widget.e eVar = this.Lk.agd;
                if (eVar != null) {
                    bVar.gL = eVar.getTouchCoords();
                }
            } else {
                aa.a aVar2 = new aa.a();
                com.kwad.sdk.core.webview.a.a.b bVar2 = aVar.My.agr;
                aVar2.f((float) bVar2.x, (float) bVar2.y);
                com.kwad.sdk.core.webview.a.a.b bVar3 = aVar.My.agr;
                aVar2.e((float) bVar3.x, (float) bVar3.y);
                com.kwad.sdk.core.webview.a.a.b bVar4 = aVar.My.agr;
                aVar2.q(bVar4.width, bVar4.height);
                bVar.gL = aVar2;
            }
            return bVar;
        }
        return (u.b) invokeLL.objValue;
    }

    @Override // com.kwad.sdk.core.webview.kwai.a
    public final void a(String str, @NonNull com.kwad.sdk.core.webview.kwai.c cVar) {
        Handler handler;
        Runnable runnable;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, str, cVar) == null) {
            if (this.Lk.wh()) {
                cVar.onError(-1, "native adTemplate is null");
                return;
            }
            com.kwad.sdk.core.webview.a.a.a aVar = new com.kwad.sdk.core.webview.a.a.a();
            try {
                aVar.parseJson(new JSONObject(str));
            } catch (JSONException e) {
                com.kwad.sdk.core.e.b.printStackTrace(e);
            }
            if (!this.Lk.agf) {
                if (this.bJ != null) {
                    handler = this.Ll;
                    runnable = new Runnable(this, aVar) { // from class: com.kwad.components.core.webview.jshandler.f.2
                        public static /* synthetic */ Interceptable $ic;
                        public transient /* synthetic */ FieldHolder $fh;
                        public final /* synthetic */ com.kwad.sdk.core.webview.a.a.a Lq;
                        public final /* synthetic */ f Lr;

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
                            this.Lr = this;
                            this.Lq = aVar;
                        }

                        @Override // java.lang.Runnable
                        public final void run() {
                            Interceptable interceptable2 = $ic;
                            if (!(interceptable2 == null || interceptable2.invokeV(1048576, this) == null) || this.Lr.bJ == null) {
                                return;
                            }
                            this.Lr.bJ.a(this.Lq);
                        }
                    };
                }
                cVar.a(null);
            }
            handler = this.Ll;
            runnable = new Runnable(this, aVar) { // from class: com.kwad.components.core.webview.jshandler.f.1
                public static /* synthetic */ Interceptable $ic;
                public transient /* synthetic */ FieldHolder $fh;
                public final /* synthetic */ com.kwad.sdk.core.webview.a.a.a Lq;
                public final /* synthetic */ f Lr;

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
                    this.Lr = this;
                    this.Lq = aVar;
                }

                @Override // java.lang.Runnable
                public final void run() {
                    AdTemplate adTemplate;
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 == null || interceptable2.invokeV(1048576, this) == null) {
                        com.kwad.sdk.core.webview.b bVar = this.Lr.Lk;
                        if (bVar.agg) {
                            if (this.Lq.creativeId >= 0) {
                                List<AdTemplate> wg = bVar.wg();
                                com.kwad.sdk.core.webview.a.a.a aVar2 = this.Lq;
                                adTemplate = com.kwad.sdk.core.response.a.d.a(wg, aVar2.creativeId, aVar2.adStyle);
                            } else {
                                adTemplate = bVar.getAdTemplate();
                            }
                            a.C0354a b = new a.C0354a(this.Lr.Lk.Gl.getContext()).L(adTemplate).b(this.Lr.s(this.Lq.creativeId));
                            f fVar = this.Lr;
                            com.kwad.components.core.c.a.a.a(b.aj(f.b(this.Lq)).ak(this.Lr.Ln).c(this.Lr.Lk.mReportExtData).ae(this.Lq.Mx).al(this.Lr.Lo || this.Lq.DZ).ag(this.Lr.Lm).a(this.Lr.a(this.Lq, adTemplate)).a(new a.b(this) { // from class: com.kwad.components.core.webview.jshandler.f.1.1
                                public static /* synthetic */ Interceptable $ic;
                                public transient /* synthetic */ FieldHolder $fh;
                                public final /* synthetic */ AnonymousClass1 Ls;

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
                                    this.Ls = this;
                                }

                                @Override // com.kwad.components.core.c.a.a.b
                                public final void onAdClicked() {
                                    Interceptable interceptable3 = $ic;
                                    if (interceptable3 == null || interceptable3.invokeV(1048576, this) == null) {
                                        this.Ls.Lr.ik();
                                        if (this.Ls.Lr.bJ != null) {
                                            this.Ls.Lr.bJ.a(this.Ls.Lq);
                                        }
                                    }
                                }
                            }));
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
        return (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this)) == null) ? "clickAction" : (String) invokeV.objValue;
    }

    public void ik() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048579, this) == null) {
        }
    }

    @Override // com.kwad.sdk.core.webview.kwai.a
    public final void onDestroy() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048580, this) == null) {
            this.Ll.removeCallbacksAndMessages(null);
            this.bJ = null;
        }
    }

    @Nullable
    public final com.kwad.components.core.c.a.c s(long j) {
        InterceptResult invokeJ;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeJ = interceptable.invokeJ(1048581, this, j)) == null) {
            List<com.kwad.components.core.c.a.c> list = this.Lp;
            if (list == null) {
                return null;
            }
            if (j >= 0 || list.size() != 1) {
                for (com.kwad.components.core.c.a.c cVar : this.Lp) {
                    if (com.kwad.sdk.core.response.a.d.ca(cVar.mQ()) == j) {
                        return cVar;
                    }
                }
                return null;
            }
            return this.Lp.get(0);
        }
        return (com.kwad.components.core.c.a.c) invokeJ.objValue;
    }
}
