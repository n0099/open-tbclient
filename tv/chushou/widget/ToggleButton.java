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
    private float bbg;
    private int borderColor;
    private int borderWidth;
    private float centerY;
    private float jvT;
    private SpringSystem nrG;
    private Spring nrH;
    private int nrI;
    private int nrJ;
    private int nrK;
    private int nrL;
    private boolean nrM;
    private float nrN;
    private float nrO;
    private int nrP;
    private float nrQ;
    private float nrR;
    private boolean nrS;
    private a nrT;
    SimpleSpringListener nrU;
    private Paint paint;
    private RectF rect;
    private float startX;

    /* loaded from: classes5.dex */
    public interface a {
        void a(boolean z, ToggleButton toggleButton);
    }

    public ToggleButton(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.nrI = Color.parseColor("#4ebb7f");
        this.nrJ = Color.parseColor("#dadbda");
        this.nrK = Color.parseColor("#ffffff");
        this.nrL = Color.parseColor("#ffffff");
        this.borderColor = this.nrJ;
        this.nrM = false;
        this.borderWidth = 2;
        this.rect = new RectF();
        this.nrS = true;
        this.nrU = new SimpleSpringListener() { // from class: tv.chushou.widget.ToggleButton.2
            @Override // com.facebook.rebound.SimpleSpringListener, com.facebook.rebound.SpringListener
            public void onSpringUpdate(Spring spring) {
                ToggleButton.this.E(spring.getCurrentValue());
            }
        };
        setup(attributeSet);
    }

    public ToggleButton(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.nrI = Color.parseColor("#4ebb7f");
        this.nrJ = Color.parseColor("#dadbda");
        this.nrK = Color.parseColor("#ffffff");
        this.nrL = Color.parseColor("#ffffff");
        this.borderColor = this.nrJ;
        this.nrM = false;
        this.borderWidth = 2;
        this.rect = new RectF();
        this.nrS = true;
        this.nrU = new SimpleSpringListener() { // from class: tv.chushou.widget.ToggleButton.2
            @Override // com.facebook.rebound.SimpleSpringListener, com.facebook.rebound.SpringListener
            public void onSpringUpdate(Spring spring) {
                ToggleButton.this.E(spring.getCurrentValue());
            }
        };
        setup(attributeSet);
    }

    @Override // android.view.View
    protected void onDetachedFromWindow() {
        super.onDetachedFromWindow();
        this.nrH.removeListener(this.nrU);
    }

    @Override // android.view.View
    public void onAttachedToWindow() {
        super.onAttachedToWindow();
        this.nrH.addListener(this.nrU);
    }

    public void setOnColor(int i) {
        this.nrI = i;
        E(this.nrM ? 1.0d : 0.0d);
    }

    public void setup(AttributeSet attributeSet) {
        this.paint = new Paint(1);
        this.paint.setStyle(Paint.Style.FILL);
        this.paint.setStrokeCap(Paint.Cap.ROUND);
        this.nrG = SpringSystem.create();
        this.nrH = this.nrG.createSpring();
        this.nrH.setSpringConfig(SpringConfig.fromOrigamiTensionAndFriction(50.0d, 7.0d));
        setOnClickListener(new View.OnClickListener() { // from class: tv.chushou.widget.ToggleButton.1
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                ToggleButton.this.wR(ToggleButton.this.nrS);
            }
        });
        TypedArray obtainStyledAttributes = getContext().obtainStyledAttributes(attributeSet, a.C0851a.ToggleButton);
        this.nrJ = obtainStyledAttributes.getColor(a.C0851a.ToggleButton_offBorderColor, this.nrJ);
        this.nrI = obtainStyledAttributes.getColor(a.C0851a.ToggleButton_onColor, this.nrI);
        this.nrL = obtainStyledAttributes.getColor(a.C0851a.ToggleButton_spotColor, this.nrL);
        this.nrK = obtainStyledAttributes.getColor(a.C0851a.ToggleButton_offColor, this.nrK);
        this.borderWidth = obtainStyledAttributes.getDimensionPixelSize(a.C0851a.ToggleButton_toggleBorderWidth, this.borderWidth);
        this.nrS = obtainStyledAttributes.getBoolean(a.C0851a.ToggleButton_animate, this.nrS);
        obtainStyledAttributes.recycle();
        this.borderColor = this.nrJ;
    }

    public void toggle() {
        wR(true);
    }

    public void wR(boolean z) {
        this.nrM = !this.nrM;
        wS(z);
        if (this.nrT != null) {
            this.nrT.a(this.nrM, this);
        }
    }

    public void dJE() {
        setToggleOn();
        if (this.nrT != null) {
            this.nrT.a(this.nrM, this);
        }
    }

    public void dJF() {
        setToggleOff();
        if (this.nrT != null) {
            this.nrT.a(this.nrM, this);
        }
    }

    public void setToggleOn() {
        setToggleOn(true);
    }

    public void setToggleOn(boolean z) {
        this.nrM = true;
        wS(z);
    }

    public void setToggleOff() {
        setToggleOff(true);
    }

    public void setToggleOff(boolean z) {
        this.nrM = false;
        wS(z);
    }

    private void wS(boolean z) {
        if (z) {
            this.nrH.setEndValue(this.nrM ? 1.0d : 0.0d);
            return;
        }
        this.nrH.setCurrentValue(this.nrM ? 1.0d : 0.0d);
        E(this.nrM ? 1.0d : 0.0d);
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
        this.bbg = Math.min(width, height) * 0.5f;
        this.centerY = this.bbg;
        this.startX = this.bbg;
        this.jvT = width - this.bbg;
        this.nrN = this.startX + this.borderWidth;
        this.nrO = this.jvT - this.borderWidth;
        this.nrP = height - (this.borderWidth * 4);
        this.nrQ = this.nrM ? this.nrO : this.nrN;
        this.nrR = this.nrP;
    }

    private int clamp(int i, int i2, int i3) {
        return Math.min(Math.max(i, i2), i3);
    }

    @Override // android.view.View
    public void draw(Canvas canvas) {
        super.draw(canvas);
        this.rect.set(0.0f, 0.0f, getWidth(), getHeight());
        this.paint.setColor(this.borderColor);
        canvas.drawRoundRect(this.rect, this.bbg, this.bbg, this.paint);
        if (this.nrR > 0.0f) {
            float f = this.nrR * 0.5f;
            this.rect.set(this.nrQ - f, this.centerY - f, this.jvT + f, this.centerY + f);
            this.paint.setColor(this.nrK);
            canvas.drawRoundRect(this.rect, f, f, this.paint);
        }
        this.rect.set((this.nrQ - 1.0f) - this.bbg, this.centerY - this.bbg, this.nrQ + 1.1f + this.bbg, this.centerY + this.bbg);
        this.paint.setColor(this.borderColor);
        canvas.drawRoundRect(this.rect, this.bbg, this.bbg, this.paint);
        float f2 = this.nrP * 0.5f;
        this.rect.set(this.nrQ - f2, this.centerY - f2, this.nrQ + f2, this.centerY + f2);
        this.paint.setColor(this.nrL);
        canvas.drawRoundRect(this.rect, f2, f2, this.paint);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void E(double d) {
        this.nrQ = (float) SpringUtil.mapValueFromRangeToRange(d, 0.0d, 1.0d, this.nrN, this.nrO);
        this.nrR = (float) SpringUtil.mapValueFromRangeToRange(1.0d - d, 0.0d, 1.0d, 10.0d, this.nrP);
        int blue = Color.blue(this.nrI);
        int red = Color.red(this.nrI);
        int green = Color.green(this.nrI);
        int blue2 = Color.blue(this.nrJ);
        int red2 = Color.red(this.nrJ);
        int green2 = Color.green(this.nrJ);
        int mapValueFromRangeToRange = (int) SpringUtil.mapValueFromRangeToRange(1.0d - d, 0.0d, 1.0d, blue, blue2);
        int mapValueFromRangeToRange2 = (int) SpringUtil.mapValueFromRangeToRange(1.0d - d, 0.0d, 1.0d, red, red2);
        this.borderColor = Color.rgb(clamp(mapValueFromRangeToRange2, 0, 255), clamp((int) SpringUtil.mapValueFromRangeToRange(1.0d - d, 0.0d, 1.0d, green, green2), 0, 255), clamp(mapValueFromRangeToRange, 0, 255));
        postInvalidate();
    }

    public void setOnToggleChanged(a aVar) {
        this.nrT = aVar;
    }

    public void setAnimate(boolean z) {
        this.nrS = z;
    }
}
