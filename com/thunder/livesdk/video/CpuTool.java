package com.thunder.livesdk.video;

import android.os.Build;
import android.os.Process;
import com.thunder.livesdk.log.ThunderLog;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.lang.reflect.InvocationTargetException;
import java.util.ArrayList;
import java.util.List;
/* loaded from: classes4.dex */
public class CpuTool {
    public static final int HZ = 100;
    private static final String TAG = "CPUTool";
    private static final String kCpuInfoCurFreqFilePath = "/sys/devices/system/cpu/cpu0/cpufreq/scaling_cur_freq";
    private static final String kCpuInfoMaxFreqFilePath = "/sys/devices/system/cpu/cpu0/cpufreq/cpuinfo_max_freq";
    private static final String kCpuInfoMinFreqFilePath = "/sys/devices/system/cpu/cpu0/cpufreq/cpuinfo_min_freq";
    public static final String OS_VERSION = Build.VERSION.RELEASE;
    public static final String[] TOP = {"/system/bin/top", "-d", "1", "-m", "6"};
    public static int mTopPeriod = 9;
    public static int count = 0;
    public static int mRefDeviceJiffies = 0;
    public static int mAppCpuRate = 0;
    public static int mDeviceCpuRate = 0;
    public static int selfProcessPid = Process.myPid();
    public static int maxCpuFreq = 0;
    public static int minCpuFreq = 0;
    private static int mHiidoAppCpuRate = -1;
    private static List<Integer> mHiidoAppCpuRateList = new ArrayList();
    private static CpuUpTimeInfo mCpuUpTimeInfo = new CpuUpTimeInfo();
    private static JiffiesCount mJiffiesCount = new JiffiesCount();
    private static JiffiesCount mJiffiesTopCount = new JiffiesCount();
    public static int mCpuCores = getCpuCores();

    /* loaded from: classes4.dex */
    public static class CpuUpTimeInfo {
        public double lastActiveTime = 0.0d;
        public double curActiveTime = 0.0d;
        public double deltaActiveTime = 0.0d;
        public double lastIdleTime = 0.0d;
        public double curIdleTime = 0.0d;
        public double deltaIdleTime = 0.0d;
        public long lastTimeCount = 0;
        public long curTimeCount = 0;
        public long deltaTimeCount = 0;

        public CpuUpTimeInfo() {
            reset();
        }

        public void reset() {
            this.lastActiveTime = 0.0d;
            this.curActiveTime = 0.0d;
            this.deltaActiveTime = 0.0d;
            this.lastIdleTime = 0.0d;
            this.curIdleTime = 0.0d;
            this.deltaIdleTime = 0.0d;
            int unused = CpuTool.mHiidoAppCpuRate = -1;
            CpuTool.mHiidoAppCpuRateList.clear();
        }

        public boolean isInit() {
            return this.lastActiveTime != 0.0d;
        }
    }

    /* loaded from: classes4.dex */
    public static class JiffiesCount {
        public long lastJiffies = 0;
        public long curJiffies = 0;
        public long deltaJiffies = 0;
        public long lastTimeCount = 0;
        public long curTimeCount = 0;
        public long deltaTimeCount = 0;

        public JiffiesCount() {
            reset();
        }

        public void reset() {
            this.lastJiffies = 0L;
            this.curJiffies = 0L;
            this.deltaJiffies = 0L;
        }

        public boolean isInit() {
            return this.lastJiffies == 0;
        }
    }

    public static String getKernelVersion() {
        return System.getProperty("os.version");
    }

    public static int getCpuCores() {
        return Runtime.getRuntime().availableProcessors();
    }

    public static synchronized int getHiidoAppCpuRate() {
        int i;
        synchronized (CpuTool.class) {
            i = mHiidoAppCpuRate;
        }
        return i;
    }

    public static synchronized double getAppCpuRateAverage() {
        double d;
        synchronized (CpuTool.class) {
            int appCpuRate = getAppCpuRate(15);
            if (appCpuRate <= 0) {
                mHiidoAppCpuRateList.add(Integer.valueOf(appCpuRate));
                if (mHiidoAppCpuRateList.size() > 10) {
                    int i = 0;
                    for (Integer num : mHiidoAppCpuRateList) {
                        i = num.intValue() + i;
                    }
                    mHiidoAppCpuRate = i / mHiidoAppCpuRateList.size();
                    mHiidoAppCpuRateList.clear();
                }
            } else {
                mHiidoAppCpuRate = appCpuRate <= 100 ? appCpuRate : 100;
            }
            if (appCpuRate < 0) {
                d = 0.0d;
            } else {
                d = appCpuRate / mCpuCores;
            }
        }
        return d;
    }

