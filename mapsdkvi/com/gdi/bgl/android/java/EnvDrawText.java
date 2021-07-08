package mapsdkvi.com.gdi.bgl.android.java;

import android.graphics.Bitmap;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.Typeface;
import android.text.Layout;
import android.text.TextPaint;
import android.util.SparseArray;
import androidx.core.view.InputDeviceCompat;
import com.baidu.mapapi.common.SysOSUtil;
import com.baidu.mobads.container.util.AdIconUtil;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptable;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptorStorage;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import java.nio.IntBuffer;
/* loaded from: classes9.dex */
public class EnvDrawText {
    public static /* synthetic */ Interceptable $ic = null;

    /* renamed from: a  reason: collision with root package name */
    public static final String f73075a = "EnvDrawText";
    public static boolean bBmpChange;
    public static Bitmap bmp;
    public static int[] buffer;
    public static SparseArray<a> fontCache;
    public transient /* synthetic */ FieldHolder $fh;

    static {
        InterceptResult invokeClinit;
        ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
        if (classClinitInterceptable == null || (invokeClinit = classClinitInterceptable.invokeClinit(-1860189441, "Lmapsdkvi/com/gdi/bgl/android/java/EnvDrawText;")) == null) {
            return;
        }
        Interceptable interceptable = invokeClinit.interceptor;
        if (interceptable != null) {
            $ic = interceptable;
        }
        if ((invokeClinit.flags & 1) != 0) {
            classClinitInterceptable.invokePostClinit(-1860189441, "Lmapsdkvi/com/gdi/bgl/android/java/EnvDrawText;");
        }
    }

