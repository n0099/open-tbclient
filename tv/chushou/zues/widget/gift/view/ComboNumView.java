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
/* loaded from: classes5.dex */
public class ComboNumView extends LinearLayout {
    private static c<Drawable> nQA;
    private static int nQz = 0;
    protected Context mContext;
    private int mType;
    private ImageView nQy;

    public ComboNumView(Context context) {
        this(context, null);
    }

    public ComboNumView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        init(context);
    }

    private void init(Context context) {
        nQz++;
        this.mContext = context;
        setOrientation(0);
        this.nQy = new ImageView(this.mContext);
        this.nQy.setBackgroundResource(b.d.zues_icon_x_n);
        this.nQy.setTag(Config.EVENT_HEAT_X);
        addView(this.nQy);
    }

    @Override // android.view.ViewGroup, android.view.View
    protected void onDetachedFromWindow() {
        nQz--;
        if (nQz <= 0) {
            nQz = 0;
            release();
        }
        super.onDetachedFromWindow();
    }

    public void release() {
        if (nQA != null) {
            nQA.clear();
            nQA = null;
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

    private String SB(String str) {
        return "game_" + str;
    }

    private Drawable getDrawable(String str) {
        Drawable drawable;
        if (nQA == null) {
            nQA = new c<>(20);
        }
        Drawable drawable2 = nQA.get(SB(str));
        if (drawable2 == null) {
            int identifier = this.mContext.getResources().getIdentifier("zues_icon_" + str, "drawable", this.mContext.getPackageName());
            if (identifier > 0 && (drawable = ContextCompat.getDrawable(this.mContext, identifier)) != null) {
                nQA.put(SB(str), drawable);
                return drawable;
            }
            return null;
        }
        return drawable2;
    }

    public void setType(int i) {
        this.nQy.setBackgroundResource(b.d.zues_icon_x_n);
        this.mType = i;
    }
}