    public static synchronized int getAppCpuRate(int i) {
        int i2 = 0;
        synchronized (CpuTool.class) {
            if (i > 0) {
                if (i != mTopPeriod) {
                    mTopPeriod = i;
                }
            }
            if (mJiffiesCount.isInit()) {
                mJiffiesCount.lastJiffies = getCurrentCpuJiffies();
                mJiffiesCount.lastTimeCount = System.currentTimeMillis();
            } else {
                mJiffiesCount.curJiffies = getCurrentCpuJiffies();
                mJiffiesCount.deltaJiffies = mJiffiesCount.curJiffies - mJiffiesCount.lastJiffies;
                mJiffiesCount.lastJiffies = mJiffiesCount.curJiffies;
                if (mJiffiesCount.deltaJiffies == 0 && ThunderLog.isInfoValid()) {
                    ThunderLog.info(TAG, "appCpu deltaJiffiesPerSecond: 0 mJiffiesCount.curJiffies: " + mJiffiesCount.curJiffies + " lastJiffies: " + mJiffiesCount.lastJiffies);
                }
                mJiffiesCount.curTimeCount = System.currentTimeMillis();
                mJiffiesCount.deltaTimeCount = mJiffiesCount.curTimeCount - mJiffiesCount.lastTimeCount;
                mJiffiesCount.lastTimeCount = mJiffiesCount.curTimeCount;
                if (mJiffiesCount.deltaTimeCount != 0) {
                    long j = (mJiffiesCount.deltaJiffies * 1000) / mJiffiesCount.deltaTimeCount;
                    if (ThunderLog.isInfoValid()) {
                        ThunderLog.info(TAG, "appCpu deltaJiffiesPerSecond: " + j);
                    }
                    long referDeviceJiffies = getReferDeviceJiffies();
                    if (referDeviceJiffies != 0) {
                        i2 = (int) ((((j * 100) * mJiffiesTopCount.deltaTimeCount) / referDeviceJiffies) / 1000);
                        if (ThunderLog.isInfoValid()) {
                            ThunderLog.info(TAG, "refJiffies by top:" + referDeviceJiffies + " cpuRate " + i2);
                        }
                    } else {
                        i2 = (int) (-j);
                    }
                }
            }
        }
        return i2;
    }

    public static int getDeviceCpuRate() {
        return mDeviceCpuRate;
    }

    public static int getDeviceCpuRateByUptime() {
        if (!mCpuUpTimeInfo.isInit()) {
            float[] cpuUpTimeInfo = getCpuUpTimeInfo();
            if (cpuUpTimeInfo != null) {
                mCpuUpTimeInfo.lastActiveTime = cpuUpTimeInfo[0];
                mCpuUpTimeInfo.lastIdleTime = cpuUpTimeInfo[1];
                mCpuUpTimeInfo.lastTimeCount = System.currentTimeMillis();
                return 0;
            }
            return 0;
        }
        float[] cpuUpTimeInfo2 = getCpuUpTimeInfo();
        if (cpuUpTimeInfo2 != null && cpuUpTimeInfo2.length == 2) {
            mCpuUpTimeInfo.curActiveTime = cpuUpTimeInfo2[0];
            mCpuUpTimeInfo.deltaActiveTime = mCpuUpTimeInfo.curActiveTime - mCpuUpTimeInfo.lastActiveTime;
            mCpuUpTimeInfo.lastActiveTime = mCpuUpTimeInfo.curActiveTime;
            mCpuUpTimeInfo.curIdleTime = cpuUpTimeInfo2[1];
            mCpuUpTimeInfo.deltaIdleTime = mCpuUpTimeInfo.curIdleTime - mCpuUpTimeInfo.lastIdleTime;
            mCpuUpTimeInfo.lastIdleTime = mCpuUpTimeInfo.curIdleTime;
        }
        if (cpuUpTimeInfo2 == null || mCpuUpTimeInfo.deltaActiveTime == 0.0d || mCpuCores == 0) {
            return 0;
        }
        if (ThunderLog.isInfoValid()) {
            ThunderLog.info(TAG, "deltaIdleTime:" + mCpuUpTimeInfo.deltaIdleTime + " deltaActiveTime " + mCpuUpTimeInfo.deltaActiveTime + " mCpuCores " + mCpuCores);
        }
        double d = 1.0d - (mCpuUpTimeInfo.deltaIdleTime / (mCpuUpTimeInfo.deltaActiveTime * mCpuCores));
        ThunderLog.release(TAG, "deviceCpuRate:" + (100.0d * d));
        return (int) (d * 100.0d);
    }

