package d.b.g0.a.u0.g;

import android.os.Handler;
import android.os.Message;
import android.util.Base64;
import android.util.Log;
import androidx.annotation.NonNull;
import d.b.g0.a.k;
import d.b.g0.a.u0.g.b;
import d.b.g0.a.u0.g.c;
import d.b.g0.p.d;
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
import java.util.concurrent.CountDownLatch;
import java.util.zip.GZIPInputStream;
import javax.crypto.BadPaddingException;
import javax.crypto.Cipher;
import javax.crypto.IllegalBlockSizeException;
import javax.crypto.NoSuchPaddingException;
import javax.crypto.spec.IvParameterSpec;
import javax.crypto.spec.SecretKeySpec;
/* loaded from: classes2.dex */
public class a {

    /* renamed from: a  reason: collision with root package name */
    public static final boolean f47006a = k.f45443a;

    /* renamed from: b  reason: collision with root package name */
    public static CharSequence f47007b = "._";

    /* renamed from: d.b.g0.a.u0.g.a$a  reason: collision with other inner class name */
    /* loaded from: classes2.dex */
    public static class C0863a {

        /* renamed from: a  reason: collision with root package name */
        public boolean f47008a;

        /* renamed from: b  reason: collision with root package name */
        public String f47009b = "";

        public C0863a(boolean z) {
            this.f47008a = z;
        }
    }

    /* loaded from: classes2.dex */
    public static class b {

        /* renamed from: a  reason: collision with root package name */
        public BufferedInputStream f47010a;

        /* renamed from: b  reason: collision with root package name */
        public int f47011b = -1;
    }

    @NonNull
    public static C0863a a(BufferedInputStream bufferedInputStream, File file, int i) {
        DataInputStream dataInputStream;
        DataInputStream dataInputStream2;
        DataInputStream dataInputStream3;
        C0863a c0863a = new C0863a(false);
        if (file == null || bufferedInputStream == null || i == 0) {
            return c0863a;
        }
        if (f47006a) {
            Log.d("BundleDecrypt", "type :" + i);
        }
        d.b.g0.a.u0.g.b bVar = new d.b.g0.a.u0.g.b();
        DataInputStream dataInputStream4 = null;
        try {
            try {
                dataInputStream = new DataInputStream(bufferedInputStream);
            } catch (Exception e2) {
                e = e2;
            }
        } catch (Throwable th) {
            th = th;
        }
        try {
            g(dataInputStream);
            bVar.f47012a = g(dataInputStream);
            bVar.f47013b = g(dataInputStream);
            g(dataInputStream);
            h(dataInputStream);
            dataInputStream.readFully(bVar.f47014c);
            byte[] c2 = c(bVar.f47014c);
            if (c2 != null && c2.length > 0) {
                byte[] bArr = new byte[bVar.f47013b];
                dataInputStream.readFully(bArr);
                byte[] bArr2 = new byte[16];
                byte[] bArr3 = new byte[16];
                System.arraycopy(c2, 0, bArr2, 0, 16);
                System.arraycopy(c2, 16, bArr3, 0, 16);
                byte[] b2 = b(bArr, bArr2, bArr3);
                if (b2 != null && b2.length > 0) {
                    if (i == 2) {
                        if (f47006a) {
                            Log.d("BundleDecrypt", "create brotli stream");
                        }
                        dataInputStream2 = new DataInputStream(d.b.g0.a.w0.a.h().a(new ByteArrayInputStream(b2)));
                        dataInputStream3 = new DataInputStream(d.b.g0.a.w0.a.h().a(dataInputStream));
                    } else {
                        dataInputStream2 = new DataInputStream(new ByteArrayInputStream(b2));
                        dataInputStream3 = new DataInputStream(new GZIPInputStream(dataInputStream));
                    }
                    if (!file.exists() && !file.mkdirs()) {
                        if (f47006a) {
                            Log.e("BundleDecrypt", "create destination directory fail");
                        }
                        c0863a.f47009b = "create destination directory failed";
                        d.a(dataInputStream);
                        return c0863a;
                    }
                    CountDownLatch countDownLatch = new CountDownLatch(4);
                    Handler[] handlerArr = new Handler[4];
                    for (int i2 = 0; i2 < 4; i2++) {
                        c cVar = new c("BundleDecrypt" + i2, file, countDownLatch);
                        cVar.start();
                        handlerArr[i2] = cVar.d();
                    }
                    for (int i3 = 0; i3 < bVar.f47012a; i3++) {
                        b.a aVar = new b.a();
                        g(dataInputStream2);
                        aVar.f47015a = g(dataInputStream2);
                        int g2 = g(dataInputStream2);
                        aVar.f47016b = g2;
                        byte[] bArr4 = new byte[g2];
                        dataInputStream2.readFully(bArr4);
                        String str = new String(bArr4, "utf-8");
                        aVar.f47017c = str;
                        if (str.contains(f47007b)) {
                            dataInputStream3.skipBytes(aVar.f47015a);
                        } else {
                            byte[] bArr5 = new byte[aVar.f47015a];
                            dataInputStream3.readFully(bArr5);
                            Message obtain = Message.obtain();
                            c.b bVar2 = new c.b();
                            bVar2.f47023b = bArr5;
                            bVar2.f47022a = aVar.f47017c;
                            obtain.what = 100;
                            obtain.obj = bVar2;
                            handlerArr[i3 % 4].sendMessage(obtain);
                        }
                    }
                    for (int i4 = 0; i4 < 4; i4++) {
                        handlerArr[i4].sendEmptyMessage(200);
                    }
                    countDownLatch.await();
                    d.a(dataInputStream2);
                    d.a(dataInputStream3);
                    c0863a.f47008a = true;
                    d.a(dataInputStream);
                    return c0863a;
                }
                c0863a.f47009b = "index array length <= 0";
                d.a(dataInputStream);
                return c0863a;
            }
            c0863a.f47009b = "cipher is null";
            d.a(dataInputStream);
            return c0863a;
        } catch (Exception e3) {
            e = e3;
            dataInputStream4 = dataInputStream;
            c0863a.f47009b = e.getLocalizedMessage();
            if (f47006a) {
                Log.e("BundleDecrypt", "decrypt bundle fail", e);
            }
            d.a(dataInputStream4);
            return c0863a;
        } catch (Throwable th2) {
            th = th2;
            dataInputStream4 = dataInputStream;
            d.a(dataInputStream4);
            throw th;
        }
    }

