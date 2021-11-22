package com.kwad.sdk.a.a;

import android.annotation.SuppressLint;
import android.text.TextUtils;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import com.kwad.sdk.R;
import com.kwad.sdk.a.a.a;
import com.kwad.sdk.core.imageloader.KSImageLoader;
import com.kwad.sdk.core.page.widget.TextProgressBar;
import com.kwad.sdk.core.response.model.AdInfo;
import com.kwad.sdk.core.response.model.AdTemplate;
import com.kwad.sdk.core.video.videoview.a;
import com.kwad.sdk.mvp.Presenter;
import com.kwad.sdk.utils.av;
import com.kwad.sdk.widget.KSFrameLayout;
import com.kwad.sdk.widget.KsLogoView;
import org.json.JSONObject;
/* loaded from: classes2.dex */
public class b extends Presenter implements View.OnClickListener {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    /* renamed from: a  reason: collision with root package name */
    public KSFrameLayout f64729a;

    /* renamed from: b  reason: collision with root package name */
    public KsLogoView f64730b;

    /* renamed from: c  reason: collision with root package name */
    public com.kwad.sdk.core.download.b.b f64731c;

    /* renamed from: d  reason: collision with root package name */
    public ImageView f64732d;

    /* renamed from: e  reason: collision with root package name */
    public com.kwad.sdk.core.video.videoview.b f64733e;

    /* renamed from: f  reason: collision with root package name */
    public TextProgressBar f64734f;

    /* renamed from: g  reason: collision with root package name */
    public a f64735g;

    /* renamed from: h  reason: collision with root package name */
    public AdInfo f64736h;

    /* renamed from: i  reason: collision with root package name */
    public AdTemplate f64737i;
    public ViewGroup j;
    public ViewGroup k;
    public ImageView l;
    public ImageView m;
    public ImageView n;
    public TextView o;
    public ImageView p;
    public TextView q;
    public TextProgressBar r;
    public boolean s;
    public boolean t;

