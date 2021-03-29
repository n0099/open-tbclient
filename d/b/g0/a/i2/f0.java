package d.b.g0.a.i2;

import android.annotation.SuppressLint;
import android.os.Environment;
import android.os.StatFs;
import android.text.TextUtils;
import android.util.Log;
import com.baidu.android.util.devices.StorageUtils;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.StringTokenizer;
/* loaded from: classes3.dex */
public final class f0 {

    /* renamed from: a  reason: collision with root package name */
    public static final boolean f44685a = d.b.g0.a.k.f45051a;

    /* loaded from: classes3.dex */
    public static class a {

        /* renamed from: a  reason: collision with root package name */
        public final String f44686a;

        public a(String str, boolean z, boolean z2, int i) {
            this.f44686a = str;
        }
    }

    public static boolean a() {
        return Environment.getExternalStorageState().equals("mounted");
    }

    public static long b() {
        long blockSize;
        long availableBlocks;
        if (a()) {
            StatFs statFs = new StatFs(Environment.getExternalStorageDirectory().getPath());
            if (c.d()) {
                blockSize = statFs.getBlockSizeLong();
                availableBlocks = statFs.getAvailableBlocksLong();
            } else {
                blockSize = statFs.getBlockSize();
                availableBlocks = statFs.getAvailableBlocks();
            }
            return availableBlocks * blockSize;
        }
        return -1L;
    }

    /* JADX DEBUG: Failed to insert an additional move for type inference into block B:101:0x01b8 */
    /* JADX DEBUG: Failed to insert an additional move for type inference into block B:104:0x003f */
    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r9v0, types: [java.lang.String] */
    /* JADX WARN: Type inference failed for: r9v13 */
    /* JADX WARN: Type inference failed for: r9v14 */
    /* JADX WARN: Type inference failed for: r9v15 */
    /* JADX WARN: Type inference failed for: r9v16 */
    /* JADX WARN: Type inference failed for: r9v4 */
    /* JADX WARN: Type inference failed for: r9v7, types: [java.io.Closeable] */
    @SuppressLint({"NewApi"})
    public static List<a> c() {
        BufferedReader bufferedReader;
        BufferedReader bufferedReader2;
        HashSet hashSet;
        BufferedReader bufferedReader3;
        String str;
        int i;
        HashMap hashMap = new HashMap();
        ArrayList arrayList = new ArrayList();
        String g2 = d.b.g0.a.a2.b.g();
        int i2 = 1;
        boolean z = false;
        boolean z2 = c.b() ? !Environment.isExternalStorageRemovable() : false;
        String externalStorageState = Environment.getExternalStorageState();
        BufferedReader bufferedReader4 = "mounted_ro";
        boolean z3 = externalStorageState.equals("mounted") || externalStorageState.equals("mounted_ro");
        boolean equals = Environment.getExternalStorageState().equals("mounted_ro");
        try {
            try {
                hashSet = new HashSet();
                bufferedReader3 = new BufferedReader(new FileReader("/proc/mounts"));
            } catch (Throwable th) {
                th = th;
            }
            try {
                if (f44685a) {
                    Log.d(StorageUtils.TAG, "/proc/mounts");
                }
                while (true) {
                    String readLine = bufferedReader3.readLine();
                    if (readLine == null) {
                        break;
                    }
                    if (f44685a) {
                        Log.d(StorageUtils.TAG, readLine);
                    }
                    StringTokenizer stringTokenizer = new StringTokenizer(readLine, " ");
                    String nextToken = stringTokenizer.nextToken();
                    String nextToken2 = stringTokenizer.nextToken();
                    if (!hashSet.contains(nextToken2)) {
                        stringTokenizer.nextToken();
                        boolean contains = Arrays.asList(stringTokenizer.nextToken().split(",")).contains("ro");
                        if (!readLine.contains("vfat") && !readLine.contains("/mnt")) {
                            if (d(nextToken, nextToken2)) {
                                hashSet.add(nextToken2);
                                if (e(nextToken2)) {
                                    i = i2 + 1;
                                    arrayList.add(new a(nextToken2, z, contains, i2));
                                    i2 = i;
                                }
                            }
                            z = false;
                        }
                        if (nextToken2.equals(g2)) {
                            hashSet.add(g2);
                            hashMap.put(nextToken, new a(g2, z2, contains, -1));
                        } else if (readLine.contains("/dev/block/vold")) {
                            if (!readLine.contains("/mnt/secure") && !readLine.contains("/mnt/asec") && !readLine.contains("/mnt/obb") && !readLine.contains("/dev/mapper") && !readLine.contains("tmpfs")) {
                                hashSet.add(nextToken2);
                                if (!hashMap.containsKey(nextToken)) {
                                    i = i2 + 1;
                                    hashMap.put(nextToken, new a(nextToken2, z, contains, i2));
                                    i2 = i;
                                }
                            }
                        } else if (hashSet.contains(nextToken)) {
                            Iterator it = hashMap.keySet().iterator();
                            while (true) {
                                if (!it.hasNext()) {
                                    str = null;
                                    break;
                                }
                                str = (String) it.next();
                                if (TextUtils.equals(((a) hashMap.get(str)).f44686a, nextToken)) {
                                    break;
                                }
                            }
                            hashMap.remove(str);
                            hashSet.add(nextToken2);
                            if (!hashMap.containsKey(nextToken)) {
                                hashMap.put(nextToken, new a(nextToken2, false, contains, i2));
                                i2++;
                            }
                        }
                        z = false;
                    }
                }
                for (a aVar : hashMap.values()) {
                    if (e(aVar.f44686a)) {
                        arrayList.add(aVar);
                    }
                }
                if (!hashSet.contains(g2) && z3) {
                    arrayList.add(0, new a(g2, z2, equals, -1));
                }
                d.b.g0.p.d.a(bufferedReader3);
            } catch (FileNotFoundException e2) {
                e = e2;
                bufferedReader2 = bufferedReader3;
                bufferedReader4 = bufferedReader2;
                if (f44685a) {
                    e.printStackTrace();
                    bufferedReader4 = bufferedReader2;
                }
                d.b.g0.p.d.a(bufferedReader4);
                return arrayList;
            } catch (IOException e3) {
                e = e3;
                bufferedReader = bufferedReader3;
                bufferedReader4 = bufferedReader;
                if (f44685a) {
                    e.printStackTrace();
                    bufferedReader4 = bufferedReader;
                }
                d.b.g0.p.d.a(bufferedReader4);
                return arrayList;
            } catch (Throwable th2) {
                th = th2;
                bufferedReader4 = bufferedReader3;
                d.b.g0.p.d.a(bufferedReader4);
                throw th;
            }
        } catch (FileNotFoundException e4) {
            e = e4;
            bufferedReader2 = null;
        } catch (IOException e5) {
            e = e5;
            bufferedReader = null;
        } catch (Throwable th3) {
            th = th3;
            bufferedReader4 = null;
        }
        return arrayList;
    }

    public static boolean d(String str, String str2) {
        if (str == null || !str.contains("/dev/fuse") || str2 == null || str2.startsWith("/storage/emulated/legacy") || str2.contains("/Android/obb")) {
            return false;
        }
        if (str2.startsWith("/storage/")) {
            return true;
        }
        return (!c.e() || str2.startsWith("/mnt/") || str2.startsWith("/data/")) ? false : true;
    }

    public static boolean e(String str) {
        if (TextUtils.isEmpty(str)) {
            return false;
        }
        return new File(str).canRead();
    }
}
