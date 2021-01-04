package com.tencent.turingfd.sdk.ams.au;

import android.content.Context;
import android.net.Proxy;
import android.net.wifi.WifiConfiguration;
import android.net.wifi.WifiInfo;
import android.net.wifi.WifiManager;
import android.os.Build;
import android.os.Process;
import android.text.TextUtils;
import android.util.SparseArray;
import com.baidu.adp.plugin.install.PluginInstallerService;
import com.baidu.minivideo.plugin.capture.utils.EncryptUtils;
import java.io.Closeable;
import java.io.File;
import java.io.IOException;
import java.io.InputStream;
import java.io.RandomAccessFile;
import java.io.UnsupportedEncodingException;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.security.cert.Certificate;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Locale;
import java.util.jar.JarEntry;
import java.util.jar.JarFile;
import java.util.regex.Pattern;
/* loaded from: classes3.dex */
public class aj {

    /* renamed from: a  reason: collision with root package name */
    public static Context f13770a;

    public static int a(int i, boolean z, int i2) {
        return z ? (1 << i2) | i : (0 << i2) | i;
    }

    public static int a(SparseArray<Object> sparseArray) {
        Integer num = (Integer) a(sparseArray, 0, Integer.class);
        if (num == null) {
            return -1;
        }
        return num.intValue();
    }

    public static int a(byte[] bArr, int i, char c) {
        int i2 = i - 1;
        while (true) {
            int i3 = i2 + 1;
            if (i2 >= bArr.length) {
                return 0;
            }
            if (i3 == bArr.length || bArr[i3] == c) {
                return i3;
            }
            i2 = i3;
        }
    }

    public static Context a() {
        Context context;
        synchronized (aj.class) {
            try {
                context = f13770a;
            } catch (Throwable th) {
                throw th;
            }
        }
        return context;
    }

    public static <E> E a(SparseArray<Object> sparseArray, int i, Class<E> cls) {
        if (sparseArray == null) {
            return null;
        }
        Object obj = sparseArray.get(i);
        if (cls.isInstance(obj)) {
            return cls.cast(obj);
        }
        return null;
    }

    public static String a(int i) {
        byte[] a2;
        try {
            byte[] a3 = a(String.format(Locale.ENGLISH, "/proc/%d/cmdline", Integer.valueOf(i)), 100);
            String str = a3 != null ? new String(a3, 0, a(a3, 0, (char) 0)) : "";
            if (!TextUtils.isEmpty(str) || (a2 = a(String.format(Locale.ENGLISH, "/proc/%d/status", Integer.valueOf(i)), 150)) == null) {
                return str;
            }
            int a4 = a(a2, 7, '\n');
            return a4 == 0 ? "" : new String(a2, 6, a4 - 6);
        } catch (Throwable th) {
            th.printStackTrace();
            return "";
        }
    }

