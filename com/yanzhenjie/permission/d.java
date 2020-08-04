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
    private static final com.yanzhenjie.permission.a.a nQH = new com.yanzhenjie.permission.a.b();
    private String[] acN;
    private com.yanzhenjie.permission.b.b nQI;
    private a nQJ;
    private a nQK;
    private g nQL;
    private String[] nQM;

    /* JADX INFO: Access modifiers changed from: package-private */
    public d(com.yanzhenjie.permission.b.b bVar) {
        this.nQI = bVar;
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
        this.nQL = gVar;
        return this;
    }

    @Override // com.yanzhenjie.permission.h
    @NonNull
    public h a(a aVar) {
        this.nQJ = aVar;
        return this;
    }

    @Override // com.yanzhenjie.permission.h
    @NonNull
    public h b(a aVar) {
        this.nQK = aVar;
        return this;
    }

    @Override // com.yanzhenjie.permission.h
    public void start() {
        List<String> a = a(nQH, this.nQI, this.acN);
        this.nQM = (String[]) a.toArray(new String[a.size()]);
        if (this.nQM.length > 0) {
            List<String> b = b(this.nQI, this.nQM);
            if (b.size() > 0 && this.nQL != null) {
                this.nQL.showRationale(this.nQI.getContext(), b, this);
                return;
            } else {
                execute();
                return;
            }
        }
        dSk();
    }

    @Override // com.yanzhenjie.permission.i
    @RequiresApi(api = 23)
    public void execute() {
        PermissionActivity.a(this.nQI.getContext(), this.nQM, this);
    }

    @Override // com.yanzhenjie.permission.i
    public void cancel() {
        W(this.nQM);
    }

    @Override // com.yanzhenjie.permission.PermissionActivity.a
    public void W(@NonNull String[] strArr) {
        List<String> a = a(nQH, this.nQI, strArr);
        if (a.isEmpty()) {
            dSk();
        } else {
            fK(a);
        }
    }

    private void dSk() {
        if (this.nQJ != null) {
            List<String> asList = Arrays.asList(this.acN);
            try {
                this.nQJ.onAction(asList);
            } catch (Exception e) {
                if (this.nQK != null) {
                    this.nQK.onAction(asList);
                }
            }
        }
    }

    private void fK(@NonNull List<String> list) {
        if (this.nQK != null) {
            this.nQK.onAction(list);
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
