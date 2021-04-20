package d.b.i0.s2.c0.c;

import android.text.TextPaint;
import android.text.TextUtils;
import com.bumptech.glide.load.engine.GlideException;
/* loaded from: classes4.dex */
public class a {
    public static int a(int i) {
        return (int) ((i * 9.0d) / 16.0d);
    }

    public static int b(int i) {
        return (int) ((i * 16.0d) / 9.0d);
    }

    public static int c(int i) {
        return (int) ((i * 9.0d) / 16.0d);
    }

    public static String d(String str, String str2, float f2, TextPaint textPaint) {
        if (TextUtils.isEmpty(str2)) {
            str2 = "";
        }
        if (TextUtils.isEmpty(str)) {
            str = "";
        }
        if (textPaint == null) {
            textPaint = new TextPaint();
        }
        CharSequence ellipsize = TextUtils.ellipsize(str, textPaint, f2 - textPaint.measureText(GlideException.IndentedAppendable.INDENT + str2), TextUtils.TruncateAt.END);
        if (ellipsize != null) {
            return ellipsize.toString() + GlideException.IndentedAppendable.INDENT + str2;
        }
        return str2;
    }
}
