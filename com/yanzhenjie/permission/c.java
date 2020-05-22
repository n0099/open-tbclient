package com.yanzhenjie.permission;

import android.support.annotation.NonNull;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
/* loaded from: classes6.dex */
class c implements h {
    private static final com.yanzhenjie.permission.a.a nkV = new com.yanzhenjie.permission.a.b();
    private String[] acn;
    private com.yanzhenjie.permission.b.b nkW;
    private a nkX;
    private a nkY;

    /* JADX INFO: Access modifiers changed from: package-private */
    public c(com.yanzhenjie.permission.b.b bVar) {
        this.nkW = bVar;
    }

    @Override // com.yanzhenjie.permission.h
    @NonNull
    public h Y(String... strArr) {
        this.acn = strArr;
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
        this.nkX = aVar;
        return this;
    }

    @Override // com.yanzhenjie.permission.h
    @NonNull
    public h b(a aVar) {
        this.nkY = aVar;
        return this;
    }

    @Override // com.yanzhenjie.permission.h
    public void start() {
        List<String> a = a(this.nkW, this.acn);
        if (a.isEmpty()) {
            dJP();
        } else {
            fn(a);
        }
    }

    private void dJP() {
        if (this.nkX != null) {
            List<String> asList = Arrays.asList(this.acn);
            try {
                this.nkX.onAction(asList);
            } catch (Exception e) {
                if (this.nkY != null) {
                    this.nkY.onAction(asList);
                }
            }
        }
    }

    private void fn(@NonNull List<String> list) {
        if (this.nkY != null) {
            this.nkY.onAction(list);
        }
    }

    private static List<String> a(@NonNull com.yanzhenjie.permission.b.b bVar, @NonNull String... strArr) {
        ArrayList arrayList = new ArrayList(1);
        for (String str : strArr) {
            if (!nkV.e(bVar.getContext(), str)) {
                arrayList.add(str);
            }
        }
        return arrayList;
    }
}
