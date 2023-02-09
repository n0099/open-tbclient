package com.kwad.components.core.c.kwai;

import android.app.Activity;
import android.app.AlertDialog;
import android.content.Context;
import android.content.DialogInterface;
import android.graphics.drawable.ColorDrawable;
import android.os.Bundle;
import android.text.TextUtils;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.core.view.InputDeviceCompat;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import com.kwad.components.core.c.kwai.a;
import com.kwad.sdk.api.loader.Wrapper;
import com.kwad.sdk.core.response.model.AdTemplate;
import com.kwad.sdk.utils.bj;
import org.json.JSONObject;
/* loaded from: classes8.dex */
public final class b extends AlertDialog {
    public static /* synthetic */ Interceptable $ic;
    @Nullable
    public static b DG;
    public transient /* synthetic */ FieldHolder $fh;
    @NonNull
    public final C0600b DH;
    public com.kwad.components.core.c.kwai.a DK;
    public boolean DL;

    /* loaded from: classes8.dex */
    public static class a {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        @Nullable
        public DialogInterface.OnShowListener DN;
        @Nullable
        public DialogInterface.OnDismissListener DO;
        public AdTemplate adTemplate;
        @Nullable
        public Context context;
        public String url;

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

        public final a K(AdTemplate adTemplate) {
            InterceptResult invokeL;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeL = interceptable.invokeL(1048576, this, adTemplate)) == null) {
                this.adTemplate = adTemplate;
                return this;
            }
            return (a) invokeL.objValue;
        }

        public final a a(@Nullable DialogInterface.OnShowListener onShowListener) {
            InterceptResult invokeL;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeL = interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, onShowListener)) == null) {
                this.DN = onShowListener;
                return this;
            }
            return (a) invokeL.objValue;
        }

        public final a ah(Context context) {
            InterceptResult invokeL;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeL = interceptable.invokeL(Constants.METHOD_SEND_USER_MSG, this, context)) == null) {
                this.context = context;
                return this;
            }
            return (a) invokeL.objValue;
        }

        public final a ak(String str) {
            InterceptResult invokeL;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeL = interceptable.invokeL(1048579, this, str)) == null) {
                this.url = str;
                return this;
            }
            return (a) invokeL.objValue;
        }

        public final a c(@Nullable DialogInterface.OnDismissListener onDismissListener) {
            InterceptResult invokeL;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeL = interceptable.invokeL(1048580, this, onDismissListener)) == null) {
                this.DO = onDismissListener;
                return this;
            }
            return (a) invokeL.objValue;
        }

        public final C0600b ms() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeV = interceptable.invokeV(1048581, this)) == null) {
                if (com.kwad.components.core.a.aw.booleanValue() && (this.context == null || this.adTemplate == null || TextUtils.isEmpty(this.url))) {
                    throw new IllegalArgumentException("param is error, please check it");
                }
                return new C0600b(this, (byte) 0);
            }
            return (C0600b) invokeV.objValue;
        }
    }

    /* renamed from: com.kwad.components.core.c.kwai.b$b  reason: collision with other inner class name */
    /* loaded from: classes8.dex */
    public static class C0600b {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        @Nullable
        public DialogInterface.OnShowListener DN;
        @Nullable
        public DialogInterface.OnDismissListener DO;
        public final AdTemplate adTemplate;
        public Context context;
        public String url;

        public C0600b(a aVar) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {aVar};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.context = aVar.context;
            this.adTemplate = aVar.adTemplate;
            this.url = aVar.url;
            this.DN = aVar.DN;
            this.DO = aVar.DO;
        }

        public /* synthetic */ C0600b(a aVar, byte b) {
            this(aVar);
        }
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public b(Activity activity, C0600b c0600b) {
        super(activity);
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {activity, c0600b};
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
        this.DL = false;
        setOwnerActivity(activity);
        this.DH = c0600b;
        c0600b.context = Wrapper.wrapContextIfNeed(c0600b.context);
        if (com.kwad.sdk.b.kwai.a.a(activity)) {
            getWindow().addFlags(1024);
        }
        setOnShowListener(c0600b.DN);
        setOnDismissListener(c0600b.DO);
    }

    public static boolean a(C0600b c0600b) {
        InterceptResult invokeL;
        Activity dB;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65537, null, c0600b)) == null) {
            b bVar = DG;
            if ((bVar != null && bVar.isShowing()) || (dB = bj.dB(c0600b.context)) == null || dB.isFinishing()) {
                return false;
            }
            com.kwad.sdk.kwai.kwai.c.rd().dismiss();
            try {
                b bVar2 = new b(dB, c0600b);
                DG = bVar2;
                bVar2.show();
                com.kwad.sdk.core.report.a.c(c0600b.adTemplate, 86, (JSONObject) null);
                return true;
            } catch (Throwable th) {
                com.kwad.sdk.core.e.b.printStackTrace(th);
                return false;
            }
        }
        return invokeL.booleanValue;
    }

    public static boolean mq() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(65538, null)) == null) {
            b bVar = DG;
            if (bVar != null) {
                return bVar.isShowing();
            }
            return false;
        }
        return invokeV.booleanValue;
    }

    public final void ai(boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(1048576, this, z) == null) {
            this.DL = z;
            dismiss();
        }
    }

    @Override // android.app.Dialog, android.content.DialogInterface
    public final void dismiss() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this) == null) {
            super.dismiss();
            DG = null;
        }
    }

    @Override // android.app.Dialog
    public final boolean isShowing() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this)) == null) ? super.isShowing() : invokeV.booleanValue;
    }

    public final boolean mr() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048579, this)) == null) ? this.DL : invokeV.booleanValue;
    }

    @Override // android.app.Dialog
    public final void onBackPressed() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048580, this) == null) {
            super.onBackPressed();
            com.kwad.sdk.core.report.a.aB(this.DH.adTemplate);
        }
    }

    @Override // android.app.AlertDialog, android.app.Dialog
    public final void onCreate(Bundle bundle) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048581, this, bundle) == null) {
            super.onCreate(bundle);
            if (this.DK == null) {
                com.kwad.components.core.c.kwai.a aVar = new com.kwad.components.core.c.kwai.a(this, this.DH);
                this.DK = aVar;
                aVar.setChangeListener(new a.InterfaceC0599a(this) { // from class: com.kwad.components.core.c.kwai.b.1
                    public static /* synthetic */ Interceptable $ic;
                    public transient /* synthetic */ FieldHolder $fh;
                    public final /* synthetic */ b DM;

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
                        this.DM = this;
                    }

                    @Override // com.kwad.components.core.c.kwai.a.InterfaceC0599a
                    public final void mp() {
                        Interceptable interceptable2 = $ic;
                        if (interceptable2 == null || interceptable2.invokeV(1048576, this) == null) {
                            this.DM.dismiss();
                        }
                    }
                });
            }
            setContentView(this.DK);
            setCanceledOnTouchOutside(true);
            getWindow().getDecorView().setPadding(0, 0, 0, 0);
            getWindow().setBackgroundDrawable(new ColorDrawable(0));
            getWindow().setLayout(-1, -1);
        }
    }

    @Override // android.app.Dialog, android.view.Window.Callback
    public final void onDetachedFromWindow() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048582, this) == null) {
            super.onDetachedFromWindow();
            DG = null;
        }
    }

    @Override // android.app.Dialog
    public final void onStart() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048583, this) == null) {
            super.onStart();
            b bVar = DG;
            if (bVar != null) {
                bVar.setTitle((CharSequence) null);
            }
        }
    }

    @Override // android.app.Dialog
    public final void show() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(InputDeviceCompat.SOURCE_TOUCHPAD, this) == null) {
            try {
                super.show();
            } catch (Exception e) {
                com.kwad.sdk.core.e.b.printStackTraceOnly(e);
            }
        }
    }
}
