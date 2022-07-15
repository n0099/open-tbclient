package com.repackage;

import android.app.Activity;
import android.content.DialogInterface;
import android.view.View;
import androidx.annotation.NonNull;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.nadcore.download.view.DefaultDownloadViewLP;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import java.lang.ref.WeakReference;
/* loaded from: classes5.dex */
public class dj0 extends ej0 implements View.OnClickListener {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public boolean f;
    public zi0 g;

    /* loaded from: classes5.dex */
    public class a implements DialogInterface.OnDismissListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ dj0 a;

        public a(dj0 dj0Var) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {dj0Var};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = dj0Var;
        }

        @Override // android.content.DialogInterface.OnDismissListener
        public void onDismiss(DialogInterface dialogInterface) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, dialogInterface) == null) {
                this.a.e.clear();
                this.a.e = null;
            }
        }
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    /* JADX WARN: Type inference failed for: r8v1, types: [android.view.View] */
    public dj0(@NonNull si0 si0Var, @NonNull kj0<?> kj0Var) {
        super(si0Var, kj0Var);
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {si0Var, kj0Var};
            interceptable.invokeUnInit(65536, newInitContext);
            int i = newInitContext.flag;
            if ((i & 1) != 0) {
                int i2 = i & 2;
                Object[] objArr2 = newInitContext.callArgs;
                super((si0) objArr2[0], (kj0) objArr2[1]);
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
        kj0Var.getRealView().setOnClickListener(this);
    }

    public void A(zi0 zi0Var, Activity activity) {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeLL(1048576, this, zi0Var, activity) == null) && (this.e.get() instanceof DefaultDownloadViewLP)) {
            DefaultDownloadViewLP defaultDownloadViewLP = (DefaultDownloadViewLP) this.e.get();
            defaultDownloadViewLP.d(false);
            wj0.c(zi0Var, defaultDownloadViewLP, activity, new a(this), null);
        }
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, view2) == null) {
            m();
        }
    }

    /* JADX WARN: Type inference failed for: r5v1, types: [android.view.View] */
    @Override // com.repackage.ej0
    public void t(kj0<?> kj0Var) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(Constants.METHOD_SEND_USER_MSG, this, kj0Var) == null) {
            super.t(kj0Var);
            kj0Var.getRealView().setOnClickListener(this);
        }
    }

    public zi0 v() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048579, this)) == null) ? this.g : (zi0) invokeV.objValue;
    }

    public boolean w() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048580, this)) == null) ? this.f : invokeV.booleanValue;
    }

    public boolean x() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048581, this)) == null) {
            WeakReference<kj0<?>> weakReference = this.e;
            if (weakReference != null && weakReference.get() != null) {
                kj0<?> kj0Var = this.e.get();
                if (kj0Var instanceof View) {
                    return !((View) kj0Var).isAttachedToWindow();
                }
            }
            return true;
        }
        return invokeV.booleanValue;
    }

    public void y(zi0 zi0Var) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048582, this, zi0Var) == null) {
            this.g = zi0Var;
        }
    }

    public void z(boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(1048583, this, z) == null) {
            this.f = z;
        }
    }
}
