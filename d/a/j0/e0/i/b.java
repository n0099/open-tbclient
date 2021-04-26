package d.a.j0.e0.i;

import com.baidu.tieba.dnsproxy.pbdata.DnsIpData;
import java.util.ArrayList;
import java.util.List;
/* loaded from: classes4.dex */
public class b {

    /* renamed from: a  reason: collision with root package name */
    public String f53400a;

    /* renamed from: c  reason: collision with root package name */
    public float f53402c;

    /* renamed from: b  reason: collision with root package name */
    public List<Integer> f53401b = new ArrayList();

    /* renamed from: d  reason: collision with root package name */
    public boolean f53403d = false;

    /* renamed from: e  reason: collision with root package name */
    public boolean f53404e = false;

    public static final b c(DnsIpData dnsIpData) {
        if (dnsIpData == null) {
            return null;
        }
        b bVar = new b();
        bVar.f53400a = dnsIpData.address;
        for (int i2 = 0; i2 < dnsIpData.data.size(); i2++) {
            bVar.f53401b.add(dnsIpData.data.get(i2));
        }
        bVar.b();
        return bVar;
    }

    public static final DnsIpData d(b bVar) {
        if (bVar == null) {
            return null;
        }
        DnsIpData.Builder builder = new DnsIpData.Builder();
        builder.address = bVar.f53400a;
        builder.data = new ArrayList();
        for (Integer num : bVar.f53401b) {
            builder.data.add(Integer.valueOf(num.intValue()));
        }
        return builder.build(true);
    }

    public void a(int i2) {
        this.f53401b.add(0, Integer.valueOf(i2));
        while (this.f53401b.size() > 49) {
            List<Integer> list = this.f53401b;
            list.remove(list.size() - 1);
        }
        b();
    }

    public final void b() {
        int size = this.f53401b.size();
        float f2 = 0.0f;
        if (size <= 0) {
            this.f53402c = 0.0f;
            return;
        }
        int i2 = 0;
        if (size == 1) {
            this.f53402c = this.f53401b.get(0).intValue();
            return;
        }
        float f3 = 1.0f;
        for (Integer num : this.f53401b) {
            int intValue = num.intValue();
            i2 += intValue;
            f3 *= 0.5f;
            f2 += intValue * f3;
        }
        float f4 = f2 + ((f3 * i2) / size);
        this.f53402c = f4;
        if (f4 < 0.05d) {
            if (this.f53403d) {
                return;
            }
            d.a.j0.e0.d.c().b("ip_weight_lower", this.f53400a, String.valueOf(this.f53402c));
            this.f53403d = true;
        } else if (this.f53403d && f4 > 0.5d && !this.f53404e) {
            d.a.j0.e0.d.c().b("ip_weight_lower_recover", this.f53400a, String.valueOf(this.f53402c));
            this.f53404e = true;
        }
    }
}
