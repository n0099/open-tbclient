package d.b.i0.r.g0.c;

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
    public RandomAccessFile f51337d;

    /* renamed from: f  reason: collision with root package name */
    public int f51339f;

    /* renamed from: g  reason: collision with root package name */
    public int f51340g;

    /* renamed from: h  reason: collision with root package name */
    public int f51341h;
    public int i;
    public short j;
    public short k;

    /* renamed from: a  reason: collision with root package name */
    public int f51334a = 0;

    /* renamed from: b  reason: collision with root package name */
    public boolean f51335b = false;

    /* renamed from: c  reason: collision with root package name */
    public AudioRecord f51336c = null;

    /* renamed from: e  reason: collision with root package name */
    public File f51338e = null;

    /* renamed from: d.b.i0.r.g0.c.a$a  reason: collision with other inner class name */
    /* loaded from: classes3.dex */
    public class RunnableC1115a implements Runnable {
        public RunnableC1115a() {
        }

        @Override // java.lang.Runnable
        public void run() {
            a.this.h();
        }
    }

    @Override // d.b.i0.r.g0.c.d
    public void a() {
        this.f51335b = false;
    }

    @Override // d.b.i0.r.g0.c.d
    public boolean b(String str) {
        return g(o, l, m, n, str);
    }

    @Override // d.b.i0.r.g0.c.d
    public boolean c() {
        Thread thread = new Thread(new RunnableC1115a());
        thread.setPriority(10);
        thread.setDaemon(true);
        thread.start();
        return true;
    }

    @Override // d.b.i0.r.g0.c.d
    public boolean d() {
        return this.f51335b;
    }

    public void f(String str) {
    }

    public boolean g(int i, int i2, int i3, int i4, String str) {
        this.f51334a = AudioRecord.getMinBufferSize(i2, i3, i4) + 2048;
        this.f51340g = i2;
        this.f51341h = i3;
        this.i = i4;
        AudioRecord audioRecord = this.f51336c;
        if (audioRecord != null) {
            audioRecord.release();
        }
        this.f51336c = new AudioRecord(i, this.f51340g, this.f51341h, this.i, this.f51334a);
        this.j = (short) (this.f51341h == 12 ? 2 : 1);
        this.k = (short) (this.i == 2 ? 16 : 8);
        File file = new File(str);
        this.f51338e = file;
        if (file.exists()) {
            this.f51338e.delete();
        }
        try {
            this.f51338e.createNewFile();
            RandomAccessFile randomAccessFile = this.f51337d;
            if (randomAccessFile != null) {
                try {
                    randomAccessFile.close();
                } catch (IOException e2) {
                    e2.printStackTrace();
                    return false;
                }
            }
            try {
                this.f51337d = new RandomAccessFile(this.f51338e, "rw");
                i();
                f(this.f51338e.getParent());
                return true;
            } catch (FileNotFoundException e3) {
                e3.printStackTrace();
                return false;
            }
        } catch (IOException unused) {
            this.f51338e = null;
            return false;
        }
    }

    public final void h() {
        AudioRecord audioRecord = this.f51336c;
        if (audioRecord == null || this.f51338e == null) {
            return;
        }
        try {
            this.f51335b = true;
            int i = this.f51334a;
            byte[] bArr = new byte[i];
            audioRecord.startRecording();
            while (this.f51335b) {
                this.f51336c.read(bArr, 0, i);
                this.f51337d.write(bArr);
                this.f51339f += i;
            }
            this.f51337d.seek(4L);
            this.f51337d.writeInt(Integer.reverseBytes(this.f51339f + 36));
            this.f51337d.seek(40L);
            this.f51337d.writeInt(Integer.reverseBytes(this.f51339f));
            this.f51337d.close();
            this.f51336c.stop();
            this.f51336c.release();
            this.f51335b = false;
        } catch (Throwable unused) {
            if (this.f51338e.exists()) {
                this.f51338e.delete();
            }
        }
    }

    public final void i() {
        try {
            this.f51337d.setLength(0L);
            this.f51337d.writeBytes(com.baidu.wallet.base.audio.b.f23223e);
            this.f51337d.writeInt(0);
            this.f51337d.writeBytes(com.baidu.wallet.base.audio.b.f23224f);
            this.f51337d.writeBytes(com.baidu.wallet.base.audio.b.f23225g);
            this.f51337d.writeInt(Integer.reverseBytes(16));
            this.f51337d.writeShort(Short.reverseBytes((short) 1));
            this.f51337d.writeShort(Short.reverseBytes(this.j));
            this.f51337d.writeInt(Integer.reverseBytes(this.f51340g));
            this.f51337d.writeInt(Integer.reverseBytes(((this.f51340g * this.j) * this.k) / 8));
            this.f51337d.writeShort(Short.reverseBytes((short) ((this.j * this.k) / 8)));
            this.f51337d.writeShort(Short.reverseBytes(this.k));
            this.f51337d.writeBytes("data");
            this.f51337d.writeInt(0);
        } catch (IOException e2) {
            if (this.f51338e.exists()) {
                this.f51338e.delete();
            }
            e2.printStackTrace();
        }
    }
}
