package com.xiaomi.push.service.module;

import android.content.Context;
import android.content.SharedPreferences;
import android.content.res.AssetFileDescriptor;
import android.os.ParcelFileDescriptor;
import android.text.TextUtils;
import com.xiaomi.mipush.sdk.MiPushClient;
import dalvik.system.DexClassLoader;
import java.io.File;
import java.io.FileNotFoundException;
import junit.framework.Assert;
/* loaded from: classes2.dex */
class a {
    private Context a;
    private String b;
    private String c;
    private int d = 0;
    private int e = 0;
    private int f = 0;
    private String g;
    private SharedPreferences h;

    public a(Context context, String str) {
        this.a = context.getApplicationContext();
        this.b = str;
        this.h = this.a.getSharedPreferences(MiPushClient.PREF_EXTRA, 0);
        Assert.assertEquals(true, TextUtils.isEmpty(this.b) ? false : true);
    }

    public static String a(Context context, String str) {
        return b(context, str) + "/" + str + ".apk";
    }

    private String a(String str) {
        try {
            return this.a.getPackageManager().getPackageArchiveInfo(str, 16512).applicationInfo.metaData.getString("Launcher");
        } catch (Exception e) {
            return null;
        }
    }

    private void a(int i) {
        this.h.edit().putInt(this.b + "_asset_app_version", i).commit();
    }

    private void a(long j) {
        this.h.edit().putLong(this.b + "_asset_modified", j).commit();
    }

    private static String b(Context context, String str) {
        return context.getDir(str, 0).getAbsolutePath();
    }

    private void b(int i) {
        this.h.edit().putInt(this.b + "_asset_version", i).commit();
    }

    private void b(long j) {
        this.h.edit().putLong(this.b + "_local_modified", j).commit();
    }

    private void b(String str) {
        this.h.edit().putString(this.b + "_asset_launcher", str).commit();
    }

    private void c(int i) {
        this.h.edit().putInt(this.b + "_local_version", i).commit();
    }

    private void c(String str) {
        this.h.edit().putString(this.b + "_local_launcher", str).commit();
    }

    private boolean g() {
        File file = new File(l());
        return file.exists() && (s() != file.lastModified() || q() == 0);
    }

    private boolean h() {
        File file = new File(d());
        return file.exists() && (t() == file.lastModified() || r() == 0);
    }

