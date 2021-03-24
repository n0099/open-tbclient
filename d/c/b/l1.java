package d.c.b;

import android.content.ComponentName;
import android.content.Context;
import android.content.Intent;
import android.content.pm.PackageInfo;
import android.content.pm.Signature;
import android.os.Build;
import android.os.IBinder;
import android.text.TextUtils;
import com.bytedance.embedapplog.bo;
import d.c.b.g1;
import d.c.b.n1;
import java.security.MessageDigest;
/* loaded from: classes5.dex */
public final class l1 implements g1 {

    /* renamed from: a  reason: collision with root package name */
    public final g1 f65033a;

    /* renamed from: b  reason: collision with root package name */
    public t0<Boolean> f65034b;

    /* loaded from: classes5.dex */
    public class a extends t0<Boolean> {
        public a(l1 l1Var) {
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // d.c.b.t0
        /* renamed from: c */
        public Boolean a(Object... objArr) {
            long j;
            try {
                PackageInfo packageInfo = ((Context) objArr[0]).getPackageManager().getPackageInfo("com.heytap.openid", 0);
                if (packageInfo == null) {
                    return Boolean.FALSE;
                }
                if (Build.VERSION.SDK_INT >= 28) {
                    j = packageInfo.getLongVersionCode();
                } else {
                    j = packageInfo.versionCode;
                }
                return Boolean.valueOf(j >= 1);
            } catch (Throwable th) {
                th.printStackTrace();
                return Boolean.FALSE;
            }
        }
    }

    /* loaded from: classes5.dex */
    public class b implements n1.b<bo, String> {

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ Context f65035a;

        public b(Context context) {
            this.f65035a = context;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // d.c.b.n1.b
        /* renamed from: b */
        public bo a(IBinder iBinder) {
            return bo.a.a(iBinder);
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // d.c.b.n1.b
        /* renamed from: c */
        public String a(bo boVar) {
            if (boVar == null) {
                return null;
            }
            String c2 = l1.this.c(this.f65035a);
            if (TextUtils.isEmpty(c2)) {
                return null;
            }
            return boVar.a(this.f65035a.getPackageName(), c2, "OUID");
        }
    }

    public l1() {
        this(null);
    }

    @Override // d.c.b.g1
    public g1.a b(Context context) {
        if (this.f65033a != null && !this.f65034b.b(new Object[0]).booleanValue()) {
            return this.f65033a.b(context);
        }
        Intent intent = new Intent();
        intent.setComponent(new ComponentName("com.heytap.openid", "com.heytap.openid.IdentifyService"));
        intent.setAction("action.com.heytap.openid.OPEN_ID_SERVICE");
        g1.a aVar = new g1.a();
        aVar.f64995a = (String) new n1(context, intent, new b(context)).a();
        return aVar;
    }

    /* JADX WARN: Removed duplicated region for block: B:16:0x002d A[Catch: Exception -> 0x0054, TryCatch #1 {Exception -> 0x0054, blocks: (B:14:0x0025, B:16:0x002d, B:18:0x0039, B:19:0x004f), top: B:26:0x0025 }] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public final String c(Context context) {
        Signature[] signatureArr;
        MessageDigest messageDigest;
        PackageInfo packageInfo;
        try {
            packageInfo = context.getPackageManager().getPackageInfo(context.getPackageName(), 64);
        } catch (Throwable th) {
            th.printStackTrace();
        }
        if (packageInfo != null) {
            signatureArr = packageInfo.signatures;
            if (signatureArr != null && signatureArr.length > 0) {
                byte[] byteArray = signatureArr[0].toByteArray();
                try {
                    messageDigest = MessageDigest.getInstance("SHA1");
                    if (messageDigest != null) {
                        byte[] digest = messageDigest.digest(byteArray);
                        StringBuilder sb = new StringBuilder();
                        for (byte b2 : digest) {
                            sb.append(Integer.toHexString((b2 & 255) | 256).substring(1, 3));
                        }
                        return sb.toString();
                    }
                } catch (Exception e2) {
                    e2.printStackTrace();
                }
            }
            return null;
        }
        signatureArr = null;
        if (signatureArr != null) {
            byte[] byteArray2 = signatureArr[0].toByteArray();
            messageDigest = MessageDigest.getInstance("SHA1");
            if (messageDigest != null) {
            }
        }
        return null;
    }

    public l1(g1 g1Var) {
        this.f65034b = new a(this);
        this.f65033a = g1Var;
    }

    @Override // d.c.b.g1
    public boolean a(Context context) {
        if (context == null) {
            return false;
        }
        Boolean b2 = this.f65034b.b(context);
        if (this.f65033a != null && !b2.booleanValue()) {
            return this.f65033a.a(context);
        }
        return b2.booleanValue();
    }
}
