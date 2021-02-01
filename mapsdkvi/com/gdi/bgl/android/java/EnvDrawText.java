package mapsdkvi.com.gdi.bgl.android.java;

import android.graphics.Bitmap;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.Typeface;
import android.text.Layout;
import android.text.TextPaint;
import android.util.SparseArray;
import androidx.core.view.ViewCompat;
import com.baidu.mapapi.common.SysOSUtil;
import java.nio.IntBuffer;
/* loaded from: classes4.dex */
public class EnvDrawText {

    /* renamed from: a  reason: collision with root package name */
    private static final String f14402a = EnvDrawText.class.getSimpleName();
    public static boolean bBmpChange = false;
    public static Bitmap bmp = null;
    public static int[] buffer = null;
    public static SparseArray<a> fontCache = null;

    /* JADX WARN: Removed duplicated region for block: B:60:0x0185 A[Catch: all -> 0x0123, TryCatch #0 {, blocks: (B:5:0x0006, B:11:0x0019, B:13:0x001f, B:16:0x002a, B:17:0x0042, B:18:0x0045, B:20:0x0051, B:21:0x0066, B:23:0x0070, B:25:0x0074, B:27:0x0080, B:28:0x0085, B:30:0x0097, B:32:0x00c2, B:36:0x00fa, B:38:0x0100, B:41:0x010a, B:43:0x0112, B:50:0x0132, B:51:0x0136, B:53:0x013c, B:56:0x0146, B:57:0x016a, B:58:0x017f, B:60:0x0185, B:62:0x018e, B:64:0x0194, B:65:0x0199, B:66:0x019f, B:67:0x01af, B:69:0x01b9, B:71:0x01c6, B:73:0x01ce, B:75:0x01d4, B:78:0x01ea, B:80:0x0207, B:84:0x0245, B:86:0x024b, B:89:0x0255, B:91:0x025d, B:92:0x0262, B:93:0x0265, B:95:0x026b, B:96:0x0271, B:100:0x0280, B:102:0x028a, B:105:0x029b, B:106:0x02c2, B:108:0x02ce, B:109:0x02db, B:115:0x02f3, B:117:0x02f9, B:120:0x0311, B:121:0x0335, B:123:0x0341, B:113:0x02e9, B:114:0x02ed, B:110:0x02de, B:44:0x0117, B:49:0x0126, B:8:0x0014), top: B:127:0x0006 }] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public static synchronized int[] drawText(String str, int i, int i2, int[] iArr, int i3, int i4, int i5, int i6, int i7) {
        int[] iArr2;
        int ceil;
        Bitmap bitmap;
        int desiredWidth;
        Bitmap bitmap2;
        a aVar;
        synchronized (EnvDrawText.class) {
            int i8 = 0;
            int i9 = 0;
            Canvas canvas = new Canvas();
            TextPaint textPaint = new TextPaint();
            if (canvas == null || textPaint == null) {
                iArr2 = new int[0];
            } else {
                String phoneType = SysOSUtil.getPhoneType();
                if (phoneType != null && phoneType.equals("vivo X3L")) {
                    i2 = 0;
                }
                textPaint.reset();
                textPaint.setSubpixelText(true);
                textPaint.setAntiAlias(true);
                textPaint.setTextSize(i);
                textPaint.setShadowLayer(0.0f, 0.0f, 0.0f, 0);
                switch (i2) {
                    case 1:
                        textPaint.setTypeface(Typeface.create(Typeface.DEFAULT, 1));
                        break;
                    case 2:
                        textPaint.setTypeface(Typeface.create(Typeface.DEFAULT, 2));
                        break;
                    default:
                        textPaint.setTypeface(Typeface.create(Typeface.DEFAULT, 0));
                        break;
                }
                if (i6 != 0) {
                    textPaint.setStrokeWidth(i6);
                    textPaint.setStrokeCap(Paint.Cap.ROUND);
                    textPaint.setStrokeJoin(Paint.Join.ROUND);
                    textPaint.setStyle(Paint.Style.STROKE);
                }
                textPaint.setSubpixelText(true);
                textPaint.setAntiAlias(true);
                if (i2 != 0 && fontCache != null && (aVar = fontCache.get(i2)) != null) {
                    textPaint.setTypeface(aVar.f14403a);
                }
                textPaint.setTextSize(i);
                int indexOf = str.indexOf(92, 0);
                if (indexOf == -1) {
                    Paint.FontMetrics fontMetrics = textPaint.getFontMetrics();
                    int desiredWidth2 = (int) (Layout.getDesiredWidth(str, 0, str.length(), textPaint) + 0.5d);
                    int ceil2 = (int) Math.ceil(fontMetrics.descent - fontMetrics.ascent);
                    iArr[0] = desiredWidth2;
                    iArr[1] = ceil2;
                    if (iArr.length == 4) {
                        desiredWidth2 = (int) Math.pow(2.0d, (int) Math.ceil(Math.log(desiredWidth2) / Math.log(2.0d)));
                        ceil2 = (int) Math.pow(2.0d, (int) Math.ceil(Math.log(ceil2) / Math.log(2.0d)));
                    }
                    if (0 != desiredWidth2 || 0 != ceil2) {
                        i9 = ceil2;
                        i8 = desiredWidth2;
                    }
                    if (iArr.length == 4) {
                        iArr[2] = i8;
                        iArr[3] = i9;
                    }
                    if (i8 <= 0 || i9 <= 0) {
                        bitmap2 = null;
                    } else {
                        Bitmap createBitmap = Bitmap.createBitmap(i8, i9, Bitmap.Config.ARGB_8888);
                        if (createBitmap == null) {
                            iArr2 = new int[0];
                        } else {
                            canvas.setBitmap(createBitmap);
                            bitmap2 = createBitmap;
                        }
                    }
                    if (((-16777216) & i5) == 0) {
                        canvas.drawColor(ViewCompat.MEASURED_SIZE_MASK);
                    } else {
                        canvas.drawColor(i5);
                    }
                    if (i6 != 0 && canvas != null) {
                        textPaint.setStrokeWidth(i6);
                        textPaint.setStrokeCap(Paint.Cap.ROUND);
                        textPaint.setStrokeJoin(Paint.Join.ROUND);
                        textPaint.setStyle(Paint.Style.STROKE);
                        textPaint.setColor(i4);
                        canvas.drawText(str, 0.0f, 0.0f - fontMetrics.ascent, textPaint);
                    }
                    textPaint.setStyle(Paint.Style.FILL);
                    textPaint.setColor(i3);
                    canvas.drawText(str, 0.0f, 0.0f - fontMetrics.ascent, textPaint);
                    bitmap = bitmap2;
                    iArr2 = new int[i8 * i9];
                    if (bitmap != null) {
                        bitmap.copyPixelsToBuffer(IntBuffer.wrap(iArr2));
                    }
                    if (bitmap != null && !bitmap.isRecycled()) {
                        bitmap.recycle();
                    }
                } else {
                    int i10 = indexOf + 1;
                    int measureText = (int) textPaint.measureText(str.substring(0, indexOf));
                    int i11 = 2;
                    while (true) {
                        int indexOf2 = str.indexOf(92, i10);
                        if (indexOf2 > 0) {
                            int measureText2 = (int) textPaint.measureText(str.substring(i10, indexOf2));
                            if (measureText2 <= measureText) {
                                measureText2 = measureText;
                            }
                            i10 = indexOf2 + 1;
                            i11++;
                            measureText = measureText2;
                        } else {
                            if (i10 != str.length() && (desiredWidth = (int) (Layout.getDesiredWidth(str.substring(i10, str.length()), textPaint) + 0.5d)) > measureText) {
                                measureText = desiredWidth;
                            }
                            Paint.FontMetrics fontMetrics2 = textPaint.getFontMetrics();
                            int ceil3 = ((int) Math.ceil(fontMetrics2.descent - fontMetrics2.ascent)) * i11;
                            iArr[0] = measureText;
                            iArr[1] = ceil3;
                            if (iArr.length == 4) {
                                measureText = (int) Math.pow(2.0d, (int) Math.ceil(Math.log(measureText) / Math.log(2.0d)));
                                ceil3 = (int) Math.pow(2.0d, (int) Math.ceil(Math.log(ceil3) / Math.log(2.0d)));
                            }
                            if (0 != measureText || 0 != ceil3) {
                                i9 = ceil3;
                                i8 = measureText;
                            }
                            if (iArr.length == 4) {
                                iArr[2] = i8;
                                iArr[3] = i9;
                            }
                            if (i8 <= 0 || i9 <= 0) {
                                bitmap = null;
                            } else {
                                bitmap = Bitmap.createBitmap(i8, i9, Bitmap.Config.ARGB_8888);
                                if (bitmap == null) {
                                    iArr2 = new int[0];
                                } else {
                                    canvas.setBitmap(bitmap);
                                }
                            }
                            if (((-16777216) & i5) == 0) {
                                canvas.drawColor(ViewCompat.MEASURED_SIZE_MASK);
                            } else {
                                canvas.drawColor(i5);
                            }
                            textPaint.setTextAlign(getTextAlignedType(i7));
                            int i12 = i7 == 1 ? 0 : i7 == 2 ? iArr[0] : iArr[0] / 2;
                            int i13 = 0;
                            int i14 = 0;
                            while (true) {
                                int indexOf3 = str.indexOf(92, i13);
                                if (indexOf3 > 0) {
                                    String substring = str.substring(i13, indexOf3);
                                    int measureText3 = (int) textPaint.measureText(substring);
                                    i13 = indexOf3 + 1;
                                    if (i6 != 0 && canvas != null) {
                                        textPaint.setStrokeWidth(i6);
                                        textPaint.setStrokeCap(Paint.Cap.ROUND);
                                        textPaint.setStrokeJoin(Paint.Join.ROUND);
                                        textPaint.setStyle(Paint.Style.STROKE);
                                        textPaint.setColor(i4);
                                        canvas.drawText(substring, i12, (i14 * ceil) - fontMetrics2.ascent, textPaint);
                                    }
                                    textPaint.setStyle(Paint.Style.FILL);
                                    textPaint.setColor(i3);
                                    if (canvas != null) {
                                        canvas.drawText(substring, i12, (i14 * ceil) - fontMetrics2.ascent, textPaint);
                                    }
                                    i14++;
                                } else {
                                    if (i13 != str.length()) {
                                        String substring2 = str.substring(i13, str.length());
                                        int desiredWidth3 = (int) (Layout.getDesiredWidth(substring2, textPaint) + 0.5d);
                                        if (i6 != 0 && canvas != null) {
                                            textPaint.setStrokeWidth(i6);
                                            textPaint.setStrokeCap(Paint.Cap.ROUND);
                                            textPaint.setStrokeJoin(Paint.Join.ROUND);
                                            textPaint.setStyle(Paint.Style.STROKE);
                                            textPaint.setColor(i4);
                                            canvas.drawText(substring2, i12, (i14 * ceil) - fontMetrics2.ascent, textPaint);
                                        }
                                        textPaint.setStyle(Paint.Style.FILL);
                                        textPaint.setColor(i3);
                                        if (canvas != null) {
                                            canvas.drawText(substring2, i12, (i14 * ceil) - fontMetrics2.ascent, textPaint);
                                        }
                                    }
                                    iArr2 = new int[i8 * i9];
                                    if (bitmap != null) {
                                    }
                                    if (bitmap != null) {
                                        bitmap.recycle();
                                    }
                                }
                            }
                        }
                    }
                }
            }
        }
        return iArr2;
    }

    public static Bitmap drawTextAlpha(String str, int i, int i2, int i3) {
        int desiredWidth;
        Bitmap bitmap = null;
        Canvas canvas = new Canvas();
        TextPaint textPaint = new TextPaint();
        if (canvas == null || textPaint == null) {
            return null;
        }
        String phoneType = SysOSUtil.getPhoneType();
        if (phoneType != null && phoneType.equals("vivo X3L")) {
            i2 = 0;
        }
        textPaint.reset();
        textPaint.setSubpixelText(false);
        textPaint.setAntiAlias(false);
        textPaint.setTextSize(i);
        switch (i2) {
            case 1:
                textPaint.setTypeface(Typeface.create(Typeface.DEFAULT, 1));
                break;
            case 2:
                textPaint.setTypeface(Typeface.create(Typeface.DEFAULT, 2));
                break;
            default:
                textPaint.setTypeface(Typeface.create(Typeface.DEFAULT, 0));
                break;
        }
        float f = (i3 * 1.3f) + 0.5f;
        int indexOf = str.indexOf(92, 0);
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
            canvas.drawText(str, 0.5f * f, 0.0f - fontMetrics.ascent, textPaint);
            return bitmap;
        }
        int i4 = indexOf + 1;
        int i5 = 2;
        int desiredWidth3 = (int) (Layout.getDesiredWidth(str.substring(0, indexOf), textPaint) + 0.5d);
        while (true) {
            int indexOf2 = str.indexOf(92, i4);
            if (indexOf2 > 0) {
                int desiredWidth4 = (int) (Layout.getDesiredWidth(str.substring(i4, indexOf2), textPaint) + 0.5d);
                if (desiredWidth4 > desiredWidth3) {
                    desiredWidth3 = desiredWidth4;
                }
                i4 = indexOf2 + 1;
                i5++;
            } else {
                if (i4 != str.length() && (desiredWidth = (int) (Layout.getDesiredWidth(str.substring(i4, str.length()), textPaint) + 0.5d)) > desiredWidth3) {
                    desiredWidth3 = desiredWidth;
                }
                Paint.FontMetrics fontMetrics2 = textPaint.getFontMetrics();
                int ceil2 = (int) Math.ceil(fontMetrics2.descent - fontMetrics2.ascent);
                int i6 = desiredWidth3 + i3;
                int i7 = i5 * ceil2;
                if (i6 > 0 && i7 > 0) {
                    bitmap = Bitmap.createBitmap(i6, i7, Bitmap.Config.ALPHA_8);
                    if (bitmap == null) {
                        return bitmap;
                    }
                    bitmap.eraseColor(0);
                    canvas.setBitmap(bitmap);
                }
                textPaint.setTextAlign(getTextAlignedType(3));
                float f2 = i6 - (0.5f * f);
                int i8 = 0;
                int i9 = 0;
                while (true) {
                    int indexOf3 = str.indexOf(92, i8);
                    if (indexOf3 <= 0) {
                        if (i8 != str.length()) {
                            String substring = str.substring(i8, str.length());
                            int desiredWidth5 = (int) (Layout.getDesiredWidth(substring, textPaint) + 0.5d);
                            textPaint.setStyle(Paint.Style.FILL);
                            if (canvas != null) {
                                canvas.drawText(substring, f2, (i9 * ceil2) - fontMetrics2.ascent, textPaint);
                                return bitmap;
                            }
                            return bitmap;
                        }
                        return bitmap;
                    }
                    String substring2 = str.substring(i8, indexOf3);
                    int desiredWidth6 = (int) (Layout.getDesiredWidth(substring2, textPaint) + 0.5d);
                    i8 = indexOf3 + 1;
                    textPaint.setStyle(Paint.Style.FILL);
                    if (canvas != null) {
                        canvas.drawText(substring2, f2, (i9 * ceil2) - fontMetrics2.ascent, textPaint);
                    }
                    i9++;
                }
            }
        }
    }

    public static synchronized Bitmap drawTextExt(String str, int i, int i2, int[] iArr, int i3, int i4, int i5, int i6, int i7) {
        Bitmap bitmap;
        int ceil;
        Bitmap bitmap2;
        int desiredWidth;
        synchronized (EnvDrawText.class) {
            int i8 = 0;
            int i9 = 0;
            Canvas canvas = new Canvas();
            TextPaint textPaint = new TextPaint();
            if (canvas == null || textPaint == null) {
                bitmap = null;
            } else {
                String phoneType = SysOSUtil.getPhoneType();
                if (phoneType != null && phoneType.equals("vivo X3L")) {
                    i2 = 0;
                }
                textPaint.reset();
                textPaint.setSubpixelText(true);
                textPaint.setAntiAlias(true);
                textPaint.setTextSize(i);
                textPaint.setShadowLayer(0.0f, 0.0f, 0.0f, 0);
                switch (i2) {
                    case 1:
                        textPaint.setTypeface(Typeface.create(Typeface.DEFAULT, 1));
                        break;
                    case 2:
                        textPaint.setTypeface(Typeface.create(Typeface.DEFAULT, 2));
                        break;
                    default:
                        textPaint.setTypeface(Typeface.create(Typeface.DEFAULT, 0));
                        break;
                }
                if (i6 != 0) {
                    textPaint.setStrokeWidth(i6);
                    textPaint.setStrokeCap(Paint.Cap.ROUND);
                    textPaint.setStrokeJoin(Paint.Join.ROUND);
                    textPaint.setStyle(Paint.Style.STROKE);
                }
                int indexOf = str.indexOf(92, 0);
                if (indexOf == -1) {
                    Paint.FontMetrics fontMetrics = textPaint.getFontMetrics();
                    int desiredWidth2 = (int) (Layout.getDesiredWidth(str, 0, str.length(), textPaint) + 0.5d);
                    int ceil2 = (int) Math.ceil(fontMetrics.descent - fontMetrics.ascent);
                    iArr[0] = desiredWidth2;
                    iArr[1] = ceil2;
                    if (iArr.length == 4) {
                        desiredWidth2 = (int) Math.pow(2.0d, (int) Math.ceil(Math.log(desiredWidth2) / Math.log(2.0d)));
                        ceil2 = (int) Math.pow(2.0d, (int) Math.ceil(Math.log(ceil2) / Math.log(2.0d)));
                    }
                    if (0 != desiredWidth2 || 0 != ceil2) {
                        i9 = ceil2;
                        i8 = desiredWidth2;
                    }
                    if (iArr.length == 4) {
                        iArr[2] = i8;
                        iArr[3] = i9;
                    }
                    if (i8 <= 0 || i9 <= 0) {
                        bitmap = null;
                    } else {
                        bitmap = Bitmap.createBitmap(i8, i9, Bitmap.Config.ARGB_8888);
                        if (bitmap != null) {
                            canvas.setBitmap(bitmap);
                        }
                    }
                    if (((-16777216) & i5) == 0) {
                        canvas.drawColor(ViewCompat.MEASURED_SIZE_MASK);
                    } else {
                        canvas.drawColor(i5);
                    }
                    if (i6 != 0 && canvas != null) {
                        textPaint.setStrokeWidth(i6);
                        textPaint.setStrokeCap(Paint.Cap.ROUND);
                        textPaint.setStrokeJoin(Paint.Join.ROUND);
                        textPaint.setStyle(Paint.Style.STROKE);
                        textPaint.setColor(i4);
                        canvas.drawText(str, 0.0f, 0.0f - fontMetrics.ascent, textPaint);
                    }
                    textPaint.setStyle(Paint.Style.FILL);
                    textPaint.setColor(i3);
                    canvas.drawText(str, 0.0f, 0.0f - fontMetrics.ascent, textPaint);
                } else {
                    int i10 = indexOf + 1;
                    int desiredWidth3 = (int) (Layout.getDesiredWidth(str.substring(0, indexOf), textPaint) + 0.5d);
                    int i11 = 2;
                    while (true) {
                        int indexOf2 = str.indexOf(92, i10);
                        if (indexOf2 > 0) {
                            int desiredWidth4 = (int) (Layout.getDesiredWidth(str.substring(i10, indexOf2), textPaint) + 0.5d);
                            if (desiredWidth4 <= desiredWidth3) {
                                desiredWidth4 = desiredWidth3;
                            }
                            i10 = indexOf2 + 1;
                            i11++;
                            desiredWidth3 = desiredWidth4;
                        } else {
                            if (i10 != str.length() && (desiredWidth = (int) (Layout.getDesiredWidth(str.substring(i10, str.length()), textPaint) + 0.5d)) > desiredWidth3) {
                                desiredWidth3 = desiredWidth;
                            }
                            Paint.FontMetrics fontMetrics2 = textPaint.getFontMetrics();
                            int ceil3 = ((int) Math.ceil(fontMetrics2.descent - fontMetrics2.ascent)) * i11;
                            iArr[0] = desiredWidth3;
                            iArr[1] = ceil3;
                            if (iArr.length == 4) {
                                desiredWidth3 = (int) Math.pow(2.0d, (int) Math.ceil(Math.log(desiredWidth3) / Math.log(2.0d)));
                                ceil3 = (int) Math.pow(2.0d, (int) Math.ceil(Math.log(ceil3) / Math.log(2.0d)));
                            }
                            if (0 == desiredWidth3 && 0 == ceil3) {
                                ceil3 = 0;
                                desiredWidth3 = 0;
                            }
                            if (iArr.length == 4) {
                                iArr[2] = desiredWidth3;
                                iArr[3] = ceil3;
                            }
                            if (desiredWidth3 <= 0 || ceil3 <= 0) {
                                bitmap2 = null;
                            } else {
                                bitmap = Bitmap.createBitmap(desiredWidth3, ceil3, Bitmap.Config.ARGB_8888);
                                if (bitmap != null) {
                                    canvas.setBitmap(bitmap);
                                    bitmap2 = bitmap;
                                }
                            }
                            if (((-16777216) & i5) == 0) {
                                canvas.drawColor(ViewCompat.MEASURED_SIZE_MASK);
                            } else {
                                canvas.drawColor(i5);
                            }
                            textPaint.setTextAlign(getTextAlignedType(i7));
                            int i12 = i7 == 1 ? 0 : i7 == 2 ? iArr[0] : iArr[0] / 2;
                            int i13 = 0;
                            int i14 = 0;
                            while (true) {
                                int indexOf3 = str.indexOf(92, i13);
                                if (indexOf3 > 0) {
                                    String substring = str.substring(i13, indexOf3);
                                    int desiredWidth5 = (int) (Layout.getDesiredWidth(substring, textPaint) + 0.5d);
                                    i13 = indexOf3 + 1;
                                    if (i6 != 0 && canvas != null) {
                                        textPaint.setStrokeWidth(i6);
                                        textPaint.setStrokeCap(Paint.Cap.ROUND);
                                        textPaint.setStrokeJoin(Paint.Join.ROUND);
                                        textPaint.setStyle(Paint.Style.STROKE);
                                        textPaint.setColor(i4);
                                        canvas.drawText(substring, i12, (i14 * ceil) - fontMetrics2.ascent, textPaint);
                                    }
                                    textPaint.setStyle(Paint.Style.FILL);
                                    textPaint.setColor(i3);
                                    if (canvas != null) {
                                        canvas.drawText(substring, i12, (i14 * ceil) - fontMetrics2.ascent, textPaint);
                                    }
                                    i14++;
                                } else {
                                    if (i13 != str.length()) {
                                        String substring2 = str.substring(i13, str.length());
                                        int desiredWidth6 = (int) (Layout.getDesiredWidth(substring2, textPaint) + 0.5d);
                                        if (i6 != 0 && canvas != null) {
                                            textPaint.setStrokeWidth(i6);
                                            textPaint.setStrokeCap(Paint.Cap.ROUND);
                                            textPaint.setStrokeJoin(Paint.Join.ROUND);
                                            textPaint.setStyle(Paint.Style.STROKE);
                                            textPaint.setColor(i4);
                                            canvas.drawText(substring2, i12, (i14 * ceil) - fontMetrics2.ascent, textPaint);
                                        }
                                        textPaint.setStyle(Paint.Style.FILL);
                                        textPaint.setColor(i3);
                                        if (canvas != null) {
                                            canvas.drawText(substring2, i12, (i14 * ceil) - fontMetrics2.ascent, textPaint);
                                        }
                                    }
                                    bitmap = bitmap2;
                                }
                            }
                        }
                    }
                }
            }
        }
        return bitmap;
    }

    private static Paint.Align getTextAlignedType(int i) {
        return 1 == i ? Paint.Align.LEFT : 2 == i ? Paint.Align.RIGHT : Paint.Align.CENTER;
    }

    public static short[] getTextSize(String str, int i, int i2) {
        int length = str.length();
        if (length == 0) {
            return null;
        }
        TextPaint textPaint = new TextPaint();
        textPaint.setSubpixelText(true);
        textPaint.setAntiAlias(true);
        textPaint.setTextSize(i);
        switch (i2) {
            case 1:
                textPaint.setTypeface(Typeface.create(Typeface.DEFAULT, 1));
                break;
            case 2:
                textPaint.setTypeface(Typeface.create(Typeface.DEFAULT, 2));
                break;
            default:
                textPaint.setTypeface(Typeface.create(Typeface.DEFAULT, 0));
                break;
        }
        short[] sArr = new short[length];
        for (int i3 = 0; i3 < length; i3++) {
            sArr[i3] = (short) (Layout.getDesiredWidth(str, 0, i3 + 1, textPaint) + 0.5d);
        }
        return sArr;
    }

    public static float[] getTextSizeExt(String str, int i, int i2) {
        if (str.length() == 0) {
            return null;
        }
        Paint paint = new Paint();
        paint.setSubpixelText(true);
        paint.setAntiAlias(true);
        paint.setTextSize(i);
        switch (i2) {
            case 1:
                paint.setTypeface(Typeface.create(Typeface.DEFAULT, 1));
                break;
            case 2:
                paint.setTypeface(Typeface.create(Typeface.DEFAULT, 2));
                break;
            default:
                paint.setTypeface(Typeface.create(Typeface.DEFAULT, 0));
                break;
        }
        return new float[]{paint.measureText(str), paint.descent() - paint.ascent()};
    }

    public static synchronized void registFontCache(int i, Typeface typeface) {
        synchronized (EnvDrawText.class) {
            if (i != 0 && typeface != null) {
                if (fontCache == null) {
                    fontCache = new SparseArray<>();
                }
                a aVar = fontCache.get(i);
                if (aVar == null) {
                    a aVar2 = new a();
                    aVar2.f14403a = typeface;
                    aVar2.f14404b++;
                    fontCache.put(i, aVar2);
                } else {
                    aVar.f14404b++;
                }
            }
        }
    }

    public static synchronized void removeFontCache(int i) {
        synchronized (EnvDrawText.class) {
            a aVar = fontCache.get(i);
            if (aVar != null) {
                aVar.f14404b--;
                if (aVar.f14404b == 0) {
                    fontCache.remove(i);
                }
            }
        }
    }
}
