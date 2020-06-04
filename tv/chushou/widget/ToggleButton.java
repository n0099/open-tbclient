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
    private float jOk;
    private SpringSystem nNN;
    private Spring nNO;
    private int nNP;
    private int nNQ;
    private int nNR;
    private int nNS;
    private boolean nNT;
    private float nNU;
    private float nNV;
    private int nNW;
    private float nNX;
    private float nNY;
    private boolean nNZ;
    private a nOa;
    SimpleSpringListener nOb;
    private Paint paint;
    private RectF rect;
    private float startX;

    /* loaded from: classes5.dex */
    public interface a {
        void a(boolean z, ToggleButton toggleButton);
    }

    public ToggleButton(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.nNP = Color.parseColor("#4ebb7f");
        this.nNQ = Color.parseColor("#dadbda");
        this.nNR = Color.parseColor("#ffffff");
        this.nNS = Color.parseColor("#ffffff");
        this.borderColor = this.nNQ;
        this.nNT = false;
        this.borderWidth = 2;
        this.rect = new RectF();
        this.nNZ = true;
        this.nOb = new SimpleSpringListener() { // from class: tv.chushou.widget.ToggleButton.2
            @Override // com.facebook.rebound.SimpleSpringListener, com.facebook.rebound.SpringListener
            public void onSpringUpdate(Spring spring) {
                ToggleButton.this.F(spring.getCurrentValue());
            }
        };
        setup(attributeSet);
    }

    public ToggleButton(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.nNP = Color.parseColor("#4ebb7f");
        this.nNQ = Color.parseColor("#dadbda");
        this.nNR = Color.parseColor("#ffffff");
        this.nNS = Color.parseColor("#ffffff");
        this.borderColor = this.nNQ;
        this.nNT = false;
        this.borderWidth = 2;
        this.rect = new RectF();
        this.nNZ = true;
        this.nOb = new SimpleSpringListener() { // from class: tv.chushou.widget.ToggleButton.2
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
        this.nNO.removeListener(this.nOb);
    }

    @Override // android.view.View
    public void onAttachedToWindow() {
        super.onAttachedToWindow();
        this.nNO.addListener(this.nOb);
    }

    public void setOnColor(int i) {
        this.nNP = i;
        F(this.nNT ? 1.0d : 0.0d);
    }

    public void setup(AttributeSet attributeSet) {
        this.paint = new Paint(1);
        this.paint.setStyle(Paint.Style.FILL);
        this.paint.setStrokeCap(Paint.Cap.ROUND);
        this.nNN = SpringSystem.create();
        this.nNO = this.nNN.createSpring();
        this.nNO.setSpringConfig(SpringConfig.fromOrigamiTensionAndFriction(50.0d, 7.0d));
        setOnClickListener(new View.OnClickListener() { // from class: tv.chushou.widget.ToggleButton.1
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                ToggleButton.this.xq(ToggleButton.this.nNZ);
            }
        });
        TypedArray obtainStyledAttributes = getContext().obtainStyledAttributes(attributeSet, a.C0914a.ToggleButton);
        this.nNQ = obtainStyledAttributes.getColor(a.C0914a.ToggleButton_offBorderColor, this.nNQ);
        this.nNP = obtainStyledAttributes.getColor(a.C0914a.ToggleButton_onColor, this.nNP);
        this.nNS = obtainStyledAttributes.getColor(a.C0914a.ToggleButton_spotColor, this.nNS);
        this.nNR = obtainStyledAttributes.getColor(a.C0914a.ToggleButton_offColor, this.nNR);
        this.borderWidth = obtainStyledAttributes.getDimensionPixelSize(a.C0914a.ToggleButton_toggleBorderWidth, this.borderWidth);
        this.nNZ = obtainStyledAttributes.getBoolean(a.C0914a.ToggleButton_animate, this.nNZ);
        obtainStyledAttributes.recycle();
        this.borderColor = this.nNQ;
    }

    public void toggle() {
        xq(true);
    }

    public void xq(boolean z) {
        this.nNT = !this.nNT;
        xr(z);
        if (this.nOa != null) {
            this.nOa.a(this.nNT, this);
        }
    }

    public void dRN() {
        setToggleOn();
        if (this.nOa != null) {
            this.nOa.a(this.nNT, this);
        }
    }

    public void dRO() {
        setToggleOff();
        if (this.nOa != null) {
            this.nOa.a(this.nNT, this);
        }
    }

    public void setToggleOn() {
        setToggleOn(true);
    }

    public void setToggleOn(boolean z) {
        this.nNT = true;
        xr(z);
    }

    public void setToggleOff() {
        setToggleOff(true);
    }

    public void setToggleOff(boolean z) {
        this.nNT = false;
        xr(z);
    }

    private void xr(boolean z) {
        if (z) {
            this.nNO.setEndValue(this.nNT ? 1.0d : 0.0d);
            return;
        }
        this.nNO.setCurrentValue(this.nNT ? 1.0d : 0.0d);
        F(this.nNT ? 1.0d : 0.0d);
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
        this.jOk = width - this.biG;
        this.nNU = this.startX + this.borderWidth;
        this.nNV = this.jOk - this.borderWidth;
        this.nNW = height - (this.borderWidth * 4);
        this.nNX = this.nNT ? this.nNV : this.nNU;
        this.nNY = this.nNW;
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
        if (this.nNY > 0.0f) {
            float f = this.nNY * 0.5f;
            this.rect.set(this.nNX - f, this.centerY - f, this.jOk + f, this.centerY + f);
            this.paint.setColor(this.nNR);
            canvas.drawRoundRect(this.rect, f, f, this.paint);
        }
        this.rect.set((this.nNX - 1.0f) - this.biG, this.centerY - this.biG, this.nNX + 1.1f + this.biG, this.centerY + this.biG);
        this.paint.setColor(this.borderColor);
        canvas.drawRoundRect(this.rect, this.biG, this.biG, this.paint);
        float f2 = this.nNW * 0.5f;
        this.rect.set(this.nNX - f2, this.centerY - f2, this.nNX + f2, this.centerY + f2);
        this.paint.setColor(this.nNS);
        canvas.drawRoundRect(this.rect, f2, f2, this.paint);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void F(double d) {
        this.nNX = (float) SpringUtil.mapValueFromRangeToRange(d, 0.0d, 1.0d, this.nNU, this.nNV);
        this.nNY = (float) SpringUtil.mapValueFromRangeToRange(1.0d - d, 0.0d, 1.0d, 10.0d, this.nNW);
        int blue = Color.blue(this.nNP);
        int red = Color.red(this.nNP);
        int green = Color.green(this.nNP);
        int blue2 = Color.blue(this.nNQ);
        int red2 = Color.red(this.nNQ);
        int green2 = Color.green(this.nNQ);
        int mapValueFromRangeToRange = (int) SpringUtil.mapValueFromRangeToRange(1.0d - d, 0.0d, 1.0d, blue, blue2);
        int mapValueFromRangeToRange2 = (int) SpringUtil.mapValueFromRangeToRange(1.0d - d, 0.0d, 1.0d, red, red2);
        this.borderColor = Color.rgb(clamp(mapValueFromRangeToRange2, 0, 255), clamp((int) SpringUtil.mapValueFromRangeToRange(1.0d - d, 0.0d, 1.0d, green, green2), 0, 255), clamp(mapValueFromRangeToRange, 0, 255));
        postInvalidate();
    }

    public void setOnToggleChanged(a aVar) {
        this.nOa = aVar;
    }

    public void setAnimate(boolean z) {
        this.nNZ = z;
    }
}
