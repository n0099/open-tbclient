package tv.athena.revenue.adapter;

import com.yy.mobile.framework.revenuesdk.baseapi.ProtocolType;
import d.r.b.a.a.f.c.b;
import d.r.b.a.a.f.d.d;
import i.a.a.a.c;
/* loaded from: classes8.dex */
public enum DataSenderAdapterFactory {
    HTTP_SENDER("tv.athena.revenue.http.HttpDataSenderAdapter"),
    SIGNAL_SENDER("tv.athena.revenue.signal.SignalDataSenderAdapter");
    
    public final String TAG = "DataSenderAdapterFactory";
    public final String clazz;
    public b dataSenderAdapter;

    /* loaded from: classes8.dex */
    public static /* synthetic */ class a {

        /* renamed from: a  reason: collision with root package name */
        public static final /* synthetic */ int[] f69593a;

        static {
            int[] iArr = new int[ProtocolType.values().length];
            f69593a = iArr;
            try {
                iArr[ProtocolType.HTTP.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                f69593a[ProtocolType.SERVICE.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
        }
    }

    DataSenderAdapterFactory(String str) {
        this.clazz = str;
    }

    private b getDataSenderAdapterImpl() {
        b bVar = this.dataSenderAdapter;
        if (bVar != null) {
            return bVar;
        }
        initDataSenderAdapter();
        return this.dataSenderAdapter;
    }

    private void initDataSenderAdapter() {
        try {
            this.dataSenderAdapter = (b) Class.forName(this.clazz).newInstance();
        } catch (Exception e2) {
            d.e("DataSenderAdapterFactory", "initDataSenderAdapter e:" + e2.getLocalizedMessage(), new Object[0]);
            this.dataSenderAdapter = new c();
        }
    }

    public static b valueOf(ProtocolType protocolType) {
        int i2 = a.f69593a[protocolType.ordinal()];
        if (i2 != 1) {
            if (i2 != 2) {
                return new c();
            }
            return SIGNAL_SENDER.getDataSenderAdapterImpl();
        }
        return HTTP_SENDER.getDataSenderAdapterImpl();
    }
}
