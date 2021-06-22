package d.a.n0.r.g0.c;

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
    public RandomAccessFile f53609d;

    /* renamed from: f  reason: collision with root package name */
    public int f53611f;

    /* renamed from: g  reason: collision with root package name */
    public int f53612g;

    /* renamed from: h  reason: collision with root package name */
    public int f53613h;

    /* renamed from: i  reason: collision with root package name */
    public int f53614i;
    public short j;
    public short k;

    /* renamed from: a  reason: collision with root package name */
    public int f53606a = 0;

    /* renamed from: b  reason: collision with root package name */
    public boolean f53607b = false;

    /* renamed from: c  reason: collision with root package name */
    public AudioRecord f53608c = null;

    /* renamed from: e  reason: collision with root package name */
    public File f53610e = null;

    /* renamed from: d.a.n0.r.g0.c.a$a  reason: collision with other inner class name */
    /* loaded from: classes3.dex */
    public class RunnableC1198a implements Runnable {
        public RunnableC1198a() {
        }

        @Override // java.lang.Runnable
        public void run() {
            a.this.h();
        }
    }

    @Override // d.a.n0.r.g0.c.d
    public void a() {
        this.f53607b = false;
    }

    @Override // d.a.n0.r.g0.c.d
    public boolean b(String str) {
        return g(o, l, m, n, str);
    }

    @Override // d.a.n0.r.g0.c.d
    public boolean c() {
        Thread thread = new Thread(new RunnableC1198a());
        thread.setPriority(10);
        thread.setDaemon(true);
        thread.start();
        return true;
    }

    @Override // d.a.n0.r.g0.c.d
    public boolean d() {
        return this.f53607b;
    }

    public void f(String str) {
    }

    public boolean g(int i2, int i3, int i4, int i5, String str) {
        this.f53606a = AudioRecord.getMinBufferSize(i3, i4, i5) + 2048;
        this.f53612g = i3;
        this.f53613h = i4;
        this.f53614i = i5;
        AudioRecord audioRecord = this.f53608c;
        if (audioRecord != null) {
            audioRecord.release();
        }
        this.f53608c = new AudioRecord(i2, this.f53612g, this.f53613h, this.f53614i, this.f53606a);
        this.j = (short) (this.f53613h == 12 ? 2 : 1);
        this.k = (short) (this.f53614i == 2 ? 16 : 8);
        File file = new File(str);
        this.f53610e = file;
        if (file.exists()) {
            this.f53610e.delete();
        }
        try {
            this.f53610e.createNewFile();
            RandomAccessFile randomAccessFile = this.f53609d;
            if (randomAccessFile != null) {
                try {
                    randomAccessFile.close();
                } catch (IOException e2) {
                    e2.printStackTrace();
                    return false;
                }
            }
            try {
                this.f53609d = new RandomAccessFile(this.f53610e, "rw");
                i();
                f(this.f53610e.getParent());
                return true;
            } catch (FileNotFoundException e3) {
                e3.printStackTrace();
                return false;
            }
        } catch (IOException unused) {
            this.f53610e = null;
            return false;
        }
    }

    public final void h() {
        AudioRecord audioRecord = this.f53608c;
        if (audioRecord == null || this.f53610e == null) {
            return;
        }
        try {
            this.f53607b = true;
            int i2 = this.f53606a;
            byte[] bArr = new byte[i2];
            audioRecord.startRecording();
            while (this.f53607b) {
                this.f53608c.read(bArr, 0, i2);
                this.f53609d.write(bArr);
                this.f53611f += i2;
            }
            this.f53609d.seek(4L);
            this.f53609d.writeInt(Integer.reverseBytes(this.f53611f + 36));
            this.f53609d.seek(40L);
            this.f53609d.writeInt(Integer.reverseBytes(this.f53611f));
            this.f53609d.close();
            this.f53608c.stop();
            this.f53608c.release();
            this.f53607b = false;
        } catch (Throwable unused) {
            if (this.f53610e.exists()) {
                this.f53610e.delete();
            }
        }
    }

    public final void i() {
        try {
            this.f53609d.setLength(0L);
            this.f53609d.writeBytes(com.baidu.wallet.base.audio.b.f23297e);
            this.f53609d.writeInt(0);
            this.f53609d.writeBytes(com.baidu.wallet.base.audio.b.f23298f);
            this.f53609d.writeBytes(com.baidu.wallet.base.audio.b.f23299g);
            this.f53609d.writeInt(Integer.reverseBytes(16));
            this.f53609d.writeShort(Short.reverseBytes((short) 1));
            this.f53609d.writeShort(Short.reverseBytes(this.j));
            this.f53609d.writeInt(Integer.reverseBytes(this.f53612g));
            this.f53609d.writeInt(Integer.reverseBytes(((this.f53612g * this.j) * this.k) / 8));
            this.f53609d.writeShort(Short.reverseBytes((short) ((this.j * this.k) / 8)));
            this.f53609d.writeShort(Short.reverseBytes(this.k));
            this.f53609d.writeBytes("data");
            this.f53609d.writeInt(0);
        } catch (IOException e2) {
            if (this.f53610e.exists()) {
                this.f53610e.delete();
            }
            e2.printStackTrace();
        }
    }
}
