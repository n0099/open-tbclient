package d.a.l0.g.i.d;

import android.text.TextUtils;
import android.util.Log;
import androidx.annotation.NonNull;
import d.a.l0.a.k;
import d.a.l0.a.k2.g.h;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashSet;
import org.json.JSONObject;
/* loaded from: classes3.dex */
public class b extends d.a.l0.g.f.a {

    /* renamed from: c  reason: collision with root package name */
    public static final boolean f50771c = k.f46875a;

    public b() {
        super("ReservationGame");
    }

    @Override // d.a.l0.g.f.a
    public d.a.l0.a.u.h.b a(@NonNull JSONObject jSONObject, @NonNull d.a.l0.a.u0.b bVar) {
        if (jSONObject == null) {
            bVar.onFail(202, "params may be error");
            return null;
        }
        if (f50771c) {
            Log.e("ReservationGameAction", "params is " + jSONObject.toString());
        }
        String optString = jSONObject.optString("apkId");
        int optInt = jSONObject.optInt("isReservation");
        if (TextUtils.isEmpty(optString)) {
            bVar.onFail(31023, "reservation apk id is empty");
            return null;
        } else if (optInt == 0) {
            bVar.onFail(31024, "reservation status error");
            return null;
        } else {
            String string = h.a().getString("reservation_apk_ids", "");
            if (optInt == 1) {
                d(string, optString);
                bVar.a(null);
            } else if (optInt == 2) {
                if (b(string, optString)) {
                    bVar.a(null);
                } else {
                    bVar.onFail(31025, "reservation cancel fail");
                }
            }
            return null;
        }
    }

    public final boolean b(String str, String str2) {
        if (TextUtils.isEmpty(str)) {
            return true;
        }
        ArrayList<String> arrayList = new ArrayList<>(Arrays.asList(str.split(",")));
        boolean remove = arrayList.remove(str2);
        if (remove) {
            c(arrayList);
        }
        return remove;
    }

    public final void c(ArrayList<String> arrayList) {
        StringBuffer stringBuffer = new StringBuffer();
        for (int i2 = 0; i2 < arrayList.size(); i2++) {
            stringBuffer.append(arrayList.get(i2));
            if (i2 < arrayList.size() - 1) {
                stringBuffer.append(",");
            }
        }
        h.a().putString("reservation_apk_ids", stringBuffer.toString());
    }

    public final void d(String str, String str2) {
        HashSet hashSet;
        if (TextUtils.isEmpty(str)) {
            hashSet = new HashSet();
        } else {
            hashSet = new HashSet(Arrays.asList(str.split(",")));
        }
        hashSet.add(str2);
        c(new ArrayList<>(hashSet));
    }
}
