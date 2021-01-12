package com.qq.e.comm.plugin.util;

import android.app.ActivityManager;
import android.content.Context;
import android.content.pm.PackageManager;
import android.os.Build;
import android.os.Environment;
import android.os.StatFs;
import android.text.TextUtils;
import android.util.Base64;
import android.util.DisplayMetrics;
import android.util.Pair;
import android.view.WindowManager;
import com.baidu.minivideo.plugin.capture.utils.EncryptUtils;
import com.baidu.searchbox.logsystem.logsys.SnapshotConstant;
import com.meizu.cloud.pushsdk.constants.PushConstants;
import com.qq.e.comm.util.GDTLogger;
import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.util.ArrayList;
import java.util.List;
import java.util.Locale;
import java.util.TimeZone;
import java.util.zip.CRC32;
/* loaded from: classes3.dex */
public class al {

    /* renamed from: a  reason: collision with root package name */
    private static final String[] f12559a = {"Y29tLnRlbmNlbnQubW0=", "Y29tLnRlbmNlbnQubW9iaWxlcXE="};

    private static String a() {
        return Build.VERSION.RELEASE;
    }

    public static String a(Context context) {
        String str;
        System.currentTimeMillis();
        try {
            Context applicationContext = context.getApplicationContext();
            String a2 = a();
            Pair<Integer, Integer> c = c(applicationContext);
            String e = e();
            long d = d(applicationContext);
            long d2 = d();
            String b2 = b();
            String b3 = b(applicationContext);
            String c2 = c();
            List<Long> e2 = e(applicationContext);
            String format = String.format(Locale.US, "%s|%d|%d|%s|%d|%d", a2, c.first, c.second, e, Long.valueOf(d), Long.valueOf(d2));
            String format2 = String.format(Locale.US, "%s|%s|%s|%s", b2, b3, c2, TextUtils.join("|", e2));
            char[] b4 = b(format);
            char[] b5 = b(format2);
            a(b4);
            b(b4, b5);
            str = a(b4, b5);
        } catch (Error e3) {
            GDTLogger.w("createQADID error: " + e3.getMessage());
            str = "01000000000000000000000000000000";
        } catch (Throwable th) {
            GDTLogger.w("createQADID exception: " + th.getMessage());
            str = "01000000000000000000000000000000";
        }
        GDTLogger.d("QADID: " + str);
        return str;
    }

    private static String a(String str) {
        return new String(Base64.decode(str, 2));
    }

