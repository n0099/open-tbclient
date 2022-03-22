package com.kwad.tachikoma;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.FrameLayout;
import android.widget.TextView;
import androidx.core.internal.view.SupportMenu;
import androidx.core.view.InputDeviceCompat;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.tieba.R;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import com.kuaishou.tachikoma.api.TKContext;
import com.kuaishou.tachikoma.api.TachikomaApi;
import com.kuaishou.tachikoma.api.app.IRenderListener;
import com.kwad.sdk.plugin.h;
import com.tachikoma.core.layout.TKLayout;
/* loaded from: classes7.dex */
public class d extends FrameLayout implements h {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public a a;

    /* renamed from: b  reason: collision with root package name */
    public TKLayout f41557b;

    /* renamed from: c  reason: collision with root package name */
    public TKContext f41558c;

    /* renamed from: d  reason: collision with root package name */
    public TextView f41559d;

    /* renamed from: e  reason: collision with root package name */
    public String f41560e;

    /* renamed from: f  reason: collision with root package name */
    public IRenderListener f41561f;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public d(Context context) {
        super(context);
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {context};
            interceptable.invokeUnInit(65536, newInitContext);
            int i = newInitContext.flag;
            if ((i & 1) != 0) {
                int i2 = i & 2;
                super((Context) newInitContext.callArgs[0]);
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
        this.f41561f = new IRenderListener(this) { // from class: com.kwad.tachikoma.d.1
            public static /* synthetic */ Interceptable $ic;
            public transient /* synthetic */ FieldHolder $fh;
            public final /* synthetic */ d a;

            {
                Interceptable interceptable2 = $ic;
                if (interceptable2 != null) {
                    InitContext newInitContext2 = TitanRuntime.newInitContext();
                    newInitContext2.initArgs = r2;
                    Object[] objArr2 = {this};
                    interceptable2.invokeUnInit(65536, newInitContext2);
                    int i3 = newInitContext2.flag;
                    if ((i3 & 1) != 0) {
                        int i4 = i3 & 2;
                        newInitContext2.thisArg = this;
                        interceptable2.invokeInitBody(65536, newInitContext2);
                        return;
                    }
                }
                this.a = this;
            }

            @Override // com.kuaishou.tachikoma.api.app.IRenderListener
            public void failed(Throwable th) {
                Interceptable interceptable2 = $ic;
                if (interceptable2 == null || interceptable2.invokeL(1048576, this, th) == null) {
                    com.kwad.sdk.core.d.a.a(th);
                }
            }

            @Override // com.kuaishou.tachikoma.api.app.IRenderListener
            public void success() {
                Interceptable interceptable2 = $ic;
                if (interceptable2 == null || interceptable2.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this) == null) {
                    this.a.d();
                }
            }
        };
        c();
    }

    private void b() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(65538, this) == null) {
            TKContext newTKJSContext = TachikomaApi.getInstance().newTKJSContext(this.f41557b);
            this.f41558c = newTKJSContext;
            this.a = new a(newTKJSContext, this.f41560e);
            this.f41558c.buildJsBridge().addJavascriptInterface(this.a, "KwaiAd");
        }
    }

    private void c() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(65539, this) == null) {
            LayoutInflater.from(getContext()).inflate(R.layout.obfuscated_res_0x7f0d0477, this);
            this.f41557b = (TKLayout) findViewById(R.id.obfuscated_res_0x7f09114f);
            b();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void d() {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeV(InputDeviceCompat.SOURCE_TRACKBALL, this) == null) && com.kwad.sdk.b.f39154c.booleanValue()) {
            if (this.f41559d == null) {
                TextView textView = new TextView(getContext());
                this.f41559d = textView;
                textView.setTextSize(12.0f);
                this.f41559d.setTextColor(SupportMenu.CATEGORY_MASK);
                addView(this.f41559d);
            }
            this.f41559d.setText("Tachikoma");
            this.f41559d.setVisibility(0);
        }
    }

    @Override // com.kwad.sdk.plugin.h
    public void a() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
            this.f41558c.onDestroy();
            this.f41558c = null;
        }
    }

    @Override // com.kwad.sdk.plugin.h
    public void a(com.kwad.sdk.core.webview.kwai.a aVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, aVar) == null) {
            this.a.a(aVar);
        }
    }

    @Override // com.kwad.sdk.plugin.h
    public void a(String str, String str2) {
        TKContext tKContext;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeLL(Constants.METHOD_SEND_USER_MSG, this, str, str2) == null) || (tKContext = this.f41558c) == null) {
            return;
        }
        tKContext.evaluateScript(str, "jsURL", str2, this.f41561f);
    }

    @Override // com.kwad.sdk.plugin.h
    public View getView() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048579, this)) == null) ? this : (View) invokeV.objValue;
    }

    public void setJsFileName(String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048580, this, str) == null) {
            this.f41560e = str;
        }
    }
}
