package com.kwad.components.ad.feed.a;

import android.content.Context;
import android.content.DialogInterface;
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
import com.kwad.sdk.utils.h;
import com.kwad.sdk.utils.y;
import com.kwad.sdk.widget.RatioFrameLayout;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import org.json.JSONObject;
/* loaded from: classes5.dex */
public abstract class c extends a implements View.OnClickListener {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public h.a A;
    public a.b B;
    public TextView a;
    public RatioFrameLayout b;
    public ImageView c;
    public KsLogoView d;
    public com.kwad.components.core.c.a.b e;
    public ImageView f;
    public List<Integer> g;
    public com.kwad.sdk.core.video.videoview.a h;
    public com.kwad.components.core.video.c i;
    public DownloadProgressView n;
    public d o;
    public boolean p;
    public boolean q;
    public volatile boolean r;
    public ImageView s;
    public TextView t;
    public TextView u;
    public TextView v;
    public TextView w;
    public View x;
    public com.kwad.sdk.widget.j y;
    public final a.InterfaceC0518a z;

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
        this.p = false;
        this.r = false;
        this.y = new com.kwad.sdk.widget.j(this) { // from class: com.kwad.components.ad.feed.a.c.1
            public static /* synthetic */ Interceptable $ic;
            public transient /* synthetic */ FieldHolder $fh;
            public final /* synthetic */ c a;

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
                this.a = this;
            }

