package com.kwad.sdk.contentalliance.detail.a;

import android.graphics.drawable.Drawable;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import androidx.annotation.Nullable;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.mobads.container.util.AdIconUtil;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import com.kwad.sdk.R;
import com.kwad.sdk.contentalliance.detail.video.f;
import com.kwad.sdk.core.response.model.AdTemplate;
import com.kwad.sdk.glide.load.DataSource;
import com.kwad.sdk.glide.load.engine.GlideException;
import com.kwad.sdk.glide.request.a.j;
import com.kwad.sdk.internal.api.SceneImpl;
import com.kwad.sdk.utils.ao;
/* loaded from: classes7.dex */
public class a extends com.kwad.sdk.contentalliance.detail.b {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    /* renamed from: b  reason: collision with root package name */
    public ImageView f34337b;

    /* renamed from: c  reason: collision with root package name */
    public AdTemplate f34338c;

    /* renamed from: d  reason: collision with root package name */
    public Runnable f34339d;

    /* renamed from: e  reason: collision with root package name */
    public com.kwad.sdk.contentalliance.a.a f34340e;

    /* renamed from: f  reason: collision with root package name */
    public com.kwad.sdk.contentalliance.detail.video.e f34341f;

    /* renamed from: g  reason: collision with root package name */
    public Runnable f34342g;