    public EnvDrawText() {
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

    /* JADX WARN: Removed duplicated region for block: B:100:0x025c  */
    /* JADX WARN: Removed duplicated region for block: B:107:0x0270 A[Catch: all -> 0x032f, TryCatch #0 {, blocks: (B:6:0x0015, B:8:0x0026, B:12:0x0032, B:15:0x004b, B:16:0x0051, B:20:0x0065, B:21:0x0078, B:23:0x0080, B:25:0x0084, B:27:0x008e, B:28:0x0093, B:30:0x00a8, B:32:0x00ca, B:39:0x0108, B:41:0x010c, B:44:0x0115, B:46:0x011d, B:50:0x0124, B:52:0x012e, B:54:0x0132, B:57:0x013e, B:59:0x0161, B:119:0x0315, B:121:0x031b, B:123:0x0324, B:125:0x032a, B:55:0x0139, B:60:0x0175, B:61:0x0187, B:63:0x018d, B:66:0x0199, B:67:0x01a0, B:69:0x01a6, B:72:0x01b9, B:74:0x01d5, B:81:0x0222, B:83:0x0226, B:86:0x022f, B:88:0x0237, B:91:0x023c, B:93:0x0241, B:95:0x0245, B:97:0x024f, B:105:0x026a, B:107:0x0270, B:109:0x027b, B:111:0x02a8, B:112:0x02c6, B:114:0x02d2, B:116:0x02df, B:117:0x02ff, B:102:0x025f, B:103:0x0263, B:96:0x024c, B:17:0x0055, B:18:0x005c), top: B:135:0x0015 }] */
    /* JADX WARN: Removed duplicated region for block: B:114:0x02d2 A[Catch: all -> 0x032f, TryCatch #0 {, blocks: (B:6:0x0015, B:8:0x0026, B:12:0x0032, B:15:0x004b, B:16:0x0051, B:20:0x0065, B:21:0x0078, B:23:0x0080, B:25:0x0084, B:27:0x008e, B:28:0x0093, B:30:0x00a8, B:32:0x00ca, B:39:0x0108, B:41:0x010c, B:44:0x0115, B:46:0x011d, B:50:0x0124, B:52:0x012e, B:54:0x0132, B:57:0x013e, B:59:0x0161, B:119:0x0315, B:121:0x031b, B:123:0x0324, B:125:0x032a, B:55:0x0139, B:60:0x0175, B:61:0x0187, B:63:0x018d, B:66:0x0199, B:67:0x01a0, B:69:0x01a6, B:72:0x01b9, B:74:0x01d5, B:81:0x0222, B:83:0x0226, B:86:0x022f, B:88:0x0237, B:91:0x023c, B:93:0x0241, B:95:0x0245, B:97:0x024f, B:105:0x026a, B:107:0x0270, B:109:0x027b, B:111:0x02a8, B:112:0x02c6, B:114:0x02d2, B:116:0x02df, B:117:0x02ff, B:102:0x025f, B:103:0x0263, B:96:0x024c, B:17:0x0055, B:18:0x005c), top: B:135:0x0015 }] */
    /* JADX WARN: Removed duplicated region for block: B:139:0x02c6 A[EDGE_INSN: B:139:0x02c6->B:112:0x02c6 ?: BREAK  , SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:41:0x010c A[Catch: all -> 0x032f, TryCatch #0 {, blocks: (B:6:0x0015, B:8:0x0026, B:12:0x0032, B:15:0x004b, B:16:0x0051, B:20:0x0065, B:21:0x0078, B:23:0x0080, B:25:0x0084, B:27:0x008e, B:28:0x0093, B:30:0x00a8, B:32:0x00ca, B:39:0x0108, B:41:0x010c, B:44:0x0115, B:46:0x011d, B:50:0x0124, B:52:0x012e, B:54:0x0132, B:57:0x013e, B:59:0x0161, B:119:0x0315, B:121:0x031b, B:123:0x0324, B:125:0x032a, B:55:0x0139, B:60:0x0175, B:61:0x0187, B:63:0x018d, B:66:0x0199, B:67:0x01a0, B:69:0x01a6, B:72:0x01b9, B:74:0x01d5, B:81:0x0222, B:83:0x0226, B:86:0x022f, B:88:0x0237, B:91:0x023c, B:93:0x0241, B:95:0x0245, B:97:0x024f, B:105:0x026a, B:107:0x0270, B:109:0x027b, B:111:0x02a8, B:112:0x02c6, B:114:0x02d2, B:116:0x02df, B:117:0x02ff, B:102:0x025f, B:103:0x0263, B:96:0x024c, B:17:0x0055, B:18:0x005c), top: B:135:0x0015 }] */
    /* JADX WARN: Removed duplicated region for block: B:54:0x0132 A[Catch: all -> 0x032f, TryCatch #0 {, blocks: (B:6:0x0015, B:8:0x0026, B:12:0x0032, B:15:0x004b, B:16:0x0051, B:20:0x0065, B:21:0x0078, B:23:0x0080, B:25:0x0084, B:27:0x008e, B:28:0x0093, B:30:0x00a8, B:32:0x00ca, B:39:0x0108, B:41:0x010c, B:44:0x0115, B:46:0x011d, B:50:0x0124, B:52:0x012e, B:54:0x0132, B:57:0x013e, B:59:0x0161, B:119:0x0315, B:121:0x031b, B:123:0x0324, B:125:0x032a, B:55:0x0139, B:60:0x0175, B:61:0x0187, B:63:0x018d, B:66:0x0199, B:67:0x01a0, B:69:0x01a6, B:72:0x01b9, B:74:0x01d5, B:81:0x0222, B:83:0x0226, B:86:0x022f, B:88:0x0237, B:91:0x023c, B:93:0x0241, B:95:0x0245, B:97:0x024f, B:105:0x026a, B:107:0x0270, B:109:0x027b, B:111:0x02a8, B:112:0x02c6, B:114:0x02d2, B:116:0x02df, B:117:0x02ff, B:102:0x025f, B:103:0x0263, B:96:0x024c, B:17:0x0055, B:18:0x005c), top: B:135:0x0015 }] */
    /* JADX WARN: Removed duplicated region for block: B:55:0x0139 A[Catch: all -> 0x032f, TryCatch #0 {, blocks: (B:6:0x0015, B:8:0x0026, B:12:0x0032, B:15:0x004b, B:16:0x0051, B:20:0x0065, B:21:0x0078, B:23:0x0080, B:25:0x0084, B:27:0x008e, B:28:0x0093, B:30:0x00a8, B:32:0x00ca, B:39:0x0108, B:41:0x010c, B:44:0x0115, B:46:0x011d, B:50:0x0124, B:52:0x012e, B:54:0x0132, B:57:0x013e, B:59:0x0161, B:119:0x0315, B:121:0x031b, B:123:0x0324, B:125:0x032a, B:55:0x0139, B:60:0x0175, B:61:0x0187, B:63:0x018d, B:66:0x0199, B:67:0x01a0, B:69:0x01a6, B:72:0x01b9, B:74:0x01d5, B:81:0x0222, B:83:0x0226, B:86:0x022f, B:88:0x0237, B:91:0x023c, B:93:0x0241, B:95:0x0245, B:97:0x024f, B:105:0x026a, B:107:0x0270, B:109:0x027b, B:111:0x02a8, B:112:0x02c6, B:114:0x02d2, B:116:0x02df, B:117:0x02ff, B:102:0x025f, B:103:0x0263, B:96:0x024c, B:17:0x0055, B:18:0x005c), top: B:135:0x0015 }] */
    /* JADX WARN: Removed duplicated region for block: B:57:0x013e A[Catch: all -> 0x032f, TryCatch #0 {, blocks: (B:6:0x0015, B:8:0x0026, B:12:0x0032, B:15:0x004b, B:16:0x0051, B:20:0x0065, B:21:0x0078, B:23:0x0080, B:25:0x0084, B:27:0x008e, B:28:0x0093, B:30:0x00a8, B:32:0x00ca, B:39:0x0108, B:41:0x010c, B:44:0x0115, B:46:0x011d, B:50:0x0124, B:52:0x012e, B:54:0x0132, B:57:0x013e, B:59:0x0161, B:119:0x0315, B:121:0x031b, B:123:0x0324, B:125:0x032a, B:55:0x0139, B:60:0x0175, B:61:0x0187, B:63:0x018d, B:66:0x0199, B:67:0x01a0, B:69:0x01a6, B:72:0x01b9, B:74:0x01d5, B:81:0x0222, B:83:0x0226, B:86:0x022f, B:88:0x0237, B:91:0x023c, B:93:0x0241, B:95:0x0245, B:97:0x024f, B:105:0x026a, B:107:0x0270, B:109:0x027b, B:111:0x02a8, B:112:0x02c6, B:114:0x02d2, B:116:0x02df, B:117:0x02ff, B:102:0x025f, B:103:0x0263, B:96:0x024c, B:17:0x0055, B:18:0x005c), top: B:135:0x0015 }] */
    /* JADX WARN: Removed duplicated region for block: B:58:0x015f  */
    /* JADX WARN: Removed duplicated region for block: B:83:0x0226 A[Catch: all -> 0x032f, TryCatch #0 {, blocks: (B:6:0x0015, B:8:0x0026, B:12:0x0032, B:15:0x004b, B:16:0x0051, B:20:0x0065, B:21:0x0078, B:23:0x0080, B:25:0x0084, B:27:0x008e, B:28:0x0093, B:30:0x00a8, B:32:0x00ca, B:39:0x0108, B:41:0x010c, B:44:0x0115, B:46:0x011d, B:50:0x0124, B:52:0x012e, B:54:0x0132, B:57:0x013e, B:59:0x0161, B:119:0x0315, B:121:0x031b, B:123:0x0324, B:125:0x032a, B:55:0x0139, B:60:0x0175, B:61:0x0187, B:63:0x018d, B:66:0x0199, B:67:0x01a0, B:69:0x01a6, B:72:0x01b9, B:74:0x01d5, B:81:0x0222, B:83:0x0226, B:86:0x022f, B:88:0x0237, B:91:0x023c, B:93:0x0241, B:95:0x0245, B:97:0x024f, B:105:0x026a, B:107:0x0270, B:109:0x027b, B:111:0x02a8, B:112:0x02c6, B:114:0x02d2, B:116:0x02df, B:117:0x02ff, B:102:0x025f, B:103:0x0263, B:96:0x024c, B:17:0x0055, B:18:0x005c), top: B:135:0x0015 }] */
    /* JADX WARN: Removed duplicated region for block: B:95:0x0245 A[Catch: all -> 0x032f, TryCatch #0 {, blocks: (B:6:0x0015, B:8:0x0026, B:12:0x0032, B:15:0x004b, B:16:0x0051, B:20:0x0065, B:21:0x0078, B:23:0x0080, B:25:0x0084, B:27:0x008e, B:28:0x0093, B:30:0x00a8, B:32:0x00ca, B:39:0x0108, B:41:0x010c, B:44:0x0115, B:46:0x011d, B:50:0x0124, B:52:0x012e, B:54:0x0132, B:57:0x013e, B:59:0x0161, B:119:0x0315, B:121:0x031b, B:123:0x0324, B:125:0x032a, B:55:0x0139, B:60:0x0175, B:61:0x0187, B:63:0x018d, B:66:0x0199, B:67:0x01a0, B:69:0x01a6, B:72:0x01b9, B:74:0x01d5, B:81:0x0222, B:83:0x0226, B:86:0x022f, B:88:0x0237, B:91:0x023c, B:93:0x0241, B:95:0x0245, B:97:0x024f, B:105:0x026a, B:107:0x0270, B:109:0x027b, B:111:0x02a8, B:112:0x02c6, B:114:0x02d2, B:116:0x02df, B:117:0x02ff, B:102:0x025f, B:103:0x0263, B:96:0x024c, B:17:0x0055, B:18:0x005c), top: B:135:0x0015 }] */
    /* JADX WARN: Removed duplicated region for block: B:96:0x024c A[Catch: all -> 0x032f, TryCatch #0 {, blocks: (B:6:0x0015, B:8:0x0026, B:12:0x0032, B:15:0x004b, B:16:0x0051, B:20:0x0065, B:21:0x0078, B:23:0x0080, B:25:0x0084, B:27:0x008e, B:28:0x0093, B:30:0x00a8, B:32:0x00ca, B:39:0x0108, B:41:0x010c, B:44:0x0115, B:46:0x011d, B:50:0x0124, B:52:0x012e, B:54:0x0132, B:57:0x013e, B:59:0x0161, B:119:0x0315, B:121:0x031b, B:123:0x0324, B:125:0x032a, B:55:0x0139, B:60:0x0175, B:61:0x0187, B:63:0x018d, B:66:0x0199, B:67:0x01a0, B:69:0x01a6, B:72:0x01b9, B:74:0x01d5, B:81:0x0222, B:83:0x0226, B:86:0x022f, B:88:0x0237, B:91:0x023c, B:93:0x0241, B:95:0x0245, B:97:0x024f, B:105:0x026a, B:107:0x0270, B:109:0x027b, B:111:0x02a8, B:112:0x02c6, B:114:0x02d2, B:116:0x02df, B:117:0x02ff, B:102:0x025f, B:103:0x0263, B:96:0x024c, B:17:0x0055, B:18:0x005c), top: B:135:0x0015 }] */
    /* JADX WARN: Removed duplicated region for block: B:99:0x0259  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public static synchronized int[] drawText(String str, int i2, int i3, int[] iArr, int i4, int i5, int i6, int i7, int i8) {
        InterceptResult invokeCommon;
        Paint.FontMetrics fontMetrics;
        int i9;
        int i10;
        int i11;
        int i12;
        int i13;
        Bitmap bitmap;
        int i14;
        int i15;
        int i16;
        int i17;
        int indexOf;
        int i18;
        int i19;
        int i20;
        int i21;
        Paint.FontMetrics fontMetrics2;
        int desiredWidth;
        TextPaint textPaint;
        Canvas canvas;
        Bitmap bitmap2;
        TextPaint textPaint2;
        a aVar;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeCommon = interceptable.invokeCommon(65538, null, new Object[]{str, Integer.valueOf(i2), Integer.valueOf(i3), iArr, Integer.valueOf(i4), Integer.valueOf(i5), Integer.valueOf(i6), Integer.valueOf(i7), Integer.valueOf(i8)})) == null) {
            synchronized (EnvDrawText.class) {
                Canvas canvas2 = new Canvas();
                TextPaint textPaint3 = new TextPaint();
                String phoneType = SysOSUtil.getPhoneType();
                int i22 = (phoneType == null || !phoneType.equals("vivo X3L")) ? i3 : 0;
                textPaint3.reset();
                textPaint3.setSubpixelText(true);
                textPaint3.setAntiAlias(true);
                float f2 = i2;
                textPaint3.setTextSize(f2);
                textPaint3.setShadowLayer(0.0f, 0.0f, 0.0f, 0);
                textPaint3.setTypeface(i22 != 1 ? i22 != 2 ? Typeface.create(Typeface.DEFAULT, 0) : Typeface.create(Typeface.DEFAULT, 2) : Typeface.create(Typeface.DEFAULT, 1));
                if (i7 != 0) {
                    textPaint3.setStrokeWidth(i7);
                    textPaint3.setStrokeCap(Paint.Cap.ROUND);
                    textPaint3.setStrokeJoin(Paint.Join.ROUND);
                    textPaint3.setStyle(Paint.Style.STROKE);
                }
                textPaint3.setSubpixelText(true);
                textPaint3.setAntiAlias(true);
                if (i22 != 0 && fontCache != null && (aVar = fontCache.get(i22)) != null) {
                    textPaint3.setTypeface(aVar.f73076a);
                }
                textPaint3.setTextSize(f2);
                int indexOf2 = str.indexOf(92, 0);
                if (indexOf2 == -1) {
                    Paint.FontMetrics fontMetrics3 = textPaint3.getFontMetrics();
                    int desiredWidth2 = (int) (Layout.getDesiredWidth(str, 0, str.length(), textPaint3) + 0.5d);
                    i19 = (int) Math.ceil(fontMetrics3.descent - fontMetrics3.ascent);
                    iArr[0] = desiredWidth2;
                    iArr[1] = i19;
                    if (iArr.length == 4) {
                        desiredWidth2 = (int) Math.pow(2.0d, (int) Math.ceil(Math.log(desiredWidth2) / Math.log(2.0d)));
                        textPaint = textPaint3;
                        i19 = (int) Math.pow(2.0d, (int) Math.ceil(Math.log(i19) / Math.log(2.0d)));
                    } else {
                        textPaint = textPaint3;
                    }
                    if (desiredWidth2 == 0 && i19 == 0) {
                        i19 = 0;
                        i18 = 0;
                        if (iArr.length == 4) {
                            iArr[2] = i18;
                            iArr[3] = i19;
                        }
                        if (i18 > 0 || i19 <= 0) {
                            canvas = canvas2;
                            bitmap2 = null;
                        } else {
                            Bitmap createBitmap = Bitmap.createBitmap(i18, i19, Bitmap.Config.ARGB_8888);
                            if (createBitmap == null) {
                                return new int[0];
                            }
                            canvas = canvas2;
                            canvas.setBitmap(createBitmap);
                            bitmap2 = createBitmap;
                        }
                        if ((i6 & (-16777216)) != 0) {
                            canvas.drawColor(16777215);
                        } else {
                            canvas.drawColor(i6);
                        }
                        if (i7 == 0) {
                            textPaint2 = textPaint;
                            textPaint2.setStrokeWidth(i7);
                            textPaint2.setStrokeCap(Paint.Cap.ROUND);
                            textPaint2.setStrokeJoin(Paint.Join.ROUND);
                            textPaint2.setStyle(Paint.Style.STROKE);
                            textPaint2.setColor(i5);
                            canvas.drawText(str, 0.0f, 0.0f - fontMetrics3.ascent, textPaint2);
                        } else {
                            textPaint2 = textPaint;
                        }
                        textPaint2.setStyle(Paint.Style.FILL);
                        textPaint2.setColor(i4);
                        canvas.drawText(str, 0.0f, 0.0f - fontMetrics3.ascent, textPaint2);
                        bitmap = bitmap2;
                    }
                    i18 = desiredWidth2;
                    if (iArr.length == 4) {
                    }
                    if (i18 > 0) {
                    }
                    canvas = canvas2;
                    bitmap2 = null;
                    if ((i6 & (-16777216)) != 0) {
                    }
                    if (i7 == 0) {
                    }
                    textPaint2.setStyle(Paint.Style.FILL);
                    textPaint2.setColor(i4);
                    canvas.drawText(str, 0.0f, 0.0f - fontMetrics3.ascent, textPaint2);
                    bitmap = bitmap2;
                } else {
                    int i23 = indexOf2 + 1;
                    int measureText = (int) textPaint3.measureText(str.substring(0, indexOf2));
                    int i24 = 92;
                    int i25 = 2;
                    while (true) {
                        int indexOf3 = str.indexOf(i24, i23);
                        if (indexOf3 <= 0) {
                            break;
                        }
                        int measureText2 = (int) textPaint3.measureText(str.substring(i23, indexOf3));
                        if (measureText2 > measureText) {
                            measureText = measureText2;
                        }
                        i23 = indexOf3 + 1;
                        i25++;
                        i24 = 92;
                    }
                    if (i23 != str.length() && (desiredWidth = (int) (Layout.getDesiredWidth(str.substring(i23, str.length()), textPaint3) + 0.5d)) > measureText) {
                        measureText = desiredWidth;
                    }
                    Paint.FontMetrics fontMetrics4 = textPaint3.getFontMetrics();
                    int ceil = (int) Math.ceil(fontMetrics4.descent - fontMetrics4.ascent);
                    int i26 = ceil * i25;
                    iArr[0] = measureText;
                    iArr[1] = i26;
                    if (iArr.length == 4) {
                        fontMetrics = fontMetrics4;
                        i9 = ceil;
                        int pow = (int) Math.pow(2.0d, (int) Math.ceil(Math.log(measureText) / Math.log(2.0d)));
                        i11 = (int) Math.pow(2.0d, (int) Math.ceil(Math.log(i26) / Math.log(2.0d)));
                        i10 = pow;
                    } else {
                        fontMetrics = fontMetrics4;
                        i9 = ceil;
                        i10 = measureText;
                        i11 = i26;
                    }
                    if (i10 == 0 && i11 == 0) {
                        i13 = 0;
                        i12 = 0;
                        if (iArr.length == 4) {
                            iArr[2] = i13;
                            iArr[3] = i12;
                        }
                        if (i13 > 0 || i12 <= 0) {
                            bitmap = null;
                        } else {
                            bitmap = Bitmap.createBitmap(i13, i12, Bitmap.Config.ARGB_8888);
                            if (bitmap == null) {
                                return new int[0];
                            }
                            canvas2.setBitmap(bitmap);
                        }
                        if ((i6 & (-16777216)) != 0) {
                            canvas2.drawColor(16777215);
                        } else {
                            canvas2.drawColor(i6);
                        }
                        textPaint3.setTextAlign(getTextAlignedType(i8));
                        if (i8 != 1) {
                            i15 = 0;
                            i14 = 0;
                        } else if (i8 == 2) {
                            i14 = 0;
                            i15 = iArr[0];
                        } else {
                            i14 = 0;
                            i15 = iArr[0] / 2;
                        }
                        i16 = 0;
                        i17 = 92;
                        while (true) {
                            indexOf = str.indexOf(i17, i14);
                            if (indexOf > 0) {
                                break;
                            }
                            String substring = str.substring(i14, indexOf);
                            textPaint3.measureText(substring);
                            int i27 = indexOf + 1;
                            if (i7 != 0) {
                                textPaint3.setStrokeWidth(i7);
                                textPaint3.setStrokeCap(Paint.Cap.ROUND);
                                textPaint3.setStrokeJoin(Paint.Join.ROUND);
                                textPaint3.setStyle(Paint.Style.STROKE);
                                textPaint3.setColor(i5);
                                i20 = i13;
                                i21 = i12;
                                fontMetrics2 = fontMetrics;
                                canvas2.drawText(substring, i15, (i16 * i9) - fontMetrics2.ascent, textPaint3);
                            } else {
                                i20 = i13;
                                i21 = i12;
                                fontMetrics2 = fontMetrics;
                            }
                            textPaint3.setStyle(Paint.Style.FILL);
                            textPaint3.setColor(i4);
                            canvas2.drawText(substring, i15, (i16 * i9) - fontMetrics2.ascent, textPaint3);
                            i16++;
                            fontMetrics = fontMetrics2;
                            i14 = i27;
                            i12 = i21;
                            i17 = 92;
                            i13 = i20;
                        }
                        int i28 = i13;
                        int i29 = i12;
                        Paint.FontMetrics fontMetrics5 = fontMetrics;
                        if (i14 != str.length()) {
                            String substring2 = str.substring(i14, str.length());
                            Layout.getDesiredWidth(substring2, textPaint3);
                            if (i7 != 0) {
                                textPaint3.setStrokeWidth(i7);
                                textPaint3.setStrokeCap(Paint.Cap.ROUND);
                                textPaint3.setStrokeJoin(Paint.Join.ROUND);
                                textPaint3.setStyle(Paint.Style.STROKE);
                                textPaint3.setColor(i5);
                                canvas2.drawText(substring2, i15, (i16 * i9) - fontMetrics5.ascent, textPaint3);
                            }
                            textPaint3.setStyle(Paint.Style.FILL);
                            textPaint3.setColor(i4);
                            canvas2.drawText(substring2, i15, (i16 * i9) - fontMetrics5.ascent, textPaint3);
                        }
                        i18 = i28;
                        i19 = i29;
                    }
                    i12 = i11;
                    i13 = i10;
                    if (iArr.length == 4) {
                    }
                    if (i13 > 0) {
                    }
                    bitmap = null;
                    if ((i6 & (-16777216)) != 0) {
                    }
                    textPaint3.setTextAlign(getTextAlignedType(i8));
                    if (i8 != 1) {
                    }
                    i16 = 0;
                    i17 = 92;
                    while (true) {
                        indexOf = str.indexOf(i17, i14);
                        if (indexOf > 0) {
                        }
                        textPaint3.setStyle(Paint.Style.FILL);
                        textPaint3.setColor(i4);
                        canvas2.drawText(substring, i15, (i16 * i9) - fontMetrics2.ascent, textPaint3);
                        i16++;
                        fontMetrics = fontMetrics2;
                        i14 = i27;
                        i12 = i21;
                        i17 = 92;
                        i13 = i20;
                    }
                    int i282 = i13;
                    int i292 = i12;
                    Paint.FontMetrics fontMetrics52 = fontMetrics;
                    if (i14 != str.length()) {
                    }
                    i18 = i282;
                    i19 = i292;
                }
                int[] iArr2 = new int[i18 * i19];
                if (bitmap != null) {
                    bitmap.copyPixelsToBuffer(IntBuffer.wrap(iArr2));
                }
                if (bitmap != null && !bitmap.isRecycled()) {
                    bitmap.recycle();
                }
                return iArr2;
            }
        }
        return (int[]) invokeCommon.objValue;
    }

    public static Bitmap drawTextAlpha(String str, int i2, int i3, int i4) {
        InterceptResult invokeLIII;
        int desiredWidth;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLIII = interceptable.invokeLIII(65539, null, str, i2, i3, i4)) == null) {
            Canvas canvas = new Canvas();
            TextPaint textPaint = new TextPaint();
            String phoneType = SysOSUtil.getPhoneType();
            int i5 = 0;
            int i6 = (phoneType == null || !phoneType.equals("vivo X3L")) ? i3 : 0;
            textPaint.reset();
            textPaint.setSubpixelText(false);
            textPaint.setAntiAlias(false);
            textPaint.setTextSize(i2);
            int i7 = 2;
            textPaint.setTypeface(i6 != 1 ? i6 != 2 ? Typeface.create(Typeface.DEFAULT, 0) : Typeface.create(Typeface.DEFAULT, 2) : Typeface.create(Typeface.DEFAULT, 1));
            float f2 = (i4 * 1.3f) + 0.5f;
            int i8 = 92;
            int indexOf = str.indexOf(92, 0);
            Bitmap bitmap = null;
            if (indexOf == -1) {
                Paint.FontMetrics fontMetrics = textPaint.getFontMetrics();
                int desiredWidth2 = (int) (Layout.getDesiredWidth(str, 0, str.length(), textPaint) + f2);
                int ceil = (int) Math.ceil(fontMetrics.descent - fontMetrics.ascent);
                if (desiredWidth2 > 0 && ceil > 0) {
                    bitmap = Bitmap.createBitmap(desiredWidth2, ceil, Bitmap.Config.ALPHA_8);
                    if (bitmap == null) {
                        return bitmap;
                    }
                    bitmap.eraseColor(0);
                    canvas.setBitmap(bitmap);
                }
                textPaint.setStyle(Paint.Style.FILL);
                canvas.drawText(str, f2 * 0.5f, 0.0f - fontMetrics.ascent, textPaint);
            } else {
                int i9 = indexOf + 1;
                int desiredWidth3 = (int) (Layout.getDesiredWidth(str.substring(0, indexOf), textPaint) + 0.5d);
                while (true) {
                    int indexOf2 = str.indexOf(i8, i9);
                    if (indexOf2 <= 0) {
                        break;
                    }
                    int desiredWidth4 = (int) (Layout.getDesiredWidth(str.substring(i9, indexOf2), textPaint) + 0.5d);
                    if (desiredWidth4 > desiredWidth3) {
                        desiredWidth3 = desiredWidth4;
                    }
                    i9 = indexOf2 + 1;
                    i7++;
                    i8 = 92;
                }
                if (i9 != str.length() && (desiredWidth = (int) (Layout.getDesiredWidth(str.substring(i9, str.length()), textPaint) + 0.5d)) > desiredWidth3) {
                    desiredWidth3 = desiredWidth;
                }
                Paint.FontMetrics fontMetrics2 = textPaint.getFontMetrics();
                int ceil2 = (int) Math.ceil(fontMetrics2.descent - fontMetrics2.ascent);
                int i10 = desiredWidth3 + i4;
                int i11 = i7 * ceil2;
                if (i10 > 0 && i11 > 0) {
                    bitmap = Bitmap.createBitmap(i10, i11, Bitmap.Config.ALPHA_8);
                    if (bitmap == null) {
                        return bitmap;
                    }
                    bitmap.eraseColor(0);
                    canvas.setBitmap(bitmap);
                }
                textPaint.setTextAlign(getTextAlignedType(3));
                float f3 = i10 - (f2 * 0.5f);
                int i12 = 0;
                while (true) {
                    int indexOf3 = str.indexOf(92, i5);
                    if (indexOf3 <= 0) {
                        break;
                    }
                    String substring = str.substring(i5, indexOf3);
                    Layout.getDesiredWidth(substring, textPaint);
                    textPaint.setStyle(Paint.Style.FILL);
                    canvas.drawText(substring, f3, (i12 * ceil2) - fontMetrics2.ascent, textPaint);
                    i12++;
                    i5 = indexOf3 + 1;
                }
                if (i5 != str.length()) {
                    String substring2 = str.substring(i5, str.length());
                    Layout.getDesiredWidth(substring2, textPaint);
                    textPaint.setStyle(Paint.Style.FILL);
                    canvas.drawText(substring2, f3, (i12 * ceil2) - fontMetrics2.ascent, textPaint);
                }
            }
            return bitmap;
        }
        return (Bitmap) invokeLIII.objValue;
    }

    /* JADX WARN: Removed duplicated region for block: B:33:0x00e6 A[Catch: all -> 0x02cb, TryCatch #0 {, blocks: (B:6:0x0015, B:8:0x0026, B:12:0x0032, B:15:0x004b, B:16:0x0051, B:20:0x0065, B:21:0x0078, B:23:0x0087, B:25:0x00aa, B:31:0x00e2, B:33:0x00e6, B:36:0x00ef, B:40:0x00f9, B:42:0x00fe, B:44:0x0102, B:47:0x010e, B:48:0x012e, B:45:0x0109, B:49:0x0142, B:50:0x0156, B:52:0x015e, B:55:0x016f, B:56:0x0175, B:58:0x017b, B:61:0x018e, B:63:0x01a9, B:69:0x01e5, B:71:0x01e9, B:74:0x01f2, B:78:0x01fc, B:80:0x0201, B:82:0x0205, B:84:0x020f, B:92:0x0229, B:94:0x022f, B:96:0x023a, B:98:0x025f, B:99:0x027c, B:101:0x0288, B:103:0x0295, B:104:0x02b5, B:89:0x0220, B:90:0x0223, B:83:0x020c, B:17:0x0055, B:18:0x005c), top: B:115:0x0015 }] */
    /* JADX WARN: Removed duplicated region for block: B:44:0x0102 A[Catch: all -> 0x02cb, TryCatch #0 {, blocks: (B:6:0x0015, B:8:0x0026, B:12:0x0032, B:15:0x004b, B:16:0x0051, B:20:0x0065, B:21:0x0078, B:23:0x0087, B:25:0x00aa, B:31:0x00e2, B:33:0x00e6, B:36:0x00ef, B:40:0x00f9, B:42:0x00fe, B:44:0x0102, B:47:0x010e, B:48:0x012e, B:45:0x0109, B:49:0x0142, B:50:0x0156, B:52:0x015e, B:55:0x016f, B:56:0x0175, B:58:0x017b, B:61:0x018e, B:63:0x01a9, B:69:0x01e5, B:71:0x01e9, B:74:0x01f2, B:78:0x01fc, B:80:0x0201, B:82:0x0205, B:84:0x020f, B:92:0x0229, B:94:0x022f, B:96:0x023a, B:98:0x025f, B:99:0x027c, B:101:0x0288, B:103:0x0295, B:104:0x02b5, B:89:0x0220, B:90:0x0223, B:83:0x020c, B:17:0x0055, B:18:0x005c), top: B:115:0x0015 }] */
    /* JADX WARN: Removed duplicated region for block: B:45:0x0109 A[Catch: all -> 0x02cb, TryCatch #0 {, blocks: (B:6:0x0015, B:8:0x0026, B:12:0x0032, B:15:0x004b, B:16:0x0051, B:20:0x0065, B:21:0x0078, B:23:0x0087, B:25:0x00aa, B:31:0x00e2, B:33:0x00e6, B:36:0x00ef, B:40:0x00f9, B:42:0x00fe, B:44:0x0102, B:47:0x010e, B:48:0x012e, B:45:0x0109, B:49:0x0142, B:50:0x0156, B:52:0x015e, B:55:0x016f, B:56:0x0175, B:58:0x017b, B:61:0x018e, B:63:0x01a9, B:69:0x01e5, B:71:0x01e9, B:74:0x01f2, B:78:0x01fc, B:80:0x0201, B:82:0x0205, B:84:0x020f, B:92:0x0229, B:94:0x022f, B:96:0x023a, B:98:0x025f, B:99:0x027c, B:101:0x0288, B:103:0x0295, B:104:0x02b5, B:89:0x0220, B:90:0x0223, B:83:0x020c, B:17:0x0055, B:18:0x005c), top: B:115:0x0015 }] */
    /* JADX WARN: Removed duplicated region for block: B:47:0x010e A[Catch: all -> 0x02cb, TryCatch #0 {, blocks: (B:6:0x0015, B:8:0x0026, B:12:0x0032, B:15:0x004b, B:16:0x0051, B:20:0x0065, B:21:0x0078, B:23:0x0087, B:25:0x00aa, B:31:0x00e2, B:33:0x00e6, B:36:0x00ef, B:40:0x00f9, B:42:0x00fe, B:44:0x0102, B:47:0x010e, B:48:0x012e, B:45:0x0109, B:49:0x0142, B:50:0x0156, B:52:0x015e, B:55:0x016f, B:56:0x0175, B:58:0x017b, B:61:0x018e, B:63:0x01a9, B:69:0x01e5, B:71:0x01e9, B:74:0x01f2, B:78:0x01fc, B:80:0x0201, B:82:0x0205, B:84:0x020f, B:92:0x0229, B:94:0x022f, B:96:0x023a, B:98:0x025f, B:99:0x027c, B:101:0x0288, B:103:0x0295, B:104:0x02b5, B:89:0x0220, B:90:0x0223, B:83:0x020c, B:17:0x0055, B:18:0x005c), top: B:115:0x0015 }] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public static synchronized Bitmap drawTextExt(String str, int i2, int i3, int[] iArr, int i4, int i5, int i6, int i7, int i8) {
        InterceptResult invokeCommon;
        Paint.FontMetrics fontMetrics;
        int i9;
        Bitmap bitmap;
        int i10;
        int i11;
        Bitmap bitmap2;
        int desiredWidth;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeCommon = interceptable.invokeCommon(InputDeviceCompat.SOURCE_TRACKBALL, null, new Object[]{str, Integer.valueOf(i2), Integer.valueOf(i3), iArr, Integer.valueOf(i4), Integer.valueOf(i5), Integer.valueOf(i6), Integer.valueOf(i7), Integer.valueOf(i8)})) == null) {
            synchronized (EnvDrawText.class) {
                Canvas canvas = new Canvas();
                TextPaint textPaint = new TextPaint();
                String phoneType = SysOSUtil.getPhoneType();
                int i12 = 0;
                int i13 = (phoneType == null || !phoneType.equals("vivo X3L")) ? i3 : 0;
                textPaint.reset();
                textPaint.setSubpixelText(true);
                textPaint.setAntiAlias(true);
                textPaint.setTextSize(i2);
                textPaint.setShadowLayer(0.0f, 0.0f, 0.0f, 0);
                textPaint.setTypeface(i13 != 1 ? i13 != 2 ? Typeface.create(Typeface.DEFAULT, 0) : Typeface.create(Typeface.DEFAULT, 2) : Typeface.create(Typeface.DEFAULT, 1));
                if (i7 != 0) {
                    textPaint.setStrokeWidth(i7);
                    textPaint.setStrokeCap(Paint.Cap.ROUND);
                    textPaint.setStrokeJoin(Paint.Join.ROUND);
                    textPaint.setStyle(Paint.Style.STROKE);
                }
                int indexOf = str.indexOf(92, 0);
                if (indexOf == -1) {
                    Paint.FontMetrics fontMetrics2 = textPaint.getFontMetrics();
                    int desiredWidth2 = (int) (Layout.getDesiredWidth(str, 0, str.length(), textPaint) + 0.5d);
                    int ceil = (int) Math.ceil(fontMetrics2.descent - fontMetrics2.ascent);
                    iArr[0] = desiredWidth2;
                    iArr[1] = ceil;
                    if (iArr.length == 4) {
                        desiredWidth2 = (int) Math.pow(2.0d, (int) Math.ceil(Math.log(desiredWidth2) / Math.log(2.0d)));
                        ceil = (int) Math.pow(2.0d, (int) Math.ceil(Math.log(ceil) / Math.log(2.0d)));
                    }
                    if (desiredWidth2 == 0 && ceil == 0) {
                        ceil = 0;
                        if (iArr.length == 4) {
                            iArr[2] = i12;
                            iArr[3] = ceil;
                        }
                        if (i12 > 0 || ceil <= 0) {
                            bitmap2 = null;
                        } else {
                            bitmap2 = Bitmap.createBitmap(i12, ceil, Bitmap.Config.ARGB_8888);
                            if (bitmap2 == null) {
                                return bitmap2;
                            }
                            canvas.setBitmap(bitmap2);
                        }
                        if ((i6 & (-16777216)) != 0) {
                            canvas.drawColor(16777215);
                        } else {
                            canvas.drawColor(i6);
                        }
                        if (i7 != 0) {
                            textPaint.setStrokeWidth(i7);
                            textPaint.setStrokeCap(Paint.Cap.ROUND);
                            textPaint.setStrokeJoin(Paint.Join.ROUND);
                            textPaint.setStyle(Paint.Style.STROKE);
                            textPaint.setColor(i5);
                            canvas.drawText(str, 0.0f, 0.0f - fontMetrics2.ascent, textPaint);
                        }
                        textPaint.setStyle(Paint.Style.FILL);
                        textPaint.setColor(i4);
                        canvas.drawText(str, 0.0f, 0.0f - fontMetrics2.ascent, textPaint);
                    }
                    i12 = desiredWidth2;
                    if (iArr.length == 4) {
                    }
                    if (i12 > 0) {
                    }
                    bitmap2 = null;
                    if ((i6 & (-16777216)) != 0) {
                    }
                    if (i7 != 0) {
                    }
                    textPaint.setStyle(Paint.Style.FILL);
                    textPaint.setColor(i4);
                    canvas.drawText(str, 0.0f, 0.0f - fontMetrics2.ascent, textPaint);
                } else {
                    int i14 = indexOf + 1;
                    int desiredWidth3 = (int) (Layout.getDesiredWidth(str.substring(0, indexOf), textPaint) + 0.5d);
                    int i15 = 2;
                    while (true) {
                        int indexOf2 = str.indexOf(92, i14);
                        if (indexOf2 <= 0) {
                            break;
                        }
                        int desiredWidth4 = (int) (Layout.getDesiredWidth(str.substring(i14, indexOf2), textPaint) + 0.5d);
                        if (desiredWidth4 > desiredWidth3) {
                            desiredWidth3 = desiredWidth4;
                        }
                        i14 = indexOf2 + 1;
                        i15++;
                    }
                    if (i14 != str.length() && (desiredWidth = (int) (Layout.getDesiredWidth(str.substring(i14, str.length()), textPaint) + 0.5d)) > desiredWidth3) {
                        desiredWidth3 = desiredWidth;
                    }
                    Paint.FontMetrics fontMetrics3 = textPaint.getFontMetrics();
                    int ceil2 = (int) Math.ceil(fontMetrics3.descent - fontMetrics3.ascent);
                    int i16 = i15 * ceil2;
                    iArr[0] = desiredWidth3;
                    iArr[1] = i16;
                    if (iArr.length == 4) {
                        fontMetrics = fontMetrics3;
                        i9 = ceil2;
                        desiredWidth3 = (int) Math.pow(2.0d, (int) Math.ceil(Math.log(desiredWidth3) / Math.log(2.0d)));
                        i16 = (int) Math.pow(2.0d, (int) Math.ceil(Math.log(i16) / Math.log(2.0d)));
                    } else {
                        fontMetrics = fontMetrics3;
                        i9 = ceil2;
                    }
                    if (desiredWidth3 == 0 && i16 == 0) {
                        desiredWidth3 = 0;
                        i16 = 0;
                    }
                    if (iArr.length == 4) {
                        iArr[2] = desiredWidth3;
                        iArr[3] = i16;
                    }
                    if (desiredWidth3 <= 0 || i16 <= 0) {
                        bitmap = null;
                    } else {
                        bitmap = Bitmap.createBitmap(desiredWidth3, i16, Bitmap.Config.ARGB_8888);
                        if (bitmap == null) {
                            return bitmap;
                        }
                        canvas.setBitmap(bitmap);
                    }
                    if ((i6 & (-16777216)) == 0) {
                        canvas.drawColor(16777215);
                    } else {
                        canvas.drawColor(i6);
                    }
                    textPaint.setTextAlign(getTextAlignedType(i8));
                    if (i8 == 1) {
                        i11 = 0;
                        i10 = 0;
                    } else {
                        i10 = 0;
                        i11 = i8 == 2 ? iArr[0] : iArr[0] / 2;
                    }
                    int i17 = 92;
                    int i18 = 0;
                    while (true) {
                        int indexOf3 = str.indexOf(i17, i18);
                        if (indexOf3 <= 0) {
                            break;
                        }
                        String substring = str.substring(i18, indexOf3);
                        Layout.getDesiredWidth(substring, textPaint);
                        i18 = indexOf3 + 1;
                        if (i7 != 0) {
                            textPaint.setStrokeWidth(i7);
                            textPaint.setStrokeCap(Paint.Cap.ROUND);
                            textPaint.setStrokeJoin(Paint.Join.ROUND);
                            textPaint.setStyle(Paint.Style.STROKE);
                            textPaint.setColor(i5);
                            canvas.drawText(substring, i11, (i10 * i9) - fontMetrics.ascent, textPaint);
                        }
                        textPaint.setStyle(Paint.Style.FILL);
                        textPaint.setColor(i4);
                        canvas.drawText(substring, i11, (i10 * i9) - fontMetrics.ascent, textPaint);
                        i10++;
                        bitmap = bitmap;
                        i17 = 92;
                    }
                    Bitmap bitmap3 = bitmap;
                    if (i18 != str.length()) {
                        String substring2 = str.substring(i18, str.length());
                        Layout.getDesiredWidth(substring2, textPaint);
                        if (i7 != 0) {
                            textPaint.setStrokeWidth(i7);
                            textPaint.setStrokeCap(Paint.Cap.ROUND);
                            textPaint.setStrokeJoin(Paint.Join.ROUND);
                            textPaint.setStyle(Paint.Style.STROKE);
                            textPaint.setColor(i5);
                            canvas.drawText(substring2, i11, (i10 * i9) - fontMetrics.ascent, textPaint);
                        }
                        textPaint.setStyle(Paint.Style.FILL);
                        textPaint.setColor(i4);
                        canvas.drawText(substring2, i11, (i10 * i9) - fontMetrics.ascent, textPaint);
                    }
                    bitmap2 = bitmap3;
                }
                return bitmap2;
            }
        }
        return (Bitmap) invokeCommon.objValue;
    }

    public static Paint.Align getTextAlignedType(int i2) {
        InterceptResult invokeI;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeI = interceptable.invokeI(AdIconUtil.AD_TEXT_ID, null, i2)) == null) ? 1 == i2 ? Paint.Align.LEFT : 2 == i2 ? Paint.Align.RIGHT : Paint.Align.CENTER : (Paint.Align) invokeI.objValue;
    }

    /* JADX WARN: Removed duplicated region for block: B:16:0x0037 A[LOOP:0: B:15:0x0035->B:16:0x0037, LOOP_END] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public static short[] getTextSize(String str, int i2, int i3) {
        InterceptResult invokeLII;
        Typeface create;
        int i4;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLII = interceptable.invokeLII(AdIconUtil.BAIDU_LOGO_ID, null, str, i2, i3)) == null) {
            int length = str.length();
            if (length == 0) {
                return null;
            }
            TextPaint textPaint = new TextPaint();
            int i5 = 1;
            textPaint.setSubpixelText(true);
            textPaint.setAntiAlias(true);
            textPaint.setTextSize(i2);
            if (i3 != 1) {
                i5 = 2;
                if (i3 != 2) {
                    create = Typeface.create(Typeface.DEFAULT, 0);
                    textPaint.setTypeface(create);
                    short[] sArr = new short[length];
                    i4 = 0;
                    while (i4 < length) {
                        int i6 = i4 + 1;
                        sArr[i4] = (short) (Layout.getDesiredWidth(str, 0, i6, textPaint) + 0.5d);
                        i4 = i6;
                    }
                    return sArr;
                }
            }
            create = Typeface.create(Typeface.DEFAULT, i5);
            textPaint.setTypeface(create);
            short[] sArr2 = new short[length];
            i4 = 0;
            while (i4 < length) {
            }
            return sArr2;
        }
        return (short[]) invokeLII.objValue;
    }

    public static float[] getTextSizeExt(String str, int i2, int i3) {
        InterceptResult invokeLII;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLII = interceptable.invokeLII(65543, null, str, i2, i3)) == null) {
            if (str.length() == 0) {
                return null;
            }
            Paint paint = new Paint();
            paint.setSubpixelText(true);
            paint.setAntiAlias(true);
            paint.setTextSize(i2);
            paint.setTypeface(i3 != 1 ? i3 != 2 ? Typeface.create(Typeface.DEFAULT, 0) : Typeface.create(Typeface.DEFAULT, 2) : Typeface.create(Typeface.DEFAULT, 1));
            return new float[]{paint.measureText(str), paint.descent() - paint.ascent()};
        }
        return (float[]) invokeLII.objValue;
    }

    public static synchronized void registFontCache(int i2, Typeface typeface) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeIL(65544, null, i2, typeface) == null) {
            synchronized (EnvDrawText.class) {
                if (i2 == 0 || typeface == null) {
                    return;
                }
                if (fontCache == null) {
                    fontCache = new SparseArray<>();
                }
                a aVar = fontCache.get(i2);
                if (aVar == null) {
                    a aVar2 = new a();
                    aVar2.f73076a = typeface;
                    aVar2.f73077b++;
                    fontCache.put(i2, aVar2);
                } else {
                    aVar.f73077b++;
                }
            }
        }
    }

    public static synchronized void removeFontCache(int i2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(65545, null, i2) == null) {
            synchronized (EnvDrawText.class) {
                a aVar = fontCache.get(i2);
                if (aVar == null) {
                    return;
                }
                int i3 = aVar.f73077b - 1;
                aVar.f73077b = i3;
                if (i3 == 0) {
                    fontCache.remove(i2);
                }
            }
        }
    }
}
