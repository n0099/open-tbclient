package d.b.j0.e0.i;

import android.net.ConnectivityManager;
import android.net.NetworkInfo;
import android.net.wifi.WifiInfo;
import android.net.wifi.WifiManager;
import android.text.TextUtils;
import com.baidu.adp.lib.util.BdLog;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tieba.dnsproxy.pbdata.ConnectPointData;
import com.baidu.tieba.dnsproxy.pbdata.DnsIpData;
import com.baidu.tieba.imageProblem.httpNet.CDNIPDirectConnect;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;
/* loaded from: classes4.dex */
public class a {

    /* renamed from: a  reason: collision with root package name */
    public HashMap<String, b> f55547a = new HashMap<>();

    /* renamed from: b  reason: collision with root package name */
    public HashMap<String, b> f55548b = new HashMap<>();

    /* renamed from: c  reason: collision with root package name */
    public long f55549c;

    /* renamed from: d  reason: collision with root package name */
    public long f55550d;

    /* renamed from: e  reason: collision with root package name */
    public String f55551e;

    public static final a a(ConnectPointData connectPointData) {
        if (connectPointData == null) {
            return null;
        }
        a aVar = new a();
        aVar.f55551e = connectPointData.name;
        aVar.f55549c = connectPointData.last_connect_rate_update_time.longValue();
        aVar.f55550d = connectPointData.last_speed_data_update_time.longValue();
        for (DnsIpData dnsIpData : connectPointData.dns_ip_connect_rate) {
            b c2 = b.c(dnsIpData);
            if (c2 != null) {
                aVar.f55547a.put(c2.f55552a, c2);
            }
        }
        for (DnsIpData dnsIpData2 : connectPointData.dns_ip_speed_data) {
            b c3 = b.c(dnsIpData2);
            if (c3 != null) {
                aVar.f55548b.put(c3.f55552a, c3);
            }
        }
        return aVar;
    }

    public static final String b() {
        WifiInfo connectionInfo;
        try {
            NetworkInfo activeNetworkInfo = ((ConnectivityManager) TbadkCoreApplication.getInst().getContext().getSystemService("connectivity")).getActiveNetworkInfo();
            if (activeNetworkInfo != null) {
                String typeName = activeNetworkInfo.getTypeName();
                String extraInfo = activeNetworkInfo.getExtraInfo();
                if (!TextUtils.isEmpty(typeName)) {
                    if (TextUtils.isEmpty(extraInfo) && typeName.equalsIgnoreCase(CDNIPDirectConnect.CDNNetworkChangeReceiver.WIFI_STRING) && (connectionInfo = ((WifiManager) TbadkCoreApplication.getInst().getContext().getSystemService("wifi")).getConnectionInfo()) != null) {
                        extraInfo = connectionInfo.getBSSID();
                    }
                    if (!TextUtils.isEmpty(extraInfo)) {
                        return typeName + "_" + extraInfo;
                    }
                }
                d.b.j0.e0.d c2 = d.b.j0.e0.d.c();
                c2.a("get_connectpoint_null", typeName + "_" + extraInfo);
                return null;
            }
            return null;
        } catch (Throwable th) {
            BdLog.detailException(th);
            d.b.j0.e0.d.c().a("get_connectpoint_name", th.getMessage());
            return null;
        }
    }

    public static final ConnectPointData c(a aVar) {
        if (aVar == null) {
            return null;
        }
        ConnectPointData.Builder builder = new ConnectPointData.Builder();
        builder.name = aVar.f55551e;
        builder.last_connect_rate_update_time = Long.valueOf(aVar.f55549c);
        builder.last_speed_data_update_time = Long.valueOf(aVar.f55550d);
        builder.dns_ip_connect_rate = new ArrayList();
        builder.dns_ip_speed_data = new ArrayList();
        for (Map.Entry<String, b> entry : aVar.f55547a.entrySet()) {
            DnsIpData d2 = b.d(entry.getValue());
            if (d2 != null) {
                builder.dns_ip_connect_rate.add(d2);
            }
        }
        for (Map.Entry<String, b> entry2 : aVar.f55548b.entrySet()) {
            DnsIpData d3 = b.d(entry2.getValue());
            if (d3 != null) {
                builder.dns_ip_speed_data.add(d3);
            }
        }
        return builder.build(true);
    }
}
