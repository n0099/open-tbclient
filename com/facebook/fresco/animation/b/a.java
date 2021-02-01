package com.facebook.fresco.animation.b;

import android.graphics.Bitmap;
import android.graphics.Canvas;
import android.graphics.ColorFilter;
import android.graphics.Paint;
import android.graphics.Rect;
import android.graphics.drawable.Drawable;
import androidx.annotation.IntRange;
import com.facebook.fresco.animation.a.c;
import com.facebook.fresco.animation.a.d;
import com.facebook.imagepipeline.a.f;
import javax.annotation.Nullable;
/* loaded from: classes5.dex */
public class a implements com.facebook.fresco.animation.a.a, c.a {
    private static final Class<?> pxC = a.class;
    private int mBitmapHeight;
    private int mBitmapWidth;
    @Nullable
    private Rect mBounds;
    private final f pEI;
    private final b pEJ;
    private final d pEK;
    private final c pEL;
    @Nullable
    private final com.facebook.fresco.animation.b.b.a pEM;
    @Nullable
    private final com.facebook.fresco.animation.b.b.b pEN;
    @Nullable
    private InterfaceC1049a pEO;
    private Bitmap.Config mBitmapConfig = Bitmap.Config.ARGB_8888;
    private final Paint mPaint = new Paint(6);

    /* renamed from: com.facebook.fresco.animation.b.a$a  reason: collision with other inner class name */
    /* loaded from: classes5.dex */
    public interface InterfaceC1049a {
        void a(a aVar, int i);

        void a(a aVar, int i, int i2);

        void b(a aVar, int i);
    }

    public a(f fVar, b bVar, d dVar, c cVar, @Nullable com.facebook.fresco.animation.b.b.a aVar, @Nullable com.facebook.fresco.animation.b.b.b bVar2) {
        this.pEI = fVar;
        this.pEJ = bVar;
        this.pEK = dVar;
        this.pEL = cVar;
        this.pEM = aVar;
        this.pEN = bVar2;
        evh();
    }

    @Override // com.facebook.fresco.animation.a.d
    public int getFrameCount() {
        return this.pEK.getFrameCount();
    }

    @Override // com.facebook.fresco.animation.a.d
    public int Ps(int i) {
        return this.pEK.Ps(i);
    }

    @Override // com.facebook.fresco.animation.a.d
    public int getLoopCount() {
        return this.pEK.getLoopCount();
    }

    @Override // com.facebook.fresco.animation.a.a
    public boolean a(Drawable drawable, Canvas canvas, int i) {
        if (this.pEO != null) {
            this.pEO.a(this, i);
        }
        boolean a2 = a(canvas, i, 0);
        if (!a2 && this.pEO != null) {
            this.pEO.b(this, i);
        }
        if (this.pEM != null && this.pEN != null) {
            this.pEM.a(this.pEN, this.pEJ, this, i);
        }
        return a2;
    }

    /* JADX DEBUG: Don't trust debug lines info. Repeating lines: [231=5] */
    /* JADX DEBUG: Failed to insert an additional move for type inference into block B:40:0x0087 */
    /* JADX DEBUG: Multi-variable search result rejected for r3v3, resolved type: com.facebook.common.references.a */
    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r3v0 */
    /* JADX WARN: Type inference failed for: r3v1 */
    /* JADX WARN: Type inference failed for: r3v2 */
    private boolean a(Canvas canvas, int i, int i2) {
        int i3;
        boolean z;
        com.facebook.common.references.a<Bitmap> aVar;
        com.facebook.common.references.a aVar2 = 3;
        boolean z2 = true;
        try {
            try {
                try {
                    switch (i2) {
                        case 0:
                            com.facebook.common.references.a<Bitmap> Pt = this.pEJ.Pt(i);
                            i3 = 1;
                            z = a(i, Pt, canvas, 0);
                            aVar = Pt;
                            break;
                        case 1:
                            com.facebook.common.references.a<Bitmap> ai = this.pEJ.ai(i, this.mBitmapWidth, this.mBitmapHeight);
                            if (!a(i, ai) || !a(i, ai, canvas, 1)) {
                                z2 = false;
                            }
                            i3 = 2;
                            z = z2;
                            aVar = ai;
                            break;
                        case 2:
                            try {
                                com.facebook.common.references.a<Bitmap> f = this.pEI.f(this.mBitmapWidth, this.mBitmapHeight, this.mBitmapConfig);
                                if (!a(i, f) || !a(i, f, canvas, 2)) {
                                    z2 = false;
                                }
                                i3 = 3;
                                z = z2;
                                aVar = f;
                                break;
                            } catch (RuntimeException e) {
                                com.facebook.common.c.a.a(pxC, "Failed to create frame bitmap", e);
                                com.facebook.common.references.a.c(null);
                                return false;
                            }
                            break;
                        case 3:
                            com.facebook.common.references.a<Bitmap> Pu = this.pEJ.Pu(i);
                            i3 = -1;
                            z = a(i, Pu, canvas, 3);
                            aVar = Pu;
                            break;
                        default:
                            com.facebook.common.references.a.c(null);
                            return false;
                    }
                    com.facebook.common.references.a.c(aVar);
                    return (z || i3 == -1) ? z : a(canvas, i, i3);
                } catch (Throwable th) {
                    th = th;
                    com.facebook.common.references.a.c(aVar2);
                    throw th;
                }
            } catch (Throwable th2) {
                th = th2;
                aVar2 = 2;
                com.facebook.common.references.a.c(aVar2);
                throw th;
            }
        } catch (Throwable th3) {
            th = th3;
            aVar2 = 0;
            com.facebook.common.references.a.c(aVar2);
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
        this.pEL.setBounds(rect);
        evh();
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
        this.pEJ.clear();
    }

    @Override // com.facebook.fresco.animation.a.c.a
    public void onInactive() {
        clear();
    }

    private void evh() {
        this.mBitmapWidth = this.pEL.getIntrinsicWidth();
        if (this.mBitmapWidth == -1) {
            this.mBitmapWidth = this.mBounds == null ? -1 : this.mBounds.width();
        }
        this.mBitmapHeight = this.pEL.getIntrinsicHeight();
        if (this.mBitmapHeight == -1) {
            this.mBitmapHeight = this.mBounds != null ? this.mBounds.height() : -1;
        }
    }

    private boolean a(int i, @Nullable com.facebook.common.references.a<Bitmap> aVar) {
        if (!com.facebook.common.references.a.a(aVar)) {
            return false;
        }
        boolean c = this.pEL.c(i, aVar.get());
        if (!c) {
            com.facebook.common.references.a.c(aVar);
            return c;
        }
        return c;
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
            this.pEJ.a(i, aVar, i2);
        }
        if (this.pEO != null) {
            this.pEO.a(this, i, i2);
        }
        return true;
    }
}
