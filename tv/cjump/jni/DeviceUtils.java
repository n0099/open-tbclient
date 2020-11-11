package tv.cjump.jni;

import android.os.Build;
import android.os.Environment;
import android.text.TextUtils;
import android.util.Log;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.RandomAccessFile;
import java.lang.reflect.Field;
/* loaded from: classes6.dex */
public class DeviceUtils {
    private static ARCH qrC = ARCH.Unknown;

    /* loaded from: classes6.dex */
    public enum ARCH {
        Unknown,
        ARM,
        X86,
        MIPS,
        ARM64
    }

    /* JADX DEBUG: Don't trust debug lines info. Repeating lines: [66=5, 68=4, 69=4, 70=4] */
    /* JADX DEBUG: Failed to insert an additional move for type inference into block B:42:0x008a */
    /* JADX DEBUG: Multi-variable search result rejected for r1v5, resolved type: java.io.RandomAccessFile */
    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Removed duplicated region for block: B:66:0x008d A[EXC_TOP_SPLITTER, SYNTHETIC] */
    /* JADX WARN: Type inference failed for: r1v1, types: [boolean] */
    /* JADX WARN: Type inference failed for: r1v2 */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public static synchronized ARCH eIr() {
        RandomAccessFile randomAccessFile;
        int i;
        synchronized (DeviceUtils.class) {
            byte[] bArr = new byte[20];
            File file = new File(Environment.getRootDirectory(), "lib/libc.so");
            RandomAccessFile canRead = file.canRead();
            if (canRead != 0) {
                try {
                    try {
                        randomAccessFile = new RandomAccessFile(file, "r");
                        try {
                            randomAccessFile.readFully(bArr);
                            switch (bArr[18] | (bArr[19] << 8)) {
                                case 3:
                                    qrC = ARCH.X86;
                                    break;
                                case 8:
                                    qrC = ARCH.MIPS;
                                    break;
                                case 40:
                                    qrC = ARCH.ARM;
                                    break;
                                case 183:
                                    qrC = ARCH.ARM64;
                                    break;
                                default:
                                    Log.e("NativeBitmapFactory", "libc.so is unknown arch: " + Integer.toHexString(i));
                                    break;
                            }
                            if (randomAccessFile != null) {
                                try {
                                    randomAccessFile.close();
                                } catch (IOException e) {
                                    e.printStackTrace();
                                }
                            }
                        } catch (FileNotFoundException e2) {
                            e = e2;
                            e.printStackTrace();
                            if (randomAccessFile != null) {
                                try {
                                    randomAccessFile.close();
                                } catch (IOException e3) {
                                    e3.printStackTrace();
                                }
                            }
                            return qrC;
                        } catch (IOException e4) {
                            e = e4;
                            e.printStackTrace();
                            if (randomAccessFile != null) {
                                try {
                                    randomAccessFile.close();
                                } catch (IOException e5) {
                                    e5.printStackTrace();
                                }
                            }
                            return qrC;
                        }
                    } catch (Throwable th) {
                        th = th;
                        if (canRead != 0) {
                            try {
                                canRead.close();
                            } catch (IOException e6) {
                                e6.printStackTrace();
                            }
                        }
                        throw th;
                    }
                } catch (FileNotFoundException e7) {
                    e = e7;
                    randomAccessFile = null;
                } catch (IOException e8) {
                    e = e8;
                    randomAccessFile = null;
                } catch (Throwable th2) {
                    th = th2;
                    canRead = 0;
                    if (canRead != 0) {
                    }
                    throw th;
                }
            }
        }
        return qrC;
    }

    public static String get_CPU_ABI() {
        return Build.CPU_ABI;
    }

    public static String get_CPU_ABI2() {
        try {
            Field declaredField = Build.class.getDeclaredField("CPU_ABI2");
            if (declaredField == null) {
                return null;
            }
            Object obj = declaredField.get(null);
            if (obj instanceof String) {
                return (String) obj;
            }
            return null;
        } catch (Exception e) {
            return null;
        }
    }

    public static boolean supportABI(String str) {
        String _cpu_abi = get_CPU_ABI();
        if (TextUtils.isEmpty(_cpu_abi) || !_cpu_abi.equalsIgnoreCase(str)) {
            return !TextUtils.isEmpty(get_CPU_ABI2()) && _cpu_abi.equalsIgnoreCase(str);
        }
        return true;
    }

    public static boolean isMiBox2Device() {
        return Build.MANUFACTURER.equalsIgnoreCase("Xiaomi") && Build.PRODUCT.equalsIgnoreCase("dredd");
    }

    public static boolean isMagicBoxDevice() {
        return Build.MANUFACTURER.equalsIgnoreCase("MagicBox") && Build.PRODUCT.equalsIgnoreCase("MagicBox");
    }

    public static boolean isProblemBoxDevice() {
        return isMiBox2Device() || isMagicBoxDevice();
    }

    public static boolean isRealARMArch() {
        return (supportABI("armeabi-v7a") || supportABI("armeabi")) && ARCH.ARM.equals(eIr());
    }

    public static boolean isRealX86Arch() {
        return supportABI("x86") || ARCH.X86.equals(eIr());
    }
}
