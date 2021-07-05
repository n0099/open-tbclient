package com.kwad.sdk.contentalliance.home.b;

import android.app.Activity;
import android.view.KeyEvent;
import android.view.View;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import com.kwad.sdk.contentalliance.home.d;
import com.kwad.sdk.contentalliance.home.viewpager.SlidePlayViewPager;
import com.kwad.sdk.utils.p;
/* loaded from: classes7.dex */
public class c extends com.kwad.sdk.contentalliance.home.e {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    /* renamed from: b  reason: collision with root package name */
    public View f35104b;

    /* renamed from: c  reason: collision with root package name */
    public SlidePlayViewPager f35105c;

    /* renamed from: d  reason: collision with root package name */
    public com.kwad.sdk.contentalliance.home.swipe.c f35106d;

    /* renamed from: e  reason: collision with root package name */
    public com.kwad.sdk.contentalliance.home.a.b f35107e;

    /* renamed from: f  reason: collision with root package name */
    public com.kwad.sdk.contentalliance.home.h f35108f;

    /* renamed from: g  reason: collision with root package name */
    public Runnable f35109g;

    /* renamed from: h  reason: collision with root package name */
    public View.OnKeyListener f35110h;

    /* renamed from: i  reason: collision with root package name */
    public d.a f35111i;
    public com.kwad.sdk.contentalliance.detail.photo.comment.g j;
    public com.kwad.sdk.contentalliance.home.d k;

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
        this.f35109g = new Runnable(this) { // from class: com.kwad.sdk.contentalliance.home.b.c.1
            public static /* synthetic */ Interceptable $ic;
            public transient /* synthetic */ FieldHolder $fh;

            /* renamed from: a  reason: collision with root package name */
            public final /* synthetic */ c f35112a;

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
                this.f35112a = this;
            }

