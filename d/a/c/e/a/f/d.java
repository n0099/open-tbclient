package d.a.c.e.a.f;

import com.baidu.adp.lib.Disk.ops.DiskFileOperate;
import com.baidu.adp.lib.util.BdLog;
/* loaded from: classes.dex */
public class d extends DiskFileOperate {

    /* renamed from: a  reason: collision with root package name */
    public String f38447a;

    /* renamed from: b  reason: collision with root package name */
    public String f38448b;

    public d(String str, String str2, DiskFileOperate.Action action) {
        super(str, str2, action);
        this.f38447a = null;
        this.f38448b = "UTF-8";
    }

    public String a() {
        return this.f38447a;
    }

    public void b(String str) {
        this.f38447a = str;
    }

    @Override // com.baidu.adp.lib.Disk.ops.DiskFileOperate
    public byte[] buildFormatData() {
        String str = this.f38447a;
        if (str != null) {
            try {
                return str.getBytes(this.f38448b);
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
            this.f38447a = new String(bArr, this.f38448b);
            return true;
        } catch (Exception e2) {
            BdLog.e(e2.getMessage());
            return false;
        }
    }
}
