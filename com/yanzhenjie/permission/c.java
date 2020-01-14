package com.yanzhenjie.permission;

import android.support.annotation.NonNull;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
/* loaded from: classes5.dex */
class c implements h {
    private static final com.yanzhenjie.permission.a.a nrD = new com.yanzhenjie.permission.a.b();
    private String[] Ip;
    private com.yanzhenjie.permission.b.b nrE;
    private a nrF;
    private a nrG;

    /* JADX INFO: Access modifiers changed from: package-private */
    public c(com.yanzhenjie.permission.b.b bVar) {
        this.nrE = bVar;
    }

    @Override // com.yanzhenjie.permission.h
    @NonNull
    public h V(String... strArr) {
        this.Ip = strArr;
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
        this.nrF = aVar;
        return this;
    }

    @Override // com.yanzhenjie.permission.h
    @NonNull
    public h b(a aVar) {
        this.nrG = aVar;
        return this;
    }

    @Override // com.yanzhenjie.permission.h
    public void start() {
        List<String> a = a(this.nrE, this.Ip);
        if (a.isEmpty()) {
            dGO();
        } else {
            fx(a);
        }
    }

    private void dGO() {
        if (this.nrF != null) {
            List<String> asList = Arrays.asList(this.Ip);
            try {
                this.nrF.onAction(asList);
            } catch (Exception e) {
                if (this.nrG != null) {
                    this.nrG.onAction(asList);
                }
            }
        }
    }

    private void fx(@NonNull List<String> list) {
        if (this.nrG != null) {
            this.nrG.onAction(list);
        }
    }

    private static List<String> a(@NonNull com.yanzhenjie.permission.b.b bVar, @NonNull String... strArr) {
        ArrayList arrayList = new ArrayList(1);
        for (String str : strArr) {
            if (!nrD.e(bVar.getContext(), str)) {
                arrayList.add(str);
            }
        }
        return arrayList;
    }
}
