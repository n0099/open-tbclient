package com.tencent.open.a;

import android.annotation.SuppressLint;
import android.os.Environment;
import android.os.StatFs;
import java.io.File;
import java.text.SimpleDateFormat;
/* loaded from: classes7.dex */
public class d {

    /* loaded from: classes7.dex */
    public static final class a {
        public static final boolean a(int i, int i2) {
            return i2 == (i & i2);
        }
    }

    /* loaded from: classes7.dex */
    public static final class b {
        public static boolean a() {
            String externalStorageState = Environment.getExternalStorageState();
            return "mounted".equals(externalStorageState) || "mounted_ro".equals(externalStorageState);
        }

        public static c b() {
            if (a()) {
                return c.b(Environment.getExternalStorageDirectory());
            }
            return null;
        }
    }

    /* loaded from: classes7.dex */
    public static class c {

        /* renamed from: a  reason: collision with root package name */
        public File f39207a;

        /* renamed from: b  reason: collision with root package name */
        public long f39208b;

        /* renamed from: c  reason: collision with root package name */
        public long f39209c;

        public File a() {
            return this.f39207a;
        }

        public long b() {
            return this.f39208b;
        }

        public long c() {
            return this.f39209c;
        }

        public String toString() {
            return String.format("[%s : %d / %d]", a().getAbsolutePath(), Long.valueOf(c()), Long.valueOf(b()));
        }

        public void a(File file) {
            this.f39207a = file;
        }

        public void b(long j) {
            this.f39209c = j;
        }

        public static c b(File file) {
            StatFs statFs;
            c cVar = new c();
            cVar.a(file);
            long blockSize = new StatFs(file.getAbsolutePath()).getBlockSize();
            cVar.a(statFs.getBlockCount() * blockSize);
            cVar.b(statFs.getAvailableBlocks() * blockSize);
            return cVar;
        }

        public void a(long j) {
            this.f39208b = j;
        }
    }

    /* renamed from: com.tencent.open.a.d$d  reason: collision with other inner class name */
    /* loaded from: classes7.dex */
    public static final class C0516d {
        @SuppressLint({"SimpleDateFormat"})
        public static SimpleDateFormat a(String str) {
            return new SimpleDateFormat(str);
        }
    }
}
