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
    private int borderColor;
    private int borderWidth;
    private float bxm;
    private float centerY;
    private float kOS;
    private SpringSystem oWc;
    private Spring oWd;
    private boolean oWe;
    private float oWf;
    private float oWg;
    private int oWh;
    private float oWi;
    private float oWj;
    private boolean oWk;
    private a oWl;
    SimpleSpringListener oWm;
    private int offBorderColor;
    private int offColor;
    private int onColor;
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
        this.oWe = false;
        this.borderWidth = 2;
        this.rect = new RectF();
        this.oWk = true;
        this.oWm = new SimpleSpringListener() { // from class: tv.chushou.widget.ToggleButton.2
            @Override // com.facebook.rebound.SimpleSpringListener, com.facebook.rebound.SpringListener
            public void onSpringUpdate(Spring spring) {
                ToggleButton.this.M(spring.getCurrentValue());
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
        this.oWe = false;
        this.borderWidth = 2;
        this.rect = new RectF();
        this.oWk = true;
        this.oWm = new SimpleSpringListener() { // from class: tv.chushou.widget.ToggleButton.2
            @Override // com.facebook.rebound.SimpleSpringListener, com.facebook.rebound.SpringListener
            public void onSpringUpdate(Spring spring) {
                ToggleButton.this.M(spring.getCurrentValue());
            }
        };
        setup(attributeSet);
    }

    @Override // android.view.View
    protected void onDetachedFromWindow() {
        super.onDetachedFromWindow();
        this.oWd.removeListener(this.oWm);
    }

    @Override // android.view.View
    public void onAttachedToWindow() {
        super.onAttachedToWindow();
        this.oWd.addListener(this.oWm);
    }

    public void setOnColor(int i) {
        this.onColor = i;
        M(this.oWe ? 1.0d : 0.0d);
    }

    public void setup(AttributeSet attributeSet) {
        this.paint = new Paint(1);
        this.paint.setStyle(Paint.Style.FILL);
        this.paint.setStrokeCap(Paint.Cap.ROUND);
        this.oWc = SpringSystem.create();
        this.oWd = this.oWc.createSpring();
        this.oWd.setSpringConfig(SpringConfig.fromOrigamiTensionAndFriction(50.0d, 7.0d));
        setOnClickListener(new View.OnClickListener() { // from class: tv.chushou.widget.ToggleButton.1
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                ToggleButton.this.zs(ToggleButton.this.oWk);
            }
        });
        TypedArray obtainStyledAttributes = getContext().obtainStyledAttributes(attributeSet, a.C1004a.ToggleButton);
        this.offBorderColor = obtainStyledAttributes.getColor(a.C1004a.ToggleButton_offBorderColor, this.offBorderColor);
        this.onColor = obtainStyledAttributes.getColor(a.C1004a.ToggleButton_onColor, this.onColor);
        this.spotColor = obtainStyledAttributes.getColor(a.C1004a.ToggleButton_spotColor, this.spotColor);
        this.offColor = obtainStyledAttributes.getColor(a.C1004a.ToggleButton_offColor, this.offColor);
        this.borderWidth = obtainStyledAttributes.getDimensionPixelSize(a.C1004a.ToggleButton_toggleBorderWidth, this.borderWidth);
        this.oWk = obtainStyledAttributes.getBoolean(a.C1004a.ToggleButton_animate, this.oWk);
        obtainStyledAttributes.recycle();
        this.borderColor = this.offBorderColor;
    }

    public void toggle() {
        zs(true);
    }

    public void zs(boolean z) {
        this.oWe = !this.oWe;
        zt(z);
        if (this.oWl != null) {
            this.oWl.a(this.oWe, this);
        }
    }

    public void eqe() {
        setToggleOn();
        if (this.oWl != null) {
            this.oWl.a(this.oWe, this);
        }
    }

    public void eqf() {
        setToggleOff();
        if (this.oWl != null) {
            this.oWl.a(this.oWe, this);
        }
    }

    public void setToggleOn() {
        setToggleOn(true);
    }

    public void setToggleOn(boolean z) {
        this.oWe = true;
        zt(z);
    }

    public void setToggleOff() {
        setToggleOff(true);
    }

    public void setToggleOff(boolean z) {
        this.oWe = false;
        zt(z);
    }

    private void zt(boolean z) {
        if (z) {
            this.oWd.setEndValue(this.oWe ? 1.0d : 0.0d);
            return;
        }
        this.oWd.setCurrentValue(this.oWe ? 1.0d : 0.0d);
        M(this.oWe ? 1.0d : 0.0d);
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
        this.bxm = Math.min(width, height) * 0.5f;
        this.centerY = this.bxm;
        this.startX = this.bxm;
        this.kOS = width - this.bxm;
        this.oWf = this.startX + this.borderWidth;
        this.oWg = this.kOS - this.borderWidth;
        this.oWh = height - (this.borderWidth * 4);
        this.oWi = this.oWe ? this.oWg : this.oWf;
        this.oWj = this.oWh;
    }

    private int clamp(int i, int i2, int i3) {
        return Math.min(Math.max(i, i2), i3);
    }

    @Override // android.view.View
    public void draw(Canvas canvas) {
        super.draw(canvas);
        this.rect.set(0.0f, 0.0f, getWidth(), getHeight());
        this.paint.setColor(this.borderColor);
        canvas.drawRoundRect(this.rect, this.bxm, this.bxm, this.paint);
        if (this.oWj > 0.0f) {
            float f = this.oWj * 0.5f;
            this.rect.set(this.oWi - f, this.centerY - f, this.kOS + f, this.centerY + f);
            this.paint.setColor(this.offColor);
            canvas.drawRoundRect(this.rect, f, f, this.paint);
        }
        this.rect.set((this.oWi - 1.0f) - this.bxm, this.centerY - this.bxm, this.oWi + 1.1f + this.bxm, this.centerY + this.bxm);
        this.paint.setColor(this.borderColor);
        canvas.drawRoundRect(this.rect, this.bxm, this.bxm, this.paint);
        float f2 = this.oWh * 0.5f;
        this.rect.set(this.oWi - f2, this.centerY - f2, this.oWi + f2, this.centerY + f2);
        this.paint.setColor(this.spotColor);
        canvas.drawRoundRect(this.rect, f2, f2, this.paint);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void M(double d) {
        this.oWi = (float) SpringUtil.mapValueFromRangeToRange(d, 0.0d, 1.0d, this.oWf, this.oWg);
        this.oWj = (float) SpringUtil.mapValueFromRangeToRange(1.0d - d, 0.0d, 1.0d, 10.0d, this.oWh);
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
        this.oWl = aVar;
    }

    public void setAnimate(boolean z) {
        this.oWk = z;
    }
}