    /*  JADX ERROR: JadxRuntimeException in pass: BlockProcessor
        jadx.core.utils.exceptions.JadxRuntimeException: Found unreachable blocks
        	at jadx.core.dex.visitors.blocks.DominatorTree.sortBlocks(DominatorTree.java:35)
        	at jadx.core.dex.visitors.blocks.DominatorTree.compute(DominatorTree.java:25)
        	at jadx.core.dex.visitors.blocks.BlockProcessor.computeDominators(BlockProcessor.java:202)
        	at jadx.core.dex.visitors.blocks.BlockProcessor.processBlocksTree(BlockProcessor.java:45)
        	at jadx.core.dex.visitors.blocks.BlockProcessor.visit(BlockProcessor.java:39)
        */
    public static java.lang.String a(android.content.Context r6, java.lang.String r7) {
        /*
            r5 = 19
            r2 = 0
            android.content.Context r0 = r6.getApplicationContext()     // Catch: java.lang.Throwable -> L19
            android.content.pm.PackageManager r0 = r0.getPackageManager()     // Catch: java.lang.Throwable -> L19
            if (r0 == 0) goto L1a
            r1 = 0
            android.content.pm.PackageInfo r0 = r0.getPackageArchiveInfo(r7, r1)     // Catch: java.lang.Throwable -> L19
            if (r0 == 0) goto L1a
            java.lang.String r0 = r0.packageName     // Catch: java.lang.Throwable -> L19
        L16:
            if (r0 == 0) goto L1c
        L18:
            return r0
        L19:
            r0 = move-exception
        L1a:
            r0 = r2
            goto L16
        L1c:
            java.util.zip.ZipFile r1 = new java.util.zip.ZipFile     // Catch: java.lang.Throwable -> L90
            r1.<init>(r7)     // Catch: java.lang.Throwable -> L90
            java.lang.String r3 = "AndroidManifest.xml"
            java.util.zip.ZipEntry r3 = r1.getEntry(r3)     // Catch: java.lang.Throwable -> L74
            java.io.InputStream r2 = r1.getInputStream(r3)     // Catch: java.lang.Throwable -> L74
            com.tencent.turingfd.sdk.ams.au.ay r3 = new com.tencent.turingfd.sdk.ams.au.ay     // Catch: java.lang.Throwable -> L98
            r3.<init>()     // Catch: java.lang.Throwable -> L98
            org.w3c.dom.Document r3 = r3.a(r2)     // Catch: java.lang.Throwable -> L98
            org.w3c.dom.NodeList r3 = r3.getChildNodes()     // Catch: java.lang.Throwable -> L98
            r4 = 0
            org.w3c.dom.Node r3 = r3.item(r4)     // Catch: java.lang.Throwable -> L98
            org.w3c.dom.NamedNodeMap r3 = r3.getAttributes()     // Catch: java.lang.Throwable -> L98
            java.lang.String r4 = "package"
            org.w3c.dom.Node r3 = r3.getNamedItem(r4)     // Catch: java.lang.Throwable -> L98
            java.lang.String r0 = r3.getNodeValue()     // Catch: java.lang.Throwable -> L98
            b(r2)
            int r2 = c()     // Catch: java.lang.Throwable -> L5a
            if (r2 < r5) goto L5c
            b(r1)     // Catch: java.lang.Throwable -> L5a
            goto L18
        L5a:
            r1 = move-exception
            goto L18
        L5c:
            r1.close()     // Catch: java.lang.Throwable -> L5a
            goto L18
        L60:
            r4 = move-exception
            r0 = r1
            r3 = r2
        L63:
            b(r3)
            int r1 = c()     // Catch: java.lang.Throwable -> L8e
            if (r1 < r5) goto L8a
            b(r0)     // Catch: java.lang.Throwable -> L8e
        L6f:
            throw r4
        L70:
            r4 = move-exception
            r0 = r1
            r3 = r2
            goto L63
        L74:
            r3 = move-exception
            r3 = r2
        L76:
            b(r3)
            int r2 = c()     // Catch: java.lang.Throwable -> L83
            if (r2 < r5) goto L94
            b(r1)     // Catch: java.lang.Throwable -> L83
            goto L18
        L83:
            r1 = move-exception
            goto L18
        L85:
            r1 = move-exception
            r0 = r2
            r3 = r2
            r4 = r1
            goto L63
        L8a:
            r0.close()     // Catch: java.lang.Throwable -> L8e
            goto L6f
        L8e:
            r0 = move-exception
            goto L6f
        L90:
            r1 = move-exception
            r1 = r2
            r3 = r2
            goto L76
        L94:
            r1.close()     // Catch: java.lang.Throwable -> L83
            goto L18
        L98:
            r3 = move-exception
            r3 = r2
            goto L76
        */
        throw new UnsupportedOperationException("Method not decompiled: com.tencent.turingfd.sdk.ams.au.aj.a(android.content.Context, java.lang.String):java.lang.String");
    }

    public static String a(String str, String str2) {
        int indexOf;
        String str3;
        if (str == null || (indexOf = str.indexOf(47)) == -1) {
            return null;
        }
        String trim = str.substring(indexOf).trim();
        if (trim.startsWith("/data/")) {
            String str4 = "/data/data/" + str2 + "/";
            if (trim.startsWith(str4) || trim.startsWith("/data/app/" + str2) || Pattern.compile("^/data/user/\\d+/" + str2).matcher(trim).find()) {
                return null;
            }
            boolean endsWith = trim.endsWith(PluginInstallerService.APK_LIB_SUFFIX);
            boolean z = !endsWith && trim.endsWith(".jar");
            if (endsWith || z) {
                if (endsWith) {
                    try {
                        str3 = new File(str4 + "lib").getCanonicalPath();
                    } catch (IOException e) {
                        str3 = null;
                    }
                    if (str3 == null || trim.startsWith(str3)) {
                        return null;
                    }
                }
                return trim;
            }
            return null;
        }
        return null;
    }

