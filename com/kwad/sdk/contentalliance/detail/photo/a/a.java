package com.kwad.sdk.contentalliance.detail.photo.a;

import android.view.ViewGroup;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import com.kwad.sdk.R;
/* loaded from: classes7.dex */
public class a extends com.kwad.sdk.contentalliance.detail.b {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    /* renamed from: b  reason: collision with root package name */
    public ViewGroup f34585b;

    /* renamed from: c  reason: collision with root package name */
    public com.kwad.sdk.contentalliance.home.swipe.a f34586c;

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
        this.f34586c = new com.kwad.sdk.contentalliance.home.swipe.b(this) { // from class: com.kwad.sdk.contentalliance.detail.photo.a.a.1
            public static /* synthetic */ Interceptable $ic;
            public transient /* synthetic */ FieldHolder $fh;

            /* renamed from: a  reason: collision with root package name */
            public final /* synthetic */ a f34587a;

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
                this.f34587a = this;
            }

            @Override // com.kwad.sdk.contentalliance.home.swipe.b, com.kwad.sdk.contentalliance.home.swipe.a
            public void a(float f2) {
                Interceptable interceptable2 = $ic;
                if (interceptable2 == null || interceptable2.invokeF(1048576, this, f2) == null) {
                    this.f34587a.a(f2);
                }
            }
        };
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(float f2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeF(65537, this, f2) == null) {
            this.f34585b.setAlpha(f2);
            this.f34585b.setVisibility(f2 == 0.0f ? 8 : 0);
        }
    }

    @Override // com.kwad.sdk.contentalliance.detail.b, com.kwad.sdk.mvp.Presenter
    public void a() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
            super.a();
            a(((com.kwad.sdk.contentalliance.detail.b) this).f34553a.l.getSourceType() == 0 ? 1.0f : 0.0f);
            ((com.kwad.sdk.contentalliance.detail.b) this).f34553a.f34578e.add(this.f34586c);
        }
    }

    @Override // com.kwad.sdk.mvp.Presenter
    public void b_() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this) == null) {
            super.b_();
            ((com.kwad.sdk.contentalliance.detail.b) this).f34553a.f34578e.remove(this.f34586c);
        }
    }

    @Override // com.kwad.sdk.mvp.Presenter
    public void c() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this) == null) {
            super.c();
            this.f34585b = (ViewGroup) b(R.id.ksad_video_bottom_container);
        }
    }
}
