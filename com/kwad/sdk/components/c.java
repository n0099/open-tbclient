package com.kwad.sdk.components;

import android.content.Context;
import androidx.annotation.Nullable;
import com.kwad.sdk.api.SdkConfig;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.Iterator;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;
/* loaded from: classes5.dex */
public final class c {
    public static final Map<Class, a> a = new ConcurrentHashMap();

    @Nullable
    public static <T extends a> T a(Class<T> cls) {
        T t = (T) a.get(cls);
        if (t != null) {
            return t;
        }
        com.kwad.sdk.core.d.b.a("KSAdSDK", new ComponentsNotFoundException(cls.getSimpleName()));
        try {
            if (DevelopMangerComponents.class.isAssignableFrom(cls)) {
                e eVar = new e();
                a.put(cls, eVar);
                return eVar;
            }
            return null;
        } catch (Throwable th) {
            com.kwad.sdk.core.d.b.b(th);
            return null;
        }
    }

    public static void a(Context context, SdkConfig sdkConfig) {
        ArrayList arrayList = new ArrayList(a.values());
        Collections.sort(arrayList, new Comparator<a>() { // from class: com.kwad.sdk.components.c.1
            public static int a(a aVar, a aVar2) {
                if (aVar == null) {
                    return -1;
                }
                if (aVar2 == null) {
                    return 1;
                }
                try {
                    try {
                        return aVar.priority() - aVar2.priority();
                    } catch (Exception unused) {
                        return 1;
                    }
                } catch (Exception unused2) {
                    return -1;
                }
            }

            /* JADX DEBUG: Method arguments types fixed to match base method, original types: [java.lang.Object, java.lang.Object] */
            @Override // java.util.Comparator
            public final /* synthetic */ int compare(a aVar, a aVar2) {
                return a(aVar, aVar2);
            }
        });
        Iterator it = arrayList.iterator();
        while (it.hasNext()) {
            a aVar = (a) it.next();
            if (aVar != null) {
                try {
                    aVar.init(context, sdkConfig);
                } catch (Throwable th) {
                    com.kwad.sdk.core.d.b.a(th);
                }
            }
        }
    }

    public static void a(Class cls, a aVar) {
        a.put(cls, aVar);
    }
}
