package com.repackage;

import android.graphics.Color;
import android.view.LayoutInflater;
import android.view.ViewGroup;
import android.widget.TextView;
import androidx.core.view.InputDeviceCompat;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.tieba.R;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import java.text.SimpleDateFormat;
import java.util.Locale;
/* loaded from: classes7.dex */
public class vu2 {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public boolean a;
    public boolean b;

    public vu2() {
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

    public void a() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
            this.a = true;
        }
    }

    public final ViewGroup b() {
        InterceptResult invokeV;
        ViewGroup viewGroup;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this)) == null) {
            if (j03.a0() == null || j03.a0().x() == null || (viewGroup = (ViewGroup) j03.a0().x().findViewById(16908290)) == null) {
                return null;
            }
            ViewGroup viewGroup2 = (ViewGroup) viewGroup.findViewById(R.id.obfuscated_res_0x7f091d8f);
            if (viewGroup2 != null) {
                return viewGroup2;
            }
            ViewGroup viewGroup3 = (ViewGroup) LayoutInflater.from(j03.a0().x()).inflate(R.layout.obfuscated_res_0x7f0d07c4, viewGroup);
            this.b = true;
            return viewGroup3;
        }
        return (ViewGroup) invokeV.objValue;
    }

    public void c() {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this) == null) && this.b) {
            d();
        }
    }

    public final void d() {
        j03 a0;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(1048579, this) == null) || (a0 = j03.a0()) == null || a0.x() == null) {
            return;
        }
        ViewGroup viewGroup = (ViewGroup) a0.x().findViewById(R.id.obfuscated_res_0x7f091d8f);
        if (viewGroup != null && (viewGroup.getParent() instanceof ViewGroup)) {
            ((ViewGroup) viewGroup.getParent()).removeView(viewGroup);
        }
        this.b = false;
    }

    public void e() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048580, this) == null) {
            this.a = false;
            c();
            k();
        }
    }

    public void f(long j) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeJ(1048581, this, j) == null) {
            j(R.id.obfuscated_res_0x7f090985, j, "#80ff0000", "FCP");
        }
    }

    public void g(long j) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeJ(1048582, this, j) == null) {
            j(R.id.obfuscated_res_0x7f0909a3, j, "#80ff0000", "FIP");
        }
    }

    public void h(long j) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeJ(1048583, this, j) == null) {
            j(R.id.obfuscated_res_0x7f0909eb, j, "#8000ff00", "FMP");
        }
    }

    public void i(long j) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeJ(InputDeviceCompat.SOURCE_TOUCHPAD, this, j) == null) {
            j(R.id.obfuscated_res_0x7f090c08, j, "#80ff0000", "FTP");
        }
    }

    public final void j(int i, long j, String str, String str2) {
        ViewGroup b;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeCommon(1048585, this, new Object[]{Integer.valueOf(i), Long.valueOf(j), str, str2}) == null) || this.a || (b = b()) == null) {
            return;
        }
        TextView textView = (TextView) b.findViewById(i);
        textView.setText(String.format(str2 + ":[%s]ms", Long.valueOf(j)));
        textView.setBackgroundColor(Color.parseColor(str));
    }

    public void k() {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(1048586, this) == null) || this.b) {
            return;
        }
        b();
    }

    public void l(long j, long j2) {
        ViewGroup b;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeCommon(1048587, this, new Object[]{Long.valueOf(j), Long.valueOf(j2)}) == null) || this.a || (b = b()) == null) {
            return;
        }
        ((TextView) b.findViewById(R.id.obfuscated_res_0x7f091dcc)).setText(String.format("启动:[%s] 耗时:[%s]ms", new SimpleDateFormat("HH:mm:ss:SSS", Locale.getDefault()).format(Long.valueOf(j)), Long.valueOf(j2)));
    }
}
