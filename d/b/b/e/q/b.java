package d.b.b.e.q;

import android.media.AudioTrack;
import android.os.Handler;
import android.os.Message;
import android.os.Process;
import com.baidu.adp.lib.util.BdLog;
import com.baidu.adp.lib.voice.Amrnb;
import java.io.File;
import java.io.FileInputStream;
/* loaded from: classes.dex */
public class b implements Runnable {
    public static Object p = new Object();

    /* renamed from: f  reason: collision with root package name */
    public AudioTrack f42044f;

    /* renamed from: g  reason: collision with root package name */
    public String f42045g;
    public Amrnb i;
    public final Handler j;
    public int n;

    /* renamed from: e  reason: collision with root package name */
    public volatile int f42043e = 0;

    /* renamed from: h  reason: collision with root package name */
    public final short[] f42046h = {12, 13, 15, 17, 19, 20, 26, 31, 5, 0, 0, 0, 0, 0, 0, 0};
    public int k = 0;
    public final Handler l = new Handler();
    public final Runnable m = new a();
    public final Runnable o = new RunnableC0542b();

    /* loaded from: classes.dex */
    public class a implements Runnable {
        public a() {
        }

        @Override // java.lang.Runnable
        public void run() {
            if (b.this.f42044f == null) {
                return;
            }
            try {
                if (b.this.f42044f.getPlayState() != 3) {
                    return;
                }
            } catch (NullPointerException unused) {
            }
            int g2 = b.this.g() + 0;
            if (g2 != b.this.k) {
                b.this.k = g2;
                Message obtainMessage = b.this.j.obtainMessage(6);
                obtainMessage.arg1 = b.this.k;
                b.this.j.sendMessage(obtainMessage);
            }
            b.this.l.postDelayed(b.this.m, 100L);
        }
    }

    /* renamed from: d.b.b.e.q.b$b  reason: collision with other inner class name */
    /* loaded from: classes.dex */
    public class RunnableC0542b implements Runnable {
        public RunnableC0542b() {
        }

        @Override // java.lang.Runnable
        public void run() {
            b.this.i();
        }
    }

    public b(Handler handler, int i) {
        this.n = 0;
        this.n = i;
        this.j = handler;
        try {
            Amrnb amrnb = new Amrnb();
            this.i = amrnb;
            if (amrnb != null || this.j == null) {
                return;
            }
            this.j.sendMessage(this.j.obtainMessage(2));
        } catch (Exception unused) {
            Handler handler2 = this.j;
            if (handler2 != null) {
                handler2.sendMessage(handler2.obtainMessage(2));
            }
        }
    }

    public int g() {
        AudioTrack audioTrack = this.f42044f;
        if (audioTrack == null) {
            return 0;
        }
        try {
            int playbackHeadPosition = audioTrack.getPlaybackHeadPosition();
            if (this.f42044f == null) {
                return 0;
            }
            int sampleRate = this.f42044f.getSampleRate();
            if (sampleRate == 0) {
                return 0;
            }
            return (int) (((playbackHeadPosition * 1.0f) / (sampleRate * 1.0f)) * 1000.0f);
        } catch (Throwable unused) {
            return 0;
        }
    }

    public final void h() {
        try {
            this.f42044f = new AudioTrack(h.f42051b, 8000, 2, 2, Math.min(AudioTrack.getMinBufferSize(8000, 2, 2) * 8, 4096), 1);
        } catch (IllegalArgumentException e2) {
            this.f42044f = null;
            BdLog.e(e2.getMessage());
        }
        this.f42043e = 1;
    }

    public void i() {
        int i;
        Handler handler = this.j;
        if (handler != null) {
            handler.removeCallbacks(this.o);
        }
        synchronized (p) {
            if (this.f42044f != null) {
                try {
                    i = this.f42044f.getPlaybackHeadPosition();
                    try {
                        this.f42044f.stop();
                        this.f42044f.release();
                    } catch (Exception unused) {
                    }
                } catch (Exception unused2) {
                    i = 0;
                }
                this.n = 0;
                this.f42044f = null;
            } else {
                i = 0;
            }
            if (this.l != null) {
                this.l.removeCallbacks(this.m);
            }
            if (this.j != null) {
                Message obtainMessage = this.j.obtainMessage(0);
                obtainMessage.arg1 = i;
                this.j.sendMessage(obtainMessage);
            }
        }
        this.f42043e = 0;
    }

