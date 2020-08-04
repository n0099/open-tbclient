package com.facebook.fresco.animation.b;

import android.graphics.Bitmap;
import android.graphics.Canvas;
import android.graphics.ColorFilter;
import android.graphics.Paint;
import android.graphics.Rect;
import android.graphics.drawable.Drawable;
import android.support.annotation.IntRange;
import com.facebook.fresco.animation.a.c;
import com.facebook.fresco.animation.a.d;
import com.facebook.imagepipeline.b.f;
import javax.annotation.Nullable;
/* loaded from: classes18.dex */
public class a implements com.facebook.fresco.animation.a.a, c.a {
    private static final Class<?> mPz = a.class;
    private int mBitmapHeight;
    private int mBitmapWidth;
    @Nullable
    private Rect mBounds;
    private final f mXb;
    private final b mXc;
    private final d mXd;
    private final c mXe;
    @Nullable
    private final com.facebook.fresco.animation.b.b.a mXf;
    @Nullable
    private final com.facebook.fresco.animation.b.b.b mXg;
    @Nullable
    private InterfaceC0812a mXh;
    private Bitmap.Config mBitmapConfig = Bitmap.Config.ARGB_8888;
    private final Paint mPaint = new Paint(6);

    /* renamed from: com.facebook.fresco.animation.b.a$a  reason: collision with other inner class name */
    /* loaded from: classes18.dex */
    public interface InterfaceC0812a {
        void a(a aVar, int i);

        void a(a aVar, int i, int i2);

        void b(a aVar, int i);
    }

    public a(f fVar, b bVar, d dVar, c cVar, @Nullable com.facebook.fresco.animation.b.b.a aVar, @Nullable com.facebook.fresco.animation.b.b.b bVar2) {
        this.mXb = fVar;
        this.mXc = bVar;
        this.mXd = dVar;
        this.mXe = cVar;
        this.mXf = aVar;
        this.mXg = bVar2;
        dFj();
    }

    @Override // com.facebook.fresco.animation.a.d
    public int getFrameCount() {
        return this.mXd.getFrameCount();
    }

    @Override // com.facebook.fresco.animation.a.d
    public int IQ(int i) {
        return this.mXd.IQ(i);
    }

    @Override // com.facebook.fresco.animation.a.d
    public int getLoopCount() {
        return this.mXd.getLoopCount();
    }

    @Override // com.facebook.fresco.animation.a.a
    public boolean a(Drawable drawable, Canvas canvas, int i) {
        if (this.mXh != null) {
            this.mXh.a(this, i);
        }
        boolean a = a(canvas, i, 0);
        if (!a && this.mXh != null) {
            this.mXh.b(this, i);
        }
        if (this.mXf != null && this.mXg != null) {
            this.mXf.a(this.mXg, this.mXc, this, i);
        }
        return a;
    }

