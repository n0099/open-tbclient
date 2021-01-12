package com.sdk.base.module.permission;

import android.annotation.SuppressLint;
import android.content.Context;
import android.content.Intent;
import android.os.Build;
import java.util.ArrayList;
import java.util.Arrays;
/* loaded from: classes14.dex */
public final class c implements a {

    /* renamed from: a  reason: collision with root package name */
    private String[] f12869a;

    /* renamed from: b  reason: collision with root package name */
    private b f12870b;
    private String[] c;
    private Context d;

    public c(Context context) {
        this.d = context;
    }

    private void b() {
        if (this.f12870b != null) {
            Arrays.asList(this.f12869a);
        }
    }

    @SuppressLint({"NewApi"})
    public final void a() {
        if (Build.VERSION.SDK_INT >= 23) {
            Context context = this.d;
            String[] strArr = this.f12869a;
            ArrayList arrayList = new ArrayList(1);
            for (String str : strArr) {
                if (context.checkSelfPermission(str) != 0) {
                    arrayList.add(str);
                }
            }
            this.c = (String[]) arrayList.toArray(new String[arrayList.size()]);
            if (this.c.length > 0) {
                PermissionActivity.a(this);
                Intent intent = new Intent(this.d, PermissionActivity.class);
                intent.putExtra("KEY_INPUT_PERMISSIONS", this.c);
                intent.setFlags(268435456);
                this.d.startActivity(intent);
                return;
            }
        }
        b();
    }

    public final void a(b bVar) {
        this.f12870b = bVar;
    }

    public final void a(String... strArr) {
        this.f12869a = strArr;
    }

    @Override // com.sdk.base.module.permission.a
    public final void a(String[] strArr, int[] iArr) {
        ArrayList arrayList = new ArrayList();
        for (int i = 0; i < strArr.length; i++) {
            if (iArr[i] != 0) {
                arrayList.add(strArr[i]);
            }
        }
        if (arrayList.isEmpty()) {
            b();
        }
    }
}
