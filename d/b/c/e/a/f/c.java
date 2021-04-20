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
    public Bitmap f42095a;

    /* renamed from: b  reason: collision with root package name */
    public BitmapFactory.Options f42096b;

    /* renamed from: c  reason: collision with root package name */
    public a f42097c;

    /* renamed from: d  reason: collision with root package name */
    public boolean f42098d;

    /* renamed from: e  reason: collision with root package name */
    public long f42099e;

    /* loaded from: classes.dex */
    public static class a {

        /* renamed from: d  reason: collision with root package name */
        public static byte f42100d = Byte.MIN_VALUE;

        /* renamed from: e  reason: collision with root package name */
        public static byte f42101e = Byte.MIN_VALUE;

        /* renamed from: a  reason: collision with root package name */
        public boolean f42102a = false;

        /* renamed from: b  reason: collision with root package name */
        public long f42103b = 0;

        /* renamed from: c  reason: collision with root package name */
        public boolean f42104c = true;

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
            if ((wrap.get() & f42100d) != 0) {
                this.f42102a = true;
            }
            this.f42103b = wrap.getLong();
            if ((wrap.get() & f42101e) != 0) {
                this.f42104c = false;
            }
            return true;
        }

        public byte[] c() {
            ByteBuffer allocate = ByteBuffer.allocate(a());
            allocate.putInt(1786600511);
            allocate.put(this.f42102a ? (byte) (f42100d | 0) : (byte) 0);
            allocate.putLong(this.f42103b);
            allocate.put(this.f42104c ? (byte) 0 : (byte) (f42101e | 0));
            allocate.flip();
            return allocate.array();
        }
    }

    public c(String str, String str2, DiskFileOperate.Action action) {
        super(str, str2, action);
        this.f42095a = null;
        this.f42096b = null;
        this.f42097c = null;
        this.f42098d = true;
        this.f42097c = new a();
    }

    public byte[] a() {
        int a2 = a.a();
        int length = this.mData.length - a2;
        byte[] bArr = new byte[length];
        System.arraycopy(this.mData, a2, bArr, 0, length);
        return bArr;
    }

    public boolean b() {
        return this.f42097c.f42104c;
    }

    @Override // com.baidu.adp.lib.Disk.ops.DiskFileOperate
    public byte[] buildFormatData() {
        if (this.mData == null || !this.f42098d) {
            return null;
        }
        return this.f42097c.c();
    }

    public void c(boolean z) {
        this.f42097c.f42104c = z;
    }

    public void d(boolean z) {
        this.f42098d = z;
    }

    @Override // com.baidu.adp.lib.Disk.ops.DiskFileOperate
    public void endLog() {
        d.b.c.e.l.a.k(isSuccess(), System.currentTimeMillis() - this.f42099e);
    }

    @Override // com.baidu.adp.lib.Disk.ops.DiskFileOperate
    public boolean formatData(byte[] bArr) {
        if (bArr != null && this.f42097c.b(bArr)) {
            long j = this.f42097c.f42103b;
            if (j == 0 || j >= System.currentTimeMillis()) {
                if (this.f42096b == null) {
                    BitmapFactory.Options options = new BitmapFactory.Options();
                    this.f42096b = options;
                    options.inPreferredConfig = Bitmap.Config.RGB_565;
                }
                int a2 = a.a();
                try {
                    this.f42095a = BitmapFactory.decodeByteArray(bArr, a2, bArr.length - a2, this.f42096b);
                } catch (Error e2) {
                    BdLog.e(e2.getMessage());
                }
                return this.f42095a != null;
            }
        }
        return false;
    }

    public Bitmap getBitmap() {
        return this.f42095a;
    }

    public boolean isGif() {
        return this.f42097c.f42102a;
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
        this.f42097c.f42102a = z;
    }

    @Override // com.baidu.adp.lib.Disk.ops.DiskFileOperate
    public void startLog() {
        this.f42099e = System.currentTimeMillis();
    }
}
