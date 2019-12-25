package org.greenrobot.eventbus.util;

import android.util.Log;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import org.greenrobot.eventbus.EventBus;
/* loaded from: classes4.dex */
public class ExceptionToResourceMapping {
    public final Map<Class<? extends Throwable>, Integer> throwableToMsgIdMap = new HashMap();

    public Integer mapThrowable(Throwable th) {
        int i = 20;
        Throwable th2 = th;
        do {
            Integer mapThrowableFlat = mapThrowableFlat(th2);
            if (mapThrowableFlat == null) {
                th2 = th2.getCause();
                i--;
                if (i <= 0 || th2 == th) {
                    break;
                }
            } else {
                return mapThrowableFlat;
            }
        } while (th2 != null);
        Log.d(EventBus.TAG, "No specific message ressource ID found for " + th);
        return null;
    }

    protected Integer mapThrowableFlat(Throwable th) {
        Class<?> cls = th.getClass();
        Integer num = this.throwableToMsgIdMap.get(cls);
        if (num != null) {
            return num;
        }
        Class<? extends Throwable> cls2 = null;
        Iterator<Map.Entry<Class<? extends Throwable>, Integer>> it = this.throwableToMsgIdMap.entrySet().iterator();
        while (true) {
            Integer num2 = num;
            if (it.hasNext()) {
                Map.Entry<Class<? extends Throwable>, Integer> next = it.next();
                Class<? extends Throwable> key = next.getKey();
                if (key.isAssignableFrom(cls) && (cls2 == null || cls2.isAssignableFrom(key))) {
                    num = next.getValue();
                } else {
                    key = cls2;
                    num = num2;
                }
                cls2 = key;
            } else {
                return num2;
            }
        }
    }

    public ExceptionToResourceMapping addMapping(Class<? extends Throwable> cls, int i) {
        this.throwableToMsgIdMap.put(cls, Integer.valueOf(i));
        return this;
    }
}
