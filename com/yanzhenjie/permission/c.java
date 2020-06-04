package com.yanzhenjie.permission;

import android.support.annotation.NonNull;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
/* loaded from: classes6.dex */
class c implements h {
    private static final com.yanzhenjie.permission.a.a nmf = new com.yanzhenjie.permission.a.b();
    private String[] acn;
    private com.yanzhenjie.permission.b.b nmg;
    private a nmh;
    private a nmi;

    /* JADX INFO: Access modifiers changed from: package-private */
    public c(com.yanzhenjie.permission.b.b bVar) {
        this.nmg = bVar;
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
        this.nmh = aVar;
        return this;
    }

    @Override // com.yanzhenjie.permission.h
    @NonNull
    public h b(a aVar) {
        this.nmi = aVar;
        return this;
    }

    @Override // com.yanzhenjie.permission.h
    public void start() {
        List<String> a = a(this.nmg, this.acn);
        if (a.isEmpty()) {
            dKd();
        } else {
            fp(a);
        }
    }

    private void dKd() {
        if (this.nmh != null) {
            List<String> asList = Arrays.asList(this.acn);
            try {
                this.nmh.onAction(asList);
            } catch (Exception e) {
                if (this.nmi != null) {
                    this.nmi.onAction(asList);
                }
            }
        }
    }

    private void fp(@NonNull List<String> list) {
        if (this.nmi != null) {
            this.nmi.onAction(list);
        }
    }

    private static List<String> a(@NonNull com.yanzhenjie.permission.b.b bVar, @NonNull String... strArr) {
        ArrayList arrayList = new ArrayList(1);
        for (String str : strArr) {
            if (!nmf.e(bVar.getContext(), str)) {
                arrayList.add(str);
            }
        }
        return arrayList;
    }
}
