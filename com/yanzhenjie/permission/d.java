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
    private static final com.yanzhenjie.permission.a.a mQS = new com.yanzhenjie.permission.a.b();
    private String[] abV;
    private com.yanzhenjie.permission.b.b mQT;
    private a mQU;
    private a mQV;
    private g mQW;
    private String[] mQX;

    /* JADX INFO: Access modifiers changed from: package-private */
    public d(com.yanzhenjie.permission.b.b bVar) {
        this.mQT = bVar;
    }

    @Override // com.yanzhenjie.permission.h
    @NonNull
    public h V(String... strArr) {
        this.abV = strArr;
        return this;
    }

    @Override // com.yanzhenjie.permission.h
    @NonNull
    public h a(g gVar) {
        this.mQW = gVar;
        return this;
    }

    @Override // com.yanzhenjie.permission.h
    @NonNull
    public h a(a aVar) {
        this.mQU = aVar;
        return this;
    }

    @Override // com.yanzhenjie.permission.h
    @NonNull
    public h b(a aVar) {
        this.mQV = aVar;
        return this;
    }

    @Override // com.yanzhenjie.permission.h
    public void start() {
        List<String> a = a(mQS, this.mQT, this.abV);
        this.mQX = (String[]) a.toArray(new String[a.size()]);
        if (this.mQX.length > 0) {
            List<String> b = b(this.mQT, this.mQX);
            if (b.size() > 0 && this.mQW != null) {
                this.mQW.showRationale(this.mQT.getContext(), b, this);
                return;
            } else {
                execute();
                return;
            }
        }
        dCx();
    }

    @Override // com.yanzhenjie.permission.i
    @RequiresApi(api = 23)
    public void execute() {
        PermissionActivity.a(this.mQT.getContext(), this.mQX, this);
    }

    @Override // com.yanzhenjie.permission.i
    public void cancel() {
        W(this.mQX);
    }

    @Override // com.yanzhenjie.permission.PermissionActivity.a
    public void W(@NonNull String[] strArr) {
        List<String> a = a(mQS, this.mQT, strArr);
        if (a.isEmpty()) {
            dCx();
        } else {
            fg(a);
        }
    }

    private void dCx() {
        if (this.mQU != null) {
            List<String> asList = Arrays.asList(this.abV);
            try {
                this.mQU.onAction(asList);
            } catch (Exception e) {
                if (this.mQV != null) {
                    this.mQV.onAction(asList);
                }
            }
        }
    }

    private void fg(@NonNull List<String> list) {
        if (this.mQV != null) {
            this.mQV.onAction(list);
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
            if (bVar.Ps(str)) {
                arrayList.add(str);
            }
        }
        return arrayList;
    }
}
