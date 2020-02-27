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
    private static final com.yanzhenjie.permission.a.a nsf = new com.yanzhenjie.permission.a.b();
    private String[] IL;
    private com.yanzhenjie.permission.b.b nsg;
    private a nsh;
    private a nsi;
    private g nsj;
    private String[] nsk;

    /* JADX INFO: Access modifiers changed from: package-private */
    public d(com.yanzhenjie.permission.b.b bVar) {
        this.nsg = bVar;
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
        this.nsj = gVar;
        return this;
    }

    @Override // com.yanzhenjie.permission.h
    @NonNull
    public h a(a aVar) {
        this.nsh = aVar;
        return this;
    }

    @Override // com.yanzhenjie.permission.h
    @NonNull
    public h b(a aVar) {
        this.nsi = aVar;
        return this;
    }

    @Override // com.yanzhenjie.permission.h
    public void start() {
        List<String> a = a(nsf, this.nsg, this.IL);
        this.nsk = (String[]) a.toArray(new String[a.size()]);
        if (this.nsk.length > 0) {
            List<String> b = b(this.nsg, this.nsk);
            if (b.size() > 0 && this.nsj != null) {
                this.nsj.showRationale(this.nsg.getContext(), b, this);
                return;
            } else {
                execute();
                return;
            }
        }
        dHV();
    }

    @Override // com.yanzhenjie.permission.i
    @RequiresApi(api = 23)
    public void execute() {
        PermissionActivity.a(this.nsg.getContext(), this.nsk, this);
    }

    @Override // com.yanzhenjie.permission.i
    public void cancel() {
        X(this.nsk);
    }

    @Override // com.yanzhenjie.permission.PermissionActivity.a
    public void X(@NonNull String[] strArr) {
        List<String> a = a(nsf, this.nsg, strArr);
        if (a.isEmpty()) {
            dHV();
        } else {
            fs(a);
        }
    }

    private void dHV() {
        if (this.nsh != null) {
            List<String> asList = Arrays.asList(this.IL);
            try {
                this.nsh.onAction(asList);
            } catch (Exception e) {
                if (this.nsi != null) {
                    this.nsi.onAction(asList);
                }
            }
        }
    }

    private void fs(@NonNull List<String> list) {
        if (this.nsi != null) {
            this.nsi.onAction(list);
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
