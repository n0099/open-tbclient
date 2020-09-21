package com.yanzhenjie.permission;

import android.support.annotation.NonNull;
import android.support.annotation.RequiresApi;
import com.yanzhenjie.permission.PermissionActivity;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
@RequiresApi(api = 23)
/* loaded from: classes8.dex */
class d implements PermissionActivity.a, h, i {
    private static final com.yanzhenjie.permission.a.a ouF = new com.yanzhenjie.permission.a.b();
    private String[] aeM;
    private com.yanzhenjie.permission.b.b ouG;
    private a ouH;
    private a ouI;
    private g ouJ;
    private String[] ouK;

    /* JADX INFO: Access modifiers changed from: package-private */
    public d(com.yanzhenjie.permission.b.b bVar) {
        this.ouG = bVar;
    }

    @Override // com.yanzhenjie.permission.h
    @NonNull
    public h W(String... strArr) {
        this.aeM = strArr;
        return this;
    }

    @Override // com.yanzhenjie.permission.h
    @NonNull
    public h a(g gVar) {
        this.ouJ = gVar;
        return this;
    }

    @Override // com.yanzhenjie.permission.h
    @NonNull
    public h a(a aVar) {
        this.ouH = aVar;
        return this;
    }

    @Override // com.yanzhenjie.permission.h
    @NonNull
    public h b(a aVar) {
        this.ouI = aVar;
        return this;
    }

    @Override // com.yanzhenjie.permission.h
    public void start() {
        List<String> a = a(ouF, this.ouG, this.aeM);
        this.ouK = (String[]) a.toArray(new String[a.size()]);
        if (this.ouK.length > 0) {
            List<String> b = b(this.ouG, this.ouK);
            if (b.size() > 0 && this.ouJ != null) {
                this.ouJ.showRationale(this.ouG.getContext(), b, this);
                return;
            } else {
                execute();
                return;
            }
        }
        eis();
    }

    @Override // com.yanzhenjie.permission.i
    @RequiresApi(api = 23)
    public void execute() {
        PermissionActivity.a(this.ouG.getContext(), this.ouK, this);
    }

    @Override // com.yanzhenjie.permission.i
    public void cancel() {
        X(this.ouK);
    }

    @Override // com.yanzhenjie.permission.PermissionActivity.a
    public void X(@NonNull String[] strArr) {
        List<String> a = a(ouF, this.ouG, strArr);
        if (a.isEmpty()) {
            eis();
        } else {
            gd(a);
        }
    }

    private void eis() {
        if (this.ouH != null) {
            List<String> asList = Arrays.asList(this.aeM);
            try {
                this.ouH.onAction(asList);
            } catch (Exception e) {
                if (this.ouI != null) {
                    this.ouI.onAction(asList);
                }
            }
        }
    }

    private void gd(@NonNull List<String> list) {
        if (this.ouI != null) {
            this.ouI.onAction(list);
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
            if (bVar.Wn(str)) {
                arrayList.add(str);
            }
        }
        return arrayList;
    }
}
