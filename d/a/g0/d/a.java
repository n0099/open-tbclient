package d.a.g0.d;

import android.content.ComponentName;
import android.content.Context;
import android.content.Intent;
import android.content.pm.ActivityInfo;
import android.content.pm.ApplicationInfo;
import android.content.pm.PackageInfo;
import android.content.pm.PackageManager;
import android.content.pm.ResolveInfo;
import android.content.pm.Signature;
import android.os.Bundle;
import android.os.Environment;
import android.os.Process;
import android.provider.Settings;
import android.text.TextUtils;
import androidx.recyclerview.widget.ItemTouchHelper;
import com.android.internal.http.multipart.Part;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.searchbox.logsystem.basic.upload.LogSystemUploaderStrategy;
import com.baidu.tbadk.core.util.FieldBuilder;
import com.baidu.webkit.internal.Base64;
import com.baidu.webkit.internal.utils.UtilsBlink;
import io.flutter.plugin.common.StandardMessageCodec;
import java.io.BufferedReader;
import java.io.ByteArrayInputStream;
import java.io.CharArrayWriter;
import java.io.File;
import java.io.FileReader;
import java.security.MessageDigest;
import java.security.PublicKey;
import java.security.cert.CertificateFactory;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import javax.crypto.Cipher;
import javax.crypto.spec.IvParameterSpec;
import javax.crypto.spec.SecretKeySpec;
import kotlin.jvm.internal.ByteCompanionObject;
import okhttp3.internal.publicsuffix.PublicSuffixDatabase;
import org.json.JSONArray;
import org.json.JSONObject;
/* loaded from: classes2.dex */
public final class a {

    /* renamed from: c  reason: collision with root package name */
    public static final String f40775c;

    /* renamed from: d  reason: collision with root package name */
    public static e f40776d;

    /* renamed from: e  reason: collision with root package name */
    public static int f40777e;

    /* renamed from: a  reason: collision with root package name */
    public final Context f40778a;

    /* renamed from: b  reason: collision with root package name */
    public PublicKey f40779b;

    /* renamed from: d.a.g0.d.a$a  reason: collision with other inner class name */
    /* loaded from: classes2.dex */
    public class C0550a implements Comparator<d> {
        public C0550a(a aVar) {
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // java.util.Comparator
        /* renamed from: a */
        public int compare(d dVar, d dVar2) {
            int i2 = dVar2.f40782c - dVar.f40782c;
            if (i2 != 0) {
                return i2;
            }
            if (dVar.f40781b && dVar2.f40781b) {
                return 0;
            }
            if (dVar.f40781b) {
                return -1;
            }
            if (dVar2.f40781b) {
                return 1;
            }
            return i2;
        }
    }

    /* loaded from: classes2.dex */
    public static final class b {
        public static byte[] a(String str, String str2, byte[] bArr) {
            SecretKeySpec secretKeySpec = new SecretKeySpec(str2.getBytes(), "AES");
            Cipher cipher = Cipher.getInstance("AES/CBC/PKCS5Padding");
            cipher.init(2, secretKeySpec, new IvParameterSpec(str.getBytes()));
            return cipher.doFinal(bArr);
        }
    }

    /* loaded from: classes2.dex */
    public static class c {
        public static byte[] a(byte[] bArr) {
            return b(bArr, bArr.length);
        }

