package com.vivo.push.b;

import android.content.Intent;
import java.util.HashMap;
/* loaded from: classes3.dex */
public final class x extends com.vivo.push.v {
    private HashMap<String, String> a;
    private long b;

    public x() {
        super(2012);
    }

    public x(long j) {
        this();
        this.b = j;
    }

    public final void a(HashMap<String, String> hashMap) {
        this.a = hashMap;
    }

    @Override // com.vivo.push.v
    public final void d(Intent intent) {
        intent.putExtra("ReporterCommand.EXTRA_PARAMS", this.a);
        intent.putExtra("ReporterCommand.EXTRA_REPORTER_TYPE", this.b);
    }

    @Override // com.vivo.push.v
    public final void e(Intent intent) {
        this.a = (HashMap) intent.getSerializableExtra("ReporterCommand.EXTRA_PARAMS");
        this.b = intent.getLongExtra("ReporterCommand.EXTRA_REPORTER_TYPE", this.b);
    }

    @Override // com.vivo.push.v
    public final String toString() {
        return "ReporterCommand（" + this.b + ")";
    }
}
