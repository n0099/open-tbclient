package com.kwad.sdk.core.download.a;

import android.app.Activity;
import android.app.AlertDialog;
import android.content.Context;
import android.graphics.drawable.ColorDrawable;
import android.os.Bundle;
import android.view.View;
import android.webkit.URLUtil;
import androidx.annotation.NonNull;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import com.kwad.sdk.api.loader.Wrapper;
import com.kwad.sdk.core.response.model.AdInfo;
import com.kwad.sdk.core.response.model.AdTemplate;
import com.kwad.sdk.utils.x;
/* loaded from: classes7.dex */
public class b extends AlertDialog {
    public static /* synthetic */ Interceptable $ic;

    /* renamed from: a  reason: collision with root package name */
    public static b f36029a;
    public transient /* synthetic */ FieldHolder $fh;

    /* renamed from: b  reason: collision with root package name */
    public a f36030b;

    /* renamed from: c  reason: collision with root package name */
    public AdTemplate f36031c;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public b(Activity activity, @NonNull AdTemplate adTemplate) {
        super(Wrapper.wrapContextIfNeed(activity));
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {activity, adTemplate};
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
        setOwnerActivity(activity);
        this.f36031c = adTemplate;
    }

    public static boolean a() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(65538, null)) == null) {
            b bVar = f36029a;
            if (bVar != null) {
                return bVar.isShowing();
            }
            return false;
        }
        return invokeV.booleanValue;
    }

    public static boolean a(@NonNull Context context, @NonNull AdTemplate adTemplate) {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(65539, null, context, adTemplate)) == null) {
            if (context instanceof Activity) {
                try {
                    if (f36029a == null) {
                        b bVar = new b((Activity) context, adTemplate);
                        f36029a = bVar;
                        bVar.getWindow().addFlags(1024);
                    }
                    if (f36029a.isShowing()) {
                        return true;
                    }
                    f36029a.show();
                    com.kwad.sdk.core.report.b.c(adTemplate, 86, null);
                    return true;
                } catch (Throwable th) {
                    com.kwad.sdk.core.d.a.a(th);
                    return false;
                }
            }
            return false;
        }
        return invokeLL.booleanValue;
    }

    public static boolean b(@NonNull Context context, @NonNull AdTemplate adTemplate) {
        InterceptResult invokeLL;
        AdInfo.DownloadSafeInfo Z;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(65540, null, context, adTemplate)) == null) {
            if (com.kwad.sdk.core.response.b.c.c(adTemplate) && (Z = com.kwad.sdk.core.response.b.a.Z(com.kwad.sdk.core.response.b.c.j(adTemplate))) != null && URLUtil.isNetworkUrl(Z.windowPopUrl)) {
                int i2 = Z.windowPopType;
                return i2 == 1 || (i2 == 2 && !com.ksad.download.d.b.b(context));
            }
            return false;
        }
        return invokeLL.booleanValue;
    }

    @Override // android.app.Dialog, android.content.DialogInterface
    public void dismiss() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
            super.dismiss();
            f36029a = null;
        }
    }

    @Override // android.app.Dialog
    public boolean isShowing() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this)) == null) ? super.isShowing() : invokeV.booleanValue;
    }

    @Override // android.app.Dialog
    public void onBackPressed() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this) == null) {
            super.onBackPressed();
            com.kwad.sdk.core.report.b.o(this.f36031c);
        }
    }

    @Override // android.app.AlertDialog, android.app.Dialog
    public void onCreate(Bundle bundle) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048579, this, bundle) == null) {
            super.onCreate(bundle);
            if (this.f36030b == null) {
                a aVar = new a(Wrapper.wrapContextIfNeed(getOwnerActivity()), this, this.f36031c, !x.e(getOwnerActivity()) ? 1 : 0);
                this.f36030b = aVar;
                aVar.setOnClickListener(new View.OnClickListener(this) { // from class: com.kwad.sdk.core.download.a.b.1
                    public static /* synthetic */ Interceptable $ic;
                    public transient /* synthetic */ FieldHolder $fh;

                    /* renamed from: a  reason: collision with root package name */
                    public final /* synthetic */ b f36032a;

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
                        this.f36032a = this;
                    }

                    @Override // android.view.View.OnClickListener
                    public void onClick(View view) {
                        Interceptable interceptable2 = $ic;
                        if (interceptable2 == null || interceptable2.invokeL(1048576, this, view) == null) {
                            com.kwad.sdk.core.report.b.o(this.f36032a.f36031c);
                            this.f36032a.dismiss();
                        }
                    }
                });
            }
            setContentView(this.f36030b);
            setCanceledOnTouchOutside(true);
            getWindow().getDecorView().setPadding(0, 0, 0, 0);
            getWindow().setBackgroundDrawable(new ColorDrawable(0));
            getWindow().setLayout(-1, -1);
        }
    }

    @Override // android.app.Dialog, android.view.Window.Callback
    public void onDetachedFromWindow() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048580, this) == null) {
            super.onDetachedFromWindow();
            a aVar = this.f36030b;
            if (aVar != null) {
                aVar.c();
            }
        }
    }

    @Override // android.app.Dialog
    public void onStart() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048581, this) == null) {
            super.onStart();
            b bVar = f36029a;
            if (bVar != null) {
                bVar.setTitle((CharSequence) null);
            }
        }
    }

    @Override // android.app.Dialog
    public void show() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048582, this) == null) {
            super.show();
        }
    }
}
