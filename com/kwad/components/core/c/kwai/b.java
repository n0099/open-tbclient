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
import com.kwad.sdk.utils.bf;
import org.json.JSONObject;
/* loaded from: classes5.dex */
public final class b extends AlertDialog {
    public static /* synthetic */ Interceptable $ic;
    @Nullable
    public static b a;
    public transient /* synthetic */ FieldHolder $fh;
    @NonNull
    public final C0509b b;
    public com.kwad.components.core.c.kwai.a c;
    public boolean d;

    /* loaded from: classes5.dex */
    public static class a {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        @Nullable
        public Context a;
        public AdTemplate b;
        public String c;
        @Nullable
        public DialogInterface.OnShowListener d;
        @Nullable
        public DialogInterface.OnDismissListener e;

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

        public final a a(Context context) {
            InterceptResult invokeL;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeL = interceptable.invokeL(1048576, this, context)) == null) {
                this.a = context;
                return this;
            }
            return (a) invokeL.objValue;
        }

        public final a a(@Nullable DialogInterface.OnDismissListener onDismissListener) {
            InterceptResult invokeL;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeL = interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, onDismissListener)) == null) {
                this.e = onDismissListener;
                return this;
            }
            return (a) invokeL.objValue;
        }

        public final a a(@Nullable DialogInterface.OnShowListener onShowListener) {
            InterceptResult invokeL;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeL = interceptable.invokeL(Constants.METHOD_SEND_USER_MSG, this, onShowListener)) == null) {
                this.d = onShowListener;
                return this;
            }
            return (a) invokeL.objValue;
        }

        public final a a(AdTemplate adTemplate) {
            InterceptResult invokeL;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeL = interceptable.invokeL(1048579, this, adTemplate)) == null) {
                this.b = adTemplate;
                return this;
            }
            return (a) invokeL.objValue;
        }

        public final a a(String str) {
            InterceptResult invokeL;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeL = interceptable.invokeL(1048580, this, str)) == null) {
                this.c = str;
                return this;
            }
            return (a) invokeL.objValue;
        }

        public final C0509b a() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeV = interceptable.invokeV(1048581, this)) == null) {
                if (com.kwad.components.core.a.c.booleanValue() && (this.a == null || this.b == null || TextUtils.isEmpty(this.c))) {
                    throw new IllegalArgumentException("param is error, please check it");
                }
                return new C0509b(this, (byte) 0);
            }
            return (C0509b) invokeV.objValue;
        }
    }

    /* renamed from: com.kwad.components.core.c.kwai.b$b  reason: collision with other inner class name */
    /* loaded from: classes5.dex */
    public static class C0509b {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public Context a;
        public final AdTemplate b;
        public String c;
        @Nullable
        public DialogInterface.OnShowListener d;
        @Nullable
        public DialogInterface.OnDismissListener e;

        public C0509b(a aVar) {
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
            this.a = aVar.a;
            this.b = aVar.b;
            this.c = aVar.c;
            this.d = aVar.d;
            this.e = aVar.e;
        }

        public /* synthetic */ C0509b(a aVar, byte b) {
            this(aVar);
        }
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public b(Activity activity, C0509b c0509b) {
        super(activity);
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {activity, c0509b};
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
        this.d = false;
        setOwnerActivity(activity);
        this.b = c0509b;
        c0509b.a = Wrapper.wrapContextIfNeed(c0509b.a);
        if (com.kwad.sdk.b.kwai.a.a(activity)) {
            getWindow().addFlags(1024);
        }
        setOnShowListener(c0509b.d);
        setOnDismissListener(c0509b.e);
    }

    public static boolean a() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(65537, null)) == null) {
            b bVar = a;
            if (bVar != null) {
                return bVar.isShowing();
            }
            return false;
        }
        return invokeV.booleanValue;
    }

    public static boolean a(C0509b c0509b) {
        InterceptResult invokeL;
        Activity b;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65538, null, c0509b)) == null) {
            b bVar = a;
            if ((bVar != null && bVar.isShowing()) || (b = bf.b(c0509b.a)) == null || b.isFinishing()) {
                return false;
            }
            com.kwad.sdk.kwai.kwai.b.a().d();
            try {
                b bVar2 = new b(b, c0509b);
                a = bVar2;
                bVar2.show();
                com.kwad.sdk.core.report.a.c(c0509b.b, 86, (JSONObject) null);
                return true;
            } catch (Throwable th) {
                com.kwad.sdk.core.d.b.a(th);
                return false;
            }
        }
        return invokeL.booleanValue;
    }

    public final void a(boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(1048576, this, z) == null) {
            this.d = z;
            dismiss();
        }
    }

    public final boolean b() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this)) == null) ? this.d : invokeV.booleanValue;
    }

    @Override // android.app.Dialog, android.content.DialogInterface
    public final void dismiss() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this) == null) {
            super.dismiss();
            a = null;
        }
    }

    @Override // android.app.Dialog
    public final boolean isShowing() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048579, this)) == null) ? super.isShowing() : invokeV.booleanValue;
    }

    @Override // android.app.Dialog
    public final void onBackPressed() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048580, this) == null) {
            super.onBackPressed();
            com.kwad.sdk.core.report.a.m(this.b.b);
        }
    }

    @Override // android.app.AlertDialog, android.app.Dialog
    public final void onCreate(Bundle bundle) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048581, this, bundle) == null) {
            super.onCreate(bundle);
            if (this.c == null) {
                com.kwad.components.core.c.kwai.a aVar = new com.kwad.components.core.c.kwai.a(this, this.b);
                this.c = aVar;
                aVar.setChangeListener(new a.InterfaceC0508a(this) { // from class: com.kwad.components.core.c.kwai.b.1
                    public static /* synthetic */ Interceptable $ic;
                    public transient /* synthetic */ FieldHolder $fh;
                    public final /* synthetic */ b a;

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

                    @Override // com.kwad.components.core.c.kwai.a.InterfaceC0508a
                    public final void a() {
                        Interceptable interceptable2 = $ic;
                        if (interceptable2 == null || interceptable2.invokeV(1048576, this) == null) {
                            this.a.dismiss();
                        }
                    }
                });
            }
            setContentView(this.c);
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
            a = null;
        }
    }

    @Override // android.app.Dialog
    public final void onStart() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048583, this) == null) {
            super.onStart();
            b bVar = a;
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
                com.kwad.sdk.core.d.b.b(e);
            }
        }
    }
}
