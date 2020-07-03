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
    private static final com.yanzhenjie.permission.a.a nHU = new com.yanzhenjie.permission.a.b();
    private String[] acS;
    private com.yanzhenjie.permission.b.b nHV;
    private a nHW;
    private a nHX;
    private g nHY;
    private String[] nHZ;

    /* JADX INFO: Access modifiers changed from: package-private */
    public d(com.yanzhenjie.permission.b.b bVar) {
        this.nHV = bVar;
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
        this.nHY = gVar;
        return this;
    }

    @Override // com.yanzhenjie.permission.h
    @NonNull
    public h a(a aVar) {
        this.nHW = aVar;
        return this;
    }

    @Override // com.yanzhenjie.permission.h
    @NonNull
    public h b(a aVar) {
        this.nHX = aVar;
        return this;
    }

    @Override // com.yanzhenjie.permission.h
    public void start() {
        List<String> a = a(nHU, this.nHV, this.acS);
        this.nHZ = (String[]) a.toArray(new String[a.size()]);
        if (this.nHZ.length > 0) {
            List<String> b = b(this.nHV, this.nHZ);
            if (b.size() > 0 && this.nHY != null) {
                this.nHY.showRationale(this.nHV.getContext(), b, this);
                return;
            } else {
                execute();
                return;
            }
        }
        dOJ();
    }

    @Override // com.yanzhenjie.permission.i
    @RequiresApi(api = 23)
    public void execute() {
        PermissionActivity.a(this.nHV.getContext(), this.nHZ, this);
    }

    @Override // com.yanzhenjie.permission.i
    public void cancel() {
        Y(this.nHZ);
    }

    @Override // com.yanzhenjie.permission.PermissionActivity.a
    public void Y(@NonNull String[] strArr) {
        List<String> a = a(nHU, this.nHV, strArr);
        if (a.isEmpty()) {
            dOJ();
        } else {
            fB(a);
        }
    }

    private void dOJ() {
        if (this.nHW != null) {
            List<String> asList = Arrays.asList(this.acS);
            try {
                this.nHW.onAction(asList);
            } catch (Exception e) {
                if (this.nHX != null) {
                    this.nHX.onAction(asList);
                }
            }
        }
    }

    private void fB(@NonNull List<String> list) {
        if (this.nHX != null) {
            this.nHX.onAction(list);
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
            if (bVar.RV(str)) {
                arrayList.add(str);
            }
        }
        return arrayList;
    }
}
