package com.opensource.svgaplayer.a;

import android.graphics.Bitmap;
import android.graphics.BitmapShader;
import android.graphics.Canvas;
import android.graphics.DashPathEffect;
import android.graphics.Matrix;
import android.graphics.Paint;
import android.graphics.Path;
import android.graphics.Rect;
import android.graphics.Shader;
import android.media.SoundPool;
import android.text.StaticLayout;
import android.text.TextPaint;
import android.widget.ImageView;
import com.meizu.cloud.pushsdk.notification.model.AdvanceSetting;
import com.opensource.svgaplayer.a.a;
import com.opensource.svgaplayer.c;
import com.opensource.svgaplayer.entities.SVGAVideoShapeEntity;
import com.opensource.svgaplayer.f;
import java.util.HashMap;
import kotlin.TypeCastException;
import kotlin.h;
import kotlin.jvm.a.m;
import kotlin.jvm.a.r;
import kotlin.jvm.internal.q;
import kotlin.text.l;
@h
/* loaded from: classes8.dex */
public final class b extends com.opensource.svgaplayer.a.a {
    private final c nJd;
    private final C0868b nKe;
    private final HashMap<String, Bitmap> nKf;
    private final a nKg;
    private final float[] nKh;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public b(f fVar, c cVar) {
        super(fVar);
        q.m(fVar, "videoItem");
        q.m(cVar, "dynamicItem");
        this.nJd = cVar;
        this.nKe = new C0868b();
        this.nKf = new HashMap<>();
        this.nKg = new a();
        this.nKh = new float[16];
    }

    @Override // com.opensource.svgaplayer.a.a
    public void a(Canvas canvas, int i, ImageView.ScaleType scaleType) {
        q.m(canvas, "canvas");
        q.m(scaleType, "scaleType");
        super.a(canvas, i, scaleType);
        this.nKg.ak(canvas);
        for (a.C0867a c0867a : KW(i)) {
            a(c0867a, canvas, i);
        }
        KX(i);
    }

    private final void KX(int i) {
        SoundPool dPl;
        Integer dPy;
        for (com.opensource.svgaplayer.entities.a aVar : dOS().dPk()) {
            if (aVar.dPw() == i && (dPl = dOS().dPl()) != null && (dPy = aVar.dPy()) != null) {
                aVar.r(Integer.valueOf(dPl.play(dPy.intValue(), 1.0f, 1.0f, 1, 0, 1.0f)));
            }
            if (aVar.dPx() <= i) {
                Integer dPz = aVar.dPz();
                if (dPz != null) {
                    int intValue = dPz.intValue();
                    SoundPool dPl2 = dOS().dPl();
                    if (dPl2 != null) {
                        dPl2.stop(intValue);
                    }
                }
                aVar.r(null);
            }
        }
    }

    private final Matrix c(Matrix matrix) {
        Matrix dPu = this.nKe.dPu();
        dPu.postScale(dPo().dPT(), dPo().dPU());
        dPu.postTranslate(dPo().dPR(), dPo().dPS());
        dPu.preConcat(matrix);
        return dPu;
    }

    private final void a(a.C0867a c0867a, Canvas canvas, int i) {
        a(c0867a, canvas);
        b(c0867a, canvas);
        b(c0867a, canvas, i);
    }

    private final void a(a.C0867a c0867a, Canvas canvas) {
        String dPp = c0867a.dPp();
        if (dPp != null && !q.l((Object) this.nJd.dOT().get(dPp), (Object) true)) {
            Bitmap bitmap = this.nJd.dOU().get(dPp);
            if (bitmap == null) {
                bitmap = dOS().dPm().get(dPp);
            }
            if (bitmap != null) {
                Matrix c = c(c0867a.dPq().dPC());
                Paint dPr = this.nKe.dPr();
                dPr.setAntiAlias(dOS().dPg());
                dPr.setFilterBitmap(dOS().dPg());
                dPr.setAlpha((int) (c0867a.dPq().dPO() * 255));
                if (c0867a.dPq().dPQ() != null) {
                    com.opensource.svgaplayer.entities.b dPQ = c0867a.dPq().dPQ();
                    if (dPQ != null) {
                        canvas.save();
                        dPr.reset();
                        Path dPs = this.nKe.dPs();
                        dPQ.a(dPs);
                        dPs.transform(c);
                        canvas.clipPath(dPs);
                        c.preScale((float) (c0867a.dPq().dPP().getWidth() / bitmap.getWidth()), (float) (c0867a.dPq().dPP().getWidth() / bitmap.getWidth()));
                        canvas.drawBitmap(bitmap, c, dPr);
                        canvas.restore();
                    } else {
                        return;
                    }
                } else {
                    c.preScale((float) (c0867a.dPq().dPP().getWidth() / bitmap.getWidth()), (float) (c0867a.dPq().dPP().getWidth() / bitmap.getWidth()));
                    canvas.drawBitmap(bitmap, c, dPr);
                }
                a(canvas, bitmap, c0867a, c);
            }
        }
    }

