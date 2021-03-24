package com.bytedance.sdk.openadsdk.preload.geckox.utils;

import android.os.Process;
import java.io.File;
import java.util.HashMap;
import java.util.Map;
/* loaded from: classes6.dex */
public class FileLock {

    /* renamed from: a  reason: collision with root package name */
    public static final Map<String, Integer> f30340a = new HashMap();

    /* renamed from: b  reason: collision with root package name */
    public final int f30341b;

    /* renamed from: c  reason: collision with root package name */
    public final String f30342c;

    static {
        g.a("file_lock_pg");
    }

    public FileLock(String str, int i) {
        this.f30342c = str;
        this.f30341b = i;
    }

    public static FileLock a(String str) {
        try {
            int d2 = d(str);
            nLockFile(d2);
            return new FileLock(str, d2);
        } catch (Exception e2) {
            throw new RuntimeException("lock failed, file:" + str + ", pid:" + Process.myPid() + " caused by:" + e2.getMessage());
        }
    }

    public static FileLock b(String str) {
        try {
            int d2 = d(str);
            if (nTryLock(d2)) {
                return new FileLock(str, d2);
            }
            return null;
        } catch (Exception e2) {
            throw new RuntimeException("try lock failed, file:" + str + " caused by:" + e2.getMessage());
        }
    }

    public static FileLock c(String str) throws Exception {
        try {
            int d2 = d(str);
            if (!nTryLock(d2)) {
                new FileLock(str, d2).b();
                return null;
            }
            return new FileLock(str, d2);
        } catch (Exception e2) {
            throw new RuntimeException("try lock failed, file:" + str + " caused by:" + e2.getMessage());
        }
    }

    public static int d(String str) throws Exception {
        Integer num;
        synchronized (f30340a) {
            num = f30340a.get(str);
            if (num == null) {
                new File(str).getParentFile().mkdirs();
                num = Integer.valueOf(nGetFD(str));
                f30340a.put(str, num);
            }
        }
        return num.intValue();
    }

    public static native int nGetFD(String str) throws Exception;

    public static native void nLockFile(int i) throws Exception;

    public static native void nLockFileSegment(int i, int i2) throws Exception;

    public static native void nRelease(int i) throws Exception;

    public static native boolean nTryLock(int i) throws Exception;

    public static native void nUnlockFile(int i) throws Exception;

    public static FileLock a(String str, int i) {
        try {
            int d2 = d(str);
            nLockFileSegment(d2, i);
            return new FileLock(str, d2);
        } catch (Exception e2) {
            throw new RuntimeException("lock segment failed, file:" + str + " caused by:" + e2.getMessage());
        }
    }

    public void b() {
        Integer remove;
        synchronized (f30340a) {
            remove = f30340a.remove(this.f30342c);
        }
        try {
            nRelease(remove.intValue());
        } catch (Exception e2) {
            throw new RuntimeException("release lock failed, file:" + this.f30342c + " caused by:" + e2.getMessage());
        }
    }

    public void a() {
        try {
            nUnlockFile(this.f30341b);
        } catch (Exception unused) {
            throw new RuntimeException("release lock failed，path:" + this.f30342c);
        }
    }
}
