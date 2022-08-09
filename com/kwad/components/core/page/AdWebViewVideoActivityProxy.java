package com.kwad.components.core.page;

import android.app.Activity;
import android.app.Dialog;
import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.view.ViewGroup;
import androidx.annotation.Keep;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.searchbox.performance.speed.task.LaunchTaskConstants;
import com.baidu.tieba.R;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptable;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptorStorage;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import com.kwad.components.core.c.a.a;
import com.kwad.components.core.kwai.a;
import com.kwad.components.core.m.e;
import com.kwad.components.core.page.widget.a;
import com.kwad.sdk.api.core.KsAdSdkDynamicImpl;
import com.kwad.sdk.api.core.ResContext;
import com.kwad.sdk.api.proxy.app.AdWebViewActivity;
import com.kwad.sdk.api.proxy.app.BaseFragmentActivity;
import com.kwad.sdk.core.response.model.AdInfo;
import com.kwad.sdk.core.response.model.AdTemplate;
import com.kwad.sdk.utils.ag;
import com.kwad.sdk.widget.DownloadProgressBar;
import java.io.Serializable;
import java.util.List;
import org.json.JSONObject;
@KsAdSdkDynamicImpl(AdWebViewActivity.class)
@Keep
/* loaded from: classes5.dex */
public class AdWebViewVideoActivityProxy extends com.kwad.components.core.i.b {
    public static /* synthetic */ Interceptable $ic = null;
    public static final String KEY_REPORTED = "key_reported";
    public static final String KEY_TEMPLATE = "key_template";
    public static boolean showingAdWebViewVideoActivity;
    public transient /* synthetic */ FieldHolder $fh;
    public AdTemplate mAdTemplate;
    public com.kwad.components.core.c.a.c mApkDownloadHelper;
    public b mFragment;
    public Dialog mKsExitInterceptDialog;
    public DownloadProgressBar mProgressbar;
    public com.kwad.components.core.kwai.a mTitleBarHelper;
    public ViewGroup mWebDownloadContainer;

    static {
        InterceptResult invokeClinit;
        ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
        if (classClinitInterceptable == null || (invokeClinit = classClinitInterceptable.invokeClinit(1338909412, "Lcom/kwad/components/core/page/AdWebViewVideoActivityProxy;")) == null) {
            return;
        }
        Interceptable interceptable = invokeClinit.interceptor;
        if (interceptable != null) {
            $ic = interceptable;
        }
        if ((invokeClinit.flags & 1) != 0) {
            classClinitInterceptable.invokePostClinit(1338909412, "Lcom/kwad/components/core/page/AdWebViewVideoActivityProxy;");
        }
    }

