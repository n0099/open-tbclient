package com.kwad.sdk.pngencrypt.chunk;

import java.util.ArrayList;
import java.util.List;
/* loaded from: classes10.dex */
public final class w {
    public final e aLf;
    public final boolean aLg;

    public w(e eVar) {
        this.aLf = eVar;
        if (eVar instanceof f) {
            this.aLg = false;
        } else {
            this.aLg = true;
        }
    }

    private List<? extends t> fE(String str) {
        ArrayList arrayList = new ArrayList();
        arrayList.addAll(this.aLf.ak("tEXt", str));
        arrayList.addAll(this.aLf.ak("zTXt", str));
        arrayList.addAll(this.aLf.ak("iTXt", str));
        return arrayList;
    }

    public final String fF(String str) {
        List<? extends t> fE = fE(str);
        if (fE.isEmpty()) {
            return "";
        }
        StringBuilder sb = new StringBuilder();
        for (t tVar : fE) {
            sb.append(tVar.IU());
            sb.append("\n");
        }
        return sb.toString().trim();
    }
}