    /* JADX DEBUG: Don't trust debug lines info. Repeating lines: [231=4] */
    /* JADX DEBUG: Failed to insert an additional move for type inference into block B:38:0x0081 */
    /* JADX DEBUG: Multi-variable search result rejected for r2v2, resolved type: com.facebook.common.references.a */
    /* JADX WARN: Code restructure failed: missing block: B:17:0x0039, code lost:
        if (a(r11, r3, r10, 1) != false) goto L23;
     */
    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Removed duplicated region for block: B:11:0x001d A[ADDED_TO_REGION] */
    /* JADX WARN: Removed duplicated region for block: B:51:? A[ADDED_TO_REGION, RETURN, SYNTHETIC] */
    /* JADX WARN: Type inference failed for: r2v0 */
    /* JADX WARN: Type inference failed for: r2v1 */
    /* JADX WARN: Type inference failed for: r2v6 */
    /* JADX WARN: Type inference failed for: r2v8 */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    private boolean a(Canvas canvas, int i, int i2) {
        com.facebook.common.references.a<Bitmap> b;
        boolean z;
        com.facebook.common.references.a aVar = 2;
        int i3 = 1;
        try {
            try {
                switch (i2) {
                    case 0:
                        b = this.mXc.IR(i);
                        z = a(i, b, canvas, 0);
                        com.facebook.common.references.a.c(b);
                        return (z || i3 == -1) ? z : a(canvas, i, i3);
                    case 1:
                        com.facebook.common.references.a<Bitmap> ab = this.mXc.ab(i, this.mBitmapWidth, this.mBitmapHeight);
                        try {
                            if (a(i, ab)) {
                                break;
                            }
                            i3 = 0;
                            z = i3;
                            i3 = 2;
                            b = ab;
                            com.facebook.common.references.a.c(b);
                            if (z) {
                                return z;
                            }
                        } catch (Throwable th) {
                            th = th;
                            aVar = ab;
                            com.facebook.common.references.a.c(aVar);
                            throw th;
                        }
                    case 2:
                        try {
                            b = this.mXb.b(this.mBitmapWidth, this.mBitmapHeight, this.mBitmapConfig);
                            if (!a(i, b) || !a(i, b, canvas, 2)) {
                                i3 = 0;
                            }
                            z = i3;
                            i3 = 3;
                            com.facebook.common.references.a.c(b);
                            if (z) {
                            }
                        } catch (RuntimeException e) {
                            com.facebook.common.c.a.a(mPz, "Failed to create frame bitmap", (Throwable) e);
                            com.facebook.common.references.a.c(null);
                            return false;
                        }
                        break;
                    case 3:
                        com.facebook.common.references.a<Bitmap> IS = this.mXc.IS(i);
                        try {
                            b = IS;
                            z = a(i, IS, canvas, 3);
                            i3 = -1;
                            com.facebook.common.references.a.c(b);
                            if (z) {
                            }
                        } catch (Throwable th2) {
                            th = th2;
                            aVar = IS;
                            com.facebook.common.references.a.c(aVar);
                            throw th;
                        }
                        break;
                    default:
                        com.facebook.common.references.a.c(null);
                        return false;
                }
            } catch (Throwable th3) {
                th = th3;
            }
        } catch (Throwable th4) {
            th = th4;
            aVar = 0;
            com.facebook.common.references.a.c(aVar);
            throw th;
        }
    }

    @Override // com.facebook.fresco.animation.a.a
    public void setAlpha(@IntRange(from = 0, to = 255) int i) {
        this.mPaint.setAlpha(i);
    }

    @Override // com.facebook.fresco.animation.a.a
    public void setColorFilter(@Nullable ColorFilter colorFilter) {
        this.mPaint.setColorFilter(colorFilter);
    }

    @Override // com.facebook.fresco.animation.a.a
    public void setBounds(@Nullable Rect rect) {
        this.mBounds = rect;
        this.mXe.setBounds(rect);
        dFj();
    }

    @Override // com.facebook.fresco.animation.a.a
    public int getIntrinsicWidth() {
        return this.mBitmapWidth;
    }

    @Override // com.facebook.fresco.animation.a.a
    public int getIntrinsicHeight() {
        return this.mBitmapHeight;
    }

    @Override // com.facebook.fresco.animation.a.a
    public void clear() {
        this.mXc.clear();
    }

    @Override // com.facebook.fresco.animation.a.c.a
    public void onInactive() {
        clear();
    }

    private void dFj() {
        this.mBitmapWidth = this.mXe.getIntrinsicWidth();
        if (this.mBitmapWidth == -1) {
            this.mBitmapWidth = this.mBounds == null ? -1 : this.mBounds.width();
        }
        this.mBitmapHeight = this.mXe.getIntrinsicHeight();
        if (this.mBitmapHeight == -1) {
            this.mBitmapHeight = this.mBounds != null ? this.mBounds.height() : -1;
        }
    }

    private boolean a(int i, @Nullable com.facebook.common.references.a<Bitmap> aVar) {
        if (!com.facebook.common.references.a.a(aVar)) {
            return false;
        }
        boolean a = this.mXe.a(i, aVar.get());
        if (!a) {
            com.facebook.common.references.a.c(aVar);
            return a;
        }
        return a;
    }

    private boolean a(int i, @Nullable com.facebook.common.references.a<Bitmap> aVar, Canvas canvas, int i2) {
        if (!com.facebook.common.references.a.a(aVar)) {
            return false;
        }
        if (this.mBounds == null) {
            canvas.drawBitmap(aVar.get(), 0.0f, 0.0f, this.mPaint);
        } else {
            canvas.drawBitmap(aVar.get(), (Rect) null, this.mBounds, this.mPaint);
        }
        if (i2 != 3) {
            this.mXc.a(i, aVar, i2);
        }
        if (this.mXh != null) {
            this.mXh.a(this, i, i2);
        }
        return true;
    }
}
