package com.kwad.sdk.pngencrypt.chunk;

import java.util.ArrayList;
import java.util.List;
/* loaded from: classes6.dex */
public class ah {

    /* renamed from: a  reason: collision with root package name */
    public final e f36516a;

    /* renamed from: b  reason: collision with root package name */
    public final boolean f36517b;

    public ah(e eVar) {
        this.f36516a = eVar;
        this.f36517b = !(eVar instanceof f);
    }

    public List<? extends ae> a(String str) {
        ArrayList arrayList = new ArrayList();
        arrayList.addAll(this.f36516a.a("tEXt", str));
        arrayList.addAll(this.f36516a.a("zTXt", str));
        arrayList.addAll(this.f36516a.a("iTXt", str));
        return arrayList;
    }

    public String b(String str) {
        List<? extends ae> a2 = a(str);
        if (a2.isEmpty()) {
            return "";
        }
        StringBuilder sb = new StringBuilder();
        for (ae aeVar : a2) {
            sb.append(aeVar.d());
            sb.append("\n");
        }
        return sb.toString().trim();
    }
}
