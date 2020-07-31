package tv.chushou.widget;

import android.content.Context;
import android.content.res.Resources;
import android.content.res.TypedArray;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.graphics.RectF;
import android.util.AttributeSet;
import android.util.TypedValue;
import android.view.View;
import com.facebook.rebound.SimpleSpringListener;
import com.facebook.rebound.Spring;
import com.facebook.rebound.SpringConfig;
import com.facebook.rebound.SpringSystem;
import com.facebook.rebound.SpringUtil;
import tv.chushou.widget.b.a;
/* loaded from: classes6.dex */
public class ToggleButton extends View {
    private float boe;
    private int borderColor;
    private int borderWidth;
    private float centerY;
    private float kqS;
    private int offBorderColor;
    private int offColor;
    private int onColor;
    private SpringSystem oso;
    private Spring osp;
    private boolean osq;
    private float osr;
    private float oss;
    private int ost;
    private float osu;
    private float osv;
    private boolean osw;
    private a osx;
    SimpleSpringListener osy;
    private Paint paint;
    private RectF rect;
    private int spotColor;
    private float startX;

    /* loaded from: classes6.dex */
    public interface a {
        void a(boolean z, ToggleButton toggleButton);
    }

    public ToggleButton(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.onColor = Color.parseColor("#4ebb7f");
        this.offBorderColor = Color.parseColor("#dadbda");
        this.offColor = Color.parseColor("#ffffff");
        this.spotColor = Color.parseColor("#ffffff");
        this.borderColor = this.offBorderColor;
        this.osq = false;
        this.borderWidth = 2;
        this.rect = new RectF();
        this.osw = true;
        this.osy = new SimpleSpringListener() { // from class: tv.chushou.widget.ToggleButton.2
            @Override // com.facebook.rebound.SimpleSpringListener, com.facebook.rebound.SpringListener
            public void onSpringUpdate(Spring spring) {
                ToggleButton.this.G(spring.getCurrentValue());
            }
        };
        setup(attributeSet);
    }

    public ToggleButton(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.onColor = Color.parseColor("#4ebb7f");
        this.offBorderColor = Color.parseColor("#dadbda");
        this.offColor = Color.parseColor("#ffffff");
        this.spotColor = Color.parseColor("#ffffff");
        this.borderColor = this.offBorderColor;
        this.osq = false;
        this.borderWidth = 2;
        this.rect = new RectF();
        this.osw = true;
        this.osy = new SimpleSpringListener() { // from class: tv.chushou.widget.ToggleButton.2
            @Override // com.facebook.rebound.SimpleSpringListener, com.facebook.rebound.SpringListener
            public void onSpringUpdate(Spring spring) {
                ToggleButton.this.G(spring.getCurrentValue());
            }
        };
        setup(attributeSet);
    }

    @Override // android.view.View
    protected void onDetachedFromWindow() {
        super.onDetachedFromWindow();
        this.osp.removeListener(this.osy);
    }

    @Override // android.view.View
    public void onAttachedToWindow() {
        super.onAttachedToWindow();
        this.osp.addListener(this.osy);
    }

    public void setOnColor(int i) {
        this.onColor = i;
        G(this.osq ? 1.0d : 0.0d);
    }

