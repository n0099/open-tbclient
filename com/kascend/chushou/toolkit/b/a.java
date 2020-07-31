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
    private static final tv.chushou.zues.toolkit.b.a nCP = tv.chushou.zues.toolkit.b.a.ota;
    private static a nCS;
    private final Object d = new Object();
    private Map<View, String> e = Collections.synchronizedMap(new WeakHashMap());
    private final tv.chushou.zues.toolkit.a.b.a<Drawable> nCQ = new tv.chushou.zues.toolkit.a.b.a<>(15, new tv.chushou.zues.toolkit.a.b.b<Drawable>() { // from class: com.kascend.chushou.toolkit.b.a.1
        /* JADX DEBUG: Method merged with bridge method */
        @Override // tv.chushou.zues.toolkit.a.b.b
        /* renamed from: a */
        public int L(String str, Drawable drawable) {
            return 1;
        }
    });
    private tv.chushou.zues.toolkit.a.a.a nCR;

    public static a dOn() {
        if (nCS == null) {
            synchronized (a.class) {
                if (nCS == null) {
                    nCS = new a();
                }
            }
        }
        return nCS;
    }

    public static void b() {
    }

    private a() {
        this.nCR = null;
        try {
            this.nCR = tv.chushou.zues.toolkit.a.a.a.b(com.kascend.chushou.d.c.nnC.e(), 1, 1, 10485760L);
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
            if (this.nCQ != null) {
                drawable = this.nCQ.get(str);
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
        String a;
        View b;

        c(String str, View view) {
            this.a = str;
            this.b = view;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public boolean a(c cVar) {
        String str = this.e.get(cVar.b);
        return str == null || !str.equals(cVar.a);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes6.dex */
    public class b implements Runnable {
        c nCW;

        b(c cVar) {
            this.nCW = cVar;
        }

        @Override // java.lang.Runnable
        public void run() {
            Drawable Sb;
            if (!a.this.a(this.nCW) && !h.isEmpty(this.nCW.a) && (Sb = a.this.Sb(this.nCW.a)) != null) {
                a.this.nCQ.put(this.nCW.a, Sb);
                if (!a.this.a(this.nCW)) {
                    ((Activity) this.nCW.b.getContext()).runOnUiThread(new RunnableC0844a(Sb, this.nCW));
                }
            }
        }
    }

    /* renamed from: com.kascend.chushou.toolkit.b.a$a  reason: collision with other inner class name */
    /* loaded from: classes6.dex */
    class RunnableC0844a implements Runnable {
        Drawable a;
        c nCU;

        RunnableC0844a(Drawable drawable, c cVar) {
            this.a = drawable;
            this.nCU = cVar;
        }

        @Override // java.lang.Runnable
        public void run() {
            if (!a.this.a(this.nCU)) {
                this.nCU.b.setBackgroundDrawable(this.a);
            }
        }
    }

    private void b(String str, View view) {
        tv.chushou.a.a.b.a.dZP().N(new b(new c(str, view)));
    }

    /* JADX DEBUG: Don't trust debug lines info. Repeating lines: [195=5, 197=4, 198=4, 199=4] */
    /* JADX WARN: Removed duplicated region for block: B:45:0x006e A[EXC_TOP_SPLITTER, SYNTHETIC] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    private Drawable Sa(String str) {
        InputStream inputStream;
        Throwable th;
        InputStream inputStream2 = null;
        if (this.nCR == null) {
            return null;
        }
        try {
            a.c TN = this.nCR.TN(str);
            if (TN == null) {
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
            inputStream = TN.LZ(0);
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
    public Drawable Sb(String str) {
        Drawable Sa;
        a.C0952a TO;
        Drawable drawable = null;
        if (this.nCR != null) {
            ?? r1 = nCP;
            String TP = r1.TP(str);
            try {
                try {
                    synchronized (this.d) {
                        try {
                            Sa = Sa(TP);
                        } catch (Throwable th) {
                            r1 = 0;
                            th = th;
                        }
                        try {
                            if (Sa == null && (TO = this.nCR.TO(TP)) != null) {
                                OutputStream LW = TO.LW(0);
                                Http http = (Http) tv.chushou.basis.d.b.dZG().S(Http.class);
                                if (http == null) {
                                    TO.abort();
                                    drawable = Sa;
                                } else if (http.downloadSync(str, LW)) {
                                    TO.commit();
                                    drawable = Sa(TP);
                                } else {
                                    TO.abort();
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
                        drawable = Sa;
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