    /* JADX WARN: Removed duplicated region for block: B:25:0x0081  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    private boolean i() {
        ParcelFileDescriptor parcelFileDescriptor;
        AssetFileDescriptor assetFileDescriptor;
        Exception exc;
        AssetFileDescriptor openFd;
        File file = new File(l());
        if (file.exists()) {
            AssetFileDescriptor assetFileDescriptor2 = null;
            try {
                try {
                    try {
                        openFd = this.a.getAssets().openFd(this.b + ".apk");
                    } catch (Exception e) {
                        assetFileDescriptor = null;
                        exc = e;
                    }
                    try {
                        r0 = openFd.getLength() != file.length();
                    } catch (Exception e2) {
                        assetFileDescriptor = openFd;
                        exc = e2;
                        try {
                            exc.printStackTrace();
                            if (assetFileDescriptor != null) {
                                parcelFileDescriptor = assetFileDescriptor.getParcelFileDescriptor();
                                com.xiaomi.channel.commonutils.file.a.a(parcelFileDescriptor);
                            }
                            return r0;
                        } catch (Throwable th) {
                            th = th;
                            assetFileDescriptor2 = assetFileDescriptor;
                            if (assetFileDescriptor2 != null) {
                                com.xiaomi.channel.commonutils.file.a.a(assetFileDescriptor2.getParcelFileDescriptor());
                            }
                            throw th;
                        }
                    }
                } catch (FileNotFoundException e3) {
                    com.xiaomi.channel.commonutils.logger.b.d("no " + this.b + ".apk file in assets of app");
                    if (0 != 0) {
                        parcelFileDescriptor = assetFileDescriptor2.getParcelFileDescriptor();
                    }
                }
                if (openFd != null) {
                    parcelFileDescriptor = openFd.getParcelFileDescriptor();
                    com.xiaomi.channel.commonutils.file.a.a(parcelFileDescriptor);
                }
            } catch (Throwable th2) {
                th = th2;
                if (assetFileDescriptor2 != null) {
                }
                throw th;
            }
        }
        return r0;
    }

    private void j() {
        String str;
        try {
            try {
                com.xiaomi.channel.commonutils.logger.b.b("copyAssetFile start");
                String[] list = this.a.getAssets().list("");
                if (list != null) {
                    for (String str2 : list) {
                        if (!TextUtils.isEmpty(str2) && str2.startsWith(this.b)) {
                            com.xiaomi.channel.commonutils.android.c.a(this.a, str2, l());
                            str = "copyAssetFile end";
                            break;
                        }
                    }
                }
                str = "copyAssetFile end";
            } catch (Exception e) {
                e.printStackTrace();
                str = "copyAssetFile end";
            }
            com.xiaomi.channel.commonutils.logger.b.b(str);
        } catch (Throwable th) {
            com.xiaomi.channel.commonutils.logger.b.b("copyAssetFile end");
            throw th;
        }
    }

    private String k() {
        return b(this.a, this.b);
    }

    private String l() {
        return k() + "/" + this.b + "_asset.apk";
    }

    private String m() {
        return k() + "/lib/";
    }

    private String n() {
        return k() + "/asset_lib/";
    }

    private boolean o() {
        try {
            return p() != com.xiaomi.channel.commonutils.android.b.b(this.a, this.a.getPackageName());
        } catch (Exception e) {
            return true;
        }
    }

    private int p() {
        try {
            return this.h.getInt(this.b + "_asset_app_version", 0);
        } catch (Exception e) {
            return 0;
        }
    }

    private int q() {
        try {
            return this.h.getInt(this.b + "_asset_version", 0);
        } catch (Exception e) {
            return 0;
        }
    }

    private int r() {
        try {
            return this.h.getInt(this.b + "_local_version", 0);
        } catch (Exception e) {
            return 0;
        }
    }

    private long s() {
        try {
            return this.h.getLong(this.b + "_asset_modified", 0L);
        } catch (Exception e) {
            return 0L;
        }
    }

    private long t() {
        try {
            return this.h.getLong(this.b + "_local_modified", 0L);
        } catch (Exception e) {
            return 0L;
        }
    }

    private String u() {
        try {
            return this.h.getString(this.b + "_asset_launcher", null);
        } catch (Exception e) {
            return null;
        }
    }

    private String v() {
        try {
            return this.h.getString(this.b + "_local_launcher", null);
        } catch (Exception e) {
            return null;
        }
    }

    public int a() {
        return this.d;
    }

    public String b() {
        return this.g;
    }

    /* JADX WARN: Removed duplicated region for block: B:20:0x00aa A[Catch: Exception -> 0x0190, all -> 0x0241, TryCatch #0 {Exception -> 0x0190, blocks: (B:4:0x0003, B:7:0x0048, B:10:0x0057, B:12:0x005d, B:15:0x006b, B:34:0x0171, B:17:0x0071, B:18:0x009b, B:20:0x00aa, B:22:0x00b0, B:23:0x00c4, B:25:0x00fc, B:27:0x0102, B:29:0x010e, B:30:0x0126, B:38:0x0189, B:44:0x01c2, B:46:0x01c8, B:48:0x01d4, B:49:0x01ec, B:55:0x023a, B:36:0x0180, B:9:0x004e), top: B:62:0x0003, outer: #1 }] */
    /* JADX WARN: Removed duplicated region for block: B:25:0x00fc A[Catch: Exception -> 0x0190, all -> 0x0241, TryCatch #0 {Exception -> 0x0190, blocks: (B:4:0x0003, B:7:0x0048, B:10:0x0057, B:12:0x005d, B:15:0x006b, B:34:0x0171, B:17:0x0071, B:18:0x009b, B:20:0x00aa, B:22:0x00b0, B:23:0x00c4, B:25:0x00fc, B:27:0x0102, B:29:0x010e, B:30:0x0126, B:38:0x0189, B:44:0x01c2, B:46:0x01c8, B:48:0x01d4, B:49:0x01ec, B:55:0x023a, B:36:0x0180, B:9:0x004e), top: B:62:0x0003, outer: #1 }] */
    /* JADX WARN: Removed duplicated region for block: B:44:0x01c2 A[Catch: Exception -> 0x0190, all -> 0x0241, TRY_ENTER, TryCatch #0 {Exception -> 0x0190, blocks: (B:4:0x0003, B:7:0x0048, B:10:0x0057, B:12:0x005d, B:15:0x006b, B:34:0x0171, B:17:0x0071, B:18:0x009b, B:20:0x00aa, B:22:0x00b0, B:23:0x00c4, B:25:0x00fc, B:27:0x0102, B:29:0x010e, B:30:0x0126, B:38:0x0189, B:44:0x01c2, B:46:0x01c8, B:48:0x01d4, B:49:0x01ec, B:55:0x023a, B:36:0x0180, B:9:0x004e), top: B:62:0x0003, outer: #1 }] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public synchronized DexClassLoader c() {
        DexClassLoader dexClassLoader;
        String l;
        File file;
        boolean i;
        boolean z;
        File file2;
        boolean z2 = true;
        synchronized (this) {
            try {
                com.xiaomi.channel.commonutils.logger.b.b("load apk " + this.b);
                l = l();
                file = new File(l);
                i = i();
                com.xiaomi.channel.commonutils.logger.b.b("assert app size changed : " + i);
                if (!file.exists() || i || o()) {
                    com.xiaomi.channel.commonutils.logger.b.b("re-copy asset file");
                    j();
                }
            } catch (Exception e) {
                com.xiaomi.channel.commonutils.logger.b.a(e);
                com.xiaomi.channel.commonutils.logger.b.b("load apk : " + this.c + ", version : " + this.d);
                com.xiaomi.channel.commonutils.logger.b.b("load apk done.");
            }
            if (file.exists()) {
                com.xiaomi.channel.commonutils.logger.b.b("check modify.");
                if (g() || i || o()) {
                    com.xiaomi.channel.commonutils.logger.b.b("modified.");
                    this.e = com.xiaomi.channel.commonutils.android.b.c(this.a, l);
                    b(this.e);
                    a(com.xiaomi.channel.commonutils.android.b.b(this.a, this.a.getPackageName()));
                    a(file.lastModified());
                    z = true;
                    String d = d();
                    file2 = new File(d);
                    if (file2.exists()) {
                        if (h()) {
                            this.f = com.xiaomi.channel.commonutils.android.b.c(this.a, d);
                            c(this.f);
                            b(file2.lastModified());
                            com.xiaomi.channel.commonutils.logger.b.b("asset version " + this.e);
                            com.xiaomi.channel.commonutils.logger.b.b("local version " + this.f);
                            if (this.e >= this.f) {
                                if (this.e > this.d) {
                                    this.d = this.e;
                                    this.c = l();
                                    if (z) {
                                        this.g = a(this.c);
                                        b(this.g);
                                        com.xiaomi.channel.commonutils.android.a.a(this.a, this.c, n());
                                    } else {
                                        this.g = u();
                                    }
                                    dexClassLoader = new DexClassLoader(this.c, this.a.getDir("dex", 0).getAbsolutePath(), n(), ClassLoader.getSystemClassLoader());
                                    com.xiaomi.channel.commonutils.logger.b.b("load apk : " + this.c + ", version : " + this.d);
                                    com.xiaomi.channel.commonutils.logger.b.b("load apk done.");
                                }
                                com.xiaomi.channel.commonutils.logger.b.b("load apk : " + this.c + ", version : " + this.d);
                                com.xiaomi.channel.commonutils.logger.b.b("load apk done.");
                                dexClassLoader = null;
                            } else {
                                if (this.f > this.d) {
                                    this.d = this.f;
                                    this.c = d();
                                    if (z2) {
                                        this.g = a(this.c);
                                        c(this.g);
                                        com.xiaomi.channel.commonutils.android.a.a(this.a, this.c, m());
                                    } else {
                                        this.g = v();
                                    }
                                    dexClassLoader = new DexClassLoader(this.c, this.a.getDir("dex", 0).getAbsolutePath(), m(), ClassLoader.getSystemClassLoader());
                                    com.xiaomi.channel.commonutils.logger.b.b("load apk : " + this.c + ", version : " + this.d);
                                    com.xiaomi.channel.commonutils.logger.b.b("load apk done.");
                                }
                                com.xiaomi.channel.commonutils.logger.b.b("load apk : " + this.c + ", version : " + this.d);
                                com.xiaomi.channel.commonutils.logger.b.b("load apk done.");
                                dexClassLoader = null;
                            }
                        } else {
                            this.f = r();
                        }
                    }
                    z2 = false;
                    com.xiaomi.channel.commonutils.logger.b.b("asset version " + this.e);
                    com.xiaomi.channel.commonutils.logger.b.b("local version " + this.f);
                    if (this.e >= this.f) {
                    }
                } else {
                    com.xiaomi.channel.commonutils.logger.b.b("not modified.");
                    this.e = q();
                }
            }
            z = false;
            String d2 = d();
            file2 = new File(d2);
            if (file2.exists()) {
            }
            z2 = false;
            com.xiaomi.channel.commonutils.logger.b.b("asset version " + this.e);
            com.xiaomi.channel.commonutils.logger.b.b("local version " + this.f);
            if (this.e >= this.f) {
            }
        }
        return dexClassLoader;
    }

    public String d() {
        return a(this.a, this.b);
    }

    public String e() {
        return this.b;
    }

    public String f() {
        return this.c;
    }
}
