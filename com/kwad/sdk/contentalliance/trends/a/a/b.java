package com.kwad.sdk.contentalliance.trends.a.a;

import android.os.Handler;
import android.view.ViewGroup;
import android.widget.TextView;
import androidx.viewpager.widget.ViewPager;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import com.kwad.sdk.R;
import com.kwad.sdk.core.response.b.c;
import com.kwad.sdk.core.response.model.TrendInfo;
import org.json.JSONObject;
/* loaded from: classes7.dex */
public class b extends com.kwad.sdk.contentalliance.detail.b {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    /* renamed from: b  reason: collision with root package name */
    public TextView f35474b;

    /* renamed from: c  reason: collision with root package name */
    public TextView f35475c;

    /* renamed from: d  reason: collision with root package name */
    public ViewGroup f35476d;

    /* renamed from: e  reason: collision with root package name */
    public Handler f35477e;

    /* renamed from: f  reason: collision with root package name */
    public boolean f35478f;

    /* renamed from: g  reason: collision with root package name */
    public ViewGroup f35479g;

    /* renamed from: h  reason: collision with root package name */
    public com.kwad.sdk.contentalliance.a.a f35480h;

    /* renamed from: i  reason: collision with root package name */
    public ViewPager.OnPageChangeListener f35481i;

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
        this.f35478f = false;
        this.f35480h = new com.kwad.sdk.contentalliance.a.b(this) { // from class: com.kwad.sdk.contentalliance.trends.a.a.b.1
            public static /* synthetic */ Interceptable $ic;
            public transient /* synthetic */ FieldHolder $fh;

            /* renamed from: a  reason: collision with root package name */
            public final /* synthetic */ b f35482a;

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
                this.f35482a = this;
            }

            @Override // com.kwad.sdk.contentalliance.a.b, com.kwad.sdk.contentalliance.a.a
            public void j() {
                Interceptable interceptable2 = $ic;
                if (interceptable2 == null || interceptable2.invokeV(1048576, this) == null) {
                    super.j();
                    if (this.f35482a.f35478f) {
                        this.f35482a.f35477e.postDelayed(new Runnable(this) { // from class: com.kwad.sdk.contentalliance.trends.a.a.b.1.1
                            public static /* synthetic */ Interceptable $ic;
                            public transient /* synthetic */ FieldHolder $fh;

                            /* renamed from: a  reason: collision with root package name */
                            public final /* synthetic */ AnonymousClass1 f35483a;

                            {
                                Interceptable interceptable3 = $ic;
                                if (interceptable3 != null) {
                                    InitContext newInitContext2 = TitanRuntime.newInitContext();
                                    newInitContext2.initArgs = r2;
                                    Object[] objArr = {this};
                                    interceptable3.invokeUnInit(65536, newInitContext2);
                                    int i4 = newInitContext2.flag;
                                    if ((i4 & 1) != 0) {
                                        int i5 = i4 & 2;
                                        newInitContext2.thisArg = this;
                                        interceptable3.invokeInitBody(65536, newInitContext2);
                                        return;
                                    }
                                }
                                this.f35483a = this;
                            }

                            @Override // java.lang.Runnable
                            public void run() {
                                Interceptable interceptable3 = $ic;
                                if (interceptable3 == null || interceptable3.invokeV(1048576, this) == null) {
                                    this.f35483a.f35482a.f35476d.setVisibility(8);
                                }
                            }
                        }, 1000L);
                    }
                }
            }

