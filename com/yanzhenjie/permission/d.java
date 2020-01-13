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
    private static final com.yanzhenjie.permission.a.a nry = new com.yanzhenjie.permission.a.b();
    private String[] Ip;
    private a nrA;
    private a nrB;
    private g nrC;
    private String[] nrD;
    private com.yanzhenjie.permission.b.b nrz;

    /* JADX INFO: Access modifiers changed from: package-private */
    public d(com.yanzhenjie.permission.b.b bVar) {
        this.nrz = bVar;
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
        this.nrC = gVar;
        return this;
    }

    @Override // com.yanzhenjie.permission.h
    @NonNull
    public h a(a aVar) {
        this.nrA = aVar;
        return this;
    }

    @Override // com.yanzhenjie.permission.h
    @NonNull
    public h b(a aVar) {
        this.nrB = aVar;
        return this;
    }

    @Override // com.yanzhenjie.permission.h
    public void start() {
        List<String> a = a(nry, this.nrz, this.Ip);
        this.nrD = (String[]) a.toArray(new String[a.size()]);
        if (this.nrD.length > 0) {
            List<String> b = b(this.nrz, this.nrD);
            if (b.size() > 0 && this.nrC != null) {
                this.nrC.showRationale(this.nrz.getContext(), b, this);
                return;
            } else {
                execute();
                return;
            }
        }
        dGM();
    }

    @Override // com.yanzhenjie.permission.i
    @RequiresApi(api = 23)
    public void execute() {
        PermissionActivity.a(this.nrz.getContext(), this.nrD, this);
    }

    @Override // com.yanzhenjie.permission.i
    public void cancel() {
        W(this.nrD);
    }

    @Override // com.yanzhenjie.permission.PermissionActivity.a
    public void W(@NonNull String[] strArr) {
        List<String> a = a(nry, this.nrz, strArr);
        if (a.isEmpty()) {
            dGM();
        } else {
            fx(a);
        }
    }

    private void dGM() {
        if (this.nrA != null) {
            List<String> asList = Arrays.asList(this.Ip);
            try {
                this.nrA.onAction(asList);
            } catch (Exception e) {
                if (this.nrB != null) {
                    this.nrB.onAction(asList);
                }
            }
        }
    }

    private void fx(@NonNull List<String> list) {
        if (this.nrB != null) {
            this.nrB.onAction(list);
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
