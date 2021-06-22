package d.a.o0.p0.a;

import com.baidu.adp.lib.util.StringUtils;
import com.baidu.tbadk.TbConfig;
import d.a.c.e.d.l;
/* loaded from: classes4.dex */
public class d {

    /* renamed from: a  reason: collision with root package name */
    public l<byte[]> f61758a;

    public d() {
        b();
    }

    public byte[] a(String str) {
        byte[] bArr;
        l<byte[]> lVar = this.f61758a;
        l.b<byte[]> h2 = (lVar == null || str == null) ? null : lVar.h(str);
        if (h2 == null || (bArr = h2.f42298b) == null) {
            return null;
        }
        return bArr;
    }

    public void b() {
        if (this.f61758a == null) {
            this.f61758a = d.a.n0.r.r.a.f().d("tb.bawu_team_info");
        }
    }

    public void c(String str, byte[] bArr) {
        if (StringUtils.isNull(str)) {
            return;
        }
        b();
        this.f61758a.e(str, bArr, TbConfig.MILLS_7DAYS);
    }
}
