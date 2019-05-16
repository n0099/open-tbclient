package com.vivo.push.b;

import android.content.Intent;
/* loaded from: classes3.dex */
public final class n extends s {
    private String a;
    private int b;
    private boolean c;

    public n() {
        super(7);
        this.b = 0;
        this.c = false;
    }

    public final String d() {
        return this.a;
    }

    public final void b(String str) {
        this.a = str;
    }

    public final int e() {
        return this.b;
    }

    public final void a(int i) {
        this.b = i;
    }

    public final boolean f() {
        return this.c;
    }

    public final void a(boolean z) {
        this.c = z;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.vivo.push.b.s, com.vivo.push.v
    public final void d(Intent intent) {
        super.d(intent);
        intent.putExtra("content", this.a);
        intent.putExtra("log_level", this.b);
        intent.putExtra("is_server_log", this.c);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.vivo.push.b.s, com.vivo.push.v
    public final void e(Intent intent) {
        super.e(intent);
        this.a = intent.getStringExtra("content");
        this.b = intent.getIntExtra("log_level", 0);
        this.c = intent.getBooleanExtra("is_server_log", false);
    }

    @Override // com.vivo.push.b.s, com.vivo.push.v
    public final String toString() {
        return "OnLogCommand";
    }
}
