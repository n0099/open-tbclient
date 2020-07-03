package com.yanzhenjie.permission;

import android.support.annotation.NonNull;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
/* loaded from: classes6.dex */
class c implements h {
    private static final com.yanzhenjie.permission.a.a nHU = new com.yanzhenjie.permission.a.b();
    private String[] acS;
    private com.yanzhenjie.permission.b.b nHV;
    private a nHW;
    private a nHX;

    /* JADX INFO: Access modifiers changed from: package-private */
    public c(com.yanzhenjie.permission.b.b bVar) {
        this.nHV = bVar;
    }

    @Override // com.yanzhenjie.permission.h
    @NonNull
    public h X(String... strArr) {
        this.acS = strArr;
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
        this.nHW = aVar;
        return this;
    }

    @Override // com.yanzhenjie.permission.h
    @NonNull
    public h b(a aVar) {
        this.nHX = aVar;
        return this;
    }

    @Override // com.yanzhenjie.permission.h
    public void start() {
        List<String> a = a(this.nHV, this.acS);
        if (a.isEmpty()) {
            dOJ();
        } else {
            fB(a);
        }
    }

    private void dOJ() {
        if (this.nHW != null) {
            List<String> asList = Arrays.asList(this.acS);
            try {
                this.nHW.onAction(asList);
            } catch (Exception e) {
                if (this.nHX != null) {
                    this.nHX.onAction(asList);
                }
            }
        }
    }

    private void fB(@NonNull List<String> list) {
        if (this.nHX != null) {
            this.nHX.onAction(list);
        }
    }

    private static List<String> a(@NonNull com.yanzhenjie.permission.b.b bVar, @NonNull String... strArr) {
        ArrayList arrayList = new ArrayList(1);
        for (String str : strArr) {
            if (!nHU.e(bVar.getContext(), str)) {
                arrayList.add(str);
            }
        }
        return arrayList;
    }
}
