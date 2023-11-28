package com.xiaomi.push;

import android.util.Pair;
import com.yy.hiidostatis.defs.obj.ParamableElem;
import java.util.Vector;
import java.util.concurrent.ConcurrentHashMap;
/* loaded from: classes10.dex */
public class es {
    public static Vector<Pair<String, Long>> a = new Vector<>();

    /* renamed from: a  reason: collision with other field name */
    public static ConcurrentHashMap<String, Long> f324a = new ConcurrentHashMap<>();

    public static String a() {
        StringBuilder sb = new StringBuilder();
        synchronized (a) {
            for (int i = 0; i < a.size(); i++) {
                Pair<String, Long> elementAt = a.elementAt(i);
                sb.append((String) elementAt.first);
                sb.append(":");
                sb.append(elementAt.second);
                if (i < a.size() - 1) {
                    sb.append(ParamableElem.DIVIDE_PARAM);
                }
            }
            a.clear();
        }
        return sb.toString();
    }
}
