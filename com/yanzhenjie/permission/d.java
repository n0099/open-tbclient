package com.yanzhenjie.permission;

import android.support.annotation.NonNull;
import android.support.annotation.RequiresApi;
import com.yanzhenjie.permission.PermissionActivity;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
@RequiresApi(api = 23)
/* loaded from: classes4.dex */
class d implements PermissionActivity.a, h, i {
    private static final com.yanzhenjie.permission.a.a okU = new com.yanzhenjie.permission.a.b();
    private String[] aeu;
    private com.yanzhenjie.permission.b.b okV;
    private a okW;
    private a okX;
    private g okY;
    private String[] okZ;

    /* JADX INFO: Access modifiers changed from: package-private */
    public d(com.yanzhenjie.permission.b.b bVar) {
        this.okV = bVar;
    }

    @Override // com.yanzhenjie.permission.h
    @NonNull
    public h W(String... strArr) {
        this.aeu = strArr;
        return this;
    }

    @Override // com.yanzhenjie.permission.h
    @NonNull
    public h a(g gVar) {
        this.okY = gVar;
        return this;
    }

    @Override // com.yanzhenjie.permission.h
    @NonNull
    public h a(a aVar) {
        this.okW = aVar;
        return this;
    }

    @Override // com.yanzhenjie.permission.h
    @NonNull
    public h b(a aVar) {
        this.okX = aVar;
        return this;
    }

    @Override // com.yanzhenjie.permission.h
    public void start() {
        List<String> a = a(okU, this.okV, this.aeu);
        this.okZ = (String[]) a.toArray(new String[a.size()]);
        if (this.okZ.length > 0) {
            List<String> b = b(this.okV, this.okZ);
            if (b.size() > 0 && this.okY != null) {
                this.okY.showRationale(this.okV.getContext(), b, this);
                return;
            } else {
                execute();
                return;
            }
        }
        eev();
    }

    @Override // com.yanzhenjie.permission.i
    @RequiresApi(api = 23)
    public void execute() {
        PermissionActivity.a(this.okV.getContext(), this.okZ, this);
    }

    @Override // com.yanzhenjie.permission.i
    public void cancel() {
        X(this.okZ);
    }

    @Override // com.yanzhenjie.permission.PermissionActivity.a
    public void X(@NonNull String[] strArr) {
        List<String> a = a(okU, this.okV, strArr);
        if (a.isEmpty()) {
            eev();
        } else {
            fU(a);
        }
    }

    private void eev() {
        if (this.okW != null) {
            List<String> asList = Arrays.asList(this.aeu);
            try {
                this.okW.onAction(asList);
            } catch (Exception e) {
                if (this.okX != null) {
                    this.okX.onAction(asList);
                }
            }
        }
    }

    private void fU(@NonNull List<String> list) {
        if (this.okX != null) {
            this.okX.onAction(list);
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
            if (bVar.VL(str)) {
                arrayList.add(str);
            }
        }
        return arrayList;
    }
}
