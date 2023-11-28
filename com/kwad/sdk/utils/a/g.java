package com.kwad.sdk.utils.a;

import com.kwad.sdk.utils.a.c;
import java.util.LinkedHashSet;
import java.util.Set;
/* loaded from: classes10.dex */
public final class g implements c.b<Set<String>> {
    public static final g aQC = new g();

    @Override // com.kwad.sdk.utils.a.c.b
    public final String Ml() {
        return "StringSet";
    }

    public static byte[] e(Set<String> set) {
        if (set.isEmpty()) {
            return new byte[0];
        }
        int size = set.size();
        int[] iArr = new int[size];
        String[] strArr = new String[size];
        int i = 0;
        int i2 = 0;
        for (String str : set) {
            if (str == null) {
                i += 5;
                iArr[i2] = -1;
            } else {
                int gw = b.gw(str);
                strArr[i2] = str;
                iArr[i2] = gw;
                i += b.dI(gw) + gw;
            }
            i2++;
        }
        b bVar = new b(i);
        for (int i3 = 0; i3 < size; i3++) {
            int i4 = iArr[i3];
            bVar.dH(i4);
            if (i4 >= 0) {
                bVar.gv(strArr[i3]);
            }
        }
        return bVar.aPJ;
    }

    public static Set<String> h(byte[] bArr, int i, int i2) {
        int i3;
        LinkedHashSet linkedHashSet = new LinkedHashSet();
        if (i2 > 0) {
            b bVar = new b(bArr, i);
            int i4 = i + i2;
            while (true) {
                i3 = bVar.position;
                if (i3 >= i4) {
                    break;
                }
                linkedHashSet.add(bVar.getString(bVar.LR()));
            }
            if (i3 != i4) {
                throw new IllegalArgumentException("Invalid String set");
            }
        }
        return linkedHashSet;
    }

    /* JADX DEBUG: Return type fixed from 'java.lang.Object' to match base method */
    @Override // com.kwad.sdk.utils.a.c.b
    public final /* synthetic */ Set<String> g(byte[] bArr, int i, int i2) {
        return h(bArr, i, i2);
    }

    /* JADX DEBUG: Method arguments types fixed to match base method, original types: [java.lang.Object] */
    @Override // com.kwad.sdk.utils.a.c.b
    public final /* synthetic */ byte[] o(Set<String> set) {
        return e(set);
    }
}
