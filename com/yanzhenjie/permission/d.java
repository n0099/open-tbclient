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
    private static final com.yanzhenjie.permission.a.a nmf = new com.yanzhenjie.permission.a.b();
    private String[] acn;
    private com.yanzhenjie.permission.b.b nmg;
    private a nmh;
    private a nmi;
    private g nmj;
    private String[] nmk;

    /* JADX INFO: Access modifiers changed from: package-private */
    public d(com.yanzhenjie.permission.b.b bVar) {
        this.nmg = bVar;
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
        this.nmj = gVar;
        return this;
    }

    @Override // com.yanzhenjie.permission.h
    @NonNull
    public h a(a aVar) {
        this.nmh = aVar;
        return this;
    }

    @Override // com.yanzhenjie.permission.h
    @NonNull
    public h b(a aVar) {
        this.nmi = aVar;
        return this;
    }

    @Override // com.yanzhenjie.permission.h
    public void start() {
        List<String> a = a(nmf, this.nmg, this.acn);
        this.nmk = (String[]) a.toArray(new String[a.size()]);
        if (this.nmk.length > 0) {
            List<String> b = b(this.nmg, this.nmk);
            if (b.size() > 0 && this.nmj != null) {
                this.nmj.showRationale(this.nmg.getContext(), b, this);
                return;
            } else {
                execute();
                return;
            }
        }
        dKd();
    }

    @Override // com.yanzhenjie.permission.i
    @RequiresApi(api = 23)
    public void execute() {
        PermissionActivity.a(this.nmg.getContext(), this.nmk, this);
    }

    @Override // com.yanzhenjie.permission.i
    public void cancel() {
        Z(this.nmk);
    }

    @Override // com.yanzhenjie.permission.PermissionActivity.a
    public void Z(@NonNull String[] strArr) {
        List<String> a = a(nmf, this.nmg, strArr);
        if (a.isEmpty()) {
            dKd();
        } else {
            fp(a);
        }
    }

    private void dKd() {
        if (this.nmh != null) {
            List<String> asList = Arrays.asList(this.acn);
            try {
                this.nmh.onAction(asList);
            } catch (Exception e) {
                if (this.nmi != null) {
                    this.nmi.onAction(asList);
                }
            }
        }
    }

    private void fp(@NonNull List<String> list) {
        if (this.nmi != null) {
            this.nmi.onAction(list);
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
            if (bVar.Rj(str)) {
                arrayList.add(str);
            }
        }
        return arrayList;
    }
}