    private static String a(char[] cArr, char[] cArr2) {
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < 32; i++) {
            if (i < 16) {
                sb.append(cArr[i]);
            } else {
                sb.append(cArr2[i - 16]);
            }
        }
        return sb.toString();
    }

    private static void a(char[] cArr) {
        String upperCase = Integer.toHexString(1).toUpperCase();
        if (upperCase.length() < 2) {
            cArr[0] = (char) 48;
            cArr[1] = upperCase.charAt(0);
            return;
        }
        cArr[0] = upperCase.charAt(0);
        cArr[1] = upperCase.charAt(1);
    }

    private static long b(char[] cArr) {
        StringBuilder sb = new StringBuilder();
        for (char c : cArr) {
            sb.append(c);
        }
        byte[] d = d(sb.toString());
        CRC32 crc32 = new CRC32();
        crc32.update(d);
        return crc32.getValue();
    }

    private static String b() {
        return Locale.getDefault().getLanguage();
    }

    private static String b(Context context) {
        return context.getApplicationContext().getResources().getConfiguration().locale.getCountry();
    }

    private static void b(char[] cArr, char[] cArr2) {
        char[] cArr3 = new char[30];
        for (int i = 0; i < 30; i++) {
            if (i < 16) {
                cArr3[i] = cArr[i];
            } else {
                cArr3[i] = cArr2[i - 16];
            }
        }
        String upperCase = Integer.toHexString((int) (b(cArr3) % 256)).toUpperCase();
        if (upperCase.length() < 2) {
            cArr2[14] = (char) 48;
            cArr2[15] = upperCase.charAt(0);
            return;
        }
        cArr2[14] = upperCase.charAt(0);
        cArr2[15] = upperCase.charAt(1);
    }

    private static char[] b(String str) {
        String c = c(str);
        char[] cArr = new char[16];
        for (int i = 8; i < 24; i++) {
            cArr[i - 8] = c.charAt(i);
        }
        return cArr;
    }

    private static Pair<Integer, Integer> c(Context context) {
        DisplayMetrics displayMetrics = new DisplayMetrics();
        WindowManager windowManager = (WindowManager) context.getSystemService("window");
        if (windowManager != null) {
            if (Build.VERSION.SDK_INT >= 17) {
                windowManager.getDefaultDisplay().getRealMetrics(displayMetrics);
            } else {
                windowManager.getDefaultDisplay().getMetrics(displayMetrics);
            }
        }
        return new Pair<>(Integer.valueOf(Math.min(displayMetrics.widthPixels, displayMetrics.heightPixels)), Integer.valueOf(Math.max(displayMetrics.widthPixels, displayMetrics.heightPixels)));
    }

    private static String c() {
        try {
            return TimeZone.getDefault().getDisplayName(false, 0);
        } catch (AssertionError e) {
            return "";
        } catch (Exception e2) {
            return "";
        }
    }

    private static String c(String str) {
        try {
            MessageDigest messageDigest = MessageDigest.getInstance(EncryptUtils.ENCRYPT_MD5);
            messageDigest.update(str.getBytes());
            byte[] digest = messageDigest.digest();
            StringBuilder sb = new StringBuilder();
            for (byte b2 : digest) {
                if ((b2 & 255) < 16) {
                    sb.append("0");
                }
                sb.append(Integer.toHexString(b2 & 255));
            }
            return sb.toString().toUpperCase();
        } catch (NoSuchAlgorithmException e) {
            return "";
        }
    }

    private static long d() {
        StatFs statFs = new StatFs(Environment.getDataDirectory().getPath());
        if (Build.VERSION.SDK_INT >= 18) {
            return statFs.getBlockCountLong() * statFs.getBlockSizeLong();
        }
        return statFs.getBlockCount() * statFs.getBlockSize();
    }

    private static long d(Context context) {
        BufferedReader bufferedReader;
        FileReader fileReader;
        BufferedReader bufferedReader2;
        String readLine;
        if (Build.VERSION.SDK_INT >= 16) {
            ActivityManager activityManager = (ActivityManager) context.getSystemService(PushConstants.INTENT_ACTIVITY_NAME);
            ActivityManager.MemoryInfo memoryInfo = new ActivityManager.MemoryInfo();
            if (activityManager != null) {
                activityManager.getMemoryInfo(memoryInfo);
                return memoryInfo.totalMem;
            }
            return 0L;
        }
        try {
            fileReader = new FileReader("/proc/meminfo");
            try {
                bufferedReader = new BufferedReader(fileReader, 4096);
                do {
                    try {
                        readLine = bufferedReader.readLine();
                        if (readLine == null) {
                            break;
                        }
                    } catch (FileNotFoundException e) {
                        bufferedReader2 = bufferedReader;
                        if (bufferedReader2 != null) {
                            try {
                                bufferedReader2.close();
                            } catch (IOException e2) {
                            }
                        }
                        if (fileReader != null) {
                            try {
                                fileReader.close();
                                return 0L;
                            } catch (IOException e3) {
                                return 0L;
                            }
                        }
                        return 0L;
                    } catch (IOException e4) {
                        if (bufferedReader != null) {
                            try {
                                bufferedReader.close();
                            } catch (IOException e5) {
                            }
                        }
                        if (fileReader != null) {
                            try {
                                fileReader.close();
                                return 0L;
                            } catch (IOException e6) {
                                return 0L;
                            }
                        }
                        return 0L;
                    } catch (Throwable th) {
                        th = th;
                        if (bufferedReader != null) {
                            try {
                                bufferedReader.close();
                            } catch (IOException e7) {
                            }
                        }
                        if (fileReader != null) {
                            try {
                                fileReader.close();
                            } catch (IOException e8) {
                            }
                        }
                        throw th;
                    }
                } while (!readLine.contains("MemTotal"));
                long longValue = readLine != null ? Long.valueOf(readLine.split("\\s+")[1]).longValue() * 1024 : 0L;
                if (bufferedReader != null) {
                    try {
                        bufferedReader.close();
                    } catch (IOException e9) {
                    }
                }
                if (fileReader != null) {
                    try {
                        fileReader.close();
                        return longValue;
                    } catch (IOException e10) {
                        return longValue;
                    }
                }
                return longValue;
            } catch (FileNotFoundException e11) {
                bufferedReader2 = null;
            } catch (IOException e12) {
                bufferedReader = null;
            } catch (Throwable th2) {
                th = th2;
                bufferedReader = null;
            }
        } catch (FileNotFoundException e13) {
            bufferedReader2 = null;
            fileReader = null;
        } catch (IOException e14) {
            bufferedReader = null;
            fileReader = null;
        } catch (Throwable th3) {
            th = th3;
            bufferedReader = null;
            fileReader = null;
        }
    }

    private static byte[] d(String str) {
        int length = str.length();
        byte[] bArr = new byte[length / 2];
        for (int i = 0; i < length; i += 2) {
            bArr[i / 2] = (byte) ((Character.digit(str.charAt(i), 16) << 4) + Character.digit(str.charAt(i + 1), 16));
        }
        return bArr;
    }

    private static String e() {
        BufferedReader bufferedReader;
        FileReader fileReader;
        String property = System.getProperty("os.version");
        try {
            fileReader = new FileReader(SnapshotConstant.DeviceFilePathConstants.DEVICE_VERSION);
            try {
                bufferedReader = new BufferedReader(fileReader, 8192);
            } catch (FileNotFoundException e) {
                bufferedReader = null;
            } catch (IOException e2) {
                bufferedReader = null;
            } catch (Throwable th) {
                th = th;
                bufferedReader = null;
            }
            try {
                String readLine = bufferedReader.readLine();
                if (readLine != null) {
                    property = readLine;
                }
                if (bufferedReader != null) {
                    try {
                        bufferedReader.close();
                    } catch (IOException e3) {
                    }
                }
                if (fileReader != null) {
                    try {
                        fileReader.close();
                    } catch (IOException e4) {
                    }
                }
            } catch (FileNotFoundException e5) {
                if (bufferedReader != null) {
                    try {
                        bufferedReader.close();
                    } catch (IOException e6) {
                    }
                }
                if (fileReader != null) {
                    try {
                        fileReader.close();
                    } catch (IOException e7) {
                    }
                }
                return property;
            } catch (IOException e8) {
                if (bufferedReader != null) {
                    try {
                        bufferedReader.close();
                    } catch (IOException e9) {
                    }
                }
                if (fileReader != null) {
                    try {
                        fileReader.close();
                    } catch (IOException e10) {
                    }
                }
                return property;
            } catch (Throwable th2) {
                th = th2;
                if (bufferedReader != null) {
                    try {
                        bufferedReader.close();
                    } catch (IOException e11) {
                    }
                }
                if (fileReader != null) {
                    try {
                        fileReader.close();
                    } catch (IOException e12) {
                    }
                }
                throw th;
            }
        } catch (FileNotFoundException e13) {
            bufferedReader = null;
            fileReader = null;
        } catch (IOException e14) {
            bufferedReader = null;
            fileReader = null;
        } catch (Throwable th3) {
            th = th3;
            bufferedReader = null;
            fileReader = null;
        }
        return property;
    }

    private static List<Long> e(Context context) {
        ArrayList arrayList = new ArrayList();
        PackageManager packageManager = context.getPackageManager();
        for (String str : f12559a) {
            try {
                arrayList.add(Long.valueOf(packageManager.getPackageInfo(a(str), 0).firstInstallTime));
            } catch (Exception e) {
                arrayList.add(-1L);
            }
        }
        return arrayList;
    }
}
