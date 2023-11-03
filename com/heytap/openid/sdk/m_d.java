package com.heytap.openid.sdk;

import android.content.Context;
import android.os.Looper;
import android.util.Log;
import androidx.annotation.Keep;
import com.baidu.cyberplayer.sdk.statistics.DpStatConstants;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
@Keep
/* loaded from: classes10.dex */
public class m_d {
    public static /* synthetic */ Interceptable $ic;
    @Keep
    public static boolean m_a;
    @Keep
    public static boolean m_b;
    @Keep
    public static boolean m_c;
    public transient /* synthetic */ FieldHolder $fh;

    @Keep
    public static native Context m_a(Context context);

    /* JADX WARN: Removed duplicated region for block: B:40:0x0084  */
    /* JADX WARN: Removed duplicated region for block: B:49:0x00a3  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public static HashMap<String, String> m_a(Context context, int i) {
        InterceptResult invokeLI;
        String str;
        String str2;
        Interceptable interceptable = $ic;
        if (interceptable != null && (invokeLI = interceptable.invokeLI(65537, null, context, i)) != null) {
            return (HashMap) invokeLI.objValue;
        }
        int m_a2 = m_a.m_a(i);
        if (m_a2 != 10000) {
            throw new RuntimeException(m_a2 + "");
        }
        ArrayList arrayList = new ArrayList();
        if ((i & 8) == 8) {
            arrayList.add("OUID");
            arrayList.add("OUID_STATUS");
        }
        if ((i & 32) == 32 && !arrayList.contains("OUID_STATUS")) {
            arrayList.add("OUID_STATUS");
        }
        if ((i & 2) == 2) {
            arrayList.add("AUID");
        }
        if ((i & 16) == 16) {
            arrayList.add("GUID");
        }
        boolean z = true;
        if ((i & 1) == 1) {
            arrayList.add("APID");
        }
        if ((i & 4) == 4) {
            arrayList.add("DUID");
        }
        if (!m_a) {
            str = "1001";
        } else if (m_b || m_c) {
            if (Looper.myLooper() == Looper.getMainLooper()) {
                str = DpStatConstants.FILECACHE_CLOSE_TYPE_OPT_IS_LIVE;
            }
            if (z) {
                HashMap<String, String> hashMap = new HashMap<>();
                Iterator it = arrayList.iterator();
                while (it.hasNext()) {
                    String str3 = (String) it.next();
                    hashMap.put(str3, str3 == "OUID_STATUS" ? "FALSE" : "");
                }
                return hashMap;
            }
            m_b m_a3 = m_b.m_a();
            Context m_a4 = m_a(context);
            m_a3.getClass();
            ArrayList arrayList2 = new ArrayList();
            if (m_a3.m_a.isEmpty()) {
                m_a.m_a(m_a4, m_a3.m_a);
            }
            Iterator it2 = arrayList.iterator();
            while (it2.hasNext()) {
                String str4 = (String) it2.next();
                if (m_a3.m_a.containsKey(str4)) {
                    m_f m_fVar = m_a3.m_a.get(str4);
                    if (!m_fVar.m_a(str4)) {
                        ArrayList arrayList3 = new ArrayList();
                        arrayList3.add(str4);
                        m_h.m_a("1025");
                        m_a.m_a.execute(new com.heytap.openid.base.m_a(m_a3, m_a4, arrayList3));
                    }
                    str2 = m_fVar.m_a;
                } else {
                    str2 = null;
                }
                if (str2 == null) {
                    arrayList2.add(str4);
                }
            }
            if (!arrayList2.isEmpty()) {
                m_h.m_a("1026");
                m_a3.m_a(m_a4, (List<String>) arrayList2, false);
            }
            HashMap<String, String> hashMap2 = new HashMap<>();
            Iterator it3 = arrayList.iterator();
            while (it3.hasNext()) {
                String str5 = (String) it3.next();
                m_f m_fVar2 = m_a3.m_a.get(str5);
                hashMap2.put(str5, m_fVar2 == null ? str5 == "OUID_STATUS" ? "FALSE" : "" : m_fVar2.m_a);
            }
            m_h.m_a("2025");
            return hashMap2;
        } else {
            str = "1002";
        }
        Log.e("IDHelper", str);
        z = false;
        if (z) {
        }
    }
}