    public AdWebViewVideoActivityProxy() {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            interceptable.invokeUnInit(65537, newInitContext);
            int i = newInitContext.flag;
            if ((i & 1) != 0) {
                int i2 = i & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65537, newInitContext);
            }
        }
    }

    private com.kwad.components.core.page.widget.a buildDialog() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(65543, this)) == null) ? new com.kwad.components.core.page.widget.a(getActivity(), new a.InterfaceC0361a(this) { // from class: com.kwad.components.core.page.AdWebViewVideoActivityProxy.4
            public static /* synthetic */ Interceptable $ic;
            public transient /* synthetic */ FieldHolder $fh;
            public final /* synthetic */ AdWebViewVideoActivityProxy FE;

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
                this.FE = this;
            }

            @Override // com.kwad.components.core.page.widget.a.InterfaceC0361a
            public final void a(DialogInterface dialogInterface) {
                Interceptable interceptable2 = $ic;
                if (interceptable2 == null || interceptable2.invokeL(1048576, this, dialogInterface) == null) {
                    com.kwad.sdk.core.report.a.r(this.FE.mAdTemplate, 104);
                    dialogInterface.dismiss();
                }
            }

            @Override // com.kwad.components.core.page.widget.a.InterfaceC0361a
            public final void b(DialogInterface dialogInterface) {
                Interceptable interceptable2 = $ic;
                if (interceptable2 == null || interceptable2.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, dialogInterface) == null) {
                    AdWebViewVideoActivityProxy.super.onBackPressed();
                    com.kwad.sdk.core.report.a.r(this.FE.mAdTemplate, 105);
                }
            }

            @Override // com.kwad.components.core.page.widget.a.InterfaceC0361a
            public final void c(DialogInterface dialogInterface) {
                Interceptable interceptable2 = $ic;
                if (interceptable2 == null || interceptable2.invokeL(Constants.METHOD_SEND_USER_MSG, this, dialogInterface) == null) {
                    com.kwad.sdk.core.report.a.r(this.FE.mAdTemplate, 106);
                    dialogInterface.dismiss();
                }
            }
        }) : (com.kwad.components.core.page.widget.a) invokeV.objValue;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public a.C0352a getAdClickConfig(boolean z) {
        InterceptResult invokeZ;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeZ = interceptable.invokeZ(65544, this, z)) == null) ? new a.C0352a(getActivity()).aj(z).ak(false).L(this.mAdTemplate).am(false) : (a.C0352a) invokeZ.objValue;
    }

    private void initView() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(65545, this) == null) {
            this.mProgressbar = (DownloadProgressBar) findViewById(R.id.obfuscated_res_0x7f091221);
            this.mWebDownloadContainer = (ViewGroup) findViewById(R.id.obfuscated_res_0x7f091220);
            AdInfo bQ = com.kwad.sdk.core.response.a.d.bQ(this.mAdTemplate);
            if (com.kwad.sdk.core.response.a.a.am(bQ)) {
                this.mWebDownloadContainer.setVisibility(0);
                this.mApkDownloadHelper = new com.kwad.components.core.c.a.c(this.mAdTemplate, new com.kwad.sdk.core.download.kwai.a(this, bQ) { // from class: com.kwad.components.core.page.AdWebViewVideoActivityProxy.1
                    public static /* synthetic */ Interceptable $ic;
                    public transient /* synthetic */ FieldHolder $fh;
                    public final /* synthetic */ AdWebViewVideoActivityProxy FE;
                    public final /* synthetic */ AdInfo pE;

                    {
                        Interceptable interceptable2 = $ic;
                        if (interceptable2 != null) {
                            InitContext newInitContext = TitanRuntime.newInitContext();
                            newInitContext.initArgs = r2;
                            Object[] objArr = {this, bQ};
                            interceptable2.invokeUnInit(65536, newInitContext);
                            int i = newInitContext.flag;
                            if ((i & 1) != 0) {
                                int i2 = i & 2;
                                newInitContext.thisArg = this;
                                interceptable2.invokeInitBody(65536, newInitContext);
                                return;
                            }
                        }
                        this.FE = this;
                        this.pE = bQ;
                    }

                    @Override // com.kwad.sdk.api.KsAppDownloadListener
                    public final void onDownloadFailed() {
                        Interceptable interceptable2 = $ic;
                        if (interceptable2 == null || interceptable2.invokeV(1048576, this) == null) {
                            this.FE.mProgressbar.setProgress(100.0f);
                            this.FE.mProgressbar.setText(com.kwad.sdk.core.response.a.a.al(this.pE));
                        }
                    }

                    @Override // com.kwad.sdk.api.KsAppDownloadListener
                    public final void onDownloadFinished() {
                        Interceptable interceptable2 = $ic;
                        if (interceptable2 == null || interceptable2.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this) == null) {
                            this.FE.mProgressbar.setProgress(100.0f);
                            this.FE.mProgressbar.setText(com.kwad.sdk.core.response.a.a.aJ(this.FE.mAdTemplate));
                        }
                    }

                    @Override // com.kwad.sdk.api.KsAppDownloadListener
                    public final void onIdle() {
                        Interceptable interceptable2 = $ic;
                        if (interceptable2 == null || interceptable2.invokeV(Constants.METHOD_SEND_USER_MSG, this) == null) {
                            this.FE.mProgressbar.setProgress(100.0f);
                            this.FE.mProgressbar.setText(com.kwad.sdk.core.response.a.a.al(this.pE));
                        }
                    }

                    @Override // com.kwad.sdk.api.KsAppDownloadListener
                    public final void onInstalled() {
                        Interceptable interceptable2 = $ic;
                        if (interceptable2 == null || interceptable2.invokeV(1048579, this) == null) {
                            this.FE.mProgressbar.setProgress(100.0f);
                            this.FE.mProgressbar.setText(com.kwad.sdk.core.response.a.a.P(this.pE));
                        }
                    }

                    @Override // com.kwad.sdk.core.download.kwai.a
                    public final void onPaused(int i) {
                        Interceptable interceptable2 = $ic;
                        if (interceptable2 == null || interceptable2.invokeI(1048580, this, i) == null) {
                            this.FE.mProgressbar.setProgress(i);
                            this.FE.mProgressbar.setText(com.kwad.sdk.core.response.a.a.aX(i));
                        }
                    }

                    @Override // com.kwad.sdk.api.KsAppDownloadListener
                    public final void onProgressUpdate(int i) {
                        Interceptable interceptable2 = $ic;
                        if (interceptable2 == null || interceptable2.invokeI(1048581, this, i) == null) {
                            this.FE.mProgressbar.setProgress(i);
                            this.FE.mProgressbar.setText(com.kwad.sdk.core.response.a.a.aW(i));
                        }
                    }
                });
                this.mProgressbar.setOnClickListener(new View.OnClickListener(this) { // from class: com.kwad.components.core.page.AdWebViewVideoActivityProxy.2
                    public static /* synthetic */ Interceptable $ic;
                    public transient /* synthetic */ FieldHolder $fh;
                    public final /* synthetic */ AdWebViewVideoActivityProxy FE;

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
                        this.FE = this;
                    }

                    @Override // android.view.View.OnClickListener
                    public final void onClick(View view2) {
                        Interceptable interceptable2 = $ic;
                        if (interceptable2 == null || interceptable2.invokeL(1048576, this, view2) == null) {
                            this.FE.mApkDownloadHelper.m(this.FE.getAdClickConfig(true));
                        }
                    }
                });
            } else {
                this.mWebDownloadContainer.setVisibility(8);
            }
            List<AdInfo> list = this.mAdTemplate.adInfoList;
            String bl = (list == null || list.size() <= 0 || this.mAdTemplate.adInfoList.get(0) == null) ? "详情页面" : com.kwad.sdk.core.response.a.a.bl(com.kwad.sdk.core.response.a.d.bQ(this.mAdTemplate));
            com.kwad.components.core.kwai.a aVar = new com.kwad.components.core.kwai.a((ViewGroup) findViewById(R.id.obfuscated_res_0x7f0910c8));
            this.mTitleBarHelper = aVar;
            aVar.a(new a.InterfaceC0358a(this) { // from class: com.kwad.components.core.page.AdWebViewVideoActivityProxy.3
                public static /* synthetic */ Interceptable $ic;
                public transient /* synthetic */ FieldHolder $fh;
                public final /* synthetic */ AdWebViewVideoActivityProxy FE;

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
                    this.FE = this;
                }

                @Override // com.kwad.components.core.kwai.a.InterfaceC0358a
                public final void r(View view2) {
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 == null || interceptable2.invokeL(1048576, this, view2) == null) {
                        this.FE.onBackPressed();
                    }
                }

                @Override // com.kwad.components.core.kwai.a.InterfaceC0358a
                public final void s(View view2) {
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 == null || interceptable2.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, view2) == null) {
                        this.FE.finish();
                    }
                }
            });
            this.mTitleBarHelper.a(new com.kwad.components.core.kwai.b(bl));
            ag.cy(getActivity());
            e.a(getActivity(), 0, true);
            b M = b.M(this.mAdTemplate);
            this.mFragment = M;
            M.setApkDownloadHelper(this.mApkDownloadHelper);
            getSupportFragmentManager().beginTransaction().replace(R.id.obfuscated_res_0x7f09111f, this.mFragment).commitAllowingStateLoss();
        }
    }

    private boolean isFormAdExitInterceptEnable() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(65546, this)) == null) {
            if (this.mAdTemplate == null) {
                return false;
            }
            if (com.kwad.sdk.core.config.d.sa() && this.mAdTemplate.mIsFromContent) {
                return true;
            }
            return com.kwad.sdk.core.config.d.sb() && !this.mAdTemplate.mIsFromContent;
        }
        return invokeV.booleanValue;
    }

    public static void launch(Context context, AdTemplate adTemplate) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeLL(65547, null, context, adTemplate) == null) || context == null || adTemplate == null) {
            return;
        }
        Intent intent = new Intent(context, BaseFragmentActivity.FragmentActivity3.class);
        intent.addFlags(LaunchTaskConstants.OTHER_PROCESS);
        intent.putExtra(KEY_TEMPLATE, adTemplate);
        intent.putExtra(KEY_REPORTED, adTemplate.mPvReported);
        context.startActivity(intent);
        if (context instanceof ResContext) {
            context = ((ResContext) context).getDelegatedContext();
        }
        if (context instanceof Activity) {
            ((Activity) context).overridePendingTransition(0, 0);
        }
    }

    private void showDialog() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(65548, this) == null) {
            if (this.mKsExitInterceptDialog == null) {
                this.mKsExitInterceptDialog = buildDialog();
            }
            com.kwad.sdk.core.report.a.c(this.mAdTemplate, 103, (JSONObject) null);
            this.mKsExitInterceptDialog.show();
        }
    }

    private void showWaitDialog() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(65549, this) == null) {
            if (isFormAdExitInterceptEnable()) {
                showDialog();
            } else {
                finish();
            }
        }
    }

    @Override // com.kwad.components.core.i.b
    public String getPageName() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) ? "AdWebViewVideoActivityProxy" : (String) invokeV.objValue;
    }

    @Override // com.kwad.components.core.i.b, com.kwad.sdk.api.proxy.IActivityProxy
    public void onBackPressed() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this) == null) {
            b bVar = this.mFragment;
            if (bVar == null || !bVar.bG()) {
                showWaitDialog();
            } else {
                super.onBackPressed();
            }
        }
    }

    @Override // com.kwad.components.core.i.b, com.kwad.sdk.api.proxy.IActivityProxy
    public void onCreate(Bundle bundle) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(Constants.METHOD_SEND_USER_MSG, this, bundle) == null) {
            super.onCreate(bundle);
            setContentView(R.layout.obfuscated_res_0x7f0d03fb);
            Serializable serializableExtra = getIntent().getSerializableExtra(KEY_TEMPLATE);
            showingAdWebViewVideoActivity = true;
            if (!(serializableExtra instanceof AdTemplate)) {
                finish();
                return;
            }
            AdTemplate adTemplate = (AdTemplate) serializableExtra;
            this.mAdTemplate = adTemplate;
            adTemplate.mPvReported = getIntent().getBooleanExtra(KEY_REPORTED, false);
            initView();
        }
    }

    @Override // com.kwad.components.core.i.b, com.kwad.sdk.api.proxy.IActivityProxy
    public void onDestroy() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048579, this) == null) {
            Dialog dialog = this.mKsExitInterceptDialog;
            if (dialog != null && dialog.isShowing()) {
                this.mKsExitInterceptDialog.dismiss();
            }
            super.onDestroy();
            showingAdWebViewVideoActivity = false;
            com.kwad.components.core.c.a.c cVar = this.mApkDownloadHelper;
            if (cVar != null) {
                cVar.clear();
            }
        }
    }

    @Override // com.kwad.sdk.api.proxy.IActivityProxy
    public void onPause() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048580, this) == null) {
            showingAdWebViewVideoActivity = false;
            overridePendingTransition(0, 0);
        }
    }

    @Override // com.kwad.components.core.i.b, com.kwad.sdk.api.proxy.IActivityProxy
    public void onResume() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048581, this) == null) {
            super.onResume();
            showingAdWebViewVideoActivity = true;
        }
    }
}
