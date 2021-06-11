package d.a.c.e.a.f;

import com.baidu.adp.lib.Disk.ops.DiskFileOperate;
import com.baidu.adp.lib.util.BdLog;
/* loaded from: classes.dex */
public class d extends DiskFileOperate {

    /* renamed from: a  reason: collision with root package name */
    public String f42100a;

    /* renamed from: b  reason: collision with root package name */
    public String f42101b;

    public d(String str, String str2, DiskFileOperate.Action action) {
        super(str, str2, action);
        this.f42100a = null;
        this.f42101b = "UTF-8";
    }

    public String a() {
        return this.f42100a;
    }

    public void b(String str) {
        this.f42100a = str;
    }

    @Override // com.baidu.adp.lib.Disk.ops.DiskFileOperate
    public byte[] buildFormatData() {
        String str = this.f42100a;
        if (str != null) {
            try {
                return str.getBytes(this.f42101b);
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
            this.f42100a = new String(bArr, this.f42101b);
            return true;
        } catch (Exception e2) {
            BdLog.e(e2.getMessage());
            return false;
        }
    }
}
