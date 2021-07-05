package com.kwad.sdk.contentalliance.tube.detail.b;

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
import com.kwad.sdk.contentalliance.tube.b;
import com.kwad.sdk.core.response.model.AdResultData;
import com.kwad.sdk.utils.ao;
/* loaded from: classes7.dex */
public class e extends com.kwad.sdk.contentalliance.tube.detail.a.a implements View.OnClickListener {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    /* renamed from: b  reason: collision with root package name */
    public ViewGroup f35675b;

    /* renamed from: c  reason: collision with root package name */
    public View f35676c;

    /* renamed from: d  reason: collision with root package name */
    public TextView f35677d;

    /* renamed from: e  reason: collision with root package name */
    public b.a f35678e;

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
        this.f35678e = new b.a(this) { // from class: com.kwad.sdk.contentalliance.tube.detail.b.e.1
            public static /* synthetic */ Interceptable $ic;
            public transient /* synthetic */ FieldHolder $fh;

            /* renamed from: a  reason: collision with root package name */
            public final /* synthetic */ e f35679a;

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
                this.f35679a = this;
            }

            @Override // com.kwad.sdk.contentalliance.tube.b.a
            public void a(boolean z) {
                Interceptable interceptable2 = $ic;
                if (interceptable2 == null || interceptable2.invokeZ(1048576, this, z) == null) {
                }
            }

            @Override // com.kwad.sdk.contentalliance.tube.b.a
            public void a(boolean z, int i4, String str) {
                Interceptable interceptable2 = $ic;
                if (interceptable2 == null || interceptable2.invokeCommon(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, new Object[]{Boolean.valueOf(z), Integer.valueOf(i4), str}) == null) {
                }
            }

            @Override // com.kwad.sdk.contentalliance.tube.b.a
            public void a(boolean z, @NonNull AdResultData adResultData) {
                Interceptable interceptable2 = $ic;
                if (!(interceptable2 == null || interceptable2.invokeZL(Constants.METHOD_SEND_USER_MSG, this, z, adResultData) == null) || ((com.kwad.sdk.contentalliance.tube.detail.a.a) this.f35679a).f35629a.f35631b.mTubeInfo == null) {
                    return;
                }
                this.f35679a.f35677d.setText(((com.kwad.sdk.contentalliance.tube.detail.a.a) this.f35679a).f35629a.f35631b.mTubeInfo.name);
            }

            @Override // com.kwad.sdk.contentalliance.tube.b.a
            public void b(boolean z) {
                Interceptable interceptable2 = $ic;
                if (interceptable2 == null || interceptable2.invokeZ(1048579, this, z) == null) {
                }
            }
        };
    }

    private void e() {
        Activity m;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeV(65540, this) == null) && (m = m()) != null && com.kwad.sdk.utils.d.a(m)) {
            int a2 = ao.a(o());
            ViewGroup.LayoutParams layoutParams = this.f35675b.getLayoutParams();
            com.kwad.sdk.core.d.a.a("TubeTitleBarPresenter", "initImmersiveTitleBar() height=" + layoutParams.height);
            layoutParams.height = layoutParams.height + a2;
            this.f35675b.setLayoutParams(layoutParams);
            ViewGroup viewGroup = this.f35675b;
            viewGroup.setPadding(viewGroup.getPaddingLeft(), a2, this.f35675b.getPaddingRight(), this.f35675b.getPaddingBottom());
        }
    }

    @Override // com.kwad.sdk.contentalliance.tube.detail.a.a, com.kwad.sdk.mvp.Presenter
    public void a() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
            super.a();
            this.f35676c.setOnClickListener(this);
            com.kwad.sdk.core.d.a.a("TubeTitleBarPresenter", "onBind()");
            e();
            ((com.kwad.sdk.contentalliance.tube.detail.a.a) this).f35629a.f35633d.add(this.f35678e);
        }
    }

    @Override // com.kwad.sdk.mvp.Presenter
    public void b_() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this) == null) {
            super.b_();
            ((com.kwad.sdk.contentalliance.tube.detail.a.a) this).f35629a.f35633d.remove(this.f35678e);
        }
    }

    @Override // com.kwad.sdk.mvp.Presenter
    public void c() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this) == null) {
            super.c();
            this.f35675b = (ViewGroup) b(R.id.ksad_tube_title_bar);
            this.f35676c = b(R.id.ksad_tube_left_back);
            this.f35677d = (TextView) b(R.id.ksad_tube_title);
        }
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeL(1048579, this, view) == null) && view == this.f35676c) {
            Activity m = m();
            com.kwad.sdk.core.report.e.d(((com.kwad.sdk.contentalliance.tube.detail.a.a) this).f35629a.f35635f);
            if (m != null) {
                m.finish();
            }
        }
    }
}