    private static long getReferDeviceJiffies() {
        mJiffiesTopCount.lastJiffies = getCurrentCpuJiffies();
        mJiffiesTopCount.lastTimeCount = System.currentTimeMillis();
        int[] cpuRateByTop = getCpuRateByTop();
        if (cpuRateByTop == null || cpuRateByTop[0] == 0) {
            return mRefDeviceJiffies;
        }
        mJiffiesTopCount.curJiffies = getCurrentCpuJiffies();
        mJiffiesTopCount.curTimeCount = System.currentTimeMillis();
        mJiffiesTopCount.deltaJiffies = mJiffiesTopCount.curJiffies - mJiffiesTopCount.lastJiffies;
        mJiffiesTopCount.deltaTimeCount = mJiffiesTopCount.curTimeCount - mJiffiesTopCount.lastTimeCount;
        mRefDeviceJiffies = (int) ((100 * mJiffiesTopCount.deltaJiffies) / cpuRateByTop[0]);
        if (ThunderLog.isInfoValid()) {
            ThunderLog.info(TAG, "top cpu device jiffies:" + mRefDeviceJiffies + " mJiffiesTopCount.deltaJiffies:" + mJiffiesTopCount.deltaJiffies + " top:" + cpuRateByTop);
        }
        return mRefDeviceJiffies;
    }

    public static int[] getCpuRateByTop() {
        int[] iArr = new int[2];
        if (OS_VERSION.compareTo("8.0") >= 0) {
            if (count == 0) {
                String[] cpuRateByRunTop = getCpuRateByRunTop(selfProcessPid);
                if (ThunderLog.isInfoValid()) {
                    ThunderLog.info(TAG, "appCpuRate:" + cpuRateByRunTop[0] + "deviceCpuRate" + cpuRateByRunTop[1]);
                }
                if (cpuRateByRunTop != null) {
                    try {
                        iArr[0] = (int) Float.parseFloat(cpuRateByRunTop[0]);
                        mAppCpuRate = iArr[0];
                        iArr[1] = (int) Float.parseFloat(cpuRateByRunTop[1]);
                        mDeviceCpuRate = iArr[1];
                    } catch (Exception e) {
                        ThunderLog.error(TAG, "Exception " + e);
                    }
                    ThunderLog.error(TAG, "getAppRateByTop appCpuRate:" + mAppCpuRate + " deviceCpuRate " + mDeviceCpuRate);
                }
            }
            if (count == mTopPeriod - 1) {
                count = 0;
            } else {
                count++;
            }
        }
        return iArr;
    }

