package tv.chushou.zues.widget.textview;

import android.content.Context;
import android.content.res.TypedArray;
import android.text.TextUtils;
import android.util.AttributeSet;
import android.widget.TextView;
/* loaded from: classes6.dex */
public class EllipsizedTextView extends TextView {
    private int mMaxLines;

    public EllipsizedTextView(Context context) {
        this(context, null, 0);
    }

    public EllipsizedTextView(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, 0);
    }

    public EllipsizedTextView(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        TypedArray obtainStyledAttributes = context.obtainStyledAttributes(attributeSet, new int[]{16843091}, i, 0);
        this.mMaxLines = obtainStyledAttributes.getInteger(0, 1);
        obtainStyledAttributes.recycle();
    }

    @Override // android.widget.TextView
    public void setText(CharSequence charSequence, TextView.BufferType bufferType) {
        if (getWidth() != 0 && this.mMaxLines <= 100) {
            charSequence = TextUtils.ellipsize(charSequence, getPaint(), getWidth() * this.mMaxLines, TextUtils.TruncateAt.END, false, null);
        }
        super.setText(charSequence, bufferType);
    }

    @Override // android.view.View
    protected void onSizeChanged(int i, int i2, int i3, int i4) {
        super.onSizeChanged(i, i2, i3, i4);
        if (i > 0 && i3 != i) {
            setText(getText());
        }
    }

    @Override // android.widget.TextView
    public void setMaxLines(int i) {
        super.setMaxLines(i);
        this.mMaxLines = i;
    }
}
