package com.kwad.sdk.contentalliance.trends.a.b;

import android.view.View;
import android.widget.RelativeLayout;
import androidx.annotation.NonNull;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import com.kwad.sdk.R;
import com.kwad.sdk.contentalliance.detail.photo.comment.g;
import com.kwad.sdk.contentalliance.home.a.d;
import com.kwad.sdk.contentalliance.home.a.i;
import com.kwad.sdk.contentalliance.home.b.f;
import com.kwad.sdk.contentalliance.home.e;
import com.kwad.sdk.contentalliance.trends.view.TrendsRollingTextContainer;
import com.kwad.sdk.core.g.o;
import com.kwad.sdk.core.response.model.TrendInfo;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.concurrent.atomic.AtomicBoolean;
/* loaded from: classes7.dex */
public class c extends e {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    /* renamed from: b  reason: collision with root package name */
    public com.kwad.sdk.core.i.a f35509b;

    /* renamed from: c  reason: collision with root package name */
    public RelativeLayout f35510c;

    /* renamed from: d  reason: collision with root package name */
    public TrendsRollingTextContainer f35511d;

    /* renamed from: e  reason: collision with root package name */
    public AtomicBoolean f35512e;

    /* renamed from: f  reason: collision with root package name */
    public List<TrendInfo> f35513f;

    /* renamed from: g  reason: collision with root package name */
    public long f35514g;

    /* renamed from: h  reason: collision with root package name */
    public String f35515h;

    /* renamed from: i  reason: collision with root package name */
    public i f35516i;
    public boolean j;
    public com.kwad.sdk.core.i.c k;
    public f.a l;
    public g m;
    public List<a> n;
    public com.kwad.sdk.contentalliance.trends.view.c o;
    public d p;

    /* loaded from: classes7.dex */
    public interface a {
        void a(@NonNull List<TrendInfo> list);
    }

    public c() {
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
        this.f35512e = new AtomicBoolean(false);
        this.f35513f = new ArrayList();
        this.f35514g = 0L;
        this.f35515h = "";
        this.k = new com.kwad.sdk.core.i.d(this) { // from class: com.kwad.sdk.contentalliance.trends.a.b.c.1
            public static /* synthetic */ Interceptable $ic;
            public transient /* synthetic */ FieldHolder $fh;

            /* renamed from: a  reason: collision with root package name */
            public final /* synthetic */ c f35517a;

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
                this.f35517a = this;
            }

            @Override // com.kwad.sdk.core.i.d, com.kwad.sdk.core.i.c
            public void c_() {
                Interceptable interceptable2 = $ic;
                if (!(interceptable2 == null || interceptable2.invokeV(1048576, this) == null) || this.f35517a.f35512e.getAndSet(true)) {
                    return;
                }
                com.kwad.sdk.core.report.e.a(((e) this.f35517a).f35218a.f35223e, this.f35517a.f35514g, this.f35517a.f35515h);
            }
        };
        this.l = new f.a(this) { // from class: com.kwad.sdk.contentalliance.trends.a.b.c.2
            public static /* synthetic */ Interceptable $ic;
            public transient /* synthetic */ FieldHolder $fh;

            /* renamed from: a  reason: collision with root package name */
            public final /* synthetic */ c f35518a;

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
                this.f35518a = this;
            }

