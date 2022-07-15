package com.kwad.components.ad.reward.i;

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
    public View a;
    public View b;
    public Button c;
    public Button e;
    public TextView f;
    public ImageView g;
    public TextView h;
    public TextView i;
    public KSRatingBar j;
    public KsAppTagsView k;
    public com.kwad.components.core.c.a.b l;
    public a m;
    public volatile boolean n;
    public com.kwad.components.ad.g.a o;
    public AdTemplate p;

    /* loaded from: classes5.dex */
    public interface a {
        void a(boolean z, int i);
    }

    /* loaded from: classes5.dex */
    public static class b {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public String a;
        public String b;
        public float c;
        public List<String> d;
        public String e;
        public int f;
        public String g;

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
            this.f = 15;
        }

        public static b a(AdTemplate adTemplate) {
            InterceptResult invokeL;
            String str;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeL = interceptable.invokeL(65537, null, adTemplate)) == null) {
                if (adTemplate == null) {
                    return null;
                }
                AdInfo i = com.kwad.sdk.core.response.a.d.i(adTemplate);
                b bVar = new b();
                bVar.b = com.kwad.sdk.core.response.a.d.q(adTemplate) ? com.kwad.sdk.core.response.a.a.B(i) : com.kwad.sdk.core.response.a.a.A(i);
                bVar.c = com.kwad.sdk.core.response.a.a.F(i);
                bVar.e = com.kwad.sdk.core.response.a.a.z(i);
                bVar.a = com.kwad.sdk.core.response.a.d.q(adTemplate) ? com.kwad.sdk.core.response.a.a.aZ(i) : com.kwad.sdk.core.response.a.a.aE(i);
                if (com.kwad.sdk.core.response.a.d.a(adTemplate, com.kwad.components.ad.reward.kwai.b.d(com.kwad.sdk.core.response.a.d.i(adTemplate)))) {
                    bVar.f = com.kwad.components.ad.reward.kwai.b.d();
                    str = "安装并体验%s秒  可领取奖励";
                } else {
                    bVar.f = com.kwad.sdk.core.config.d.R();
                    str = "浏览详情页%s秒，领取奖励";
                }
                bVar.g = str;
                bVar.d = com.kwad.sdk.core.response.a.c.f(adTemplate);
                return bVar;
            }
            return (b) invokeL.objValue;
        }

        public final String a() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            return (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) ? String.format(this.g, Integer.valueOf(this.f)) : (String) invokeV.objValue;
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
        this.n = false;
        this.a = view2;
        c();
        this.o = new com.kwad.components.ad.g.a(view2);
    }

    private void a(View view2, boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLZ(65538, this, view2, z) == null) {
            int id = view2.getId();
            if (id == R.id.obfuscated_res_0x7f0910ee || id == R.id.obfuscated_res_0x7f0910ed || id == R.id.obfuscated_res_0x7f0910ef) {
                com.kwad.sdk.core.d.b.a("ApkInfoCardViewHelper", "onClick install");
                this.n = true;
                a aVar = this.m;
                if (aVar != null) {
                    aVar.a(z, 1);
                }
            }
        }
    }

    private void c() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(65541, this) == null) {
            this.c = (Button) this.a.findViewById(R.id.obfuscated_res_0x7f0910ed);
            this.e = (Button) this.a.findViewById(R.id.obfuscated_res_0x7f0910ef);
            this.b = this.a.findViewById(R.id.obfuscated_res_0x7f0910ee);
            this.g = (ImageView) this.a.findViewById(R.id.obfuscated_res_0x7f0910ec);
            this.f = (TextView) this.a.findViewById(R.id.obfuscated_res_0x7f0910f0);
            this.h = (TextView) this.a.findViewById(R.id.obfuscated_res_0x7f0910ea);
            this.j = (KSRatingBar) this.a.findViewById(R.id.obfuscated_res_0x7f0910f1);
            this.k = (KsAppTagsView) this.a.findViewById(R.id.obfuscated_res_0x7f0910f3);
        }
    }

    public final void a() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
            com.kwad.components.core.c.a.b bVar = this.l;
            if (bVar != null) {
                bVar.b(this);
            }
            com.kwad.components.ad.g.a aVar = this.o;
            if (aVar != null) {
                aVar.d();
            }
        }
    }

    @Override // com.kwad.sdk.core.download.kwai.a
    public final void a(int i) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, i) == null) {
            super.a(i);
            if (i != 0) {
                this.o.c();
                this.e.setText(com.kwad.sdk.core.response.a.a.b(i));
            }
        }
    }

    public final void a(a aVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(Constants.METHOD_SEND_USER_MSG, this, aVar) == null) {
            this.m = aVar;
        }
    }

    public final void a(com.kwad.components.core.c.a.b bVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048579, this, bVar) == null) {
            this.l = bVar;
            if (bVar != null) {
                bVar.a(this);
            }
        }
    }

    public final void a(AdTemplate adTemplate, boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLZ(1048580, this, adTemplate, z) == null) {
            this.p = adTemplate;
            b a2 = b.a(adTemplate);
            if (a2 == null) {
                return;
            }
            KSImageLoader.loadAppIcon(this.g, a2.a, adTemplate, 12);
            this.f.setText(a2.b);
            this.h.setText(a2.e);
            this.j.setStar(a2.c);
            if (com.kwad.sdk.core.response.a.d.a(adTemplate, com.kwad.components.ad.reward.kwai.b.d(com.kwad.sdk.core.response.a.d.i(adTemplate)))) {
                this.e.setText(com.kwad.sdk.core.response.a.a.H(com.kwad.sdk.core.response.a.d.i(adTemplate)));
                this.j.setVisibility(0);
            } else {
                this.e.setText("查看详情");
                this.j.setVisibility(8);
            }
            this.c.setText(a2.a());
            this.c.setClickable(true);
            this.e.setClickable(true);
            this.b.setClickable(true);
            new com.kwad.sdk.widget.f(this.c, this);
            new com.kwad.sdk.widget.f(this.e, this);
            new com.kwad.sdk.widget.f(this.b, this);
            List<String> list = a2.d;
            if (z && list.size() == 0) {
                this.h.setVisibility(8);
                TextView textView = (TextView) this.a.findViewById(R.id.obfuscated_res_0x7f0910eb);
                this.i = textView;
                textView.setVisibility(0);
                this.i.setText(a2.e);
            }
            if (list.size() == 0) {
                this.k.setVisibility(8);
            }
            this.k.setAppTags(list);
            this.b.postDelayed(new Runnable(this) { // from class: com.kwad.components.ad.reward.i.c.1
                public static /* synthetic */ Interceptable $ic;
                public transient /* synthetic */ FieldHolder $fh;
                public final /* synthetic */ c a;

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
                    this.a = this;
                }

                @Override // java.lang.Runnable
                public final void run() {
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 == null || interceptable2.invokeV(1048576, this) == null) {
                        int height = this.a.b.getHeight();
                        com.kwad.sdk.core.d.b.a("ApkInfoCardViewHelper", hashCode() + " parentHeight: " + height);
                        if (this.a.n) {
                            return;
                        }
                        this.a.o.a();
                    }
                }
            }, 1600L);
        }
    }

    public final void a(String str, int i) {
        Button button;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeLI(1048581, this, str, i) == null) || (button = this.e) == null || str == null || i == 0) {
            return;
        }
        button.setText(str);
    }

    @Override // com.kwad.sdk.widget.c
    public final void a_(View view2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048582, this, view2) == null) {
            a(view2, true);
        }
    }

    public final void b() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048583, this) == null) {
            this.o.c();
        }
    }

    @Override // com.kwad.sdk.widget.c
    public final void b(View view2) {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeL(InputDeviceCompat.SOURCE_TOUCHPAD, this, view2) == null) && com.kwad.sdk.core.response.a.c.d(this.p)) {
            a(view2, false);
        }
    }

    @Override // com.kwad.sdk.api.KsAppDownloadListener
    public final void onDownloadFailed() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048585, this) == null) {
            AdTemplate adTemplate = this.p;
            this.e.setText(adTemplate != null ? com.kwad.sdk.core.response.a.a.H(com.kwad.sdk.core.response.a.d.i(adTemplate)) : "立即下载");
        }
    }

    @Override // com.kwad.sdk.api.KsAppDownloadListener
    public final void onDownloadFinished() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048586, this) == null) {
            AdTemplate adTemplate = this.p;
            this.e.setText(adTemplate == null ? "" : com.kwad.sdk.core.response.a.a.a(adTemplate));
        }
    }

    @Override // com.kwad.sdk.core.download.kwai.a, com.kwad.sdk.api.KsAppDownloadListener
    public final void onDownloadStarted() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048587, this) == null) {
        }
    }

    @Override // com.kwad.sdk.api.KsAppDownloadListener
    public final void onIdle() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048588, this) == null) {
            AdTemplate adTemplate = this.p;
            this.e.setText(adTemplate != null ? com.kwad.sdk.core.response.a.a.H(com.kwad.sdk.core.response.a.d.i(adTemplate)) : "立即下载");
        }
    }

    @Override // com.kwad.sdk.api.KsAppDownloadListener
    public final void onInstalled() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048589, this) == null) {
            AdTemplate adTemplate = this.p;
            this.e.setText(adTemplate != null ? com.kwad.sdk.core.response.a.a.n(com.kwad.sdk.core.response.a.d.i(adTemplate)) : "立即打开");
        }
    }

    @Override // com.kwad.sdk.api.KsAppDownloadListener
    public final void onProgressUpdate(int i) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeI(1048590, this, i) == null) || i == 0) {
            return;
        }
        this.o.c();
        this.e.setText(com.kwad.sdk.core.response.a.a.a(i));
    }
}
