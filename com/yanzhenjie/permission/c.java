package com.yanzhenjie.permission;

import android.support.annotation.NonNull;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
/* loaded from: classes6.dex */
class c implements h {
    private static final com.yanzhenjie.permission.a.a nss = new com.yanzhenjie.permission.a.b();
    private String[] IL;
    private com.yanzhenjie.permission.b.b nst;
    private a nsu;
    private a nsv;

    /* JADX INFO: Access modifiers changed from: package-private */
    public c(com.yanzhenjie.permission.b.b bVar) {
        this.nst = bVar;
    }

    @Override // com.yanzhenjie.permission.h
    @NonNull
    public h W(String... strArr) {
        this.IL = strArr;
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
        this.nsu = aVar;
        return this;
    }

    @Override // com.yanzhenjie.permission.h
    @NonNull
    public h b(a aVar) {
        this.nsv = aVar;
        return this;
    }

    @Override // com.yanzhenjie.permission.h
    public void start() {
        List<String> a = a(this.nst, this.IL);
        if (a.isEmpty()) {
            dHY();
        } else {
            fs(a);
        }
    }

    private void dHY() {
        if (this.nsu != null) {
            List<String> asList = Arrays.asList(this.IL);
            try {
                this.nsu.onAction(asList);
            } catch (Exception e) {
                if (this.nsv != null) {
                    this.nsv.onAction(asList);
                }
            }
        }
    }

    private void fs(@NonNull List<String> list) {
        if (this.nsv != null) {
            this.nsv.onAction(list);
        }
    }

    private static List<String> a(@NonNull com.yanzhenjie.permission.b.b bVar, @NonNull String... strArr) {
        ArrayList arrayList = new ArrayList(1);
        for (String str : strArr) {
            if (!nss.e(bVar.getContext(), str)) {
                arrayList.add(str);
            }
        }
        return arrayList;
    }
}
