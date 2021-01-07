package com.ss.android.downloadlib.c;

import android.app.Activity;
import android.content.Context;
import android.os.Build;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.core.content.ContextCompat;
import com.ss.android.a.a.a.h;
import com.ss.android.a.a.a.q;
/* loaded from: classes4.dex */
public class b implements h {

    /* renamed from: a  reason: collision with root package name */
    private q f13277a;

    @Override // com.ss.android.a.a.a.h
    public void a(@NonNull Activity activity, @NonNull String[] strArr, q qVar) {
        if (Build.VERSION.SDK_INT >= 23) {
            this.f13277a = qVar;
            activity.requestPermissions(strArr, 1);
        } else if (qVar != null) {
            qVar.a();
        }
    }

    @Override // com.ss.android.a.a.a.h
    public boolean a(@Nullable Context context, @NonNull String str) {
        return context != null && ContextCompat.checkSelfPermission(context, str) == 0;
    }

    @Override // com.ss.android.a.a.a.h
    public void a(@NonNull Activity activity, int i, @NonNull String[] strArr, @NonNull int[] iArr) {
        if (iArr.length > 0 && this.f13277a != null) {
            if (iArr[0] == -1) {
                this.f13277a.a(strArr[0]);
            } else if (iArr[0] == 0) {
                this.f13277a.a();
            }
        }
    }
}
