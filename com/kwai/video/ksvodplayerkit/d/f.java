package com.kwai.video.ksvodplayerkit.d;

import android.text.TextUtils;
import com.kwai.video.hodor.AbstractHodorPreloadTask;
import com.kwai.video.hodor.MediaPreloadPriorityTask;
import com.kwai.video.ksvodplayerkit.i;
import java.util.ArrayList;
import java.util.List;
/* loaded from: classes7.dex */
public class f extends b {
    public f(String str, String str2, int i2) {
        ArrayList arrayList = new ArrayList();
        arrayList.add(str);
        a(arrayList, str2, i2);
    }

    private void a(List<String> list, String str, int i2) {
        this.f38063a = new com.kwai.video.ksvodplayerkit.HttpDns.d(list);
        this.f38068f = i.a().t();
        String str2 = list.get(0);
        this.f38066d = str2;
        this.f38065c = i2;
        this.f38069g = str;
        String b2 = com.kwai.video.ksvodplayerkit.c.a.b(str2);
        if (this.f38063a.b() != null && !TextUtils.isEmpty(this.f38063a.b().f37965b)) {
            this.f38066d = this.f38063a.b().f37965b;
            b2 = this.f38063a.d();
        }
        this.f38065c = i2;
        String str3 = this.f38066d;
        this.f38067e = MediaPreloadPriorityTask.newTaskWithHttpDns(str3, b2, com.kwai.video.ksvodplayerkit.c.c.c(str3));
    }

    @Override // com.kwai.video.ksvodplayerkit.d.b
    public AbstractHodorPreloadTask a() {
        this.f38063a.a(false);
        if (this.f38063a.f() <= 0 || this.f38063a.e() || this.f38064b.get() >= i.a().e() || !this.f38063a.a()) {
            return null;
        }
        if (this.f38063a.b() != null && !TextUtils.isEmpty(this.f38063a.b().f37965b)) {
            this.f38066d = this.f38063a.b().f37965b;
            String d2 = this.f38063a.d();
            String str = this.f38066d;
            this.f38067e = MediaPreloadPriorityTask.newTaskWithHttpDns(str, d2, com.kwai.video.ksvodplayerkit.c.c.c(str));
        }
        return this.f38067e;
    }

    @Override // com.kwai.video.ksvodplayerkit.d.b
    public AbstractHodorPreloadTask b() {
        if (this.f38067e == null) {
            String d2 = this.f38063a.d() != null ? this.f38063a.d() : com.kwai.video.ksvodplayerkit.c.a.b(this.f38066d);
            String str = this.f38066d;
            this.f38067e = MediaPreloadPriorityTask.newTaskWithHttpDns(str, d2, com.kwai.video.ksvodplayerkit.c.c.c(str));
        }
        return this.f38067e;
    }
}
