package mapsdkvi.com.gdi.bgl.android.java;

import android.graphics.Bitmap;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.Typeface;
import android.text.Layout;
import android.text.TextPaint;
import android.util.SparseArray;
import com.baidu.mapapi.common.SysOSUtil;
import java.nio.IntBuffer;
/* loaded from: classes4.dex */
public class EnvDrawText {
    private static final String a = EnvDrawText.class.getSimpleName();
    public static boolean bBmpChange = false;
    public static Bitmap bmp = null;
    public static int[] buffer = null;
    public static SparseArray<a> fontCache = null;

    /* JADX WARN: Removed duplicated region for block: B:60:0x0187 A[Catch: all -> 0x0122, TryCatch #0 {, blocks: (B:5:0x0006, B:11:0x0019, B:13:0x001f, B:16:0x002a, B:17:0x0042, B:18:0x0045, B:20:0x0051, B:21:0x0066, B:23:0x0070, B:25:0x0074, B:27:0x0080, B:28:0x0085, B:30:0x0097, B:32:0x00c2, B:36:0x00f9, B:38:0x00ff, B:41:0x0109, B:43:0x0111, B:50:0x0131, B:51:0x0135, B:53:0x013b, B:56:0x0145, B:57:0x0169, B:58:0x0182, B:60:0x0187, B:62:0x0190, B:64:0x0196, B:65:0x019b, B:66:0x01a1, B:67:0x01b5, B:69:0x01bf, B:71:0x01cc, B:73:0x01d6, B:75:0x01dc, B:78:0x01f2, B:80:0x020f, B:84:0x024d, B:86:0x0253, B:89:0x025d, B:91:0x0265, B:92:0x026a, B:93:0x026d, B:95:0x0273, B:96:0x0279, B:100:0x0288, B:102:0x0292, B:105:0x02a3, B:106:0x02ca, B:108:0x02d6, B:109:0x02e3, B:115:0x02fb, B:117:0x0301, B:120:0x0319, B:121:0x033d, B:123:0x0349, B:113:0x02f1, B:114:0x02f5, B:110:0x02e6, B:44:0x0116, B:49:0x0125, B:8:0x0014), top: B:128:0x0006 }] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public static synchronized int[] drawText(String str, int i, int i2, int[] iArr, int i3, int i4, int i5, int i6, int i7) {
        int[] iArr2;
        int ceil;
        Bitmap bitmap;
        int i8;
        int i9;
        int desiredWidth;
        Bitmap bitmap2;
        a aVar;
        synchronized (EnvDrawText.class) {
            int i10 = 0;
            int i11 = 0;
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
                    textPaint.setTypeface(aVar.a);
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
                    if (0 == desiredWidth2 && 0 == ceil2) {
                        ceil2 = 0;
                        i9 = 0;
                    } else {
                        i9 = desiredWidth2;
                    }
                    if (iArr.length == 4) {
                        iArr[2] = i9;
                        iArr[3] = ceil2;
                    }
                    if (i9 <= 0 || ceil2 <= 0) {
                        bitmap2 = null;
                    } else {
                        Bitmap createBitmap = Bitmap.createBitmap(i9, ceil2, Bitmap.Config.ARGB_8888);
                        if (createBitmap == null) {
                            iArr2 = new int[0];
                        } else {
                            canvas.setBitmap(createBitmap);
                            bitmap2 = createBitmap;
                        }
                    }
                    if (((-16777216) & i5) == 0) {
                        canvas.drawColor(16777215);
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
                    Bitmap bitmap3 = bitmap2;
                    i8 = ceil2;
                    bitmap = bitmap3;
                    iArr2 = new int[i8 * i9];
                    if (bitmap != null) {
                        bitmap.copyPixelsToBuffer(IntBuffer.wrap(iArr2));
                    }
                    if (bitmap != null && !bitmap.isRecycled()) {
                        bitmap.recycle();
                    }
                } else {
                    int i12 = indexOf + 1;
                    int measureText = (int) textPaint.measureText(str.substring(0, indexOf));
                    int i13 = i12;
                    int i14 = 2;
                    while (true) {
                        int indexOf2 = str.indexOf(92, i13);
                        if (indexOf2 > 0) {
                            int measureText2 = (int) textPaint.measureText(str.substring(i13, indexOf2));
                            if (measureText2 <= measureText) {
                                measureText2 = measureText;
                            }
                            i14++;
                            measureText = measureText2;
                            i13 = indexOf2 + 1;
                        } else {
                            if (i13 != str.length() && (desiredWidth = (int) (Layout.getDesiredWidth(str.substring(i13, str.length()), textPaint) + 0.5d)) > measureText) {
                                measureText = desiredWidth;
                            }
                            Paint.FontMetrics fontMetrics2 = textPaint.getFontMetrics();
                            int ceil3 = ((int) Math.ceil(fontMetrics2.descent - fontMetrics2.ascent)) * i14;
                            iArr[0] = measureText;
                            iArr[1] = ceil3;
                            if (iArr.length == 4) {
                                measureText = (int) Math.pow(2.0d, (int) Math.ceil(Math.log(measureText) / Math.log(2.0d)));
                                ceil3 = (int) Math.pow(2.0d, (int) Math.ceil(Math.log(ceil3) / Math.log(2.0d)));
                            }
                            if (0 != measureText || 0 != ceil3) {
                                i11 = ceil3;
                                i10 = measureText;
                            }
                            if (iArr.length == 4) {
                                iArr[2] = i10;
                                iArr[3] = i11;
                            }
                            if (i10 <= 0 || i11 <= 0) {
                                bitmap = null;
                            } else {
                                bitmap = Bitmap.createBitmap(i10, i11, Bitmap.Config.ARGB_8888);
                                if (bitmap == null) {
                                    iArr2 = new int[0];
                                } else {
                                    canvas.setBitmap(bitmap);
                                }
                            }
                            if (((-16777216) & i5) == 0) {
                                canvas.drawColor(16777215);
                            } else {
                                canvas.drawColor(i5);
                            }
                            textPaint.setTextAlign(getTextAlignedType(i7));
                            int i15 = i7 == 1 ? 0 : i7 == 2 ? iArr[0] : iArr[0] / 2;
                            int i16 = 0;
                            int i17 = 0;
                            while (true) {
                                int indexOf3 = str.indexOf(92, i16);
                                if (indexOf3 > 0) {
                                    String substring = str.substring(i16, indexOf3);
                                    int measureText3 = (int) textPaint.measureText(substring);
                                    i16 = indexOf3 + 1;
                                    if (i6 != 0 && canvas != null) {
                                        textPaint.setStrokeWidth(i6);
                                        textPaint.setStrokeCap(Paint.Cap.ROUND);
                                        textPaint.setStrokeJoin(Paint.Join.ROUND);
                                        textPaint.setStyle(Paint.Style.STROKE);
                                        textPaint.setColor(i4);
                                        canvas.drawText(substring, i15, (i17 * ceil) - fontMetrics2.ascent, textPaint);
                                    }
                                    textPaint.setStyle(Paint.Style.FILL);
                                    textPaint.setColor(i3);
                                    if (canvas != null) {
                                        canvas.drawText(substring, i15, (i17 * ceil) - fontMetrics2.ascent, textPaint);
                                    }
                                    i17++;
                                } else {
                                    if (i16 != str.length()) {
                                        String substring2 = str.substring(i16, str.length());
                                        int desiredWidth3 = (int) (Layout.getDesiredWidth(substring2, textPaint) + 0.5d);
                                        if (i6 != 0 && canvas != null) {
                                            textPaint.setStrokeWidth(i6);
                                            textPaint.setStrokeCap(Paint.Cap.ROUND);
                                            textPaint.setStrokeJoin(Paint.Join.ROUND);
                                            textPaint.setStyle(Paint.Style.STROKE);
                                            textPaint.setColor(i4);
                                            canvas.drawText(substring2, i15, (i17 * ceil) - fontMetrics2.ascent, textPaint);
                                        }
                                        textPaint.setStyle(Paint.Style.FILL);
                                        textPaint.setColor(i3);
                                        if (canvas != null) {
                                            canvas.drawText(substring2, i15, (i17 * ceil) - fontMetrics2.ascent, textPaint);
                                        }
                                    }
                                    i8 = i11;
                                    i9 = i10;
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
                        canvas.drawColor(16777215);
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
                    int i11 = i10;
                    int i12 = 2;
                    while (true) {
                        int indexOf2 = str.indexOf(92, i11);
                        if (indexOf2 > 0) {
                            int desiredWidth4 = (int) (Layout.getDesiredWidth(str.substring(i11, indexOf2), textPaint) + 0.5d);
                            if (desiredWidth4 <= desiredWidth3) {
                                desiredWidth4 = desiredWidth3;
                            }
                            i12++;
                            desiredWidth3 = desiredWidth4;
                            i11 = indexOf2 + 1;
                        } else {
                            if (i11 != str.length() && (desiredWidth = (int) (Layout.getDesiredWidth(str.substring(i11, str.length()), textPaint) + 0.5d)) > desiredWidth3) {
                                desiredWidth3 = desiredWidth;
                            }
                            Paint.FontMetrics fontMetrics2 = textPaint.getFontMetrics();
                            int ceil3 = ((int) Math.ceil(fontMetrics2.descent - fontMetrics2.ascent)) * i12;
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
                                canvas.drawColor(16777215);
                            } else {
                                canvas.drawColor(i5);
                            }
                            textPaint.setTextAlign(getTextAlignedType(i7));
                            int i13 = i7 == 1 ? 0 : i7 == 2 ? iArr[0] : iArr[0] / 2;
                            int i14 = 0;
                            int i15 = 0;
                            while (true) {
                                int indexOf3 = str.indexOf(92, i14);
                                if (indexOf3 > 0) {
                                    String substring = str.substring(i14, indexOf3);
                                    int desiredWidth5 = (int) (Layout.getDesiredWidth(substring, textPaint) + 0.5d);
                                    i14 = indexOf3 + 1;
                                    if (i6 != 0 && canvas != null) {
                                        textPaint.setStrokeWidth(i6);
                                        textPaint.setStrokeCap(Paint.Cap.ROUND);
                                        textPaint.setStrokeJoin(Paint.Join.ROUND);
                                        textPaint.setStyle(Paint.Style.STROKE);
                                        textPaint.setColor(i4);
                                        canvas.drawText(substring, i13, (i15 * ceil) - fontMetrics2.ascent, textPaint);
                                    }
                                    textPaint.setStyle(Paint.Style.FILL);
                                    textPaint.setColor(i3);
                                    if (canvas != null) {
                                        canvas.drawText(substring, i13, (i15 * ceil) - fontMetrics2.ascent, textPaint);
                                    }
                                    i15++;
                                } else {
                                    if (i14 != str.length()) {
                                        String substring2 = str.substring(i14, str.length());
                                        int desiredWidth6 = (int) (Layout.getDesiredWidth(substring2, textPaint) + 0.5d);
                                        if (i6 != 0 && canvas != null) {
                                            textPaint.setStrokeWidth(i6);
                                            textPaint.setStrokeCap(Paint.Cap.ROUND);
                                            textPaint.setStrokeJoin(Paint.Join.ROUND);
                                            textPaint.setStyle(Paint.Style.STROKE);
                                            textPaint.setColor(i4);
                                            canvas.drawText(substring2, i13, (i15 * ceil) - fontMetrics2.ascent, textPaint);
                                        }
                                        textPaint.setStyle(Paint.Style.FILL);
                                        textPaint.setColor(i3);
                                        if (canvas != null) {
                                            canvas.drawText(substring2, i13, (i15 * ceil) - fontMetrics2.ascent, textPaint);
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
                    aVar2.a = typeface;
                    aVar2.b++;
                    fontCache.put(i, aVar2);
                } else {
                    aVar.b++;
                }
            }
        }
    }

    public static synchronized void removeFontCache(int i) {
        synchronized (EnvDrawText.class) {
            a aVar = fontCache.get(i);
            if (aVar != null) {
                aVar.b--;
                if (aVar.b == 0) {
                    fontCache.remove(i);
                }
            }
        }
    }
}
