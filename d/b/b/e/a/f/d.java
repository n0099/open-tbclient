package d.b.b.e.a.f;

import com.baidu.adp.lib.Disk.ops.DiskFileOperate;
import com.baidu.adp.lib.util.BdLog;
/* loaded from: classes.dex */
public class d extends DiskFileOperate {

    /* renamed from: a  reason: collision with root package name */
    public String f41607a;

    /* renamed from: b  reason: collision with root package name */
    public String f41608b;

    public d(String str, String str2, DiskFileOperate.Action action) {
        super(str, str2, action);
        this.f41607a = null;
        this.f41608b = "UTF-8";
    }

    public String a() {
        return this.f41607a;
    }

    public void b(String str) {
        this.f41607a = str;
    }

    @Override // com.baidu.adp.lib.Disk.ops.DiskFileOperate
    public byte[] buildFormatData() {
        String str = this.f41607a;
        if (str != null) {
            try {
                return str.getBytes(this.f41608b);
            } catch (Exception e2) {
                BdLog.e(e2.getMessage());
            }
        }
        return null;
    }

    @Override // com.baidu.adp.lib.Disk.ops.DiskFileOperate
    public boolean formatData(byte[] bArr) {
        if (bArr == null) {
            return false;
        }
        try {
            this.f41607a = new String(bArr, this.f41608b);
            return true;
        } catch (Exception e2) {
            BdLog.e(e2.getMessage());
            return false;
        }
    }
}
