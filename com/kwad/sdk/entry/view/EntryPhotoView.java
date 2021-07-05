package com.kwad.sdk.entry.view;

import android.content.Context;
import android.graphics.Bitmap;
import android.text.TextUtils;
import android.util.AttributeSet;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewStub;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;
import androidx.annotation.MainThread;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.core.view.InputDeviceCompat;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.mobads.container.util.AdIconUtil;
import com.baidu.mobads.container.util.CommonUtils;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptable;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptorStorage;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import com.kwad.sdk.R;
import com.kwad.sdk.api.KsAppDownloadListener;
import com.kwad.sdk.core.download.b.a;
import com.kwad.sdk.core.page.widget.RoundAngleImageView;
import com.kwad.sdk.core.response.b.d;
import com.kwad.sdk.core.response.model.AdInfo;
import com.kwad.sdk.core.response.model.AdTemplate;
import com.kwad.sdk.core.response.model.PhotoInfo;
import com.kwad.sdk.core.view.g;
import com.kwad.sdk.glide.framesequence.FrameSequence;
import com.kwad.sdk.glide.load.h;
import com.kwad.sdk.glide.load.resource.bitmap.o;
import com.kwad.sdk.glide.request.e;
import com.kwad.sdk.glide.webp.decoder.WebpFrameCacheStrategy;
import com.kwad.sdk.glide.webp.decoder.k;
import com.kwad.sdk.glide.webp.decoder.n;
import com.kwad.sdk.utils.ag;
import com.kwad.sdk.utils.ao;
import com.kwad.sdk.utils.s;
import com.kwad.sdk.widget.AnimatedImageView;
import org.json.JSONObject;
/* loaded from: classes7.dex */
public class EntryPhotoView extends com.kwad.sdk.widget.a implements View.OnClickListener, g.a {
    public static /* synthetic */ Interceptable $ic;

    /* renamed from: a  reason: collision with root package name */
    public static final s.a f37243a;
    public transient /* synthetic */ FieldHolder $fh;
    public RelativeLayout A;
    public g B;
    public Runnable C;
    public boolean D;
    public View.OnClickListener E;

    /* renamed from: b  reason: collision with root package name */
    public AnimatedImageView f37244b;

    /* renamed from: c  reason: collision with root package name */
    public RoundAngleImageView f37245c;

    /* renamed from: d  reason: collision with root package name */
    public TextView f37246d;

    /* renamed from: e  reason: collision with root package name */
    public TextView f37247e;

    /* renamed from: f  reason: collision with root package name */
    public ImageView f37248f;

    /* renamed from: g  reason: collision with root package name */
    public com.kwad.sdk.core.response.model.a f37249g;

    /* renamed from: h  reason: collision with root package name */
    public AdTemplate f37250h;

    /* renamed from: i  reason: collision with root package name */
    public PhotoInfo f37251i;
    public AdInfo j;
    public boolean k;
    public boolean l;
    public View m;
    public int n;
    public String o;
    public g p;
    public int q;
    public com.kwad.sdk.core.download.b.b r;
    public KsAppDownloadListener s;
    public boolean t;
    public ViewStub u;
    public RoundAngleImageView v;
    public TextView w;
    public TextView x;
    public TextView y;
    public boolean z;

