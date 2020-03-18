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
    private static volatile File nYM;
    private static tv.chushou.zues.toolkit.a.b.a<Drawable> nYN;
    private static final Field nYO;
    private static volatile Resources nYg;
    private static volatile Application sApplication;

    public static void a(Context context, File file, Resources resources) {
        sApplication = (Application) context;
        nYM = file;
        nYg = resources;
    }

    @SuppressLint({"PrivateApi"})
    public static Application dQu() {
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

    public static Resources dQV() {
        return nYg;
    }

    public static boolean isEmpty(String str) {
        return str == null || str.isEmpty() || str.equals("null");
    }

    public static boolean isEmpty(Collection<?> collection) {
        return collection == null || collection.isEmpty();
    }

    public static boolean Z(JSONArray jSONArray) {
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

    public static void dQW() {
        if (nYN != null) {
            nYN.clear();
            nYN = null;
        }
    }

    @Nullable
    public static Drawable SW(String str) {
        if (nYN != null) {
            return nYN.get(str);
        }
        return null;
    }

    @Nullable
    public static Drawable J(String str, Object obj) {
        BitmapDrawable bitmapDrawable = null;
        if (obj != null) {
            try {
                if (obj instanceof Drawable) {
                    bitmapDrawable = (Drawable) obj;
                } else if (obj instanceof Bitmap) {
                    bitmapDrawable = new BitmapDrawable(dQV(), (Bitmap) obj);
                }
                if (bitmapDrawable != null) {
                    if (nYN == null) {
                        nYN = new tv.chushou.zues.toolkit.a.b.a<>(15, new tv.chushou.zues.toolkit.a.b.b<Drawable>() { // from class: tv.chushou.zues.utils.h.1
                            /* JADX DEBUG: Method merged with bridge method */
                            @Override // tv.chushou.zues.toolkit.a.b.b
                            /* renamed from: b */
                            public int E(String str2, Drawable drawable) {
                                return 1;
                            }
                        });
                    }
                    nYN.put(str, bitmapDrawable);
                }
            } catch (Exception e) {
            }
        }
        return bitmapDrawable;
    }

    public static String SX(String str) {
        if (isEmpty(str)) {
            return "";
        }
        File file = nYM;
        if (file == null) {
            file = dQu().getCacheDir();
        }
        return file.getAbsolutePath() + File.separator + tv.chushou.a.a.d.b.encrypt(str);
    }

    @Nullable
    public static Drawable SY(final String str) {
        if (isEmpty(str)) {
            return null;
        }
        String Ta = Ta(str);
        if (isEmpty(Ta)) {
            RxExecutor.post(null, EventThread.IO, new Runnable() { // from class: tv.chushou.zues.utils.h.2
                @Override // java.lang.Runnable
                public void run() {
                    Bitmap H = tv.chushou.zues.widget.fresco.a.H(str, 0, 0);
                    if (H != null) {
                        h.J(str, H);
                        c.a(H, new File(h.SX(str)), Bitmap.CompressFormat.PNG, 75);
                    }
                }
            });
            return null;
        }
        Drawable SW = SW(str);
        if (SW == null) {
            try {
                Bitmap decodeFile = BitmapFactory.decodeFile(Ta);
                if (decodeFile != null) {
                    return J(str, decodeFile);
                }
                return SW;
            } catch (Exception e) {
                return SW;
            }
        }
        return SW;
    }

    public static void SZ(String str) {
        Bitmap decodeFile;
        if (!isEmpty(str)) {
            String Ta = Ta(str);
            if (isEmpty(Ta)) {
                Bitmap H = tv.chushou.zues.widget.fresco.a.H(str, 0, 0);
                if (H != null) {
                    J(str, H);
                    c.a(H, new File(SX(str)), Bitmap.CompressFormat.PNG, 75);
                    return;
                }
                return;
            }
            File file = new File(Ta);
            if (file.exists() && file.isFile() && (decodeFile = BitmapFactory.decodeFile(Ta)) != null) {
                J(str, decodeFile);
            }
        }
    }

    private static String Ta(String str) {
        if (isEmpty(str)) {
            return "";
        }
        String SX = SX(str);
        File file = new File(SX);
        if (!file.isFile() || !file.exists()) {
            e.d("Utils", "image( " + str + " ): not exists");
            return "";
        }
        return SX;
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
                nYO = field;
            }
        } catch (Exception e3) {
            field = null;
            e = e3;
        }
        nYO = field;
    }
}
