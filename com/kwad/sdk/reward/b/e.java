package com.kwad.sdk.reward.b;

import android.view.ViewGroup;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import com.kwad.sdk.R;
import com.kwad.sdk.contentalliance.detail.video.f;
/* loaded from: classes7.dex */
public class e extends com.kwad.sdk.reward.d {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    /* renamed from: b  reason: collision with root package name */
    public ViewGroup f39040b;

    /* renamed from: c  reason: collision with root package name */
    public ViewGroup f39041c;

    /* renamed from: d  reason: collision with root package name */
    public com.kwad.sdk.reward.a.e f39042d;

    /* renamed from: e  reason: collision with root package name */
    public com.kwad.sdk.contentalliance.detail.video.e f39043e;

    public e() {
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
        this.f39042d = new com.kwad.sdk.reward.a.e(this) { // from class: com.kwad.sdk.reward.b.e.1
            public static /* synthetic */ Interceptable $ic;
            public transient /* synthetic */ FieldHolder $fh;

            /* renamed from: a  reason: collision with root package name */
            public final /* synthetic */ e f39044a;

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
                this.f39044a = this;
            }

            @Override // com.kwad.sdk.reward.a.e
            public void a() {
                Interceptable interceptable2 = $ic;
                if (interceptable2 == null || interceptable2.invokeV(1048576, this) == null) {
                    this.f39044a.e();
                }
            }
        };
        this.f39043e = new f(this) { // from class: com.kwad.sdk.reward.b.e.2
            public static /* synthetic */ Interceptable $ic;
            public transient /* synthetic */ FieldHolder $fh;

            /* renamed from: a  reason: collision with root package name */
            public final /* synthetic */ e f39045a;

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
                this.f39045a = this;
            }

            @Override // com.kwad.sdk.contentalliance.detail.video.f, com.kwad.sdk.contentalliance.detail.video.e
            public void a() {
                Interceptable interceptable2 = $ic;
                if (interceptable2 == null || interceptable2.invokeV(1048576, this) == null) {
                    super.a();
                    ((com.kwad.sdk.reward.d) this.f39045a).f39062a.b();
                }
            }
        };
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void e() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(65539, this) == null) {
            this.f39040b.setVisibility(8);
            this.f39041c.setVisibility(0);
        }
    }

    @Override // com.kwad.sdk.reward.d, com.kwad.sdk.mvp.Presenter
    public void a() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
            super.a();
            this.f39040b.setVisibility(0);
            ((com.kwad.sdk.reward.d) this).f39062a.n.add(this.f39042d);
            ((com.kwad.sdk.reward.d) this).f39062a.f38819i.a(this.f39043e);
        }
    }

    @Override // com.kwad.sdk.mvp.Presenter
    public void b_() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this) == null) {
            super.b_();
            ((com.kwad.sdk.reward.d) this).f39062a.n.remove(this.f39042d);
            ((com.kwad.sdk.reward.d) this).f39062a.f38819i.b(this.f39043e);
        }
    }

    @Override // com.kwad.sdk.mvp.Presenter
    public void c() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this) == null) {
            super.c();
            this.f39040b = (ViewGroup) b(R.id.ksad_play_detail_top_toolbar);
            this.f39041c = (ViewGroup) b(R.id.ksad_play_end_top_toolbar);
        }
    }
}
