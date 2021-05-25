package tv.athena.revenue.adapter;

import com.yy.mobile.framework.revenuesdk.baseapi.ProtocolType;
import d.r.b.a.a.f.d.d;
import i.a.a.a.b;
/* loaded from: classes8.dex */
public enum DataProtocolAdapterFactory {
    HTTP_PROTOCOL("tv.athena.revenue.http.HttpProtocolAdapter"),
    SIGNAL_PROTOCOL("tv.athena.revenue.signal.SignalProtocolAdapter");
    
    public final String TAG = "DataSenderAdapterFactory";
    public final String clazz;
    public d.r.b.a.a.f.c.a dataProtocolAdapter;

    /* loaded from: classes8.dex */
    public static /* synthetic */ class a {

        /* renamed from: a  reason: collision with root package name */
        public static final /* synthetic */ int[] f69592a;

        static {
            int[] iArr = new int[ProtocolType.values().length];
            f69592a = iArr;
            try {
                iArr[ProtocolType.HTTP.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                f69592a[ProtocolType.SERVICE.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
        }
    }

    DataProtocolAdapterFactory(String str) {
        this.clazz = str;
    }

    private d.r.b.a.a.f.c.a getDataProtocolAdapter() {
        d.r.b.a.a.f.c.a aVar = this.dataProtocolAdapter;
        if (aVar != null) {
            return aVar;
        }
        initDataProtocolAdapter();
        return this.dataProtocolAdapter;
    }

    private void initDataProtocolAdapter() {
        try {
            this.dataProtocolAdapter = (d.r.b.a.a.f.c.a) Class.forName(this.clazz).newInstance();
        } catch (Exception e2) {
            d.e("DataSenderAdapterFactory", "initDataSenderAdapter e:" + e2.getLocalizedMessage(), new Object[0]);
            this.dataProtocolAdapter = new b();
        }
    }

    public static d.r.b.a.a.f.c.a valueOf(ProtocolType protocolType) {
        int i2 = a.f69592a[protocolType.ordinal()];
        if (i2 != 1) {
            if (i2 != 2) {
                return new b();
            }
            return SIGNAL_PROTOCOL.getDataProtocolAdapter();
        }
        return HTTP_PROTOCOL.getDataProtocolAdapter();
    }
}
