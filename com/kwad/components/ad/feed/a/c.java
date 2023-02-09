package com.kwad.components.ad.feed.a;

import android.content.Context;
import android.text.TextUtils;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.TextView;
import androidx.annotation.NonNull;
import androidx.core.view.InputDeviceCompat;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.tieba.R;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import com.kwad.components.ad.widget.DownloadProgressView;
import com.kwad.components.core.c.a.a;
import com.kwad.components.core.internal.api.KSAdVideoPlayConfigImpl;
import com.kwad.components.core.video.a;
import com.kwad.components.core.widget.KsLogoView;
import com.kwad.sdk.api.KsAdVideoPlayConfig;
import com.kwad.sdk.contentalliance.kwai.kwai.b;
import com.kwad.sdk.core.imageloader.KSImageLoader;
import com.kwad.sdk.core.report.u;
import com.kwad.sdk.core.response.model.AdTemplate;
import com.kwad.sdk.core.video.videoview.AdVideoPlayerViewCache;
import com.kwad.sdk.utils.aa;
import com.kwad.sdk.utils.h;
import com.kwad.sdk.widget.RatioFrameLayout;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import org.json.JSONObject;
/* loaded from: classes8.dex */
public abstract class c extends a implements View.OnClickListener {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public KsLogoView bq;
    public List<Integer> bv;
    public volatile boolean bw;
    public com.kwad.sdk.widget.j bx;
    public TextView cE;
    public ImageView cw;
    public TextView cx;
    public TextView de;
    public ImageView dg;
    public TextView dh;
    public TextView di;
    public View dj;
    public DownloadProgressView dk;
    public RatioFrameLayout dn;

    /* renamed from: do  reason: not valid java name */
    public ImageView f4do;
    public com.kwad.sdk.core.video.videoview.a dp;
    public com.kwad.components.core.video.c dq;
    public d dr;
    public boolean ds;
    public boolean dt;
    public final a.InterfaceC0609a du;
    public h.a dv;
    public a.b dw;
    public com.kwad.components.core.c.a.c mApkDownloadHelper;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public c(@NonNull Context context) {
        super(context);
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {context};
            interceptable.invokeUnInit(65536, newInitContext);
            int i = newInitContext.flag;
            if ((i & 1) != 0) {
                int i2 = i & 2;
                super((Context) newInitContext.callArgs[0]);
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
        this.ds = false;
        this.bw = false;
        this.bx = new com.kwad.sdk.widget.j(this) { // from class: com.kwad.components.ad.feed.a.c.1
            public static /* synthetic */ Interceptable $ic;
            public transient /* synthetic */ FieldHolder $fh;
            public final /* synthetic */ c dx;

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
                this.dx = this;
            }

            @Override // com.kwad.sdk.widget.j
            public final void av() {
                Interceptable interceptable2 = $ic;
                if (interceptable2 == null || interceptable2.invokeV(1048576, this) == null) {
                    com.kwad.sdk.utils.k.cj(this.dx.mAdTemplate);
                }
            }
        };
        this.du = new a.InterfaceC0609a(this) { // from class: com.kwad.components.ad.feed.a.c.2
            public static /* synthetic */ Interceptable $ic;
            public transient /* synthetic */ FieldHolder $fh;
            public final /* synthetic */ c dx;

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
                this.dx = this;
            }

            @Override // com.kwad.components.core.video.a.InterfaceC0609a
            public final void a(int i3, aa.a aVar) {
                int i4;
                Interceptable interceptable2 = $ic;
                if (interceptable2 == null || interceptable2.invokeIL(1048576, this, i3, aVar) == null) {
                    int i5 = 2;
                    boolean z = false;
                    if (i3 == 1) {
                        i4 = 15;
                    } else if (i3 == 2) {
                        i4 = 16;
                    } else if (i3 != 3) {
                        i4 = 35;
                    } else {
                        i4 = 39;
                        i5 = 1;
                        z = true;
                    }
                    u.b bVar = new u.b();
                    bVar.gL = aVar;
                    bVar.gJ = i4;
                    com.kwad.components.core.c.a.a.a(new a.C0598a(com.kwad.sdk.b.kwai.a.x(this.dx.dp)).L(this.dx.mAdTemplate).b(this.dx.mApkDownloadHelper).ae(i5).aj(z).al(true).an(true).a(bVar).a(new a.b(this) { // from class: com.kwad.components.ad.feed.a.c.2.1
                        public static /* synthetic */ Interceptable $ic;
                        public transient /* synthetic */ FieldHolder $fh;
                        public final /* synthetic */ AnonymousClass2 dy;

                        {
                            Interceptable interceptable3 = $ic;
                            if (interceptable3 != null) {
                                InitContext newInitContext2 = TitanRuntime.newInitContext();
                                newInitContext2.initArgs = r2;
                                Object[] objArr2 = {this};
                                interceptable3.invokeUnInit(65536, newInitContext2);
                                int i6 = newInitContext2.flag;
                                if ((i6 & 1) != 0) {
                                    int i7 = i6 & 2;
                                    newInitContext2.thisArg = this;
                                    interceptable3.invokeInitBody(65536, newInitContext2);
                                    return;
                                }
                            }
                            this.dy = this;
                        }

                        @Override // com.kwad.components.core.c.a.a.b
                        public final void onAdClicked() {
                            Interceptable interceptable3 = $ic;
                            if (interceptable3 == null || interceptable3.invokeV(1048576, this) == null) {
                                this.dy.dx.dx();
                            }
                        }
                    }));
                }
            }
        };
        this.dv = new h.a(this) { // from class: com.kwad.components.ad.feed.a.c.4
            public static /* synthetic */ Interceptable $ic;
            public transient /* synthetic */ FieldHolder $fh;
            public final /* synthetic */ c dx;

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
                this.dx = this;
            }

