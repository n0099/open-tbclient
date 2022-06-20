package com.repackage;

import android.content.Context;
import android.graphics.Typeface;
import android.text.SpannableStringBuilder;
import android.text.TextUtils;
import android.util.Log;
import android.widget.TextView;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.core.view.GravityCompat;
import androidx.core.view.InputDeviceCompat;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import com.repackage.ev1;
/* loaded from: classes5.dex */
public abstract class dv1<V extends TextView, M extends ev1> extends fv1<V, M> {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public dv1(@Nullable Context context, @NonNull M m) {
        super(context, m);
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {context, m};
            interceptable.invokeUnInit(65536, newInitContext);
            int i = newInitContext.flag;
            if ((i & 1) != 0) {
                int i2 = i & 2;
                Object[] objArr2 = newInitContext.callArgs;
                super((Context) objArr2[0], (gv1) objArr2[1]);
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.repackage.fv1, com.repackage.hv1
    @NonNull
    /* renamed from: S */
    public kw1 k(@NonNull M m, @NonNull M m2) {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(1048579, this, m, m2)) == null) {
            kw1 k = super.k(m, m2);
            if (!TextUtils.equals(m.t, m2.t)) {
                k.b(6);
            }
            return k;
        }
        return (kw1) invokeLL.objValue;
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.repackage.fv1
    /* renamed from: T */
    public void O(@NonNull V v, @NonNull M m, @NonNull kw1 kw1Var) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLLL(1048580, this, v, m, kw1Var) == null) {
            super.C(v, m, kw1Var);
            if (kw1Var.a(6)) {
                U(v, m);
            }
            if (kw1Var.a(4)) {
                V(v, m);
            }
        }
    }

    /* JADX DEBUG: Multi-variable search result rejected for r4v1, resolved type: android.text.SpannableStringBuilder */
    /* JADX WARN: Multi-variable type inference failed */
    public void U(@NonNull V v, @NonNull M m) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(1048581, this, v, m) == null) {
            if (hv1.h) {
                Log.d("Component-TextView", "renderText");
            }
            boolean z = !TextUtils.isEmpty(m.t) && m.x >= 0;
            String str = m.t;
            if (z) {
                SpannableStringBuilder spannableStringBuilder = new SpannableStringBuilder(str);
                spannableStringBuilder.setSpan(new cv1(m.x), 0, str.length(), 33);
                str = spannableStringBuilder;
            }
            v.setIncludeFontPadding(!z);
            v.setText(str);
        }
    }

    public final void V(@NonNull V v, @NonNull M m) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeLL(1048582, this, v, m) == null) || m.j == null) {
            return;
        }
        if (hv1.h) {
            Log.d("Component-TextView", "renderTextStyle");
        }
        if (m.v) {
            v.setTextColor(m.u);
        }
        float f = (float) m.w;
        if (f > 0.0f) {
            v.setTextSize(1, f);
        }
        X(v, m);
        W(v, m);
        String str = m.B;
        char c = 65535;
        int hashCode = str.hashCode();
        if (hashCode != -1039745817) {
            if (hashCode == -1039592053 && str.equals("nowrap")) {
                c = 1;
            }
        } else if (str.equals("normal")) {
            c = 0;
        }
        if (c == 0) {
            v.setSingleLine(false);
        } else if (c == 1) {
            v.setSingleLine(true);
        }
        if ("ellipsis".equals(m.C)) {
            v.setEllipsize(TextUtils.TruncateAt.END);
        }
    }

    public void W(@NonNull V v, @NonNull M m) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeLL(1048583, this, v, m) == null) || m.j == null) {
            return;
        }
        if (hv1.h) {
            Log.d("Component-TextView", "renderTextStyleFontWeight");
        }
        String str = m.A;
        char c = 65535;
        int hashCode = str.hashCode();
        if (hashCode != -1039745817) {
            if (hashCode == 3029637 && str.equals("bold")) {
                c = 1;
            }
        } else if (str.equals("normal")) {
            c = 0;
        }
        if (c == 0) {
            v.setTypeface(Typeface.SANS_SERIF, 0);
        } else if (c != 1) {
            sw1.o("Component-TextView", "invalid font weight : " + m.A);
            v.setTypeface(Typeface.SANS_SERIF, 0);
        } else {
            v.setTypeface(Typeface.SANS_SERIF, 1);
        }
    }

    public void X(@NonNull V v, @NonNull M m) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(InputDeviceCompat.SOURCE_TOUCHPAD, this, v, m) == null) {
            Y(v, m, 48);
        }
    }

    public final void Y(@NonNull V v, @NonNull M m, int i) {
        int i2;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeLLI(1048585, this, v, m, i) == null) || m.j == null) {
            return;
        }
        if (hv1.h) {
            Log.d("Component-TextView", "renderTextStyleTextAlign");
        }
        String str = m.z;
        char c = 65535;
        int hashCode = str.hashCode();
        if (hashCode != -1364013995) {
            if (hashCode != 3317767) {
                if (hashCode == 108511772 && str.equals("right")) {
                    c = 1;
                }
            } else if (str.equals("left")) {
                c = 0;
            }
        } else if (str.equals("center")) {
            c = 2;
        }
        if (c != 0) {
            if (c == 1) {
                i2 = 8388613 | i;
            } else if (c != 2) {
                sw1.o("Component-TextView", "invalid text align: " + m.z);
            } else {
                i2 = i | 1;
            }
            v.setGravity(i2);
        }
        i2 = i | GravityCompat.START;
        v.setGravity(i2);
    }
}
