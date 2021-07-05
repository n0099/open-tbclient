package com.kwad.sdk.contentalliance.tube.profile.b;

import android.app.Activity;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import androidx.annotation.NonNull;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import com.kwad.sdk.R;
import com.kwad.sdk.contentalliance.tube.model.TubeProfileResultData;
import com.kwad.sdk.utils.ao;
/* loaded from: classes7.dex */
public class f extends com.kwad.sdk.contentalliance.tube.profile.a.a implements View.OnClickListener {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    /* renamed from: b  reason: collision with root package name */
    public ViewGroup f35757b;

    /* renamed from: c  reason: collision with root package name */
    public View f35758c;

    /* renamed from: d  reason: collision with root package name */
    public TextView f35759d;

    /* renamed from: e  reason: collision with root package name */
    public com.kwad.sdk.contentalliance.tube.profile.e f35760e;

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
        this.f35760e = new com.kwad.sdk.contentalliance.tube.profile.e(this) { // from class: com.kwad.sdk.contentalliance.tube.profile.b.f.1
            public static /* synthetic */ Interceptable $ic;
            public transient /* synthetic */ FieldHolder $fh;

            /* renamed from: a  reason: collision with root package name */
            public final /* synthetic */ f f35761a;

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
                this.f35761a = this;
            }

            @Override // com.kwad.sdk.contentalliance.tube.profile.e
            public void a(@NonNull TubeProfileResultData tubeProfileResultData) {
                Interceptable interceptable2 = $ic;
                if (interceptable2 == null || interceptable2.invokeL(1048576, this, tubeProfileResultData) == null) {
                    this.f35761a.f35759d.setText(tubeProfileResultData.tubeProfile.tubeInfo.name);
                }
            }
        };
    }

    private void e() {
        Activity m;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeV(65538, this) == null) && (m = m()) != null && com.kwad.sdk.utils.d.a(m)) {
            int a2 = ao.a(o());
            com.kwad.sdk.core.d.a.a("TubeTitleBarPresenter", "initImmersiveTitleBar() statusBarHeight=" + a2);
            ViewGroup.LayoutParams layoutParams = this.f35757b.getLayoutParams();
            com.kwad.sdk.core.d.a.a("TubeTitleBarPresenter", "initImmersiveTitleBar() titleBarLayoutParams.height=" + layoutParams.height);
            layoutParams.height = layoutParams.height + a2;
            this.f35757b.setLayoutParams(layoutParams);
            ViewGroup viewGroup = this.f35757b;
            viewGroup.setPadding(viewGroup.getPaddingLeft(), a2, this.f35757b.getPaddingRight(), this.f35757b.getPaddingBottom());
        }
    }

    @Override // com.kwad.sdk.contentalliance.tube.profile.a.a, com.kwad.sdk.mvp.Presenter
    public void a() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
            super.a();
            this.f35758c.setOnClickListener(this);
            com.kwad.sdk.core.d.a.a("TubeTitleBarPresenter", "onBind()");
            e();
            ((com.kwad.sdk.contentalliance.tube.profile.a.a) this).f35705a.f35710e.add(this.f35760e);
        }
    }

    @Override // com.kwad.sdk.mvp.Presenter
    public void b_() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this) == null) {
            super.b_();
            ((com.kwad.sdk.contentalliance.tube.profile.a.a) this).f35705a.f35710e.remove(this.f35760e);
        }
    }

    @Override // com.kwad.sdk.mvp.Presenter
    public void c() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this) == null) {
            super.c();
            this.f35757b = (ViewGroup) b(R.id.ksad_tube_title_bar);
            this.f35758c = b(R.id.ksad_tube_left_back);
            this.f35759d = (TextView) b(R.id.ksad_tube_title);
        }
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        Activity m;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeL(1048579, this, view) == null) && view == this.f35758c && (m = m()) != null) {
            com.kwad.sdk.core.report.e.d(((com.kwad.sdk.contentalliance.tube.profile.a.a) this).f35705a.f35711f);
            m.finish();
        }
    }
}
