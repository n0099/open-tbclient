package com.yanzhenjie.permission;

import android.support.annotation.NonNull;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
/* loaded from: classes6.dex */
class c implements h {
    private static final com.yanzhenjie.permission.a.a pBr = new com.yanzhenjie.permission.a.b();
    private String[] afe;
    private com.yanzhenjie.permission.b.b pBs;
    private a pBt;
    private a pBu;

    /* JADX INFO: Access modifiers changed from: package-private */
    public c(com.yanzhenjie.permission.b.b bVar) {
        this.pBs = bVar;
    }

    @Override // com.yanzhenjie.permission.h
    @NonNull
    public h aa(String... strArr) {
        this.afe = strArr;
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
        this.pBt = aVar;
        return this;
    }

    @Override // com.yanzhenjie.permission.h
    @NonNull
    public h b(a aVar) {
        this.pBu = aVar;
        return this;
    }

    @Override // com.yanzhenjie.permission.h
    public void start() {
        List<String> a2 = a(this.pBs, this.afe);
        if (a2.isEmpty()) {
            ewd();
        } else {
            gC(a2);
        }
    }

    private void ewd() {
        if (this.pBt != null) {
            List<String> asList = Arrays.asList(this.afe);
            try {
                this.pBt.onAction(asList);
            } catch (Exception e) {
                if (this.pBu != null) {
                    this.pBu.onAction(asList);
                }
            }
        }
    }

    private void gC(@NonNull List<String> list) {
        if (this.pBu != null) {
            this.pBu.onAction(list);
        }
    }

    private static List<String> a(@NonNull com.yanzhenjie.permission.b.b bVar, @NonNull String... strArr) {
        ArrayList arrayList = new ArrayList(1);
        for (String str : strArr) {
            if (!pBr.e(bVar.getContext(), str)) {
                arrayList.add(str);
            }
        }
        return arrayList;
    }
}
