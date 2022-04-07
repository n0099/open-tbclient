package com.repackage;

import android.text.SpannableStringBuilder;
import android.text.TextUtils;
import android.text.style.ForegroundColorSpan;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import android.widget.Toast;
import androidx.core.view.InputDeviceCompat;
import com.baidu.tieba.R;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptable;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptorStorage;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
/* loaded from: classes5.dex */
public class bc9 {
    public static /* synthetic */ Interceptable $ic = null;
    public static Toast a = null;
    public static int b = -1;
    public static int c = -1;
    public transient /* synthetic */ FieldHolder $fh;

    static {
        InterceptResult invokeClinit;
        ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
        if (classClinitInterceptable == null || (invokeClinit = classClinitInterceptable.invokeClinit(-755831655, "Lcom/repackage/bc9;")) == null) {
            return;
        }
        Interceptable interceptable = invokeClinit.interceptor;
        if (interceptable != null) {
            $ic = interceptable;
        }
        if ((invokeClinit.flags & 1) != 0) {
            classClinitInterceptable.invokePostClinit(-755831655, "Lcom/repackage/bc9;");
        }
    }

    public static void a(int i) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(65537, null, i) == null) {
            b(i, 0);
        }
    }

    public static void b(int i, int i2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeII(65538, null, i, i2) == null) {
            c(w79.c().getContext().getResources().getString(i), i2);
        }
    }

    public static void c(String str, int i) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLI(65539, null, str, i) == null) {
            d(str, i, null);
        }
    }

    public static void d(String str, int i, String str2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLIL(InputDeviceCompat.SOURCE_TRACKBALL, null, str, i, str2) == null) {
            e(str, i, str2, -1);
        }
    }

    public static void e(String str, int i, String str2, int i2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeCommon(65541, null, new Object[]{str, Integer.valueOf(i), str2, Integer.valueOf(i2)}) == null) {
            if (b != -1 && c != -1) {
                Toast toast = a;
                if (toast != null) {
                    toast.cancel();
                }
                Toast toast2 = new Toast(w79.c().getContext());
                a = toast2;
                if (i2 > -1) {
                    toast2.setGravity(i2, 0, 0);
                }
                a.setDuration(i);
                try {
                    View inflate = LayoutInflater.from(w79.c().getContext()).inflate(b, (ViewGroup) null);
                    TextView textView = (TextView) inflate.findViewById(c);
                    if (!TextUtils.isEmpty(str2) && !TextUtils.isEmpty(str) && str.contains(str2)) {
                        SpannableStringBuilder spannableStringBuilder = new SpannableStringBuilder(str);
                        spannableStringBuilder.setSpan(new ForegroundColorSpan(w79.c().getContext().getResources().getColor(R.color.obfuscated_res_0x7f0603f6)), str.indexOf(str2), str.indexOf(str2) + str2.length(), 33);
                        textView.setText(spannableStringBuilder);
                    } else {
                        textView.setText(str);
                    }
                    a.setView(inflate);
                    a.show();
                    return;
                } catch (Exception e) {
                    e.printStackTrace();
                    return;
                }
            }
            Toast toast3 = a;
            if (toast3 == null) {
                Toast makeText = Toast.makeText(w79.c().getContext(), str, i);
                a = makeText;
                if (i2 > -1) {
                    makeText.setGravity(i2, 0, 0);
                }
            } else {
                toast3.cancel();
                Toast makeText2 = Toast.makeText(w79.c().getContext(), str, i);
                a = makeText2;
                if (i2 > -1) {
                    makeText2.setGravity(i2, 0, 0);
                }
                a.setDuration(i);
            }
            try {
                a.show();
            } catch (Exception unused) {
            }
        }
    }
}
