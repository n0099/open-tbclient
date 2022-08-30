package com.kwad.sdk.pngencrypt.chunk;

import java.util.ArrayList;
import java.util.List;
/* loaded from: classes7.dex */
public final class w {
    public final e amq;
    public final boolean amr;

    public w(e eVar) {
        this.amq = eVar;
        this.amr = !(eVar instanceof f);
    }

    private List<? extends t> du(String str) {
        ArrayList arrayList = new ArrayList();
        arrayList.addAll(this.amq.M("tEXt", str));
        arrayList.addAll(this.amq.M("zTXt", str));
        arrayList.addAll(this.amq.M("iTXt", str));
        return arrayList;
    }

    public final String dv(String str) {
        List<? extends t> du = du(str);
        if (du.isEmpty()) {
            return "";
        }
        StringBuilder sb = new StringBuilder();
        for (t tVar : du) {
            sb.append(tVar.yR());
            sb.append("\n");
        }
        return sb.toString().trim();
    }
}
