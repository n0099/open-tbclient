package com.kwad.sdk.contentalliance.detail.photo.comment;

import android.content.Context;
import android.os.SystemClock;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewParent;
import android.widget.ImageButton;
import android.widget.LinearLayout;
import android.widget.TextView;
import androidx.annotation.NonNull;
import androidx.core.view.InputDeviceCompat;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import com.kwad.sdk.R;
import com.kwad.sdk.contentalliance.detail.ad.presenter.comment.CommentAdItemView;
import com.kwad.sdk.contentalliance.widget.KSHalfPageLoadingView;
import com.kwad.sdk.contentalliance.widget.KSPageLoadingView;
import com.kwad.sdk.core.g.g;
import com.kwad.sdk.core.response.model.AdTemplate;
import com.kwad.sdk.core.response.model.CommentResponse;
import com.kwad.sdk.support.KsRecyclerView;
import com.kwad.sdk.utils.ao;
import com.kwad.sdk.utils.q;
import java.util.ArrayList;
import java.util.List;
/* loaded from: classes7.dex */
public class CommentListPanel extends LinearLayout {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    /* renamed from: a  reason: collision with root package name */
    public RecyclerView.OnScrollListener f34654a;

    /* renamed from: b  reason: collision with root package name */
    public e f34655b;

    /* renamed from: c  reason: collision with root package name */
    public KsRecyclerView f34656c;

    /* renamed from: d  reason: collision with root package name */
    public d f34657d;

    /* renamed from: e  reason: collision with root package name */
    public com.kwad.sdk.lib.widget.recycler.d f34658e;

    /* renamed from: f  reason: collision with root package name */
    public View f34659f;

    /* renamed from: g  reason: collision with root package name */
    public View f34660g;

    /* renamed from: h  reason: collision with root package name */
    public KSHalfPageLoadingView f34661h;

    /* renamed from: i  reason: collision with root package name */
    public AdTemplate f34662i;
    public List<b> j;
    public List<c> k;
    public List<f> l;
    public boolean m;
    public CommentResponse n;
    public a o;
    public View.OnClickListener p;
    public View.OnClickListener q;
    public KSPageLoadingView.a r;

    /* loaded from: classes7.dex */
    public static class a {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: a  reason: collision with root package name */
        public long f34668a;

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
            this.f34668a = -1L;
        }

