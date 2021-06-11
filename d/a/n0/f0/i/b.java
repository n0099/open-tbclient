package d.a.n0.f0.i;

import com.baidu.tieba.dnsproxy.pbdata.DnsIpData;
import java.util.ArrayList;
import java.util.List;
/* loaded from: classes4.dex */
public class b {

    /* renamed from: a  reason: collision with root package name */
    public String f57986a;

    /* renamed from: c  reason: collision with root package name */
    public float f57988c;

    /* renamed from: b  reason: collision with root package name */
    public List<Integer> f57987b = new ArrayList();

    /* renamed from: d  reason: collision with root package name */
    public boolean f57989d = false;

    /* renamed from: e  reason: collision with root package name */
    public boolean f57990e = false;

    public static final b c(DnsIpData dnsIpData) {
        if (dnsIpData == null) {
            return null;
        }
        b bVar = new b();
        bVar.f57986a = dnsIpData.address;
        for (int i2 = 0; i2 < dnsIpData.data.size(); i2++) {
            bVar.f57987b.add(dnsIpData.data.get(i2));
        }
        bVar.b();
        return bVar;
    }

    public static final DnsIpData d(b bVar) {
        if (bVar == null) {
            return null;
        }
        DnsIpData.Builder builder = new DnsIpData.Builder();
        builder.address = bVar.f57986a;
        builder.data = new ArrayList();
        for (Integer num : bVar.f57987b) {
            builder.data.add(Integer.valueOf(num.intValue()));
        }
        return builder.build(true);
    }

    public void a(int i2) {
        this.f57987b.add(0, Integer.valueOf(i2));
        while (this.f57987b.size() > 49) {
            List<Integer> list = this.f57987b;
            list.remove(list.size() - 1);
        }
        b();
    }

    public final void b() {
        int size = this.f57987b.size();
        float f2 = 0.0f;
        if (size <= 0) {
            this.f57988c = 0.0f;
            return;
        }
        int i2 = 0;
        if (size == 1) {
            this.f57988c = this.f57987b.get(0).intValue();
            return;
        }
        float f3 = 1.0f;
        for (Integer num : this.f57987b) {
            int intValue = num.intValue();
            i2 += intValue;
            f3 *= 0.5f;
            f2 += intValue * f3;
        }
        float f4 = f2 + ((f3 * i2) / size);
        this.f57988c = f4;
        if (f4 < 0.05d) {
            if (this.f57989d) {
                return;
            }
            d.a.n0.f0.d.c().b("ip_weight_lower", this.f57986a, String.valueOf(this.f57988c));
            this.f57989d = true;
        } else if (this.f57989d && f4 > 0.5d && !this.f57990e) {
            d.a.n0.f0.d.c().b("ip_weight_lower_recover", this.f57986a, String.valueOf(this.f57988c));
            this.f57990e = true;
        }
    }
}
