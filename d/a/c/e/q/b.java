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
    public AudioTrack f39994f;

    /* renamed from: g  reason: collision with root package name */
    public String f39995g;

    /* renamed from: i  reason: collision with root package name */
    public Amrnb f39997i;
    public final Handler j;
    public int n;

    /* renamed from: e  reason: collision with root package name */
    public volatile int f39993e = 0;

    /* renamed from: h  reason: collision with root package name */
    public final short[] f39996h = {12, 13, 15, 17, 19, 20, 26, 31, 5, 0, 0, 0, 0, 0, 0, 0};
    public int k = 0;
    public final Handler l = new Handler();
    public final Runnable m = new a();
    public final Runnable o = new RunnableC0519b();

    /* loaded from: classes.dex */
    public class a implements Runnable {
        public a() {
        }

        @Override // java.lang.Runnable
        public void run() {
            if (b.this.f39994f == null) {
                return;
            }
            try {
                if (b.this.f39994f.getPlayState() != 3) {
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
    public class RunnableC0519b implements Runnable {
        public RunnableC0519b() {
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
            this.f39997i = amrnb;
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
        AudioTrack audioTrack = this.f39994f;
        if (audioTrack == null) {
            return 0;
        }
        try {
            int playbackHeadPosition = audioTrack.getPlaybackHeadPosition();
            if (this.f39994f == null) {
                return 0;
            }
            int sampleRate = this.f39994f.getSampleRate();
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
            this.f39994f = new AudioTrack(h.f40002b, 8000, 2, 2, Math.min(AudioTrack.getMinBufferSize(8000, 2, 2) * 8, 4096), 1);
        } catch (IllegalArgumentException e2) {
            this.f39994f = null;
            BdLog.e(e2.getMessage());
        }
        this.f39993e = 1;
    }

    public void i() {
        int i2;
        Handler handler = this.j;
        if (handler != null) {
            handler.removeCallbacks(this.o);
        }
        synchronized (p) {
            if (this.f39994f != null) {
                try {
                    i2 = this.f39994f.getPlaybackHeadPosition();
                    try {
                        this.f39994f.stop();
                        this.f39994f.release();
                    } catch (Exception unused) {
                    }
                } catch (Exception unused2) {
                    i2 = 0;
                }
                this.n = 0;
                this.f39994f = null;
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
        this.f39993e = 0;
    }

    public void j(String str) {
        this.f39995g = str;
    }

    public void k(int i2) {
        this.n = i2;
    }

    public void l() {
        this.f39993e = 3;
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
        if (this.f39997i == null) {
            Handler handler = this.j;
            if (handler != null) {
                handler.sendMessage(handler.obtainMessage(2));
                return;
            }
            return;
        }
        boolean z = true;
        if (this.f39995g == null) {
            Handler handler2 = this.j;
            if (handler2 != null) {
                handler2.sendMessage(handler2.obtainMessage(1));
                return;
            }
            return;
        }
        File file = new File(this.f39995g);
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
        AudioTrack audioTrack = this.f39994f;
        if (audioTrack != null && audioTrack.getState() != 0) {
            if (this.n > 0) {
                this.f39994f.reloadStaticData();
                this.f39994f.setPlaybackHeadPosition(this.n);
            }
            boolean z2 = false;
            try {
                this.f39994f.play();
                this.f39993e = 2;
                this.l.post(this.m);
                FileInputStream fileInputStream2 = new FileInputStream(file);
                try {
                    bool = Boolean.TRUE;
                    bArr = new byte[32];
                    this.f39997i.decoderInit();
                    sArr = new short[160];
                } catch (Exception unused) {
                }
                try {
                    while (this.f39993e == 2) {
                        if (bool.booleanValue()) {
                            if (fileInputStream2.read(bArr, 0, 6) != 6 || bArr[0] != 35 || bArr[1] != 33 || bArr[2] != 65 || bArr[3] != 77 || bArr[4] != 82 || bArr[5] != 10) {
                                break;
                            }
                            bool = Boolean.FALSE;
                        }
                        if (fileInputStream2.read(bArr, 0, 1) > 0) {
                            short s = this.f39996h[(bArr[0] >> 3) & 15];
                            if (fileInputStream2.read(bArr, 1, s) == s) {
                                synchronized (p) {
                                    if (this.f39994f != null && this.f39994f.getPlayState() == 3) {
                                        this.f39997i.decoderDecode(bArr, sArr);
                                        this.f39994f.write(sArr, 0, 160);
                                    }
                                }
                            }
                        }
                    }
                    fileInputStream2.close();
                    this.f39997i.decoderDeinit();
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
                    this.f39993e = 3;
                    if (!z) {
                    }
                }
                z = false;
            } catch (Exception unused3) {
            }
            this.f39993e = 3;
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