    public void j(String str) {
        this.f42045g = str;
    }

    public void k(int i) {
        this.n = i;
    }

    public void l() {
        this.f42043e = 3;
        i();
    }

    /* JADX WARN: Removed duplicated region for block: B:85:0x011e  */
    /* JADX WARN: Removed duplicated region for block: B:86:0x0128  */
    @Override // java.lang.Runnable
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public void run() {
        Boolean bool;
        byte[] bArr;
        short[] sArr;
        Process.setThreadPriority(-19);
        if (this.i == null) {
            Handler handler = this.j;
            if (handler != null) {
                handler.sendMessage(handler.obtainMessage(2));
                return;
            }
            return;
        }
        boolean z = true;
        if (this.f42045g == null) {
            Handler handler2 = this.j;
            if (handler2 != null) {
                handler2.sendMessage(handler2.obtainMessage(1));
                return;
            }
            return;
        }
        File file = new File(this.f42045g);
        if (!file.exists()) {
            Handler handler3 = this.j;
            if (handler3 != null) {
                handler3.sendMessage(handler3.obtainMessage(1));
                return;
            }
            return;
        }
        FileInputStream fileInputStream = null;
        h();
        AudioTrack audioTrack = this.f42044f;
        if (audioTrack != null && audioTrack.getState() != 0) {
            if (this.n > 0) {
                this.f42044f.reloadStaticData();
                this.f42044f.setPlaybackHeadPosition(this.n);
            }
            boolean z2 = false;
            try {
                this.f42044f.play();
                this.f42043e = 2;
                this.l.post(this.m);
                FileInputStream fileInputStream2 = new FileInputStream(file);
                try {
                    bool = Boolean.TRUE;
                    bArr = new byte[32];
                    this.i.decoderInit();
                    sArr = new short[160];
                } catch (Exception unused) {
                }
                try {
                    while (this.f42043e == 2) {
                        if (bool.booleanValue()) {
                            if (fileInputStream2.read(bArr, 0, 6) != 6 || bArr[0] != 35 || bArr[1] != 33 || bArr[2] != 65 || bArr[3] != 77 || bArr[4] != 82 || bArr[5] != 10) {
                                break;
                            }
                            bool = Boolean.FALSE;
                        }
                        if (fileInputStream2.read(bArr, 0, 1) > 0) {
                            short s = this.f42046h[(bArr[0] >> 3) & 15];
                            if (fileInputStream2.read(bArr, 1, s) == s) {
                                synchronized (p) {
                                    if (this.f42044f != null && this.f42044f.getPlayState() == 3) {
                                        this.i.decoderDecode(bArr, sArr);
                                        this.f42044f.write(sArr, 0, 160);
                                    }
                                }
                            }
                        }
                    }
                    fileInputStream2.close();
                    this.i.decoderDeinit();
                } catch (Exception unused2) {
                    z2 = z;
                    fileInputStream = fileInputStream2;
                    Handler handler4 = this.j;
                    if (handler4 != null) {
                        handler4.sendMessage(handler4.obtainMessage(5));
                    }
                    if (fileInputStream != null) {
                        try {
                            fileInputStream.close();
                        } catch (Exception e2) {
                            BdLog.e(e2.getMessage());
                        }
                    }
                    z = z2;
                    this.f42043e = 3;
                    if (!z) {
                    }
                }
                z = false;
            } catch (Exception unused3) {
            }
            this.f42043e = 3;
            if (!z) {
                this.j.postDelayed(this.o, 500L);
                return;
            } else {
                i();
                return;
            }
        }
        Handler handler5 = this.j;
        if (handler5 != null) {
            handler5.sendMessage(handler5.obtainMessage(3));
        }
    }
}
