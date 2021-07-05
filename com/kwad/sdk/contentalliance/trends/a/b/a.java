package com.kwad.sdk.contentalliance.trends.a.b;

import android.app.Activity;
import android.text.TextUtils;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import androidx.annotation.NonNull;
import androidx.viewpager.widget.ViewPager;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.livesdk.sdk.service.IMLikeRequest;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import com.kwad.sdk.R;
import com.kwad.sdk.contentalliance.home.a.d;
import com.kwad.sdk.contentalliance.home.a.i;
import com.kwad.sdk.contentalliance.home.e;
import com.kwad.sdk.contentalliance.home.h;
import com.kwad.sdk.core.response.model.TrendInfo;
import com.kwad.sdk.utils.ag;
import org.json.JSONObject;
/* loaded from: classes7.dex */
public class a extends e {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    /* renamed from: b  reason: collision with root package name */
    public Runnable f35485b;

    /* renamed from: c  reason: collision with root package name */
    public TextView f35486c;

    /* renamed from: d  reason: collision with root package name */
    public ImageView f35487d;

    /* renamed from: e  reason: collision with root package name */
    public TextView f35488e;

    /* renamed from: f  reason: collision with root package name */
    public ViewGroup f35489f;

    /* renamed from: g  reason: collision with root package name */
    public i f35490g;

    /* renamed from: h  reason: collision with root package name */
    public boolean f35491h;

    /* renamed from: i  reason: collision with root package name */
    public com.kwad.sdk.contentalliance.trends.view.c f35492i;
    public d j;
    public ViewPager.OnPageChangeListener k;

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
        this.f35492i = new com.kwad.sdk.contentalliance.trends.view.d(this) { // from class: com.kwad.sdk.contentalliance.trends.a.b.a.1
            public static /* synthetic */ Interceptable $ic;
            public transient /* synthetic */ FieldHolder $fh;

            /* renamed from: a  reason: collision with root package name */
            public final /* synthetic */ a f35493a;

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
                this.f35493a = this;
            }

            @Override // com.kwad.sdk.contentalliance.trends.view.d, com.kwad.sdk.contentalliance.trends.view.c
            public void a() {
                Interceptable interceptable2 = $ic;
                if (interceptable2 == null || interceptable2.invokeV(1048576, this) == null) {
                    this.f35493a.f();
                    this.f35493a.f35487d.setVisibility(8);
                }
            }

            @Override // com.kwad.sdk.contentalliance.trends.view.d, com.kwad.sdk.contentalliance.trends.view.c
            public void a(View view, TrendInfo trendInfo, int i4) {
                Interceptable interceptable2 = $ic;
                if (!(interceptable2 == null || interceptable2.invokeLLI(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, view, trendInfo, i4) == null) || trendInfo == null) {
                    return;
                }
                this.f35493a.a(trendInfo);
            }

