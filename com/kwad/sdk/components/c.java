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
    public static final Map<Class, a> Td = new ConcurrentHashMap();

    public static void a(Class cls, a aVar) {
        Td.put(cls, aVar);
    }

    @Nullable
    public static <T extends a> T f(Class<T> cls) {
        T t = (T) Td.get(cls);
        if (t != null) {
            return t;
        }
        com.kwad.sdk.core.e.b.w("KSAdSDK", new ComponentsNotFoundException(cls.getSimpleName()));
        try {
            if (DevelopMangerComponents.class.isAssignableFrom(cls)) {
                e eVar = new e();
                Td.put(cls, eVar);
                return eVar;
            }
            return null;
        } catch (Throwable th) {
            com.kwad.sdk.core.e.b.printStackTraceOnly(th);
            return null;
        }
    }

    public static void init(Context context, SdkConfig sdkConfig) {
        ArrayList arrayList = new ArrayList(Td.values());
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
                    com.kwad.sdk.core.e.b.printStackTrace(th);
                }
            }
        }
    }
}
