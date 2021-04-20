package d.b.i0.o0.a;

import com.baidu.adp.lib.util.StringUtils;
import com.baidu.tbadk.TbConfig;
import d.b.c.e.d.l;
/* loaded from: classes4.dex */
public class d {

    /* renamed from: a  reason: collision with root package name */
    public l<byte[]> f58682a;

    public d() {
        b();
    }

    public byte[] a(String str) {
        byte[] bArr;
        l<byte[]> lVar = this.f58682a;
        l.b<byte[]> h2 = (lVar == null || str == null) ? null : lVar.h(str);
        if (h2 == null || (bArr = h2.f42199b) == null) {
            return null;
        }
        return bArr;
    }

    public void b() {
        if (this.f58682a == null) {
            this.f58682a = d.b.h0.r.r.a.f().d("tb.bawu_team_info");
        }
    }

    public void c(String str, byte[] bArr) {
        if (StringUtils.isNull(str)) {
            return;
        }
        b();
        this.f58682a.e(str, bArr, TbConfig.MILLS_7DAYS);
    }
}