    /* JADX WARN: Removed duplicated region for block: B:25:0x0092 A[EXC_TOP_SPLITTER, SYNTHETIC] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public static long getCurrentCpuJiffies() {
        BufferedReader bufferedReader;
        String[] split;
        long j = 0;
        String str = "/proc/" + Process.myPid() + "/stat";
        String[] strArr = new String[3];
        File file = new File(str);
        if (!file.exists() || !file.canRead()) {
            ThunderLog.error(TAG, "file not exist or have not permission:" + str);
        } else {
            try {
                bufferedReader = new BufferedReader(new FileReader(file));
            } catch (IOException e) {
                e = e;
                bufferedReader = null;
            }
            try {
                String readLine = bufferedReader.readLine();
                if (readLine != null && (split = readLine.split(" ")) != null) {
                    strArr[0] = split[1];
                    strArr[1] = split[13];
                    strArr[2] = split[14];
                    j = Long.parseLong(strArr[2]) + Long.parseLong(strArr[1]);
                }
            } catch (IOException e2) {
                e = e2;
                ThunderLog.error(TAG, "exception: " + e);
                if (bufferedReader != null) {
                }
                return j;
            }
            if (bufferedReader != null) {
                try {
                    bufferedReader.close();
                } catch (IOException e3) {
                    ThunderLog.error(TAG, "exception: " + e3);
                }
            }
        }
        return j;
    }

    /* JADX WARN: Removed duplicated region for block: B:26:0x004c A[EXC_TOP_SPLITTER, SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:30:? A[RETURN, SYNTHETIC] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public static float[] getCpuUpTimeInfo() {
        BufferedReader bufferedReader;
        String[] split;
        float[] fArr = new float[2];
        File file = new File("/proc/uptime");
        if (file.exists() && file.canRead()) {
            try {
                bufferedReader = new BufferedReader(new FileReader(file));
                try {
                    String readLine = bufferedReader.readLine();
                    if (readLine != null && (split = readLine.split(" ")) != null) {
                        fArr[0] = Float.parseFloat(split[0]);
                        fArr[1] = Float.parseFloat(split[1]);
                    }
                } catch (IOException e) {
                    e = e;
                    ThunderLog.error(TAG, "exception: " + e);
                    if (bufferedReader == null) {
                    }
                }
            } catch (IOException e2) {
                e = e2;
                bufferedReader = null;
            }
            if (bufferedReader == null) {
                try {
                    bufferedReader.close();
                    return fArr;
                } catch (IOException e3) {
                    ThunderLog.error(TAG, "exception: " + e3);
                    return fArr;
                }
            }
            return fArr;
        }
        return null;
    }

    /* JADX DEBUG: Don't trust debug lines info. Repeating lines: [384=4, 385=4, 387=4, 390=4, 392=4, 393=4, 395=4, 382=5] */
    public static int getMaxCpuFreqInfo() {
        BufferedReader bufferedReader;
        FileReader fileReader;
        BufferedReader bufferedReader2;
        int i = 0;
        try {
            try {
                File file = new File(kCpuInfoMaxFreqFilePath);
                if (file == null || !file.exists()) {
                    bufferedReader2 = null;
                    fileReader = null;
                } else {
                    fileReader = new FileReader(kCpuInfoMaxFreqFilePath);
                    try {
                        bufferedReader2 = new BufferedReader(fileReader);
                        try {
                            String readLine = bufferedReader2.readLine();
                            if (readLine != null && !readLine.isEmpty()) {
                                i = Integer.parseInt(readLine.trim());
                            }
                        } catch (FileNotFoundException e) {
                            e = e;
                            ThunderLog.error(TAG, "Exception: " + e.toString());
                            if (fileReader != null) {
                                try {
                                    fileReader.close();
                                } catch (IOException e2) {
                                    ThunderLog.error(TAG, "Exception: " + e2.toString());
                                }
                            }
                            if (bufferedReader2 != null) {
                                try {
                                    bufferedReader2.close();
                                } catch (IOException e3) {
                                    ThunderLog.error(TAG, "Exception: " + e3.toString());
                                }
                            }
                            return i;
                        } catch (IOException e4) {
                            e = e4;
                            ThunderLog.error(TAG, "Exception: " + e.toString());
                            if (fileReader != null) {
                                try {
                                    fileReader.close();
                                } catch (IOException e5) {
                                    ThunderLog.error(TAG, "Exception: " + e5.toString());
                                }
                            }
                            if (bufferedReader2 != null) {
                                try {
                                    bufferedReader2.close();
                                } catch (IOException e6) {
                                    ThunderLog.error(TAG, "Exception: " + e6.toString());
                                }
                            }
                            return i;
                        }
                    } catch (FileNotFoundException e7) {
                        e = e7;
                        bufferedReader2 = null;
                    } catch (IOException e8) {
                        e = e8;
                        bufferedReader2 = null;
                    } catch (Throwable th) {
                        th = th;
                        bufferedReader = null;
                        if (fileReader != null) {
                            try {
                                fileReader.close();
                            } catch (IOException e9) {
                                ThunderLog.error(TAG, "Exception: " + e9.toString());
                            }
                        }
                        if (bufferedReader != null) {
                            try {
                                bufferedReader.close();
                            } catch (IOException e10) {
                                ThunderLog.error(TAG, "Exception: " + e10.toString());
                            }
                        }
                        throw th;
                    }
                }
                if (fileReader != null) {
                    try {
                        fileReader.close();
                    } catch (IOException e11) {
                        ThunderLog.error(TAG, "Exception: " + e11.toString());
                    }
                }
                if (bufferedReader2 != null) {
                    try {
                        bufferedReader2.close();
                    } catch (IOException e12) {
                        ThunderLog.error(TAG, "Exception: " + e12.toString());
                    }
                }
            } catch (Throwable th2) {
                th = th2;
            }
        } catch (FileNotFoundException e13) {
            e = e13;
            bufferedReader2 = null;
            fileReader = null;
        } catch (IOException e14) {
            e = e14;
            bufferedReader2 = null;
            fileReader = null;
        } catch (Throwable th3) {
            th = th3;
            bufferedReader = null;
            fileReader = null;
        }
        return i;
    }

