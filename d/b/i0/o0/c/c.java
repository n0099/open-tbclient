package d.b.i0.o0.c;

import com.baidu.adp.lib.util.StringUtils;
import com.baidu.tbadk.TbConfig;
import com.baidu.tbadk.core.TbadkCoreApplication;
import d.b.c.e.d.l;
/* loaded from: classes4.dex */
public class c {

    /* renamed from: a  reason: collision with root package name */
    public d.b.c.e.d.l<byte[]> f58724a;

    public c() {
        b();
    }

    public byte[] a(String str) {
        byte[] bArr;
        if (StringUtils.isNull(str)) {
            return null;
        }
        String str2 = str + "/" + TbadkCoreApplication.getCurrentAccount();
        d.b.c.e.d.l<byte[]> lVar = this.f58724a;
        l.b<byte[]> h2 = lVar != null ? lVar.h(str2) : null;
        if (h2 == null || (bArr = h2.f42199b) == null) {
            return null;
        }
        return bArr;
    }

    public void b() {
        if (this.f58724a == null) {
            this.f58724a = d.b.h0.r.r.a.f().d("tb.forum_member_info");
        }
    }

    public void c(String str, byte[] bArr) {
        String currentAccount = TbadkCoreApplication.getCurrentAccount();
        if (StringUtils.isNull(str)) {
            return;
        }
        b();
        d.b.c.e.d.l<byte[]> lVar = this.f58724a;
        lVar.e(str + "/" + currentAccount, bArr, TbConfig.MILLS_7DAYS);
    }
}
