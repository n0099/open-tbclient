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
    private static volatile Resources oMN;
    private static volatile File oNw;
    private static tv.chushou.zues.toolkit.a.b.a<Drawable> oNx;
    private static final Field oNy;
    private static volatile Application sApplication;

    public static void a(Context context, File file, Resources resources) {
        sApplication = (Application) context;
        oNw = file;
        oMN = resources;
    }

    @SuppressLint({"PrivateApi"})
    public static Application elS() {
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

    public static Resources emv() {
        return oMN;
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

    public static void emw() {
        if (oNx != null) {
            oNx.clear();
            oNx = null;
        }
    }

    @Nullable
    public static Drawable WY(String str) {
        if (oNx != null) {
            return oNx.get(str);
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
                    bitmapDrawable = new BitmapDrawable(emv(), (Bitmap) obj);
                }
                if (bitmapDrawable != null) {
                    if (oNx == null) {
                        oNx = new tv.chushou.zues.toolkit.a.b.a<>(15, new tv.chushou.zues.toolkit.a.b.b<Drawable>() { // from class: tv.chushou.zues.utils.h.1
                            /* JADX DEBUG: Method merged with bridge method */
                            @Override // tv.chushou.zues.toolkit.a.b.b
                            /* renamed from: b */
                            public int K(String str2, Drawable drawable) {
                                return 1;
                            }
                        });
                    }
                    oNx.put(str, bitmapDrawable);
                }
            } catch (Exception e) {
            }
        }
        return bitmapDrawable;
    }

    public static String WZ(String str) {
        if (isEmpty(str)) {
            return "";
        }
        File file = oNw;
        if (file == null) {
            file = elS().getCacheDir();
        }
        return file.getAbsolutePath() + File.separator + tv.chushou.a.a.d.b.encrypt(str);
    }

    @Nullable
    public static Drawable Xa(final String str) {
        if (isEmpty(str)) {
            return null;
        }
        String Xc = Xc(str);
        if (isEmpty(Xc)) {
            RxExecutor.post(null, EventThread.IO, new Runnable() { // from class: tv.chushou.zues.utils.h.2
                @Override // java.lang.Runnable
                public void run() {
                    Bitmap A = tv.chushou.zues.widget.fresco.a.A(str, 0, 0);
                    if (A != null) {
                        h.P(str, A);
                        c.a(A, new File(h.WZ(str)), Bitmap.CompressFormat.PNG, 75);
                    }
                }
            });
            return null;
        }
        Drawable WY = WY(str);
        if (WY == null) {
            try {
                Bitmap decodeFile = BitmapFactory.decodeFile(Xc);
                if (decodeFile != null) {
                    return P(str, decodeFile);
                }
                return WY;
            } catch (Exception e) {
                return WY;
            }
        }
        return WY;
    }

    public static void Xb(String str) {
        Bitmap decodeFile;
        if (!isEmpty(str)) {
            String Xc = Xc(str);
            if (isEmpty(Xc)) {
                Bitmap A = tv.chushou.zues.widget.fresco.a.A(str, 0, 0);
                if (A != null) {
                    P(str, A);
                    c.a(A, new File(WZ(str)), Bitmap.CompressFormat.PNG, 75);
                    return;
                }
                return;
            }
            File file = new File(Xc);
            if (file.exists() && file.isFile() && (decodeFile = BitmapFactory.decodeFile(Xc)) != null) {
                P(str, decodeFile);
            }
        }
    }

    private static String Xc(String str) {
        if (isEmpty(str)) {
            return "";
        }
        String WZ = WZ(str);
        File file = new File(WZ);
        if (!file.isFile() || !file.exists()) {
            e.d("Utils", "image( " + str + " ): not exists");
            return "";
        }
        return WZ;
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
                oNy = field;
            }
        } catch (Exception e3) {
            field = null;
            e = e3;
        }
        oNy = field;
    }
}
