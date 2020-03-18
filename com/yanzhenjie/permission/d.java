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
    private static final com.yanzhenjie.permission.a.a nuf = new com.yanzhenjie.permission.a.b();
    private String[] IL;
    private com.yanzhenjie.permission.b.b nug;
    private a nuh;
    private a nui;
    private g nuj;
    private String[] nuk;

    /* JADX INFO: Access modifiers changed from: package-private */
    public d(com.yanzhenjie.permission.b.b bVar) {
        this.nug = bVar;
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
        this.nuj = gVar;
        return this;
    }

    @Override // com.yanzhenjie.permission.h
    @NonNull
    public h a(a aVar) {
        this.nuh = aVar;
        return this;
    }

    @Override // com.yanzhenjie.permission.h
    @NonNull
    public h b(a aVar) {
        this.nui = aVar;
        return this;
    }

    @Override // com.yanzhenjie.permission.h
    public void start() {
        List<String> a = a(nuf, this.nug, this.IL);
        this.nuk = (String[]) a.toArray(new String[a.size()]);
        if (this.nuk.length > 0) {
            List<String> b = b(this.nug, this.nuk);
            if (b.size() > 0 && this.nuj != null) {
                this.nuj.showRationale(this.nug.getContext(), b, this);
                return;
            } else {
                execute();
                return;
            }
        }
        dIy();
    }

    @Override // com.yanzhenjie.permission.i
    @RequiresApi(api = 23)
    public void execute() {
        PermissionActivity.a(this.nug.getContext(), this.nuk, this);
    }

    @Override // com.yanzhenjie.permission.i
    public void cancel() {
        X(this.nuk);
    }

    @Override // com.yanzhenjie.permission.PermissionActivity.a
    public void X(@NonNull String[] strArr) {
        List<String> a = a(nuf, this.nug, strArr);
        if (a.isEmpty()) {
            dIy();
        } else {
            fs(a);
        }
    }

    private void dIy() {
        if (this.nuh != null) {
            List<String> asList = Arrays.asList(this.IL);
            try {
                this.nuh.onAction(asList);
            } catch (Exception e) {
                if (this.nui != null) {
                    this.nui.onAction(asList);
                }
            }
        }
    }

    private void fs(@NonNull List<String> list) {
        if (this.nui != null) {
            this.nui.onAction(list);
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