            @Override // com.kwad.sdk.contentalliance.a.b, com.kwad.sdk.contentalliance.a.a
            public void k() {
                Interceptable interceptable2 = $ic;
                if (interceptable2 == null || interceptable2.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this) == null) {
                    super.k();
                    if (this.f35482a.f35478f) {
                        this.f35482a.f35477e.removeCallbacksAndMessages(null);
                    }
                }
            }
        };
        this.f35481i = new ViewPager.OnPageChangeListener(this) { // from class: com.kwad.sdk.contentalliance.trends.a.a.b.2
            public static /* synthetic */ Interceptable $ic;
            public transient /* synthetic */ FieldHolder $fh;

            /* renamed from: a  reason: collision with root package name */
            public final /* synthetic */ b f35484a;

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
                this.f35484a = this;
            }

            @Override // androidx.viewpager.widget.ViewPager.OnPageChangeListener
            public void onPageScrollStateChanged(int i4) {
                Interceptable interceptable2 = $ic;
                if (interceptable2 == null || interceptable2.invokeI(1048576, this, i4) == null) {
                }
            }

            @Override // androidx.viewpager.widget.ViewPager.OnPageChangeListener
            public void onPageScrolled(int i4, float f2, int i5) {
                Interceptable interceptable2 = $ic;
                if (interceptable2 == null || interceptable2.invokeCommon(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, new Object[]{Integer.valueOf(i4), Float.valueOf(f2), Integer.valueOf(i5)}) == null) {
                    CharSequence pageTitle = ((com.kwad.sdk.contentalliance.detail.b) this.f35484a).f34553a.l.getAdapter().getPageTitle(((com.kwad.sdk.contentalliance.detail.b) this.f35484a).f34553a.l.getCurrentItem());
                    if (!this.f35484a.f35478f || ((com.kwad.sdk.contentalliance.detail.b) this.f35484a).f34553a.j.mCurrentTrendTitle == null || ((com.kwad.sdk.contentalliance.detail.b) this.f35484a).f34553a.j.mCurrentTrendTitle.equals(pageTitle.toString()) || this.f35484a.f35476d.getVisibility() == 0) {
                        return;
                    }
                    this.f35484a.f35476d.setVisibility(0);
                }
            }

            @Override // androidx.viewpager.widget.ViewPager.OnPageChangeListener
            public void onPageSelected(int i4) {
                Interceptable interceptable2 = $ic;
                if (interceptable2 == null || interceptable2.invokeI(Constants.METHOD_SEND_USER_MSG, this, i4) == null) {
                }
            }
        };
    }

    @Override // com.kwad.sdk.contentalliance.detail.b, com.kwad.sdk.mvp.Presenter
    public void a() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
            super.a();
            this.f35476d.setVisibility(8);
            if (c.B(((com.kwad.sdk.contentalliance.detail.b) this).f34553a.j)) {
                com.kwad.sdk.contentalliance.detail.c cVar = ((com.kwad.sdk.contentalliance.detail.b) this).f34553a;
                if (cVar.j.mTrendSlideType != null) {
                    cVar.f34575b.add(this.f35480h);
                    TrendInfo trendInfo = new TrendInfo();
                    try {
                        trendInfo.parseJson(new JSONObject(((com.kwad.sdk.contentalliance.detail.b) this).f34553a.j.mCurrentTrendTitle));
                    } catch (Exception e2) {
                        e2.printStackTrace();
                    }
                    this.f35475c.setText(trendInfo.name);
                    this.f35474b.setText(((com.kwad.sdk.contentalliance.detail.b) this).f34553a.j.mTrendSlideType);
                    this.f35478f = true;
                    ((com.kwad.sdk.contentalliance.detail.b) this).f34553a.l.a(this.f35481i);
                }
                this.f35479g.setVisibility(0);
            }
        }
    }

    @Override // com.kwad.sdk.mvp.Presenter
    public void b_() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this) == null) {
            super.b_();
            com.kwad.sdk.contentalliance.detail.c cVar = ((com.kwad.sdk.contentalliance.detail.b) this).f34553a;
            if (cVar.j.mTrendSlideType != null) {
                cVar.f34575b.remove(this.f35480h);
                ((com.kwad.sdk.contentalliance.detail.b) this).f34553a.l.b(this.f35481i);
            }
            this.f35477e.removeCallbacksAndMessages(null);
            this.f35476d.setVisibility(8);
        }
    }

    @Override // com.kwad.sdk.mvp.Presenter
    public void c() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this) == null) {
            super.c();
            this.f35477e = new Handler();
            this.f35476d = (ViewGroup) b(R.id.ksad_photo_trend_container);
            this.f35475c = (TextView) b(R.id.ksad_content_alliance_trend_title);
            this.f35474b = (TextView) b(R.id.ksad_content_alliance_trend_type);
            this.f35479g = (ViewGroup) b(R.id.ksad_trend_feed_margin);
        }
    }
}
