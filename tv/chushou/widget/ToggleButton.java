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
/* loaded from: classes4.dex */
public class ToggleButton extends View {
    private float aAO;
    private int borderColor;
    private int borderWidth;
    private float centerY;
    private float iIu;
    private SpringSystem nUV;
    private Spring nUW;
    private int nUX;
    private int nUY;
    private int nUZ;
    private int nVa;
    private boolean nVb;
    private float nVc;
    private float nVd;
    private int nVe;
    private float nVf;
    private float nVg;
    private boolean nVh;
    private a nVi;
    SimpleSpringListener nVj;
    private Paint paint;
    private RectF rect;
    private float startX;

    /* loaded from: classes4.dex */
    public interface a {
        void a(boolean z, ToggleButton toggleButton);
    }

    public ToggleButton(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.nUX = Color.parseColor("#4ebb7f");
        this.nUY = Color.parseColor("#dadbda");
        this.nUZ = Color.parseColor("#ffffff");
        this.nVa = Color.parseColor("#ffffff");
        this.borderColor = this.nUY;
        this.nVb = false;
        this.borderWidth = 2;
        this.rect = new RectF();
        this.nVh = true;
        this.nVj = new SimpleSpringListener() { // from class: tv.chushou.widget.ToggleButton.2
            @Override // com.facebook.rebound.SimpleSpringListener, com.facebook.rebound.SpringListener
            public void onSpringUpdate(Spring spring) {
                ToggleButton.this.A(spring.getCurrentValue());
            }
        };
        setup(attributeSet);
    }

    public ToggleButton(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.nUX = Color.parseColor("#4ebb7f");
        this.nUY = Color.parseColor("#dadbda");
        this.nUZ = Color.parseColor("#ffffff");
        this.nVa = Color.parseColor("#ffffff");
        this.borderColor = this.nUY;
        this.nVb = false;
        this.borderWidth = 2;
        this.rect = new RectF();
        this.nVh = true;
        this.nVj = new SimpleSpringListener() { // from class: tv.chushou.widget.ToggleButton.2
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
        this.nUW.removeListener(this.nVj);
    }

    @Override // android.view.View
    public void onAttachedToWindow() {
        super.onAttachedToWindow();
        this.nUW.addListener(this.nVj);
    }

    public void setOnColor(int i) {
        this.nUX = i;
        A(this.nVb ? 1.0d : 0.0d);
    }

    public void setup(AttributeSet attributeSet) {
        this.paint = new Paint(1);
        this.paint.setStyle(Paint.Style.FILL);
        this.paint.setStrokeCap(Paint.Cap.ROUND);
        this.nUV = SpringSystem.create();
        this.nUW = this.nUV.createSpring();
        this.nUW.setSpringConfig(SpringConfig.fromOrigamiTensionAndFriction(50.0d, 7.0d));
        setOnClickListener(new View.OnClickListener() { // from class: tv.chushou.widget.ToggleButton.1
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                ToggleButton.this.xb(ToggleButton.this.nVh);
            }
        });
        TypedArray obtainStyledAttributes = getContext().obtainStyledAttributes(attributeSet, a.C0798a.ToggleButton);
        this.nUY = obtainStyledAttributes.getColor(a.C0798a.ToggleButton_offBorderColor, this.nUY);
        this.nUX = obtainStyledAttributes.getColor(a.C0798a.ToggleButton_onColor, this.nUX);
        this.nVa = obtainStyledAttributes.getColor(a.C0798a.ToggleButton_spotColor, this.nVa);
        this.nUZ = obtainStyledAttributes.getColor(a.C0798a.ToggleButton_offColor, this.nUZ);
        this.borderWidth = obtainStyledAttributes.getDimensionPixelSize(a.C0798a.ToggleButton_toggleBorderWidth, this.borderWidth);
        this.nVh = obtainStyledAttributes.getBoolean(a.C0798a.ToggleButton_animate, this.nVh);
        obtainStyledAttributes.recycle();
        this.borderColor = this.nUY;
    }

    public void toggle() {
        xb(true);
    }

    public void xb(boolean z) {
        this.nVb = !this.nVb;
        xc(z);
        if (this.nVi != null) {
            this.nVi.a(this.nVb, this);
        }
    }

