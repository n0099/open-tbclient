package com.kwad.sdk.core.page;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.text.TextUtils;
import androidx.annotation.Nullable;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import com.kwad.sdk.KsAdSDKImpl;
import com.kwad.sdk.R;
import com.kwad.sdk.api.proxy.app.BaseFragmentActivity;
import com.kwad.sdk.core.page.widget.webview.KsAdWebView;
import com.kwad.sdk.core.response.model.AdTemplate;
import com.kwad.sdk.core.view.AdBaseFrameLayout;
import com.kwad.sdk.core.webview.jshandler.p;
import com.kwad.sdk.widget.e;
import org.json.JSONObject;
/* loaded from: classes2.dex */
public class a extends com.kwad.sdk.h.b implements p.b {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public AdBaseFrameLayout a;

    /* renamed from: b  reason: collision with root package name */
    public e f57531b;

    /* renamed from: c  reason: collision with root package name */
    public AdTemplate f57532c;

    /* renamed from: d  reason: collision with root package name */
    public com.kwad.sdk.core.download.a.b f57533d;

    /* renamed from: e  reason: collision with root package name */
    public boolean f57534e;

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
        this.f57534e = true;
    }

    public static void a(Context context, AdTemplate adTemplate) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(65537, null, context, adTemplate) == null) {
            KsAdSDKImpl.putComponentProxy(BaseFragmentActivity.FragmentActivity8.class, a.class);
            Intent intent = new Intent(context, BaseFragmentActivity.FragmentActivity8.class);
            intent.putExtra("key_template_json", adTemplate.toJson().toString());
            context.startActivity(intent);
        }
    }

    private void a(Intent intent) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(65538, this, intent) == null) {
            String stringExtra = intent.getStringExtra("key_template_json");
            if (TextUtils.isEmpty(stringExtra)) {
                return;
            }
            try {
                this.f57532c = new AdTemplate();
                this.f57532c.parseJson(new JSONObject(stringExtra));
                this.f57533d = new com.kwad.sdk.core.download.a.b(this.f57532c);
            } catch (Exception e2) {
                com.kwad.sdk.core.d.a.b(e2);
            }
        }
    }

    @Override // com.kwad.sdk.core.webview.jshandler.p.b
    public void a(p.a aVar) {
        e eVar;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048576, this, aVar) == null) {
            com.kwad.sdk.core.d.a.a("AdPlayableActivityProxy", "updatePageStatus status: " + aVar);
            if (aVar.a != 1 || (eVar = this.f57531b) == null) {
                return;
            }
            eVar.c();
        }
    }

    @Override // com.kwad.sdk.h.b
    public String getPageName() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this)) == null) ? "AdPlayableActivityProxy" : (String) invokeV.objValue;
    }

    @Override // com.kwad.sdk.h.b, com.kwad.sdk.api.proxy.IActivityProxy
    public void onCreate(@Nullable Bundle bundle) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(Constants.METHOD_SEND_USER_MSG, this, bundle) == null) {
            super.onCreate(bundle);
            setContentView(R.layout.ksad_activity_playable);
            a(getIntent());
            this.a = (AdBaseFrameLayout) findViewById(R.id.ksad_playable_activity_root);
            e eVar = new e((KsAdWebView) findViewById(R.id.ksad_playable_webview));
            this.f57531b = eVar;
            eVar.a(this.f57532c, this.a, this.f57533d);
            this.f57531b.a(this);
            this.f57531b.b();
        }
    }

    @Override // com.kwad.sdk.h.b, com.kwad.sdk.api.proxy.IActivityProxy
    public void onDestroy() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048579, this) == null) {
            super.onDestroy();
            this.f57531b.a((p.b) null);
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

    @Override // com.kwad.sdk.h.b, com.kwad.sdk.api.proxy.IActivityProxy
    public void onResume() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048582, this) == null) {
            super.onResume();
        }
    }
}
