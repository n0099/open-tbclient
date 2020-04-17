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
    private static final com.yanzhenjie.permission.a.a mQP = new com.yanzhenjie.permission.a.b();
    private String[] abS;
    private com.yanzhenjie.permission.b.b mQQ;
    private a mQR;
    private a mQS;
    private g mQT;
    private String[] mQU;

    /* JADX INFO: Access modifiers changed from: package-private */
    public d(com.yanzhenjie.permission.b.b bVar) {
        this.mQQ = bVar;
    }

    @Override // com.yanzhenjie.permission.h
    @NonNull
    public h V(String... strArr) {
        this.abS = strArr;
        return this;
    }

    @Override // com.yanzhenjie.permission.h
    @NonNull
    public h a(g gVar) {
        this.mQT = gVar;
        return this;
    }

    @Override // com.yanzhenjie.permission.h
    @NonNull
    public h a(a aVar) {
        this.mQR = aVar;
        return this;
    }

    @Override // com.yanzhenjie.permission.h
    @NonNull
    public h b(a aVar) {
        this.mQS = aVar;
        return this;
    }

    @Override // com.yanzhenjie.permission.h
    public void start() {
        List<String> a = a(mQP, this.mQQ, this.abS);
        this.mQU = (String[]) a.toArray(new String[a.size()]);
        if (this.mQU.length > 0) {
            List<String> b = b(this.mQQ, this.mQU);
            if (b.size() > 0 && this.mQT != null) {
                this.mQT.showRationale(this.mQQ.getContext(), b, this);
                return;
            } else {
                execute();
                return;
            }
        }
        dCA();
    }

    @Override // com.yanzhenjie.permission.i
    @RequiresApi(api = 23)
    public void execute() {
        PermissionActivity.a(this.mQQ.getContext(), this.mQU, this);
    }

    @Override // com.yanzhenjie.permission.i
    public void cancel() {
        W(this.mQU);
    }

    @Override // com.yanzhenjie.permission.PermissionActivity.a
    public void W(@NonNull String[] strArr) {
        List<String> a = a(mQP, this.mQQ, strArr);
        if (a.isEmpty()) {
            dCA();
        } else {
            fg(a);
        }
    }

    private void dCA() {
        if (this.mQR != null) {
            List<String> asList = Arrays.asList(this.abS);
            try {
                this.mQR.onAction(asList);
            } catch (Exception e) {
                if (this.mQS != null) {
                    this.mQS.onAction(asList);
                }
            }
        }
    }

    private void fg(@NonNull List<String> list) {
        if (this.mQS != null) {
            this.mQS.onAction(list);
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
            if (bVar.Pp(str)) {
                arrayList.add(str);
            }
        }
        return arrayList;
    }
}
