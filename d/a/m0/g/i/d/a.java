package d.a.m0.g.i.d;

import android.os.Bundle;
import android.text.TextUtils;
import com.baidu.searchbox.process.ipc.util.ProcessUtils;
import com.baidu.swan.gamecenter.appmanager.download.AppDownloadNetworkStateReceiver;
import com.baidu.swan.gamecenter.network.models.ReservationGameInfo;
import d.a.m0.a.a2.d;
import d.a.m0.a.k2.g.h;
import d.a.m0.g.c.d.e;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Iterator;
import java.util.List;
import org.json.JSONException;
import org.json.JSONObject;
/* loaded from: classes3.dex */
public class a {

    /* renamed from: d.a.m0.g.i.d.a$a  reason: collision with other inner class name */
    /* loaded from: classes3.dex */
    public class C1064a implements d.a.m0.g.h.b<List<ReservationGameInfo>> {

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ String[] f50876a;

        public C1064a(String[] strArr) {
            this.f50876a = strArr;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // d.a.m0.g.h.b
        /* renamed from: a */
        public void onSuccess(List<ReservationGameInfo> list) {
            if (list == null) {
                return;
            }
            ArrayList arrayList = new ArrayList();
            arrayList.addAll(list);
            ArrayList arrayList2 = new ArrayList(Arrays.asList(this.f50876a));
            Iterator it = arrayList.iterator();
            while (it.hasNext()) {
                ReservationGameInfo reservationGameInfo = (ReservationGameInfo) it.next();
                boolean z = reservationGameInfo.auto_download;
                String str = reservationGameInfo.app_id;
                if (z) {
                    String str2 = reservationGameInfo.download_url;
                    String str3 = reservationGameInfo.package_id;
                    if (!TextUtils.isEmpty(str2) && !TextUtils.isEmpty(str3) && !TextUtils.isEmpty(str)) {
                        a.this.e(str2, str3, str);
                        d.a.m0.g.h.a.b().c(str);
                        if (arrayList2.remove(str)) {
                            a.this.f(arrayList2);
                        }
                    }
                } else if (arrayList2.remove(str)) {
                    a.this.f(arrayList2);
                }
            }
        }

        @Override // d.a.m0.g.h.b
        public void onFail(String str) {
        }
    }

    /* loaded from: classes3.dex */
    public static class b {

        /* renamed from: a  reason: collision with root package name */
        public static final a f50878a = new a();
    }

    /* loaded from: classes3.dex */
    public class c implements d.a.m0.g.c.f.b {
        public c(a aVar) {
        }

        @Override // d.a.m0.g.c.f.b
        public void b(d.a.m0.g.c.g.b bVar) {
        }
    }

    public static final a c() {
        return b.f50878a;
    }

    public void d() {
        if (d.a.m0.a.c1.a.a0().e(d.a.m0.a.c1.a.b())) {
            String string = h.a().getString("reservation_apk_ids", "");
            if (TextUtils.isEmpty(string)) {
                return;
            }
            String[] split = string.split(",");
            if (split.length == 0) {
                return;
            }
            d.a.m0.g.h.a.b().d(new C1064a(split));
        }
    }

    public final void e(String str, String str2, String str3) {
        if (ProcessUtils.isMainProcess()) {
            d.a.m0.g.c.a.n().H(str, str2, str3, new c(this));
            return;
        }
        d.a.m0.a.v1.c.e.a z = d.g().z();
        if (z != null) {
            JSONObject jSONObject = new JSONObject();
            try {
                jSONObject.put("url", str);
                jSONObject.put("packageName", str2);
                jSONObject.put("apkId", str3);
            } catch (JSONException e2) {
                e2.printStackTrace();
            }
            Bundle bundle = new Bundle();
            bundle.putString(AppDownloadNetworkStateReceiver.KEY_OPERATION, "startDownload");
            bundle.putString("data", jSONObject.toString());
            bundle.putString("ubc_params", new d.a.m0.g.c.i.a().a());
            z.K(bundle, e.class);
        }
    }

    public final void f(ArrayList<String> arrayList) {
        StringBuffer stringBuffer = new StringBuffer();
        for (int i2 = 0; i2 < arrayList.size(); i2++) {
            stringBuffer.append(arrayList.get(i2));
            if (i2 < arrayList.size() - 1) {
                stringBuffer.append(",");
            }
        }
        h.a().putString("reservation_apk_ids", stringBuffer.toString());
    }
}
