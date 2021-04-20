package com.kwad.sdk.pngencrypt.chunk;

import java.util.ArrayList;
import java.util.List;
/* loaded from: classes6.dex */
public class ah {

    /* renamed from: a  reason: collision with root package name */
    public final e f36421a;

    /* renamed from: b  reason: collision with root package name */
    public final boolean f36422b;

    public ah(e eVar) {
        this.f36421a = eVar;
        this.f36422b = !(eVar instanceof f);
    }

    public List<? extends ae> a(String str) {
        ArrayList arrayList = new ArrayList();
        arrayList.addAll(this.f36421a.a("tEXt", str));
        arrayList.addAll(this.f36421a.a("zTXt", str));
        arrayList.addAll(this.f36421a.a("iTXt", str));
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
