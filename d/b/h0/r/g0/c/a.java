package d.b.h0.r.g0.c;

import android.media.AudioRecord;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.RandomAccessFile;
/* loaded from: classes3.dex */
public class a implements d {
    public static int l = 8000;
    public static int m = 2;
    public static int n = 2;
    public static int o = 1;

    /* renamed from: d  reason: collision with root package name */
    public RandomAccessFile f51001d;

    /* renamed from: f  reason: collision with root package name */
    public int f51003f;

    /* renamed from: g  reason: collision with root package name */
    public int f51004g;

    /* renamed from: h  reason: collision with root package name */
    public int f51005h;
    public int i;
    public short j;
    public short k;

    /* renamed from: a  reason: collision with root package name */
    public int f50998a = 0;

    /* renamed from: b  reason: collision with root package name */
    public boolean f50999b = false;

    /* renamed from: c  reason: collision with root package name */
    public AudioRecord f51000c = null;

    /* renamed from: e  reason: collision with root package name */
    public File f51002e = null;

    /* renamed from: d.b.h0.r.g0.c.a$a  reason: collision with other inner class name */
    /* loaded from: classes3.dex */
    public class RunnableC1093a implements Runnable {
        public RunnableC1093a() {
        }

        @Override // java.lang.Runnable
        public void run() {
            a.this.h();
        }
    }

    @Override // d.b.h0.r.g0.c.d
    public void a() {
        this.f50999b = false;
    }

    @Override // d.b.h0.r.g0.c.d
    public boolean b(String str) {
        return g(o, l, m, n, str);
    }

    @Override // d.b.h0.r.g0.c.d
    public boolean c() {
        Thread thread = new Thread(new RunnableC1093a());
        thread.setPriority(10);
        thread.setDaemon(true);
        thread.start();
        return true;
    }

    @Override // d.b.h0.r.g0.c.d
    public boolean d() {
        return this.f50999b;
    }

    public void f(String str) {
    }

    public boolean g(int i, int i2, int i3, int i4, String str) {
        this.f50998a = AudioRecord.getMinBufferSize(i2, i3, i4) + 2048;
        this.f51004g = i2;
        this.f51005h = i3;
        this.i = i4;
        AudioRecord audioRecord = this.f51000c;
        if (audioRecord != null) {
            audioRecord.release();
        }
        this.f51000c = new AudioRecord(i, this.f51004g, this.f51005h, this.i, this.f50998a);
        this.j = (short) (this.f51005h == 12 ? 2 : 1);
        this.k = (short) (this.i == 2 ? 16 : 8);
        File file = new File(str);
        this.f51002e = file;
        if (file.exists()) {
            this.f51002e.delete();
        }
        try {
            this.f51002e.createNewFile();
            RandomAccessFile randomAccessFile = this.f51001d;
            if (randomAccessFile != null) {
                try {
                    randomAccessFile.close();
                } catch (IOException e2) {
                    e2.printStackTrace();
                    return false;
                }
            }
            try {
                this.f51001d = new RandomAccessFile(this.f51002e, "rw");
                i();
                f(this.f51002e.getParent());
                return true;
            } catch (FileNotFoundException e3) {
                e3.printStackTrace();
                return false;
            }
        } catch (IOException unused) {
            this.f51002e = null;
            return false;
        }
    }

    public final void h() {
        AudioRecord audioRecord = this.f51000c;
        if (audioRecord == null || this.f51002e == null) {
            return;
        }
        try {
            this.f50999b = true;
            int i = this.f50998a;
            byte[] bArr = new byte[i];
            audioRecord.startRecording();
            while (this.f50999b) {
                this.f51000c.read(bArr, 0, i);
                this.f51001d.write(bArr);
                this.f51003f += i;
            }
            this.f51001d.seek(4L);
            this.f51001d.writeInt(Integer.reverseBytes(this.f51003f + 36));
            this.f51001d.seek(40L);
            this.f51001d.writeInt(Integer.reverseBytes(this.f51003f));
            this.f51001d.close();
            this.f51000c.stop();
            this.f51000c.release();
            this.f50999b = false;
        } catch (Throwable unused) {
            if (this.f51002e.exists()) {
                this.f51002e.delete();
            }
        }
    }

    public final void i() {
        try {
            this.f51001d.setLength(0L);
            this.f51001d.writeBytes(com.baidu.wallet.base.audio.b.f23215e);
            this.f51001d.writeInt(0);
            this.f51001d.writeBytes(com.baidu.wallet.base.audio.b.f23216f);
            this.f51001d.writeBytes(com.baidu.wallet.base.audio.b.f23217g);
            this.f51001d.writeInt(Integer.reverseBytes(16));
            this.f51001d.writeShort(Short.reverseBytes((short) 1));
            this.f51001d.writeShort(Short.reverseBytes(this.j));
            this.f51001d.writeInt(Integer.reverseBytes(this.f51004g));
            this.f51001d.writeInt(Integer.reverseBytes(((this.f51004g * this.j) * this.k) / 8));
            this.f51001d.writeShort(Short.reverseBytes((short) ((this.j * this.k) / 8)));
            this.f51001d.writeShort(Short.reverseBytes(this.k));
            this.f51001d.writeBytes("data");
            this.f51001d.writeInt(0);
        } catch (IOException e2) {
            if (this.f51002e.exists()) {
                this.f51002e.delete();
            }
            e2.printStackTrace();
        }
    }
}
