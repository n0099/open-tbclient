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
    private float aFg;
    private int borderColor;
    private int borderWidth;
    private float centerY;
    private float iKf;
    private SpringSystem nWc;
    private Spring nWd;
    private int nWe;
    private int nWf;
    private int nWg;
    private int nWh;
    private boolean nWi;
    private float nWj;
    private float nWk;
    private int nWl;
    private float nWm;
    private float nWn;
    private boolean nWo;
    private a nWp;
    SimpleSpringListener nWq;
    private Paint paint;
    private RectF rect;
    private float startX;

    /* loaded from: classes5.dex */
    public interface a {
        void a(boolean z, ToggleButton toggleButton);
    }

    public ToggleButton(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.nWe = Color.parseColor("#4ebb7f");
        this.nWf = Color.parseColor("#dadbda");
        this.nWg = Color.parseColor("#ffffff");
        this.nWh = Color.parseColor("#ffffff");
        this.borderColor = this.nWf;
        this.nWi = false;
        this.borderWidth = 2;
        this.rect = new RectF();
        this.nWo = true;
        this.nWq = new SimpleSpringListener() { // from class: tv.chushou.widget.ToggleButton.2
            @Override // com.facebook.rebound.SimpleSpringListener, com.facebook.rebound.SpringListener
            public void onSpringUpdate(Spring spring) {
                ToggleButton.this.A(spring.getCurrentValue());
            }
        };
        setup(attributeSet);
    }

    public ToggleButton(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.nWe = Color.parseColor("#4ebb7f");
        this.nWf = Color.parseColor("#dadbda");
        this.nWg = Color.parseColor("#ffffff");
        this.nWh = Color.parseColor("#ffffff");
        this.borderColor = this.nWf;
        this.nWi = false;
        this.borderWidth = 2;
        this.rect = new RectF();
        this.nWo = true;
        this.nWq = new SimpleSpringListener() { // from class: tv.chushou.widget.ToggleButton.2
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
        this.nWd.removeListener(this.nWq);
    }

    @Override // android.view.View
    public void onAttachedToWindow() {
        super.onAttachedToWindow();
        this.nWd.addListener(this.nWq);
    }

    public void setOnColor(int i) {
        this.nWe = i;
        A(this.nWi ? 1.0d : 0.0d);
    }

    public void setup(AttributeSet attributeSet) {
        this.paint = new Paint(1);
        this.paint.setStyle(Paint.Style.FILL);
        this.paint.setStrokeCap(Paint.Cap.ROUND);
        this.nWc = SpringSystem.create();
        this.nWd = this.nWc.createSpring();
        this.nWd.setSpringConfig(SpringConfig.fromOrigamiTensionAndFriction(50.0d, 7.0d));
        setOnClickListener(new View.OnClickListener() { // from class: tv.chushou.widget.ToggleButton.1
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                ToggleButton.this.xe(ToggleButton.this.nWo);
            }
        });
        TypedArray obtainStyledAttributes = getContext().obtainStyledAttributes(attributeSet, a.C0806a.ToggleButton);
        this.nWf = obtainStyledAttributes.getColor(a.C0806a.ToggleButton_offBorderColor, this.nWf);
        this.nWe = obtainStyledAttributes.getColor(a.C0806a.ToggleButton_onColor, this.nWe);
        this.nWh = obtainStyledAttributes.getColor(a.C0806a.ToggleButton_spotColor, this.nWh);
        this.nWg = obtainStyledAttributes.getColor(a.C0806a.ToggleButton_offColor, this.nWg);
        this.borderWidth = obtainStyledAttributes.getDimensionPixelSize(a.C0806a.ToggleButton_toggleBorderWidth, this.borderWidth);
        this.nWo = obtainStyledAttributes.getBoolean(a.C0806a.ToggleButton_animate, this.nWo);
        obtainStyledAttributes.recycle();
        this.borderColor = this.nWf;
    }

    public void toggle() {
        xe(true);
    }

    public void xe(boolean z) {
        this.nWi = !this.nWi;
        xf(z);
        if (this.nWp != null) {
            this.nWp.a(this.nWi, this);
        }
    }

    public void dQj() {
        setToggleOn();
        if (this.nWp != null) {
            this.nWp.a(this.nWi, this);
        }
    }

    public void dQk() {
        setToggleOff();
        if (this.nWp != null) {
            this.nWp.a(this.nWi, this);
        }
    }

    public void setToggleOn() {
        setToggleOn(true);
    }

    public void setToggleOn(boolean z) {
        this.nWi = true;
        xf(z);
    }

    public void setToggleOff() {
        setToggleOff(true);
    }

    public void setToggleOff(boolean z) {
        this.nWi = false;
        xf(z);
    }

    private void xf(boolean z) {
        if (z) {
            this.nWd.setEndValue(this.nWi ? 1.0d : 0.0d);
            return;
        }
        this.nWd.setCurrentValue(this.nWi ? 1.0d : 0.0d);
        A(this.nWi ? 1.0d : 0.0d);
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
        this.aFg = Math.min(width, height) * 0.5f;
        this.centerY = this.aFg;
        this.startX = this.aFg;
        this.iKf = width - this.aFg;
        this.nWj = this.startX + this.borderWidth;
        this.nWk = this.iKf - this.borderWidth;
        this.nWl = height - (this.borderWidth * 4);
        this.nWm = this.nWi ? this.nWk : this.nWj;
        this.nWn = this.nWl;
    }

    private int clamp(int i, int i2, int i3) {
        return Math.min(Math.max(i, i2), i3);
    }

    @Override // android.view.View
    public void draw(Canvas canvas) {
        super.draw(canvas);
        this.rect.set(0.0f, 0.0f, getWidth(), getHeight());
        this.paint.setColor(this.borderColor);
        canvas.drawRoundRect(this.rect, this.aFg, this.aFg, this.paint);
        if (this.nWn > 0.0f) {
            float f = this.nWn * 0.5f;
            this.rect.set(this.nWm - f, this.centerY - f, this.iKf + f, this.centerY + f);
            this.paint.setColor(this.nWg);
            canvas.drawRoundRect(this.rect, f, f, this.paint);
        }
        this.rect.set((this.nWm - 1.0f) - this.aFg, this.centerY - this.aFg, this.nWm + 1.1f + this.aFg, this.centerY + this.aFg);
        this.paint.setColor(this.borderColor);
        canvas.drawRoundRect(this.rect, this.aFg, this.aFg, this.paint);
        float f2 = this.nWl * 0.5f;
        this.rect.set(this.nWm - f2, this.centerY - f2, this.nWm + f2, this.centerY + f2);
        this.paint.setColor(this.nWh);
        canvas.drawRoundRect(this.rect, f2, f2, this.paint);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void A(double d) {
        this.nWm = (float) SpringUtil.mapValueFromRangeToRange(d, 0.0d, 1.0d, this.nWj, this.nWk);
        this.nWn = (float) SpringUtil.mapValueFromRangeToRange(1.0d - d, 0.0d, 1.0d, 10.0d, this.nWl);
        int blue = Color.blue(this.nWe);
        int red = Color.red(this.nWe);
        int green = Color.green(this.nWe);
        int blue2 = Color.blue(this.nWf);
        int red2 = Color.red(this.nWf);
        int green2 = Color.green(this.nWf);
        int mapValueFromRangeToRange = (int) SpringUtil.mapValueFromRangeToRange(1.0d - d, 0.0d, 1.0d, blue, blue2);
        int mapValueFromRangeToRange2 = (int) SpringUtil.mapValueFromRangeToRange(1.0d - d, 0.0d, 1.0d, red, red2);
        this.borderColor = Color.rgb(clamp(mapValueFromRangeToRange2, 0, 255), clamp((int) SpringUtil.mapValueFromRangeToRange(1.0d - d, 0.0d, 1.0d, green, green2), 0, 255), clamp(mapValueFromRangeToRange, 0, 255));
        postInvalidate();
    }

    public void setOnToggleChanged(a aVar) {
        this.nWp = aVar;
    }

    public void setAnimate(boolean z) {
        this.nWo = z;
    }
}
