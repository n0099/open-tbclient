package com.yy.hiidostatis.message.sender;

import com.yy.hiidostatis.api.HiidoSDK;
import com.yy.hiidostatis.inner.util.log.L;
import com.yy.hiidostatis.message.HostManager;
import com.yy.hiidostatis.message.bean.Message;
import java.io.IOException;
import java.net.InetAddress;
import java.net.UnknownHostException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.concurrent.atomic.AtomicLong;
import okhttp3.Call;
import okhttp3.Dns;
/* loaded from: classes9.dex */
public class HostInfo implements HostManager {
    public static final int CHANGE_DNS_MIN_ERR_COUNT = 30;
    public static final long CHANGE_DNS_MIN_INTERVAL = 5000;
    public static final String TEST_HOST = "datatest.bigda.com";
    public volatile boolean useIp = false;
    public AtomicInteger errorCount = new AtomicInteger(0);
    public AtomicLong preChangeTime = new AtomicLong();
    public volatile String testServer = TEST_HOST;
    public volatile List<InetAddress> ips = trans(HiidoSDK.getHiidoIps());

    private boolean isDebug() {
        return HiidoSDK.isDebugMode;
    }

    private List<InetAddress> trans(String[] strArr) {
        ArrayList arrayList = new ArrayList(strArr.length);
        for (String str : strArr) {
            try {
                arrayList.add(InetAddress.getByName(str));
            } catch (UnknownHostException e) {
                e.printStackTrace();
            }
        }
        Collections.shuffle(arrayList);
        return arrayList;
    }

    @Override // com.yy.hiidostatis.message.HostManager
    public String getHost(Message message) {
        if (isDebug()) {
            return this.testServer;
        }
        return HiidoSDK.getHiidoHost();
    }

    @Override // com.yy.hiidostatis.message.HostManager
    public List<InetAddress> lookup(String str) throws UnknownHostException {
        if (this.useIp && !isDebug()) {
            L.debug(this, "Host:%s", this.ips.get(0));
            return new ArrayList(this.ips);
        }
        L.debug(this, "Host:%s", str);
        return Dns.SYSTEM.lookup(str);
    }

    @Override // com.yy.hiidostatis.message.HostManager
    public void onSuccess(Call call) {
        if (this.errorCount.decrementAndGet() < 0) {
            this.errorCount.set(0);
        }
    }

    @Override // com.yy.hiidostatis.message.HostManager
    public synchronized void onFailure(Call call, IOException iOException) {
        if (this.errorCount.incrementAndGet() > 30 && System.currentTimeMillis() - this.preChangeTime.get() > 5000) {
            if (this.useIp) {
                if (this.ips.size() == 1) {
                    this.useIp = false;
                    this.ips = trans(HiidoSDK.getHiidoIps());
                } else {
                    this.ips.remove(0);
                }
            } else {
                this.useIp = true;
            }
        }
    }
}
