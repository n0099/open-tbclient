package d.b.h0.a.u0.g;

import android.os.Handler;
import android.os.Message;
import android.util.Base64;
import android.util.Log;
import androidx.annotation.NonNull;
import d.b.h0.a.k;
import d.b.h0.a.u0.g.b;
import d.b.h0.a.u0.g.c;
import d.b.h0.p.d;
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
    public static final boolean f47335a = k.f45772a;

    /* renamed from: b  reason: collision with root package name */
    public static CharSequence f47336b = "._";

    /* renamed from: d.b.h0.a.u0.g.a$a  reason: collision with other inner class name */
    /* loaded from: classes2.dex */
    public static class C0883a {

        /* renamed from: a  reason: collision with root package name */
        public boolean f47337a;

        /* renamed from: b  reason: collision with root package name */
        public String f47338b = "";

        public C0883a(boolean z) {
            this.f47337a = z;
        }
    }

    /* loaded from: classes2.dex */
    public static class b {

        /* renamed from: a  reason: collision with root package name */
        public BufferedInputStream f47339a;

        /* renamed from: b  reason: collision with root package name */
        public int f47340b = -1;
    }

    @NonNull
    public static C0883a a(BufferedInputStream bufferedInputStream, File file, int i) {
        DataInputStream dataInputStream;
        DataInputStream dataInputStream2;
        DataInputStream dataInputStream3;
        C0883a c0883a = new C0883a(false);
        if (file == null || bufferedInputStream == null || i == 0) {
            return c0883a;
        }
        if (f47335a) {
            Log.d("BundleDecrypt", "type :" + i);
        }
        d.b.h0.a.u0.g.b bVar = new d.b.h0.a.u0.g.b();
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
            bVar.f47341a = g(dataInputStream);
            bVar.f47342b = g(dataInputStream);
            g(dataInputStream);
            h(dataInputStream);
            dataInputStream.readFully(bVar.f47343c);
            byte[] c2 = c(bVar.f47343c);
            if (c2 != null && c2.length > 0) {
                byte[] bArr = new byte[bVar.f47342b];
                dataInputStream.readFully(bArr);
                byte[] bArr2 = new byte[16];
                byte[] bArr3 = new byte[16];
                System.arraycopy(c2, 0, bArr2, 0, 16);
                System.arraycopy(c2, 16, bArr3, 0, 16);
                byte[] b2 = b(bArr, bArr2, bArr3);
                if (b2 != null && b2.length > 0) {
                    if (i == 2) {
                        if (f47335a) {
                            Log.d("BundleDecrypt", "create brotli stream");
                        }
                        dataInputStream2 = new DataInputStream(d.b.h0.a.w0.a.h().a(new ByteArrayInputStream(b2)));
                        dataInputStream3 = new DataInputStream(d.b.h0.a.w0.a.h().a(dataInputStream));
                    } else {
                        dataInputStream2 = new DataInputStream(new ByteArrayInputStream(b2));
                        dataInputStream3 = new DataInputStream(new GZIPInputStream(dataInputStream));
                    }
                    if (!file.exists() && !file.mkdirs()) {
                        if (f47335a) {
                            Log.e("BundleDecrypt", "create destination directory fail");
                        }
                        c0883a.f47338b = "create destination directory failed";
                        d.a(dataInputStream);
                        return c0883a;
                    }
                    CountDownLatch countDownLatch = new CountDownLatch(4);
                    Handler[] handlerArr = new Handler[4];
                    for (int i2 = 0; i2 < 4; i2++) {
                        c cVar = new c("BundleDecrypt" + i2, file, countDownLatch);
                        cVar.start();
                        handlerArr[i2] = cVar.d();
                    }
                    for (int i3 = 0; i3 < bVar.f47341a; i3++) {
                        b.a aVar = new b.a();
                        g(dataInputStream2);
                        aVar.f47344a = g(dataInputStream2);
                        int g2 = g(dataInputStream2);
                        aVar.f47345b = g2;
                        byte[] bArr4 = new byte[g2];
                        dataInputStream2.readFully(bArr4);
                        String str = new String(bArr4, "utf-8");
                        aVar.f47346c = str;
                        if (str.contains(f47336b)) {
                            dataInputStream3.skipBytes(aVar.f47344a);
                        } else {
                            byte[] bArr5 = new byte[aVar.f47344a];
                            dataInputStream3.readFully(bArr5);
                            Message obtain = Message.obtain();
                            c.b bVar2 = new c.b();
                            bVar2.f47352b = bArr5;
                            bVar2.f47351a = aVar.f47346c;
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
                    c0883a.f47337a = true;
                    d.a(dataInputStream);
                    return c0883a;
                }
                c0883a.f47338b = "index array length <= 0";
                d.a(dataInputStream);
                return c0883a;
            }
            c0883a.f47338b = "cipher is null";
            d.a(dataInputStream);
            return c0883a;
        } catch (Exception e3) {
            e = e3;
            dataInputStream4 = dataInputStream;
            c0883a.f47338b = e.getLocalizedMessage();
            if (f47335a) {
                Log.e("BundleDecrypt", "decrypt bundle fail", e);
            }
            d.a(dataInputStream4);
            return c0883a;
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
            if (f47335a) {
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
            if (f47335a) {
                Log.e("BundleDecrypt", "decypt cipher fail", e2);
                return null;
            }
            return null;
        }
    }

    public static void d(int i) {
        File file = new File(d.b.h0.a.y0.c.a.d().get(0).f45407a, "/decryptLog.csv");
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
        bVar.f47339a = bufferedInputStream;
        bufferedInputStream.mark(8);
        int read = (bufferedInputStream.read() << 8) | bufferedInputStream.read() | (bufferedInputStream.read() << 16) | (bufferedInputStream.read() << 24);
        if (read == -1122498812) {
            bVar.f47340b = 1;
        } else if (read == -1122434039) {
            bVar.f47340b = 2;
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
                    if (f47335a) {
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
                bVar.f47339a = bufferedInputStream;
                bVar.f47340b = 1;
                return bVar;
            }
            if (read == -1122434039) {
                bVar.f47339a = bufferedInputStream;
                bVar.f47340b = 2;
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
            if (f47335a) {
                Log.e("BundleDecrypt", e2.getMessage());
                return null;
            }
            return null;
        }
    }
}
