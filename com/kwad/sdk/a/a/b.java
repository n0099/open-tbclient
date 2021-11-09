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
    public KSFrameLayout f63816a;

    /* renamed from: b  reason: collision with root package name */
    public KsLogoView f63817b;

    /* renamed from: c  reason: collision with root package name */
    public com.kwad.sdk.core.download.b.b f63818c;

    /* renamed from: d  reason: collision with root package name */
    public ImageView f63819d;

    /* renamed from: e  reason: collision with root package name */
    public com.kwad.sdk.core.video.videoview.b f63820e;

    /* renamed from: f  reason: collision with root package name */
    public TextProgressBar f63821f;

    /* renamed from: g  reason: collision with root package name */
    public a f63822g;

    /* renamed from: h  reason: collision with root package name */
    public AdInfo f63823h;

    /* renamed from: i  reason: collision with root package name */
    public AdTemplate f63824i;
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
            if (com.kwad.sdk.core.response.b.a.G(this.f63823h)) {
                KSImageLoader.loadImage(this.f63819d, com.kwad.sdk.core.response.b.a.B(this.f63823h).materialUrl, this.f63824i);
                this.f63819d.setClickable(true);
                this.f63819d.setOnClickListener(new View.OnClickListener(this) { // from class: com.kwad.sdk.a.a.b.2
                    public static /* synthetic */ Interceptable $ic;
                    public transient /* synthetic */ FieldHolder $fh;

                    /* renamed from: a  reason: collision with root package name */
                    public final /* synthetic */ b f63826a;

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
                        this.f63826a = this;
                    }

                    @Override // android.view.View.OnClickListener
                    public void onClick(View view) {
                        Interceptable interceptable2 = $ic;
                        if (interceptable2 == null || interceptable2.invokeL(1048576, this, view) == null) {
                            this.f63826a.f63822g.a(this.f63826a.f63819d, false);
                        }
                    }
                });
                this.j.setVisibility(8);
                this.m.setVisibility(0);
                this.n.setVisibility(8);
            } else {
                this.j.setVisibility(0);
                String a2 = com.kwad.sdk.core.response.b.a.T(this.f63823h).a();
                if (TextUtils.isEmpty(a2)) {
                    this.f63819d.setVisibility(8);
                } else {
                    this.f63819d.setImageDrawable(null);
                    KSImageLoader.loadImage(this.f63819d, a2, this.f63824i);
                    this.f63819d.setVisibility(0);
                }
                com.kwad.sdk.core.video.videoview.b bVar = this.f63822g.f63811h;
                this.f63820e = bVar;
                if (bVar.getParent() != null) {
                    ((ViewGroup) this.f63820e.getParent()).removeView(this.f63820e);
                }
                if (com.kwad.sdk.core.response.b.a.F(this.f63823h)) {
                    this.f63816a.setRatio(com.kwad.sdk.core.response.b.a.C(this.f63823h).height / com.kwad.sdk.core.response.b.a.C(this.f63823h).width);
                    this.f63816a.addView(this.f63820e);
                    ViewGroup.MarginLayoutParams marginLayoutParams = (ViewGroup.MarginLayoutParams) this.f63820e.getLayoutParams();
                    marginLayoutParams.topMargin = 0;
                    marginLayoutParams.width = -1;
                    marginLayoutParams.height = -1;
                    this.f63820e.setLayoutParams(marginLayoutParams);
                }
                this.f63816a.setClickable(true);
                this.f63816a.setOnClickListener(new View.OnClickListener(this) { // from class: com.kwad.sdk.a.a.b.3
                    public static /* synthetic */ Interceptable $ic;
                    public transient /* synthetic */ FieldHolder $fh;

                    /* renamed from: a  reason: collision with root package name */
                    public final /* synthetic */ b f63827a;

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
                        this.f63827a = this;
                    }

                    @Override // android.view.View.OnClickListener
                    public void onClick(View view) {
                        Interceptable interceptable2 = $ic;
                        if (interceptable2 == null || interceptable2.invokeL(1048576, this, view) == null) {
                            this.f63827a.f63822g.a(this.f63827a.f63820e, false);
                        }
                    }
                });
                boolean isVideoSoundEnable = this.f63822g.f63809f.isVideoSoundEnable();
                this.s = isVideoSoundEnable;
                this.l.setImageResource(isVideoSoundEnable ? R.drawable.ksad_interstitial_unmute : R.drawable.ksad_interstitial_mute);
                this.l.setOnClickListener(new View.OnClickListener(this) { // from class: com.kwad.sdk.a.a.b.4
                    public static /* synthetic */ Interceptable $ic;
                    public transient /* synthetic */ FieldHolder $fh;

                    /* renamed from: a  reason: collision with root package name */
                    public final /* synthetic */ b f63828a;

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
                        this.f63828a = this;
                    }

                    @Override // android.view.View.OnClickListener
                    public void onClick(View view) {
                        Interceptable interceptable2 = $ic;
                        if (interceptable2 == null || interceptable2.invokeL(1048576, this, view) == null) {
                            b bVar2 = this.f63828a;
                            bVar2.s = !bVar2.s;
                            this.f63828a.f63820e.setVideoSoundEnable(this.f63828a.s);
                            this.f63828a.l.setImageResource(this.f63828a.s ? R.drawable.ksad_interstitial_unmute : R.drawable.ksad_interstitial_mute);
                        }
                    }
                });
                this.o.setOnClickListener(new View.OnClickListener(this) { // from class: com.kwad.sdk.a.a.b.5
                    public static /* synthetic */ Interceptable $ic;
                    public transient /* synthetic */ FieldHolder $fh;

                    /* renamed from: a  reason: collision with root package name */
                    public final /* synthetic */ b f63829a;

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
                        this.f63829a = this;
                    }

                    @Override // android.view.View.OnClickListener
                    public void onClick(View view) {
                        Interceptable interceptable2 = $ic;
                        if ((interceptable2 == null || interceptable2.invokeL(1048576, this, view) == null) && this.f63829a.t) {
                            if (!this.f63829a.f63820e.i()) {
                                this.f63829a.f63820e.j();
                            }
                            com.kwad.sdk.core.report.a.i(this.f63829a.f63822g.f63804a, null);
                            this.f63829a.j.setVisibility(8);
                            this.f63829a.k.setVisibility(0);
                            this.f63829a.m.setVisibility(0);
                        }
                    }
                });
                this.f63822g.a(new a.b(this, com.kwad.sdk.core.response.b.a.b(this.f63823h)) { // from class: com.kwad.sdk.a.a.b.6
                    public static /* synthetic */ Interceptable $ic;
                    public transient /* synthetic */ FieldHolder $fh;

                    /* renamed from: a  reason: collision with root package name */
                    public final /* synthetic */ int f63830a;

                    /* renamed from: b  reason: collision with root package name */
                    public final /* synthetic */ b f63831b;

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
                        this.f63831b = this;
                        this.f63830a = r7;
                    }

                    @Override // com.kwad.sdk.core.video.videoview.a.b
                    public void a() {
                        Interceptable interceptable2 = $ic;
                        if (interceptable2 == null || interceptable2.invokeV(1048576, this) == null) {
                            this.f63831b.n.setVisibility(8);
                            this.f63831b.j.setVisibility(0);
                        }
                    }

                    @Override // com.kwad.sdk.core.video.videoview.a.b
                    @SuppressLint({"SetTextI18n"})
                    public void a(long j) {
                        TextView textView;
                        String str;
                        Interceptable interceptable2 = $ic;
                        if (interceptable2 == null || interceptable2.invokeJ(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, j) == null) {
                            int i2 = this.f63830a - ((int) (j / 1000));
                            int i3 = (j > (com.kwad.sdk.core.config.c.ad() * 1000) ? 1 : (j == (com.kwad.sdk.core.config.c.ad() * 1000) ? 0 : -1));
                            b bVar2 = this.f63831b;
                            if (i3 < 0) {
                                textView = bVar2.o;
                                str = String.valueOf(i2);
                            } else {
                                bVar2.t = true;
                                textView = this.f63831b.o;
                                str = com.kwad.sdk.core.config.c.ae() + " " + i2;
                            }
                            textView.setText(str);
                        }
                    }

                    @Override // com.kwad.sdk.core.video.videoview.a.b
                    public void b() {
                        Interceptable interceptable2 = $ic;
                        if ((interceptable2 == null || interceptable2.invokeV(Constants.METHOD_SEND_USER_MSG, this) == null) && this.f63831b.f63819d.getVisibility() == 0) {
                            this.f63831b.f63819d.setVisibility(8);
                        }
                    }

                    @Override // com.kwad.sdk.core.video.videoview.a.b
                    public void c() {
                        Interceptable interceptable2 = $ic;
                        if (interceptable2 == null || interceptable2.invokeV(1048579, this) == null) {
                            this.f63831b.f63820e.setVisibility(8);
                            this.f63831b.f63820e.l();
                            this.f63831b.j.setVisibility(8);
                            this.f63831b.k.setVisibility(0);
                            this.f63831b.m.setVisibility(0);
                        }
                    }
                });
                if (com.kwad.sdk.core.response.b.a.v(this.f63823h)) {
                    this.p.setVisibility(0);
                    this.p.setImageResource(R.drawable.ksad_default_app_icon);
                    imageView = this.p;
                    m = com.kwad.sdk.core.response.b.a.n(this.f63823h);
                } else {
                    this.p.setVisibility(0);
                    this.p.setImageResource(R.drawable.ksad_default_app_icon);
                    imageView = this.p;
                    m = com.kwad.sdk.core.response.b.c.m(this.f63824i);
                }
                KSImageLoader.loadAppIcon(imageView, m, this.f63824i, 8);
                this.q.setText(com.kwad.sdk.core.response.b.a.m(this.f63823h));
                this.r.a(com.kwad.sdk.core.response.b.a.u(this.f63823h), 0);
                this.r.setOnClickListener(this);
                this.m.setVisibility(8);
                this.n.setVisibility(8);
                this.j.setVisibility(0);
            }
            this.m.setOnClickListener(new View.OnClickListener(this) { // from class: com.kwad.sdk.a.a.b.7
                public static /* synthetic */ Interceptable $ic;
                public transient /* synthetic */ FieldHolder $fh;

                /* renamed from: a  reason: collision with root package name */
                public final /* synthetic */ b f63832a;

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
                    this.f63832a = this;
                }

                @Override // android.view.View.OnClickListener
                public void onClick(View view) {
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 == null || interceptable2.invokeL(1048576, this, view) == null) {
                        this.f63832a.f63822g.f63806c.dismiss();
                        com.kwad.sdk.core.report.a.a(this.f63832a.f63824i, 1, (JSONObject) null);
                        if (this.f63832a.f63822g.f63805b != null) {
                            this.f63832a.f63822g.f63805b.onAdClosed();
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
        if (android.text.TextUtils.isEmpty(com.kwad.sdk.core.response.b.a.n(r5.f63823h)) != false) goto L10;
     */
    /* JADX WARN: Code restructure failed: missing block: B:17:0x0049, code lost:
        r0.setVisibility(0);
        r0.setImageResource(com.kwad.sdk.R.drawable.ksad_default_app_icon);
        com.kwad.sdk.core.imageloader.KSImageLoader.loadAppIcon(r0, com.kwad.sdk.core.response.b.c.m(r5.f63824i), r5.f63824i, 8);
     */
    /* JADX WARN: Code restructure failed: missing block: B:18:0x005c, code lost:
        r0 = (android.widget.TextView) r5.f63822g.f63808e.findViewById(com.kwad.sdk.R.id.ksad_app_title);
        r1 = (android.widget.TextView) r5.f63822g.f63808e.findViewById(com.kwad.sdk.R.id.ksad_app_desc);
     */
    /* JADX WARN: Code restructure failed: missing block: B:19:0x007e, code lost:
        if (android.text.TextUtils.isEmpty(com.kwad.sdk.core.response.b.a.p(r5.f63823h)) != false) goto L18;
     */
    /* JADX WARN: Code restructure failed: missing block: B:20:0x0080, code lost:
        r2 = com.kwad.sdk.core.response.b.a.p(r5.f63823h);
     */
    /* JADX WARN: Code restructure failed: missing block: B:21:0x0086, code lost:
        r0.setText(r2);
        r0.setVisibility(0);
     */
    /* JADX WARN: Code restructure failed: missing block: B:23:0x0097, code lost:
        if (android.text.TextUtils.isEmpty(r5.f63823h.advertiserInfo.adAuthorText) != false) goto L21;
     */
    /* JADX WARN: Code restructure failed: missing block: B:24:0x0099, code lost:
        r2 = r5.f63823h.advertiserInfo.adAuthorText;
     */
    /* JADX WARN: Code restructure failed: missing block: B:25:0x00a0, code lost:
        r2 = "可爱的广告君";
     */
    /* JADX WARN: Code restructure failed: missing block: B:26:0x00a3, code lost:
        r1.setText(com.kwad.sdk.core.response.b.a.m(r5.f63823h));
        r5.f63821f.a(com.kwad.sdk.core.response.b.a.u(r5.f63823h), 0);
        r5.f63821f.setOnClickListener(r5);
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
        ImageView imageView = (ImageView) this.f63822g.f63808e.findViewById(R.id.ksad_app_icon);
        boolean z = true;
        if (com.kwad.sdk.core.response.b.a.F(this.f63823h)) {
            AdInfo.AdMaterialInfo.MaterialFeature C = com.kwad.sdk.core.response.b.a.C(this.f63823h);
        } else {
            AdInfo.AdMaterialInfo.MaterialFeature B = com.kwad.sdk.core.response.b.a.B(this.f63823h);
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
        if (android.text.TextUtils.isEmpty(com.kwad.sdk.core.response.b.a.n(r6.f63823h)) != false) goto L14;
     */
    /* JADX WARN: Code restructure failed: missing block: B:25:0x0090, code lost:
        r0.setImageResource(com.kwad.sdk.R.drawable.ksad_default_app_icon);
        com.kwad.sdk.core.imageloader.KSImageLoader.loadAppIcon(r0, com.kwad.sdk.core.response.b.a.n(r6.f63823h), r6.f63824i, 8);
        r0.setVisibility(0);
     */
    /* JADX WARN: Code restructure failed: missing block: B:26:0x00a3, code lost:
        r2.setText(com.kwad.sdk.core.response.b.a.m(r6.f63823h));
        r6.f63821f.a(com.kwad.sdk.core.response.b.a.u(r6.f63823h), 0);
        r6.f63821f.setOnClickListener(r6);
        r6.f63818c = new com.kwad.sdk.core.download.b.b(r6.f63824i, null, new com.kwad.sdk.a.a.b.AnonymousClass8(r6));
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
        ImageView imageView = (ImageView) this.f63822g.f63808e.findViewById(R.id.ksad_app_icon);
        TextView textView = (TextView) this.f63822g.f63808e.findViewById(R.id.ksad_app_title);
        TextView textView2 = (TextView) this.f63822g.f63808e.findViewById(R.id.ksad_app_desc);
        textView.setText(!TextUtils.isEmpty(com.kwad.sdk.core.response.b.a.o(this.f63823h)) ? com.kwad.sdk.core.response.b.a.o(this.f63823h) : !TextUtils.isEmpty(this.f63823h.advertiserInfo.adAuthorText) ? this.f63823h.advertiserInfo.adAuthorText : "可爱的广告君");
        textView.setVisibility(0);
        boolean z = true;
        if (com.kwad.sdk.core.response.b.a.F(this.f63823h)) {
            AdInfo.AdMaterialInfo.MaterialFeature C = com.kwad.sdk.core.response.b.a.C(this.f63823h);
        } else {
            AdInfo.AdMaterialInfo.MaterialFeature B = com.kwad.sdk.core.response.b.a.B(this.f63823h);
        }
    }

    @Override // com.kwad.sdk.mvp.Presenter
    public void a() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
            super.a();
            a aVar = (a) l();
            this.f63822g = aVar;
            this.f63816a = (KSFrameLayout) aVar.f63808e.findViewById(R.id.ksad_video_container);
            this.f63819d = (ImageView) this.f63822g.f63808e.findViewById(R.id.ksad_video_first_frame_container);
            this.f63817b = (KsLogoView) this.f63822g.f63808e.findViewById(R.id.ksad_ad_interstitial_logo);
            this.j = (ViewGroup) this.f63822g.f63808e.findViewById(R.id.ksad_interstitial_playing);
            this.k = (ViewGroup) this.f63822g.f63808e.findViewById(R.id.ksad_interstitial_play_end);
            this.f63821f = (TextProgressBar) this.f63822g.f63808e.findViewById(R.id.ksad_interstitial_download_btn);
            this.m = (ImageView) this.f63822g.f63808e.findViewById(R.id.ksad_interstitial_close);
            this.f63821f.setTextDimen(av.a(m(), 10.0f));
            this.f63821f.setTextColor(-1);
            this.l = (ImageView) this.f63822g.f63808e.findViewById(R.id.ksad_interstitial_mute);
            this.n = (ImageView) this.f63822g.f63808e.findViewById(R.id.ksad_interstitial_play);
            this.o = (TextView) this.f63822g.f63808e.findViewById(R.id.ksad_interstitial_count_down);
            this.p = (ImageView) this.f63822g.f63808e.findViewById(R.id.ksad_interstitial_logo);
            this.q = (TextView) this.f63822g.f63808e.findViewById(R.id.ksad_interstitial_desc);
            this.r = (TextProgressBar) this.f63822g.f63808e.findViewById(R.id.ksad_app_download_btn);
            AdTemplate adTemplate = this.f63822g.f63804a;
            this.f63824i = adTemplate;
            this.f63823h = com.kwad.sdk.core.response.b.c.i(adTemplate);
            this.f63817b.a(this.f63822g.f63804a);
            if (com.kwad.sdk.core.response.b.a.v(com.kwad.sdk.core.response.b.c.i(this.f63822g.f63804a))) {
                n();
            } else {
                f();
            }
            this.f63822g.f63808e.setOnClickListener(this);
            this.f63822g.a(new a.InterfaceC1886a(this) { // from class: com.kwad.sdk.a.a.b.1
                public static /* synthetic */ Interceptable $ic;
                public transient /* synthetic */ FieldHolder $fh;

                /* renamed from: a  reason: collision with root package name */
                public final /* synthetic */ b f63825a;

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
                    this.f63825a = this;
                }

                @Override // com.kwad.sdk.a.a.a.InterfaceC1886a
                public void a() {
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 == null || interceptable2.invokeV(1048576, this) == null) {
                        this.f63825a.e();
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
            this.f63822g.a(view, view == this.f63821f || view == this.r);
        }
    }
}
