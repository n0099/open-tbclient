package d.a.c.e.a.f;

import com.baidu.adp.gif.NSGif;
import com.baidu.adp.lib.Disk.ops.DiskFileOperate;
/* loaded from: classes.dex */
public class a extends DiskFileOperate {

    /* renamed from: a  reason: collision with root package name */
    public NSGif f38435a;

    public a(String str, String str2, DiskFileOperate.Action action) {
        super(str, str2, action);
        this.f38435a = null;
    }

    public NSGif a() {
        return this.f38435a;
    }

    @Override // com.baidu.adp.lib.Disk.ops.DiskFileOperate
    public boolean formatData(byte[] bArr) {
        if (bArr != null && NSGif.f2139f) {
            NSGif f2 = NSGif.f(bArr, 0, bArr.length);
            this.f38435a = f2;
            if (f2 != null) {
                return true;
            }
        }
        return false;
    }
}
