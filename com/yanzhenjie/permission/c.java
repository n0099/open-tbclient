package com.yanzhenjie.permission;

import android.support.annotation.NonNull;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
/* loaded from: classes5.dex */
class c implements h {
    private static final com.yanzhenjie.permission.a.a nry = new com.yanzhenjie.permission.a.b();
    private String[] Ip;
    private a nrA;
    private a nrB;
    private com.yanzhenjie.permission.b.b nrz;

    /* JADX INFO: Access modifiers changed from: package-private */
    public c(com.yanzhenjie.permission.b.b bVar) {
        this.nrz = bVar;
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
        this.nrA = aVar;
        return this;
    }

    @Override // com.yanzhenjie.permission.h
    @NonNull
    public h b(a aVar) {
        this.nrB = aVar;
        return this;
    }

    @Override // com.yanzhenjie.permission.h
    public void start() {
        List<String> a = a(this.nrz, this.Ip);
        if (a.isEmpty()) {
            dGM();
        } else {
            fx(a);
        }
    }

    private void dGM() {
        if (this.nrA != null) {
            List<String> asList = Arrays.asList(this.Ip);
            try {
                this.nrA.onAction(asList);
            } catch (Exception e) {
                if (this.nrB != null) {
                    this.nrB.onAction(asList);
                }
            }
        }
    }

    private void fx(@NonNull List<String> list) {
        if (this.nrB != null) {
            this.nrB.onAction(list);
        }
    }

    private static List<String> a(@NonNull com.yanzhenjie.permission.b.b bVar, @NonNull String... strArr) {
        ArrayList arrayList = new ArrayList(1);
        for (String str : strArr) {
            if (!nry.e(bVar.getContext(), str)) {
                arrayList.add(str);
            }
        }
        return arrayList;
    }
}
