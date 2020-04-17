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
    private float bbb;
    private int borderColor;
    private int borderWidth;
    private float centerY;
    private float jvP;
    private SpringSystem nrD;
    private Spring nrE;
    private int nrF;
    private int nrG;
    private int nrH;
    private int nrI;
    private boolean nrJ;
    private float nrK;
    private float nrL;
    private int nrM;
    private float nrN;
    private float nrO;
    private boolean nrP;
    private a nrQ;
    SimpleSpringListener nrR;
    private Paint paint;
    private RectF rect;
    private float startX;

    /* loaded from: classes5.dex */
    public interface a {
        void a(boolean z, ToggleButton toggleButton);
    }

    public ToggleButton(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.nrF = Color.parseColor("#4ebb7f");
        this.nrG = Color.parseColor("#dadbda");
        this.nrH = Color.parseColor("#ffffff");
        this.nrI = Color.parseColor("#ffffff");
        this.borderColor = this.nrG;
        this.nrJ = false;
        this.borderWidth = 2;
        this.rect = new RectF();
        this.nrP = true;
        this.nrR = new SimpleSpringListener() { // from class: tv.chushou.widget.ToggleButton.2
            @Override // com.facebook.rebound.SimpleSpringListener, com.facebook.rebound.SpringListener
            public void onSpringUpdate(Spring spring) {
                ToggleButton.this.E(spring.getCurrentValue());
            }
        };
        setup(attributeSet);
    }

    public ToggleButton(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.nrF = Color.parseColor("#4ebb7f");
        this.nrG = Color.parseColor("#dadbda");
        this.nrH = Color.parseColor("#ffffff");
        this.nrI = Color.parseColor("#ffffff");
        this.borderColor = this.nrG;
        this.nrJ = false;
        this.borderWidth = 2;
        this.rect = new RectF();
        this.nrP = true;
        this.nrR = new SimpleSpringListener() { // from class: tv.chushou.widget.ToggleButton.2
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
        this.nrE.removeListener(this.nrR);
    }

    @Override // android.view.View
    public void onAttachedToWindow() {
        super.onAttachedToWindow();
        this.nrE.addListener(this.nrR);
    }

    public void setOnColor(int i) {
        this.nrF = i;
        E(this.nrJ ? 1.0d : 0.0d);
    }

    public void setup(AttributeSet attributeSet) {
        this.paint = new Paint(1);
        this.paint.setStyle(Paint.Style.FILL);
        this.paint.setStrokeCap(Paint.Cap.ROUND);
        this.nrD = SpringSystem.create();
        this.nrE = this.nrD.createSpring();
        this.nrE.setSpringConfig(SpringConfig.fromOrigamiTensionAndFriction(50.0d, 7.0d));
        setOnClickListener(new View.OnClickListener() { // from class: tv.chushou.widget.ToggleButton.1
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                ToggleButton.this.wR(ToggleButton.this.nrP);
            }
        });
        TypedArray obtainStyledAttributes = getContext().obtainStyledAttributes(attributeSet, a.C0830a.ToggleButton);
        this.nrG = obtainStyledAttributes.getColor(a.C0830a.ToggleButton_offBorderColor, this.nrG);
        this.nrF = obtainStyledAttributes.getColor(a.C0830a.ToggleButton_onColor, this.nrF);
        this.nrI = obtainStyledAttributes.getColor(a.C0830a.ToggleButton_spotColor, this.nrI);
        this.nrH = obtainStyledAttributes.getColor(a.C0830a.ToggleButton_offColor, this.nrH);
        this.borderWidth = obtainStyledAttributes.getDimensionPixelSize(a.C0830a.ToggleButton_toggleBorderWidth, this.borderWidth);
        this.nrP = obtainStyledAttributes.getBoolean(a.C0830a.ToggleButton_animate, this.nrP);
        obtainStyledAttributes.recycle();
        this.borderColor = this.nrG;
    }

    public void toggle() {
        wR(true);
    }

    public void wR(boolean z) {
        this.nrJ = !this.nrJ;
        wS(z);
        if (this.nrQ != null) {
            this.nrQ.a(this.nrJ, this);
        }
    }

    public void dJI() {
        setToggleOn();
        if (this.nrQ != null) {
            this.nrQ.a(this.nrJ, this);
        }
    }

    public void dJJ() {
        setToggleOff();
        if (this.nrQ != null) {
            this.nrQ.a(this.nrJ, this);
        }
    }

    public void setToggleOn() {
        setToggleOn(true);
    }

    public void setToggleOn(boolean z) {
        this.nrJ = true;
        wS(z);
    }

    public void setToggleOff() {
        setToggleOff(true);
    }

    public void setToggleOff(boolean z) {
        this.nrJ = false;
        wS(z);
    }

    private void wS(boolean z) {
        if (z) {
            this.nrE.setEndValue(this.nrJ ? 1.0d : 0.0d);
            return;
        }
        this.nrE.setCurrentValue(this.nrJ ? 1.0d : 0.0d);
        E(this.nrJ ? 1.0d : 0.0d);
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
        this.bbb = Math.min(width, height) * 0.5f;
        this.centerY = this.bbb;
        this.startX = this.bbb;
        this.jvP = width - this.bbb;
        this.nrK = this.startX + this.borderWidth;
        this.nrL = this.jvP - this.borderWidth;
        this.nrM = height - (this.borderWidth * 4);
        this.nrN = this.nrJ ? this.nrL : this.nrK;
        this.nrO = this.nrM;
    }

    private int clamp(int i, int i2, int i3) {
        return Math.min(Math.max(i, i2), i3);
    }

    @Override // android.view.View
    public void draw(Canvas canvas) {
        super.draw(canvas);
        this.rect.set(0.0f, 0.0f, getWidth(), getHeight());
        this.paint.setColor(this.borderColor);
        canvas.drawRoundRect(this.rect, this.bbb, this.bbb, this.paint);
        if (this.nrO > 0.0f) {
            float f = this.nrO * 0.5f;
            this.rect.set(this.nrN - f, this.centerY - f, this.jvP + f, this.centerY + f);
            this.paint.setColor(this.nrH);
            canvas.drawRoundRect(this.rect, f, f, this.paint);
        }
        this.rect.set((this.nrN - 1.0f) - this.bbb, this.centerY - this.bbb, this.nrN + 1.1f + this.bbb, this.centerY + this.bbb);
        this.paint.setColor(this.borderColor);
        canvas.drawRoundRect(this.rect, this.bbb, this.bbb, this.paint);
        float f2 = this.nrM * 0.5f;
        this.rect.set(this.nrN - f2, this.centerY - f2, this.nrN + f2, this.centerY + f2);
        this.paint.setColor(this.nrI);
        canvas.drawRoundRect(this.rect, f2, f2, this.paint);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void E(double d) {
        this.nrN = (float) SpringUtil.mapValueFromRangeToRange(d, 0.0d, 1.0d, this.nrK, this.nrL);
        this.nrO = (float) SpringUtil.mapValueFromRangeToRange(1.0d - d, 0.0d, 1.0d, 10.0d, this.nrM);
        int blue = Color.blue(this.nrF);
        int red = Color.red(this.nrF);
        int green = Color.green(this.nrF);
        int blue2 = Color.blue(this.nrG);
        int red2 = Color.red(this.nrG);
        int green2 = Color.green(this.nrG);
        int mapValueFromRangeToRange = (int) SpringUtil.mapValueFromRangeToRange(1.0d - d, 0.0d, 1.0d, blue, blue2);
        int mapValueFromRangeToRange2 = (int) SpringUtil.mapValueFromRangeToRange(1.0d - d, 0.0d, 1.0d, red, red2);
        this.borderColor = Color.rgb(clamp(mapValueFromRangeToRange2, 0, 255), clamp((int) SpringUtil.mapValueFromRangeToRange(1.0d - d, 0.0d, 1.0d, green, green2), 0, 255), clamp(mapValueFromRangeToRange, 0, 255));
        postInvalidate();
    }

    public void setOnToggleChanged(a aVar) {
        this.nrQ = aVar;
    }

    public void setAnimate(boolean z) {
        this.nrP = z;
    }
}