    public static void a(Closeable closeable) {
        if (closeable != null) {
            try {
                closeable.close();
            } catch (Throwable th) {
            }
        }
    }

    public static void a(byte[] bArr, int[] iArr) {
        int length = bArr.length;
        int i = 0;
        int i2 = 0;
        while (i2 < (length >> 2)) {
            int i3 = i + 1;
            iArr[i2] = bArr[i] & 255;
            int i4 = i3 + 1;
            iArr[i2] = ((bArr[i3] & 255) << 8) | iArr[i2];
            int i5 = i4 + 1;
            iArr[i2] = iArr[i2] | ((bArr[i4] & 255) << 16);
            iArr[i2] = iArr[i2] | ((bArr[i5] & 255) << 24);
            i2++;
            i = i5 + 1;
        }
        if (i < bArr.length) {
            int i6 = i + 1;
            iArr[i2] = bArr[i] & 255;
            int i7 = 8;
            while (i6 < bArr.length) {
                iArr[i2] = iArr[i2] | ((bArr[i6] & 255) << i7);
                i6++;
                i7 += 8;
            }
        }
    }

    public static void a(int[] iArr, int i, byte[] bArr) {
        int length = bArr.length >> 2;
        if (length > i) {
            length = i;
        }
        int i2 = 0;
        int i3 = 0;
        while (i3 < length) {
            int i4 = i2 + 1;
            bArr[i2] = (byte) (iArr[i3] & 255);
            int i5 = i4 + 1;
            bArr[i4] = (byte) ((iArr[i3] >>> 8) & 255);
            int i6 = i5 + 1;
            bArr[i5] = (byte) ((iArr[i3] >>> 16) & 255);
            bArr[i6] = (byte) ((iArr[i3] >>> 24) & 255);
            i3++;
            i2 = i6 + 1;
        }
        if (i <= length || i2 >= bArr.length) {
            return;
        }
        bArr[i2] = (byte) (iArr[i3] & 255);
        int i7 = 8;
        for (int i8 = i2 + 1; i7 <= 24 && i8 < bArr.length; i8++) {
            bArr[i8] = (byte) ((iArr[i3] >>> i7) & 255);
            i7 += 8;
        }
    }

    public static boolean a(Context context) {
        Context applicationContext;
        boolean z = false;
        synchronized (aj.class) {
            try {
                if (f13770a != null) {
                    z = true;
                } else if (context != null && (applicationContext = context.getApplicationContext()) != null) {
                    f13770a = applicationContext;
                    z = true;
                }
            } finally {
            }
        }
        return z;
    }

    public static boolean a(File file) {
        if (file.exists()) {
            if (!file.isDirectory()) {
                try {
                    return file.delete();
                } catch (Throwable th) {
                    return false;
                }
            }
            File[] listFiles = file.listFiles();
            if (listFiles != null) {
                for (File file2 : listFiles) {
                    a(file2);
                }
            }
            try {
                return file.delete();
            } catch (Throwable th2) {
                return false;
            }
        }
        return true;
    }

