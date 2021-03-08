package com.yy.mediaframework.utils;

import android.os.Build;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.lang.reflect.InvocationTargetException;
/* loaded from: classes6.dex */
public class CPUTool {
    private static final String TAG = "CPUTool";
    private static final String kCpuInfoCurFreqFilePath = "/sys/devices/system/cpu/cpu0/cpufreq/scaling_cur_freq";
    private static final String kCpuInfoMaxFreqFilePath = "/sys/devices/system/cpu/cpu0/cpufreq/cpuinfo_max_freq";
    private static final String kCpuInfoMinFreqFilePath = "/sys/devices/system/cpu/cpu0/cpufreq/cpuinfo_min_freq";

    public static native String getRunningABI();

    /* JADX DEBUG: Don't trust debug lines info. Repeating lines: [44=5, 46=4, 47=4, 49=4, 51=4, 53=4, 54=4, 56=4] */
    public static int getMaxCpuFreq() {
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
                            YMFLog.error((Object) null, "[Util    ]", "exception:" + e.toString());
                            if (fileReader != null) {
                                try {
                                    fileReader.close();
                                } catch (IOException e2) {
                                    YMFLog.error((Object) null, "[Util    ]", "exception:" + e2.toString());
                                }
                            }
                            if (bufferedReader2 != null) {
                                try {
                                    bufferedReader2.close();
                                } catch (IOException e3) {
                                    YMFLog.error((Object) null, "[Util    ]", "exception:" + e3.toString());
                                }
                            }
                            return i;
                        } catch (IOException e4) {
                            e = e4;
                            YMFLog.error((Object) null, "[Util    ]", "exception:" + e.toString());
                            if (fileReader != null) {
                                try {
                                    fileReader.close();
                                } catch (IOException e5) {
                                    YMFLog.error((Object) null, "[Util    ]", "exception:" + e5.toString());
                                }
                            }
                            if (bufferedReader2 != null) {
                                try {
                                    bufferedReader2.close();
                                } catch (IOException e6) {
                                    YMFLog.error((Object) null, "[Util    ]", "exception:" + e6.toString());
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
                                YMFLog.error((Object) null, "[Util    ]", "exception:" + e9.toString());
                            }
                        }
                        if (bufferedReader != null) {
                            try {
                                bufferedReader.close();
                            } catch (IOException e10) {
                                YMFLog.error((Object) null, "[Util    ]", "exception:" + e10.toString());
                            }
                        }
                        throw th;
                    }
                }
                if (fileReader != null) {
                    try {
                        fileReader.close();
                    } catch (IOException e11) {
                        YMFLog.error((Object) null, "[Util    ]", "exception:" + e11.toString());
                    }
                }
                if (bufferedReader2 != null) {
                    try {
                        bufferedReader2.close();
                    } catch (IOException e12) {
                        YMFLog.error((Object) null, "[Util    ]", "exception:" + e12.toString());
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

    /* JADX DEBUG: Don't trust debug lines info. Repeating lines: [96=4, 98=4, 86=5, 88=4, 89=4, 91=4, 93=4, 95=4] */
    public static int getMinCpuFreq() {
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
                            YMFLog.error((Object) null, "[Util    ]", "exception:" + e.toString());
                            if (fileReader != null) {
                                try {
                                    fileReader.close();
                                } catch (IOException e2) {
                                    YMFLog.error((Object) null, "[Util    ]", "exception:" + e2.toString());
                                }
                            }
                            if (bufferedReader2 != null) {
                                try {
                                    bufferedReader2.close();
                                } catch (IOException e3) {
                                    YMFLog.error((Object) null, "[Util    ]", "exception:" + e3.toString());
                                }
                            }
                            return i;
                        } catch (IOException e4) {
                            e = e4;
                            YMFLog.error((Object) null, "[Util    ]", "exception:" + e.toString());
                            if (fileReader != null) {
                                try {
                                    fileReader.close();
                                } catch (IOException e5) {
                                    YMFLog.error((Object) null, "[Util    ]", "exception:" + e5.toString());
                                }
                            }
                            if (bufferedReader2 != null) {
                                try {
                                    bufferedReader2.close();
                                } catch (IOException e6) {
                                    YMFLog.error((Object) null, "[Util    ]", "exception:" + e6.toString());
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
                                YMFLog.error((Object) null, "[Util    ]", "exception:" + e9.toString());
                            }
                        }
                        if (bufferedReader != null) {
                            try {
                                bufferedReader.close();
                            } catch (IOException e10) {
                                YMFLog.error((Object) null, "[Util    ]", "exception:" + e10.toString());
                            }
                        }
                        throw th;
                    }
                }
                if (fileReader != null) {
                    try {
                        fileReader.close();
                    } catch (IOException e11) {
                        YMFLog.error((Object) null, "[Util    ]", "exception:" + e11.toString());
                    }
                }
                if (bufferedReader2 != null) {
                    try {
                        bufferedReader2.close();
                    } catch (IOException e12) {
                        YMFLog.error((Object) null, "[Util    ]", "exception:" + e12.toString());
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

    /* JADX DEBUG: Don't trust debug lines info. Repeating lines: [129=4, 130=4, 132=4, 134=4, 136=4, 137=4, 139=4, 127=5] */
    public static int getCurCpuFreq() {
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
                    fileReader = new FileReader(kCpuInfoCurFreqFilePath);
                    try {
                        bufferedReader2 = new BufferedReader(fileReader);
                        try {
                            String readLine = bufferedReader2.readLine();
                            if (readLine != null && !readLine.isEmpty()) {
                                i = Integer.parseInt(readLine.trim());
                            }
                        } catch (FileNotFoundException e) {
                            e = e;
                            YMFLog.error((Object) null, "[Util    ]", "exception:" + e.toString());
                            if (fileReader != null) {
                                try {
                                    fileReader.close();
                                } catch (IOException e2) {
                                    YMFLog.error((Object) null, "[Util    ]", "exception:" + e2.toString());
                                }
                            }
                            if (bufferedReader2 != null) {
                                try {
                                    bufferedReader2.close();
                                } catch (IOException e3) {
                                    YMFLog.error((Object) null, "[Util    ]", "exception:" + e3.toString());
                                }
                            }
                            return i;
                        } catch (IOException e4) {
                            e = e4;
                            YMFLog.error((Object) null, "[Util    ]", "exception:" + e.toString());
                            if (fileReader != null) {
                                try {
                                    fileReader.close();
                                } catch (IOException e5) {
                                    YMFLog.error((Object) null, "[Util    ]", "exception:" + e5.toString());
                                }
                            }
                            if (bufferedReader2 != null) {
                                try {
                                    bufferedReader2.close();
                                } catch (IOException e6) {
                                    YMFLog.error((Object) null, "[Util    ]", "exception:" + e6.toString());
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
                                YMFLog.error((Object) null, "[Util    ]", "exception:" + e9.toString());
                            }
                        }
                        if (bufferedReader != null) {
                            try {
                                bufferedReader.close();
                            } catch (IOException e10) {
                                YMFLog.error((Object) null, "[Util    ]", "exception:" + e10.toString());
                            }
                        }
                        throw th;
                    }
                }
                if (fileReader != null) {
                    try {
                        fileReader.close();
                    } catch (IOException e11) {
                        YMFLog.error((Object) null, "[Util    ]", "exception:" + e11.toString());
                    }
                }
                if (bufferedReader2 != null) {
                    try {
                        bufferedReader2.close();
                    } catch (IOException e12) {
                        YMFLog.error((Object) null, "[Util    ]", "exception:" + e12.toString());
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

    /* JADX DEBUG: Don't trust debug lines info. Repeating lines: [197=5, 198=5, 200=5, 201=5, 203=5, 204=5] */
    /* JADX DEBUG: Failed to insert an additional move for type inference into block B:66:0x0155 */
    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r4v0, types: [java.lang.String] */
    /* JADX WARN: Type inference failed for: r4v1 */
    /* JADX WARN: Type inference failed for: r4v3, types: [java.io.BufferedReader] */
    /* JADX WARN: Type inference failed for: r4v9 */
    public static String getCpuInfoByProcNode() {
        FileReader fileReader;
        BufferedReader bufferedReader;
        ?? r4 = "/proc/cpuinfo";
        String str = "unknown";
        String str2 = "";
        try {
            try {
                fileReader = new FileReader("/proc/cpuinfo");
            } catch (Throwable th) {
                th = th;
            }
            try {
                bufferedReader = new BufferedReader(fileReader);
                while (true) {
                    try {
                        str = bufferedReader.readLine();
                        if (str == null) {
                            bufferedReader.close();
                            fileReader.close();
                            if (bufferedReader != null) {
                                try {
                                    bufferedReader.close();
                                } catch (IOException e) {
                                    YMFLog.error((Object) null, "[Util    ]", "exception:" + e.toString());
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
                                            YMFLog.error((Object) null, "[Util    ]", "exception:" + e2.toString());
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
                                            YMFLog.error((Object) null, "[Util    ]", "exception:" + e3.toString());
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
                        YMFLog.error((Object) null, "[Util    ]", "exception:" + e.toString());
                        if (bufferedReader != null) {
                            try {
                                bufferedReader.close();
                            } catch (IOException e5) {
                                YMFLog.error((Object) null, "[Util    ]", "exception:" + e5.toString());
                            }
                        }
                        if (fileReader != null) {
                            fileReader.close();
                        }
                        return str;
                    }
                }
            } catch (IOException e6) {
                e = e6;
                bufferedReader = null;
            } catch (Throwable th2) {
                th = th2;
                r4 = 0;
                if (r4 != 0) {
                    try {
                        r4.close();
                    } catch (IOException e7) {
                        YMFLog.error((Object) null, "[Util    ]", "exception:" + e7.toString());
                        throw th;
                    }
                }
                if (fileReader != null) {
                    fileReader.close();
                }
                throw th;
            }
        } catch (IOException e8) {
            e = e8;
            fileReader = null;
            bufferedReader = null;
        } catch (Throwable th3) {
            th = th3;
            fileReader = null;
            r4 = 0;
        }
        return str;
    }

    public static String getCpuInfoBySystemProperties() {
        YMFLog.info(null, "[Util    ]", "getCpuInfo.");
        try {
            Class<?> cls = Class.forName("android.os.SystemProperties");
            return (String) cls.getDeclaredMethod("get", String.class).invoke(cls, "ro.board.platform");
        } catch (ClassNotFoundException e) {
            YMFLog.info(null, "[Util    ]", "getCpuInfo exception:" + e);
            return null;
        } catch (IllegalAccessException e2) {
            YMFLog.info(null, "[Util    ]", "getCpuInfo exception:" + e2);
            return null;
        } catch (NoSuchMethodException e3) {
            YMFLog.info(null, "[Util    ]", "getCpuInfo exception:" + e3);
            return null;
        } catch (InvocationTargetException e4) {
            YMFLog.info(null, "[Util    ]", "getCpuInfo exception:" + e4);
            return null;
        }
    }

    public static boolean isEmulator() {
        String str;
        if (Build.VERSION.SDK_INT >= 21) {
            str = Build.SUPPORTED_ABIS[0];
        } else {
            str = Build.CPU_ABI;
        }
        String runningABI = getRunningABI();
        return (str != null && str.contains("x86")) || (runningABI != null && runningABI.contains("x86"));
    }
}
