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
    private static volatile Resources qmt;
    private static volatile File qnc;
    private static tv.chushou.zues.toolkit.a.b.a<Drawable> qnd;
    private static final Field qne;
    private static volatile Application sApplication;

    public static void a(Context context, File file, Resources resources) {
        sApplication = (Application) context;
        qnc = file;
        qmt = resources;
    }

    @SuppressLint({"PrivateApi"})
    public static Application eHo() {
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

    public static Resources eHR() {
        return qmt;
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

    public static int cd(String str, int i) {
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

    public static long T(String str, long j) {
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

    public static void eHS() {
        if (qnd != null) {
            qnd.clear();
            qnd = null;
        }
    }

    @Nullable
    public static Drawable aaE(String str) {
        if (qnd != null) {
            return qnd.get(str);
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
                    bitmapDrawable = new BitmapDrawable(eHR(), (Bitmap) obj);
                }
                if (bitmapDrawable != null) {
                    if (qnd == null) {
                        qnd = new tv.chushou.zues.toolkit.a.b.a<>(15, new tv.chushou.zues.toolkit.a.b.b<Drawable>() { // from class: tv.chushou.zues.utils.h.1
                            /* JADX DEBUG: Method merged with bridge method */
                            @Override // tv.chushou.zues.toolkit.a.b.b
                            /* renamed from: b */
                            public int L(String str2, Drawable drawable) {
                                return 1;
                            }
                        });
                    }
                    qnd.put(str, bitmapDrawable);
                }
            } catch (Exception e) {
            }
        }
        return bitmapDrawable;
    }

    public static String aaF(String str) {
        if (isEmpty(str)) {
            return "";
        }
        File file = qnc;
        if (file == null) {
            file = eHo().getCacheDir();
        }
        return file.getAbsolutePath() + File.separator + tv.chushou.a.a.d.b.encrypt(str);
    }

    @Nullable
    public static Drawable aaG(final String str) {
        if (isEmpty(str)) {
            return null;
        }
        String aaI = aaI(str);
        if (isEmpty(aaI)) {
            RxExecutor.post(null, EventThread.IO, new Runnable() { // from class: tv.chushou.zues.utils.h.2
                @Override // java.lang.Runnable
                public void run() {
                    Bitmap C = tv.chushou.zues.widget.fresco.a.C(str, 0, 0);
                    if (C != null) {
                        h.Q(str, C);
                        c.a(C, new File(h.aaF(str)), Bitmap.CompressFormat.PNG, 75);
                    }
                }
            });
            return null;
        }
        Drawable aaE = aaE(str);
        if (aaE == null) {
            try {
                Bitmap decodeFile = BitmapFactory.decodeFile(aaI);
                if (decodeFile != null) {
                    return Q(str, decodeFile);
                }
                return aaE;
            } catch (Exception e) {
                return aaE;
            }
        }
        return aaE;
    }

    public static void aaH(String str) {
        Bitmap decodeFile;
        if (!isEmpty(str)) {
            String aaI = aaI(str);
            if (isEmpty(aaI)) {
                Bitmap C = tv.chushou.zues.widget.fresco.a.C(str, 0, 0);
                if (C != null) {
                    Q(str, C);
                    c.a(C, new File(aaF(str)), Bitmap.CompressFormat.PNG, 75);
                    return;
                }
                return;
            }
            File file = new File(aaI);
            if (file.exists() && file.isFile() && (decodeFile = BitmapFactory.decodeFile(aaI)) != null) {
                Q(str, decodeFile);
            }
        }
    }

    private static String aaI(String str) {
        if (isEmpty(str)) {
            return "";
        }
        String aaF = aaF(str);
        File file = new File(aaF);
        if (!file.isFile() || !file.exists()) {
            e.d("Utils", "image( " + str + " ): not exists");
            return "";
        }
        return aaF;
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
                qne = field;
            }
        } catch (Exception e3) {
            field = null;
            e = e3;
        }
        qne = field;
    }
}
