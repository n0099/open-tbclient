package com.yanzhenjie.permission;

import android.support.annotation.NonNull;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
/* loaded from: classes18.dex */
class c implements h {
    private static final com.yanzhenjie.permission.a.a pMo = new com.yanzhenjie.permission.a.b();
    private String[] afj;
    private com.yanzhenjie.permission.b.b pMp;
    private a pMq;
    private a pMr;

    /* JADX INFO: Access modifiers changed from: package-private */
    public c(com.yanzhenjie.permission.b.b bVar) {
        this.pMp = bVar;
    }

    @Override // com.yanzhenjie.permission.h
    @NonNull
    public h ac(String... strArr) {
        this.afj = strArr;
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
        this.pMq = aVar;
        return this;
    }

    @Override // com.yanzhenjie.permission.h
    @NonNull
    public h b(a aVar) {
        this.pMr = aVar;
        return this;
    }

    @Override // com.yanzhenjie.permission.h
    public void start() {
        List<String> a2 = a(this.pMp, this.afj);
        if (a2.isEmpty()) {
            ezT();
        } else {
            gL(a2);
        }
    }

    private void ezT() {
        if (this.pMq != null) {
            List<String> asList = Arrays.asList(this.afj);
            try {
                this.pMq.onAction(asList);
            } catch (Exception e) {
                if (this.pMr != null) {
                    this.pMr.onAction(asList);
                }
            }
        }
    }

    private void gL(@NonNull List<String> list) {
        if (this.pMr != null) {
            this.pMr.onAction(list);
        }
    }

    private static List<String> a(@NonNull com.yanzhenjie.permission.b.b bVar, @NonNull String... strArr) {
        ArrayList arrayList = new ArrayList(1);
        for (String str : strArr) {
            if (!pMo.e(bVar.getContext(), str)) {
                arrayList.add(str);
            }
        }
        return arrayList;
    }
}
