package com.yanzhenjie.permission;

import android.support.annotation.NonNull;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
/* loaded from: classes6.dex */
class c implements h {
    private static final com.yanzhenjie.permission.a.a mQP = new com.yanzhenjie.permission.a.b();
    private String[] abS;
    private com.yanzhenjie.permission.b.b mQQ;
    private a mQR;
    private a mQS;

    /* JADX INFO: Access modifiers changed from: package-private */
    public c(com.yanzhenjie.permission.b.b bVar) {
        this.mQQ = bVar;
    }

    @Override // com.yanzhenjie.permission.h
    @NonNull
    public h V(String... strArr) {
        this.abS = strArr;
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
        this.mQR = aVar;
        return this;
    }

    @Override // com.yanzhenjie.permission.h
    @NonNull
    public h b(a aVar) {
        this.mQS = aVar;
        return this;
    }

    @Override // com.yanzhenjie.permission.h
    public void start() {
        List<String> a = a(this.mQQ, this.abS);
        if (a.isEmpty()) {
            dCA();
        } else {
            fg(a);
        }
    }

    private void dCA() {
        if (this.mQR != null) {
            List<String> asList = Arrays.asList(this.abS);
            try {
                this.mQR.onAction(asList);
            } catch (Exception e) {
                if (this.mQS != null) {
                    this.mQS.onAction(asList);
                }
            }
        }
    }

    private void fg(@NonNull List<String> list) {
        if (this.mQS != null) {
            this.mQS.onAction(list);
        }
    }

    private static List<String> a(@NonNull com.yanzhenjie.permission.b.b bVar, @NonNull String... strArr) {
        ArrayList arrayList = new ArrayList(1);
        for (String str : strArr) {
            if (!mQP.e(bVar.getContext(), str)) {
                arrayList.add(str);
            }
        }
        return arrayList;
    }
}
