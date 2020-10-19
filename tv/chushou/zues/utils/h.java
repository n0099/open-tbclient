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
    private static volatile Resources plJ;
    private static volatile File pms;
    private static tv.chushou.zues.toolkit.a.b.a<Drawable> pmt;
    private static final Field pmu;
    private static volatile Application sApplication;

    public static void a(Context context, File file, Resources resources) {
        sApplication = (Application) context;
        pms = file;
        plJ = resources;
    }

    @SuppressLint({"PrivateApi"})
    public static Application etB() {
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

    public static Resources eue() {
        return plJ;
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

    public static int bX(String str, int i) {
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

    public static void euf() {
        if (pmt != null) {
            pmt.clear();
            pmt = null;
        }
    }

    @Nullable
    public static Drawable Yn(String str) {
        if (pmt != null) {
            return pmt.get(str);
        }
        return null;
    }

    @Nullable
    public static Drawable Q(String str, Object obj) {
        BitmapDrawable bitmapDrawable = null;
        if (obj != null) {
            try {
                if (obj instanceof Drawable) {
                    bitmapDrawable = (Drawable) obj;
                } else if (obj instanceof Bitmap) {
                    bitmapDrawable = new BitmapDrawable(eue(), (Bitmap) obj);
                }
                if (bitmapDrawable != null) {
                    if (pmt == null) {
                        pmt = new tv.chushou.zues.toolkit.a.b.a<>(15, new tv.chushou.zues.toolkit.a.b.b<Drawable>() { // from class: tv.chushou.zues.utils.h.1
                            /* JADX DEBUG: Method merged with bridge method */
                            @Override // tv.chushou.zues.toolkit.a.b.b
                            /* renamed from: b */
                            public int L(String str2, Drawable drawable) {
                                return 1;
                            }
                        });
                    }
                    pmt.put(str, bitmapDrawable);
                }
            } catch (Exception e) {
            }
        }
        return bitmapDrawable;
    }

    public static String Yo(String str) {
        if (isEmpty(str)) {
            return "";
        }
        File file = pms;
        if (file == null) {
            file = etB().getCacheDir();
        }
        return file.getAbsolutePath() + File.separator + tv.chushou.a.a.d.b.encrypt(str);
    }

    @Nullable
    public static Drawable Yp(final String str) {
        if (isEmpty(str)) {
            return null;
        }
        String Yr = Yr(str);
        if (isEmpty(Yr)) {
            RxExecutor.post(null, EventThread.IO, new Runnable() { // from class: tv.chushou.zues.utils.h.2
                @Override // java.lang.Runnable
                public void run() {
                    Bitmap B = tv.chushou.zues.widget.fresco.a.B(str, 0, 0);
                    if (B != null) {
                        h.Q(str, B);
                        c.a(B, new File(h.Yo(str)), Bitmap.CompressFormat.PNG, 75);
                    }
                }
            });
            return null;
        }
        Drawable Yn = Yn(str);
        if (Yn == null) {
            try {
                Bitmap decodeFile = BitmapFactory.decodeFile(Yr);
                if (decodeFile != null) {
                    return Q(str, decodeFile);
                }
                return Yn;
            } catch (Exception e) {
                return Yn;
            }
        }
        return Yn;
    }

    public static void Yq(String str) {
        Bitmap decodeFile;
        if (!isEmpty(str)) {
            String Yr = Yr(str);
            if (isEmpty(Yr)) {
                Bitmap B = tv.chushou.zues.widget.fresco.a.B(str, 0, 0);
                if (B != null) {
                    Q(str, B);
                    c.a(B, new File(Yo(str)), Bitmap.CompressFormat.PNG, 75);
                    return;
                }
                return;
            }
            File file = new File(Yr);
            if (file.exists() && file.isFile() && (decodeFile = BitmapFactory.decodeFile(Yr)) != null) {
                Q(str, decodeFile);
            }
        }
    }

    private static String Yr(String str) {
        if (isEmpty(str)) {
            return "";
        }
        String Yo = Yo(str);
        File file = new File(Yo);
        if (!file.isFile() || !file.exists()) {
            e.d("Utils", "image( " + str + " ): not exists");
            return "";
        }
        return Yo;
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
                pmu = field;
            }
        } catch (Exception e3) {
            field = null;
            e = e3;
        }
        pmu = field;
    }
}