    static {
        InterceptResult invokeClinit;
        ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
        if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(-112747964, "Lcom/kwad/sdk/entry/view/EntryPhotoView;")) != null) {
            Interceptable interceptable = invokeClinit.interceptor;
            if (interceptable != null) {
                $ic = interceptable;
            }
            if ((invokeClinit.flags & 1) != 0) {
                classClinitInterceptable.invokePostClinit(-112747964, "Lcom/kwad/sdk/entry/view/EntryPhotoView;");
                return;
            }
        }
        f37243a = new s.a();
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public EntryPhotoView(@NonNull Context context) {
        super(context);
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {context};
            interceptable.invokeUnInit(65537, newInitContext);
            int i2 = newInitContext.flag;
            if ((i2 & 1) != 0) {
                int i3 = i2 & 2;
                super((Context) newInitContext.callArgs[0]);
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65537, newInitContext);
                return;
            }
        }
        this.q = 1;
        this.z = false;
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public EntryPhotoView(@NonNull Context context, @Nullable AttributeSet attributeSet) {
        super(context, attributeSet);
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {context, attributeSet};
            interceptable.invokeUnInit(65538, newInitContext);
            int i2 = newInitContext.flag;
            if ((i2 & 1) != 0) {
                int i3 = i2 & 2;
                Object[] objArr2 = newInitContext.callArgs;
                super((Context) objArr2[0], (AttributeSet) objArr2[1]);
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65538, newInitContext);
                return;
            }
        }
        this.q = 1;
        this.z = false;
    }

    private void a(int i2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(AdIconUtil.AD_TEXT_ID, this, i2) == null) {
            ViewGroup.LayoutParams layoutParams = this.A.getLayoutParams();
            layoutParams.width = -1;
            layoutParams.height = ao.a(getContext(), i2);
            this.A.setClickable(true);
            this.A.setOnClickListener(this);
        }
    }

    private void a(int i2, int i3) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeII(AdIconUtil.BAIDU_LOGO_ID, this, i2, i3) == null) {
            this.v.setRadius(ao.a(getContext(), 4.0f));
            ViewGroup.LayoutParams layoutParams = this.v.getLayoutParams();
            layoutParams.width = ao.a(getContext(), i2);
            layoutParams.height = ao.a(getContext(), i3);
            this.v.setClickable(true);
            this.v.setOnClickListener(this);
            com.kwad.sdk.glide.c.b(getContext()).a(com.kwad.sdk.core.response.b.c.q(this.f37250h)).a(getContext().getResources().getDrawable(R.drawable.ksad_default_app_icon)).b(getContext().getResources().getDrawable(R.drawable.ksad_default_app_icon)).c(getContext().getResources().getDrawable(R.drawable.ksad_default_app_icon)).a((e) new com.kwad.sdk.c(com.kwad.sdk.core.response.b.a.o(this.j), this.f37250h)).a((ImageView) this.v);
        }
    }

    private void a(int i2, int i3, int i4) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeIII(65543, this, i2, i3, i4) == null) {
            ViewGroup.LayoutParams layoutParams = this.x.getLayoutParams();
            layoutParams.width = -2;
            layoutParams.height = ao.a(getContext(), i2);
            this.x.setClickable(true);
            this.x.setOnClickListener(this);
            setSelectedAdButton(this.f37250h.mHasEntryAdClick);
            this.x.setTextSize(i3);
            this.x.setMaxWidth(ao.a(getContext(), i4));
            this.x.setText(com.kwad.sdk.core.response.b.a.w(this.j));
            g gVar = new g(this.x, 30);
            this.B = gVar;
            gVar.a(new g.a(this) { // from class: com.kwad.sdk.entry.view.EntryPhotoView.5
                public static /* synthetic */ Interceptable $ic;
                public transient /* synthetic */ FieldHolder $fh;

                /* renamed from: a  reason: collision with root package name */
                public final /* synthetic */ EntryPhotoView f37256a;

                {
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 != null) {
                        InitContext newInitContext = TitanRuntime.newInitContext();
                        newInitContext.initArgs = r2;
                        Object[] objArr = {this};
                        interceptable2.invokeUnInit(65536, newInitContext);
                        int i5 = newInitContext.flag;
                        if ((i5 & 1) != 0) {
                            int i6 = i5 & 2;
                            newInitContext.thisArg = this;
                            interceptable2.invokeInitBody(65536, newInitContext);
                            return;
                        }
                    }
                    this.f37256a = this;
                }

                @Override // com.kwad.sdk.core.view.g.a
                public void a(boolean z) {
                    Interceptable interceptable2 = $ic;
                    if (!(interceptable2 == null || interceptable2.invokeZ(1048576, this, z) == null) || this.f37256a.x == null) {
                        return;
                    }
                    if (this.f37256a.f37250h.mHasEntryAdClick) {
                        this.f37256a.setSelectedAdButton(true);
                    } else if (!z) {
                        this.f37256a.setSelectedAdButton(false);
                        this.f37256a.D = false;
                        this.f37256a.x.removeCallbacks(this.f37256a.C);
                    } else if (this.f37256a.D) {
                    } else {
                        this.f37256a.x.removeCallbacks(this.f37256a.C);
                        this.f37256a.C = new Runnable(this) { // from class: com.kwad.sdk.entry.view.EntryPhotoView.5.1
                            public static /* synthetic */ Interceptable $ic;
                            public transient /* synthetic */ FieldHolder $fh;

                            /* renamed from: a  reason: collision with root package name */
                            public final /* synthetic */ AnonymousClass5 f37257a;

                            {
                                Interceptable interceptable3 = $ic;
                                if (interceptable3 != null) {
                                    InitContext newInitContext = TitanRuntime.newInitContext();
                                    newInitContext.initArgs = r2;
                                    Object[] objArr = {this};
                                    interceptable3.invokeUnInit(65536, newInitContext);
                                    int i5 = newInitContext.flag;
                                    if ((i5 & 1) != 0) {
                                        int i6 = i5 & 2;
                                        newInitContext.thisArg = this;
                                        interceptable3.invokeInitBody(65536, newInitContext);
                                        return;
                                    }
                                }
                                this.f37257a = this;
                            }

                            @Override // java.lang.Runnable
                            public void run() {
                                Interceptable interceptable3 = $ic;
                                if (interceptable3 == null || interceptable3.invokeV(1048576, this) == null) {
                                    this.f37257a.f37256a.setSelectedAdButton(true);
                                }
                            }
                        };
                        this.f37256a.x.postDelayed(this.f37256a.C, 1300L);
                        this.f37256a.D = true;
                    }
                }
            });
            g gVar2 = this.B;
            if (gVar2 != null) {
                gVar2.a();
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void b(int i2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(65547, this, i2) == null) {
            com.kwad.sdk.core.report.b.a(this.f37250h, i2, getTouchCoords());
        }
    }

    private KsAppDownloadListener getAppDownloadListener() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(65554, this)) == null) {
            if (this.s == null) {
                this.s = new com.kwad.sdk.core.download.b.c(this) { // from class: com.kwad.sdk.entry.view.EntryPhotoView.6
                    public static /* synthetic */ Interceptable $ic;
                    public transient /* synthetic */ FieldHolder $fh;

                    /* renamed from: a  reason: collision with root package name */
                    public final /* synthetic */ EntryPhotoView f37258a;

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
                        this.f37258a = this;
                    }

                    @Override // com.kwad.sdk.core.download.b.c
                    public void a(int i2) {
                        Interceptable interceptable2 = $ic;
                        if (interceptable2 == null || interceptable2.invokeI(1048576, this, i2) == null) {
                            this.f37258a.x.setText(CommonUtils.DIALOG_POS_TEXT);
                            ViewGroup.LayoutParams layoutParams = this.f37258a.x.getLayoutParams();
                            layoutParams.width = -2;
                            this.f37258a.x.setLayoutParams(layoutParams);
                        }
                    }

                    @Override // com.kwad.sdk.api.KsAppDownloadListener
                    public void onDownloadFailed() {
                        Interceptable interceptable2 = $ic;
                        if (interceptable2 == null || interceptable2.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this) == null) {
                            this.f37258a.x.setText(com.kwad.sdk.core.response.b.a.w(this.f37258a.j));
                            ViewGroup.LayoutParams layoutParams = this.f37258a.x.getLayoutParams();
                            layoutParams.width = -2;
                            this.f37258a.x.setLayoutParams(layoutParams);
                        }
                    }

                    @Override // com.kwad.sdk.api.KsAppDownloadListener
                    public void onDownloadFinished() {
                        Interceptable interceptable2 = $ic;
                        if (interceptable2 == null || interceptable2.invokeV(Constants.METHOD_SEND_USER_MSG, this) == null) {
                            this.f37258a.x.setText(com.kwad.sdk.core.response.b.a.a(this.f37258a.f37250h));
                            ViewGroup.LayoutParams layoutParams = this.f37258a.x.getLayoutParams();
                            layoutParams.width = -2;
                            this.f37258a.x.setLayoutParams(layoutParams);
                        }
                    }

                    @Override // com.kwad.sdk.api.KsAppDownloadListener
                    public void onIdle() {
                        Interceptable interceptable2 = $ic;
                        if (interceptable2 == null || interceptable2.invokeV(1048579, this) == null) {
                            this.f37258a.x.setText(com.kwad.sdk.core.response.b.a.w(this.f37258a.j));
                            ViewGroup.LayoutParams layoutParams = this.f37258a.x.getLayoutParams();
                            layoutParams.width = -2;
                            this.f37258a.x.setLayoutParams(layoutParams);
                        }
                    }

                    @Override // com.kwad.sdk.api.KsAppDownloadListener
                    public void onInstalled() {
                        Interceptable interceptable2 = $ic;
                        if (interceptable2 == null || interceptable2.invokeV(1048580, this) == null) {
                            this.f37258a.x.setText(com.kwad.sdk.core.response.b.a.b());
                            ViewGroup.LayoutParams layoutParams = this.f37258a.x.getLayoutParams();
                            layoutParams.width = -2;
                            this.f37258a.x.setLayoutParams(layoutParams);
                        }
                    }

                    @Override // com.kwad.sdk.api.KsAppDownloadListener
                    public void onProgressUpdate(int i2) {
                        Interceptable interceptable2 = $ic;
                        if (interceptable2 == null || interceptable2.invokeI(1048581, this, i2) == null) {
                            TextView textView = this.f37258a.x;
                            textView.setText("下载中..." + i2 + "%");
                            ViewGroup.LayoutParams layoutParams = this.f37258a.x.getLayoutParams();
                            layoutParams.width = -2;
                            this.f37258a.x.setLayoutParams(layoutParams);
                        }
                    }
                };
            }
            return this.s;
        }
        return (KsAppDownloadListener) invokeV.objValue;
    }

    private void m() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(65555, this) == null) {
            this.f37246d.setVisibility(8);
            this.f37247e.setText(com.kwad.sdk.core.response.b.a.n(this.j));
            n();
            p();
            s();
            if (com.kwad.sdk.core.response.b.a.y(this.j) && this.r == null) {
                com.kwad.sdk.core.download.b.b bVar = new com.kwad.sdk.core.download.b.b(this.f37250h);
                this.r = bVar;
                bVar.a(getAppDownloadListener());
            }
        }
    }

    private void n() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(65556, this) == null) {
            this.f37247e.setOnClickListener(new View.OnClickListener(this) { // from class: com.kwad.sdk.entry.view.EntryPhotoView.2
                public static /* synthetic */ Interceptable $ic;
                public transient /* synthetic */ FieldHolder $fh;

                /* renamed from: a  reason: collision with root package name */
                public final /* synthetic */ EntryPhotoView f37253a;

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
                    this.f37253a = this;
                }

                @Override // android.view.View.OnClickListener
                public void onClick(View view) {
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 == null || interceptable2.invokeL(1048576, this, view) == null) {
                        if (com.kwad.sdk.core.response.b.c.c(this.f37253a.f37250h)) {
                            com.kwad.sdk.core.report.b.d(this.f37253a.f37250h, 24);
                        }
                        if (this.f37253a.E != null) {
                            this.f37253a.E.onClick(this.f37253a);
                        }
                    }
                }
            });
            this.f37244b.setOnClickListener(new View.OnClickListener(this) { // from class: com.kwad.sdk.entry.view.EntryPhotoView.3
                public static /* synthetic */ Interceptable $ic;
                public transient /* synthetic */ FieldHolder $fh;

                /* renamed from: a  reason: collision with root package name */
                public final /* synthetic */ EntryPhotoView f37254a;

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
                    this.f37254a = this;
                }

                @Override // android.view.View.OnClickListener
                public void onClick(View view) {
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 == null || interceptable2.invokeL(1048576, this, view) == null) {
                        if (com.kwad.sdk.core.response.b.c.c(this.f37254a.f37250h)) {
                            com.kwad.sdk.core.report.b.d(this.f37254a.f37250h, 83);
                        }
                        if (this.f37254a.E != null) {
                            this.f37254a.E.onClick(this.f37254a);
                        }
                    }
                }
            });
            this.f37245c.setOnClickListener(new View.OnClickListener(this) { // from class: com.kwad.sdk.entry.view.EntryPhotoView.4
                public static /* synthetic */ Interceptable $ic;
                public transient /* synthetic */ FieldHolder $fh;

                /* renamed from: a  reason: collision with root package name */
                public final /* synthetic */ EntryPhotoView f37255a;

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
                    this.f37255a = this;
                }

                @Override // android.view.View.OnClickListener
                public void onClick(View view) {
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 == null || interceptable2.invokeL(1048576, this, view) == null) {
                        if (com.kwad.sdk.core.response.b.c.c(this.f37255a.f37250h)) {
                            com.kwad.sdk.core.report.b.d(this.f37255a.f37250h, 83);
                        }
                        if (this.f37255a.E != null) {
                            this.f37255a.E.onClick(this.f37255a);
                        }
                    }
                }
            });
        }
    }

    private void o() {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(65557, this) == null) || this.f37251i == null) {
            return;
        }
        p();
        long m = d.m(this.f37251i);
        this.f37246d.setVisibility(0);
        this.f37246d.setText(ag.a(m, "0"));
        com.kwad.sdk.core.d.a.a("EntryPhotoView", "videoDescPos=" + this.f37249g.f36570i + " videoDesc=" + this.f37251i.baseInfo.videoDesc);
        if (this.f37249g.f36570i != 1 || TextUtils.isEmpty(this.f37251i.baseInfo.videoDesc)) {
            this.f37247e.setVisibility(8);
            return;
        }
        this.f37247e.setVisibility(0);
        this.f37247e.setText(this.f37251i.baseInfo.videoDesc);
    }

    private void p() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(65558, this) == null) {
            String D = com.kwad.sdk.core.response.b.c.D(this.f37250h);
            setBackgroundImageView(com.kwad.sdk.core.response.b.c.p(this.f37250h));
            c();
            if (this.k) {
                com.kwad.sdk.core.d.a.a("EntryPhotoView", "coverUrl=" + D);
                if (!TextUtils.isEmpty(D) && FrameSequence.isEnable()) {
                    h<Bitmap> oVar = q() ? new o() : new com.kwad.sdk.glide.load.resource.bitmap.g();
                    com.kwad.sdk.glide.c.b(getContext()).a(D).a(getResources().getDrawable(R.drawable.ksad_loading_entry)).c(getResources().getDrawable(R.drawable.ksad_loading_entry)).b(oVar).a(k.class, new n(oVar)).a((com.kwad.sdk.glide.load.d<com.kwad.sdk.glide.load.d<WebpFrameCacheStrategy>>) com.kwad.sdk.glide.webp.decoder.o.f38430a, (com.kwad.sdk.glide.load.d<WebpFrameCacheStrategy>) WebpFrameCacheStrategy.f38379b).a(com.kwad.sdk.glide.load.engine.h.f38088d).a((e) new com.kwad.sdk.c(D, this.f37250h)).a((ImageView) this.f37244b);
                    return;
                }
            }
            setCoverImageView(com.kwad.sdk.core.response.b.c.o(this.f37250h).a());
        }
    }

    private boolean q() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(65559, this)) == null) {
            com.kwad.sdk.core.response.model.c n = com.kwad.sdk.core.response.b.c.n(this.f37250h);
            return com.kwad.sdk.core.config.c.V() && n.b() * 3 < n.c() * 4;
        }
        return invokeV.booleanValue;
    }

    private void r() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(65560, this) == null) {
            this.m.setVisibility(8);
            this.f37246d.setVisibility(0);
            this.f37248f.setVisibility(0);
            this.u.setVisibility(8);
        }
    }

    private void s() {
        int i2;
        int i3;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(65561, this) == null) {
            t();
            if (this.q == 2) {
                a(44);
                a(28, 28);
                i2 = 12;
                a(28, 12, 88);
                i3 = 9;
            } else {
                a(40);
                a(22, 22);
                i2 = 10;
                a(24, 10, 76);
                i3 = 7;
            }
            setAdMarkView(i3);
            setAdTextView(i2);
        }
    }

    private void setAdMarkView(int i2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(65562, this, i2) == null) {
            this.w.setTextSize(i2);
            this.w.setText(com.kwad.sdk.core.response.b.a.v(this.j));
        }
    }

    private void setAdTextView(int i2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(65563, this, i2) == null) {
            this.y.setTextSize(i2);
            String v = com.kwad.sdk.core.response.b.c.v(this.f37250h);
            if (ag.a(v) && com.kwad.sdk.core.response.b.c.c(this.f37250h)) {
                v = getContext().getString(R.string.ksad_ad_default_username_normal);
            }
            this.y.setText(v);
            this.y.setClickable(true);
            this.y.setOnClickListener(this);
        }
    }

    private void setBackgroundImageView(String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(65564, this, str) == null) {
            if (!q()) {
                this.f37245c.setVisibility(8);
                return;
            }
            this.f37245c.setVisibility(0);
            com.kwad.sdk.core.d.a.a("EntryPhotoView", "blurBackgroundUrl=" + str);
            com.kwad.sdk.glide.c.b(getContext()).a(str).a(getContext().getResources().getDrawable(R.drawable.ksad_entry_blur_def_bg)).b(getContext().getResources().getDrawable(R.drawable.ksad_entry_blur_def_bg)).c(getContext().getResources().getDrawable(R.drawable.ksad_entry_blur_def_bg)).a((e) new com.kwad.sdk.c(str, this.f37250h)).a((ImageView) this.f37245c);
        }
    }

    private void setCoverImageView(String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(65565, this, str) == null) {
            com.kwad.sdk.core.d.a.a("EntryPhotoView", "coverUrl=" + str);
            com.kwad.sdk.glide.c.b(getContext()).a(str).a(getContext().getResources().getDrawable(R.drawable.ksad_loading_entry)).b(getContext().getResources().getDrawable(R.drawable.ksad_loading_entry)).c(getContext().getResources().getDrawable(R.drawable.ksad_loading_entry)).a((e) new com.kwad.sdk.c(str, this.f37250h)).a((ImageView) this.f37244b);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void setSelectedAdButton(boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(65566, this, z) == null) {
            com.kwad.sdk.core.d.a.a("EntryPhotoView", "setButtonBackground selected=" + z);
            TextView textView = this.x;
            if (textView != null) {
                textView.setSelected(z);
            }
        }
    }

    private void t() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(65567, this) == null) {
            if (!this.z) {
                this.u.inflate();
            }
            this.u.setVisibility(0);
            this.u.setClickable(true);
            this.u.setOnClickListener(this);
            this.A = (RelativeLayout) findViewById(R.id.ksad_entryitem_ad_layout);
            this.v = (RoundAngleImageView) findViewById(R.id.ksad_entryitem_ad_app_icon);
            this.x = (TextView) findViewById(R.id.ksad_entryitem_ad_btn);
            this.y = (TextView) findViewById(R.id.ksad_entryitem_ad_text);
            this.w = (TextView) findViewById(R.id.ksad_entryitem_ad_mark);
        }
    }

    @Override // com.kwad.sdk.widget.a
    public void a() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
            super.a();
            if (com.kwad.sdk.core.response.b.c.c(this.f37250h) && this.z) {
                com.kwad.sdk.core.report.b.a(this.f37250h, (JSONObject) null);
            }
            com.kwad.sdk.core.report.e.b(this.f37250h, this.o);
        }
    }

    public void a(int i2, String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeIL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, i2, str) == null) {
            this.n = i2;
            this.o = str;
        }
    }

    public void a(@NonNull AdTemplate adTemplate, com.kwad.sdk.core.response.model.a aVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(Constants.METHOD_SEND_USER_MSG, this, adTemplate, aVar) == null) {
            this.f37249g = aVar;
            this.f37250h = adTemplate;
            r();
            if (com.kwad.sdk.core.response.b.c.c(this.f37250h)) {
                this.j = com.kwad.sdk.core.response.b.c.j(this.f37250h);
                m();
                return;
            }
            this.f37251i = com.kwad.sdk.core.response.b.c.k(this.f37250h);
            o();
        }
    }

    @Override // com.kwad.sdk.core.view.g.a
    public void a(boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(1048579, this, z) == null) {
            if (z) {
                d();
            } else {
                e();
            }
        }
    }

    public void a(boolean z, boolean z2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeCommon(1048580, this, new Object[]{Boolean.valueOf(z), Boolean.valueOf(z2)}) == null) {
            this.k = z;
            this.l = z2;
        }
    }

    public void b() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048581, this) == null) {
            AnimatedImageView animatedImageView = (AnimatedImageView) findViewById(R.id.ksad_entryitem_photocover);
            this.f37244b = animatedImageView;
            animatedImageView.setRadius(ao.a(getContext(), 4.0f));
            RoundAngleImageView roundAngleImageView = (RoundAngleImageView) findViewById(R.id.ksad_entryitem_background);
            this.f37245c = roundAngleImageView;
            roundAngleImageView.setRadius(ao.a(getContext(), 4.0f));
            this.f37246d = (TextView) findViewById(R.id.ksad_entryitem_lickcount);
            this.m = findViewById(R.id.ksad_entryitem_lookmore);
            this.f37247e = (TextView) findViewById(R.id.ksad_entryitem_title);
            this.f37248f = (ImageView) findViewById(R.id.ksad_entryitem_playbtn);
            ViewStub viewStub = (ViewStub) findViewById(R.id.ksad_entryitem_ad_bottom_viewstub);
            this.u = viewStub;
            viewStub.setOnInflateListener(new ViewStub.OnInflateListener(this) { // from class: com.kwad.sdk.entry.view.EntryPhotoView.1
                public static /* synthetic */ Interceptable $ic;
                public transient /* synthetic */ FieldHolder $fh;

                /* renamed from: a  reason: collision with root package name */
                public final /* synthetic */ EntryPhotoView f37252a;

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
                    this.f37252a = this;
                }

                @Override // android.view.ViewStub.OnInflateListener
                public void onInflate(ViewStub viewStub2, View view) {
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 == null || interceptable2.invokeLL(1048576, this, viewStub2, view) == null) {
                        this.f37252a.z = true;
                    }
                }
            });
        }
    }

    public void c() {
        AnimatedImageView animatedImageView;
        Context context;
        float f2;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048582, this) == null) {
            if (q()) {
                this.f37244b.setScaleType(ImageView.ScaleType.FIT_CENTER);
                animatedImageView = this.f37244b;
                context = getContext();
                f2 = 0.0f;
            } else {
                this.f37244b.setScaleType(ImageView.ScaleType.CENTER_CROP);
                animatedImageView = this.f37244b;
                context = getContext();
                f2 = 4.0f;
            }
            animatedImageView.setRadius(ao.a(context, f2));
        }
    }

    public void d() {
        AnimatedImageView animatedImageView;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(1048583, this) == null) || (animatedImageView = this.f37244b) == null || this.t) {
            return;
        }
        animatedImageView.a();
        this.t = true;
    }

    @Override // android.view.ViewGroup, android.view.View
    public boolean dispatchTouchEvent(MotionEvent motionEvent) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(InputDeviceCompat.SOURCE_TOUCHPAD, this, motionEvent)) == null) {
            int action = motionEvent.getAction();
            if (action == 0) {
                f37243a.a(getWidth(), getHeight());
                f37243a.a(motionEvent.getX(), motionEvent.getY());
            } else if (action == 1) {
                f37243a.b(motionEvent.getX(), motionEvent.getY());
            }
            return super.dispatchTouchEvent(motionEvent);
        }
        return invokeL.booleanValue;
    }

    public void e() {
        AnimatedImageView animatedImageView;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeV(1048585, this) == null) && (animatedImageView = this.f37244b) != null && this.t) {
            animatedImageView.b();
            this.t = false;
        }
    }

    public void f() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048586, this) == null) {
            d();
        }
    }

    public void g() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048587, this) == null) {
            e();
        }
    }

    public String getEntryId() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048588, this)) == null) ? this.o : (String) invokeV.objValue;
    }

    public int getPosition() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048589, this)) == null) ? this.n : invokeV.intValue;
    }

    public AdTemplate getTemplateData() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048590, this)) == null) ? this.f37250h : (AdTemplate) invokeV.objValue;
    }

    @MainThread
    public s.a getTouchCoords() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048591, this)) == null) ? f37243a : (s.a) invokeV.objValue;
    }

    public void h() {
        g gVar;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(1048592, this) == null) || (gVar = this.p) == null) {
            return;
        }
        gVar.b();
    }

    @Override // com.kwad.sdk.widget.a, android.view.ViewGroup, android.view.View
    public void onAttachedToWindow() {
        g gVar;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048593, this) == null) {
            super.onAttachedToWindow();
            if (this.l && (gVar = this.p) != null) {
                gVar.a();
            }
            g gVar2 = this.B;
            if (gVar2 != null) {
                gVar2.a();
            }
        }
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048594, this, view) == null) {
            int i2 = view == this.v ? 55 : view == this.y ? 82 : view == this.x ? 83 : view == this.A ? 35 : 0;
            com.kwad.sdk.core.download.b.b.a(this.r, true);
            com.kwad.sdk.core.download.b.a.a(view.getContext(), this.f37250h, new a.InterfaceC0426a(this, i2) { // from class: com.kwad.sdk.entry.view.EntryPhotoView.7
                public static /* synthetic */ Interceptable $ic;
                public transient /* synthetic */ FieldHolder $fh;

                /* renamed from: a  reason: collision with root package name */
                public final /* synthetic */ int f37259a;

                /* renamed from: b  reason: collision with root package name */
                public final /* synthetic */ EntryPhotoView f37260b;

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
                    this.f37260b = this;
                    this.f37259a = i2;
                }

                @Override // com.kwad.sdk.core.download.b.a.InterfaceC0426a
                public void a() {
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 == null || interceptable2.invokeV(1048576, this) == null) {
                        this.f37260b.f37250h.mHasEntryAdClick = true;
                        this.f37260b.b(this.f37259a);
                    }
                }
            }, this.r);
        }
    }

    @Override // com.kwad.sdk.widget.a, android.view.ViewGroup, android.view.View
    public void onDetachedFromWindow() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048595, this) == null) {
            super.onDetachedFromWindow();
            h();
            g gVar = this.B;
            if (gVar != null) {
                gVar.b();
            }
        }
    }

    @Override // android.view.View
    public void onFinishInflate() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048596, this) == null) {
            super.onFinishInflate();
            b();
        }
    }

    public void setAdShowStyle(int i2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048597, this, i2) == null) {
            this.q = i2;
        }
    }

    public void setLikeViewPos(int i2) {
        FrameLayout.LayoutParams layoutParams;
        int i3;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048598, this, i2) == null) {
            if (i2 == 0) {
                this.f37246d.setVisibility(8);
                return;
            }
            if (i2 == 1) {
                this.f37246d.setVisibility(0);
                layoutParams = (FrameLayout.LayoutParams) this.f37246d.getLayoutParams();
                i3 = 83;
            } else if (i2 != 2) {
                return;
            } else {
                this.f37246d.setVisibility(0);
                layoutParams = (FrameLayout.LayoutParams) this.f37246d.getLayoutParams();
                i3 = 85;
            }
            layoutParams.gravity = i3;
        }
    }

    public void setLookMoreVisible(boolean z) {
        TextView textView;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(1048599, this, z) == null) {
            if (z) {
                this.m.setVisibility(0);
                this.f37246d.setVisibility(8);
                this.f37248f.setVisibility(8);
                textView = this.f37247e;
            } else {
                this.m.setVisibility(8);
                this.f37246d.setVisibility(0);
                this.f37248f.setVisibility(0);
                this.f37247e.setVisibility(0);
                if (!com.kwad.sdk.core.response.b.c.c(this.f37250h)) {
                    this.f37246d.setVisibility(0);
                    return;
                }
                textView = this.f37246d;
            }
            textView.setVisibility(8);
        }
    }

    @Override // android.view.View
    public void setOnClickListener(@Nullable View.OnClickListener onClickListener) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048600, this, onClickListener) == null) {
            super.setOnClickListener(onClickListener);
            this.E = onClickListener;
        }
    }

    public void setPlayBtnRes(int i2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048601, this, i2) == null) {
            this.f37248f.setImageResource(i2);
        }
    }
}
