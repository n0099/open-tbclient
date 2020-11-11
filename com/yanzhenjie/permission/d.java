package com.yanzhenjie.permission;

import android.support.annotation.NonNull;
import android.support.annotation.RequiresApi;
import com.yanzhenjie.permission.PermissionActivity;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
@RequiresApi(api = 23)
/* loaded from: classes6.dex */
class d implements PermissionActivity.a, h, i {
    private static final com.yanzhenjie.permission.a.a pKL = new com.yanzhenjie.permission.a.b();
    private String[] afe;
    private com.yanzhenjie.permission.b.b pKM;
    private a pKN;
    private a pKO;
    private g pKP;
    private String[] pKQ;

    /* JADX INFO: Access modifiers changed from: package-private */
    public d(com.yanzhenjie.permission.b.b bVar) {
        this.pKM = bVar;
    }

    @Override // com.yanzhenjie.permission.h
    @NonNull
    public h ab(String... strArr) {
        this.afe = strArr;
        return this;
    }

    @Override // com.yanzhenjie.permission.h
    @NonNull
    public h a(g gVar) {
        this.pKP = gVar;
        return this;
    }

    @Override // com.yanzhenjie.permission.h
    @NonNull
    public h a(a aVar) {
        this.pKN = aVar;
        return this;
    }

    @Override // com.yanzhenjie.permission.h
    @NonNull
    public h b(a aVar) {
        this.pKO = aVar;
        return this;
    }

    @Override // com.yanzhenjie.permission.h
    public void start() {
        List<String> a2 = a(pKL, this.pKM, this.afe);
        this.pKQ = (String[]) a2.toArray(new String[a2.size()]);
        if (this.pKQ.length > 0) {
            List<String> b = b(this.pKM, this.pKQ);
            if (b.size() > 0 && this.pKP != null) {
                this.pKP.showRationale(this.pKM.getContext(), b, this);
                return;
            } else {
                execute();
                return;
            }
        }
        ezS();
    }

    @Override // com.yanzhenjie.permission.i
    @RequiresApi(api = 23)
    public void execute() {
        PermissionActivity.a(this.pKM.getContext(), this.pKQ, this);
    }

    @Override // com.yanzhenjie.permission.i
    public void cancel() {
        ac(this.pKQ);
    }

    @Override // com.yanzhenjie.permission.PermissionActivity.a
    public void ac(@NonNull String[] strArr) {
        List<String> a2 = a(pKL, this.pKM, strArr);
        if (a2.isEmpty()) {
            ezS();
        } else {
            gL(a2);
        }
    }

    private void ezS() {
        if (this.pKN != null) {
            List<String> asList = Arrays.asList(this.afe);
            try {
                this.pKN.onAction(asList);
            } catch (Exception e) {
                if (this.pKO != null) {
                    this.pKO.onAction(asList);
                }
            }
        }
    }

    private void gL(@NonNull List<String> list) {
        if (this.pKO != null) {
            this.pKO.onAction(list);
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
            if (bVar.Zs(str)) {
                arrayList.add(str);
            }
        }
        return arrayList;
    }
}
