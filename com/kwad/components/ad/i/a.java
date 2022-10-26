package com.kwad.components.ad.i;

import android.app.Activity;
import android.os.Handler;
import android.os.Looper;
import android.os.SystemClock;
import android.text.TextUtils;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;
import android.webkit.DownloadListener;
import android.widget.FrameLayout;
import android.widget.ImageView;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.tieba.R;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import com.kwad.components.core.webview.KsAdWebView;
import com.kwad.components.core.webview.kwai.c;
import com.kwad.sdk.core.report.u;
import com.kwad.sdk.core.response.a.d;
import com.kwad.sdk.core.response.model.AdTemplate;
import com.kwad.sdk.core.view.AdBaseFrameLayout;
/* loaded from: classes7.dex */
public final class a {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public boolean BP;
    public KsAdWebView BQ;
    public boolean BR;
    public boolean BS;
    public View BT;
    public InterfaceC0527a BU;
    public boolean BV;
    public boolean BW;
    public boolean BX;
    public b BY;
    public com.kwad.sdk.core.webview.a.kwai.a bJ;
    public FrameLayout bS;
    public AdBaseFrameLayout ct;
    public c.a gX;
    public Activity mActivity;
    public AdTemplate mAdTemplate;
    public ImageView mBackIcon;
    public Handler mHandler;
    public long mLastDown;

    /* renamed from: com.kwad.components.ad.i.a$a  reason: collision with other inner class name */
    /* loaded from: classes7.dex */
    public interface InterfaceC0527a {
        void V(boolean z);
    }

    /* loaded from: classes7.dex */
    public interface b {
        void hI();
    }

