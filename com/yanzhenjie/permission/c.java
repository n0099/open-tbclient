package com.yanzhenjie.permission;

import android.support.annotation.NonNull;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
/* loaded from: classes5.dex */
class c implements h {
    private static final com.yanzhenjie.permission.a.a nQH = new com.yanzhenjie.permission.a.b();
    private String[] acN;
    private com.yanzhenjie.permission.b.b nQI;
    private a nQJ;
    private a nQK;

    /* JADX INFO: Access modifiers changed from: package-private */
    public c(com.yanzhenjie.permission.b.b bVar) {
        this.nQI = bVar;
    }

    @Override // com.yanzhenjie.permission.h
    @NonNull
    public h V(String... strArr) {
        this.acN = strArr;
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
        this.nQJ = aVar;
        return this;
    }

    @Override // com.yanzhenjie.permission.h
    @NonNull
    public h b(a aVar) {
        this.nQK = aVar;
        return this;
    }

    @Override // com.yanzhenjie.permission.h
    public void start() {
        List<String> a = a(this.nQI, this.acN);
        if (a.isEmpty()) {
            dSk();
        } else {
            fK(a);
        }
    }

    private void dSk() {
        if (this.nQJ != null) {
            List<String> asList = Arrays.asList(this.acN);
            try {
                this.nQJ.onAction(asList);
            } catch (Exception e) {
                if (this.nQK != null) {
                    this.nQK.onAction(asList);
                }
            }
        }
    }

    private void fK(@NonNull List<String> list) {
        if (this.nQK != null) {
            this.nQK.onAction(list);
        }
    }

    private static List<String> a(@NonNull com.yanzhenjie.permission.b.b bVar, @NonNull String... strArr) {
        ArrayList arrayList = new ArrayList(1);
        for (String str : strArr) {
            if (!nQH.e(bVar.getContext(), str)) {
                arrayList.add(str);
            }
        }
        return arrayList;
    }
}
