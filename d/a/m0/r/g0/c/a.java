package d.a.m0.r.g0.c;

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
    public RandomAccessFile f53502d;

    /* renamed from: f  reason: collision with root package name */
    public int f53504f;

    /* renamed from: g  reason: collision with root package name */
    public int f53505g;

    /* renamed from: h  reason: collision with root package name */
    public int f53506h;

    /* renamed from: i  reason: collision with root package name */
    public int f53507i;
    public short j;
    public short k;

    /* renamed from: a  reason: collision with root package name */
    public int f53499a = 0;

    /* renamed from: b  reason: collision with root package name */
    public boolean f53500b = false;

    /* renamed from: c  reason: collision with root package name */
    public AudioRecord f53501c = null;

    /* renamed from: e  reason: collision with root package name */
    public File f53503e = null;

    /* renamed from: d.a.m0.r.g0.c.a$a  reason: collision with other inner class name */
    /* loaded from: classes3.dex */
    public class RunnableC1195a implements Runnable {
        public RunnableC1195a() {
        }

        @Override // java.lang.Runnable
        public void run() {
            a.this.h();
        }
    }

    @Override // d.a.m0.r.g0.c.d
    public void a() {
        this.f53500b = false;
    }

    @Override // d.a.m0.r.g0.c.d
    public boolean b(String str) {
        return g(o, l, m, n, str);
    }

    @Override // d.a.m0.r.g0.c.d
    public boolean c() {
        Thread thread = new Thread(new RunnableC1195a());
        thread.setPriority(10);
        thread.setDaemon(true);
        thread.start();
        return true;
    }

    @Override // d.a.m0.r.g0.c.d
    public boolean d() {
        return this.f53500b;
    }

    public void f(String str) {
    }

    public boolean g(int i2, int i3, int i4, int i5, String str) {
        this.f53499a = AudioRecord.getMinBufferSize(i3, i4, i5) + 2048;
        this.f53505g = i3;
        this.f53506h = i4;
        this.f53507i = i5;
        AudioRecord audioRecord = this.f53501c;
        if (audioRecord != null) {
            audioRecord.release();
        }
        this.f53501c = new AudioRecord(i2, this.f53505g, this.f53506h, this.f53507i, this.f53499a);
        this.j = (short) (this.f53506h == 12 ? 2 : 1);
        this.k = (short) (this.f53507i == 2 ? 16 : 8);
        File file = new File(str);
        this.f53503e = file;
        if (file.exists()) {
            this.f53503e.delete();
        }
        try {
            this.f53503e.createNewFile();
            RandomAccessFile randomAccessFile = this.f53502d;
            if (randomAccessFile != null) {
                try {
                    randomAccessFile.close();
                } catch (IOException e2) {
                    e2.printStackTrace();
                    return false;
                }
            }
            try {
                this.f53502d = new RandomAccessFile(this.f53503e, "rw");
                i();
                f(this.f53503e.getParent());
                return true;
            } catch (FileNotFoundException e3) {
                e3.printStackTrace();
                return false;
            }
        } catch (IOException unused) {
            this.f53503e = null;
            return false;
        }
    }

    public final void h() {
        AudioRecord audioRecord = this.f53501c;
        if (audioRecord == null || this.f53503e == null) {
            return;
        }
        try {
            this.f53500b = true;
            int i2 = this.f53499a;
            byte[] bArr = new byte[i2];
            audioRecord.startRecording();
            while (this.f53500b) {
                this.f53501c.read(bArr, 0, i2);
                this.f53502d.write(bArr);
                this.f53504f += i2;
            }
            this.f53502d.seek(4L);
            this.f53502d.writeInt(Integer.reverseBytes(this.f53504f + 36));
            this.f53502d.seek(40L);
            this.f53502d.writeInt(Integer.reverseBytes(this.f53504f));
            this.f53502d.close();
            this.f53501c.stop();
            this.f53501c.release();
            this.f53500b = false;
        } catch (Throwable unused) {
            if (this.f53503e.exists()) {
                this.f53503e.delete();
            }
        }
    }

    public final void i() {
        try {
            this.f53502d.setLength(0L);
            this.f53502d.writeBytes(com.baidu.wallet.base.audio.b.f23215e);
            this.f53502d.writeInt(0);
            this.f53502d.writeBytes(com.baidu.wallet.base.audio.b.f23216f);
            this.f53502d.writeBytes(com.baidu.wallet.base.audio.b.f23217g);
            this.f53502d.writeInt(Integer.reverseBytes(16));
            this.f53502d.writeShort(Short.reverseBytes((short) 1));
            this.f53502d.writeShort(Short.reverseBytes(this.j));
            this.f53502d.writeInt(Integer.reverseBytes(this.f53505g));
            this.f53502d.writeInt(Integer.reverseBytes(((this.f53505g * this.j) * this.k) / 8));
            this.f53502d.writeShort(Short.reverseBytes((short) ((this.j * this.k) / 8)));
            this.f53502d.writeShort(Short.reverseBytes(this.k));
            this.f53502d.writeBytes("data");
            this.f53502d.writeInt(0);
        } catch (IOException e2) {
            if (this.f53503e.exists()) {
                this.f53503e.delete();
            }
            e2.printStackTrace();
        }
    }
}
