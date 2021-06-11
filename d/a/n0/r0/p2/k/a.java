package d.a.n0.r0.p2.k;

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
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.util.SkinManager;
import com.baidu.tbadk.core.util.StatisticItem;
import com.baidu.tbadk.core.util.TiebaStatic;
import com.baidu.tieba.R;
import com.baidu.tieba.view.expandable.SpannableClickTextView;
import com.bumptech.glide.load.engine.GlideException;
import d.a.c.e.p.l;
/* loaded from: classes4.dex */
public class a {

    /* renamed from: a  reason: collision with root package name */
    public static final int f63084a = l.g(TbadkCoreApplication.getInst(), R.dimen.tbds33);

    /* renamed from: d.a.n0.r0.p2.k.a$a  reason: collision with other inner class name */
    /* loaded from: classes4.dex */
    public static class C1592a extends ClickableSpan {

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ String f63085e;

        /* renamed from: f  reason: collision with root package name */
        public final /* synthetic */ String f63086f;

        public C1592a(String str, String str2) {
            this.f63085e = str;
            this.f63086f = str2;
        }

        @Override // android.text.style.ClickableSpan
        public void onClick(View view) {
            if (StringUtils.isNull(this.f63085e)) {
                return;
            }
            StatisticItem statisticItem = new StatisticItem("c13313");
            statisticItem.param("tid", this.f63086f);
            TiebaStatic.log(statisticItem);
            d.a.m0.l.a.s(TbadkCoreApplication.getInst().getApplicationContext(), false, this.f63085e);
        }
    }

    /* loaded from: classes4.dex */
    public static class b extends ImageSpan {
        public b(Context context, int i2) {
            super(context, i2);
        }

        @Override // android.text.style.DynamicDrawableSpan, android.text.style.ReplacementSpan
        public void draw(Canvas canvas, CharSequence charSequence, int i2, int i3, float f2, int i4, int i5, int i6, Paint paint) {
            Drawable drawable = getDrawable();
            canvas.save();
            canvas.translate(f2, (((i6 - i4) - drawable.getBounds().bottom) / 2) + i4);
            drawable.draw(canvas);
            canvas.restore();
        }

        @Override // android.text.style.DynamicDrawableSpan, android.text.style.ReplacementSpan
        public int getSize(Paint paint, CharSequence charSequence, int i2, int i3, Paint.FontMetricsInt fontMetricsInt) {
            Rect bounds = getDrawable().getBounds();
            if (fontMetricsInt != null) {
                Paint.FontMetricsInt fontMetricsInt2 = paint.getFontMetricsInt();
                int i4 = fontMetricsInt2.bottom - fontMetricsInt2.top;
                int i5 = (bounds.bottom - bounds.top) / 2;
                int i6 = i4 / 4;
                int i7 = i5 - i6;
                int i8 = -(i5 + i6);
                fontMetricsInt.ascent = i8;
                fontMetricsInt.top = i8;
                fontMetricsInt.bottom = i7;
                fontMetricsInt.descent = i7;
            }
            return bounds.right;
        }
    }

    /* loaded from: classes4.dex */
    public static class c extends ReplacementSpan {

        /* renamed from: e  reason: collision with root package name */
        public int f63087e;

        /* renamed from: f  reason: collision with root package name */
        public int f63088f;

        public c(int i2, int i3) {
            this.f63087e = i2;
            this.f63088f = i3;
        }

        public final TextPaint a(Paint paint) {
            TextPaint textPaint = new TextPaint(paint);
            textPaint.setTextSize(this.f63087e);
            textPaint.setColor(this.f63088f);
            return textPaint;
        }

        @Override // android.text.style.ReplacementSpan
        public void draw(Canvas canvas, CharSequence charSequence, int i2, int i3, float f2, int i4, int i5, int i6, Paint paint) {
            CharSequence subSequence = charSequence.subSequence(i2, i3);
            TextPaint a2 = a(paint);
            Paint.FontMetricsInt fontMetricsInt = a2.getFontMetricsInt();
            canvas.drawText(subSequence.toString(), f2, i5 - (((((fontMetricsInt.descent + i5) + i5) + fontMetricsInt.ascent) / 2) - ((i6 + i4) / 2)), a2);
        }

        @Override // android.text.style.ReplacementSpan
        public int getSize(Paint paint, CharSequence charSequence, int i2, int i3, Paint.FontMetricsInt fontMetricsInt) {
            return (int) a(paint).measureText(charSequence.subSequence(i2, i3).toString());
        }
    }

    public static void a(Context context, TextView textView, String str, String str2, String str3) {
        if (context == null || textView == null || StringUtils.isNull(str)) {
            return;
        }
        int color = SkinManager.getColor(R.color.CAM_X0107);
        String str4 = str + GlideException.IndentedAppendable.INDENT;
        TextPaint paint = textView.getPaint();
        int g2 = l.p(context)[0] - (l.g(context, R.dimen.tbds48) * 2);
        int g3 = l.g(context, R.dimen.tbds116);
        int t = l.t(paint, " 广告");
        int t2 = l.t(paint, "...  ");
        int t3 = l.t(paint, str4);
        int g4 = l.g(context, R.dimen.tbds30);
        int i2 = t3 + g3 + t + g4;
        int i3 = g2 * 2;
        if (i2 >= i3) {
            str4 = b(paint, str4, (((i3 - g3) - t) - t2) - g4) + "...  ";
        } else if (i2 >= g2 && t3 < g2 && i2 >= g2) {
            str4 = str4.trim() + "\n";
        }
        SpannableStringBuilder spannableStringBuilder = new SpannableStringBuilder(str4);
        SpannableString spannableString = new SpannableString("_");
        spannableString.setSpan(new b(context, R.drawable.icon_video_middle_ad_link), 0, 1, 17);
        spannableString.setSpan(new C1592a(str2, str3), 0, 1, 17);
        spannableString.setSpan(new BackgroundColorSpan(0), 0, 1, 17);
        SpannableString spannableString2 = new SpannableString(" 广告");
        spannableString2.setSpan(new c(f63084a, color), 0, 3, 17);
        spannableStringBuilder.append((CharSequence) spannableString).append((CharSequence) spannableString2);
        textView.setHighlightColor(0);
        textView.setText(spannableStringBuilder);
        if (textView instanceof SpannableClickTextView) {
            ((SpannableClickTextView) textView).setCustomMovementMethod();
        } else {
            textView.setMovementMethod(LinkMovementMethod.getInstance());
        }
        StatisticItem statisticItem = new StatisticItem("c13312");
        statisticItem.param("tid", str3);
        TiebaStatic.log(statisticItem);
    }

    public static String b(Paint paint, String str, int i2) {
        String str2 = str;
        for (int length = str.length() - 1; l.t(paint, str2) > i2 && length > 0; length--) {
            str2 = str.substring(0, length);
        }
        return str2;
    }
}
