package d.a.n0.p0.d.a.b;

import com.baidu.adp.lib.util.StringUtils;
import com.baidu.tbadk.TbConfig;
import d.a.c.e.d.l;
/* loaded from: classes4.dex */
public class a {

    /* renamed from: a  reason: collision with root package name */
    public l<byte[]> f58037a;

    public a() {
        b();
    }

    public byte[] a(String str) {
        byte[] bArr;
        l<byte[]> lVar = this.f58037a;
        l.b<byte[]> h2 = (lVar == null || str == null) ? null : lVar.h(str);
        if (h2 == null || (bArr = h2.f38542b) == null) {
            return null;
        }
        return bArr;
    }

    public final void b() {
        if (this.f58037a == null) {
            this.f58037a = d.a.m0.r.r.a.f().d("tb.tbtiel_level_info");
        }
    }

    public void c(String str, byte[] bArr) {
        if (StringUtils.isNull(str)) {
            return;
        }
        b();
        this.f58037a.e(str, bArr, TbConfig.MILLS_7DAYS);
    }
}
