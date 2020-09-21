package tv.chushou.zues.utils;

import android.annotation.SuppressLint;
import android.app.Application;
import android.content.Context;
import android.content.res.Resources;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.drawable.BitmapDrawable;
import android.graphics.drawable.Drawable;
import android.support.annotation.Nullable;
import java.io.File;
import java.lang.reflect.Field;
import java.util.Collection;
import org.json.JSONArray;
import tv.chushou.basis.rxjava.RxExecutor;
import tv.chushou.basis.rxjava.thread.EventThread;
/* loaded from: classes6.dex */
public class h {
    private static volatile File oWY;
    private static tv.chushou.zues.toolkit.a.b.a<Drawable> oWZ;
    private static volatile Resources oWp;
    private static final Field oXa;
    private static volatile Application sApplication;

    public static void a(Context context, File file, Resources resources) {
        sApplication = (Application) context;
        oWY = file;
        oWp = resources;
    }

    @SuppressLint({"PrivateApi"})
    public static Application epQ() {
        if (sApplication != null) {
            return sApplication;
        }
        synchronized (h.class) {
            if (sApplication == null) {
                try {
                    sApplication = (Application) Class.forName("android.app.ActivityThread").getMethod("currentApplication", new Class[0]).invoke(null, null);
                } catch (Exception e) {
                }
            }
        }
        return sApplication;
    }

    public static Resources eqt() {
        return oWp;
    }

    public static boolean isEmpty(String str) {
        return str == null || str.isEmpty() || str.equals("null");
    }

    public static boolean isEmpty(Collection<?> collection) {
        return collection == null || collection.isEmpty();
    }

    public static boolean ad(JSONArray jSONArray) {
        return jSONArray == null || jSONArray.length() == 0;
    }

    public static int parseInt(String str) {
        if (isEmpty(str)) {
            return 0;
        }
        try {
            return Integer.parseInt(str);
        } catch (NumberFormatException e) {
            return 0;
        }
    }

    public static int bW(String str, int i) {
        if (!isEmpty(str)) {
            try {
                return Integer.parseInt(str);
            } catch (NumberFormatException e) {
                return i;
            }
        }
        return i;
    }

    public static long parseLong(String str) {
        if (isEmpty(str)) {
            return 0L;
        }
        try {
            return Long.parseLong(str);
        } catch (NumberFormatException e) {
            return 0L;
        }
    }

    public static long Q(String str, long j) {
        if (!isEmpty(str)) {
            try {
                return Long.parseLong(str);
            } catch (NumberFormatException e) {
                return j;
            }
        }
        return j;
    }

    public static float parseFloat(String str) {
        if (isEmpty(str)) {
            return 0.0f;
        }
        try {
            return Float.parseFloat(str);
        } catch (NumberFormatException e) {
            return 0.0f;
        }
    }

    public static void equ() {
        if (oWZ != null) {
            oWZ.clear();
            oWZ = null;
        }
    }

    @Nullable
    public static Drawable Xz(String str) {
        if (oWZ != null) {
            return oWZ.get(str);
        }
        return null;
    }

    @Nullable
    public static Drawable P(String str, Object obj) {
        BitmapDrawable bitmapDrawable = null;
        if (obj != null) {
            try {
                if (obj instanceof Drawable) {
                    bitmapDrawable = (Drawable) obj;
                } else if (obj instanceof Bitmap) {
                    bitmapDrawable = new BitmapDrawable(eqt(), (Bitmap) obj);
                }
                if (bitmapDrawable != null) {
                    if (oWZ == null) {
                        oWZ = new tv.chushou.zues.toolkit.a.b.a<>(15, new tv.chushou.zues.toolkit.a.b.b<Drawable>() { // from class: tv.chushou.zues.utils.h.1
                            /* JADX DEBUG: Method merged with bridge method */
                            @Override // tv.chushou.zues.toolkit.a.b.b
                            /* renamed from: b */
                            public int K(String str2, Drawable drawable) {
                                return 1;
                            }
                        });
                    }
                    oWZ.put(str, bitmapDrawable);
                }
            } catch (Exception e) {
            }
        }
        return bitmapDrawable;
    }

    public static String XA(String str) {
        if (isEmpty(str)) {
            return "";
        }
        File file = oWY;
        if (file == null) {
            file = epQ().getCacheDir();
        }
        return file.getAbsolutePath() + File.separator + tv.chushou.a.a.d.b.encrypt(str);
    }

    @Nullable
    public static Drawable XB(final String str) {
        if (isEmpty(str)) {
            return null;
        }
        String XD = XD(str);
        if (isEmpty(XD)) {
            RxExecutor.post(null, EventThread.IO, new Runnable() { // from class: tv.chushou.zues.utils.h.2
                @Override // java.lang.Runnable
                public void run() {
                    Bitmap A = tv.chushou.zues.widget.fresco.a.A(str, 0, 0);
                    if (A != null) {
                        h.P(str, A);
                        c.a(A, new File(h.XA(str)), Bitmap.CompressFormat.PNG, 75);
                    }
                }
            });
            return null;
        }
        Drawable Xz = Xz(str);
        if (Xz == null) {
            try {
                Bitmap decodeFile = BitmapFactory.decodeFile(XD);
                if (decodeFile != null) {
                    return P(str, decodeFile);
                }
                return Xz;
            } catch (Exception e) {
                return Xz;
            }
        }
        return Xz;
    }

    public static void XC(String str) {
        Bitmap decodeFile;
        if (!isEmpty(str)) {
            String XD = XD(str);
            if (isEmpty(XD)) {
                Bitmap A = tv.chushou.zues.widget.fresco.a.A(str, 0, 0);
                if (A != null) {
                    P(str, A);
                    c.a(A, new File(XA(str)), Bitmap.CompressFormat.PNG, 75);
                    return;
                }
                return;
            }
            File file = new File(XD);
            if (file.exists() && file.isFile() && (decodeFile = BitmapFactory.decodeFile(XD)) != null) {
                P(str, decodeFile);
            }
        }
    }

    private static String XD(String str) {
        if (isEmpty(str)) {
            return "";
        }
        String XA = XA(str);
        File file = new File(XA);
        if (!file.isFile() || !file.exists()) {
            e.d("Utils", "image( " + str + " ): not exists");
            return "";
        }
        return XA;
    }

    static {
        Field field;
        Exception e;
        try {
            field = Class.forName("android.text.TextLine").getDeclaredField("sCached");
            try {
                field.setAccessible(true);
            } catch (Exception e2) {
                e = e2;
                e.printStackTrace();
                oXa = field;
            }
        } catch (Exception e3) {
            field = null;
            e = e3;
        }
        oXa = field;
    }
}
