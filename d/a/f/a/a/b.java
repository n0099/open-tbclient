package d.a.f.a.a;

import android.media.AudioRecord;
import android.os.Handler;
import android.os.Message;
import android.os.Process;
import com.baidu.adp.lib.util.BdLog;
import com.baidu.adp.lib.voice.Amrnb;
import com.baidu.audiorecorder.lib.voice.BdSoundGate;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
/* loaded from: classes.dex */
public class b implements Runnable {

    /* renamed from: f  reason: collision with root package name */
    public String f39926f;

    /* renamed from: g  reason: collision with root package name */
    public int f39927g;

    /* renamed from: h  reason: collision with root package name */
    public FileOutputStream f39928h;

    /* renamed from: i  reason: collision with root package name */
    public Amrnb f39929i;
    public final Handler j;
    public long k;
    public long l;

    /* renamed from: e  reason: collision with root package name */
    public volatile int f39925e = 0;
    public final Handler m = new Handler();
    public final Runnable n = new a();

    /* loaded from: classes.dex */
    public class a implements Runnable {
        public a() {
        }

        @Override // java.lang.Runnable
        public void run() {
            b.this.g((int) (System.currentTimeMillis() - b.this.k));
            b.this.m.postDelayed(b.this.n, 200L);
        }
    }

    public b(Handler handler) {
        this.j = handler;
        try {
            Amrnb amrnb = Amrnb.getInstance();
            this.f39929i = amrnb;
            if (amrnb == null || !Amrnb.bLoadLibrary) {
                this.f39929i = null;
                if (this.j != null) {
                    this.j.sendMessage(this.j.obtainMessage(5));
                }
            }
        } catch (Exception unused) {
            Handler handler2 = this.j;
            if (handler2 != null) {
                handler2.sendMessage(handler2.obtainMessage(5));
            }
        }
    }

    public void cancel() {
        this.f39925e = 5;
    }

    public final boolean e() {
        FileOutputStream fileOutputStream = this.f39928h;
        if (fileOutputStream != null) {
            try {
                fileOutputStream.close();
                return true;
            } catch (IOException e2) {
                BdLog.e(e2.getMessage());
                return false;
            }
        }
        return true;
    }

    public final void f(short[] sArr) {
        byte[] bArr = new byte[32];
        try {
            this.f39928h.write(bArr, 0, this.f39929i.encoderEncode(2, sArr, bArr));
        } catch (IOException unused) {
        }
    }

    public final void g(int i2) {
        Message obtainMessage = this.j.obtainMessage(9);
        obtainMessage.arg1 = i2;
        this.j.sendMessage(obtainMessage);
    }

    public final void h(List<short[]> list) {
        int a2 = BdSoundGate.b().a();
        short[] sArr = new short[a2];
        short[] sArr2 = new short[a2];
        int size = list.size();
        int i2 = 0;
        for (int i3 = 0; i3 < size; i3++) {
            System.arraycopy(list.get(i3), 0, sArr2, i2, 160);
            i2 += 160;
            if (i3 == size - 1) {
                BdSoundGate.b().f(sArr2, sArr);
                int i4 = 0;
                for (int i5 = 0; i5 < size; i5++) {
                    System.arraycopy(sArr, i4, list.get(i5), 0, 160);
                    i4 += 160;
                    f(list.get(i5));
                }
                i2 = 0;
            }
        }
    }

    public boolean i(String str, int i2) {
        if (this.f39929i == null) {
            return false;
        }
        this.f39925e = 0;
        this.f39926f = str;
        this.f39927g = i2;
        return true;
    }

    public void j() {
        this.f39925e = 4;
    }

