package com.kwai.video.ksvodplayerkit.d;

import android.text.TextUtils;
import com.kwai.video.hodor.AbstractHodorPreloadTask;
import com.kwai.video.hodor.MediaPreloadPriorityTask;
import com.kwai.video.ksvodplayerkit.i;
import java.util.ArrayList;
import java.util.List;
/* loaded from: classes4.dex */
public class f extends b {
    public f(String str, String str2, int i) {
        ArrayList arrayList = new ArrayList();
        arrayList.add(str);
        a(arrayList, str2, i);
    }

    private void a(List<String> list, String str, int i) {
        this.f11063a = new com.kwai.video.ksvodplayerkit.HttpDns.d(list);
        this.f = i.a().t();
        this.d = list.get(0);
        this.c = i;
        this.g = str;
        String b2 = com.kwai.video.ksvodplayerkit.c.a.b(this.d);
        if (this.f11063a.b() != null && !TextUtils.isEmpty(this.f11063a.b().f11026b)) {
            this.d = this.f11063a.b().f11026b;
            b2 = this.f11063a.d();
        }
        this.c = i;
        this.e = MediaPreloadPriorityTask.newTaskWithHttpDns(this.d, b2, com.kwai.video.ksvodplayerkit.c.c.c(this.d));
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.kwai.video.ksvodplayerkit.d.b
    public AbstractHodorPreloadTask a() {
        this.f11063a.a(false);
        if (this.f11063a.f() <= 0 || this.f11063a.e() || this.f11064b.get() >= i.a().e() || !this.f11063a.a()) {
            return null;
        }
        if (this.f11063a.b() != null && !TextUtils.isEmpty(this.f11063a.b().f11026b)) {
            this.d = this.f11063a.b().f11026b;
            this.e = MediaPreloadPriorityTask.newTaskWithHttpDns(this.d, this.f11063a.d(), com.kwai.video.ksvodplayerkit.c.c.c(this.d));
        }
        return this.e;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.kwai.video.ksvodplayerkit.d.b
    public AbstractHodorPreloadTask b() {
        if (this.e == null) {
            this.e = MediaPreloadPriorityTask.newTaskWithHttpDns(this.d, this.f11063a.d() != null ? this.f11063a.d() : com.kwai.video.ksvodplayerkit.c.a.b(this.d), com.kwai.video.ksvodplayerkit.c.c.c(this.d));
        }
        return this.e;
    }
}
