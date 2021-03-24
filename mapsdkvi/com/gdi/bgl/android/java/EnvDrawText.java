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
    public static final String f68118a = "EnvDrawText";
    public static boolean bBmpChange = false;
    public static Bitmap bmp;
    public static int[] buffer;
    public static SparseArray<a> fontCache;

    /* JADX WARN: Removed duplicated region for block: B:100:0x025b  */
    /* JADX WARN: Removed duplicated region for block: B:101:0x025e  */
    /* JADX WARN: Removed duplicated region for block: B:108:0x0272 A[Catch: all -> 0x0331, TryCatch #0 {, blocks: (B:4:0x0011, B:6:0x0022, B:10:0x002e, B:13:0x0047, B:14:0x004d, B:18:0x0061, B:19:0x0074, B:21:0x007c, B:23:0x0080, B:25:0x008a, B:26:0x008f, B:28:0x00a4, B:30:0x00b7, B:32:0x00c9, B:39:0x0107, B:41:0x010b, B:44:0x0114, B:46:0x011c, B:50:0x0123, B:52:0x012d, B:54:0x0131, B:57:0x013d, B:59:0x0160, B:120:0x0317, B:122:0x031d, B:124:0x0326, B:126:0x032c, B:55:0x0138, B:60:0x0174, B:61:0x0186, B:63:0x018c, B:66:0x0198, B:67:0x019f, B:69:0x01a5, B:73:0x01bb, B:75:0x01d7, B:82:0x0224, B:84:0x0228, B:87:0x0231, B:89:0x0239, B:92:0x023e, B:94:0x0243, B:96:0x0247, B:98:0x0251, B:106:0x026c, B:108:0x0272, B:110:0x027d, B:112:0x02aa, B:113:0x02c8, B:115:0x02d4, B:117:0x02e1, B:118:0x0301, B:103:0x0261, B:104:0x0265, B:97:0x024e, B:15:0x0051, B:16:0x0058), top: B:134:0x0011 }] */
    /* JADX WARN: Removed duplicated region for block: B:115:0x02d4 A[Catch: all -> 0x0331, TryCatch #0 {, blocks: (B:4:0x0011, B:6:0x0022, B:10:0x002e, B:13:0x0047, B:14:0x004d, B:18:0x0061, B:19:0x0074, B:21:0x007c, B:23:0x0080, B:25:0x008a, B:26:0x008f, B:28:0x00a4, B:30:0x00b7, B:32:0x00c9, B:39:0x0107, B:41:0x010b, B:44:0x0114, B:46:0x011c, B:50:0x0123, B:52:0x012d, B:54:0x0131, B:57:0x013d, B:59:0x0160, B:120:0x0317, B:122:0x031d, B:124:0x0326, B:126:0x032c, B:55:0x0138, B:60:0x0174, B:61:0x0186, B:63:0x018c, B:66:0x0198, B:67:0x019f, B:69:0x01a5, B:73:0x01bb, B:75:0x01d7, B:82:0x0224, B:84:0x0228, B:87:0x0231, B:89:0x0239, B:92:0x023e, B:94:0x0243, B:96:0x0247, B:98:0x0251, B:106:0x026c, B:108:0x0272, B:110:0x027d, B:112:0x02aa, B:113:0x02c8, B:115:0x02d4, B:117:0x02e1, B:118:0x0301, B:103:0x0261, B:104:0x0265, B:97:0x024e, B:15:0x0051, B:16:0x0058), top: B:134:0x0011 }] */
    /* JADX WARN: Removed duplicated region for block: B:138:0x02c8 A[EDGE_INSN: B:138:0x02c8->B:113:0x02c8 ?: BREAK  , SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:41:0x010b A[Catch: all -> 0x0331, TryCatch #0 {, blocks: (B:4:0x0011, B:6:0x0022, B:10:0x002e, B:13:0x0047, B:14:0x004d, B:18:0x0061, B:19:0x0074, B:21:0x007c, B:23:0x0080, B:25:0x008a, B:26:0x008f, B:28:0x00a4, B:30:0x00b7, B:32:0x00c9, B:39:0x0107, B:41:0x010b, B:44:0x0114, B:46:0x011c, B:50:0x0123, B:52:0x012d, B:54:0x0131, B:57:0x013d, B:59:0x0160, B:120:0x0317, B:122:0x031d, B:124:0x0326, B:126:0x032c, B:55:0x0138, B:60:0x0174, B:61:0x0186, B:63:0x018c, B:66:0x0198, B:67:0x019f, B:69:0x01a5, B:73:0x01bb, B:75:0x01d7, B:82:0x0224, B:84:0x0228, B:87:0x0231, B:89:0x0239, B:92:0x023e, B:94:0x0243, B:96:0x0247, B:98:0x0251, B:106:0x026c, B:108:0x0272, B:110:0x027d, B:112:0x02aa, B:113:0x02c8, B:115:0x02d4, B:117:0x02e1, B:118:0x0301, B:103:0x0261, B:104:0x0265, B:97:0x024e, B:15:0x0051, B:16:0x0058), top: B:134:0x0011 }] */
    /* JADX WARN: Removed duplicated region for block: B:54:0x0131 A[Catch: all -> 0x0331, TryCatch #0 {, blocks: (B:4:0x0011, B:6:0x0022, B:10:0x002e, B:13:0x0047, B:14:0x004d, B:18:0x0061, B:19:0x0074, B:21:0x007c, B:23:0x0080, B:25:0x008a, B:26:0x008f, B:28:0x00a4, B:30:0x00b7, B:32:0x00c9, B:39:0x0107, B:41:0x010b, B:44:0x0114, B:46:0x011c, B:50:0x0123, B:52:0x012d, B:54:0x0131, B:57:0x013d, B:59:0x0160, B:120:0x0317, B:122:0x031d, B:124:0x0326, B:126:0x032c, B:55:0x0138, B:60:0x0174, B:61:0x0186, B:63:0x018c, B:66:0x0198, B:67:0x019f, B:69:0x01a5, B:73:0x01bb, B:75:0x01d7, B:82:0x0224, B:84:0x0228, B:87:0x0231, B:89:0x0239, B:92:0x023e, B:94:0x0243, B:96:0x0247, B:98:0x0251, B:106:0x026c, B:108:0x0272, B:110:0x027d, B:112:0x02aa, B:113:0x02c8, B:115:0x02d4, B:117:0x02e1, B:118:0x0301, B:103:0x0261, B:104:0x0265, B:97:0x024e, B:15:0x0051, B:16:0x0058), top: B:134:0x0011 }] */
    /* JADX WARN: Removed duplicated region for block: B:55:0x0138 A[Catch: all -> 0x0331, TryCatch #0 {, blocks: (B:4:0x0011, B:6:0x0022, B:10:0x002e, B:13:0x0047, B:14:0x004d, B:18:0x0061, B:19:0x0074, B:21:0x007c, B:23:0x0080, B:25:0x008a, B:26:0x008f, B:28:0x00a4, B:30:0x00b7, B:32:0x00c9, B:39:0x0107, B:41:0x010b, B:44:0x0114, B:46:0x011c, B:50:0x0123, B:52:0x012d, B:54:0x0131, B:57:0x013d, B:59:0x0160, B:120:0x0317, B:122:0x031d, B:124:0x0326, B:126:0x032c, B:55:0x0138, B:60:0x0174, B:61:0x0186, B:63:0x018c, B:66:0x0198, B:67:0x019f, B:69:0x01a5, B:73:0x01bb, B:75:0x01d7, B:82:0x0224, B:84:0x0228, B:87:0x0231, B:89:0x0239, B:92:0x023e, B:94:0x0243, B:96:0x0247, B:98:0x0251, B:106:0x026c, B:108:0x0272, B:110:0x027d, B:112:0x02aa, B:113:0x02c8, B:115:0x02d4, B:117:0x02e1, B:118:0x0301, B:103:0x0261, B:104:0x0265, B:97:0x024e, B:15:0x0051, B:16:0x0058), top: B:134:0x0011 }] */
    /* JADX WARN: Removed duplicated region for block: B:57:0x013d A[Catch: all -> 0x0331, TryCatch #0 {, blocks: (B:4:0x0011, B:6:0x0022, B:10:0x002e, B:13:0x0047, B:14:0x004d, B:18:0x0061, B:19:0x0074, B:21:0x007c, B:23:0x0080, B:25:0x008a, B:26:0x008f, B:28:0x00a4, B:30:0x00b7, B:32:0x00c9, B:39:0x0107, B:41:0x010b, B:44:0x0114, B:46:0x011c, B:50:0x0123, B:52:0x012d, B:54:0x0131, B:57:0x013d, B:59:0x0160, B:120:0x0317, B:122:0x031d, B:124:0x0326, B:126:0x032c, B:55:0x0138, B:60:0x0174, B:61:0x0186, B:63:0x018c, B:66:0x0198, B:67:0x019f, B:69:0x01a5, B:73:0x01bb, B:75:0x01d7, B:82:0x0224, B:84:0x0228, B:87:0x0231, B:89:0x0239, B:92:0x023e, B:94:0x0243, B:96:0x0247, B:98:0x0251, B:106:0x026c, B:108:0x0272, B:110:0x027d, B:112:0x02aa, B:113:0x02c8, B:115:0x02d4, B:117:0x02e1, B:118:0x0301, B:103:0x0261, B:104:0x0265, B:97:0x024e, B:15:0x0051, B:16:0x0058), top: B:134:0x0011 }] */
    /* JADX WARN: Removed duplicated region for block: B:58:0x015e  */
    /* JADX WARN: Removed duplicated region for block: B:84:0x0228 A[Catch: all -> 0x0331, TryCatch #0 {, blocks: (B:4:0x0011, B:6:0x0022, B:10:0x002e, B:13:0x0047, B:14:0x004d, B:18:0x0061, B:19:0x0074, B:21:0x007c, B:23:0x0080, B:25:0x008a, B:26:0x008f, B:28:0x00a4, B:30:0x00b7, B:32:0x00c9, B:39:0x0107, B:41:0x010b, B:44:0x0114, B:46:0x011c, B:50:0x0123, B:52:0x012d, B:54:0x0131, B:57:0x013d, B:59:0x0160, B:120:0x0317, B:122:0x031d, B:124:0x0326, B:126:0x032c, B:55:0x0138, B:60:0x0174, B:61:0x0186, B:63:0x018c, B:66:0x0198, B:67:0x019f, B:69:0x01a5, B:73:0x01bb, B:75:0x01d7, B:82:0x0224, B:84:0x0228, B:87:0x0231, B:89:0x0239, B:92:0x023e, B:94:0x0243, B:96:0x0247, B:98:0x0251, B:106:0x026c, B:108:0x0272, B:110:0x027d, B:112:0x02aa, B:113:0x02c8, B:115:0x02d4, B:117:0x02e1, B:118:0x0301, B:103:0x0261, B:104:0x0265, B:97:0x024e, B:15:0x0051, B:16:0x0058), top: B:134:0x0011 }] */
    /* JADX WARN: Removed duplicated region for block: B:96:0x0247 A[Catch: all -> 0x0331, TryCatch #0 {, blocks: (B:4:0x0011, B:6:0x0022, B:10:0x002e, B:13:0x0047, B:14:0x004d, B:18:0x0061, B:19:0x0074, B:21:0x007c, B:23:0x0080, B:25:0x008a, B:26:0x008f, B:28:0x00a4, B:30:0x00b7, B:32:0x00c9, B:39:0x0107, B:41:0x010b, B:44:0x0114, B:46:0x011c, B:50:0x0123, B:52:0x012d, B:54:0x0131, B:57:0x013d, B:59:0x0160, B:120:0x0317, B:122:0x031d, B:124:0x0326, B:126:0x032c, B:55:0x0138, B:60:0x0174, B:61:0x0186, B:63:0x018c, B:66:0x0198, B:67:0x019f, B:69:0x01a5, B:73:0x01bb, B:75:0x01d7, B:82:0x0224, B:84:0x0228, B:87:0x0231, B:89:0x0239, B:92:0x023e, B:94:0x0243, B:96:0x0247, B:98:0x0251, B:106:0x026c, B:108:0x0272, B:110:0x027d, B:112:0x02aa, B:113:0x02c8, B:115:0x02d4, B:117:0x02e1, B:118:0x0301, B:103:0x0261, B:104:0x0265, B:97:0x024e, B:15:0x0051, B:16:0x0058), top: B:134:0x0011 }] */
    /* JADX WARN: Removed duplicated region for block: B:97:0x024e A[Catch: all -> 0x0331, TryCatch #0 {, blocks: (B:4:0x0011, B:6:0x0022, B:10:0x002e, B:13:0x0047, B:14:0x004d, B:18:0x0061, B:19:0x0074, B:21:0x007c, B:23:0x0080, B:25:0x008a, B:26:0x008f, B:28:0x00a4, B:30:0x00b7, B:32:0x00c9, B:39:0x0107, B:41:0x010b, B:44:0x0114, B:46:0x011c, B:50:0x0123, B:52:0x012d, B:54:0x0131, B:57:0x013d, B:59:0x0160, B:120:0x0317, B:122:0x031d, B:124:0x0326, B:126:0x032c, B:55:0x0138, B:60:0x0174, B:61:0x0186, B:63:0x018c, B:66:0x0198, B:67:0x019f, B:69:0x01a5, B:73:0x01bb, B:75:0x01d7, B:82:0x0224, B:84:0x0228, B:87:0x0231, B:89:0x0239, B:92:0x023e, B:94:0x0243, B:96:0x0247, B:98:0x0251, B:106:0x026c, B:108:0x0272, B:110:0x027d, B:112:0x02aa, B:113:0x02c8, B:115:0x02d4, B:117:0x02e1, B:118:0x0301, B:103:0x0261, B:104:0x0265, B:97:0x024e, B:15:0x0051, B:16:0x0058), top: B:134:0x0011 }] */
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
                textPaint3.setTypeface(aVar.f68119a);
            }
            textPaint3.setTextSize(f2);
            int indexOf2 = str.indexOf(92, 0);
            if (indexOf2 == -1) {
                Paint.FontMetrics fontMetrics3 = textPaint3.getFontMetrics();
                double desiredWidth = Layout.getDesiredWidth(str, 0, str.length(), textPaint3);
                Double.isNaN(desiredWidth);
                int i22 = (int) (desiredWidth + 0.5d);
                i18 = (int) Math.ceil(fontMetrics3.descent - fontMetrics3.ascent);
                iArr[0] = i22;
                iArr[1] = i18;
                if (iArr.length == 4) {
                    i22 = (int) Math.pow(2.0d, (int) Math.ceil(Math.log(i22) / Math.log(2.0d)));
                    textPaint = textPaint3;
                    i18 = (int) Math.pow(2.0d, (int) Math.ceil(Math.log(i18) / Math.log(2.0d)));
                } else {
                    textPaint = textPaint3;
                }
                if (i22 == 0 && i18 == 0) {
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
                i17 = i22;
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
                if (i23 != str.length()) {
                    double desiredWidth2 = Layout.getDesiredWidth(str.substring(i23, str.length()), textPaint3);
                    Double.isNaN(desiredWidth2);
                    int i26 = (int) (desiredWidth2 + 0.5d);
                    if (i26 > measureText) {
                        measureText = i26;
                    }
                }
                Paint.FontMetrics fontMetrics4 = textPaint3.getFontMetrics();
                int ceil = (int) Math.ceil(fontMetrics4.descent - fontMetrics4.ascent);
                int i27 = ceil * i25;
                iArr[0] = measureText;
                iArr[1] = i27;
                if (iArr.length == 4) {
                    fontMetrics = fontMetrics4;
                    i8 = ceil;
                    int pow = (int) Math.pow(2.0d, (int) Math.ceil(Math.log(measureText) / Math.log(2.0d)));
                    i10 = (int) Math.pow(2.0d, (int) Math.ceil(Math.log(i27) / Math.log(2.0d)));
                    i9 = pow;
                } else {
                    fontMetrics = fontMetrics4;
                    i8 = ceil;
                    i9 = measureText;
                    i10 = i27;
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
                        int i28 = indexOf + 1;
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
                        i13 = i28;
                        i11 = i20;
                        i16 = 92;
                        i12 = i19;
                    }
                    int i29 = i12;
                    int i30 = i11;
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
                    i17 = i29;
                    i18 = i30;
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
                    i13 = i28;
                    i11 = i20;
                    i16 = 92;
                    i12 = i19;
                }
                int i292 = i12;
                int i302 = i11;
                Paint.FontMetrics fontMetrics52 = fontMetrics;
                if (i13 != str.length()) {
                }
                i17 = i292;
                i18 = i302;
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
        int ceil;
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
            int desiredWidth = (int) (Layout.getDesiredWidth(str, 0, str.length(), textPaint) + f2);
            int ceil2 = (int) Math.ceil(fontMetrics.descent - fontMetrics.ascent);
            if (desiredWidth > 0 && ceil2 > 0) {
                bitmap = Bitmap.createBitmap(desiredWidth, ceil2, Bitmap.Config.ALPHA_8);
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
            double desiredWidth2 = Layout.getDesiredWidth(str.substring(0, indexOf), textPaint);
            Double.isNaN(desiredWidth2);
            int i9 = (int) (desiredWidth2 + 0.5d);
            while (true) {
                int indexOf2 = str.indexOf(i7, i8);
                if (indexOf2 <= 0) {
                    break;
                }
                double desiredWidth3 = Layout.getDesiredWidth(str.substring(i8, indexOf2), textPaint);
                Double.isNaN(desiredWidth3);
                int i10 = (int) (desiredWidth3 + 0.5d);
                if (i10 > i9) {
                    i9 = i10;
                }
                i8 = indexOf2 + 1;
                i6++;
                i7 = 92;
            }
            if (i8 != str.length()) {
                double desiredWidth4 = Layout.getDesiredWidth(str.substring(i8, str.length()), textPaint);
                Double.isNaN(desiredWidth4);
                int i11 = (int) (desiredWidth4 + 0.5d);
                if (i11 > i9) {
                    i9 = i11;
                }
            }
            Paint.FontMetrics fontMetrics2 = textPaint.getFontMetrics();
            int i12 = i9 + i3;
            int ceil3 = i6 * ((int) Math.ceil(fontMetrics2.descent - fontMetrics2.ascent));
            if (i12 > 0 && ceil3 > 0) {
                bitmap = Bitmap.createBitmap(i12, ceil3, Bitmap.Config.ALPHA_8);
                if (bitmap == null) {
                    return bitmap;
                }
                bitmap.eraseColor(0);
                canvas.setBitmap(bitmap);
            }
            textPaint.setTextAlign(getTextAlignedType(3));
            float f3 = i12 - (f2 * 0.5f);
            int i13 = 0;
            while (true) {
                int indexOf3 = str.indexOf(92, i4);
                if (indexOf3 <= 0) {
                    break;
                }
                String substring = str.substring(i4, indexOf3);
                Layout.getDesiredWidth(substring, textPaint);
                textPaint.setStyle(Paint.Style.FILL);
                canvas.drawText(substring, f3, (i13 * ceil) - fontMetrics2.ascent, textPaint);
                i13++;
                i4 = indexOf3 + 1;
            }
            if (i4 != str.length()) {
                String substring2 = str.substring(i4, str.length());
                Layout.getDesiredWidth(substring2, textPaint);
                textPaint.setStyle(Paint.Style.FILL);
                canvas.drawText(substring2, f3, (i13 * ceil) - fontMetrics2.ascent, textPaint);
            }
        }
        return bitmap;
    }

    /* JADX WARN: Removed duplicated region for block: B:33:0x00e5 A[Catch: all -> 0x02d3, TryCatch #0 {, blocks: (B:4:0x0011, B:6:0x0022, B:10:0x002e, B:13:0x0047, B:14:0x004d, B:18:0x0061, B:19:0x0074, B:21:0x0083, B:23:0x0096, B:25:0x00a9, B:31:0x00e1, B:33:0x00e5, B:36:0x00ee, B:40:0x00f8, B:42:0x00fd, B:44:0x0101, B:47:0x010d, B:48:0x012d, B:45:0x0108, B:49:0x0141, B:52:0x015a, B:54:0x0160, B:59:0x017a, B:61:0x0180, B:65:0x0196, B:67:0x01b1, B:73:0x01ed, B:75:0x01f1, B:78:0x01fa, B:82:0x0204, B:84:0x0209, B:86:0x020d, B:88:0x0217, B:96:0x0231, B:98:0x0237, B:100:0x0242, B:102:0x0267, B:103:0x0284, B:105:0x0290, B:107:0x029d, B:108:0x02bd, B:93:0x0228, B:94:0x022b, B:87:0x0214, B:15:0x0051, B:16:0x0058), top: B:117:0x0011 }] */
    /* JADX WARN: Removed duplicated region for block: B:44:0x0101 A[Catch: all -> 0x02d3, TryCatch #0 {, blocks: (B:4:0x0011, B:6:0x0022, B:10:0x002e, B:13:0x0047, B:14:0x004d, B:18:0x0061, B:19:0x0074, B:21:0x0083, B:23:0x0096, B:25:0x00a9, B:31:0x00e1, B:33:0x00e5, B:36:0x00ee, B:40:0x00f8, B:42:0x00fd, B:44:0x0101, B:47:0x010d, B:48:0x012d, B:45:0x0108, B:49:0x0141, B:52:0x015a, B:54:0x0160, B:59:0x017a, B:61:0x0180, B:65:0x0196, B:67:0x01b1, B:73:0x01ed, B:75:0x01f1, B:78:0x01fa, B:82:0x0204, B:84:0x0209, B:86:0x020d, B:88:0x0217, B:96:0x0231, B:98:0x0237, B:100:0x0242, B:102:0x0267, B:103:0x0284, B:105:0x0290, B:107:0x029d, B:108:0x02bd, B:93:0x0228, B:94:0x022b, B:87:0x0214, B:15:0x0051, B:16:0x0058), top: B:117:0x0011 }] */
    /* JADX WARN: Removed duplicated region for block: B:45:0x0108 A[Catch: all -> 0x02d3, TryCatch #0 {, blocks: (B:4:0x0011, B:6:0x0022, B:10:0x002e, B:13:0x0047, B:14:0x004d, B:18:0x0061, B:19:0x0074, B:21:0x0083, B:23:0x0096, B:25:0x00a9, B:31:0x00e1, B:33:0x00e5, B:36:0x00ee, B:40:0x00f8, B:42:0x00fd, B:44:0x0101, B:47:0x010d, B:48:0x012d, B:45:0x0108, B:49:0x0141, B:52:0x015a, B:54:0x0160, B:59:0x017a, B:61:0x0180, B:65:0x0196, B:67:0x01b1, B:73:0x01ed, B:75:0x01f1, B:78:0x01fa, B:82:0x0204, B:84:0x0209, B:86:0x020d, B:88:0x0217, B:96:0x0231, B:98:0x0237, B:100:0x0242, B:102:0x0267, B:103:0x0284, B:105:0x0290, B:107:0x029d, B:108:0x02bd, B:93:0x0228, B:94:0x022b, B:87:0x0214, B:15:0x0051, B:16:0x0058), top: B:117:0x0011 }] */
    /* JADX WARN: Removed duplicated region for block: B:47:0x010d A[Catch: all -> 0x02d3, TryCatch #0 {, blocks: (B:4:0x0011, B:6:0x0022, B:10:0x002e, B:13:0x0047, B:14:0x004d, B:18:0x0061, B:19:0x0074, B:21:0x0083, B:23:0x0096, B:25:0x00a9, B:31:0x00e1, B:33:0x00e5, B:36:0x00ee, B:40:0x00f8, B:42:0x00fd, B:44:0x0101, B:47:0x010d, B:48:0x012d, B:45:0x0108, B:49:0x0141, B:52:0x015a, B:54:0x0160, B:59:0x017a, B:61:0x0180, B:65:0x0196, B:67:0x01b1, B:73:0x01ed, B:75:0x01f1, B:78:0x01fa, B:82:0x0204, B:84:0x0209, B:86:0x020d, B:88:0x0217, B:96:0x0231, B:98:0x0237, B:100:0x0242, B:102:0x0267, B:103:0x0284, B:105:0x0290, B:107:0x029d, B:108:0x02bd, B:93:0x0228, B:94:0x022b, B:87:0x0214, B:15:0x0051, B:16:0x0058), top: B:117:0x0011 }] */
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
                double desiredWidth = Layout.getDesiredWidth(str, 0, str.length(), textPaint);
                Double.isNaN(desiredWidth);
                int i13 = (int) (desiredWidth + 0.5d);
                int ceil = (int) Math.ceil(fontMetrics2.descent - fontMetrics2.ascent);
                iArr[0] = i13;
                iArr[1] = ceil;
                if (iArr.length == 4) {
                    i13 = (int) Math.pow(2.0d, (int) Math.ceil(Math.log(i13) / Math.log(2.0d)));
                    ceil = (int) Math.pow(2.0d, (int) Math.ceil(Math.log(ceil) / Math.log(2.0d)));
                }
                if (i13 == 0 && ceil == 0) {
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
                i11 = i13;
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
                int i14 = indexOf + 1;
                double desiredWidth2 = Layout.getDesiredWidth(str.substring(0, indexOf), textPaint);
                Double.isNaN(desiredWidth2);
                int i15 = (int) (desiredWidth2 + 0.5d);
                int i16 = 2;
                while (true) {
                    int indexOf2 = str.indexOf(92, i14);
                    if (indexOf2 <= 0) {
                        break;
                    }
                    double desiredWidth3 = Layout.getDesiredWidth(str.substring(i14, indexOf2), textPaint);
                    Double.isNaN(desiredWidth3);
                    int i17 = (int) (desiredWidth3 + 0.5d);
                    if (i17 > i15) {
                        i15 = i17;
                    }
                    i14 = indexOf2 + 1;
                    i16++;
                }
                if (i14 != str.length()) {
                    double desiredWidth4 = Layout.getDesiredWidth(str.substring(i14, str.length()), textPaint);
                    Double.isNaN(desiredWidth4);
                    int i18 = (int) (desiredWidth4 + 0.5d);
                    if (i18 > i15) {
                        i15 = i18;
                    }
                }
                Paint.FontMetrics fontMetrics3 = textPaint.getFontMetrics();
                int ceil2 = (int) Math.ceil(fontMetrics3.descent - fontMetrics3.ascent);
                int i19 = i16 * ceil2;
                iArr[0] = i15;
                iArr[1] = i19;
                if (iArr.length == 4) {
                    fontMetrics = fontMetrics3;
                    i8 = ceil2;
                    i15 = (int) Math.pow(2.0d, (int) Math.ceil(Math.log(i15) / Math.log(2.0d)));
                    i19 = (int) Math.pow(2.0d, (int) Math.ceil(Math.log(i19) / Math.log(2.0d)));
                } else {
                    fontMetrics = fontMetrics3;
                    i8 = ceil2;
                }
                if (i15 == 0 && i19 == 0) {
                    i15 = 0;
                    i19 = 0;
                }
                if (iArr.length == 4) {
                    iArr[2] = i15;
                    iArr[3] = i19;
                }
                if (i15 <= 0 || i19 <= 0) {
                    bitmap = null;
                } else {
                    bitmap = Bitmap.createBitmap(i15, i19, Bitmap.Config.ARGB_8888);
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
                int i20 = 92;
                int i21 = 0;
                while (true) {
                    int indexOf3 = str.indexOf(i20, i21);
                    if (indexOf3 <= 0) {
                        break;
                    }
                    String substring = str.substring(i21, indexOf3);
                    Layout.getDesiredWidth(substring, textPaint);
                    i21 = indexOf3 + 1;
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
                    i20 = 92;
                }
                Bitmap bitmap3 = bitmap;
                if (i21 != str.length()) {
                    String substring2 = str.substring(i21, str.length());
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
        double d2;
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
                    Double.isNaN(Layout.getDesiredWidth(str, 0, i5, textPaint));
                    sArr[i3] = (short) (d2 + 0.5d);
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
                aVar2.f68119a = typeface;
                aVar2.f68120b++;
                fontCache.put(i, aVar2);
            } else {
                aVar.f68120b++;
            }
        }
    }

    public static synchronized void removeFontCache(int i) {
        synchronized (EnvDrawText.class) {
            a aVar = fontCache.get(i);
            if (aVar == null) {
                return;
            }
            int i2 = aVar.f68120b - 1;
            aVar.f68120b = i2;
            if (i2 == 0) {
                fontCache.remove(i);
            }
        }
    }
}