    public a() {
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
        this.f34339d = new Runnable(this) { // from class: com.kwad.sdk.contentalliance.detail.a.a.1
            public static /* synthetic */ Interceptable $ic;
            public transient /* synthetic */ FieldHolder $fh;

            /* renamed from: a  reason: collision with root package name */
            public final /* synthetic */ a f34343a;

            {
                Interceptable interceptable2 = $ic;
                if (interceptable2 != null) {
                    InitContext newInitContext2 = TitanRuntime.newInitContext();
                    newInitContext2.initArgs = r2;
                    Object[] objArr = {this};
                    interceptable2.invokeUnInit(65536, newInitContext2);
                    int i4 = newInitContext2.flag;
                    if ((i4 & 1) != 0) {
                        int i5 = i4 & 2;
                        newInitContext2.thisArg = this;
                        interceptable2.invokeInitBody(65536, newInitContext2);
                        return;
                    }
                }
                this.f34343a = this;
            }

            @Override // java.lang.Runnable
            public void run() {
                ImageView.ScaleType scaleType;
                ImageView imageView;
                Interceptable interceptable2 = $ic;
                if (!(interceptable2 == null || interceptable2.invokeV(1048576, this) == null) || ((com.kwad.sdk.contentalliance.detail.b) this.f34343a).f34553a.k == null || !((com.kwad.sdk.contentalliance.detail.b) this.f34343a).f34553a.k.isAdded() || ((com.kwad.sdk.contentalliance.detail.b) this.f34343a).f34553a.k.getActivity() == null) {
                    return;
                }
                int width = this.f34343a.l().getWidth();
                int height = this.f34343a.l().getHeight();
                com.kwad.sdk.core.response.model.c m = com.kwad.sdk.core.response.b.c.m(this.f34343a.f34338c);
                ViewGroup.LayoutParams layoutParams = this.f34343a.f34337b.getLayoutParams();
                int c2 = m.c();
                int b2 = m.b();
                try {
                    if (c2 == 0 || b2 == 0) {
                        layoutParams.width = -1;
                        layoutParams.height = -1;
                        this.f34343a.f34337b.setLayoutParams(layoutParams);
                    } else if (!ao.a(null, width, height, this.f34343a.f34338c.photoInfo.videoInfo)) {
                        layoutParams.width = width;
                        layoutParams.height = (int) ((b2 / (c2 * 1.0f)) * width);
                        this.f34343a.f34337b.setLayoutParams(layoutParams);
                        imageView = this.f34343a.f34337b;
                        scaleType = ImageView.ScaleType.FIT_CENTER;
                        imageView.setScaleType(scaleType);
                        String a2 = m.a();
                        com.kwad.sdk.glide.c.a(((com.kwad.sdk.contentalliance.detail.b) this.f34343a).f34553a.k).a(a2).a((com.kwad.sdk.glide.request.e<Drawable>) new com.kwad.sdk.c(a2, this.f34343a.f34338c)).b(new com.kwad.sdk.glide.request.e<Drawable>(this, a2) { // from class: com.kwad.sdk.contentalliance.detail.a.a.1.1
                            public static /* synthetic */ Interceptable $ic;
                            public transient /* synthetic */ FieldHolder $fh;

                            /* renamed from: a  reason: collision with root package name */
                            public final /* synthetic */ String f34344a;

                            /* renamed from: b  reason: collision with root package name */
                            public final /* synthetic */ AnonymousClass1 f34345b;

                            {
                                Interceptable interceptable3 = $ic;
                                if (interceptable3 != null) {
                                    InitContext newInitContext2 = TitanRuntime.newInitContext();
                                    newInitContext2.initArgs = r2;
                                    Object[] objArr = {this, a2};
                                    interceptable3.invokeUnInit(65536, newInitContext2);
                                    int i4 = newInitContext2.flag;
                                    if ((i4 & 1) != 0) {
                                        int i5 = i4 & 2;
                                        newInitContext2.thisArg = this;
                                        interceptable3.invokeInitBody(65536, newInitContext2);
                                        return;
                                    }
                                }
                                this.f34345b = this;
                                this.f34344a = a2;
                            }

                            /* JADX DEBUG: Method merged with bridge method */
                            @Override // com.kwad.sdk.glide.request.e
                            public boolean a(Drawable drawable, Object obj, j<Drawable> jVar, DataSource dataSource, boolean z) {
                                InterceptResult invokeCommon;
                                Interceptable interceptable3 = $ic;
                                if (interceptable3 == null || (invokeCommon = interceptable3.invokeCommon(1048576, this, new Object[]{drawable, obj, jVar, dataSource, Boolean.valueOf(z)})) == null) {
                                    return false;
                                }
                                return invokeCommon.booleanValue;
                            }

                            @Override // com.kwad.sdk.glide.request.e
                            public boolean a(@Nullable GlideException glideException, Object obj, j<Drawable> jVar, boolean z) {
                                InterceptResult invokeCommon;
                                Interceptable interceptable3 = $ic;
                                if (interceptable3 == null || (invokeCommon = interceptable3.invokeCommon(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, new Object[]{glideException, obj, jVar, Boolean.valueOf(z)})) == null) {
                                    com.kwad.sdk.core.report.e.a(((com.kwad.sdk.contentalliance.detail.b) this.f34345b.f34343a).f34553a.j, this.f34344a);
                                    return false;
                                }
                                return invokeCommon.booleanValue;
                            }
                        }).a(this.f34343a.f34337b);
                        return;
                    } else {
                        ViewGroup.LayoutParams layoutParams2 = this.f34343a.f34337b.getLayoutParams();
                        layoutParams.width = -1;
                        layoutParams.height = -1;
                        this.f34343a.f34337b.setLayoutParams(layoutParams2);
                    }
                    com.kwad.sdk.glide.c.a(((com.kwad.sdk.contentalliance.detail.b) this.f34343a).f34553a.k).a(a2).a((com.kwad.sdk.glide.request.e<Drawable>) new com.kwad.sdk.c(a2, this.f34343a.f34338c)).b(new com.kwad.sdk.glide.request.e<Drawable>(this, a2) { // from class: com.kwad.sdk.contentalliance.detail.a.a.1.1
                        public static /* synthetic */ Interceptable $ic;
                        public transient /* synthetic */ FieldHolder $fh;

                        /* renamed from: a  reason: collision with root package name */
                        public final /* synthetic */ String f34344a;

                        /* renamed from: b  reason: collision with root package name */
                        public final /* synthetic */ AnonymousClass1 f34345b;

                        {
                            Interceptable interceptable3 = $ic;
                            if (interceptable3 != null) {
                                InitContext newInitContext2 = TitanRuntime.newInitContext();
                                newInitContext2.initArgs = objArr;
                                Object[] objArr = {this, a2};
                                interceptable3.invokeUnInit(65536, newInitContext2);
                                int i4 = newInitContext2.flag;
                                if ((i4 & 1) != 0) {
                                    int i5 = i4 & 2;
                                    newInitContext2.thisArg = this;
                                    interceptable3.invokeInitBody(65536, newInitContext2);
                                    return;
                                }
                            }
                            this.f34345b = this;
                            this.f34344a = a2;
                        }

                        /* JADX DEBUG: Method merged with bridge method */
                        @Override // com.kwad.sdk.glide.request.e
                        public boolean a(Drawable drawable, Object obj, j<Drawable> jVar, DataSource dataSource, boolean z) {
                            InterceptResult invokeCommon;
                            Interceptable interceptable3 = $ic;
                            if (interceptable3 == null || (invokeCommon = interceptable3.invokeCommon(1048576, this, new Object[]{drawable, obj, jVar, dataSource, Boolean.valueOf(z)})) == null) {
                                return false;
                            }
                            return invokeCommon.booleanValue;
                        }

                        @Override // com.kwad.sdk.glide.request.e
                        public boolean a(@Nullable GlideException glideException, Object obj, j<Drawable> jVar, boolean z) {
                            InterceptResult invokeCommon;
                            Interceptable interceptable3 = $ic;
                            if (interceptable3 == null || (invokeCommon = interceptable3.invokeCommon(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, new Object[]{glideException, obj, jVar, Boolean.valueOf(z)})) == null) {
                                com.kwad.sdk.core.report.e.a(((com.kwad.sdk.contentalliance.detail.b) this.f34345b.f34343a).f34553a.j, this.f34344a);
                                return false;
                            }
                            return invokeCommon.booleanValue;
                        }
                    }).a(this.f34343a.f34337b);
                    return;
                } catch (Exception e2) {
                    com.kwad.sdk.core.d.a.b(e2);
                    return;
                }
                imageView = this.f34343a.f34337b;
                scaleType = ImageView.ScaleType.CENTER_CROP;
                imageView.setScaleType(scaleType);
                String a22 = m.a();
            }
        };
        this.f34340e = new com.kwad.sdk.contentalliance.a.b(this) { // from class: com.kwad.sdk.contentalliance.detail.a.a.2
            public static /* synthetic */ Interceptable $ic;
            public transient /* synthetic */ FieldHolder $fh;

            /* renamed from: a  reason: collision with root package name */
            public final /* synthetic */ a f34346a;

            {
                Interceptable interceptable2 = $ic;
                if (interceptable2 != null) {
                    InitContext newInitContext2 = TitanRuntime.newInitContext();
                    newInitContext2.initArgs = r2;
                    Object[] objArr = {this};
                    interceptable2.invokeUnInit(65536, newInitContext2);
                    int i4 = newInitContext2.flag;
                    if ((i4 & 1) != 0) {
                        int i5 = i4 & 2;
                        newInitContext2.thisArg = this;
                        interceptable2.invokeInitBody(65536, newInitContext2);
                        return;
                    }
                }
                this.f34346a = this;
            }

            @Override // com.kwad.sdk.contentalliance.a.b, com.kwad.sdk.contentalliance.a.a
            public void k() {
                Interceptable interceptable2 = $ic;
                if (interceptable2 == null || interceptable2.invokeV(1048576, this) == null) {
                    super.k();
                    this.f34346a.f34337b.setVisibility(0);
                }
            }
        };
        this.f34341f = new f(this) { // from class: com.kwad.sdk.contentalliance.detail.a.a.3
            public static /* synthetic */ Interceptable $ic;
            public transient /* synthetic */ FieldHolder $fh;

            /* renamed from: a  reason: collision with root package name */
            public final /* synthetic */ a f34347a;

            {
                Interceptable interceptable2 = $ic;
                if (interceptable2 != null) {
                    InitContext newInitContext2 = TitanRuntime.newInitContext();
                    newInitContext2.initArgs = r2;
                    Object[] objArr = {this};
                    interceptable2.invokeUnInit(65536, newInitContext2);
                    int i4 = newInitContext2.flag;
                    if ((i4 & 1) != 0) {
                        int i5 = i4 & 2;
                        newInitContext2.thisArg = this;
                        interceptable2.invokeInitBody(65536, newInitContext2);
                        return;
                    }
                }
                this.f34347a = this;
            }

            @Override // com.kwad.sdk.contentalliance.detail.video.f, com.kwad.sdk.contentalliance.detail.video.e
            public void a() {
                Interceptable interceptable2 = $ic;
                if (!(interceptable2 == null || interceptable2.invokeV(1048576, this) == null) || com.kwad.sdk.core.response.b.c.c(this.f34347a.f34338c)) {
                    return;
                }
                ((com.kwad.sdk.contentalliance.detail.b) this.f34347a).f34553a.l.post(this.f34347a.f34342g);
            }

            @Override // com.kwad.sdk.contentalliance.detail.video.f, com.kwad.sdk.contentalliance.detail.video.e
            public void d() {
                Interceptable interceptable2 = $ic;
                if (interceptable2 == null || interceptable2.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this) == null) {
                    super.d();
                    if (this.f34347a.f34337b.getVisibility() == 0) {
                        this.f34347a.f34337b.setVisibility(8);
                    }
                }
            }
        };
        this.f34342g = new Runnable(this) { // from class: com.kwad.sdk.contentalliance.detail.a.a.4
            public static /* synthetic */ Interceptable $ic;
            public transient /* synthetic */ FieldHolder $fh;

            /* renamed from: a  reason: collision with root package name */
            public final /* synthetic */ a f34348a;

            {
                Interceptable interceptable2 = $ic;
                if (interceptable2 != null) {
                    InitContext newInitContext2 = TitanRuntime.newInitContext();
                    newInitContext2.initArgs = r2;
                    Object[] objArr = {this};
                    interceptable2.invokeUnInit(65536, newInitContext2);
                    int i4 = newInitContext2.flag;
                    if ((i4 & 1) != 0) {
                        int i5 = i4 & 2;
                        newInitContext2.thisArg = this;
                        interceptable2.invokeInitBody(65536, newInitContext2);
                        return;
                    }
                }
                this.f34348a = this;
            }

            @Override // java.lang.Runnable
            public void run() {
                Interceptable interceptable2 = $ic;
                if (interceptable2 == null || interceptable2.invokeV(1048576, this) == null) {
                    if (!this.f34348a.e()) {
                        ((com.kwad.sdk.contentalliance.detail.b) this.f34348a).f34553a.l.a(true);
                    } else if (((com.kwad.sdk.contentalliance.detail.b) this.f34348a).f34553a.m != null) {
                        ((com.kwad.sdk.contentalliance.detail.b) this.f34348a).f34553a.m.h();
                    }
                }
            }
        };
    }

    /* JADX INFO: Access modifiers changed from: private */
    public boolean e() {
        InterceptResult invokeV;
        SceneImpl sceneImpl;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(AdIconUtil.BAIDU_LOGO_ID, this)) == null) {
            AdTemplate adTemplate = this.f34338c;
            int pageScene = (adTemplate == null || (sceneImpl = adTemplate.mAdScene) == null) ? 0 : sceneImpl.getPageScene();
            return ((com.kwad.sdk.contentalliance.detail.b) this).f34553a.l.a() || !((com.kwad.sdk.contentalliance.detail.b) this).f34553a.l.k() || ((com.kwad.sdk.contentalliance.detail.b) this).f34553a.f34580g || ((pageScene == 1 && com.kwad.sdk.core.config.c.t() == 1) || (pageScene == 5 && com.kwad.sdk.core.config.c.u() == 1));
        }
        return invokeV.booleanValue;
    }

    @Override // com.kwad.sdk.contentalliance.detail.b, com.kwad.sdk.mvp.Presenter
    public void a() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
            super.a();
            this.f34338c = ((com.kwad.sdk.contentalliance.detail.b) this).f34553a.j;
            l().post(this.f34339d);
            ((com.kwad.sdk.contentalliance.detail.b) this).f34553a.f34575b.add(this.f34340e);
            com.kwad.sdk.contentalliance.detail.video.b bVar = ((com.kwad.sdk.contentalliance.detail.b) this).f34553a.m;
            if (bVar != null) {
                bVar.a(this.f34341f);
            }
        }
    }

    @Override // com.kwad.sdk.mvp.Presenter
    public void b_() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this) == null) {
            super.b_();
            l().removeCallbacks(this.f34339d);
            ((com.kwad.sdk.contentalliance.detail.b) this).f34553a.l.removeCallbacks(this.f34342g);
            ((com.kwad.sdk.contentalliance.detail.b) this).f34553a.f34575b.remove(this.f34340e);
            com.kwad.sdk.contentalliance.detail.video.b bVar = ((com.kwad.sdk.contentalliance.detail.b) this).f34553a.m;
            if (bVar != null) {
                bVar.b(this.f34341f);
            }
        }
    }

    @Override // com.kwad.sdk.mvp.Presenter
    public void c() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this) == null) {
            super.c();
            this.f34337b = (ImageView) b(R.id.ksad_video_first_frame);
        }
    }

    @Override // com.kwad.sdk.mvp.Presenter
    public void d() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048579, this) == null) {
            super.d();
            View l = l();
            if (l != null) {
                l.removeCallbacks(this.f34339d);
            }
        }
    }
}
