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
        this.f37288a = new com.kwai.video.ksvodplayerkit.HttpDns.d(list);
        this.f37293f = i.a().t();
        String str2 = list.get(0);
        this.f37291d = str2;
        this.f37290c = i;
        this.f37294g = str;
        String b2 = com.kwai.video.ksvodplayerkit.c.a.b(str2);
        if (this.f37288a.b() != null && !TextUtils.isEmpty(this.f37288a.b().f37197b)) {
            this.f37291d = this.f37288a.b().f37197b;
            b2 = this.f37288a.d();
        }
        this.f37290c = i;
        String str3 = this.f37291d;
        this.f37292e = MediaPreloadPriorityTask.newTaskWithHttpDns(str3, b2, com.kwai.video.ksvodplayerkit.c.c.c(str3));
    }

    @Override // com.kwai.video.ksvodplayerkit.d.b
    public AbstractHodorPreloadTask a() {
        this.f37288a.a(false);
        if (this.f37288a.f() <= 0 || this.f37288a.e() || this.f37289b.get() >= i.a().e() || !this.f37288a.a()) {
            return null;
        }
        if (this.f37288a.b() != null && !TextUtils.isEmpty(this.f37288a.b().f37197b)) {
            this.f37291d = this.f37288a.b().f37197b;
            String d2 = this.f37288a.d();
            String str = this.f37291d;
            this.f37292e = MediaPreloadPriorityTask.newTaskWithHttpDns(str, d2, com.kwai.video.ksvodplayerkit.c.c.c(str));
        }
        return this.f37292e;
    }

    @Override // com.kwai.video.ksvodplayerkit.d.b
    public AbstractHodorPreloadTask b() {
        if (this.f37292e == null) {
            String d2 = this.f37288a.d() != null ? this.f37288a.d() : com.kwai.video.ksvodplayerkit.c.a.b(this.f37291d);
            String str = this.f37291d;
            this.f37292e = MediaPreloadPriorityTask.newTaskWithHttpDns(str, d2, com.kwai.video.ksvodplayerkit.c.c.c(str));
        }
        return this.f37292e;
    }
}
