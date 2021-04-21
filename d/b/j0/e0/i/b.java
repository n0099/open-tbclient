package d.b.j0.e0.i;

import com.baidu.tieba.dnsproxy.pbdata.DnsIpData;
import java.util.ArrayList;
import java.util.List;
/* loaded from: classes4.dex */
public class b {

    /* renamed from: a  reason: collision with root package name */
    public String f55552a;

    /* renamed from: c  reason: collision with root package name */
    public float f55554c;

    /* renamed from: b  reason: collision with root package name */
    public List<Integer> f55553b = new ArrayList();

    /* renamed from: d  reason: collision with root package name */
    public boolean f55555d = false;

    /* renamed from: e  reason: collision with root package name */
    public boolean f55556e = false;

    public static final b c(DnsIpData dnsIpData) {
        if (dnsIpData == null) {
            return null;
        }
        b bVar = new b();
        bVar.f55552a = dnsIpData.address;
        for (int i = 0; i < dnsIpData.data.size(); i++) {
            bVar.f55553b.add(dnsIpData.data.get(i));
        }
        bVar.b();
        return bVar;
    }

    public static final DnsIpData d(b bVar) {
        if (bVar == null) {
            return null;
        }
        DnsIpData.Builder builder = new DnsIpData.Builder();
        builder.address = bVar.f55552a;
        builder.data = new ArrayList();
        for (Integer num : bVar.f55553b) {
            builder.data.add(Integer.valueOf(num.intValue()));
        }
        return builder.build(true);
    }

    public void a(int i) {
        this.f55553b.add(0, Integer.valueOf(i));
        while (this.f55553b.size() > 49) {
            List<Integer> list = this.f55553b;
            list.remove(list.size() - 1);
        }
        b();
    }

    public final void b() {
        int size = this.f55553b.size();
        float f2 = 0.0f;
        if (size <= 0) {
            this.f55554c = 0.0f;
            return;
        }
        int i = 0;
        if (size == 1) {
            this.f55554c = this.f55553b.get(0).intValue();
            return;
        }
        float f3 = 1.0f;
        for (Integer num : this.f55553b) {
            int intValue = num.intValue();
            i += intValue;
            f3 *= 0.5f;
            f2 += intValue * f3;
        }
        float f4 = f2 + ((f3 * i) / size);
        this.f55554c = f4;
        if (f4 < 0.05d) {
            if (this.f55555d) {
                return;
            }
            d.b.j0.e0.d.c().b("ip_weight_lower", this.f55552a, String.valueOf(this.f55554c));
            this.f55555d = true;
        } else if (this.f55555d && f4 > 0.5d && !this.f55556e) {
            d.b.j0.e0.d.c().b("ip_weight_lower_recover", this.f55552a, String.valueOf(this.f55554c));
            this.f55556e = true;
        }
    }
}
