package com.kwad.components.ad.reward.k;

import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;
import androidx.core.view.InputDeviceCompat;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.tieba.R;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import com.kwad.components.ad.widget.KsAppTagsView;
import com.kwad.sdk.core.imageloader.KSImageLoader;
import com.kwad.sdk.core.response.model.AdInfo;
import com.kwad.sdk.core.response.model.AdTemplate;
import com.kwad.sdk.widget.KSRatingBar;
import java.util.List;
/* loaded from: classes5.dex */
public final class c extends com.kwad.sdk.core.download.kwai.a implements com.kwad.sdk.widget.c {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public ImageView ll;
    public AdTemplate mAdTemplate;
    public com.kwad.components.core.c.a.c mApkDownloadHelper;
    public View um;
    public View un;
    public Button uo;
    public Button up;
    public TextView uq;
    public TextView ur;
    public TextView us;
    public KSRatingBar ut;
    public KsAppTagsView uu;
    public a uv;
    public volatile boolean uw;
    public com.kwad.components.ad.g.a ux;
    public Runnable uy;

    /* loaded from: classes5.dex */
    public interface a {
        void c(boolean z, int i);
    }

    /* loaded from: classes5.dex */
    public static class b {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public String appName;
        public String kY;
        public String np;
        public float uA;
        public List<String> uB;
        public int uC;
        public String uD;

        public b() {
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
            this.uC = 15;
        }

