package com.yanzhenjie.permission;

import android.support.annotation.NonNull;
import android.support.annotation.RequiresApi;
import com.yanzhenjie.permission.PermissionActivity;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
@RequiresApi(api = 23)
/* loaded from: classes5.dex */
class d implements PermissionActivity.a, h, i {
    private static final com.yanzhenjie.permission.a.a nQF = new com.yanzhenjie.permission.a.b();
    private String[] acN;
    private com.yanzhenjie.permission.b.b nQG;
    private a nQH;
    private a nQI;
    private g nQJ;
    private String[] nQK;

    /* JADX INFO: Access modifiers changed from: package-private */
    public d(com.yanzhenjie.permission.b.b bVar) {
        this.nQG = bVar;
    }

    @Override // com.yanzhenjie.permission.h
    @NonNull
    public h V(String... strArr) {
        this.acN = strArr;
        return this;
    }

    @Override // com.yanzhenjie.permission.h
    @NonNull
    public h a(g gVar) {
        this.nQJ = gVar;
        return this;
    }

    @Override // com.yanzhenjie.permission.h
    @NonNull
    public h a(a aVar) {
        this.nQH = aVar;
        return this;
    }

    @Override // com.yanzhenjie.permission.h
    @NonNull
    public h b(a aVar) {
        this.nQI = aVar;
        return this;
    }

    @Override // com.yanzhenjie.permission.h
    public void start() {
        List<String> a = a(nQF, this.nQG, this.acN);
        this.nQK = (String[]) a.toArray(new String[a.size()]);
        if (this.nQK.length > 0) {
            List<String> b = b(this.nQG, this.nQK);
            if (b.size() > 0 && this.nQJ != null) {
                this.nQJ.showRationale(this.nQG.getContext(), b, this);
                return;
            } else {
                execute();
                return;
            }
        }
        dSj();
    }

    @Override // com.yanzhenjie.permission.i
    @RequiresApi(api = 23)
    public void execute() {
        PermissionActivity.a(this.nQG.getContext(), this.nQK, this);
    }

    @Override // com.yanzhenjie.permission.i
    public void cancel() {
        W(this.nQK);
    }

    @Override // com.yanzhenjie.permission.PermissionActivity.a
    public void W(@NonNull String[] strArr) {
        List<String> a = a(nQF, this.nQG, strArr);
        if (a.isEmpty()) {
            dSj();
        } else {
            fK(a);
        }
    }

    private void dSj() {
        if (this.nQH != null) {
            List<String> asList = Arrays.asList(this.acN);
            try {
                this.nQH.onAction(asList);
            } catch (Exception e) {
                if (this.nQI != null) {
                    this.nQI.onAction(asList);
                }
            }
        }
    }

    private void fK(@NonNull List<String> list) {
        if (this.nQI != null) {
            this.nQI.onAction(list);
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
            if (bVar.SH(str)) {
                arrayList.add(str);
            }
        }
        return arrayList;
    }
}
