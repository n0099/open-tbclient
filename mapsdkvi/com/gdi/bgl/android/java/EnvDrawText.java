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
/* loaded from: classes7.dex */
public class EnvDrawText {

    /* renamed from: a  reason: collision with root package name */
    public static final String f69276a = "EnvDrawText";
    public static boolean bBmpChange = false;
    public static Bitmap bmp;
    public static int[] buffer;
    public static SparseArray<a> fontCache;

    /* JADX WARN: Removed duplicated region for block: B:105:0x026c A[Catch: all -> 0x032b, TryCatch #0 {, blocks: (B:4:0x0011, B:6:0x0022, B:10:0x002e, B:13:0x0047, B:14:0x004d, B:18:0x0061, B:19:0x0074, B:21:0x007c, B:23:0x0080, B:25:0x008a, B:26:0x008f, B:28:0x00a4, B:30:0x00c6, B:37:0x0104, B:39:0x0108, B:42:0x0111, B:44:0x0119, B:48:0x0120, B:50:0x012a, B:52:0x012e, B:55:0x013a, B:57:0x015d, B:117:0x0311, B:119:0x0317, B:121:0x0320, B:123:0x0326, B:53:0x0135, B:58:0x0171, B:59:0x0183, B:61:0x0189, B:64:0x0195, B:65:0x019c, B:67:0x01a2, B:70:0x01b5, B:72:0x01d1, B:79:0x021e, B:81:0x0222, B:84:0x022b, B:86:0x0233, B:89:0x0238, B:91:0x023d, B:93:0x0241, B:95:0x024b, B:103:0x0266, B:105:0x026c, B:107:0x0277, B:109:0x02a4, B:110:0x02c2, B:112:0x02ce, B:114:0x02db, B:115:0x02fb, B:100:0x025b, B:101:0x025f, B:94:0x0248, B:15:0x0051, B:16:0x0058), top: B:129:0x0011 }] */
    /* JADX WARN: Removed duplicated region for block: B:112:0x02ce A[Catch: all -> 0x032b, TryCatch #0 {, blocks: (B:4:0x0011, B:6:0x0022, B:10:0x002e, B:13:0x0047, B:14:0x004d, B:18:0x0061, B:19:0x0074, B:21:0x007c, B:23:0x0080, B:25:0x008a, B:26:0x008f, B:28:0x00a4, B:30:0x00c6, B:37:0x0104, B:39:0x0108, B:42:0x0111, B:44:0x0119, B:48:0x0120, B:50:0x012a, B:52:0x012e, B:55:0x013a, B:57:0x015d, B:117:0x0311, B:119:0x0317, B:121:0x0320, B:123:0x0326, B:53:0x0135, B:58:0x0171, B:59:0x0183, B:61:0x0189, B:64:0x0195, B:65:0x019c, B:67:0x01a2, B:70:0x01b5, B:72:0x01d1, B:79:0x021e, B:81:0x0222, B:84:0x022b, B:86:0x0233, B:89:0x0238, B:91:0x023d, B:93:0x0241, B:95:0x024b, B:103:0x0266, B:105:0x026c, B:107:0x0277, B:109:0x02a4, B:110:0x02c2, B:112:0x02ce, B:114:0x02db, B:115:0x02fb, B:100:0x025b, B:101:0x025f, B:94:0x0248, B:15:0x0051, B:16:0x0058), top: B:129:0x0011 }] */
    /* JADX WARN: Removed duplicated region for block: B:133:0x02c2 A[EDGE_INSN: B:133:0x02c2->B:110:0x02c2 ?: BREAK  , SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:39:0x0108 A[Catch: all -> 0x032b, TryCatch #0 {, blocks: (B:4:0x0011, B:6:0x0022, B:10:0x002e, B:13:0x0047, B:14:0x004d, B:18:0x0061, B:19:0x0074, B:21:0x007c, B:23:0x0080, B:25:0x008a, B:26:0x008f, B:28:0x00a4, B:30:0x00c6, B:37:0x0104, B:39:0x0108, B:42:0x0111, B:44:0x0119, B:48:0x0120, B:50:0x012a, B:52:0x012e, B:55:0x013a, B:57:0x015d, B:117:0x0311, B:119:0x0317, B:121:0x0320, B:123:0x0326, B:53:0x0135, B:58:0x0171, B:59:0x0183, B:61:0x0189, B:64:0x0195, B:65:0x019c, B:67:0x01a2, B:70:0x01b5, B:72:0x01d1, B:79:0x021e, B:81:0x0222, B:84:0x022b, B:86:0x0233, B:89:0x0238, B:91:0x023d, B:93:0x0241, B:95:0x024b, B:103:0x0266, B:105:0x026c, B:107:0x0277, B:109:0x02a4, B:110:0x02c2, B:112:0x02ce, B:114:0x02db, B:115:0x02fb, B:100:0x025b, B:101:0x025f, B:94:0x0248, B:15:0x0051, B:16:0x0058), top: B:129:0x0011 }] */
    /* JADX WARN: Removed duplicated region for block: B:52:0x012e A[Catch: all -> 0x032b, TryCatch #0 {, blocks: (B:4:0x0011, B:6:0x0022, B:10:0x002e, B:13:0x0047, B:14:0x004d, B:18:0x0061, B:19:0x0074, B:21:0x007c, B:23:0x0080, B:25:0x008a, B:26:0x008f, B:28:0x00a4, B:30:0x00c6, B:37:0x0104, B:39:0x0108, B:42:0x0111, B:44:0x0119, B:48:0x0120, B:50:0x012a, B:52:0x012e, B:55:0x013a, B:57:0x015d, B:117:0x0311, B:119:0x0317, B:121:0x0320, B:123:0x0326, B:53:0x0135, B:58:0x0171, B:59:0x0183, B:61:0x0189, B:64:0x0195, B:65:0x019c, B:67:0x01a2, B:70:0x01b5, B:72:0x01d1, B:79:0x021e, B:81:0x0222, B:84:0x022b, B:86:0x0233, B:89:0x0238, B:91:0x023d, B:93:0x0241, B:95:0x024b, B:103:0x0266, B:105:0x026c, B:107:0x0277, B:109:0x02a4, B:110:0x02c2, B:112:0x02ce, B:114:0x02db, B:115:0x02fb, B:100:0x025b, B:101:0x025f, B:94:0x0248, B:15:0x0051, B:16:0x0058), top: B:129:0x0011 }] */
    /* JADX WARN: Removed duplicated region for block: B:53:0x0135 A[Catch: all -> 0x032b, TryCatch #0 {, blocks: (B:4:0x0011, B:6:0x0022, B:10:0x002e, B:13:0x0047, B:14:0x004d, B:18:0x0061, B:19:0x0074, B:21:0x007c, B:23:0x0080, B:25:0x008a, B:26:0x008f, B:28:0x00a4, B:30:0x00c6, B:37:0x0104, B:39:0x0108, B:42:0x0111, B:44:0x0119, B:48:0x0120, B:50:0x012a, B:52:0x012e, B:55:0x013a, B:57:0x015d, B:117:0x0311, B:119:0x0317, B:121:0x0320, B:123:0x0326, B:53:0x0135, B:58:0x0171, B:59:0x0183, B:61:0x0189, B:64:0x0195, B:65:0x019c, B:67:0x01a2, B:70:0x01b5, B:72:0x01d1, B:79:0x021e, B:81:0x0222, B:84:0x022b, B:86:0x0233, B:89:0x0238, B:91:0x023d, B:93:0x0241, B:95:0x024b, B:103:0x0266, B:105:0x026c, B:107:0x0277, B:109:0x02a4, B:110:0x02c2, B:112:0x02ce, B:114:0x02db, B:115:0x02fb, B:100:0x025b, B:101:0x025f, B:94:0x0248, B:15:0x0051, B:16:0x0058), top: B:129:0x0011 }] */
    /* JADX WARN: Removed duplicated region for block: B:55:0x013a A[Catch: all -> 0x032b, TryCatch #0 {, blocks: (B:4:0x0011, B:6:0x0022, B:10:0x002e, B:13:0x0047, B:14:0x004d, B:18:0x0061, B:19:0x0074, B:21:0x007c, B:23:0x0080, B:25:0x008a, B:26:0x008f, B:28:0x00a4, B:30:0x00c6, B:37:0x0104, B:39:0x0108, B:42:0x0111, B:44:0x0119, B:48:0x0120, B:50:0x012a, B:52:0x012e, B:55:0x013a, B:57:0x015d, B:117:0x0311, B:119:0x0317, B:121:0x0320, B:123:0x0326, B:53:0x0135, B:58:0x0171, B:59:0x0183, B:61:0x0189, B:64:0x0195, B:65:0x019c, B:67:0x01a2, B:70:0x01b5, B:72:0x01d1, B:79:0x021e, B:81:0x0222, B:84:0x022b, B:86:0x0233, B:89:0x0238, B:91:0x023d, B:93:0x0241, B:95:0x024b, B:103:0x0266, B:105:0x026c, B:107:0x0277, B:109:0x02a4, B:110:0x02c2, B:112:0x02ce, B:114:0x02db, B:115:0x02fb, B:100:0x025b, B:101:0x025f, B:94:0x0248, B:15:0x0051, B:16:0x0058), top: B:129:0x0011 }] */
    /* JADX WARN: Removed duplicated region for block: B:56:0x015b  */
    /* JADX WARN: Removed duplicated region for block: B:81:0x0222 A[Catch: all -> 0x032b, TryCatch #0 {, blocks: (B:4:0x0011, B:6:0x0022, B:10:0x002e, B:13:0x0047, B:14:0x004d, B:18:0x0061, B:19:0x0074, B:21:0x007c, B:23:0x0080, B:25:0x008a, B:26:0x008f, B:28:0x00a4, B:30:0x00c6, B:37:0x0104, B:39:0x0108, B:42:0x0111, B:44:0x0119, B:48:0x0120, B:50:0x012a, B:52:0x012e, B:55:0x013a, B:57:0x015d, B:117:0x0311, B:119:0x0317, B:121:0x0320, B:123:0x0326, B:53:0x0135, B:58:0x0171, B:59:0x0183, B:61:0x0189, B:64:0x0195, B:65:0x019c, B:67:0x01a2, B:70:0x01b5, B:72:0x01d1, B:79:0x021e, B:81:0x0222, B:84:0x022b, B:86:0x0233, B:89:0x0238, B:91:0x023d, B:93:0x0241, B:95:0x024b, B:103:0x0266, B:105:0x026c, B:107:0x0277, B:109:0x02a4, B:110:0x02c2, B:112:0x02ce, B:114:0x02db, B:115:0x02fb, B:100:0x025b, B:101:0x025f, B:94:0x0248, B:15:0x0051, B:16:0x0058), top: B:129:0x0011 }] */
    /* JADX WARN: Removed duplicated region for block: B:93:0x0241 A[Catch: all -> 0x032b, TryCatch #0 {, blocks: (B:4:0x0011, B:6:0x0022, B:10:0x002e, B:13:0x0047, B:14:0x004d, B:18:0x0061, B:19:0x0074, B:21:0x007c, B:23:0x0080, B:25:0x008a, B:26:0x008f, B:28:0x00a4, B:30:0x00c6, B:37:0x0104, B:39:0x0108, B:42:0x0111, B:44:0x0119, B:48:0x0120, B:50:0x012a, B:52:0x012e, B:55:0x013a, B:57:0x015d, B:117:0x0311, B:119:0x0317, B:121:0x0320, B:123:0x0326, B:53:0x0135, B:58:0x0171, B:59:0x0183, B:61:0x0189, B:64:0x0195, B:65:0x019c, B:67:0x01a2, B:70:0x01b5, B:72:0x01d1, B:79:0x021e, B:81:0x0222, B:84:0x022b, B:86:0x0233, B:89:0x0238, B:91:0x023d, B:93:0x0241, B:95:0x024b, B:103:0x0266, B:105:0x026c, B:107:0x0277, B:109:0x02a4, B:110:0x02c2, B:112:0x02ce, B:114:0x02db, B:115:0x02fb, B:100:0x025b, B:101:0x025f, B:94:0x0248, B:15:0x0051, B:16:0x0058), top: B:129:0x0011 }] */
    /* JADX WARN: Removed duplicated region for block: B:94:0x0248 A[Catch: all -> 0x032b, TryCatch #0 {, blocks: (B:4:0x0011, B:6:0x0022, B:10:0x002e, B:13:0x0047, B:14:0x004d, B:18:0x0061, B:19:0x0074, B:21:0x007c, B:23:0x0080, B:25:0x008a, B:26:0x008f, B:28:0x00a4, B:30:0x00c6, B:37:0x0104, B:39:0x0108, B:42:0x0111, B:44:0x0119, B:48:0x0120, B:50:0x012a, B:52:0x012e, B:55:0x013a, B:57:0x015d, B:117:0x0311, B:119:0x0317, B:121:0x0320, B:123:0x0326, B:53:0x0135, B:58:0x0171, B:59:0x0183, B:61:0x0189, B:64:0x0195, B:65:0x019c, B:67:0x01a2, B:70:0x01b5, B:72:0x01d1, B:79:0x021e, B:81:0x0222, B:84:0x022b, B:86:0x0233, B:89:0x0238, B:91:0x023d, B:93:0x0241, B:95:0x024b, B:103:0x0266, B:105:0x026c, B:107:0x0277, B:109:0x02a4, B:110:0x02c2, B:112:0x02ce, B:114:0x02db, B:115:0x02fb, B:100:0x025b, B:101:0x025f, B:94:0x0248, B:15:0x0051, B:16:0x0058), top: B:129:0x0011 }] */
    /* JADX WARN: Removed duplicated region for block: B:97:0x0255  */
    /* JADX WARN: Removed duplicated region for block: B:98:0x0258  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public static synchronized int[] drawText(String str, int i, int i2, int[] iArr, int i3, int i4, int i5, int i6, int i7) {
        Paint.FontMetrics fontMetrics;
        int i8;
        int i9;
        int i10;
        int i11;
        int i12;
        Bitmap bitmap;
        int i13;
        int i14;
        int i15;
        int i16;
        int indexOf;
        int i17;
        int i18;
        int i19;
        int i20;
        Paint.FontMetrics fontMetrics2;
        int desiredWidth;
        TextPaint textPaint;
        Canvas canvas;
        Bitmap bitmap2;
        TextPaint textPaint2;
        a aVar;
        synchronized (EnvDrawText.class) {
            Canvas canvas2 = new Canvas();
            TextPaint textPaint3 = new TextPaint();
            String phoneType = SysOSUtil.getPhoneType();
            int i21 = (phoneType == null || !phoneType.equals("vivo X3L")) ? i2 : 0;
            textPaint3.reset();
            textPaint3.setSubpixelText(true);
            textPaint3.setAntiAlias(true);
            float f2 = i;
            textPaint3.setTextSize(f2);
            textPaint3.setShadowLayer(0.0f, 0.0f, 0.0f, 0);
            textPaint3.setTypeface(i21 != 1 ? i21 != 2 ? Typeface.create(Typeface.DEFAULT, 0) : Typeface.create(Typeface.DEFAULT, 2) : Typeface.create(Typeface.DEFAULT, 1));
            if (i6 != 0) {
                textPaint3.setStrokeWidth(i6);
                textPaint3.setStrokeCap(Paint.Cap.ROUND);
                textPaint3.setStrokeJoin(Paint.Join.ROUND);
                textPaint3.setStyle(Paint.Style.STROKE);
            }
            textPaint3.setSubpixelText(true);
            textPaint3.setAntiAlias(true);
            if (i21 != 0 && fontCache != null && (aVar = fontCache.get(i21)) != null) {
                textPaint3.setTypeface(aVar.f69277a);
            }
            textPaint3.setTextSize(f2);
            int indexOf2 = str.indexOf(92, 0);
            if (indexOf2 == -1) {
                Paint.FontMetrics fontMetrics3 = textPaint3.getFontMetrics();
                int desiredWidth2 = (int) (Layout.getDesiredWidth(str, 0, str.length(), textPaint3) + 0.5d);
                i18 = (int) Math.ceil(fontMetrics3.descent - fontMetrics3.ascent);
                iArr[0] = desiredWidth2;
                iArr[1] = i18;
                if (iArr.length == 4) {
                    desiredWidth2 = (int) Math.pow(2.0d, (int) Math.ceil(Math.log(desiredWidth2) / Math.log(2.0d)));
                    textPaint = textPaint3;
                    i18 = (int) Math.pow(2.0d, (int) Math.ceil(Math.log(i18) / Math.log(2.0d)));
                } else {
                    textPaint = textPaint3;
                }
                if (desiredWidth2 == 0 && i18 == 0) {
                    i18 = 0;
                    i17 = 0;
                    if (iArr.length == 4) {
                        iArr[2] = i17;
                        iArr[3] = i18;
                    }
                    if (i17 > 0 || i18 <= 0) {
                        canvas = canvas2;
                        bitmap2 = null;
                    } else {
                        Bitmap createBitmap = Bitmap.createBitmap(i17, i18, Bitmap.Config.ARGB_8888);
                        if (createBitmap == null) {
                            return new int[0];
                        }
                        canvas = canvas2;
                        canvas.setBitmap(createBitmap);
                        bitmap2 = createBitmap;
                    }
                    if ((i5 & (-16777216)) != 0) {
                        canvas.drawColor(ViewCompat.MEASURED_SIZE_MASK);
                    } else {
                        canvas.drawColor(i5);
                    }
                    if (i6 == 0) {
                        textPaint2 = textPaint;
                        textPaint2.setStrokeWidth(i6);
                        textPaint2.setStrokeCap(Paint.Cap.ROUND);
                        textPaint2.setStrokeJoin(Paint.Join.ROUND);
                        textPaint2.setStyle(Paint.Style.STROKE);
                        textPaint2.setColor(i4);
                        canvas.drawText(str, 0.0f, 0.0f - fontMetrics3.ascent, textPaint2);
                    } else {
                        textPaint2 = textPaint;
                    }
                    textPaint2.setStyle(Paint.Style.FILL);
                    textPaint2.setColor(i3);
                    canvas.drawText(str, 0.0f, 0.0f - fontMetrics3.ascent, textPaint2);
                    bitmap = bitmap2;
                }
                i17 = desiredWidth2;
                if (iArr.length == 4) {
                }
                if (i17 > 0) {
                }
                canvas = canvas2;
                bitmap2 = null;
                if ((i5 & (-16777216)) != 0) {
                }
                if (i6 == 0) {
                }
                textPaint2.setStyle(Paint.Style.FILL);
                textPaint2.setColor(i3);
                canvas.drawText(str, 0.0f, 0.0f - fontMetrics3.ascent, textPaint2);
                bitmap = bitmap2;
            } else {
                int i22 = indexOf2 + 1;
                int measureText = (int) textPaint3.measureText(str.substring(0, indexOf2));
                int i23 = 92;
                int i24 = 2;
                while (true) {
                    int indexOf3 = str.indexOf(i23, i22);
                    if (indexOf3 <= 0) {
                        break;
                    }
                    int measureText2 = (int) textPaint3.measureText(str.substring(i22, indexOf3));
                    if (measureText2 > measureText) {
                        measureText = measureText2;
                    }
                    i22 = indexOf3 + 1;
                    i24++;
                    i23 = 92;
                }
                if (i22 != str.length() && (desiredWidth = (int) (Layout.getDesiredWidth(str.substring(i22, str.length()), textPaint3) + 0.5d)) > measureText) {
                    measureText = desiredWidth;
                }
                Paint.FontMetrics fontMetrics4 = textPaint3.getFontMetrics();
                int ceil = (int) Math.ceil(fontMetrics4.descent - fontMetrics4.ascent);
                int i25 = ceil * i24;
                iArr[0] = measureText;
                iArr[1] = i25;
                if (iArr.length == 4) {
                    fontMetrics = fontMetrics4;
                    i8 = ceil;
                    int pow = (int) Math.pow(2.0d, (int) Math.ceil(Math.log(measureText) / Math.log(2.0d)));
                    i10 = (int) Math.pow(2.0d, (int) Math.ceil(Math.log(i25) / Math.log(2.0d)));
                    i9 = pow;
                } else {
                    fontMetrics = fontMetrics4;
                    i8 = ceil;
                    i9 = measureText;
                    i10 = i25;
                }
                if (i9 == 0 && i10 == 0) {
                    i12 = 0;
                    i11 = 0;
                    if (iArr.length == 4) {
                        iArr[2] = i12;
                        iArr[3] = i11;
                    }
                    if (i12 > 0 || i11 <= 0) {
                        bitmap = null;
                    } else {
                        bitmap = Bitmap.createBitmap(i12, i11, Bitmap.Config.ARGB_8888);
                        if (bitmap == null) {
                            return new int[0];
                        }
                        canvas2.setBitmap(bitmap);
                    }
                    if ((i5 & (-16777216)) != 0) {
                        canvas2.drawColor(ViewCompat.MEASURED_SIZE_MASK);
                    } else {
                        canvas2.drawColor(i5);
                    }
                    textPaint3.setTextAlign(getTextAlignedType(i7));
                    if (i7 != 1) {
                        i14 = 0;
                        i13 = 0;
                    } else if (i7 == 2) {
                        i13 = 0;
                        i14 = iArr[0];
                    } else {
                        i13 = 0;
                        i14 = iArr[0] / 2;
                    }
                    i15 = 0;
                    i16 = 92;
                    while (true) {
                        indexOf = str.indexOf(i16, i13);
                        if (indexOf > 0) {
                            break;
                        }
                        String substring = str.substring(i13, indexOf);
                        textPaint3.measureText(substring);
                        int i26 = indexOf + 1;
                        if (i6 != 0) {
                            textPaint3.setStrokeWidth(i6);
                            textPaint3.setStrokeCap(Paint.Cap.ROUND);
                            textPaint3.setStrokeJoin(Paint.Join.ROUND);
                            textPaint3.setStyle(Paint.Style.STROKE);
                            textPaint3.setColor(i4);
                            i19 = i12;
                            i20 = i11;
                            fontMetrics2 = fontMetrics;
                            canvas2.drawText(substring, i14, (i15 * i8) - fontMetrics2.ascent, textPaint3);
                        } else {
                            i19 = i12;
                            i20 = i11;
                            fontMetrics2 = fontMetrics;
                        }
                        textPaint3.setStyle(Paint.Style.FILL);
                        textPaint3.setColor(i3);
                        canvas2.drawText(substring, i14, (i15 * i8) - fontMetrics2.ascent, textPaint3);
                        i15++;
                        fontMetrics = fontMetrics2;
                        i13 = i26;
                        i11 = i20;
                        i16 = 92;
                        i12 = i19;
                    }
                    int i27 = i12;
                    int i28 = i11;
                    Paint.FontMetrics fontMetrics5 = fontMetrics;
                    if (i13 != str.length()) {
                        String substring2 = str.substring(i13, str.length());
                        Layout.getDesiredWidth(substring2, textPaint3);
                        if (i6 != 0) {
                            textPaint3.setStrokeWidth(i6);
                            textPaint3.setStrokeCap(Paint.Cap.ROUND);
                            textPaint3.setStrokeJoin(Paint.Join.ROUND);
                            textPaint3.setStyle(Paint.Style.STROKE);
                            textPaint3.setColor(i4);
                            canvas2.drawText(substring2, i14, (i15 * i8) - fontMetrics5.ascent, textPaint3);
                        }
                        textPaint3.setStyle(Paint.Style.FILL);
                        textPaint3.setColor(i3);
                        canvas2.drawText(substring2, i14, (i15 * i8) - fontMetrics5.ascent, textPaint3);
                    }
                    i17 = i27;
                    i18 = i28;
                }
                i11 = i10;
                i12 = i9;
                if (iArr.length == 4) {
                }
                if (i12 > 0) {
                }
                bitmap = null;
                if ((i5 & (-16777216)) != 0) {
                }
                textPaint3.setTextAlign(getTextAlignedType(i7));
                if (i7 != 1) {
                }
                i15 = 0;
                i16 = 92;
                while (true) {
                    indexOf = str.indexOf(i16, i13);
                    if (indexOf > 0) {
                    }
                    textPaint3.setStyle(Paint.Style.FILL);
                    textPaint3.setColor(i3);
                    canvas2.drawText(substring, i14, (i15 * i8) - fontMetrics2.ascent, textPaint3);
                    i15++;
                    fontMetrics = fontMetrics2;
                    i13 = i26;
                    i11 = i20;
                    i16 = 92;
                    i12 = i19;
                }
                int i272 = i12;
                int i282 = i11;
                Paint.FontMetrics fontMetrics52 = fontMetrics;
                if (i13 != str.length()) {
                }
                i17 = i272;
                i18 = i282;
            }
            int[] iArr2 = new int[i17 * i18];
            if (bitmap != null) {
                bitmap.copyPixelsToBuffer(IntBuffer.wrap(iArr2));
            }
            if (bitmap != null && !bitmap.isRecycled()) {
                bitmap.recycle();
            }
            return iArr2;
        }
    }

    public static Bitmap drawTextAlpha(String str, int i, int i2, int i3) {
        int desiredWidth;
        Canvas canvas = new Canvas();
        TextPaint textPaint = new TextPaint();
        String phoneType = SysOSUtil.getPhoneType();
        int i4 = 0;
        int i5 = (phoneType == null || !phoneType.equals("vivo X3L")) ? i2 : 0;
        textPaint.reset();
        textPaint.setSubpixelText(false);
        textPaint.setAntiAlias(false);
        textPaint.setTextSize(i);
        int i6 = 2;
        textPaint.setTypeface(i5 != 1 ? i5 != 2 ? Typeface.create(Typeface.DEFAULT, 0) : Typeface.create(Typeface.DEFAULT, 2) : Typeface.create(Typeface.DEFAULT, 1));
        float f2 = (i3 * 1.3f) + 0.5f;
        int i7 = 92;
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
            int i8 = indexOf + 1;
            int desiredWidth3 = (int) (Layout.getDesiredWidth(str.substring(0, indexOf), textPaint) + 0.5d);
            while (true) {
                int indexOf2 = str.indexOf(i7, i8);
                if (indexOf2 <= 0) {
                    break;
                }
                int desiredWidth4 = (int) (Layout.getDesiredWidth(str.substring(i8, indexOf2), textPaint) + 0.5d);
                if (desiredWidth4 > desiredWidth3) {
                    desiredWidth3 = desiredWidth4;
                }
                i8 = indexOf2 + 1;
                i6++;
                i7 = 92;
            }
            if (i8 != str.length() && (desiredWidth = (int) (Layout.getDesiredWidth(str.substring(i8, str.length()), textPaint) + 0.5d)) > desiredWidth3) {
                desiredWidth3 = desiredWidth;
            }
            Paint.FontMetrics fontMetrics2 = textPaint.getFontMetrics();
            int ceil2 = (int) Math.ceil(fontMetrics2.descent - fontMetrics2.ascent);
            int i9 = desiredWidth3 + i3;
            int i10 = i6 * ceil2;
            if (i9 > 0 && i10 > 0) {
                bitmap = Bitmap.createBitmap(i9, i10, Bitmap.Config.ALPHA_8);
                if (bitmap == null) {
                    return bitmap;
                }
                bitmap.eraseColor(0);
                canvas.setBitmap(bitmap);
            }
            textPaint.setTextAlign(getTextAlignedType(3));
            float f3 = i9 - (f2 * 0.5f);
            int i11 = 0;
            while (true) {
                int indexOf3 = str.indexOf(92, i4);
                if (indexOf3 <= 0) {
                    break;
                }
                String substring = str.substring(i4, indexOf3);
                Layout.getDesiredWidth(substring, textPaint);
                textPaint.setStyle(Paint.Style.FILL);
                canvas.drawText(substring, f3, (i11 * ceil2) - fontMetrics2.ascent, textPaint);
                i11++;
                i4 = indexOf3 + 1;
            }
            if (i4 != str.length()) {
                String substring2 = str.substring(i4, str.length());
                Layout.getDesiredWidth(substring2, textPaint);
                textPaint.setStyle(Paint.Style.FILL);
                canvas.drawText(substring2, f3, (i11 * ceil2) - fontMetrics2.ascent, textPaint);
            }
        }
        return bitmap;
    }

    /* JADX WARN: Removed duplicated region for block: B:31:0x00e2 A[Catch: all -> 0x02c7, TryCatch #0 {, blocks: (B:4:0x0011, B:6:0x0022, B:10:0x002e, B:13:0x0047, B:14:0x004d, B:18:0x0061, B:19:0x0074, B:21:0x0083, B:23:0x00a6, B:29:0x00de, B:31:0x00e2, B:34:0x00eb, B:38:0x00f5, B:40:0x00fa, B:42:0x00fe, B:45:0x010a, B:46:0x012a, B:43:0x0105, B:47:0x013e, B:48:0x0152, B:50:0x015a, B:53:0x016b, B:54:0x0171, B:56:0x0177, B:59:0x018a, B:61:0x01a5, B:67:0x01e1, B:69:0x01e5, B:72:0x01ee, B:76:0x01f8, B:78:0x01fd, B:80:0x0201, B:82:0x020b, B:90:0x0225, B:92:0x022b, B:94:0x0236, B:96:0x025b, B:97:0x0278, B:99:0x0284, B:101:0x0291, B:102:0x02b1, B:87:0x021c, B:88:0x021f, B:81:0x0208, B:15:0x0051, B:16:0x0058), top: B:109:0x0011 }] */
    /* JADX WARN: Removed duplicated region for block: B:42:0x00fe A[Catch: all -> 0x02c7, TryCatch #0 {, blocks: (B:4:0x0011, B:6:0x0022, B:10:0x002e, B:13:0x0047, B:14:0x004d, B:18:0x0061, B:19:0x0074, B:21:0x0083, B:23:0x00a6, B:29:0x00de, B:31:0x00e2, B:34:0x00eb, B:38:0x00f5, B:40:0x00fa, B:42:0x00fe, B:45:0x010a, B:46:0x012a, B:43:0x0105, B:47:0x013e, B:48:0x0152, B:50:0x015a, B:53:0x016b, B:54:0x0171, B:56:0x0177, B:59:0x018a, B:61:0x01a5, B:67:0x01e1, B:69:0x01e5, B:72:0x01ee, B:76:0x01f8, B:78:0x01fd, B:80:0x0201, B:82:0x020b, B:90:0x0225, B:92:0x022b, B:94:0x0236, B:96:0x025b, B:97:0x0278, B:99:0x0284, B:101:0x0291, B:102:0x02b1, B:87:0x021c, B:88:0x021f, B:81:0x0208, B:15:0x0051, B:16:0x0058), top: B:109:0x0011 }] */
    /* JADX WARN: Removed duplicated region for block: B:43:0x0105 A[Catch: all -> 0x02c7, TryCatch #0 {, blocks: (B:4:0x0011, B:6:0x0022, B:10:0x002e, B:13:0x0047, B:14:0x004d, B:18:0x0061, B:19:0x0074, B:21:0x0083, B:23:0x00a6, B:29:0x00de, B:31:0x00e2, B:34:0x00eb, B:38:0x00f5, B:40:0x00fa, B:42:0x00fe, B:45:0x010a, B:46:0x012a, B:43:0x0105, B:47:0x013e, B:48:0x0152, B:50:0x015a, B:53:0x016b, B:54:0x0171, B:56:0x0177, B:59:0x018a, B:61:0x01a5, B:67:0x01e1, B:69:0x01e5, B:72:0x01ee, B:76:0x01f8, B:78:0x01fd, B:80:0x0201, B:82:0x020b, B:90:0x0225, B:92:0x022b, B:94:0x0236, B:96:0x025b, B:97:0x0278, B:99:0x0284, B:101:0x0291, B:102:0x02b1, B:87:0x021c, B:88:0x021f, B:81:0x0208, B:15:0x0051, B:16:0x0058), top: B:109:0x0011 }] */
    /* JADX WARN: Removed duplicated region for block: B:45:0x010a A[Catch: all -> 0x02c7, TryCatch #0 {, blocks: (B:4:0x0011, B:6:0x0022, B:10:0x002e, B:13:0x0047, B:14:0x004d, B:18:0x0061, B:19:0x0074, B:21:0x0083, B:23:0x00a6, B:29:0x00de, B:31:0x00e2, B:34:0x00eb, B:38:0x00f5, B:40:0x00fa, B:42:0x00fe, B:45:0x010a, B:46:0x012a, B:43:0x0105, B:47:0x013e, B:48:0x0152, B:50:0x015a, B:53:0x016b, B:54:0x0171, B:56:0x0177, B:59:0x018a, B:61:0x01a5, B:67:0x01e1, B:69:0x01e5, B:72:0x01ee, B:76:0x01f8, B:78:0x01fd, B:80:0x0201, B:82:0x020b, B:90:0x0225, B:92:0x022b, B:94:0x0236, B:96:0x025b, B:97:0x0278, B:99:0x0284, B:101:0x0291, B:102:0x02b1, B:87:0x021c, B:88:0x021f, B:81:0x0208, B:15:0x0051, B:16:0x0058), top: B:109:0x0011 }] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public static synchronized Bitmap drawTextExt(String str, int i, int i2, int[] iArr, int i3, int i4, int i5, int i6, int i7) {
        Paint.FontMetrics fontMetrics;
        int i8;
        Bitmap bitmap;
        int i9;
        int i10;
        Bitmap bitmap2;
        int desiredWidth;
        synchronized (EnvDrawText.class) {
            Canvas canvas = new Canvas();
            TextPaint textPaint = new TextPaint();
            String phoneType = SysOSUtil.getPhoneType();
            int i11 = 0;
            int i12 = (phoneType == null || !phoneType.equals("vivo X3L")) ? i2 : 0;
            textPaint.reset();
            textPaint.setSubpixelText(true);
            textPaint.setAntiAlias(true);
            textPaint.setTextSize(i);
            textPaint.setShadowLayer(0.0f, 0.0f, 0.0f, 0);
            textPaint.setTypeface(i12 != 1 ? i12 != 2 ? Typeface.create(Typeface.DEFAULT, 0) : Typeface.create(Typeface.DEFAULT, 2) : Typeface.create(Typeface.DEFAULT, 1));
            if (i6 != 0) {
                textPaint.setStrokeWidth(i6);
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
                        iArr[2] = i11;
                        iArr[3] = ceil;
                    }
                    if (i11 > 0 || ceil <= 0) {
                        bitmap2 = null;
                    } else {
                        bitmap2 = Bitmap.createBitmap(i11, ceil, Bitmap.Config.ARGB_8888);
                        if (bitmap2 == null) {
                            return bitmap2;
                        }
                        canvas.setBitmap(bitmap2);
                    }
                    if ((i5 & (-16777216)) != 0) {
                        canvas.drawColor(ViewCompat.MEASURED_SIZE_MASK);
                    } else {
                        canvas.drawColor(i5);
                    }
                    if (i6 != 0) {
                        textPaint.setStrokeWidth(i6);
                        textPaint.setStrokeCap(Paint.Cap.ROUND);
                        textPaint.setStrokeJoin(Paint.Join.ROUND);
                        textPaint.setStyle(Paint.Style.STROKE);
                        textPaint.setColor(i4);
                        canvas.drawText(str, 0.0f, 0.0f - fontMetrics2.ascent, textPaint);
                    }
                    textPaint.setStyle(Paint.Style.FILL);
                    textPaint.setColor(i3);
                    canvas.drawText(str, 0.0f, 0.0f - fontMetrics2.ascent, textPaint);
                }
                i11 = desiredWidth2;
                if (iArr.length == 4) {
                }
                if (i11 > 0) {
                }
                bitmap2 = null;
                if ((i5 & (-16777216)) != 0) {
                }
                if (i6 != 0) {
                }
                textPaint.setStyle(Paint.Style.FILL);
                textPaint.setColor(i3);
                canvas.drawText(str, 0.0f, 0.0f - fontMetrics2.ascent, textPaint);
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
                Paint.FontMetrics fontMetrics3 = textPaint.getFontMetrics();
                int ceil2 = (int) Math.ceil(fontMetrics3.descent - fontMetrics3.ascent);
                int i15 = i14 * ceil2;
                iArr[0] = desiredWidth3;
                iArr[1] = i15;
                if (iArr.length == 4) {
                    fontMetrics = fontMetrics3;
                    i8 = ceil2;
                    desiredWidth3 = (int) Math.pow(2.0d, (int) Math.ceil(Math.log(desiredWidth3) / Math.log(2.0d)));
                    i15 = (int) Math.pow(2.0d, (int) Math.ceil(Math.log(i15) / Math.log(2.0d)));
                } else {
                    fontMetrics = fontMetrics3;
                    i8 = ceil2;
                }
                if (desiredWidth3 == 0 && i15 == 0) {
                    desiredWidth3 = 0;
                    i15 = 0;
                }
                if (iArr.length == 4) {
                    iArr[2] = desiredWidth3;
                    iArr[3] = i15;
                }
                if (desiredWidth3 <= 0 || i15 <= 0) {
                    bitmap = null;
                } else {
                    bitmap = Bitmap.createBitmap(desiredWidth3, i15, Bitmap.Config.ARGB_8888);
                    if (bitmap == null) {
                        return bitmap;
                    }
                    canvas.setBitmap(bitmap);
                }
                if ((i5 & (-16777216)) == 0) {
                    canvas.drawColor(ViewCompat.MEASURED_SIZE_MASK);
                } else {
                    canvas.drawColor(i5);
                }
                textPaint.setTextAlign(getTextAlignedType(i7));
                if (i7 == 1) {
                    i10 = 0;
                    i9 = 0;
                } else {
                    i9 = 0;
                    i10 = i7 == 2 ? iArr[0] : iArr[0] / 2;
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
                        canvas.drawText(substring, i10, (i9 * i8) - fontMetrics.ascent, textPaint);
                    }
                    textPaint.setStyle(Paint.Style.FILL);
                    textPaint.setColor(i3);
                    canvas.drawText(substring, i10, (i9 * i8) - fontMetrics.ascent, textPaint);
                    i9++;
                    bitmap = bitmap;
                    i16 = 92;
                }
                Bitmap bitmap3 = bitmap;
                if (i17 != str.length()) {
                    String substring2 = str.substring(i17, str.length());
                    Layout.getDesiredWidth(substring2, textPaint);
                    if (i6 != 0) {
                        textPaint.setStrokeWidth(i6);
                        textPaint.setStrokeCap(Paint.Cap.ROUND);
                        textPaint.setStrokeJoin(Paint.Join.ROUND);
                        textPaint.setStyle(Paint.Style.STROKE);
                        textPaint.setColor(i4);
                        canvas.drawText(substring2, i10, (i9 * i8) - fontMetrics.ascent, textPaint);
                    }
                    textPaint.setStyle(Paint.Style.FILL);
                    textPaint.setColor(i3);
                    canvas.drawText(substring2, i10, (i9 * i8) - fontMetrics.ascent, textPaint);
                }
                bitmap2 = bitmap3;
            }
            return bitmap2;
        }
    }

    public static Paint.Align getTextAlignedType(int i) {
        return 1 == i ? Paint.Align.LEFT : 2 == i ? Paint.Align.RIGHT : Paint.Align.CENTER;
    }

    /* JADX WARN: Removed duplicated region for block: B:14:0x0033 A[LOOP:0: B:13:0x0031->B:14:0x0033, LOOP_END] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public static short[] getTextSize(String str, int i, int i2) {
        Typeface create;
        int i3;
        int length = str.length();
        if (length == 0) {
            return null;
        }
        TextPaint textPaint = new TextPaint();
        int i4 = 1;
        textPaint.setSubpixelText(true);
        textPaint.setAntiAlias(true);
        textPaint.setTextSize(i);
        if (i2 != 1) {
            i4 = 2;
            if (i2 != 2) {
                create = Typeface.create(Typeface.DEFAULT, 0);
                textPaint.setTypeface(create);
                short[] sArr = new short[length];
                i3 = 0;
                while (i3 < length) {
                    int i5 = i3 + 1;
                    sArr[i3] = (short) (Layout.getDesiredWidth(str, 0, i5, textPaint) + 0.5d);
                    i3 = i5;
                }
                return sArr;
            }
        }
        create = Typeface.create(Typeface.DEFAULT, i4);
        textPaint.setTypeface(create);
        short[] sArr2 = new short[length];
        i3 = 0;
        while (i3 < length) {
        }
        return sArr2;
    }

    public static float[] getTextSizeExt(String str, int i, int i2) {
        if (str.length() == 0) {
            return null;
        }
        Paint paint = new Paint();
        paint.setSubpixelText(true);
        paint.setAntiAlias(true);
        paint.setTextSize(i);
        paint.setTypeface(i2 != 1 ? i2 != 2 ? Typeface.create(Typeface.DEFAULT, 0) : Typeface.create(Typeface.DEFAULT, 2) : Typeface.create(Typeface.DEFAULT, 1));
        return new float[]{paint.measureText(str), paint.descent() - paint.ascent()};
    }

    public static synchronized void registFontCache(int i, Typeface typeface) {
        synchronized (EnvDrawText.class) {
            if (i == 0 || typeface == null) {
                return;
            }
            if (fontCache == null) {
                fontCache = new SparseArray<>();
            }
            a aVar = fontCache.get(i);
            if (aVar == null) {
                a aVar2 = new a();
                aVar2.f69277a = typeface;
                aVar2.f69278b++;
                fontCache.put(i, aVar2);
            } else {
                aVar.f69278b++;
            }
        }
    }

    public static synchronized void removeFontCache(int i) {
        synchronized (EnvDrawText.class) {
            a aVar = fontCache.get(i);
            if (aVar == null) {
                return;
            }
            int i2 = aVar.f69278b - 1;
            aVar.f69278b = i2;
            if (i2 == 0) {
                fontCache.remove(i);
            }
        }
    }
}
