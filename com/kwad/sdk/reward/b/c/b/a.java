package com.kwad.sdk.reward.b.c.b;

import android.text.TextUtils;
import android.view.View;
import android.widget.TextView;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.mobads.container.util.AdIconUtil;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import com.kwad.sdk.R;
import com.kwad.sdk.core.download.b.a;
import com.kwad.sdk.core.response.model.AdTemplate;
import com.kwad.sdk.reward.a.f;
import com.kwad.sdk.reward.d;
/* loaded from: classes2.dex */
public class a extends d implements View.OnClickListener {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    /* renamed from: b  reason: collision with root package name */
    public TextView f66229b;

    /* renamed from: c  reason: collision with root package name */
    public TextView f66230c;
    @NonNull

    /* renamed from: d  reason: collision with root package name */
    public com.kwad.sdk.reward.a.b f66231d;
    @NonNull

    /* renamed from: e  reason: collision with root package name */
    public AdTemplate f66232e;
    @Nullable

    /* renamed from: f  reason: collision with root package name */
    public com.kwad.sdk.core.download.b.b f66233f;

    /* renamed from: g  reason: collision with root package name */
    public f f66234g;

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
        this.f66234g = new f(this) { // from class: com.kwad.sdk.reward.b.c.b.a.1
            public static /* synthetic */ Interceptable $ic;
            public transient /* synthetic */ FieldHolder $fh;

            /* renamed from: a  reason: collision with root package name */
            public final /* synthetic */ a f66235a;

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
                this.f66235a = this;
            }

            @Override // com.kwad.sdk.reward.a.f
            public void a() {
                Interceptable interceptable2 = $ic;
                if (!(interceptable2 == null || interceptable2.invokeV(1048576, this) == null) || ((d) this.f66235a).f66342a.t) {
                    return;
                }
                this.f66235a.e();
            }
        };
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void e() {
        TextView textView;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(AdIconUtil.AD_TEXT_ID, this) == null) {
            String f2 = com.kwad.sdk.core.response.b.b.f(this.f66232e);
            if (TextUtils.isEmpty(f2)) {
                return;
            }
            com.kwad.sdk.reward.a aVar = ((d) this).f66342a;
            if (aVar.f66014e == 1 || (aVar.q && aVar.r)) {
                this.f66230c.setVisibility(8);
                this.f66229b.setText(f2);
                this.f66229b.setVisibility(0);
                textView = this.f66229b;
            } else {
                this.f66229b.setVisibility(8);
                this.f66230c.setText(f2);
                this.f66230c.setVisibility(0);
                textView = this.f66230c;
            }
            textView.setOnClickListener(this);
            f();
        }
    }

    private void f() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(AdIconUtil.BAIDU_LOGO_ID, this) == null) {
            com.kwad.sdk.core.report.a.c(this.f66232e, 17, ((d) this).f66342a.f66013d);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void n() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(65543, this) == null) {
            com.kwad.sdk.core.report.a.a(this.f66232e, 39, ((d) this).f66342a.f66017h.getTouchCoords(), ((d) this).f66342a.f66013d);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void o() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(65544, this) == null) {
            this.f66231d.a();
        }
    }

    @Override // com.kwad.sdk.reward.d, com.kwad.sdk.mvp.Presenter
    public void a() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
            super.a();
            com.kwad.sdk.reward.a aVar = ((d) this).f66342a;
            this.f66231d = aVar.f66011b;
            this.f66232e = aVar.f66015f;
            this.f66233f = aVar.j;
            aVar.a(this.f66234g);
        }
    }

    @Override // com.kwad.sdk.mvp.Presenter
    public void b() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this) == null) {
            super.b();
            this.f66229b = (TextView) a(R.id.ksad_end_left_call_btn);
            this.f66230c = (TextView) a(R.id.ksad_end_right_call_btn);
        }
    }

    @Override // com.kwad.sdk.mvp.Presenter
    public void c() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this) == null) {
            super.c();
            ((d) this).f66342a.b(this.f66234g);
        }
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048579, this, view) == null) {
            if (view == this.f66229b || view == this.f66230c) {
                com.kwad.sdk.core.download.b.a.a(view.getContext(), this.f66232e, new a.InterfaceC1901a(this) { // from class: com.kwad.sdk.reward.b.c.b.a.2
                    public static /* synthetic */ Interceptable $ic;
                    public transient /* synthetic */ FieldHolder $fh;

                    /* renamed from: a  reason: collision with root package name */
                    public final /* synthetic */ a f66236a;

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
                        this.f66236a = this;
                    }

                    @Override // com.kwad.sdk.core.download.b.a.InterfaceC1901a
                    public void a() {
                        Interceptable interceptable2 = $ic;
                        if (interceptable2 == null || interceptable2.invokeV(1048576, this) == null) {
                            this.f66236a.n();
                            this.f66236a.o();
                        }
                    }
                }, this.f66233f, false);
            }
        }
    }
}
