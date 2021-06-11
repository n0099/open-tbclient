package d.a.j;

import android.content.ComponentName;
import android.content.Context;
import android.content.Intent;
import android.content.pm.ActivityInfo;
import android.content.pm.PackageInfo;
import android.content.pm.PackageManager;
import android.content.pm.ResolveInfo;
import android.content.pm.Signature;
import android.os.Bundle;
import android.text.TextUtils;
import android.util.Log;
import androidx.recyclerview.widget.ItemTouchHelper;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.searchbox.logsystem.basic.upload.LogSystemUploaderStrategy;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;
import java.util.HashSet;
import java.util.List;
import org.json.JSONArray;
import org.json.JSONObject;
/* loaded from: classes.dex */
public class f {

    /* renamed from: a  reason: collision with root package name */
    public d.a.j.d.d.d f43895a;

    /* renamed from: b  reason: collision with root package name */
    public List<e> f43896b;

    /* loaded from: classes.dex */
    public class a implements Comparator<e> {
        public a(f fVar) {
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // java.util.Comparator
        /* renamed from: a */
        public int compare(e eVar, e eVar2) {
            int i2 = eVar2.f43892b - eVar.f43892b;
            if (i2 == 0) {
                if (eVar.f43894d && eVar2.f43894d) {
                    return 0;
                }
                if (eVar.f43894d) {
                    return -1;
                }
                if (eVar2.f43894d) {
                    return 1;
                }
            }
            return i2;
        }
    }

    /* loaded from: classes2.dex */
    public final class b {

        /* renamed from: a  reason: collision with root package name */
        public static final byte[] f43897a = {65, 66, 67, 68, 69, 70, 71, 72, 73, 74, 75, 76, 77, 78, 79, 80, 81, 82, 83, 84, 85, 86, 87, 88, 89, 90, 97, 98, 99, 100, Constants.SHORT_PING_CMD_TYPE, 102, 103, 104, 105, 106, 107, 108, 109, 110, 111, 112, 113, 114, 115, 116, LogSystemUploaderStrategy.ContentUtil.GZIP_HEAD_1, 118, 119, 120, 121, 122, 48, 49, 50, 51, 52, 53, 54, 55, 56, 57, 43, 47};

        public static String a(byte[] bArr, String str) {
            int length = (bArr.length * 4) / 3;
            byte[] bArr2 = new byte[length + (length / 76) + 3];
            int length2 = bArr.length - (bArr.length % 3);
            int i2 = 0;
            int i3 = 0;
            for (int i4 = 0; i4 < length2; i4 += 3) {
                int i5 = i2 + 1;
                byte[] bArr3 = f43897a;
                bArr2[i2] = bArr3[(bArr[i4] & 255) >> 2];
                int i6 = i5 + 1;
                int i7 = i4 + 1;
                bArr2[i5] = bArr3[((bArr[i4] & 3) << 4) | ((bArr[i7] & 255) >> 4)];
                int i8 = i6 + 1;
                int i9 = i4 + 2;
                bArr2[i6] = bArr3[((bArr[i7] & 15) << 2) | ((bArr[i9] & 255) >> 6)];
                i2 = i8 + 1;
                bArr2[i8] = bArr3[bArr[i9] & 63];
                if ((i2 - i3) % 76 == 0 && i2 != 0) {
                    bArr2[i2] = 10;
                    i3++;
                    i2++;
                }
            }
            int length3 = bArr.length % 3;
            if (length3 == 1) {
                int i10 = i2 + 1;
                byte[] bArr4 = f43897a;
                bArr2[i2] = bArr4[(bArr[length2] & 255) >> 2];
                int i11 = i10 + 1;
                bArr2[i10] = bArr4[(bArr[length2] & 3) << 4];
                int i12 = i11 + 1;
                bArr2[i11] = 61;
                i2 = i12 + 1;
                bArr2[i12] = 61;
            } else if (length3 == 2) {
                int i13 = i2 + 1;
                byte[] bArr5 = f43897a;
                bArr2[i2] = bArr5[(bArr[length2] & 255) >> 2];
                int i14 = i13 + 1;
                int i15 = length2 + 1;
                bArr2[i13] = bArr5[((bArr[i15] & 255) >> 4) | ((bArr[length2] & 3) << 4)];
                int i16 = i14 + 1;
                bArr2[i14] = bArr5[(bArr[i15] & 15) << 2];
                i2 = i16 + 1;
                bArr2[i16] = 61;
            }
            return new String(bArr2, 0, i2, str);
        }

        public static byte[] b(byte[] bArr) {
            return c(bArr, bArr.length);
        }

