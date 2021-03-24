package com.kwai.video.ksvodplayerkit.d;

import android.text.TextUtils;
import com.kwai.video.hodor.AbstractHodorPreloadTask;
import com.kwai.video.hodor.MediaPreloadPriorityTask;
import com.kwai.video.ksvodplayerkit.i;
import java.util.ArrayList;
import java.util.List;
/* loaded from: classes6.dex */
public class f extends b {
    public f(String str, String str2, int i) {
        ArrayList arrayList = new ArrayList();
        arrayList.add(str);
        a(arrayList, str2, i);
    }

    private void a(List<String> list, String str, int i) {
        this.f37287a = new com.kwai.video.ksvodplayerkit.HttpDns.d(list);
        this.f37292f = i.a().t();
        String str2 = list.get(0);
        this.f37290d = str2;
        this.f37289c = i;
        this.f37293g = str;
        String b2 = com.kwai.video.ksvodplayerkit.c.a.b(str2);
        if (this.f37287a.b() != null && !TextUtils.isEmpty(this.f37287a.b().f37196b)) {
            this.f37290d = this.f37287a.b().f37196b;
            b2 = this.f37287a.d();
        }
        this.f37289c = i;
        String str3 = this.f37290d;
        this.f37291e = MediaPreloadPriorityTask.newTaskWithHttpDns(str3, b2, com.kwai.video.ksvodplayerkit.c.c.c(str3));
    }

    @Override // com.kwai.video.ksvodplayerkit.d.b
    public AbstractHodorPreloadTask a() {
        this.f37287a.a(false);
        if (this.f37287a.f() <= 0 || this.f37287a.e() || this.f37288b.get() >= i.a().e() || !this.f37287a.a()) {
            return null;
        }
        if (this.f37287a.b() != null && !TextUtils.isEmpty(this.f37287a.b().f37196b)) {
            this.f37290d = this.f37287a.b().f37196b;
            String d2 = this.f37287a.d();
            String str = this.f37290d;
            this.f37291e = MediaPreloadPriorityTask.newTaskWithHttpDns(str, d2, com.kwai.video.ksvodplayerkit.c.c.c(str));
        }
        return this.f37291e;
    }

    @Override // com.kwai.video.ksvodplayerkit.d.b
    public AbstractHodorPreloadTask b() {
        if (this.f37291e == null) {
            String d2 = this.f37287a.d() != null ? this.f37287a.d() : com.kwai.video.ksvodplayerkit.c.a.b(this.f37290d);
            String str = this.f37290d;
            this.f37291e = MediaPreloadPriorityTask.newTaskWithHttpDns(str, d2, com.kwai.video.ksvodplayerkit.c.c.c(str));
        }
        return this.f37291e;
    }
}
