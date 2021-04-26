package d.a.i0.r.g0.c;

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
    public RandomAccessFile f48953d;

    /* renamed from: f  reason: collision with root package name */
    public int f48955f;

    /* renamed from: g  reason: collision with root package name */
    public int f48956g;

    /* renamed from: h  reason: collision with root package name */
    public int f48957h;

    /* renamed from: i  reason: collision with root package name */
    public int f48958i;
    public short j;
    public short k;

    /* renamed from: a  reason: collision with root package name */
    public int f48950a = 0;

    /* renamed from: b  reason: collision with root package name */
    public boolean f48951b = false;

    /* renamed from: c  reason: collision with root package name */
    public AudioRecord f48952c = null;

    /* renamed from: e  reason: collision with root package name */
    public File f48954e = null;

    /* renamed from: d.a.i0.r.g0.c.a$a  reason: collision with other inner class name */
    /* loaded from: classes3.dex */
    public class RunnableC1054a implements Runnable {
        public RunnableC1054a() {
        }

        @Override // java.lang.Runnable
        public void run() {
            a.this.h();
        }
    }

    @Override // d.a.i0.r.g0.c.d
    public void a() {
        this.f48951b = false;
    }

    @Override // d.a.i0.r.g0.c.d
    public boolean b(String str) {
        return g(o, l, m, n, str);
    }

    @Override // d.a.i0.r.g0.c.d
    public boolean c() {
        Thread thread = new Thread(new RunnableC1054a());
        thread.setPriority(10);
        thread.setDaemon(true);
        thread.start();
        return true;
    }

    @Override // d.a.i0.r.g0.c.d
    public boolean d() {
        return this.f48951b;
    }

    public void f(String str) {
    }

    public boolean g(int i2, int i3, int i4, int i5, String str) {
        this.f48950a = AudioRecord.getMinBufferSize(i3, i4, i5) + 2048;
        this.f48956g = i3;
        this.f48957h = i4;
        this.f48958i = i5;
        AudioRecord audioRecord = this.f48952c;
        if (audioRecord != null) {
            audioRecord.release();
        }
        this.f48952c = new AudioRecord(i2, this.f48956g, this.f48957h, this.f48958i, this.f48950a);
        this.j = (short) (this.f48957h == 12 ? 2 : 1);
        this.k = (short) (this.f48958i == 2 ? 16 : 8);
        File file = new File(str);
        this.f48954e = file;
        if (file.exists()) {
            this.f48954e.delete();
        }
        try {
            this.f48954e.createNewFile();
            RandomAccessFile randomAccessFile = this.f48953d;
            if (randomAccessFile != null) {
                try {
                    randomAccessFile.close();
                } catch (IOException e2) {
                    e2.printStackTrace();
                    return false;
                }
            }
            try {
                this.f48953d = new RandomAccessFile(this.f48954e, "rw");
                i();
                f(this.f48954e.getParent());
                return true;
            } catch (FileNotFoundException e3) {
                e3.printStackTrace();
                return false;
            }
        } catch (IOException unused) {
            this.f48954e = null;
            return false;
        }
    }

    public final void h() {
        AudioRecord audioRecord = this.f48952c;
        if (audioRecord == null || this.f48954e == null) {
            return;
        }
        try {
            this.f48951b = true;
            int i2 = this.f48950a;
            byte[] bArr = new byte[i2];
            audioRecord.startRecording();
            while (this.f48951b) {
                this.f48952c.read(bArr, 0, i2);
                this.f48953d.write(bArr);
                this.f48955f += i2;
            }
            this.f48953d.seek(4L);
            this.f48953d.writeInt(Integer.reverseBytes(this.f48955f + 36));
            this.f48953d.seek(40L);
            this.f48953d.writeInt(Integer.reverseBytes(this.f48955f));
            this.f48953d.close();
            this.f48952c.stop();
            this.f48952c.release();
            this.f48951b = false;
        } catch (Throwable unused) {
            if (this.f48954e.exists()) {
                this.f48954e.delete();
            }
        }
    }

    public final void i() {
        try {
            this.f48953d.setLength(0L);
            this.f48953d.writeBytes(com.baidu.wallet.base.audio.b.f23938e);
            this.f48953d.writeInt(0);
            this.f48953d.writeBytes(com.baidu.wallet.base.audio.b.f23939f);
            this.f48953d.writeBytes(com.baidu.wallet.base.audio.b.f23940g);
            this.f48953d.writeInt(Integer.reverseBytes(16));
            this.f48953d.writeShort(Short.reverseBytes((short) 1));
            this.f48953d.writeShort(Short.reverseBytes(this.j));
            this.f48953d.writeInt(Integer.reverseBytes(this.f48956g));
            this.f48953d.writeInt(Integer.reverseBytes(((this.f48956g * this.j) * this.k) / 8));
            this.f48953d.writeShort(Short.reverseBytes((short) ((this.j * this.k) / 8)));
            this.f48953d.writeShort(Short.reverseBytes(this.k));
            this.f48953d.writeBytes("data");
            this.f48953d.writeInt(0);
        } catch (IOException e2) {
            if (this.f48954e.exists()) {
                this.f48954e.delete();
            }
            e2.printStackTrace();
        }
    }
}
