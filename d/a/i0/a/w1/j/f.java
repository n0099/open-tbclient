package d.a.i0.a.w1.j;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.Rect;
import android.graphics.drawable.Drawable;
import android.text.SpannableString;
import android.text.style.ImageSpan;
import androidx.annotation.NonNull;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
/* loaded from: classes3.dex */
public class f {

    /* loaded from: classes3.dex */
    public static class a extends ImageSpan {
        public a(Context context, Bitmap bitmap) {
            super(context, bitmap);
        }

        @Override // android.text.style.DynamicDrawableSpan, android.text.style.ReplacementSpan
        public void draw(@NonNull Canvas canvas, CharSequence charSequence, int i2, int i3, float f2, int i4, int i5, int i6, @NonNull Paint paint) {
            Drawable drawable = getDrawable();
            Paint.FontMetricsInt fontMetricsInt = paint.getFontMetricsInt();
            if (i4 != 0) {
                i4 -= 4;
            }
            canvas.save();
            canvas.translate(f2, i4 + (((fontMetricsInt.bottom - fontMetricsInt.top) - drawable.getBounds().bottom) / 2));
            drawable.draw(canvas);
            canvas.restore();
        }

        @Override // android.text.style.DynamicDrawableSpan, android.text.style.ReplacementSpan
        public int getSize(@NonNull Paint paint, CharSequence charSequence, int i2, int i3, Paint.FontMetricsInt fontMetricsInt) {
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
                int i9 = i7 + 8;
                fontMetricsInt.bottom = i9;
                fontMetricsInt.descent = i9;
            }
            return bounds.right + 5;
        }
    }

    /* loaded from: classes3.dex */
    public static class b extends ImageSpan {
        public b(Context context, Bitmap bitmap) {
            super(context, bitmap);
        }

        @Override // android.text.style.DynamicDrawableSpan, android.text.style.ReplacementSpan
        public void draw(@NonNull Canvas canvas, CharSequence charSequence, int i2, int i3, float f2, int i4, int i5, int i6, @NonNull Paint paint) {
            Drawable drawable = getDrawable();
            Paint.FontMetricsInt fontMetricsInt = paint.getFontMetricsInt();
            if (i4 != 0) {
                i4 -= 4;
            }
            canvas.save();
            canvas.translate(f2, i4 + (((fontMetricsInt.bottom - fontMetricsInt.top) - drawable.getBounds().bottom) / 2));
            drawable.draw(canvas);
            canvas.restore();
        }

        @Override // android.text.style.DynamicDrawableSpan, android.text.style.ReplacementSpan
        public int getSize(@NonNull Paint paint, CharSequence charSequence, int i2, int i3, Paint.FontMetricsInt fontMetricsInt) {
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
                int i9 = i7 + 3;
                fontMetricsInt.bottom = i9;
                fontMetricsInt.descent = i9;
            }
            return bounds.right + 5;
        }
    }

    public static int a(String str) {
        SpannableString spannableString = new SpannableString(str);
        int length = str.length();
        Matcher matcher = Pattern.compile("\\[([一-龥\\w])+\\]").matcher(spannableString);
        int i2 = 0;
        int i3 = 0;
        while (matcher.find()) {
            i2 += matcher.group().length();
            i3++;
        }
        return (length - i2) + i3;
    }
}
