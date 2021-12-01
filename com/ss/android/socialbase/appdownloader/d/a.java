package com.ss.android.socialbase.appdownloader.d;

import android.app.AlertDialog;
import android.content.Context;
import android.content.DialogInterface;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import com.ss.android.socialbase.appdownloader.c.k;
import com.ss.android.socialbase.appdownloader.c.l;
/* loaded from: classes2.dex */
public class a extends com.ss.android.socialbase.appdownloader.c.b {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public AlertDialog.Builder a;

    /* renamed from: com.ss.android.socialbase.appdownloader.d.a$a  reason: collision with other inner class name */
    /* loaded from: classes2.dex */
    public static class C2110a implements k {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public AlertDialog a;

        public C2110a(AlertDialog.Builder builder) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {builder};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            if (builder != null) {
                this.a = builder.show();
            }
        }

        @Override // com.ss.android.socialbase.appdownloader.c.k
        public void a() {
            AlertDialog alertDialog;
            Interceptable interceptable = $ic;
            if (!(interceptable == null || interceptable.invokeV(1048576, this) == null) || (alertDialog = this.a) == null) {
                return;
            }
            alertDialog.show();
        }

        @Override // com.ss.android.socialbase.appdownloader.c.k
        public boolean b() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this)) == null) {
                AlertDialog alertDialog = this.a;
                if (alertDialog != null) {
                    return alertDialog.isShowing();
                }
                return false;
            }
            return invokeV.booleanValue;
        }
    }

    public a(Context context) {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {context};
            interceptable.invokeUnInit(65536, newInitContext);
            int i2 = newInitContext.flag;
            if ((i2 & 1) != 0) {
                int i3 = i2 & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
        this.a = new AlertDialog.Builder(context);
    }

    @Override // com.ss.android.socialbase.appdownloader.c.l
    public l a(int i2) {
        InterceptResult invokeI;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeI = interceptable.invokeI(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, i2)) == null) {
            AlertDialog.Builder builder = this.a;
            if (builder != null) {
                builder.setTitle(i2);
            }
            return this;
        }
        return (l) invokeI.objValue;
    }

    @Override // com.ss.android.socialbase.appdownloader.c.l
    public l b(int i2, DialogInterface.OnClickListener onClickListener) {
        InterceptResult invokeIL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeIL = interceptable.invokeIL(1048581, this, i2, onClickListener)) == null) {
            AlertDialog.Builder builder = this.a;
            if (builder != null) {
                builder.setNegativeButton(i2, onClickListener);
            }
            return this;
        }
        return (l) invokeIL.objValue;
    }

    @Override // com.ss.android.socialbase.appdownloader.c.l
    public l a(String str) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048580, this, str)) == null) {
            AlertDialog.Builder builder = this.a;
            if (builder != null) {
                builder.setMessage(str);
            }
            return this;
        }
        return (l) invokeL.objValue;
    }

    @Override // com.ss.android.socialbase.appdownloader.c.l
    public l a(int i2, DialogInterface.OnClickListener onClickListener) {
        InterceptResult invokeIL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeIL = interceptable.invokeIL(Constants.METHOD_SEND_USER_MSG, this, i2, onClickListener)) == null) {
            AlertDialog.Builder builder = this.a;
            if (builder != null) {
                builder.setPositiveButton(i2, onClickListener);
            }
            return this;
        }
        return (l) invokeIL.objValue;
    }

    @Override // com.ss.android.socialbase.appdownloader.c.l
    public l a(DialogInterface.OnCancelListener onCancelListener) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048579, this, onCancelListener)) == null) {
            AlertDialog.Builder builder = this.a;
            if (builder != null) {
                builder.setOnCancelListener(onCancelListener);
            }
            return this;
        }
        return (l) invokeL.objValue;
    }

    @Override // com.ss.android.socialbase.appdownloader.c.l
    public k a() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) ? new C2110a(this.a) : (k) invokeV.objValue;
    }
}
