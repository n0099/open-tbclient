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
/* loaded from: classes5.dex */
public class h {
    private static volatile Resources nrU;
    private static volatile File nsE;
    private static tv.chushou.zues.toolkit.a.b.a<Drawable> nsF;
    private static final Field nsG;
    private static volatile Application sApplication;

    public static void a(Context context, File file, Resources resources) {
        sApplication = (Application) context;
        nsE = file;
        nrU = resources;
    }

    @SuppressLint({"PrivateApi"})
    public static Application dJt() {
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

    public static Resources dJX() {
        return nrU;
    }

    public static boolean isEmpty(String str) {
        return str == null || str.isEmpty() || str.equals("null");
    }

    public static boolean isEmpty(Collection<?> collection) {
        return collection == null || collection.isEmpty();
    }

    public static boolean aa(JSONArray jSONArray) {
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

    public static int bT(String str, int i) {
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

    public static long P(String str, long j) {
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

    public static void dJY() {
        if (nsF != null) {
            nsF.clear();
            nsF = null;
        }
    }

    @Nullable
    public static Drawable Qm(String str) {
        if (nsF != null) {
            return nsF.get(str);
        }
        return null;
    }

    @Nullable
    public static Drawable N(String str, Object obj) {
        BitmapDrawable bitmapDrawable = null;
        if (obj != null) {
            try {
                if (obj instanceof Drawable) {
                    bitmapDrawable = (Drawable) obj;
                } else if (obj instanceof Bitmap) {
                    bitmapDrawable = new BitmapDrawable(dJX(), (Bitmap) obj);
                }
                if (bitmapDrawable != null) {
                    if (nsF == null) {
                        nsF = new tv.chushou.zues.toolkit.a.b.a<>(15, new tv.chushou.zues.toolkit.a.b.b<Drawable>() { // from class: tv.chushou.zues.utils.h.1
                            /* JADX DEBUG: Method merged with bridge method */
                            @Override // tv.chushou.zues.toolkit.a.b.b
                            /* renamed from: b */
                            public int I(String str2, Drawable drawable) {
                                return 1;
                            }
                        });
                    }
                    nsF.put(str, bitmapDrawable);
                }
            } catch (Exception e) {
            }
        }
        return bitmapDrawable;
    }

    public static String Qn(String str) {
        if (isEmpty(str)) {
            return "";
        }
        File file = nsE;
        if (file == null) {
            file = dJt().getCacheDir();
        }
        return file.getAbsolutePath() + File.separator + tv.chushou.a.a.d.b.encrypt(str);
    }

    @Nullable
    public static Drawable Qo(final String str) {
        if (isEmpty(str)) {
            return null;
        }
        String Qq = Qq(str);
        if (isEmpty(Qq)) {
            RxExecutor.post(null, EventThread.IO, new Runnable() { // from class: tv.chushou.zues.utils.h.2
                @Override // java.lang.Runnable
                public void run() {
                    Bitmap A = tv.chushou.zues.widget.fresco.a.A(str, 0, 0);
                    if (A != null) {
                        h.N(str, A);
                        c.a(A, new File(h.Qn(str)), Bitmap.CompressFormat.PNG, 75);
                    }
                }
            });
            return null;
        }
        Drawable Qm = Qm(str);
        if (Qm == null) {
            try {
                Bitmap decodeFile = BitmapFactory.decodeFile(Qq);
                if (decodeFile != null) {
                    return N(str, decodeFile);
                }
                return Qm;
            } catch (Exception e) {
                return Qm;
            }
        }
        return Qm;
    }

    public static void Qp(String str) {
        Bitmap decodeFile;
        if (!isEmpty(str)) {
            String Qq = Qq(str);
            if (isEmpty(Qq)) {
                Bitmap A = tv.chushou.zues.widget.fresco.a.A(str, 0, 0);
                if (A != null) {
                    N(str, A);
                    c.a(A, new File(Qn(str)), Bitmap.CompressFormat.PNG, 75);
                    return;
                }
                return;
            }
            File file = new File(Qq);
            if (file.exists() && file.isFile() && (decodeFile = BitmapFactory.decodeFile(Qq)) != null) {
                N(str, decodeFile);
            }
        }
    }

    private static String Qq(String str) {
        if (isEmpty(str)) {
            return "";
        }
        String Qn = Qn(str);
        File file = new File(Qn);
        if (!file.isFile() || !file.exists()) {
            e.d("Utils", "image( " + str + " ): not exists");
            return "";
        }
        return Qn;
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
                nsG = field;
            }
        } catch (Exception e3) {
            field = null;
            e = e3;
        }
        nsG = field;
    }
}
