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
import com.kwad.components.ad.reward.k;
import com.kwad.components.core.c.a.a;
import com.kwad.sdk.core.response.model.AdTemplate;
/* loaded from: classes7.dex */
public final class a extends com.kwad.components.ad.reward.presenter.a implements View.OnClickListener, c, com.kwad.components.core.webview.b.d.b {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    @NonNull
    public com.kwad.components.ad.reward.d.a mAdOpenInteractionListener;
    @NonNull
    public AdTemplate mAdTemplate;
    @Nullable
    public com.kwad.components.core.c.a.c mApkDownloadHelper;
    public TextView sH;
    public TextView sI;

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

    private void bQ() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(65539, this) == null) {
            k kVar = this.nM;
            this.mAdOpenInteractionListener = kVar.mAdOpenInteractionListener;
            this.mAdTemplate = kVar.mAdTemplate;
            this.mApkDownloadHelper = kVar.mApkDownloadHelper;
        }
    }

    private void bS() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(InputDeviceCompat.SOURCE_TRACKBALL, this) == null) {
            com.kwad.sdk.core.report.a.c(this.mAdTemplate, 17, this.nM.mReportExtData);
        }
    }

    private void hP() {
        TextView textView;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(65541, this) == null) {
            String bE = com.kwad.sdk.core.response.a.c.bE(this.mAdTemplate);
            if (TextUtils.isEmpty(bE)) {
                return;
            }
            if (this.nM.mScreenOrientation == 1) {
                this.sI.setVisibility(8);
                this.sH.setText(bE);
                this.sH.setVisibility(0);
                textView = this.sH;
            } else {
                this.sH.setVisibility(8);
                this.sI.setText(bE);
                this.sI.setVisibility(0);
                textView = this.sI;
            }
            textView.setOnClickListener(this);
            bS();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void hQ() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(65542, this) == null) {
            com.kwad.sdk.core.report.a.a(this.mAdTemplate, 39, this.nM.mRootContainer.getTouchCoords(), this.nM.mReportExtData);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void notifyAdClick() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(65543, this) == null) {
            this.mAdOpenInteractionListener.bB();
        }
    }

    @Override // com.kwad.components.ad.reward.presenter.a, com.kwad.sdk.mvp.Presenter
    public final void aq() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
            super.aq();
            if (k.a(this.nM)) {
                com.kwad.components.core.webview.b.c.a.pR().a(this);
            } else {
                bQ();
            }
        }
    }

    @Override // com.kwad.components.ad.reward.presenter.a.a.c
    public final void hR() {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this) == null) || this.nM.mF) {
            return;
        }
        hP();
    }

    @Override // android.view.View.OnClickListener
    public final void onClick(View view2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(Constants.METHOD_SEND_USER_MSG, this, view2) == null) {
            if (view2 == this.sH || view2 == this.sI) {
                com.kwad.components.core.c.a.a.a(new a.C0574a(view2.getContext()).L(this.mAdTemplate).b(this.mApkDownloadHelper).aj(false).ae(1).a(new a.b(this) { // from class: com.kwad.components.ad.reward.presenter.a.a.a.1
                    public static /* synthetic */ Interceptable $ic;
                    public transient /* synthetic */ FieldHolder $fh;
                    public final /* synthetic */ a sJ;

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
                        this.sJ = this;
                    }

                    @Override // com.kwad.components.core.c.a.a.b
                    public final void onAdClicked() {
                        Interceptable interceptable2 = $ic;
                        if (interceptable2 == null || interceptable2.invokeV(1048576, this) == null) {
                            this.sJ.hQ();
                            this.sJ.notifyAdClick();
                        }
                    }
                }));
            }
        }
    }

    @Override // com.kwad.sdk.mvp.Presenter
    public final void onCreate() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048579, this) == null) {
            super.onCreate();
            this.sH = (TextView) findViewById(R.id.obfuscated_res_0x7f0910ab);
            this.sI = (TextView) findViewById(R.id.obfuscated_res_0x7f0910ae);
        }
    }

    @Override // com.kwad.sdk.mvp.Presenter
    public final void onUnbind() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048580, this) == null) {
            super.onUnbind();
            com.kwad.components.core.webview.b.c.a.pR().b(this);
            this.sH.setVisibility(8);
            this.sI.setVisibility(8);
        }
    }

    @Override // com.kwad.components.core.webview.b.d.b
    public final void u(String str) {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeL(1048581, this, str) == null) && "ksad-video-top-bar".equals(str)) {
            bQ();
        }
    }
}
