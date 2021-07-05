package com.kwad.sdk.contentalliance.trends.a.b;

import android.view.KeyEvent;
import android.view.View;
import androidx.annotation.NonNull;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.mobads.container.util.AdIconUtil;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import com.kwad.sdk.R;
import com.kwad.sdk.contentalliance.home.e;
import com.kwad.sdk.contentalliance.trends.a.b.c;
import com.kwad.sdk.contentalliance.trends.view.TrendsPanelLayout;
import com.kwad.sdk.core.response.model.TrendInfo;
import java.util.List;
/* loaded from: classes7.dex */
public class b extends e {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    /* renamed from: b  reason: collision with root package name */
    public View.OnKeyListener f35499b;

    /* renamed from: c  reason: collision with root package name */
    public TrendsPanelLayout f35500c;

    /* renamed from: d  reason: collision with root package name */
    public com.kwad.sdk.contentalliance.trends.a f35501d;

    /* renamed from: e  reason: collision with root package name */
    public TrendsPanelLayout.a f35502e;

    /* renamed from: f  reason: collision with root package name */
    public TrendsPanelLayout.b f35503f;

    /* renamed from: g  reason: collision with root package name */
    public c.a f35504g;

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
        this.f35502e = new TrendsPanelLayout.a(this) { // from class: com.kwad.sdk.contentalliance.trends.a.b.b.1
            public static /* synthetic */ Interceptable $ic;
            public transient /* synthetic */ FieldHolder $fh;

            /* renamed from: a  reason: collision with root package name */
            public final /* synthetic */ b f35505a;

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
                this.f35505a = this;
            }

