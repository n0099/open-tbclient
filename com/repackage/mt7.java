package com.repackage;

import android.content.Context;
import android.content.Intent;
import android.text.Layout;
import android.text.SpannableString;
import android.text.SpannableStringBuilder;
import android.text.TextUtils;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import androidx.core.view.InputDeviceCompat;
import com.baidu.adp.lib.util.StringUtils;
import com.baidu.tbadk.TbConfig;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.data.ThreadData;
import com.baidu.tbadk.core.util.ListUtils;
import com.baidu.tbadk.core.util.UtilHelper;
import com.baidu.tbadk.core.view.UserIconBox;
import com.baidu.tbadk.coreExtra.service.DealIntentService;
import com.baidu.tieba.R;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptable;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptorStorage;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
/* loaded from: classes6.dex */
public class mt7 {
    public static /* synthetic */ Interceptable $ic;
    public static final int a;
    public static final int b;
    public static final int[] c;
    public static TextView d;
    public transient /* synthetic */ FieldHolder $fh;

    static {
        InterceptResult invokeClinit;
        ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
        if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(-755487679, "Lcom/repackage/mt7;")) != null) {
            Interceptable interceptable = invokeClinit.interceptor;
            if (interceptable != null) {
                $ic = interceptable;
            }
            if ((invokeClinit.flags & 1) != 0) {
                classClinitInterceptable.invokePostClinit(-755487679, "Lcom/repackage/mt7;");
                return;
            }
        }
        a = li.f(TbadkCoreApplication.getInst().getContext(), R.dimen.tbds10);
        b = li.f(TbadkCoreApplication.getInst().getContext(), R.dimen.tbds8);
        c = new int[]{R.string.obfuscated_res_0x7f0f0fb9};
    }

    public static void a(int i, String str, TextView textView, TextView textView2, ImageView imageView, UserIconBox userIconBox, UserIconBox userIconBox2) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeCommon(65537, null, new Object[]{Integer.valueOf(i), str, textView, textView2, imageView, userIconBox, userIconBox2}) == null) || TextUtils.isEmpty(str) || textView == null || textView2 == null || imageView == null || userIconBox == null || userIconBox2 == null) {
            return;
        }
        int measureText = (int) textView.getPaint().measureText(str);
        int width = textView2.getVisibility() == 8 ? 0 : textView2.getWidth() + a;
        int width2 = imageView.getVisibility() == 8 ? 0 : imageView.getWidth() + a;
        int width3 = (i - (userIconBox2.getVisibility() == 8 ? 0 : (userIconBox2.getWidth() + b) + a)) - measureText;
        int i2 = width2 + width;
        if (width3 > (userIconBox.getVisibility() != 8 ? userIconBox.getWidth() + a : 0) + i2) {
            return;
        }
        if (width3 > i2) {
            userIconBox.setVisibility(8);
        } else if (width3 > width) {
            imageView.setVisibility(8);
            userIconBox.setVisibility(8);
        } else {
            textView2.setVisibility(8);
            imageView.setVisibility(8);
            userIconBox.setVisibility(8);
        }
    }

    public static int b() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(65538, null)) == null) ? c[0] : invokeV.intValue;
    }

    public static SpannableString c(ThreadData threadData) {
        InterceptResult invokeL;
        String string;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65539, null, threadData)) == null) {
            if (threadData == null) {
                return null;
            }
            if (threadData.getBJHContentTag() == 1) {
                string = TbadkCoreApplication.getInst().getString(R.string.obfuscated_res_0x7f0f1625);
            } else {
                string = threadData.getBJHContentTag() == 2 ? TbadkCoreApplication.getInst().getString(R.string.obfuscated_res_0x7f0f118c) : "";
            }
            if (TextUtils.isEmpty(string)) {
                return null;
            }
            SpannableString spannableString = new SpannableString(new StringBuilder(string).toString());
            spannableString.setSpan(new eu4(R.color.CAM_X0204, UtilHelper.getDimenPixelSize(R.dimen.tbds5), UtilHelper.getDimenPixelSize(R.dimen.tbds26), R.color.CAM_X0105, UtilHelper.getDimenPixelSize(R.dimen.tbds8), UtilHelper.getDimenPixelSize(R.dimen.tbds9), UtilHelper.getDimenPixelSize(R.dimen.tbds13)), 0, spannableString.length(), 17);
            return spannableString;
        }
        return (SpannableString) invokeL.objValue;
    }

    public static String d(String str) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeL = interceptable.invokeL(InputDeviceCompat.SOURCE_TRACKBALL, null, str)) == null) ? TbadkCoreApplication.getInst().getString(R.string.obfuscated_res_0x7f0f03cf, new Object[]{UtilHelper.getFixedBarText(str, 7, false)}) : (String) invokeL.objValue;
    }

    public static int e() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(65541, null)) == null) {
            return 28;
        }
        return invokeV.intValue;
    }

    public static Intent f(Context context, String str) {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(65542, null, context, str)) == null) {
            if (TextUtils.isEmpty(str) || context == null) {
                return null;
            }
            Intent intent = new Intent(context, DealIntentService.class);
            intent.putExtra(DealIntentService.KEY_CLASS, 1);
            intent.putExtra("id", str);
            intent.putExtra("from", "nas");
            intent.putExtra("key_start_from", 5);
            return intent;
        }
        return (Intent) invokeLL.objValue;
    }

    public static int g() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(65543, null)) == null) ? UtilHelper.getDimenPixelSize(R.dimen.tbds88) : invokeV.intValue;
    }

    public static String h(int i, Object... objArr) {
        InterceptResult invokeIL;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeIL = interceptable.invokeIL(65544, null, i, objArr)) == null) ? TbadkCoreApplication.getInst().getString(i, objArr) : (String) invokeIL.objValue;
    }

    public static int i(kp7 kp7Var) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65545, null, kp7Var)) == null) {
            if (kp7Var == null || kp7Var.O() == null) {
                return 0;
            }
            if (kp7Var.O().isMutiForumThread()) {
                return (ListUtils.isEmpty(kp7Var.p()) && (kp7Var.h() == null || StringUtils.isNull(kp7Var.h().a()))) ? 0 : 2;
            }
            return 1;
        }
        return invokeL.intValue;
    }

    public static Layout j(SpannableStringBuilder spannableStringBuilder) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65546, null, spannableStringBuilder)) == null) {
            Context context = TbadkCoreApplication.getInst().getContext();
            int k = li.k(context) - (li.f(context, R.dimen.tbds44) * 2);
            int contentSize = TbConfig.getContentSize();
            try {
                if (d == null) {
                    d = new TextView(TbadkCoreApplication.getInst().getContext());
                }
                TextView textView = d;
                if (textView.getLayoutParams() == null) {
                    textView.setLayoutParams(new ViewGroup.LayoutParams(-1, -2));
                }
                textView.setText(spannableStringBuilder);
                textView.setTextSize(0, contentSize);
                textView.setLineSpacing(TbConfig.getContentLineSpace(), 1.0f);
                textView.getPaint().setFakeBoldText(true);
                textView.measure(View.MeasureSpec.makeMeasureSpec(k, Integer.MIN_VALUE), View.MeasureSpec.makeMeasureSpec(0, 0));
                return textView.getLayout();
            } catch (Exception e) {
                e.printStackTrace();
                return null;
            }
        }
        return (Layout) invokeL.objValue;
    }

    public static void k(TextView textView) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(65547, null, textView) == null) || textView == null) {
            return;
        }
        textView.getPaint().setFakeBoldText(true);
    }
}
