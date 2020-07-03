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
    private float bnJ;
    private int borderColor;
    private int borderWidth;
    private float centerY;
    private float khX;
    private SpringSystem ojB;
    private Spring ojC;
    private int ojD;
    private int ojE;
    private int ojF;
    private int ojG;
    private boolean ojH;
    private float ojI;
    private float ojJ;
    private int ojK;
    private float ojL;
    private float ojM;
    private boolean ojN;
    private a ojO;
    SimpleSpringListener ojP;
    private Paint paint;
    private RectF rect;
    private float startX;

    /* loaded from: classes5.dex */
    public interface a {
        void a(boolean z, ToggleButton toggleButton);
    }

    public ToggleButton(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.ojD = Color.parseColor("#4ebb7f");
        this.ojE = Color.parseColor("#dadbda");
        this.ojF = Color.parseColor("#ffffff");
        this.ojG = Color.parseColor("#ffffff");
        this.borderColor = this.ojE;
        this.ojH = false;
        this.borderWidth = 2;
        this.rect = new RectF();
        this.ojN = true;
        this.ojP = new SimpleSpringListener() { // from class: tv.chushou.widget.ToggleButton.2
            @Override // com.facebook.rebound.SimpleSpringListener, com.facebook.rebound.SpringListener
            public void onSpringUpdate(Spring spring) {
                ToggleButton.this.G(spring.getCurrentValue());
            }
        };
        setup(attributeSet);
    }

    public ToggleButton(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.ojD = Color.parseColor("#4ebb7f");
        this.ojE = Color.parseColor("#dadbda");
        this.ojF = Color.parseColor("#ffffff");
        this.ojG = Color.parseColor("#ffffff");
        this.borderColor = this.ojE;
        this.ojH = false;
        this.borderWidth = 2;
        this.rect = new RectF();
        this.ojN = true;
        this.ojP = new SimpleSpringListener() { // from class: tv.chushou.widget.ToggleButton.2
            @Override // com.facebook.rebound.SimpleSpringListener, com.facebook.rebound.SpringListener
            public void onSpringUpdate(Spring spring) {
                ToggleButton.this.G(spring.getCurrentValue());
            }
        };
        setup(attributeSet);
    }

    @Override // android.view.View
    protected void onDetachedFromWindow() {
        super.onDetachedFromWindow();
        this.ojC.removeListener(this.ojP);
    }

    @Override // android.view.View
    public void onAttachedToWindow() {
        super.onAttachedToWindow();
        this.ojC.addListener(this.ojP);
    }

    public void setOnColor(int i) {
        this.ojD = i;
        G(this.ojH ? 1.0d : 0.0d);
    }

    public void setup(AttributeSet attributeSet) {
        this.paint = new Paint(1);
        this.paint.setStyle(Paint.Style.FILL);
        this.paint.setStrokeCap(Paint.Cap.ROUND);
        this.ojB = SpringSystem.create();
        this.ojC = this.ojB.createSpring();
        this.ojC.setSpringConfig(SpringConfig.fromOrigamiTensionAndFriction(50.0d, 7.0d));
        setOnClickListener(new View.OnClickListener() { // from class: tv.chushou.widget.ToggleButton.1
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                ToggleButton.this.xL(ToggleButton.this.ojN);
            }
        });
        TypedArray obtainStyledAttributes = getContext().obtainStyledAttributes(attributeSet, a.C0933a.ToggleButton);
        this.ojE = obtainStyledAttributes.getColor(a.C0933a.ToggleButton_offBorderColor, this.ojE);
        this.ojD = obtainStyledAttributes.getColor(a.C0933a.ToggleButton_onColor, this.ojD);
        this.ojG = obtainStyledAttributes.getColor(a.C0933a.ToggleButton_spotColor, this.ojG);
        this.ojF = obtainStyledAttributes.getColor(a.C0933a.ToggleButton_offColor, this.ojF);
        this.borderWidth = obtainStyledAttributes.getDimensionPixelSize(a.C0933a.ToggleButton_toggleBorderWidth, this.borderWidth);
        this.ojN = obtainStyledAttributes.getBoolean(a.C0933a.ToggleButton_animate, this.ojN);
        obtainStyledAttributes.recycle();
        this.borderColor = this.ojE;
    }

    public void toggle() {
        xL(true);
    }

    public void xL(boolean z) {
        this.ojH = !this.ojH;
        xM(z);
        if (this.ojO != null) {
            this.ojO.a(this.ojH, this);
        }
    }

    public void dWt() {
        setToggleOn();
        if (this.ojO != null) {
            this.ojO.a(this.ojH, this);
        }
    }

    public void dWu() {
        setToggleOff();
        if (this.ojO != null) {
            this.ojO.a(this.ojH, this);
        }
    }

    public void setToggleOn() {
        setToggleOn(true);
    }

    public void setToggleOn(boolean z) {
        this.ojH = true;
        xM(z);
    }

    public void setToggleOff() {
        setToggleOff(true);
    }

    public void setToggleOff(boolean z) {
        this.ojH = false;
        xM(z);
    }

    private void xM(boolean z) {
        if (z) {
            this.ojC.setEndValue(this.ojH ? 1.0d : 0.0d);
            return;
        }
        this.ojC.setCurrentValue(this.ojH ? 1.0d : 0.0d);
        G(this.ojH ? 1.0d : 0.0d);
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
        this.bnJ = Math.min(width, height) * 0.5f;
        this.centerY = this.bnJ;
        this.startX = this.bnJ;
        this.khX = width - this.bnJ;
        this.ojI = this.startX + this.borderWidth;
        this.ojJ = this.khX - this.borderWidth;
        this.ojK = height - (this.borderWidth * 4);
        this.ojL = this.ojH ? this.ojJ : this.ojI;
        this.ojM = this.ojK;
    }

    private int clamp(int i, int i2, int i3) {
        return Math.min(Math.max(i, i2), i3);
    }

    @Override // android.view.View
    public void draw(Canvas canvas) {
        super.draw(canvas);
        this.rect.set(0.0f, 0.0f, getWidth(), getHeight());
        this.paint.setColor(this.borderColor);
        canvas.drawRoundRect(this.rect, this.bnJ, this.bnJ, this.paint);
        if (this.ojM > 0.0f) {
            float f = this.ojM * 0.5f;
            this.rect.set(this.ojL - f, this.centerY - f, this.khX + f, this.centerY + f);
            this.paint.setColor(this.ojF);
            canvas.drawRoundRect(this.rect, f, f, this.paint);
        }
        this.rect.set((this.ojL - 1.0f) - this.bnJ, this.centerY - this.bnJ, this.ojL + 1.1f + this.bnJ, this.centerY + this.bnJ);
        this.paint.setColor(this.borderColor);
        canvas.drawRoundRect(this.rect, this.bnJ, this.bnJ, this.paint);
        float f2 = this.ojK * 0.5f;
        this.rect.set(this.ojL - f2, this.centerY - f2, this.ojL + f2, this.centerY + f2);
        this.paint.setColor(this.ojG);
        canvas.drawRoundRect(this.rect, f2, f2, this.paint);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void G(double d) {
        this.ojL = (float) SpringUtil.mapValueFromRangeToRange(d, 0.0d, 1.0d, this.ojI, this.ojJ);
        this.ojM = (float) SpringUtil.mapValueFromRangeToRange(1.0d - d, 0.0d, 1.0d, 10.0d, this.ojK);
        int blue = Color.blue(this.ojD);
        int red = Color.red(this.ojD);
        int green = Color.green(this.ojD);
        int blue2 = Color.blue(this.ojE);
        int red2 = Color.red(this.ojE);
        int green2 = Color.green(this.ojE);
        int mapValueFromRangeToRange = (int) SpringUtil.mapValueFromRangeToRange(1.0d - d, 0.0d, 1.0d, blue, blue2);
        int mapValueFromRangeToRange2 = (int) SpringUtil.mapValueFromRangeToRange(1.0d - d, 0.0d, 1.0d, red, red2);
        this.borderColor = Color.rgb(clamp(mapValueFromRangeToRange2, 0, 255), clamp((int) SpringUtil.mapValueFromRangeToRange(1.0d - d, 0.0d, 1.0d, green, green2), 0, 255), clamp(mapValueFromRangeToRange, 0, 255));
        postInvalidate();
    }

    public void setOnToggleChanged(a aVar) {
        this.ojO = aVar;
    }

    public void setAnimate(boolean z) {
        this.ojN = z;
    }
}
