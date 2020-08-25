package tv.chushou.zues.widget.a;

import android.content.Context;
import android.content.res.Resources;
import android.graphics.drawable.Drawable;
import android.support.annotation.DimenRes;
import android.support.annotation.DrawableRes;
import android.support.v4.content.ContextCompat;
import android.text.style.ImageSpan;
import java.util.ArrayList;
import java.util.Iterator;
/* loaded from: classes6.dex */
public class c extends com.facebook.drawee.span.b {
    private int flag;

    public c() {
        super("");
        this.flag = 33;
    }

    public c a(CharSequence charSequence, Object... objArr) {
        append(charSequence);
        for (Object obj : objArr) {
            a(obj, length() - charSequence.length(), length());
        }
        return this;
    }

    public c a(CharSequence charSequence, ArrayList<Object> arrayList) {
        append(charSequence);
        Iterator<Object> it = arrayList.iterator();
        while (it.hasNext()) {
            a(it.next(), length() - charSequence.length(), length());
        }
        return this;
    }

    public c a(CharSequence charSequence, Object obj) {
        append(charSequence);
        a(obj, length() - charSequence.length(), length());
        return this;
    }

    public c a(CharSequence charSequence, ImageSpan imageSpan) {
        String str = "." + ((Object) charSequence);
        append(str);
        a(imageSpan, length() - str.length(), (length() - str.length()) + 1);
        return this;
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // android.text.SpannableStringBuilder, android.text.Editable, java.lang.Appendable
    /* renamed from: A */
    public c append(CharSequence charSequence) {
        super.append(charSequence);
        return this;
    }

    public c a(Context context, @DrawableRes int i, @DimenRes int i2, @DimenRes int i3) {
        Drawable drawable = ContextCompat.getDrawable(context, i);
        if (drawable != null) {
            Resources resources = context.getResources();
            drawable.setBounds(0, 0, resources.getDimensionPixelSize(i2), resources.getDimensionPixelSize(i3));
            a("", (ImageSpan) new e(drawable));
        }
        return this;
    }

    public c b(Context context, @DrawableRes int i, int i2, int i3) {
        Drawable drawable = ContextCompat.getDrawable(context, i);
        if (drawable != null) {
            drawable.setBounds(0, 0, i2, i3);
            a("", (ImageSpan) new e(drawable));
        }
        return this;
    }

    public c L(Context context, @DrawableRes int i) {
        Drawable drawable = ContextCompat.getDrawable(context, i);
        if (drawable != null) {
            drawable.setBounds(0, 0, drawable.getIntrinsicWidth(), drawable.getIntrinsicHeight());
            a("", (ImageSpan) new e(drawable));
        }
        return this;
    }

    private void a(Object obj, int i, int i2) {
        setSpan(obj, i, i2, this.flag);
    }
}
