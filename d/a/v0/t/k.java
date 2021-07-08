package d.a.v0.t;

import android.text.SpannableStringBuilder;
import android.text.TextUtils;
import android.text.style.ForegroundColorSpan;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import android.widget.Toast;
import androidx.core.view.InputDeviceCompat;
import com.baidu.mobads.container.util.AdIconUtil;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptable;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptorStorage;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
/* loaded from: classes8.dex */
public class k {
    public static /* synthetic */ Interceptable $ic = null;

    /* renamed from: a  reason: collision with root package name */
    public static Toast f68251a = null;

    /* renamed from: b  reason: collision with root package name */
    public static int f68252b = -1;

    /* renamed from: c  reason: collision with root package name */
    public static int f68253c = -1;
    public transient /* synthetic */ FieldHolder $fh;

    static {
        InterceptResult invokeClinit;
        ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
        if (classClinitInterceptable == null || (invokeClinit = classClinitInterceptable.invokeClinit(1118286779, "Ld/a/v0/t/k;")) == null) {
            return;
        }
        Interceptable interceptable = invokeClinit.interceptor;
        if (interceptable != null) {
            $ic = interceptable;
        }
        if ((invokeClinit.flags & 1) != 0) {
            classClinitInterceptable.invokePostClinit(1118286779, "Ld/a/v0/t/k;");
        }
    }

    public static void a(int i2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(65537, null, i2) == null) {
            b(i2, 0);
        }
    }

    public static void b(int i2, int i3) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeII(65538, null, i2, i3) == null) {
            c(d.a.v0.b.d().b().getResources().getString(i2), i3);
        }
    }

    public static void c(String str, int i2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLI(65539, null, str, i2) == null) {
            d(str, i2, null);
        }
    }

    public static void d(String str, int i2, String str2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLIL(InputDeviceCompat.SOURCE_TRACKBALL, null, str, i2, str2) == null) {
            e(str, i2, str2, -1);
        }
    }

    public static void e(String str, int i2, String str2, int i3) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeCommon(AdIconUtil.AD_TEXT_ID, null, new Object[]{str, Integer.valueOf(i2), str2, Integer.valueOf(i3)}) == null) {
            if (f68252b != -1 && f68253c != -1) {
                Toast toast = f68251a;
                if (toast != null) {
                    toast.cancel();
                }
                Toast toast2 = new Toast(d.a.v0.b.d().b());
                f68251a = toast2;
                if (i3 > -1) {
                    toast2.setGravity(i3, 0, 0);
                }
                f68251a.setDuration(i2);
                try {
                    View inflate = LayoutInflater.from(d.a.v0.b.d().b()).inflate(f68252b, (ViewGroup) null);
                    TextView textView = (TextView) inflate.findViewById(f68253c);
                    if (!TextUtils.isEmpty(str2) && !TextUtils.isEmpty(str) && str.contains(str2)) {
                        SpannableStringBuilder spannableStringBuilder = new SpannableStringBuilder(str);
                        spannableStringBuilder.setSpan(new ForegroundColorSpan(d.a.v0.b.d().b().getResources().getColor(d.a.v0.o.a.app_theme_color)), str.indexOf(str2), str.indexOf(str2) + str2.length(), 33);
                        textView.setText(spannableStringBuilder);
                    } else {
                        textView.setText(str);
                    }
                    f68251a.setView(inflate);
                    f68251a.show();
                    return;
                } catch (Exception e2) {
                    e2.printStackTrace();
                    return;
                }
            }
            Toast toast3 = f68251a;
            if (toast3 == null) {
                Toast makeText = Toast.makeText(d.a.v0.b.d().b(), str, i2);
                f68251a = makeText;
                if (i3 > -1) {
                    makeText.setGravity(i3, 0, 0);
                }
            } else {
                toast3.cancel();
                Toast makeText2 = Toast.makeText(d.a.v0.b.d().b(), str, i2);
                f68251a = makeText2;
                if (i3 > -1) {
                    makeText2.setGravity(i3, 0, 0);
                }
                f68251a.setDuration(i2);
            }
            try {
                f68251a.show();
            } catch (Exception unused) {
            }
        }
    }
}