    public b() {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            interceptable.invokeUnInit(65536, newInitContext);
            int i2 = newInitContext.flag;
            if ((i2 & 1) != 0) {
                int i3 = i2 & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
        this.t = false;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void e() {
        ImageView imageView;
        String m;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(65543, this) == null) {
            if (com.kwad.sdk.core.response.b.a.G(this.f64736h)) {
                KSImageLoader.loadImage(this.f64732d, com.kwad.sdk.core.response.b.a.B(this.f64736h).materialUrl, this.f64737i);
                this.f64732d.setClickable(true);
                this.f64732d.setOnClickListener(new View.OnClickListener(this) { // from class: com.kwad.sdk.a.a.b.2
                    public static /* synthetic */ Interceptable $ic;
                    public transient /* synthetic */ FieldHolder $fh;

                    /* renamed from: a  reason: collision with root package name */
                    public final /* synthetic */ b f64739a;

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
                        this.f64739a = this;
                    }

                    @Override // android.view.View.OnClickListener
                    public void onClick(View view) {
                        Interceptable interceptable2 = $ic;
                        if (interceptable2 == null || interceptable2.invokeL(1048576, this, view) == null) {
                            this.f64739a.f64735g.a(this.f64739a.f64732d, false);
                        }
                    }
                });
                this.j.setVisibility(8);
                this.m.setVisibility(0);
                this.n.setVisibility(8);
            } else {
                this.j.setVisibility(0);
                String a2 = com.kwad.sdk.core.response.b.a.T(this.f64736h).a();
                if (TextUtils.isEmpty(a2)) {
                    this.f64732d.setVisibility(8);
                } else {
                    this.f64732d.setImageDrawable(null);
                    KSImageLoader.loadImage(this.f64732d, a2, this.f64737i);
                    this.f64732d.setVisibility(0);
                }
                com.kwad.sdk.core.video.videoview.b bVar = this.f64735g.f64724h;
                this.f64733e = bVar;
                if (bVar.getParent() != null) {
                    ((ViewGroup) this.f64733e.getParent()).removeView(this.f64733e);
                }
                if (com.kwad.sdk.core.response.b.a.F(this.f64736h)) {
                    this.f64729a.setRatio(com.kwad.sdk.core.response.b.a.C(this.f64736h).height / com.kwad.sdk.core.response.b.a.C(this.f64736h).width);
                    this.f64729a.addView(this.f64733e);
                    ViewGroup.MarginLayoutParams marginLayoutParams = (ViewGroup.MarginLayoutParams) this.f64733e.getLayoutParams();
                    marginLayoutParams.topMargin = 0;
                    marginLayoutParams.width = -1;
                    marginLayoutParams.height = -1;
                    this.f64733e.setLayoutParams(marginLayoutParams);
                }
                this.f64729a.setClickable(true);
                this.f64729a.setOnClickListener(new View.OnClickListener(this) { // from class: com.kwad.sdk.a.a.b.3
                    public static /* synthetic */ Interceptable $ic;
                    public transient /* synthetic */ FieldHolder $fh;

                    /* renamed from: a  reason: collision with root package name */
                    public final /* synthetic */ b f64740a;

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
                        this.f64740a = this;
                    }

                    @Override // android.view.View.OnClickListener
                    public void onClick(View view) {
                        Interceptable interceptable2 = $ic;
                        if (interceptable2 == null || interceptable2.invokeL(1048576, this, view) == null) {
                            this.f64740a.f64735g.a(this.f64740a.f64733e, false);
                        }
                    }
                });
                boolean isVideoSoundEnable = this.f64735g.f64722f.isVideoSoundEnable();
                this.s = isVideoSoundEnable;
                this.l.setImageResource(isVideoSoundEnable ? R.drawable.ksad_interstitial_unmute : R.drawable.ksad_interstitial_mute);
                this.l.setOnClickListener(new View.OnClickListener(this) { // from class: com.kwad.sdk.a.a.b.4
                    public static /* synthetic */ Interceptable $ic;
                    public transient /* synthetic */ FieldHolder $fh;

                    /* renamed from: a  reason: collision with root package name */
                    public final /* synthetic */ b f64741a;

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
                        this.f64741a = this;
                    }

                    @Override // android.view.View.OnClickListener
                    public void onClick(View view) {
                        Interceptable interceptable2 = $ic;
                        if (interceptable2 == null || interceptable2.invokeL(1048576, this, view) == null) {
                            b bVar2 = this.f64741a;
                            bVar2.s = !bVar2.s;
                            this.f64741a.f64733e.setVideoSoundEnable(this.f64741a.s);
                            this.f64741a.l.setImageResource(this.f64741a.s ? R.drawable.ksad_interstitial_unmute : R.drawable.ksad_interstitial_mute);
                        }
                    }
                });
                this.o.setOnClickListener(new View.OnClickListener(this) { // from class: com.kwad.sdk.a.a.b.5
                    public static /* synthetic */ Interceptable $ic;
                    public transient /* synthetic */ FieldHolder $fh;

                    /* renamed from: a  reason: collision with root package name */
                    public final /* synthetic */ b f64742a;

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
                        this.f64742a = this;
                    }

                    @Override // android.view.View.OnClickListener
                    public void onClick(View view) {
                        Interceptable interceptable2 = $ic;
                        if ((interceptable2 == null || interceptable2.invokeL(1048576, this, view) == null) && this.f64742a.t) {
                            if (!this.f64742a.f64733e.i()) {
                                this.f64742a.f64733e.j();
                            }
                            com.kwad.sdk.core.report.a.i(this.f64742a.f64735g.f64717a, null);
                            this.f64742a.j.setVisibility(8);
                            this.f64742a.k.setVisibility(0);
                            this.f64742a.m.setVisibility(0);
                        }
                    }
                });
                this.f64735g.a(new a.b(this, com.kwad.sdk.core.response.b.a.b(this.f64736h)) { // from class: com.kwad.sdk.a.a.b.6
                    public static /* synthetic */ Interceptable $ic;
                    public transient /* synthetic */ FieldHolder $fh;

                    /* renamed from: a  reason: collision with root package name */
                    public final /* synthetic */ int f64743a;

                    /* renamed from: b  reason: collision with root package name */
                    public final /* synthetic */ b f64744b;

                    {
                        Interceptable interceptable2 = $ic;
                        if (interceptable2 != null) {
                            InitContext newInitContext = TitanRuntime.newInitContext();
                            newInitContext.initArgs = r2;
                            Object[] objArr = {this, Integer.valueOf(r7)};
                            interceptable2.invokeUnInit(65536, newInitContext);
                            int i2 = newInitContext.flag;
                            if ((i2 & 1) != 0) {
                                int i3 = i2 & 2;
                                newInitContext.thisArg = this;
                                interceptable2.invokeInitBody(65536, newInitContext);
                                return;
                            }
                        }
                        this.f64744b = this;
                        this.f64743a = r7;
                    }

                    @Override // com.kwad.sdk.core.video.videoview.a.b
                    public void a() {
                        Interceptable interceptable2 = $ic;
                        if (interceptable2 == null || interceptable2.invokeV(1048576, this) == null) {
                            this.f64744b.n.setVisibility(8);
                            this.f64744b.j.setVisibility(0);
                        }
                    }

                    @Override // com.kwad.sdk.core.video.videoview.a.b
                    @SuppressLint({"SetTextI18n"})
                    public void a(long j) {
                        TextView textView;
                        String str;
                        Interceptable interceptable2 = $ic;
                        if (interceptable2 == null || interceptable2.invokeJ(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, j) == null) {
                            int i2 = this.f64743a - ((int) (j / 1000));
                            int i3 = (j > (com.kwad.sdk.core.config.c.ad() * 1000) ? 1 : (j == (com.kwad.sdk.core.config.c.ad() * 1000) ? 0 : -1));
                            b bVar2 = this.f64744b;
                            if (i3 < 0) {
                                textView = bVar2.o;
                                str = String.valueOf(i2);
                            } else {
                                bVar2.t = true;
                                textView = this.f64744b.o;
                                str = com.kwad.sdk.core.config.c.ae() + " " + i2;
                            }
                            textView.setText(str);
                        }
                    }

                    @Override // com.kwad.sdk.core.video.videoview.a.b
                    public void b() {
                        Interceptable interceptable2 = $ic;
                        if ((interceptable2 == null || interceptable2.invokeV(Constants.METHOD_SEND_USER_MSG, this) == null) && this.f64744b.f64732d.getVisibility() == 0) {
                            this.f64744b.f64732d.setVisibility(8);
                        }
                    }

                    @Override // com.kwad.sdk.core.video.videoview.a.b
                    public void c() {
                        Interceptable interceptable2 = $ic;
                        if (interceptable2 == null || interceptable2.invokeV(1048579, this) == null) {
                            this.f64744b.f64733e.setVisibility(8);
                            this.f64744b.f64733e.l();
                            this.f64744b.j.setVisibility(8);
                            this.f64744b.k.setVisibility(0);
                            this.f64744b.m.setVisibility(0);
                        }
                    }
                });
                if (com.kwad.sdk.core.response.b.a.v(this.f64736h)) {
                    this.p.setVisibility(0);
                    this.p.setImageResource(R.drawable.ksad_default_app_icon);
                    imageView = this.p;
                    m = com.kwad.sdk.core.response.b.a.n(this.f64736h);
                } else {
                    this.p.setVisibility(0);
                    this.p.setImageResource(R.drawable.ksad_default_app_icon);
                    imageView = this.p;
                    m = com.kwad.sdk.core.response.b.c.m(this.f64737i);
                }
                KSImageLoader.loadAppIcon(imageView, m, this.f64737i, 8);
                this.q.setText(com.kwad.sdk.core.response.b.a.m(this.f64736h));
                this.r.a(com.kwad.sdk.core.response.b.a.u(this.f64736h), 0);
                this.r.setOnClickListener(this);
                this.m.setVisibility(8);
                this.n.setVisibility(8);
                this.j.setVisibility(0);
            }
            this.m.setOnClickListener(new View.OnClickListener(this) { // from class: com.kwad.sdk.a.a.b.7
                public static /* synthetic */ Interceptable $ic;
                public transient /* synthetic */ FieldHolder $fh;

                /* renamed from: a  reason: collision with root package name */
                public final /* synthetic */ b f64745a;

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
                    this.f64745a = this;
                }

                @Override // android.view.View.OnClickListener
                public void onClick(View view) {
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 == null || interceptable2.invokeL(1048576, this, view) == null) {
                        this.f64745a.f64735g.f64719c.dismiss();
                        com.kwad.sdk.core.report.a.a(this.f64745a.f64737i, 1, (JSONObject) null);
                        if (this.f64745a.f64735g.f64718b != null) {
                            this.f64745a.f64735g.f64718b.onAdClosed();
                        }
                    }
                }
            });
        }
    }

    /* JADX WARN: Code restructure failed: missing block: B:11:0x0033, code lost:
        if (r1.height > r1.width) goto L8;
     */
    /* JADX WARN: Code restructure failed: missing block: B:13:0x0037, code lost:
        if (r2 == false) goto L22;
     */
    /* JADX WARN: Code restructure failed: missing block: B:14:0x0039, code lost:
        r0.setVisibility(8);
     */
    /* JADX WARN: Code restructure failed: missing block: B:16:0x0047, code lost:
        if (android.text.TextUtils.isEmpty(com.kwad.sdk.core.response.b.a.n(r5.f64736h)) != false) goto L10;
     */
    /* JADX WARN: Code restructure failed: missing block: B:17:0x0049, code lost:
        r0.setVisibility(0);
        r0.setImageResource(com.kwad.sdk.R.drawable.ksad_default_app_icon);
        com.kwad.sdk.core.imageloader.KSImageLoader.loadAppIcon(r0, com.kwad.sdk.core.response.b.c.m(r5.f64737i), r5.f64737i, 8);
     */
    /* JADX WARN: Code restructure failed: missing block: B:18:0x005c, code lost:
        r0 = (android.widget.TextView) r5.f64735g.f64721e.findViewById(com.kwad.sdk.R.id.ksad_app_title);
        r1 = (android.widget.TextView) r5.f64735g.f64721e.findViewById(com.kwad.sdk.R.id.ksad_app_desc);
     */
    /* JADX WARN: Code restructure failed: missing block: B:19:0x007e, code lost:
        if (android.text.TextUtils.isEmpty(com.kwad.sdk.core.response.b.a.p(r5.f64736h)) != false) goto L18;
     */
    /* JADX WARN: Code restructure failed: missing block: B:20:0x0080, code lost:
        r2 = com.kwad.sdk.core.response.b.a.p(r5.f64736h);
     */
    /* JADX WARN: Code restructure failed: missing block: B:21:0x0086, code lost:
        r0.setText(r2);
        r0.setVisibility(0);
     */
    /* JADX WARN: Code restructure failed: missing block: B:23:0x0097, code lost:
        if (android.text.TextUtils.isEmpty(r5.f64736h.advertiserInfo.adAuthorText) != false) goto L21;
     */
    /* JADX WARN: Code restructure failed: missing block: B:24:0x0099, code lost:
        r2 = r5.f64736h.advertiserInfo.adAuthorText;
     */
    /* JADX WARN: Code restructure failed: missing block: B:25:0x00a0, code lost:
        r2 = "可爱的广告君";
     */
    /* JADX WARN: Code restructure failed: missing block: B:26:0x00a3, code lost:
        r1.setText(com.kwad.sdk.core.response.b.a.m(r5.f64736h));
        r5.f64734f.a(com.kwad.sdk.core.response.b.a.u(r5.f64736h), 0);
        r5.f64734f.setOnClickListener(r5);
     */
    /* JADX WARN: Code restructure failed: missing block: B:27:0x00bc, code lost:
        return;
     */
    /* JADX WARN: Code restructure failed: missing block: B:7:0x0024, code lost:
        if (r1.height > r1.width) goto L8;
     */
    /* JADX WARN: Code restructure failed: missing block: B:9:0x0027, code lost:
        r2 = false;
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    private void f() {
        Interceptable interceptable = $ic;
        if (interceptable != null && interceptable.invokeV(65546, this) != null) {
            return;
        }
        ImageView imageView = (ImageView) this.f64735g.f64721e.findViewById(R.id.ksad_app_icon);
        boolean z = true;
        if (com.kwad.sdk.core.response.b.a.F(this.f64736h)) {
            AdInfo.AdMaterialInfo.MaterialFeature C = com.kwad.sdk.core.response.b.a.C(this.f64736h);
        } else {
            AdInfo.AdMaterialInfo.MaterialFeature B = com.kwad.sdk.core.response.b.a.B(this.f64736h);
        }
    }

    /* JADX WARN: Code restructure failed: missing block: B:15:0x006b, code lost:
        if (r1.height > r1.width) goto L12;
     */
    /* JADX WARN: Code restructure failed: missing block: B:17:0x006e, code lost:
        r3 = false;
     */
    /* JADX WARN: Code restructure failed: missing block: B:19:0x007a, code lost:
        if (r1.height > r1.width) goto L12;
     */
    /* JADX WARN: Code restructure failed: missing block: B:21:0x007e, code lost:
        if (r3 == false) goto L18;
     */
    /* JADX WARN: Code restructure failed: missing block: B:22:0x0080, code lost:
        r0.setVisibility(8);
     */
    /* JADX WARN: Code restructure failed: missing block: B:24:0x008e, code lost:
        if (android.text.TextUtils.isEmpty(com.kwad.sdk.core.response.b.a.n(r6.f64736h)) != false) goto L14;
     */
    /* JADX WARN: Code restructure failed: missing block: B:25:0x0090, code lost:
        r0.setImageResource(com.kwad.sdk.R.drawable.ksad_default_app_icon);
        com.kwad.sdk.core.imageloader.KSImageLoader.loadAppIcon(r0, com.kwad.sdk.core.response.b.a.n(r6.f64736h), r6.f64737i, 8);
        r0.setVisibility(0);
     */
    /* JADX WARN: Code restructure failed: missing block: B:26:0x00a3, code lost:
        r2.setText(com.kwad.sdk.core.response.b.a.m(r6.f64736h));
        r6.f64734f.a(com.kwad.sdk.core.response.b.a.u(r6.f64736h), 0);
        r6.f64734f.setOnClickListener(r6);
        r6.f64731c = new com.kwad.sdk.core.download.b.b(r6.f64737i, null, new com.kwad.sdk.a.a.b.AnonymousClass8(r6));
     */
    /* JADX WARN: Code restructure failed: missing block: B:27:0x00cb, code lost:
        return;
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    private void n() {
        Interceptable interceptable = $ic;
        if (interceptable != null && interceptable.invokeV(65555, this) != null) {
            return;
        }
        ImageView imageView = (ImageView) this.f64735g.f64721e.findViewById(R.id.ksad_app_icon);
        TextView textView = (TextView) this.f64735g.f64721e.findViewById(R.id.ksad_app_title);
        TextView textView2 = (TextView) this.f64735g.f64721e.findViewById(R.id.ksad_app_desc);
        textView.setText(!TextUtils.isEmpty(com.kwad.sdk.core.response.b.a.o(this.f64736h)) ? com.kwad.sdk.core.response.b.a.o(this.f64736h) : !TextUtils.isEmpty(this.f64736h.advertiserInfo.adAuthorText) ? this.f64736h.advertiserInfo.adAuthorText : "可爱的广告君");
        textView.setVisibility(0);
        boolean z = true;
        if (com.kwad.sdk.core.response.b.a.F(this.f64736h)) {
            AdInfo.AdMaterialInfo.MaterialFeature C = com.kwad.sdk.core.response.b.a.C(this.f64736h);
        } else {
            AdInfo.AdMaterialInfo.MaterialFeature B = com.kwad.sdk.core.response.b.a.B(this.f64736h);
        }
    }

    @Override // com.kwad.sdk.mvp.Presenter
    public void a() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
            super.a();
            a aVar = (a) l();
            this.f64735g = aVar;
            this.f64729a = (KSFrameLayout) aVar.f64721e.findViewById(R.id.ksad_video_container);
            this.f64732d = (ImageView) this.f64735g.f64721e.findViewById(R.id.ksad_video_first_frame_container);
            this.f64730b = (KsLogoView) this.f64735g.f64721e.findViewById(R.id.ksad_ad_interstitial_logo);
            this.j = (ViewGroup) this.f64735g.f64721e.findViewById(R.id.ksad_interstitial_playing);
            this.k = (ViewGroup) this.f64735g.f64721e.findViewById(R.id.ksad_interstitial_play_end);
            this.f64734f = (TextProgressBar) this.f64735g.f64721e.findViewById(R.id.ksad_interstitial_download_btn);
            this.m = (ImageView) this.f64735g.f64721e.findViewById(R.id.ksad_interstitial_close);
            this.f64734f.setTextDimen(av.a(m(), 10.0f));
            this.f64734f.setTextColor(-1);
            this.l = (ImageView) this.f64735g.f64721e.findViewById(R.id.ksad_interstitial_mute);
            this.n = (ImageView) this.f64735g.f64721e.findViewById(R.id.ksad_interstitial_play);
            this.o = (TextView) this.f64735g.f64721e.findViewById(R.id.ksad_interstitial_count_down);
            this.p = (ImageView) this.f64735g.f64721e.findViewById(R.id.ksad_interstitial_logo);
            this.q = (TextView) this.f64735g.f64721e.findViewById(R.id.ksad_interstitial_desc);
            this.r = (TextProgressBar) this.f64735g.f64721e.findViewById(R.id.ksad_app_download_btn);
            AdTemplate adTemplate = this.f64735g.f64717a;
            this.f64737i = adTemplate;
            this.f64736h = com.kwad.sdk.core.response.b.c.i(adTemplate);
            this.f64730b.a(this.f64735g.f64717a);
            if (com.kwad.sdk.core.response.b.a.v(com.kwad.sdk.core.response.b.c.i(this.f64735g.f64717a))) {
                n();
            } else {
                f();
            }
            this.f64735g.f64721e.setOnClickListener(this);
            this.f64735g.a(new a.InterfaceC1926a(this) { // from class: com.kwad.sdk.a.a.b.1
                public static /* synthetic */ Interceptable $ic;
                public transient /* synthetic */ FieldHolder $fh;

                /* renamed from: a  reason: collision with root package name */
                public final /* synthetic */ b f64738a;

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
                    this.f64738a = this;
                }

                @Override // com.kwad.sdk.a.a.a.InterfaceC1926a
                public void a() {
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 == null || interceptable2.invokeV(1048576, this) == null) {
                        this.f64738a.e();
                    }
                }
            });
        }
    }

    @Override // com.kwad.sdk.mvp.Presenter
    public void b() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this) == null) {
            super.b();
        }
    }

    @Override // com.kwad.sdk.mvp.Presenter
    public void c() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this) == null) {
            super.c();
        }
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048579, this, view) == null) {
            this.f64735g.a(view, view == this.f64734f || view == this.r);
        }
    }
}