    /* JADX WARN: Removed duplicated region for block: B:35:0x006d A[EXC_TOP_SPLITTER, SYNTHETIC] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public static String getCurrentProcessCpuAffinity() {
        BufferedReader bufferedReader;
        String str = null;
        File file = new File("/proc/" + Process.myPid() + "/stat");
        if (!file.exists() || !file.canRead()) {
            ThunderLog.error(TAG, "file not exist or have not permission");
        } else {
            try {
                bufferedReader = new BufferedReader(new FileReader(file));
            } catch (IOException e) {
                e = e;
                bufferedReader = null;
            }
            try {
                String readLine = bufferedReader.readLine();
                if (readLine != null) {
                    String[] split = readLine.split(" ");
                    if (getKernelVersion().compareTo("2.8.8") <= 0) {
                        if (split.length >= 3) {
                            str = split[split.length - 3];
                        }
                    } else if (split.length >= 14) {
                        str = split[split.length - 15];
                    }
                }
            } catch (IOException e2) {
                e = e2;
                ThunderLog.error(TAG, "exception: " + e);
                if (bufferedReader != null) {
                }
                return str;
            }
            if (bufferedReader != null) {
                try {
                    bufferedReader.close();
                } catch (IOException e3) {
                    ThunderLog.error(TAG, "exception: " + e3);
                }
            }
        }
        return str;
    }

    public static int getMinCpuFreq() {
        if (minCpuFreq == 0) {
            minCpuFreq = getMinCpuFreqInfo();
        }
        return minCpuFreq;
    }

    public static int getMaxCpuFreq() {
        if (maxCpuFreq == 0) {
            maxCpuFreq = getMaxCpuFreqInfo();
        }
        return maxCpuFreq;
    }

    /* JADX DEBUG: Don't trust debug lines info. Repeating lines: [488=5, 490=4, 491=4, 493=4, 496=4, 498=4, 499=4, 501=4] */
    public static int getMinCpuFreqInfo() {
        BufferedReader bufferedReader;
        FileReader fileReader;
        BufferedReader bufferedReader2;
        int i = 0;
        try {
            try {
                File file = new File(kCpuInfoMaxFreqFilePath);
                if (file == null || !file.exists()) {
                    bufferedReader2 = null;
                    fileReader = null;
                } else {
                    fileReader = new FileReader(kCpuInfoMinFreqFilePath);
                    try {
                        bufferedReader2 = new BufferedReader(fileReader);
                        try {
                            String readLine = bufferedReader2.readLine();
                            if (readLine != null && !readLine.isEmpty()) {
                                i = Integer.parseInt(readLine.trim());
                            }
                        } catch (FileNotFoundException e) {
                            e = e;
                            ThunderLog.error(TAG, "Exception: " + e.toString());
                            if (fileReader != null) {
                                try {
                                    fileReader.close();
                                } catch (IOException e2) {
                                    ThunderLog.error(TAG, "Exception: " + e2.toString());
                                }
                            }
                            if (bufferedReader2 != null) {
                                try {
                                    bufferedReader2.close();
                                } catch (IOException e3) {
                                    ThunderLog.error(TAG, "Exception: " + e3.toString());
                                }
                            }
                            return i;
                        } catch (IOException e4) {
                            e = e4;
                            ThunderLog.error(TAG, "Exception: " + e.toString());
                            if (fileReader != null) {
                                try {
                                    fileReader.close();
                                } catch (IOException e5) {
                                    ThunderLog.error(TAG, "Exception: " + e5.toString());
                                }
                            }
                            if (bufferedReader2 != null) {
                                try {
                                    bufferedReader2.close();
                                } catch (IOException e6) {
                                    ThunderLog.error(TAG, "Exception: " + e6.toString());
                                }
                            }
                            return i;
                        }
                    } catch (FileNotFoundException e7) {
                        e = e7;
                        bufferedReader2 = null;
                    } catch (IOException e8) {
                        e = e8;
                        bufferedReader2 = null;
                    } catch (Throwable th) {
                        th = th;
                        bufferedReader = null;
                        if (fileReader != null) {
                            try {
                                fileReader.close();
                            } catch (IOException e9) {
                                ThunderLog.error(TAG, "Exception: " + e9.toString());
                            }
                        }
                        if (bufferedReader != null) {
                            try {
                                bufferedReader.close();
                            } catch (IOException e10) {
                                ThunderLog.error(TAG, "Exception: " + e10.toString());
                            }
                        }
                        throw th;
                    }
                }
                if (fileReader != null) {
                    try {
                        fileReader.close();
                    } catch (IOException e11) {
                        ThunderLog.error(TAG, "Exception: " + e11.toString());
                    }
                }
                if (bufferedReader2 != null) {
                    try {
                        bufferedReader2.close();
                    } catch (IOException e12) {
                        ThunderLog.error(TAG, "Exception: " + e12.toString());
                    }
                }
            } catch (Throwable th2) {
                th = th2;
            }
        } catch (FileNotFoundException e13) {
            e = e13;
            bufferedReader2 = null;
            fileReader = null;
        } catch (IOException e14) {
            e = e14;
            bufferedReader2 = null;
            fileReader = null;
        } catch (Throwable th3) {
            th = th3;
            bufferedReader = null;
            fileReader = null;
        }
        return i;
    }

