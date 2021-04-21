package d.b.c.e.a.f;

import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import com.baidu.adp.lib.Disk.ops.DiskFileOperate;
import com.baidu.adp.lib.util.BdLog;
import d.b.c.e.p.l;
import java.nio.ByteBuffer;
/* loaded from: classes.dex */
public class c extends DiskFileOperate {

    /* renamed from: a  reason: collision with root package name */
    public Bitmap f42335a;

    /* renamed from: b  reason: collision with root package name */
    public BitmapFactory.Options f42336b;

    /* renamed from: c  reason: collision with root package name */
    public a f42337c;

    /* renamed from: d  reason: collision with root package name */
    public boolean f42338d;

    /* renamed from: e  reason: collision with root package name */
    public long f42339e;

    /* loaded from: classes.dex */
    public static class a {

        /* renamed from: d  reason: collision with root package name */
        public static byte f42340d = Byte.MIN_VALUE;

        /* renamed from: e  reason: collision with root package name */
        public static byte f42341e = Byte.MIN_VALUE;

        /* renamed from: a  reason: collision with root package name */
        public boolean f42342a = false;

        /* renamed from: b  reason: collision with root package name */
        public long f42343b = 0;

        /* renamed from: c  reason: collision with root package name */
        public boolean f42344c = true;

        public static int a() {
            return 14;
        }

        public boolean b(byte[] bArr) {
            if (bArr == null || bArr.length < a()) {
                return false;
            }
            ByteBuffer wrap = ByteBuffer.wrap(bArr, 0, a());
            if (wrap.getInt() != 1786600511) {
                return false;
            }
            if ((wrap.get() & f42340d) != 0) {
                this.f42342a = true;
            }
            this.f42343b = wrap.getLong();
            if ((wrap.get() & f42341e) != 0) {
                this.f42344c = false;
            }
            return true;
        }

        public byte[] c() {
            ByteBuffer allocate = ByteBuffer.allocate(a());
            allocate.putInt(1786600511);
            allocate.put(this.f42342a ? (byte) (f42340d | 0) : (byte) 0);
            allocate.putLong(this.f42343b);
            allocate.put(this.f42344c ? (byte) 0 : (byte) (f42341e | 0));
            allocate.flip();
            return allocate.array();
        }
    }

    public c(String str, String str2, DiskFileOperate.Action action) {
        super(str, str2, action);
        this.f42335a = null;
        this.f42336b = null;
        this.f42337c = null;
        this.f42338d = true;
        this.f42337c = new a();
    }

    public byte[] a() {
        int a2 = a.a();
        int length = this.mData.length - a2;
        byte[] bArr = new byte[length];
        System.arraycopy(this.mData, a2, bArr, 0, length);
        return bArr;
    }

    public boolean b() {
        return this.f42337c.f42344c;
    }

    @Override // com.baidu.adp.lib.Disk.ops.DiskFileOperate
    public byte[] buildFormatData() {
        if (this.mData == null || !this.f42338d) {
            return null;
        }
        return this.f42337c.c();
    }

    public void c(boolean z) {
        this.f42337c.f42344c = z;
    }

    public void d(boolean z) {
        this.f42338d = z;
    }

    @Override // com.baidu.adp.lib.Disk.ops.DiskFileOperate
    public void endLog() {
        d.b.c.e.l.a.k(isSuccess(), System.currentTimeMillis() - this.f42339e);
    }

    @Override // com.baidu.adp.lib.Disk.ops.DiskFileOperate
    public boolean formatData(byte[] bArr) {
        if (bArr != null && this.f42337c.b(bArr)) {
            long j = this.f42337c.f42343b;
            if (j == 0 || j >= System.currentTimeMillis()) {
                if (this.f42336b == null) {
                    BitmapFactory.Options options = new BitmapFactory.Options();
                    this.f42336b = options;
                    options.inPreferredConfig = Bitmap.Config.RGB_565;
                }
                int a2 = a.a();
                try {
                    this.f42335a = BitmapFactory.decodeByteArray(bArr, a2, bArr.length - a2, this.f42336b);
                } catch (Error e2) {
                    BdLog.e(e2.getMessage());
                }
                return this.f42335a != null;
            }
        }
        return false;
    }

    public Bitmap getBitmap() {
        return this.f42335a;
    }

    public boolean isGif() {
        return this.f42337c.f42342a;
    }

    @Override // com.baidu.adp.lib.Disk.ops.DiskFileOperate
    public void setData(byte[] bArr) {
        super.setData(bArr);
        if (isGif() || !l.A(bArr)) {
            return;
        }
        setGif(true);
    }

    public void setGif(boolean z) {
        this.f42337c.f42342a = z;
    }

    @Override // com.baidu.adp.lib.Disk.ops.DiskFileOperate
    public void startLog() {
        this.f42339e = System.currentTimeMillis();
    }
}
