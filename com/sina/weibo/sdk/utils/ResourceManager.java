package com.sina.weibo.sdk.utils;

import android.content.Context;
import android.content.res.ColorStateList;
import android.content.res.Resources;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.Rect;
import android.graphics.drawable.BitmapDrawable;
import android.graphics.drawable.Drawable;
import android.graphics.drawable.NinePatchDrawable;
import android.graphics.drawable.StateListDrawable;
import android.text.TextUtils;
import android.util.DisplayMetrics;
import android.util.StateSet;
import android.util.TypedValue;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import java.io.DataInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.util.Locale;
/* loaded from: classes4.dex */
public class ResourceManager {
    private static final String TAG = ResourceManager.class.getName();
    private static final String DRAWABLE_XXHDPI = "drawable-xxhdpi";
    private static final String DRAWABLE_XHDPI = "drawable-xhdpi";
    private static final String DRAWABLE_HDPI = "drawable-hdpi";
    private static final String DRAWABLE_MDPI = "drawable-mdpi";
    private static final String DRAWABLE_LDPI = "drawable-ldpi";
    private static final String DRAWABLE = "drawable";
    private static final String[] PRE_INSTALL_DRAWBLE_PATHS = {DRAWABLE_XXHDPI, DRAWABLE_XHDPI, DRAWABLE_HDPI, DRAWABLE_MDPI, DRAWABLE_LDPI, DRAWABLE};

    public static String getString(Context context, String str, String str2, String str3) {
        Locale language = getLanguage();
        return (Locale.SIMPLIFIED_CHINESE.equals(language) || ("zh".equals(language.getLanguage()) && language.getCountry().contains("CN"))) ? str2 : (Locale.TRADITIONAL_CHINESE.equals(language) || ("zh".equals(language.getLanguage()) && language.getCountry().contains("TW"))) ? str3 : str;
    }

    public static Drawable getDrawable(Context context, String str) {
        return getDrawableFromAssert(context, getAppropriatePathOfDrawable(context, str), false);
    }

    public static Drawable getNinePatchDrawable(Context context, String str) {
        return getDrawableFromAssert(context, getAppropriatePathOfDrawable(context, str), true);
    }

    public static Locale getLanguage() {
        Locale locale = Locale.getDefault();
        if (Locale.SIMPLIFIED_CHINESE.equals(locale) || Locale.TRADITIONAL_CHINESE.equals(locale)) {
            return locale;
        }
        return (locale.getLanguage().equals("zh") && (locale.getCountry().contains("CN") || locale.getCountry().contains("TW"))) ? locale : Locale.ENGLISH;
    }

    private static String getAppropriatePathOfDrawable(Context context, String str) {
        if (TextUtils.isEmpty(str)) {
            LogUtil.e(TAG, "id is NOT correct!");
            return null;
        }
        String currentDpiFolder = getCurrentDpiFolder(context);
        LogUtil.d(TAG, "find Appropriate path...");
        int i = 0;
        int i2 = -1;
        int i3 = -1;
        while (true) {
            if (i >= PRE_INSTALL_DRAWBLE_PATHS.length) {
                i = -1;
                break;
            }
            if (PRE_INSTALL_DRAWBLE_PATHS[i].equals(currentDpiFolder)) {
                i2 = i;
            }
            String str2 = PRE_INSTALL_DRAWBLE_PATHS[i] + "/" + str;
            if (isFileExisted(context, str2)) {
                if (i2 != i) {
                    if (i2 >= 0) {
                        break;
                    }
                    i3 = i;
                } else {
                    return str2;
                }
            }
            i++;
        }
        if (i3 > 0 && i > 0) {
            if (Math.abs(i2 - i) <= Math.abs(i2 - i3)) {
                i3 = i;
            }
        } else if (i3 <= 0 || i >= 0) {
            if (i3 >= 0 || i <= 0) {
                LogUtil.e(TAG, "Not find the appropriate path for drawable");
                i3 = -1;
            } else {
                i3 = i;
            }
        }
        if (i3 < 0) {
            LogUtil.e(TAG, "Not find the appropriate path for drawable");
            return null;
        }
        return PRE_INSTALL_DRAWBLE_PATHS[i3] + "/" + str;
    }

