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
    public RandomAccessFile f50593d;

    /* renamed from: f  reason: collision with root package name */
    public int f50595f;

    /* renamed from: g  reason: collision with root package name */
    public int f50596g;

    /* renamed from: h  reason: collision with root package name */
    public int f50597h;
    public int i;
    public short j;
    public short k;

    /* renamed from: a  reason: collision with root package name */
    public int f50590a = 0;

    /* renamed from: b  reason: collision with root package name */
    public boolean f50591b = false;

    /* renamed from: c  reason: collision with root package name */
    public AudioRecord f50592c = null;

    /* renamed from: e  reason: collision with root package name */
    public File f50594e = null;

    /* renamed from: d.b.h0.r.g0.c.a$a  reason: collision with other inner class name */
    /* loaded from: classes3.dex */
    public class RunnableC1079a implements Runnable {
        public RunnableC1079a() {
        }

        @Override // java.lang.Runnable
        public void run() {
            a.this.h();
        }
    }

    @Override // d.b.h0.r.g0.c.d
    public void a() {
        this.f50591b = false;
    }

    @Override // d.b.h0.r.g0.c.d
    public boolean b(String str) {
        return g(o, l, m, n, str);
    }

    @Override // d.b.h0.r.g0.c.d
    public boolean c() {
        Thread thread = new Thread(new RunnableC1079a());
        thread.setPriority(10);
        thread.setDaemon(true);
        thread.start();
        return true;
    }

    @Override // d.b.h0.r.g0.c.d
    public boolean d() {
        return this.f50591b;
    }

    public void f(String str) {
    }

    public boolean g(int i, int i2, int i3, int i4, String str) {
        this.f50590a = AudioRecord.getMinBufferSize(i2, i3, i4) + 2048;
        this.f50596g = i2;
        this.f50597h = i3;
        this.i = i4;
        AudioRecord audioRecord = this.f50592c;
        if (audioRecord != null) {
            audioRecord.release();
        }
        this.f50592c = new AudioRecord(i, this.f50596g, this.f50597h, this.i, this.f50590a);
        this.j = (short) (this.f50597h == 12 ? 2 : 1);
        this.k = (short) (this.i == 2 ? 16 : 8);
        File file = new File(str);
        this.f50594e = file;
        if (file.exists()) {
            this.f50594e.delete();
        }
        try {
            this.f50594e.createNewFile();
            RandomAccessFile randomAccessFile = this.f50593d;
            if (randomAccessFile != null) {
                try {
                    randomAccessFile.close();
                } catch (IOException e2) {
                    e2.printStackTrace();
                    return false;
                }
            }
            try {
                this.f50593d = new RandomAccessFile(this.f50594e, "rw");
                i();
                f(this.f50594e.getParent());
                return true;
            } catch (FileNotFoundException e3) {
                e3.printStackTrace();
                return false;
            }
        } catch (IOException unused) {
            this.f50594e = null;
            return false;
        }
    }

    public final void h() {
        AudioRecord audioRecord = this.f50592c;
        if (audioRecord == null || this.f50594e == null) {
            return;
        }
        try {
            this.f50591b = true;
            int i = this.f50590a;
            byte[] bArr = new byte[i];
            audioRecord.startRecording();
            while (this.f50591b) {
                this.f50592c.read(bArr, 0, i);
                this.f50593d.write(bArr);
                this.f50595f += i;
            }
            this.f50593d.seek(4L);
            this.f50593d.writeInt(Integer.reverseBytes(this.f50595f + 36));
            this.f50593d.seek(40L);
            this.f50593d.writeInt(Integer.reverseBytes(this.f50595f));
            this.f50593d.close();
            this.f50592c.stop();
            this.f50592c.release();
            this.f50591b = false;
        } catch (Throwable unused) {
            if (this.f50594e.exists()) {
                this.f50594e.delete();
            }
        }
    }

    public final void i() {
        try {
            this.f50593d.setLength(0L);
            this.f50593d.writeBytes(com.baidu.wallet.base.audio.b.f23529e);
            this.f50593d.writeInt(0);
            this.f50593d.writeBytes(com.baidu.wallet.base.audio.b.f23530f);
            this.f50593d.writeBytes(com.baidu.wallet.base.audio.b.f23531g);
            this.f50593d.writeInt(Integer.reverseBytes(16));
            this.f50593d.writeShort(Short.reverseBytes((short) 1));
            this.f50593d.writeShort(Short.reverseBytes(this.j));
            this.f50593d.writeInt(Integer.reverseBytes(this.f50596g));
            this.f50593d.writeInt(Integer.reverseBytes(((this.f50596g * this.j) * this.k) / 8));
            this.f50593d.writeShort(Short.reverseBytes((short) ((this.j * this.k) / 8)));
            this.f50593d.writeShort(Short.reverseBytes(this.k));
            this.f50593d.writeBytes("data");
            this.f50593d.writeInt(0);
        } catch (IOException e2) {
            if (this.f50594e.exists()) {
                this.f50594e.delete();
            }
            e2.printStackTrace();
        }
    }
}
