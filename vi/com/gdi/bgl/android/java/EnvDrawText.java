package vi.com.gdi.bgl.android.java;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.Typeface;
import android.os.Build;
import android.text.Layout;
import android.text.TextPaint;
import android.util.SparseArray;
import androidx.core.view.InputDeviceCompat;
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
    public static final String DEVICE_VIVOX3L = "vivo X3L";
    public static final int FONT_STYLE_BOLD = 1;
    public static final int FONT_STYLE_ITALIC = 2;
    public static final int FONT_STYLE_NORMAL = 0;
    public static int[] buffer;
    public static Bitmap defaultFontBmp;
    public static SparseArray<a> fontCache;
    public static Context mContext;
    public transient /* synthetic */ FieldHolder $fh;

    static {
        InterceptResult invokeClinit;
        ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
        if (classClinitInterceptable == null || (invokeClinit = classClinitInterceptable.invokeClinit(-213215071, "Lvi/com/gdi/bgl/android/java/EnvDrawText;")) == null) {
            return;
        }
        Interceptable interceptable = invokeClinit.interceptor;
        if (interceptable != null) {
            $ic = interceptable;
        }
        if ((invokeClinit.flags & 1) != 0) {
            classClinitInterceptable.invokePostClinit(-213215071, "Lvi/com/gdi/bgl/android/java/EnvDrawText;");
        }
    }

    public static native boolean nativeIsBitmapSame(Bitmap bitmap, Bitmap bitmap2);

    public EnvDrawText() {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            interceptable.invokeUnInit(65537, newInitContext);
            int i = newInitContext.flag;
            if ((i & 1) != 0) {
                int i2 = i & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65537, newInitContext);
            }
        }
    }

    /* JADX WARN: Removed duplicated region for block: B:123:0x027c A[EDGE_INSN: B:123:0x027c->B:96:0x027c ?: BREAK  , SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:67:0x01d6 A[Catch: all -> 0x02e7, TryCatch #0 {, blocks: (B:6:0x0015, B:8:0x0024, B:12:0x0030, B:14:0x004d, B:15:0x0060, B:17:0x006f, B:19:0x0093, B:24:0x00ca, B:26:0x00ce, B:29:0x00d7, B:31:0x00df, B:34:0x00e4, B:36:0x00ec, B:38:0x00f0, B:41:0x00fc, B:42:0x011a, B:103:0x02cd, B:105:0x02d3, B:107:0x02dc, B:109:0x02e2, B:39:0x00f7, B:44:0x012e, B:45:0x013e, B:47:0x0146, B:50:0x0155, B:51:0x015e, B:53:0x0164, B:56:0x0177, B:58:0x0192, B:65:0x01d2, B:67:0x01d6, B:70:0x01df, B:72:0x01e7, B:75:0x01ec, B:77:0x01f4, B:79:0x01f8, B:81:0x0202, B:89:0x021d, B:91:0x0223, B:93:0x022e, B:95:0x025b, B:96:0x027c, B:98:0x028a, B:100:0x0297, B:101:0x02b7, B:86:0x0212, B:87:0x0216, B:80:0x01ff), top: B:119:0x0015 }] */
    /* JADX WARN: Removed duplicated region for block: B:79:0x01f8 A[Catch: all -> 0x02e7, TryCatch #0 {, blocks: (B:6:0x0015, B:8:0x0024, B:12:0x0030, B:14:0x004d, B:15:0x0060, B:17:0x006f, B:19:0x0093, B:24:0x00ca, B:26:0x00ce, B:29:0x00d7, B:31:0x00df, B:34:0x00e4, B:36:0x00ec, B:38:0x00f0, B:41:0x00fc, B:42:0x011a, B:103:0x02cd, B:105:0x02d3, B:107:0x02dc, B:109:0x02e2, B:39:0x00f7, B:44:0x012e, B:45:0x013e, B:47:0x0146, B:50:0x0155, B:51:0x015e, B:53:0x0164, B:56:0x0177, B:58:0x0192, B:65:0x01d2, B:67:0x01d6, B:70:0x01df, B:72:0x01e7, B:75:0x01ec, B:77:0x01f4, B:79:0x01f8, B:81:0x0202, B:89:0x021d, B:91:0x0223, B:93:0x022e, B:95:0x025b, B:96:0x027c, B:98:0x028a, B:100:0x0297, B:101:0x02b7, B:86:0x0212, B:87:0x0216, B:80:0x01ff), top: B:119:0x0015 }] */
    /* JADX WARN: Removed duplicated region for block: B:80:0x01ff A[Catch: all -> 0x02e7, TryCatch #0 {, blocks: (B:6:0x0015, B:8:0x0024, B:12:0x0030, B:14:0x004d, B:15:0x0060, B:17:0x006f, B:19:0x0093, B:24:0x00ca, B:26:0x00ce, B:29:0x00d7, B:31:0x00df, B:34:0x00e4, B:36:0x00ec, B:38:0x00f0, B:41:0x00fc, B:42:0x011a, B:103:0x02cd, B:105:0x02d3, B:107:0x02dc, B:109:0x02e2, B:39:0x00f7, B:44:0x012e, B:45:0x013e, B:47:0x0146, B:50:0x0155, B:51:0x015e, B:53:0x0164, B:56:0x0177, B:58:0x0192, B:65:0x01d2, B:67:0x01d6, B:70:0x01df, B:72:0x01e7, B:75:0x01ec, B:77:0x01f4, B:79:0x01f8, B:81:0x0202, B:89:0x021d, B:91:0x0223, B:93:0x022e, B:95:0x025b, B:96:0x027c, B:98:0x028a, B:100:0x0297, B:101:0x02b7, B:86:0x0212, B:87:0x0216, B:80:0x01ff), top: B:119:0x0015 }] */
    /* JADX WARN: Removed duplicated region for block: B:83:0x020c  */
    /* JADX WARN: Removed duplicated region for block: B:84:0x020f  */
    /* JADX WARN: Removed duplicated region for block: B:91:0x0223 A[Catch: all -> 0x02e7, TryCatch #0 {, blocks: (B:6:0x0015, B:8:0x0024, B:12:0x0030, B:14:0x004d, B:15:0x0060, B:17:0x006f, B:19:0x0093, B:24:0x00ca, B:26:0x00ce, B:29:0x00d7, B:31:0x00df, B:34:0x00e4, B:36:0x00ec, B:38:0x00f0, B:41:0x00fc, B:42:0x011a, B:103:0x02cd, B:105:0x02d3, B:107:0x02dc, B:109:0x02e2, B:39:0x00f7, B:44:0x012e, B:45:0x013e, B:47:0x0146, B:50:0x0155, B:51:0x015e, B:53:0x0164, B:56:0x0177, B:58:0x0192, B:65:0x01d2, B:67:0x01d6, B:70:0x01df, B:72:0x01e7, B:75:0x01ec, B:77:0x01f4, B:79:0x01f8, B:81:0x0202, B:89:0x021d, B:91:0x0223, B:93:0x022e, B:95:0x025b, B:96:0x027c, B:98:0x028a, B:100:0x0297, B:101:0x02b7, B:86:0x0212, B:87:0x0216, B:80:0x01ff), top: B:119:0x0015 }] */
    /* JADX WARN: Removed duplicated region for block: B:98:0x028a A[Catch: all -> 0x02e7, TryCatch #0 {, blocks: (B:6:0x0015, B:8:0x0024, B:12:0x0030, B:14:0x004d, B:15:0x0060, B:17:0x006f, B:19:0x0093, B:24:0x00ca, B:26:0x00ce, B:29:0x00d7, B:31:0x00df, B:34:0x00e4, B:36:0x00ec, B:38:0x00f0, B:41:0x00fc, B:42:0x011a, B:103:0x02cd, B:105:0x02d3, B:107:0x02dc, B:109:0x02e2, B:39:0x00f7, B:44:0x012e, B:45:0x013e, B:47:0x0146, B:50:0x0155, B:51:0x015e, B:53:0x0164, B:56:0x0177, B:58:0x0192, B:65:0x01d2, B:67:0x01d6, B:70:0x01df, B:72:0x01e7, B:75:0x01ec, B:77:0x01f4, B:79:0x01f8, B:81:0x0202, B:89:0x021d, B:91:0x0223, B:93:0x022e, B:95:0x025b, B:96:0x027c, B:98:0x028a, B:100:0x0297, B:101:0x02b7, B:86:0x0212, B:87:0x0216, B:80:0x01ff), top: B:119:0x0015 }] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public static synchronized int[] drawText(String str, int i, int i2, int[] iArr, int i3, int i4, int i5, int i6, int i7) {
        InterceptResult invokeCommon;
        int i8;
        Paint.FontMetrics fontMetrics;
        int i9;
        int i10;
        Bitmap bitmap;
        int i11;
        int i12;
        int i13;
        int i14;
        int indexOf;
        int i15;
        Paint.FontMetrics fontMetrics2;
        int i16;
        int desiredWidth;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeCommon = interceptable.invokeCommon(65538, null, new Object[]{str, Integer.valueOf(i), Integer.valueOf(i2), iArr, Integer.valueOf(i3), Integer.valueOf(i4), Integer.valueOf(i5), Integer.valueOf(i6), Integer.valueOf(i7)})) == null) {
            synchronized (EnvDrawText.class) {
                Canvas canvas = new Canvas();
                TextPaint textPaint = new TextPaint();
                String str2 = Build.MODEL;
                if (str2 != null && str2.equals(DEVICE_VIVOX3L)) {
                    i8 = 0;
                } else {
                    i8 = i2;
                }
                textPaint.reset();
                textPaint.setSubpixelText(true);
                textPaint.setAntiAlias(true);
                textPaint.setTextSize(i);
                textPaint.setShadowLayer(0.0f, 0.0f, 0.0f, 0);
                textPaint.setTypeface(getTypeface(i8));
                if (i6 != 0) {
                    textPaint.setStrokeWidth(i6);
                    textPaint.setStrokeCap(Paint.Cap.ROUND);
                    textPaint.setStrokeJoin(Paint.Join.ROUND);
                    textPaint.setStyle(Paint.Style.STROKE);
                }
                int indexOf2 = str.indexOf(92, 0);
                if (indexOf2 == -1) {
                    Paint.FontMetrics fontMetrics3 = textPaint.getFontMetrics();
                    i15 = (int) (Layout.getDesiredWidth(str, 0, str.length(), textPaint) + 0.5d);
                    i10 = (int) Math.ceil(fontMetrics3.descent - fontMetrics3.ascent);
                    iArr[0] = i15;
                    iArr[1] = i10;
                    if (iArr.length == 4) {
                        i15 = (int) Math.pow(2.0d, (int) Math.ceil(Math.log(i15) / Math.log(2.0d)));
                        i10 = (int) Math.pow(2.0d, (int) Math.ceil(Math.log(i10) / Math.log(2.0d)));
                    }
                    if (i15 == 0 && i10 == 0) {
                        i15 = 0;
                        i10 = 0;
                    }
                    if (iArr.length == 4) {
                        iArr[2] = i15;
                        iArr[3] = i10;
                    }
                    if (i15 > 0 && i10 > 0) {
                        Bitmap createBitmap = Bitmap.createBitmap(i15, i10, Bitmap.Config.ARGB_8888);
                        if (createBitmap == null) {
                            return new int[0];
                        }
                        canvas.setBitmap(createBitmap);
                        bitmap = createBitmap;
                    } else {
                        bitmap = null;
                    }
                    if ((i5 & (-16777216)) == 0) {
                        canvas.drawColor(16777215);
                    } else {
                        canvas.drawColor(i5);
                    }
                    if (i6 != 0) {
                        textPaint.setStrokeWidth(i6);
                        textPaint.setStrokeCap(Paint.Cap.ROUND);
                        textPaint.setStrokeJoin(Paint.Join.ROUND);
                        textPaint.setStyle(Paint.Style.STROKE);
                        textPaint.setColor(i4);
                        canvas.drawText(str, 0.0f, 0.0f - fontMetrics3.ascent, textPaint);
                    }
                    textPaint.setStyle(Paint.Style.FILL);
                    textPaint.setColor(i3);
                    canvas.drawText(str, 0.0f, 0.0f - fontMetrics3.ascent, textPaint);
                } else {
                    int i17 = indexOf2 + 1;
                    int desiredWidth2 = (int) (Layout.getDesiredWidth(str.substring(0, indexOf2), textPaint) + 0.5d);
                    int i18 = 2;
                    while (true) {
                        int indexOf3 = str.indexOf(92, i17);
                        if (indexOf3 <= 0) {
                            break;
                        }
                        int desiredWidth3 = (int) (Layout.getDesiredWidth(str.substring(i17, indexOf3), textPaint) + 0.5d);
                        if (desiredWidth3 > desiredWidth2) {
                            desiredWidth2 = desiredWidth3;
                        }
                        i17 = indexOf3 + 1;
                        i18++;
                    }
                    if (i17 != str.length() && (desiredWidth = (int) (Layout.getDesiredWidth(str.substring(i17, str.length()), textPaint) + 0.5d)) > desiredWidth2) {
                        desiredWidth2 = desiredWidth;
                    }
                    Paint.FontMetrics fontMetrics4 = textPaint.getFontMetrics();
                    int ceil = (int) Math.ceil(fontMetrics4.descent - fontMetrics4.ascent);
                    int i19 = i18 * ceil;
                    iArr[0] = desiredWidth2;
                    iArr[1] = i19;
                    if (iArr.length == 4) {
                        fontMetrics = fontMetrics4;
                        i9 = ceil;
                        desiredWidth2 = (int) Math.pow(2.0d, (int) Math.ceil(Math.log(desiredWidth2) / Math.log(2.0d)));
                        i19 = (int) Math.pow(2.0d, (int) Math.ceil(Math.log(i19) / Math.log(2.0d)));
                    } else {
                        fontMetrics = fontMetrics4;
                        i9 = ceil;
                    }
                    if (desiredWidth2 == 0 && i19 == 0) {
                        desiredWidth2 = 0;
                        i10 = 0;
                        if (iArr.length == 4) {
                            iArr[2] = desiredWidth2;
                            iArr[3] = i10;
                        }
                        if (desiredWidth2 <= 0 && i10 > 0) {
                            Bitmap createBitmap2 = Bitmap.createBitmap(desiredWidth2, i10, Bitmap.Config.ARGB_8888);
                            if (createBitmap2 == null) {
                                return new int[0];
                            }
                            canvas.setBitmap(createBitmap2);
                            bitmap = createBitmap2;
                        } else {
                            bitmap = null;
                        }
                        if ((i5 & (-16777216)) != 0) {
                            canvas.drawColor(16777215);
                        } else {
                            canvas.drawColor(i5);
                        }
                        textPaint.setTextAlign(getTextAlignedType(i7));
                        if (i7 != 1) {
                            i12 = 0;
                            i11 = 0;
                        } else if (i7 == 2) {
                            i11 = 0;
                            i12 = iArr[0];
                        } else {
                            i11 = 0;
                            i12 = iArr[0] / 2;
                        }
                        i13 = 92;
                        i14 = 0;
                        while (true) {
                            indexOf = str.indexOf(i13, i14);
                            if (indexOf > 0) {
                                break;
                            }
                            String substring = str.substring(i14, indexOf);
                            Layout.getDesiredWidth(substring, textPaint);
                            int i20 = indexOf + 1;
                            if (i6 != 0) {
                                textPaint.setStrokeWidth(i6);
                                textPaint.setStrokeCap(Paint.Cap.ROUND);
                                textPaint.setStrokeJoin(Paint.Join.ROUND);
                                textPaint.setStyle(Paint.Style.STROKE);
                                textPaint.setColor(i4);
                                fontMetrics2 = fontMetrics;
                                i16 = desiredWidth2;
                                canvas.drawText(substring, i12, (i11 * i9) - fontMetrics2.ascent, textPaint);
                            } else {
                                fontMetrics2 = fontMetrics;
                                i16 = desiredWidth2;
                            }
                            textPaint.setStyle(Paint.Style.FILL);
                            textPaint.setColor(i3);
                            canvas.drawText(substring, i12, (i11 * i9) - fontMetrics2.ascent, textPaint);
                            i11++;
                            desiredWidth2 = i16;
                            i14 = i20;
                            fontMetrics = fontMetrics2;
                            i13 = 92;
                        }
                        Paint.FontMetrics fontMetrics5 = fontMetrics;
                        int i21 = desiredWidth2;
                        if (i14 != str.length()) {
                            String substring2 = str.substring(i14, str.length());
                            Layout.getDesiredWidth(substring2, textPaint);
                            if (i6 != 0) {
                                textPaint.setStrokeWidth(i6);
                                textPaint.setStrokeCap(Paint.Cap.ROUND);
                                textPaint.setStrokeJoin(Paint.Join.ROUND);
                                textPaint.setStyle(Paint.Style.STROKE);
                                textPaint.setColor(i4);
                                canvas.drawText(substring2, i12, (i11 * i9) - fontMetrics5.ascent, textPaint);
                            }
                            textPaint.setStyle(Paint.Style.FILL);
                            textPaint.setColor(i3);
                            canvas.drawText(substring2, i12, (i11 * i9) - fontMetrics5.ascent, textPaint);
                        }
                        i15 = i21;
                    }
                    i10 = i19;
                    if (iArr.length == 4) {
                    }
                    if (desiredWidth2 <= 0) {
                    }
                    bitmap = null;
                    if ((i5 & (-16777216)) != 0) {
                    }
                    textPaint.setTextAlign(getTextAlignedType(i7));
                    if (i7 != 1) {
                    }
                    i13 = 92;
                    i14 = 0;
                    while (true) {
                        indexOf = str.indexOf(i13, i14);
                        if (indexOf > 0) {
                        }
                        textPaint.setStyle(Paint.Style.FILL);
                        textPaint.setColor(i3);
                        canvas.drawText(substring, i12, (i11 * i9) - fontMetrics2.ascent, textPaint);
                        i11++;
                        desiredWidth2 = i16;
                        i14 = i20;
                        fontMetrics = fontMetrics2;
                        i13 = 92;
                    }
                    Paint.FontMetrics fontMetrics52 = fontMetrics;
                    int i212 = desiredWidth2;
                    if (i14 != str.length()) {
                    }
                    i15 = i212;
                }
                Bitmap bitmap2 = bitmap;
                int[] iArr2 = new int[i15 * i10];
                if (bitmap2 != null) {
                    bitmap2.copyPixelsToBuffer(IntBuffer.wrap(iArr2));
                }
                if (bitmap2 != null && !bitmap2.isRecycled()) {
                    bitmap2.recycle();
                }
                return iArr2;
            }
        }
        return (int[]) invokeCommon.objValue;
    }

    /* JADX WARN: Removed duplicated region for block: B:27:0x00d0 A[Catch: all -> 0x02b7, TryCatch #0 {, blocks: (B:6:0x0015, B:8:0x0024, B:12:0x0030, B:14:0x004d, B:15:0x0060, B:17:0x006f, B:19:0x0093, B:25:0x00cc, B:27:0x00d0, B:30:0x00d9, B:34:0x00e3, B:36:0x00e8, B:38:0x00ec, B:41:0x00f8, B:42:0x0116, B:39:0x00f3, B:43:0x0128, B:44:0x0138, B:46:0x0140, B:49:0x014f, B:50:0x0158, B:52:0x015e, B:55:0x0171, B:57:0x018c, B:63:0x01ca, B:65:0x01ce, B:68:0x01d7, B:72:0x01e1, B:74:0x01e9, B:76:0x01ed, B:78:0x01f7, B:86:0x0213, B:88:0x0219, B:90:0x0224, B:92:0x024d, B:93:0x0268, B:95:0x0274, B:97:0x0281, B:98:0x02a1, B:83:0x0207, B:84:0x020b, B:77:0x01f4), top: B:109:0x0015 }] */
    /* JADX WARN: Removed duplicated region for block: B:38:0x00ec A[Catch: all -> 0x02b7, TryCatch #0 {, blocks: (B:6:0x0015, B:8:0x0024, B:12:0x0030, B:14:0x004d, B:15:0x0060, B:17:0x006f, B:19:0x0093, B:25:0x00cc, B:27:0x00d0, B:30:0x00d9, B:34:0x00e3, B:36:0x00e8, B:38:0x00ec, B:41:0x00f8, B:42:0x0116, B:39:0x00f3, B:43:0x0128, B:44:0x0138, B:46:0x0140, B:49:0x014f, B:50:0x0158, B:52:0x015e, B:55:0x0171, B:57:0x018c, B:63:0x01ca, B:65:0x01ce, B:68:0x01d7, B:72:0x01e1, B:74:0x01e9, B:76:0x01ed, B:78:0x01f7, B:86:0x0213, B:88:0x0219, B:90:0x0224, B:92:0x024d, B:93:0x0268, B:95:0x0274, B:97:0x0281, B:98:0x02a1, B:83:0x0207, B:84:0x020b, B:77:0x01f4), top: B:109:0x0015 }] */
    /* JADX WARN: Removed duplicated region for block: B:39:0x00f3 A[Catch: all -> 0x02b7, TryCatch #0 {, blocks: (B:6:0x0015, B:8:0x0024, B:12:0x0030, B:14:0x004d, B:15:0x0060, B:17:0x006f, B:19:0x0093, B:25:0x00cc, B:27:0x00d0, B:30:0x00d9, B:34:0x00e3, B:36:0x00e8, B:38:0x00ec, B:41:0x00f8, B:42:0x0116, B:39:0x00f3, B:43:0x0128, B:44:0x0138, B:46:0x0140, B:49:0x014f, B:50:0x0158, B:52:0x015e, B:55:0x0171, B:57:0x018c, B:63:0x01ca, B:65:0x01ce, B:68:0x01d7, B:72:0x01e1, B:74:0x01e9, B:76:0x01ed, B:78:0x01f7, B:86:0x0213, B:88:0x0219, B:90:0x0224, B:92:0x024d, B:93:0x0268, B:95:0x0274, B:97:0x0281, B:98:0x02a1, B:83:0x0207, B:84:0x020b, B:77:0x01f4), top: B:109:0x0015 }] */
    /* JADX WARN: Removed duplicated region for block: B:41:0x00f8 A[Catch: all -> 0x02b7, TryCatch #0 {, blocks: (B:6:0x0015, B:8:0x0024, B:12:0x0030, B:14:0x004d, B:15:0x0060, B:17:0x006f, B:19:0x0093, B:25:0x00cc, B:27:0x00d0, B:30:0x00d9, B:34:0x00e3, B:36:0x00e8, B:38:0x00ec, B:41:0x00f8, B:42:0x0116, B:39:0x00f3, B:43:0x0128, B:44:0x0138, B:46:0x0140, B:49:0x014f, B:50:0x0158, B:52:0x015e, B:55:0x0171, B:57:0x018c, B:63:0x01ca, B:65:0x01ce, B:68:0x01d7, B:72:0x01e1, B:74:0x01e9, B:76:0x01ed, B:78:0x01f7, B:86:0x0213, B:88:0x0219, B:90:0x0224, B:92:0x024d, B:93:0x0268, B:95:0x0274, B:97:0x0281, B:98:0x02a1, B:83:0x0207, B:84:0x020b, B:77:0x01f4), top: B:109:0x0015 }] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public static synchronized Bitmap drawTextExt(String str, int i, int i2, int[] iArr, int i3, int i4, int i5, int i6, int i7) {
        InterceptResult invokeCommon;
        int i8;
        Paint.FontMetrics fontMetrics;
        int i9;
        Bitmap bitmap;
        int i10;
        int i11;
        Bitmap bitmap2;
        Paint.FontMetrics fontMetrics2;
        int desiredWidth;
        int i12;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeCommon = interceptable.invokeCommon(InputDeviceCompat.SOURCE_TRACKBALL, null, new Object[]{str, Integer.valueOf(i), Integer.valueOf(i2), iArr, Integer.valueOf(i3), Integer.valueOf(i4), Integer.valueOf(i5), Integer.valueOf(i6), Integer.valueOf(i7)})) == null) {
            synchronized (EnvDrawText.class) {
                Canvas canvas = new Canvas();
                TextPaint textPaint = new TextPaint();
                String str2 = Build.MODEL;
                if (str2 != null && str2.equals(DEVICE_VIVOX3L)) {
                    i8 = 0;
                } else {
                    i8 = i2;
                }
                textPaint.reset();
                textPaint.setSubpixelText(true);
                textPaint.setAntiAlias(true);
                textPaint.setTextSize(i);
                textPaint.setShadowLayer(0.0f, 0.0f, 0.0f, 0);
                textPaint.setTypeface(getTypeface(i8));
                if (i6 != 0) {
                    textPaint.setStrokeWidth(i6);
                    textPaint.setStrokeCap(Paint.Cap.ROUND);
                    textPaint.setStrokeJoin(Paint.Join.ROUND);
                    textPaint.setStyle(Paint.Style.STROKE);
                }
                int indexOf = str.indexOf(92, 0);
                if (indexOf == -1) {
                    Paint.FontMetrics fontMetrics3 = textPaint.getFontMetrics();
                    int desiredWidth2 = (int) (Layout.getDesiredWidth(str, 0, str.length(), textPaint) + 0.5d);
                    int ceil = (int) Math.ceil(fontMetrics3.descent - fontMetrics3.ascent);
                    iArr[0] = desiredWidth2;
                    iArr[1] = ceil;
                    if (iArr.length == 4) {
                        desiredWidth2 = (int) Math.pow(2.0d, (int) Math.ceil(Math.log(desiredWidth2) / Math.log(2.0d)));
                        ceil = (int) Math.pow(2.0d, (int) Math.ceil(Math.log(ceil) / Math.log(2.0d)));
                    }
                    if (desiredWidth2 == 0 && ceil == 0) {
                        i12 = 0;
                        ceil = 0;
                        if (iArr.length == 4) {
                            iArr[2] = i12;
                            iArr[3] = ceil;
                        }
                        if (i12 <= 0 && ceil > 0) {
                            bitmap2 = Bitmap.createBitmap(i12, ceil, Bitmap.Config.ARGB_8888);
                            if (bitmap2 == null) {
                                return bitmap2;
                            }
                            canvas.setBitmap(bitmap2);
                        } else {
                            bitmap2 = null;
                        }
                        if ((i5 & (-16777216)) != 0) {
                            canvas.drawColor(16777215);
                        } else {
                            canvas.drawColor(i5);
                        }
                        if (i6 != 0) {
                            textPaint.setStrokeWidth(i6);
                            textPaint.setStrokeCap(Paint.Cap.ROUND);
                            textPaint.setStrokeJoin(Paint.Join.ROUND);
                            textPaint.setStyle(Paint.Style.STROKE);
                            textPaint.setColor(i4);
                            canvas.drawText(str, 0.0f, 0.0f - fontMetrics3.ascent, textPaint);
                        }
                        textPaint.setStyle(Paint.Style.FILL);
                        textPaint.setColor(i3);
                        canvas.drawText(str, 0.0f, 0.0f - fontMetrics3.ascent, textPaint);
                    }
                    i12 = desiredWidth2;
                    if (iArr.length == 4) {
                    }
                    if (i12 <= 0) {
                    }
                    bitmap2 = null;
                    if ((i5 & (-16777216)) != 0) {
                    }
                    if (i6 != 0) {
                    }
                    textPaint.setStyle(Paint.Style.FILL);
                    textPaint.setColor(i3);
                    canvas.drawText(str, 0.0f, 0.0f - fontMetrics3.ascent, textPaint);
                } else {
                    int i13 = indexOf + 1;
                    int desiredWidth3 = (int) (Layout.getDesiredWidth(str.substring(0, indexOf), textPaint) + 0.5d);
                    int i14 = 2;
                    while (true) {
                        int indexOf2 = str.indexOf(92, i13);
                        if (indexOf2 <= 0) {
                            break;
                        }
                        int desiredWidth4 = (int) (Layout.getDesiredWidth(str.substring(i13, indexOf2), textPaint) + 0.5d);
                        if (desiredWidth4 > desiredWidth3) {
                            desiredWidth3 = desiredWidth4;
                        }
                        i13 = indexOf2 + 1;
                        i14++;
                    }
                    if (i13 != str.length() && (desiredWidth = (int) (Layout.getDesiredWidth(str.substring(i13, str.length()), textPaint) + 0.5d)) > desiredWidth3) {
                        desiredWidth3 = desiredWidth;
                    }
                    Paint.FontMetrics fontMetrics4 = textPaint.getFontMetrics();
                    int ceil2 = (int) Math.ceil(fontMetrics4.descent - fontMetrics4.ascent);
                    int i15 = i14 * ceil2;
                    iArr[0] = desiredWidth3;
                    iArr[1] = i15;
                    if (iArr.length == 4) {
                        fontMetrics = fontMetrics4;
                        i9 = ceil2;
                        desiredWidth3 = (int) Math.pow(2.0d, (int) Math.ceil(Math.log(desiredWidth3) / Math.log(2.0d)));
                        i15 = (int) Math.pow(2.0d, (int) Math.ceil(Math.log(i15) / Math.log(2.0d)));
                    } else {
                        fontMetrics = fontMetrics4;
                        i9 = ceil2;
                    }
                    if (desiredWidth3 == 0 && i15 == 0) {
                        desiredWidth3 = 0;
                        i15 = 0;
                    }
                    if (iArr.length == 4) {
                        iArr[2] = desiredWidth3;
                        iArr[3] = i15;
                    }
                    if (desiredWidth3 > 0 && i15 > 0) {
                        Bitmap createBitmap = Bitmap.createBitmap(desiredWidth3, i15, Bitmap.Config.ARGB_8888);
                        if (createBitmap == null) {
                            return createBitmap;
                        }
                        canvas.setBitmap(createBitmap);
                        bitmap = createBitmap;
                    } else {
                        bitmap = null;
                    }
                    if ((i5 & (-16777216)) == 0) {
                        canvas.drawColor(16777215);
                    } else {
                        canvas.drawColor(i5);
                    }
                    textPaint.setTextAlign(getTextAlignedType(i7));
                    if (i7 == 1) {
                        i10 = 0;
                        i11 = 0;
                    } else if (i7 == 2) {
                        i10 = 0;
                        i11 = iArr[0];
                    } else {
                        i10 = 0;
                        i11 = iArr[0] / 2;
                    }
                    int i16 = 92;
                    int i17 = 0;
                    while (true) {
                        int indexOf3 = str.indexOf(i16, i17);
                        if (indexOf3 <= 0) {
                            break;
                        }
                        String substring = str.substring(i17, indexOf3);
                        Layout.getDesiredWidth(substring, textPaint);
                        i17 = indexOf3 + 1;
                        if (i6 != 0) {
                            textPaint.setStrokeWidth(i6);
                            textPaint.setStrokeCap(Paint.Cap.ROUND);
                            textPaint.setStrokeJoin(Paint.Join.ROUND);
                            textPaint.setStyle(Paint.Style.STROKE);
                            textPaint.setColor(i4);
                            fontMetrics2 = fontMetrics;
                            canvas.drawText(substring, i11, (i10 * i9) - fontMetrics2.ascent, textPaint);
                        } else {
                            fontMetrics2 = fontMetrics;
                        }
                        textPaint.setStyle(Paint.Style.FILL);
                        textPaint.setColor(i3);
                        canvas.drawText(substring, i11, (i10 * i9) - fontMetrics2.ascent, textPaint);
                        i10++;
                        fontMetrics = fontMetrics2;
                        i16 = 92;
                    }
                    Paint.FontMetrics fontMetrics5 = fontMetrics;
                    if (i17 != str.length()) {
                        String substring2 = str.substring(i17, str.length());
                        Layout.getDesiredWidth(substring2, textPaint);
                        if (i6 != 0) {
                            textPaint.setStrokeWidth(i6);
                            textPaint.setStrokeCap(Paint.Cap.ROUND);
                            textPaint.setStrokeJoin(Paint.Join.ROUND);
                            textPaint.setStyle(Paint.Style.STROKE);
                            textPaint.setColor(i4);
                            canvas.drawText(substring2, i11, (i10 * i9) - fontMetrics5.ascent, textPaint);
                        }
                        textPaint.setStyle(Paint.Style.FILL);
                        textPaint.setColor(i3);
                        canvas.drawText(substring2, i11, (i10 * i9) - fontMetrics5.ascent, textPaint);
                    }
                    bitmap2 = bitmap;
                }
                return bitmap2;
            }
        }
        return (Bitmap) invokeCommon.objValue;
    }

    public static Bitmap drawTextAlpha(String str, int i, int i2, int i3) {
        InterceptResult invokeLIII;
        int i4;
        int desiredWidth;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLIII = interceptable.invokeLIII(65539, null, str, i, i2, i3)) == null) {
            Canvas canvas = new Canvas();
            TextPaint textPaint = new TextPaint();
            String str2 = Build.MODEL;
            int i5 = 0;
            if (str2 != null && str2.equals(DEVICE_VIVOX3L)) {
                i4 = 0;
            } else {
                i4 = i2;
            }
            textPaint.reset();
            textPaint.setSubpixelText(false);
            textPaint.setAntiAlias(false);
            textPaint.setTextSize(i);
            textPaint.setTypeface(getTypeface(i4));
            float f = (i3 * 1.3f) + 0.5f;
            int i6 = 92;
            int indexOf = str.indexOf(92, 0);
            Bitmap bitmap = null;
            if (indexOf == -1) {
                Paint.FontMetrics fontMetrics = textPaint.getFontMetrics();
                int desiredWidth2 = (int) (Layout.getDesiredWidth(str, 0, str.length(), textPaint) + f);
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
                canvas.drawText(str, f * 0.5f, 0.0f - fontMetrics.ascent, textPaint);
            } else {
                int i7 = indexOf + 1;
                int i8 = 2;
                int desiredWidth3 = (int) (Layout.getDesiredWidth(str.substring(0, indexOf), textPaint) + 0.5d);
                while (true) {
                    int indexOf2 = str.indexOf(i6, i7);
                    if (indexOf2 <= 0) {
                        break;
                    }
                    int desiredWidth4 = (int) (Layout.getDesiredWidth(str.substring(i7, indexOf2), textPaint) + 0.5d);
                    if (desiredWidth4 > desiredWidth3) {
                        desiredWidth3 = desiredWidth4;
                    }
                    i7 = indexOf2 + 1;
                    i8++;
                    i6 = 92;
                }
                if (i7 != str.length() && (desiredWidth = (int) (Layout.getDesiredWidth(str.substring(i7, str.length()), textPaint) + 0.5d)) > desiredWidth3) {
                    desiredWidth3 = desiredWidth;
                }
                Paint.FontMetrics fontMetrics2 = textPaint.getFontMetrics();
                int ceil2 = (int) Math.ceil(fontMetrics2.descent - fontMetrics2.ascent);
                int i9 = desiredWidth3 + i3;
                int i10 = i8 * ceil2;
                if (i9 > 0 && i10 > 0) {
                    bitmap = Bitmap.createBitmap(i9, i10, Bitmap.Config.ALPHA_8);
                    if (bitmap == null) {
                        return bitmap;
                    }
                    bitmap.eraseColor(0);
                    canvas.setBitmap(bitmap);
                }
                textPaint.setTextAlign(getTextAlignedType(3));
                float f2 = i9 - (f * 0.5f);
                int i11 = 0;
                while (true) {
                    int indexOf3 = str.indexOf(92, i5);
                    if (indexOf3 <= 0) {
                        break;
                    }
                    String substring = str.substring(i5, indexOf3);
                    Layout.getDesiredWidth(substring, textPaint);
                    textPaint.setStyle(Paint.Style.FILL);
                    canvas.drawText(substring, f2, (i11 * ceil2) - fontMetrics2.ascent, textPaint);
                    i11++;
                    i5 = indexOf3 + 1;
                }
                if (i5 != str.length()) {
                    String substring2 = str.substring(i5, str.length());
                    Layout.getDesiredWidth(substring2, textPaint);
                    textPaint.setStyle(Paint.Style.FILL);
                    canvas.drawText(substring2, f2, (i11 * ceil2) - fontMetrics2.ascent, textPaint);
                }
            }
            return bitmap;
        }
        return (Bitmap) invokeLIII.objValue;
    }

    public static Paint.Align getTextAlignedType(int i) {
        InterceptResult invokeI;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeI = interceptable.invokeI(65541, null, i)) == null) {
            if (1 == i) {
                return Paint.Align.LEFT;
            }
            if (2 == i) {
                return Paint.Align.RIGHT;
            }
            return Paint.Align.CENTER;
        }
        return (Paint.Align) invokeI.objValue;
    }

    public static Typeface getTypeface(int i) {
        InterceptResult invokeI;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeI = interceptable.invokeI(65545, null, i)) == null) {
            Typeface typeface = Typeface.DEFAULT;
            if (i != 1) {
                if (i == 2) {
                    return Typeface.create(typeface, 2);
                }
                return typeface;
            }
            return Typeface.DEFAULT_BOLD;
        }
        return (Typeface) invokeI.objValue;
    }

    public static synchronized void removeFontCache(int i) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(65549, null, i) == null) {
            synchronized (EnvDrawText.class) {
                a aVar = fontCache.get(i);
                if (aVar == null) {
                    return;
                }
                int i2 = aVar.b - 1;
                aVar.b = i2;
                if (i2 == 0) {
                    fontCache.remove(i);
                }
            }
        }
    }

    public static void setContext(Context context) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(65550, null, context) == null) {
            mContext = context;
        }
    }

    public static Bitmap getTextBitmap() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(65542, null)) == null) {
            Paint paint = new Paint();
            paint.setSubpixelText(true);
            paint.setAntiAlias(false);
            paint.setTextSize(12.0f);
            paint.setTypeface(Typeface.DEFAULT);
            float measureText = paint.measureText("!");
            float descent = paint.descent() - paint.ascent();
            if (measureText <= 0.0f) {
                measureText = 3.0f;
            }
            if (descent <= 0.0f) {
                descent = 15.0f;
            }
            Bitmap createBitmap = Bitmap.createBitmap((int) Math.ceil(measureText), (int) Math.ceil(descent), Bitmap.Config.ALPHA_8);
            createBitmap.eraseColor(0);
            Canvas canvas = new Canvas();
            canvas.setBitmap(createBitmap);
            canvas.drawText("!", 0.0f, 0.0f - paint.ascent(), paint);
            return createBitmap;
        }
        return (Bitmap) invokeV.objValue;
    }

    public static short[] getTextSize(String str, int i, int i2) {
        InterceptResult invokeLII;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLII = interceptable.invokeLII(65543, null, str, i, i2)) == null) {
            int length = str.length();
            if (length == 0) {
                return null;
            }
            TextPaint textPaint = new TextPaint();
            textPaint.setSubpixelText(true);
            textPaint.setAntiAlias(true);
            textPaint.setTextSize(i);
            textPaint.setTypeface(getTypeface(i2));
            short[] sArr = new short[length];
            int i3 = 0;
            while (i3 < length) {
                int i4 = i3 + 1;
                sArr[i3] = (short) (Layout.getDesiredWidth(str, 0, i4, textPaint) + 0.5d);
                i3 = i4;
            }
            return sArr;
        }
        return (short[]) invokeLII.objValue;
    }

    public static float[] getTextSizeExt(String str, int i, int i2) {
        InterceptResult invokeLII;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLII = interceptable.invokeLII(65544, null, str, i, i2)) == null) {
            if (str.length() == 0) {
                return null;
            }
            Paint paint = new Paint();
            paint.setSubpixelText(true);
            paint.setAntiAlias(true);
            paint.setTextSize(i);
            paint.setTypeface(getTypeface(i2));
            return new float[]{paint.measureText(str), paint.descent() - paint.ascent()};
        }
        return (float[]) invokeLII.objValue;
    }

    public static synchronized boolean isSystemFontChanged() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(65546, null)) == null) {
            synchronized (EnvDrawText.class) {
                if (defaultFontBmp == null) {
                    defaultFontBmp = getTextBitmap();
                    return false;
                }
                Bitmap textBitmap = getTextBitmap();
                if (!nativeIsBitmapSame(textBitmap, defaultFontBmp)) {
                    defaultFontBmp.recycle();
                    defaultFontBmp = Bitmap.createBitmap(textBitmap);
                    textBitmap.recycle();
                    return true;
                }
                textBitmap.recycle();
                return false;
            }
        }
        return invokeV.booleanValue;
    }

    public static synchronized void registFontCache(int i, Typeface typeface) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeIL(65548, null, i, typeface) == null) {
            synchronized (EnvDrawText.class) {
                if (i != 0 && typeface != null) {
                    if (fontCache == null) {
                        fontCache = new SparseArray<>();
                    }
                    a aVar = fontCache.get(i);
                    if (aVar == null) {
                        a aVar2 = new a();
                        aVar2.a = typeface;
                        aVar2.b++;
                        fontCache.put(i, aVar2);
                    } else {
                        aVar.b++;
                    }
                }
            }
        }
    }
}
