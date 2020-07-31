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
    private static volatile Resources osB;
    private static volatile File otk;
    private static tv.chushou.zues.toolkit.a.b.a<Drawable> otl;
    private static final Field otm;
    private static volatile Application sApplication;

    public static void a(Context context, File file, Resources resources) {
        sApplication = (Application) context;
        otk = file;
        osB = resources;
    }

    @SuppressLint({"PrivateApi"})
    public static Application dZE() {
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

    public static Resources eai() {
        return osB;
    }

    public static boolean isEmpty(String str) {
        return str == null || str.isEmpty() || str.equals("null");
    }

    public static boolean isEmpty(Collection<?> collection) {
        return collection == null || collection.isEmpty();
    }

    public static boolean ab(JSONArray jSONArray) {
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

    public static int bR(String str, int i) {
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

    public static long N(String str, long j) {
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

    public static void eaj() {
        if (otl != null) {
            otl.clear();
            otl = null;
        }
    }

    @Nullable
    public static Drawable TU(String str) {
        if (otl != null) {
            return otl.get(str);
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
                    bitmapDrawable = new BitmapDrawable(eai(), (Bitmap) obj);
                }
                if (bitmapDrawable != null) {
                    if (otl == null) {
                        otl = new tv.chushou.zues.toolkit.a.b.a<>(15, new tv.chushou.zues.toolkit.a.b.b<Drawable>() { // from class: tv.chushou.zues.utils.h.1
                            /* JADX DEBUG: Method merged with bridge method */
                            @Override // tv.chushou.zues.toolkit.a.b.b
                            /* renamed from: b */
                            public int L(String str2, Drawable drawable) {
                                return 1;
                            }
                        });
                    }
                    otl.put(str, bitmapDrawable);
                }
            } catch (Exception e) {
            }
        }
        return bitmapDrawable;
    }

    public static String TV(String str) {
        if (isEmpty(str)) {
            return "";
        }
        File file = otk;
        if (file == null) {
            file = dZE().getCacheDir();
        }
        return file.getAbsolutePath() + File.separator + tv.chushou.a.a.d.b.encrypt(str);
    }

    @Nullable
    public static Drawable TW(final String str) {
        if (isEmpty(str)) {
            return null;
        }
        String TY = TY(str);
        if (isEmpty(TY)) {
            RxExecutor.post(null, EventThread.IO, new Runnable() { // from class: tv.chushou.zues.utils.h.2
                @Override // java.lang.Runnable
                public void run() {
                    Bitmap B = tv.chushou.zues.widget.fresco.a.B(str, 0, 0);
                    if (B != null) {
                        h.Q(str, B);
                        c.a(B, new File(h.TV(str)), Bitmap.CompressFormat.PNG, 75);
                    }
                }
            });
            return null;
        }
        Drawable TU = TU(str);
        if (TU == null) {
            try {
                Bitmap decodeFile = BitmapFactory.decodeFile(TY);
                if (decodeFile != null) {
                    return Q(str, decodeFile);
                }
                return TU;
            } catch (Exception e) {
                return TU;
            }
        }
        return TU;
    }

    public static void TX(String str) {
        Bitmap decodeFile;
        if (!isEmpty(str)) {
            String TY = TY(str);
            if (isEmpty(TY)) {
                Bitmap B = tv.chushou.zues.widget.fresco.a.B(str, 0, 0);
                if (B != null) {
                    Q(str, B);
                    c.a(B, new File(TV(str)), Bitmap.CompressFormat.PNG, 75);
                    return;
                }
                return;
            }
            File file = new File(TY);
            if (file.exists() && file.isFile() && (decodeFile = BitmapFactory.decodeFile(TY)) != null) {
                Q(str, decodeFile);
            }
        }
    }

    private static String TY(String str) {
        if (isEmpty(str)) {
            return "";
        }
        String TV = TV(str);
        File file = new File(TV);
        if (!file.isFile() || !file.exists()) {
            e.d("Utils", "image( " + str + " ): not exists");
            return "";
        }
        return TV;
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
                otm = field;
            }
        } catch (Exception e3) {
            field = null;
            e = e3;
        }
        otm = field;
    }
}
