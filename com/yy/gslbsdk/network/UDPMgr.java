package com.yy.gslbsdk.network;

import com.yy.gslbsdk.util.GlobalTools;
import com.yy.gslbsdk.util.LogTools;
import java.io.IOException;
import java.net.BindException;
import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.net.InetAddress;
import java.net.SocketException;
import java.net.SocketTimeoutException;
import java.util.concurrent.LinkedBlockingQueue;
/* loaded from: classes10.dex */
public class UDPMgr {
    public static final String TAG = "UDPMgr";
    public static LinkedBlockingQueue<Integer> portQueue = new LinkedBlockingQueue<>();
    public static int currentPortCounter = 0;
    public static final Object lock = new Object();

    public static synchronized int getEnablePort() {
        int intValue;
        synchronized (UDPMgr.class) {
            synchronized (lock) {
                if (portQueue.size() == 0) {
                    if (currentPortCounter == 0) {
                        intValue = GlobalTools.UDP_LOCAL_PORT;
                        currentPortCounter = intValue;
                    } else {
                        intValue = currentPortCounter + 1;
                        currentPortCounter = intValue;
                    }
                } else {
                    intValue = portQueue.poll().intValue();
                }
            }
        }
        return intValue;
    }

    /* JADX WARN: Removed duplicated region for block: B:44:0x0071 A[SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:48:0x0034 A[SYNTHETIC] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public static String queryByUDP(String str, int i, String str2) {
        int enablePort = getEnablePort();
        String str3 = null;
        try {
            try {
                try {
                    DatagramSocket datagramSocket = new DatagramSocket(enablePort);
                    DatagramPacket datagramPacket = new DatagramPacket(str2.getBytes(), str2.getBytes().length, InetAddress.getByName(str), i);
                    byte[] bArr = new byte[10240];
                    DatagramPacket datagramPacket2 = new DatagramPacket(bArr, 10240);
                    datagramSocket.setSoTimeout(GlobalTools.UDP_TIMEOUT);
                    datagramSocket.send(datagramPacket);
                    boolean z = false;
                    int i2 = 0;
                    while (!z) {
                        if (i2 > 0) {
                            try {
                                datagramSocket.send(datagramPacket);
                            } catch (SocketTimeoutException e) {
                                e = e;
                                LogTools.printError(TAG, "queryByUDP：" + e.getMessage());
                                i2++;
                                if (i2 < GlobalTools.UDP_RETRY_TIME) {
                                }
                            }
                        }
                        datagramSocket.receive(datagramPacket2);
                        if (datagramPacket2.getLength() > 0) {
                            try {
                                str3 = new String(bArr, 0, datagramPacket2.getLength());
                            } catch (SocketTimeoutException e2) {
                                e = e2;
                                z = true;
                                LogTools.printError(TAG, "queryByUDP：" + e.getMessage());
                                i2++;
                                if (i2 < GlobalTools.UDP_RETRY_TIME) {
                                    z = true;
                                }
                            }
                            z = true;
                        }
                    }
                    datagramSocket.close();
                } finally {
                    returnPort(Integer.valueOf(enablePort));
                }
            } catch (SocketException e3) {
                LogTools.printError(TAG, "queryByUDP：" + e3.getMessage());
            }
        } catch (BindException e4) {
            LogTools.printError(TAG, "queryByUDP：" + e4.getMessage());
        } catch (IOException e5) {
            LogTools.printError(TAG, "queryByUDP：" + e5.getMessage());
        }
        return str3;
    }

    public static synchronized void returnPort(Integer num) {
        synchronized (UDPMgr.class) {
            synchronized (lock) {
                if (portQueue.contains(num)) {
                    return;
                }
                portQueue.add(num);
            }
        }
    }
}