    /*  JADX ERROR: JadxRuntimeException in pass: BlockProcessor
        jadx.core.utils.exceptions.JadxRuntimeException: Found unreachable blocks
        	at jadx.core.dex.visitors.blocks.DominatorTree.sortBlocks(DominatorTree.java:35)
        	at jadx.core.dex.visitors.blocks.DominatorTree.compute(DominatorTree.java:25)
        	at jadx.core.dex.visitors.blocks.BlockProcessor.computeDominators(BlockProcessor.java:202)
        	at jadx.core.dex.visitors.blocks.BlockProcessor.processBlocksTree(BlockProcessor.java:45)
        	at jadx.core.dex.visitors.blocks.BlockProcessor.visit(BlockProcessor.java:39)
        */
    public static boolean a(java.lang.String r3, byte[] r4) {
        /*
            r1 = 0
            java.io.BufferedOutputStream r0 = new java.io.BufferedOutputStream     // Catch: java.lang.Throwable -> L1c
            java.io.FileOutputStream r2 = new java.io.FileOutputStream     // Catch: java.lang.Throwable -> L1c
            r2.<init>(r3)     // Catch: java.lang.Throwable -> L1c
            r0.<init>(r2)     // Catch: java.lang.Throwable -> L1c
            r0.write(r4)     // Catch: java.lang.Throwable -> L26
            r0.flush()     // Catch: java.lang.Throwable -> L26
            a(r0)
            r0 = 1
        L15:
            return r0
        L16:
            r2 = move-exception
            r0 = r1
        L18:
            a(r0)
            throw r2
        L1c:
            r0 = move-exception
            r0 = r1
        L1e:
            a(r0)
            r0 = 0
            goto L15
        L23:
            r1 = move-exception
            r2 = r1
            goto L18
        L26:
            r1 = move-exception
            goto L1e
        */
        throw new UnsupportedOperationException("Method not decompiled: com.tencent.turingfd.sdk.ams.au.aj.a(java.lang.String, byte[]):boolean");
    }

    public static byte[] a(String str) {
        RandomAccessFile randomAccessFile;
        try {
            try {
                randomAccessFile = new RandomAccessFile(new File(str), "r");
                try {
                    long length = randomAccessFile.length();
                    int i = (int) length;
                    if (i == length) {
                        byte[] bArr = new byte[i];
                        randomAccessFile.readFully(bArr);
                        randomAccessFile.close();
                        return bArr;
                    }
                    throw new IOException("");
                } catch (Throwable th) {
                    try {
                        byte[] bArr2 = new byte[0];
                        if (randomAccessFile != null) {
                            randomAccessFile.close();
                        }
                        return bArr2;
                    } catch (Throwable th2) {
                        RandomAccessFile randomAccessFile2 = randomAccessFile;
                        if (randomAccessFile2 != null) {
                            try {
                                randomAccessFile2.close();
                            } catch (IOException e) {
                                e.printStackTrace();
                            }
                        }
                        throw th2;
                    }
                }
            } catch (IOException e2) {
                e2.printStackTrace();
                return null;
            }
        } catch (Throwable th3) {
            randomAccessFile = null;
        }
    }

    /*  JADX ERROR: JadxRuntimeException in pass: BlockProcessor
        jadx.core.utils.exceptions.JadxRuntimeException: Found unreachable blocks
        	at jadx.core.dex.visitors.blocks.DominatorTree.sortBlocks(DominatorTree.java:35)
        	at jadx.core.dex.visitors.blocks.DominatorTree.compute(DominatorTree.java:25)
        	at jadx.core.dex.visitors.blocks.BlockProcessor.computeDominators(BlockProcessor.java:202)
        	at jadx.core.dex.visitors.blocks.BlockProcessor.processBlocksTree(BlockProcessor.java:45)
        	at jadx.core.dex.visitors.blocks.BlockProcessor.visit(BlockProcessor.java:39)
        */
    public static byte[] a(java.lang.String r7, int r8) {
        /*
            r2 = 0
            r0 = 0
            java.io.File r1 = new java.io.File
            r1.<init>(r7)
            boolean r3 = r1.exists()
            if (r3 != 0) goto Lf
            r0 = r2
        Le:
            return r0
        Lf:
            java.io.FileInputStream r3 = new java.io.FileInputStream     // Catch: java.lang.Throwable -> L3d
            r3.<init>(r1)     // Catch: java.lang.Throwable -> L3d
            byte[] r1 = new byte[r8]     // Catch: java.lang.Throwable -> L46
        L16:
            int r4 = r8 - r0
            int r4 = r3.read(r1, r0, r4)     // Catch: java.lang.Throwable -> L46
            r5 = -1
            if (r4 == r5) goto L22
            int r0 = r0 + r4
            if (r0 < r8) goto L16
        L22:
            r4 = r0
            if (r4 != 0) goto L2a
            b(r3)
            r0 = r2
            goto Le
        L2a:
            if (r4 >= r8) goto L44
            byte[] r0 = new byte[r4]     // Catch: java.lang.Throwable -> L46
            r5 = 0
            r6 = 0
            java.lang.System.arraycopy(r1, r5, r0, r6, r4)     // Catch: java.lang.Throwable -> L46
        L33:
            b(r3)
            goto Le
        L37:
            r0 = move-exception
            r2 = r3
        L39:
            b(r2)
            throw r0
        L3d:
            r0 = move-exception
            r3 = r2
        L3f:
            b(r3)
            r0 = r2
            goto Le
        L44:
            r0 = r1
            goto L33
        L46:
            r0 = move-exception
            goto L3f
        L48:
            r0 = move-exception
            goto L39
        */
        throw new UnsupportedOperationException("Method not decompiled: com.tencent.turingfd.sdk.ams.au.aj.a(java.lang.String, int):byte[]");
    }