        public static b B(AdTemplate adTemplate) {
            InterceptResult invokeL;
            String str;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeL = interceptable.invokeL(65537, null, adTemplate)) == null) {
                if (adTemplate == null) {
                    return null;
                }
                AdInfo bQ = com.kwad.sdk.core.response.a.d.bQ(adTemplate);
                b bVar = new b();
                bVar.appName = com.kwad.sdk.core.response.a.d.p(adTemplate) ? com.kwad.sdk.core.response.a.a.af(bQ) : com.kwad.sdk.core.response.a.a.ae(bQ);
                bVar.uA = com.kwad.sdk.core.response.a.a.aj(bQ);
                bVar.np = com.kwad.sdk.core.response.a.a.ad(bQ);
                bVar.kY = com.kwad.sdk.core.response.a.d.p(adTemplate) ? com.kwad.sdk.core.response.a.a.bI(bQ) : com.kwad.sdk.core.response.a.a.bn(bQ);
                if (com.kwad.sdk.core.response.a.d.e(adTemplate, com.kwad.components.ad.reward.kwai.b.j(com.kwad.sdk.core.response.a.d.bQ(adTemplate)))) {
                    bVar.uC = com.kwad.components.ad.reward.kwai.b.fX();
                    str = "安装并体验%s秒  可领取奖励";
                } else {
                    bVar.uC = com.kwad.sdk.core.config.d.sf();
                    str = "浏览详情页%s秒，领取奖励";
                }
                bVar.uD = str;
                bVar.uB = com.kwad.sdk.core.response.a.c.bH(adTemplate);
                return bVar;
            }
            return (b) invokeL.objValue;
        }

        public final String iQ() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            return (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) ? String.format(this.uD, Integer.valueOf(this.uC)) : (String) invokeV.objValue;
        }
    }

    public c(View view2) {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {view2};
            interceptable.invokeUnInit(65536, newInitContext);
            int i = newInitContext.flag;
            if ((i & 1) != 0) {
                int i2 = i & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
        this.uw = false;
        this.um = view2;
        initView();
        this.ux = new com.kwad.components.ad.g.a(view2);
    }

    private void c(View view2, boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLZ(InputDeviceCompat.SOURCE_TRACKBALL, this, view2, z) == null) {
            int id = view2.getId();
            if (id == R.id.obfuscated_res_0x7f0910e5 || id == R.id.obfuscated_res_0x7f0910e4 || id == R.id.obfuscated_res_0x7f0910e6) {
                com.kwad.sdk.core.e.b.d("ApkInfoCardViewHelper", "onClick install");
                this.uw = true;
                a aVar = this.uv;
                if (aVar != null) {
                    aVar.c(z, 1);
                }
            }
        }
    }

    private void initView() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(65541, this) == null) {
            this.uo = (Button) this.um.findViewById(R.id.obfuscated_res_0x7f0910e4);
            this.up = (Button) this.um.findViewById(R.id.obfuscated_res_0x7f0910e6);
            this.un = this.um.findViewById(R.id.obfuscated_res_0x7f0910e5);
            this.ll = (ImageView) this.um.findViewById(R.id.obfuscated_res_0x7f0910e3);
            this.uq = (TextView) this.um.findViewById(R.id.obfuscated_res_0x7f0910e7);
            this.ur = (TextView) this.um.findViewById(R.id.obfuscated_res_0x7f0910e1);
            this.ut = (KSRatingBar) this.um.findViewById(R.id.obfuscated_res_0x7f0910e8);
            this.uu = (KsAppTagsView) this.um.findViewById(R.id.obfuscated_res_0x7f0910ea);
        }
    }

    public final void a(a aVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048576, this, aVar) == null) {
            this.uv = aVar;
        }
    }

    public final void a(com.kwad.components.core.c.a.c cVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, cVar) == null) {
            this.mApkDownloadHelper = cVar;
            if (cVar != null) {
                cVar.b(this);
            }
        }
    }

    public final void c(AdTemplate adTemplate, boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLZ(Constants.METHOD_SEND_USER_MSG, this, adTemplate, z) == null) {
            this.mAdTemplate = adTemplate;
            b B = b.B(adTemplate);
            if (B == null) {
                return;
            }
            KSImageLoader.loadAppIcon(this.ll, B.kY, adTemplate, 12);
            this.uq.setText(B.appName);
            this.ur.setText(B.np);
            this.ut.setStar(B.uA);
            if (com.kwad.sdk.core.response.a.d.e(adTemplate, com.kwad.components.ad.reward.kwai.b.j(com.kwad.sdk.core.response.a.d.bQ(adTemplate)))) {
                this.up.setText(com.kwad.sdk.core.response.a.a.al(com.kwad.sdk.core.response.a.d.bQ(adTemplate)));
                this.ut.setVisibility(0);
            } else {
                this.up.setText("查看详情");
                this.ut.setVisibility(8);
            }
            this.uo.setText(B.iQ());
            this.uo.setClickable(true);
            this.up.setClickable(true);
            this.un.setClickable(true);
            new com.kwad.sdk.widget.f(this.uo, this);
            new com.kwad.sdk.widget.f(this.up, this);
            new com.kwad.sdk.widget.f(this.un, this);
            List<String> list = B.uB;
            if (z && list.size() == 0) {
                this.ur.setVisibility(8);
                TextView textView = (TextView) this.um.findViewById(R.id.obfuscated_res_0x7f0910e2);
                this.us = textView;
                textView.setVisibility(0);
                this.us.setText(B.np);
            }
            if (list.size() == 0) {
                this.uu.setVisibility(8);
            }
            this.uu.setAppTags(list);
            if (this.uy == null) {
                this.uy = new Runnable(this) { // from class: com.kwad.components.ad.reward.k.c.1
                    public static /* synthetic */ Interceptable $ic;
                    public transient /* synthetic */ FieldHolder $fh;
                    public final /* synthetic */ c uz;

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
                        this.uz = this;
                    }

                    @Override // java.lang.Runnable
                    public final void run() {
                        Interceptable interceptable2 = $ic;
                        if (interceptable2 == null || interceptable2.invokeV(1048576, this) == null) {
                            int height = this.uz.un.getHeight();
                            com.kwad.sdk.core.e.b.d("ApkInfoCardViewHelper", hashCode() + " parentHeight: " + height);
                            if (this.uz.uw) {
                                return;
                            }
                            this.uz.ux.kL();
                        }
                    }
                };
            }
            this.un.postDelayed(this.uy, 1600L);
        }
    }

    @Override // com.kwad.sdk.widget.c
    public final void f(View view2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048579, this, view2) == null) {
            c(view2, true);
        }
    }

    @Override // com.kwad.sdk.widget.c
    public final void g(View view2) {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeL(1048580, this, view2) == null) && com.kwad.sdk.core.response.a.c.bF(this.mAdTemplate)) {
            c(view2, false);
        }
    }

    public final void i(String str, int i) {
        Button button;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeLI(1048581, this, str, i) == null) || (button = this.up) == null || str == null || i == 0) {
            return;
        }
        button.setText(str);
    }

    public final void iO() {
        Runnable runnable;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048582, this) == null) {
            com.kwad.components.core.c.a.c cVar = this.mApkDownloadHelper;
            if (cVar != null) {
                cVar.c(this);
            }
            com.kwad.components.ad.g.a aVar = this.ux;
            if (aVar != null) {
                aVar.iO();
            }
            View view2 = this.un;
            if (view2 == null || (runnable = this.uy) == null) {
                return;
            }
            view2.removeCallbacks(runnable);
            this.uy = null;
        }
    }

    public final void iP() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048583, this) == null) {
            this.ux.kN();
        }
    }

    @Override // com.kwad.sdk.api.KsAppDownloadListener
    public final void onDownloadFailed() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(InputDeviceCompat.SOURCE_TOUCHPAD, this) == null) {
            AdTemplate adTemplate = this.mAdTemplate;
            this.up.setText(adTemplate != null ? com.kwad.sdk.core.response.a.a.al(com.kwad.sdk.core.response.a.d.bQ(adTemplate)) : "立即下载");
        }
    }

    @Override // com.kwad.sdk.api.KsAppDownloadListener
    public final void onDownloadFinished() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048585, this) == null) {
            AdTemplate adTemplate = this.mAdTemplate;
            this.up.setText(adTemplate == null ? "" : com.kwad.sdk.core.response.a.a.aJ(adTemplate));
        }
    }

    @Override // com.kwad.sdk.core.download.kwai.a, com.kwad.sdk.api.KsAppDownloadListener
    public final void onDownloadStarted() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048586, this) == null) {
        }
    }

    @Override // com.kwad.sdk.api.KsAppDownloadListener
    public final void onIdle() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048587, this) == null) {
            AdTemplate adTemplate = this.mAdTemplate;
            this.up.setText(adTemplate != null ? com.kwad.sdk.core.response.a.a.al(com.kwad.sdk.core.response.a.d.bQ(adTemplate)) : "立即下载");
        }
    }

    @Override // com.kwad.sdk.api.KsAppDownloadListener
    public final void onInstalled() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048588, this) == null) {
            AdTemplate adTemplate = this.mAdTemplate;
            this.up.setText(adTemplate != null ? com.kwad.sdk.core.response.a.a.P(com.kwad.sdk.core.response.a.d.bQ(adTemplate)) : "立即打开");
        }
    }

    @Override // com.kwad.sdk.core.download.kwai.a
    public final void onPaused(int i) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048589, this, i) == null) {
            super.onPaused(i);
            if (i != 0) {
                this.ux.kN();
                this.up.setText(com.kwad.sdk.core.response.a.a.aX(i));
            }
        }
    }

    @Override // com.kwad.sdk.api.KsAppDownloadListener
    public final void onProgressUpdate(int i) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeI(1048590, this, i) == null) || i == 0) {
            return;
        }
        this.ux.kN();
        this.up.setText(com.kwad.sdk.core.response.a.a.aW(i));
    }
}
