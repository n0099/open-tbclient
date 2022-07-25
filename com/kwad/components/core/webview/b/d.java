package com.kwad.components.core.webview.b;

import android.app.Activity;
import android.content.Context;
import android.os.SystemClock;
import android.text.TextUtils;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import com.kwad.components.core.offline.init.kwai.i;
import com.kwad.components.core.page.SimpleWebViewActivity;
import com.kwad.components.core.webview.b.a.f;
import com.kwad.components.core.webview.b.a.p;
import com.kwad.components.core.webview.b.a.q;
import com.kwad.components.core.webview.b.a.s;
import com.kwad.components.core.webview.b.b.d;
import com.kwad.components.core.webview.b.kwai.j;
import com.kwad.components.core.webview.b.kwai.l;
import com.kwad.components.core.webview.b.kwai.m;
import com.kwad.components.core.webview.b.kwai.n;
import com.kwad.components.core.webview.jshandler.aa;
import com.kwad.components.core.webview.jshandler.ac;
import com.kwad.components.core.webview.jshandler.k;
import com.kwad.components.core.webview.jshandler.r;
import com.kwad.components.core.webview.jshandler.x;
import com.kwad.components.offline.api.core.api.ILoggerReporter;
import com.kwad.components.offline.api.tk.ITkOfflineCompo;
import com.kwad.components.offline.api.tk.TkLoggerReporter;
import com.kwad.components.offline.api.tk.model.StyleTemplate;
import com.kwad.components.offline.api.tk.model.report.TKPerformMsg;
import com.kwad.sdk.components.h;
import com.kwad.sdk.core.download.g;
import com.kwad.sdk.core.imageloader.utils.IoUtils;
import com.kwad.sdk.core.response.model.AdTemplate;
import com.kwad.sdk.utils.ag;
import com.kwad.sdk.utils.bd;
import com.kwad.sdk.utils.o;
import com.kwad.sdk.utils.t;
import java.io.File;
import java.io.FileInputStream;
import java.util.concurrent.Future;
/* loaded from: classes5.dex */
public class d {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public com.kwad.components.core.webview.b.b.d Ne;
    public e Nf;
    public com.kwad.components.core.offline.api.kwai.a Ng;
    public Future<?> Nh;
    public h Ni;
    public j Nj;
    public g Nk;
    public StyleTemplate Nl;
    public long Nm;
    public boolean Nn;
    public boolean No;
    public boolean Np;
    public boolean Nq;
    public long Nr;
    public long Ns;
    public long Nt;
    public final Runnable Nu;
    public Activity mActivity;
    public AdTemplate mAdTemplate;
    public final Context mContext;
    public long tS;
    public final s tb;
    public final com.kwad.components.core.video.h td;

    /* renamed from: com.kwad.components.core.webview.b.d$1  reason: invalid class name */
    /* loaded from: classes5.dex */
    public class AnonymousClass1 implements Runnable {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ d Nv;

        public AnonymousClass1(d dVar) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {dVar};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.Nv = dVar;
        }

