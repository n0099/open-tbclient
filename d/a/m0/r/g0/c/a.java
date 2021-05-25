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
    public RandomAccessFile f49827d;

    /* renamed from: f  reason: collision with root package name */
    public int f49829f;

    /* renamed from: g  reason: collision with root package name */
    public int f49830g;

    /* renamed from: h  reason: collision with root package name */
    public int f49831h;

    /* renamed from: i  reason: collision with root package name */
    public int f49832i;
    public short j;
    public short k;

    /* renamed from: a  reason: collision with root package name */
    public int f49824a = 0;

    /* renamed from: b  reason: collision with root package name */
    public boolean f49825b = false;

    /* renamed from: c  reason: collision with root package name */
    public AudioRecord f49826c = null;

    /* renamed from: e  reason: collision with root package name */
    public File f49828e = null;

    /* renamed from: d.a.m0.r.g0.c.a$a  reason: collision with other inner class name */
    /* loaded from: classes3.dex */
    public class RunnableC1139a implements Runnable {
        public RunnableC1139a() {
        }

        @Override // java.lang.Runnable
        public void run() {
            a.this.h();
        }
    }

    @Override // d.a.m0.r.g0.c.d
    public void a() {
        this.f49825b = false;
    }

    @Override // d.a.m0.r.g0.c.d
    public boolean b(String str) {
        return g(o, l, m, n, str);
    }

    @Override // d.a.m0.r.g0.c.d
    public boolean c() {
        Thread thread = new Thread(new RunnableC1139a());
        thread.setPriority(10);
        thread.setDaemon(true);
        thread.start();
        return true;
    }

    @Override // d.a.m0.r.g0.c.d
    public boolean d() {
        return this.f49825b;
    }

    public void f(String str) {
    }

    public boolean g(int i2, int i3, int i4, int i5, String str) {
        this.f49824a = AudioRecord.getMinBufferSize(i3, i4, i5) + 2048;
        this.f49830g = i3;
        this.f49831h = i4;
        this.f49832i = i5;
        AudioRecord audioRecord = this.f49826c;
        if (audioRecord != null) {
            audioRecord.release();
        }
        this.f49826c = new AudioRecord(i2, this.f49830g, this.f49831h, this.f49832i, this.f49824a);
        this.j = (short) (this.f49831h == 12 ? 2 : 1);
        this.k = (short) (this.f49832i == 2 ? 16 : 8);
        File file = new File(str);
        this.f49828e = file;
        if (file.exists()) {
            this.f49828e.delete();
        }
        try {
            this.f49828e.createNewFile();
            RandomAccessFile randomAccessFile = this.f49827d;
            if (randomAccessFile != null) {
                try {
                    randomAccessFile.close();
                } catch (IOException e2) {
                    e2.printStackTrace();
                    return false;
                }
            }
            try {
                this.f49827d = new RandomAccessFile(this.f49828e, "rw");
                i();
                f(this.f49828e.getParent());
                return true;
            } catch (FileNotFoundException e3) {
                e3.printStackTrace();
                return false;
            }
        } catch (IOException unused) {
            this.f49828e = null;
            return false;
        }
    }

    public final void h() {
        AudioRecord audioRecord = this.f49826c;
        if (audioRecord == null || this.f49828e == null) {
            return;
        }
        try {
            this.f49825b = true;
            int i2 = this.f49824a;
            byte[] bArr = new byte[i2];
            audioRecord.startRecording();
            while (this.f49825b) {
                this.f49826c.read(bArr, 0, i2);
                this.f49827d.write(bArr);
                this.f49829f += i2;
            }
            this.f49827d.seek(4L);
            this.f49827d.writeInt(Integer.reverseBytes(this.f49829f + 36));
            this.f49827d.seek(40L);
            this.f49827d.writeInt(Integer.reverseBytes(this.f49829f));
            this.f49827d.close();
            this.f49826c.stop();
            this.f49826c.release();
            this.f49825b = false;
        } catch (Throwable unused) {
            if (this.f49828e.exists()) {
                this.f49828e.delete();
            }
        }
    }

    public final void i() {
        try {
            this.f49827d.setLength(0L);
            this.f49827d.writeBytes(com.baidu.wallet.base.audio.b.f23112e);
            this.f49827d.writeInt(0);
            this.f49827d.writeBytes(com.baidu.wallet.base.audio.b.f23113f);
            this.f49827d.writeBytes(com.baidu.wallet.base.audio.b.f23114g);
            this.f49827d.writeInt(Integer.reverseBytes(16));
            this.f49827d.writeShort(Short.reverseBytes((short) 1));
            this.f49827d.writeShort(Short.reverseBytes(this.j));
            this.f49827d.writeInt(Integer.reverseBytes(this.f49830g));
            this.f49827d.writeInt(Integer.reverseBytes(((this.f49830g * this.j) * this.k) / 8));
            this.f49827d.writeShort(Short.reverseBytes((short) ((this.j * this.k) / 8)));
            this.f49827d.writeShort(Short.reverseBytes(this.k));
            this.f49827d.writeBytes("data");
            this.f49827d.writeInt(0);
        } catch (IOException e2) {
            if (this.f49828e.exists()) {
                this.f49828e.delete();
            }
            e2.printStackTrace();
        }
    }
}
