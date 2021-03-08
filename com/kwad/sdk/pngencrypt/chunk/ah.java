package com.kwad.sdk.pngencrypt.chunk;

import java.util.ArrayList;
import java.util.List;
/* loaded from: classes3.dex */
public class ah {

    /* renamed from: a  reason: collision with root package name */
    private final e f6919a;
    private final boolean b;

    public ah(e eVar) {
        this.f6919a = eVar;
        if (eVar instanceof f) {
            this.b = false;
        } else {
            this.b = true;
        }
    }

    public List<? extends ae> a(String str) {
        ArrayList arrayList = new ArrayList();
        arrayList.addAll(this.f6919a.a("tEXt", str));
        arrayList.addAll(this.f6919a.a("zTXt", str));
        arrayList.addAll(this.f6919a.a("iTXt", str));
        return arrayList;
    }

    public String b(String str) {
        List<? extends ae> a2 = a(str);
        if (a2.isEmpty()) {
            return "";
        }
        StringBuilder sb = new StringBuilder();
        for (ae aeVar : a2) {
            sb.append(aeVar.d()).append("\n");
        }
        return sb.toString().trim();
    }
}
