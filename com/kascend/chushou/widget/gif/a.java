package com.kascend.chushou.widget.gif;

import android.graphics.Bitmap;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.Rect;
import android.graphics.RectF;
import android.support.v4.graphics.drawable.RoundedBitmapDrawable;
import android.support.v4.graphics.drawable.RoundedBitmapDrawableFactory;
import com.baidu.searchbox.unitedscheme.SchemeCollecter;
import com.facebook.cache.common.g;
import com.facebook.imagepipeline.b.f;
import com.kascend.chushou.d.i;
import java.io.File;
import java.util.Arrays;
import java.util.Locale;
import kotlin.jvm.internal.o;
import kotlin.jvm.internal.q;
import kotlin.jvm.internal.v;
/* loaded from: classes4.dex */
public final class a extends com.facebook.imagepipeline.request.a {
    public static final C0715a nhQ = new C0715a(null);
    private final int c;
    private final int d;
    private final String e;
    private com.facebook.cache.common.b nhP;

    public a(int i, int i2, String str) {
        this.c = i;
        this.d = i2;
        this.e = str;
    }

    /* renamed from: com.kascend.chushou.widget.gif.a$a  reason: collision with other inner class name */
    /* loaded from: classes4.dex */
    public static final class C0715a {
        private C0715a() {
        }

        public /* synthetic */ C0715a(o oVar) {
            this();
        }
    }

    @Override // com.facebook.imagepipeline.request.a, com.facebook.imagepipeline.request.b
    public String getName() {
        return "AvatarFramePostProcessor";
    }

    @Override // com.facebook.imagepipeline.request.a, com.facebook.imagepipeline.request.b
    public com.facebook.cache.common.b dqg() {
        String SG;
        if (this.nhP == null) {
            v vVar = v.nBK;
            Locale locale = Locale.CHINA;
            q.i(locale, "Locale.CHINA");
            Object[] objArr = new Object[1];
            String str = this.e;
            if (str == null || str.length() == 0) {
                SG = SchemeCollecter.CLASSIFY_EMPTY;
            } else {
                SG = tv.chushou.zues.toolkit.b.a.nVI.SG(this.e);
            }
            objArr[0] = SG;
            String format = String.format(locale, "%s", Arrays.copyOf(objArr, objArr.length));
            q.i(format, "java.lang.String.format(locale, format, *args)");
            this.nhP = new g(format);
        }
        return this.nhP;
    }

    @Override // com.facebook.imagepipeline.request.a, com.facebook.imagepipeline.request.b
    public com.facebook.common.references.a<Bitmap> a(Bitmap bitmap, f fVar) {
        Bitmap bitmap2;
        q.j(bitmap, "sourceBitmap");
        q.j(fVar, "bitmapFactory");
        Bitmap.Config config = bitmap.getConfig();
        int i = this.c;
        int i2 = this.c;
        if (config == null) {
            config = com.facebook.imagepipeline.request.a.lWq;
        }
        com.facebook.common.references.a<Bitmap> c = fVar.c(i, i2, config);
        if (c == null) {
            bitmap2 = null;
        } else {
            try {
                bitmap2 = c.get();
            } finally {
                com.facebook.common.references.a.c(c);
            }
        }
        d(bitmap2, bitmap);
        return com.facebook.common.references.a.b((com.facebook.common.references.a) c);
    }

    @Override // com.facebook.imagepipeline.request.a
    public void d(Bitmap bitmap, Bitmap bitmap2) {
        if (bitmap != null && bitmap2 != null) {
            Canvas canvas = new Canvas(bitmap);
            RoundedBitmapDrawable create = RoundedBitmapDrawableFactory.create(tv.chushou.widget.a.c.getResources(), bitmap2);
            q.i(create, "avatarDrawable");
            create.setCircular(true);
            create.setBounds(0, 0, this.d, this.d);
            canvas.save();
            float f = (this.c - this.d) / 2;
            canvas.translate(f, f);
            create.draw(canvas);
            canvas.restore();
            String str = this.e;
            Bitmap a = str == null || str.length() == 0 ? null : a(this.e, this.c);
            if (a != null) {
                canvas.drawBitmap(a, new Rect(0, 0, a.getWidth(), a.getHeight()), new RectF(0.0f, 0.0f, this.c, this.c), (Paint) null);
            }
        }
    }

    private final Bitmap a(String str, int i) {
        File ac = tv.chushou.zues.widget.fresco.a.ac(i.QH(str));
        if (ac != null) {
            return tv.chushou.zues.utils.c.G(ac.getAbsolutePath(), i, i);
        }
        File c = com.kascend.chushou.d.c.mOp.c();
        tv.chushou.a.a.d.a.ao(c);
        File file = new File(c, tv.chushou.zues.toolkit.b.a.nVI.SG(str));
        if (file.isFile() && file.exists()) {
            return tv.chushou.zues.utils.c.G(file.getAbsolutePath(), i, i);
        }
        if (tv.chushou.zues.widget.fresco.a.r(str, file)) {
            return tv.chushou.zues.utils.c.G(file.getAbsolutePath(), i, i);
        }
        return null;
    }
}