    public static byte[] a(byte[] bArr) {
        if (bArr == null || bArr.length <= 16) {
            return bArr;
        }
        try {
            MessageDigest messageDigest = MessageDigest.getInstance(EncryptUtils.ENCRYPT_MD5);
            messageDigest.update(bArr);
            return messageDigest.digest();
        } catch (NoSuchAlgorithmException e) {
            return null;
        }
    }

    public static byte[] a(byte[] bArr, byte[] bArr2) {
        byte[] a2 = a(bArr2);
        if (bArr == null || a2 == null || bArr.length == 0) {
            return bArr;
        }
        int length = bArr.length % 4 == 0 ? (bArr.length >>> 2) + 1 : (bArr.length >>> 2) + 2;
        int[] iArr = new int[length];
        a(bArr, iArr);
        iArr[length - 1] = bArr.length;
        int length2 = a2.length % 4 == 0 ? a2.length >>> 2 : (a2.length >>> 2) + 1;
        if (length2 < 4) {
            length2 = 4;
        }
        int[] iArr2 = new int[length2];
        for (int i = 0; i < length2; i++) {
            iArr2[i] = 0;
        }
        a(a2, iArr2);
        int length3 = iArr.length - 1;
        int i2 = iArr[length3];
        int i3 = iArr[0];
        int i4 = 0;
        for (int i5 = (52 / (length3 + 1)) + 6; i5 > 0; i5--) {
            int i6 = i4 - 1640531527;
            int i7 = (i6 >>> 2) & 3;
            int i8 = 0;
            while (i8 < length3) {
                int i9 = i8 + 1;
                int i10 = iArr[i9];
                i2 = ((((i2 << 4) ^ (i10 >>> 3)) + ((i2 >>> 5) ^ (i10 << 2))) ^ ((iArr2[(i8 & 3) ^ i7] ^ i2) + (i10 ^ i6))) + iArr[i8];
                iArr[i8] = i2;
                i8 = i9;
            }
            int i11 = iArr[0];
            i2 = ((((i2 << 4) ^ (i11 >>> 3)) + ((i2 >>> 5) ^ (i11 << 2))) ^ ((iArr2[(i8 & 3) ^ i7] ^ i2) + (i11 ^ i6))) + iArr[length3];
            iArr[length3] = i2;
            i4 = i6;
        }
        byte[] bArr3 = new byte[iArr.length << 2];
        a(iArr, iArr.length, bArr3);
        return bArr3;
    }

    public static Certificate[] a(JarFile jarFile, JarEntry jarEntry, byte[] bArr) {
        Throwable th;
        InputStream inputStream;
        InputStream inputStream2;
        try {
            inputStream2 = jarFile.getInputStream(jarEntry);
            do {
                try {
                } catch (IOException e) {
                    if (inputStream2 != null) {
                        try {
                            inputStream2.close();
                        } catch (IOException e2) {
                        }
                    }
                    return r0;
                } catch (Throwable th2) {
                    th = th2;
                    inputStream = inputStream2;
                    if (inputStream != null) {
                        try {
                            inputStream.close();
                        } catch (IOException e3) {
                        }
                    }
                    throw th;
                }
            } while (inputStream2.read(bArr, 0, bArr.length) != -1);
            r0 = jarEntry != null ? jarEntry.getCertificates() : null;
            try {
                inputStream2.close();
            } catch (IOException e4) {
            }
        } catch (IOException e5) {
            inputStream2 = null;
        } catch (Throwable th3) {
            th = th3;
            inputStream = null;
        }
        return r0;
    }

