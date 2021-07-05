package com.kwad.sdk.contentalliance.detail.photo.e;

import android.view.KeyEvent;
import android.view.View;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import com.kwad.sdk.R;
import com.kwad.sdk.contentalliance.detail.ad.presenter.comment.CommentBottomAdPanel;
import com.kwad.sdk.contentalliance.detail.photo.comment.CommentListPanel;
import com.kwad.sdk.contentalliance.detail.photo.comment.f;
import com.kwad.sdk.contentalliance.detail.photo.comment.g;
import com.kwad.sdk.contentalliance.detail.photo.f.f;
import com.kwad.sdk.core.download.b.a;
import com.kwad.sdk.core.response.model.AdTemplate;
import com.kwad.sdk.core.view.AdBaseFrameLayout;
import java.util.List;
/* loaded from: classes7.dex */
public class a extends com.kwad.sdk.contentalliance.detail.b {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    /* renamed from: b  reason: collision with root package name */
    public View.OnKeyListener f34718b;

    /* renamed from: c  reason: collision with root package name */
    public AdBaseFrameLayout f34719c;

    /* renamed from: d  reason: collision with root package name */
    public CommentListPanel f34720d;

    /* renamed from: e  reason: collision with root package name */
    public CommentBottomAdPanel f34721e;
    @Nullable

    /* renamed from: f  reason: collision with root package name */
    public com.kwad.sdk.core.download.b.b f34722f;

    /* renamed from: g  reason: collision with root package name */
    public int f34723g;

    /* renamed from: h  reason: collision with root package name */
    public com.kwad.sdk.core.i.c f34724h;

    /* renamed from: i  reason: collision with root package name */
    public com.kwad.sdk.contentalliance.a.a f34725i;
    public CommentBottomAdPanel.a j;
    public f k;
    public List<g> l;
    public CommentListPanel.b m;
    public CommentListPanel.c n;
    public f.a o;

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
        this.f34723g = 0;
        this.f34724h = new com.kwad.sdk.core.i.d(this) { // from class: com.kwad.sdk.contentalliance.detail.photo.e.a.1
            public static /* synthetic */ Interceptable $ic;
            public transient /* synthetic */ FieldHolder $fh;

            /* renamed from: a  reason: collision with root package name */
            public final /* synthetic */ a f34726a;

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
                this.f34726a = this;
            }

