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
    private static final com.yanzhenjie.permission.a.a nsh = new com.yanzhenjie.permission.a.b();
    private String[] IL;
    private com.yanzhenjie.permission.b.b nsi;
    private a nsj;
    private a nsk;
    private g nsl;
    private String[] nsm;

    /* JADX INFO: Access modifiers changed from: package-private */
    public d(com.yanzhenjie.permission.b.b bVar) {
        this.nsi = bVar;
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
        this.nsl = gVar;
        return this;
    }

    @Override // com.yanzhenjie.permission.h
    @NonNull
    public h a(a aVar) {
        this.nsj = aVar;
        return this;
    }

    @Override // com.yanzhenjie.permission.h
    @NonNull
    public h b(a aVar) {
        this.nsk = aVar;
        return this;
    }

    @Override // com.yanzhenjie.permission.h
    public void start() {
        List<String> a = a(nsh, this.nsi, this.IL);
        this.nsm = (String[]) a.toArray(new String[a.size()]);
        if (this.nsm.length > 0) {
            List<String> b = b(this.nsi, this.nsm);
            if (b.size() > 0 && this.nsl != null) {
                this.nsl.showRationale(this.nsi.getContext(), b, this);
                return;
            } else {
                execute();
                return;
            }
        }
        dHX();
    }

    @Override // com.yanzhenjie.permission.i
    @RequiresApi(api = 23)
    public void execute() {
        PermissionActivity.a(this.nsi.getContext(), this.nsm, this);
    }

    @Override // com.yanzhenjie.permission.i
    public void cancel() {
        X(this.nsm);
    }

    @Override // com.yanzhenjie.permission.PermissionActivity.a
    public void X(@NonNull String[] strArr) {
        List<String> a = a(nsh, this.nsi, strArr);
        if (a.isEmpty()) {
            dHX();
        } else {
            fs(a);
        }
    }

    private void dHX() {
        if (this.nsj != null) {
            List<String> asList = Arrays.asList(this.IL);
            try {
                this.nsj.onAction(asList);
            } catch (Exception e) {
                if (this.nsk != null) {
                    this.nsk.onAction(asList);
                }
            }
        }
    }

    private void fs(@NonNull List<String> list) {
        if (this.nsk != null) {
            this.nsk.onAction(list);
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
            if (bVar.RE(str)) {
                arrayList.add(str);
            }
        }
        return arrayList;
    }
}
