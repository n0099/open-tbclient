package com.yy.gslbsdk.network;

import androidx.core.view.InputDeviceCompat;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptable;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptorStorage;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
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
/* loaded from: classes8.dex */
public class UDPMgr {
    public static /* synthetic */ Interceptable $ic = null;
    public static final String TAG = "UDPMgr";
    public static int currentPortCounter;
    public static final Object lock;
    public static LinkedBlockingQueue<Integer> portQueue;
    public transient /* synthetic */ FieldHolder $fh;

    static {
        InterceptResult invokeClinit;
        ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
        if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(1822463415, "Lcom/yy/gslbsdk/network/UDPMgr;")) != null) {
            Interceptable interceptable = invokeClinit.interceptor;
            if (interceptable != null) {
                $ic = interceptable;
            }
            if ((invokeClinit.flags & 1) != 0) {
                classClinitInterceptable.invokePostClinit(1822463415, "Lcom/yy/gslbsdk/network/UDPMgr;");
                return;
            }
        }
        portQueue = new LinkedBlockingQueue<>();
        currentPortCounter = 0;
        lock = new Object();
    }

    public UDPMgr() {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            interceptable.invokeUnInit(65537, newInitContext);
            int i2 = newInitContext.flag;
            if ((i2 & 1) != 0) {
                int i3 = i2 & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65537, newInitContext);
            }
        }
    }

    public static synchronized int getEnablePort() {
        InterceptResult invokeV;
        int intValue;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(65538, null)) == null) {
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
        return invokeV.intValue;
    }

    /* JADX WARN: Removed duplicated region for block: B:50:0x0075 A[SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:54:0x0038 A[SYNTHETIC] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public static String queryByUDP(String str, int i2, String str2) {
        InterceptResult invokeLIL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLIL = interceptable.invokeLIL(65539, null, str, i2, str2)) == null) {
            int enablePort = getEnablePort();
            String str3 = null;
            try {
                try {
                    try {
                        try {
                            DatagramSocket datagramSocket = new DatagramSocket(enablePort);
                            DatagramPacket datagramPacket = new DatagramPacket(str2.getBytes(), str2.getBytes().length, InetAddress.getByName(str), i2);
                            byte[] bArr = new byte[10240];
                            DatagramPacket datagramPacket2 = new DatagramPacket(bArr, 10240);
                            datagramSocket.setSoTimeout(GlobalTools.UDP_TIMEOUT);
                            datagramSocket.send(datagramPacket);
                            boolean z = false;
                            int i3 = 0;
                            while (!z) {
                                if (i3 > 0) {
                                    try {
                                        datagramSocket.send(datagramPacket);
                                    } catch (SocketTimeoutException e2) {
                                        e = e2;
                                        LogTools.printError(TAG, "queryByUDP：" + e.getMessage());
                                        i3++;
                                        if (i3 < GlobalTools.UDP_RETRY_TIME) {
                                        }
                                    }
                                }
                                datagramSocket.receive(datagramPacket2);
                                if (datagramPacket2.getLength() > 0) {
                                    try {
                                        str3 = new String(bArr, 0, datagramPacket2.getLength());
                                    } catch (SocketTimeoutException e3) {
                                        e = e3;
                                        z = true;
                                        LogTools.printError(TAG, "queryByUDP：" + e.getMessage());
                                        i3++;
                                        if (i3 < GlobalTools.UDP_RETRY_TIME) {
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
                    } catch (BindException e4) {
                        LogTools.printError(TAG, "queryByUDP：" + e4.getMessage());
                    }
                } catch (SocketException e5) {
                    LogTools.printError(TAG, "queryByUDP：" + e5.getMessage());
                }
            } catch (IOException e6) {
                LogTools.printError(TAG, "queryByUDP：" + e6.getMessage());
            }
            return str3;
        }
        return (String) invokeLIL.objValue;
    }

    public static synchronized void returnPort(Integer num) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(InputDeviceCompat.SOURCE_TRACKBALL, null, num) == null) {
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
}
