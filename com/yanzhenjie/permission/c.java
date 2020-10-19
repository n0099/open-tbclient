package com.yanzhenjie.permission;

import android.support.annotation.NonNull;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
/* loaded from: classes6.dex */
class c implements h {
    private static final com.yanzhenjie.permission.a.a oJU = new com.yanzhenjie.permission.a.b();
    private String[] afd;
    private com.yanzhenjie.permission.b.b oJV;
    private a oJW;
    private a oJX;

    /* JADX INFO: Access modifiers changed from: package-private */
    public c(com.yanzhenjie.permission.b.b bVar) {
        this.oJV = bVar;
    }

    @Override // com.yanzhenjie.permission.h
    @NonNull
    public h Z(String... strArr) {
        this.afd = strArr;
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
        this.oJW = aVar;
        return this;
    }

    @Override // com.yanzhenjie.permission.h
    @NonNull
    public h b(a aVar) {
        this.oJX = aVar;
        return this;
    }

    @Override // com.yanzhenjie.permission.h
    public void start() {
        List<String> a2 = a(this.oJV, this.afd);
        if (a2.isEmpty()) {
            emd();
        } else {
            gg(a2);
        }
    }

    private void emd() {
        if (this.oJW != null) {
            List<String> asList = Arrays.asList(this.afd);
            try {
                this.oJW.onAction(asList);
            } catch (Exception e) {
                if (this.oJX != null) {
                    this.oJX.onAction(asList);
                }
            }
        }
    }

    private void gg(@NonNull List<String> list) {
        if (this.oJX != null) {
            this.oJX.onAction(list);
        }
    }

    private static List<String> a(@NonNull com.yanzhenjie.permission.b.b bVar, @NonNull String... strArr) {
        ArrayList arrayList = new ArrayList(1);
        for (String str : strArr) {
            if (!oJU.e(bVar.getContext(), str)) {
                arrayList.add(str);
            }
        }
        return arrayList;
    }
}