    /* JADX DEBUG: Don't trust debug lines info. Repeating lines: [227=4] */
    /* JADX WARN: Removed duplicated region for block: B:42:0x006c A[EXC_TOP_SPLITTER, SYNTHETIC] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    private static Drawable getDrawableFromAssert(Context context, String str, boolean z) {
        InputStream inputStream;
        InputStream inputStream2;
        Drawable bitmapDrawable;
        try {
            inputStream = context.getAssets().open(str);
            if (inputStream != null) {
                try {
                    Bitmap decodeStream = BitmapFactory.decodeStream(inputStream);
                    DisplayMetrics displayMetrics = context.getResources().getDisplayMetrics();
                    if (z) {
                        bitmapDrawable = new NinePatchDrawable(new Resources(context.getAssets(), displayMetrics, context.getResources().getConfiguration()), decodeStream, decodeStream.getNinePatchChunk(), new Rect(0, 0, 0, 0), null);
                    } else {
                        decodeStream.setDensity(displayMetrics.densityDpi);
                        bitmapDrawable = new BitmapDrawable(context.getResources(), decodeStream);
                    }
                } catch (IOException e) {
                    e = e;
                    inputStream2 = inputStream;
                    try {
                        e.printStackTrace();
                        if (inputStream2 != null) {
                            try {
                                inputStream2.close();
                            } catch (IOException e2) {
                                e2.printStackTrace();
                            }
                            return null;
                        }
                        return null;
                    } catch (Throwable th) {
                        th = th;
                        inputStream = inputStream2;
                        if (inputStream != null) {
                            try {
                                inputStream.close();
                            } catch (IOException e3) {
                                e3.printStackTrace();
                            }
                        }
                        throw th;
                    }
                } catch (Throwable th2) {
                    th = th2;
                    if (inputStream != null) {
                    }
                    throw th;
                }
            } else {
                bitmapDrawable = null;
            }
            if (inputStream != null) {
                try {
                    inputStream.close();
                    return bitmapDrawable;
                } catch (IOException e4) {
                    e4.printStackTrace();
                    return bitmapDrawable;
                }
            }
            return bitmapDrawable;
        } catch (IOException e5) {
            e = e5;
            inputStream2 = null;
        } catch (Throwable th3) {
            th = th3;
            inputStream = null;
        }
    }

    /* JADX DEBUG: Another duplicated slice has different insns count: {[IF]}, finally: {[IF, INVOKE, MOVE_EXCEPTION, INVOKE, INVOKE, MOVE_EXCEPTION] complete} */
    private static boolean isFileExisted(Context context, String str) {
        boolean z = false;
        if (context != null && !TextUtils.isEmpty(str)) {
            InputStream inputStream = null;
            try {
                try {
                    inputStream = context.getAssets().open(str);
                    LogUtil.d(TAG, "file [" + str + "] existed");
                    z = true;
                    if (inputStream != null) {
                        try {
                            inputStream.close();
                        } catch (IOException e) {
                            e.printStackTrace();
                        }
                    }
                } catch (IOException e2) {
                    LogUtil.d(TAG, "file [" + str + "] NOT existed");
                    if (inputStream != null) {
                        try {
                            inputStream.close();
                        } catch (IOException e3) {
                            e3.printStackTrace();
                        }
                    }
                }
            } catch (Throwable th) {
                if (inputStream != null) {
                    try {
                        inputStream.close();
                    } catch (IOException e4) {
                        e4.printStackTrace();
                    }
                }
                throw th;
            }
        }
        return z;
    }

    private static String getCurrentDpiFolder(Context context) {
        int i = context.getResources().getDisplayMetrics().densityDpi;
        if (i <= 120) {
            return DRAWABLE_LDPI;
        }
        if (i > 120 && i <= 160) {
            return DRAWABLE_MDPI;
        }
        if (i > 160 && i <= 240) {
            return DRAWABLE_HDPI;
        }
        if (i > 240 && i <= 320) {
            return DRAWABLE_XHDPI;
        }
        return DRAWABLE_XXHDPI;
    }

