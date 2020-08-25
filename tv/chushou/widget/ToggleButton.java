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
    private float btQ;
    private float centerY;
    private float kGm;
    private SpringSystem oMi;
    private Spring oMj;
    private boolean oMk;
    private float oMl;
    private float oMm;
    private int oMn;
    private float oMo;
    private float oMp;
    private boolean oMq;
    private a oMr;
    SimpleSpringListener oMs;
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
        this.oMk = false;
        this.borderWidth = 2;
        this.rect = new RectF();
        this.oMq = true;
        this.oMs = new SimpleSpringListener() { // from class: tv.chushou.widget.ToggleButton.2
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
        this.oMk = false;
        this.borderWidth = 2;
        this.rect = new RectF();
        this.oMq = true;
        this.oMs = new SimpleSpringListener() { // from class: tv.chushou.widget.ToggleButton.2
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
        this.oMj.removeListener(this.oMs);
    }

    @Override // android.view.View
    public void onAttachedToWindow() {
        super.onAttachedToWindow();
        this.oMj.addListener(this.oMs);
    }

    public void setOnColor(int i) {
        this.onColor = i;
        M(this.oMk ? 1.0d : 0.0d);
    }

    public void setup(AttributeSet attributeSet) {
        this.paint = new Paint(1);
        this.paint.setStyle(Paint.Style.FILL);
        this.paint.setStrokeCap(Paint.Cap.ROUND);
        this.oMi = SpringSystem.create();
        this.oMj = this.oMi.createSpring();
        this.oMj.setSpringConfig(SpringConfig.fromOrigamiTensionAndFriction(50.0d, 7.0d));
        setOnClickListener(new View.OnClickListener() { // from class: tv.chushou.widget.ToggleButton.1
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                ToggleButton.this.zi(ToggleButton.this.oMq);
            }
        });
        TypedArray obtainStyledAttributes = getContext().obtainStyledAttributes(attributeSet, a.C1007a.ToggleButton);
        this.offBorderColor = obtainStyledAttributes.getColor(a.C1007a.ToggleButton_offBorderColor, this.offBorderColor);
        this.onColor = obtainStyledAttributes.getColor(a.C1007a.ToggleButton_onColor, this.onColor);
        this.spotColor = obtainStyledAttributes.getColor(a.C1007a.ToggleButton_spotColor, this.spotColor);
        this.offColor = obtainStyledAttributes.getColor(a.C1007a.ToggleButton_offColor, this.offColor);
        this.borderWidth = obtainStyledAttributes.getDimensionPixelSize(a.C1007a.ToggleButton_toggleBorderWidth, this.borderWidth);
        this.oMq = obtainStyledAttributes.getBoolean(a.C1007a.ToggleButton_animate, this.oMq);
        obtainStyledAttributes.recycle();
        this.borderColor = this.offBorderColor;
    }

    public void toggle() {
        zi(true);
    }

    public void zi(boolean z) {
        this.oMk = !this.oMk;
        zj(z);
        if (this.oMr != null) {
            this.oMr.a(this.oMk, this);
        }
    }

    public void elX() {
        setToggleOn();
        if (this.oMr != null) {
            this.oMr.a(this.oMk, this);
        }
    }

    public void elY() {
        setToggleOff();
        if (this.oMr != null) {
            this.oMr.a(this.oMk, this);
        }
    }

    public void setToggleOn() {
        setToggleOn(true);
    }

    public void setToggleOn(boolean z) {
        this.oMk = true;
        zj(z);
    }

    public void setToggleOff() {
        setToggleOff(true);
    }

    public void setToggleOff(boolean z) {
        this.oMk = false;
        zj(z);
    }

    private void zj(boolean z) {
        if (z) {
            this.oMj.setEndValue(this.oMk ? 1.0d : 0.0d);
            return;
        }
        this.oMj.setCurrentValue(this.oMk ? 1.0d : 0.0d);
        M(this.oMk ? 1.0d : 0.0d);
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
        this.btQ = Math.min(width, height) * 0.5f;
        this.centerY = this.btQ;
        this.startX = this.btQ;
        this.kGm = width - this.btQ;
        this.oMl = this.startX + this.borderWidth;
        this.oMm = this.kGm - this.borderWidth;
        this.oMn = height - (this.borderWidth * 4);
        this.oMo = this.oMk ? this.oMm : this.oMl;
        this.oMp = this.oMn;
    }

    private int clamp(int i, int i2, int i3) {
        return Math.min(Math.max(i, i2), i3);
    }

    @Override // android.view.View
    public void draw(Canvas canvas) {
        super.draw(canvas);
        this.rect.set(0.0f, 0.0f, getWidth(), getHeight());
        this.paint.setColor(this.borderColor);
        canvas.drawRoundRect(this.rect, this.btQ, this.btQ, this.paint);
        if (this.oMp > 0.0f) {
            float f = this.oMp * 0.5f;
            this.rect.set(this.oMo - f, this.centerY - f, this.kGm + f, this.centerY + f);
            this.paint.setColor(this.offColor);
            canvas.drawRoundRect(this.rect, f, f, this.paint);
        }
        this.rect.set((this.oMo - 1.0f) - this.btQ, this.centerY - this.btQ, this.oMo + 1.1f + this.btQ, this.centerY + this.btQ);
        this.paint.setColor(this.borderColor);
        canvas.drawRoundRect(this.rect, this.btQ, this.btQ, this.paint);
        float f2 = this.oMn * 0.5f;
        this.rect.set(this.oMo - f2, this.centerY - f2, this.oMo + f2, this.centerY + f2);
        this.paint.setColor(this.spotColor);
        canvas.drawRoundRect(this.rect, f2, f2, this.paint);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void M(double d) {
        this.oMo = (float) SpringUtil.mapValueFromRangeToRange(d, 0.0d, 1.0d, this.oMl, this.oMm);
        this.oMp = (float) SpringUtil.mapValueFromRangeToRange(1.0d - d, 0.0d, 1.0d, 10.0d, this.oMn);
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
        this.oMr = aVar;
    }

    public void setAnimate(boolean z) {
        this.oMq = z;
    }
}
