package d.a.h0.g.l;

import android.text.TextUtils;
import java.util.ArrayList;
import java.util.HashMap;
/* loaded from: classes3.dex */
public class g {

    /* renamed from: a  reason: collision with root package name */
    public HashMap<String, h> f46665a = new HashMap<>();

    public void a(h hVar, String... strArr) {
        if (strArr == null || strArr.length == 0) {
            return;
        }
        for (String str : strArr) {
            if (!TextUtils.isEmpty(str)) {
                this.f46665a.put(str, hVar);
            }
        }
    }

    public void b() {
        this.f46665a.clear();
    }

    public ArrayList<h> c(String... strArr) {
        ArrayList<h> arrayList = null;
        if (strArr != null && strArr.length != 0) {
            for (String str : strArr) {
                if (!TextUtils.isEmpty(str)) {
                    for (String str2 : this.f46665a.keySet()) {
                        if (str2.startsWith(str) || str.startsWith(str2)) {
                            if (arrayList == null) {
                                arrayList = new ArrayList<>();
                            }
                            arrayList.add(this.f46665a.get(str2));
                        }
                    }
                }
            }
        }
        return arrayList;
    }

    public void d(h hVar, String... strArr) {
        if (strArr == null || strArr.length == 0) {
            return;
        }
        for (String str : strArr) {
            if (!TextUtils.isEmpty(str) && this.f46665a.get(str) == hVar) {
                this.f46665a.remove(str);
            }
        }
    }
}