            @Override // com.kwad.sdk.contentalliance.trends.view.TrendsPanelLayout.a
            public void a(int i4) {
                Interceptable interceptable2 = $ic;
                if (interceptable2 == null || interceptable2.invokeI(1048576, this, i4) == null) {
                    com.kwad.sdk.core.report.e.a(((e) this.f35505a).f35218a.f35223e, i4);
                    this.f35505a.e();
                }
            }
        };
        this.f35503f = new TrendsPanelLayout.b(this) { // from class: com.kwad.sdk.contentalliance.trends.a.b.b.2
            public static /* synthetic */ Interceptable $ic;
            public transient /* synthetic */ FieldHolder $fh;

            /* renamed from: a  reason: collision with root package name */
            public final /* synthetic */ b f35506a;

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
                this.f35506a = this;
            }

            @Override // com.kwad.sdk.contentalliance.trends.view.TrendsPanelLayout.b
            public void a(View view, TrendInfo trendInfo, int i4) {
                Interceptable interceptable2 = $ic;
                if (!(interceptable2 == null || interceptable2.invokeLLI(1048576, this, view, trendInfo, i4) == null) || trendInfo == null) {
                    return;
                }
                com.kwad.sdk.core.d.a.a("PhotoTrendsPanelPresenter", "onItemClick position=" + i4 + " trendInfo=" + trendInfo.toJson());
                ((e) this.f35506a).f35218a.f35227i = trendInfo;
                this.f35506a.a(view, trendInfo, i4);
                com.kwad.sdk.core.report.e.d(((e) this.f35506a).f35218a.f35223e, trendInfo.trendId, trendInfo.name);
                if (this.f35506a.f35501d != null) {
                    this.f35506a.f35501d.b(trendInfo);
                }
            }
        };
        this.f35504g = new c.a(this) { // from class: com.kwad.sdk.contentalliance.trends.a.b.b.3
            public static /* synthetic */ Interceptable $ic;
            public transient /* synthetic */ FieldHolder $fh;

            /* renamed from: a  reason: collision with root package name */
            public final /* synthetic */ b f35507a;

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
                this.f35507a = this;
            }

            @Override // com.kwad.sdk.contentalliance.trends.a.b.c.a
            public void a(@NonNull List<TrendInfo> list) {
                Interceptable interceptable2 = $ic;
                if (interceptable2 == null || interceptable2.invokeL(1048576, this, list) == null) {
                    this.f35507a.a(list);
                }
            }
        };
        this.f35499b = new View.OnKeyListener(this) { // from class: com.kwad.sdk.contentalliance.trends.a.b.b.4
            public static /* synthetic */ Interceptable $ic;
            public transient /* synthetic */ FieldHolder $fh;

            /* renamed from: a  reason: collision with root package name */
            public final /* synthetic */ b f35508a;

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
                this.f35508a = this;
            }

            @Override // android.view.View.OnKeyListener
            public boolean onKey(View view, int i4, KeyEvent keyEvent) {
                InterceptResult invokeLIL;
                Interceptable interceptable2 = $ic;
                if (interceptable2 == null || (invokeLIL = interceptable2.invokeLIL(1048576, this, view, i4, keyEvent)) == null) {
                    if (i4 == 4 && keyEvent.getAction() == 1) {
                        this.f35508a.f35500c.a(5);
                        return true;
                    }
                    return false;
                }
                return invokeLIL.booleanValue;
            }
        };
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(View view, TrendInfo trendInfo, int i2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLLI(65538, this, view, trendInfo, i2) == null) {
            for (com.kwad.sdk.contentalliance.trends.view.c cVar : ((e) this).f35218a.o) {
                cVar.a(view, trendInfo, i2);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(@NonNull List<TrendInfo> list) {
        long j;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(AdIconUtil.AD_TEXT_ID, this, list) == null) {
            TrendInfo trendInfo = ((e) this).f35218a.f35227i;
            if (trendInfo != null) {
                j = trendInfo.trendId;
                String str = trendInfo.name;
            } else {
                j = 0;
            }
            this.f35500c.a(new com.kwad.sdk.contentalliance.trends.view.b(list, j, ((e) this).f35218a.f35223e));
            this.f35500c.a();
            com.kwad.sdk.core.report.e.a(((e) this).f35218a.f35223e);
            this.f35500c.setFocusableInTouchMode(true);
            this.f35500c.requestFocus();
            this.f35500c.setOnKeyListener(this.f35499b);
            ((e) this).f35218a.f35224f.l = true;
            f();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void e() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(65546, this) == null) {
            this.f35500c.setFocusableInTouchMode(false);
            this.f35500c.setOnKeyListener(null);
            ((e) this).f35218a.f35224f.l = false;
            g();
        }
    }

    private void f() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(65548, this) == null) {
            for (com.kwad.sdk.contentalliance.trends.view.c cVar : ((e) this).f35218a.o) {
                cVar.a();
            }
        }
    }

    private void g() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(65549, this) == null) {
            for (com.kwad.sdk.contentalliance.trends.view.c cVar : ((e) this).f35218a.o) {
                cVar.b();
            }
        }
    }

    @Override // com.kwad.sdk.contentalliance.home.e, com.kwad.sdk.mvp.Presenter
    public void a() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
            super.a();
            com.kwad.sdk.contentalliance.home.a.b c2 = ((e) this).f35218a.f35220b.c();
            if (c2 instanceof com.kwad.sdk.contentalliance.trends.a) {
                this.f35501d = (com.kwad.sdk.contentalliance.trends.a) c2;
            }
            ((e) this).f35218a.n.add(this.f35504g);
            this.f35500c.setItemClickListener(this.f35503f);
            this.f35500c.setCloseListener(this.f35502e);
        }
    }

    @Override // com.kwad.sdk.mvp.Presenter
    public void b_() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this) == null) {
            super.b_();
            e();
            this.f35500c.setCloseListener(null);
            this.f35500c.setItemClickListener(null);
            this.f35500c.c();
        }
    }

    @Override // com.kwad.sdk.mvp.Presenter
    public void c() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this) == null) {
            super.c();
            this.f35500c = (TrendsPanelLayout) b(R.id.ksad_trend_list_panel);
        }
    }
}
