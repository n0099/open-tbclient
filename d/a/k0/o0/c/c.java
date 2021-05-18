package d.a.k0.o0.c;

import com.baidu.adp.lib.util.StringUtils;
import com.baidu.tbadk.TbConfig;
import com.baidu.tbadk.core.TbadkCoreApplication;
import d.a.c.e.d.l;
/* loaded from: classes4.dex */
public class c {

    /* renamed from: a  reason: collision with root package name */
    public d.a.c.e.d.l<byte[]> f57878a;

    public c() {
        b();
    }

    public byte[] a(String str) {
        byte[] bArr;
        if (StringUtils.isNull(str)) {
            return null;
        }
        String str2 = str + "/" + TbadkCoreApplication.getCurrentAccount();
        d.a.c.e.d.l<byte[]> lVar = this.f57878a;
        l.b<byte[]> h2 = lVar != null ? lVar.h(str2) : null;
        if (h2 == null || (bArr = h2.f38878b) == null) {
            return null;
        }
        return bArr;
    }

    public void b() {
        if (this.f57878a == null) {
            this.f57878a = d.a.j0.r.r.a.f().d("tb.forum_member_info");
        }
    }

    public void c(String str, byte[] bArr) {
        String currentAccount = TbadkCoreApplication.getCurrentAccount();
        if (StringUtils.isNull(str)) {
            return;
        }
        b();
        d.a.c.e.d.l<byte[]> lVar = this.f57878a;
        lVar.e(str + "/" + currentAccount, bArr, TbConfig.MILLS_7DAYS);
    }
}
