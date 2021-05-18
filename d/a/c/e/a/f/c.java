package d.a.c.e.a.f;

import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import com.baidu.adp.lib.Disk.ops.DiskFileOperate;
import com.baidu.adp.lib.util.BdLog;
import d.a.c.e.p.l;
import java.nio.ByteBuffer;
/* loaded from: classes.dex */
public class c extends DiskFileOperate {

    /* renamed from: a  reason: collision with root package name */
    public Bitmap f38773a;

    /* renamed from: b  reason: collision with root package name */
    public BitmapFactory.Options f38774b;

    /* renamed from: c  reason: collision with root package name */
    public a f38775c;

    /* renamed from: d  reason: collision with root package name */
    public boolean f38776d;

    /* renamed from: e  reason: collision with root package name */
    public long f38777e;

    /* loaded from: classes.dex */
    public static class a {

        /* renamed from: d  reason: collision with root package name */
        public static byte f38778d = Byte.MIN_VALUE;

        /* renamed from: e  reason: collision with root package name */
        public static byte f38779e = Byte.MIN_VALUE;

        /* renamed from: a  reason: collision with root package name */
        public boolean f38780a = false;

        /* renamed from: b  reason: collision with root package name */
        public long f38781b = 0;

        /* renamed from: c  reason: collision with root package name */
        public boolean f38782c = true;

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
            if ((wrap.get() & f38778d) != 0) {
                this.f38780a = true;
            }
            this.f38781b = wrap.getLong();
            if ((wrap.get() & f38779e) != 0) {
                this.f38782c = false;
            }
            return true;
        }

        public byte[] c() {
            ByteBuffer allocate = ByteBuffer.allocate(a());
            allocate.putInt(1786600511);
            allocate.put(this.f38780a ? (byte) (f38778d | 0) : (byte) 0);
            allocate.putLong(this.f38781b);
            allocate.put(this.f38782c ? (byte) 0 : (byte) (f38779e | 0));
            allocate.flip();
            return allocate.array();
        }
    }

    public c(String str, String str2, DiskFileOperate.Action action) {
        super(str, str2, action);
        this.f38773a = null;
        this.f38774b = null;
        this.f38775c = null;
        this.f38776d = true;
        this.f38775c = new a();
    }

    public static int a(BitmapFactory.Options options, int i2, int i3) {
        int i4 = options.outHeight;
        int i5 = options.outWidth;
        int i6 = 1;
        if (i4 > i3 || i5 > i2) {
            int i7 = i4 / 2;
            int i8 = i5 / 2;
            while (i7 / i6 >= i3 && i8 / i6 >= i2) {
                i6 *= 2;
            }
        }
        return i6;
    }

    public boolean b(byte[] bArr, int i2, int i3) {
        if (bArr != null && this.f38775c.b(bArr)) {
            long j = this.f38775c.f38781b;
            if (j == 0 || j >= System.currentTimeMillis()) {
                int a2 = a.a();
                try {
                    if (this.f38774b == null) {
                        BitmapFactory.Options options = new BitmapFactory.Options();
                        this.f38774b = options;
                        options.inPreferredConfig = Bitmap.Config.RGB_565;
                    }
                    this.f38774b.inJustDecodeBounds = true;
                    BitmapFactory.decodeByteArray(bArr, a2, bArr.length - a2, this.f38774b);
                } catch (Error e2) {
                    BdLog.e(e2.getMessage());
                }
                if (!this.f38774b.mCancel && this.f38774b.outWidth != -1 && this.f38774b.outHeight != -1) {
                    this.f38774b.inSampleSize = a(this.f38774b, i2, i3);
                    this.f38774b.inJustDecodeBounds = false;
                    this.f38773a = BitmapFactory.decodeByteArray(bArr, a2, bArr.length - a2, this.f38774b);
                    return this.f38773a != null;
                }
                return false;
            }
            return false;
        }
        return false;
    }

    @Override // com.baidu.adp.lib.Disk.ops.DiskFileOperate
    public byte[] buildFormatData() {
        if (this.mData == null || !this.f38776d) {
            return null;
        }
        return this.f38775c.c();
    }

    public byte[] c() {
        int a2 = a.a();
        int length = this.mData.length - a2;
        byte[] bArr = new byte[length];
        System.arraycopy(this.mData, a2, bArr, 0, length);
        return bArr;
    }

    public boolean d() {
        return this.f38775c.f38782c;
    }

    public void e(boolean z) {
        this.f38775c.f38782c = z;
    }

    @Override // com.baidu.adp.lib.Disk.ops.DiskFileOperate
    public void endLog() {
        d.a.c.e.l.a.k(isSuccess(), System.currentTimeMillis() - this.f38777e);
    }

    public void f(boolean z) {
        this.f38776d = z;
    }

    @Override // com.baidu.adp.lib.Disk.ops.DiskFileOperate
    public boolean formatData(byte[] bArr) {
        if (bArr != null && this.f38775c.b(bArr)) {
            long j = this.f38775c.f38781b;
            if (j == 0 || j >= System.currentTimeMillis()) {
                if (this.f38774b == null) {
                    BitmapFactory.Options options = new BitmapFactory.Options();
                    this.f38774b = options;
                    options.inPreferredConfig = Bitmap.Config.RGB_565;
                }
                int a2 = a.a();
                try {
                    this.f38773a = BitmapFactory.decodeByteArray(bArr, a2, bArr.length - a2, this.f38774b);
                } catch (Error e2) {
                    BdLog.e(e2.getMessage());
                }
                return this.f38773a != null;
            }
        }
        return false;
    }

    public Bitmap getBitmap() {
        return this.f38773a;
    }

    public boolean isGif() {
        return this.f38775c.f38780a;
    }

    @Override // com.baidu.adp.lib.Disk.ops.DiskFileOperate
    public void setData(byte[] bArr) {
        super.setData(bArr);
        if (isGif() || !l.B(bArr)) {
            return;
        }
        setGif(true);
    }

    public void setGif(boolean z) {
        this.f38775c.f38780a = z;
    }

    @Override // com.baidu.adp.lib.Disk.ops.DiskFileOperate
    public void startLog() {
        this.f38777e = System.currentTimeMillis();
    }
}
