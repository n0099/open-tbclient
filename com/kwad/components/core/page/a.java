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
import com.kwad.components.core.webview.jshandler.u;
import com.kwad.sdk.KsAdSDKImpl;
import com.kwad.sdk.api.proxy.app.BaseFragmentActivity;
import com.kwad.sdk.core.response.model.AdTemplate;
import com.kwad.sdk.core.view.AdBaseFrameLayout;
import org.json.JSONObject;
/* loaded from: classes5.dex */
public class a extends com.kwad.components.core.h.b implements a.InterfaceC0513a, u.b {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public AdBaseFrameLayout a;
    public com.kwad.components.core.playable.a b;
    public AdTemplate c;
    public com.kwad.components.core.c.a.b d;
    public boolean e;
    public com.kwad.components.core.kwai.a f;

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
        this.e = true;
    }

    @InvokeBy(invokerClass = KsAdSDKImpl.class, methodId = KsAdSDKImpl.INVOKER_ID_INIT_COMPONENT_PROXY)
    public static void a() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(65537, null) == null) {
            KsAdSDKImpl.putComponentProxy(BaseFragmentActivity.FragmentActivity8.class, a.class);
        }
    }

    public static void a(Context context, AdTemplate adTemplate) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(65538, null, context, adTemplate) == null) {
            KsAdSDKImpl.putComponentProxy(BaseFragmentActivity.FragmentActivity8.class, a.class);
            Intent intent = new Intent(context, BaseFragmentActivity.FragmentActivity8.class);
            intent.putExtra("key_template_json", adTemplate.toJson().toString());
            context.startActivity(intent);
        }
    }

    private void a(Intent intent) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(65539, this, intent) == null) {
            String stringExtra = intent.getStringExtra("key_template_json");
            if (TextUtils.isEmpty(stringExtra)) {
                return;
            }
            try {
                this.c = new AdTemplate();
                this.c.parseJson(new JSONObject(stringExtra));
                this.d = new com.kwad.components.core.c.a.b(this.c);
            } catch (Exception e) {
                com.kwad.sdk.core.d.b.b(e);
            }
        }
    }

    private void b() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(InputDeviceCompat.SOURCE_TRACKBALL, this) == null) {
            com.kwad.components.core.kwai.a aVar = new com.kwad.components.core.kwai.a(this.a);
            this.f = aVar;
            aVar.a(this);
            this.f.a(new com.kwad.components.core.kwai.b(""));
        }
    }

    @Override // com.kwad.components.core.kwai.a.InterfaceC0513a
    public final void a(View view2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048576, this, view2) == null) {
            onBackPressed();
        }
    }

    @Override // com.kwad.components.core.webview.jshandler.u.b
    public final void a(u.a aVar) {
        com.kwad.components.core.playable.a aVar2;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, aVar) == null) {
            com.kwad.sdk.core.d.b.a("AdPlayableActivityProxy", "updatePageStatus status: " + aVar);
            if (aVar.a != 1 || (aVar2 = this.b) == null) {
                return;
            }
            aVar2.a(PlayableSource.UNKNOWN_TRYPLAY_ENTRY_SOURCE);
        }
    }

    @Override // com.kwad.components.core.kwai.a.InterfaceC0513a
    public final void b(View view2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(Constants.METHOD_SEND_USER_MSG, this, view2) == null) {
            finish();
        }
    }

    @Override // com.kwad.components.core.h.b
    public String getPageName() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048579, this)) == null) ? "AdPlayableActivityProxy" : (String) invokeV.objValue;
    }

    @Override // com.kwad.components.core.h.b, com.kwad.sdk.api.proxy.IActivityProxy
    public void onCreate(@Nullable Bundle bundle) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048580, this, bundle) == null) {
            super.onCreate(bundle);
            getActivity().setTheme(R.style.obfuscated_res_0x7f100227);
            setContentView(R.layout.obfuscated_res_0x7f0d03fe);
            a(getIntent());
            this.a = (AdBaseFrameLayout) findViewById(R.id.obfuscated_res_0x7f0910c2);
            b();
            com.kwad.components.core.playable.a aVar = new com.kwad.components.core.playable.a((KsAdWebView) findViewById(R.id.obfuscated_res_0x7f0910c7));
            this.b = aVar;
            aVar.a(this.c, this.a, this.d);
            this.b.a(this);
            this.b.b();
        }
    }

    @Override // com.kwad.components.core.h.b, com.kwad.sdk.api.proxy.IActivityProxy
    public void onDestroy() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048581, this) == null) {
            super.onDestroy();
            this.b.b(this);
        }
    }

    @Override // com.kwad.sdk.api.proxy.IActivityProxy
    public void onPause() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048582, this) == null) {
            super.onPause();
        }
    }

    @Override // com.kwad.sdk.api.proxy.IActivityProxy
    public void onRestart() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048583, this) == null) {
            super.onRestart();
        }
    }

    @Override // com.kwad.components.core.h.b, com.kwad.sdk.api.proxy.IActivityProxy
    public void onResume() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(InputDeviceCompat.SOURCE_TOUCHPAD, this) == null) {
            super.onResume();
        }
    }
}