            @Override // com.kwad.sdk.core.i.d, com.kwad.sdk.core.i.c
            public void b() {
                Interceptable interceptable2 = $ic;
                if (interceptable2 == null || interceptable2.invokeV(1048576, this) == null) {
                    this.f34726a.e();
                }
            }
        };
        this.f34725i = new com.kwad.sdk.contentalliance.a.b(this) { // from class: com.kwad.sdk.contentalliance.detail.photo.e.a.2
            public static /* synthetic */ Interceptable $ic;
            public transient /* synthetic */ FieldHolder $fh;

            /* renamed from: a  reason: collision with root package name */
            public final /* synthetic */ a f34727a;

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
                this.f34727a = this;
            }

            @Override // com.kwad.sdk.contentalliance.a.b, com.kwad.sdk.contentalliance.a.a
            public void k() {
                Interceptable interceptable2 = $ic;
                if (interceptable2 == null || interceptable2.invokeV(1048576, this) == null) {
                    ((com.kwad.sdk.contentalliance.detail.b) this.f34727a).f34553a.f34581h = false;
                    this.f34727a.e();
                }
            }
        };
        this.f34718b = new View.OnKeyListener(this) { // from class: com.kwad.sdk.contentalliance.detail.photo.e.a.3
            public static /* synthetic */ Interceptable $ic;
            public transient /* synthetic */ FieldHolder $fh;

            /* renamed from: a  reason: collision with root package name */
            public final /* synthetic */ a f34728a;

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
                this.f34728a = this;
            }

            @Override // android.view.View.OnKeyListener
            public boolean onKey(View view, int i4, KeyEvent keyEvent) {
                InterceptResult invokeLIL;
                Interceptable interceptable2 = $ic;
                if (interceptable2 == null || (invokeLIL = interceptable2.invokeLIL(1048576, this, view, i4, keyEvent)) == null) {
                    if (i4 == 4 && keyEvent.getAction() == 1) {
                        this.f34728a.e();
                        return true;
                    }
                    return false;
                }
                return invokeLIL.booleanValue;
            }
        };
        this.j = new CommentBottomAdPanel.a(this) { // from class: com.kwad.sdk.contentalliance.detail.photo.e.a.4
            public static /* synthetic */ Interceptable $ic;
            public transient /* synthetic */ FieldHolder $fh;

            /* renamed from: a  reason: collision with root package name */
            public final /* synthetic */ a f34729a;

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
                this.f34729a = this;
            }

            @Override // com.kwad.sdk.contentalliance.detail.ad.presenter.comment.CommentBottomAdPanel.a
            public void a() {
                Interceptable interceptable2 = $ic;
                if (interceptable2 == null || interceptable2.invokeV(1048576, this) == null) {
                    com.kwad.sdk.core.d.a.a("PhotoCommentListPresenter", " mCommentBottomAdPanel PanelCloseListener close");
                    ((com.kwad.sdk.contentalliance.detail.b) this.f34729a).f34553a.f34581h = true;
                    this.f34729a.a(false);
                }
            }
        };
        this.k = new com.kwad.sdk.contentalliance.detail.photo.comment.f(this) { // from class: com.kwad.sdk.contentalliance.detail.photo.e.a.5
            public static /* synthetic */ Interceptable $ic;
            public transient /* synthetic */ FieldHolder $fh;

            /* renamed from: a  reason: collision with root package name */
            public final /* synthetic */ a f34730a;

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
                this.f34730a = this;
            }

            @Override // com.kwad.sdk.contentalliance.detail.photo.comment.f
            public void a(int i4) {
                Interceptable interceptable2 = $ic;
                if (interceptable2 == null || interceptable2.invokeI(1048576, this, i4) == null) {
                    com.kwad.sdk.core.download.b.b.a(this.f34730a.f34722f, true);
                    com.kwad.sdk.core.download.b.a.a(this.f34730a.f34721e.getContext(), ((com.kwad.sdk.contentalliance.detail.b) this.f34730a).f34553a.j, new a.InterfaceC0426a(this, i4) { // from class: com.kwad.sdk.contentalliance.detail.photo.e.a.5.1
                        public static /* synthetic */ Interceptable $ic;
                        public transient /* synthetic */ FieldHolder $fh;

                        /* renamed from: a  reason: collision with root package name */
                        public final /* synthetic */ int f34731a;

                        /* renamed from: b  reason: collision with root package name */
                        public final /* synthetic */ AnonymousClass5 f34732b;

                        {
                            Interceptable interceptable3 = $ic;
                            if (interceptable3 != null) {
                                InitContext newInitContext2 = TitanRuntime.newInitContext();
                                newInitContext2.initArgs = r2;
                                Object[] objArr = {this, Integer.valueOf(i4)};
                                interceptable3.invokeUnInit(65536, newInitContext2);
                                int i5 = newInitContext2.flag;
                                if ((i5 & 1) != 0) {
                                    int i6 = i5 & 2;
                                    newInitContext2.thisArg = this;
                                    interceptable3.invokeInitBody(65536, newInitContext2);
                                    return;
                                }
                            }
                            this.f34732b = this;
                            this.f34731a = i4;
                        }

                        @Override // com.kwad.sdk.core.download.b.a.InterfaceC0426a
                        public void a() {
                            Interceptable interceptable3 = $ic;
                            if (interceptable3 == null || interceptable3.invokeV(1048576, this) == null) {
                                com.kwad.sdk.core.d.a.a("PhotoCommentListPresenter", "CommentPanelAdClickListener onAdClick itemClickType:" + this.f34731a);
                                com.kwad.sdk.core.report.b.a(((com.kwad.sdk.contentalliance.detail.b) this.f34732b.f34730a).f34553a.j, this.f34731a, this.f34732b.f34730a.f34719c.getTouchCoords());
                            }
                        }
                    }, this.f34730a.f34722f);
                }
            }
        };
        this.m = new CommentListPanel.b(this) { // from class: com.kwad.sdk.contentalliance.detail.photo.e.a.6
            public static /* synthetic */ Interceptable $ic;
            public transient /* synthetic */ FieldHolder $fh;

            /* renamed from: a  reason: collision with root package name */
            public final /* synthetic */ a f34733a;

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
                this.f34733a = this;
            }

            @Override // com.kwad.sdk.contentalliance.detail.photo.comment.CommentListPanel.b
            public void a() {
                Interceptable interceptable2 = $ic;
                if (interceptable2 == null || interceptable2.invokeV(1048576, this) == null) {
                    this.f34733a.e();
                }
            }
        };
        this.n = new CommentListPanel.c(this) { // from class: com.kwad.sdk.contentalliance.detail.photo.e.a.7
            public static /* synthetic */ Interceptable $ic;
            public transient /* synthetic */ FieldHolder $fh;

            /* renamed from: a  reason: collision with root package name */
            public final /* synthetic */ a f34734a;

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
                this.f34734a = this;
            }

            @Override // com.kwad.sdk.contentalliance.detail.photo.comment.CommentListPanel.c
            public void a(boolean z) {
                Interceptable interceptable2 = $ic;
                if (interceptable2 == null || interceptable2.invokeZ(1048576, this, z) == null) {
                    if (!z || ((com.kwad.sdk.contentalliance.detail.b) this.f34734a).f34553a.f34581h) {
                        if (this.f34734a.f34723g == 1) {
                            return;
                        }
                        this.f34734a.a(false);
                    } else if (this.f34734a.f34723g == 2) {
                        return;
                    } else {
                        this.f34734a.f34721e.a(((com.kwad.sdk.contentalliance.detail.b) this.f34734a).f34553a.j, this.f34734a.f34722f);
                        com.kwad.sdk.core.report.b.d(((com.kwad.sdk.contentalliance.detail.b) this.f34734a).f34553a.j, 89);
                        this.f34734a.f34721e.a(this.f34734a.j);
                        this.f34734a.f34723g = 2;
                        this.f34734a.f34721e.a(true, false);
                    }
                    com.kwad.sdk.core.d.a.a("PhotoCommentListPresenter", " onShowBottomAdBanner + show:" + z + "  mHasCloseBottomAdBanner: " + ((com.kwad.sdk.contentalliance.detail.b) this.f34734a).f34553a.f34581h);
                }
            }
        };
        this.o = new f.a(this) { // from class: com.kwad.sdk.contentalliance.detail.photo.e.a.8
            public static /* synthetic */ Interceptable $ic;
            public transient /* synthetic */ FieldHolder $fh;

            /* renamed from: a  reason: collision with root package name */
            public final /* synthetic */ a f34735a;

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
                this.f34735a = this;
            }

            @Override // com.kwad.sdk.contentalliance.detail.photo.f.f.a
            public void a(@NonNull AdTemplate adTemplate, long j) {
                Interceptable interceptable2 = $ic;
                if (interceptable2 == null || interceptable2.invokeLJ(1048576, this, adTemplate, j) == null) {
                    this.f34735a.f34720d.a(adTemplate, j);
                    this.f34735a.f34720d.a();
                    this.f34735a.f();
                }
            }
        };
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(65540, this, z) == null) {
            this.f34723g = 1;
            this.f34721e.b(this.j);
            this.f34721e.a();
            this.f34721e.a(false, z);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void e() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(65545, this) == null) {
            com.kwad.sdk.contentalliance.detail.c cVar = ((com.kwad.sdk.contentalliance.detail.b) this).f34553a;
            cVar.f34580g = false;
            cVar.n = false;
            if (this.f34720d.getVisibility() == 0) {
                this.f34720d.setVisibility(8);
                this.f34720d.setFocusableInTouchMode(false);
                this.f34720d.setOnKeyListener(null);
                this.f34720d.c();
                h();
            }
            a(true);
            this.f34723g = 0;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void f() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(65547, this) == null) {
            this.f34720d.setVisibility(0);
            this.f34720d.setFocusableInTouchMode(true);
            this.f34720d.requestFocus();
            this.f34720d.setOnKeyListener(this.f34718b);
            com.kwad.sdk.contentalliance.detail.c cVar = ((com.kwad.sdk.contentalliance.detail.b) this).f34553a;
            cVar.f34580g = true;
            cVar.n = true;
            g();
        }
    }

    private void g() {
        List<g> list;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(65549, this) == null) || (list = this.l) == null) {
            return;
        }
        for (g gVar : list) {
            gVar.a();
        }
    }

    private void h() {
        List<g> list;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(65551, this) == null) || (list = this.l) == null) {
            return;
        }
        for (g gVar : list) {
            gVar.b();
        }
    }

    @Override // com.kwad.sdk.contentalliance.detail.b, com.kwad.sdk.mvp.Presenter
    public void a() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
            super.a();
            com.kwad.sdk.contentalliance.detail.c cVar = ((com.kwad.sdk.contentalliance.detail.b) this).f34553a;
            this.l = cVar.f34574a.f35245f;
            cVar.f34575b.add(this.f34725i);
            com.kwad.sdk.contentalliance.detail.c cVar2 = ((com.kwad.sdk.contentalliance.detail.b) this).f34553a;
            this.f34722f = cVar2.o;
            com.kwad.sdk.contentalliance.detail.video.b bVar = cVar2.m;
            if (bVar != null) {
                bVar.a(this.f34724h);
            }
            ((com.kwad.sdk.contentalliance.detail.b) this).f34553a.f34579f.add(this.o);
            this.f34720d.a(this.m);
            if (com.kwad.sdk.core.config.c.C() && com.kwad.sdk.core.response.b.c.c(((com.kwad.sdk.contentalliance.detail.b) this).f34553a.j)) {
                this.f34720d.a(this.n);
                this.f34720d.a(this.k);
            }
        }
    }

    @Override // com.kwad.sdk.mvp.Presenter
    public void b_() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this) == null) {
            super.b_();
            this.l = null;
            ((com.kwad.sdk.contentalliance.detail.b) this).f34553a.f34575b.remove(this.f34725i);
            ((com.kwad.sdk.contentalliance.detail.b) this).f34553a.f34579f.remove(this.o);
            com.kwad.sdk.contentalliance.detail.video.b bVar = ((com.kwad.sdk.contentalliance.detail.b) this).f34553a.m;
            if (bVar != null) {
                bVar.b(this.f34724h);
            }
            e();
            this.f34720d.b(this.m);
            this.f34720d.b(this.n);
            this.f34720d.b(this.k);
            this.f34720d.d();
            a(true);
            this.f34723g = 0;
        }
    }

    @Override // com.kwad.sdk.mvp.Presenter
    public void c() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this) == null) {
            super.c();
            this.f34720d = (CommentListPanel) b(R.id.ksad_photo_comment_list_panel);
            this.f34719c = (AdBaseFrameLayout) b(R.id.ksad_root_container);
            this.f34721e = (CommentBottomAdPanel) b(R.id.ksad_photo_comment_bottom_ad_panel);
        }
    }
}
