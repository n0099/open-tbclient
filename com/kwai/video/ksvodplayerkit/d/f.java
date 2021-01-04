package com.kwai.video.ksvodplayerkit.d;

import android.text.TextUtils;
import com.kwai.video.hodor.AbstractHodorPreloadTask;
import com.kwai.video.hodor.MediaPreloadPriorityTask;
import com.kwai.video.ksvodplayerkit.i;
import java.util.ArrayList;
import java.util.List;
/* loaded from: classes5.dex */
public class f extends b {
    public f(String str, String str2, int i) {
        ArrayList arrayList = new ArrayList();
        arrayList.add(str);
        a(arrayList, str2, i);
    }

    private void a(List<String> list, String str, int i) {
        this.f11362a = new com.kwai.video.ksvodplayerkit.HttpDns.d(list);
        this.f = i.a().t();
        this.d = list.get(0);
        this.c = i;
        this.g = str;
        String b2 = com.kwai.video.ksvodplayerkit.c.a.b(this.d);
        if (this.f11362a.b() != null && !TextUtils.isEmpty(this.f11362a.b().f11325b)) {
            this.d = this.f11362a.b().f11325b;
            b2 = this.f11362a.d();
        }
        this.c = i;
        this.e = MediaPreloadPriorityTask.newTaskWithHttpDns(this.d, b2, com.kwai.video.ksvodplayerkit.c.c.c(this.d));
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.kwai.video.ksvodplayerkit.d.b
    public AbstractHodorPreloadTask a() {
        this.f11362a.a(false);
        if (this.f11362a.f() <= 0 || this.f11362a.e() || this.f11363b.get() >= i.a().e() || !this.f11362a.a()) {
            return null;
        }
        if (this.f11362a.b() != null && !TextUtils.isEmpty(this.f11362a.b().f11325b)) {
            this.d = this.f11362a.b().f11325b;
            this.e = MediaPreloadPriorityTask.newTaskWithHttpDns(this.d, this.f11362a.d(), com.kwai.video.ksvodplayerkit.c.c.c(this.d));
        }
        return this.e;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.kwai.video.ksvodplayerkit.d.b
    public AbstractHodorPreloadTask b() {
        if (this.e == null) {
            this.e = MediaPreloadPriorityTask.newTaskWithHttpDns(this.d, this.f11362a.d() != null ? this.f11362a.d() : com.kwai.video.ksvodplayerkit.c.a.b(this.d), com.kwai.video.ksvodplayerkit.c.c.c(this.d));
        }
        return this.e;
    }
}
