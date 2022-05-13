package com.repackage;

import android.content.Context;
import android.text.Editable;
import android.text.InputFilter;
import android.text.TextUtils;
import android.util.Log;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.core.view.InputDeviceCompat;
import com.baidu.searchbox.launch.stats.SpeedStatsStampTable;
import com.baidu.swan.apps.component.components.textarea.SwanEditText;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import com.repackage.bw1;
import com.tachikoma.core.component.input.ReturnKeyType;
/* loaded from: classes5.dex */
public abstract class aw1<V extends SwanEditText, M extends bw1> extends fw1<V, M> {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public aw1(@Nullable Context context, @NonNull M m) {
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
                super((Context) objArr2[0], (gw1) objArr2[1]);
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.repackage.fw1, com.repackage.hw1, com.repackage.jw1
    @NonNull
    /* renamed from: Z */
    public mx1 k(@NonNull M m, @NonNull M m2) {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(1048582, this, m, m2)) == null) {
            mx1 k = super.k(m, m2);
            if (q() != 0 && !TextUtils.equals(((SwanEditText) q()).getText().toString(), m2.t)) {
                k.b(6);
            }
            if (m.D != m2.D) {
                k.b(10);
            }
            if (m.F != m2.F) {
                k.b(11);
            }
            if (m.G != m2.G || m.H != m2.H) {
                k.b(12);
            }
            if (!TextUtils.equals(m.I, m2.I)) {
                k.b(13);
            }
            return k;
        }
        return (mx1) invokeLL.objValue;
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.repackage.fw1
    /* renamed from: a0 */
    public void T(@NonNull V v, @NonNull M m, @NonNull mx1 mx1Var) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLLL(1048583, this, v, m, mx1Var) == null) {
            super.O(v, m, mx1Var);
            if (mx1Var.a(11)) {
                d0(v, m);
            }
            if (mx1Var.a(12)) {
                f0(v, m);
            }
            if (mx1Var.a(10)) {
                e0(v, m);
            }
            if (mx1Var.a(13)) {
                c0(v, m);
            }
        }
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.repackage.hw1
    /* renamed from: b0 */
    public void Q(@NonNull V v, @NonNull M m) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(InputDeviceCompat.SOURCE_TOUCHPAD, this, v, m) == null) {
            if (jw1.h) {
                Log.d("Component-EditText", "renderBackground");
            }
            v.setBackgroundColor(0);
        }
    }

    public boolean c0(@NonNull V v, @NonNull M m) {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(1048585, this, v, m)) == null) {
            if (jw1.h) {
                Log.d("Component-EditText", "renderConfirmType:" + m.I);
            }
            String str = m.I;
            char c = 65535;
            switch (str.hashCode()) {
                case -906336856:
                    if (str.equals("search")) {
                        c = 1;
                        break;
                    }
                    break;
                case SpeedStatsStampTable.AD_LOAD_BEAR_END_STAMP_KEY /* 3304 */:
                    if (str.equals(ReturnKeyType.GO)) {
                        c = 3;
                        break;
                    }
                    break;
                case 3089282:
                    if (str.equals("done")) {
                        c = 4;
                        break;
                    }
                    break;
                case 3377907:
                    if (str.equals("next")) {
                        c = 2;
                        break;
                    }
                    break;
                case 3526536:
                    if (str.equals(ReturnKeyType.SEND)) {
                        c = 0;
                        break;
                    }
                    break;
            }
            if (c == 0) {
                v.setImeOptions(4);
            } else if (c == 1) {
                v.setImeOptions(3);
            } else if (c == 2) {
                v.setImeOptions(5);
            } else if (c == 3) {
                v.setImeOptions(2);
            } else if (c != 4) {
                return false;
            } else {
                v.setImeOptions(6);
            }
            return true;
        }
        return invokeLL.booleanValue;
    }

    public void d0(@NonNull V v, @NonNull M m) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(1048586, this, v, m) == null) {
            if (jw1.h) {
                Log.d("Component-EditText", "renderCursor");
            }
            Editable text = v.getText();
            int length = text != null ? text.length() : 0;
            int i = m.F;
            if (i > length || i < 0) {
                return;
            }
            v.setSelection(i);
        }
    }

    public final void e0(@NonNull V v, @NonNull M m) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(1048587, this, v, m) == null) {
            if (jw1.h) {
                Log.d("Component-EditText", "renderMaxLength");
            }
            if (m.D >= 0) {
                v.setFilters(new InputFilter[]{new InputFilter.LengthFilter(m.D)});
            }
        }
    }

    public void f0(@NonNull V v, @NonNull M m) {
        int i;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(1048588, this, v, m) == null) {
            if (jw1.h) {
                Log.d("Component-EditText", "renderSelection");
            }
            Editable text = v.getText();
            int length = text != null ? text.length() : 0;
            int i2 = m.H;
            if (i2 > length || (i = m.G) < 0 || i > i2) {
                return;
            }
            v.setSelection(i, i2);
        }
    }
}
