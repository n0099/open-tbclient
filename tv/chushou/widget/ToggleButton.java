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
    private float bKG;
    private int borderColor;
    private int borderWidth;
    private float centerY;
    private float lwU;
    private int offBorderColor;
    private int offColor;
    private int onColor;
    private Paint paint;
    private SpringSystem qnJ;
    private Spring qnK;
    private boolean qnL;
    private float qnM;
    private float qnN;
    private int qnO;
    private float qnP;
    private float qnQ;
    private boolean qnR;
    private a qnS;
    SimpleSpringListener qnT;
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
        this.qnL = false;
        this.borderWidth = 2;
        this.rect = new RectF();
        this.qnR = true;
        this.qnT = new SimpleSpringListener() { // from class: tv.chushou.widget.ToggleButton.2
            @Override // com.facebook.rebound.SimpleSpringListener, com.facebook.rebound.SpringListener
            public void onSpringUpdate(Spring spring) {
                ToggleButton.this.Q(spring.getCurrentValue());
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
        this.qnL = false;
        this.borderWidth = 2;
        this.rect = new RectF();
        this.qnR = true;
        this.qnT = new SimpleSpringListener() { // from class: tv.chushou.widget.ToggleButton.2
            @Override // com.facebook.rebound.SimpleSpringListener, com.facebook.rebound.SpringListener
            public void onSpringUpdate(Spring spring) {
                ToggleButton.this.Q(spring.getCurrentValue());
            }
        };
        setup(attributeSet);
    }

    @Override // android.view.View
    protected void onDetachedFromWindow() {
        super.onDetachedFromWindow();
        this.qnK.removeListener(this.qnT);
    }

    @Override // android.view.View
    public void onAttachedToWindow() {
        super.onAttachedToWindow();
        this.qnK.addListener(this.qnT);
    }

    public void setOnColor(int i) {
        this.onColor = i;
        Q(this.qnL ? 1.0d : 0.0d);
    }

    public void setup(AttributeSet attributeSet) {
        this.paint = new Paint(1);
        this.paint.setStyle(Paint.Style.FILL);
        this.paint.setStrokeCap(Paint.Cap.ROUND);
        this.qnJ = SpringSystem.create();
        this.qnK = this.qnJ.createSpring();
        this.qnK.setSpringConfig(SpringConfig.fromOrigamiTensionAndFriction(50.0d, 7.0d));
        setOnClickListener(new View.OnClickListener() { // from class: tv.chushou.widget.ToggleButton.1
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                ToggleButton.this.Ac(ToggleButton.this.qnR);
            }
        });
        TypedArray obtainStyledAttributes = getContext().obtainStyledAttributes(attributeSet, a.C1117a.ToggleButton);
        this.offBorderColor = obtainStyledAttributes.getColor(a.C1117a.ToggleButton_offBorderColor, this.offBorderColor);
        this.onColor = obtainStyledAttributes.getColor(a.C1117a.ToggleButton_onColor, this.onColor);
        this.spotColor = obtainStyledAttributes.getColor(a.C1117a.ToggleButton_spotColor, this.spotColor);
        this.offColor = obtainStyledAttributes.getColor(a.C1117a.ToggleButton_offColor, this.offColor);
        this.borderWidth = obtainStyledAttributes.getDimensionPixelSize(a.C1117a.ToggleButton_toggleBorderWidth, this.borderWidth);
        this.qnR = obtainStyledAttributes.getBoolean(a.C1117a.ToggleButton_animate, this.qnR);
        obtainStyledAttributes.recycle();
        this.borderColor = this.offBorderColor;
    }

    public void toggle() {
        Ac(true);
    }

    public void Ac(boolean z) {
        this.qnL = !this.qnL;
        Bz(z);
        if (this.qnS != null) {
            this.qnS.a(this.qnL, this);
        }
    }

    public void eHD() {
        setToggleOn();
        if (this.qnS != null) {
            this.qnS.a(this.qnL, this);
        }
    }

    public void eHE() {
        setToggleOff();
        if (this.qnS != null) {
            this.qnS.a(this.qnL, this);
        }
    }

    public void setToggleOn() {
        setToggleOn(true);
    }

    public void setToggleOn(boolean z) {
        this.qnL = true;
        Bz(z);
    }

    public void setToggleOff() {
        setToggleOff(true);
    }

    public void setToggleOff(boolean z) {
        this.qnL = false;
        Bz(z);
    }

    private void Bz(boolean z) {
        if (z) {
            this.qnK.setEndValue(this.qnL ? 1.0d : 0.0d);
            return;
        }
        this.qnK.setCurrentValue(this.qnL ? 1.0d : 0.0d);
        Q(this.qnL ? 1.0d : 0.0d);
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
        this.bKG = Math.min(width, height) * 0.5f;
        this.centerY = this.bKG;
        this.startX = this.bKG;
        this.lwU = width - this.bKG;
        this.qnM = this.startX + this.borderWidth;
        this.qnN = this.lwU - this.borderWidth;
        this.qnO = height - (this.borderWidth * 4);
        this.qnP = this.qnL ? this.qnN : this.qnM;
        this.qnQ = this.qnO;
    }

    private int clamp(int i, int i2, int i3) {
        return Math.min(Math.max(i, i2), i3);
    }

    @Override // android.view.View
    public void draw(Canvas canvas) {
        super.draw(canvas);
        this.rect.set(0.0f, 0.0f, getWidth(), getHeight());
        this.paint.setColor(this.borderColor);
        canvas.drawRoundRect(this.rect, this.bKG, this.bKG, this.paint);
        if (this.qnQ > 0.0f) {
            float f = this.qnQ * 0.5f;
            this.rect.set(this.qnP - f, this.centerY - f, this.lwU + f, this.centerY + f);
            this.paint.setColor(this.offColor);
            canvas.drawRoundRect(this.rect, f, f, this.paint);
        }
        this.rect.set((this.qnP - 1.0f) - this.bKG, this.centerY - this.bKG, this.qnP + 1.1f + this.bKG, this.centerY + this.bKG);
        this.paint.setColor(this.borderColor);
        canvas.drawRoundRect(this.rect, this.bKG, this.bKG, this.paint);
        float f2 = this.qnO * 0.5f;
        this.rect.set(this.qnP - f2, this.centerY - f2, this.qnP + f2, this.centerY + f2);
        this.paint.setColor(this.spotColor);
        canvas.drawRoundRect(this.rect, f2, f2, this.paint);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void Q(double d) {
        this.qnP = (float) SpringUtil.mapValueFromRangeToRange(d, 0.0d, 1.0d, this.qnM, this.qnN);
        this.qnQ = (float) SpringUtil.mapValueFromRangeToRange(1.0d - d, 0.0d, 1.0d, 10.0d, this.qnO);
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
        this.qnS = aVar;
    }

    public void setAnimate(boolean z) {
        this.qnR = z;
    }
}
