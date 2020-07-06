package com.yanzhenjie.permission;

import android.support.annotation.NonNull;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
/* loaded from: classes6.dex */
class c implements h {
    private static final com.yanzhenjie.permission.a.a nHX = new com.yanzhenjie.permission.a.b();
    private String[] acS;
    private com.yanzhenjie.permission.b.b nHY;
    private a nHZ;
    private a nIa;

    /* JADX INFO: Access modifiers changed from: package-private */
    public c(com.yanzhenjie.permission.b.b bVar) {
        this.nHY = bVar;
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
        this.nHZ = aVar;
        return this;
    }

    @Override // com.yanzhenjie.permission.h
    @NonNull
    public h b(a aVar) {
        this.nIa = aVar;
        return this;
    }

    @Override // com.yanzhenjie.permission.h
    public void start() {
        List<String> a = a(this.nHY, this.acS);
        if (a.isEmpty()) {
            dON();
        } else {
            fB(a);
        }
    }

    private void dON() {
        if (this.nHZ != null) {
            List<String> asList = Arrays.asList(this.acS);
            try {
                this.nHZ.onAction(asList);
            } catch (Exception e) {
                if (this.nIa != null) {
                    this.nIa.onAction(asList);
                }
            }
        }
    }

    private void fB(@NonNull List<String> list) {
        if (this.nIa != null) {
            this.nIa.onAction(list);
        }
    }

    private static List<String> a(@NonNull com.yanzhenjie.permission.b.b bVar, @NonNull String... strArr) {
        ArrayList arrayList = new ArrayList(1);
        for (String str : strArr) {
            if (!nHX.e(bVar.getContext(), str)) {
                arrayList.add(str);
            }
        }
        return arrayList;
    }
}
