package d.b.h0.r.u.e;

import android.graphics.Paint;
import android.text.Spanned;
import com.baidu.tbadk.core.elementsMaven.view.EMTextView;
/* loaded from: classes3.dex */
public class a {
    public static void a(Paint.FontMetricsInt fontMetricsInt, int i) {
        int i2 = fontMetricsInt.descent;
        int i3 = i2 - fontMetricsInt.ascent;
        if (i3 <= 0) {
            return;
        }
        int round = Math.round(i2 * ((i * 1.0f) / i3));
        fontMetricsInt.descent = round;
        fontMetricsInt.ascent = round - i;
    }

    public static boolean b(CharSequence charSequence) {
        if (charSequence instanceof Spanned) {
            Spanned spanned = (Spanned) charSequence;
            return ((EMTextView.a[]) spanned.getSpans(0, spanned.length(), EMTextView.a.class)).length > 0;
        }
        return false;
    }
}
