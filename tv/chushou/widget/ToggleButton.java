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
    private float aFf;
    private int borderColor;
    private int borderWidth;
    private float centerY;
    private float iJT;
    private SpringSystem nVR;
    private Spring nVS;
    private int nVT;
    private int nVU;
    private int nVV;
    private int nVW;
    private boolean nVX;
    private float nVY;
    private float nVZ;
    private int nWa;
    private float nWb;
    private float nWc;
    private boolean nWd;
    private a nWe;
    SimpleSpringListener nWf;
    private Paint paint;
    private RectF rect;
    private float startX;

    /* loaded from: classes5.dex */
    public interface a {
        void a(boolean z, ToggleButton toggleButton);
    }

    public ToggleButton(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.nVT = Color.parseColor("#4ebb7f");
        this.nVU = Color.parseColor("#dadbda");
        this.nVV = Color.parseColor("#ffffff");
        this.nVW = Color.parseColor("#ffffff");
        this.borderColor = this.nVU;
        this.nVX = false;
        this.borderWidth = 2;
        this.rect = new RectF();
        this.nWd = true;
        this.nWf = new SimpleSpringListener() { // from class: tv.chushou.widget.ToggleButton.2
            @Override // com.facebook.rebound.SimpleSpringListener, com.facebook.rebound.SpringListener
            public void onSpringUpdate(Spring spring) {
                ToggleButton.this.A(spring.getCurrentValue());
            }
        };
        setup(attributeSet);
    }

    public ToggleButton(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.nVT = Color.parseColor("#4ebb7f");
        this.nVU = Color.parseColor("#dadbda");
        this.nVV = Color.parseColor("#ffffff");
        this.nVW = Color.parseColor("#ffffff");
        this.borderColor = this.nVU;
        this.nVX = false;
        this.borderWidth = 2;
        this.rect = new RectF();
        this.nWd = true;
        this.nWf = new SimpleSpringListener() { // from class: tv.chushou.widget.ToggleButton.2
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
        this.nVS.removeListener(this.nWf);
    }

    @Override // android.view.View
    public void onAttachedToWindow() {
        super.onAttachedToWindow();
        this.nVS.addListener(this.nWf);
    }

    public void setOnColor(int i) {
        this.nVT = i;
        A(this.nVX ? 1.0d : 0.0d);
    }

    public void setup(AttributeSet attributeSet) {
        this.paint = new Paint(1);
        this.paint.setStyle(Paint.Style.FILL);
        this.paint.setStrokeCap(Paint.Cap.ROUND);
        this.nVR = SpringSystem.create();
        this.nVS = this.nVR.createSpring();
        this.nVS.setSpringConfig(SpringConfig.fromOrigamiTensionAndFriction(50.0d, 7.0d));
        setOnClickListener(new View.OnClickListener() { // from class: tv.chushou.widget.ToggleButton.1
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                ToggleButton.this.xe(ToggleButton.this.nWd);
            }
        });
        TypedArray obtainStyledAttributes = getContext().obtainStyledAttributes(attributeSet, a.C0806a.ToggleButton);
        this.nVU = obtainStyledAttributes.getColor(a.C0806a.ToggleButton_offBorderColor, this.nVU);
        this.nVT = obtainStyledAttributes.getColor(a.C0806a.ToggleButton_onColor, this.nVT);
        this.nVW = obtainStyledAttributes.getColor(a.C0806a.ToggleButton_spotColor, this.nVW);
        this.nVV = obtainStyledAttributes.getColor(a.C0806a.ToggleButton_offColor, this.nVV);
        this.borderWidth = obtainStyledAttributes.getDimensionPixelSize(a.C0806a.ToggleButton_toggleBorderWidth, this.borderWidth);
        this.nWd = obtainStyledAttributes.getBoolean(a.C0806a.ToggleButton_animate, this.nWd);
        obtainStyledAttributes.recycle();
        this.borderColor = this.nVU;
    }

    public void toggle() {
        xe(true);
    }

    public void xe(boolean z) {
        this.nVX = !this.nVX;
        xf(z);
        if (this.nWe != null) {
            this.nWe.a(this.nVX, this);
        }
    }

    public void dQi() {
        setToggleOn();
        if (this.nWe != null) {
            this.nWe.a(this.nVX, this);
        }
    }

    public void dQj() {
        setToggleOff();
        if (this.nWe != null) {
            this.nWe.a(this.nVX, this);
        }
    }

    public void setToggleOn() {
        setToggleOn(true);
    }

    public void setToggleOn(boolean z) {
        this.nVX = true;
        xf(z);
    }

    public void setToggleOff() {
        setToggleOff(true);
    }

    public void setToggleOff(boolean z) {
        this.nVX = false;
        xf(z);
    }

    private void xf(boolean z) {
        if (z) {
            this.nVS.setEndValue(this.nVX ? 1.0d : 0.0d);
            return;
        }
        this.nVS.setCurrentValue(this.nVX ? 1.0d : 0.0d);
        A(this.nVX ? 1.0d : 0.0d);
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
        this.aFf = Math.min(width, height) * 0.5f;
        this.centerY = this.aFf;
        this.startX = this.aFf;
        this.iJT = width - this.aFf;
        this.nVY = this.startX + this.borderWidth;
        this.nVZ = this.iJT - this.borderWidth;
        this.nWa = height - (this.borderWidth * 4);
        this.nWb = this.nVX ? this.nVZ : this.nVY;
        this.nWc = this.nWa;
    }

    private int clamp(int i, int i2, int i3) {
        return Math.min(Math.max(i, i2), i3);
    }

    @Override // android.view.View
    public void draw(Canvas canvas) {
        super.draw(canvas);
        this.rect.set(0.0f, 0.0f, getWidth(), getHeight());
        this.paint.setColor(this.borderColor);
        canvas.drawRoundRect(this.rect, this.aFf, this.aFf, this.paint);
        if (this.nWc > 0.0f) {
            float f = this.nWc * 0.5f;
            this.rect.set(this.nWb - f, this.centerY - f, this.iJT + f, this.centerY + f);
            this.paint.setColor(this.nVV);
            canvas.drawRoundRect(this.rect, f, f, this.paint);
        }
        this.rect.set((this.nWb - 1.0f) - this.aFf, this.centerY - this.aFf, this.nWb + 1.1f + this.aFf, this.centerY + this.aFf);
        this.paint.setColor(this.borderColor);
        canvas.drawRoundRect(this.rect, this.aFf, this.aFf, this.paint);
        float f2 = this.nWa * 0.5f;
        this.rect.set(this.nWb - f2, this.centerY - f2, this.nWb + f2, this.centerY + f2);
        this.paint.setColor(this.nVW);
        canvas.drawRoundRect(this.rect, f2, f2, this.paint);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void A(double d) {
        this.nWb = (float) SpringUtil.mapValueFromRangeToRange(d, 0.0d, 1.0d, this.nVY, this.nVZ);
        this.nWc = (float) SpringUtil.mapValueFromRangeToRange(1.0d - d, 0.0d, 1.0d, 10.0d, this.nWa);
        int blue = Color.blue(this.nVT);
        int red = Color.red(this.nVT);
        int green = Color.green(this.nVT);
        int blue2 = Color.blue(this.nVU);
        int red2 = Color.red(this.nVU);
        int green2 = Color.green(this.nVU);
        int mapValueFromRangeToRange = (int) SpringUtil.mapValueFromRangeToRange(1.0d - d, 0.0d, 1.0d, blue, blue2);
        int mapValueFromRangeToRange2 = (int) SpringUtil.mapValueFromRangeToRange(1.0d - d, 0.0d, 1.0d, red, red2);
        this.borderColor = Color.rgb(clamp(mapValueFromRangeToRange2, 0, 255), clamp((int) SpringUtil.mapValueFromRangeToRange(1.0d - d, 0.0d, 1.0d, green, green2), 0, 255), clamp(mapValueFromRangeToRange, 0, 255));
        postInvalidate();
    }

    public void setOnToggleChanged(a aVar) {
        this.nWe = aVar;
    }

    public void setAnimate(boolean z) {
        this.nWd = z;
    }
}
