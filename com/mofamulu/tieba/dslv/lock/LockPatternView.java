package com.mofamulu.tieba.dslv.lock;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.Canvas;
import android.graphics.Matrix;
import android.graphics.Paint;
import android.graphics.Path;
import android.graphics.Rect;
import android.os.Parcel;
import android.os.Parcelable;
import android.os.SystemClock;
import android.util.AttributeSet;
import android.view.MotionEvent;
import android.view.View;
import com.baidu.cyberplayer.sdk.BVideoView;
import com.baidu.tieba.R;
import com.baidu.zeus.bouncycastle.DERTags;
import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
/* loaded from: classes.dex */
public class LockPatternView extends View {
    private final Path A;
    private final Rect B;
    private int C;
    private int D;
    private int E;
    private final Matrix F;
    private final Matrix G;
    private final int H;
    private final int I;
    private final int J;
    private final int K;
    private final int L;
    private final Context M;
    private boolean a;
    private Paint b;
    private Paint c;
    private j d;
    private ArrayList e;
    private boolean[][] f;
    private float g;
    private float h;
    private long i;
    private DisplayMode j;
    private boolean k;
    private boolean l;
    private boolean m;
    private boolean n;
    private float o;
    private final int p;
    private float q;
    private float r;
    private float s;
    private Bitmap t;
    private Bitmap u;
    private Bitmap v;
    private Bitmap w;
    private Bitmap x;
    private Bitmap y;
    private Bitmap z;

    /* loaded from: classes.dex */
    public enum DisplayMode {
        Correct,
        Animate,
        Wrong;

        /* JADX DEBUG: Replace access to removed values field (a) with 'values()' method */
        /* renamed from: values  reason: to resolve conflict with enum method */
        public static DisplayMode[] valuesCustom() {
            DisplayMode[] valuesCustom = values();
            int length = valuesCustom.length;
            DisplayMode[] displayModeArr = new DisplayMode[length];
            System.arraycopy(valuesCustom, 0, displayModeArr, 0, length);
            return displayModeArr;
        }
    }

    public LockPatternView(Context context) {
        this(context, null);
    }

