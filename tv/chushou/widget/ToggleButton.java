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
    private float bGL;
    private int borderColor;
    private int borderWidth;
    private float centerY;
    private float lqH;
    private int offBorderColor;
    private int offColor;
    private int onColor;
    private Paint paint;
    private SpringSystem qcL;
    private Spring qcM;
    private boolean qcN;
    private float qcO;
    private float qcP;
    private int qcQ;
    private float qcR;
    private float qcS;
    private boolean qcT;
    private a qcU;
    SimpleSpringListener qcV;
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
        this.qcN = false;
        this.borderWidth = 2;
        this.rect = new RectF();
        this.qcT = true;
        this.qcV = new SimpleSpringListener() { // from class: tv.chushou.widget.ToggleButton.2
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
        this.qcN = false;
        this.borderWidth = 2;
        this.rect = new RectF();
        this.qcT = true;
        this.qcV = new SimpleSpringListener() { // from class: tv.chushou.widget.ToggleButton.2
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
        this.qcM.removeListener(this.qcV);
    }

    @Override // android.view.View
    public void onAttachedToWindow() {
        super.onAttachedToWindow();
        this.qcM.addListener(this.qcV);
    }

    public void setOnColor(int i) {
        this.onColor = i;
        Q(this.qcN ? 1.0d : 0.0d);
    }

    public void setup(AttributeSet attributeSet) {
        this.paint = new Paint(1);
        this.paint.setStyle(Paint.Style.FILL);
        this.paint.setStrokeCap(Paint.Cap.ROUND);
        this.qcL = SpringSystem.create();
        this.qcM = this.qcL.createSpring();
        this.qcM.setSpringConfig(SpringConfig.fromOrigamiTensionAndFriction(50.0d, 7.0d));
        setOnClickListener(new View.OnClickListener() { // from class: tv.chushou.widget.ToggleButton.1
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                ToggleButton.this.zK(ToggleButton.this.qcT);
            }
        });
        TypedArray obtainStyledAttributes = getContext().obtainStyledAttributes(attributeSet, a.C1094a.ToggleButton);
        this.offBorderColor = obtainStyledAttributes.getColor(a.C1094a.ToggleButton_offBorderColor, this.offBorderColor);
        this.onColor = obtainStyledAttributes.getColor(a.C1094a.ToggleButton_onColor, this.onColor);
        this.spotColor = obtainStyledAttributes.getColor(a.C1094a.ToggleButton_spotColor, this.spotColor);
        this.offColor = obtainStyledAttributes.getColor(a.C1094a.ToggleButton_offColor, this.offColor);
        this.borderWidth = obtainStyledAttributes.getDimensionPixelSize(a.C1094a.ToggleButton_toggleBorderWidth, this.borderWidth);
        this.qcT = obtainStyledAttributes.getBoolean(a.C1094a.ToggleButton_animate, this.qcT);
        obtainStyledAttributes.recycle();
        this.borderColor = this.offBorderColor;
    }

    public void toggle() {
        zK(true);
    }

    public void zK(boolean z) {
        this.qcN = !this.qcN;
        Bh(z);
        if (this.qcU != null) {
            this.qcU.a(this.qcN, this);
        }
    }

    public void eDN() {
        setToggleOn();
        if (this.qcU != null) {
            this.qcU.a(this.qcN, this);
        }
    }

    public void eDO() {
        setToggleOff();
        if (this.qcU != null) {
            this.qcU.a(this.qcN, this);
        }
    }

    public void setToggleOn() {
        setToggleOn(true);
    }

    public void setToggleOn(boolean z) {
        this.qcN = true;
        Bh(z);
    }

    public void setToggleOff() {
        setToggleOff(true);
    }

    public void setToggleOff(boolean z) {
        this.qcN = false;
        Bh(z);
    }

    private void Bh(boolean z) {
        if (z) {
            this.qcM.setEndValue(this.qcN ? 1.0d : 0.0d);
            return;
        }
        this.qcM.setCurrentValue(this.qcN ? 1.0d : 0.0d);
        Q(this.qcN ? 1.0d : 0.0d);
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
        this.bGL = Math.min(width, height) * 0.5f;
        this.centerY = this.bGL;
        this.startX = this.bGL;
        this.lqH = width - this.bGL;
        this.qcO = this.startX + this.borderWidth;
        this.qcP = this.lqH - this.borderWidth;
        this.qcQ = height - (this.borderWidth * 4);
        this.qcR = this.qcN ? this.qcP : this.qcO;
        this.qcS = this.qcQ;
    }

    private int clamp(int i, int i2, int i3) {
        return Math.min(Math.max(i, i2), i3);
    }

    @Override // android.view.View
    public void draw(Canvas canvas) {
        super.draw(canvas);
        this.rect.set(0.0f, 0.0f, getWidth(), getHeight());
        this.paint.setColor(this.borderColor);
        canvas.drawRoundRect(this.rect, this.bGL, this.bGL, this.paint);
        if (this.qcS > 0.0f) {
            float f = this.qcS * 0.5f;
            this.rect.set(this.qcR - f, this.centerY - f, this.lqH + f, this.centerY + f);
            this.paint.setColor(this.offColor);
            canvas.drawRoundRect(this.rect, f, f, this.paint);
        }
        this.rect.set((this.qcR - 1.0f) - this.bGL, this.centerY - this.bGL, this.qcR + 1.1f + this.bGL, this.centerY + this.bGL);
        this.paint.setColor(this.borderColor);
        canvas.drawRoundRect(this.rect, this.bGL, this.bGL, this.paint);
        float f2 = this.qcQ * 0.5f;
        this.rect.set(this.qcR - f2, this.centerY - f2, this.qcR + f2, this.centerY + f2);
        this.paint.setColor(this.spotColor);
        canvas.drawRoundRect(this.rect, f2, f2, this.paint);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void Q(double d) {
        this.qcR = (float) SpringUtil.mapValueFromRangeToRange(d, 0.0d, 1.0d, this.qcO, this.qcP);
        this.qcS = (float) SpringUtil.mapValueFromRangeToRange(1.0d - d, 0.0d, 1.0d, 10.0d, this.qcQ);
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
        this.qcU = aVar;
    }

    public void setAnimate(boolean z) {
        this.qcT = z;
    }
}
