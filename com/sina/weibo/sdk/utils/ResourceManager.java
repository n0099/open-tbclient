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
import androidx.core.view.InputDeviceCompat;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptable;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptorStorage;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import java.io.DataInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.util.Locale;
/* loaded from: classes3.dex */
public class ResourceManager {
    public static /* synthetic */ Interceptable $ic = null;
    public static final String DRAWABLE = "drawable";
    public static final String DRAWABLE_HDPI = "drawable-hdpi";
    public static final String DRAWABLE_LDPI = "drawable-ldpi";
    public static final String DRAWABLE_MDPI = "drawable-mdpi";
    public static final String DRAWABLE_XHDPI = "drawable-xhdpi";
    public static final String DRAWABLE_XXHDPI = "drawable-xxhdpi";
    public static final String[] PRE_INSTALL_DRAWBLE_PATHS;
    public static final String TAG = "com.sina.weibo.sdk.utils.ResourceManager";
    public transient /* synthetic */ FieldHolder $fh;

    static {
        InterceptResult invokeClinit;
        ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
        if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(1121698562, "Lcom/sina/weibo/sdk/utils/ResourceManager;")) != null) {
            Interceptable interceptable = invokeClinit.interceptor;
            if (interceptable != null) {
                $ic = interceptable;
            }
            if ((invokeClinit.flags & 1) != 0) {
                classClinitInterceptable.invokePostClinit(1121698562, "Lcom/sina/weibo/sdk/utils/ResourceManager;");
                return;
            }
        }
        PRE_INSTALL_DRAWBLE_PATHS = new String[]{DRAWABLE_XXHDPI, DRAWABLE_XHDPI, DRAWABLE_HDPI, DRAWABLE_MDPI, DRAWABLE_LDPI, "drawable"};
    }

    public ResourceManager() {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            interceptable.invokeUnInit(65537, newInitContext);
            int i2 = newInitContext.flag;
            if ((i2 & 1) != 0) {
                int i3 = i2 & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65537, newInitContext);
            }
        }
    }

    public static ColorStateList createColorStateList(int i2, int i3) {
        InterceptResult invokeII;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeII = interceptable.invokeII(65538, null, i2, i3)) == null) ? new ColorStateList(new int[][]{new int[]{16842919}, new int[]{16842913}, new int[]{16842908}, StateSet.WILD_CARD}, new int[]{i3, i3, i3, i2}) : (ColorStateList) invokeII.objValue;
    }

    public static StateListDrawable createStateListDrawable(Context context, String str, String str2) {
        InterceptResult invokeLLL;
        Drawable drawable;
        Drawable drawable2;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLLL = interceptable.invokeLLL(65539, null, context, str, str2)) == null) {
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
        return (StateListDrawable) invokeLLL.objValue;
    }

    public static int dp2px(Context context, int i2) {
        InterceptResult invokeLI;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeLI = interceptable.invokeLI(65541, null, context, i2)) == null) ? (int) ((i2 * context.getResources().getDisplayMetrics().density) + 0.5d) : invokeLI.intValue;
    }

    public static Drawable extractDrawable(Context context, String str) throws Exception {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(65542, null, context, str)) == null) {
            InputStream open = context.getAssets().open(str);
            DisplayMetrics displayMetrics = context.getResources().getDisplayMetrics();
            TypedValue typedValue = new TypedValue();
            typedValue.density = displayMetrics.densityDpi;
            Drawable createFromResourceStream = Drawable.createFromResourceStream(context.getResources(), typedValue, open, str);
            open.close();
            return createFromResourceStream;
        }
        return (Drawable) invokeLL.objValue;
    }

    public static View extractView(Context context, String str, ViewGroup viewGroup) throws Exception {
        InterceptResult invokeLLL;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeLLL = interceptable.invokeLLL(65543, null, context, str, viewGroup)) == null) ? ((LayoutInflater) context.getSystemService("layout_inflater")).inflate(context.getAssets().openXmlResourceParser(str), viewGroup) : (View) invokeLLL.objValue;
    }

    /* JADX WARN: Code restructure failed: missing block: B:26:0x0069, code lost:
        if (java.lang.Math.abs(r4 - r2) <= java.lang.Math.abs(r4 - r5)) goto L33;
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public static String getAppropriatePathOfDrawable(Context context, String str) {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(65544, null, context, str)) == null) {
            if (TextUtils.isEmpty(str)) {
                LogUtil.e(TAG, "id is NOT correct!");
                return null;
            }
            String currentDpiFolder = getCurrentDpiFolder(context);
            LogUtil.d(TAG, "find Appropriate path...");
            int i2 = 0;
            int i3 = -1;
            int i4 = -1;
            int i5 = -1;
            while (true) {
                String[] strArr = PRE_INSTALL_DRAWBLE_PATHS;
                if (i2 >= strArr.length) {
                    i2 = -1;
                    break;
                }
                if (strArr[i2].equals(currentDpiFolder)) {
                    i4 = i2;
                }
                String str2 = PRE_INSTALL_DRAWBLE_PATHS[i2] + "/" + str;
                if (isFileExisted(context, str2)) {
                    if (i4 != i2) {
                        if (i4 >= 0) {
                            break;
                        }
                        i5 = i2;
                    } else {
                        return str2;
                    }
                }
                i2++;
            }
            if (i5 <= 0 || i2 <= 0) {
                if (i5 <= 0 || i2 >= 0) {
                    if (i5 >= 0 || i2 <= 0) {
                        LogUtil.e(TAG, "Not find the appropriate path for drawable");
                    }
                    i3 = i2;
                }
                i3 = i5;
            }
            if (i3 < 0) {
                LogUtil.e(TAG, "Not find the appropriate path for drawable");
                return null;
            }
            return PRE_INSTALL_DRAWBLE_PATHS[i3] + "/" + str;
        }
        return (String) invokeLL.objValue;
    }

    public static String getCurrentDpiFolder(Context context) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65545, null, context)) == null) {
            int i2 = context.getResources().getDisplayMetrics().densityDpi;
            return i2 <= 120 ? DRAWABLE_LDPI : (i2 <= 120 || i2 > 160) ? (i2 <= 160 || i2 > 240) ? (i2 <= 240 || i2 > 320) ? DRAWABLE_XXHDPI : DRAWABLE_XHDPI : DRAWABLE_HDPI : DRAWABLE_MDPI;
        }
        return (String) invokeL.objValue;
    }

    public static Drawable getDrawable(Context context, String str) {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeLL = interceptable.invokeLL(65546, null, context, str)) == null) ? getDrawableFromAssert(context, getAppropriatePathOfDrawable(context, str), false) : (Drawable) invokeLL.objValue;
    }

    /* JADX WARN: Removed duplicated region for block: B:42:0x006f A[EXC_TOP_SPLITTER, SYNTHETIC] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public static Drawable getDrawableFromAssert(Context context, String str, boolean z) {
        InterceptResult invokeLLZ;
        InputStream inputStream;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLLZ = interceptable.invokeLLZ(65547, null, context, str, z)) == null) {
            NinePatchDrawable ninePatchDrawable = null;
            ninePatchDrawable = null;
            ninePatchDrawable = null;
            ninePatchDrawable = null;
            InputStream inputStream2 = null;
            try {
                try {
                    inputStream = context.getAssets().open(str);
                    if (inputStream != null) {
                        try {
                            try {
                                Bitmap decodeStream = BitmapFactory.decodeStream(inputStream);
                                DisplayMetrics displayMetrics = context.getResources().getDisplayMetrics();
                                if (z) {
                                    ninePatchDrawable = new NinePatchDrawable(new Resources(context.getAssets(), displayMetrics, context.getResources().getConfiguration()), decodeStream, decodeStream.getNinePatchChunk(), new Rect(0, 0, 0, 0), null);
                                } else {
                                    decodeStream.setDensity(displayMetrics.densityDpi);
                                    ninePatchDrawable = new BitmapDrawable(context.getResources(), decodeStream);
                                }
                            } catch (IOException e2) {
                                e = e2;
                                e.printStackTrace();
                                if (inputStream != null) {
                                    inputStream.close();
                                }
                                return ninePatchDrawable;
                            }
                        } catch (Throwable th) {
                            th = th;
                            inputStream2 = inputStream;
                            if (inputStream2 != null) {
                                try {
                                    inputStream2.close();
                                } catch (IOException e3) {
                                    e3.printStackTrace();
                                }
                            }
                            throw th;
                        }
                    }
                } catch (IOException e4) {
                    e4.printStackTrace();
                }
            } catch (IOException e5) {
                e = e5;
                inputStream = null;
            } catch (Throwable th2) {
                th = th2;
                if (inputStream2 != null) {
                }
                throw th;
            }
            if (inputStream != null) {
                inputStream.close();
            }
            return ninePatchDrawable;
        }
        return (Drawable) invokeLLZ.objValue;
    }

    public static Locale getLanguage() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(65548, null)) == null) {
            Locale locale = Locale.getDefault();
            return (Locale.SIMPLIFIED_CHINESE.equals(locale) || Locale.TRADITIONAL_CHINESE.equals(locale)) ? locale : (locale.getLanguage().equals("zh") && (locale.getCountry().contains("CN") || locale.getCountry().contains("TW"))) ? locale : Locale.ENGLISH;
        }
        return (Locale) invokeV.objValue;
    }

    public static Drawable getNinePatchDrawable(Context context, String str) {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeLL = interceptable.invokeLL(65549, null, context, str)) == null) ? getDrawableFromAssert(context, getAppropriatePathOfDrawable(context, str), true) : (Drawable) invokeLL.objValue;
    }

    public static String getString(Context context, String str, String str2, String str3) {
        InterceptResult invokeLLLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLLLL = interceptable.invokeLLLL(65550, null, context, str, str2, str3)) == null) {
            Locale language = getLanguage();
            return (Locale.SIMPLIFIED_CHINESE.equals(language) || ("zh".equals(language.getLanguage()) && language.getCountry().contains("CN"))) ? str2 : (Locale.TRADITIONAL_CHINESE.equals(language) || ("zh".equals(language.getLanguage()) && language.getCountry().contains("TW"))) ? str3 : str;
        }
        return (String) invokeLLLL.objValue;
    }

    /* JADX DEBUG: Another duplicated slice has different insns count: {[IF]}, finally: {[IF, INVOKE, MOVE_EXCEPTION, INVOKE, INVOKE, MOVE_EXCEPTION] complete} */
    public static boolean isFileExisted(Context context, String str) {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(65551, null, context, str)) == null) {
            if (context == null || TextUtils.isEmpty(str)) {
                return false;
            }
            InputStream inputStream = null;
            try {
                try {
                    inputStream = context.getAssets().open(str);
                    String str2 = TAG;
                    LogUtil.d(str2, "file [" + str + "] existed");
                    if (inputStream != null) {
                        try {
                            inputStream.close();
                        } catch (IOException e2) {
                            e2.printStackTrace();
                        }
                    }
                    return true;
                } catch (IOException unused) {
                    String str3 = TAG;
                    LogUtil.d(str3, "file [" + str + "] NOT existed");
                    if (inputStream != null) {
                        try {
                            inputStream.close();
                        } catch (IOException e3) {
                            e3.printStackTrace();
                        }
                    }
                    return false;
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
        return invokeLL.booleanValue;
    }

    public static String readCountryFromAsset(Context context, String str) {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        if (interceptable != null && (invokeLL = interceptable.invokeLL(65552, null, context, str)) != null) {
            return (String) invokeLL.objValue;
        }
        String str2 = "";
        try {
            InputStream open = context.getAssets().open(str);
            if (open != null) {
                DataInputStream dataInputStream = new DataInputStream(open);
                byte[] bArr = new byte[dataInputStream.available()];
                dataInputStream.read(bArr);
                String str3 = new String(bArr, "UTF-8");
                try {
                    open.close();
                    return str3;
                } catch (IOException e2) {
                    e = e2;
                    str2 = str3;
                    e.printStackTrace();
                    return str2;
                }
            }
            return "";
        } catch (IOException e3) {
            e = e3;
        }
    }

    public static StateListDrawable createStateListDrawable(Context context, String str, String str2, String str3) {
        InterceptResult invokeLLLL;
        Drawable drawable;
        Drawable drawable2;
        Drawable drawable3;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLLLL = interceptable.invokeLLLL(InputDeviceCompat.SOURCE_TRACKBALL, null, context, str, str2, str3)) == null) {
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
        return (StateListDrawable) invokeLLLL.objValue;
    }
}