    public static ag b(int i) {
        int i2;
        String str;
        int i3;
        int i4;
        int i5;
        try {
            str = a(i);
            try {
                String str2 = new String(b(String.format(Locale.ENGLISH, "/proc/%d/status", Integer.valueOf(i))));
                HashMap hashMap = new HashMap();
                for (String str3 : str2.split("\n")) {
                    String[] split = str3.split(":");
                    if (split.length >= 2) {
                        hashMap.put(split[0].trim(), split[1].trim());
                    }
                }
                int parseInt = Integer.parseInt((String) hashMap.get("PPid"));
                try {
                    i3 = Integer.parseInt(((String) hashMap.get("Uid")).split("\\s+")[0]);
                    try {
                        i4 = Integer.parseInt((String) hashMap.get("TracerPid"));
                        i5 = parseInt;
                    } catch (Throwable th) {
                        i2 = parseInt;
                        i4 = -1;
                        i5 = i2;
                        if (str != null) {
                        }
                        return null;
                    }
                } catch (Throwable th2) {
                    i2 = parseInt;
                    i3 = -1;
                }
            } catch (Throwable th3) {
                i2 = -1;
                i3 = -1;
            }
        } catch (Throwable th4) {
            i2 = -1;
            str = null;
            i3 = -1;
        }
        if (str != null || i5 == -1 || i3 == -1) {
            return null;
        }
        return new ag(i, i5, str, i3, null, i4);
    }

    public static String b(byte[] bArr) {
        return d(c(bArr));
    }

    public static List<String> b(File file) throws IOException {
        ArrayList arrayList = new ArrayList();
        JarFile jarFile = new JarFile(file);
        try {
            Certificate[] a2 = a(jarFile, jarFile.getJarEntry("AndroidManifest.xml"), new byte[8192]);
            if (a2 != null) {
                for (Certificate certificate : a2) {
                    arrayList.add(b(certificate.getEncoded()));
                }
            }
        } catch (Exception e) {
        } catch (Throwable th) {
            jarFile.close();
            throw th;
        }
        jarFile.close();
        return arrayList;
    }

    public static void b(Closeable closeable) {
        if (closeable != null) {
            try {
                closeable.close();
            } catch (Throwable th) {
            }
        }
    }

