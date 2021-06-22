package d.a.o0.f0.i;

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
    public HashMap<String, b> f58106a = new HashMap<>();

    /* renamed from: b  reason: collision with root package name */
    public HashMap<String, b> f58107b = new HashMap<>();

    /* renamed from: c  reason: collision with root package name */
    public long f58108c;

    /* renamed from: d  reason: collision with root package name */
    public long f58109d;

    /* renamed from: e  reason: collision with root package name */
    public String f58110e;

    public static final a a(ConnectPointData connectPointData) {
        if (connectPointData == null) {
            return null;
        }
        a aVar = new a();
        aVar.f58110e = connectPointData.name;
        aVar.f58108c = connectPointData.last_connect_rate_update_time.longValue();
        aVar.f58109d = connectPointData.last_speed_data_update_time.longValue();
        for (DnsIpData dnsIpData : connectPointData.dns_ip_connect_rate) {
            b c2 = b.c(dnsIpData);
            if (c2 != null) {
                aVar.f58106a.put(c2.f58111a, c2);
            }
        }
        for (DnsIpData dnsIpData2 : connectPointData.dns_ip_speed_data) {
            b c3 = b.c(dnsIpData2);
            if (c3 != null) {
                aVar.f58107b.put(c3.f58111a, c3);
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
                d.a.o0.f0.d c2 = d.a.o0.f0.d.c();
                c2.a("get_connectpoint_null", typeName + "_" + extraInfo);
                return null;
            }
            return null;
        } catch (Throwable th) {
            BdLog.detailException(th);
            d.a.o0.f0.d.c().a("get_connectpoint_name", th.getMessage());
            return null;
        }
    }

    public static final ConnectPointData c(a aVar) {
        if (aVar == null) {
            return null;
        }
        ConnectPointData.Builder builder = new ConnectPointData.Builder();
        builder.name = aVar.f58110e;
        builder.last_connect_rate_update_time = Long.valueOf(aVar.f58108c);
        builder.last_speed_data_update_time = Long.valueOf(aVar.f58109d);
        builder.dns_ip_connect_rate = new ArrayList();
        builder.dns_ip_speed_data = new ArrayList();
        for (Map.Entry<String, b> entry : aVar.f58106a.entrySet()) {
            DnsIpData d2 = b.d(entry.getValue());
            if (d2 != null) {
                builder.dns_ip_connect_rate.add(d2);
            }
        }
        for (Map.Entry<String, b> entry2 : aVar.f58107b.entrySet()) {
            DnsIpData d3 = b.d(entry2.getValue());
            if (d3 != null) {
                builder.dns_ip_speed_data.add(d3);
            }
        }
        return builder.build(true);
    }
}
