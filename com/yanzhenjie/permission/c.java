package com.yanzhenjie.permission;

import android.support.annotation.NonNull;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
/* loaded from: classes6.dex */
class c implements h {
    private static final com.yanzhenjie.permission.a.a pKL = new com.yanzhenjie.permission.a.b();
    private String[] afe;
    private com.yanzhenjie.permission.b.b pKM;
    private a pKN;
    private a pKO;

    /* JADX INFO: Access modifiers changed from: package-private */
    public c(com.yanzhenjie.permission.b.b bVar) {
        this.pKM = bVar;
    }

    @Override // com.yanzhenjie.permission.h
    @NonNull
    public h ab(String... strArr) {
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
        this.pKN = aVar;
        return this;
    }

    @Override // com.yanzhenjie.permission.h
    @NonNull
    public h b(a aVar) {
        this.pKO = aVar;
        return this;
    }

    @Override // com.yanzhenjie.permission.h
    public void start() {
        List<String> a2 = a(this.pKM, this.afe);
        if (a2.isEmpty()) {
            ezS();
        } else {
            gL(a2);
        }
    }

    private void ezS() {
        if (this.pKN != null) {
            List<String> asList = Arrays.asList(this.afe);
            try {
                this.pKN.onAction(asList);
            } catch (Exception e) {
                if (this.pKO != null) {
                    this.pKO.onAction(asList);
                }
            }
        }
    }

    private void gL(@NonNull List<String> list) {
        if (this.pKO != null) {
            this.pKO.onAction(list);
        }
    }

    private static List<String> a(@NonNull com.yanzhenjie.permission.b.b bVar, @NonNull String... strArr) {
        ArrayList arrayList = new ArrayList(1);
        for (String str : strArr) {
            if (!pKL.e(bVar.getContext(), str)) {
                arrayList.add(str);
            }
        }
        return arrayList;
    }
}
