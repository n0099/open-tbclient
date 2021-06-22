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
        this.f38161a = new com.kwai.video.ksvodplayerkit.HttpDns.d(list);
        this.f38166f = i.a().t();
        String str2 = list.get(0);
        this.f38164d = str2;
        this.f38163c = i2;
        this.f38167g = str;
        String b2 = com.kwai.video.ksvodplayerkit.c.a.b(str2);
        if (this.f38161a.b() != null && !TextUtils.isEmpty(this.f38161a.b().f38063b)) {
            this.f38164d = this.f38161a.b().f38063b;
            b2 = this.f38161a.d();
        }
        this.f38163c = i2;
        String str3 = this.f38164d;
        this.f38165e = MediaPreloadPriorityTask.newTaskWithHttpDns(str3, b2, com.kwai.video.ksvodplayerkit.c.c.c(str3));
    }

    @Override // com.kwai.video.ksvodplayerkit.d.b
    public AbstractHodorPreloadTask a() {
        this.f38161a.a(false);
        if (this.f38161a.f() <= 0 || this.f38161a.e() || this.f38162b.get() >= i.a().e() || !this.f38161a.a()) {
            return null;
        }
        if (this.f38161a.b() != null && !TextUtils.isEmpty(this.f38161a.b().f38063b)) {
            this.f38164d = this.f38161a.b().f38063b;
            String d2 = this.f38161a.d();
            String str = this.f38164d;
            this.f38165e = MediaPreloadPriorityTask.newTaskWithHttpDns(str, d2, com.kwai.video.ksvodplayerkit.c.c.c(str));
        }
        return this.f38165e;
    }

    @Override // com.kwai.video.ksvodplayerkit.d.b
    public AbstractHodorPreloadTask b() {
        if (this.f38165e == null) {
            String d2 = this.f38161a.d() != null ? this.f38161a.d() : com.kwai.video.ksvodplayerkit.c.a.b(this.f38164d);
            String str = this.f38164d;
            this.f38165e = MediaPreloadPriorityTask.newTaskWithHttpDns(str, d2, com.kwai.video.ksvodplayerkit.c.c.c(str));
        }
        return this.f38165e;
    }
}