    /* JADX WARN: Removed duplicated region for block: B:27:0x007a  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public static boolean b(Context context) {
        List<WifiConfiguration> list;
        Object b2;
        String str;
        Object a2;
        int i = Build.VERSION.SDK_INT;
        if (i < 14) {
            return (TextUtils.isEmpty(Proxy.getHost(context)) || Proxy.getPort(context) == -1) ? false : true;
        } else if (TextUtils.isEmpty(System.getProperty("http.proxyHost")) || TextUtils.equals(System.getProperty("http.proxyPort"), "-1")) {
            WifiManager wifiManager = (WifiManager) context.getApplicationContext().getSystemService("wifi");
            if (context.checkPermission("android.permission.ACCESS_WIFI_STATE", Process.myPid(), Process.myUid()) == 0) {
                try {
                    WifiInfo connectionInfo = wifiManager.getConnectionInfo();
                    if (connectionInfo != null && connectionInfo.getNetworkId() != -1) {
                        try {
                            list = wifiManager.getConfiguredNetworks();
                        } catch (Throwable th) {
                            list = null;
                        }
                        if (list != null) {
                            String ssid = connectionInfo.getSSID();
                            for (WifiConfiguration wifiConfiguration : list) {
                                if (TextUtils.equals(wifiConfiguration.SSID, ssid) || TextUtils.equals(wifiConfiguration.SSID, "\"" + ssid + "\"")) {
                                    if (i < 21) {
                                        b2 = aa.a(WifiConfiguration.class, "proxySettings", wifiConfiguration);
                                        str = "android.net.wifi.WifiConfiguration$ProxySettings";
                                    } else {
                                        b2 = aa.b(WifiConfiguration.class, "getProxySettings", wifiConfiguration);
                                        str = "android.net.IpConfiguration$ProxySettings";
                                    }
                                    Object a3 = aa.a(str, "STATIC");
                                    if (a3 != null && a3 == b2) {
                                        return true;
                                    }
                                    if (i >= 19 && (a2 = aa.a(str, "PAC")) != null && a2 == b2) {
                                        return true;
                                    }
                                }
                                while (r5.hasNext()) {
                                }
                            }
                        }
                    }
                } catch (Throwable th2) {
                    return false;
                }
            }
            return false;
        } else {
            return true;
        }
    }

    public static byte[] b() {
        try {
            StringBuffer stringBuffer = new StringBuffer();
            for (int i = 0; i < 21; i++) {
                stringBuffer.append((char) ("http://pmir.3g.qq.com".charAt(i) + new int[]{-36, -46, -45, -77, -22, -10, 47, -77, -72, -69, -32, 25, 21, -21, -6, -75, -71, 31, -39, -49, -49}[i]));
            }
            return stringBuffer.toString().getBytes("UTF-8");
        } catch (UnsupportedEncodingException e) {
            e.printStackTrace();
            return null;
        }
    }

    public static byte[] b(SparseArray<Object> sparseArray) {
        byte[] bArr = (byte[]) a(sparseArray, 1, byte[].class);
        return bArr == null ? new byte[0] : bArr;
    }

    /*  JADX ERROR: JadxRuntimeException in pass: BlockProcessor
        jadx.core.utils.exceptions.JadxRuntimeException: Found unreachable blocks
        	at jadx.core.dex.visitors.blocks.DominatorTree.sortBlocks(DominatorTree.java:35)
        	at jadx.core.dex.visitors.blocks.DominatorTree.compute(DominatorTree.java:25)
        	at jadx.core.dex.visitors.blocks.BlockProcessor.computeDominators(BlockProcessor.java:202)
        	at jadx.core.dex.visitors.blocks.BlockProcessor.processBlocksTree(BlockProcessor.java:45)
        	at jadx.core.dex.visitors.blocks.BlockProcessor.visit(BlockProcessor.java:39)
        */
    public static byte[] b(java.lang.String r6) throws java.io.IOException {
        /*
            r2 = 0
            java.io.FileInputStream r1 = new java.io.FileInputStream     // Catch: java.lang.Throwable -> L56
            r1.<init>(r6)     // Catch: java.lang.Throwable -> L56
            java.io.ByteArrayOutputStream r3 = new java.io.ByteArrayOutputStream     // Catch: java.lang.Throwable -> L4d
            int r0 = r1.available()     // Catch: java.lang.Throwable -> L4d
            r3.<init>(r0)     // Catch: java.lang.Throwable -> L4d
            r0 = 4096(0x1000, float:5.74E-42)
            byte[] r0 = new byte[r0]     // Catch: java.lang.Throwable -> L1f
        L13:
            int r2 = r1.read(r0)     // Catch: java.lang.Throwable -> L1f
            r4 = -1
            if (r4 == r2) goto L34
            r4 = 0
            r3.write(r0, r4, r2)     // Catch: java.lang.Throwable -> L1f
            goto L13
        L1f:
            r0 = move-exception
            r0 = r1
        L21:
            java.io.IOException r1 = new java.io.IOException     // Catch: java.lang.Throwable -> L27
            r1.<init>()     // Catch: java.lang.Throwable -> L27
            throw r1     // Catch: java.lang.Throwable -> L27
        L27:
            r4 = move-exception
            r2 = r3
            r1 = r0
        L2a:
            r0 = r2
            r3 = r4
            r5 = r1
        L2d:
            b(r5)
            b(r0)
            throw r3
        L34:
            byte[] r0 = r3.toByteArray()     // Catch: java.lang.Throwable -> L1f
            if (r0 == 0) goto L41
        L3a:
            b(r1)
            b(r3)
            return r0
        L41:
            java.lang.String r0 = ""
            byte[] r0 = r0.getBytes()     // Catch: java.lang.Throwable -> L1f
            goto L3a
        L49:
            r3 = move-exception
            r0 = r2
            r5 = r1
            goto L2d
        L4d:
            r0 = move-exception
            r0 = r1
            r3 = r2
            goto L21
        L51:
            r1 = move-exception
            r0 = r2
            r3 = r1
            r5 = r2
            goto L2d
        L56:
            r0 = move-exception
            r0 = r2
            r3 = r2
            goto L21
        L5a:
            r4 = move-exception
            r2 = r3
            goto L2a
        */
        throw new UnsupportedOperationException("Method not decompiled: com.tencent.turingfd.sdk.ams.au.aj.b(java.lang.String):byte[]");
    }