            @Override // com.kwad.sdk.widget.j
            public final void a() {
                Interceptable interceptable2 = $ic;
                if (interceptable2 == null || interceptable2.invokeV(1048576, this) == null) {
                    com.kwad.sdk.utils.k.c(this.a.j);
                }
            }
        };
        this.z = new a.InterfaceC0518a(this) { // from class: com.kwad.components.ad.feed.a.c.2
            public static /* synthetic */ Interceptable $ic;
            public transient /* synthetic */ FieldHolder $fh;
            public final /* synthetic */ c a;

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
                this.a = this;
            }

            @Override // com.kwad.components.core.video.a.InterfaceC0518a
            public final void a(int i3, y.a aVar) {
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
                    bVar.i = aVar;
                    bVar.c = i4;
                    com.kwad.components.core.c.a.a.a(new a.C0507a(com.kwad.sdk.b.kwai.a.a(this.a.h)).a(this.a.j).a(this.a.e).a(i5).a(z).c(true).e(true).a(bVar).a(new a.b(this) { // from class: com.kwad.components.ad.feed.a.c.2.1
                        public static /* synthetic */ Interceptable $ic;
                        public transient /* synthetic */ FieldHolder $fh;
                        public final /* synthetic */ AnonymousClass2 a;

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
                            this.a = this;
                        }

                        @Override // com.kwad.components.core.c.a.a.b
                        public final void a() {
                            Interceptable interceptable3 = $ic;
                            if (interceptable3 == null || interceptable3.invokeV(1048576, this) == null) {
                                this.a.a.g();
                            }
                        }
                    }));
                }
            }
        };
        this.A = new h.a(this) { // from class: com.kwad.components.ad.feed.a.c.4
            public static /* synthetic */ Interceptable $ic;
            public transient /* synthetic */ FieldHolder $fh;
            public final /* synthetic */ c a;

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
                this.a = this;
            }

            @Override // com.kwad.sdk.utils.h.a
            public final void a() {
                Interceptable interceptable2 = $ic;
                if (interceptable2 == null || interceptable2.invokeV(1048576, this) == null) {
                    this.a.q = false;
                    if (this.a.h != null) {
                        this.a.h.setVideoSoundEnable(false);
                    }
                }
            }

            @Override // com.kwad.sdk.utils.h.a
            public final void b() {
                Interceptable interceptable2 = $ic;
                if (interceptable2 == null || interceptable2.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this) == null) {
                }
            }
        };
        this.B = new a.b(this) { // from class: com.kwad.components.ad.feed.a.c.6
            public static /* synthetic */ Interceptable $ic;
            public transient /* synthetic */ FieldHolder $fh;
            public final /* synthetic */ c a;

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
                this.a = this;
            }

            @Override // com.kwad.components.core.video.a.b
            public final void a(long j) {
                Interceptable interceptable2 = $ic;
                if (interceptable2 == null || interceptable2.invokeJ(1048576, this, j) == null) {
                    this.a.a(j);
                }
            }

            @Override // com.kwad.components.core.video.a.b
            public final void f_() {
                Interceptable interceptable2 = $ic;
                if (interceptable2 == null || interceptable2.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this) == null) {
                    if (this.a.o != null && (this.a.o.getParent() instanceof ViewGroup)) {
                        ((ViewGroup) this.a.o.getParent()).removeView(this.a.o);
                        this.a.o.b();
                        this.a.o = null;
                    }
                    com.kwad.sdk.core.report.a.h(this.a.j);
                }
            }

            @Override // com.kwad.components.core.video.a.b
            public final void g_() {
                Interceptable interceptable2 = $ic;
                if (interceptable2 == null || interceptable2.invokeV(Constants.METHOD_SEND_USER_MSG, this) == null) {
                    com.kwad.sdk.core.video.videoview.a aVar = this.a.h;
                    c cVar = this.a;
                    aVar.setVideoSoundEnable(cVar.b(cVar.p));
                }
            }

            @Override // com.kwad.components.core.video.a.b
            public final void h_() {
                Interceptable interceptable2 = $ic;
                if (interceptable2 == null || interceptable2.invokeV(1048579, this) == null) {
                    if (com.kwad.components.ad.feed.kwai.b.a() && this.a.o == null) {
                        this.a.o = new d(this.a.getContext());
                        FrameLayout.LayoutParams layoutParams = new FrameLayout.LayoutParams(-1, -1);
                        c cVar = this.a;
                        cVar.addView(cVar.o, layoutParams);
                        this.a.o.a();
                    }
                    com.kwad.sdk.core.report.a.i(this.a.j);
                }
            }
        };
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(long j) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeJ(65539, this, j) == null) {
            int ceil = (int) Math.ceil(((float) j) / 1000.0f);
            List<Integer> list = this.g;
            if (list == null || list.isEmpty()) {
                return;
            }
            Iterator<Integer> it = this.g.iterator();
            while (it.hasNext()) {
                if (ceil >= it.next().intValue()) {
                    com.kwad.sdk.core.report.a.b(this.j, ceil, (JSONObject) null);
                    it.remove();
                    return;
                }
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Code restructure failed: missing block: B:34:0x0059, code lost:
        if (r7 == r4.h) goto L15;
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public void a(com.kwad.sdk.core.video.videoview.a aVar, boolean z, View view2) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeCommon(65543, this, new Object[]{aVar, Boolean.valueOf(z), view2}) == null) || aVar == null) {
            return;
        }
        String b = com.kwad.sdk.core.response.a.a.b(this.k);
        this.i.setAutoRelease(false);
        int i = z ? 1 : 2;
        AdVideoPlayerViewCache.a().a(b, this.h);
        int i2 = 35;
        if (view2 == this.a) {
            i2 = 25;
        } else {
            if (view2 != this.b) {
                if (view2 == this.n || view2 == this.w || view2 == this.x) {
                    i2 = 1;
                } else if (view2 == this.s) {
                    i2 = 13;
                } else if (view2 == this.t) {
                    i2 = 14;
                } else if (view2 == this.u || view2 == this.v) {
                    i2 = 101;
                }
            }
            i2 = 100;
        }
        com.kwad.components.core.c.a.a.a(new a.C0507a(com.kwad.sdk.b.kwai.a.a(this)).a(this.j).a(this.e).a(z).a(i).e(true).a(new a.b(this, i2) { // from class: com.kwad.components.ad.feed.a.c.5
            public static /* synthetic */ Interceptable $ic;
            public transient /* synthetic */ FieldHolder $fh;
            public final /* synthetic */ int a;
            public final /* synthetic */ c b;

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
                this.b = this;
                this.a = i2;
            }

            @Override // com.kwad.components.core.c.a.a.b
            public final void a() {
                Interceptable interceptable2 = $ic;
                if (interceptable2 == null || interceptable2.invokeV(1048576, this) == null) {
                    this.b.a(this.a);
                }
            }
        }));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public boolean b(boolean z) {
        InterceptResult invokeZ;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeZ = interceptable.invokeZ(65547, this, z)) == null) {
            if (z) {
                if (!com.kwad.sdk.core.config.d.Z()) {
                    return !com.kwad.components.core.l.b.a(this.m).b() ? com.kwad.components.core.l.b.a(this.m).a(false) : !com.kwad.components.core.l.b.a(this.m).a();
                }
                if (!this.q) {
                    this.q = com.kwad.components.core.l.b.a(this.m).a(true);
                }
                return this.q;
            }
            return false;
        }
        return invokeZ.booleanValue;
    }

    private void f() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(65552, this) == null) {
            findViewById(R.id.obfuscated_res_0x7f090fdf).setVisibility(0);
            findViewById(R.id.obfuscated_res_0x7f090fde).setVisibility(8);
            this.v = (TextView) findViewById(R.id.obfuscated_res_0x7f09104c);
            this.w = (TextView) findViewById(R.id.obfuscated_res_0x7f09104e);
            this.x = findViewById(R.id.obfuscated_res_0x7f09104f);
            this.v.setText(com.kwad.sdk.core.response.a.a.z(this.k));
            this.w.setText(com.kwad.sdk.core.response.a.a.H(this.k));
            this.x.setOnClickListener(this);
            this.v.setOnClickListener(this);
            this.w.setOnClickListener(this);
        }
    }

    private void i() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(65556, this) == null) {
            findViewById(R.id.obfuscated_res_0x7f090fde).setVisibility(0);
            findViewById(R.id.obfuscated_res_0x7f090fdf).setVisibility(8);
            this.s = (ImageView) findViewById(R.id.obfuscated_res_0x7f090ff5);
            this.t = (TextView) findViewById(R.id.obfuscated_res_0x7f090ff9);
            TextView textView = (TextView) findViewById(R.id.obfuscated_res_0x7f090ff1);
            this.u = textView;
            com.kwad.sdk.b.kwai.a.a(this, this.s, this.t, textView);
            this.t.setText(com.kwad.sdk.core.response.a.a.A(this.k));
            this.s.setImageResource(R.drawable.obfuscated_res_0x7f080bc0);
            KSImageLoader.loadAppIcon(this.s, com.kwad.sdk.core.response.a.a.aE(this.k), this.j, 8);
            this.u.setText(com.kwad.sdk.core.response.a.a.z(this.k));
            a((View.OnClickListener) this);
            this.n.a(this.j);
            this.n.setOnClickListener(this);
            com.kwad.components.core.c.a.b bVar = new com.kwad.components.core.c.a.b(this.j, null, this.n.getAppDownloadListener());
            this.e = bVar;
            bVar.c(this.n.getAppDownloadListener());
            this.e.a((DialogInterface.OnShowListener) this);
            this.e.a((DialogInterface.OnDismissListener) this);
            a(true);
        }
    }

    public final void a(@NonNull KsAdVideoPlayConfig ksAdVideoPlayConfig) {
        ImageView imageView;
        int i;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048576, this, ksAdVideoPlayConfig) == null) {
            this.p = (!(ksAdVideoPlayConfig instanceof KSAdVideoPlayConfigImpl) || ((KSAdVideoPlayConfigImpl) ksAdVideoPlayConfig).getVideoSoundValue() == 0) ? com.kwad.sdk.core.response.a.a.ay(this.k) : ksAdVideoPlayConfig.isVideoSoundEnable();
            String a = com.kwad.sdk.core.response.a.a.ae(this.k).a();
            if (TextUtils.isEmpty(a)) {
                imageView = this.f;
                i = 8;
            } else {
                this.f.setImageDrawable(null);
                KSImageLoader.loadImage(this.f, a, this.j);
                imageView = this.f;
                i = 0;
            }
            imageView.setVisibility(i);
            this.g = com.kwad.sdk.core.response.a.a.Z(this.k);
            com.kwad.sdk.core.video.videoview.a aVar = new com.kwad.sdk.core.video.videoview.a(this.m);
            this.h = aVar;
            aVar.setVisibleListener(this.y);
            this.h.setOnClickListener(this);
            this.h.setTag(this.g);
            String b = com.kwad.sdk.core.response.a.a.b(this.k);
            if (TextUtils.isEmpty(b)) {
                return;
            }
            this.h.a(new b.a(this.j).a(b).b(com.kwad.sdk.core.response.a.f.b(com.kwad.sdk.core.response.a.d.j(this.j))).a(this.j.mVideoPlayerStatus).a(com.kwad.sdk.contentalliance.kwai.kwai.a.a(this.j)).a(), (Map<String, String>) null);
            this.h.setVideoSoundEnable(b(this.p));
            com.kwad.components.core.video.c cVar = new com.kwad.components.core.video.c(this.m, this.j, this.h, ksAdVideoPlayConfig);
            this.i = cVar;
            cVar.setAdClickListener(this.z);
            this.i.setVideoPlayCallback(this.B);
            this.h.setController(this.i);
            if (this.b.getTag() != null) {
                RatioFrameLayout ratioFrameLayout = this.b;
                ratioFrameLayout.removeView((View) ratioFrameLayout.getTag());
                this.b.setTag(null);
            }
            this.b.addView(this.h);
            this.b.setTag(this.h);
            this.b.setClickable(true);
            this.b.setOnClickListener(new View.OnClickListener(this) { // from class: com.kwad.components.ad.feed.a.c.3
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
                        int i2 = newInitContext.flag;
                        if ((i2 & 1) != 0) {
                            int i3 = i2 & 2;
                            newInitContext.thisArg = this;
                            interceptable2.invokeInitBody(65536, newInitContext);
                            return;
                        }
                    }
                    this.a = this;
                }

                @Override // android.view.View.OnClickListener
                public final void onClick(View view2) {
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 == null || interceptable2.invokeL(1048576, this, view2) == null) {
                        if (!this.a.h.d()) {
                            c cVar2 = this.a;
                            cVar2.a(cVar2.h, false, view2);
                            return;
                        }
                        com.kwad.sdk.utils.k.b(this.a.j);
                        this.a.h.setKsPlayLogParam(com.kwad.sdk.contentalliance.kwai.kwai.a.a(this.a.j));
                        this.a.h.a();
                    }
                }
            });
            if (this.p) {
                com.kwad.components.core.l.b.a(this.m).a(this.A);
            }
        }
    }

    @Override // com.kwad.components.core.widget.b
    public final void a(@NonNull AdTemplate adTemplate) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, adTemplate) == null) {
            super.a((c) adTemplate);
            this.a.setText(com.kwad.sdk.core.response.a.a.z(this.k));
            this.d.a(adTemplate);
            if (com.kwad.sdk.core.response.a.a.I(this.k)) {
                i();
            } else {
                f();
            }
            this.a.setOnClickListener(this);
            this.b.setOnClickListener(this);
            this.c.setOnClickListener(this);
            setOnClickListener(this);
        }
    }

    @Override // com.kwad.components.core.widget.b, com.kwad.sdk.widget.KSFrameLayout
    public final void a_() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this) == null) {
            super.a_();
            com.kwad.sdk.utils.k.a(this.j);
        }
    }

    @Override // com.kwad.components.core.widget.b, com.kwad.sdk.widget.KSFrameLayout
    public final void b_() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048579, this) == null) {
            super.b_();
        }
    }

    @Override // com.kwad.components.core.widget.b
    public final void c() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048580, this) == null) {
            this.a = (TextView) findViewById(R.id.obfuscated_res_0x7f090fda);
            RatioFrameLayout ratioFrameLayout = (RatioFrameLayout) findViewById(R.id.obfuscated_res_0x7f0911c3);
            this.b = ratioFrameLayout;
            ratioFrameLayout.setRatio(0.56f);
            this.c = (ImageView) findViewById(R.id.obfuscated_res_0x7f090fdc);
            this.f = (ImageView) findViewById(R.id.obfuscated_res_0x7f0911d3);
            this.d = (KsLogoView) findViewById(R.id.obfuscated_res_0x7f090fdd);
            this.n = (DownloadProgressView) findViewById(R.id.obfuscated_res_0x7f090ff3);
        }
    }

    @Override // com.kwad.components.core.widget.b
    public final void d() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048581, this) == null) {
            super.d();
            com.kwad.components.core.c.a.b bVar = this.e;
            if (bVar != null) {
                bVar.b(this.n.getAppDownloadListener());
            }
            if (this.p) {
                com.kwad.components.core.l.b.a(this.m).b(this.A);
            }
            a(false);
        }
    }

    @Override // com.kwad.components.ad.feed.a.a
    public com.kwad.components.core.c.a.b getApkDownloadHelper() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048582, this)) == null) ? this.e : (com.kwad.components.core.c.a.b) invokeV.objValue;
    }

    @Override // com.kwad.components.core.widget.b, com.kwad.sdk.core.g.b
    public final void m_() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048583, this) == null) {
            super.m_();
            com.kwad.components.core.video.c cVar = this.i;
            if (cVar != null) {
                cVar.setVideoPlayCallback(this.B);
            }
        }
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(InputDeviceCompat.SOURCE_TOUCHPAD, this, view2) == null) {
            if (view2 == this.c) {
                h();
                return;
            }
            a(false);
            a(this.h, view2 == this.n, view2);
        }
    }

    @Override // android.view.View
    public void onWindowFocusChanged(boolean z) {
        com.kwad.sdk.core.video.videoview.a aVar;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(1048585, this, z) == null) {
            super.onWindowFocusChanged(z);
            if (!z || (aVar = this.h) == null) {
                return;
            }
            ViewGroup viewGroup = (ViewGroup) aVar.getParent();
            if (this.h.getParent() != this.b) {
                viewGroup.removeView(this.h);
                if (this.b.getTag() != null) {
                    RatioFrameLayout ratioFrameLayout = this.b;
                    ratioFrameLayout.removeView((View) ratioFrameLayout.getTag());
                    this.b.setTag(null);
                }
                this.b.addView(this.h);
                this.b.setTag(this.h);
                String b = com.kwad.sdk.core.response.a.a.b(this.k);
                this.h.setVideoSoundEnable(this.p);
                this.i.setAdClickListener(this.z);
                this.i.getAdTemplate().mAdWebVideoPageShowing = false;
                this.i.o();
                this.i.setAutoRelease(true);
                AdVideoPlayerViewCache.a().a(b);
            }
        }
    }
}
