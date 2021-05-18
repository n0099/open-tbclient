package d.a.k0.q3.l;

import android.annotation.TargetApi;
import android.media.MediaExtractor;
import android.media.MediaFormat;
import com.baidu.adp.lib.util.BdLog;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.nio.ByteOrder;
/* loaded from: classes5.dex */
public class g {

    /* renamed from: a  reason: collision with root package name */
    public static boolean f60077a = false;

    /* loaded from: classes5.dex */
    public static class a {

        /* renamed from: a  reason: collision with root package name */
        public int f60078a = 48000;

        /* renamed from: b  reason: collision with root package name */
        public int f60079b = 1;

        /* renamed from: c  reason: collision with root package name */
        public int f60080c = 16;

        /* renamed from: d  reason: collision with root package name */
        public int f60081d = 0;

        public boolean a() {
            int i2 = this.f60081d;
            return i2 == 5 || i2 == 6 || i2 == 8 || i2 == 9;
        }

        public boolean b() {
            int i2 = this.f60081d;
            return i2 == 3 || i2 == 4 || i2 == 8 || i2 == 9;
        }

        public boolean c() {
            int i2 = this.f60081d;
            return i2 == 1 || i2 == 4 || i2 == 6 || i2 == 9;
        }
    }

    public static byte[] a(byte b2, byte b3, byte b4, byte b5, boolean z) {
        return e((short) ((f(b2, b3, z) / 2) + (f(b4, b5, z) / 2)), z);
    }

    public static byte[] b(int i2, int i3, byte[] bArr) {
        BdLog.e("convertChannelCount sourceByteWidth = " + i2 + " outputByteWidth = " + i3);
        if (i2 == i3) {
            return bArr;
        }
        int length = bArr.length;
        if (i2 != 1) {
            if (i2 == 2 && i3 == 1) {
                int i4 = length / 2;
                byte[] bArr2 = new byte[i4];
                for (int i5 = 0; i5 < i4; i5++) {
                    int i6 = i5 * 2;
                    bArr2[i5] = (byte) (f(bArr[i6], bArr[i6 + 1], f60077a) / 256);
                }
                return bArr2;
            }
        } else if (i3 == 2) {
            byte[] bArr3 = new byte[length * 2];
            for (int i7 = 0; i7 < length; i7++) {
                byte[] e2 = e((short) (bArr[i7] * 256), f60077a);
                int i8 = i7 * 2;
                bArr3[i8] = e2[0];
                bArr3[i8 + 1] = e2[1];
            }
            return bArr3;
        }
        return bArr;
    }

    public static byte[] c(int i2, int i3, int i4, byte[] bArr) {
        BdLog.e("convertChannelCount sourceChannelCount = " + i2 + " outputChannelCount = " + i3);
        if (i2 == i3) {
            return bArr;
        }
        if (i4 == 1 || i4 == 2) {
            int length = bArr.length;
            int i5 = 0;
            if (i2 != 1) {
                if (i2 == 2 && i3 == 1) {
                    int i6 = length / 2;
                    byte[] bArr2 = new byte[i6];
                    if (i4 == 1) {
                        while (i5 < i6) {
                            int i7 = i5 * 2;
                            bArr2[i5] = (byte) (((short) (bArr[i7] + bArr[i7 + 1])) >> 1);
                            i5 += 2;
                        }
                    } else if (i4 == 2) {
                        for (int i8 = 0; i8 < i6; i8 += 2) {
                            int i9 = i8 * 2;
                            byte[] a2 = a(bArr[i9], bArr[i9 + 1], bArr[i9 + 2], bArr[i9 + 3], f60077a);
                            bArr2[i8] = a2[0];
                            bArr2[i8 + 1] = a2[1];
                        }
                    }
                    return bArr2;
                }
            } else if (i3 == 2) {
                byte[] bArr3 = new byte[length * 2];
                if (i4 == 1) {
                    while (i5 < length) {
                        byte b2 = bArr[i5];
                        int i10 = i5 * 2;
                        bArr3[i10] = b2;
                        bArr3[i10 + 1] = b2;
                        i5++;
                    }
                } else if (i4 == 2) {
                    while (i5 < length) {
                        byte b3 = bArr[i5];
                        byte b4 = bArr[i5 + 1];
                        int i11 = i5 * 2;
                        bArr3[i11] = b3;
                        bArr3[i11 + 1] = b4;
                        bArr3[i11 + 2] = b3;
                        bArr3[i11 + 3] = b4;
                        i5 += 2;
                    }
                }
                return bArr3;
            }
            return bArr;
        }
        return bArr;
    }