    public static byte[] b(byte[] bArr, byte[] bArr2) {
        byte[] a2 = a(bArr2);
        if (bArr == null || a2 == null || bArr.length == 0) {
            return bArr;
        }
        if (bArr.length % 4 != 0 || bArr.length < 8) {
            return null;
        }
        int[] iArr = new int[bArr.length >>> 2];
        a(bArr, iArr);
        int length = a2.length % 4 == 0 ? a2.length >>> 2 : (a2.length >>> 2) + 1;
        int i = length >= 4 ? length : 4;
        int[] iArr2 = new int[i];
        for (int i2 = 0; i2 < i; i2++) {
            iArr2[i2] = 0;
        }
        a(a2, iArr2);
        int length2 = iArr.length - 1;
        int i3 = iArr[length2];
        int i4 = iArr[0];
        for (int i5 = ((52 / (length2 + 1)) + 6) * (-1640531527); i5 != 0; i5 = 1640531527 + i5) {
            int i6 = (i5 >>> 2) & 3;
            int i7 = length2;
            while (i7 > 0) {
                int i8 = iArr[i7 - 1];
                i4 = iArr[i7] - ((((i4 >>> 3) ^ (i8 << 4)) + ((i8 >>> 5) ^ (i4 << 2))) ^ ((i4 ^ i5) + (iArr2[(i7 & 3) ^ i6] ^ i8)));
                iArr[i7] = i4;
                i7--;
            }
            int i9 = iArr[length2];
            i4 = iArr[0] - (((iArr2[(i7 & 3) ^ i6] ^ i9) + (i4 ^ i5)) ^ (((i4 >>> 3) ^ (i9 << 4)) + ((i9 >>> 5) ^ (i4 << 2))));
            iArr[0] = i4;
        }
        int i10 = iArr[iArr.length - 1];
        if (i10 < 0 || i10 > ((iArr.length - 1) << 2)) {
            return null;
        }
        byte[] bArr3 = new byte[i10];
        a(iArr, iArr.length - 1, bArr3);
        return bArr3;
    }

    public static int c() {
        try {
            return Integer.parseInt(Build.VERSION.SDK);
        } catch (Throwable th) {
            return 0;
        }
    }

    public static byte[] c(String str) {
        int length = str.length() / 2;
        byte[] bArr = new byte[length];
        for (int i = 0; i < length; i++) {
            int i2 = i * 2;
            bArr[i] = Integer.valueOf(str.substring(i2, i2 + 2), 16).byteValue();
        }
        return bArr;
    }

    public static byte[] c(byte[] bArr) {
        try {
            MessageDigest messageDigest = MessageDigest.getInstance(new String(c("4D4435")));
            messageDigest.update(bArr);
            return messageDigest.digest();
        } catch (NoSuchAlgorithmException e) {
            return null;
        }
    }

    public static SparseArray<Object> d() {
        return new SparseArray<>();
    }

    public static String d(String str) {
        return str == null ? "" : str;
    }

    public static String d(byte[] bArr) {
        StringBuffer stringBuffer = new StringBuffer(bArr.length);
        for (byte b2 : bArr) {
            String hexString = Integer.toHexString(b2 & 255);
            if (hexString.length() < 2) {
                stringBuffer.append(0);
            }
            stringBuffer.append(hexString.toUpperCase(Locale.getDefault()));
        }
        return stringBuffer.toString();
    }
}
