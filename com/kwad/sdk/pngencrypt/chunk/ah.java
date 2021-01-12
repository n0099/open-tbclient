package com.kwad.sdk.pngencrypt.chunk;

import java.util.ArrayList;
import java.util.List;
/* loaded from: classes4.dex */
public class ah {

    /* renamed from: a  reason: collision with root package name */
    private final e f10497a;

    /* renamed from: b  reason: collision with root package name */
    private final boolean f10498b;

    public ah(e eVar) {
        this.f10497a = eVar;
        if (eVar instanceof f) {
            this.f10498b = false;
        } else {
            this.f10498b = true;
        }
    }

    public List<? extends ae> a(String str) {
        ArrayList arrayList = new ArrayList();
        arrayList.addAll(this.f10497a.a("tEXt", str));
        arrayList.addAll(this.f10497a.a("zTXt", str));
        arrayList.addAll(this.f10497a.a("iTXt", str));
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