    public static byte[] b(byte[] bArr, byte[] bArr2, byte[] bArr3) {
        try {
            Cipher cipher = Cipher.getInstance("AES/CBC/NoPadding");
            cipher.init(2, new SecretKeySpec(bArr2, "AES"), new IvParameterSpec(bArr3));
            return cipher.doFinal(bArr);
        } catch (InvalidAlgorithmParameterException | InvalidKeyException | NoSuchAlgorithmException | BadPaddingException | IllegalBlockSizeException | NoSuchPaddingException e2) {
            if (f47006a) {
                Log.e("BundleDecrypt", "use key/iv decrypt AES fail", e2);
                return null;
            }
            return null;
        }
    }

    public static byte[] c(byte[] bArr) {
        try {
            Cipher cipher = Cipher.getInstance("RSA/ECB/PKCS1Padding");
            cipher.init(2, i());
            return cipher.doFinal(bArr);
        } catch (InvalidKeyException | NoSuchAlgorithmException | BadPaddingException | IllegalBlockSizeException | NoSuchPaddingException e2) {
            if (f47006a) {
                Log.e("BundleDecrypt", "decypt cipher fail", e2);
                return null;
            }
            return null;
        }
    }

    public static void d(int i) {
        File file = new File(d.b.g0.a.y0.c.a.d().get(0).f45078a, "/decryptLog.csv");
        try {
            if (!file.exists()) {
                file.createNewFile();
            }
            FileWriter fileWriter = new FileWriter(file, true);
            fileWriter.write(String.valueOf(i));
            fileWriter.write(44);
            d.a(fileWriter);
        } catch (IOException e2) {
            e2.printStackTrace();
        }
    }

    public static b e(@NonNull BufferedInputStream bufferedInputStream) throws IOException {
        b bVar = new b();
        bVar.f47010a = bufferedInputStream;
        bufferedInputStream.mark(8);
        int read = (bufferedInputStream.read() << 8) | bufferedInputStream.read() | (bufferedInputStream.read() << 16) | (bufferedInputStream.read() << 24);
        if (read == -1122498812) {
            bVar.f47011b = 1;
        } else if (read == -1122434039) {
            bVar.f47011b = 2;
        } else {
            bufferedInputStream.reset();
        }
        return bVar;
    }

    public static b f(File file) {
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
                    if (f47006a) {
                        Log.e("BundleDecrypt", "bundle encryption check fail", e);
                    }
                    bufferedInputStream = bufferedInputStream2;
                    d.a(bufferedInputStream);
                    return bVar;
                }
            } catch (IOException e3) {
                e = e3;
            }
            if (read == -1122498812) {
                bVar.f47010a = bufferedInputStream;
                bVar.f47011b = 1;
                return bVar;
            }
            if (read == -1122434039) {
                bVar.f47010a = bufferedInputStream;
                bVar.f47011b = 2;
                return bVar;
            }
            d.a(bufferedInputStream);
        }
        return bVar;
    }

    public static int g(DataInputStream dataInputStream) throws IOException {
        byte[] bArr = new byte[4];
        dataInputStream.readFully(bArr);
        return ByteBuffer.wrap(bArr).order(ByteOrder.LITTLE_ENDIAN).getInt();
    }

    public static long h(DataInputStream dataInputStream) throws IOException {
        byte[] bArr = new byte[8];
        dataInputStream.readFully(bArr);
        return ByteBuffer.wrap(bArr).order(ByteOrder.LITTLE_ENDIAN).getLong();
    }

    public static PublicKey i() {
        try {
            return KeyFactory.getInstance("RSA").generatePublic(new X509EncodedKeySpec(Base64.decode("MEwwDQYJKoZIhvcNAQEBBQADOwAwOAIxAMrOpIWOfuGDG1bjUXV5aPU5UQr0vmOqJif4uJC+7/2B9Nm27SEGINei70QIW4x/vwIDAQAB".getBytes("utf-8"), 0)));
        } catch (UnsupportedEncodingException | NoSuchAlgorithmException | InvalidKeySpecException e2) {
            if (f47006a) {
                Log.e("BundleDecrypt", e2.getMessage());
                return null;
            }
            return null;
        }
    }
}