        @Override // java.lang.Runnable
        public final void run() {
            String str;
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                this.Nv.Nm = SystemClock.elapsedRealtime();
                com.kwad.sdk.core.e.b.d("TKLoadController", "开始读取模板 id: " + this.Nv.Nf.bZ());
                StyleTemplate loadTkFileByTemplateId = this.Nv.Ng.loadTkFileByTemplateId(this.Nv.mContext, this.Nv.Nf.bZ());
                StringBuilder sb = new StringBuilder("读取完毕，总耗时");
                sb.append(SystemClock.elapsedRealtime() - this.Nv.Nm);
                sb.append(", 读取");
                if (loadTkFileByTemplateId == null) {
                    str = "失败";
                } else {
                    str = "成功" + loadTkFileByTemplateId.toJson() + AnonymousClass1.class.getSimpleName();
                }
                sb.append(str);
                com.kwad.sdk.core.e.b.d("TKLoadController", sb.toString());
                if (this.Nv.Nn) {
                    return;
                }
                com.kwad.sdk.core.e.b.d("TKLoadController", "没有超时");
                bd.c(this.Nv.Nu);
                bd.runOnUiThread(new Runnable(this, loadTkFileByTemplateId) { // from class: com.kwad.components.core.webview.b.d.1.1
                    public static /* synthetic */ Interceptable $ic;
                    public transient /* synthetic */ FieldHolder $fh;
                    public final /* synthetic */ StyleTemplate Nw;
                    public final /* synthetic */ AnonymousClass1 Nx;

                    {
                        Interceptable interceptable2 = $ic;
                        if (interceptable2 != null) {
                            InitContext newInitContext = TitanRuntime.newInitContext();
                            newInitContext.initArgs = r2;
                            Object[] objArr = {this, loadTkFileByTemplateId};
                            interceptable2.invokeUnInit(65536, newInitContext);
                            int i = newInitContext.flag;
                            if ((i & 1) != 0) {
                                int i2 = i & 2;
                                newInitContext.thisArg = this;
                                interceptable2.invokeInitBody(65536, newInitContext);
                                return;
                            }
                        }
                        this.Nx = this;
                        this.Nw = loadTkFileByTemplateId;
                    }

                    @Override // java.lang.Runnable
                    public final void run() {
                        Interceptable interceptable2 = $ic;
                        if (interceptable2 == null || interceptable2.invokeV(1048576, this) == null) {
                            if (this.Nw != null) {
                                if (this.Nx.Nv.mActivity == null || this.Nx.Nv.mActivity.isFinishing()) {
                                    return;
                                }
                                this.Nx.Nv.a(this.Nw, new a(this) { // from class: com.kwad.components.core.webview.b.d.1.1.1
                                    public static /* synthetic */ Interceptable $ic;
                                    public transient /* synthetic */ FieldHolder $fh;
                                    public final /* synthetic */ RunnableC03671 Ny;

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
                                        this.Ny = this;
                                    }

                                    @Override // com.kwad.components.core.webview.b.d.a
                                    public final void kU() {
                                        Interceptable interceptable3 = $ic;
                                        if (interceptable3 == null || interceptable3.invokeV(1048576, this) == null) {
                                            this.Ny.Nx.Nv.pI();
                                            com.kwad.sdk.core.e.b.d("TKLoadController", "渲染失败");
                                        }
                                    }

                                    @Override // com.kwad.components.core.webview.b.d.a
                                    public final void onSuccess() {
                                        Interceptable interceptable3 = $ic;
                                        if (interceptable3 == null || interceptable3.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this) == null) {
                                            com.kwad.sdk.core.e.b.d("TKLoadController", "渲染成功");
                                        }
                                    }
                                });
                                return;
                            }
                            this.Nx.Nv.aG(TKPerformMsg.ERROR_REASON.KSAD_TK_NO_TEMPLATE);
                            com.kwad.sdk.core.e.b.d("TKLoadController", "没有模板信息" + Thread.currentThread().getName());
                            this.Nx.Nv.pI();
                        }
                    }
                });
            }
        }
    }

    /* loaded from: classes5.dex */
    public interface a {
        void kU();

        void onSuccess();
    }

    public d(long j, Context context) {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {Long.valueOf(j), context};
            interceptable.invokeUnInit(65536, newInitContext);
            int i = newInitContext.flag;
            if ((i & 1) != 0) {
                int i2 = i & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
        this.Nn = false;
        this.No = false;
        this.Np = false;
        this.Nq = false;
        this.tS = -1L;
        this.Nu = new Runnable(this) { // from class: com.kwad.components.core.webview.b.d.10
            public static /* synthetic */ Interceptable $ic;
            public transient /* synthetic */ FieldHolder $fh;
            public final /* synthetic */ d Nv;

            {
                Interceptable interceptable2 = $ic;
                if (interceptable2 != null) {
                    InitContext newInitContext2 = TitanRuntime.newInitContext();
                    newInitContext2.initArgs = r2;
                    Object[] objArr2 = {this};
                    interceptable2.invokeUnInit(65536, newInitContext2);
                    int i3 = newInitContext2.flag;
                    if ((i3 & 1) != 0) {
                        int i4 = i3 & 2;
                        newInitContext2.thisArg = this;
                        interceptable2.invokeInitBody(65536, newInitContext2);
                        return;
                    }
                }
                this.Nv = this;
            }

            @Override // java.lang.Runnable
            public final void run() {
                Interceptable interceptable2 = $ic;
                if (interceptable2 == null || interceptable2.invokeV(1048576, this) == null) {
                    com.kwad.sdk.core.e.b.d("TKLoadController", "已经超时");
                    this.Nv.pM();
                    this.Nv.Nn = true;
                    this.Nv.pI();
                }
            }
        };
        this.td = new com.kwad.components.core.video.h(this) { // from class: com.kwad.components.core.webview.b.d.8
            public static /* synthetic */ Interceptable $ic;
            public transient /* synthetic */ FieldHolder $fh;
            public final /* synthetic */ d Nv;

            {
                Interceptable interceptable2 = $ic;
                if (interceptable2 != null) {
                    InitContext newInitContext2 = TitanRuntime.newInitContext();
                    newInitContext2.initArgs = r2;
                    Object[] objArr2 = {this};
                    interceptable2.invokeUnInit(65536, newInitContext2);
                    int i3 = newInitContext2.flag;
                    if ((i3 & 1) != 0) {
                        int i4 = i3 & 2;
                        newInitContext2.thisArg = this;
                        interceptable2.invokeInitBody(65536, newInitContext2);
                        return;
                    }
                }
                this.Nv = this;
            }

            private void d(double d) {
                Interceptable interceptable2 = $ic;
                if (interceptable2 == null || interceptable2.invokeCommon(65537, this, new Object[]{Double.valueOf(d)}) == null) {
                    this.Nv.tb.NZ = false;
                    this.Nv.tb.Oa = false;
                    this.Nv.tb.kD = (int) ((d / 1000.0d) + 0.5d);
                    ic();
                }
            }

            private void ic() {
                Interceptable interceptable2 = $ic;
                if (!(interceptable2 == null || interceptable2.invokeV(65538, this) == null) || this.Nv.Nj == null || this.Nv.tb == null) {
                    return;
                }
                this.Nv.Nj.a(this.Nv.tb);
            }

            @Override // com.kwad.components.core.video.h, com.kwad.components.core.video.g
            public final void onVideoPlayCompleted() {
                Interceptable interceptable2 = $ic;
                if (interceptable2 == null || interceptable2.invokeV(1048576, this) == null) {
                    this.Nv.tb.Oa = true;
                    this.Nv.tb.NZ = false;
                    this.Nv.tb.kD = com.kwad.sdk.core.response.a.a.B(com.kwad.sdk.core.response.a.d.bQ(this.Nv.mAdTemplate));
                    ic();
                }
            }

            @Override // com.kwad.components.core.video.h, com.kwad.components.core.video.g
            public final void onVideoPlayError(int i3, int i4) {
                Interceptable interceptable2 = $ic;
                if (interceptable2 == null || interceptable2.invokeII(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, i3, i4) == null) {
                    this.Nv.tb.NZ = true;
                    this.Nv.tb.Oa = false;
                    ic();
                }
            }

            @Override // com.kwad.components.core.video.h, com.kwad.components.core.video.g
            public final void onVideoPlayProgress(long j2, long j3) {
                Interceptable interceptable2 = $ic;
                if (interceptable2 == null || interceptable2.invokeCommon(Constants.METHOD_SEND_USER_MSG, this, new Object[]{Long.valueOf(j2), Long.valueOf(j3)}) == null) {
                    d(j3);
                }
            }

            @Override // com.kwad.components.core.video.h, com.kwad.components.core.video.g
            public final void onVideoPlayStart() {
                Interceptable interceptable2 = $ic;
                if (interceptable2 == null || interceptable2.invokeV(1048579, this) == null) {
                    d(0.0d);
                }
            }

            @Override // com.kwad.components.core.video.h, com.kwad.components.core.video.g
            public final void onVideoPreparing() {
                Interceptable interceptable2 = $ic;
                if (interceptable2 == null || interceptable2.invokeV(1048580, this) == null) {
                    d(0.0d);
                }
            }
        };
        this.mContext = context;
        this.tS = j;
        this.tb = new s();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(StyleTemplate styleTemplate, a aVar) {
        Interceptable interceptable = $ic;
        if (interceptable != null && interceptable.invokeLL(65543, this, styleTemplate, aVar) != null) {
            return;
        }
        this.Nl = styleTemplate;
        com.kwad.sdk.core.e.b.w("TKLoadController", "addTKView mTKPlugin.getState(): " + this.Ng.getState());
        if (this.Ng.getState() == ITkOfflineCompo.TKState.SO_FAIL) {
            aG(TKPerformMsg.ERROR_REASON.KSAD_TK_SO_FAIL);
            if (aVar != null) {
                aVar.kU();
                return;
            }
            return;
        }
        FrameLayout ca = this.Nf.ca();
        FileInputStream fileInputStream = null;
        try {
            String jsBaseDir = this.Ng.getJsBaseDir(this.mContext, this.Nf.bZ());
            File file = new File(jsBaseDir, styleTemplate.tkFileName);
            if (!o.I(file)) {
                aG(TKPerformMsg.ERROR_REASON.KSAD_TK_NO_FILE);
                if (aVar != null) {
                    aVar.kU();
                }
                return;
            }
            pK();
            this.Ns = SystemClock.elapsedRealtime();
            Context context = this.mContext;
            Context wrapContextIfNeed = new i(ITkOfflineCompo.PACKAGE_NAME).wrapContextIfNeed(context);
            com.kwad.sdk.core.e.b.d("TKLoadController", "context: " + context + " , resources: " + context.getResources() + "\nwrappedContext: " + wrapContextIfNeed + ", wrapped resources: " + wrapContextIfNeed.getResources());
            h view2 = this.Ng.getView(wrapContextIfNeed, styleTemplate.templateId, styleTemplate.templateVersionCode, styleTemplate.tkSouce);
            this.Nt = SystemClock.elapsedRealtime() - this.Ns;
            this.Nr = SystemClock.elapsedRealtime();
            a(view2, ca);
            FileInputStream fileInputStream2 = new FileInputStream(file);
            try {
                String inputStreamToString = IoUtils.inputStreamToString(fileInputStream2);
                if (inputStreamToString == null) {
                    aH(TKPerformMsg.ERROR_REASON.KSAD_TK_NO_TEMPLATE);
                    if (aVar != null) {
                        aVar.kU();
                    }
                    com.kwad.sdk.crash.utils.b.closeQuietly(fileInputStream2);
                    return;
                }
                File file2 = new File(jsBaseDir);
                view2.a(inputStreamToString, file2.getAbsolutePath() + "/", new com.kwad.sdk.components.g(this, aVar) { // from class: com.kwad.components.core.webview.b.d.9
                    public static /* synthetic */ Interceptable $ic;
                    public transient /* synthetic */ FieldHolder $fh;
                    public final /* synthetic */ d Nv;
                    public final /* synthetic */ a Nz;

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
                        this.Nv = this;
                        this.Nz = aVar;
                    }

                    @Override // com.kwad.sdk.components.g
                    public final void onSuccess() {
                        a aVar2;
                        Interceptable interceptable2 = $ic;
                        if (!(interceptable2 == null || interceptable2.invokeV(1048576, this) == null) || (aVar2 = this.Nz) == null) {
                            return;
                        }
                        aVar2.onSuccess();
                    }

                    @Override // com.kwad.sdk.components.g
                    public final void pN() {
                        a aVar2;
                        Interceptable interceptable2 = $ic;
                        if (!(interceptable2 == null || interceptable2.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this) == null) || (aVar2 = this.Nz) == null) {
                            return;
                        }
                        aVar2.kU();
                    }
                });
                View view3 = view2.getView();
                view3.setLayoutParams(new FrameLayout.LayoutParams(-1, -1));
                ca.addView(view3);
                this.Ni = view2;
                com.kwad.sdk.crash.utils.b.closeQuietly(fileInputStream2);
            } catch (Throwable th) {
                th = th;
                fileInputStream = fileInputStream2;
                try {
                    d(th);
                    if (aVar != null) {
                        aVar.kU();
                    }
                } finally {
                    com.kwad.sdk.crash.utils.b.closeQuietly(fileInputStream);
                }
            }
        } catch (Throwable th2) {
            th = th2;
        }
    }

    private void a(h hVar, ViewGroup viewGroup) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(65544, this, hVar, viewGroup) == null) {
            com.kwad.components.core.c.a.c cVar = new com.kwad.components.core.c.a.c(this.mAdTemplate);
            com.kwad.sdk.core.webview.b bVar = new com.kwad.sdk.core.webview.b();
            bVar.setAdTemplate(this.mAdTemplate);
            bVar.mScreenOrientation = !ag.cB(this.mContext) ? 1 : 0;
            bVar.agd = this.Nf.dD();
            bVar.Gl = viewGroup;
            bVar.Fv = null;
            this.Nf.a(hVar, bVar);
            l lVar = new l();
            lVar.a(new l.a(this) { // from class: com.kwad.components.core.webview.b.d.11
                public static /* synthetic */ Interceptable $ic;
                public transient /* synthetic */ FieldHolder $fh;
                public final /* synthetic */ d Nv;

                {
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 != null) {
                        InitContext newInitContext = TitanRuntime.newInitContext();
                        newInitContext.initArgs = r2;
                        Object[] objArr = {this};
                        interceptable2.invokeUnInit(65536, newInitContext);
                        int i = newInitContext.flag;
                        if ((i & 1) != 0) {
                            int i2 = i & 2;
                            newInitContext.thisArg = this;
                            interceptable2.invokeInitBody(65536, newInitContext);
                            return;
                        }
                    }
                    this.Nv = this;
                }

                @Override // com.kwad.components.core.webview.b.kwai.l.a
                public final void a(p pVar) {
                    Interceptable interceptable2 = $ic;
                    if (!(interceptable2 == null || interceptable2.invokeL(1048576, this, pVar) == null) || TextUtils.isEmpty(pVar.message)) {
                        return;
                    }
                    t.c(this.Nv.mContext, pVar.message, 0L);
                }
            });
            hVar.c(lVar);
            hVar.c(c(bVar));
            hVar.c(new com.kwad.sdk.core.webview.a.a());
            hVar.c(new com.kwad.components.core.webview.b.kwai.c());
            hVar.c(new com.kwad.components.core.webview.jshandler.i(bVar, cVar, this.Nf.getClickListener()));
            hVar.c(new com.kwad.components.core.webview.jshandler.l(bVar));
            hVar.c(new com.kwad.components.core.webview.jshandler.o(bVar));
            k kVar = new k(bVar);
            kVar.a(new k.b(this) { // from class: com.kwad.components.core.webview.b.d.12
                public static /* synthetic */ Interceptable $ic;
                public transient /* synthetic */ FieldHolder $fh;
                public final /* synthetic */ d Nv;

                {
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 != null) {
                        InitContext newInitContext = TitanRuntime.newInitContext();
                        newInitContext.initArgs = r2;
                        Object[] objArr = {this};
                        interceptable2.invokeUnInit(65536, newInitContext);
                        int i = newInitContext.flag;
                        if ((i & 1) != 0) {
                            int i2 = i & 2;
                            newInitContext.thisArg = this;
                            interceptable2.invokeInitBody(65536, newInitContext);
                            return;
                        }
                    }
                    this.Nv = this;
                }

                @Override // com.kwad.components.core.webview.jshandler.k.b
                public final void a(k.a aVar) {
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 == null || interceptable2.invokeL(1048576, this, aVar) == null) {
                        this.Nv.Nf.b(aVar);
                    }
                }
            });
            hVar.c(kVar);
            hVar.c(new r(bVar, new r.b(this) { // from class: com.kwad.components.core.webview.b.d.13
                public static /* synthetic */ Interceptable $ic;
                public transient /* synthetic */ FieldHolder $fh;
                public final /* synthetic */ d Nv;

                {
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 != null) {
                        InitContext newInitContext = TitanRuntime.newInitContext();
                        newInitContext.initArgs = r2;
                        Object[] objArr = {this};
                        interceptable2.invokeUnInit(65536, newInitContext);
                        int i = newInitContext.flag;
                        if ((i & 1) != 0) {
                            int i2 = i & 2;
                            newInitContext.thisArg = this;
                            interceptable2.invokeInitBody(65536, newInitContext);
                            return;
                        }
                    }
                    this.Nv = this;
                }

                @Override // com.kwad.components.core.webview.jshandler.r.b
                public final void a(r.a aVar) {
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 == null || interceptable2.invokeL(1048576, this, aVar) == null) {
                        this.Nv.b(aVar);
                    }
                }
            }));
            hVar.c(new x(new x.b(this) { // from class: com.kwad.components.core.webview.b.d.14
                public static /* synthetic */ Interceptable $ic;
                public transient /* synthetic */ FieldHolder $fh;
                public final /* synthetic */ d Nv;

                {
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 != null) {
                        InitContext newInitContext = TitanRuntime.newInitContext();
                        newInitContext.initArgs = r2;
                        Object[] objArr = {this};
                        interceptable2.invokeUnInit(65536, newInitContext);
                        int i = newInitContext.flag;
                        if ((i & 1) != 0) {
                            int i2 = i & 2;
                            newInitContext.thisArg = this;
                            interceptable2.invokeInitBody(65536, newInitContext);
                            return;
                        }
                    }
                    this.Nv = this;
                }

                @Override // com.kwad.components.core.webview.jshandler.x.b
                public final void a(x.a aVar) {
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 == null || interceptable2.invokeL(1048576, this, aVar) == null) {
                        if (aVar.status != 1) {
                            this.Nv.pI();
                            this.Nv.aH(aVar.errorMsg);
                            return;
                        }
                        this.Nv.pL();
                        e eVar = this.Nv.Nf;
                        if (eVar != null) {
                            eVar.dF();
                        }
                    }
                }
            }));
            aa aaVar = new aa();
            hVar.c(aaVar);
            this.Nf.a(aaVar);
            hVar.c(new ac(bVar, cVar));
            j jVar = new j();
            this.Nj = jVar;
            hVar.c(jVar);
            this.Nf.a(this.Nj);
            if (com.kwad.sdk.core.response.a.a.am(com.kwad.sdk.core.response.a.d.bQ(this.mAdTemplate))) {
                com.kwad.components.core.webview.b.kwai.g gVar = new com.kwad.components.core.webview.b.kwai.g();
                hVar.c(gVar);
                this.Nk = new g(this, this.mAdTemplate, gVar) { // from class: com.kwad.components.core.webview.b.d.15
                    public static /* synthetic */ Interceptable $ic;
                    public transient /* synthetic */ FieldHolder $fh;
                    public final /* synthetic */ com.kwad.components.core.webview.b.kwai.g NB;
                    public final /* synthetic */ d Nv;

                    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                    {
                        super(r8);
                        Interceptable interceptable2 = $ic;
                        if (interceptable2 != null) {
                            InitContext newInitContext = TitanRuntime.newInitContext();
                            newInitContext.initArgs = r2;
                            Object[] objArr = {this, r8, gVar};
                            interceptable2.invokeUnInit(65536, newInitContext);
                            int i = newInitContext.flag;
                            if ((i & 1) != 0) {
                                int i2 = i & 2;
                                super((AdTemplate) newInitContext.callArgs[0]);
                                newInitContext.thisArg = this;
                                interceptable2.invokeInitBody(65536, newInitContext);
                                return;
                            }
                        }
                        this.Nv = this;
                        this.NB = gVar;
                    }

                    @Override // com.kwad.sdk.core.download.g, com.kwad.sdk.core.download.f
                    public final void a(String str, int i, com.kwad.sdk.core.download.h hVar2) {
                        Interceptable interceptable2 = $ic;
                        if (interceptable2 == null || interceptable2.invokeLIL(1048576, this, str, i, hVar2) == null) {
                            super.a(str, i, hVar2);
                            com.kwad.components.core.webview.b.a.b bVar2 = new com.kwad.components.core.webview.b.a.b();
                            bVar2.NK = 1;
                            this.NB.a(bVar2);
                        }
                    }
                };
                com.kwad.sdk.core.download.e.sV().a(this.Nk, this.mAdTemplate);
            }
            m mVar = new m();
            mVar.a(new m.a(this) { // from class: com.kwad.components.core.webview.b.d.16
                public static /* synthetic */ Interceptable $ic;
                public transient /* synthetic */ FieldHolder $fh;
                public final /* synthetic */ d Nv;

                {
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 != null) {
                        InitContext newInitContext = TitanRuntime.newInitContext();
                        newInitContext.initArgs = r2;
                        Object[] objArr = {this};
                        interceptable2.invokeUnInit(65536, newInitContext);
                        int i = newInitContext.flag;
                        if ((i & 1) != 0) {
                            int i2 = i & 2;
                            newInitContext.thisArg = this;
                            interceptable2.invokeInitBody(65536, newInitContext);
                            return;
                        }
                    }
                    this.Nv = this;
                }

                @Override // com.kwad.components.core.webview.b.kwai.m.a
                public final void b(q qVar) {
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 == null || interceptable2.invokeL(1048576, this, qVar) == null) {
                        this.Nv.Nf.a(qVar);
                    }
                }
            });
            hVar.c(mVar);
            n nVar = new n();
            nVar.a(new n.a(this) { // from class: com.kwad.components.core.webview.b.d.2
                public static /* synthetic */ Interceptable $ic;
                public transient /* synthetic */ FieldHolder $fh;
                public final /* synthetic */ d Nv;

                {
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 != null) {
                        InitContext newInitContext = TitanRuntime.newInitContext();
                        newInitContext.initArgs = r2;
                        Object[] objArr = {this};
                        interceptable2.invokeUnInit(65536, newInitContext);
                        int i = newInitContext.flag;
                        if ((i & 1) != 0) {
                            int i2 = i & 2;
                            newInitContext.thisArg = this;
                            interceptable2.invokeInitBody(65536, newInitContext);
                            return;
                        }
                    }
                    this.Nv = this;
                }

                @Override // com.kwad.components.core.webview.b.kwai.n.a
                public final void a(com.kwad.components.core.webview.b.a.i iVar) {
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 == null || interceptable2.invokeL(1048576, this, iVar) == null) {
                        this.Nv.Nf.b(iVar);
                    }
                }
            });
            hVar.c(nVar);
            com.kwad.components.core.webview.b.kwai.i iVar = new com.kwad.components.core.webview.b.kwai.i();
            hVar.c(iVar);
            this.Nf.a(iVar);
            hVar.c(new com.kwad.components.core.webview.b.kwai.k(this) { // from class: com.kwad.components.core.webview.b.d.3
                public static /* synthetic */ Interceptable $ic;
                public transient /* synthetic */ FieldHolder $fh;
                public final /* synthetic */ d Nv;

                {
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 != null) {
                        InitContext newInitContext = TitanRuntime.newInitContext();
                        newInitContext.initArgs = r2;
                        Object[] objArr = {this};
                        interceptable2.invokeUnInit(65536, newInitContext);
                        int i = newInitContext.flag;
                        if ((i & 1) != 0) {
                            int i2 = i & 2;
                            newInitContext.thisArg = this;
                            interceptable2.invokeInitBody(65536, newInitContext);
                            return;
                        }
                    }
                    this.Nv = this;
                }

                @Override // com.kwad.components.core.webview.b.kwai.k
                public final void a(com.kwad.components.core.webview.b.a.o oVar) {
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 == null || interceptable2.invokeL(1048576, this, oVar) == null) {
                        super.a(oVar);
                        if (this.Nv.mActivity.isFinishing()) {
                            return;
                        }
                        if (this.Nv.Ne != null) {
                            this.Nv.Ne.dismiss();
                        }
                        d.b bVar2 = new d.b();
                        bVar2.setAdTemplate(this.Nv.mAdTemplate);
                        bVar2.aI(oVar.templateId);
                        this.Nv.Ne = com.kwad.components.core.webview.b.b.d.b(bVar2);
                        this.Nv.Ne.show(this.Nv.mActivity.getFragmentManager(), "");
                    }
                }
            });
            hVar.c(new com.kwad.components.core.webview.b.kwai.a(this) { // from class: com.kwad.components.core.webview.b.d.4
                public static /* synthetic */ Interceptable $ic;
                public transient /* synthetic */ FieldHolder $fh;
                public final /* synthetic */ d Nv;

                {
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 != null) {
                        InitContext newInitContext = TitanRuntime.newInitContext();
                        newInitContext.initArgs = r2;
                        Object[] objArr = {this};
                        interceptable2.invokeUnInit(65536, newInitContext);
                        int i = newInitContext.flag;
                        if ((i & 1) != 0) {
                            int i2 = i & 2;
                            newInitContext.thisArg = this;
                            interceptable2.invokeInitBody(65536, newInitContext);
                            return;
                        }
                    }
                    this.Nv = this;
                }

                @Override // com.kwad.components.core.webview.b.kwai.a
                public final void ie() {
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 == null || interceptable2.invokeV(1048576, this) == null) {
                        super.ie();
                        if (this.Nv.Ne != null) {
                            this.Nv.Ne.dismiss();
                        }
                        e eVar = this.Nv.Nf;
                        if (eVar != null) {
                            eVar.dI();
                        }
                    }
                }
            });
            hVar.c(new com.kwad.components.core.webview.jshandler.g(new com.kwad.sdk.core.webview.a.kwai.b(this) { // from class: com.kwad.components.core.webview.b.d.5
                public static /* synthetic */ Interceptable $ic;
                public transient /* synthetic */ FieldHolder $fh;
                public final /* synthetic */ d Nv;

                {
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 != null) {
                        InitContext newInitContext = TitanRuntime.newInitContext();
                        newInitContext.initArgs = r2;
                        Object[] objArr = {this};
                        interceptable2.invokeUnInit(65536, newInitContext);
                        int i = newInitContext.flag;
                        if ((i & 1) != 0) {
                            int i2 = i & 2;
                            newInitContext.thisArg = this;
                            interceptable2.invokeInitBody(65536, newInitContext);
                            return;
                        }
                    }
                    this.Nv = this;
                }

                @Override // com.kwad.sdk.core.webview.a.kwai.b
                public final void onClose() {
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 == null || interceptable2.invokeV(1048576, this) == null) {
                        this.Nv.Nf.dE();
                    }
                }
            }));
            hVar.c(new com.kwad.components.core.webview.b.kwai.b(this) { // from class: com.kwad.components.core.webview.b.d.6
                public static /* synthetic */ Interceptable $ic;
                public transient /* synthetic */ FieldHolder $fh;
                public final /* synthetic */ d Nv;

                {
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 != null) {
                        InitContext newInitContext = TitanRuntime.newInitContext();
                        newInitContext.initArgs = r2;
                        Object[] objArr = {this};
                        interceptable2.invokeUnInit(65536, newInitContext);
                        int i = newInitContext.flag;
                        if ((i & 1) != 0) {
                            int i2 = i & 2;
                            newInitContext.thisArg = this;
                            interceptable2.invokeInitBody(65536, newInitContext);
                            return;
                        }
                    }
                    this.Nv = this;
                }

                @Override // com.kwad.components.core.webview.b.kwai.b
                public final void a(f fVar) {
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 == null || interceptable2.invokeL(1048576, this, fVar) == null) {
                        super.a(fVar);
                        com.kwad.components.core.j.a.og().a(fVar.Mm, this.Nv.mAdTemplate, fVar.Mn);
                    }
                }
            });
            hVar.c(new com.kwad.components.core.webview.b.kwai.f(this) { // from class: com.kwad.components.core.webview.b.d.7
                public static /* synthetic */ Interceptable $ic;
                public transient /* synthetic */ FieldHolder $fh;
                public final /* synthetic */ d Nv;

                {
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 != null) {
                        InitContext newInitContext = TitanRuntime.newInitContext();
                        newInitContext.initArgs = r2;
                        Object[] objArr = {this};
                        interceptable2.invokeUnInit(65536, newInitContext);
                        int i = newInitContext.flag;
                        if ((i & 1) != 0) {
                            int i2 = i & 2;
                            newInitContext.thisArg = this;
                            interceptable2.invokeInitBody(65536, newInitContext);
                            return;
                        }
                    }
                    this.Nv = this;
                }

                @Override // com.kwad.components.core.webview.b.kwai.f
                public final void a(com.kwad.components.core.webview.b.a.j jVar2) {
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 == null || interceptable2.invokeL(1048576, this, jVar2) == null) {
                        super.a(jVar2);
                        SimpleWebViewActivity.launch(this.Nv.mContext, jVar2.url, jVar2.title);
                    }
                }
            });
            a(bVar, cVar, hVar, viewGroup);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void aG(String str) {
        StyleTemplate findStyleTemplateFromConfigById;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(65546, this, str) == null) || (findStyleTemplateFromConfigById = this.Ng.findStyleTemplateFromConfigById(this.Nf.bZ())) == null) {
            return;
        }
        TkLoggerReporter.get().reportTKPerform(ILoggerReporter.Category.ERROR_LOG, new TKPerformMsg(0).setRenderState(4).setErrorReason(str).setTemplateId(this.Nf.bZ()).setVersionCode(String.valueOf(findStyleTemplateFromConfigById.templateVersionCode)).toJson());
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void aH(String str) {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeL(65547, this, str) == null) && this.No && !this.Np) {
            this.Np = true;
            com.kwad.sdk.core.e.b.d("tkRender", "logTkRenderFail : " + str);
            TkLoggerReporter.get().reportTKPerform(ILoggerReporter.Category.ERROR_LOG, new TKPerformMsg(this.Nl.tkSouce).setRenderState(2).setErrorReason(str).setTemplateId(this.Nf.bZ()).setVersionCode(String.valueOf(this.Nl.templateVersionCode)).toJson());
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void b(r.a aVar) {
        FrameLayout ca;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(65550, this, aVar) == null) || (ca = this.Nf.ca()) == null) {
            return;
        }
        FrameLayout.LayoutParams layoutParams = (FrameLayout.LayoutParams) ca.getLayoutParams();
        layoutParams.height = com.kwad.sdk.b.kwai.a.a(this.mContext, aVar.height);
        layoutParams.leftMargin = com.kwad.sdk.b.kwai.a.a(this.mContext, aVar.leftMargin);
        layoutParams.rightMargin = com.kwad.sdk.b.kwai.a.a(this.mContext, aVar.rightMargin);
        layoutParams.bottomMargin = com.kwad.sdk.b.kwai.a.a(this.mContext, aVar.bottomMargin);
        layoutParams.width = -1;
        ca.setLayoutParams(layoutParams);
    }

    private void d(Throwable th) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(65552, this, th) == null) {
            com.kwad.components.core.b.a.b(th);
            TkLoggerReporter.get().reportTKPerform(ILoggerReporter.Category.ERROR_LOG, new TKPerformMsg(this.Nl.tkSouce).setRenderState(3).setErrorReason(th.getMessage()).setTemplateId(this.Nf.bZ()).setVersionCode(String.valueOf(this.Nl.templateVersionCode)).toJson());
        }
    }

    private void pG() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(65563, this) == null) {
            this.No = false;
            this.Np = false;
            this.Nn = false;
            this.Nq = false;
            this.Nm = 0L;
            this.Ns = 0L;
            this.Nt = 0L;
            this.Nr = 0L;
        }
    }

    private void pH() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(65564, this) == null) {
            bd.runOnUiThreadDelay(this.Nu, 1000L);
            this.Nh = com.kwad.sdk.core.threads.b.vn().submit(new AnonymousClass1(this));
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void pI() {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(65565, this) == null) || this.Nq) {
            return;
        }
        this.Nq = true;
        this.Nf.cb();
    }

    private void pJ() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(65566, this) == null) {
            com.kwad.components.core.offline.api.kwai.a aVar = this.Ng;
            StyleTemplate findStyleTemplateFromConfigById = aVar == null ? null : aVar.findStyleTemplateFromConfigById(this.Nf.bZ());
            TkLoggerReporter.get().reportTKPerform(ILoggerReporter.Category.APM_LOG, new TKPerformMsg(findStyleTemplateFromConfigById == null ? 0 : findStyleTemplateFromConfigById.tkSouce).setRenderState(-1).setTemplateId(this.Nf.bZ()).setVersionCode(findStyleTemplateFromConfigById == null ? "" : String.valueOf(findStyleTemplateFromConfigById.templateVersionCode)).toJson());
        }
    }

    private void pK() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(65567, this) == null) {
            this.No = true;
            com.kwad.sdk.core.e.b.d("tkrender", "logTkRenderStart");
            TkLoggerReporter.get().reportTKPerform(ILoggerReporter.Category.APM_LOG, new TKPerformMsg(this.Nl.tkSouce).setRenderState(0).setTemplateId(this.Nf.bZ()).setVersionCode(String.valueOf(this.Nl.templateVersionCode)).toJson());
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void pL() {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeV(65568, this) == null) && this.No && !this.Np) {
            this.Np = true;
            com.kwad.sdk.core.e.b.d("tkRender", "logTkRenderSuccess");
            TkLoggerReporter.get().reportTKPerform(ILoggerReporter.Category.APM_LOG, new TKPerformMsg(this.Nl.tkSouce).setRenderState(1).setRenderTime(this.Nr > 0 ? SystemClock.elapsedRealtime() - this.Nr : 0L).setTemplateId(this.Nf.bZ()).setLoadTime(this.Ns - this.Nm).setInitTime(this.Nt).setVersionCode(String.valueOf(this.Nl.templateVersionCode)).toJson());
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void pM() {
        StyleTemplate findStyleTemplateFromConfigById;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(65569, this) == null) || (findStyleTemplateFromConfigById = this.Ng.findStyleTemplateFromConfigById(this.Nf.bZ())) == null) {
            return;
        }
        TkLoggerReporter.get().reportTKPerform(ILoggerReporter.Category.ERROR_LOG, new TKPerformMsg(findStyleTemplateFromConfigById.tkSouce).setRenderState(3).setErrorReason("timeout").setTemplateId(this.Nf.bZ()).setVersionCode(String.valueOf(findStyleTemplateFromConfigById.templateVersionCode)).toJson());
    }

    public final void a(Activity activity, AdTemplate adTemplate, e eVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLLL(1048576, this, activity, adTemplate, eVar) == null) {
            this.mActivity = activity;
            this.mAdTemplate = adTemplate;
            this.Nf = eVar;
            pG();
            FrameLayout ca = this.Nf.ca();
            if (ca != null) {
                ca.removeAllViews();
            }
            if (!com.kwad.sdk.core.config.d.isCanUseTk()) {
                pI();
                return;
            }
            this.Ng = (com.kwad.components.core.offline.api.kwai.a) com.kwad.sdk.components.c.f(com.kwad.components.core.offline.api.kwai.a.class);
            pJ();
            com.kwad.sdk.core.e.b.d("TKLoadController", "bind mTKPlugin: " + this.Ng);
            if (this.Ng != null) {
                pH();
                return;
            }
            pI();
            TkLoggerReporter.get().reportTKPerform(ILoggerReporter.Category.ERROR_LOG, new TKPerformMsg(0).setRenderState(4).setErrorReason(TKPerformMsg.ERROR_REASON.KSAD_TK_OFFLINE_FAILED).setTemplateId(this.Nf.bZ()).toJson());
        }
    }

    public void a(com.kwad.sdk.core.webview.b bVar, com.kwad.components.core.c.a.c cVar, h hVar, ViewGroup viewGroup) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLLLL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, bVar, cVar, hVar, viewGroup) == null) {
        }
    }

    public com.kwad.components.core.webview.jshandler.s c(com.kwad.sdk.core.webview.b bVar) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeL = interceptable.invokeL(Constants.METHOD_SEND_USER_MSG, this, bVar)) == null) ? new com.kwad.components.core.webview.jshandler.s(bVar) : (com.kwad.components.core.webview.jshandler.s) invokeL.objValue;
    }

    public final void pF() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048579, this) == null) {
            Future<?> future = this.Nh;
            if (future != null) {
                future.cancel(true);
            }
            bd.c(this.Nu);
            if (this.Nk != null) {
                com.kwad.sdk.core.download.e.sV().a(this.Nk);
            }
            h hVar = this.Ni;
            if (hVar != null) {
                hVar.onDestroy();
            }
            com.kwad.components.core.webview.b.b.d dVar = this.Ne;
            if (dVar != null) {
                dVar.dismiss();
            }
        }
    }
}
