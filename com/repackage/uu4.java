package com.repackage;

import android.app.Activity;
import android.app.AlertDialog;
import android.content.DialogInterface;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import androidx.annotation.Nullable;
import androidx.core.view.InputDeviceCompat;
import com.baidu.adp.lib.util.StringUtils;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.tbadk.TbPageContext;
import com.baidu.tieba.R;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
/* loaded from: classes7.dex */
public class uu4 {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public TbPageContext<?> a;
    public Activity b;
    public AlertDialog c;
    public String d;
    public TextView e;
    public DialogInterface.OnCancelListener f;
    public boolean g;

    public uu4(TbPageContext<?> tbPageContext) {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {tbPageContext};
            interceptable.invokeUnInit(65537, newInitContext);
            int i = newInitContext.flag;
            if ((i & 1) != 0) {
                int i2 = i & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65537, newInitContext);
                return;
            }
        }
        this.a = null;
        this.b = null;
        this.d = null;
        this.e = null;
        this.g = true;
        this.a = tbPageContext;
        if (tbPageContext == null || tbPageContext.getPageActivity() == null) {
            return;
        }
        this.b = this.a.getPageActivity();
    }

    public final uu4 a(DialogInterface.OnCancelListener onCancelListener) {
        InterceptResult invokeL;
        TextView textView;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048576, this, onCancelListener)) == null) {
            if (this.b == null) {
                return this;
            }
            AlertDialog create = new AlertDialog.Builder(this.b).create();
            this.c = create;
            tg.i(create, this.b);
            View inflate = LayoutInflater.from(this.b).inflate(R.layout.obfuscated_res_0x7f0d0204, (ViewGroup) null);
            this.e = (TextView) inflate.findViewById(R.id.obfuscated_res_0x7f09073e);
            if (!StringUtils.isNull(this.d) && (textView = this.e) != null) {
                textView.setText(this.d);
            }
            AlertDialog alertDialog = this.c;
            if (alertDialog != null && alertDialog.getWindow() != null) {
                this.c.getWindow().setContentView(inflate);
                if (onCancelListener != null) {
                    this.c.setCancelable(true);
                    this.c.setCanceledOnTouchOutside(true);
                    this.c.setOnCancelListener(onCancelListener);
                } else {
                    this.c.setCanceledOnTouchOutside(false);
                    this.c.setCancelable(false);
                }
            }
            return this;
        }
        return (uu4) invokeL.objValue;
    }

    public final uu4 b(DialogInterface.OnCancelListener onCancelListener) {
        InterceptResult invokeL;
        TextView textView;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, onCancelListener)) == null) {
            if (this.b == null) {
                return this;
            }
            AlertDialog create = new AlertDialog.Builder(this.b).create();
            this.c = create;
            tg.i(create, this.b);
            View inflate = LayoutInflater.from(this.b).inflate(R.layout.obfuscated_res_0x7f0d0204, (ViewGroup) null);
            this.e = (TextView) inflate.findViewById(R.id.obfuscated_res_0x7f09073e);
            if (!StringUtils.isNull(this.d) && (textView = this.e) != null) {
                textView.setText(this.d);
            }
            AlertDialog alertDialog = this.c;
            if (alertDialog != null && alertDialog.getWindow() != null) {
                this.c.getWindow().setContentView(inflate);
                if (onCancelListener != null) {
                    this.c.setOnCancelListener(onCancelListener);
                }
            }
            return this;
        }
        return (uu4) invokeL.objValue;
    }

    public boolean c() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this)) == null) {
            AlertDialog alertDialog = this.c;
            return alertDialog != null && alertDialog.isShowing();
        }
        return invokeV.booleanValue;
    }

    public void d(boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(1048579, this, z) == null) {
            this.g = z;
        }
    }

    public void e(DialogInterface.OnCancelListener onCancelListener) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048580, this, onCancelListener) == null) {
            this.f = onCancelListener;
        }
    }

    public void f(boolean z) {
        AlertDialog alertDialog;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeZ(1048581, this, z) == null) || (alertDialog = this.c) == null) {
            return;
        }
        alertDialog.setCancelable(z);
    }

    public void g(boolean z) {
        AlertDialog alertDialog;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeZ(1048582, this, z) == null) || (alertDialog = this.c) == null) {
            return;
        }
        alertDialog.setCanceledOnTouchOutside(z);
    }

    @Nullable
    public Activity getActivity() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048583, this)) == null) ? this.b : (Activity) invokeV.objValue;
    }

    public void h(boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(InputDeviceCompat.SOURCE_TOUCHPAD, this, z) == null) {
            if (z) {
                if (this.g) {
                    a(this.f);
                    return;
                } else {
                    b(this.f);
                    return;
                }
            }
            tg.a(this.c, this.b);
        }
    }

    public void i(int i) {
        Activity activity;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeI(1048585, this, i) == null) || (activity = this.b) == null) {
            return;
        }
        this.d = activity.getString(i);
    }

    public void j(String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048586, this, str) == null) {
            this.d = str;
            TextView textView = this.e;
            if (textView != null) {
                textView.setText(str);
            }
        }
    }

    public uu4(Activity activity) {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {activity};
            interceptable.invokeUnInit(65536, newInitContext);
            int i = newInitContext.flag;
            if ((i & 1) != 0) {
                int i2 = i & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
        this.a = null;
        this.b = null;
        this.d = null;
        this.e = null;
        this.g = true;
        this.b = activity;
    }
}
