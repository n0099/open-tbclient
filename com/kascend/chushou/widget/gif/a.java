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
import kotlin.h;
import kotlin.jvm.internal.o;
import kotlin.jvm.internal.q;
import kotlin.jvm.internal.v;
@h
/* loaded from: classes6.dex */
public final class a extends com.facebook.imagepipeline.request.a {
    public static final C0857a nGY = new C0857a(null);
    private final int c;
    private final int d;
    private final String e;
    private com.facebook.cache.common.b nGX;

    public a(int i, int i2, String str) {
        this.c = i;
        this.d = i2;
        this.e = str;
    }

    @h
    /* renamed from: com.kascend.chushou.widget.gif.a$a  reason: collision with other inner class name */
    /* loaded from: classes6.dex */
    public static final class C0857a {
        private C0857a() {
        }

        public /* synthetic */ C0857a(o oVar) {
            this();
        }
    }

    @Override // com.facebook.imagepipeline.request.a, com.facebook.imagepipeline.request.b
    public String getName() {
        return "AvatarFramePostProcessor";
    }

    @Override // com.facebook.imagepipeline.request.a, com.facebook.imagepipeline.request.b
    public com.facebook.cache.common.b dJo() {
        String TP;
        if (this.nGX == null) {
            v vVar = v.nYG;
            Locale locale = Locale.CHINA;
            q.l((Object) locale, "Locale.CHINA");
            Object[] objArr = new Object[1];
            String str = this.e;
            if (str == null || str.length() == 0) {
                TP = SchemeCollecter.CLASSIFY_EMPTY;
            } else {
                TP = tv.chushou.zues.toolkit.b.a.otc.TP(this.e);
            }
            objArr[0] = TP;
            String format = String.format(locale, "%s", Arrays.copyOf(objArr, objArr.length));
            q.l((Object) format, "java.lang.String.format(locale, format, *args)");
            this.nGX = new g(format);
        }
        return this.nGX;
    }

    @Override // com.facebook.imagepipeline.request.a, com.facebook.imagepipeline.request.b
    public com.facebook.common.references.a<Bitmap> a(Bitmap bitmap, f fVar) {
        Bitmap bitmap2;
        q.m(bitmap, "sourceBitmap");
        q.m(fVar, "bitmapFactory");
        Bitmap.Config config = bitmap.getConfig();
        int i = this.c;
        int i2 = this.c;
        if (config == null) {
            config = com.facebook.imagepipeline.request.a.nfZ;
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
        return com.facebook.common.references.a.b(c);
    }

    @Override // com.facebook.imagepipeline.request.a
    public void d(Bitmap bitmap, Bitmap bitmap2) {
        if (bitmap != null && bitmap2 != null) {
            Canvas canvas = new Canvas(bitmap);
            RoundedBitmapDrawable create = RoundedBitmapDrawableFactory.create(tv.chushou.widget.a.c.getResources(), bitmap2);
            q.l((Object) create, "avatarDrawable");
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
        File af = tv.chushou.zues.widget.fresco.a.af(i.RK(str));
        if (af != null) {
            return tv.chushou.zues.utils.c.A(af.getAbsolutePath(), i, i);
        }
        File c = com.kascend.chushou.d.c.nnE.c();
        tv.chushou.a.a.d.a.as(c);
        File file = new File(c, tv.chushou.zues.toolkit.b.a.otc.TP(str));
        if (file.isFile() && file.exists()) {
            return tv.chushou.zues.utils.c.A(file.getAbsolutePath(), i, i);
        }
        if (tv.chushou.zues.widget.fresco.a.s(str, file)) {
            return tv.chushou.zues.utils.c.A(file.getAbsolutePath(), i, i);
        }
        return null;
    }
}
