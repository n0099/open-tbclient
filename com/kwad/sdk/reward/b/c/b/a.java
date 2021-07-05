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
import com.kwad.sdk.reward.a.e;
import com.kwad.sdk.reward.d;
/* loaded from: classes7.dex */
public class a extends d implements View.OnClickListener {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    /* renamed from: b  reason: collision with root package name */
    public TextView f39012b;

    /* renamed from: c  reason: collision with root package name */
    public TextView f39013c;
    @NonNull

    /* renamed from: d  reason: collision with root package name */
    public com.kwad.sdk.reward.a.b f39014d;
    @NonNull

    /* renamed from: e  reason: collision with root package name */
    public AdTemplate f39015e;
    @Nullable

    /* renamed from: f  reason: collision with root package name */
    public com.kwad.sdk.core.download.b.b f39016f;

    /* renamed from: g  reason: collision with root package name */
    public e f39017g;

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
        this.f39017g = new e(this) { // from class: com.kwad.sdk.reward.b.c.b.a.1
            public static /* synthetic */ Interceptable $ic;
            public transient /* synthetic */ FieldHolder $fh;

            /* renamed from: a  reason: collision with root package name */
            public final /* synthetic */ a f39018a;

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
                this.f39018a = this;
            }

            @Override // com.kwad.sdk.reward.a.e
            public void a() {
                Interceptable interceptable2 = $ic;
                if (interceptable2 == null || interceptable2.invokeV(1048576, this) == null) {
                    this.f39018a.e();
                }
            }
        };
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void e() {
        TextView textView;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(65540, this) == null) {
            String k = com.kwad.sdk.core.response.b.b.k(this.f39015e);
            if (TextUtils.isEmpty(k)) {
                return;
            }
            com.kwad.sdk.reward.a aVar = ((d) this).f39062a;
            if (aVar.f38815e == 1 || (aVar.p && aVar.q)) {
                this.f39013c.setVisibility(8);
                this.f39012b.setText(k);
                this.f39012b.setVisibility(0);
                textView = this.f39012b;
            } else {
                this.f39012b.setVisibility(8);
                this.f39013c.setText(k);
                this.f39013c.setVisibility(0);
                textView = this.f39013c;
            }
            textView.setOnClickListener(this);
            f();
        }
    }

    private void f() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(AdIconUtil.AD_TEXT_ID, this) == null) {
            com.kwad.sdk.core.report.b.c(this.f39015e, 17, ((d) this).f39062a.f38814d);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void g() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(AdIconUtil.BAIDU_LOGO_ID, this) == null) {
            com.kwad.sdk.core.report.b.a(this.f39015e, 39, ((d) this).f39062a.f38818h.getTouchCoords(), ((d) this).f39062a.f38814d);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void h() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(65543, this) == null) {
            this.f39014d.a();
        }
    }

    @Override // com.kwad.sdk.reward.d, com.kwad.sdk.mvp.Presenter
    public void a() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
            super.a();
            com.kwad.sdk.reward.a aVar = ((d) this).f39062a;
            this.f39014d = aVar.f38812b;
            this.f39015e = aVar.f38816f;
            this.f39016f = aVar.j;
            aVar.n.add(this.f39017g);
        }
    }

    @Override // com.kwad.sdk.mvp.Presenter
    public void b_() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this) == null) {
            super.b_();
            ((d) this).f39062a.n.remove(this.f39017g);
        }
    }

    @Override // com.kwad.sdk.mvp.Presenter
    public void c() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this) == null) {
            super.c();
            this.f39012b = (TextView) b(R.id.ksad_end_left_call_btn);
            this.f39013c = (TextView) b(R.id.ksad_end_right_call_btn);
        }
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048579, this, view) == null) {
            if (view == this.f39012b || view == this.f39013c) {
                com.kwad.sdk.core.download.b.a.a(view.getContext(), this.f39015e, new a.InterfaceC0426a(this) { // from class: com.kwad.sdk.reward.b.c.b.a.2
                    public static /* synthetic */ Interceptable $ic;
                    public transient /* synthetic */ FieldHolder $fh;

                    /* renamed from: a  reason: collision with root package name */
                    public final /* synthetic */ a f39019a;

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
                        this.f39019a = this;
                    }

                    @Override // com.kwad.sdk.core.download.b.a.InterfaceC0426a
                    public void a() {
                        Interceptable interceptable2 = $ic;
                        if (interceptable2 == null || interceptable2.invokeV(1048576, this) == null) {
                            this.f39019a.g();
                            this.f39019a.h();
                        }
                    }
                }, this.f39016f);
            }
        }
    }
}