    @Override // java.lang.Runnable
    public void run() {
        AudioRecord audioRecord;
        Handler handler;
        Process.setThreadPriority(-19);
        if (this.f39929i == null) {
            Handler handler2 = this.j;
            if (handler2 != null) {
                handler2.sendMessage(handler2.obtainMessage(5));
            }
        } else if (this.f39925e == 4) {
            Handler handler3 = this.j;
            if (handler3 != null) {
                handler3.sendMessage(handler3.obtainMessage(8));
            }
            this.f39925e = 0;
        } else {
            String str = this.f39926f;
            AudioRecord audioRecord2 = null;
            boolean z = true;
            if (str != null && str.length() > 0) {
                try {
                    File h2 = d.a.c.e.p.f.h(null, this.f39926f);
                    if (h2 != null) {
                        this.f39928h = new FileOutputStream(h2);
                    } else if (this.j != null) {
                        this.j.sendMessage(this.j.obtainMessage(1));
                        return;
                    } else {
                        return;
                    }
                } catch (Exception e2) {
                    BdLog.e(e2.getMessage());
                    e();
                    Handler handler4 = this.j;
                    if (handler4 != null) {
                        handler4.sendMessage(handler4.obtainMessage(1));
                    }
                    this.f39925e = 0;
                    return;
                }
            }
            if (this.f39925e == 4) {
                Handler handler5 = this.j;
                if (handler5 != null) {
                    handler5.sendMessage(handler5.obtainMessage(8));
                }
                e();
                this.f39925e = 0;
                return;
            }
            try {
                audioRecord = c.b().a();
            } catch (IllegalArgumentException unused) {
                Handler handler6 = this.j;
                if (handler6 != null) {
                    handler6.sendMessage(handler6.obtainMessage(6));
                }
                e();
                this.f39925e = 0;
                return;
            } catch (Exception unused2) {
                audioRecord = null;
            }
            if (audioRecord != null && audioRecord.getState() != 0) {
                if (this.f39925e == 4) {
                    try {
                        audioRecord.release();
                    } catch (Exception unused3) {
                    }
                    Handler handler7 = this.j;
                    if (handler7 != null) {
                        handler7.sendMessage(handler7.obtainMessage(8));
                    }
                    e();
                    this.f39925e = 0;
                    return;
                }
                audioRecord.startRecording();
                if (this.f39925e == 4) {
                    try {
                        audioRecord.stop();
                        audioRecord.release();
                    } catch (Exception unused4) {
                    }
                    Handler handler8 = this.j;
                    if (handler8 != null) {
                        handler8.sendMessage(handler8.obtainMessage(8));
                    }
                    e();
                    this.f39925e = 0;
                    return;
                }
                this.f39925e = 3;
                try {
                    if (this.f39928h == null) {
                        try {
                            audioRecord.stop();
                            audioRecord.release();
                        } catch (Exception unused5) {
                            audioRecord2 = audioRecord;
                        }
                        try {
                            if (this.j != null) {
                                this.j.sendMessage(this.j.obtainMessage(1));
                            }
                            this.f39925e = 0;
                            return;
                        } catch (IOException unused6) {
                            audioRecord = audioRecord2;
                            try {
                                audioRecord.stop();
                                audioRecord.release();
                            } catch (Exception unused7) {
                            }
                            Handler handler9 = this.j;
                            if (handler9 != null) {
                                handler9.sendMessage(handler9.obtainMessage(3));
                            }
                            this.f39925e = 0;
                            return;
                        }
                    }
                    d.a.c.e.p.f.E(this.f39928h);
                    this.f39929i.encoderInit();
                    if (this.f39927g > 0) {
                        BdSoundGate.b().d(1600, this.f39927g);
                    }
                    ArrayList arrayList = new ArrayList();
                    this.k = System.currentTimeMillis();
                    this.m.post(this.n);
                    short[] sArr = null;
                    short s = 0;
                    while (true) {
                        if (this.f39925e != 3) {
                            z = false;
                            break;
                        }
                        if (sArr == null) {
                            sArr = new short[160];
                            s = 0;
                        }
                        int read = audioRecord.read(sArr, s, 160 - s);
                        if (read > 0) {
                            int i2 = 0;
                            for (int i3 = 0; i3 < sArr.length; i3++) {
                                i2 += sArr[i3] * sArr[i3];
                            }
                            Handler handler10 = this.j;
                            if (handler10 != null) {
                                Message obtainMessage = handler10.obtainMessage(4);
                                int abs = Math.abs((((int) (i2 / read)) / 100000) >> 1);
                                while (abs > 100) {
                                    abs = (int) (abs / 10.0d);
                                }
                                obtainMessage.arg1 = abs;
                                this.j.sendMessage(obtainMessage);
                            }
                        }
                        s = (short) (s + read);
                        if (s == 160) {
                            if (this.f39927g > 0) {
                                int size = arrayList.size() + 1;
                                if (size > 1 && size % 10 == 0) {
                                    h(arrayList);
                                    arrayList.clear();
                                }
                                arrayList.add(sArr);
                            } else {
                                f(sArr);
                            }
                            sArr = null;
                        }
                        ArrayList arrayList2 = arrayList;
                        if (System.currentTimeMillis() - this.k > d.a.c.e.q.d.f39245a) {
                            break;
                        }
                        arrayList = arrayList2;
                    }
                    System.currentTimeMillis();
                    if (sArr != null) {
                        while (s < 160) {
                            try {
                                if (s >= sArr.length || s < 0) {
                                    break;
                                }
                                sArr[s] = 0;
                                s = (short) (s + 1);
                            } catch (Exception unused8) {
                            }
                        }
                        f(sArr);
                    }
                    if (this.f39927g > 0) {
                        BdSoundGate.b().e();
                    }
                    System.currentTimeMillis();
                    audioRecord.stop();
                    audioRecord.release();
                    System.currentTimeMillis();
                    if (this.f39925e == 5) {
                        if (!e()) {
                            Handler handler11 = this.j;
                            if (handler11 != null) {
                                handler11.sendMessage(handler11.obtainMessage(2));
                            }
                        } else {
                            try {
                                d.a.c.e.p.f.k(this.f39926f);
                                if (this.j != null) {
                                    this.j.sendMessage(this.j.obtainMessage(100));
                                }
                            } catch (Exception unused9) {
                                Handler handler12 = this.j;
                                if (handler12 != null) {
                                    handler12.sendMessage(handler12.obtainMessage(101));
                                }
                                this.f39925e = 0;
                            }
                        }
                        this.f39925e = 0;
                        return;
                    }
                    this.f39925e = 4;
                    long currentTimeMillis = System.currentTimeMillis() - this.k;
                    this.l = currentTimeMillis;
                    g((int) currentTimeMillis);
                    Handler handler13 = this.m;
                    if (handler13 != null) {
                        handler13.removeCallbacks(this.n);
                    }
                    System.currentTimeMillis();
                    if (!e() && (handler = this.j) != null) {
                        handler.sendMessage(handler.obtainMessage(2));
                    }
                    this.f39929i.encoderDeinit();
                    this.f39925e = 0;
                    Handler handler14 = this.j;
                    if (handler14 != null) {
                        if (z) {
                            handler14.sendMessage(handler14.obtainMessage(7));
                            return;
                        }
                        Message obtainMessage2 = handler14.obtainMessage(0);
                        obtainMessage2.arg1 = (int) this.l;
                        this.j.sendMessage(obtainMessage2);
                    }
                } catch (IOException unused10) {
                }
            } else {
                if (audioRecord != null) {
                    try {
                        audioRecord.release();
                    } catch (Exception unused11) {
                    }
                }
                Handler handler15 = this.j;
                if (handler15 != null) {
                    handler15.sendMessage(handler15.obtainMessage(6));
                }
                e();
                this.f39925e = 0;
            }
        }
    }
}
