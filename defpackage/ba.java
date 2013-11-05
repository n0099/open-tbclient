package defpackage;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.PorterDuff;
import android.graphics.PorterDuffXfermode;
import android.graphics.RectF;
import android.graphics.drawable.BitmapDrawable;
import android.util.AttributeSet;
import android.util.Log;
import android.view.MotionEvent;
import android.view.ViewConfiguration;
import android.view.ViewParent;
import android.widget.CheckBox;
import android.widget.CompoundButton;
import com.baidu.cloudsdk.assets.DrawableUtils;
import com.baidu.cloudsdk.social.share.SocialShareConfig;
import com.tencent.mm.sdk.contact.RContact;
import com.tencent.mm.sdk.platformtools.Util;
/* JADX INFO: Access modifiers changed from: package-private */
/* renamed from: ba  reason: default package */
/* loaded from: classes.dex */
public class ba extends CheckBox {
    private be A;
    private CompoundButton.OnCheckedChangeListener B;
    private CompoundButton.OnCheckedChangeListener C;
    private boolean D;
    private final float E;
    private float F;
    private float G;
    private float H;
    private SocialShareConfig I;

    /* renamed from: a  reason: collision with root package name */
    private Paint f371a;
    private ViewParent b;
    private Bitmap c;
    private Bitmap d;
    private Bitmap e;
    private Bitmap f;
    private Bitmap g;
    private Bitmap h;
    private RectF i;
    private PorterDuffXfermode j;
    private float k;
    private float l;
    private float m;
    private float n;
    private float o;
    private float p;
    private float q;
    private float r;
    private float s;
    private int t;
    private int u;
    private final int v;
    private int w;
    private boolean x;
    private boolean y;
    private boolean z;

    public ba(Context context) {
        this(context, null);
    }