    public static String getCpuInfo() {
        String cpuInfoBySystemProperties = getCpuInfoBySystemProperties();
        if (cpuInfoBySystemProperties == null) {
            String cpuInfoByProcNode = getCpuInfoByProcNode();
            if (cpuInfoByProcNode == null) {
                return null;
            }
            return cpuInfoByProcNode;
        }
        return cpuInfoBySystemProperties;
    }

    /* JADX DEBUG: Don't trust debug lines info. Repeating lines: [562=5, 563=5, 565=5, 566=5, 568=5, 569=5] */
    public static String getCpuInfoByProcNode() {
        FileReader fileReader;
        BufferedReader bufferedReader;
        String str = "unknown";
        String str2 = "";
        try {
            fileReader = new FileReader("/proc/cpuinfo");
            try {
                bufferedReader = new BufferedReader(fileReader);
                while (true) {
                    try {
                        try {
                            str = bufferedReader.readLine();
                            if (str == null) {
                                bufferedReader.close();
                                fileReader.close();
                                if (bufferedReader != null) {
                                    try {
                                        bufferedReader.close();
                                    } catch (IOException e) {
                                        ThunderLog.error(TAG, "Exception: " + e.toString());
                                    }
                                }
                                if (fileReader != null) {
                                    fileReader.close();
                                }
                            } else if (str.contains("Hardware")) {
                                String[] split = str.split(":");
                                if (split.length == 2) {
                                    str2 = split[1];
                                } else if (split.length == 1) {
                                    str2 = split[0];
                                }
                                if (str2 != null) {
                                    String[] split2 = str2.split(" ");
                                    if (split2.length > 1) {
                                        str = split2[split2.length - 1];
                                        if (bufferedReader != null) {
                                            try {
                                                bufferedReader.close();
                                            } catch (IOException e2) {
                                                ThunderLog.error(TAG, "Exception: " + e2.toString());
                                            }
                                        }
                                        if (fileReader != null) {
                                            fileReader.close();
                                        }
                                    } else {
                                        str = split2[0];
                                        if (bufferedReader != null) {
                                            try {
                                                bufferedReader.close();
                                            } catch (IOException e3) {
                                                ThunderLog.error(TAG, "Exception: " + e3.toString());
                                            }
                                        }
                                        if (fileReader != null) {
                                            fileReader.close();
                                        }
                                    }
                                }
                            }
                        } catch (IOException e4) {
                            e = e4;
                            ThunderLog.error(TAG, "Exception: " + e.toString());
                            if (bufferedReader != null) {
                                try {
                                    bufferedReader.close();
                                } catch (IOException e5) {
                                    ThunderLog.error(TAG, "Exception: " + e5.toString());
                                }
                            }
                            if (fileReader != null) {
                                fileReader.close();
                            }
                            return str;
                        }
                    } catch (Throwable th) {
                        th = th;
                        if (bufferedReader != null) {
                            try {
                                bufferedReader.close();
                            } catch (IOException e6) {
                                ThunderLog.error(TAG, "Exception: " + e6.toString());
                                throw th;
                            }
                        }
                        if (fileReader != null) {
                            fileReader.close();
                        }
                        throw th;
                    }
                }
            } catch (IOException e7) {
                e = e7;
                bufferedReader = null;
            } catch (Throwable th2) {
                th = th2;
                bufferedReader = null;
            }
        } catch (IOException e8) {
            e = e8;
            fileReader = null;
            bufferedReader = null;
        } catch (Throwable th3) {
            th = th3;
            fileReader = null;
            bufferedReader = null;
        }
        return str;
    }

