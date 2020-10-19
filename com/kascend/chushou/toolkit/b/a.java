package com.kascend.chushou.toolkit.b;

import android.app.Activity;
import android.graphics.BitmapFactory;
import android.graphics.Rect;
import android.graphics.drawable.Drawable;
import android.graphics.drawable.NinePatchDrawable;
import android.view.View;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.util.Collections;
import java.util.Map;
import java.util.WeakHashMap;
import tv.chushou.basis.http.Http;
import tv.chushou.widget.ninepatch.BitmapType;
import tv.chushou.zues.toolkit.a.a.a;
import tv.chushou.zues.utils.e;
import tv.chushou.zues.utils.h;
/* loaded from: classes6.dex */
public class a {
    private static final tv.chushou.zues.toolkit.b.a owh = tv.chushou.zues.toolkit.b.a.pmi;
    private static a owk;
    private final Object d = new Object();
    private Map<View, String> e = Collections.synchronizedMap(new WeakHashMap());
    private final tv.chushou.zues.toolkit.a.b.a<Drawable> owi = new tv.chushou.zues.toolkit.a.b.a<>(15, new tv.chushou.zues.toolkit.a.b.b<Drawable>() { // from class: com.kascend.chushou.toolkit.b.a.1
        /* JADX DEBUG: Method merged with bridge method */
        @Override // tv.chushou.zues.toolkit.a.b.b
        /* renamed from: a */
        public int L(String str, Drawable drawable) {
            return 1;
        }
    });
    private tv.chushou.zues.toolkit.a.a.a owj;

    public static a eii() {
        if (owk == null) {
            synchronized (a.class) {
                if (owk == null) {
                    owk = new a();
                }
            }
        }
        return owk;
    }

    public static void b() {
    }

