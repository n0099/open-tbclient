package d.a.i0.a.a1.h;

import android.os.Handler;
import android.os.Message;
import android.util.Base64;
import android.util.Log;
import android.util.Pair;
import androidx.annotation.NonNull;
import d.a.i0.a.a1.h.b;
import d.a.i0.a.a1.h.c;
import d.a.i0.a.e0.d;
import d.a.i0.a.k;
import d.a.i0.a.v2.q0;
import java.io.BufferedInputStream;
import java.io.ByteArrayInputStream;
import java.io.DataInputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileWriter;
import java.io.IOException;
import java.io.UnsupportedEncodingException;
import java.nio.ByteBuffer;
import java.nio.ByteOrder;
import java.security.InvalidAlgorithmParameterException;
import java.security.InvalidKeyException;
import java.security.KeyFactory;
import java.security.NoSuchAlgorithmException;
import java.security.PublicKey;
import java.security.spec.InvalidKeySpecException;
import java.security.spec.X509EncodedKeySpec;
import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.CountDownLatch;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.zip.GZIPInputStream;
import javax.crypto.BadPaddingException;
import javax.crypto.Cipher;
import javax.crypto.IllegalBlockSizeException;
import javax.crypto.NoSuchPaddingException;
import javax.crypto.spec.IvParameterSpec;
import javax.crypto.spec.SecretKeySpec;
/* loaded from: classes3.dex */
public class a {

    /* renamed from: a  reason: collision with root package name */
    public static final boolean f40534a = k.f43025a;

    /* renamed from: b  reason: collision with root package name */
    public static final boolean f40535b;

    /* renamed from: c  reason: collision with root package name */
    public static final AtomicInteger f40536c;

    /* renamed from: d  reason: collision with root package name */
    public static CharSequence f40537d;

    /* renamed from: d.a.i0.a.a1.h.a$a  reason: collision with other inner class name */
    /* loaded from: classes3.dex */
    public static class C0551a {

        /* renamed from: a  reason: collision with root package name */
        public boolean f40538a;

        /* renamed from: b  reason: collision with root package name */
        public String f40539b = "";

        public C0551a(boolean z) {
            this.f40538a = z;
        }
    }

    /* loaded from: classes3.dex */
    public static class b {

        /* renamed from: a  reason: collision with root package name */
        public BufferedInputStream f40540a;

        /* renamed from: b  reason: collision with root package name */
        public int f40541b = -1;
    }

    static {
        d.a.i0.a.c1.a.Z().getSwitch("swan_pkg_download_finish_unzip_safely", false);
        f40535b = false;
        f40536c = new AtomicInteger(0);
        f40537d = "._";
    }

    public static boolean a(int i2, @NonNull File file, int i3, @NonNull C0551a c0551a) {
        if (i2 > 0) {
            String str = i2 + " files write error";
            c0551a.f40539b = str;
            d.h("BundleDecrypt", str);
            d.a.i0.a.j2.p.d dVar = new d.a.i0.a.j2.p.d();
            d.a.i0.a.q2.a aVar = new d.a.i0.a.q2.a();
            aVar.j(4L);
            aVar.h(52L);
            dVar.p(aVar);
            dVar.l("path", file.getAbsolutePath());
            dVar.l("eMsg", str);
            dVar.l("decryptType", String.valueOf(i3));
            dVar.l("stack", q0.z(30));
            d.a.i0.a.j2.k.L(dVar);
            return true;
        }
        return false;
    }

    @NonNull
    public static Pair<Boolean, File> b() {
        File file = new File(d.a.i0.a.c1.a.b().getFilesDir(), "swan_tmp_unzip");
        d.a.i0.t.d.k(file);
        File file2 = new File(file, System.nanoTime() + "_" + f40536c.incrementAndGet());
        boolean k = d.a.i0.t.d.k(file2);
        d.h("BundleDecrypt", "#createTmpUnzipDir tmpUnzipDir=" + file2 + " dirExist=" + k);
        return new Pair<>(Boolean.valueOf(k), file2);
    }