    public void dOR() {
        setToggleOn();
        if (this.nVi != null) {
            this.nVi.a(this.nVb, this);
        }
    }

    public void dOS() {
        setToggleOff();
        if (this.nVi != null) {
            this.nVi.a(this.nVb, this);
        }
    }

    public void setToggleOn() {
        setToggleOn(true);
    }

    public void setToggleOn(boolean z) {
        this.nVb = true;
        xc(z);
    }

    public void setToggleOff() {
        setToggleOff(true);
    }

    public void setToggleOff(boolean z) {
        this.nVb = false;
        xc(z);
    }

    private void xc(boolean z) {
        if (z) {
            this.nUW.setEndValue(this.nVb ? 1.0d : 0.0d);
            return;
        }
        this.nUW.setCurrentValue(this.nVb ? 1.0d : 0.0d);
        A(this.nVb ? 1.0d : 0.0d);
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
        this.aAO = Math.min(width, height) * 0.5f;
        this.centerY = this.aAO;
        this.startX = this.aAO;
        this.iIu = width - this.aAO;
        this.nVc = this.startX + this.borderWidth;
        this.nVd = this.iIu - this.borderWidth;
        this.nVe = height - (this.borderWidth * 4);
        this.nVf = this.nVb ? this.nVd : this.nVc;
        this.nVg = this.nVe;
    }

    private int clamp(int i, int i2, int i3) {
        return Math.min(Math.max(i, i2), i3);
    }

    @Override // android.view.View
    public void draw(Canvas canvas) {
        super.draw(canvas);
        this.rect.set(0.0f, 0.0f, getWidth(), getHeight());
        this.paint.setColor(this.borderColor);
        canvas.drawRoundRect(this.rect, this.aAO, this.aAO, this.paint);
        if (this.nVg > 0.0f) {
            float f = this.nVg * 0.5f;
            this.rect.set(this.nVf - f, this.centerY - f, this.iIu + f, this.centerY + f);
            this.paint.setColor(this.nUZ);
            canvas.drawRoundRect(this.rect, f, f, this.paint);
        }
        this.rect.set((this.nVf - 1.0f) - this.aAO, this.centerY - this.aAO, this.nVf + 1.1f + this.aAO, this.centerY + this.aAO);
        this.paint.setColor(this.borderColor);
        canvas.drawRoundRect(this.rect, this.aAO, this.aAO, this.paint);
        float f2 = this.nVe * 0.5f;
        this.rect.set(this.nVf - f2, this.centerY - f2, this.nVf + f2, this.centerY + f2);
        this.paint.setColor(this.nVa);
        canvas.drawRoundRect(this.rect, f2, f2, this.paint);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void A(double d) {
        this.nVf = (float) SpringUtil.mapValueFromRangeToRange(d, 0.0d, 1.0d, this.nVc, this.nVd);
        this.nVg = (float) SpringUtil.mapValueFromRangeToRange(1.0d - d, 0.0d, 1.0d, 10.0d, this.nVe);
        int blue = Color.blue(this.nUX);
        int red = Color.red(this.nUX);
        int green = Color.green(this.nUX);
        int blue2 = Color.blue(this.nUY);
        int red2 = Color.red(this.nUY);
        int green2 = Color.green(this.nUY);
        int mapValueFromRangeToRange = (int) SpringUtil.mapValueFromRangeToRange(1.0d - d, 0.0d, 1.0d, blue, blue2);
        int mapValueFromRangeToRange2 = (int) SpringUtil.mapValueFromRangeToRange(1.0d - d, 0.0d, 1.0d, red, red2);
        this.borderColor = Color.rgb(clamp(mapValueFromRangeToRange2, 0, 255), clamp((int) SpringUtil.mapValueFromRangeToRange(1.0d - d, 0.0d, 1.0d, green, green2), 0, 255), clamp(mapValueFromRangeToRange, 0, 255));
        postInvalidate();
    }

    public void setOnToggleChanged(a aVar) {
        this.nVi = aVar;
    }

    public void setAnimate(boolean z) {
        this.nVh = z;
    }
}