    public ba(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, 16842860);
    }

    public ba(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.v = Util.MASK_8BIT;
        this.w = Util.MASK_8BIT;
        this.x = false;
        this.E = 350.0f;
        a(context);
    }

    private float a(float f) {
        return f - this.o;
    }

    private void a() {
        this.b = getParent();
        if (this.b != null) {
            this.b.requestDisallowInterceptTouchEvent(true);
        }
    }

    private void a(Context context) {
        this.f371a = new Paint();
        this.f371a.setColor(-1);
        this.I = SocialShareConfig.getInstance(context);
        this.t = ViewConfiguration.getPressedStateDuration() + ViewConfiguration.getTapTimeout();
        this.u = ViewConfiguration.get(context).getScaledTouchSlop();
        this.q = DrawableUtils.fix720px(context, 126);
        this.r = DrawableUtils.fix720px(context, 62);
        int fix720px = DrawableUtils.fix720px(context, 204);
        this.g = Bitmap.createScaledBitmap(((BitmapDrawable) DrawableUtils.getDrawable(context, this.I.getAssetFileName("switch_mask"))).getBitmap(), (int) this.q, (int) this.r, true);
        this.c = Bitmap.createScaledBitmap(((BitmapDrawable) DrawableUtils.getDrawable(context, this.I.getAssetFileName("switch_button_bottom"))).getBitmap(), fix720px, (int) this.r, true);
        this.e = Bitmap.createScaledBitmap(((BitmapDrawable) DrawableUtils.getDrawable(context, this.I.getAssetFileName("switch_btn_pressed"))).getBitmap(), fix720px, (int) this.r, true);
        this.f = Bitmap.createScaledBitmap(((BitmapDrawable) DrawableUtils.getDrawable(context, this.I.getAssetFileName("switch_btn_unpressed"))).getBitmap(), fix720px, (int) this.r, true);
        this.h = Bitmap.createScaledBitmap(((BitmapDrawable) DrawableUtils.getDrawable(context, this.I.getAssetFileName("switch_frame"))).getBitmap(), (int) this.q, (int) this.r, true);
        this.d = this.f;
        this.o = DrawableUtils.fix720px(context, 102);
        this.p = DrawableUtils.fix720px(context, 24);
        this.n = this.x ? this.o : this.p;
        this.m = a(this.n);
        this.F = (int) ((getResources().getDisplayMetrics().density * 350.0f) + 0.5f);
        this.i = new RectF(0.0f, 0.0f, this.q, this.r);
        this.j = new PorterDuffXfermode(PorterDuff.Mode.SRC_IN);
    }

    private void a(boolean z) {
        postDelayed(new bg(this, z), 10L);
    }

    private void b() {
        this.D = false;
    }

    private void b(float f) {
        this.n = f;
        this.m = a(this.n);
        invalidate();
    }

    private void b(boolean z) {
        this.D = true;
        this.H = z ? this.F : -this.F;
        this.G = this.n;
        new bf(this, null).run();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void c() {
        Log.d("SwitchButton", String.valueOf(this.H));
        this.G += (this.H * 16.0f) / 1000.0f;
        if (this.G <= this.p) {
            b();
            this.G = this.p;
            a(false);
        } else if (this.G >= this.o) {
            b();
            this.G = this.o;
            a(true);
        }
        b(this.G);
    }

    @Override // android.widget.CompoundButton, android.widget.Checkable
    public boolean isChecked() {
        return this.x;
    }

    @Override // android.widget.CompoundButton, android.widget.TextView, android.view.View
    protected void onDraw(Canvas canvas) {
        canvas.saveLayerAlpha(this.i, this.w, 31);
        canvas.drawBitmap(this.g, 0.0f, 0.0f, this.f371a);
        this.f371a.setXfermode(this.j);
        canvas.drawBitmap(this.c, this.m, 0.0f, this.f371a);
        this.f371a.setXfermode(null);
        canvas.drawBitmap(this.h, 0.0f, 0.0f, this.f371a);
        canvas.drawBitmap(this.d, this.m, 0.0f, this.f371a);
        canvas.restore();
    }

    @Override // android.widget.TextView, android.view.View
    protected void onMeasure(int i, int i2) {
        setMeasuredDimension((int) this.q, (int) this.r);
    }

    @Override // android.widget.TextView, android.view.View
    public boolean onTouchEvent(MotionEvent motionEvent) {
        int action = motionEvent.getAction();
        float x = motionEvent.getX();
        float y = motionEvent.getY();
        float abs = Math.abs(x - this.l);
        float abs2 = Math.abs(y - this.k);
        switch (action) {
            case 0:
                a();
                this.l = x;
                this.k = y;
                this.d = this.e;
                this.s = this.x ? this.o : this.p;
                break;
            case 1:
                this.d = this.f;
                float eventTime = (float) (motionEvent.getEventTime() - motionEvent.getDownTime());
                if (abs2 < this.u && abs < this.u && eventTime < this.t) {
                    if (this.A == null) {
                        this.A = new be(this, null);
                    }
                    if (!post(this.A)) {
                        performClick();
                        break;
                    }
                } else {
                    b(this.z);
                    break;
                }
                break;
            case 2:
                float eventTime2 = (float) (motionEvent.getEventTime() - motionEvent.getDownTime());
                this.n = (this.s + motionEvent.getX()) - this.l;
                if (this.n <= this.p) {
                    this.n = this.p;
                }
                if (this.n >= this.o) {
                    this.n = this.o;
                }
                this.z = this.n > ((this.o - this.p) / 2.0f) + this.p;
                this.m = a(this.n);
                break;
        }
        invalidate();
        return isEnabled();
    }

    @Override // android.widget.CompoundButton, android.view.View
    public boolean performClick() {
        b(!this.x);
        return true;
    }

    @Override // android.widget.CompoundButton, android.widget.Checkable
    public void setChecked(boolean z) {
        if (this.x != z) {
            this.x = z;
            this.n = z ? this.o : this.p;
            this.m = a(this.n);
            invalidate();
            if (this.y) {
                return;
            }
            this.y = true;
            if (this.B != null) {
                this.B.onCheckedChanged(this, this.x);
            }
            if (this.C != null) {
                this.C.onCheckedChanged(this, this.x);
            }
            this.y = false;
        }
    }

    @Override // android.widget.TextView, android.view.View
    public void setEnabled(boolean z) {
        this.w = z ? Util.MASK_8BIT : RContact.MM_CONTACTFLAG_ALL;
        super.setEnabled(z);
    }

    @Override // android.widget.CompoundButton
    public void setOnCheckedChangeListener(CompoundButton.OnCheckedChangeListener onCheckedChangeListener) {
        this.B = onCheckedChangeListener;
    }

    @Override // android.widget.CompoundButton, android.widget.Checkable
    public void toggle() {
        setChecked(!this.x);
    }
}
