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
    private float aFe;
    private int borderColor;
    private int borderWidth;
    private float centerY;
    private float iJR;
    private SpringSystem nVP;
    private Spring nVQ;
    private int nVR;
    private int nVS;
    private int nVT;
    private int nVU;
    private boolean nVV;
    private float nVW;
    private float nVX;
    private int nVY;
    private float nVZ;
    private float nWa;
    private boolean nWb;
    private a nWc;
    SimpleSpringListener nWd;
    private Paint paint;
    private RectF rect;
    private float startX;

    /* loaded from: classes5.dex */
    public interface a {
        void a(boolean z, ToggleButton toggleButton);
    }

    public ToggleButton(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.nVR = Color.parseColor("#4ebb7f");
        this.nVS = Color.parseColor("#dadbda");
        this.nVT = Color.parseColor("#ffffff");
        this.nVU = Color.parseColor("#ffffff");
        this.borderColor = this.nVS;
        this.nVV = false;
        this.borderWidth = 2;
        this.rect = new RectF();
        this.nWb = true;
        this.nWd = new SimpleSpringListener() { // from class: tv.chushou.widget.ToggleButton.2
            @Override // com.facebook.rebound.SimpleSpringListener, com.facebook.rebound.SpringListener
            public void onSpringUpdate(Spring spring) {
                ToggleButton.this.A(spring.getCurrentValue());
            }
        };
        setup(attributeSet);
    }

    public ToggleButton(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.nVR = Color.parseColor("#4ebb7f");
        this.nVS = Color.parseColor("#dadbda");
        this.nVT = Color.parseColor("#ffffff");
        this.nVU = Color.parseColor("#ffffff");
        this.borderColor = this.nVS;
        this.nVV = false;
        this.borderWidth = 2;
        this.rect = new RectF();
        this.nWb = true;
        this.nWd = new SimpleSpringListener() { // from class: tv.chushou.widget.ToggleButton.2
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
        this.nVQ.removeListener(this.nWd);
    }

    @Override // android.view.View
    public void onAttachedToWindow() {
        super.onAttachedToWindow();
        this.nVQ.addListener(this.nWd);
    }

    public void setOnColor(int i) {
        this.nVR = i;
        A(this.nVV ? 1.0d : 0.0d);
    }

    public void setup(AttributeSet attributeSet) {
        this.paint = new Paint(1);
        this.paint.setStyle(Paint.Style.FILL);
        this.paint.setStrokeCap(Paint.Cap.ROUND);
        this.nVP = SpringSystem.create();
        this.nVQ = this.nVP.createSpring();
        this.nVQ.setSpringConfig(SpringConfig.fromOrigamiTensionAndFriction(50.0d, 7.0d));
        setOnClickListener(new View.OnClickListener() { // from class: tv.chushou.widget.ToggleButton.1
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                ToggleButton.this.xe(ToggleButton.this.nWb);
            }
        });
        TypedArray obtainStyledAttributes = getContext().obtainStyledAttributes(attributeSet, a.C0806a.ToggleButton);
        this.nVS = obtainStyledAttributes.getColor(a.C0806a.ToggleButton_offBorderColor, this.nVS);
        this.nVR = obtainStyledAttributes.getColor(a.C0806a.ToggleButton_onColor, this.nVR);
        this.nVU = obtainStyledAttributes.getColor(a.C0806a.ToggleButton_spotColor, this.nVU);
        this.nVT = obtainStyledAttributes.getColor(a.C0806a.ToggleButton_offColor, this.nVT);
        this.borderWidth = obtainStyledAttributes.getDimensionPixelSize(a.C0806a.ToggleButton_toggleBorderWidth, this.borderWidth);
        this.nWb = obtainStyledAttributes.getBoolean(a.C0806a.ToggleButton_animate, this.nWb);
        obtainStyledAttributes.recycle();
        this.borderColor = this.nVS;
    }

    public void toggle() {
        xe(true);
    }

    public void xe(boolean z) {
        this.nVV = !this.nVV;
        xf(z);
        if (this.nWc != null) {
            this.nWc.a(this.nVV, this);
        }
    }

    public void dQg() {
        setToggleOn();
        if (this.nWc != null) {
            this.nWc.a(this.nVV, this);
        }
    }

    public void dQh() {
        setToggleOff();
        if (this.nWc != null) {
            this.nWc.a(this.nVV, this);
        }
    }

    public void setToggleOn() {
        setToggleOn(true);
    }

    public void setToggleOn(boolean z) {
        this.nVV = true;
        xf(z);
    }

    public void setToggleOff() {
        setToggleOff(true);
    }

    public void setToggleOff(boolean z) {
        this.nVV = false;
        xf(z);
    }

    private void xf(boolean z) {
        if (z) {
            this.nVQ.setEndValue(this.nVV ? 1.0d : 0.0d);
            return;
        }
        this.nVQ.setCurrentValue(this.nVV ? 1.0d : 0.0d);
        A(this.nVV ? 1.0d : 0.0d);
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
        this.aFe = Math.min(width, height) * 0.5f;
        this.centerY = this.aFe;
        this.startX = this.aFe;
        this.iJR = width - this.aFe;
        this.nVW = this.startX + this.borderWidth;
        this.nVX = this.iJR - this.borderWidth;
        this.nVY = height - (this.borderWidth * 4);
        this.nVZ = this.nVV ? this.nVX : this.nVW;
        this.nWa = this.nVY;
    }

    private int clamp(int i, int i2, int i3) {
        return Math.min(Math.max(i, i2), i3);
    }

    @Override // android.view.View
    public void draw(Canvas canvas) {
        super.draw(canvas);
        this.rect.set(0.0f, 0.0f, getWidth(), getHeight());
        this.paint.setColor(this.borderColor);
        canvas.drawRoundRect(this.rect, this.aFe, this.aFe, this.paint);
        if (this.nWa > 0.0f) {
            float f = this.nWa * 0.5f;
            this.rect.set(this.nVZ - f, this.centerY - f, this.iJR + f, this.centerY + f);
            this.paint.setColor(this.nVT);
            canvas.drawRoundRect(this.rect, f, f, this.paint);
        }
        this.rect.set((this.nVZ - 1.0f) - this.aFe, this.centerY - this.aFe, this.nVZ + 1.1f + this.aFe, this.centerY + this.aFe);
        this.paint.setColor(this.borderColor);
        canvas.drawRoundRect(this.rect, this.aFe, this.aFe, this.paint);
        float f2 = this.nVY * 0.5f;
        this.rect.set(this.nVZ - f2, this.centerY - f2, this.nVZ + f2, this.centerY + f2);
        this.paint.setColor(this.nVU);
        canvas.drawRoundRect(this.rect, f2, f2, this.paint);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void A(double d) {
        this.nVZ = (float) SpringUtil.mapValueFromRangeToRange(d, 0.0d, 1.0d, this.nVW, this.nVX);
        this.nWa = (float) SpringUtil.mapValueFromRangeToRange(1.0d - d, 0.0d, 1.0d, 10.0d, this.nVY);
        int blue = Color.blue(this.nVR);
        int red = Color.red(this.nVR);
        int green = Color.green(this.nVR);
        int blue2 = Color.blue(this.nVS);
        int red2 = Color.red(this.nVS);
        int green2 = Color.green(this.nVS);
        int mapValueFromRangeToRange = (int) SpringUtil.mapValueFromRangeToRange(1.0d - d, 0.0d, 1.0d, blue, blue2);
        int mapValueFromRangeToRange2 = (int) SpringUtil.mapValueFromRangeToRange(1.0d - d, 0.0d, 1.0d, red, red2);
        this.borderColor = Color.rgb(clamp(mapValueFromRangeToRange2, 0, 255), clamp((int) SpringUtil.mapValueFromRangeToRange(1.0d - d, 0.0d, 1.0d, green, green2), 0, 255), clamp(mapValueFromRangeToRange, 0, 255));
        postInvalidate();
    }

    public void setOnToggleChanged(a aVar) {
        this.nWc = aVar;
    }

    public void setAnimate(boolean z) {
        this.nWb = z;
    }
}
