package tv.chushou.zues.widget.textview;

import android.content.Context;
import android.text.TextUtils;
import android.util.AttributeSet;
import com.facebook.drawee.span.SimpleDraweeSpanTextView;
/* loaded from: classes4.dex */
public class MarqueeTextView extends SimpleDraweeSpanTextView {
    public MarqueeTextView(Context context) {
        this(context, null, 0);
    }

    public MarqueeTextView(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, 0);
    }

    public MarqueeTextView(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        setMaxLines(1);
        setEllipsize(TextUtils.TruncateAt.MARQUEE);
    }

    @Override // android.view.View
    public boolean isFocused() {
        return true;
    }
}
