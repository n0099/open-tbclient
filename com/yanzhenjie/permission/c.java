package com.yanzhenjie.permission;

import android.support.annotation.NonNull;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
/* loaded from: classes6.dex */
class c implements h {
    private static final com.yanzhenjie.permission.a.a mQS = new com.yanzhenjie.permission.a.b();
    private String[] abV;
    private com.yanzhenjie.permission.b.b mQT;
    private a mQU;
    private a mQV;

    /* JADX INFO: Access modifiers changed from: package-private */
    public c(com.yanzhenjie.permission.b.b bVar) {
        this.mQT = bVar;
    }

    @Override // com.yanzhenjie.permission.h
    @NonNull
    public h V(String... strArr) {
        this.abV = strArr;
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
        this.mQU = aVar;
        return this;
    }

    @Override // com.yanzhenjie.permission.h
    @NonNull
    public h b(a aVar) {
        this.mQV = aVar;
        return this;
    }

    @Override // com.yanzhenjie.permission.h
    public void start() {
        List<String> a = a(this.mQT, this.abV);
        if (a.isEmpty()) {
            dCx();
        } else {
            fg(a);
        }
    }

    private void dCx() {
        if (this.mQU != null) {
            List<String> asList = Arrays.asList(this.abV);
            try {
                this.mQU.onAction(asList);
            } catch (Exception e) {
                if (this.mQV != null) {
                    this.mQV.onAction(asList);
                }
            }
        }
    }

    private void fg(@NonNull List<String> list) {
        if (this.mQV != null) {
            this.mQV.onAction(list);
        }
    }

    private static List<String> a(@NonNull com.yanzhenjie.permission.b.b bVar, @NonNull String... strArr) {
        ArrayList arrayList = new ArrayList(1);
        for (String str : strArr) {
            if (!mQS.e(bVar.getContext(), str)) {
                arrayList.add(str);
            }
        }
        return arrayList;
    }
}
