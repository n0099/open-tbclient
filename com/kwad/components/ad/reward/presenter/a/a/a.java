package com.kwad.components.ad.reward.presenter.a.a;

import android.text.TextUtils;
import android.view.View;
import android.widget.TextView;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.core.view.InputDeviceCompat;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.tieba.R;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import com.kwad.components.ad.reward.l;
import com.kwad.components.core.c.a.a;
import com.kwad.sdk.core.response.model.AdTemplate;
/* loaded from: classes5.dex */
public final class a extends com.kwad.components.ad.reward.presenter.a implements View.OnClickListener, com.kwad.components.ad.reward.c.d, c {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public TextView b;
    public TextView c;
    @NonNull
    public com.kwad.components.ad.reward.c.a d;
    @NonNull
    public AdTemplate e;
    @Nullable
    public com.kwad.components.core.c.a.b f;

    public a() {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            interceptable.invokeUnInit(65536, newInitContext);
            int i = newInitContext.flag;
            if ((i & 1) != 0) {
                int i2 = i & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
            }
        }
    }

    private void e() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(65539, this) == null) {
            l lVar = ((com.kwad.components.ad.reward.presenter.a) this).a;
            this.d = lVar.b;
            this.e = lVar.g;
            this.f = lVar.k;
        }
    }

    private void g() {
        TextView textView;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(InputDeviceCompat.SOURCE_TRACKBALL, this) == null) {
            String c = com.kwad.sdk.core.response.a.c.c(this.e);
            if (TextUtils.isEmpty(c)) {
                return;
            }
            if (((com.kwad.components.ad.reward.presenter.a) this).a.f == 1) {
                this.c.setVisibility(8);
                this.b.setText(c);
                this.b.setVisibility(0);
                textView = this.b;
            } else {
                this.b.setVisibility(8);
                this.c.setText(c);
                this.c.setVisibility(0);
                textView = this.c;
            }
            textView.setOnClickListener(this);
            h();
        }
    }

    private void h() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(65541, this) == null) {
            com.kwad.sdk.core.report.a.c(this.e, 17, ((com.kwad.components.ad.reward.presenter.a) this).a.e);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void i() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(65542, this) == null) {
            com.kwad.sdk.core.report.a.a(this.e, 39, ((com.kwad.components.ad.reward.presenter.a) this).a.h.getTouchCoords(), ((com.kwad.components.ad.reward.presenter.a) this).a.e);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void k() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(65543, this) == null) {
            this.d.a();
        }
    }

    @Override // com.kwad.components.ad.reward.presenter.a, com.kwad.sdk.mvp.Presenter
    public final void a() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
            super.a();
            if (l.a(((com.kwad.components.ad.reward.presenter.a) this).a)) {
                ((com.kwad.components.ad.reward.presenter.a) this).a.a(this);
            } else {
                e();
            }
        }
    }

    @Override // com.kwad.components.ad.reward.c.d
    public final void a(String str) {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, str) == null) && "ksad-video-top-bar".equals(str)) {
            e();
        }
    }

    @Override // com.kwad.components.ad.reward.presenter.a.a.c
    public final void d() {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this) == null) || ((com.kwad.components.ad.reward.presenter.a) this).a.z) {
            return;
        }
        g();
    }

    @Override // com.kwad.sdk.mvp.Presenter
    public final void i_() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048579, this) == null) {
            super.i_();
            this.b = (TextView) b(R.id.obfuscated_res_0x7f09103e);
            this.c = (TextView) b(R.id.obfuscated_res_0x7f091041);
        }
    }

    @Override // com.kwad.sdk.mvp.Presenter
    public final void k_() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048580, this) == null) {
            super.k_();
            ((com.kwad.components.ad.reward.presenter.a) this).a.b(this);
            this.b.setVisibility(8);
            this.c.setVisibility(8);
        }
    }

    @Override // android.view.View.OnClickListener
    public final void onClick(View view2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048581, this, view2) == null) {
            if (view2 == this.b || view2 == this.c) {
                com.kwad.components.core.c.a.a.a(new a.C0507a(view2.getContext()).a(this.e).a(this.f).a(false).a(1).a(new a.b(this) { // from class: com.kwad.components.ad.reward.presenter.a.a.a.1
                    public static /* synthetic */ Interceptable $ic;
                    public transient /* synthetic */ FieldHolder $fh;
                    public final /* synthetic */ a a;

                    {
                        Interceptable interceptable2 = $ic;
                        if (interceptable2 != null) {
                            InitContext newInitContext = TitanRuntime.newInitContext();
                            newInitContext.initArgs = r2;
                            Object[] objArr = {this};
                            interceptable2.invokeUnInit(65536, newInitContext);
                            int i = newInitContext.flag;
                            if ((i & 1) != 0) {
                                int i2 = i & 2;
                                newInitContext.thisArg = this;
                                interceptable2.invokeInitBody(65536, newInitContext);
                                return;
                            }
                        }
                        this.a = this;
                    }

                    @Override // com.kwad.components.core.c.a.a.b
                    public final void a() {
                        Interceptable interceptable2 = $ic;
                        if (interceptable2 == null || interceptable2.invokeV(1048576, this) == null) {
                            this.a.i();
                            this.a.k();
                        }
                    }
                }));
            }
        }
    }
}
