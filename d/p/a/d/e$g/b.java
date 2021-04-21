package d.p.a.d.e$g;

import android.content.Context;
import android.net.Uri;
import android.os.Parcelable;
import androidx.annotation.NonNull;
import com.meizu.cloud.pushsdk.notification.model.ActVideoSetting;
import com.ss.android.downloadlib.a.a.d;
import com.ss.android.downloadlib.a.a.e;
import com.ss.android.downloadlib.a.a.f;
import com.ss.android.downloadlib.a.a.g;
import d.p.a.d.f.n;
import d.p.a.d.n.k;
import java.util.ArrayList;
import org.json.JSONObject;
/* loaded from: classes6.dex */
public class b {
    public static e a(@NonNull JSONObject jSONObject, String str) {
        String c2 = d.p.a.e.a.h.b.c(jSONObject, "ar", str);
        String c3 = d.p.a.e.a.h.b.c(jSONObject, "as", str);
        if (k.I(n.a(), c2)) {
            e eVar = new e();
            eVar.f38999b = c2;
            eVar.f39000c = c2;
            eVar.f39001d = 100300000;
            eVar.f38998a = 2;
            return eVar;
        } else if (k.I(n.a(), c3)) {
            e eVar2 = new e();
            eVar2.f38999b = c3;
            eVar2.f39000c = c3;
            eVar2.f39001d = 100300000;
            eVar2.f38998a = 2;
            return eVar2;
        } else {
            return null;
        }
    }

    public static f b(String str, @NonNull JSONObject jSONObject, String str2) {
        String c2 = d.p.a.e.a.h.b.c(jSONObject, "ar", str2);
        String c3 = d.p.a.e.a.h.b.c(jSONObject, "as", str2);
        if (k.I(n.a(), c2)) {
            String c4 = d.p.a.e.a.h.b.c(jSONObject, "at", str2);
            f fVar = new f();
            fVar.f39002a = str;
            fVar.f39003b = c4;
            fVar.f39005d = 0;
            fVar.f39006e = 2;
            fVar.f39004c = c4;
            return fVar;
        } else if (k.I(n.a(), c3)) {
            String c5 = d.p.a.e.a.h.b.c(jSONObject, ActVideoSetting.ACT_URL, str2);
            f fVar2 = new f();
            fVar2.f39002a = str;
            fVar2.f39003b = c5;
            fVar2.f39005d = 0;
            fVar2.f39006e = 0;
            fVar2.f39004c = c5;
            return fVar2;
        } else {
            return null;
        }
    }

    public static boolean c(Context context, String str, String str2, @NonNull JSONObject jSONObject, String str3) {
        try {
            a.a();
            d dVar = new d("android.intent.action.VIEW", Uri.parse(String.format(d.p.a.e.a.h.b.c(jSONObject, "ap", str3), str2)));
            String k = d.p.a.e.a.h.c.k();
            if (k.I(n.a(), k)) {
                dVar.setPackage(k);
            }
            ArrayList<? extends Parcelable> arrayList = new ArrayList<>();
            g gVar = new g();
            e a2 = a(jSONObject, str3);
            f b2 = b(str, jSONObject, str3);
            if (a2 != null && b2 != null) {
                gVar.f39008b = a2;
                gVar.f39007a = d.p.a.e.a.h.b.c(jSONObject, "aq", str3);
                gVar.f39009c = b2;
                arrayList.add(gVar);
                dVar.putParcelableArrayListExtra(d.p.a.e.a.h.b.c(jSONObject, com.alipay.sdk.sys.a.k, str3), arrayList);
                dVar.addFlags(268468224);
                dVar.putExtra("start_only_for_android", true);
                if (k.u(context, dVar)) {
                    context.startActivity(dVar);
                    return true;
                }
                return false;
            }
        } catch (Throwable unused) {
        }
        return false;
    }
}