    /* JADX WARN: Removed duplicated region for block: B:100:0x0220  */
    @NonNull
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public static C0551a c(BufferedInputStream bufferedInputStream, File file, int i2) {
        long j;
        DataInputStream dataInputStream;
        byte[] e2;
        DataInputStream dataInputStream2;
        DataInputStream dataInputStream3;
        if (f40535b) {
            d.h("BundleDecrypt", "命中开关，#decryptSafely dstFolder=" + file + " type=" + i2);
            return f(bufferedInputStream, file, i2);
        }
        long nanoTime = f40534a ? System.nanoTime() : 0L;
        C0551a c0551a = new C0551a(false);
        if (file == null || bufferedInputStream == null || i2 == 0) {
            return c0551a;
        }
        if (f40534a) {
            Log.d("BundleDecrypt", "type :" + i2);
        }
        d.a.i0.a.a1.h.b bVar = new d.a.i0.a.a1.h.b();
        DataInputStream dataInputStream4 = null;
        try {
            try {
                dataInputStream = new DataInputStream(bufferedInputStream);
            } catch (Throwable th) {
                th = th;
            }
        } catch (Exception e3) {
            e = e3;
            j = nanoTime;
        }
        try {
            try {
                k(dataInputStream);
                bVar.f40542a = k(dataInputStream);
                bVar.f40543b = k(dataInputStream);
                k(dataInputStream);
                l(dataInputStream);
                dataInputStream.readFully(bVar.f40544c);
                e2 = e(bVar.f40544c);
            } catch (Exception e4) {
                e = e4;
                j = nanoTime;
            }
            try {
            } catch (Exception e5) {
                e = e5;
                dataInputStream4 = dataInputStream;
                c0551a.f40539b = e.getLocalizedMessage();
                if (f40534a) {
                    Log.e("BundleDecrypt", "decrypt bundle fail", e);
                }
                d.a.i0.t.d.d(dataInputStream4);
                if (f40534a) {
                }
                return c0551a;
            }
            if (e2 != null && e2.length > 0) {
                byte[] bArr = new byte[bVar.f40543b];
                dataInputStream.readFully(bArr);
                byte[] bArr2 = new byte[16];
                byte[] bArr3 = new byte[16];
                System.arraycopy(e2, 0, bArr2, 0, 16);
                System.arraycopy(e2, 16, bArr3, 0, 16);
                byte[] d2 = d(bArr, bArr2, bArr3);
                if (d2 != null && d2.length > 0) {
                    if (i2 == 2) {
                        if (f40534a) {
                            Log.d("BundleDecrypt", "create brotli stream");
                        }
                        dataInputStream2 = new DataInputStream(d.a.i0.a.c1.a.i().a(new ByteArrayInputStream(d2)));
                        dataInputStream3 = new DataInputStream(d.a.i0.a.c1.a.i().a(dataInputStream));
                    } else {
                        dataInputStream2 = new DataInputStream(new ByteArrayInputStream(d2));
                        dataInputStream3 = new DataInputStream(new GZIPInputStream(dataInputStream));
                    }
                    if (!file.exists() && !file.mkdirs()) {
                        if (f40534a) {
                            Log.e("BundleDecrypt", "create destination directory fail");
                        }
                        c0551a.f40539b = "create destination directory failed";
                        d.a.i0.t.d.d(dataInputStream);
                        return c0551a;
                    }
                    AtomicInteger atomicInteger = new AtomicInteger(0);
                    CountDownLatch countDownLatch = new CountDownLatch(4);
                    Handler[] handlerArr = new Handler[4];
                    int i3 = 0;
                    for (int i4 = 4; i3 < i4; i4 = 4) {
                        c cVar = new c("BundleDecrypt" + i3, file, countDownLatch, atomicInteger);
                        cVar.start();
                        handlerArr[i3] = cVar.d();
                        i3++;
                    }
                    ArrayList arrayList = new ArrayList();
                    int i5 = 0;
                    while (i5 < bVar.f40542a) {
                        b.a aVar = new b.a();
                        k(dataInputStream2);
                        d.a.i0.a.a1.h.b bVar2 = bVar;
                        aVar.f40545a = k(dataInputStream2);
                        int k = k(dataInputStream2);
                        aVar.f40546b = k;
                        byte[] bArr4 = new byte[k];
                        dataInputStream2.readFully(bArr4);
                        long j2 = nanoTime;
                        String str = new String(bArr4, "utf-8");
                        aVar.f40547c = str;
                        if (str.contains(f40537d)) {
                            dataInputStream3.skipBytes(aVar.f40545a);
                        } else {
                            byte[] bArr5 = new byte[aVar.f40545a];
                            dataInputStream3.readFully(bArr5);
                            Message obtain = Message.obtain();
                            c.C0552c c0552c = new c.C0552c();
                            c0552c.f40555b = bArr5;
                            c0552c.f40554a = aVar.f40547c;
                            obtain.what = 100;
                            obtain.obj = c0552c;
                            handlerArr[i5 % 4].sendMessage(obtain);
                            arrayList.add(aVar);
                        }
                        i5++;
                        bVar = bVar2;
                        nanoTime = j2;
                    }
                    j = nanoTime;
                    for (int i6 = 0; i6 < 4; i6++) {
                        handlerArr[i6].sendEmptyMessage(200);
                    }
                    countDownLatch.await();
                    d.a.i0.t.d.d(dataInputStream2);
                    d.a.i0.t.d.d(dataInputStream3);
                    if (a(atomicInteger.get(), file, i2, c0551a)) {
                        d.a.i0.t.d.d(dataInputStream);
                        return c0551a;
                    } else if (!m(arrayList, file, i2)) {
                        d.h("BundleDecrypt", "decrypt：unpack file check fail");
                        c0551a.f40539b = "decrypt：unpack file check fail";
                        d.a.i0.t.d.d(dataInputStream);
                        return c0551a;
                    } else {
                        c0551a.f40538a = true;
                        d.a.i0.t.d.d(dataInputStream);
                        if (f40534a) {
                            Log.i("BundleDecrypt", "#decrypt dstFolder=" + file.getAbsolutePath() + " 耗时(ms): " + ((System.nanoTime() - j) / 1000000.0d));
                        }
                        return c0551a;
                    }
                }
                c0551a.f40539b = "index array length <= 0";
                d.a.i0.t.d.d(dataInputStream);
                return c0551a;
            }
            c0551a.f40539b = "cipher is null";
            d.a.i0.t.d.d(dataInputStream);
            return c0551a;
        } catch (Throwable th2) {
            th = th2;
            dataInputStream4 = dataInputStream;
            d.a.i0.t.d.d(dataInputStream4);
            throw th;
        }
    }

