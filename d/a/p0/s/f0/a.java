package d.a.p0.s.f0;

import android.app.Activity;
import android.app.AlertDialog;
import android.content.DialogInterface;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
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
public class a {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    /* renamed from: a  reason: collision with root package name */
    public TbPageContext<?> f52977a;

    /* renamed from: b  reason: collision with root package name */
    public Activity f52978b;

    /* renamed from: c  reason: collision with root package name */
    public AlertDialog f52979c;

    /* renamed from: d  reason: collision with root package name */
    public String f52980d;

    /* renamed from: e  reason: collision with root package name */
    public TextView f52981e;

    /* renamed from: f  reason: collision with root package name */
    public DialogInterface.OnCancelListener f52982f;

    /* renamed from: g  reason: collision with root package name */
    public boolean f52983g;

    public a(TbPageContext<?> tbPageContext) {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {tbPageContext};
            interceptable.invokeUnInit(65537, newInitContext);
            int i2 = newInitContext.flag;
            if ((i2 & 1) != 0) {
                int i3 = i2 & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65537, newInitContext);
                return;
            }
        }
        this.f52977a = null;
        this.f52978b = null;
        this.f52980d = null;
        this.f52981e = null;
        this.f52983g = true;
        this.f52977a = tbPageContext;
        if (tbPageContext == null || tbPageContext.getPageActivity() == null) {
            return;
        }
        this.f52978b = this.f52977a.getPageActivity();
    }

    public final a a(DialogInterface.OnCancelListener onCancelListener) {
        InterceptResult invokeL;
        TextView textView;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048576, this, onCancelListener)) == null) {
            if (this.f52978b == null) {
                return this;
            }
            AlertDialog create = new AlertDialog.Builder(this.f52978b).create();
            this.f52979c = create;
            d.a.d.e.m.g.i(create, this.f52978b);
            View inflate = LayoutInflater.from(this.f52978b).inflate(R.layout.custom_loading_toast, (ViewGroup) null);
            this.f52981e = (TextView) inflate.findViewById(R.id.custom_loading_text);
            if (!StringUtils.isNull(this.f52980d) && (textView = this.f52981e) != null) {
                textView.setText(this.f52980d);
            }
            AlertDialog alertDialog = this.f52979c;
            if (alertDialog != null && alertDialog.getWindow() != null) {
                this.f52979c.getWindow().setContentView(inflate);
                if (onCancelListener != null) {
                    this.f52979c.setCancelable(true);
                    this.f52979c.setCanceledOnTouchOutside(true);
                    this.f52979c.setOnCancelListener(onCancelListener);
                } else {
                    this.f52979c.setCanceledOnTouchOutside(false);
                    this.f52979c.setCancelable(false);
                }
            }
            return this;
        }
        return (a) invokeL.objValue;
    }

    public final a b(DialogInterface.OnCancelListener onCancelListener) {
        InterceptResult invokeL;
        TextView textView;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, onCancelListener)) == null) {
            if (this.f52978b == null) {
                return this;
            }
            AlertDialog create = new AlertDialog.Builder(this.f52978b).create();
            this.f52979c = create;
            d.a.d.e.m.g.i(create, this.f52978b);
            View inflate = LayoutInflater.from(this.f52978b).inflate(R.layout.custom_loading_toast, (ViewGroup) null);
            this.f52981e = (TextView) inflate.findViewById(R.id.custom_loading_text);
            if (!StringUtils.isNull(this.f52980d) && (textView = this.f52981e) != null) {
                textView.setText(this.f52980d);
            }
            AlertDialog alertDialog = this.f52979c;
            if (alertDialog != null && alertDialog.getWindow() != null) {
                this.f52979c.getWindow().setContentView(inflate);
                if (onCancelListener != null) {
                    this.f52979c.setOnCancelListener(onCancelListener);
                }
            }
            return this;
        }
        return (a) invokeL.objValue;
    }

    public boolean c() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this)) == null) {
            AlertDialog alertDialog = this.f52979c;
            return alertDialog != null && alertDialog.isShowing();
        }
        return invokeV.booleanValue;
    }

    public void d(boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(1048579, this, z) == null) {
            this.f52983g = z;
        }
    }

    public void e(DialogInterface.OnCancelListener onCancelListener) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048580, this, onCancelListener) == null) {
            this.f52982f = onCancelListener;
        }
    }

    public void f(boolean z) {
        AlertDialog alertDialog;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeZ(1048581, this, z) == null) || (alertDialog = this.f52979c) == null) {
            return;
        }
        alertDialog.setCancelable(z);
    }

    public void g(boolean z) {
        AlertDialog alertDialog;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeZ(1048582, this, z) == null) || (alertDialog = this.f52979c) == null) {
            return;
        }
        alertDialog.setCanceledOnTouchOutside(z);
    }

    public void h(boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(1048583, this, z) == null) {
            if (z) {
                if (this.f52983g) {
                    a(this.f52982f);
                    return;
                } else {
                    b(this.f52982f);
                    return;
                }
            }
            d.a.d.e.m.g.a(this.f52979c, this.f52978b);
        }
    }

    public void i(int i2) {
        Activity activity;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeI(InputDeviceCompat.SOURCE_TOUCHPAD, this, i2) == null) || (activity = this.f52978b) == null) {
            return;
        }
        this.f52980d = activity.getString(i2);
    }

    public void j(String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048585, this, str) == null) {
            this.f52980d = str;
            TextView textView = this.f52981e;
            if (textView != null) {
                textView.setText(str);
            }
        }
    }

    public a(Activity activity) {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {activity};
            interceptable.invokeUnInit(65536, newInitContext);
            int i2 = newInitContext.flag;
            if ((i2 & 1) != 0) {
                int i3 = i2 & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
        this.f52977a = null;
        this.f52978b = null;
        this.f52980d = null;
        this.f52981e = null;
        this.f52983g = true;
        this.f52978b = activity;
    }
}
