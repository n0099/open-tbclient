package d.a.j0.r.g0.c;

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
    public RandomAccessFile f49783d;

    /* renamed from: f  reason: collision with root package name */
    public int f49785f;

    /* renamed from: g  reason: collision with root package name */
    public int f49786g;

    /* renamed from: h  reason: collision with root package name */
    public int f49787h;

    /* renamed from: i  reason: collision with root package name */
    public int f49788i;
    public short j;
    public short k;

    /* renamed from: a  reason: collision with root package name */
    public int f49780a = 0;

    /* renamed from: b  reason: collision with root package name */
    public boolean f49781b = false;

    /* renamed from: c  reason: collision with root package name */
    public AudioRecord f49782c = null;

    /* renamed from: e  reason: collision with root package name */
    public File f49784e = null;

    /* renamed from: d.a.j0.r.g0.c.a$a  reason: collision with other inner class name */
    /* loaded from: classes3.dex */
    public class RunnableC1130a implements Runnable {
        public RunnableC1130a() {
        }

        @Override // java.lang.Runnable
        public void run() {
            a.this.h();
        }
    }

    @Override // d.a.j0.r.g0.c.d
    public void a() {
        this.f49781b = false;
    }

    @Override // d.a.j0.r.g0.c.d
    public boolean b(String str) {
        return g(o, l, m, n, str);
    }

    @Override // d.a.j0.r.g0.c.d
    public boolean c() {
        Thread thread = new Thread(new RunnableC1130a());
        thread.setPriority(10);
        thread.setDaemon(true);
        thread.start();
        return true;
    }

    @Override // d.a.j0.r.g0.c.d
    public boolean d() {
        return this.f49781b;
    }

    public void f(String str) {
    }

    public boolean g(int i2, int i3, int i4, int i5, String str) {
        this.f49780a = AudioRecord.getMinBufferSize(i3, i4, i5) + 2048;
        this.f49786g = i3;
        this.f49787h = i4;
        this.f49788i = i5;
        AudioRecord audioRecord = this.f49782c;
        if (audioRecord != null) {
            audioRecord.release();
        }
        this.f49782c = new AudioRecord(i2, this.f49786g, this.f49787h, this.f49788i, this.f49780a);
        this.j = (short) (this.f49787h == 12 ? 2 : 1);
        this.k = (short) (this.f49788i == 2 ? 16 : 8);
        File file = new File(str);
        this.f49784e = file;
        if (file.exists()) {
            this.f49784e.delete();
        }
        try {
            this.f49784e.createNewFile();
            RandomAccessFile randomAccessFile = this.f49783d;
            if (randomAccessFile != null) {
                try {
                    randomAccessFile.close();
                } catch (IOException e2) {
                    e2.printStackTrace();
                    return false;
                }
            }
            try {
                this.f49783d = new RandomAccessFile(this.f49784e, "rw");
                i();
                f(this.f49784e.getParent());
                return true;
            } catch (FileNotFoundException e3) {
                e3.printStackTrace();
                return false;
            }
        } catch (IOException unused) {
            this.f49784e = null;
            return false;
        }
    }

    public final void h() {
        AudioRecord audioRecord = this.f49782c;
        if (audioRecord == null || this.f49784e == null) {
            return;
        }
        try {
            this.f49781b = true;
            int i2 = this.f49780a;
            byte[] bArr = new byte[i2];
            audioRecord.startRecording();
            while (this.f49781b) {
                this.f49782c.read(bArr, 0, i2);
                this.f49783d.write(bArr);
                this.f49785f += i2;
            }
            this.f49783d.seek(4L);
            this.f49783d.writeInt(Integer.reverseBytes(this.f49785f + 36));
            this.f49783d.seek(40L);
            this.f49783d.writeInt(Integer.reverseBytes(this.f49785f));
            this.f49783d.close();
            this.f49782c.stop();
            this.f49782c.release();
            this.f49781b = false;
        } catch (Throwable unused) {
            if (this.f49784e.exists()) {
                this.f49784e.delete();
            }
        }
    }

    public final void i() {
        try {
            this.f49783d.setLength(0L);
            this.f49783d.writeBytes(com.baidu.wallet.base.audio.b.f23183e);
            this.f49783d.writeInt(0);
            this.f49783d.writeBytes(com.baidu.wallet.base.audio.b.f23184f);
            this.f49783d.writeBytes(com.baidu.wallet.base.audio.b.f23185g);
            this.f49783d.writeInt(Integer.reverseBytes(16));
            this.f49783d.writeShort(Short.reverseBytes((short) 1));
            this.f49783d.writeShort(Short.reverseBytes(this.j));
            this.f49783d.writeInt(Integer.reverseBytes(this.f49786g));
            this.f49783d.writeInt(Integer.reverseBytes(((this.f49786g * this.j) * this.k) / 8));
            this.f49783d.writeShort(Short.reverseBytes((short) ((this.j * this.k) / 8)));
            this.f49783d.writeShort(Short.reverseBytes(this.k));
            this.f49783d.writeBytes("data");
            this.f49783d.writeInt(0);
        } catch (IOException e2) {
            if (this.f49784e.exists()) {
                this.f49784e.delete();
            }
            e2.printStackTrace();
        }
    }
}
