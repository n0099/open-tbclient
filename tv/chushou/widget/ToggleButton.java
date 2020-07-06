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
    private SpringSystem ojE;
    private Spring ojF;
    private int ojG;
    private int ojH;
    private int ojI;
    private int ojJ;
    private boolean ojK;
    private float ojL;
    private float ojM;
    private int ojN;
    private float ojO;
    private float ojP;
    private boolean ojQ;
    private a ojR;
    SimpleSpringListener ojS;
    private Paint paint;
    private RectF rect;
    private float startX;

    /* loaded from: classes5.dex */
    public interface a {
        void a(boolean z, ToggleButton toggleButton);
    }

    public ToggleButton(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.ojG = Color.parseColor("#4ebb7f");
        this.ojH = Color.parseColor("#dadbda");
        this.ojI = Color.parseColor("#ffffff");
        this.ojJ = Color.parseColor("#ffffff");
        this.borderColor = this.ojH;
        this.ojK = false;
        this.borderWidth = 2;
        this.rect = new RectF();
        this.ojQ = true;
        this.ojS = new SimpleSpringListener() { // from class: tv.chushou.widget.ToggleButton.2
            @Override // com.facebook.rebound.SimpleSpringListener, com.facebook.rebound.SpringListener
            public void onSpringUpdate(Spring spring) {
                ToggleButton.this.G(spring.getCurrentValue());
            }
        };
        setup(attributeSet);
    }

    public ToggleButton(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.ojG = Color.parseColor("#4ebb7f");
        this.ojH = Color.parseColor("#dadbda");
        this.ojI = Color.parseColor("#ffffff");
        this.ojJ = Color.parseColor("#ffffff");
        this.borderColor = this.ojH;
        this.ojK = false;
        this.borderWidth = 2;
        this.rect = new RectF();
        this.ojQ = true;
        this.ojS = new SimpleSpringListener() { // from class: tv.chushou.widget.ToggleButton.2
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
        this.ojF.removeListener(this.ojS);
    }

    @Override // android.view.View
    public void onAttachedToWindow() {
        super.onAttachedToWindow();
        this.ojF.addListener(this.ojS);
    }

    public void setOnColor(int i) {
        this.ojG = i;
        G(this.ojK ? 1.0d : 0.0d);
    }

    public void setup(AttributeSet attributeSet) {
        this.paint = new Paint(1);
        this.paint.setStyle(Paint.Style.FILL);
        this.paint.setStrokeCap(Paint.Cap.ROUND);
        this.ojE = SpringSystem.create();
        this.ojF = this.ojE.createSpring();
        this.ojF.setSpringConfig(SpringConfig.fromOrigamiTensionAndFriction(50.0d, 7.0d));
        setOnClickListener(new View.OnClickListener() { // from class: tv.chushou.widget.ToggleButton.1
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                ToggleButton.this.xL(ToggleButton.this.ojQ);
            }
        });
        TypedArray obtainStyledAttributes = getContext().obtainStyledAttributes(attributeSet, a.C0934a.ToggleButton);
        this.ojH = obtainStyledAttributes.getColor(a.C0934a.ToggleButton_offBorderColor, this.ojH);
        this.ojG = obtainStyledAttributes.getColor(a.C0934a.ToggleButton_onColor, this.ojG);
        this.ojJ = obtainStyledAttributes.getColor(a.C0934a.ToggleButton_spotColor, this.ojJ);
        this.ojI = obtainStyledAttributes.getColor(a.C0934a.ToggleButton_offColor, this.ojI);
        this.borderWidth = obtainStyledAttributes.getDimensionPixelSize(a.C0934a.ToggleButton_toggleBorderWidth, this.borderWidth);
        this.ojQ = obtainStyledAttributes.getBoolean(a.C0934a.ToggleButton_animate, this.ojQ);
        obtainStyledAttributes.recycle();
        this.borderColor = this.ojH;
    }

    public void toggle() {
        xL(true);
    }

    public void xL(boolean z) {
        this.ojK = !this.ojK;
        xM(z);
        if (this.ojR != null) {
            this.ojR.a(this.ojK, this);
        }
    }

    public void dWx() {
        setToggleOn();
        if (this.ojR != null) {
            this.ojR.a(this.ojK, this);
        }
    }

    public void dWy() {
        setToggleOff();
        if (this.ojR != null) {
            this.ojR.a(this.ojK, this);
        }
    }

    public void setToggleOn() {
        setToggleOn(true);
    }

    public void setToggleOn(boolean z) {
        this.ojK = true;
        xM(z);
    }

    public void setToggleOff() {
        setToggleOff(true);
    }

    public void setToggleOff(boolean z) {
        this.ojK = false;
        xM(z);
    }

    private void xM(boolean z) {
        if (z) {
            this.ojF.setEndValue(this.ojK ? 1.0d : 0.0d);
            return;
        }
        this.ojF.setCurrentValue(this.ojK ? 1.0d : 0.0d);
        G(this.ojK ? 1.0d : 0.0d);
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
        this.ojL = this.startX + this.borderWidth;
        this.ojM = this.khX - this.borderWidth;
        this.ojN = height - (this.borderWidth * 4);
        this.ojO = this.ojK ? this.ojM : this.ojL;
        this.ojP = this.ojN;
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
        if (this.ojP > 0.0f) {
            float f = this.ojP * 0.5f;
            this.rect.set(this.ojO - f, this.centerY - f, this.khX + f, this.centerY + f);
            this.paint.setColor(this.ojI);
            canvas.drawRoundRect(this.rect, f, f, this.paint);
        }
        this.rect.set((this.ojO - 1.0f) - this.bnJ, this.centerY - this.bnJ, this.ojO + 1.1f + this.bnJ, this.centerY + this.bnJ);
        this.paint.setColor(this.borderColor);
        canvas.drawRoundRect(this.rect, this.bnJ, this.bnJ, this.paint);
        float f2 = this.ojN * 0.5f;
        this.rect.set(this.ojO - f2, this.centerY - f2, this.ojO + f2, this.centerY + f2);
        this.paint.setColor(this.ojJ);
        canvas.drawRoundRect(this.rect, f2, f2, this.paint);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void G(double d) {
        this.ojO = (float) SpringUtil.mapValueFromRangeToRange(d, 0.0d, 1.0d, this.ojL, this.ojM);
        this.ojP = (float) SpringUtil.mapValueFromRangeToRange(1.0d - d, 0.0d, 1.0d, 10.0d, this.ojN);
        int blue = Color.blue(this.ojG);
        int red = Color.red(this.ojG);
        int green = Color.green(this.ojG);
        int blue2 = Color.blue(this.ojH);
        int red2 = Color.red(this.ojH);
        int green2 = Color.green(this.ojH);
        int mapValueFromRangeToRange = (int) SpringUtil.mapValueFromRangeToRange(1.0d - d, 0.0d, 1.0d, blue, blue2);
        int mapValueFromRangeToRange2 = (int) SpringUtil.mapValueFromRangeToRange(1.0d - d, 0.0d, 1.0d, red, red2);
        this.borderColor = Color.rgb(clamp(mapValueFromRangeToRange2, 0, 255), clamp((int) SpringUtil.mapValueFromRangeToRange(1.0d - d, 0.0d, 1.0d, green, green2), 0, 255), clamp(mapValueFromRangeToRange, 0, 255));
        postInvalidate();
    }

    public void setOnToggleChanged(a aVar) {
        this.ojR = aVar;
    }

    public void setAnimate(boolean z) {
        this.ojQ = z;
    }
}
