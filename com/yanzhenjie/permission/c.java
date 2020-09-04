package com.yanzhenjie.permission;

import android.support.annotation.NonNull;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
/* loaded from: classes4.dex */
class c implements h {
    private static final com.yanzhenjie.permission.a.a okU = new com.yanzhenjie.permission.a.b();
    private String[] aeu;
    private com.yanzhenjie.permission.b.b okV;
    private a okW;
    private a okX;

    /* JADX INFO: Access modifiers changed from: package-private */
    public c(com.yanzhenjie.permission.b.b bVar) {
        this.okV = bVar;
    }

    @Override // com.yanzhenjie.permission.h
    @NonNull
    public h W(String... strArr) {
        this.aeu = strArr;
        return this;
    }

    @Override // com.yanzhenjie.permission.h
    @NonNull
    public h a(g gVar) {
        return this;
    }

    @Override // com.yanzhenjie.permission.h
    @NonNull
    public h a(a aVar) {
        this.okW = aVar;
        return this;
    }

    @Override // com.yanzhenjie.permission.h
    @NonNull
    public h b(a aVar) {
        this.okX = aVar;
        return this;
    }

    @Override // com.yanzhenjie.permission.h
    public void start() {
        List<String> a = a(this.okV, this.aeu);
        if (a.isEmpty()) {
            eev();
        } else {
            fU(a);
        }
    }

    private void eev() {
        if (this.okW != null) {
            List<String> asList = Arrays.asList(this.aeu);
            try {
                this.okW.onAction(asList);
            } catch (Exception e) {
                if (this.okX != null) {
                    this.okX.onAction(asList);
                }
            }
        }
    }

    private void fU(@NonNull List<String> list) {
        if (this.okX != null) {
            this.okX.onAction(list);
        }
    }

    private static List<String> a(@NonNull com.yanzhenjie.permission.b.b bVar, @NonNull String... strArr) {
        ArrayList arrayList = new ArrayList(1);
        for (String str : strArr) {
            if (!okU.e(bVar.getContext(), str)) {
                arrayList.add(str);
            }
        }
        return arrayList;
    }
}
