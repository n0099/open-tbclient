package d.b.i0.q3.l;

import android.annotation.TargetApi;
import android.media.MediaExtractor;
import android.media.MediaFormat;
import com.baidu.adp.lib.util.BdLog;
import com.kwai.video.player.misc.IMediaFormat;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.nio.ByteOrder;
/* loaded from: classes5.dex */
public class g {

    /* renamed from: a  reason: collision with root package name */
    public static boolean f60773a = false;

    /* loaded from: classes5.dex */
    public static class a {

        /* renamed from: a  reason: collision with root package name */
        public int f60774a = 48000;

        /* renamed from: b  reason: collision with root package name */
        public int f60775b = 1;

        /* renamed from: c  reason: collision with root package name */
        public int f60776c = 16;

        /* renamed from: d  reason: collision with root package name */
        public int f60777d = 0;

        public boolean a() {
            int i = this.f60777d;
            return i == 5 || i == 6 || i == 8 || i == 9;
        }

        public boolean b() {
            int i = this.f60777d;
            return i == 3 || i == 4 || i == 8 || i == 9;
        }

        public boolean c() {
            int i = this.f60777d;
            return i == 1 || i == 4 || i == 6 || i == 9;
        }
    }

    public static byte[] a(byte b2, byte b3, byte b4, byte b5, boolean z) {
        return e((short) ((f(b2, b3, z) / 2) + (f(b4, b5, z) / 2)), z);
    }

    public static byte[] b(int i, int i2, byte[] bArr) {
        BdLog.e("convertChannelCount sourceByteWidth = " + i + " outputByteWidth = " + i2);
        if (i == i2) {
            return bArr;
        }
        int length = bArr.length;
        if (i != 1) {
            if (i == 2 && i2 == 1) {
                int i3 = length / 2;
                byte[] bArr2 = new byte[i3];
                for (int i4 = 0; i4 < i3; i4++) {
                    int i5 = i4 * 2;
                    bArr2[i4] = (byte) (f(bArr[i5], bArr[i5 + 1], f60773a) / 256);
                }
                return bArr2;
            }
        } else if (i2 == 2) {
            byte[] bArr3 = new byte[length * 2];
            for (int i6 = 0; i6 < length; i6++) {
                byte[] e2 = e((short) (bArr[i6] * 256), f60773a);
                int i7 = i6 * 2;
                bArr3[i7] = e2[0];
                bArr3[i7 + 1] = e2[1];
            }
            return bArr3;
        }
        return bArr;
    }

    public static byte[] c(int i, int i2, int i3, byte[] bArr) {
        BdLog.e("convertChannelCount sourceChannelCount = " + i + " outputChannelCount = " + i2);
        if (i == i2) {
            return bArr;
        }
        if (i3 == 1 || i3 == 2) {
            int length = bArr.length;
            int i4 = 0;
            if (i != 1) {
                if (i == 2 && i2 == 1) {
                    int i5 = length / 2;
                    byte[] bArr2 = new byte[i5];
                    if (i3 == 1) {
                        while (i4 < i5) {
                            int i6 = i4 * 2;
                            bArr2[i4] = (byte) (((short) (bArr[i6] + bArr[i6 + 1])) >> 1);
                            i4 += 2;
                        }
                    } else if (i3 == 2) {
                        for (int i7 = 0; i7 < i5; i7 += 2) {
                            int i8 = i7 * 2;
                            byte[] a2 = a(bArr[i8], bArr[i8 + 1], bArr[i8 + 2], bArr[i8 + 3], f60773a);
                            bArr2[i7] = a2[0];
                            bArr2[i7 + 1] = a2[1];
                        }
                    }
                    return bArr2;
                }
            } else if (i2 == 2) {
                byte[] bArr3 = new byte[length * 2];
                if (i3 == 1) {
                    while (i4 < length) {
                        byte b2 = bArr[i4];
                        int i9 = i4 * 2;
                        bArr3[i9] = b2;
                        bArr3[i9 + 1] = b2;
                        i4++;
                    }
                } else if (i3 == 2) {
                    while (i4 < length) {
                        byte b3 = bArr[i4];
                        byte b4 = bArr[i4 + 1];
                        int i10 = i4 * 2;
                        bArr3[i10] = b3;
                        bArr3[i10 + 1] = b4;
                        bArr3[i10 + 2] = b3;
                        bArr3[i10 + 3] = b4;
                        i4 += 2;
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
            int i = 0;
            while (true) {
                if (i >= mediaExtractor.getTrackCount()) {
                    mediaFormat = null;
                    break;
                }
                mediaFormat = mediaExtractor.getTrackFormat(i);
                if (mediaFormat.getString(IMediaFormat.KEY_MIME).startsWith("audio/")) {
                    mediaExtractor.selectTrack(i);
                    break;
                }
                i++;
            }
            if (mediaFormat == null) {
                mediaExtractor.release();
                return null;
            }
            a aVar = new a();
            aVar.f60774a = mediaFormat.containsKey("sample-rate") ? mediaFormat.getInteger("sample-rate") : 48000;
            aVar.f60775b = mediaFormat.containsKey("channel-count") ? mediaFormat.getInteger("channel-count") : 1;
            aVar.f60776c = mediaFormat.containsKey("bit-width") ? mediaFormat.getInteger("bit-width") : 16;
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
        int i;
        if (z) {
            i = ((short) (((short) ((b2 & 255) | 0)) << 8)) | (b3 & 255);
        } else {
            i = (b2 & 255) | ((short) (((short) ((b3 & 255) | 0)) << 8));
        }
        return (short) i;
    }

    public static void g() {
        if (ByteOrder.nativeOrder() == ByteOrder.BIG_ENDIAN) {
            f60773a = true;
        } else {
            f60773a = false;
        }
    }

    public static boolean h(a... aVarArr) {
        a aVar;
        if (aVarArr == null || aVarArr.length < 2 || (aVar = aVarArr[0]) == null) {
            return false;
        }
        boolean z = true;
        for (int i = 1; i < aVarArr.length; i++) {
            if (aVar.f60774a != aVarArr[i].f60774a) {
                aVarArr[i].f60777d++;
                z = false;
            }
            if (aVar.f60775b != aVarArr[i].f60775b) {
                aVarArr[i].f60777d += 3;
                z = false;
            }
            if (aVar.f60776c != aVarArr[i].f60776c) {
                aVarArr[i].f60777d += 5;
                z = false;
            }
        }
        return z;
    }

    public static boolean i(String str, String str2, int i, int i2) {
        BdLog.e("resampling sampleRate = " + i + " resampleRate = " + i2);
        if (i2 == i) {
            return false;
        }
        File file = new File(str);
        File file2 = new File(str2);
        try {
            FileInputStream fileInputStream = new FileInputStream(file);
            FileOutputStream fileOutputStream = new FileOutputStream(file2);
            new j(fileInputStream, fileOutputStream, i, i2, 2, 2, 1, Integer.MAX_VALUE, 0.0d, 0, true);
            fileInputStream.close();
            fileOutputStream.close();
            return true;
        } catch (Exception e2) {
            e2.printStackTrace();
            return false;
        }
    }
}