        public static byte[] c(byte[] bArr, int i2) {
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
                    i8 = ((byte) i3) | (i8 << 6);
                    if (i10 % 4 == 3) {
                        int i11 = i9 + 1;
                        bArr2[i9] = (byte) ((16711680 & i8) >> 16);
                        int i12 = i11 + 1;
                        bArr2[i11] = (byte) ((65280 & i8) >> 8);
                        bArr2[i12] = (byte) (i8 & 255);
                        i9 = i12 + 1;
                    }
                    i10++;
                }
                i7++;
                b2 = 10;
            }
            if (i6 > 0) {
                int i13 = i8 << (i6 * 6);
                int i14 = i9 + 1;
                bArr2[i9] = (byte) ((i13 & ItemTouchHelper.ACTION_MODE_DRAG_MASK) >> 16);
                if (i6 == 1) {
                    i9 = i14 + 1;
                    bArr2[i14] = (byte) ((i13 & 65280) >> 8);
                } else {
                    i9 = i14;
                }
            }
            byte[] bArr3 = new byte[i9];
            System.arraycopy(bArr2, 0, bArr3, 0, i9);
            return bArr3;
        }
    }

    /* loaded from: classes2.dex */
    public final class c {
        public static String a(byte[] bArr, String str, boolean z) {
            StringBuilder sb = new StringBuilder();
            for (byte b2 : bArr) {
                String hexString = Integer.toHexString(b2 & 255);
                if (z) {
                    hexString = hexString.toUpperCase();
                }
                if (hexString.length() == 1) {
                    sb.append("0");
                }
                sb.append(hexString);
                sb.append(str);
            }
            return sb.toString();
        }

        public static String b(byte[] bArr, boolean z) {
            try {
                MessageDigest messageDigest = MessageDigest.getInstance("MD5");
                messageDigest.reset();
                messageDigest.update(bArr);
                return a(messageDigest.digest(), "", z);
            } catch (NoSuchAlgorithmException e2) {
                throw new RuntimeException(e2);
            }
        }
    }

    /* loaded from: classes2.dex */
    public final class d {
        public static byte[] a(byte[] bArr) {
            try {
                return MessageDigest.getInstance("SHA-1").digest(bArr);
            } catch (NoSuchAlgorithmException e2) {
                throw new RuntimeException(e2);
            }
        }
    }

    public f() {
        c();
    }

    public static String a(byte[] bArr) {
        StringBuilder sb;
        if (bArr != null) {
            String str = "";
            for (byte b2 : bArr) {
                String hexString = Integer.toHexString(b2 & 255);
                if (hexString.length() == 1) {
                    sb = new StringBuilder();
                    sb.append(str);
                    str = "0";
                } else {
                    sb = new StringBuilder();
                }
                sb.append(str);
                sb.append(hexString);
                str = sb.toString();
            }
            return str.toLowerCase();
        }
        throw new IllegalArgumentException("Argument b ( byte array ) is null! ");
    }

    public static byte[] f(byte[] bArr, d.a.j.d.d.d dVar) {
        d.a.j.d.d.a a2 = d.a.j.d.d.a.a();
        a2.b(2, dVar);
        return a2.c(bArr);
    }

    public List<e> b(Context context, Intent intent, boolean z) {
        ArrayList arrayList = new ArrayList();
        PackageManager packageManager = context.getPackageManager();
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
                                byte[] b2 = b.b(string.getBytes("utf-8"));
                                JSONObject jSONObject = new JSONObject(new String(b2));
                                e eVar = new e();
                                eVar.f43892b = jSONObject.getInt("priority");
                                eVar.f43891a = resolveInfo.activityInfo.applicationInfo;
                                if (context.getPackageName().equals(resolveInfo.activityInfo.applicationInfo.packageName)) {
                                    eVar.f43894d = true;
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
                                        if (e(strArr, g(packageInfo.signatures))) {
                                            byte[] f2 = f(b.b(string2.getBytes()), this.f43895a);
                                            if (f2 != null && Arrays.equals(f2, d.a(b2))) {
                                                eVar.f43893c = true;
                                            }
                                        }
                                    }
                                }
                                arrayList.add(eVar);
                            }
                        }
                    } catch (Exception unused) {
                    }
                }
            }
        }
        Collections.sort(arrayList, new a(this));
        return arrayList;
    }

    public final void c() {
        this.f43895a = new d.a.j.d.d.e(h.a(), h.b());
    }

    public boolean d(Context context) {
        List<e> b2 = b(context, new Intent("com.baidu.intent.action.GALAXY").setPackage(context.getPackageName()), true);
        if (b2 == null || b2.size() == 0) {
            for (int i2 = 0; i2 < 3; i2++) {
                Log.w("CuidBuddyInfoManager", "galaxy lib host missing meta-data,make sure you know the right way to integrate galaxy");
            }
            return false;
        }
        boolean z = b2.get(0).f43893c;
        if (!z) {
            for (int i3 = 0; i3 < 3; i3++) {
                Log.w("CuidBuddyInfoManager", "galaxy config err, In the release version of the signature should be matched");
            }
        }
        return z;
    }

    public final boolean e(String[] strArr, String[] strArr2) {
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

    public final String[] g(Signature[] signatureArr) {
        int length = signatureArr.length;
        String[] strArr = new String[length];
        for (int i2 = 0; i2 < length; i2++) {
            strArr[i2] = a(d.a(signatureArr[i2].toByteArray()));
        }
        return strArr;
    }

    public List<e> h(Context context) {
        List<e> list = this.f43896b;
        if (list != null) {
            return list;
        }
        d(context);
        List<e> b2 = b(context, new Intent("com.baidu.intent.action.GALAXY"), true);
        this.f43896b = b2;
        return b2;
    }
}
