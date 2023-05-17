package com.yy.gslbsdk.protocol;

import com.yy.gslbsdk.util.LogTools;
import java.net.InetAddress;
import java.util.LinkedList;
/* loaded from: classes10.dex */
public class LocalDNSProtocolMgr {
    public static final String TAG = "LocalDNSProtocolMgr";

    public static DnsInfo requestProtocol(String str) {
        LinkedList<String> linkedList = new LinkedList<>();
        try {
            InetAddress[] allByName = InetAddress.getAllByName(str);
            if (allByName != null && allByName.length > 0) {
                for (InetAddress inetAddress : allByName) {
                    byte[] address = inetAddress.getAddress();
                    if (address != null && address.length == 4) {
                        linkedList.add(inetAddress.getHostAddress());
                    }
                }
            }
        } catch (Exception e) {
            LogTools.printError(TAG, "LocalDNSProtocolMgr.requestProtocol() exception:" + e.getMessage());
        }
        if (linkedList.isEmpty()) {
            return null;
        }
        DnsInfo dnsInfo = new DnsInfo();
        dnsInfo.setHost(str);
        dnsInfo.setIps(linkedList);
        dnsInfo.setTtl(0);
        return dnsInfo;
    }
}
