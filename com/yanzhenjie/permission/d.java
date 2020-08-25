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
    private static final com.yanzhenjie.permission.a.a okC = new com.yanzhenjie.permission.a.b();
    private String[] aes;
    private com.yanzhenjie.permission.b.b okD;
    private a okE;
    private a okF;
    private g okG;
    private String[] okH;

    /* JADX INFO: Access modifiers changed from: package-private */
    public d(com.yanzhenjie.permission.b.b bVar) {
        this.okD = bVar;
    }

    @Override // com.yanzhenjie.permission.h
    @NonNull
    public h W(String... strArr) {
        this.aes = strArr;
        return this;
    }

    @Override // com.yanzhenjie.permission.h
    @NonNull
    public h a(g gVar) {
        this.okG = gVar;
        return this;
    }

    @Override // com.yanzhenjie.permission.h
    @NonNull
    public h a(a aVar) {
        this.okE = aVar;
        return this;
    }

    @Override // com.yanzhenjie.permission.h
    @NonNull
    public h b(a aVar) {
        this.okF = aVar;
        return this;
    }

    @Override // com.yanzhenjie.permission.h
    public void start() {
        List<String> a = a(okC, this.okD, this.aes);
        this.okH = (String[]) a.toArray(new String[a.size()]);
        if (this.okH.length > 0) {
            List<String> b = b(this.okD, this.okH);
            if (b.size() > 0 && this.okG != null) {
                this.okG.showRationale(this.okD.getContext(), b, this);
                return;
            } else {
                execute();
                return;
            }
        }
        eem();
    }

    @Override // com.yanzhenjie.permission.i
    @RequiresApi(api = 23)
    public void execute() {
        PermissionActivity.a(this.okD.getContext(), this.okH, this);
    }

    @Override // com.yanzhenjie.permission.i
    public void cancel() {
        X(this.okH);
    }

    @Override // com.yanzhenjie.permission.PermissionActivity.a
    public void X(@NonNull String[] strArr) {
        List<String> a = a(okC, this.okD, strArr);
        if (a.isEmpty()) {
            eem();
        } else {
            fU(a);
        }
    }

    private void eem() {
        if (this.okE != null) {
            List<String> asList = Arrays.asList(this.aes);
            try {
                this.okE.onAction(asList);
            } catch (Exception e) {
                if (this.okF != null) {
                    this.okF.onAction(asList);
                }
            }
        }
    }

    private void fU(@NonNull List<String> list) {
        if (this.okF != null) {
            this.okF.onAction(list);
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
