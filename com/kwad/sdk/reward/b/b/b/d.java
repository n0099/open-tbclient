package com.kwad.sdk.reward.b.b.b;

import android.view.View;
import android.widget.ImageView;
import androidx.annotation.NonNull;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import com.kwad.sdk.R;
import com.kwad.sdk.api.KsVideoPlayConfig;
import com.kwad.sdk.contentalliance.detail.video.f;
import com.kwad.sdk.utils.g;
/* loaded from: classes7.dex */
public class d extends com.kwad.sdk.reward.d implements View.OnClickListener {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    /* renamed from: b  reason: collision with root package name */
    public ImageView f38936b;
    @NonNull

    /* renamed from: c  reason: collision with root package name */
    public com.kwad.sdk.reward.c.a f38937c;

    /* renamed from: d  reason: collision with root package name */
    public g.a f38938d;

    /* renamed from: e  reason: collision with root package name */
    public com.kwad.sdk.contentalliance.detail.video.e f38939e;

    public d() {
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
        this.f38938d = new g.a(this) { // from class: com.kwad.sdk.reward.b.b.b.d.1
            public static /* synthetic */ Interceptable $ic;
            public transient /* synthetic */ FieldHolder $fh;

            /* renamed from: a  reason: collision with root package name */
            public final /* synthetic */ d f38940a;

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
                this.f38940a = this;
            }

            @Override // com.kwad.sdk.utils.g.a
            public void a() {
                Interceptable interceptable2 = $ic;
                if (!(interceptable2 == null || interceptable2.invokeV(1048576, this) == null) || this.f38940a.f38936b == null) {
                    return;
                }
                this.f38940a.f38936b.post(new Runnable(this) { // from class: com.kwad.sdk.reward.b.b.b.d.1.1
                    public static /* synthetic */ Interceptable $ic;
                    public transient /* synthetic */ FieldHolder $fh;

                    /* renamed from: a  reason: collision with root package name */
                    public final /* synthetic */ AnonymousClass1 f38941a;

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
                        this.f38941a = this;
                    }

                    @Override // java.lang.Runnable
                    public void run() {
                        Interceptable interceptable3 = $ic;
                        if (interceptable3 == null || interceptable3.invokeV(1048576, this) == null) {
                            this.f38941a.f38940a.f38936b.setSelected(false);
                            this.f38941a.f38940a.f38937c.a(false, false);
                        }
                    }
                });
            }

            @Override // com.kwad.sdk.utils.g.a
            public void b() {
                Interceptable interceptable2 = $ic;
                if (interceptable2 == null || interceptable2.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this) == null) {
                }
            }
        };
        this.f38939e = new f(this) { // from class: com.kwad.sdk.reward.b.b.b.d.2
            public static /* synthetic */ Interceptable $ic;
            public transient /* synthetic */ FieldHolder $fh;

            /* renamed from: a  reason: collision with root package name */
            public final /* synthetic */ d f38942a;

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
                this.f38942a = this;
            }

            @Override // com.kwad.sdk.contentalliance.detail.video.f, com.kwad.sdk.contentalliance.detail.video.e
            public void b() {
                Interceptable interceptable2 = $ic;
                if (interceptable2 == null || interceptable2.invokeV(1048576, this) == null) {
                    this.f38942a.e();
                }
            }
        };
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void e() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(65540, this) == null) {
            this.f38936b.setOnClickListener(this);
        }
    }

    @Override // com.kwad.sdk.reward.d, com.kwad.sdk.mvp.Presenter
    public void a() {
        ImageView imageView;
        boolean z;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
            super.a();
            com.kwad.sdk.reward.a aVar = ((com.kwad.sdk.reward.d) this).f39062a;
            this.f38937c = aVar.f38819i;
            KsVideoPlayConfig ksVideoPlayConfig = aVar.f38813c;
            if (com.kwad.sdk.utils.b.a().b()) {
                imageView = this.f38936b;
                z = false;
            } else if (ksVideoPlayConfig != null) {
                this.f38936b.setSelected(ksVideoPlayConfig.isVideoSoundEnable());
                this.f38937c.a(this.f38939e);
                this.f38937c.a(this.f38938d);
            } else {
                imageView = this.f38936b;
                z = true;
            }
            imageView.setSelected(z);
            this.f38937c.a(this.f38939e);
            this.f38937c.a(this.f38938d);
        }
    }

    @Override // com.kwad.sdk.mvp.Presenter
    public void b_() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this) == null) {
            super.b_();
            this.f38937c.b(this.f38939e);
            this.f38937c.b(this.f38938d);
        }
    }

    @Override // com.kwad.sdk.mvp.Presenter
    public void c() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this) == null) {
            super.c();
            this.f38936b = (ImageView) b(R.id.ksad_video_sound_switch);
        }
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        ImageView imageView;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeL(1048579, this, view) == null) && view == (imageView = this.f38936b)) {
            this.f38937c.a(!imageView.isSelected(), true);
            ImageView imageView2 = this.f38936b;
            imageView2.setSelected(!imageView2.isSelected());
        }
    }
}
