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
    private float biG;
    private int borderColor;
    private int borderWidth;
    private float centerY;
    private float jNe;
    private SpringSystem nMD;
    private Spring nME;
    private int nMF;
    private int nMG;
    private int nMH;
    private int nMI;
    private boolean nMJ;
    private float nMK;
    private float nML;
    private int nMM;
    private float nMN;
    private float nMO;
    private boolean nMP;
    private a nMQ;
    SimpleSpringListener nMR;
    private Paint paint;
    private RectF rect;
    private float startX;

    /* loaded from: classes5.dex */
    public interface a {
        void a(boolean z, ToggleButton toggleButton);
    }

    public ToggleButton(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.nMF = Color.parseColor("#4ebb7f");
        this.nMG = Color.parseColor("#dadbda");
        this.nMH = Color.parseColor("#ffffff");
        this.nMI = Color.parseColor("#ffffff");
        this.borderColor = this.nMG;
        this.nMJ = false;
        this.borderWidth = 2;
        this.rect = new RectF();
        this.nMP = true;
        this.nMR = new SimpleSpringListener() { // from class: tv.chushou.widget.ToggleButton.2
            @Override // com.facebook.rebound.SimpleSpringListener, com.facebook.rebound.SpringListener
            public void onSpringUpdate(Spring spring) {
                ToggleButton.this.F(spring.getCurrentValue());
            }
        };
        setup(attributeSet);
    }

    public ToggleButton(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.nMF = Color.parseColor("#4ebb7f");
        this.nMG = Color.parseColor("#dadbda");
        this.nMH = Color.parseColor("#ffffff");
        this.nMI = Color.parseColor("#ffffff");
        this.borderColor = this.nMG;
        this.nMJ = false;
        this.borderWidth = 2;
        this.rect = new RectF();
        this.nMP = true;
        this.nMR = new SimpleSpringListener() { // from class: tv.chushou.widget.ToggleButton.2
            @Override // com.facebook.rebound.SimpleSpringListener, com.facebook.rebound.SpringListener
            public void onSpringUpdate(Spring spring) {
                ToggleButton.this.F(spring.getCurrentValue());
            }
        };
        setup(attributeSet);
    }

    @Override // android.view.View
    protected void onDetachedFromWindow() {
        super.onDetachedFromWindow();
        this.nME.removeListener(this.nMR);
    }

    @Override // android.view.View
    public void onAttachedToWindow() {
        super.onAttachedToWindow();
        this.nME.addListener(this.nMR);
    }

    public void setOnColor(int i) {
        this.nMF = i;
        F(this.nMJ ? 1.0d : 0.0d);
    }

    public void setup(AttributeSet attributeSet) {
        this.paint = new Paint(1);
        this.paint.setStyle(Paint.Style.FILL);
        this.paint.setStrokeCap(Paint.Cap.ROUND);
        this.nMD = SpringSystem.create();
        this.nME = this.nMD.createSpring();
        this.nME.setSpringConfig(SpringConfig.fromOrigamiTensionAndFriction(50.0d, 7.0d));
        setOnClickListener(new View.OnClickListener() { // from class: tv.chushou.widget.ToggleButton.1
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                ToggleButton.this.xo(ToggleButton.this.nMP);
            }
        });
        TypedArray obtainStyledAttributes = getContext().obtainStyledAttributes(attributeSet, a.C0913a.ToggleButton);
        this.nMG = obtainStyledAttributes.getColor(a.C0913a.ToggleButton_offBorderColor, this.nMG);
        this.nMF = obtainStyledAttributes.getColor(a.C0913a.ToggleButton_onColor, this.nMF);
        this.nMI = obtainStyledAttributes.getColor(a.C0913a.ToggleButton_spotColor, this.nMI);
        this.nMH = obtainStyledAttributes.getColor(a.C0913a.ToggleButton_offColor, this.nMH);
        this.borderWidth = obtainStyledAttributes.getDimensionPixelSize(a.C0913a.ToggleButton_toggleBorderWidth, this.borderWidth);
        this.nMP = obtainStyledAttributes.getBoolean(a.C0913a.ToggleButton_animate, this.nMP);
        obtainStyledAttributes.recycle();
        this.borderColor = this.nMG;
    }

    public void toggle() {
        xo(true);
    }

    public void xo(boolean z) {
        this.nMJ = !this.nMJ;
        xp(z);
        if (this.nMQ != null) {
            this.nMQ.a(this.nMJ, this);
        }
    }

    public void dRz() {
        setToggleOn();
        if (this.nMQ != null) {
            this.nMQ.a(this.nMJ, this);
        }
    }

    public void dRA() {
        setToggleOff();
        if (this.nMQ != null) {
            this.nMQ.a(this.nMJ, this);
        }
    }

    public void setToggleOn() {
        setToggleOn(true);
    }

    public void setToggleOn(boolean z) {
        this.nMJ = true;
        xp(z);
    }

    public void setToggleOff() {
        setToggleOff(true);
    }

    public void setToggleOff(boolean z) {
        this.nMJ = false;
        xp(z);
    }

    private void xp(boolean z) {
        if (z) {
            this.nME.setEndValue(this.nMJ ? 1.0d : 0.0d);
            return;
        }
        this.nME.setCurrentValue(this.nMJ ? 1.0d : 0.0d);
        F(this.nMJ ? 1.0d : 0.0d);
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
        this.biG = Math.min(width, height) * 0.5f;
        this.centerY = this.biG;
        this.startX = this.biG;
        this.jNe = width - this.biG;
        this.nMK = this.startX + this.borderWidth;
        this.nML = this.jNe - this.borderWidth;
        this.nMM = height - (this.borderWidth * 4);
        this.nMN = this.nMJ ? this.nML : this.nMK;
        this.nMO = this.nMM;
    }

    private int clamp(int i, int i2, int i3) {
        return Math.min(Math.max(i, i2), i3);
    }

    @Override // android.view.View
    public void draw(Canvas canvas) {
        super.draw(canvas);
        this.rect.set(0.0f, 0.0f, getWidth(), getHeight());
        this.paint.setColor(this.borderColor);
        canvas.drawRoundRect(this.rect, this.biG, this.biG, this.paint);
        if (this.nMO > 0.0f) {
            float f = this.nMO * 0.5f;
            this.rect.set(this.nMN - f, this.centerY - f, this.jNe + f, this.centerY + f);
            this.paint.setColor(this.nMH);
            canvas.drawRoundRect(this.rect, f, f, this.paint);
        }
        this.rect.set((this.nMN - 1.0f) - this.biG, this.centerY - this.biG, this.nMN + 1.1f + this.biG, this.centerY + this.biG);
        this.paint.setColor(this.borderColor);
        canvas.drawRoundRect(this.rect, this.biG, this.biG, this.paint);
        float f2 = this.nMM * 0.5f;
        this.rect.set(this.nMN - f2, this.centerY - f2, this.nMN + f2, this.centerY + f2);
        this.paint.setColor(this.nMI);
        canvas.drawRoundRect(this.rect, f2, f2, this.paint);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void F(double d) {
        this.nMN = (float) SpringUtil.mapValueFromRangeToRange(d, 0.0d, 1.0d, this.nMK, this.nML);
        this.nMO = (float) SpringUtil.mapValueFromRangeToRange(1.0d - d, 0.0d, 1.0d, 10.0d, this.nMM);
        int blue = Color.blue(this.nMF);
        int red = Color.red(this.nMF);
        int green = Color.green(this.nMF);
        int blue2 = Color.blue(this.nMG);
        int red2 = Color.red(this.nMG);
        int green2 = Color.green(this.nMG);
        int mapValueFromRangeToRange = (int) SpringUtil.mapValueFromRangeToRange(1.0d - d, 0.0d, 1.0d, blue, blue2);
        int mapValueFromRangeToRange2 = (int) SpringUtil.mapValueFromRangeToRange(1.0d - d, 0.0d, 1.0d, red, red2);
        this.borderColor = Color.rgb(clamp(mapValueFromRangeToRange2, 0, 255), clamp((int) SpringUtil.mapValueFromRangeToRange(1.0d - d, 0.0d, 1.0d, green, green2), 0, 255), clamp(mapValueFromRangeToRange, 0, 255));
        postInvalidate();
    }

    public void setOnToggleChanged(a aVar) {
        this.nMQ = aVar;
    }

    public void setAnimate(boolean z) {
        this.nMP = z;
    }
}
