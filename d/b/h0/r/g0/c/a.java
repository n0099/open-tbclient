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
    public RandomAccessFile f50594d;

    /* renamed from: f  reason: collision with root package name */
    public int f50596f;

    /* renamed from: g  reason: collision with root package name */
    public int f50597g;

    /* renamed from: h  reason: collision with root package name */
    public int f50598h;
    public int i;
    public short j;
    public short k;

    /* renamed from: a  reason: collision with root package name */
    public int f50591a = 0;

    /* renamed from: b  reason: collision with root package name */
    public boolean f50592b = false;

    /* renamed from: c  reason: collision with root package name */
    public AudioRecord f50593c = null;

    /* renamed from: e  reason: collision with root package name */
    public File f50595e = null;

    /* renamed from: d.b.h0.r.g0.c.a$a  reason: collision with other inner class name */
    /* loaded from: classes3.dex */
    public class RunnableC1080a implements Runnable {
        public RunnableC1080a() {
        }

        @Override // java.lang.Runnable
        public void run() {
            a.this.h();
        }
    }

    @Override // d.b.h0.r.g0.c.d
    public void a() {
        this.f50592b = false;
    }

    @Override // d.b.h0.r.g0.c.d
    public boolean b(String str) {
        return g(o, l, m, n, str);
    }

    @Override // d.b.h0.r.g0.c.d
    public boolean c() {
        Thread thread = new Thread(new RunnableC1080a());
        thread.setPriority(10);
        thread.setDaemon(true);
        thread.start();
        return true;
    }

    @Override // d.b.h0.r.g0.c.d
    public boolean d() {
        return this.f50592b;
    }

    public void f(String str) {
    }

    public boolean g(int i, int i2, int i3, int i4, String str) {
        this.f50591a = AudioRecord.getMinBufferSize(i2, i3, i4) + 2048;
        this.f50597g = i2;
        this.f50598h = i3;
        this.i = i4;
        AudioRecord audioRecord = this.f50593c;
        if (audioRecord != null) {
            audioRecord.release();
        }
        this.f50593c = new AudioRecord(i, this.f50597g, this.f50598h, this.i, this.f50591a);
        this.j = (short) (this.f50598h == 12 ? 2 : 1);
        this.k = (short) (this.i == 2 ? 16 : 8);
        File file = new File(str);
        this.f50595e = file;
        if (file.exists()) {
            this.f50595e.delete();
        }
        try {
            this.f50595e.createNewFile();
            RandomAccessFile randomAccessFile = this.f50594d;
            if (randomAccessFile != null) {
                try {
                    randomAccessFile.close();
                } catch (IOException e2) {
                    e2.printStackTrace();
                    return false;
                }
            }
            try {
                this.f50594d = new RandomAccessFile(this.f50595e, "rw");
                i();
                f(this.f50595e.getParent());
                return true;
            } catch (FileNotFoundException e3) {
                e3.printStackTrace();
                return false;
            }
        } catch (IOException unused) {
            this.f50595e = null;
            return false;
        }
    }

    public final void h() {
        AudioRecord audioRecord = this.f50593c;
        if (audioRecord == null || this.f50595e == null) {
            return;
        }
        try {
            this.f50592b = true;
            int i = this.f50591a;
            byte[] bArr = new byte[i];
            audioRecord.startRecording();
            while (this.f50592b) {
                this.f50593c.read(bArr, 0, i);
                this.f50594d.write(bArr);
                this.f50596f += i;
            }
            this.f50594d.seek(4L);
            this.f50594d.writeInt(Integer.reverseBytes(this.f50596f + 36));
            this.f50594d.seek(40L);
            this.f50594d.writeInt(Integer.reverseBytes(this.f50596f));
            this.f50594d.close();
            this.f50593c.stop();
            this.f50593c.release();
            this.f50592b = false;
        } catch (Throwable unused) {
            if (this.f50595e.exists()) {
                this.f50595e.delete();
            }
        }
    }

    public final void i() {
        try {
            this.f50594d.setLength(0L);
            this.f50594d.writeBytes(com.baidu.wallet.base.audio.b.f23530e);
            this.f50594d.writeInt(0);
            this.f50594d.writeBytes(com.baidu.wallet.base.audio.b.f23531f);
            this.f50594d.writeBytes(com.baidu.wallet.base.audio.b.f23532g);
            this.f50594d.writeInt(Integer.reverseBytes(16));
            this.f50594d.writeShort(Short.reverseBytes((short) 1));
            this.f50594d.writeShort(Short.reverseBytes(this.j));
            this.f50594d.writeInt(Integer.reverseBytes(this.f50597g));
            this.f50594d.writeInt(Integer.reverseBytes(((this.f50597g * this.j) * this.k) / 8));
            this.f50594d.writeShort(Short.reverseBytes((short) ((this.j * this.k) / 8)));
            this.f50594d.writeShort(Short.reverseBytes(this.k));
            this.f50594d.writeBytes("data");
            this.f50594d.writeInt(0);
        } catch (IOException e2) {
            if (this.f50595e.exists()) {
                this.f50595e.delete();
            }
            e2.printStackTrace();
        }
    }
}
