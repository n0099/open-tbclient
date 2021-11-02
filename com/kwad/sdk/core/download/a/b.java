package com.kwad.sdk.core.download.a;

import android.app.Activity;
import android.app.AlertDialog;
import android.content.Context;
import android.content.DialogInterface;
import android.graphics.drawable.ColorDrawable;
import android.os.Bundle;
import android.view.View;
import android.webkit.URLUtil;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.core.view.InputDeviceCompat;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.mobads.container.util.AdIconUtil;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import com.kwad.sdk.api.core.ResContext;
import com.kwad.sdk.api.loader.Wrapper;
import com.kwad.sdk.core.response.model.AdInfo;
import com.kwad.sdk.core.response.model.AdTemplate;
import com.kwad.sdk.utils.ab;
/* loaded from: classes2.dex */
public class b extends AlertDialog {
    public static /* synthetic */ Interceptable $ic;

    /* renamed from: a  reason: collision with root package name */
    public static b f64453a;
    public transient /* synthetic */ FieldHolder $fh;

    /* renamed from: b  reason: collision with root package name */
    public String f64454b;

    /* renamed from: c  reason: collision with root package name */
    public a f64455c;

    /* renamed from: d  reason: collision with root package name */
    public AdTemplate f64456d;

    /* renamed from: e  reason: collision with root package name */
    public boolean f64457e;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public b(Activity activity, @NonNull AdTemplate adTemplate, String str) {
        super(Wrapper.wrapContextIfNeed(activity));
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {activity, adTemplate, str};
            interceptable.invokeUnInit(65536, newInitContext);
            int i2 = newInitContext.flag;
            if ((i2 & 1) != 0) {
                int i3 = i2 & 2;
                super((Context) newInitContext.callArgs[0]);
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
        this.f64457e = false;
        setOwnerActivity(activity);
        this.f64456d = adTemplate;
        this.f64454b = str;
    }

    public static b a(Activity activity, AdTemplate adTemplate, String str) {
        InterceptResult invokeLLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLLL = interceptable.invokeLLL(65537, null, activity, adTemplate, str)) == null) {
            b bVar = new b(activity, adTemplate, str);
            bVar.getWindow().addFlags(1024);
            return bVar;
        }
        return (b) invokeLLL.objValue;
    }

    public static boolean a() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(65539, null)) == null) {
            b bVar = f64453a;
            if (bVar != null) {
                return bVar.isShowing();
            }
            return false;
        }
        return invokeV.booleanValue;
    }

    public static boolean a(@NonNull Context context, @NonNull AdTemplate adTemplate) {
        InterceptResult invokeLL;
        AdInfo.DownloadSafeInfo V;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(InputDeviceCompat.SOURCE_TRACKBALL, null, context, adTemplate)) == null) {
            if (com.kwad.sdk.core.response.b.c.b(adTemplate) && (V = com.kwad.sdk.core.response.b.a.V(com.kwad.sdk.core.response.b.c.i(adTemplate))) != null && URLUtil.isNetworkUrl(V.windowPopUrl)) {
                int i2 = V.windowPopType;
                return i2 == 1 || (i2 == 2 && !com.ksad.download.d.b.b(context));
            }
            return false;
        }
        return invokeLL.booleanValue;
    }

    public static boolean a(@NonNull Context context, @NonNull AdTemplate adTemplate, @Nullable String str) {
        InterceptResult invokeLLL;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeLLL = interceptable.invokeLLL(AdIconUtil.AD_TEXT_ID, null, context, adTemplate, str)) == null) ? a(context, adTemplate, str, null, null) : invokeLLL.booleanValue;
    }

    public static boolean a(@NonNull Context context, @NonNull AdTemplate adTemplate, @Nullable String str, @Nullable DialogInterface.OnShowListener onShowListener, @Nullable DialogInterface.OnDismissListener onDismissListener) {
        InterceptResult invokeLLLLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLLLLL = interceptable.invokeLLLLL(AdIconUtil.BAIDU_LOGO_ID, null, context, adTemplate, str, onShowListener, onDismissListener)) == null) {
            if (context instanceof ResContext) {
                context = ((ResContext) context).getDelegatedContext();
            }
            if (context instanceof Activity) {
                try {
                    if (f64453a == null) {
                        b a2 = a((Activity) context, adTemplate, str);
                        f64453a = a2;
                        if (onShowListener != null) {
                            a2.setOnShowListener(onShowListener);
                        }
                        if (onDismissListener != null) {
                            f64453a.setOnDismissListener(onDismissListener);
                        }
                    }
                    if (f64453a.isShowing()) {
                        return true;
                    }
                    f64453a.show();
                    com.kwad.sdk.core.report.a.c(adTemplate, 86, null);
                    return true;
                } catch (Throwable th) {
                    com.kwad.sdk.core.d.a.a(th);
                    return false;
                }
            }
            return false;
        }
        return invokeLLLLL.booleanValue;
    }

    public void a(boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(1048576, this, z) == null) {
            this.f64457e = z;
            dismiss();
        }
    }

    public boolean b() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this)) == null) ? this.f64457e : invokeV.booleanValue;
    }

    @Override // android.app.Dialog, android.content.DialogInterface
    public void dismiss() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this) == null) {
            super.dismiss();
            f64453a = null;
        }
    }

    @Override // android.app.Dialog
    public boolean isShowing() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048579, this)) == null) ? super.isShowing() : invokeV.booleanValue;
    }

    @Override // android.app.Dialog
    public void onBackPressed() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048580, this) == null) {
            super.onBackPressed();
            com.kwad.sdk.core.report.a.n(this.f64456d);
        }
    }

    @Override // android.app.AlertDialog, android.app.Dialog
    public void onCreate(Bundle bundle) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048581, this, bundle) == null) {
            super.onCreate(bundle);
            if (this.f64455c == null) {
                a aVar = new a(Wrapper.wrapContextIfNeed(getOwnerActivity()), this, this.f64456d, !ab.e(getOwnerActivity()) ? 1 : 0, this.f64454b);
                this.f64455c = aVar;
                aVar.setOnClickListener(new View.OnClickListener(this) { // from class: com.kwad.sdk.core.download.a.b.1
                    public static /* synthetic */ Interceptable $ic;
                    public transient /* synthetic */ FieldHolder $fh;

                    /* renamed from: a  reason: collision with root package name */
                    public final /* synthetic */ b f64458a;

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
                        this.f64458a = this;
                    }

                    @Override // android.view.View.OnClickListener
                    public void onClick(View view) {
                        Interceptable interceptable2 = $ic;
                        if (interceptable2 == null || interceptable2.invokeL(1048576, this, view) == null) {
                            com.kwad.sdk.core.report.a.n(this.f64458a.f64456d);
                            this.f64458a.dismiss();
                        }
                    }
                });
            }
            setContentView(this.f64455c);
            setCanceledOnTouchOutside(true);
            getWindow().getDecorView().setPadding(0, 0, 0, 0);
            getWindow().setBackgroundDrawable(new ColorDrawable(0));
            getWindow().setLayout(-1, -1);
        }
    }

    @Override // android.app.Dialog, android.view.Window.Callback
    public void onDetachedFromWindow() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048582, this) == null) {
            super.onDetachedFromWindow();
            a aVar = this.f64455c;
            if (aVar != null) {
                aVar.c();
            }
            f64453a = null;
        }
    }

    @Override // android.app.Dialog
    public void onStart() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048583, this) == null) {
            super.onStart();
            b bVar = f64453a;
            if (bVar != null) {
                bVar.setTitle((CharSequence) null);
            }
        }
    }

    @Override // android.app.Dialog
    public void show() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(InputDeviceCompat.SOURCE_TOUCHPAD, this) == null) {
            super.show();
        }
    }
}
