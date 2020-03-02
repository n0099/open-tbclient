package com.yanzhenjie.permission;

import android.support.annotation.NonNull;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
/* loaded from: classes6.dex */
class c implements h {
    private static final com.yanzhenjie.permission.a.a nsh = new com.yanzhenjie.permission.a.b();
    private String[] IL;
    private com.yanzhenjie.permission.b.b nsi;
    private a nsj;
    private a nsk;

    /* JADX INFO: Access modifiers changed from: package-private */
    public c(com.yanzhenjie.permission.b.b bVar) {
        this.nsi = bVar;
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
        this.nsj = aVar;
        return this;
    }

    @Override // com.yanzhenjie.permission.h
    @NonNull
    public h b(a aVar) {
        this.nsk = aVar;
        return this;
    }

    @Override // com.yanzhenjie.permission.h
    public void start() {
        List<String> a = a(this.nsi, this.IL);
        if (a.isEmpty()) {
            dHX();
        } else {
            fs(a);
        }
    }

    private void dHX() {
        if (this.nsj != null) {
            List<String> asList = Arrays.asList(this.IL);
            try {
                this.nsj.onAction(asList);
            } catch (Exception e) {
                if (this.nsk != null) {
                    this.nsk.onAction(asList);
                }
            }
        }
    }

    private void fs(@NonNull List<String> list) {
        if (this.nsk != null) {
            this.nsk.onAction(list);
        }
    }

    private static List<String> a(@NonNull com.yanzhenjie.permission.b.b bVar, @NonNull String... strArr) {
        ArrayList arrayList = new ArrayList(1);
        for (String str : strArr) {
            if (!nsh.e(bVar.getContext(), str)) {
                arrayList.add(str);
            }
        }
        return arrayList;
    }
}