    public void setup(AttributeSet attributeSet) {
        this.paint = new Paint(1);
        this.paint.setStyle(Paint.Style.FILL);
        this.paint.setStrokeCap(Paint.Cap.ROUND);
        this.oso = SpringSystem.create();
        this.osp = this.oso.createSpring();
        this.osp.setSpringConfig(SpringConfig.fromOrigamiTensionAndFriction(50.0d, 7.0d));
        setOnClickListener(new View.OnClickListener() { // from class: tv.chushou.widget.ToggleButton.1
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                ToggleButton.this.yq(ToggleButton.this.osw);
            }
        });
        TypedArray obtainStyledAttributes = getContext().obtainStyledAttributes(attributeSet, a.C0949a.ToggleButton);
        this.offBorderColor = obtainStyledAttributes.getColor(a.C0949a.ToggleButton_offBorderColor, this.offBorderColor);
        this.onColor = obtainStyledAttributes.getColor(a.C0949a.ToggleButton_onColor, this.onColor);
        this.spotColor = obtainStyledAttributes.getColor(a.C0949a.ToggleButton_spotColor, this.spotColor);
        this.offColor = obtainStyledAttributes.getColor(a.C0949a.ToggleButton_offColor, this.offColor);
        this.borderWidth = obtainStyledAttributes.getDimensionPixelSize(a.C0949a.ToggleButton_toggleBorderWidth, this.borderWidth);
        this.osw = obtainStyledAttributes.getBoolean(a.C0949a.ToggleButton_animate, this.osw);
        obtainStyledAttributes.recycle();
        this.borderColor = this.offBorderColor;
    }

    public void toggle() {
        yq(true);
    }

    public void yq(boolean z) {
        this.osq = !this.osq;
        yr(z);
        if (this.osx != null) {
            this.osx.a(this.osq, this);
        }
    }

    public void dZT() {
        setToggleOn();
        if (this.osx != null) {
            this.osx.a(this.osq, this);
        }
    }

    public void dZU() {
        setToggleOff();
        if (this.osx != null) {
            this.osx.a(this.osq, this);
        }
    }

    public void setToggleOn() {
        setToggleOn(true);
    }

    public void setToggleOn(boolean z) {
        this.osq = true;
        yr(z);
    }

    public void setToggleOff() {
        setToggleOff(true);
    }

    public void setToggleOff(boolean z) {
        this.osq = false;
        yr(z);
    }

    private void yr(boolean z) {
        if (z) {
            this.osp.setEndValue(this.osq ? 1.0d : 0.0d);
            return;
        }
        this.osp.setCurrentValue(this.osq ? 1.0d : 0.0d);
        G(this.osq ? 1.0d : 0.0d);
    }

    @Override // android.view.View
    protected void onMeasure(int i, int i2) {
        int mode = View.MeasureSpec.getMode(i);
        int mode2 = View.MeasureSpec.getMode(i2);
        View.MeasureSpec.getSize(i);
        int size = View.MeasureSpec.getSize(i2);
        Resources system = Resources.getSystem();
        if (mode == 0 || mode == Integer.MIN_VALUE) {
            i = View.MeasureSpec.makeMeasureSpec((int) TypedValue.applyDimension(1, 50.0f, system.getDisplayMetrics()), 1073741824);
        }
        if (mode2 == 0 || size == Integer.MIN_VALUE) {
            i2 = View.MeasureSpec.makeMeasureSpec((int) TypedValue.applyDimension(1, 30.0f, system.getDisplayMetrics()), 1073741824);
        }
        super.onMeasure(i, i2);
    }

    @Override // android.view.View
    protected void onLayout(boolean z, int i, int i2, int i3, int i4) {
        super.onLayout(z, i, i2, i3, i4);
        int width = getWidth();
        int height = getHeight();
        this.boe = Math.min(width, height) * 0.5f;
        this.centerY = this.boe;
        this.startX = this.boe;
        this.kqS = width - this.boe;
        this.osr = this.startX + this.borderWidth;
        this.oss = this.kqS - this.borderWidth;
        this.ost = height - (this.borderWidth * 4);
        this.osu = this.osq ? this.oss : this.osr;
        this.osv = this.ost;
    }

    private int clamp(int i, int i2, int i3) {
        return Math.min(Math.max(i, i2), i3);
    }

    @Override // android.view.View
    public void draw(Canvas canvas) {
        super.draw(canvas);
        this.rect.set(0.0f, 0.0f, getWidth(), getHeight());
        this.paint.setColor(this.borderColor);
        canvas.drawRoundRect(this.rect, this.boe, this.boe, this.paint);
        if (this.osv > 0.0f) {
            float f = this.osv * 0.5f;
            this.rect.set(this.osu - f, this.centerY - f, this.kqS + f, this.centerY + f);
            this.paint.setColor(this.offColor);
            canvas.drawRoundRect(this.rect, f, f, this.paint);
        }
        this.rect.set((this.osu - 1.0f) - this.boe, this.centerY - this.boe, this.osu + 1.1f + this.boe, this.centerY + this.boe);
        this.paint.setColor(this.borderColor);
        canvas.drawRoundRect(this.rect, this.boe, this.boe, this.paint);
        float f2 = this.ost * 0.5f;
        this.rect.set(this.osu - f2, this.centerY - f2, this.osu + f2, this.centerY + f2);
        this.paint.setColor(this.spotColor);
        canvas.drawRoundRect(this.rect, f2, f2, this.paint);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void G(double d) {
        this.osu = (float) SpringUtil.mapValueFromRangeToRange(d, 0.0d, 1.0d, this.osr, this.oss);
        this.osv = (float) SpringUtil.mapValueFromRangeToRange(1.0d - d, 0.0d, 1.0d, 10.0d, this.ost);
        int blue = Color.blue(this.onColor);
        int red = Color.red(this.onColor);
        int green = Color.green(this.onColor);
        int blue2 = Color.blue(this.offBorderColor);
        int red2 = Color.red(this.offBorderColor);
        int green2 = Color.green(this.offBorderColor);
        int mapValueFromRangeToRange = (int) SpringUtil.mapValueFromRangeToRange(1.0d - d, 0.0d, 1.0d, blue, blue2);
        int mapValueFromRangeToRange2 = (int) SpringUtil.mapValueFromRangeToRange(1.0d - d, 0.0d, 1.0d, red, red2);
        this.borderColor = Color.rgb(clamp(mapValueFromRangeToRange2, 0, 255), clamp((int) SpringUtil.mapValueFromRangeToRange(1.0d - d, 0.0d, 1.0d, green, green2), 0, 255), clamp(mapValueFromRangeToRange, 0, 255));
        postInvalidate();
    }

    public void setOnToggleChanged(a aVar) {
        this.osx = aVar;
    }

    public void setAnimate(boolean z) {
        this.osw = z;
    }
}
