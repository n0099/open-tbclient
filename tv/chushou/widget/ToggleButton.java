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
/* loaded from: classes5.dex */
public class ToggleButton extends View {
    private float aFu;
    private int borderColor;
    private int borderWidth;
    private float centerY;
    private float iLG;
    private SpringSystem nXP;
    private Spring nXQ;
    private int nXR;
    private int nXS;
    private int nXT;
    private int nXU;
    private boolean nXV;
    private float nXW;
    private float nXX;
    private int nXY;
    private float nXZ;
    private float nYa;
    private boolean nYb;
    private a nYc;
    SimpleSpringListener nYd;
    private Paint paint;
    private RectF rect;
    private float startX;

    /* loaded from: classes5.dex */
    public interface a {
        void a(boolean z, ToggleButton toggleButton);
    }

    public ToggleButton(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.nXR = Color.parseColor("#4ebb7f");
        this.nXS = Color.parseColor("#dadbda");
        this.nXT = Color.parseColor("#ffffff");
        this.nXU = Color.parseColor("#ffffff");
        this.borderColor = this.nXS;
        this.nXV = false;
        this.borderWidth = 2;
        this.rect = new RectF();
        this.nYb = true;
        this.nYd = new SimpleSpringListener() { // from class: tv.chushou.widget.ToggleButton.2
            @Override // com.facebook.rebound.SimpleSpringListener, com.facebook.rebound.SpringListener
            public void onSpringUpdate(Spring spring) {
                ToggleButton.this.A(spring.getCurrentValue());
            }
        };
        setup(attributeSet);
    }

    public ToggleButton(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.nXR = Color.parseColor("#4ebb7f");
        this.nXS = Color.parseColor("#dadbda");
        this.nXT = Color.parseColor("#ffffff");
        this.nXU = Color.parseColor("#ffffff");
        this.borderColor = this.nXS;
        this.nXV = false;
        this.borderWidth = 2;
        this.rect = new RectF();
        this.nYb = true;
        this.nYd = new SimpleSpringListener() { // from class: tv.chushou.widget.ToggleButton.2
            @Override // com.facebook.rebound.SimpleSpringListener, com.facebook.rebound.SpringListener
            public void onSpringUpdate(Spring spring) {
                ToggleButton.this.A(spring.getCurrentValue());
            }
        };
        setup(attributeSet);
    }

    @Override // android.view.View
    protected void onDetachedFromWindow() {
        super.onDetachedFromWindow();
        this.nXQ.removeListener(this.nYd);
    }

    @Override // android.view.View
    public void onAttachedToWindow() {
        super.onAttachedToWindow();
        this.nXQ.addListener(this.nYd);
    }

    public void setOnColor(int i) {
        this.nXR = i;
        A(this.nXV ? 1.0d : 0.0d);
    }