    private static View extractView(Context context, String str, ViewGroup viewGroup) throws Exception {
        return ((LayoutInflater) context.getSystemService("layout_inflater")).inflate(context.getAssets().openXmlResourceParser(str), viewGroup);
    }

    private static Drawable extractDrawable(Context context, String str) throws Exception {
        InputStream open = context.getAssets().open(str);
        DisplayMetrics displayMetrics = context.getResources().getDisplayMetrics();
        TypedValue typedValue = new TypedValue();
        typedValue.density = displayMetrics.densityDpi;
        Drawable createFromResourceStream = Drawable.createFromResourceStream(context.getResources(), typedValue, open, str);
        open.close();
        return createFromResourceStream;
    }

    public static int dp2px(Context context, int i) {
        return (int) ((context.getResources().getDisplayMetrics().density * i) + 0.5d);
    }

    public static ColorStateList createColorStateList(int i, int i2) {
        return new ColorStateList(new int[][]{new int[]{16842919}, new int[]{16842913}, new int[]{16842908}, StateSet.WILD_CARD}, new int[]{i2, i2, i2, i});
    }

    public static StateListDrawable createStateListDrawable(Context context, String str, String str2) {
        Drawable drawable;
        Drawable drawable2;
        if (str.indexOf(".9") > -1) {
            drawable = getNinePatchDrawable(context, str);
        } else {
            drawable = getDrawable(context, str);
        }
        if (str2.indexOf(".9") > -1) {
            drawable2 = getNinePatchDrawable(context, str2);
        } else {
            drawable2 = getDrawable(context, str2);
        }
        StateListDrawable stateListDrawable = new StateListDrawable();
        stateListDrawable.addState(new int[]{16842919}, drawable2);
        stateListDrawable.addState(new int[]{16842913}, drawable2);
        stateListDrawable.addState(new int[]{16842908}, drawable2);
        stateListDrawable.addState(StateSet.WILD_CARD, drawable);
        return stateListDrawable;
    }

    public static StateListDrawable createStateListDrawable(Context context, String str, String str2, String str3) {
        Drawable drawable;
        Drawable drawable2;
        Drawable drawable3;
        if (str.indexOf(".9") > -1) {
            drawable = getNinePatchDrawable(context, str);
        } else {
            drawable = getDrawable(context, str);
        }
        if (str3.indexOf(".9") > -1) {
            drawable2 = getNinePatchDrawable(context, str3);
        } else {
            drawable2 = getDrawable(context, str3);
        }
        if (str2.indexOf(".9") > -1) {
            drawable3 = getNinePatchDrawable(context, str2);
        } else {
            drawable3 = getDrawable(context, str2);
        }
        StateListDrawable stateListDrawable = new StateListDrawable();
        stateListDrawable.addState(new int[]{16842919}, drawable3);
        stateListDrawable.addState(new int[]{16842913}, drawable3);
        stateListDrawable.addState(new int[]{16842908}, drawable3);
        stateListDrawable.addState(new int[]{16842766}, drawable2);
        stateListDrawable.addState(StateSet.WILD_CARD, drawable);
        return stateListDrawable;
    }

    public static String readCountryFromAsset(Context context, String str) {
        String str2;
        IOException e;
        try {
            InputStream open = context.getAssets().open(str);
            if (open == null) {
                return "";
            }
            DataInputStream dataInputStream = new DataInputStream(open);
            byte[] bArr = new byte[dataInputStream.available()];
            dataInputStream.read(bArr);
            str2 = new String(bArr, "UTF-8");
            try {
                open.close();
                return str2;
            } catch (IOException e2) {
                e = e2;
                e.printStackTrace();
                return str2;
            }
        } catch (IOException e3) {
            str2 = "";
            e = e3;
        }
    }
}
