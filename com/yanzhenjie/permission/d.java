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
    private static final com.yanzhenjie.permission.a.a oJU = new com.yanzhenjie.permission.a.b();
    private String[] afd;
    private com.yanzhenjie.permission.b.b oJV;
    private a oJW;
    private a oJX;
    private g oJY;
    private String[] oJZ;

    /* JADX INFO: Access modifiers changed from: package-private */
    public d(com.yanzhenjie.permission.b.b bVar) {
        this.oJV = bVar;
    }

    @Override // com.yanzhenjie.permission.h
    @NonNull
    public h Z(String... strArr) {
        this.afd = strArr;
        return this;
    }

    @Override // com.yanzhenjie.permission.h
    @NonNull
    public h a(g gVar) {
        this.oJY = gVar;
        return this;
    }

    @Override // com.yanzhenjie.permission.h
    @NonNull
    public h a(a aVar) {
        this.oJW = aVar;
        return this;
    }

    @Override // com.yanzhenjie.permission.h
    @NonNull
    public h b(a aVar) {
        this.oJX = aVar;
        return this;
    }

    @Override // com.yanzhenjie.permission.h
    public void start() {
        List<String> a2 = a(oJU, this.oJV, this.afd);
        this.oJZ = (String[]) a2.toArray(new String[a2.size()]);
        if (this.oJZ.length > 0) {
            List<String> b = b(this.oJV, this.oJZ);
            if (b.size() > 0 && this.oJY != null) {
                this.oJY.showRationale(this.oJV.getContext(), b, this);
                return;
            } else {
                execute();
                return;
            }
        }
        emd();
    }

    @Override // com.yanzhenjie.permission.i
    @RequiresApi(api = 23)
    public void execute() {
        PermissionActivity.a(this.oJV.getContext(), this.oJZ, this);
    }

    @Override // com.yanzhenjie.permission.i
    public void cancel() {
        aa(this.oJZ);
    }

    @Override // com.yanzhenjie.permission.PermissionActivity.a
    public void aa(@NonNull String[] strArr) {
        List<String> a2 = a(oJU, this.oJV, strArr);
        if (a2.isEmpty()) {
            emd();
        } else {
            gg(a2);
        }
    }

    private void emd() {
        if (this.oJW != null) {
            List<String> asList = Arrays.asList(this.afd);
            try {
                this.oJW.onAction(asList);
            } catch (Exception e) {
                if (this.oJX != null) {
                    this.oJX.onAction(asList);
                }
            }
        }
    }

    private void gg(@NonNull List<String> list) {
        if (this.oJX != null) {
            this.oJX.onAction(list);
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
            if (bVar.Xb(str)) {
                arrayList.add(str);
            }
        }
        return arrayList;
    }
}
