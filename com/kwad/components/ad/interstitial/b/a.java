package com.kwad.components.ad.interstitial.b;

import android.content.Context;
import android.view.OrientationEventListener;
import android.view.View;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.tieba.R;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import com.kwad.components.ad.interstitial.b.c;
import com.kwad.components.core.widget.ComplianceTextView;
import com.kwad.components.core.widget.KsAutoCloseView;
import com.kwad.sdk.utils.ae;
/* loaded from: classes5.dex */
public final class a extends b {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public ComplianceTextView a;
    public OrientationEventListener b;
    public KsAutoCloseView c;

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

    private void a(View view2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(65537, this, view2) == null) {
            int a = com.kwad.sdk.b.kwai.a.a(u(), 4.0f);
            int a2 = com.kwad.sdk.b.kwai.a.a(u(), 4.0f);
            com.kwad.sdk.b.kwai.a.a(view2, a2, a, a2, 0);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(c cVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(65539, this, cVar) == null) {
            OrientationEventListener orientationEventListener = new OrientationEventListener(this, cVar.c.getContext(), cVar) { // from class: com.kwad.components.ad.interstitial.b.a.2
                public static /* synthetic */ Interceptable $ic;
                public transient /* synthetic */ FieldHolder $fh;
                public final /* synthetic */ c a;
                public final /* synthetic */ a b;

                /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                {
                    super(r8);
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 != null) {
                        InitContext newInitContext = TitanRuntime.newInitContext();
                        newInitContext.initArgs = r2;
                        Object[] objArr = {this, r8, cVar};
                        interceptable2.invokeUnInit(65536, newInitContext);
                        int i = newInitContext.flag;
                        if ((i & 1) != 0) {
                            int i2 = i & 2;
                            super((Context) newInitContext.callArgs[0]);
                            newInitContext.thisArg = this;
                            interceptable2.invokeInitBody(65536, newInitContext);
                            return;
                        }
                    }
                    this.b = this;
                    this.a = cVar;
                }

                @Override // android.view.OrientationEventListener
                public final void onOrientationChanged(int i) {
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 == null || interceptable2.invokeI(1048576, this, i) == null) {
                        this.b.b(this.a);
                    }
                }
            };
            this.b = orientationEventListener;
            if (orientationEventListener.canDetectOrientation()) {
                this.b.enable();
            } else {
                this.b.disable();
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void b(c cVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(65541, this, cVar) == null) {
            a((View) this.a);
            if (ae.a()) {
                com.kwad.sdk.b.kwai.a.a(this.c, 0, com.kwad.sdk.b.kwai.a.a(u(), 25.0f), 0, 0);
            } else {
                com.kwad.sdk.b.kwai.a.a(this.c, 0, 0, 0, 0);
            }
            this.a.setVisibility(0);
            this.a.setAdTemplate(cVar.a);
        }
    }

    @Override // com.kwad.sdk.mvp.Presenter
    public final void a() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
            super.a();
            c cVar = (c) t();
            cVar.a(new c.InterfaceC0469c(this, cVar) { // from class: com.kwad.components.ad.interstitial.b.a.1
                public static /* synthetic */ Interceptable $ic;
                public transient /* synthetic */ FieldHolder $fh;
                public final /* synthetic */ c a;
                public final /* synthetic */ a b;

                {
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 != null) {
                        InitContext newInitContext = TitanRuntime.newInitContext();
                        newInitContext.initArgs = r2;
                        Object[] objArr = {this, cVar};
                        interceptable2.invokeUnInit(65536, newInitContext);
                        int i = newInitContext.flag;
                        if ((i & 1) != 0) {
                            int i2 = i & 2;
                            newInitContext.thisArg = this;
                            interceptable2.invokeInitBody(65536, newInitContext);
                            return;
                        }
                    }
                    this.b = this;
                    this.a = cVar;
                }

                @Override // com.kwad.components.ad.interstitial.b.c.InterfaceC0469c
                public final void a() {
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 == null || interceptable2.invokeV(1048576, this) == null) {
                        this.b.b(this.a);
                        this.b.a(this.a);
                    }
                }
            });
        }
    }

    @Override // com.kwad.sdk.mvp.Presenter
    public final void i_() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this) == null) {
            super.i_();
            this.a = (ComplianceTextView) b(R.id.obfuscated_res_0x7f09101a);
            this.c = (KsAutoCloseView) b(R.id.obfuscated_res_0x7f09105b);
        }
    }

    @Override // com.kwad.sdk.mvp.Presenter
    public final void k_() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this) == null) {
            super.k_();
            OrientationEventListener orientationEventListener = this.b;
            if (orientationEventListener != null) {
                orientationEventListener.disable();
            }
        }
    }
}