    public a() {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            interceptable.invokeUnInit(65536, newInitContext);
            int i = newInitContext.flag;
            if ((i & 1) != 0) {
                int i2 = i & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
        this.BP = true;
        this.mHandler = new Handler(Looper.getMainLooper());
        this.BV = false;
        this.BW = false;
        this.BX = false;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public boolean bs() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(65542, this)) == null) ? this.BX ? !this.BP : (this.BP || this.BV || this.BW) ? false : true : invokeV.booleanValue;
    }

    private void fh() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(65549, this) == null) {
            this.bS.removeAllViews();
            this.bS.setVisibility(4);
            this.BT = com.kwad.sdk.b.kwai.a.a((ViewGroup) this.bS, getLayoutId(), true);
            KsAdWebView ksAdWebView = (KsAdWebView) this.bS.findViewById(R.id.obfuscated_res_0x7f091232);
            this.BQ = ksAdWebView;
            ksAdWebView.setBackgroundColor(-1);
            u.b bVar = new u.b();
            bVar.abM = 1;
            c.a b2 = this.BQ.getClientConfig().aA(false).aB(false).b(bVar).R(this.mAdTemplate).a(kS()).b(getWebListener());
            this.gX = b2;
            this.BQ.setClientConfig(b2);
            this.BQ.setDownloadListener(new DownloadListener(this) { // from class: com.kwad.components.ad.i.a.1
                public static /* synthetic */ Interceptable $ic;
                public transient /* synthetic */ FieldHolder $fh;
                public final /* synthetic */ a BZ;

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
                    this.BZ = this;
                }

                @Override // android.webkit.DownloadListener
                public final void onDownloadStart(String str, String str2, String str3, String str4, long j) {
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 == null || interceptable2.invokeCommon(1048576, this, new Object[]{str, str2, str3, str4, Long.valueOf(j)}) == null) {
                        this.BZ.BW = true;
                        if (this.BZ.BU != null) {
                            this.BZ.BU.V(this.BZ.bs());
                        }
                    }
                }
            });
            ImageView imageView = (ImageView) this.BT.findViewById(R.id.obfuscated_res_0x7f09109e);
            this.mBackIcon = imageView;
            imageView.setVisibility(8);
            this.mBackIcon.setOnClickListener(new View.OnClickListener(this) { // from class: com.kwad.components.ad.i.a.2
                public static /* synthetic */ Interceptable $ic;
                public transient /* synthetic */ FieldHolder $fh;
                public final /* synthetic */ a BZ;

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
                    this.BZ = this;
                }

                @Override // android.view.View.OnClickListener
                public final void onClick(View view2) {
                    Interceptable interceptable2 = $ic;
                    if (!(interceptable2 == null || interceptable2.invokeL(1048576, this, view2) == null) || this.BZ.BY == null) {
                        return;
                    }
                    this.BZ.BY.hI();
                }
            });
        }
    }

    public static int getLayoutId() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(65551, null)) == null) ? R.layout.obfuscated_res_0x7f0d0409 : invokeV.intValue;
    }

    private KsAdWebView.d getWebListener() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(65552, this)) == null) ? new KsAdWebView.d(this) { // from class: com.kwad.components.ad.i.a.3
            public static /* synthetic */ Interceptable $ic;
            public transient /* synthetic */ FieldHolder $fh;
            public final /* synthetic */ a BZ;

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
                this.BZ = this;
            }

            @Override // com.kwad.components.core.webview.KsAdWebView.d
            public final void a(int i, String str, String str2) {
                Interceptable interceptable2 = $ic;
                if (interceptable2 == null || interceptable2.invokeILL(1048576, this, i, str, str2) == null) {
                    this.BZ.BP = true;
                    if (this.BZ.BU != null) {
                        this.BZ.BU.V(this.BZ.bs());
                    }
                }
            }

            @Override // com.kwad.components.core.webview.KsAdWebView.d
            public final void bv() {
                Interceptable interceptable2 = $ic;
                if (interceptable2 == null || interceptable2.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this) == null) {
                }
            }

            @Override // com.kwad.components.core.webview.KsAdWebView.d
            public final void bw() {
                Interceptable interceptable2 = $ic;
                if (!(interceptable2 == null || interceptable2.invokeV(Constants.METHOD_SEND_USER_MSG, this) == null) || this.BZ.BU == null) {
                    return;
                }
                this.BZ.BU.V(this.BZ.bs());
            }
        } : (KsAdWebView.d) invokeV.objValue;
    }

    private KsAdWebView.b kS() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(65556, this)) == null) ? new KsAdWebView.b(this) { // from class: com.kwad.components.ad.i.a.4
            public static /* synthetic */ Interceptable $ic;
            public transient /* synthetic */ FieldHolder $fh;
            public final /* synthetic */ a BZ;

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
                this.BZ = this;
            }

            @Override // com.kwad.components.core.webview.KsAdWebView.b
            public final void kU() {
                Interceptable interceptable2 = $ic;
                if (interceptable2 == null || interceptable2.invokeV(1048576, this) == null) {
                    this.BZ.BV = true;
                    if (this.BZ.BU != null) {
                        this.BZ.BU.V(this.BZ.bs());
                    }
                }
            }

            @Override // com.kwad.components.core.webview.KsAdWebView.b
            public final void onSuccess() {
                Interceptable interceptable2 = $ic;
                if (interceptable2 == null || interceptable2.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this) == null) {
                    this.BZ.BV = true;
                    if (this.BZ.BU != null) {
                        this.BZ.BU.V(this.BZ.bs());
                    }
                }
            }
        } : (KsAdWebView.b) invokeV.objValue;
    }

    private boolean kT() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(65557, this)) == null) {
            if (!bs()) {
                FrameLayout frameLayout = this.bS;
                if (frameLayout != null) {
                    frameLayout.setVisibility(8);
                }
                return false;
            }
            FrameLayout frameLayout2 = this.bS;
            if (frameLayout2 != null) {
                frameLayout2.setVisibility(0);
                return true;
            }
            return true;
        }
        return invokeV.booleanValue;
    }

    public static String l(AdTemplate adTemplate) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeL = interceptable.invokeL(65558, null, adTemplate)) == null) ? com.kwad.sdk.core.response.a.a.ar(d.bQ(adTemplate)) : (String) invokeL.objValue;
    }

    public final void a(FrameLayout frameLayout, AdBaseFrameLayout adBaseFrameLayout, AdTemplate adTemplate) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLLL(1048576, this, frameLayout, adBaseFrameLayout, adTemplate) == null) {
            this.bS = frameLayout;
            this.ct = adBaseFrameLayout;
            this.mAdTemplate = adTemplate;
            fh();
            this.BP = false;
        }
    }

    public final void a(InterfaceC0527a interfaceC0527a) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, interfaceC0527a) == null) {
            this.BU = interfaceC0527a;
        }
    }

    public final void a(b bVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(Constants.METHOD_SEND_USER_MSG, this, bVar) == null) {
            this.BY = bVar;
        }
    }

    public final void a(com.kwad.sdk.core.webview.a.kwai.a aVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048579, this, aVar) == null) {
            this.bJ = aVar;
        }
    }

    public final void aE() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048580, this) == null) {
            this.bS.setVisibility(4);
            String l = l(this.mAdTemplate);
            if (TextUtils.isEmpty(l)) {
                return;
            }
            this.BQ.loadUrl(l);
        }
    }

    public final a ae(boolean z) {
        InterceptResult invokeZ;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeZ = interceptable.invokeZ(1048581, this, z)) == null) {
            this.BS = z;
            return this;
        }
        return (a) invokeZ.objValue;
    }

    public final boolean ay() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048582, this)) == null) {
            boolean kT = kT();
            this.BX = true;
            if (kT && this.mActivity != null) {
                if (this.BQ.getClientConfig() != null) {
                    this.BQ.getClientConfig().aA(true);
                    this.BQ.getClientConfig().aB(true);
                }
                this.ct.a(new View.OnTouchListener(this) { // from class: com.kwad.components.ad.i.a.5
                    public static /* synthetic */ Interceptable $ic;
                    public transient /* synthetic */ FieldHolder $fh;
                    public final /* synthetic */ a BZ;

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
                        this.BZ = this;
                    }

                    @Override // android.view.View.OnTouchListener
                    public final boolean onTouch(View view2, MotionEvent motionEvent) {
                        InterceptResult invokeLL;
                        Interceptable interceptable2 = $ic;
                        if (interceptable2 == null || (invokeLL = interceptable2.invokeLL(1048576, this, view2, motionEvent)) == null) {
                            if (motionEvent.getX() > this.BZ.mBackIcon.getX() && motionEvent.getX() - this.BZ.mBackIcon.getX() < this.BZ.mBackIcon.getWidth() && motionEvent.getY() > this.BZ.mBackIcon.getY() && motionEvent.getY() - this.BZ.mBackIcon.getY() < this.BZ.mBackIcon.getHeight()) {
                                com.kwad.sdk.core.e.b.d("LandingPageWebCard", "onClick backIcon");
                                return false;
                            }
                            if (motionEvent.getAction() == 0) {
                                this.BZ.mLastDown = SystemClock.elapsedRealtime();
                            } else if (motionEvent.getAction() == 1) {
                                long elapsedRealtime = SystemClock.elapsedRealtime() - this.BZ.mLastDown;
                                if (this.BZ.mLastDown > 0 && elapsedRealtime > 30 && elapsedRealtime < 500) {
                                    com.kwad.sdk.core.report.a.a(this.BZ.mAdTemplate, 155, this.BZ.ct.getTouchCoords());
                                    if (!this.BZ.BR) {
                                        this.BZ.BR = true;
                                        if (this.BZ.bJ != null) {
                                            com.kwad.sdk.core.webview.a.a.a aVar = new com.kwad.sdk.core.webview.a.a.a();
                                            aVar.Mx = 3;
                                            this.BZ.bJ.a(aVar);
                                        }
                                    }
                                }
                                this.BZ.mLastDown = 0L;
                            }
                            return false;
                        }
                        return invokeLL.booleanValue;
                    }
                });
                long X = com.kwad.sdk.core.response.a.a.X(d.bQ(this.mAdTemplate));
                if (X == 0 || !this.BS) {
                    this.mBackIcon.setVisibility(0);
                } else {
                    this.mHandler.postDelayed(new Runnable(this) { // from class: com.kwad.components.ad.i.a.6
                        public static /* synthetic */ Interceptable $ic;
                        public transient /* synthetic */ FieldHolder $fh;
                        public final /* synthetic */ a BZ;

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
                            this.BZ = this;
                        }

                        @Override // java.lang.Runnable
                        public final void run() {
                            Interceptable interceptable2 = $ic;
                            if (!(interceptable2 == null || interceptable2.invokeV(1048576, this) == null) || this.BZ.mActivity == null || this.BZ.mActivity.isFinishing()) {
                                return;
                            }
                            this.BZ.mBackIcon.setVisibility(0);
                            this.BZ.mBackIcon.setAlpha(0.0f);
                            this.BZ.mBackIcon.animate().alpha(1.0f).setDuration(500L).start();
                        }
                    }, X);
                }
                KsAdWebView ksAdWebView = this.BQ;
                if (ksAdWebView != null) {
                    ksAdWebView.pp();
                }
            }
            return kT;
        }
        return invokeV.booleanValue;
    }

    public final void setActivity(Activity activity) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048583, this, activity) == null) {
            this.mActivity = activity;
        }
    }
}