    private final void a(Canvas canvas, Bitmap bitmap, a.C0867a c0867a, Matrix matrix) {
        Bitmap bitmap2;
        Rect rect;
        if (this.nJd.dPa()) {
            this.nKf.clear();
            this.nJd.xL(false);
        }
        String dPp = c0867a.dPp();
        if (dPp != null) {
            Bitmap bitmap3 = null;
            String str = this.nJd.dOV().get(dPp);
            if (str != null) {
                TextPaint textPaint = this.nJd.dOW().get(dPp);
                if (textPaint != null && (bitmap3 = this.nKf.get(dPp)) == null) {
                    Bitmap createBitmap = Bitmap.createBitmap(bitmap.getWidth(), bitmap.getHeight(), Bitmap.Config.ARGB_8888);
                    Canvas canvas2 = new Canvas(createBitmap);
                    q.l((Object) textPaint, "drawingTextPaint");
                    textPaint.setAntiAlias(true);
                    textPaint.getTextBounds(str, 0, str.length(), new Rect());
                    canvas2.drawText(str, (float) ((bitmap.getWidth() - rect.width()) / 2.0d), (((0 + bitmap.getHeight()) - textPaint.getFontMetrics().bottom) - textPaint.getFontMetrics().top) / 2, textPaint);
                    HashMap<String, Bitmap> hashMap = this.nKf;
                    if (createBitmap == null) {
                        throw new TypeCastException("null cannot be cast to non-null type android.graphics.Bitmap");
                    }
                    hashMap.put(dPp, createBitmap);
                    bitmap3 = createBitmap;
                }
                bitmap2 = bitmap3;
            } else {
                bitmap2 = bitmap3;
            }
            StaticLayout staticLayout = this.nJd.dOX().get(dPp);
            if (staticLayout != null) {
                Bitmap bitmap4 = this.nKf.get(dPp);
                if (bitmap4 == null) {
                    q.l((Object) staticLayout, AdvanceSetting.NETWORK_TYPE);
                    TextPaint paint = staticLayout.getPaint();
                    q.l((Object) paint, "it.paint");
                    paint.setAntiAlias(true);
                    StaticLayout staticLayout2 = new StaticLayout(staticLayout.getText(), 0, staticLayout.getText().length(), staticLayout.getPaint(), bitmap.getWidth(), staticLayout.getAlignment(), staticLayout.getSpacingMultiplier(), staticLayout.getSpacingAdd(), false);
                    Bitmap createBitmap2 = Bitmap.createBitmap(bitmap.getWidth(), bitmap.getHeight(), Bitmap.Config.ARGB_8888);
                    Canvas canvas3 = new Canvas(createBitmap2);
                    canvas3.translate(0.0f, (bitmap.getHeight() - staticLayout2.getHeight()) / 2);
                    staticLayout2.draw(canvas3);
                    HashMap<String, Bitmap> hashMap2 = this.nKf;
                    if (createBitmap2 == null) {
                        throw new TypeCastException("null cannot be cast to non-null type android.graphics.Bitmap");
                    }
                    hashMap2.put(dPp, createBitmap2);
                    bitmap4 = createBitmap2;
                }
                bitmap2 = bitmap4;
            }
            if (bitmap2 != null) {
                Paint dPr = this.nKe.dPr();
                dPr.setAntiAlias(dOS().dPg());
                if (c0867a.dPq().dPQ() != null) {
                    com.opensource.svgaplayer.entities.b dPQ = c0867a.dPq().dPQ();
                    if (dPQ != null) {
                        canvas.save();
                        canvas.concat(matrix);
                        canvas.clipRect(0, 0, bitmap.getWidth(), bitmap.getHeight());
                        dPr.setShader(new BitmapShader(bitmap2, Shader.TileMode.REPEAT, Shader.TileMode.REPEAT));
                        Path dPs = this.nKe.dPs();
                        dPQ.a(dPs);
                        canvas.drawPath(dPs, dPr);
                        canvas.restore();
                        return;
                    }
                    return;
                }
                dPr.setFilterBitmap(dOS().dPg());
                canvas.drawBitmap(bitmap2, matrix, dPr);
            }
        }
    }

