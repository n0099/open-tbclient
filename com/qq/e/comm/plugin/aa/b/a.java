package com.qq.e.comm.plugin.aa.b;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.Color;
import android.graphics.Matrix;
import android.os.Build;
import android.os.Handler;
import android.os.Looper;
import android.renderscript.Allocation;
import android.renderscript.RenderScript;
import android.renderscript.ScriptIntrinsicBlur;
import android.text.TextUtils;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import android.widget.ImageView;
import com.qq.e.comm.managers.GDTADManager;
import com.qq.e.comm.plugin.util.ai;
import com.qq.e.comm.plugin.util.s;
import com.qq.e.comm.plugin.y.u;
import java.lang.ref.WeakReference;
import java.util.LinkedHashMap;
import java.util.Map;
/* loaded from: classes3.dex */
public class a {

    /* renamed from: a  reason: collision with root package name */
    private static Map<String, WeakReference<Bitmap>> f11659a = new LinkedHashMap();

    /* JADX INFO: Access modifiers changed from: package-private */
    /* renamed from: com.qq.e.comm.plugin.aa.b.a$2  reason: invalid class name */
    /* loaded from: classes3.dex */
    public static final class AnonymousClass2 implements com.qq.e.comm.plugin.p.b {

        /* renamed from: a  reason: collision with root package name */
        final /* synthetic */ long f11662a;

        /* renamed from: b  reason: collision with root package name */
        final /* synthetic */ ViewGroup f11663b;
        final /* synthetic */ ImageView c;

        AnonymousClass2(long j, ViewGroup viewGroup, ImageView imageView) {
            this.f11662a = j;
            this.f11663b = viewGroup;
            this.c = imageView;
        }

        @Override // com.qq.e.comm.plugin.p.b
        public void a(String str, int i, Exception exc) {
        }

        @Override // com.qq.e.comm.plugin.p.b
        public void a(final String str, ImageView imageView, final com.qq.e.comm.plugin.p.e eVar) {
            ai.a("BGBlurHelper", "BG Blur download image cost : " + (System.currentTimeMillis() - this.f11662a));
            s.f12589a.submit(new Runnable() { // from class: com.qq.e.comm.plugin.aa.b.a.2.1
                @Override // java.lang.Runnable
                public void run() {
                    Bitmap a2 = eVar.a();
                    if (a2 == null) {
                        return;
                    }
                    Bitmap copy = a2.copy(Bitmap.Config.ARGB_8888, true);
                    Matrix matrix = new Matrix();
                    matrix.preScale(0.25f, 0.25f);
                    final Bitmap b2 = a.b(Bitmap.createBitmap(copy, 0, 0, copy.getWidth(), copy.getHeight(), matrix, false), AnonymousClass2.this.f11663b.getContext());
                    a.f11659a.put(str, new WeakReference(b2));
                    new Handler(Looper.getMainLooper()).post(new Runnable() { // from class: com.qq.e.comm.plugin.aa.b.a.2.1.1
                        @Override // java.lang.Runnable
                        public void run() {
                            a.b(AnonymousClass2.this.c, b2, AnonymousClass2.this.f11663b, AnonymousClass2.this.f11662a);
                        }
                    });
                }
            });
        }
    }

    public static void a(ViewGroup viewGroup) {
        if (b()) {
            ai.a("BGBlurHelper", "BG Blur disable");
        } else if (viewGroup != null) {
            View findViewWithTag = viewGroup.findViewWithTag("blurImage");
            View findViewWithTag2 = viewGroup.findViewWithTag("blurBG");
            if (findViewWithTag != null) {
                findViewWithTag.setVisibility(0);
            }
            if (findViewWithTag2 != null) {
                findViewWithTag2.setVisibility(0);
            }
        }
    }

    public static void a(ViewGroup viewGroup, String str, f fVar) {
        a(viewGroup, str, fVar, false);
    }

