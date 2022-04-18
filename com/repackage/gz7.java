package com.repackage;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.Rect;
import android.graphics.drawable.Drawable;
import android.text.SpannableString;
import android.text.SpannableStringBuilder;
import android.text.TextPaint;
import android.text.method.LinkMovementMethod;
import android.text.style.BackgroundColorSpan;
import android.text.style.ClickableSpan;
import android.text.style.ImageSpan;
import android.text.style.ReplacementSpan;
import android.view.View;
import android.widget.TextView;
import com.baidu.adp.lib.util.StringUtils;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.util.SkinManager;
import com.baidu.tbadk.core.util.StatisticItem;
import com.baidu.tbadk.core.util.TiebaStatic;
import com.baidu.tieba.R;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptable;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptorStorage;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import com.bumptech.glide.load.engine.GlideException;
/* loaded from: classes6.dex */
public class gz7 {
    public static /* synthetic */ Interceptable $ic;
    public static final int a;
    public transient /* synthetic */ FieldHolder $fh;

    /* loaded from: classes6.dex */
    public static class a extends ClickableSpan {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ String a;
        public final /* synthetic */ String b;

        public a(String str, String str2) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {str, str2};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = str;
            this.b = str2;
        }

        @Override // android.text.style.ClickableSpan
        public void onClick(View view2) {
            Interceptable interceptable = $ic;
            if (!(interceptable == null || interceptable.invokeL(1048576, this, view2) == null) || StringUtils.isNull(this.a)) {
                return;
            }
            StatisticItem statisticItem = new StatisticItem("c13313");
            statisticItem.param("tid", this.b);
            TiebaStatic.log(statisticItem);
            ul4.v(TbadkCoreApplication.getInst().getApplicationContext(), false, this.a);
        }
    }

    /* loaded from: classes6.dex */
    public static class b extends ImageSpan {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public b(Drawable drawable, int i) {
            super(drawable, i);
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {drawable, Integer.valueOf(i)};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    Object[] objArr2 = newInitContext.callArgs;
                    super((Drawable) objArr2[0], ((Integer) objArr2[1]).intValue());
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
        }

        @Override // android.text.style.DynamicDrawableSpan, android.text.style.ReplacementSpan
        public void draw(Canvas canvas, CharSequence charSequence, int i, int i2, float f, int i3, int i4, int i5, Paint paint) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeCommon(1048576, this, new Object[]{canvas, charSequence, Integer.valueOf(i), Integer.valueOf(i2), Float.valueOf(f), Integer.valueOf(i3), Integer.valueOf(i4), Integer.valueOf(i5), paint}) == null) {
                Drawable drawable = getDrawable();
                canvas.save();
                canvas.translate(f, (((i5 - i3) - drawable.getBounds().bottom) / 2) + i3);
                drawable.draw(canvas);
                canvas.restore();
            }
        }

        @Override // android.text.style.DynamicDrawableSpan, android.text.style.ReplacementSpan
        public int getSize(Paint paint, CharSequence charSequence, int i, int i2, Paint.FontMetricsInt fontMetricsInt) {
            InterceptResult invokeCommon;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeCommon = interceptable.invokeCommon(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, new Object[]{paint, charSequence, Integer.valueOf(i), Integer.valueOf(i2), fontMetricsInt})) == null) {
                Rect bounds = getDrawable().getBounds();
                if (fontMetricsInt != null) {
                    Paint.FontMetricsInt fontMetricsInt2 = paint.getFontMetricsInt();
                    int i3 = fontMetricsInt2.bottom - fontMetricsInt2.top;
                    int i4 = (bounds.bottom - bounds.top) / 2;
                    int i5 = i3 / 4;
                    int i6 = i4 - i5;
                    int i7 = -(i4 + i5);
                    fontMetricsInt.ascent = i7;
                    fontMetricsInt.top = i7;
                    fontMetricsInt.bottom = i6;
                    fontMetricsInt.descent = i6;
                }
                return bounds.right;
            }
            return invokeCommon.intValue;
        }
    }

    /* loaded from: classes6.dex */
    public static class c extends ReplacementSpan {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public int a;
        public int b;

        public c(int i, int i2) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {Integer.valueOf(i), Integer.valueOf(i2)};
                interceptable.invokeUnInit(65536, newInitContext);
                int i3 = newInitContext.flag;
                if ((i3 & 1) != 0) {
                    int i4 = i3 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = i;
            this.b = i2;
        }

        public final TextPaint a(Paint paint) {
            InterceptResult invokeL;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeL = interceptable.invokeL(1048576, this, paint)) == null) {
                TextPaint textPaint = new TextPaint(paint);
                textPaint.setTextSize(this.a);
                textPaint.setColor(this.b);
                return textPaint;
            }
            return (TextPaint) invokeL.objValue;
        }

        @Override // android.text.style.ReplacementSpan
        public void draw(Canvas canvas, CharSequence charSequence, int i, int i2, float f, int i3, int i4, int i5, Paint paint) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeCommon(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, new Object[]{canvas, charSequence, Integer.valueOf(i), Integer.valueOf(i2), Float.valueOf(f), Integer.valueOf(i3), Integer.valueOf(i4), Integer.valueOf(i5), paint}) == null) {
                CharSequence subSequence = charSequence.subSequence(i, i2);
                TextPaint a = a(paint);
                Paint.FontMetricsInt fontMetricsInt = a.getFontMetricsInt();
                canvas.drawText(subSequence.toString(), f, i4 - (((((fontMetricsInt.descent + i4) + i4) + fontMetricsInt.ascent) / 2) - ((i5 + i3) / 2)), a);
            }
        }

        @Override // android.text.style.ReplacementSpan
        public int getSize(Paint paint, CharSequence charSequence, int i, int i2, Paint.FontMetricsInt fontMetricsInt) {
            InterceptResult invokeCommon;
            Interceptable interceptable = $ic;
            return (interceptable == null || (invokeCommon = interceptable.invokeCommon(Constants.METHOD_SEND_USER_MSG, this, new Object[]{paint, charSequence, Integer.valueOf(i), Integer.valueOf(i2), fontMetricsInt})) == null) ? (int) a(paint).measureText(charSequence.subSequence(i, i2).toString()) : invokeCommon.intValue;
        }
    }

    static {
        InterceptResult invokeClinit;
        ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
        if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(-755660659, "Lcom/repackage/gz7;")) != null) {
            Interceptable interceptable = invokeClinit.interceptor;
            if (interceptable != null) {
                $ic = interceptable;
            }
            if ((invokeClinit.flags & 1) != 0) {
                classClinitInterceptable.invokePostClinit(-755660659, "Lcom/repackage/gz7;");
                return;
            }
        }
        a = oi.f(TbadkCoreApplication.getInst(), R.dimen.tbds33);
    }

    public static void a(Context context, TextView textView, String str, String str2, String str3) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeLLLLL(65537, null, context, textView, str, str2, str3) == null) || context == null || textView == null || StringUtils.isNull(str)) {
            return;
        }
        int color = SkinManager.getColor(R.color.CAM_X0107);
        String str4 = str + GlideException.IndentedAppendable.INDENT;
        TextPaint paint = textView.getPaint();
        int f = oi.p(context)[0] - (oi.f(context, R.dimen.tbds48) * 2);
        int f2 = oi.f(context, R.dimen.tbds116);
        int t = oi.t(paint, " 广告");
        int t2 = oi.t(paint, "...  ");
        int t3 = oi.t(paint, str4);
        int f3 = oi.f(context, R.dimen.tbds30);
        int i = t3 + f2 + t + f3;
        int i2 = f * 2;
        if (i >= i2) {
            str4 = b(paint, str4, (((i2 - f2) - t) - t2) - f3) + "...  ";
        } else if (i >= f && t3 < f && i >= f) {
            str4 = str4.trim() + "\n";
        }
        SpannableStringBuilder spannableStringBuilder = new SpannableStringBuilder(str4);
        SpannableString spannableString = new SpannableString("_");
        Drawable drawable = SkinManager.getDrawable(R.drawable.icon_video_pb_ad_link);
        drawable.setBounds(0, 0, drawable.getIntrinsicWidth(), drawable.getIntrinsicHeight());
        spannableString.setSpan(new b(drawable, 0), 0, 1, 17);
        spannableString.setSpan(new a(str2, str3), 0, 1, 17);
        spannableString.setSpan(new BackgroundColorSpan(0), 0, 1, 17);
        SpannableString spannableString2 = new SpannableString(" 广告");
        spannableString2.setSpan(new c(a, color), 0, 3, 17);
        spannableStringBuilder.append((CharSequence) spannableString).append((CharSequence) spannableString2);
        textView.setHighlightColor(0);
        textView.setText(spannableStringBuilder);
        textView.setMovementMethod(LinkMovementMethod.getInstance());
        StatisticItem statisticItem = new StatisticItem("c13312");
        statisticItem.param("tid", str3);
        TiebaStatic.log(statisticItem);
    }

    public static String b(Paint paint, String str, int i) {
        InterceptResult invokeLLI;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLLI = interceptable.invokeLLI(65538, null, paint, str, i)) == null) {
            String str2 = str;
            for (int length = str.length() - 1; oi.t(paint, str2) > i && length > 0; length--) {
                str2 = str.substring(0, length);
            }
            return str2;
        }
        return (String) invokeLLI.objValue;
    }
}
