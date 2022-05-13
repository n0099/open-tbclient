package com.repackage;

import android.graphics.drawable.Drawable;
import android.text.SpannableString;
import android.text.SpannableStringBuilder;
import android.util.SparseIntArray;
import android.widget.LinearLayout;
import android.widget.TextView;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.data.SmallTailInfo;
import com.baidu.tbadk.core.util.SkinManager;
import com.baidu.tieba.R;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptable;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptorStorage;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
/* loaded from: classes6.dex */
public class i08 {
    public static /* synthetic */ Interceptable $ic;
    public static SparseIntArray a;
    public transient /* synthetic */ FieldHolder $fh;

    static {
        InterceptResult invokeClinit;
        ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
        if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(-755672160, "Lcom/repackage/i08;")) != null) {
            Interceptable interceptable = invokeClinit.interceptor;
            if (interceptable != null) {
                $ic = interceptable;
            }
            if ((invokeClinit.flags & 1) != 0) {
                classClinitInterceptable.invokePostClinit(-755672160, "Lcom/repackage/i08;");
                return;
            }
        }
        a = new SparseIntArray();
    }

    public static void a(SmallTailInfo smallTailInfo, TextView textView, boolean z, boolean z2, boolean z3) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeCommon(65537, null, new Object[]{smallTailInfo, textView, Boolean.valueOf(z), Boolean.valueOf(z2), Boolean.valueOf(z3)}) == null) || smallTailInfo == null || textView == null) {
            return;
        }
        LinearLayout.LayoutParams layoutParams = (LinearLayout.LayoutParams) textView.getLayoutParams();
        int b = b(R.dimen.obfuscated_res_0x7f070207);
        if (z2 && z3) {
            layoutParams.setMargins(b, b(R.dimen.obfuscated_res_0x7f070305), b, b(R.dimen.obfuscated_res_0x7f070263));
        } else if (z) {
            layoutParams.setMargins(0, b(R.dimen.obfuscated_res_0x7f070305), 0, 0);
        } else if (!z2) {
            layoutParams.setMargins(b(R.dimen.obfuscated_res_0x7f070235), b(R.dimen.obfuscated_res_0x7f070305), b(R.dimen.obfuscated_res_0x7f07020f), b(R.dimen.obfuscated_res_0x7f0701b2));
        } else {
            layoutParams.setMargins(b, b(R.dimen.obfuscated_res_0x7f070305), b, b(R.dimen.obfuscated_res_0x7f0701b2));
        }
        SpannableStringBuilder spannableStringBuilder = new SpannableStringBuilder();
        spannableStringBuilder.append((CharSequence) "icon");
        spannableStringBuilder.append((CharSequence) smallTailInfo.tailSpannable);
        Drawable drawable = SkinManager.getDrawable(R.drawable.icon_pb_tail);
        drawable.setBounds(0, 0, b, b);
        ne5 ne5Var = new ne5(drawable);
        ne5Var.c(b(R.dimen.obfuscated_res_0x7f070224));
        spannableStringBuilder.setSpan(ne5Var, 0, 4, 33);
        textView.setLayoutParams(layoutParams);
        textView.setText(spannableStringBuilder);
        textView.setTextColor(smallTailInfo.showColorId);
        textView.setVisibility(0);
    }

    public static int b(int i) {
        InterceptResult invokeI;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeI = interceptable.invokeI(65538, null, i)) == null) {
            int i2 = a.get(i, -1);
            if (i2 == -1) {
                int f = mi.f(TbadkCoreApplication.getInst().getContext(), i);
                a.put(i, f);
                return f;
            }
            return i2;
        }
        return invokeI.intValue;
    }

    public static void c(SmallTailInfo smallTailInfo, TextView textView, boolean z, boolean z2, boolean z3) {
        SpannableString spannableString;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeCommon(65539, null, new Object[]{smallTailInfo, textView, Boolean.valueOf(z), Boolean.valueOf(z2), Boolean.valueOf(z3)}) == null) || smallTailInfo == null || (spannableString = smallTailInfo.tailSpannable) == null || spannableString.length() == 0 || textView == null) {
            return;
        }
        smallTailInfo.updateShowInfo();
        a(smallTailInfo, textView, z, z2, z3);
    }
}
