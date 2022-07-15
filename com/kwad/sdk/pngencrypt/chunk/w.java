package com.kwad.sdk.pngencrypt.chunk;

import java.util.ArrayList;
import java.util.List;
/* loaded from: classes5.dex */
public final class w {
    public final e a;
    public final boolean b;

    public w(e eVar) {
        this.a = eVar;
        this.b = !(eVar instanceof f);
    }

    private List<? extends t> b(String str) {
        ArrayList arrayList = new ArrayList();
        arrayList.addAll(this.a.a("tEXt", str));
        arrayList.addAll(this.a.a("zTXt", str));
        arrayList.addAll(this.a.a("iTXt", str));
        return arrayList;
    }

    public final String a(String str) {
        List<? extends t> b = b(str);
        if (b.isEmpty()) {
            return "";
        }
        StringBuilder sb = new StringBuilder();
        for (t tVar : b) {
            sb.append(tVar.b());
            sb.append("\n");
        }
        return sb.toString().trim();
    }
}