    private final void b(a.C0867a c0867a, Canvas canvas) {
        float[] dPL;
        String dPJ;
        String dPI;
        int dPG;
        Matrix c = c(c0867a.dPq().dPC());
        for (SVGAVideoShapeEntity sVGAVideoShapeEntity : c0867a.dPq().hW()) {
            sVGAVideoShapeEntity.dPF();
            if (sVGAVideoShapeEntity.dPE() != null) {
                Paint dPr = this.nKe.dPr();
                dPr.reset();
                dPr.setAntiAlias(dOS().dPg());
                dPr.setAlpha((int) (c0867a.dPq().dPO() * 255));
                Path dPs = this.nKe.dPs();
                dPs.reset();
                dPs.addPath(this.nKg.a(sVGAVideoShapeEntity));
                Matrix dPv = this.nKe.dPv();
                dPv.reset();
                Matrix dPC = sVGAVideoShapeEntity.dPC();
                if (dPC != null) {
                    dPv.postConcat(dPC);
                }
                dPv.postConcat(c);
                dPs.transform(dPv);
                SVGAVideoShapeEntity.a dPB = sVGAVideoShapeEntity.dPB();
                if (dPB != null && (dPG = dPB.dPG()) != 0) {
                    dPr.setStyle(Paint.Style.FILL);
                    dPr.setColor(dPG);
                    dPr.setAlpha(Math.min(255, Math.max(0, (int) (c0867a.dPq().dPO() * 255))));
                    if (c0867a.dPq().dPQ() != null) {
                        canvas.save();
                    }
                    com.opensource.svgaplayer.entities.b dPQ = c0867a.dPq().dPQ();
                    if (dPQ != null) {
                        Path dPt = this.nKe.dPt();
                        dPQ.a(dPt);
                        dPt.transform(c);
                        canvas.clipPath(dPt);
                    }
                    canvas.drawPath(dPs, dPr);
                    if (c0867a.dPq().dPQ() != null) {
                        canvas.restore();
                    }
                }
                SVGAVideoShapeEntity.a dPB2 = sVGAVideoShapeEntity.dPB();
                if (dPB2 != null && dPB2.getStrokeWidth() > 0) {
                    dPr.setStyle(Paint.Style.STROKE);
                    SVGAVideoShapeEntity.a dPB3 = sVGAVideoShapeEntity.dPB();
                    if (dPB3 != null) {
                        dPr.setColor(dPB3.dPH());
                        dPr.setAlpha(Math.min(255, Math.max(0, (int) (c0867a.dPq().dPO() * 255))));
                    }
                    float d = d(c);
                    SVGAVideoShapeEntity.a dPB4 = sVGAVideoShapeEntity.dPB();
                    if (dPB4 != null) {
                        dPr.setStrokeWidth(dPB4.getStrokeWidth() * d);
                    }
                    SVGAVideoShapeEntity.a dPB5 = sVGAVideoShapeEntity.dPB();
                    if (dPB5 != null && (dPI = dPB5.dPI()) != null) {
                        if (l.I(dPI, "butt", true)) {
                            dPr.setStrokeCap(Paint.Cap.BUTT);
                        } else if (l.I(dPI, "round", true)) {
                            dPr.setStrokeCap(Paint.Cap.ROUND);
                        } else if (l.I(dPI, "square", true)) {
                            dPr.setStrokeCap(Paint.Cap.SQUARE);
                        }
                    }
                    SVGAVideoShapeEntity.a dPB6 = sVGAVideoShapeEntity.dPB();
                    if (dPB6 != null && (dPJ = dPB6.dPJ()) != null) {
                        if (l.I(dPJ, "miter", true)) {
                            dPr.setStrokeJoin(Paint.Join.MITER);
                        } else if (l.I(dPJ, "round", true)) {
                            dPr.setStrokeJoin(Paint.Join.ROUND);
                        } else if (l.I(dPJ, "bevel", true)) {
                            dPr.setStrokeJoin(Paint.Join.BEVEL);
                        }
                    }
                    SVGAVideoShapeEntity.a dPB7 = sVGAVideoShapeEntity.dPB();
                    if (dPB7 != null) {
                        dPr.setStrokeMiter(dPB7.dPK() * d);
                    }
                    SVGAVideoShapeEntity.a dPB8 = sVGAVideoShapeEntity.dPB();
                    if (dPB8 != null && (dPL = dPB8.dPL()) != null && dPL.length == 3 && (dPL[0] > 0 || dPL[1] > 0)) {
                        float[] fArr = new float[2];
                        fArr[0] = (dPL[0] < 1.0f ? 1.0f : dPL[0]) * d;
                        fArr[1] = (dPL[1] < 0.1f ? 0.1f : dPL[1]) * d;
                        dPr.setPathEffect(new DashPathEffect(fArr, dPL[2] * d));
                    }
                    if (c0867a.dPq().dPQ() != null) {
                        canvas.save();
                    }
                    com.opensource.svgaplayer.entities.b dPQ2 = c0867a.dPq().dPQ();
                    if (dPQ2 != null) {
                        Path dPt2 = this.nKe.dPt();
                        dPQ2.a(dPt2);
                        dPt2.transform(c);
                        canvas.clipPath(dPt2);
                    }
                    canvas.drawPath(dPs, dPr);
                    if (c0867a.dPq().dPQ() != null) {
                        canvas.restore();
                    }
                }
            }
        }
    }

