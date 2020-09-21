package com.yanzhenjie.permission;

import android.support.annotation.NonNull;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
/* loaded from: classes8.dex */
class c implements h {
    private static final com.yanzhenjie.permission.a.a ouF = new com.yanzhenjie.permission.a.b();
    private String[] aeM;
    private com.yanzhenjie.permission.b.b ouG;
    private a ouH;
    private a ouI;

    /* JADX INFO: Access modifiers changed from: package-private */
    public c(com.yanzhenjie.permission.b.b bVar) {
        this.ouG = bVar;
    }

    @Override // com.yanzhenjie.permission.h
    @NonNull
    public h W(String... strArr) {
        this.aeM = strArr;
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
        this.ouH = aVar;
        return this;
    }

    @Override // com.yanzhenjie.permission.h
    @NonNull
    public h b(a aVar) {
        this.ouI = aVar;
        return this;
    }

    @Override // com.yanzhenjie.permission.h
    public void start() {
        List<String> a = a(this.ouG, this.aeM);
        if (a.isEmpty()) {
            eis();
        } else {
            gd(a);
        }
    }

    private void eis() {
        if (this.ouH != null) {
            List<String> asList = Arrays.asList(this.aeM);
            try {
                this.ouH.onAction(asList);
            } catch (Exception e) {
                if (this.ouI != null) {
                    this.ouI.onAction(asList);
                }
            }
        }
    }

    private void gd(@NonNull List<String> list) {
        if (this.ouI != null) {
            this.ouI.onAction(list);
        }
    }

    private static List<String> a(@NonNull com.yanzhenjie.permission.b.b bVar, @NonNull String... strArr) {
        ArrayList arrayList = new ArrayList(1);
        for (String str : strArr) {
            if (!ouF.e(bVar.getContext(), str)) {
                arrayList.add(str);
            }
        }
        return arrayList;
    }
}
