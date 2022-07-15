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
import com.kwad.components.core.l.e;
import com.kwad.components.core.page.widget.a;
import com.kwad.sdk.api.core.KsAdSdkDynamicImpl;
import com.kwad.sdk.api.core.ResContext;
import com.kwad.sdk.api.proxy.app.AdWebViewActivity;
import com.kwad.sdk.api.proxy.app.BaseFragmentActivity;
import com.kwad.sdk.core.response.model.AdInfo;
import com.kwad.sdk.core.response.model.AdTemplate;
import com.kwad.sdk.utils.ae;
import com.kwad.sdk.widget.DownloadProgressBar;
import java.io.Serializable;
import java.util.List;
import org.json.JSONObject;
@KsAdSdkDynamicImpl(AdWebViewActivity.class)
@Keep
/* loaded from: classes5.dex */
public class AdWebViewVideoActivityProxy extends com.kwad.components.core.h.b {
    public static /* synthetic */ Interceptable $ic = null;
    public static final String KEY_REPORTED = "key_reported";
    public static final String KEY_TEMPLATE = "key_template";
    public static boolean showingAdWebViewVideoActivity;
    public transient /* synthetic */ FieldHolder $fh;
    public AdTemplate mAdTemplate;
    public com.kwad.components.core.c.a.b mApkDownloadHelper;
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
        return (interceptable == null || (invokeV = interceptable.invokeV(65543, this)) == null) ? new com.kwad.components.core.page.widget.a(getActivity(), new a.InterfaceC0516a(this) { // from class: com.kwad.components.core.page.AdWebViewVideoActivityProxy.4
            public static /* synthetic */ Interceptable $ic;
            public transient /* synthetic */ FieldHolder $fh;
            public final /* synthetic */ AdWebViewVideoActivityProxy a;

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

            @Override // com.kwad.components.core.page.widget.a.InterfaceC0516a
            public final void a(DialogInterface dialogInterface) {
                Interceptable interceptable2 = $ic;
                if (interceptable2 == null || interceptable2.invokeL(1048576, this, dialogInterface) == null) {
                    com.kwad.sdk.core.report.a.k(this.a.mAdTemplate, 104);
                    dialogInterface.dismiss();
                }
            }

            @Override // com.kwad.components.core.page.widget.a.InterfaceC0516a
            public final void b(DialogInterface dialogInterface) {
                Interceptable interceptable2 = $ic;
                if (interceptable2 == null || interceptable2.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, dialogInterface) == null) {
                    AdWebViewVideoActivityProxy.super.onBackPressed();
                    com.kwad.sdk.core.report.a.k(this.a.mAdTemplate, 105);
                }
            }

            @Override // com.kwad.components.core.page.widget.a.InterfaceC0516a
            public final void c(DialogInterface dialogInterface) {
                Interceptable interceptable2 = $ic;
                if (interceptable2 == null || interceptable2.invokeL(Constants.METHOD_SEND_USER_MSG, this, dialogInterface) == null) {
                    com.kwad.sdk.core.report.a.k(this.a.mAdTemplate, 106);
                    dialogInterface.dismiss();
                }
            }
        }) : (com.kwad.components.core.page.widget.a) invokeV.objValue;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public a.C0507a getAdClickConfig(boolean z) {
        InterceptResult invokeZ;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeZ = interceptable.invokeZ(65544, this, z)) == null) ? new a.C0507a(getActivity()).a(z).b(false).a(this.mAdTemplate).d(false) : (a.C0507a) invokeZ.objValue;
    }

    private void initView() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(65545, this) == null) {
            this.mProgressbar = (DownloadProgressBar) findViewById(R.id.obfuscated_res_0x7f0911ef);
            this.mWebDownloadContainer = (ViewGroup) findViewById(R.id.obfuscated_res_0x7f0911ee);
            AdInfo i = com.kwad.sdk.core.response.a.d.i(this.mAdTemplate);
            if (com.kwad.sdk.core.response.a.a.I(i)) {
                this.mWebDownloadContainer.setVisibility(0);
                this.mApkDownloadHelper = new com.kwad.components.core.c.a.b(this.mAdTemplate, new com.kwad.sdk.core.download.kwai.a(this, i) { // from class: com.kwad.components.core.page.AdWebViewVideoActivityProxy.1
                    public static /* synthetic */ Interceptable $ic;
                    public transient /* synthetic */ FieldHolder $fh;
                    public final /* synthetic */ AdInfo a;
                    public final /* synthetic */ AdWebViewVideoActivityProxy b;

                    {
                        Interceptable interceptable2 = $ic;
                        if (interceptable2 != null) {
                            InitContext newInitContext = TitanRuntime.newInitContext();
                            newInitContext.initArgs = r2;
                            Object[] objArr = {this, i};
                            interceptable2.invokeUnInit(65536, newInitContext);
                            int i2 = newInitContext.flag;
                            if ((i2 & 1) != 0) {
                                int i3 = i2 & 2;
                                newInitContext.thisArg = this;
                                interceptable2.invokeInitBody(65536, newInitContext);
                                return;
                            }
                        }
                        this.b = this;
                        this.a = i;
                    }

                    @Override // com.kwad.sdk.core.download.kwai.a
                    public final void a(int i2) {
                        Interceptable interceptable2 = $ic;
                        if (interceptable2 == null || interceptable2.invokeI(1048576, this, i2) == null) {
                            this.b.mProgressbar.setProgress(i2);
                            this.b.mProgressbar.setText(com.kwad.sdk.core.response.a.a.b(i2));
                        }
                    }

                    @Override // com.kwad.sdk.api.KsAppDownloadListener
                    public final void onDownloadFailed() {
                        Interceptable interceptable2 = $ic;
                        if (interceptable2 == null || interceptable2.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this) == null) {
                            this.b.mProgressbar.setProgress(100.0f);
                            this.b.mProgressbar.setText(com.kwad.sdk.core.response.a.a.H(this.a));
                        }
                    }

                    @Override // com.kwad.sdk.api.KsAppDownloadListener
                    public final void onDownloadFinished() {
                        Interceptable interceptable2 = $ic;
                        if (interceptable2 == null || interceptable2.invokeV(Constants.METHOD_SEND_USER_MSG, this) == null) {
                            this.b.mProgressbar.setProgress(100.0f);
                            this.b.mProgressbar.setText(com.kwad.sdk.core.response.a.a.a(this.b.mAdTemplate));
                        }
                    }

                    @Override // com.kwad.sdk.api.KsAppDownloadListener
                    public final void onIdle() {
                        Interceptable interceptable2 = $ic;
                        if (interceptable2 == null || interceptable2.invokeV(1048579, this) == null) {
                            this.b.mProgressbar.setProgress(100.0f);
                            this.b.mProgressbar.setText(com.kwad.sdk.core.response.a.a.H(this.a));
                        }
                    }

                    @Override // com.kwad.sdk.api.KsAppDownloadListener
                    public final void onInstalled() {
                        Interceptable interceptable2 = $ic;
                        if (interceptable2 == null || interceptable2.invokeV(1048580, this) == null) {
                            this.b.mProgressbar.setProgress(100.0f);
                            this.b.mProgressbar.setText(com.kwad.sdk.core.response.a.a.n(this.a));
                        }
                    }

                    @Override // com.kwad.sdk.api.KsAppDownloadListener
                    public final void onProgressUpdate(int i2) {
                        Interceptable interceptable2 = $ic;
                        if (interceptable2 == null || interceptable2.invokeI(1048581, this, i2) == null) {
                            this.b.mProgressbar.setProgress(i2);
                            this.b.mProgressbar.setText(com.kwad.sdk.core.response.a.a.a(i2));
                        }
                    }
                });
                this.mProgressbar.setOnClickListener(new View.OnClickListener(this) { // from class: com.kwad.components.core.page.AdWebViewVideoActivityProxy.2
                    public static /* synthetic */ Interceptable $ic;
                    public transient /* synthetic */ FieldHolder $fh;
                    public final /* synthetic */ AdWebViewVideoActivityProxy a;

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
                        this.a = this;
                    }

                    @Override // android.view.View.OnClickListener
                    public final void onClick(View view2) {
                        Interceptable interceptable2 = $ic;
                        if (interceptable2 == null || interceptable2.invokeL(1048576, this, view2) == null) {
                            this.a.mApkDownloadHelper.a(this.a.getAdClickConfig(true));
                        }
                    }
                });
            } else {
                this.mWebDownloadContainer.setVisibility(8);
            }
            List<AdInfo> list = this.mAdTemplate.adInfoList;
            String aC = (list == null || list.size() <= 0 || this.mAdTemplate.adInfoList.get(0) == null) ? "详情页面" : com.kwad.sdk.core.response.a.a.aC(com.kwad.sdk.core.response.a.d.i(this.mAdTemplate));
            com.kwad.components.core.kwai.a aVar = new com.kwad.components.core.kwai.a((ViewGroup) findViewById(R.id.obfuscated_res_0x7f09107b));
            this.mTitleBarHelper = aVar;
            aVar.a(new a.InterfaceC0513a(this) { // from class: com.kwad.components.core.page.AdWebViewVideoActivityProxy.3
                public static /* synthetic */ Interceptable $ic;
                public transient /* synthetic */ FieldHolder $fh;
                public final /* synthetic */ AdWebViewVideoActivityProxy a;

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
                    this.a = this;
                }

                @Override // com.kwad.components.core.kwai.a.InterfaceC0513a
                public final void a(View view2) {
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 == null || interceptable2.invokeL(1048576, this, view2) == null) {
                        this.a.onBackPressed();
                    }
                }

                @Override // com.kwad.components.core.kwai.a.InterfaceC0513a
                public final void b(View view2) {
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 == null || interceptable2.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, view2) == null) {
                        this.a.finish();
                    }
                }
            });
            this.mTitleBarHelper.a(new com.kwad.components.core.kwai.b(aC));
            ae.b(getActivity());
            e.a(getActivity(), 0, true);
            b a = b.a(this.mAdTemplate);
            this.mFragment = a;
            a.a(this.mApkDownloadHelper);
            getSupportFragmentManager().beginTransaction().replace(R.id.obfuscated_res_0x7f0910d2, this.mFragment).commitAllowingStateLoss();
        }
    }

    private boolean isFormAdExitInterceptEnable() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(65546, this)) == null) {
            if (this.mAdTemplate == null) {
                return false;
            }
            if (com.kwad.sdk.core.config.d.H() && this.mAdTemplate.mIsFromContent) {
                return true;
            }
            return com.kwad.sdk.core.config.d.I() && !this.mAdTemplate.mIsFromContent;
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

    @Override // com.kwad.components.core.h.b
    public String getPageName() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) ? "AdWebViewVideoActivityProxy" : (String) invokeV.objValue;
    }

    @Override // com.kwad.components.core.h.b, com.kwad.sdk.api.proxy.IActivityProxy
    public void onBackPressed() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this) == null) {
            b bVar = this.mFragment;
            if (bVar == null || !bVar.a()) {
                showWaitDialog();
            } else {
                super.onBackPressed();
            }
        }
    }

    @Override // com.kwad.components.core.h.b, com.kwad.sdk.api.proxy.IActivityProxy
    public void onCreate(Bundle bundle) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(Constants.METHOD_SEND_USER_MSG, this, bundle) == null) {
            super.onCreate(bundle);
            setContentView(R.layout.obfuscated_res_0x7f0d03f8);
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

    @Override // com.kwad.components.core.h.b, com.kwad.sdk.api.proxy.IActivityProxy
    public void onDestroy() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048579, this) == null) {
            Dialog dialog = this.mKsExitInterceptDialog;
            if (dialog != null && dialog.isShowing()) {
                this.mKsExitInterceptDialog.dismiss();
            }
            super.onDestroy();
            showingAdWebViewVideoActivity = false;
            com.kwad.components.core.c.a.b bVar = this.mApkDownloadHelper;
            if (bVar != null) {
                bVar.i();
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

    @Override // com.kwad.components.core.h.b, com.kwad.sdk.api.proxy.IActivityProxy
    public void onResume() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048581, this) == null) {
            super.onResume();
            showingAdWebViewVideoActivity = true;
        }
    }
}
