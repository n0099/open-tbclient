package com.yanzhenjie.permission;

import android.support.annotation.NonNull;
import android.support.annotation.RequiresApi;
import com.yanzhenjie.permission.PermissionActivity;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
@RequiresApi(api = 23)
/* loaded from: classes18.dex */
class d implements PermissionActivity.a, h, i {
    private static final com.yanzhenjie.permission.a.a pMo = new com.yanzhenjie.permission.a.b();
    private String[] afj;
    private com.yanzhenjie.permission.b.b pMp;
    private a pMq;
    private a pMr;
    private g pMs;
    private String[] pMt;

    /* JADX INFO: Access modifiers changed from: package-private */
    public d(com.yanzhenjie.permission.b.b bVar) {
        this.pMp = bVar;
    }

    @Override // com.yanzhenjie.permission.h
    @NonNull
    public h ac(String... strArr) {
        this.afj = strArr;
        return this;
    }

    @Override // com.yanzhenjie.permission.h
    @NonNull
    public h a(g gVar) {
        this.pMs = gVar;
        return this;
    }

    @Override // com.yanzhenjie.permission.h
    @NonNull
    public h a(a aVar) {
        this.pMq = aVar;
        return this;
    }

    @Override // com.yanzhenjie.permission.h
    @NonNull
    public h b(a aVar) {
        this.pMr = aVar;
        return this;
    }

    @Override // com.yanzhenjie.permission.h
    public void start() {
        List<String> a2 = a(pMo, this.pMp, this.afj);
        this.pMt = (String[]) a2.toArray(new String[a2.size()]);
        if (this.pMt.length > 0) {
            List<String> b = b(this.pMp, this.pMt);
            if (b.size() > 0 && this.pMs != null) {
                this.pMs.showRationale(this.pMp.getContext(), b, this);
                return;
            } else {
                execute();
                return;
            }
        }
        ezT();
    }

    @Override // com.yanzhenjie.permission.i
    @RequiresApi(api = 23)
    public void execute() {
        PermissionActivity.a(this.pMp.getContext(), this.pMt, this);
    }

    @Override // com.yanzhenjie.permission.i
    public void cancel() {
        ad(this.pMt);
    }

    @Override // com.yanzhenjie.permission.PermissionActivity.a
    public void ad(@NonNull String[] strArr) {
        List<String> a2 = a(pMo, this.pMp, strArr);
        if (a2.isEmpty()) {
            ezT();
        } else {
            gL(a2);
        }
    }

    private void ezT() {
        if (this.pMq != null) {
            List<String> asList = Arrays.asList(this.afj);
            try {
                this.pMq.onAction(asList);
            } catch (Exception e) {
                if (this.pMr != null) {
                    this.pMr.onAction(asList);
                }
            }
        }
    }

    private void gL(@NonNull List<String> list) {
        if (this.pMr != null) {
            this.pMr.onAction(list);
        }
    }

    private static List<String> a(com.yanzhenjie.permission.a.a aVar, @NonNull com.yanzhenjie.permission.b.b bVar, @NonNull String... strArr) {
        ArrayList arrayList = new ArrayList(1);
        for (String str : strArr) {
            if (!aVar.e(bVar.getContext(), str)) {
                arrayList.add(str);
            }
        }
        return arrayList;
    }

    private static List<String> b(@NonNull com.yanzhenjie.permission.b.b bVar, @NonNull String... strArr) {
        ArrayList arrayList = new ArrayList(1);
        for (String str : strArr) {
            if (bVar.Zd(str)) {
                arrayList.add(str);
            }
        }
        return arrayList;
    }
}
