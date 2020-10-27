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
    private static final com.yanzhenjie.permission.a.a pBr = new com.yanzhenjie.permission.a.b();
    private String[] afe;
    private com.yanzhenjie.permission.b.b pBs;
    private a pBt;
    private a pBu;
    private g pBv;
    private String[] pBw;

    /* JADX INFO: Access modifiers changed from: package-private */
    public d(com.yanzhenjie.permission.b.b bVar) {
        this.pBs = bVar;
    }

    @Override // com.yanzhenjie.permission.h
    @NonNull
    public h aa(String... strArr) {
        this.afe = strArr;
        return this;
    }

    @Override // com.yanzhenjie.permission.h
    @NonNull
    public h a(g gVar) {
        this.pBv = gVar;
        return this;
    }

    @Override // com.yanzhenjie.permission.h
    @NonNull
    public h a(a aVar) {
        this.pBt = aVar;
        return this;
    }

    @Override // com.yanzhenjie.permission.h
    @NonNull
    public h b(a aVar) {
        this.pBu = aVar;
        return this;
    }

    @Override // com.yanzhenjie.permission.h
    public void start() {
        List<String> a2 = a(pBr, this.pBs, this.afe);
        this.pBw = (String[]) a2.toArray(new String[a2.size()]);
        if (this.pBw.length > 0) {
            List<String> b = b(this.pBs, this.pBw);
            if (b.size() > 0 && this.pBv != null) {
                this.pBv.showRationale(this.pBs.getContext(), b, this);
                return;
            } else {
                execute();
                return;
            }
        }
        ewd();
    }

    @Override // com.yanzhenjie.permission.i
    @RequiresApi(api = 23)
    public void execute() {
        PermissionActivity.a(this.pBs.getContext(), this.pBw, this);
    }

    @Override // com.yanzhenjie.permission.i
    public void cancel() {
        ab(this.pBw);
    }

    @Override // com.yanzhenjie.permission.PermissionActivity.a
    public void ab(@NonNull String[] strArr) {
        List<String> a2 = a(pBr, this.pBs, strArr);
        if (a2.isEmpty()) {
            ewd();
        } else {
            gC(a2);
        }
    }

    private void ewd() {
        if (this.pBt != null) {
            List<String> asList = Arrays.asList(this.afe);
            try {
                this.pBt.onAction(asList);
            } catch (Exception e) {
                if (this.pBu != null) {
                    this.pBu.onAction(asList);
                }
            }
        }
    }

    private void gC(@NonNull List<String> list) {
        if (this.pBu != null) {
            this.pBu.onAction(list);
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
            if (bVar.YO(str)) {
                arrayList.add(str);
            }
        }
        return arrayList;
    }
}
