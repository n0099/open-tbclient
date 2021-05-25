package d.a.c.e.q;

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
    public AudioTrack f38903f;

    /* renamed from: g  reason: collision with root package name */
    public String f38904g;

    /* renamed from: i  reason: collision with root package name */
    public Amrnb f38906i;
    public final Handler j;
    public int n;

    /* renamed from: e  reason: collision with root package name */
    public volatile int f38902e = 0;

    /* renamed from: h  reason: collision with root package name */
    public final short[] f38905h = {12, 13, 15, 17, 19, 20, 26, 31, 5, 0, 0, 0, 0, 0, 0, 0};
    public int k = 0;
    public final Handler l = new Handler();
    public final Runnable m = new a();
    public final Runnable o = new RunnableC0490b();

    /* loaded from: classes.dex */
    public class a implements Runnable {
        public a() {
        }

        @Override // java.lang.Runnable
        public void run() {
            if (b.this.f38903f == null) {
                return;
            }
            try {
                if (b.this.f38903f.getPlayState() != 3) {
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

    /* renamed from: d.a.c.e.q.b$b  reason: collision with other inner class name */
    /* loaded from: classes.dex */
    public class RunnableC0490b implements Runnable {
        public RunnableC0490b() {
        }

        @Override // java.lang.Runnable
        public void run() {
            b.this.i();
        }
    }

    public b(Handler handler, int i2) {
        this.n = 0;
        this.n = i2;
        this.j = handler;
        try {
            Amrnb amrnb = new Amrnb();
            this.f38906i = amrnb;
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
        AudioTrack audioTrack = this.f38903f;
        if (audioTrack == null) {
            return 0;
        }
        try {
            int playbackHeadPosition = audioTrack.getPlaybackHeadPosition();
            if (this.f38903f == null) {
                return 0;
            }
            int sampleRate = this.f38903f.getSampleRate();
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
            this.f38903f = new AudioTrack(h.f38911b, 8000, 2, 2, Math.min(AudioTrack.getMinBufferSize(8000, 2, 2) * 8, 4096), 1);
        } catch (IllegalArgumentException e2) {
            this.f38903f = null;
            BdLog.e(e2.getMessage());
        }
        this.f38902e = 1;
    }

    public void i() {
        int i2;
        Handler handler = this.j;
        if (handler != null) {
            handler.removeCallbacks(this.o);
        }
        synchronized (p) {
            if (this.f38903f != null) {
                try {
                    i2 = this.f38903f.getPlaybackHeadPosition();
                    try {
                        this.f38903f.stop();
                        this.f38903f.release();
                    } catch (Exception unused) {
                    }
                } catch (Exception unused2) {
                    i2 = 0;
                }
                this.n = 0;
                this.f38903f = null;
            } else {
                i2 = 0;
            }
            if (this.l != null) {
                this.l.removeCallbacks(this.m);
            }
            if (this.j != null) {
                Message obtainMessage = this.j.obtainMessage(0);
                obtainMessage.arg1 = i2;
                this.j.sendMessage(obtainMessage);
            }
        }
        this.f38902e = 0;
    }

    public void j(String str) {
        this.f38904g = str;
    }

    public void k(int i2) {
        this.n = i2;
    }

    public void l() {
        this.f38902e = 3;
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
        if (this.f38906i == null) {
            Handler handler = this.j;
            if (handler != null) {
                handler.sendMessage(handler.obtainMessage(2));
                return;
            }
            return;
        }
        boolean z = true;
        if (this.f38904g == null) {
            Handler handler2 = this.j;
            if (handler2 != null) {
                handler2.sendMessage(handler2.obtainMessage(1));
                return;
            }
            return;
        }
        File file = new File(this.f38904g);
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
        AudioTrack audioTrack = this.f38903f;
        if (audioTrack != null && audioTrack.getState() != 0) {
            if (this.n > 0) {
                this.f38903f.reloadStaticData();
                this.f38903f.setPlaybackHeadPosition(this.n);
            }
            boolean z2 = false;
            try {
                this.f38903f.play();
                this.f38902e = 2;
                this.l.post(this.m);
                FileInputStream fileInputStream2 = new FileInputStream(file);
                try {
                    bool = Boolean.TRUE;
                    bArr = new byte[32];
                    this.f38906i.decoderInit();
                    sArr = new short[160];
                } catch (Exception unused) {
                }
                try {
                    while (this.f38902e == 2) {
                        if (bool.booleanValue()) {
                            if (fileInputStream2.read(bArr, 0, 6) != 6 || bArr[0] != 35 || bArr[1] != 33 || bArr[2] != 65 || bArr[3] != 77 || bArr[4] != 82 || bArr[5] != 10) {
                                break;
                            }
                            bool = Boolean.FALSE;
                        }
                        if (fileInputStream2.read(bArr, 0, 1) > 0) {
                            short s = this.f38905h[(bArr[0] >> 3) & 15];
                            if (fileInputStream2.read(bArr, 1, s) == s) {
                                synchronized (p) {
                                    if (this.f38903f != null && this.f38903f.getPlayState() == 3) {
                                        this.f38906i.decoderDecode(bArr, sArr);
                                        this.f38903f.write(sArr, 0, 160);
                                    }
                                }
                            }
                        }
                    }
                    fileInputStream2.close();
                    this.f38906i.decoderDeinit();
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
                    this.f38902e = 3;
                    if (!z) {
                    }
                }
                z = false;
            } catch (Exception unused3) {
            }
            this.f38902e = 3;
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
