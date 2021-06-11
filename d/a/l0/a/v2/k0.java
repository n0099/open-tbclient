package d.a.l0.a.v2;

import android.annotation.SuppressLint;
import android.os.Environment;
import android.os.StatFs;
import android.text.TextUtils;
import android.util.Log;
import com.baidu.android.util.devices.StorageUtils;
import com.baidu.searchbox.common.runtime.AppRuntime;
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
public final class k0 {

    /* renamed from: a  reason: collision with root package name */
    public static final boolean f49096a = d.a.l0.a.k.f46875a;

    /* loaded from: classes3.dex */
    public static class a {

        /* renamed from: a  reason: collision with root package name */
        public final String f49097a;

        public a(String str, boolean z, boolean z2, int i2) {
            this.f49097a = str;
        }
    }

    public static int a() {
        if (b()) {
            return (int) (new StatFs(Environment.getExternalStorageDirectory().getPath()).getTotalBytes() / 1024);
        }
        return -1;
    }

    public static boolean b() {
        return Environment.getExternalStorageState().equals("mounted");
    }

    public static long c() {
        long blockSize;
        long availableBlocks;
        if (b()) {
            StatFs statFs = new StatFs(Environment.getExternalStorageDirectory().getPath());
            if (d.d()) {
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

    /* JADX WARN: Removed duplicated region for block: B:106:0x01cc  */
    @SuppressLint({"NewApi"})
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public static List<a> d() {
        HashSet hashSet;
        BufferedReader bufferedReader;
        String str;
        int i2;
        HashMap hashMap = new HashMap();
        ArrayList arrayList = new ArrayList();
        BufferedReader bufferedReader2 = null;
        File externalFilesDir = AppRuntime.getAppContext().getExternalFilesDir(null);
        String path = externalFilesDir == null ? null : externalFilesDir.getPath();
        int i3 = 1;
        boolean z = false;
        boolean z2 = d.b() ? !Environment.isExternalStorageRemovable() : false;
        String externalStorageState = Environment.getExternalStorageState();
        boolean z3 = externalStorageState.equals("mounted") || externalStorageState.equals("mounted_ro");
        boolean equals = Environment.getExternalStorageState().equals("mounted_ro");
        try {
            try {
                hashSet = new HashSet();
                bufferedReader = new BufferedReader(new FileReader("/proc/mounts"));
            } catch (Throwable th) {
                th = th;
            }
            try {
                if (f49096a) {
                    Log.d(StorageUtils.TAG, "/proc/mounts");
                }
                while (true) {
                    String readLine = bufferedReader.readLine();
                    if (readLine == null) {
                        break;
                    }
                    if (f49096a) {
                        Log.d(StorageUtils.TAG, readLine);
                    }
                    StringTokenizer stringTokenizer = new StringTokenizer(readLine, " ");
                    String nextToken = stringTokenizer.nextToken();
                    String nextToken2 = stringTokenizer.nextToken();
                    if (!hashSet.contains(nextToken2)) {
                        stringTokenizer.nextToken();
                        boolean contains = Arrays.asList(stringTokenizer.nextToken().split(",")).contains("ro");
                        if (!readLine.contains("vfat") && !readLine.contains("/mnt")) {
                            if (e(nextToken, nextToken2)) {
                                hashSet.add(nextToken2);
                                if (f(nextToken2)) {
                                    i2 = i3 + 1;
                                    arrayList.add(new a(nextToken2, z, contains, i3));
                                    i3 = i2;
                                }
                            }
                            z = false;
                        }
                        if (nextToken2.equals(path)) {
                            hashSet.add(path);
                            hashMap.put(nextToken, new a(path, z2, contains, -1));
                        } else if (readLine.contains("/dev/block/vold")) {
                            if (!readLine.contains("/mnt/secure") && !readLine.contains("/mnt/asec") && !readLine.contains("/mnt/obb") && !readLine.contains("/dev/mapper") && !readLine.contains("tmpfs")) {
                                hashSet.add(nextToken2);
                                if (!hashMap.containsKey(nextToken)) {
                                    i2 = i3 + 1;
                                    hashMap.put(nextToken, new a(nextToken2, z, contains, i3));
                                    i3 = i2;
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
                                if (TextUtils.equals(((a) hashMap.get(str)).f49097a, nextToken)) {
                                    break;
                                }
                            }
                            hashMap.remove(str);
                            hashSet.add(nextToken2);
                            if (!hashMap.containsKey(nextToken)) {
                                hashMap.put(nextToken, new a(nextToken2, false, contains, i3));
                                i3++;
                            }
                        }
                        z = false;
                    }
                }
                for (a aVar : hashMap.values()) {
                    if (f(aVar.f49097a)) {
                        arrayList.add(aVar);
                    }
                }
                if (!hashSet.contains(path) && z3) {
                    arrayList.add(0, new a(path, z2, equals, -1));
                }
                d.a.l0.t.d.d(bufferedReader);
            } catch (FileNotFoundException e2) {
                e = e2;
                bufferedReader2 = bufferedReader;
                if (f49096a) {
                    e.printStackTrace();
                }
                d.a.l0.t.d.d(bufferedReader2);
                if (arrayList.isEmpty()) {
                }
                return arrayList;
            } catch (IOException e3) {
                e = e3;
                bufferedReader2 = bufferedReader;
                if (f49096a) {
                    e.printStackTrace();
                }
                d.a.l0.t.d.d(bufferedReader2);
                if (arrayList.isEmpty()) {
                }
                return arrayList;
            } catch (Throwable th2) {
                th = th2;
                bufferedReader2 = bufferedReader;
                d.a.l0.t.d.d(bufferedReader2);
                throw th;
            }
        } catch (FileNotFoundException e4) {
            e = e4;
            bufferedReader2 = null;
        } catch (IOException e5) {
            e = e5;
            bufferedReader2 = null;
        } catch (Throwable th3) {
            th = th3;
            bufferedReader2 = null;
        }
        if (arrayList.isEmpty()) {
            arrayList.add(new a(path, z2, equals, -1));
        }
        return arrayList;
    }

    public static boolean e(String str, String str2) {
        if (str == null || !str.contains("/dev/fuse") || str2 == null || str2.startsWith("/storage/emulated/legacy") || str2.contains("/Android/obb")) {
            return false;
        }
        if (str2.startsWith("/storage/")) {
            return true;
        }
        return (!d.e() || str2.startsWith("/mnt/") || str2.startsWith("/data/")) ? false : true;
    }

    public static boolean f(String str) {
        if (TextUtils.isEmpty(str)) {
            return false;
        }
        return new File(str).canRead();
    }
}