    public LockPatternView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        Bitmap[] bitmapArr;
        this.a = false;
        this.b = new Paint();
        this.c = new Paint();
        this.e = new ArrayList(9);
        this.f = (boolean[][]) Array.newInstance(Boolean.TYPE, 3, 3);
        this.g = -1.0f;
        this.h = -1.0f;
        this.j = DisplayMode.Correct;
        this.k = true;
        this.l = false;
        this.m = true;
        this.n = false;
        this.o = 0.1f;
        this.p = DERTags.TAGGED;
        this.q = 0.6f;
        this.A = new Path();
        this.B = new Rect();
        this.F = new Matrix();
        this.G = new Matrix();
        this.H = 0;
        this.I = 0;
        this.J = 0;
        this.K = 0;
        this.L = 0;
        this.M = context;
        if ("square".equals("")) {
            this.E = 0;
        } else if ("lock_width".equals("")) {
            this.E = 1;
        } else if ("lock_height".equals("")) {
            this.E = 2;
        } else {
            this.E = 0;
        }
        setClickable(true);
        this.c.setAntiAlias(true);
        this.c.setDither(true);
        this.c.setColor(getContext().getResources().getColor(l.a(getContext(), R.attr.alp_color_pattern_path)));
        this.c.setAlpha(DERTags.TAGGED);
        this.c.setStyle(Paint.Style.STROKE);
        this.c.setStrokeJoin(Paint.Join.ROUND);
        this.c.setStrokeCap(Paint.Cap.ROUND);
        this.t = a(l.a(getContext(), R.attr.alp_drawable_btn_code_lock_default_holo));
        this.u = a(l.a(getContext(), R.attr.alp_drawable_btn_code_lock_touched_holo));
        this.v = a(l.a(getContext(), R.attr.alp_drawable_indicator_code_lock_point_area_default_holo));
        this.w = a(l.a(getContext(), R.attr.aosp_drawable_indicator_code_lock_point_area_normal));
        this.x = a(R.drawable.aosp_indicator_code_lock_point_area_red_holo);
        this.y = a(R.drawable.aosp_indicator_code_lock_drag_direction_green_up);
        this.z = a(R.drawable.aosp_indicator_code_lock_drag_direction_red_up);
        for (Bitmap bitmap : new Bitmap[]{this.t, this.u, this.v, this.w, this.x}) {
            this.C = Math.max(this.C, bitmap.getWidth());
            this.D = Math.max(this.D, bitmap.getHeight());
        }
    }

    private Bitmap a(int i) {
        return BitmapFactory.decodeResource(getContext().getResources(), i);
    }

    public void setInStealthMode(boolean z) {
        this.l = z;
    }

    public void setTactileFeedbackEnabled(boolean z) {
        this.m = z;
    }

    public void setOnPatternListener(j jVar) {
        this.d = jVar;
    }

    public void a(DisplayMode displayMode, List list) {
        this.e.clear();
        this.e.addAll(list);
        g();
        Iterator it = list.iterator();
        while (it.hasNext()) {
            i iVar = (i) it.next();
            this.f[iVar.a()][iVar.b()] = true;
        }
        setDisplayMode(displayMode);
    }

    public void setDisplayMode(DisplayMode displayMode) {
        this.j = displayMode;
        if (displayMode == DisplayMode.Animate) {
            if (this.e.size() == 0) {
                throw new IllegalStateException("you must have a pattern to animate if you want to set the display mode to animate");
            }
            this.i = SystemClock.elapsedRealtime();
            i iVar = (i) this.e.get(0);
            this.g = c(iVar.b());
            this.h = d(iVar.a());
            g();
        }
        invalidate();
    }

    public DisplayMode getDisplayMode() {
        return this.j;
    }

    public List getPattern() {
        return (List) this.e.clone();
    }

    private void b() {
        b(R.string.alp_lockscreen_access_pattern_cell_added);
        if (this.d != null) {
            this.d.b(this.e);
        }
    }

    private void c() {
        b(R.string.alp_lockscreen_access_pattern_start);
        if (this.d != null) {
            this.d.a();
        }
    }

    private void d() {
        b(R.string.alp_lockscreen_access_pattern_detected);
        if (this.d != null) {
            this.d.a(this.e);
        }
    }

    private void e() {
        b(R.string.alp_lockscreen_access_pattern_cleared);
        if (this.d != null) {
            this.d.b();
        }
    }

    public void a() {
        f();
    }

    private void f() {
        this.e.clear();
        g();
        this.j = DisplayMode.Correct;
        invalidate();
    }

    private void g() {
        for (int i = 0; i < 3; i++) {
            for (int i2 = 0; i2 < 3; i2++) {
                this.f[i][i2] = false;
            }
        }
    }

    @Override // android.view.View
    protected void onSizeChanged(int i, int i2, int i3, int i4) {
        this.r = ((i + 0) + 0) / 3.0f;
        this.s = ((i2 + 0) + 0) / 3.0f;
    }

    private int a(int i, int i2) {
        int size = View.MeasureSpec.getSize(i);
        switch (View.MeasureSpec.getMode(i)) {
            case Integer.MIN_VALUE:
                return Math.max(size, i2);
            case 0:
                return i2;
            default:
                return size;
        }
    }

    @Override // android.view.View
    protected int getSuggestedMinimumWidth() {
        return this.C * 3;
    }

    @Override // android.view.View
    protected int getSuggestedMinimumHeight() {
        return this.C * 3;
    }

    @Override // android.view.View
    protected void onMeasure(int i, int i2) {
        int suggestedMinimumWidth = getSuggestedMinimumWidth();
        int suggestedMinimumHeight = getSuggestedMinimumHeight();
        int a = a(i, suggestedMinimumWidth);
        int a2 = a(i2, suggestedMinimumHeight);
        switch (this.E) {
            case 0:
                a2 = Math.min(a, a2);
                a = a2;
                break;
            case 1:
                a2 = Math.min(a, a2);
                break;
            case 2:
                a = Math.min(a, a2);
                break;
        }
        setMeasuredDimension(a, a2);
    }

    private i a(float f, float f2) {
        int i;
        i iVar = null;
        i b = b(f, f2);
        if (b != null) {
            ArrayList arrayList = this.e;
            if (!arrayList.isEmpty()) {
                i iVar2 = (i) arrayList.get(arrayList.size() - 1);
                int i2 = b.a - iVar2.a;
                int i3 = b.b - iVar2.b;
                int i4 = iVar2.a;
                int i5 = iVar2.b;
                if (Math.abs(i2) == 2 && Math.abs(i3) != 1) {
                    i4 = (i2 > 0 ? 1 : -1) + iVar2.a;
                }
                if (Math.abs(i3) != 2 || Math.abs(i2) == 1) {
                    i = i5;
                } else {
                    i = iVar2.b + (i3 > 0 ? 1 : -1);
                }
                iVar = i.a(i4, i);
            }
            if (iVar != null && !this.f[iVar.a][iVar.b]) {
                a(iVar);
            }
            a(b);
            if (this.m) {
                performHapticFeedback(1, 3);
            }
            return b;
        }
        return null;
    }

    private void a(i iVar) {
        this.f[iVar.a()][iVar.b()] = true;
        this.e.add(iVar);
        b();
    }

    private i b(float f, float f2) {
        int b;
        int a = a(f2);
        if (a >= 0 && (b = b(f)) >= 0 && !this.f[a][b]) {
            return i.a(a, b);
        }
        return null;
    }

    private int a(float f) {
        float f2 = this.s;
        float f3 = f2 * this.q;
        float f4 = ((f2 - f3) / 2.0f) + 0.0f;
        for (int i = 0; i < 3; i++) {
            float f5 = (i * f2) + f4;
            if (f >= f5 && f <= f5 + f3) {
                return i;
            }
        }
        return -1;
    }

    private int b(float f) {
        float f2 = this.r;
        float f3 = f2 * this.q;
        float f4 = ((f2 - f3) / 2.0f) + 0.0f;
        for (int i = 0; i < 3; i++) {
            float f5 = (i * f2) + f4;
            if (f >= f5 && f <= f5 + f3) {
                return i;
            }
        }
        return -1;
    }

    @Override // android.view.View
    public boolean onTouchEvent(MotionEvent motionEvent) {
        if (this.k && isEnabled()) {
            switch (motionEvent.getAction()) {
                case 0:
                    c(motionEvent);
                    return true;
                case 1:
                    b(motionEvent);
                    return true;
                case 2:
                    a(motionEvent);
                    return true;
                case 3:
                    this.n = false;
                    f();
                    e();
                    return true;
                default:
                    return false;
            }
        }
        return false;
    }

    private void a(MotionEvent motionEvent) {
        float f;
        float f2;
        float f3;
        float f4;
        float f5;
        float f6;
        float f7;
        float f8;
        int historySize = motionEvent.getHistorySize();
        int i = 0;
        while (true) {
            int i2 = i;
            if (i2 < historySize + 1) {
                float historicalX = i2 < historySize ? motionEvent.getHistoricalX(i2) : motionEvent.getX();
                float historicalY = i2 < historySize ? motionEvent.getHistoricalY(i2) : motionEvent.getY();
                int size = this.e.size();
                i a = a(historicalX, historicalY);
                int size2 = this.e.size();
                if (a != null && size2 == 1) {
                    this.n = true;
                    c();
                }
                if (Math.abs(historicalX - this.g) + Math.abs(historicalY - this.h) > this.r * 0.01f) {
                    float f9 = this.g;
                    float f10 = this.h;
                    this.g = historicalX;
                    this.h = historicalY;
                    if (this.n && size2 > 0) {
                        ArrayList arrayList = this.e;
                        float f11 = this.r * this.o * 0.5f;
                        i iVar = (i) arrayList.get(size2 - 1);
                        float c = c(iVar.b);
                        float d = d(iVar.a);
                        Rect rect = this.B;
                        if (c < historicalX) {
                            f = historicalX;
                            f2 = c;
                        } else {
                            f = c;
                            f2 = historicalX;
                        }
                        if (d < historicalY) {
                            f3 = d;
                        } else {
                            f3 = historicalY;
                            historicalY = d;
                        }
                        rect.set((int) (f2 - f11), (int) (f3 - f11), (int) (f + f11), (int) (historicalY + f11));
                        if (c < f9) {
                            f4 = f9;
                        } else {
                            f4 = c;
                            c = f9;
                        }
                        if (d < f10) {
                            f10 = d;
                            d = f10;
                        }
                        rect.union((int) (c - f11), (int) (f10 - f11), (int) (f4 + f11), (int) (d + f11));
                        if (a != null) {
                            float c2 = c(a.b);
                            float d2 = d(a.a);
                            if (size2 >= 2) {
                                i iVar2 = (i) arrayList.get((size2 - 1) - (size2 - size));
                                f6 = c(iVar2.b);
                                f5 = d(iVar2.a);
                                if (c2 < f6) {
                                    f6 = c2;
                                    c2 = f6;
                                }
                                if (d2 < f5) {
                                    float f12 = c2;
                                    f8 = d2;
                                    f7 = f12;
                                } else {
                                    f7 = c2;
                                    f8 = f5;
                                    f5 = d2;
                                }
                            } else {
                                f5 = d2;
                                f6 = c2;
                                f7 = c2;
                                f8 = d2;
                            }
                            float f13 = this.r / 2.0f;
                            float f14 = this.s / 2.0f;
                            rect.set((int) (f6 - f13), (int) (f8 - f14), (int) (f7 + f13), (int) (f5 + f14));
                        }
                        invalidate(rect);
                    } else {
                        invalidate();
                    }
                }
                i = i2 + 1;
            } else {
                return;
            }
        }
    }

    private void b(int i) {
        setContentDescription(this.M.getString(i));
        sendAccessibilityEvent(4);
        setContentDescription(null);
    }

    private void b(MotionEvent motionEvent) {
        if (!this.e.isEmpty()) {
            this.n = false;
            d();
            invalidate();
        }
    }

    private void c(MotionEvent motionEvent) {
        f();
        float x = motionEvent.getX();
        float y = motionEvent.getY();
        i a = a(x, y);
        if (a != null) {
            this.n = true;
            this.j = DisplayMode.Correct;
            c();
        } else {
            this.n = false;
            e();
        }
        if (a != null) {
            float c = c(a.b);
            float d = d(a.a);
            float f = this.r / 2.0f;
            float f2 = this.s / 2.0f;
            invalidate((int) (c - f), (int) (d - f2), (int) (c + f), (int) (d + f2));
        }
        this.g = x;
        this.h = y;
    }

    private float c(int i) {
        return 0.0f + (i * this.r) + (this.r / 2.0f);
    }

    private float d(int i) {
        return 0.0f + (i * this.s) + (this.s / 2.0f);
    }

    @Override // android.view.View
    protected void onDraw(Canvas canvas) {
        int elapsedRealtime;
        ArrayList arrayList = this.e;
        int size = arrayList.size();
        boolean[][] zArr = this.f;
        if (this.j == DisplayMode.Animate) {
            int elapsedRealtime2 = (((int) (SystemClock.elapsedRealtime() - this.i)) % ((size + 1) * BVideoView.MEDIA_INFO_VIDEO_TRACK_LAGGING)) / BVideoView.MEDIA_INFO_VIDEO_TRACK_LAGGING;
            g();
            for (int i = 0; i < elapsedRealtime2; i++) {
                i iVar = (i) arrayList.get(i);
                zArr[iVar.a()][iVar.b()] = true;
            }
            if (elapsedRealtime2 > 0 && elapsedRealtime2 < size) {
                float f = (elapsedRealtime % BVideoView.MEDIA_INFO_VIDEO_TRACK_LAGGING) / 700.0f;
                i iVar2 = (i) arrayList.get(elapsedRealtime2 - 1);
                float c = c(iVar2.b);
                float d = d(iVar2.a);
                i iVar3 = (i) arrayList.get(elapsedRealtime2);
                float d2 = (d(iVar3.a) - d) * f;
                this.g = c + ((c(iVar3.b) - c) * f);
                this.h = d2 + d;
            }
            invalidate();
        }
        float f2 = this.r;
        float f3 = this.s;
        this.c.setStrokeWidth(this.o * f2 * 0.5f);
        Path path = this.A;
        path.rewind();
        int i2 = 0;
        while (true) {
            int i3 = i2;
            if (i3 >= 3) {
                break;
            }
            float f4 = (i3 * f3) + 0.0f;
            for (int i4 = 0; i4 < 3; i4++) {
                a(canvas, (int) (0.0f + (i4 * f2)), (int) f4, zArr[i3][i4]);
            }
            i2 = i3 + 1;
        }
        boolean z = !this.l || this.j == DisplayMode.Wrong;
        boolean z2 = (this.b.getFlags() & 2) != 0;
        this.b.setFilterBitmap(true);
        if (z) {
            int i5 = 0;
            while (true) {
                int i6 = i5;
                if (i6 >= size - 1) {
                    break;
                }
                i iVar4 = (i) arrayList.get(i6);
                i iVar5 = (i) arrayList.get(i6 + 1);
                if (!zArr[iVar5.a][iVar5.b]) {
                    break;
                }
                a(canvas, 0.0f + (iVar4.b * f2), 0.0f + (iVar4.a * f3), iVar4, iVar5);
                i5 = i6 + 1;
            }
        }
        if (z) {
            boolean z3 = false;
            for (int i7 = 0; i7 < size; i7++) {
                i iVar6 = (i) arrayList.get(i7);
                if (!zArr[iVar6.a][iVar6.b]) {
                    break;
                }
                z3 = true;
                float c2 = c(iVar6.b);
                float d3 = d(iVar6.a);
                if (i7 == 0) {
                    path.moveTo(c2, d3);
                } else {
                    path.lineTo(c2, d3);
                }
            }
            if ((this.n || this.j == DisplayMode.Animate) && z3) {
                path.lineTo(this.g, this.h);
            }
            canvas.drawPath(path, this.c);
        }
        this.b.setFilterBitmap(z2);
    }

    private void a(Canvas canvas, float f, float f2, i iVar, i iVar2) {
        boolean z = this.j != DisplayMode.Wrong;
        int i = iVar2.a;
        int i2 = iVar.a;
        int i3 = iVar2.b;
        int i4 = iVar.b;
        int i5 = (((int) this.r) - this.C) / 2;
        int i6 = (((int) this.s) - this.D) / 2;
        Bitmap bitmap = z ? this.y : this.z;
        int i7 = this.C;
        int i8 = this.D;
        float min = Math.min(this.r / this.C, 1.0f);
        float min2 = Math.min(this.s / this.D, 1.0f);
        this.F.setTranslate(i5 + f, i6 + f2);
        this.F.preTranslate(this.C / 2, this.D / 2);
        this.F.preScale(min, min2);
        this.F.preTranslate((-this.C) / 2, (-this.D) / 2);
        this.F.preRotate(((float) Math.toDegrees((float) Math.atan2(i - i2, i3 - i4))) + 90.0f, i7 / 2.0f, i8 / 2.0f);
        this.F.preTranslate((i7 - bitmap.getWidth()) / 2.0f, 0.0f);
        canvas.drawBitmap(bitmap, this.F, this.b);
    }

    private void a(Canvas canvas, int i, int i2, boolean z) {
        Bitmap bitmap;
        Bitmap bitmap2;
        if (!z || (this.l && this.j != DisplayMode.Wrong)) {
            bitmap = this.v;
            bitmap2 = this.t;
        } else if (this.n) {
            bitmap = this.w;
            bitmap2 = this.u;
        } else if (this.j == DisplayMode.Wrong) {
            bitmap = this.x;
            bitmap2 = this.t;
        } else if (this.j == DisplayMode.Correct || this.j == DisplayMode.Animate) {
            bitmap = this.w;
            bitmap2 = this.t;
        } else {
            throw new IllegalStateException("unknown display mode " + this.j);
        }
        int i3 = this.C;
        int i4 = this.D;
        float f = this.r;
        float min = Math.min(this.r / this.C, 1.0f);
        float min2 = Math.min(this.s / this.D, 1.0f);
        this.G.setTranslate(((int) ((f - i3) / 2.0f)) + i, ((int) ((this.s - i4) / 2.0f)) + i2);
        this.G.preTranslate(this.C / 2, this.D / 2);
        this.G.preScale(min, min2);
        this.G.preTranslate((-this.C) / 2, (-this.D) / 2);
        canvas.drawBitmap(bitmap, this.G, this.b);
        canvas.drawBitmap(bitmap2, this.G, this.b);
    }

    @Override // android.view.View
    protected Parcelable onSaveInstanceState() {
        return new SavedState(super.onSaveInstanceState(), h.a(this.e), this.j.ordinal(), this.k, this.l, this.m, null);
    }

    @Override // android.view.View
    protected void onRestoreInstanceState(Parcelable parcelable) {
        SavedState savedState = (SavedState) parcelable;
        super.onRestoreInstanceState(savedState.getSuperState());
        a(DisplayMode.Correct, h.a(savedState.a()));
        this.j = DisplayMode.valuesCustom()[savedState.b()];
        this.k = savedState.c();
        this.l = savedState.d();
        this.m = savedState.e();
    }

    /* loaded from: classes.dex */
    class SavedState extends View.BaseSavedState {
        public static final Parcelable.Creator CREATOR = new k();
        private final String a;
        private final int b;
        private final boolean c;
        private final boolean d;
        private final boolean e;

        /* synthetic */ SavedState(Parcelable parcelable, String str, int i, boolean z, boolean z2, boolean z3, SavedState savedState) {
            this(parcelable, str, i, z, z2, z3);
        }

        private SavedState(Parcelable parcelable, String str, int i, boolean z, boolean z2, boolean z3) {
            super(parcelable);
            this.a = str;
            this.b = i;
            this.c = z;
            this.d = z2;
            this.e = z3;
        }

        /* JADX INFO: Access modifiers changed from: package-private */
        public /* synthetic */ SavedState(Parcel parcel, SavedState savedState) {
            this(parcel);
        }

        private SavedState(Parcel parcel) {
            super(parcel);
            this.a = parcel.readString();
            this.b = parcel.readInt();
            this.c = ((Boolean) parcel.readValue(null)).booleanValue();
            this.d = ((Boolean) parcel.readValue(null)).booleanValue();
            this.e = ((Boolean) parcel.readValue(null)).booleanValue();
        }

        public String a() {
            return this.a;
        }

        public int b() {
            return this.b;
        }

        public boolean c() {
            return this.c;
        }

        public boolean d() {
            return this.d;
        }

        public boolean e() {
            return this.e;
        }

        @Override // android.view.View.BaseSavedState, android.view.AbsSavedState, android.os.Parcelable
        public void writeToParcel(Parcel parcel, int i) {
            super.writeToParcel(parcel, i);
            parcel.writeString(this.a);
            parcel.writeInt(this.b);
            parcel.writeValue(Boolean.valueOf(this.c));
            parcel.writeValue(Boolean.valueOf(this.d));
            parcel.writeValue(Boolean.valueOf(this.e));
        }
    }
}
