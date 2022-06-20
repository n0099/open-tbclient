package com.repackage;

import android.app.Activity;
import android.content.Context;
import android.text.SpannableString;
import android.text.method.LinkMovementMethod;
import android.text.style.AbsoluteSizeSpan;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import com.baidu.tbadk.TbPageContext;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.elementsMaven.view.EMTextView;
import com.baidu.tbadk.core.util.SkinManager;
import com.baidu.tbadk.core.view.commonBtn.TBSpecificationBtn;
import com.baidu.tieba.R;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import java.util.Arrays;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import kotlin.jvm.JvmName;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.StringCompanionObject;
import kotlin.text.StringsKt__StringsKt;
@JvmName(name = "PrivacyPolicyDialogUtil")
/* loaded from: classes6.dex */
public final class oi5 {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    /* loaded from: classes6.dex */
    public static final class a extends ni5 {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ Context a;

        public a(Context context) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {context};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = context;
        }

        @Override // android.text.style.ClickableSpan
        public void onClick(View widget) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, widget) == null) {
                Intrinsics.checkNotNullParameter(widget, "widget");
                cl4.l(this.a, "http://tieba.baidu.com/tb/mobile/wisemainstatic/secretright.html");
            }
        }
    }

    /* loaded from: classes6.dex */
    public static final class b extends ni5 {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ Context a;

        public b(Context context) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {context};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = context;
        }

        @Override // android.text.style.ClickableSpan
        public void onClick(View widget) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, widget) == null) {
                Intrinsics.checkNotNullParameter(widget, "widget");
                cl4.l(this.a, "https://gsp0.baidu.com/5aAHeD3nKhI2p27j8IqW0jdnxx1xbK/tb/eula.html");
            }
        }
    }

    public static final nq4 a(TbPageContext<?> tbPageContext, View.OnClickListener listener, int i, int i2) {
        InterceptResult invokeLLII;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLLII = interceptable.invokeLLII(65536, null, tbPageContext, listener, i, i2)) == null) {
            Intrinsics.checkNotNullParameter(tbPageContext, "tbPageContext");
            Intrinsics.checkNotNullParameter(listener, "listener");
            View inflate = LayoutInflater.from(tbPageContext.getPageActivity()).inflate(R.layout.obfuscated_res_0x7f0d06ea, (ViewGroup) null);
            Intrinsics.checkNotNullExpressionValue(inflate, "from(tbPageContext.pageA…olicy_guide_dialog, null)");
            EMTextView eMTextView = (EMTextView) inflate.findViewById(R.id.obfuscated_res_0x7f092017);
            eMTextView.setText(R.string.obfuscated_res_0x7f0f10ef);
            fr4 d = fr4.d(eMTextView);
            d.A(R.string.F_X02);
            d.z(R.dimen.T_X05);
            EMTextView eMTextView2 = (EMTextView) inflate.findViewById(R.id.obfuscated_res_0x7f0906a9);
            eMTextView2.setHighlightColor(0);
            StringCompanionObject stringCompanionObject = StringCompanionObject.INSTANCE;
            String string = tbPageContext.getString(i);
            Intrinsics.checkNotNullExpressionValue(string, "tbPageContext.getString(contentTestResId)");
            String format = String.format(string, Arrays.copyOf(new Object[]{tbPageContext.getString(R.string.obfuscated_res_0x7f0f0eef), tbPageContext.getString(R.string.obfuscated_res_0x7f0f14fe)}, 2));
            Intrinsics.checkNotNullExpressionValue(format, "java.lang.String.format(format, *args)");
            Activity pageActivity = tbPageContext.getPageActivity();
            Intrinsics.checkNotNullExpressionValue(pageActivity, "tbPageContext.pageActivity");
            SpannableString d2 = d(pageActivity, format);
            eMTextView2.setMovementMethod(LinkMovementMethod.getInstance());
            eMTextView2.setText(d2);
            fr4.d(eMTextView2).z(R.dimen.T_X07);
            EMTextView eMTextView3 = (EMTextView) inflate.findViewById(R.id.obfuscated_res_0x7f0903e8);
            eMTextView3.setText(i2);
            fr4.d(eMTextView3).z(R.dimen.T_X08);
            eMTextView3.setOnClickListener(listener);
            TBSpecificationBtn tBSpecificationBtn = (TBSpecificationBtn) inflate.findViewById(R.id.obfuscated_res_0x7f092478);
            tBSpecificationBtn.setText(tbPageContext.getString(R.string.obfuscated_res_0x7f0f10e3));
            tBSpecificationBtn.setTextSize(R.dimen.T_X07);
            xt4 xt4Var = new xt4();
            xt4Var.p(R.color.CAM_X0303, R.color.CAM_X0101);
            tBSpecificationBtn.setConfig(xt4Var);
            tBSpecificationBtn.setOnClickListener(listener);
            nq4 nq4Var = new nq4(tbPageContext.getPageActivity());
            nq4Var.setContentView(inflate);
            nq4Var.setContentViewSize(8);
            nq4Var.setAutoNight(false);
            nq4Var.setCanceledOnTouchOutside(false);
            nq4Var.setCancelable(false);
            nq4Var.create(tbPageContext);
            return nq4Var;
        }
        return (nq4) invokeLLII.objValue;
    }

    public static final nq4 b(TbPageContext<?> tbPageContext, View.OnClickListener listener) {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(65537, null, tbPageContext, listener)) == null) {
            Intrinsics.checkNotNullParameter(tbPageContext, "tbPageContext");
            Intrinsics.checkNotNullParameter(listener, "listener");
            View inflate = LayoutInflater.from(tbPageContext.getPageActivity()).inflate(R.layout.obfuscated_res_0x7f0d06eb, (ViewGroup) null);
            Intrinsics.checkNotNullExpressionValue(inflate, "from(tbPageContext.pageA…rivate_hint_dialog, null)");
            ((TextView) inflate.findViewById(R.id.obfuscated_res_0x7f0918f5)).setText(R.string.obfuscated_res_0x7f0f10ef);
            inflate.findViewById(R.id.obfuscated_res_0x7f091939).setVisibility(0);
            TextView textView = (TextView) inflate.findViewById(R.id.obfuscated_res_0x7f09193a);
            textView.setHighlightColor(0);
            StringCompanionObject stringCompanionObject = StringCompanionObject.INSTANCE;
            String string = tbPageContext.getString(R.string.obfuscated_res_0x7f0f10ee);
            Intrinsics.checkNotNullExpressionValue(string, "tbPageContext.getString(…tring.secret_hint_format)");
            String format = String.format(string, Arrays.copyOf(new Object[]{tbPageContext.getString(R.string.obfuscated_res_0x7f0f10ed), tbPageContext.getString(R.string.obfuscated_res_0x7f0f10f2), tbPageContext.getString(R.string.obfuscated_res_0x7f0f10e6), tbPageContext.getString(R.string.obfuscated_res_0x7f0f10e7), tbPageContext.getString(R.string.obfuscated_res_0x7f0f10e8), tbPageContext.getString(R.string.obfuscated_res_0x7f0f10e9), tbPageContext.getString(R.string.obfuscated_res_0x7f0f10ea)}, 7));
            Intrinsics.checkNotNullExpressionValue(format, "java.lang.String.format(format, *args)");
            Activity pageActivity = tbPageContext.getPageActivity();
            Intrinsics.checkNotNullExpressionValue(pageActivity, "tbPageContext.pageActivity");
            SpannableString d = d(pageActivity, format);
            Matcher matcher = Pattern.compile("\n\n").matcher(format);
            while (matcher.find()) {
                d.setSpan(new AbsoluteSizeSpan(2, true), matcher.start() + 1, matcher.end(), 33);
            }
            textView.setMovementMethod(LinkMovementMethod.getInstance());
            textView.setText(d);
            TextView textView2 = (TextView) inflate.findViewById(R.id.obfuscated_res_0x7f0918f1);
            textView2.setOnClickListener(listener);
            SkinManager.setViewTextColorSelector(textView2, R.color.CAM_X0110, R.color.CAM_X0110, 0);
            TextView textView3 = (TextView) inflate.findViewById(R.id.obfuscated_res_0x7f0918f6);
            textView3.setOnClickListener(listener);
            fr4 d2 = fr4.d(textView3);
            d2.n(R.string.J_X01);
            d2.f(R.color.CAM_X0303);
            SkinManager.setViewTextColorSelector(textView3, R.color.CAM_X0101, R.color.CAM_X0618, 0);
            nq4 nq4Var = new nq4(tbPageContext.getPageActivity());
            nq4Var.setContentView(inflate);
            nq4Var.setContentViewSize(7);
            nq4Var.setCanceledOnTouchOutside(false);
            nq4Var.setAutoNight(false);
            nq4Var.setCancelable(false);
            nq4Var.create(tbPageContext);
            return nq4Var;
        }
        return (nq4) invokeLL.objValue;
    }

    public static final int[] c(String str, int i) {
        InterceptResult invokeLI;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLI = interceptable.invokeLI(65538, null, str, i)) == null) {
            String string = TbadkCoreApplication.getInst().getString(i);
            Intrinsics.checkNotNullExpressionValue(string, "getInst().getString(patternTextResId)");
            int[] iArr = {StringsKt__StringsKt.indexOf$default((CharSequence) str, string, 0, false, 6, (Object) null), iArr[0] + string.length()};
            return iArr;
        }
        return (int[]) invokeLI.objValue;
    }

    public static final SpannableString d(Context context, String str) {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(65539, null, context, str)) == null) {
            SpannableString spannableString = new SpannableString(str);
            int[] c = c(str, R.string.obfuscated_res_0x7f0f0eef);
            if (c[0] != -1) {
                spannableString.setSpan(new a(context), c[0], c[1], 18);
            }
            int[] c2 = c(str, R.string.obfuscated_res_0x7f0f14fe);
            if (c2[0] != -1) {
                spannableString.setSpan(new b(context), c2[0], c2[1], 18);
            }
            return spannableString;
        }
        return (SpannableString) invokeLL.objValue;
    }
}