    public static byte[] d(byte[] bArr, byte[] bArr2, byte[] bArr3) {
        try {
            Cipher cipher = Cipher.getInstance("AES/CBC/NoPadding");
            cipher.init(2, new SecretKeySpec(bArr2, "AES"), new IvParameterSpec(bArr3));
            return cipher.doFinal(bArr);
        } catch (InvalidAlgorithmParameterException | InvalidKeyException | NoSuchAlgorithmException | BadPaddingException | IllegalBlockSizeException | NoSuchPaddingException e2) {
            if (f40534a) {
                Log.e("BundleDecrypt", "use key/iv decrypt AES fail", e2);
                return null;
            }
            return null;
        }
    }

    public static byte[] e(byte[] bArr) {
        try {
            Cipher cipher = Cipher.getInstance("RSA/ECB/PKCS1Padding");
            cipher.init(2, n());
            return cipher.doFinal(bArr);
        } catch (InvalidKeyException | NoSuchAlgorithmException | BadPaddingException | IllegalBlockSizeException | NoSuchPaddingException e2) {
            if (f40534a) {
                Log.e("BundleDecrypt", "decypt cipher fail", e2);
                return null;
            }
            return null;
        }
    }

    /* JADX WARN: Removed duplicated region for block: B:157:0x035b  */
    /* JADX WARN: Removed duplicated region for block: B:160:0x0378  */
    /* JADX WARN: Removed duplicated region for block: B:165:0x03aa  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public static C0551a f(BufferedInputStream bufferedInputStream, File file, int i2) {
        DataInputStream dataInputStream;
        long j;
        File file2;
        DataInputStream dataInputStream2;
        byte[] e2;
        DataInputStream dataInputStream3;
        DataInputStream dataInputStream4;
        AtomicInteger atomicInteger;
        CountDownLatch countDownLatch;
        String str;
        ArrayList arrayList;
        String str2;
        String str3;
        String str4;
        String str5 = " 耗时(ms): ";
        String str6 = "#decryptSafely 删除临时目录: ";
        String str7 = "BundleDecrypt";
        long nanoTime = f40534a ? System.nanoTime() : 0L;
        C0551a c0551a = new C0551a(false);
        if (file == null || bufferedInputStream == null || i2 == 0) {
            return c0551a;
        }
        d.a.i0.a.a1.h.b bVar = new d.a.i0.a.a1.h.b();
        try {
            dataInputStream2 = new DataInputStream(bufferedInputStream);
            try {
                try {
                    k(dataInputStream2);
                    bVar.f40542a = k(dataInputStream2);
                    bVar.f40543b = k(dataInputStream2);
                    k(dataInputStream2);
                    l(dataInputStream2);
                    dataInputStream2.readFully(bVar.f40544c);
                    e2 = e(bVar.f40544c);
                    try {
                    } catch (Exception e3) {
                        e = e3;
                        dataInputStream = dataInputStream2;
                        file2 = null;
                        try {
                            c0551a.f40539b = e.getLocalizedMessage();
                            d.i(str7, "#decryptSafely ex=", e);
                            d.a.i0.t.d.d(dataInputStream);
                            if (file2 != null) {
                            }
                            if (f40534a) {
                            }
                            return c0551a;
                        } catch (Throwable th) {
                            th = th;
                            d.a.i0.t.d.d(dataInputStream);
                            if (file2 != null) {
                                d.h(str7, str6 + file2.getAbsolutePath());
                                d.a.i0.t.d.K(file2);
                            }
                            throw th;
                        }
                    }
                } catch (Exception e4) {
                    e = e4;
                    j = nanoTime;
                }
            } catch (Throwable th2) {
                th = th2;
                dataInputStream = dataInputStream2;
                file2 = null;
                d.a.i0.t.d.d(dataInputStream);
                if (file2 != null) {
                }
                throw th;
            }
        } catch (Exception e5) {
            e = e5;
            j = nanoTime;
            dataInputStream = null;
        } catch (Throwable th3) {
            th = th3;
            dataInputStream = null;
        }
        if (e2 != null && e2.length > 0) {
            byte[] bArr = new byte[bVar.f40543b];
            dataInputStream2.readFully(bArr);
            byte[] bArr2 = new byte[16];
            byte[] bArr3 = new byte[16];
            System.arraycopy(e2, 0, bArr2, 0, 16);
            System.arraycopy(e2, 16, bArr3, 0, 16);
            byte[] d2 = d(bArr, bArr2, bArr3);
            if (d2 != null && d2.length > 0) {
                if (i2 == 2) {
                    try {
                        dataInputStream3 = new DataInputStream(d.a.i0.a.c1.a.i().a(new ByteArrayInputStream(d2)));
                        dataInputStream4 = new DataInputStream(d.a.i0.a.c1.a.i().a(dataInputStream2));
                    } catch (Exception e6) {
                        e = e6;
                        dataInputStream = dataInputStream2;
                        j = nanoTime;
                        file2 = null;
                        c0551a.f40539b = e.getLocalizedMessage();
                        d.i(str7, "#decryptSafely ex=", e);
                        d.a.i0.t.d.d(dataInputStream);
                        if (file2 != null) {
                            d.h(str7, str6 + file2.getAbsolutePath());
                            d.a.i0.t.d.K(file2);
                        }
                        if (f40534a) {
                        }
                        return c0551a;
                    }
                } else {
                    dataInputStream3 = new DataInputStream(new ByteArrayInputStream(d2));
                    dataInputStream4 = new DataInputStream(new GZIPInputStream(dataInputStream2));
                }
                DataInputStream dataInputStream5 = dataInputStream3;
                DataInputStream dataInputStream6 = dataInputStream4;
                if (!d.a.i0.t.d.k(file)) {
                    d.h("BundleDecrypt", "#decryptSafely 解压目录创建失败 path=" + file.getAbsolutePath());
                    c0551a.f40539b = "create destination directory failed";
                    d.a.i0.t.d.d(dataInputStream2);
                    return c0551a;
                }
                Pair<Boolean, File> b2 = b();
                if (!((Boolean) b2.first).booleanValue()) {
                    d.h("BundleDecrypt", "#decryptSafely 临时解压目录创建失败 path=" + ((File) b2.second).getAbsolutePath());
                    c0551a.f40539b = "create temp unzip directory failed";
                    d.a.i0.t.d.d(dataInputStream2);
                    return c0551a;
                }
                File file3 = (File) b2.second;
                try {
                    try {
                        atomicInteger = new AtomicInteger(0);
                        countDownLatch = new CountDownLatch(4);
                        j = nanoTime;
                        try {
                            Handler[] handlerArr = new Handler[4];
                            int i3 = 0;
                            for (int i4 = 4; i3 < i4; i4 = 4) {
                                String str8 = str5;
                                try {
                                    c cVar = new c("BundleDecrypt" + i3, file3, countDownLatch, atomicInteger);
                                    cVar.start();
                                    handlerArr[i3] = cVar.e();
                                    i3++;
                                    str5 = str8;
                                } catch (Exception e7) {
                                    e = e7;
                                    dataInputStream = dataInputStream2;
                                    file2 = file3;
                                    str5 = str8;
                                    c0551a.f40539b = e.getLocalizedMessage();
                                    d.i(str7, "#decryptSafely ex=", e);
                                    d.a.i0.t.d.d(dataInputStream);
                                    if (file2 != null) {
                                    }
                                    if (f40534a) {
                                    }
                                    return c0551a;
                                }
                            }
                            str = str5;
                            try {
                                arrayList = new ArrayList();
                                int i5 = 0;
                                while (i5 < bVar.f40542a) {
                                    try {
                                        b.a q = q(dataInputStream5);
                                        d.a.i0.a.a1.h.b bVar2 = bVar;
                                        String str9 = str7;
                                        try {
                                            if (q.f40547c.contains(f40537d)) {
                                                dataInputStream6.skipBytes(q.f40545a);
                                                str4 = str6;
                                            } else {
                                                byte[] bArr4 = new byte[q.f40545a];
                                                dataInputStream6.readFully(bArr4);
                                                Message obtain = Message.obtain();
                                                str4 = str6;
                                                try {
                                                    c.C0552c c0552c = new c.C0552c();
                                                    c0552c.f40555b = bArr4;
                                                    c0552c.f40554a = q.f40547c;
                                                    obtain.what = 100;
                                                    obtain.obj = c0552c;
                                                    handlerArr[i5 % 4].sendMessage(obtain);
                                                    arrayList.add(q);
                                                } catch (Throwable th4) {
                                                    th = th4;
                                                    for (int i6 = 0; i6 < 4; i6++) {
                                                        handlerArr[i6].sendEmptyMessage(200);
                                                    }
                                                    countDownLatch.await();
                                                    d.a.i0.t.d.d(dataInputStream5);
                                                    d.a.i0.t.d.d(dataInputStream6);
                                                    throw th;
                                                }
                                            }
                                            i5++;
                                            bVar = bVar2;
                                            str7 = str9;
                                            str6 = str4;
                                        } catch (Throwable th5) {
                                            th = th5;
                                        }
                                    } catch (Throwable th6) {
                                        th = th6;
                                    }
                                }
                                str2 = str6;
                                str3 = str7;
                                int i7 = 0;
                                for (int i8 = 4; i7 < i8; i8 = 4) {
                                    try {
                                        handlerArr[i7].sendEmptyMessage(200);
                                        i7++;
                                    } catch (Exception e8) {
                                        e = e8;
                                        dataInputStream = dataInputStream2;
                                        file2 = file3;
                                        str5 = str;
                                        str7 = str3;
                                        str6 = str2;
                                        c0551a.f40539b = e.getLocalizedMessage();
                                        d.i(str7, "#decryptSafely ex=", e);
                                        d.a.i0.t.d.d(dataInputStream);
                                        if (file2 != null) {
                                        }
                                        if (f40534a) {
                                        }
                                        return c0551a;
                                    } catch (Throwable th7) {
                                        th = th7;
                                        dataInputStream = dataInputStream2;
                                        file2 = file3;
                                        str7 = str3;
                                        str6 = str2;
                                        d.a.i0.t.d.d(dataInputStream);
                                        if (file2 != null) {
                                        }
                                        throw th;
                                    }
                                }
                            } catch (Exception e9) {
                                e = e9;
                                str5 = str;
                            }
                        } catch (Exception e10) {
                            e = e10;
                        }
                    } catch (Exception e11) {
                        e = e11;
                        j = nanoTime;
                    }
                } catch (Throwable th8) {
                    th = th8;
                }
                try {
                    countDownLatch.await();
                    d.a.i0.t.d.d(dataInputStream5);
                    d.a.i0.t.d.d(dataInputStream6);
                } catch (Exception e12) {
                    e = e12;
                    str5 = str;
                    str7 = str3;
                    str6 = str2;
                    dataInputStream = dataInputStream2;
                    file2 = file3;
                    c0551a.f40539b = e.getLocalizedMessage();
                    d.i(str7, "#decryptSafely ex=", e);
                    d.a.i0.t.d.d(dataInputStream);
                    if (file2 != null) {
                    }
                    if (f40534a) {
                    }
                    return c0551a;
                } catch (Throwable th9) {
                    th = th9;
                    str7 = str3;
                    str6 = str2;
                    dataInputStream = dataInputStream2;
                    file2 = file3;
                    d.a.i0.t.d.d(dataInputStream);
                    if (file2 != null) {
                    }
                    throw th;
                }
                if (a(atomicInteger.get(), file, i2, c0551a)) {
                    d.a.i0.t.d.d(dataInputStream2);
                    if (file3 != null) {
                        d.h(str3, str2 + file3.getAbsolutePath());
                        d.a.i0.t.d.K(file3);
                    }
                    return c0551a;
                }
                str7 = str3;
                str6 = str2;
                if (!m(arrayList, file3, i2)) {
                    d.h(str7, "decrypt：unpack file check fail");
                    c0551a.f40539b = "decrypt：unpack file check fail";
                    d.a.i0.t.d.d(dataInputStream2);
                    if (file3 != null) {
                        d.h(str7, str6 + file3.getAbsolutePath());
                        d.a.i0.t.d.K(file3);
                    }
                    return c0551a;
                }
                long nanoTime2 = f40534a ? System.nanoTime() : 0L;
                boolean p = p(file3, file, arrayList);
                if (f40534a) {
                    StringBuilder sb = new StringBuilder();
                    sb.append("#moveToDestDir dstFolder=");
                    sb.append(file.getAbsolutePath());
                    sb.append(" moveRes=");
                    sb.append(p);
                    sb.append(" fileCount=");
                    sb.append(arrayList.size());
                    str5 = str;
                    sb.append(str5);
                    sb.append((System.nanoTime() - nanoTime2) / 1000000.0d);
                    Log.i(str7, sb.toString());
                } else {
                    str5 = str;
                }
                if (!p) {
                    c0551a.f40539b = "decrypt: from temp unzip dir, move to dest dir fail";
                    d.a.i0.t.d.d(dataInputStream2);
                    if (file3 != null) {
                        d.h(str7, str6 + file3.getAbsolutePath());
                        d.a.i0.t.d.K(file3);
                    }
                    return c0551a;
                }
                c0551a.f40538a = true;
                d.a.i0.t.d.d(dataInputStream2);
                if (file3 != null) {
                    d.h(str7, str6 + file3.getAbsolutePath());
                    d.a.i0.t.d.K(file3);
                }
                if (f40534a) {
                    Log.i(str7, "#decryptSafely dstFolder=" + file.getAbsolutePath() + str5 + ((System.nanoTime() - j) / 1000000.0d));
                }
                return c0551a;
            }
            c0551a.f40539b = "index array length <= 0";
            d.a.i0.t.d.d(dataInputStream2);
            return c0551a;
        }
        c0551a.f40539b = "cipher is null";
        d.a.i0.t.d.d(dataInputStream2);
        return c0551a;
    }

    public static void g(int i2) {
        File file = new File(j());
        try {
            if (!file.exists()) {
                file.createNewFile();
            }
            FileWriter fileWriter = new FileWriter(file, true);
            fileWriter.write(String.valueOf(i2));
            fileWriter.write(44);
            d.a.i0.t.d.d(fileWriter);
        } catch (IOException e2) {
            e2.printStackTrace();
        }
    }

    public static b h(@NonNull BufferedInputStream bufferedInputStream) throws IOException {
        b bVar = new b();
        bVar.f40540a = bufferedInputStream;
        bufferedInputStream.mark(8);
        int read = (bufferedInputStream.read() << 8) | bufferedInputStream.read() | (bufferedInputStream.read() << 16) | (bufferedInputStream.read() << 24);
        if (read == -1122498812) {
            bVar.f40541b = 1;
        } else if (read == -1122434039) {
            bVar.f40541b = 2;
        } else {
            bufferedInputStream.reset();
        }
        return bVar;
    }

    public static b i(File file) {
        BufferedInputStream bufferedInputStream;
        int read;
        b bVar = new b();
        if (file != null && file.exists()) {
            BufferedInputStream bufferedInputStream2 = null;
            try {
                bufferedInputStream = new BufferedInputStream(new FileInputStream(file));
                try {
                    read = bufferedInputStream.read() | (bufferedInputStream.read() << 8) | (bufferedInputStream.read() << 16) | (bufferedInputStream.read() << 24);
                } catch (IOException e2) {
                    e = e2;
                    bufferedInputStream2 = bufferedInputStream;
                    if (f40534a) {
                        Log.e("BundleDecrypt", "bundle encryption check fail", e);
                    }
                    bufferedInputStream = bufferedInputStream2;
                    d.a.i0.t.d.d(bufferedInputStream);
                    return bVar;
                }
            } catch (IOException e3) {
                e = e3;
            }
            if (read == -1122498812) {
                bVar.f40540a = bufferedInputStream;
                bVar.f40541b = 1;
                return bVar;
            }
            if (read == -1122434039) {
                bVar.f40540a = bufferedInputStream;
                bVar.f40541b = 2;
                return bVar;
            }
            d.a.i0.t.d.d(bufferedInputStream);
        }
        return bVar;
    }

    public static String j() {
        return new File(d.a.i0.a.f1.c.a.d().get(0).f45247a, "/decryptLog.csv").getAbsolutePath();
    }

    public static int k(DataInputStream dataInputStream) throws IOException {
        byte[] bArr = new byte[4];
        dataInputStream.readFully(bArr);
        return ByteBuffer.wrap(bArr).order(ByteOrder.LITTLE_ENDIAN).getInt();
    }

    public static long l(DataInputStream dataInputStream) throws IOException {
        byte[] bArr = new byte[8];
        dataInputStream.readFully(bArr);
        return ByteBuffer.wrap(bArr).order(ByteOrder.LITTLE_ENDIAN).getLong();
    }

    public static boolean m(List<b.a> list, File file, int i2) {
        long currentTimeMillis = f40534a ? System.currentTimeMillis() : 0L;
        for (b.a aVar : list) {
            File file2 = new File(file, aVar.f40547c);
            if (!file2.exists() || (file2.isFile() && file2.length() != aVar.f40545a)) {
                d.h("BundleDecrypt", "decrypt：unpack file " + aVar.f40547c + " fail");
                d.a.i0.a.j2.p.d dVar = new d.a.i0.a.j2.p.d();
                d.a.i0.a.q2.a aVar2 = new d.a.i0.a.q2.a();
                aVar2.j(4L);
                aVar2.h(52L);
                dVar.p(aVar2);
                dVar.l("path", file2.getAbsolutePath());
                dVar.l("eMsg", "decrypt files not match encrypt content");
                dVar.l("decryptType", String.valueOf(i2));
                dVar.l("stack", q0.z(30));
                d.a.i0.a.j2.k.L(dVar);
                return false;
            }
        }
        if (f40534a) {
            Log.d("BundleDecrypt", "check all files valid cost - " + (System.currentTimeMillis() - currentTimeMillis) + "ms");
            return true;
        }
        return true;
    }

    public static PublicKey n() {
        try {
            return KeyFactory.getInstance("RSA").generatePublic(new X509EncodedKeySpec(Base64.decode("MEwwDQYJKoZIhvcNAQEBBQADOwAwOAIxAMrOpIWOfuGDG1bjUXV5aPU5UQr0vmOqJif4uJC+7/2B9Nm27SEGINei70QIW4x/vwIDAQAB".getBytes("utf-8"), 0)));
        } catch (UnsupportedEncodingException | NoSuchAlgorithmException | InvalidKeySpecException e2) {
            if (f40534a) {
                Log.e("BundleDecrypt", e2.getMessage());
                return null;
            }
            return null;
        }
    }

    public static boolean o(@NonNull File file, @NonNull File file2) {
        if (file2.exists()) {
            return file.length() == file2.length() || file.renameTo(file2);
        }
        file2.getParentFile().mkdirs();
        return file.renameTo(file2);
    }

    public static boolean p(File file, File file2, List<b.a> list) {
        if (file == null || file2 == null || list == null || !file.isDirectory() || !file2.isDirectory()) {
            return false;
        }
        for (b.a aVar : list) {
            String str = aVar.f40547c;
            File file3 = new File(file, str);
            File file4 = new File(file2, str);
            if (!o(file3, file4)) {
                d.h("BundleDecrypt", "#moveFile fail src=" + file3.getAbsolutePath() + "dst=" + file4.getAbsolutePath());
                return false;
            }
        }
        return true;
    }

    public static b.a q(DataInputStream dataInputStream) throws IOException {
        b.a aVar = new b.a();
        k(dataInputStream);
        aVar.f40545a = k(dataInputStream);
        int k = k(dataInputStream);
        aVar.f40546b = k;
        byte[] bArr = new byte[k];
        dataInputStream.readFully(bArr);
        aVar.f40547c = new String(bArr, "utf-8");
        return aVar;
    }
}
