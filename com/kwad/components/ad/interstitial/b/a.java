package com.kwad.components.ad.interstitial.b;

import android.content.Context;
import android.view.OrientationEventListener;
import android.view.View;
import androidx.core.view.InputDeviceCompat;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.tieba.R;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import com.kwad.components.ad.interstitial.b.c;
import com.kwad.components.core.widget.ComplianceTextView;
import com.kwad.components.core.widget.KsAutoCloseView;
import com.kwad.sdk.utils.ag;
/* loaded from: classes7.dex */
public final class a extends b {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public ComplianceTextView gc;
    public OrientationEventListener gd;
    public KsAutoCloseView ge;

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

    /* JADX INFO: Access modifiers changed from: private */
    public void a(c cVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(65538, this, cVar) == null) {
            OrientationEventListener orientationEventListener = new OrientationEventListener(this, cVar.gi.getContext(), cVar) { // from class: com.kwad.components.ad.interstitial.b.a.2
                public static /* synthetic */ Interceptable $ic;
                public transient /* synthetic */ FieldHolder $fh;
                public final /* synthetic */ c gf;
                public final /* synthetic */ a gg;

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
                    this.gg = this;
                    this.gf = cVar;
                }

                @Override // android.view.OrientationEventListener
                public final void onOrientationChanged(int i) {
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 == null || interceptable2.invokeI(1048576, this, i) == null) {
                        this.gg.b(this.gf);
                    }
                }
            };
            this.gd = orientationEventListener;
            if (orientationEventListener.canDetectOrientation()) {
                this.gd.enable();
            } else {
                this.gd.disable();
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void b(c cVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(InputDeviceCompat.SOURCE_TRACKBALL, this, cVar) == null) {
            e((View) this.gc);
            if (ag.zL()) {
                com.kwad.sdk.b.kwai.a.b(this.ge, 0, com.kwad.sdk.b.kwai.a.a(getContext(), 25.0f), 0, 0);
            } else {
                com.kwad.sdk.b.kwai.a.b(this.ge, 0, 0, 0, 0);
            }
            this.gc.setVisibility(0);
            this.gc.setAdTemplate(cVar.mAdTemplate);
        }
    }

    private void e(View view2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(65541, this, view2) == null) {
            int a = com.kwad.sdk.b.kwai.a.a(getContext(), 4.0f);
            int a2 = com.kwad.sdk.b.kwai.a.a(getContext(), 4.0f);
            com.kwad.sdk.b.kwai.a.b(view2, a2, a, a2, 0);
        }
    }

    @Override // com.kwad.components.ad.interstitial.b.b, com.kwad.sdk.mvp.Presenter
    public final void aq() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
            super.aq();
            c cVar = (c) xR();
            cVar.a(new c.e(this, cVar) { // from class: com.kwad.components.ad.interstitial.b.a.1
                public static /* synthetic */ Interceptable $ic;
                public transient /* synthetic */ FieldHolder $fh;
                public final /* synthetic */ c gf;
                public final /* synthetic */ a gg;

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
                    this.gg = this;
                    this.gf = cVar;
                }

                @Override // com.kwad.components.ad.interstitial.b.c.e
                public final void onError() {
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 == null || interceptable2.invokeV(1048576, this) == null) {
                        this.gg.b(this.gf);
                        this.gg.a(this.gf);
                    }
                }
            });
        }
    }

    @Override // com.kwad.sdk.mvp.Presenter
    public final void onCreate() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this) == null) {
            super.onCreate();
            this.gc = (ComplianceTextView) findViewById(R.id.obfuscated_res_0x7f091069);
            this.ge = (KsAutoCloseView) findViewById(R.id.obfuscated_res_0x7f0910aa);
        }
    }

    @Override // com.kwad.sdk.mvp.Presenter
    public final void onUnbind() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this) == null) {
            super.onUnbind();
            OrientationEventListener orientationEventListener = this.gd;
            if (orientationEventListener != null) {
                orientationEventListener.disable();
            }
        }
    }
}
