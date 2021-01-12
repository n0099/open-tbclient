package com.ss.android.downloadlib.a.b;

import android.content.SharedPreferences;
import androidx.annotation.NonNull;
import com.ss.android.downloadlib.a.j;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;
import org.json.JSONObject;
/* loaded from: classes4.dex */
public class g {

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes4.dex */
    public static class a {
        private static g pRa = new g();
    }

    public static g eCf() {
        return a.pRa;
    }

    private g() {
    }

    /* JADX INFO: Access modifiers changed from: private */
    public SharedPreferences c() {
        return j.a().getSharedPreferences("sp_ad_download_event", 0);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    @NonNull
    public ConcurrentHashMap<Long, com.ss.android.b.a.b.a> b() {
        ConcurrentHashMap<Long, com.ss.android.b.a.b.a> concurrentHashMap = new ConcurrentHashMap<>();
        Map<String, ?> all = c().getAll();
        if (all == null) {
            return concurrentHashMap;
        }
        for (Map.Entry<String, ?> entry : all.entrySet()) {
            if (entry.getValue() != null) {
                try {
                    long longValue = Long.valueOf(entry.getKey()).longValue();
                    com.ss.android.b.a.b.a fb = com.ss.android.b.a.b.a.fb(new JSONObject(String.valueOf(entry.getValue())));
                    if (longValue > 0 && fb != null) {
                        concurrentHashMap.put(Long.valueOf(longValue), fb);
                    }
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
        }
        return concurrentHashMap;
    }

    public void d(com.ss.android.b.a.b.a aVar) {
        ArrayList arrayList = new ArrayList();
        arrayList.add(aVar);
        a((Collection<com.ss.android.b.a.b.a>) arrayList);
    }

    public synchronized void a(final Collection<com.ss.android.b.a.b.a> collection) {
        if (collection != null) {
            if (!collection.isEmpty()) {
                com.ss.android.downloadlib.f.eCI().c(new Runnable() { // from class: com.ss.android.downloadlib.a.b.g.1
                    @Override // java.lang.Runnable
                    public void run() {
                        SharedPreferences.Editor edit = g.this.c().edit();
                        for (com.ss.android.b.a.b.a aVar : collection) {
                            if (aVar != null && aVar.j() != 0) {
                                edit.putString(String.valueOf(aVar.j()), aVar.eBT().toString());
                            }
                        }
                        edit.apply();
                    }
                }, true);
            }
        }
    }

    public void a(final List<String> list) {
        if (list != null && !list.isEmpty()) {
            com.ss.android.downloadlib.f.eCI().c(new Runnable() { // from class: com.ss.android.downloadlib.a.b.g.2
                @Override // java.lang.Runnable
                public void run() {
                    SharedPreferences.Editor edit = g.this.c().edit();
                    for (String str : list) {
                        edit.remove(str);
                    }
                    edit.apply();
                }
            }, true);
        }
    }
}
