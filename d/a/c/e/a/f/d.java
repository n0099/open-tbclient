package d.a.c.e.a.f;

import com.baidu.adp.lib.Disk.ops.DiskFileOperate;
import com.baidu.adp.lib.util.BdLog;
/* loaded from: classes.dex */
public class d extends DiskFileOperate {

    /* renamed from: a  reason: collision with root package name */
    public String f39538a;

    /* renamed from: b  reason: collision with root package name */
    public String f39539b;

    public d(String str, String str2, DiskFileOperate.Action action) {
        super(str, str2, action);
        this.f39538a = null;
        this.f39539b = "UTF-8";
    }

    public String a() {
        return this.f39538a;
    }

    public void b(String str) {
        this.f39538a = str;
    }

    @Override // com.baidu.adp.lib.Disk.ops.DiskFileOperate
    public byte[] buildFormatData() {
        String str = this.f39538a;
        if (str != null) {
            try {
                return str.getBytes(this.f39539b);
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
            this.f39538a = new String(bArr, this.f39539b);
            return true;
        } catch (Exception e2) {
            BdLog.e(e2.getMessage());
            return false;
        }
    }
}
