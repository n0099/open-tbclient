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
    private static final com.yanzhenjie.permission.a.a nss = new com.yanzhenjie.permission.a.b();
    private String[] IL;
    private com.yanzhenjie.permission.b.b nst;
    private a nsu;
    private a nsv;
    private g nsw;
    private String[] nsx;

    /* JADX INFO: Access modifiers changed from: package-private */
    public d(com.yanzhenjie.permission.b.b bVar) {
        this.nst = bVar;
    }

    @Override // com.yanzhenjie.permission.h
    @NonNull
    public h W(String... strArr) {
        this.IL = strArr;
        return this;
    }

    @Override // com.yanzhenjie.permission.h
    @NonNull
    public h a(g gVar) {
        this.nsw = gVar;
        return this;
    }

    @Override // com.yanzhenjie.permission.h
    @NonNull
    public h a(a aVar) {
        this.nsu = aVar;
        return this;
    }

    @Override // com.yanzhenjie.permission.h
    @NonNull
    public h b(a aVar) {
        this.nsv = aVar;
        return this;
    }

    @Override // com.yanzhenjie.permission.h
    public void start() {
        List<String> a = a(nss, this.nst, this.IL);
        this.nsx = (String[]) a.toArray(new String[a.size()]);
        if (this.nsx.length > 0) {
            List<String> b = b(this.nst, this.nsx);
            if (b.size() > 0 && this.nsw != null) {
                this.nsw.showRationale(this.nst.getContext(), b, this);
                return;
            } else {
                execute();
                return;
            }
        }
        dHY();
    }

    @Override // com.yanzhenjie.permission.i
    @RequiresApi(api = 23)
    public void execute() {
        PermissionActivity.a(this.nst.getContext(), this.nsx, this);
    }

    @Override // com.yanzhenjie.permission.i
    public void cancel() {
        X(this.nsx);
    }

    @Override // com.yanzhenjie.permission.PermissionActivity.a
    public void X(@NonNull String[] strArr) {
        List<String> a = a(nss, this.nst, strArr);
        if (a.isEmpty()) {
            dHY();
        } else {
            fs(a);
        }
    }

    private void dHY() {
        if (this.nsu != null) {
            List<String> asList = Arrays.asList(this.IL);
            try {
                this.nsu.onAction(asList);
            } catch (Exception e) {
                if (this.nsv != null) {
                    this.nsv.onAction(asList);
                }
            }
        }
    }

    private void fs(@NonNull List<String> list) {
        if (this.nsv != null) {
            this.nsv.onAction(list);
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
            if (bVar.RF(str)) {
                arrayList.add(str);
            }
        }
        return arrayList;
    }
}