    private a() {
        this.owj = null;
        try {
            this.owj = tv.chushou.zues.toolkit.a.a.a.b(com.kascend.chushou.d.c.oha.e(), 1, 1, 10485760L);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public void a(String str, View view, int i) {
        if (view != null) {
            if (h.isEmpty(str)) {
                view.setBackgroundResource(i);
                return;
            }
            this.e.put(view, str);
            Drawable drawable = null;
            if (this.owi != null) {
                drawable = this.owi.get(str);
            }
            if (drawable != null) {
                view.setBackgroundDrawable(drawable.getConstantState().newDrawable());
                return;
            }
            view.setBackgroundResource(i);
            b(str, view);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes6.dex */
    public class c {

        /* renamed from: a  reason: collision with root package name */
        String f4216a;
        View b;

        c(String str, View view) {
            this.f4216a = str;
            this.b = view;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public boolean a(c cVar) {
        String str = this.e.get(cVar.b);
        return str == null || !str.equals(cVar.f4216a);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes6.dex */
    public class b implements Runnable {
        c owo;

        b(c cVar) {
            this.owo = cVar;
        }

        @Override // java.lang.Runnable
        public void run() {
            Drawable Wv;
            if (!a.this.a(this.owo) && !h.isEmpty(this.owo.f4216a) && (Wv = a.this.Wv(this.owo.f4216a)) != null) {
                a.this.owi.put(this.owo.f4216a, Wv);
                if (!a.this.a(this.owo)) {
                    ((Activity) this.owo.b.getContext()).runOnUiThread(new RunnableC0917a(Wv, this.owo));
                }
            }
        }
    }

    /* renamed from: com.kascend.chushou.toolkit.b.a$a  reason: collision with other inner class name */
    /* loaded from: classes6.dex */
    class RunnableC0917a implements Runnable {

        /* renamed from: a  reason: collision with root package name */
        Drawable f4215a;
        c owm;

        RunnableC0917a(Drawable drawable, c cVar) {
            this.f4215a = drawable;
            this.owm = cVar;
        }

        @Override // java.lang.Runnable
        public void run() {
            if (!a.this.a(this.owm)) {
                this.owm.b.setBackgroundDrawable(this.f4215a);
            }
        }
    }

    private void b(String str, View view) {
        tv.chushou.a.a.b.a.etL().K(new b(new c(str, view)));
    }

    /* JADX DEBUG: Don't trust debug lines info. Repeating lines: [195=5, 197=4, 198=4, 199=4] */
    /* JADX WARN: Removed duplicated region for block: B:45:0x006e A[EXC_TOP_SPLITTER, SYNTHETIC] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    private Drawable Wu(String str) {
        InputStream inputStream;
        Throwable th;
        InputStream inputStream2 = null;
        if (this.owj == null) {
            return null;
        }
        try {
            a.c Yh = this.owj.Yh(str);
            if (Yh == null) {
                if (0 != 0) {
                    try {
                        inputStream2.close();
                        return null;
                    } catch (IOException e) {
                        e.printStackTrace();
                        return null;
                    }
                }
                return null;
            }
            inputStream = Yh.PN(0);
            try {
                try {
                    BitmapFactory.Options options = new BitmapFactory.Options();
                    options.inDensity = 320;
                    NinePatchDrawable ninePatchDrawable = BitmapType.getNinePatchDrawable(tv.chushou.widget.a.c.getResources(), BitmapFactory.decodeStream(inputStream, new Rect(), options), null);
                    ninePatchDrawable.setTargetDensity(tv.chushou.widget.a.c.getResources().getDisplayMetrics().densityDpi);
                    if (inputStream != null) {
                        try {
                            inputStream.close();
                        } catch (IOException e2) {
                            e2.printStackTrace();
                        }
                    }
                    return ninePatchDrawable;
                } catch (Exception e3) {
                    e = e3;
                    e.e("BgImageLoader", "", e);
                    if (inputStream != null) {
                        try {
                            inputStream.close();
                            return null;
                        } catch (IOException e4) {
                            e4.printStackTrace();
                            return null;
                        }
                    }
                    return null;
                }
            } catch (Throwable th2) {
                th = th2;
                if (inputStream != null) {
                    try {
                        inputStream.close();
                    } catch (IOException e5) {
                        e5.printStackTrace();
                    }
                }
                throw th;
            }
        } catch (Exception e6) {
            e = e6;
            inputStream = null;
        } catch (Throwable th3) {
            inputStream = null;
            th = th3;
            if (inputStream != null) {
            }
            throw th;
        }
    }

    /* JADX DEBUG: Failed to insert an additional move for type inference into block B:34:0x0065 */
    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r1v1, types: [tv.chushou.zues.toolkit.b.a] */
    /* JADX WARN: Type inference failed for: r1v10 */
    /* JADX WARN: Type inference failed for: r1v4 */
    /* JADX WARN: Type inference failed for: r1v7 */
    public Drawable Wv(String str) {
        Drawable Wu;
        a.C1025a Yi;
        Drawable drawable = null;
        if (this.owj != null) {
            ?? r1 = owh;
            String generate = r1.generate(str);
            try {
                try {
                    synchronized (this.d) {
                        try {
                            Wu = Wu(generate);
                        } catch (Throwable th) {
                            r1 = 0;
                            th = th;
                        }
                        try {
                            if (Wu == null && (Yi = this.owj.Yi(generate)) != null) {
                                OutputStream PK = Yi.PK(0);
                                Http http = (Http) tv.chushou.basis.d.b.etD().S(Http.class);
                                if (http == null) {
                                    Yi.abort();
                                    drawable = Wu;
                                } else if (http.downloadSync(str, PK)) {
                                    Yi.commit();
                                    drawable = Wu(generate);
                                } else {
                                    Yi.abort();
                                }
                            }
                        } catch (Throwable th2) {
                            r1 = drawable;
                            th = th2;
                            try {
                                throw th;
                            } catch (Exception e) {
                                drawable = r1;
                                e = e;
                                e.e("BgImageLoader", "", e);
                                return drawable;
                            }
                        }
                        drawable = Wu;
                    }
                } catch (Throwable th3) {
                    th = th3;
                }
            } catch (Exception e2) {
                e = e2;
            }
        }
        return drawable;
    }
}