            @Override // com.kwad.sdk.contentalliance.trends.view.d, com.kwad.sdk.contentalliance.trends.view.c
            public void b() {
                Interceptable interceptable2 = $ic;
                if (interceptable2 == null || interceptable2.invokeV(Constants.METHOD_SEND_USER_MSG, this) == null) {
                    this.f35493a.e();
                    this.f35493a.f35487d.setVisibility(0);
                }
            }
        };
        this.j = new com.kwad.sdk.contentalliance.home.a.e(this) { // from class: com.kwad.sdk.contentalliance.trends.a.b.a.2
            public static /* synthetic */ Interceptable $ic;
            public transient /* synthetic */ FieldHolder $fh;

            /* renamed from: a  reason: collision with root package name */
            public final /* synthetic */ a f35494a;

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
                this.f35494a = this;
            }

            @Override // com.kwad.sdk.contentalliance.home.a.e, com.kwad.sdk.contentalliance.home.a.d
            public void a(int i4, String str) {
                Interceptable interceptable2 = $ic;
                if (interceptable2 == null || interceptable2.invokeIL(1048576, this, i4, str) == null) {
                    com.kwad.sdk.core.d.a.a("PhotoTrendFeedTitlePresenter", " onError code " + i4 + " msg " + str);
                    if (((e) this.f35494a).f35218a.f35221c.getAdapter().a() == 0) {
                        this.f35494a.f35486c.setVisibility(8);
                        this.f35494a.f35488e.setVisibility(8);
                        this.f35494a.f35491h = true;
                    }
                }
            }

            @Override // com.kwad.sdk.contentalliance.home.a.e, com.kwad.sdk.contentalliance.home.a.d
            public void a(boolean z, int i4) {
                Interceptable interceptable2 = $ic;
                if (interceptable2 == null || interceptable2.invokeCommon(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, new Object[]{Boolean.valueOf(z), Integer.valueOf(i4)}) == null) {
                    com.kwad.sdk.core.d.a.a("PhotoTrendFeedTitlePresenter", " onFinishLoading  " + z);
                    this.f35494a.f35491h = false;
                    this.f35494a.f35486c.setVisibility(0);
                    this.f35494a.f35488e.setVisibility(0);
                }
            }
        };
        this.f35485b = new Runnable(this) { // from class: com.kwad.sdk.contentalliance.trends.a.b.a.3
            public static /* synthetic */ Interceptable $ic;
            public transient /* synthetic */ FieldHolder $fh;

            /* renamed from: a  reason: collision with root package name */
            public final /* synthetic */ a f35495a;

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
                this.f35495a = this;
            }

            @Override // java.lang.Runnable
            public void run() {
                Interceptable interceptable2 = $ic;
                if (interceptable2 == null || interceptable2.invokeV(1048576, this) == null) {
                    this.f35495a.f35486c.setAlpha(1.0f);
                    this.f35495a.f35488e.setAlpha(1.0f);
                    this.f35495a.e();
                }
            }
        };
        this.k = new ViewPager.OnPageChangeListener(this) { // from class: com.kwad.sdk.contentalliance.trends.a.b.a.4
            public static /* synthetic */ Interceptable $ic;
            public transient /* synthetic */ FieldHolder $fh;

            /* renamed from: a  reason: collision with root package name */
            public final /* synthetic */ a f35496a;

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
                this.f35496a = this;
            }

            @Override // androidx.viewpager.widget.ViewPager.OnPageChangeListener
            public void onPageScrollStateChanged(int i4) {
                Interceptable interceptable2 = $ic;
                if (interceptable2 == null || interceptable2.invokeI(1048576, this, i4) == null) {
                }
            }

            @Override // androidx.viewpager.widget.ViewPager.OnPageChangeListener
            public void onPageScrolled(int i4, float f2, int i5) {
                int i6;
                String str;
                Interceptable interceptable2 = $ic;
                if (!(interceptable2 == null || interceptable2.invokeCommon(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, new Object[]{Integer.valueOf(i4), Float.valueOf(f2), Integer.valueOf(i5)}) == null) || f2 == 0.0f || ((e) this.f35496a).f35218a.f35221c.getAdapter() == null) {
                    return;
                }
                CharSequence pageTitle = ((e) this.f35496a).f35218a.f35221c.getAdapter().getPageTitle(i4);
                TrendInfo trendInfo = new TrendInfo();
                try {
                    trendInfo.parseJson(new JSONObject(pageTitle.toString()));
                } catch (Exception e2) {
                    e2.printStackTrace();
                }
                TrendInfo trendInfo2 = new TrendInfo();
                boolean z = true;
                if (((e) this.f35496a).f35218a.f35221c.k()) {
                    try {
                        trendInfo2.parseJson(new JSONObject(((e) this.f35496a).f35218a.f35221c.getAdapter().getPageTitle(i4 + 1).toString()));
                    } catch (Exception e3) {
                        e3.printStackTrace();
                    }
                }
                String str2 = trendInfo.name;
                if (!((str2 == null || (str = trendInfo2.name) == null || str2.equals(str)) ? false : false) || i6 == 0) {
                    this.f35496a.f35486c.setAlpha(1.0f);
                    this.f35496a.f35488e.setAlpha(1.0f);
                    return;
                }
                float abs = Math.abs(f2 - 0.5f) * 2.0f;
                if (abs <= this.f35496a.f35486c.getAlpha() || abs == 1.0f) {
                    this.f35496a.f35486c.setAlpha(abs);
                    this.f35496a.f35488e.setAlpha(abs);
                }
            }

            @Override // androidx.viewpager.widget.ViewPager.OnPageChangeListener
            public void onPageSelected(int i4) {
                Interceptable interceptable2 = $ic;
                if (!(interceptable2 == null || interceptable2.invokeI(Constants.METHOD_SEND_USER_MSG, this, i4) == null) || ((e) this.f35496a).f35218a.f35221c.getAdapter() == null) {
                    return;
                }
                CharSequence pageTitle = ((e) this.f35496a).f35218a.f35221c.getAdapter().getPageTitle(i4);
                if (TextUtils.isEmpty(pageTitle)) {
                    return;
                }
                TrendInfo trendInfo = new TrendInfo();
                try {
                    trendInfo.parseJson(new JSONObject(pageTitle.toString()));
                } catch (Exception e2) {
                    e2.printStackTrace();
                }
                CharSequence text = this.f35496a.f35486c.getText();
                if (TextUtils.isEmpty(trendInfo.name) || TextUtils.isEmpty(text) || text.equals(trendInfo.name)) {
                    this.f35496a.a(trendInfo);
                    this.f35496a.e();
                    return;
                }
                ((e) this.f35496a).f35218a.f35227i = trendInfo;
                this.f35496a.a(trendInfo);
                this.f35496a.f35486c.setVisibility(8);
                this.f35496a.f35488e.setVisibility(8);
                this.f35496a.f35486c.postDelayed(this.f35496a.f35485b, IMLikeRequest.TIME_INTERVAL);
            }
        };
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(@NonNull TrendInfo trendInfo) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(65539, this, trendInfo) == null) {
            this.f35486c.setText(trendInfo.name);
            this.f35488e.setText(String.format(m().getString(R.string.ksad_trend_title_info_format), Integer.valueOf(trendInfo.rank), ag.b(trendInfo.viewCount)));
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void e() {
        h hVar;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(65545, this) == null) || (hVar = ((e) this).f35218a.f35224f) == null || hVar.l || this.f35491h) {
            return;
        }
        this.f35486c.setVisibility(0);
        this.f35488e.setVisibility(0);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void f() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(65547, this) == null) {
            this.f35486c.setVisibility(8);
            this.f35488e.setVisibility(8);
        }
    }

    @Override // com.kwad.sdk.contentalliance.home.e, com.kwad.sdk.mvp.Presenter
    public void a() {
        ViewGroup viewGroup;
        int i2;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
            super.a();
            i iVar = ((e) this).f35218a.f35220b;
            this.f35490g = iVar;
            iVar.a(this.j);
            ((e) this).f35218a.f35221c.a(this.k);
            a(((e) this).f35218a.f35227i);
            com.kwad.sdk.core.d.a.a("PhotoTrendFeedTitlePresenter", "mCallerContext.mTrendListData size=" + ((e) this).f35218a.f35226h.size());
            TrendInfo trendInfo = ((e) this).f35218a.f35227i;
            if (trendInfo != null) {
                com.kwad.sdk.core.d.a.a("PhotoTrendFeedTitlePresenter", "trendInfo" + trendInfo.toJson());
                a(trendInfo);
                this.f35486c.setOnClickListener(new View.OnClickListener(this) { // from class: com.kwad.sdk.contentalliance.trends.a.b.a.5
                    public static /* synthetic */ Interceptable $ic;
                    public transient /* synthetic */ FieldHolder $fh;

                    /* renamed from: a  reason: collision with root package name */
                    public final /* synthetic */ a f35497a;

                    {
                        Interceptable interceptable2 = $ic;
                        if (interceptable2 != null) {
                            InitContext newInitContext = TitanRuntime.newInitContext();
                            newInitContext.initArgs = r2;
                            Object[] objArr = {this};
                            interceptable2.invokeUnInit(65536, newInitContext);
                            int i3 = newInitContext.flag;
                            if ((i3 & 1) != 0) {
                                int i4 = i3 & 2;
                                newInitContext.thisArg = this;
                                interceptable2.invokeInitBody(65536, newInitContext);
                                return;
                            }
                        }
                        this.f35497a = this;
                    }

                    @Override // android.view.View.OnClickListener
                    public void onClick(View view) {
                        Interceptable interceptable2 = $ic;
                        if (interceptable2 == null || interceptable2.invokeL(1048576, this, view) == null) {
                        }
                    }
                });
                viewGroup = this.f35489f;
                i2 = 0;
            } else {
                viewGroup = this.f35489f;
                i2 = 8;
            }
            viewGroup.setVisibility(i2);
            ((e) this).f35218a.o.add(this.f35492i);
            this.f35487d.setOnClickListener(new View.OnClickListener(this) { // from class: com.kwad.sdk.contentalliance.trends.a.b.a.6
                public static /* synthetic */ Interceptable $ic;
                public transient /* synthetic */ FieldHolder $fh;

                /* renamed from: a  reason: collision with root package name */
                public final /* synthetic */ a f35498a;

                {
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 != null) {
                        InitContext newInitContext = TitanRuntime.newInitContext();
                        newInitContext.initArgs = r2;
                        Object[] objArr = {this};
                        interceptable2.invokeUnInit(65536, newInitContext);
                        int i3 = newInitContext.flag;
                        if ((i3 & 1) != 0) {
                            int i4 = i3 & 2;
                            newInitContext.thisArg = this;
                            interceptable2.invokeInitBody(65536, newInitContext);
                            return;
                        }
                    }
                    this.f35498a = this;
                }

                @Override // android.view.View.OnClickListener
                public void onClick(View view) {
                    Activity activity;
                    Interceptable interceptable2 = $ic;
                    if (!(interceptable2 == null || interceptable2.invokeL(1048576, this, view) == null) || (activity = ((e) this.f35498a).f35218a.f35219a.getActivity()) == null) {
                        return;
                    }
                    activity.onBackPressed();
                }
            });
        }
    }

    @Override // com.kwad.sdk.mvp.Presenter
    public void b_() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this) == null) {
            super.b_();
            ((e) this).f35218a.f35221c.b(this.k);
            ((e) this).f35218a.o.remove(this.f35492i);
            this.f35490g.b(this.j);
            this.f35487d.setOnClickListener(null);
            this.f35486c.removeCallbacks(this.f35485b);
        }
    }

    @Override // com.kwad.sdk.mvp.Presenter
    public void c() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this) == null) {
            super.c();
            this.f35489f = (ViewGroup) b(R.id.ksad_trends_feed_title_info);
            this.f35488e = (TextView) b(R.id.ksad_trends_feed_info_text);
            this.f35486c = (TextView) b(R.id.ksad_trends_feed_title);
            this.f35487d = (ImageView) b(R.id.ksad_trends_feed_back);
        }
    }
}
