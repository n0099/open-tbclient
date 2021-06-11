package i.a.a.a;

import com.yy.mobile.framework.revenuesdk.baseapi.data.DataSenderConfig;
import com.yy.mobile.framework.revenuesdk.baseapi.data.IDataSenderAdapter;
import com.yy.mobile.framework.revenuesdk.baseapi.log.RLog;
import java.util.ArrayList;
import tv.athena.revenue.http.HttpDataSenderAdapter;
/* loaded from: classes8.dex */
public class a implements IDataSenderAdapter {

    /* renamed from: a  reason: collision with root package name */
    public IDataSenderAdapter f72020a;

    /* renamed from: b  reason: collision with root package name */
    public IDataSenderAdapter f72021b;

    public a(IDataSenderAdapter iDataSenderAdapter) {
        RLog.debug("DataSenderAdapter", "DataSenderAdapter construct");
        this.f72020a = iDataSenderAdapter;
    }

    @Override // com.yy.mobile.framework.revenuesdk.baseapi.data.IDataSenderAdapter
    public void init(DataSenderConfig dataSenderConfig) {
        RLog.debug("DataSenderAdapter", "DataSenderAdapter init");
        IDataSenderAdapter iDataSenderAdapter = this.f72020a;
        if (iDataSenderAdapter == null) {
            HttpDataSenderAdapter httpDataSenderAdapter = new HttpDataSenderAdapter();
            this.f72021b = httpDataSenderAdapter;
            httpDataSenderAdapter.init(dataSenderConfig);
            return;
        }
        iDataSenderAdapter.init(dataSenderConfig);
    }

    @Override // com.yy.mobile.framework.revenuesdk.baseapi.data.IRevenueDataSender
    public void sendData(int i2, int i3, String str, ArrayList<Integer> arrayList, byte[] bArr) {
        IDataSenderAdapter iDataSenderAdapter = this.f72020a;
        if (iDataSenderAdapter != null) {
            iDataSenderAdapter.sendData(i2, i3, str, arrayList, bArr);
            return;
        }
        IDataSenderAdapter iDataSenderAdapter2 = this.f72021b;
        if (iDataSenderAdapter2 != null) {
            iDataSenderAdapter2.sendData(i2, i3, str, arrayList, bArr);
        } else {
            RLog.error("DataSenderAdapter", "sendData senderAdapter is null ", new Object[0]);
        }
    }
}