    public void setup(AttributeSet attributeSet) {
        this.paint = new Paint(1);
        this.paint.setStyle(Paint.Style.FILL);
        this.paint.setStrokeCap(Paint.Cap.ROUND);
        this.nXP = SpringSystem.create();
        this.nXQ = this.nXP.createSpring();
        this.nXQ.setSpringConfig(SpringConfig.fromOrigamiTensionAndFriction(50.0d, 7.0d));
        setOnClickListener(new View.OnClickListener() { // from class: tv.chushou.widget.ToggleButton.1
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                ToggleButton.this.xm(ToggleButton.this.nYb);
            }
        });
        TypedArray obtainStyledAttributes = getContext().obtainStyledAttributes(attributeSet, a.C0807a.ToggleButton);
        this.nXS = obtainStyledAttributes.getColor(a.C0807a.ToggleButton_offBorderColor, this.nXS);
        this.nXR = obtainStyledAttributes.getColor(a.C0807a.ToggleButton_onColor, this.nXR);
        this.nXU = obtainStyledAttributes.getColor(a.C0807a.ToggleButton_spotColor, this.nXU);
        this.nXT = obtainStyledAttributes.getColor(a.C0807a.ToggleButton_offColor, this.nXT);
        this.borderWidth = obtainStyledAttributes.getDimensionPixelSize(a.C0807a.ToggleButton_toggleBorderWidth, this.borderWidth);
        this.nYb = obtainStyledAttributes.getBoolean(a.C0807a.ToggleButton_animate, this.nYb);
        obtainStyledAttributes.recycle();
        this.borderColor = this.nXS;
    }

    public void toggle() {
        xm(true);
    }

    public void xm(boolean z) {
        this.nXV = !this.nXV;
        xn(z);
        if (this.nYc != null) {
            this.nYc.a(this.nXV, this);
        }
    }

    public void dQJ() {
        setToggleOn();
        if (this.nYc != null) {
            this.nYc.a(this.nXV, this);
        }
    }

    public void dQK() {
        setToggleOff();
        if (this.nYc != null) {
            this.nYc.a(this.nXV, this);
        }
    }

    public void setToggleOn() {
        setToggleOn(true);
    }

    public void setToggleOn(boolean z) {
        this.nXV = true;
        xn(z);
    }

    public void setToggleOff() {
        setToggleOff(true);
    }

    public void setToggleOff(boolean z) {
        this.nXV = false;
        xn(z);
    }

    private void xn(boolean z) {
        if (z) {
            this.nXQ.setEndValue(this.nXV ? 1.0d : 0.0d);
            return;
        }
        this.nXQ.setCurrentValue(this.nXV ? 1.0d : 0.0d);
        A(this.nXV ? 1.0d : 0.0d);
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
        this.aFu = Math.min(width, height) * 0.5f;
        this.centerY = this.aFu;
        this.startX = this.aFu;
        this.iLG = width - this.aFu;
        this.nXW = this.startX + this.borderWidth;
        this.nXX = this.iLG - this.borderWidth;
        this.nXY = height - (this.borderWidth * 4);
        this.nXZ = this.nXV ? this.nXX : this.nXW;
        this.nYa = this.nXY;
    }

    private int clamp(int i, int i2, int i3) {
        return Math.min(Math.max(i, i2), i3);
    }

    @Override // android.view.View
    public void draw(Canvas canvas) {
        super.draw(canvas);
        this.rect.set(0.0f, 0.0f, getWidth(), getHeight());
        this.paint.setColor(this.borderColor);
        canvas.drawRoundRect(this.rect, this.aFu, this.aFu, this.paint);
        if (this.nYa > 0.0f) {
            float f = this.nYa * 0.5f;
            this.rect.set(this.nXZ - f, this.centerY - f, this.iLG + f, this.centerY + f);
            this.paint.setColor(this.nXT);
            canvas.drawRoundRect(this.rect, f, f, this.paint);
        }
        this.rect.set((this.nXZ - 1.0f) - this.aFu, this.centerY - this.aFu, this.nXZ + 1.1f + this.aFu, this.centerY + this.aFu);
        this.paint.setColor(this.borderColor);
        canvas.drawRoundRect(this.rect, this.aFu, this.aFu, this.paint);
        float f2 = this.nXY * 0.5f;
        this.rect.set(this.nXZ - f2, this.centerY - f2, this.nXZ + f2, this.centerY + f2);
        this.paint.setColor(this.nXU);
        canvas.drawRoundRect(this.rect, f2, f2, this.paint);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void A(double d) {
        this.nXZ = (float) SpringUtil.mapValueFromRangeToRange(d, 0.0d, 1.0d, this.nXW, this.nXX);
        this.nYa = (float) SpringUtil.mapValueFromRangeToRange(1.0d - d, 0.0d, 1.0d, 10.0d, this.nXY);
        int blue = Color.blue(this.nXR);
        int red = Color.red(this.nXR);
        int green = Color.green(this.nXR);
        int blue2 = Color.blue(this.nXS);
        int red2 = Color.red(this.nXS);
        int green2 = Color.green(this.nXS);
        int mapValueFromRangeToRange = (int) SpringUtil.mapValueFromRangeToRange(1.0d - d, 0.0d, 1.0d, blue, blue2);
        int mapValueFromRangeToRange2 = (int) SpringUtil.mapValueFromRangeToRange(1.0d - d, 0.0d, 1.0d, red, red2);
        this.borderColor = Color.rgb(clamp(mapValueFromRangeToRange2, 0, 255), clamp((int) SpringUtil.mapValueFromRangeToRange(1.0d - d, 0.0d, 1.0d, green, green2), 0, 255), clamp(mapValueFromRangeToRange, 0, 255));
        postInvalidate();
    }

    public void setOnToggleChanged(a aVar) {
        this.nYc = aVar;
    }

    public void setAnimate(boolean z) {
        this.nYb = z;
    }
}
