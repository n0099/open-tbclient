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
    private static final com.yanzhenjie.permission.a.a nkV = new com.yanzhenjie.permission.a.b();
    private String[] acn;
    private com.yanzhenjie.permission.b.b nkW;
    private a nkX;
    private a nkY;
    private g nkZ;
    private String[] nla;

    /* JADX INFO: Access modifiers changed from: package-private */
    public d(com.yanzhenjie.permission.b.b bVar) {
        this.nkW = bVar;
    }

    @Override // com.yanzhenjie.permission.h
    @NonNull
    public h Y(String... strArr) {
        this.acn = strArr;
        return this;
    }

    @Override // com.yanzhenjie.permission.h
    @NonNull
    public h a(g gVar) {
        this.nkZ = gVar;
        return this;
    }

    @Override // com.yanzhenjie.permission.h
    @NonNull
    public h a(a aVar) {
        this.nkX = aVar;
        return this;
    }

    @Override // com.yanzhenjie.permission.h
    @NonNull
    public h b(a aVar) {
        this.nkY = aVar;
        return this;
    }

    @Override // com.yanzhenjie.permission.h
    public void start() {
        List<String> a = a(nkV, this.nkW, this.acn);
        this.nla = (String[]) a.toArray(new String[a.size()]);
        if (this.nla.length > 0) {
            List<String> b = b(this.nkW, this.nla);
            if (b.size() > 0 && this.nkZ != null) {
                this.nkZ.showRationale(this.nkW.getContext(), b, this);
                return;
            } else {
                execute();
                return;
            }
        }
        dJP();
    }

    @Override // com.yanzhenjie.permission.i
    @RequiresApi(api = 23)
    public void execute() {
        PermissionActivity.a(this.nkW.getContext(), this.nla, this);
    }

    @Override // com.yanzhenjie.permission.i
    public void cancel() {
        Z(this.nla);
    }

    @Override // com.yanzhenjie.permission.PermissionActivity.a
    public void Z(@NonNull String[] strArr) {
        List<String> a = a(nkV, this.nkW, strArr);
        if (a.isEmpty()) {
            dJP();
        } else {
            fn(a);
        }
    }

    private void dJP() {
        if (this.nkX != null) {
            List<String> asList = Arrays.asList(this.acn);
            try {
                this.nkX.onAction(asList);
            } catch (Exception e) {
                if (this.nkY != null) {
                    this.nkY.onAction(asList);
                }
            }
        }
    }

    private void fn(@NonNull List<String> list) {
        if (this.nkY != null) {
            this.nkY.onAction(list);
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
            if (bVar.Ri(str)) {
                arrayList.add(str);
            }
        }
        return arrayList;
    }
}
