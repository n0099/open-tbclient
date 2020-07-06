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
    private static final com.yanzhenjie.permission.a.a nHX = new com.yanzhenjie.permission.a.b();
    private String[] acS;
    private com.yanzhenjie.permission.b.b nHY;
    private a nHZ;
    private a nIa;
    private g nIb;
    private String[] nIc;

    /* JADX INFO: Access modifiers changed from: package-private */
    public d(com.yanzhenjie.permission.b.b bVar) {
        this.nHY = bVar;
    }

    @Override // com.yanzhenjie.permission.h
    @NonNull
    public h X(String... strArr) {
        this.acS = strArr;
        return this;
    }

    @Override // com.yanzhenjie.permission.h
    @NonNull
    public h a(g gVar) {
        this.nIb = gVar;
        return this;
    }

    @Override // com.yanzhenjie.permission.h
    @NonNull
    public h a(a aVar) {
        this.nHZ = aVar;
        return this;
    }

    @Override // com.yanzhenjie.permission.h
    @NonNull
    public h b(a aVar) {
        this.nIa = aVar;
        return this;
    }

    @Override // com.yanzhenjie.permission.h
    public void start() {
        List<String> a = a(nHX, this.nHY, this.acS);
        this.nIc = (String[]) a.toArray(new String[a.size()]);
        if (this.nIc.length > 0) {
            List<String> b = b(this.nHY, this.nIc);
            if (b.size() > 0 && this.nIb != null) {
                this.nIb.showRationale(this.nHY.getContext(), b, this);
                return;
            } else {
                execute();
                return;
            }
        }
        dON();
    }

    @Override // com.yanzhenjie.permission.i
    @RequiresApi(api = 23)
    public void execute() {
        PermissionActivity.a(this.nHY.getContext(), this.nIc, this);
    }

    @Override // com.yanzhenjie.permission.i
    public void cancel() {
        Y(this.nIc);
    }

    @Override // com.yanzhenjie.permission.PermissionActivity.a
    public void Y(@NonNull String[] strArr) {
        List<String> a = a(nHX, this.nHY, strArr);
        if (a.isEmpty()) {
            dON();
        } else {
            fB(a);
        }
    }

    private void dON() {
        if (this.nHZ != null) {
            List<String> asList = Arrays.asList(this.acS);
            try {
                this.nHZ.onAction(asList);
            } catch (Exception e) {
                if (this.nIa != null) {
                    this.nIa.onAction(asList);
                }
            }
        }
    }

    private void fB(@NonNull List<String> list) {
        if (this.nIa != null) {
            this.nIa.onAction(list);
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
            if (bVar.RW(str)) {
                arrayList.add(str);
            }
        }
        return arrayList;
    }
}
