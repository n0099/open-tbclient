package com.yanzhenjie.permission;

import android.support.annotation.NonNull;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
/* loaded from: classes4.dex */
class c implements h {
    private static final com.yanzhenjie.permission.a.a okC = new com.yanzhenjie.permission.a.b();
    private String[] aes;
    private com.yanzhenjie.permission.b.b okD;
    private a okE;
    private a okF;

    /* JADX INFO: Access modifiers changed from: package-private */
    public c(com.yanzhenjie.permission.b.b bVar) {
        this.okD = bVar;
    }

    @Override // com.yanzhenjie.permission.h
    @NonNull
    public h W(String... strArr) {
        this.aes = strArr;
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
        this.okE = aVar;
        return this;
    }

    @Override // com.yanzhenjie.permission.h
    @NonNull
    public h b(a aVar) {
        this.okF = aVar;
        return this;
    }

    @Override // com.yanzhenjie.permission.h
    public void start() {
        List<String> a = a(this.okD, this.aes);
        if (a.isEmpty()) {
            eem();
        } else {
            fU(a);
        }
    }

    private void eem() {
        if (this.okE != null) {
            List<String> asList = Arrays.asList(this.aes);
            try {
                this.okE.onAction(asList);
            } catch (Exception e) {
                if (this.okF != null) {
                    this.okF.onAction(asList);
                }
            }
        }
    }

    private void fU(@NonNull List<String> list) {
        if (this.okF != null) {
            this.okF.onAction(list);
        }
    }

    private static List<String> a(@NonNull com.yanzhenjie.permission.b.b bVar, @NonNull String... strArr) {
        ArrayList arrayList = new ArrayList(1);
        for (String str : strArr) {
            if (!okC.e(bVar.getContext(), str)) {
                arrayList.add(str);
            }
        }
        return arrayList;
    }
}