            @Override // com.kwad.sdk.contentalliance.home.b.f.a
            public void a() {
                Interceptable interceptable2 = $ic;
                if (interceptable2 == null || interceptable2.invokeV(1048576, this) == null) {
                    if (this.f35518a.f35513f.isEmpty()) {
                        o.a(true, new o.d(this) { // from class: com.kwad.sdk.contentalliance.trends.a.b.c.2.1
                            public static /* synthetic */ Interceptable $ic;
                            public transient /* synthetic */ FieldHolder $fh;

                            /* renamed from: a  reason: collision with root package name */
                            public final /* synthetic */ AnonymousClass2 f35519a;

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
                                this.f35519a = this;
                            }

                            @Override // com.kwad.sdk.core.g.o.d
                            public void a(int i4, String str) {
                                Interceptable interceptable3 = $ic;
                                if (interceptable3 == null || interceptable3.invokeIL(1048576, this, i4, str) == null) {
                                }
                            }

                            @Override // com.kwad.sdk.core.g.o.d
                            public void a(@NonNull List<TrendInfo> list) {
                                Interceptable interceptable3 = $ic;
                                if (interceptable3 == null || interceptable3.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, list) == null) {
                                    Collections.sort(list, TrendInfo.mTrendsComparator);
                                    this.f35519a.f35518a.f35513f.addAll(list);
                                    ((e) this.f35519a.f35518a).f35218a.f35226h = this.f35519a.f35518a.f35513f;
                                    this.f35519a.f35518a.g();
                                }
                            }
                        });
                    } else {
                        this.f35518a.f35516i.a(0);
                    }
                }
            }
        };
        this.m = new g(this) { // from class: com.kwad.sdk.contentalliance.trends.a.b.c.3
            public static /* synthetic */ Interceptable $ic;
            public transient /* synthetic */ FieldHolder $fh;

            /* renamed from: a  reason: collision with root package name */
            public final /* synthetic */ c f35520a;

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
                this.f35520a = this;
            }

            @Override // com.kwad.sdk.contentalliance.detail.photo.comment.g
            public void a() {
                Interceptable interceptable2 = $ic;
                if (interceptable2 == null || interceptable2.invokeV(1048576, this) == null) {
                    this.f35520a.f35511d.b();
                    this.f35520a.f35510c.setVisibility(8);
                }
            }

            @Override // com.kwad.sdk.contentalliance.detail.photo.comment.g
            public void b() {
                Interceptable interceptable2 = $ic;
                if (interceptable2 == null || interceptable2.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this) == null) {
                    this.f35520a.e();
                }
            }
        };
        this.o = new com.kwad.sdk.contentalliance.trends.view.d(this) { // from class: com.kwad.sdk.contentalliance.trends.a.b.c.4
            public static /* synthetic */ Interceptable $ic;
            public transient /* synthetic */ FieldHolder $fh;

            /* renamed from: a  reason: collision with root package name */
            public final /* synthetic */ c f35521a;

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
                this.f35521a = this;
            }

            @Override // com.kwad.sdk.contentalliance.trends.view.d, com.kwad.sdk.contentalliance.trends.view.c
            public void a() {
                Interceptable interceptable2 = $ic;
                if (interceptable2 == null || interceptable2.invokeV(1048576, this) == null) {
                    this.f35521a.f();
                }
            }

            @Override // com.kwad.sdk.contentalliance.trends.view.d, com.kwad.sdk.contentalliance.trends.view.c
            public void a(View view, TrendInfo trendInfo, int i4) {
                Interceptable interceptable2 = $ic;
                if (interceptable2 == null || interceptable2.invokeLLI(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, view, trendInfo, i4) == null) {
                    this.f35521a.f();
                }
            }

            @Override // com.kwad.sdk.contentalliance.trends.view.d, com.kwad.sdk.contentalliance.trends.view.c
            public void b() {
                Interceptable interceptable2 = $ic;
                if (!(interceptable2 == null || interceptable2.invokeV(Constants.METHOD_SEND_USER_MSG, this) == null) || this.f35521a.j) {
                    return;
                }
                this.f35521a.e();
            }
        };
        this.p = new d(this) { // from class: com.kwad.sdk.contentalliance.trends.a.b.c.5
            public static /* synthetic */ Interceptable $ic;
            public transient /* synthetic */ FieldHolder $fh;

            /* renamed from: a  reason: collision with root package name */
            public final /* synthetic */ c f35522a;

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
                this.f35522a = this;
            }

            @Override // com.kwad.sdk.contentalliance.home.a.d
            public void a(int i4, String str) {
                Interceptable interceptable2 = $ic;
                if (interceptable2 == null || interceptable2.invokeIL(1048576, this, i4, str) == null) {
                    this.f35522a.e();
                    this.f35522a.j = false;
                }
            }

            @Override // com.kwad.sdk.contentalliance.home.a.d
            public void a(boolean z, int i4) {
                Interceptable interceptable2 = $ic;
                if (interceptable2 == null || interceptable2.invokeCommon(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, new Object[]{Boolean.valueOf(z), Integer.valueOf(i4)}) == null) {
                    this.f35522a.e();
                    this.f35522a.j = false;
                }
            }

            @Override // com.kwad.sdk.contentalliance.home.a.d
            public void a(boolean z, boolean z2, int i4, int i5) {
                Interceptable interceptable2 = $ic;
                if (interceptable2 == null || interceptable2.invokeCommon(Constants.METHOD_SEND_USER_MSG, this, new Object[]{Boolean.valueOf(z), Boolean.valueOf(z2), Integer.valueOf(i4), Integer.valueOf(i5)}) == null) {
                    this.f35522a.j = true;
                }
            }
        };
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void e() {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(65543, this) == null) || this.f35513f.isEmpty()) {
            return;
        }
        this.f35511d.c();
        this.f35510c.setVisibility(0);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void f() {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(65545, this) == null) || this.f35513f.isEmpty()) {
            return;
        }
        this.f35511d.b();
        this.f35510c.setVisibility(4);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void g() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(65546, this) == null) {
            List<TrendInfo> list = this.f35513f;
            if (list == null || list.isEmpty()) {
                f();
                return;
            }
            this.f35511d.a(this.f35513f);
            this.f35510c.setOnClickListener(new View.OnClickListener(this) { // from class: com.kwad.sdk.contentalliance.trends.a.b.c.6
                public static /* synthetic */ Interceptable $ic;
                public transient /* synthetic */ FieldHolder $fh;

                /* renamed from: a  reason: collision with root package name */
                public final /* synthetic */ c f35523a;

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
                    this.f35523a = this;
                }

                @Override // android.view.View.OnClickListener
                public void onClick(View view) {
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 == null || interceptable2.invokeL(1048576, this, view) == null) {
                        this.f35523a.f35510c.setVisibility(8);
                        com.kwad.sdk.core.report.e.b(((e) this.f35523a).f35218a.f35223e, this.f35523a.f35514g, this.f35523a.f35515h);
                        this.f35523a.h();
                    }
                }
            });
            e();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void h() {
        List<a> list;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(65549, this) == null) || (list = this.n) == null) {
            return;
        }
        for (a aVar : list) {
            aVar.a(this.f35513f);
        }
    }

    @Override // com.kwad.sdk.contentalliance.home.e, com.kwad.sdk.mvp.Presenter
    public void a() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
            super.a();
            i iVar = ((e) this).f35218a.f35220b;
            this.f35516i = iVar;
            iVar.a(this.p);
            com.kwad.sdk.core.i.a aVar = ((e) this).f35218a.f35224f.f35240a;
            this.f35509b = aVar;
            aVar.a(this.k);
            TrendInfo trendInfo = ((e) this).f35218a.f35227i;
            if (trendInfo != null) {
                this.f35514g = trendInfo.trendId;
                this.f35515h = trendInfo.name;
            }
            com.kwad.sdk.contentalliance.home.f fVar = ((e) this).f35218a;
            this.f35513f = fVar.f35226h;
            this.n = fVar.n;
            g();
            ((e) this).f35218a.o.add(this.o);
            ((e) this).f35218a.f35224f.f35245f.add(this.m);
            ((e) this).f35218a.p.add(this.l);
        }
    }

    @Override // com.kwad.sdk.mvp.Presenter
    public void b_() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this) == null) {
            super.b_();
            ((e) this).f35218a.f35224f.f35245f.remove(this.m);
            ((e) this).f35218a.o.remove(this.o);
            this.f35509b.b(this.k);
            this.f35511d.a();
            this.f35516i.b(this.p);
            ((e) this).f35218a.p.remove(this.l);
        }
    }

    @Override // com.kwad.sdk.mvp.Presenter
    public void c() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this) == null) {
            super.c();
            this.f35510c = (RelativeLayout) b(R.id.ksad_trends_rolling_container);
            this.f35511d = (TrendsRollingTextContainer) b(R.id.ksad_trends_rolling_trend_name_layout);
        }
    }
}