    @TargetApi(16)
    public static a d(String str) {
        MediaFormat mediaFormat;
        MediaExtractor mediaExtractor = new MediaExtractor();
        try {
            mediaExtractor.setDataSource(str);
            int i2 = 0;
            while (true) {
                if (i2 >= mediaExtractor.getTrackCount()) {
                    mediaFormat = null;
                    break;
                }
                mediaFormat = mediaExtractor.getTrackFormat(i2);
                if (mediaFormat.getString("mime").startsWith("audio/")) {
                    mediaExtractor.selectTrack(i2);
                    break;
                }
                i2++;
            }
            if (mediaFormat == null) {
                mediaExtractor.release();
                return null;
            }
            a aVar = new a();
            aVar.f60078a = mediaFormat.containsKey("sample-rate") ? mediaFormat.getInteger("sample-rate") : 48000;
            aVar.f60079b = mediaFormat.containsKey("channel-count") ? mediaFormat.getInteger("channel-count") : 1;
            aVar.f60080c = mediaFormat.containsKey("bit-width") ? mediaFormat.getInteger("bit-width") : 16;
            mediaExtractor.release();
            return aVar;
        } catch (IOException e2) {
            e2.printStackTrace();
            return null;
        }
    }

    public static byte[] e(short s, boolean z) {
        byte[] bArr = new byte[2];
        if (z) {
            bArr[1] = (byte) (s & 255);
            bArr[0] = (byte) (((short) (s >> 8)) & 255);
        } else {
            bArr[0] = (byte) (s & 255);
            bArr[1] = (byte) (((short) (s >> 8)) & 255);
        }
        return bArr;
    }

    public static short f(byte b2, byte b3, boolean z) {
        int i2;
        if (z) {
            i2 = ((short) (((short) ((b2 & 255) | 0)) << 8)) | (b3 & 255);
        } else {
            i2 = (b2 & 255) | ((short) (((short) ((b3 & 255) | 0)) << 8));
        }
        return (short) i2;
    }

    public static void g() {
        if (ByteOrder.nativeOrder() == ByteOrder.BIG_ENDIAN) {
            f60077a = true;
        } else {
            f60077a = false;
        }
    }

    public static boolean h(a... aVarArr) {
        a aVar;
        if (aVarArr == null || aVarArr.length < 2 || (aVar = aVarArr[0]) == null) {
            return false;
        }
        boolean z = true;
        for (int i2 = 1; i2 < aVarArr.length; i2++) {
            if (aVar.f60078a != aVarArr[i2].f60078a) {
                aVarArr[i2].f60081d++;
                z = false;
            }
            if (aVar.f60079b != aVarArr[i2].f60079b) {
                aVarArr[i2].f60081d += 3;
                z = false;
            }
            if (aVar.f60080c != aVarArr[i2].f60080c) {
                aVarArr[i2].f60081d += 5;
                z = false;
            }
        }
        return z;
    }

    public static boolean i(String str, String str2, int i2, int i3) {
        BdLog.e("resampling sampleRate = " + i2 + " resampleRate = " + i3);
        if (i3 == i2) {
            return false;
        }
        File file = new File(str);
        File file2 = new File(str2);
        try {
            FileInputStream fileInputStream = new FileInputStream(file);
            FileOutputStream fileOutputStream = new FileOutputStream(file2);
            new j(fileInputStream, fileOutputStream, i2, i3, 2, 2, 1, Integer.MAX_VALUE, 0.0d, 0, true);
            fileInputStream.close();
            fileOutputStream.close();
            return true;
        } catch (Exception e2) {
            e2.printStackTrace();
            return false;
        }
    }
}
