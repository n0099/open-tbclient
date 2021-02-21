package com.tencent.open.a;

import android.annotation.SuppressLint;
import android.os.Environment;
import android.os.StatFs;
import java.io.File;
import java.text.SimpleDateFormat;
/* loaded from: classes15.dex */
public class d {

    /* loaded from: classes15.dex */
    public static final class a {
        public static final boolean a(int i, int i2) {
            return i2 == (i & i2);
        }
    }

    /* renamed from: com.tencent.open.a.d$d  reason: collision with other inner class name */
    /* loaded from: classes15.dex */
    public static final class C1270d {
        @SuppressLint({"SimpleDateFormat"})
        public static SimpleDateFormat a(String str) {
            return new SimpleDateFormat(str);
        }
    }

    /* loaded from: classes15.dex */
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

    /* loaded from: classes15.dex */
    public static class c {

        /* renamed from: a  reason: collision with root package name */
        private File f13377a;

        /* renamed from: b  reason: collision with root package name */
        private long f13378b;
        private long c;

        public File a() {
            return this.f13377a;
        }

        public void a(File file) {
            this.f13377a = file;
        }

        public long b() {
            return this.f13378b;
        }

        public void a(long j) {
            this.f13378b = j;
        }

        public long c() {
            return this.c;
        }

        public void b(long j) {
            this.c = j;
        }

        public static c b(File file) {
            StatFs statFs;
            c cVar = new c();
            cVar.a(file);
            long blockSize = new StatFs(file.getAbsolutePath()).getBlockSize();
            cVar.a(statFs.getBlockCount() * blockSize);
            cVar.b(blockSize * statFs.getAvailableBlocks());
            return cVar;
        }

        public String toString() {
            return String.format("[%s : %d / %d]", a().getAbsolutePath(), Long.valueOf(c()), Long.valueOf(b()));
        }
    }
}
