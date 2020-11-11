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
    private float bMq;
    private int borderColor;
    private int borderWidth;
    private float centerY;
    private float lwE;
    private int offBorderColor;
    private int offColor;
    private int onColor;
    private Paint paint;
    private SpringSystem qmg;
    private Spring qmh;
    private boolean qmi;
    private float qmj;
    private float qmk;
    private int qml;
    private float qmm;
    private float qmn;
    private boolean qmo;
    private a qmp;
    SimpleSpringListener qmq;
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
        this.qmi = false;
        this.borderWidth = 2;
        this.rect = new RectF();
        this.qmo = true;
        this.qmq = new SimpleSpringListener() { // from class: tv.chushou.widget.ToggleButton.2
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
        this.qmi = false;
        this.borderWidth = 2;
        this.rect = new RectF();
        this.qmo = true;
        this.qmq = new SimpleSpringListener() { // from class: tv.chushou.widget.ToggleButton.2
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
        this.qmh.removeListener(this.qmq);
    }

    @Override // android.view.View
    public void onAttachedToWindow() {
        super.onAttachedToWindow();
        this.qmh.addListener(this.qmq);
    }

    public void setOnColor(int i) {
        this.onColor = i;
        Q(this.qmi ? 1.0d : 0.0d);
    }

    public void setup(AttributeSet attributeSet) {
        this.paint = new Paint(1);
        this.paint.setStyle(Paint.Style.FILL);
        this.paint.setStrokeCap(Paint.Cap.ROUND);
        this.qmg = SpringSystem.create();
        this.qmh = this.qmg.createSpring();
        this.qmh.setSpringConfig(SpringConfig.fromOrigamiTensionAndFriction(50.0d, 7.0d));
        setOnClickListener(new View.OnClickListener() { // from class: tv.chushou.widget.ToggleButton.1
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                ToggleButton.this.zV(ToggleButton.this.qmo);
            }
        });
        TypedArray obtainStyledAttributes = getContext().obtainStyledAttributes(attributeSet, a.C1114a.ToggleButton);
        this.offBorderColor = obtainStyledAttributes.getColor(a.C1114a.ToggleButton_offBorderColor, this.offBorderColor);
        this.onColor = obtainStyledAttributes.getColor(a.C1114a.ToggleButton_onColor, this.onColor);
        this.spotColor = obtainStyledAttributes.getColor(a.C1114a.ToggleButton_spotColor, this.spotColor);
        this.offColor = obtainStyledAttributes.getColor(a.C1114a.ToggleButton_offColor, this.offColor);
        this.borderWidth = obtainStyledAttributes.getDimensionPixelSize(a.C1114a.ToggleButton_toggleBorderWidth, this.borderWidth);
        this.qmo = obtainStyledAttributes.getBoolean(a.C1114a.ToggleButton_animate, this.qmo);
        obtainStyledAttributes.recycle();
        this.borderColor = this.offBorderColor;
    }

    public void toggle() {
        zV(true);
    }

    public void zV(boolean z) {
        this.qmi = !this.qmi;
        Bs(z);
        if (this.qmp != null) {
            this.qmp.a(this.qmi, this);
        }
    }

    public void eHC() {
        setToggleOn();
        if (this.qmp != null) {
            this.qmp.a(this.qmi, this);
        }
    }

    public void eHD() {
        setToggleOff();
        if (this.qmp != null) {
            this.qmp.a(this.qmi, this);
        }
    }

    public void setToggleOn() {
        setToggleOn(true);
    }

    public void setToggleOn(boolean z) {
        this.qmi = true;
        Bs(z);
    }

    public void setToggleOff() {
        setToggleOff(true);
    }

    public void setToggleOff(boolean z) {
        this.qmi = false;
        Bs(z);
    }

    private void Bs(boolean z) {
        if (z) {
            this.qmh.setEndValue(this.qmi ? 1.0d : 0.0d);
            return;
        }
        this.qmh.setCurrentValue(this.qmi ? 1.0d : 0.0d);
        Q(this.qmi ? 1.0d : 0.0d);
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
        this.bMq = Math.min(width, height) * 0.5f;
        this.centerY = this.bMq;
        this.startX = this.bMq;
        this.lwE = width - this.bMq;
        this.qmj = this.startX + this.borderWidth;
        this.qmk = this.lwE - this.borderWidth;
        this.qml = height - (this.borderWidth * 4);
        this.qmm = this.qmi ? this.qmk : this.qmj;
        this.qmn = this.qml;
    }

    private int clamp(int i, int i2, int i3) {
        return Math.min(Math.max(i, i2), i3);
    }

    @Override // android.view.View
    public void draw(Canvas canvas) {
        super.draw(canvas);
        this.rect.set(0.0f, 0.0f, getWidth(), getHeight());
        this.paint.setColor(this.borderColor);
        canvas.drawRoundRect(this.rect, this.bMq, this.bMq, this.paint);
        if (this.qmn > 0.0f) {
            float f = this.qmn * 0.5f;
            this.rect.set(this.qmm - f, this.centerY - f, this.lwE + f, this.centerY + f);
            this.paint.setColor(this.offColor);
            canvas.drawRoundRect(this.rect, f, f, this.paint);
        }
        this.rect.set((this.qmm - 1.0f) - this.bMq, this.centerY - this.bMq, this.qmm + 1.1f + this.bMq, this.centerY + this.bMq);
        this.paint.setColor(this.borderColor);
        canvas.drawRoundRect(this.rect, this.bMq, this.bMq, this.paint);
        float f2 = this.qml * 0.5f;
        this.rect.set(this.qmm - f2, this.centerY - f2, this.qmm + f2, this.centerY + f2);
        this.paint.setColor(this.spotColor);
        canvas.drawRoundRect(this.rect, f2, f2, this.paint);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void Q(double d) {
        this.qmm = (float) SpringUtil.mapValueFromRangeToRange(d, 0.0d, 1.0d, this.qmj, this.qmk);
        this.qmn = (float) SpringUtil.mapValueFromRangeToRange(1.0d - d, 0.0d, 1.0d, 10.0d, this.qml);
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
        this.qmp = aVar;
    }

    public void setAnimate(boolean z) {
        this.qmo = z;
    }
}