        public static byte[] b(byte[] bArr, int i2) {
            byte b2;
            int i3;
            int i4 = (i2 / 4) * 3;
            if (i4 == 0) {
                return new byte[0];
            }
            byte[] bArr2 = new byte[i4];
            int i5 = i2;
            int i6 = 0;
            while (true) {
                byte b3 = bArr[i5 - 1];
                b2 = 10;
                if (b3 != 10 && b3 != 13 && b3 != 32 && b3 != 9) {
                    if (b3 != 61) {
                        break;
                    }
                    i6++;
                }
                i5--;
            }
            int i7 = 0;
            int i8 = 0;
            int i9 = 0;
            int i10 = 0;
            while (i7 < i5) {
                byte b4 = bArr[i7];
                if (b4 != b2 && b4 != 13 && b4 != 32 && b4 != 9) {
                    if (b4 >= 65 && b4 <= 90) {
                        i3 = b4 - 65;
                    } else if (b4 >= 97 && b4 <= 122) {
                        i3 = b4 - 71;
                    } else if (b4 >= 48 && b4 <= 57) {
                        i3 = b4 + 4;
                    } else if (b4 == 43) {
                        i3 = 62;
                    } else if (b4 != 47) {
                        return null;
                    } else {
                        i3 = 63;
                    }
                    i9 = ((byte) i3) | (i9 << 6);
                    if (i10 % 4 == 3) {
                        int i11 = i8 + 1;
                        bArr2[i8] = (byte) ((16711680 & i9) >> 16);
                        int i12 = i11 + 1;
                        bArr2[i11] = (byte) ((65280 & i9) >> 8);
                        bArr2[i12] = (byte) (i9 & 255);
                        i8 = i12 + 1;
                    }
                    i10++;
                }
                i7++;
                b2 = 10;
            }
            if (i6 > 0) {
                int i13 = i9 << (i6 * 6);
                int i14 = i8 + 1;
                bArr2[i8] = (byte) ((i13 & ItemTouchHelper.ACTION_MODE_DRAG_MASK) >> 16);
                if (i6 == 1) {
                    i8 = i14 + 1;
                    bArr2[i14] = (byte) ((i13 & 65280) >> 8);
                } else {
                    i8 = i14;
                }
            }
            byte[] bArr3 = new byte[i8];
            System.arraycopy(bArr2, 0, bArr3, 0, i8);
            return bArr3;
        }
    }

    /* loaded from: classes2.dex */
    public static class d {

        /* renamed from: a  reason: collision with root package name */
        public ApplicationInfo f40780a;

        /* renamed from: b  reason: collision with root package name */
        public boolean f40781b;

        /* renamed from: c  reason: collision with root package name */
        public int f40782c;

        /* renamed from: d  reason: collision with root package name */
        public boolean f40783d;

        public /* synthetic */ d(C0550a c0550a) {
            this();
        }

        public d() {
            this.f40782c = 0;
            this.f40783d = false;
            this.f40781b = false;
        }
    }

    /* loaded from: classes2.dex */
    public static class e {

        /* renamed from: a  reason: collision with root package name */
        public String f40784a;

        /* renamed from: b  reason: collision with root package name */
        public String f40785b;

        /* renamed from: c  reason: collision with root package name */
        public int f40786c = 0;

        public static e a(String str) {
            if (TextUtils.isEmpty(str)) {
                return null;
            }
            try {
                JSONObject jSONObject = new JSONObject(str);
                Iterator<String> keys = jSONObject.keys();
                String str2 = "0";
                String str3 = "0";
                while (keys.hasNext()) {
                    String next = keys.next();
                    if (!a.s("ZGV2aWNlaWQ=").equals(next) && !a.s("dmVy").equals(next)) {
                        str3 = jSONObject.optString(next, "0");
                    }
                }
                String string = jSONObject.getString(a.s("ZGV2aWNlaWQ="));
                jSONObject.getInt(a.s("dmVy"));
                int length = TextUtils.isEmpty(str3) ? 0 : str3.length();
                if (!TextUtils.isEmpty(string)) {
                    e eVar = new e();
                    eVar.f40784a = string;
                    eVar.f40786c = length;
                    if (length >= 14) {
                        return eVar;
                    }
                    if (!TextUtils.isEmpty(str3)) {
                        str2 = str3;
                    }
                    eVar.f40785b = str2;
                    return eVar;
                }
            } catch (Exception e2) {
                d.a.g0.l.c.d(e2);
            }
            return null;
        }

        public static boolean d(int i2) {
            return i2 >= 14;
        }

        public static e e(String str, String str2) {
            if (TextUtils.isEmpty(str)) {
                return null;
            }
            e eVar = new e();
            eVar.f40784a = str;
            int length = TextUtils.isEmpty(str2) ? 0 : str2.length();
            eVar.f40786c = length;
            if (length >= 14) {
                return eVar;
            }
            if (TextUtils.isEmpty(str2)) {
                str2 = "0";
            }
            eVar.f40785b = str2;
            return eVar;
        }

