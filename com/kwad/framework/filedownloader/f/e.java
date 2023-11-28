package com.kwad.framework.filedownloader.f;

import com.baidu.searchbox.player.model.YYOption;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;
/* loaded from: classes10.dex */
public class e {
    public final int ahX;
    public final long ahY;
    public final boolean ahZ;
    public final boolean aia;
    public final int aib;
    public final boolean aic;
    public final boolean aid;

    /* loaded from: classes10.dex */
    public static class a {
        public static final e aie = new e((byte) 0);
    }

    /* JADX WARN: Removed duplicated region for block: B:109:? A[RETURN, SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:39:0x007d A[Catch: all -> 0x01cf, TryCatch #8 {all -> 0x01cf, blocks: (B:7:0x0033, B:8:0x003a, B:9:0x003e, B:10:0x0042, B:11:0x0046, B:12:0x004a, B:37:0x0079, B:39:0x007d, B:41:0x0081, B:42:0x0089), top: B:95:0x0033 }] */
    /* JADX WARN: Removed duplicated region for block: B:42:0x0089 A[Catch: all -> 0x01cf, TRY_LEAVE, TryCatch #8 {all -> 0x01cf, blocks: (B:7:0x0033, B:8:0x003a, B:9:0x003e, B:10:0x0042, B:11:0x0046, B:12:0x004a, B:37:0x0079, B:39:0x007d, B:41:0x0081, B:42:0x0089), top: B:95:0x0033 }] */
    /* JADX WARN: Removed duplicated region for block: B:46:0x009f  */
    /* JADX WARN: Removed duplicated region for block: B:54:0x00cb  */
    /* JADX WARN: Removed duplicated region for block: B:57:0x00d5  */
    /* JADX WARN: Removed duplicated region for block: B:58:0x00e4  */
    /* JADX WARN: Removed duplicated region for block: B:60:0x00ea  */
    /* JADX WARN: Removed duplicated region for block: B:61:0x00fe  */
    /* JADX WARN: Removed duplicated region for block: B:63:0x0107  */
    /* JADX WARN: Removed duplicated region for block: B:64:0x0117  */
    /* JADX WARN: Removed duplicated region for block: B:66:0x011c  */
    /* JADX WARN: Removed duplicated region for block: B:74:0x0145  */
    /* JADX WARN: Removed duplicated region for block: B:76:0x014a  */
    /* JADX WARN: Removed duplicated region for block: B:84:0x0172  */
    /* JADX WARN: Removed duplicated region for block: B:87:0x0178  */
    /* JADX WARN: Type inference failed for: r4v7 */
    /* JADX WARN: Type inference failed for: r4v8, types: [boolean] */
    /* JADX WARN: Type inference failed for: r4v9 */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public e() {
        InputStream inputStream;
        InputStream inputStream2;
        String str;
        String str2;
        String str3;
        String str4;
        String str5;
        String str6;
        String str7;
        String str8;
        Object obj;
        int i;
        Object obj2;
        long j;
        Object obj3;
        int i2;
        ?? r4;
        if (c.wB() != null) {
            long currentTimeMillis = System.currentTimeMillis();
            Properties properties = new Properties();
            try {
                inputStream2 = c.wB().getAssets().open("filedownloader.properties");
                if (inputStream2 != null) {
                    try {
                        try {
                            properties.load(inputStream2);
                            str = properties.getProperty("http.lenient");
                        } catch (IOException e) {
                            e = e;
                            str = null;
                            str2 = null;
                            str3 = null;
                            str4 = null;
                            str5 = null;
                            if (!(e instanceof FileNotFoundException)) {
                                if (d.ahW) {
                                    d.c(e.class, "not found filedownloader.properties", new Object[0]);
                                }
                            } else {
                                e.printStackTrace();
                            }
                            com.kwad.sdk.crash.utils.b.closeQuietly(inputStream2);
                            str6 = str;
                            str7 = str5;
                            str8 = null;
                            if (str6 == null) {
                            }
                            this.aia = true;
                            if (str2 != null) {
                            }
                            if (str3 != null) {
                            }
                            if (str4 != null) {
                            }
                            if (str7 != null) {
                            }
                            if (str8 != null) {
                            }
                            if (d.ahW) {
                            }
                        }
                        try {
                            str2 = properties.getProperty("download.min-progress-step");
                        } catch (IOException e2) {
                            e = e2;
                            str2 = null;
                            str3 = null;
                            str4 = null;
                            str5 = null;
                            if (!(e instanceof FileNotFoundException)) {
                            }
                            com.kwad.sdk.crash.utils.b.closeQuietly(inputStream2);
                            str6 = str;
                            str7 = str5;
                            str8 = null;
                            if (str6 == null) {
                            }
                            this.aia = true;
                            if (str2 != null) {
                            }
                            if (str3 != null) {
                            }
                            if (str4 != null) {
                            }
                            if (str7 != null) {
                            }
                            if (str8 != null) {
                            }
                            if (d.ahW) {
                            }
                        }
                        try {
                            str3 = properties.getProperty("download.min-progress-time");
                        } catch (IOException e3) {
                            e = e3;
                            str3 = null;
                            str4 = null;
                            str5 = null;
                            if (!(e instanceof FileNotFoundException)) {
                            }
                            com.kwad.sdk.crash.utils.b.closeQuietly(inputStream2);
                            str6 = str;
                            str7 = str5;
                            str8 = null;
                            if (str6 == null) {
                            }
                            this.aia = true;
                            if (str2 != null) {
                            }
                            if (str3 != null) {
                            }
                            if (str4 != null) {
                            }
                            if (str7 != null) {
                            }
                            if (str8 != null) {
                            }
                            if (d.ahW) {
                            }
                        }
                        try {
                            str4 = properties.getProperty("download.max-network-thread-count");
                        } catch (IOException e4) {
                            e = e4;
                            str4 = null;
                            str5 = null;
                            if (!(e instanceof FileNotFoundException)) {
                            }
                            com.kwad.sdk.crash.utils.b.closeQuietly(inputStream2);
                            str6 = str;
                            str7 = str5;
                            str8 = null;
                            if (str6 == null) {
                            }
                            this.aia = true;
                            if (str2 != null) {
                            }
                            if (str3 != null) {
                            }
                            if (str4 != null) {
                            }
                            if (str7 != null) {
                            }
                            if (str8 != null) {
                            }
                            if (d.ahW) {
                            }
                        }
                        try {
                            str5 = properties.getProperty("file.non-pre-allocation");
                        } catch (IOException e5) {
                            e = e5;
                            str5 = null;
                            if (!(e instanceof FileNotFoundException)) {
                            }
                            com.kwad.sdk.crash.utils.b.closeQuietly(inputStream2);
                            str6 = str;
                            str7 = str5;
                            str8 = null;
                            if (str6 == null) {
                            }
                            this.aia = true;
                            if (str2 != null) {
                            }
                            if (str3 != null) {
                            }
                            if (str4 != null) {
                            }
                            if (str7 != null) {
                            }
                            if (str8 != null) {
                            }
                            if (d.ahW) {
                            }
                        }
                        try {
                            str8 = properties.getProperty("broadcast.completed");
                            str6 = str;
                        } catch (IOException e6) {
                            e = e6;
                            if (!(e instanceof FileNotFoundException)) {
                            }
                            com.kwad.sdk.crash.utils.b.closeQuietly(inputStream2);
                            str6 = str;
                            str7 = str5;
                            str8 = null;
                            if (str6 == null) {
                            }
                            this.aia = true;
                            if (str2 != null) {
                            }
                            if (str3 != null) {
                            }
                            if (str4 != null) {
                            }
                            if (str7 != null) {
                            }
                            if (str8 != null) {
                            }
                            if (d.ahW) {
                            }
                        }
                    } catch (Throwable th) {
                        th = th;
                        inputStream = inputStream2;
                        com.kwad.sdk.crash.utils.b.closeQuietly(inputStream);
                        throw th;
                    }
                } else {
                    str8 = null;
                    str6 = null;
                    str2 = null;
                    str3 = null;
                    str4 = null;
                    str5 = null;
                }
                com.kwad.sdk.crash.utils.b.closeQuietly(inputStream2);
                str7 = str5;
            } catch (IOException e7) {
                e = e7;
                inputStream2 = null;
            } catch (Throwable th2) {
                th = th2;
                inputStream = null;
            }
            if (str6 == null) {
                obj = "download.max-network-thread-count";
                i = 0;
                this.ahZ = false;
            } else if (str6.equals(YYOption.IsLive.VALUE_TRUE) || str6.equals("false")) {
                obj = "download.max-network-thread-count";
                i = 0;
                this.ahZ = str6.equals(YYOption.IsLive.VALUE_TRUE);
            } else {
                throw new IllegalStateException(f.b("the value of '%s' must be '%s' or '%s'", "http.lenient", YYOption.IsLive.VALUE_TRUE, "false"));
            }
            this.aia = true;
            if (str2 != null) {
                this.ahX = Math.max(i, Integer.valueOf(str2).intValue());
            } else {
                this.ahX = 65536;
            }
            if (str3 != null) {
                obj2 = "download.min-progress-time";
                j = currentTimeMillis;
                obj3 = "http.lenient";
                this.ahY = Math.max(0L, Long.valueOf(str3).longValue());
            } else {
                obj2 = "download.min-progress-time";
                j = currentTimeMillis;
                obj3 = "http.lenient";
                this.ahY = 2000L;
            }
            if (str4 != null) {
                this.aib = bG(Integer.valueOf(str4).intValue());
                i2 = 3;
            } else {
                i2 = 3;
                this.aib = 3;
            }
            if (str7 != null) {
                if (!str7.equals(YYOption.IsLive.VALUE_TRUE) && !str7.equals("false")) {
                    Object[] objArr = new Object[i2];
                    objArr[0] = "file.non-pre-allocation";
                    objArr[1] = YYOption.IsLive.VALUE_TRUE;
                    objArr[2] = "false";
                    throw new IllegalStateException(f.b("the value of '%s' must be '%s' or '%s'", objArr));
                }
                r4 = 0;
                this.aic = str7.equals(YYOption.IsLive.VALUE_TRUE);
            } else {
                r4 = 0;
                this.aic = false;
            }
            if (str8 != null) {
                if (!str8.equals(YYOption.IsLive.VALUE_TRUE) && !str8.equals("false")) {
                    Object[] objArr2 = new Object[3];
                    objArr2[r4] = "broadcast.completed";
                    objArr2[1] = YYOption.IsLive.VALUE_TRUE;
                    objArr2[2] = "false";
                    throw new IllegalStateException(f.b("the value of '%s' must be '%s' or '%s'", objArr2));
                }
                this.aid = str8.equals(YYOption.IsLive.VALUE_TRUE);
            } else {
                this.aid = r4;
            }
            if (d.ahW) {
                Object[] objArr3 = new Object[11];
                objArr3[r4] = Long.valueOf(System.currentTimeMillis() - j);
                objArr3[1] = obj3;
                objArr3[2] = Boolean.valueOf(this.ahZ);
                objArr3[3] = "process.non-separate";
                objArr3[4] = Boolean.valueOf(this.aia);
                objArr3[5] = "download.min-progress-step";
                objArr3[6] = Integer.valueOf(this.ahX);
                objArr3[7] = obj2;
                objArr3[8] = Long.valueOf(this.ahY);
                objArr3[9] = obj;
                objArr3[10] = Integer.valueOf(this.aib);
                d.b(e.class, "init properties %d\n load properties: %s=%B; %s=%B; %s=%d; %s=%d; %s=%d", objArr3);
                return;
            }
            return;
        }
        throw new IllegalStateException("Please invoke the 'FileDownloader#setup' before using FileDownloader. If you want to register some components on FileDownloader please invoke the 'FileDownloader#setupOnApplicationOnCreate' on the 'Application#onCreate' first.");
    }

    public /* synthetic */ e(byte b) {
        this();
    }

    public static int bG(int i) {
        if (i > 12) {
            d.d(e.class, "require the count of network thread  is %d, what is more than the max valid count(%d), so adjust to %d auto", Integer.valueOf(i), 12, 12);
            return 12;
        } else if (i <= 0) {
            d.d(e.class, "require the count of network thread  is %d, what is less than the min valid count(%d), so adjust to %d auto", Integer.valueOf(i), 1, 1);
            return 1;
        } else {
            return i;
        }
    }

    public static e wD() {
        return a.aie;
    }
}