            @Override // java.lang.Runnable
            public void run() {
                Interceptable interceptable2 = $ic;
                if (interceptable2 == null || interceptable2.invokeV(1048576, this) == null) {
                    c cVar = this.f35112a;
                    cVar.b(cVar.f35104b);
                }
            }
        };
        this.f35110h = new View.OnKeyListener(this) { // from class: com.kwad.sdk.contentalliance.home.b.c.2
            public static /* synthetic */ Interceptable $ic;
            public transient /* synthetic */ FieldHolder $fh;

            /* renamed from: a  reason: collision with root package name */
            public final /* synthetic */ c f35113a;

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
                this.f35113a = this;
            }

            @Override // android.view.View.OnKeyListener
            public boolean onKey(View view, int i4, KeyEvent keyEvent) {
                InterceptResult invokeLIL;
                Interceptable interceptable2 = $ic;
                if (interceptable2 == null || (invokeLIL = interceptable2.invokeLIL(1048576, this, view, i4, keyEvent)) == null) {
                    if (i4 == 4 && keyEvent.getAction() == 1) {
                        this.f35113a.k.a();
                        return true;
                    }
                    return false;
                }
                return invokeLIL.booleanValue;
            }
        };
        this.f35111i = new d.a(this) { // from class: com.kwad.sdk.contentalliance.home.b.c.3
            public static /* synthetic */ Interceptable $ic;
            public transient /* synthetic */ FieldHolder $fh;

            /* renamed from: a  reason: collision with root package name */
            public final /* synthetic */ c f35114a;

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
                this.f35114a = this;
            }

            @Override // com.kwad.sdk.contentalliance.home.d.a
            public boolean a() {
                InterceptResult invokeV;
                Interceptable interceptable2 = $ic;
                if (interceptable2 == null || (invokeV = interceptable2.invokeV(1048576, this)) == null) {
                    if (this.f35114a.f35106d != null) {
                        if ((this.f35114a.f35105c == null || this.f35114a.f35105c.getSourceType() == 0) && !this.f35114a.f35106d.b()) {
                            return false;
                        }
                        this.f35114a.f35106d.c();
                        return true;
                    }
                    return false;
                }
                return invokeV.booleanValue;
            }

            @Override // com.kwad.sdk.contentalliance.home.d.a
            public void b() {
                Interceptable interceptable2 = $ic;
                if (interceptable2 == null || interceptable2.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this) == null) {
                    com.kwad.sdk.core.d.a.a("HomeBackPresenter", "onRefresh()");
                    p.a(this.f35114a.o(), "再按一次返回键退出", 3000L);
                    if (this.f35114a.f35107e != null) {
                        this.f35114a.f35107e.a(3);
                    }
                }
            }

            @Override // com.kwad.sdk.contentalliance.home.d.a
            public void c() {
                Interceptable interceptable2 = $ic;
                if (interceptable2 == null || interceptable2.invokeV(Constants.METHOD_SEND_USER_MSG, this) == null) {
                    com.kwad.sdk.core.d.a.a("HomeBackPresenter", "onExit()");
                    Activity m = this.f35114a.m();
                    if (m != null) {
                        m.onBackPressed();
                    }
                }
            }
        };
        this.j = new com.kwad.sdk.contentalliance.detail.photo.comment.g(this) { // from class: com.kwad.sdk.contentalliance.home.b.c.4
            public static /* synthetic */ Interceptable $ic;
            public transient /* synthetic */ FieldHolder $fh;

            /* renamed from: a  reason: collision with root package name */
            public final /* synthetic */ c f35115a;

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
                this.f35115a = this;
            }

            @Override // com.kwad.sdk.contentalliance.detail.photo.comment.g
            public void a() {
                Interceptable interceptable2 = $ic;
                if (interceptable2 == null || interceptable2.invokeV(1048576, this) == null) {
                }
            }

            @Override // com.kwad.sdk.contentalliance.detail.photo.comment.g
            public void b() {
                Interceptable interceptable2 = $ic;
                if (interceptable2 == null || interceptable2.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this) == null) {
                    c cVar = this.f35115a;
                    cVar.b(cVar.l());
                }
            }
        };
        this.k = new com.kwad.sdk.contentalliance.home.d(this.f35111i);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void b(View view) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(65540, this, view) == null) || view == null) {
            return;
        }
        view.setFocusableInTouchMode(true);
        view.requestFocus();
        view.setOnKeyListener(this.f35110h);
    }

    @Override // com.kwad.sdk.contentalliance.home.e, com.kwad.sdk.mvp.Presenter
    public void a() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
            super.a();
            this.f35104b = l();
            com.kwad.sdk.contentalliance.home.f fVar = ((com.kwad.sdk.contentalliance.home.e) this).f35218a;
            this.f35105c = fVar.f35221c;
            com.kwad.sdk.contentalliance.home.h hVar = fVar.f35224f;
            this.f35108f = hVar;
            if (hVar != null) {
                this.f35106d = hVar.f35246g;
                hVar.f35245f.add(this.j);
            }
            com.kwad.sdk.contentalliance.home.a.i iVar = ((com.kwad.sdk.contentalliance.home.e) this).f35218a.f35220b;
            if (iVar != null) {
                this.f35107e = iVar.c();
            }
            View view = this.f35104b;
            if (view != null) {
                b(view);
                this.f35104b.postDelayed(this.f35109g, 1000L);
            }
            this.k.a(((com.kwad.sdk.contentalliance.home.e) this).f35218a.m);
        }
    }

    @Override // com.kwad.sdk.mvp.Presenter
    public void b_() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this) == null) {
            super.b_();
            View view = this.f35104b;
            if (view != null) {
                view.removeCallbacks(this.f35109g);
            }
            com.kwad.sdk.contentalliance.home.h hVar = this.f35108f;
            if (hVar != null) {
                hVar.f35245f.remove(this.j);
            }
        }
    }

    @Override // com.kwad.sdk.mvp.Presenter
    public void d() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this) == null) {
            super.d();
            View l = l();
            if (l != null) {
                l.setFocusableInTouchMode(false);
                l.setOnKeyListener(null);
            }
        }
    }
}
