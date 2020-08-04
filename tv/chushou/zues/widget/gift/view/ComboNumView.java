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
/* loaded from: classes6.dex */
public class ComboNumView extends LinearLayout {
    private static int ouY = 0;
    private static c<Drawable> ouZ;
    protected Context mContext;
    private int mType;
    private ImageView ouX;

    public ComboNumView(Context context) {
        this(context, null);
    }

    public ComboNumView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        init(context);
    }

    private void init(Context context) {
        ouY++;
        this.mContext = context;
        setOrientation(0);
        this.ouX = new ImageView(this.mContext);
        this.ouX.setBackgroundResource(b.d.zues_icon_x_n);
        this.ouX.setTag(Config.EVENT_HEAT_X);
        addView(this.ouX);
    }

    @Override // android.view.ViewGroup, android.view.View
    protected void onDetachedFromWindow() {
        ouY--;
        if (ouY <= 0) {
            ouY = 0;
            release();
        }
        super.onDetachedFromWindow();
    }

    public void release() {
        if (ouZ != null) {
            ouZ.clear();
            ouZ = null;
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

    private String TZ(String str) {
        return "game_" + str;
    }

    private Drawable getDrawable(String str) {
        Drawable drawable;
        if (ouZ == null) {
            ouZ = new c<>(20);
        }
        Drawable drawable2 = ouZ.get(TZ(str));
        if (drawable2 == null) {
            int identifier = this.mContext.getResources().getIdentifier("zues_icon_" + str, "drawable", this.mContext.getPackageName());
            if (identifier > 0 && (drawable = ContextCompat.getDrawable(this.mContext, identifier)) != null) {
                ouZ.put(TZ(str), drawable);
                return drawable;
            }
            return null;
        }
        return drawable2;
    }

    public void setType(int i) {
        this.ouX.setBackgroundResource(b.d.zues_icon_x_n);
        this.mType = i;
    }
}