            @Override // com.kwad.sdk.utils.h.a
            public final void bk() {
                Interceptable interceptable2 = $ic;
                if (interceptable2 == null || interceptable2.invokeV(1048576, this) == null) {
                    c.a(this.dx, false);
                    if (this.dx.dp != null) {
                        this.dx.dp.setVideoSoundEnable(false);
                    }
                }
            }

            @Override // com.kwad.sdk.utils.h.a
            public final void bl() {
                Interceptable interceptable2 = $ic;
                if (interceptable2 == null || interceptable2.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this) == null) {
                }
            }
        };
        this.dw = new a.b(this) { // from class: com.kwad.components.ad.feed.a.c.6
            public static /* synthetic */ Interceptable $ic;
            public transient /* synthetic */ FieldHolder $fh;
            public final /* synthetic */ c dx;

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
                this.dx = this;
            }

            @Override // com.kwad.components.core.video.a.b
            public final void bm() {
                Interceptable interceptable2 = $ic;
                if (interceptable2 == null || interceptable2.invokeV(1048576, this) == null) {
                    if (com.kwad.components.ad.feed.kwai.b.bc() && this.dx.dr == null) {
                        this.dx.dr = new d(this.dx.getContext());
                        FrameLayout.LayoutParams layoutParams = new FrameLayout.LayoutParams(-1, -1);
                        c cVar = this.dx;
                        cVar.addView(cVar.dr, layoutParams);
                        this.dx.dr.bn();
                    }
                    com.kwad.sdk.core.report.a.ax(this.dx.mAdTemplate);
                }
            }

            @Override // com.kwad.components.core.video.a.b
            public final void d(long j) {
                Interceptable interceptable2 = $ic;
                if (interceptable2 == null || interceptable2.invokeJ(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, j) == null) {
                    this.dx.c(j);
                }
            }

            @Override // com.kwad.components.core.video.a.b
            public final void onVideoPlayStart() {
                Interceptable interceptable2 = $ic;
                if (interceptable2 == null || interceptable2.invokeV(Constants.METHOD_SEND_USER_MSG, this) == null) {
                    if (this.dx.dr != null && (this.dx.dr.getParent() instanceof ViewGroup)) {
                        ((ViewGroup) this.dx.dr.getParent()).removeView(this.dx.dr);
                        this.dx.dr.bo();
                        this.dx.dr = null;
                    }
                    com.kwad.sdk.core.report.a.aw(this.dx.mAdTemplate);
                }
            }

            @Override // com.kwad.components.core.video.a.b
            public final void onVideoPlaying() {
                Interceptable interceptable2 = $ic;
                if (interceptable2 == null || interceptable2.invokeV(1048579, this) == null) {
                    com.kwad.sdk.core.video.videoview.a aVar = this.dx.dp;
                    c cVar = this.dx;
                    aVar.setVideoSoundEnable(cVar.h(cVar.ds));
                }
            }
        };
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Code restructure failed: missing block: B:34:0x0059, code lost:
        if (r7 == r4.dp) goto L15;
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public void a(com.kwad.sdk.core.video.videoview.a aVar, boolean z, View view2) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeCommon(65542, this, new Object[]{aVar, Boolean.valueOf(z), view2}) == null) || aVar == null) {
            return;
        }
        String A = com.kwad.sdk.core.response.a.a.A(this.mAdInfo);
        this.dq.setAutoRelease(false);
        int i = z ? 1 : 2;
        AdVideoPlayerViewCache.getInstance().a(A, this.dp);
        int i2 = 35;
        if (view2 == this.de) {
            i2 = 25;
        } else {
            if (view2 != this.dn) {
                if (view2 == this.dk || view2 == this.cE || view2 == this.dj) {
                    i2 = 1;
                } else if (view2 == this.cw) {
                    i2 = 13;
                } else if (view2 == this.cx) {
                    i2 = 14;
                } else if (view2 == this.dh || view2 == this.di) {
                    i2 = 101;
                }
            }
            i2 = 100;
        }
        com.kwad.components.core.c.a.a.a(new a.C0598a(com.kwad.sdk.b.kwai.a.x(this)).L(this.mAdTemplate).b(this.mApkDownloadHelper).aj(z).ae(i).an(true).a(new a.b(this, i2) { // from class: com.kwad.components.ad.feed.a.c.5
            public static /* synthetic */ Interceptable $ic;
            public transient /* synthetic */ FieldHolder $fh;
            public final /* synthetic */ int dl;
            public final /* synthetic */ c dx;

            {
                Interceptable interceptable2 = $ic;
                if (interceptable2 != null) {
                    InitContext newInitContext = TitanRuntime.newInitContext();
                    newInitContext.initArgs = r2;
                    Object[] objArr = {this, Integer.valueOf(i2)};
                    interceptable2.invokeUnInit(65536, newInitContext);
                    int i3 = newInitContext.flag;
                    if ((i3 & 1) != 0) {
                        int i4 = i3 & 2;
                        newInitContext.thisArg = this;
                        interceptable2.invokeInitBody(65536, newInitContext);
                        return;
                    }
                }
                this.dx = this;
                this.dl = i2;
            }

            @Override // com.kwad.components.core.c.a.a.b
            public final void onAdClicked() {
                Interceptable interceptable2 = $ic;
                if (interceptable2 == null || interceptable2.invokeV(1048576, this) == null) {
                    this.dx.aq(this.dl);
                }
            }
        }));
    }

    public static /* synthetic */ boolean a(c cVar, boolean z) {
        cVar.dt = false;
        return false;
    }

    private void bh() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(65546, this) == null) {
            findViewById(R.id.obfuscated_res_0x7f091143).setVisibility(0);
            findViewById(R.id.obfuscated_res_0x7f091142).setVisibility(8);
            this.di = (TextView) findViewById(R.id.obfuscated_res_0x7f0911b0);
            this.cE = (TextView) findViewById(R.id.obfuscated_res_0x7f0911b2);
            this.dj = findViewById(R.id.obfuscated_res_0x7f0911b3);
            this.di.setText(com.kwad.components.ad.feed.f.d(this.mAdTemplate));
            this.cE.setText(com.kwad.sdk.core.response.a.a.al(this.mAdInfo));
            this.dj.setOnClickListener(this);
            this.di.setOnClickListener(this);
            this.cE.setOnClickListener(this);
        }
    }

    private void bi() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(65547, this) == null) {
            findViewById(R.id.obfuscated_res_0x7f091142).setVisibility(0);
            findViewById(R.id.obfuscated_res_0x7f091143).setVisibility(8);
            this.cw = (ImageView) findViewById(R.id.obfuscated_res_0x7f091159);
            this.cx = (TextView) findViewById(R.id.obfuscated_res_0x7f09115d);
            TextView textView = (TextView) findViewById(R.id.obfuscated_res_0x7f091155);
            this.dh = textView;
            com.kwad.sdk.b.kwai.a.a(this, this.cw, this.cx, textView);
            this.cx.setText(com.kwad.sdk.core.response.a.a.ae(this.mAdInfo));
            this.cw.setImageResource(R.drawable.obfuscated_res_0x7f080c72);
            KSImageLoader.loadAppIcon(this.cw, com.kwad.sdk.core.response.a.a.bn(this.mAdInfo), this.mAdTemplate, 8);
            this.dh.setText(com.kwad.components.ad.feed.f.d(this.mAdTemplate));
            bf();
            this.dk.F(this.mAdTemplate);
            this.dk.setOnClickListener(this);
            com.kwad.components.core.c.a.c cVar = new com.kwad.components.core.c.a.c(this.mAdTemplate, null, this.dk.getAppDownloadListener());
            this.mApkDownloadHelper = cVar;
            cVar.d(this.dk.getAppDownloadListener());
            this.mApkDownloadHelper.setOnShowListener(this);
            this.mApkDownloadHelper.setOnDismissListener(this);
            g(true);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void c(long j) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeJ(65549, this, j) == null) {
            int ceil = (int) Math.ceil(((float) j) / 1000.0f);
            List<Integer> list = this.bv;
            if (list == null || list.isEmpty()) {
                return;
            }
            Iterator<Integer> it = this.bv.iterator();
            while (it.hasNext()) {
                if (ceil >= it.next().intValue()) {
                    com.kwad.sdk.core.report.a.b(this.mAdTemplate, ceil, (JSONObject) null);
                    it.remove();
                    return;
                }
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public boolean h(boolean z) {
        InterceptResult invokeZ;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeZ = interceptable.invokeZ(65555, this, z)) == null) {
            if (z) {
                if (!com.kwad.sdk.core.config.d.fY()) {
                    return !com.kwad.components.core.m.b.at(this.mContext).ow() ? com.kwad.components.core.m.b.at(this.mContext).ay(false) : !com.kwad.components.core.m.b.at(this.mContext).ov();
                }
                if (!this.dt) {
                    this.dt = com.kwad.components.core.m.b.at(this.mContext).ay(true);
                }
                return this.dt;
            }
            return false;
        }
        return invokeZ.booleanValue;
    }

    public final void a(@NonNull KsAdVideoPlayConfig ksAdVideoPlayConfig) {
        ImageView imageView;
        int i;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048576, this, ksAdVideoPlayConfig) == null) {
            this.ds = (!(ksAdVideoPlayConfig instanceof KSAdVideoPlayConfigImpl) || ((KSAdVideoPlayConfigImpl) ksAdVideoPlayConfig).getVideoSoundValue() == 0) ? com.kwad.sdk.core.response.a.a.bh(this.mAdInfo) : ksAdVideoPlayConfig.isVideoSoundEnable();
            String url = com.kwad.sdk.core.response.a.a.aL(this.mAdInfo).getUrl();
            if (TextUtils.isEmpty(url)) {
                imageView = this.f4do;
                i = 8;
            } else {
                this.f4do.setImageDrawable(null);
                KSImageLoader.loadImage(this.f4do, url, this.mAdTemplate);
                imageView = this.f4do;
                i = 0;
            }
            imageView.setVisibility(i);
            this.bv = com.kwad.sdk.core.response.a.a.aF(this.mAdInfo);
            com.kwad.sdk.core.video.videoview.a aVar = new com.kwad.sdk.core.video.videoview.a(this.mContext);
            this.dp = aVar;
            aVar.setVisibleListener(this.bx);
            this.dp.setOnClickListener(this);
            this.dp.setTag(this.bv);
            String A = com.kwad.sdk.core.response.a.a.A(this.mAdInfo);
            if (TextUtils.isEmpty(A)) {
                return;
            }
            this.dp.a(new b.a(this.mAdTemplate).bk(A).bl(com.kwad.sdk.core.response.a.f.b(com.kwad.sdk.core.response.a.d.bR(this.mAdTemplate))).a(this.mAdTemplate.mVideoPlayerStatus).b(com.kwad.sdk.contentalliance.kwai.kwai.a.al(this.mAdTemplate)).rC(), (Map<String, String>) null);
            this.dp.setVideoSoundEnable(h(this.ds));
            com.kwad.components.core.video.c cVar = new com.kwad.components.core.video.c(this.mContext, this.mAdTemplate, this.dp, ksAdVideoPlayConfig);
            this.dq = cVar;
            cVar.setAdClickListener(this.du);
            this.dq.setVideoPlayCallback(this.dw);
            this.dp.setController(this.dq);
            if (this.dn.getTag() != null) {
                RatioFrameLayout ratioFrameLayout = this.dn;
                ratioFrameLayout.removeView((View) ratioFrameLayout.getTag());
                this.dn.setTag(null);
            }
            this.dn.addView(this.dp);
            this.dn.setTag(this.dp);
            this.dn.setClickable(true);
            this.dn.setOnClickListener(new View.OnClickListener(this) { // from class: com.kwad.components.ad.feed.a.c.3
                public static /* synthetic */ Interceptable $ic;
                public transient /* synthetic */ FieldHolder $fh;
                public final /* synthetic */ c dx;

                {
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 != null) {
                        InitContext newInitContext = TitanRuntime.newInitContext();
                        newInitContext.initArgs = r2;
                        Object[] objArr = {this};
                        interceptable2.invokeUnInit(65536, newInitContext);
                        int i2 = newInitContext.flag;
                        if ((i2 & 1) != 0) {
                            int i3 = i2 & 2;
                            newInitContext.thisArg = this;
                            interceptable2.invokeInitBody(65536, newInitContext);
                            return;
                        }
                    }
                    this.dx = this;
                }

                @Override // android.view.View.OnClickListener
                public final void onClick(View view2) {
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 == null || interceptable2.invokeL(1048576, this, view2) == null) {
                        if (!this.dx.dp.isIdle()) {
                            c cVar2 = this.dx;
                            cVar2.a(cVar2.dp, false, view2);
                            return;
                        }
                        com.kwad.sdk.utils.k.ci(this.dx.mAdTemplate);
                        this.dx.dp.setKsPlayLogParam(com.kwad.sdk.contentalliance.kwai.kwai.a.al(this.dx.mAdTemplate));
                        this.dx.dp.start();
                    }
                }
            });
            if (this.ds) {
                com.kwad.components.core.m.b.at(this.mContext).a(this.dv);
            }
        }
    }

    @Override // com.kwad.components.core.widget.b, com.kwad.sdk.core.h.b
    public final void aR() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this) == null) {
            super.aR();
            com.kwad.components.core.video.c cVar = this.dq;
            if (cVar != null) {
                cVar.setVideoPlayCallback(this.dw);
            }
        }
    }

    @Override // com.kwad.components.core.widget.b, com.kwad.sdk.widget.KSFrameLayout
    public final void am() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this) == null) {
            super.am();
        }
    }

    @Override // com.kwad.components.core.widget.b, com.kwad.sdk.widget.KSFrameLayout
    public final void an() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048579, this) == null) {
            super.an();
            com.kwad.sdk.utils.k.ch(this.mAdTemplate);
        }
    }

    @Override // com.kwad.components.core.widget.b
    public final void bg() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048580, this) == null) {
            this.de = (TextView) findViewById(R.id.obfuscated_res_0x7f09113e);
            RatioFrameLayout ratioFrameLayout = (RatioFrameLayout) findViewById(R.id.obfuscated_res_0x7f091309);
            this.dn = ratioFrameLayout;
            ratioFrameLayout.setRatio(0.56f);
            this.dg = (ImageView) findViewById(R.id.obfuscated_res_0x7f091140);
            this.f4do = (ImageView) findViewById(R.id.obfuscated_res_0x7f091319);
            this.bq = (KsLogoView) findViewById(R.id.obfuscated_res_0x7f091141);
            this.dk = (DownloadProgressView) findViewById(R.id.obfuscated_res_0x7f091157);
        }
    }

    @Override // com.kwad.components.core.widget.b
    public final void bj() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048581, this) == null) {
            super.bj();
            com.kwad.components.core.c.a.c cVar = this.mApkDownloadHelper;
            if (cVar != null) {
                cVar.c(this.dk.getAppDownloadListener());
            }
            if (this.ds) {
                com.kwad.components.core.m.b.at(this.mContext).b(this.dv);
            }
            g(false);
        }
    }

    @Override // com.kwad.components.core.widget.b
    public final void c(@NonNull AdTemplate adTemplate) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048582, this, adTemplate) == null) {
            super.c((c) adTemplate);
            this.de.setText(com.kwad.components.ad.feed.f.d(this.mAdTemplate));
            this.bq.T(adTemplate);
            if (com.kwad.sdk.core.response.a.a.am(this.mAdInfo)) {
                bi();
            } else {
                bh();
            }
            this.de.setOnClickListener(this);
            this.dn.setOnClickListener(this);
            this.dg.setOnClickListener(this);
            setOnClickListener(this);
        }
    }

    @Override // com.kwad.components.ad.feed.a.a
    public com.kwad.components.core.c.a.c getApkDownloadHelper() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048583, this)) == null) ? this.mApkDownloadHelper : (com.kwad.components.core.c.a.c) invokeV.objValue;
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(InputDeviceCompat.SOURCE_TOUCHPAD, this, view2) == null) {
            if (view2 == this.dg) {
                pX();
                return;
            }
            g(false);
            a(this.dp, view2 == this.dk, view2);
        }
    }

    @Override // android.view.View
    public void onWindowFocusChanged(boolean z) {
        com.kwad.sdk.core.video.videoview.a aVar;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(1048585, this, z) == null) {
            super.onWindowFocusChanged(z);
            if (!z || (aVar = this.dp) == null) {
                return;
            }
            ViewGroup viewGroup = (ViewGroup) aVar.getParent();
            if (this.dp.getParent() != this.dn) {
                viewGroup.removeView(this.dp);
                if (this.dn.getTag() != null) {
                    RatioFrameLayout ratioFrameLayout = this.dn;
                    ratioFrameLayout.removeView((View) ratioFrameLayout.getTag());
                    this.dn.setTag(null);
                }
                this.dn.addView(this.dp);
                this.dn.setTag(this.dp);
                String A = com.kwad.sdk.core.response.a.a.A(this.mAdInfo);
                this.dp.setVideoSoundEnable(this.ds);
                this.dq.setAdClickListener(this.du);
                this.dq.getAdTemplate().mAdWebVideoPageShowing = false;
                this.dq.pe();
                this.dq.setAutoRelease(true);
                AdVideoPlayerViewCache.getInstance().remove(A);
            }
        }
    }
}
