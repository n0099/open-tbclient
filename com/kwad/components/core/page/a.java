package com.kwad.components.core.page;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import androidx.annotation.Nullable;
import androidx.core.view.InputDeviceCompat;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.tieba.R;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import com.ksad.annotation.invoker.InvokeBy;
import com.kwad.components.core.kwai.a;
import com.kwad.components.core.playable.PlayableSource;
import com.kwad.components.core.webview.KsAdWebView;
import com.kwad.components.core.webview.jshandler.x;
import com.kwad.sdk.KsAdSDKImpl;
import com.kwad.sdk.api.proxy.app.BaseFragmentActivity;
import com.kwad.sdk.core.response.model.AdTemplate;
import com.kwad.sdk.core.view.AdBaseFrameLayout;
import org.json.JSONObject;
/* loaded from: classes7.dex */
public class a extends com.kwad.components.core.i.b implements a.InterfaceC0580a, x.b {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public boolean Fu;
    public AdTemplate mAdTemplate;
    public com.kwad.components.core.c.a.c mApkDownloadHelper;
    public AdBaseFrameLayout mRootContainer;
    public com.kwad.components.core.kwai.a mTitleBarHelper;
    public com.kwad.components.core.playable.a mk;

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
                return;
            }
        }
        this.Fu = true;
    }

    private void d(Intent intent) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(65537, this, intent) == null) {
            String stringExtra = intent.getStringExtra("key_template_json");
            if (TextUtils.isEmpty(stringExtra)) {
                return;
            }
            try {
                this.mAdTemplate = new AdTemplate();
                this.mAdTemplate.parseJson(new JSONObject(stringExtra));
                this.mApkDownloadHelper = new com.kwad.components.core.c.a.c(this.mAdTemplate);
            } catch (Exception e) {
                com.kwad.sdk.core.e.b.printStackTraceOnly(e);
            }
        }
    }

    public static void launch(Context context, AdTemplate adTemplate) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(65538, null, context, adTemplate) == null) {
            KsAdSDKImpl.putComponentProxy(BaseFragmentActivity.FragmentActivity8.class, a.class);
            Intent intent = new Intent(context, BaseFragmentActivity.FragmentActivity8.class);
            intent.putExtra("key_template_json", adTemplate.toJson().toString());
            context.startActivity(intent);
        }
    }

    private void nv() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(65539, this) == null) {
            com.kwad.components.core.kwai.a aVar = new com.kwad.components.core.kwai.a(this.mRootContainer);
            this.mTitleBarHelper = aVar;
            aVar.a(this);
            this.mTitleBarHelper.a(new com.kwad.components.core.kwai.b(""));
        }
    }

    @InvokeBy(invokerClass = KsAdSDKImpl.class, methodId = KsAdSDKImpl.INVOKER_ID_INIT_COMPONENT_PROXY)
    public static void register() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(InputDeviceCompat.SOURCE_TRACKBALL, null) == null) {
            KsAdSDKImpl.putComponentProxy(BaseFragmentActivity.FragmentActivity8.class, a.class);
        }
    }

    @Override // com.kwad.components.core.webview.jshandler.x.b
    public final void a(x.a aVar) {
        com.kwad.components.core.playable.a aVar2;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048576, this, aVar) == null) {
            com.kwad.sdk.core.e.b.d("AdPlayableActivityProxy", "updatePageStatus status: " + aVar);
            if (aVar.status != 1 || (aVar2 = this.mk) == null) {
                return;
            }
            aVar2.e(PlayableSource.UNKNOWN_TRYPLAY_ENTRY_SOURCE);
        }
    }

    @Override // com.kwad.components.core.i.b
    public String getPageName() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this)) == null) ? "AdPlayableActivityProxy" : (String) invokeV.objValue;
    }

    @Override // com.kwad.components.core.i.b, com.kwad.sdk.api.proxy.IActivityProxy
    public void onCreate(@Nullable Bundle bundle) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(Constants.METHOD_SEND_USER_MSG, this, bundle) == null) {
            super.onCreate(bundle);
            getActivity().setTheme(R.style.obfuscated_res_0x7f10022f);
            setContentView(R.layout.obfuscated_res_0x7f0d0406);
            d(getIntent());
            this.mRootContainer = (AdBaseFrameLayout) findViewById(R.id.obfuscated_res_0x7f091132);
            nv();
            com.kwad.components.core.playable.a aVar = new com.kwad.components.core.playable.a((KsAdWebView) findViewById(R.id.obfuscated_res_0x7f091137));
            this.mk = aVar;
            aVar.a(this.mAdTemplate, this.mRootContainer, this.mApkDownloadHelper);
            this.mk.a(this);
            this.mk.oc();
        }
    }

    @Override // com.kwad.components.core.i.b, com.kwad.sdk.api.proxy.IActivityProxy
    public void onDestroy() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048579, this) == null) {
            super.onDestroy();
            this.mk.b(this);
        }
    }

    @Override // com.kwad.sdk.api.proxy.IActivityProxy
    public void onPause() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048580, this) == null) {
            super.onPause();
        }
    }

    @Override // com.kwad.sdk.api.proxy.IActivityProxy
    public void onRestart() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048581, this) == null) {
            super.onRestart();
        }
    }

    @Override // com.kwad.components.core.i.b, com.kwad.sdk.api.proxy.IActivityProxy
    public void onResume() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048582, this) == null) {
            super.onResume();
        }
    }

    @Override // com.kwad.components.core.kwai.a.InterfaceC0580a
    public final void r(View view2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048583, this, view2) == null) {
            onBackPressed();
        }
    }

    @Override // com.kwad.components.core.kwai.a.InterfaceC0580a
    public final void s(View view2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(InputDeviceCompat.SOURCE_TOUCHPAD, this, view2) == null) {
            finish();
        }
    }
}
