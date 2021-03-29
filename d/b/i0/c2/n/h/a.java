package d.b.i0.c2.n.h;

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
import com.bumptech.glide.load.engine.GlideException;
import d.b.b.e.p.l;
/* loaded from: classes5.dex */
public class a {

    /* renamed from: a  reason: collision with root package name */
    public static final int f53166a = l.g(TbadkCoreApplication.getInst(), R.dimen.tbds33);

    /* renamed from: d.b.i0.c2.n.h.a$a  reason: collision with other inner class name */
    /* loaded from: classes5.dex */
    public static class C1172a extends ClickableSpan {

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ String f53167e;

        /* renamed from: f  reason: collision with root package name */
        public final /* synthetic */ String f53168f;

        public C1172a(String str, String str2) {
            this.f53167e = str;
            this.f53168f = str2;
        }

        @Override // android.text.style.ClickableSpan
        public void onClick(View view) {
            if (StringUtils.isNull(this.f53167e)) {
                return;
            }
            StatisticItem statisticItem = new StatisticItem("c13313");
            statisticItem.param("tid", this.f53168f);
            TiebaStatic.log(statisticItem);
            d.b.h0.l.a.s(TbadkCoreApplication.getInst().getApplicationContext(), false, this.f53167e);
        }
    }

    /* loaded from: classes5.dex */
    public static class b extends ImageSpan {
        public b(Drawable drawable, int i) {
            super(drawable, i);
        }

        @Override // android.text.style.DynamicDrawableSpan, android.text.style.ReplacementSpan
        public void draw(Canvas canvas, CharSequence charSequence, int i, int i2, float f2, int i3, int i4, int i5, Paint paint) {
            Drawable drawable = getDrawable();
            canvas.save();
            canvas.translate(f2, (((i5 - i3) - drawable.getBounds().bottom) / 2) + i3);
            drawable.draw(canvas);
            canvas.restore();
        }

        @Override // android.text.style.DynamicDrawableSpan, android.text.style.ReplacementSpan
        public int getSize(Paint paint, CharSequence charSequence, int i, int i2, Paint.FontMetricsInt fontMetricsInt) {
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
    }

    /* loaded from: classes5.dex */
    public static class c extends ReplacementSpan {

        /* renamed from: e  reason: collision with root package name */
        public int f53169e;

        /* renamed from: f  reason: collision with root package name */
        public int f53170f;

        public c(int i, int i2) {
            this.f53169e = i;
            this.f53170f = i2;
        }

        public final TextPaint a(Paint paint) {
            TextPaint textPaint = new TextPaint(paint);
            textPaint.setTextSize(this.f53169e);
            textPaint.setColor(this.f53170f);
            return textPaint;
        }

        @Override // android.text.style.ReplacementSpan
        public void draw(Canvas canvas, CharSequence charSequence, int i, int i2, float f2, int i3, int i4, int i5, Paint paint) {
            CharSequence subSequence = charSequence.subSequence(i, i2);
            TextPaint a2 = a(paint);
            Paint.FontMetricsInt fontMetricsInt = a2.getFontMetricsInt();
            canvas.drawText(subSequence.toString(), f2, i4 - (((((fontMetricsInt.descent + i4) + i4) + fontMetricsInt.ascent) / 2) - ((i5 + i3) / 2)), a2);
        }

        @Override // android.text.style.ReplacementSpan
        public int getSize(Paint paint, CharSequence charSequence, int i, int i2, Paint.FontMetricsInt fontMetricsInt) {
            return (int) a(paint).measureText(charSequence.subSequence(i, i2).toString());
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
        int i = t3 + g3 + t + g4;
        int i2 = g2 * 2;
        if (i >= i2) {
            str4 = b(paint, str4, (((i2 - g3) - t) - t2) - g4) + "...  ";
        } else if (i >= g2 && t3 < g2 && i >= g2) {
            str4 = str4.trim() + "\n";
        }
        SpannableStringBuilder spannableStringBuilder = new SpannableStringBuilder(str4);
        SpannableString spannableString = new SpannableString("_");
        Drawable drawable = SkinManager.getDrawable(R.drawable.icon_video_pb_ad_link);
        drawable.setBounds(0, 0, drawable.getIntrinsicWidth(), drawable.getIntrinsicHeight());
        spannableString.setSpan(new b(drawable, 0), 0, 1, 17);
        spannableString.setSpan(new C1172a(str2, str3), 0, 1, 17);
        spannableString.setSpan(new BackgroundColorSpan(0), 0, 1, 17);
        SpannableString spannableString2 = new SpannableString(" 广告");
        spannableString2.setSpan(new c(f53166a, color), 0, 3, 17);
        spannableStringBuilder.append((CharSequence) spannableString).append((CharSequence) spannableString2);
        textView.setHighlightColor(0);
        textView.setText(spannableStringBuilder);
        textView.setMovementMethod(LinkMovementMethod.getInstance());
        StatisticItem statisticItem = new StatisticItem("c13312");
        statisticItem.param("tid", str3);
        TiebaStatic.log(statisticItem);
    }

    public static String b(Paint paint, String str, int i) {
        String str2 = str;
        for (int length = str.length() - 1; l.t(paint, str2) > i && length > 0; length--) {
            str2 = str.substring(0, length);
        }
        return str2;
    }
}
