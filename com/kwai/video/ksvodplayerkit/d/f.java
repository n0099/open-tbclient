package com.kwai.video.ksvodplayerkit.d;

import android.text.TextUtils;
import com.kwai.video.hodor.AbstractHodorPreloadTask;
import com.kwai.video.hodor.MediaPreloadPriorityTask;
import com.kwai.video.ksvodplayerkit.i;
import java.util.ArrayList;
import java.util.List;
/* loaded from: classes3.dex */
public class f extends b {
    public f(String str, String str2, int i) {
        ArrayList arrayList = new ArrayList();
        arrayList.add(str);
        a(arrayList, str2, i);
    }

    private void a(List<String> list, String str, int i) {
        this.f11065a = new com.kwai.video.ksvodplayerkit.HttpDns.d(list);
        this.f = i.a().t();
        this.d = list.get(0);
        this.c = i;
        this.g = str;
        String b2 = com.kwai.video.ksvodplayerkit.c.a.b(this.d);
        if (this.f11065a.b() != null && !TextUtils.isEmpty(this.f11065a.b().f11028b)) {
            this.d = this.f11065a.b().f11028b;
            b2 = this.f11065a.d();
        }
        this.c = i;
        this.e = MediaPreloadPriorityTask.newTaskWithHttpDns(this.d, b2, com.kwai.video.ksvodplayerkit.c.c.c(this.d));
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.kwai.video.ksvodplayerkit.d.b
    public AbstractHodorPreloadTask a() {
        this.f11065a.a(false);
        if (this.f11065a.f() <= 0 || this.f11065a.e() || this.f11066b.get() >= i.a().e() || !this.f11065a.a()) {
            return null;
        }
        if (this.f11065a.b() != null && !TextUtils.isEmpty(this.f11065a.b().f11028b)) {
            this.d = this.f11065a.b().f11028b;
            this.e = MediaPreloadPriorityTask.newTaskWithHttpDns(this.d, this.f11065a.d(), com.kwai.video.ksvodplayerkit.c.c.c(this.d));
        }
        return this.e;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.kwai.video.ksvodplayerkit.d.b
    public AbstractHodorPreloadTask b() {
        if (this.e == null) {
            this.e = MediaPreloadPriorityTask.newTaskWithHttpDns(this.d, this.f11065a.d() != null ? this.f11065a.d() : com.kwai.video.ksvodplayerkit.c.a.b(this.d), com.kwai.video.ksvodplayerkit.c.c.c(this.d));
        }
        return this.e;
    }
}