    private final float d(Matrix matrix) {
        matrix.getValues(this.nKh);
        if (this.nKh[0] == 0.0f) {
            return 0.0f;
        }
        double d = this.nKh[0];
        double d2 = this.nKh[3];
        double d3 = this.nKh[1];
        double d4 = this.nKh[4];
        if (d * d4 == d2 * d3) {
            return 0.0f;
        }
        double sqrt = Math.sqrt((d * d) + (d2 * d2));
        double d5 = d / sqrt;
        double d6 = d2 / sqrt;
        double d7 = (d5 * d3) + (d6 * d4);
        double d8 = d3 - (d5 * d7);
        double d9 = d4 - (d6 * d7);
        double sqrt2 = Math.sqrt((d8 * d8) + (d9 * d9));
        double d10 = d7 / sqrt2;
        if (d5 * (d9 / sqrt2) < d6 * (d8 / sqrt2)) {
            sqrt = -sqrt;
        }
        return dPo().dPV() ? Math.abs((float) sqrt) : Math.abs((float) sqrt2);
    }

    private final void b(a.C0867a c0867a, Canvas canvas, int i) {
        String dPp = c0867a.dPp();
        if (dPp != null) {
            m<Canvas, Integer, Boolean> mVar = this.nJd.dOY().get(dPp);
            if (mVar != null) {
                Matrix c = c(c0867a.dPq().dPC());
                canvas.save();
                canvas.concat(c);
                mVar.invoke(canvas, Integer.valueOf(i));
                canvas.restore();
            }
            r<Canvas, Integer, Integer, Integer, Boolean> rVar = this.nJd.dOZ().get(dPp);
            if (rVar != null) {
                Matrix c2 = c(c0867a.dPq().dPC());
                canvas.save();
                canvas.concat(c2);
                rVar.invoke(canvas, Integer.valueOf(i), Integer.valueOf((int) c0867a.dPq().dPP().getWidth()), Integer.valueOf((int) c0867a.dPq().dPP().getHeight()));
                canvas.restore();
            }
        }
    }

    @h
    /* renamed from: com.opensource.svgaplayer.a.b$b  reason: collision with other inner class name */
    /* loaded from: classes8.dex */
    public static final class C0868b {
        private final Paint nKl = new Paint();
        private final Path nKm = new Path();
        private final Path nKn = new Path();
        private final Matrix nKo = new Matrix();
        private final Matrix nKp = new Matrix();

        public final Paint dPr() {
            this.nKl.reset();
            return this.nKl;
        }

        public final Path dPs() {
            this.nKm.reset();
            return this.nKm;
        }

        public final Path dPt() {
            this.nKn.reset();
            return this.nKn;
        }

        public final Matrix dPu() {
            this.nKo.reset();
            return this.nKo;
        }

        public final Matrix dPv() {
            this.nKp.reset();
            return this.nKp;
        }
    }

    @h
    /* loaded from: classes8.dex */
    public static final class a {
        private int nKi;
        private int nKj;
        private final HashMap<SVGAVideoShapeEntity, Path> nKk = new HashMap<>();

        public final void ak(Canvas canvas) {
            q.m(canvas, "canvas");
            if (this.nKi != canvas.getWidth() || this.nKj != canvas.getHeight()) {
                this.nKk.clear();
            }
            this.nKi = canvas.getWidth();
            this.nKj = canvas.getHeight();
        }

        public final Path a(SVGAVideoShapeEntity sVGAVideoShapeEntity) {
            q.m(sVGAVideoShapeEntity, "shape");
            if (!this.nKk.containsKey(sVGAVideoShapeEntity)) {
                Path path = new Path();
                path.set(sVGAVideoShapeEntity.dPE());
                this.nKk.put(sVGAVideoShapeEntity, path);
            }
            Path path2 = this.nKk.get(sVGAVideoShapeEntity);
            if (path2 == null) {
                q.dUg();
            }
            return path2;
        }
    }
}