        public void a() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                this.f34668a = SystemClock.elapsedRealtime();
            }
        }

        public long b() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this)) == null) {
                long elapsedRealtime = this.f34668a > 0 ? SystemClock.elapsedRealtime() - this.f34668a : 0L;
                this.f34668a = -1L;
                return elapsedRealtime;
            }
            return invokeV.longValue;
        }
    }

    /* loaded from: classes7.dex */
    public interface b {
        void a();
    }

    /* loaded from: classes7.dex */
    public interface c {
        void a(boolean z);
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public CommentListPanel(Context context) {
        super(context);
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {context};
            interceptable.invokeUnInit(65536, newInitContext);
            int i2 = newInitContext.flag;
            if ((i2 & 1) != 0) {
                int i3 = i2 & 2;
                super((Context) newInitContext.callArgs[0]);
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
        this.f34655b = null;
        this.j = new ArrayList();
        this.k = new ArrayList();
        this.l = new ArrayList();
        this.o = new a();
        this.p = new View.OnClickListener(this) { // from class: com.kwad.sdk.contentalliance.detail.photo.comment.CommentListPanel.1
            public static /* synthetic */ Interceptable $ic;
            public transient /* synthetic */ FieldHolder $fh;

            /* renamed from: a  reason: collision with root package name */
            public final /* synthetic */ CommentListPanel f34663a;

            {
                Interceptable interceptable2 = $ic;
                if (interceptable2 != null) {
                    InitContext newInitContext2 = TitanRuntime.newInitContext();
                    newInitContext2.initArgs = r2;
                    Object[] objArr2 = {this};
                    interceptable2.invokeUnInit(65536, newInitContext2);
                    int i4 = newInitContext2.flag;
                    if ((i4 & 1) != 0) {
                        int i5 = i4 & 2;
                        newInitContext2.thisArg = this;
                        interceptable2.invokeInitBody(65536, newInitContext2);
                        return;
                    }
                }
                this.f34663a = this;
            }

            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                Interceptable interceptable2 = $ic;
                if (interceptable2 == null || interceptable2.invokeL(1048576, this, view) == null) {
                    this.f34663a.h();
                }
            }
        };
        this.q = new View.OnClickListener(this) { // from class: com.kwad.sdk.contentalliance.detail.photo.comment.CommentListPanel.2
            public static /* synthetic */ Interceptable $ic;
            public transient /* synthetic */ FieldHolder $fh;

            /* renamed from: a  reason: collision with root package name */
            public final /* synthetic */ CommentListPanel f34664a;

            {
                Interceptable interceptable2 = $ic;
                if (interceptable2 != null) {
                    InitContext newInitContext2 = TitanRuntime.newInitContext();
                    newInitContext2.initArgs = r2;
                    Object[] objArr2 = {this};
                    interceptable2.invokeUnInit(65536, newInitContext2);
                    int i4 = newInitContext2.flag;
                    if ((i4 & 1) != 0) {
                        int i5 = i4 & 2;
                        newInitContext2.thisArg = this;
                        interceptable2.invokeInitBody(65536, newInitContext2);
                        return;
                    }
                }
                this.f34664a = this;
            }

            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                Interceptable interceptable2 = $ic;
                if (interceptable2 == null || interceptable2.invokeL(1048576, this, view) == null) {
                }
            }
        };
        this.r = new KSPageLoadingView.a(this) { // from class: com.kwad.sdk.contentalliance.detail.photo.comment.CommentListPanel.3
            public static /* synthetic */ Interceptable $ic;
            public transient /* synthetic */ FieldHolder $fh;

            /* renamed from: a  reason: collision with root package name */
            public final /* synthetic */ CommentListPanel f34665a;

            {
                Interceptable interceptable2 = $ic;
                if (interceptable2 != null) {
                    InitContext newInitContext2 = TitanRuntime.newInitContext();
                    newInitContext2.initArgs = r2;
                    Object[] objArr2 = {this};
                    interceptable2.invokeUnInit(65536, newInitContext2);
                    int i4 = newInitContext2.flag;
                    if ((i4 & 1) != 0) {
                        int i5 = i4 & 2;
                        newInitContext2.thisArg = this;
                        interceptable2.invokeInitBody(65536, newInitContext2);
                        return;
                    }
                }
                this.f34665a = this;
            }

            @Override // com.kwad.sdk.contentalliance.widget.KSPageLoadingView.a
            public void a() {
                Interceptable interceptable2 = $ic;
                if (interceptable2 == null || interceptable2.invokeV(1048576, this) == null) {
                    this.f34665a.a();
                }
            }
        };
        this.f34654a = new RecyclerView.OnScrollListener(this) { // from class: com.kwad.sdk.contentalliance.detail.photo.comment.CommentListPanel.4
            public static /* synthetic */ Interceptable $ic;
            public transient /* synthetic */ FieldHolder $fh;

            /* renamed from: a  reason: collision with root package name */
            public final /* synthetic */ CommentListPanel f34666a;

            {
                Interceptable interceptable2 = $ic;
                if (interceptable2 != null) {
                    InitContext newInitContext2 = TitanRuntime.newInitContext();
                    newInitContext2.initArgs = r2;
                    Object[] objArr2 = {this};
                    interceptable2.invokeUnInit(65536, newInitContext2);
                    int i4 = newInitContext2.flag;
                    if ((i4 & 1) != 0) {
                        int i5 = i4 & 2;
                        newInitContext2.thisArg = this;
                        interceptable2.invokeInitBody(65536, newInitContext2);
                        return;
                    }
                }
                this.f34666a = this;
            }

            @Override // androidx.recyclerview.widget.RecyclerView.OnScrollListener
            public void onScrolled(RecyclerView recyclerView, int i4, int i5) {
                Interceptable interceptable2 = $ic;
                if (interceptable2 == null || interceptable2.invokeLII(1048576, this, recyclerView, i4, i5) == null) {
                    super.onScrolled(recyclerView, i4, i5);
                    int a2 = com.kwad.sdk.lib.widget.recycler.e.a(recyclerView);
                    for (c cVar : this.f34666a.k) {
                        cVar.a(a2 > 0);
                    }
                }
            }
        };
        e();
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public CommentListPanel(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {context, attributeSet};
            interceptable.invokeUnInit(65537, newInitContext);
            int i2 = newInitContext.flag;
            if ((i2 & 1) != 0) {
                int i3 = i2 & 2;
                Object[] objArr2 = newInitContext.callArgs;
                super((Context) objArr2[0], (AttributeSet) objArr2[1]);
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65537, newInitContext);
                return;
            }
        }
        this.f34655b = null;
        this.j = new ArrayList();
        this.k = new ArrayList();
        this.l = new ArrayList();
        this.o = new a();
        this.p = new View.OnClickListener(this) { // from class: com.kwad.sdk.contentalliance.detail.photo.comment.CommentListPanel.1
            public static /* synthetic */ Interceptable $ic;
            public transient /* synthetic */ FieldHolder $fh;

            /* renamed from: a  reason: collision with root package name */
            public final /* synthetic */ CommentListPanel f34663a;

            {
                Interceptable interceptable2 = $ic;
                if (interceptable2 != null) {
                    InitContext newInitContext2 = TitanRuntime.newInitContext();
                    newInitContext2.initArgs = objArr2;
                    Object[] objArr22 = {this};
                    interceptable2.invokeUnInit(65536, newInitContext2);
                    int i4 = newInitContext2.flag;
                    if ((i4 & 1) != 0) {
                        int i5 = i4 & 2;
                        newInitContext2.thisArg = this;
                        interceptable2.invokeInitBody(65536, newInitContext2);
                        return;
                    }
                }
                this.f34663a = this;
            }

            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                Interceptable interceptable2 = $ic;
                if (interceptable2 == null || interceptable2.invokeL(1048576, this, view) == null) {
                    this.f34663a.h();
                }
            }
        };
        this.q = new View.OnClickListener(this) { // from class: com.kwad.sdk.contentalliance.detail.photo.comment.CommentListPanel.2
            public static /* synthetic */ Interceptable $ic;
            public transient /* synthetic */ FieldHolder $fh;

            /* renamed from: a  reason: collision with root package name */
            public final /* synthetic */ CommentListPanel f34664a;

            {
                Interceptable interceptable2 = $ic;
                if (interceptable2 != null) {
                    InitContext newInitContext2 = TitanRuntime.newInitContext();
                    newInitContext2.initArgs = objArr2;
                    Object[] objArr22 = {this};
                    interceptable2.invokeUnInit(65536, newInitContext2);
                    int i4 = newInitContext2.flag;
                    if ((i4 & 1) != 0) {
                        int i5 = i4 & 2;
                        newInitContext2.thisArg = this;
                        interceptable2.invokeInitBody(65536, newInitContext2);
                        return;
                    }
                }
                this.f34664a = this;
            }

            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                Interceptable interceptable2 = $ic;
                if (interceptable2 == null || interceptable2.invokeL(1048576, this, view) == null) {
                }
            }
        };
        this.r = new KSPageLoadingView.a(this) { // from class: com.kwad.sdk.contentalliance.detail.photo.comment.CommentListPanel.3
            public static /* synthetic */ Interceptable $ic;
            public transient /* synthetic */ FieldHolder $fh;

            /* renamed from: a  reason: collision with root package name */
            public final /* synthetic */ CommentListPanel f34665a;

            {
                Interceptable interceptable2 = $ic;
                if (interceptable2 != null) {
                    InitContext newInitContext2 = TitanRuntime.newInitContext();
                    newInitContext2.initArgs = objArr2;
                    Object[] objArr22 = {this};
                    interceptable2.invokeUnInit(65536, newInitContext2);
                    int i4 = newInitContext2.flag;
                    if ((i4 & 1) != 0) {
                        int i5 = i4 & 2;
                        newInitContext2.thisArg = this;
                        interceptable2.invokeInitBody(65536, newInitContext2);
                        return;
                    }
                }
                this.f34665a = this;
            }

            @Override // com.kwad.sdk.contentalliance.widget.KSPageLoadingView.a
            public void a() {
                Interceptable interceptable2 = $ic;
                if (interceptable2 == null || interceptable2.invokeV(1048576, this) == null) {
                    this.f34665a.a();
                }
            }
        };
        this.f34654a = new RecyclerView.OnScrollListener(this) { // from class: com.kwad.sdk.contentalliance.detail.photo.comment.CommentListPanel.4
            public static /* synthetic */ Interceptable $ic;
            public transient /* synthetic */ FieldHolder $fh;

            /* renamed from: a  reason: collision with root package name */
            public final /* synthetic */ CommentListPanel f34666a;

            {
                Interceptable interceptable2 = $ic;
                if (interceptable2 != null) {
                    InitContext newInitContext2 = TitanRuntime.newInitContext();
                    newInitContext2.initArgs = objArr2;
                    Object[] objArr22 = {this};
                    interceptable2.invokeUnInit(65536, newInitContext2);
                    int i4 = newInitContext2.flag;
                    if ((i4 & 1) != 0) {
                        int i5 = i4 & 2;
                        newInitContext2.thisArg = this;
                        interceptable2.invokeInitBody(65536, newInitContext2);
                        return;
                    }
                }
                this.f34666a = this;
            }

            @Override // androidx.recyclerview.widget.RecyclerView.OnScrollListener
            public void onScrolled(RecyclerView recyclerView, int i4, int i5) {
                Interceptable interceptable2 = $ic;
                if (interceptable2 == null || interceptable2.invokeLII(1048576, this, recyclerView, i4, i5) == null) {
                    super.onScrolled(recyclerView, i4, i5);
                    int a2 = com.kwad.sdk.lib.widget.recycler.e.a(recyclerView);
                    for (c cVar : this.f34666a.k) {
                        cVar.a(a2 > 0);
                    }
                }
            }
        };
        e();
    }

    private void e() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(65545, this) == null) {
            ao.a((ViewGroup) this, R.layout.ksad_content_alliance_comment_list_panel_2, true);
            ((LinearLayout) findViewById(R.id.ksad_photo_comment_list_space)).setOnClickListener(this.p);
            ((ImageButton) findViewById(R.id.ksad_photo_comment_list_panel_close)).setOnClickListener(this.p);
            KsRecyclerView ksRecyclerView = (KsRecyclerView) findViewById(R.id.ksad_photo_comment_list_content);
            this.f34656c = ksRecyclerView;
            ksRecyclerView.setVisibility(8);
            KSHalfPageLoadingView kSHalfPageLoadingView = (KSHalfPageLoadingView) findViewById(R.id.ksad_comment_page_loading);
            this.f34661h = kSHalfPageLoadingView;
            kSHalfPageLoadingView.setRetryClickListener(this.r);
            this.f34661h.a();
            setOnClickListener(this.q);
        }
    }

    private void f() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(65546, this) == null) {
            if (this.f34659f == null) {
                this.f34659f = LayoutInflater.from(getContext()).inflate(R.layout.ksad_photo_comment_list_footer_2, (ViewGroup) this.f34656c, false);
            }
            TextView textView = (TextView) this.f34659f.findViewById(R.id.ksad_comment_list_footer_tip);
            if (!com.kwad.sdk.core.config.c.X()) {
                this.f34659f.setVisibility(8);
                return;
            }
            if (!this.f34658e.d(this.f34659f)) {
                this.f34658e.c(this.f34659f);
            }
            this.f34659f.setVisibility(0);
            textView.setText(q.a(getContext()));
        }
    }

    private void g() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(65547, this) == null) {
            if (this.f34660g == null) {
                this.f34660g = LayoutInflater.from(getContext()).inflate(R.layout.ksad_photo_comment_list_header, (ViewGroup) this.f34656c, false);
            }
            CommentAdItemView commentAdItemView = (CommentAdItemView) this.f34660g.findViewById(R.id.ksad_comment_list_header_ad_item);
            if (this.f34658e.e(this.f34660g)) {
                return;
            }
            commentAdItemView.a(this.f34662i, this.l);
            this.f34658e.b(this.f34660g);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void h() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(65548, this) == null) {
            for (b bVar : this.j) {
                bVar.a();
            }
        }
    }

    public void a() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
            this.f34656c.setVisibility(8);
            this.f34661h.b();
            e eVar = this.f34655b;
            if (eVar == null) {
                this.f34661h.f();
                return;
            }
            CommentResponse commentResponse = this.n;
            if (commentResponse != null) {
                a(commentResponse);
                this.f34661h.a();
            } else if (this.m) {
            } else {
                this.m = true;
                new com.kwad.sdk.core.g.g().a(eVar.b(), new g.a(this) { // from class: com.kwad.sdk.contentalliance.detail.photo.comment.CommentListPanel.5
                    public static /* synthetic */ Interceptable $ic;
                    public transient /* synthetic */ FieldHolder $fh;

                    /* renamed from: a  reason: collision with root package name */
                    public final /* synthetic */ CommentListPanel f34667a;

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
                        this.f34667a = this;
                    }

                    @Override // com.kwad.sdk.core.g.g.a
                    public void a(int i2, String str) {
                        Interceptable interceptable2 = $ic;
                        if (interceptable2 == null || interceptable2.invokeIL(1048576, this, i2, str) == null) {
                            if (com.kwad.sdk.core.network.f.f36360c.k == i2) {
                                if (com.kwad.sdk.core.config.c.C()) {
                                    this.f34667a.f34661h.a();
                                    this.f34667a.a(new CommentResponse());
                                } else {
                                    this.f34667a.f34661h.f();
                                }
                                this.f34667a.o.a();
                                com.kwad.sdk.core.report.e.g(this.f34667a.f34655b.a());
                            } else if (com.kwad.sdk.core.network.f.f36358a.k == i2) {
                                this.f34667a.f34661h.c();
                            } else {
                                this.f34667a.f34661h.d();
                            }
                            this.f34667a.m = false;
                        }
                    }

                    @Override // com.kwad.sdk.core.g.g.a
                    public void a(@NonNull CommentResponse commentResponse2) {
                        Interceptable interceptable2 = $ic;
                        if (interceptable2 == null || interceptable2.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, commentResponse2) == null) {
                            this.f34667a.f34661h.a();
                            this.f34667a.n = commentResponse2;
                            this.f34667a.a(commentResponse2);
                            this.f34667a.m = false;
                        }
                    }
                });
            }
        }
    }

    public void a(@NonNull b bVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, bVar) == null) {
            this.j.add(bVar);
        }
    }

    public void a(@NonNull c cVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(Constants.METHOD_SEND_USER_MSG, this, cVar) == null) {
            this.k.add(cVar);
        }
    }

    public void a(@NonNull f fVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048579, this, fVar) == null) {
            this.l.add(fVar);
        }
    }

    public void a(@NonNull AdTemplate adTemplate, long j) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLJ(1048580, this, adTemplate, j) == null) {
            this.f34662i = adTemplate;
            this.f34655b = new e(adTemplate, j);
        }
    }

    public void a(@NonNull CommentResponse commentResponse) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048581, this, commentResponse) == null) {
            this.f34656c.setItemAnimator(null);
            this.f34656c.setLayoutManager(b());
            this.f34658e = b(commentResponse);
            f();
            this.f34656c.setAdapter(this.f34658e);
            this.f34656c.setVisibility(0);
            if (com.kwad.sdk.core.config.c.C() && com.kwad.sdk.core.response.b.c.c(this.f34662i)) {
                this.f34656c.setOnScrollListener(this.f34654a);
                g();
            }
            this.o.a();
            com.kwad.sdk.core.report.e.g(this.f34655b.a());
        }
    }

    public RecyclerView.LayoutManager b() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048582, this)) == null) {
            LinearLayoutManager linearLayoutManager = new LinearLayoutManager(getContext());
            linearLayoutManager.setOrientation(1);
            return linearLayoutManager;
        }
        return (RecyclerView.LayoutManager) invokeV.objValue;
    }

    public com.kwad.sdk.lib.widget.recycler.d b(@NonNull CommentResponse commentResponse) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048583, this, commentResponse)) == null) {
            this.f34655b.a(commentResponse.rootComments);
            d dVar = new d(getContext(), this.f34655b);
            this.f34657d = dVar;
            return new com.kwad.sdk.lib.widget.recycler.d(dVar);
        }
        return (com.kwad.sdk.lib.widget.recycler.d) invokeL.objValue;
    }

    public void b(@NonNull b bVar) {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeL(InputDeviceCompat.SOURCE_TOUCHPAD, this, bVar) == null) && this.j.contains(bVar)) {
            this.j.remove(bVar);
        }
    }

    public void b(@NonNull c cVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048585, this, cVar) == null) {
            this.k.remove(cVar);
        }
    }

    public void b(@NonNull f fVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048586, this, fVar) == null) {
            this.l.remove(fVar);
        }
    }

    public void c() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048587, this) == null) {
            d dVar = this.f34657d;
            long a2 = dVar != null ? dVar.a() : 0L;
            if (this.f34655b != null) {
                com.kwad.sdk.core.report.e.a(this.f34655b.a(), a2, this.o.b());
            }
        }
    }

    public void d() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048588, this) == null) {
            this.n = null;
        }
    }

    /* JADX WARN: Code restructure failed: missing block: B:8:0x000e, code lost:
        if (r0 != 2) goto L8;
     */
    @Override // android.view.ViewGroup, android.view.View
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public boolean dispatchTouchEvent(MotionEvent motionEvent) {
        InterceptResult invokeL;
        ViewParent parent;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048589, this, motionEvent)) == null) {
            int action = motionEvent.getAction();
            boolean z = true;
            if (action != 0) {
                if (action == 1) {
                    parent = getParent();
                    z = false;
                    parent.requestDisallowInterceptTouchEvent(z);
                    return super.dispatchTouchEvent(motionEvent);
                }
            }
            parent = getParent();
            parent.requestDisallowInterceptTouchEvent(z);
            return super.dispatchTouchEvent(motionEvent);
        }
        return invokeL.booleanValue;
    }
}
