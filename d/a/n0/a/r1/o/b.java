package d.a.n0.a.r1.o;

import android.graphics.Color;
import android.view.LayoutInflater;
import android.view.ViewGroup;
import android.widget.TextView;
import androidx.core.view.InputDeviceCompat;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import d.a.n0.a.a2.e;
import d.a.n0.a.f;
import d.a.n0.a.g;
import java.text.SimpleDateFormat;
import java.util.Locale;
/* loaded from: classes7.dex */
public class b {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    /* renamed from: a  reason: collision with root package name */
    public boolean f47173a;

    /* renamed from: b  reason: collision with root package name */
    public boolean f47174b;

    public b() {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            interceptable.invokeUnInit(65536, newInitContext);
            int i2 = newInitContext.flag;
            if ((i2 & 1) != 0) {
                int i3 = i2 & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
            }
        }
    }

    public void a() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
            this.f47173a = true;
        }
    }

    public final ViewGroup b() {
        InterceptResult invokeV;
        ViewGroup viewGroup;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this)) == null) {
            if (e.Q() == null || e.Q().x() == null || (viewGroup = (ViewGroup) e.Q().x().findViewById(16908290)) == null) {
                return null;
            }
            ViewGroup viewGroup2 = (ViewGroup) viewGroup.findViewById(f.start_up_root_container);
            if (viewGroup2 != null) {
                return viewGroup2;
            }
            ViewGroup viewGroup3 = (ViewGroup) LayoutInflater.from(e.Q().x()).inflate(g.swan_app_startup_window, viewGroup);
            this.f47174b = true;
            return viewGroup3;
        }
        return (ViewGroup) invokeV.objValue;
    }

    public void c() {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this) == null) && this.f47174b) {
            d();
        }
    }

    public final void d() {
        e Q;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(1048579, this) == null) || (Q = e.Q()) == null || Q.x() == null) {
            return;
        }
        ViewGroup viewGroup = (ViewGroup) Q.x().findViewById(f.start_up_root_container);
        if (viewGroup != null && (viewGroup.getParent() instanceof ViewGroup)) {
            ((ViewGroup) viewGroup.getParent()).removeView(viewGroup);
        }
        this.f47174b = false;
    }

    public void e() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048580, this) == null) {
            this.f47173a = false;
            c();
            k();
        }
    }

    public void f(long j) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeJ(1048581, this, j) == null) {
            j(f.fcp, j, "#80ff0000", "FCP");
        }
    }

    public void g(long j) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeJ(1048582, this, j) == null) {
            j(f.fip, j, "#80ff0000", "FIP");
        }
    }

    public void h(long j) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeJ(1048583, this, j) == null) {
            j(f.fmp, j, "#8000ff00", "FMP");
        }
    }

    public void i(long j) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeJ(InputDeviceCompat.SOURCE_TOUCHPAD, this, j) == null) {
            j(f.ftp, j, "#80ff0000", "FTP");
        }
    }

    public final void j(int i2, long j, String str, String str2) {
        ViewGroup b2;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeCommon(1048585, this, new Object[]{Integer.valueOf(i2), Long.valueOf(j), str, str2}) == null) || this.f47173a || (b2 = b()) == null) {
            return;
        }
        TextView textView = (TextView) b2.findViewById(i2);
        textView.setText(String.format(str2 + ":[%s]ms", Long.valueOf(j)));
        textView.setBackgroundColor(Color.parseColor(str));
    }

    public void k() {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(1048586, this) == null) || this.f47174b) {
            return;
        }
        b();
    }

    public void l(long j, long j2) {
        ViewGroup b2;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeCommon(1048587, this, new Object[]{Long.valueOf(j), Long.valueOf(j2)}) == null) || this.f47173a || (b2 = b()) == null) {
            return;
        }
        ((TextView) b2.findViewById(f.sum)).setText(String.format("启动:[%s] 耗时:[%s]ms", new SimpleDateFormat("HH:mm:ss:SSS", Locale.getDefault()).format(Long.valueOf(j)), Long.valueOf(j2)));
    }
}
