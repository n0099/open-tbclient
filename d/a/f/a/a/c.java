package d.a.f.a.a;

import android.media.AudioRecord;
import com.baidu.swan.nalib.audio.SwanAudioPlayer;
/* loaded from: classes.dex */
public class c {

    /* renamed from: e  reason: collision with root package name */
    public static c f39735e;

    /* renamed from: f  reason: collision with root package name */
    public static int[] f39736f = {8000, 11025, 16000, 22050, 32000, SwanAudioPlayer.DEFAULT_SAMPLE_RATE, 47250, 48000};

    /* renamed from: g  reason: collision with root package name */
    public static short[] f39737g = {2, 3};

    /* renamed from: h  reason: collision with root package name */
    public static short[] f39738h = {2, 16, 12, 3};

    /* renamed from: a  reason: collision with root package name */
    public int f39739a;

    /* renamed from: b  reason: collision with root package name */
    public short f39740b;

    /* renamed from: c  reason: collision with root package name */
    public short f39741c;

    /* renamed from: d  reason: collision with root package name */
    public int f39742d = -2;

    public static c b() {
        c cVar;
        c cVar2 = f39735e;
        if (cVar2 == null) {
            synchronized (c.class) {
                if (f39735e == null) {
                    f39735e = new c();
                }
                cVar = f39735e;
            }
            return cVar;
        }
        return cVar2;
    }

    /* JADX WARN: Removed duplicated region for block: B:119:0x0118 A[SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:75:0x010d  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public AudioRecord a() throws IllegalArgumentException {
        int[] iArr;
        int i2;
        int i3;
        short[] sArr;
        short s;
        int i4;
        int i5;
        int minBufferSize;
        AudioRecord audioRecord;
        if (this.f39739a > 0 && this.f39740b > 0 && this.f39741c > 0) {
            return new AudioRecord(1, this.f39739a, this.f39741c, this.f39740b, this.f39742d);
        }
        int[] iArr2 = f39736f;
        int length = iArr2.length;
        AudioRecord audioRecord2 = null;
        for (int i6 = 0; i6 < length; i6++) {
            int i7 = iArr2[i6];
            short[] sArr2 = f39737g;
            int length2 = sArr2.length;
            int i8 = 0;
            while (i8 < length2) {
                short s2 = sArr2[i8];
                short[] sArr3 = f39738h;
                int length3 = sArr3.length;
                AudioRecord audioRecord3 = audioRecord2;
                int i9 = 0;
                while (i9 < length3) {
                    short s3 = sArr3[i9];
                    try {
                        minBufferSize = AudioRecord.getMinBufferSize(i7, s3, s2);
                        this.f39742d = minBufferSize;
                    } catch (Throwable th) {
                        th = th;
                        iArr = iArr2;
                        i2 = i9;
                        i3 = length3;
                        sArr = sArr3;
                        s = s2;
                        i4 = i8;
                        i5 = 1;
                    }
                    if (minBufferSize == -2) {
                        if (audioRecord3 == null || audioRecord3.getState() == 1) {
                            iArr = iArr2;
                            i2 = i9;
                            i3 = length3;
                            sArr = sArr3;
                            s = s2;
                            i4 = i8;
                        } else {
                            audioRecord3.release();
                            iArr = iArr2;
                            i2 = i9;
                            i3 = length3;
                            sArr = sArr3;
                            s = s2;
                            i4 = i8;
                            audioRecord3 = null;
                        }
                    } else {
                        int min = Math.min(minBufferSize * 8, 4096);
                        iArr = iArr2;
                        i5 = 1;
                        i2 = i9;
                        i3 = length3;
                        sArr = sArr3;
                        short s4 = s2;
                        i4 = i8;
                        try {
                            audioRecord = new AudioRecord(1, i7, s3, s2, min);
                            try {
                            } catch (Throwable th2) {
                                th = th2;
                                s = s4;
                            }
                        } catch (Throwable th3) {
                            th = th3;
                        }
                        try {
                            if (audioRecord.getState() == 1) {
                                try {
                                    this.f39739a = i7;
                                    try {
                                        this.f39740b = s4;
                                        this.f39741c = s3;
                                        this.f39742d = min;
                                        if (audioRecord.getState() != 1) {
                                            audioRecord.release();
                                        }
                                        return audioRecord;
                                    } catch (Throwable th4) {
                                        th = th4;
                                        audioRecord3 = audioRecord;
                                        s = s4;
                                    }
                                } catch (Throwable th5) {
                                    th = th5;
                                    audioRecord3 = audioRecord;
                                    s = s4;
                                    th.printStackTrace();
                                    if (audioRecord3 != null) {
                                    }
                                    i9 = i2 + 1;
                                    s2 = s;
                                    length3 = i3;
                                    iArr2 = iArr;
                                    sArr3 = sArr;
                                    i8 = i4;
                                }
                            } else {
                                try {
                                    audioRecord.release();
                                    try {
                                        audioRecord3 = new AudioRecord(1, i7, s3, s4, this.f39742d);
                                        try {
                                        } catch (Throwable th6) {
                                            th = th6;
                                            s = s4;
                                        }
                                    } catch (Throwable th7) {
                                        th = th7;
                                        s = s4;
                                        audioRecord3 = audioRecord;
                                        th.printStackTrace();
                                        if (audioRecord3 != null) {
                                        }
                                        i9 = i2 + 1;
                                        s2 = s;
                                        length3 = i3;
                                        iArr2 = iArr;
                                        sArr3 = sArr;
                                        i8 = i4;
                                    }
                                } catch (Throwable th8) {
                                    th = th8;
                                    s = s4;
                                }
                                if (audioRecord3.getState() == 1) {
                                    this.f39739a = i7;
                                    s = s4;
                                    try {
                                        this.f39740b = s;
                                        this.f39741c = s3;
                                        if (audioRecord3.getState() != 1) {
                                            audioRecord3.release();
                                        }
                                        return audioRecord3;
                                    } catch (Throwable th9) {
                                        th = th9;
                                    }
                                } else {
                                    s = s4;
                                    if (audioRecord3.getState() == 1) {
                                    }
                                    audioRecord3.release();
                                    audioRecord3 = null;
                                }
                            }
                            th.printStackTrace();
                            if (audioRecord3 != null) {
                                if (audioRecord3.getState() == i5) {
                                }
                                audioRecord3.release();
                                audioRecord3 = null;
                            }
                        } catch (Throwable th10) {
                            if (audioRecord3 != null && audioRecord3.getState() != i5) {
                                audioRecord3.release();
                            }
                            throw th10;
                        }
                    }
                    i9 = i2 + 1;
                    s2 = s;
                    length3 = i3;
                    iArr2 = iArr;
                    sArr3 = sArr;
                    i8 = i4;
                }
                i8++;
                audioRecord2 = audioRecord3;
            }
        }
        throw new IllegalArgumentException("getInstance() failed : no suitable audio configurations on this device.");
    }
}
