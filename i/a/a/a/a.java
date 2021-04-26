package i.a.a.a;

import com.yy.mobile.framework.revenuesdk.baseapi.ProtocolType;
import d.r.b.a.a.f.d.d;
import java.util.ArrayList;
import tv.athena.revenue.adapter.DataSenderAdapterFactory;
/* loaded from: classes7.dex */
public class a implements d.r.b.a.a.f.c.b {

    /* renamed from: a  reason: collision with root package name */
    public d.r.b.a.a.f.c.b f68041a;

    /* renamed from: b  reason: collision with root package name */
    public d.r.b.a.a.f.c.b f68042b;

    public a(d.r.b.a.a.f.c.b bVar) {
        d.b("DataSenderAdapter", "DataSenderAdapter construct");
        this.f68041a = bVar;
    }

    @Override // d.r.b.a.a.f.c.b
    public void init(String str, String str2, String str3, String str4, ProtocolType protocolType, int i2) {
        d.b("DataSenderAdapter", "DataSenderAdapter init");
        d.r.b.a.a.f.c.b bVar = this.f68041a;
        if (bVar == null) {
            d.r.b.a.a.f.c.b valueOf = DataSenderAdapterFactory.valueOf(protocolType);
            this.f68042b = valueOf;
            valueOf.init(str, str2, str3, str4, protocolType, i2);
            return;
        }
        bVar.init(str, str2, str3, str4, protocolType, i2);
    }

    @Override // d.r.b.a.a.f.c.d
    public void sendData(int i2, String str, ArrayList<Integer> arrayList, byte[] bArr) {
        d.r.b.a.a.f.c.b bVar = this.f68041a;
        if (bVar != null) {
            bVar.sendData(i2, str, arrayList, bArr);
            return;
        }
        d.r.b.a.a.f.c.b bVar2 = this.f68042b;
        if (bVar2 != null) {
            bVar2.sendData(i2, str, arrayList, bArr);
        } else {
            d.e("DataSenderAdapter", "sendData senderAdapter is null ", new Object[0]);
        }
    }
}
