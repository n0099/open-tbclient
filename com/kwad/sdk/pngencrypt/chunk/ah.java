package com.kwad.sdk.pngencrypt.chunk;

import java.util.ArrayList;
import java.util.List;
/* loaded from: classes5.dex */
public class ah {
    public final e a;
    public final boolean b;

    public ah(e eVar) {
        this.a = eVar;
        this.b = !(eVar instanceof f);
    }

    public List<? extends ae> a(String str) {
        ArrayList arrayList = new ArrayList();
        arrayList.addAll(this.a.a("tEXt", str));
        arrayList.addAll(this.a.a("zTXt", str));
        arrayList.addAll(this.a.a("iTXt", str));
        return arrayList;
    }

    public String b(String str) {
        List<? extends ae> a = a(str);
        if (a.isEmpty()) {
            return "";
        }
        StringBuilder sb = new StringBuilder();
        for (ae aeVar : a) {
            sb.append(aeVar.d());
            sb.append("\n");
        }
        return sb.toString().trim();
    }
}