        public static boolean g(String str) {
            return TextUtils.isEmpty(str);
        }

        public String c() {
            String str = this.f40785b;
            if (TextUtils.isEmpty(str)) {
                str = "0";
            }
            return this.f40784a + FieldBuilder.SE + str;
        }

        public boolean f() {
            return d(this.f40786c);
        }

        public boolean h() {
            return g(this.f40785b);
        }
    }

    /* loaded from: classes2.dex */
    public static final class f {
        public static byte[] a() {
            return new byte[]{48, -126, 3, 99, 48, -126, 2, 75, -96, 3, 2, 1, 2, 2, 4, 106, -93, 120, 122, 48, 13, 6, 9, 42, -122, 72, -122, -9, 13, 1, 1, 11, 5, 0, 48, 97, 49, 11, 48, 9, 6, 3, 85, 4, 6, 19, 2, 99, 110, 49, 16, 48, 14, 6, 3, 85, 4, 8, 19, 7, 98, Constants.SHORT_PING_CMD_TYPE, 105, 106, 105, 110, 103, 49, 16, 48, 14, 6, 3, 85, 4, 7, 19, 7, 104, 97, 105, 100, 105, 97, 110, 49, 14, 48, StandardMessageCodec.LIST, 6, 3, 85, 4, 10, 19, 5, 98, 97, 105, 100, LogSystemUploaderStrategy.ContentUtil.GZIP_HEAD_1, 49, 14, 48, StandardMessageCodec.LIST, 6, 3, 85, 4, 11, 19, 5, 98, 97, 105, 100, LogSystemUploaderStrategy.ContentUtil.GZIP_HEAD_1, 49, 14, 48, StandardMessageCodec.LIST, 6, 3, 85, 4, 3, 19, 5, 98, 97, 105, 100, LogSystemUploaderStrategy.ContentUtil.GZIP_HEAD_1, 48, 32, 23, 13, 49, 53, 49, 48, 50, 49, 48, 52, 51, 54, 51, 55, 90, 24, 15, 50, 48, 55, 48, 48, 55, 50, 52, 48, 52, 51, 54, 51, 55, 90, 48, 97, 49, 11, 48, 9, 6, 3, 85, 4, 6, 19, 2, 99, 110, 49, 16, 48, 14, 6, 3, 85, 4, 8, 19, 7, 98, Constants.SHORT_PING_CMD_TYPE, 105, 106, 105, 110, 103, 49, 16, 48, 14, 6, 3, 85, 4, 7, 19, 7, 104, 97, 105, 100, 105, 97, 110, 49, 14, 48, StandardMessageCodec.LIST, 6, 3, 85, 4, 10, 19, 5, 98, 97, 105, 100, LogSystemUploaderStrategy.ContentUtil.GZIP_HEAD_1, 49, 14, 48, StandardMessageCodec.LIST, 6, 3, 85, 4, 11, 19, 5, 98, 97, 105, 100, LogSystemUploaderStrategy.ContentUtil.GZIP_HEAD_1, 49, 14, 48, StandardMessageCodec.LIST, 6, 3, 85, 4, 3, 19, 5, 98, 97, 105, 100, LogSystemUploaderStrategy.ContentUtil.GZIP_HEAD_1, 48, -126, 1, 34, 48, 13, 6, 9, 42, -122, 72, -122, -9, 13, 1, 1, 1, 5, 0, 3, -126, 1, 15, 0, 48, -126, 1, 10, 2, -126, 1, 1, 0, -86, -91, -2, -41, ByteCompanionObject.MAX_VALUE, 37, -25, -33, 93, 51, -73, 32, -81, 61, 108, 37, 126, 14, -125, 125, -55, -29, 34, -60, 84, -67, -46, 125, -93, -67, -27, 97, 54, Base64.INTERNAL_PADDING, 0, -6, 83, 67, -116, 43, -24, 26, 88, -5, PublicSuffixDatabase.EXCEPTION_MARKER, 27, -105, 49, 76, -70, -32, 105, -48, 67, 69, 102, -111, -81, 93, -103, -18, 17, 55, 81, -34, -80, -76, -13, -84, 6, 91, 10, 48, -56, -1, UtilsBlink.VER_TYPE_SEPARATOR, 9, 23, 34, 6, 103, Base64.INTERNAL_PADDING, -51, 29, 70, -19, -51, 20, -39, -43, -97, 75, 23, -124, -101, -71, -75, -107, -88, -13, -71, 80, 90, -76, -119, 51, -80, 118, ByteCompanionObject.MIN_VALUE, -12, -108, 98, -29, -27, 60, -119, -74, 110, 61, 51, -22, 53, 66, -99, -45, -25, 111, -121, 25, -72, ByteCompanionObject.MAX_VALUE, 3, 51, -100, 57, -90, 116, -59, -117, 74, -71, 121, 59, 19, -8, -109, PublicSuffixDatabase.EXCEPTION_MARKER, -14, 76, -105, -127, -23, 5, 99, -82, 22, -99, 51, 78, -26, 77, -52, -29, 121, 42, -76, 20, 2, 116, 111, -76, 2, -78, -90, -54, 81, 115, 82, 50, 124, -83, 96, 20, -40, -118, 105, 90, -70, 120, -33, -110, StandardMessageCodec.LIST, -15, 38, 34, -125, -116, 69, -54, -103, -109, -124, 26, 94, -89, -98, -11, -66, 89, 48, -68, -51, 107, -60, StandardMessageCodec.LIST, 114, -71, 119, 49, -31, -65, 113, -99, 3, -90, 79, -88, -38, -87, -25, -38, 41, 110, -25, 29, 49, 124, -76, -91, 77, -11, -90, 114, -63, 118, -22, -5, -124, 19, 22, -74, -75, 78, 28, 47, -69, 2, 3, 1, 0, 1, -93, PublicSuffixDatabase.EXCEPTION_MARKER, 48, 31, 48, 29, 6, 3, 85, 29, 14, 4, 22, 4, 20, -41, -108, PublicSuffixDatabase.EXCEPTION_MARKER, -126, -103, Base64.INTERNAL_PADDING, 115, -83, 99, 110, -39, 110, -125, -118, -69, 87, -103, 30, StandardMessageCodec.LIST, -53, 48, 13, 6, 9, 42, -122, 72, -122, -9, 13, 1, 1, 11, 5, 0, 3, -126, 1, 1, 0, 0, -117, 0, -28, 51, 26, -4, -15, 86, ByteCompanionObject.MAX_VALUE, 14, -101, -48, 121, 115, -53, -72, -22, 4, -83, 49, 106, -15, -44, -116, -105, 19, 65, -32, 65, 92, 21, 51, 61, -21, -74, 71, 91, 64, 75, -72, -48, 102, 17, -120, -23, -68, 51, 23, -104, 107, 65, -30, 109, -6, 46, -44, -46, -73, -54, -55, 63, 77, -54, -11, -51, 27, -1, 114, 86, -80, 28, -89, 29, -20, 49, -8, 57, -7, -30, 61, -108, -6, -60, 113, UtilsBlink.VER_TYPE_SEPARATOR, -32, -93, 19, -62, -89, 106, 91, 96, -48, 90, -59, 46, 104, 111, -88, 51, -39, 40, -36, -113, 86, -92, 25, 30, 94, -13, -15, -57, 59, -21, -111, 104, -50, -3, -121, -90, -43, 61, 105, -3, 57, 69, 51, -3, -31, 105, -12, 19, 77, -82, -120, 121, 108, -63, -126, 46, -43, 14, -56, 21, 47, 63, -104, -7, 113, 57, 100, -9, -12, -101, 107, -77, -64, 91, -104, -61, 0, -7, -72, -19, 75, StandardMessageCodec.LIST, 111, ByteCompanionObject.MAX_VALUE, -115, -46, -99, -111, -93, -67, -42, -66, 32, 81, 70, 109, -57, 10, 19, -49, -44, 59, 21, 31, -61, -59, 83, -14, 43, 73, -88, 120, -58, -46, 46, 66, 41, -2, -70, -6, -42, 103, 8, 4, 89, 110, -122, 68, -86, 62, -68, 13, -117, Base64.INTERNAL_PADDING, -52, -6, 106, -91, 91, -62, -56, -26, -41, -109, 68, -102, -43, -29, 113, 43, -126, -127, 122, -47, -30, -96, -2, 78, 44, -92, -38, -124, -102, 73, -105, -66, 5, -85, -7, 56};
        }
    }

