package d.b.i0.e0.i;

import com.baidu.tieba.dnsproxy.pbdata.DnsIpData;
import java.util.ArrayList;
import java.util.List;
/* loaded from: classes4.dex */
public class b {

    /* renamed from: a  reason: collision with root package name */
    public String f54248a;

    /* renamed from: c  reason: collision with root package name */
    public float f54250c;

    /* renamed from: b  reason: collision with root package name */
    public List<Integer> f54249b = new ArrayList();

    /* renamed from: d  reason: collision with root package name */
    public boolean f54251d = false;

    /* renamed from: e  reason: collision with root package name */
    public boolean f54252e = false;

    public static final b c(DnsIpData dnsIpData) {
        if (dnsIpData == null) {
            return null;
        }
        b bVar = new b();
        bVar.f54248a = dnsIpData.address;
        for (int i = 0; i < dnsIpData.data.size(); i++) {
            bVar.f54249b.add(dnsIpData.data.get(i));
        }
        bVar.b();
        return bVar;
    }

    public static final DnsIpData d(b bVar) {
        if (bVar == null) {
            return null;
        }
        DnsIpData.Builder builder = new DnsIpData.Builder();
        builder.address = bVar.f54248a;
        builder.data = new ArrayList();
        for (Integer num : bVar.f54249b) {
            builder.data.add(Integer.valueOf(num.intValue()));
        }
        return builder.build(true);
    }

    public void a(int i) {
        this.f54249b.add(0, Integer.valueOf(i));
        while (this.f54249b.size() > 49) {
            List<Integer> list = this.f54249b;
            list.remove(list.size() - 1);
        }
        b();
    }

    public final void b() {
        int size = this.f54249b.size();
        float f2 = 0.0f;
        if (size <= 0) {
            this.f54250c = 0.0f;
            return;
        }
        int i = 0;
        if (size == 1) {
            this.f54250c = this.f54249b.get(0).intValue();
            return;
        }
        float f3 = 1.0f;
        for (Integer num : this.f54249b) {
            int intValue = num.intValue();
            i += intValue;
            f3 *= 0.5f;
            f2 += intValue * f3;
        }
        float f4 = f2 + ((f3 * i) / size);
        this.f54250c = f4;
        if (f4 < 0.05d) {
            if (this.f54251d) {
                return;
            }
            d.b.i0.e0.d.c().b("ip_weight_lower", this.f54248a, String.valueOf(this.f54250c));
            this.f54251d = true;
        } else if (this.f54251d && f4 > 0.5d && !this.f54252e) {
            d.b.i0.e0.d.c().b("ip_weight_lower_recover", this.f54248a, String.valueOf(this.f54250c));
            this.f54252e = true;
        }
    }
}