    public static void a(final ViewGroup viewGroup, final String str, final f fVar, final int i, boolean z) {
        if (b()) {
            ai.a("BGBlurHelper", "BG Blur disable");
        } else if (viewGroup == null || TextUtils.isEmpty(str)) {
            ai.a("BGBlurHelper", "viewGroup or imgUrl null");
        } else if (Build.VERSION.SDK_INT < 17) {
            ai.a("BGBlurHelper", "RenderScript nonsupport SDK level");
        } else {
            View findViewWithTag = viewGroup.findViewWithTag("blurImage");
            View findViewWithTag2 = viewGroup.findViewWithTag("blurBG");
            if (findViewWithTag != null && findViewWithTag2 != null) {
                findViewWithTag.setVisibility(0);
                findViewWithTag2.setVisibility(0);
                ai.a("BGBlurHelper", "already do blur, just show.");
            } else if (z) {
                b(viewGroup, str, i);
            } else if (fVar != null) {
                viewGroup.postDelayed(new Runnable() { // from class: com.qq.e.comm.plugin.aa.b.a.1
                    @Override // java.lang.Runnable
                    public void run() {
                        if (f.this == null || viewGroup == null) {
                            return;
                        }
                        int measuredWidth = viewGroup.getMeasuredWidth();
                        int measuredHeight = f.this.getMeasuredHeight();
                        ai.a("BGBlurHelper", "containWidth : " + measuredWidth + " ,containHeight : " + measuredHeight);
                        int measuredWidth2 = f.this.getMeasuredWidth();
                        int measuredHeight2 = f.this.getMeasuredHeight();
                        ai.a("BGBlurHelper", "videoWidth : " + measuredWidth2 + " ,videoHeight : " + measuredHeight2);
                        if (measuredWidth > measuredWidth2 || measuredHeight > measuredHeight2) {
                            a.b(viewGroup, str, i);
                        } else {
                            ai.a("BGBlurHelper", "no need blur");
                        }
                    }
                }, 50L);
            }
        }
    }

    public static void a(ViewGroup viewGroup, String str, f fVar, boolean z) {
        a(viewGroup, str, fVar, Color.parseColor("#88444444"), z);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static Bitmap b(Bitmap bitmap, Context context) {
        RenderScript create;
        ScriptIntrinsicBlur create2;
        if (Build.VERSION.SDK_INT >= 17 && (create = RenderScript.create(context)) != null) {
            Allocation createFromBitmap = Allocation.createFromBitmap(create, bitmap);
            if (createFromBitmap != null && (create2 = ScriptIntrinsicBlur.create(create, createFromBitmap.getElement())) != null) {
                create2.setInput(createFromBitmap);
                create2.setRadius(5.0f);
                create2.forEach(createFromBitmap);
                createFromBitmap.copyTo(bitmap);
            }
            create.destroy();
        }
        return bitmap;
    }

    public static void b(ViewGroup viewGroup) {
        if (b()) {
            ai.a("BGBlurHelper", "BG Blur disable");
        } else if (viewGroup != null) {
            View findViewWithTag = viewGroup.findViewWithTag("blurImage");
            View findViewWithTag2 = viewGroup.findViewWithTag("blurBG");
            if (findViewWithTag != null) {
                findViewWithTag.setVisibility(4);
            }
            if (findViewWithTag2 != null) {
                findViewWithTag2.setVisibility(4);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static void b(ViewGroup viewGroup, String str, int i) {
        long currentTimeMillis = System.currentTimeMillis();
        ImageView imageView = new ImageView(viewGroup.getContext());
        imageView.setTag("blurImage");
        FrameLayout.LayoutParams layoutParams = new FrameLayout.LayoutParams(-1, -1);
        imageView.setLayoutParams(layoutParams);
        ImageView imageView2 = new ImageView(viewGroup.getContext());
        imageView2.setTag("blurBG");
        imageView2.setLayoutParams(layoutParams);
        imageView2.setScaleType(ImageView.ScaleType.FIT_XY);
        imageView2.setBackgroundColor(i);
        viewGroup.addView(imageView2, 0);
        WeakReference<Bitmap> weakReference = f11659a.get(str);
        if (weakReference == null || weakReference.get() == null) {
            com.qq.e.comm.plugin.p.a.a().a(str, imageView, new AnonymousClass2(currentTimeMillis, viewGroup, imageView));
            return;
        }
        ai.a("BGBlurHelper", "BG Blur hit cache");
        b(imageView, weakReference.get(), viewGroup, currentTimeMillis);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static void b(ImageView imageView, Bitmap bitmap, ViewGroup viewGroup, long j) {
        if (bitmap == null || bitmap.isRecycled() || viewGroup == null) {
            return;
        }
        imageView.setImageBitmap(bitmap);
        imageView.setScaleType(ImageView.ScaleType.CENTER_CROP);
        viewGroup.addView(imageView, 0);
        long currentTimeMillis = System.currentTimeMillis() - j;
        ai.a("BGBlurHelper", "BG Blur cost : " + currentTimeMillis);
        u.a(100282, ((int) currentTimeMillis) / 50, null);
    }

    private static boolean b() {
        return GDTADManager.getInstance().getSM().getInteger("videoBGBlur", 1) == 0;
    }
}
