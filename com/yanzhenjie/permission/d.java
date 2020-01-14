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
    private static final com.yanzhenjie.permission.a.a nrD = new com.yanzhenjie.permission.a.b();
    private String[] Ip;
    private com.yanzhenjie.permission.b.b nrE;
    private a nrF;
    private a nrG;
    private g nrH;
    private String[] nrI;

    /* JADX INFO: Access modifiers changed from: package-private */
    public d(com.yanzhenjie.permission.b.b bVar) {
        this.nrE = bVar;
    }

    @Override // com.yanzhenjie.permission.h
    @NonNull
    public h V(String... strArr) {
        this.Ip = strArr;
        return this;
    }

    @Override // com.yanzhenjie.permission.h
    @NonNull
    public h a(g gVar) {
        this.nrH = gVar;
        return this;
    }

    @Override // com.yanzhenjie.permission.h
    @NonNull
    public h a(a aVar) {
        this.nrF = aVar;
        return this;
    }

    @Override // com.yanzhenjie.permission.h
    @NonNull
    public h b(a aVar) {
        this.nrG = aVar;
        return this;
    }

    @Override // com.yanzhenjie.permission.h
    public void start() {
        List<String> a = a(nrD, this.nrE, this.Ip);
        this.nrI = (String[]) a.toArray(new String[a.size()]);
        if (this.nrI.length > 0) {
            List<String> b = b(this.nrE, this.nrI);
            if (b.size() > 0 && this.nrH != null) {
                this.nrH.showRationale(this.nrE.getContext(), b, this);
                return;
            } else {
                execute();
                return;
            }
        }
        dGO();
    }

    @Override // com.yanzhenjie.permission.i
    @RequiresApi(api = 23)
    public void execute() {
        PermissionActivity.a(this.nrE.getContext(), this.nrI, this);
    }

    @Override // com.yanzhenjie.permission.i
    public void cancel() {
        W(this.nrI);
    }

    @Override // com.yanzhenjie.permission.PermissionActivity.a
    public void W(@NonNull String[] strArr) {
        List<String> a = a(nrD, this.nrE, strArr);
        if (a.isEmpty()) {
            dGO();
        } else {
            fx(a);
        }
    }

    private void dGO() {
        if (this.nrF != null) {
            List<String> asList = Arrays.asList(this.Ip);
            try {
                this.nrF.onAction(asList);
            } catch (Exception e) {
                if (this.nrG != null) {
                    this.nrG.onAction(asList);
                }
            }
        }
    }

    private void fx(@NonNull List<String> list) {
        if (this.nrG != null) {
            this.nrG.onAction(list);
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
            if (bVar.Rt(str)) {
                arrayList.add(str);
            }
        }
        return arrayList;
    }
}