    public static String getCpuInfoBySystemProperties() {
        ThunderLog.release(TAG, "getCpuInfo 11");
        try {
            Class<?> cls = Class.forName("android.os.SystemProperties");
            return (String) cls.getDeclaredMethod("get", String.class).invoke(cls, "ro.board.platform");
        } catch (ClassNotFoundException e) {
            ThunderLog.release(TAG, "getCpuInfo exception:" + e);
            return null;
        } catch (IllegalAccessException e2) {
            ThunderLog.release(TAG, "getCpuInfo exception:" + e2);
            return null;
        } catch (NoSuchMethodException e3) {
            ThunderLog.release(TAG, "getCpuInfo exception:" + e3);
            return null;
        } catch (InvocationTargetException e4) {
            ThunderLog.release(TAG, "getCpuInfo exception:" + e4);
            return null;
        }
    }

    public static String[] getCpuRateByRunTop(int i) {
        String[] strArr = {"0", "0"};
        long currentTimeMillis = System.currentTimeMillis();
        String run = run(TOP, i);
        long currentTimeMillis2 = System.currentTimeMillis() - currentTimeMillis;
        if (run != null) {
            parseTopCpuInfo(run, strArr);
            return strArr;
        }
        return null;
    }

    private static String run(String[] strArr, int i) {
        StringBuilder sb = new StringBuilder();
        int i2 = 10;
        try {
            InputStream inputStream = Runtime.getRuntime().exec(strArr).getInputStream();
            BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(inputStream));
            while (true) {
                String readLine = bufferedReader.readLine();
                if (readLine == null) {
                    ThunderLog.error(TAG, "return null");
                    break;
                } else if (readLine != null && i != 0 && readLine.contains(String.valueOf(i))) {
                    sb.append(readLine);
                    break;
                } else {
                    i2--;
                    if (i2 <= 0) {
                        break;
                    }
                }
            }
            if (inputStream != null) {
                inputStream.close();
            }
            if (bufferedReader != null) {
                bufferedReader.close();
            }
        } catch (IOException e) {
            ThunderLog.error(TAG, "top Exception:" + e);
        }
        return sb.toString();
    }

    public static int parseTopCpuInfo(String str, String[] strArr) {
        String[] split;
        String[] split2 = str.split(" ");
        if (strArr != null && strArr.length == 2 && split2 != null) {
            for (int i = 0; i < split2.length; i++) {
                if (split2[i].toUpperCase().equals("R") || split2[i].toUpperCase().equals("S")) {
                    String str2 = split2[i + 1];
                    if (str2 == " ") {
                        str2 = split2[i + 2];
                    }
                    strArr[0] = str2;
                }
                if (split2[i].toLowerCase().contains("%idle") && i > 0 && (split = split2[i].split("%")) != null && split.length > 0) {
                    strArr[1] = String.valueOf((mCpuCores * 100) - Float.parseFloat(split[0]));
                }
            }
            return 0;
        }
        return -1;
    }
}
