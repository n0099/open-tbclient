package com.kwad.sdk.contentalliance.detail.photo.d;

import android.content.Context;
import android.view.View;
import android.widget.LinearLayout;
import androidx.annotation.NonNull;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import com.kwad.sdk.R;
import com.kwad.sdk.core.g.k;
import com.kwad.sdk.core.response.model.AdTemplate;
import com.kwad.sdk.core.response.model.PhotoShareInfo;
import com.kwad.sdk.live.a.b;
import com.kwad.sdk.live.mode.LiveInfo;
import com.kwad.sdk.utils.i;
import com.kwad.sdk.utils.p;
/* loaded from: classes7.dex */
public class f extends a<LinearLayout> {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    /* renamed from: c  reason: collision with root package name */
    public d f34712c;

    /* renamed from: d  reason: collision with root package name */
    public com.kwad.sdk.contentalliance.detail.photo.f.c f34713d;

    /* renamed from: e  reason: collision with root package name */
    public boolean f34714e;

    /* renamed from: f  reason: collision with root package name */
    public AdTemplate f34715f;

    public f() {
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
        this.f34714e = false;
    }

    private com.kwad.sdk.contentalliance.detail.photo.newui.b.a h() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(65546, this)) == null) {
            com.kwad.sdk.contentalliance.detail.photo.newui.b.a aVar = new com.kwad.sdk.contentalliance.detail.photo.newui.b.a(o());
            aVar.setButtonImageResource(R.drawable.ksad_func_button_photo_share_2);
            aVar.setButtonText("复制链接");
            return aVar;
        }
        return (com.kwad.sdk.contentalliance.detail.photo.newui.b.a) invokeV.objValue;
    }

    private void p() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(65548, this) == null) {
            b.a aVar = new b.a();
            LiveInfo A = com.kwad.sdk.core.response.b.c.A(this.f34715f);
            aVar.f38637a = com.kwad.sdk.live.mode.a.b(A);
            aVar.f38638b = com.kwad.sdk.live.mode.a.a(A);
            new k().a(aVar, new k.a(this) { // from class: com.kwad.sdk.contentalliance.detail.photo.d.f.2
                public static /* synthetic */ Interceptable $ic;
                public transient /* synthetic */ FieldHolder $fh;

                /* renamed from: a  reason: collision with root package name */
                public final /* synthetic */ f f34717a;

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
                    this.f34717a = this;
                }

                @Override // com.kwad.sdk.core.g.k.a
                public void a(int i2, String str) {
                    Context o;
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 == null || interceptable2.invokeIL(1048576, this, i2, str) == null) {
                        com.kwad.sdk.core.d.a.a("PhotoShareButtonPresenter", "onError() code=" + i2 + " msg=" + str);
                        if (i2 == com.kwad.sdk.core.network.f.f36365h.k) {
                            o = this.f34717a.o();
                        } else {
                            o = this.f34717a.o();
                            str = "复制链接失败，请稍后重试";
                        }
                        p.a(o, str);
                        if (this.f34717a.f34713d != null) {
                            this.f34717a.f34713d.a(this.f34717a);
                        }
                        com.kwad.sdk.core.report.e.a(this.f34717a.f34712c.a(), false);
                        this.f34717a.f34714e = false;
                    }
                }

                @Override // com.kwad.sdk.core.g.k.a
                public void a(@NonNull PhotoShareInfo photoShareInfo) {
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 == null || interceptable2.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, photoShareInfo) == null) {
                        com.kwad.sdk.core.d.a.a("PhotoShareButtonPresenter", "onLoad() shareUrl=" + photoShareInfo.getShareUrl());
                        i.a(this.f34717a.o(), "ksadsdk_share_url", photoShareInfo.getShareUrl());
                        p.a(this.f34717a.o(), "链接已经复制\n快分享给好友吧");
                        if (this.f34717a.f34713d != null) {
                            this.f34717a.f34713d.a(this.f34717a);
                        }
                        com.kwad.sdk.core.report.e.a(this.f34717a.f34712c.a(), true);
                        this.f34717a.f34714e = false;
                    }
                }
            });
        }
    }

    @Override // com.kwad.sdk.contentalliance.detail.photo.d.a, com.kwad.sdk.mvp.Presenter
    public void a() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
            super.a();
            d dVar = ((a) this).f34687a.f34701a;
            this.f34712c = dVar;
            this.f34715f = dVar.a();
            this.f34713d = ((a) this).f34687a.f34702b;
            com.kwad.sdk.core.report.e.e(this.f34712c.a());
        }
    }

    @Override // com.kwad.sdk.contentalliance.detail.photo.d.a, com.kwad.sdk.mvp.Presenter
    public void b_() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this) == null) {
            super.b_();
            this.f34713d = null;
        }
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.kwad.sdk.contentalliance.detail.photo.f.d
    /* renamed from: f */
    public LinearLayout g() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this)) == null) ? h() : (LinearLayout) invokeV.objValue;
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(1048580, this, view) == null) || this.f34712c == null) {
            return;
        }
        if (this.f34714e) {
            com.kwad.sdk.core.d.a.a("PhotoShareButtonPresenter", "mIsRequesting= " + this.f34714e);
            return;
        }
        this.f34714e = true;
        if (com.kwad.sdk.core.response.b.c.a(this.f34715f)) {
            p();
        } else {
            new k().a(this.f34712c.b(), new k.a(this) { // from class: com.kwad.sdk.contentalliance.detail.photo.d.f.1
                public static /* synthetic */ Interceptable $ic;
                public transient /* synthetic */ FieldHolder $fh;

                /* renamed from: a  reason: collision with root package name */
                public final /* synthetic */ f f34716a;

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
                    this.f34716a = this;
                }

                @Override // com.kwad.sdk.core.g.k.a
                public void a(int i2, String str) {
                    Context o;
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 == null || interceptable2.invokeIL(1048576, this, i2, str) == null) {
                        com.kwad.sdk.core.d.a.a("PhotoShareButtonPresenter", "onError() code=" + i2 + " msg=" + str);
                        if (i2 == com.kwad.sdk.core.network.f.f36365h.k) {
                            o = this.f34716a.o();
                        } else {
                            o = this.f34716a.o();
                            str = "复制链接失败，请稍后重试";
                        }
                        p.a(o, str);
                        if (this.f34716a.f34713d != null) {
                            this.f34716a.f34713d.a(this.f34716a);
                        }
                        com.kwad.sdk.core.report.e.a(this.f34716a.f34712c.a(), false);
                        this.f34716a.f34714e = false;
                    }
                }

                @Override // com.kwad.sdk.core.g.k.a
                public void a(@NonNull PhotoShareInfo photoShareInfo) {
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 == null || interceptable2.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, photoShareInfo) == null) {
                        com.kwad.sdk.core.d.a.a("PhotoShareButtonPresenter", "onLoad() shareUrl=" + photoShareInfo.getShareUrl());
                        i.a(this.f34716a.o(), "ksadsdk_share_url", photoShareInfo.getShareUrl());
                        p.a(this.f34716a.o(), "链接已经复制\n快分享给好友吧");
                        if (this.f34716a.f34713d != null) {
                            this.f34716a.f34713d.a(this.f34716a);
                        }
                        com.kwad.sdk.core.report.e.a(this.f34716a.f34712c.a(), true);
                        this.f34716a.f34714e = false;
                    }
                }
            });
        }
    }
}
