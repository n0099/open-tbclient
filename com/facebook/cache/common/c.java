package com.facebook.cache.common;

import java.io.UnsupportedEncodingException;
import java.util.ArrayList;
import java.util.List;
/* loaded from: classes8.dex */
public final class c {
    public static List<String> a(b bVar) {
        try {
            if (bVar instanceof d) {
                List<b> dNK = ((d) bVar).dNK();
                ArrayList arrayList = new ArrayList(dNK.size());
                for (int i = 0; i < dNK.size(); i++) {
                    arrayList.add(c(dNK.get(i)));
                }
                return arrayList;
            }
            ArrayList arrayList2 = new ArrayList(1);
            arrayList2.add(c(bVar));
            return arrayList2;
        } catch (UnsupportedEncodingException e) {
            throw new RuntimeException(e);
        }
    }

    public static String b(b bVar) {
        try {
            return bVar instanceof d ? c(((d) bVar).dNK().get(0)) : c(bVar);
        } catch (UnsupportedEncodingException e) {
            throw new RuntimeException(e);
        }
    }

    private static String c(b bVar) throws UnsupportedEncodingException {
        return com.facebook.common.util.b.am(bVar.dNJ().getBytes("UTF-8"));
    }
}
