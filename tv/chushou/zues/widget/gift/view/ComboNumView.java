package tv.chushou.zues.widget.gift.view;

import android.content.Context;
import android.graphics.drawable.Drawable;
import android.support.v4.content.ContextCompat;
import android.util.AttributeSet;
import android.view.View;
import android.widget.ImageView;
import android.widget.LinearLayout;
import com.baidu.mobstat.Config;
import tv.chushou.zues.b;
import tv.chushou.zues.toolkit.a.b.c;
/* loaded from: classes4.dex */
public class ComboNumView extends LinearLayout {
    private static int nXG = 0;
    private static c<Drawable> nXH;
    protected Context mContext;
    private int mType;
    private ImageView nXF;

    public ComboNumView(Context context) {
        this(context, null);
    }

    public ComboNumView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        init(context);
    }

    private void init(Context context) {
        nXG++;
        this.mContext = context;
        setOrientation(0);
        this.nXF = new ImageView(this.mContext);
        this.nXF.setBackgroundResource(b.d.zues_icon_x_n);
        this.nXF.setTag(Config.EVENT_HEAT_X);
        addView(this.nXF);
    }

    @Override // android.view.ViewGroup, android.view.View
    protected void onDetachedFromWindow() {
        nXG--;
        if (nXG <= 0) {
            nXG = 0;
            release();
        }
        super.onDetachedFromWindow();
    }

    public void release() {
        if (nXH != null) {
            nXH.clear();
            nXH = null;
        }
    }

    public void setNumber(int i) {
        if (i <= 0) {
            setVisibility(8);
            return;
        }
        setVisibility(0);
        String valueOf = String.valueOf(i);
        int length = valueOf.length();
        for (int i2 = 0; i2 < length; i2++) {
            Drawable drawable = getDrawable(valueOf.substring(i2, i2 + 1));
            if (drawable != null) {
                View childAt = getChildAt(i2 + 1);
                if (childAt == null) {
                    ImageView imageView = new ImageView(this.mContext);
                    imageView.setBackgroundDrawable(drawable);
                    addView(imageView);
                } else {
                    ImageView imageView2 = (ImageView) childAt;
                    imageView2.setBackgroundDrawable(drawable);
                    imageView2.setVisibility(0);
                }
            }
        }
        int childCount = getChildCount();
        for (int i3 = length + 1; i3 < childCount; i3++) {
            View childAt2 = getChildAt(i3);
            if (childAt2 != null) {
                childAt2.setVisibility(8);
            }
        }
    }

    private String SQ(String str) {
        return "game_" + str;
    }

    private Drawable getDrawable(String str) {
        Drawable drawable;
        if (nXH == null) {
            nXH = new c<>(20);
        }
        Drawable drawable2 = nXH.get(SQ(str));
        if (drawable2 == null) {
            int identifier = this.mContext.getResources().getIdentifier("zues_icon_" + str, "drawable", this.mContext.getPackageName());
            if (identifier > 0 && (drawable = ContextCompat.getDrawable(this.mContext, identifier)) != null) {
                nXH.put(SQ(str), drawable);
                return drawable;
            }
            return null;
        }
        return drawable2;
    }

    public void setType(int i) {
        this.nXF.setBackgroundResource(b.d.zues_icon_x_n);
        this.mType = i;
    }
}
