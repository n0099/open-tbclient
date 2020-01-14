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
    private SpringSystem nVa;
    private Spring nVb;
    private int nVc;
    private int nVd;
    private int nVe;
    private int nVf;
    private boolean nVg;
    private float nVh;
    private float nVi;
    private int nVj;
    private float nVk;
    private float nVl;
    private boolean nVm;
    private a nVn;
    SimpleSpringListener nVo;
    private Paint paint;
    private RectF rect;
    private float startX;

    /* loaded from: classes4.dex */
    public interface a {
        void a(boolean z, ToggleButton toggleButton);
    }

    public ToggleButton(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.nVc = Color.parseColor("#4ebb7f");
        this.nVd = Color.parseColor("#dadbda");
        this.nVe = Color.parseColor("#ffffff");
        this.nVf = Color.parseColor("#ffffff");
        this.borderColor = this.nVd;
        this.nVg = false;
        this.borderWidth = 2;
        this.rect = new RectF();
        this.nVm = true;
        this.nVo = new SimpleSpringListener() { // from class: tv.chushou.widget.ToggleButton.2
            @Override // com.facebook.rebound.SimpleSpringListener, com.facebook.rebound.SpringListener
            public void onSpringUpdate(Spring spring) {
                ToggleButton.this.A(spring.getCurrentValue());
            }
        };
        setup(attributeSet);
    }

    public ToggleButton(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.nVc = Color.parseColor("#4ebb7f");
        this.nVd = Color.parseColor("#dadbda");
        this.nVe = Color.parseColor("#ffffff");
        this.nVf = Color.parseColor("#ffffff");
        this.borderColor = this.nVd;
        this.nVg = false;
        this.borderWidth = 2;
        this.rect = new RectF();
        this.nVm = true;
        this.nVo = new SimpleSpringListener() { // from class: tv.chushou.widget.ToggleButton.2
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
        this.nVb.removeListener(this.nVo);
    }

    @Override // android.view.View
    public void onAttachedToWindow() {
        super.onAttachedToWindow();
        this.nVb.addListener(this.nVo);
    }

    public void setOnColor(int i) {
        this.nVc = i;
        A(this.nVg ? 1.0d : 0.0d);
    }

    public void setup(AttributeSet attributeSet) {
        this.paint = new Paint(1);
        this.paint.setStyle(Paint.Style.FILL);
        this.paint.setStrokeCap(Paint.Cap.ROUND);
        this.nVa = SpringSystem.create();
        this.nVb = this.nVa.createSpring();
        this.nVb.setSpringConfig(SpringConfig.fromOrigamiTensionAndFriction(50.0d, 7.0d));
        setOnClickListener(new View.OnClickListener() { // from class: tv.chushou.widget.ToggleButton.1
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                ToggleButton.this.xb(ToggleButton.this.nVm);
            }
        });
        TypedArray obtainStyledAttributes = getContext().obtainStyledAttributes(attributeSet, a.C0798a.ToggleButton);
        this.nVd = obtainStyledAttributes.getColor(a.C0798a.ToggleButton_offBorderColor, this.nVd);
        this.nVc = obtainStyledAttributes.getColor(a.C0798a.ToggleButton_onColor, this.nVc);
        this.nVf = obtainStyledAttributes.getColor(a.C0798a.ToggleButton_spotColor, this.nVf);
        this.nVe = obtainStyledAttributes.getColor(a.C0798a.ToggleButton_offColor, this.nVe);
        this.borderWidth = obtainStyledAttributes.getDimensionPixelSize(a.C0798a.ToggleButton_toggleBorderWidth, this.borderWidth);
        this.nVm = obtainStyledAttributes.getBoolean(a.C0798a.ToggleButton_animate, this.nVm);
        obtainStyledAttributes.recycle();
        this.borderColor = this.nVd;
    }

    public void toggle() {
        xb(true);
    }

    public void xb(boolean z) {
        this.nVg = !this.nVg;
        xc(z);
        if (this.nVn != null) {
            this.nVn.a(this.nVg, this);
        }
    }

    public void dOT() {
        setToggleOn();
        if (this.nVn != null) {
            this.nVn.a(this.nVg, this);
        }
    }

    public void dOU() {
        setToggleOff();
        if (this.nVn != null) {
            this.nVn.a(this.nVg, this);
        }
    }

    public void setToggleOn() {
        setToggleOn(true);
    }

    public void setToggleOn(boolean z) {
        this.nVg = true;
        xc(z);
    }

    public void setToggleOff() {
        setToggleOff(true);
    }

    public void setToggleOff(boolean z) {
        this.nVg = false;
        xc(z);
    }

    private void xc(boolean z) {
        if (z) {
            this.nVb.setEndValue(this.nVg ? 1.0d : 0.0d);
            return;
        }
        this.nVb.setCurrentValue(this.nVg ? 1.0d : 0.0d);
        A(this.nVg ? 1.0d : 0.0d);
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
        this.nVh = this.startX + this.borderWidth;
        this.nVi = this.iIu - this.borderWidth;
        this.nVj = height - (this.borderWidth * 4);
        this.nVk = this.nVg ? this.nVi : this.nVh;
        this.nVl = this.nVj;
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
        if (this.nVl > 0.0f) {
            float f = this.nVl * 0.5f;
            this.rect.set(this.nVk - f, this.centerY - f, this.iIu + f, this.centerY + f);
            this.paint.setColor(this.nVe);
            canvas.drawRoundRect(this.rect, f, f, this.paint);
        }
        this.rect.set((this.nVk - 1.0f) - this.aAO, this.centerY - this.aAO, this.nVk + 1.1f + this.aAO, this.centerY + this.aAO);
        this.paint.setColor(this.borderColor);
        canvas.drawRoundRect(this.rect, this.aAO, this.aAO, this.paint);
        float f2 = this.nVj * 0.5f;
        this.rect.set(this.nVk - f2, this.centerY - f2, this.nVk + f2, this.centerY + f2);
        this.paint.setColor(this.nVf);
        canvas.drawRoundRect(this.rect, f2, f2, this.paint);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void A(double d) {
        this.nVk = (float) SpringUtil.mapValueFromRangeToRange(d, 0.0d, 1.0d, this.nVh, this.nVi);
        this.nVl = (float) SpringUtil.mapValueFromRangeToRange(1.0d - d, 0.0d, 1.0d, 10.0d, this.nVj);
        int blue = Color.blue(this.nVc);
        int red = Color.red(this.nVc);
        int green = Color.green(this.nVc);
        int blue2 = Color.blue(this.nVd);
        int red2 = Color.red(this.nVd);
        int green2 = Color.green(this.nVd);
        int mapValueFromRangeToRange = (int) SpringUtil.mapValueFromRangeToRange(1.0d - d, 0.0d, 1.0d, blue, blue2);
        int mapValueFromRangeToRange2 = (int) SpringUtil.mapValueFromRangeToRange(1.0d - d, 0.0d, 1.0d, red, red2);
        this.borderColor = Color.rgb(clamp(mapValueFromRangeToRange2, 0, 255), clamp((int) SpringUtil.mapValueFromRangeToRange(1.0d - d, 0.0d, 1.0d, green, green2), 0, 255), clamp(mapValueFromRangeToRange, 0, 255));
        postInvalidate();
    }

    public void setOnToggleChanged(a aVar) {
        this.nVn = aVar;
    }

    public void setAnimate(boolean z) {
        this.nVm = z;
    }
}