    /* loaded from: classes2.dex */
    public static final class g {
        public static byte[] a(byte[] bArr) {
            try {
                return MessageDigest.getInstance("SHA-1").digest(bArr);
            } catch (Exception e2) {
                a.n(e2);
                return new byte[0];
            }
        }
    }

    static {
        String str = new String(c.a(new byte[]{77, 122, 65, 121, 77, 84, 73, 120, 77, 68, 73, 61}));
        f40775c = str + new String(c.a(new byte[]{90, 71, 108, 106, 100, 87, 82, 112, 89, 87, 73, 61}));
    }

    public a(Context context) {
        this.f40778a = context.getApplicationContext();
        u();
    }

    public static String b(Context context) {
        e m = m(context);
        return m != null ? m.c() : "";
    }

    /* JADX WARN: Removed duplicated region for block: B:41:0x003f A[EXC_TOP_SPLITTER, SYNTHETIC] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public static String c(File file) {
        FileReader fileReader;
        FileReader fileReader2 = null;
        try {
            fileReader = new FileReader(file);
            try {
                try {
                    char[] cArr = new char[8192];
                    CharArrayWriter charArrayWriter = new CharArrayWriter();
                    while (true) {
                        int read = fileReader.read(cArr);
                        if (read <= 0) {
                            break;
                        }
                        charArrayWriter.write(cArr, 0, read);
                    }
                    String charArrayWriter2 = charArrayWriter.toString();
                    try {
                        fileReader.close();
                    } catch (Exception e2) {
                        n(e2);
                    }
                    return charArrayWriter2;
                } catch (Exception e3) {
                    e = e3;
                    n(e);
                    if (fileReader != null) {
                        try {
                            fileReader.close();
                        } catch (Exception e4) {
                            n(e4);
                        }
                    }
                    return null;
                }
            } catch (Throwable th) {
                th = th;
                fileReader2 = fileReader;
                if (fileReader2 != null) {
                    try {
                        fileReader2.close();
                    } catch (Exception e5) {
                        n(e5);
                    }
                }
                throw th;
            }
        } catch (Exception e6) {
            e = e6;
            fileReader = null;
        } catch (Throwable th2) {
            th = th2;
            if (fileReader2 != null) {
            }
            throw th;
        }
    }

    public static String e(byte[] bArr) {
        if (bArr != null) {
            String str = "";
            for (byte b2 : bArr) {
                String hexString = Integer.toHexString(b2 & 255);
                str = hexString.length() == 1 ? str + "0" + hexString : str + hexString;
            }
            return str.toLowerCase();
        }
        throw new IllegalArgumentException("Argument b ( byte array ) is null! ");
    }

    public static byte[] j(byte[] bArr, PublicKey publicKey) {
        Cipher cipher = Cipher.getInstance("RSA/ECB/PKCS1Padding");
        cipher.init(2, publicKey);
        return cipher.doFinal(bArr);
    }

    public static e m(Context context) {
        if (f40776d == null) {
            synchronized (e.class) {
                if (f40776d == null) {
                    f40776d = new a(context).a();
                }
            }
        }
        return f40776d;
    }

    public static void n(Throwable th) {
    }

    public static String q(String str) {
        if (TextUtils.isEmpty(str)) {
            return null;
        }
        try {
            return new String(b.a(f40775c, f40775c, c.a(str.getBytes())));
        } catch (Exception e2) {
            n(e2);
            return "";
        }
    }

    public static String s(String str) {
        return new String(c.a(str.getBytes()));
    }

    public final e a() {
        List<d> f2 = f(new Intent("com.baidu.intent.action.GALAXY").setPackage(this.f40778a.getPackageName()), true);
        boolean z = false;
        if (f2 != null && f2.size() != 0) {
            z = f2.get(0).f40783d;
        }
        File file = new File(this.f40778a.getFilesDir(), "libcuid.so");
        e a2 = file.exists() ? e.a(q(c(file))) : null;
        if (a2 == null) {
            f40777e |= 16;
            List<d> f3 = f(new Intent("com.baidu.intent.action.GALAXY"), z);
            if (f3 != null) {
                String str = com.baidu.fsg.face.base.b.c.f5743g;
                File filesDir = this.f40778a.getFilesDir();
                if (!com.baidu.fsg.face.base.b.c.f5743g.equals(filesDir.getName())) {
                    str = filesDir.getName();
                }
                for (d dVar : f3) {
                    if (!dVar.f40781b) {
                        File file2 = new File(new File(dVar.f40780a.dataDir, str), "libcuid.so");
                        if (file2.exists() && (a2 = e.a(q(c(file2)))) != null) {
                            break;
                        }
                    }
                }
            }
        }
        if (a2 == null) {
            a2 = e.a(q(v("com.baidu.deviceid.v2")));
        }
        boolean o = o("android.permission.READ_EXTERNAL_STORAGE");
        if (a2 == null && o) {
            f40777e |= 2;
            a2 = p();
        }
        if (a2 == null) {
            f40777e |= 8;
            a2 = l();
        }
        if (a2 == null && o) {
            f40777e |= 1;
            a2 = t(r());
        }
        h(a2);
        return a2;
    }

    public final List<d> f(Intent intent, boolean z) {
        ArrayList arrayList = new ArrayList();
        PackageManager packageManager = this.f40778a.getPackageManager();
        List<ResolveInfo> queryBroadcastReceivers = packageManager.queryBroadcastReceivers(intent, 0);
        if (queryBroadcastReceivers != null) {
            for (ResolveInfo resolveInfo : queryBroadcastReceivers) {
                ActivityInfo activityInfo = resolveInfo.activityInfo;
                if (activityInfo != null && activityInfo.applicationInfo != null) {
                    try {
                        Bundle bundle = packageManager.getReceiverInfo(new ComponentName(resolveInfo.activityInfo.packageName, resolveInfo.activityInfo.name), 128).metaData;
                        if (bundle != null) {
                            String string = bundle.getString("galaxy_data");
                            if (!TextUtils.isEmpty(string)) {
                                byte[] a2 = c.a(string.getBytes("utf-8"));
                                JSONObject jSONObject = new JSONObject(new String(a2));
                                d dVar = new d(null);
                                dVar.f40782c = jSONObject.getInt("priority");
                                dVar.f40780a = resolveInfo.activityInfo.applicationInfo;
                                if (this.f40778a.getPackageName().equals(resolveInfo.activityInfo.applicationInfo.packageName)) {
                                    dVar.f40781b = true;
                                }
                                if (z) {
                                    String string2 = bundle.getString("galaxy_sf");
                                    if (!TextUtils.isEmpty(string2)) {
                                        PackageInfo packageInfo = packageManager.getPackageInfo(resolveInfo.activityInfo.applicationInfo.packageName, 64);
                                        JSONArray jSONArray = jSONObject.getJSONArray("sigs");
                                        int length = jSONArray.length();
                                        String[] strArr = new String[length];
                                        for (int i2 = 0; i2 < length; i2++) {
                                            strArr[i2] = jSONArray.getString(i2);
                                        }
                                        if (i(strArr, k(packageInfo.signatures))) {
                                            byte[] j = j(c.a(string2.getBytes()), this.f40779b);
                                            if (j != null && Arrays.equals(j, g.a(a2))) {
                                                dVar.f40783d = true;
                                            }
                                        }
                                    }
                                }
                                arrayList.add(dVar);
                            }
                        }
                    } catch (Exception e2) {
                        n(e2);
                    }
                }
            }
        }
        Collections.sort(arrayList, new C0550a(this));
        return arrayList;
    }

    public final boolean h(e eVar) {
        if (eVar == null) {
            return false;
        }
        if (eVar.f()) {
            eVar.f40785b = "O";
            return true;
        } else if (eVar.h()) {
            eVar.f40785b = "0";
            return true;
        } else {
            return false;
        }
    }

    public final boolean i(String[] strArr, String[] strArr2) {
        if (strArr == null || strArr2 == null || strArr.length != strArr2.length) {
            return false;
        }
        HashSet hashSet = new HashSet();
        for (String str : strArr) {
            hashSet.add(str);
        }
        HashSet hashSet2 = new HashSet();
        for (String str2 : strArr2) {
            hashSet2.add(str2);
        }
        return hashSet.equals(hashSet2);
    }

    public final String[] k(Signature[] signatureArr) {
        int length = signatureArr.length;
        String[] strArr = new String[length];
        for (int i2 = 0; i2 < length; i2++) {
            strArr[i2] = e(g.a(signatureArr[i2].toByteArray()));
        }
        return strArr;
    }

    public final e l() {
        return e.e(v("com.baidu.deviceid"), v("bd_setting_i"));
    }

    public final boolean o(String str) {
        return this.f40778a.checkPermission(str, Process.myPid(), Process.myUid()) == 0;
    }

    public final e p() {
        File file = new File(Environment.getExternalStorageDirectory().getAbsolutePath() + File.separator + "backups/.SystemConfig/.cuid2");
        if (file.exists()) {
            String c2 = c(file);
            if (TextUtils.isEmpty(c2)) {
                return null;
            }
            try {
                return e.a(new String(b.a(f40775c, f40775c, c.a(c2.getBytes()))));
            } catch (Exception e2) {
                n(e2);
                return null;
            }
        }
        return null;
    }

    public final String r() {
        return "0";
    }

    public final e t(String str) {
        String str2;
        String str3 = "";
        File file = new File(Environment.getExternalStorageDirectory().getAbsolutePath() + File.separator + "baidu/.cuid");
        if (!file.exists()) {
            file = new File(Environment.getExternalStorageDirectory().getAbsolutePath() + File.separator + "backups/.SystemConfig/.cuid");
        }
        try {
            BufferedReader bufferedReader = new BufferedReader(new FileReader(file));
            StringBuilder sb = new StringBuilder();
            while (true) {
                String readLine = bufferedReader.readLine();
                if (readLine == null) {
                    break;
                }
                sb.append(readLine);
                sb.append(Part.CRLF);
            }
            bufferedReader.close();
            String[] split = new String(b.a(f40775c, f40775c, c.a(sb.toString().getBytes()))).split("=");
            if (split == null || split.length != 2) {
                str2 = "";
            } else {
                str2 = split[0];
                try {
                    str3 = split[1];
                } catch (Exception e2) {
                    e = e2;
                    n(e);
                    return e.e(str3, str2);
                }
            }
        } catch (Exception e3) {
            e = e3;
            str2 = "";
        }
        return e.e(str3, str2);
    }

    /* JADX WARN: Removed duplicated region for block: B:32:0x003a A[EXC_TOP_SPLITTER, SYNTHETIC] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public final void u() {
        ByteArrayInputStream byteArrayInputStream;
        Exception e2;
        ByteArrayInputStream byteArrayInputStream2 = null;
        try {
            try {
                byteArrayInputStream = new ByteArrayInputStream(f.a());
                try {
                    try {
                        this.f40779b = CertificateFactory.getInstance("X.509").generateCertificate(byteArrayInputStream).getPublicKey();
                        byteArrayInputStream.close();
                    } catch (Exception e3) {
                        e2 = e3;
                        n(e2);
                        if (byteArrayInputStream != null) {
                            byteArrayInputStream.close();
                        }
                    }
                } catch (Throwable th) {
                    ByteArrayInputStream byteArrayInputStream3 = byteArrayInputStream;
                    th = th;
                    byteArrayInputStream2 = byteArrayInputStream3;
                    if (byteArrayInputStream2 != null) {
                        try {
                            byteArrayInputStream2.close();
                        } catch (Exception e4) {
                            n(e4);
                        }
                    }
                    throw th;
                }
            } catch (Exception e5) {
                n(e5);
            }
        } catch (Exception e6) {
            byteArrayInputStream = null;
            e2 = e6;
        } catch (Throwable th2) {
            th = th2;
            if (byteArrayInputStream2 != null) {
            }
            throw th;
        }
    }

    public final String v(String str) {
        try {
            return Settings.System.getString(this.f40778a.getContentResolver(), str);
        } catch (Exception e2) {
            n(e2);
            return null;
        }
    }
}
