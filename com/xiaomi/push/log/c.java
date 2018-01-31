package com.xiaomi.push.log;

import com.xiaomi.push.log.b;
import java.io.File;
import java.util.Date;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes2.dex */
public class c extends b.C0199b {
    File a;
    final /* synthetic */ int b;
    final /* synthetic */ Date c;
    final /* synthetic */ Date d;
    final /* synthetic */ String e;
    final /* synthetic */ String f;
    final /* synthetic */ boolean g;
    final /* synthetic */ b h;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public c(b bVar, int i, Date date, Date date2, String str, String str2, boolean z) {
        super();
        this.h = bVar;
        this.b = i;
        this.c = date;
        this.d = date2;
        this.e = str;
        this.f = str2;
        this.g = z;
    }

    @Override // com.xiaomi.push.log.b.C0199b, com.xiaomi.channel.commonutils.misc.h.b
    public void b() {
        if (com.xiaomi.channel.commonutils.file.c.d()) {
            try {
                File file = new File(this.h.b.getExternalFilesDir(null) + "/.logcache");
                file.mkdirs();
                if (file.isDirectory()) {
                    a aVar = new a();
                    aVar.a(this.b);
                    this.a = aVar.a(this.h.b, this.c, this.d, file);
                }
            } catch (NullPointerException e) {
            }
        }
    }

    @Override // com.xiaomi.channel.commonutils.misc.h.b
    public void c() {
        if (this.a != null && this.a.exists()) {
            this.h.a.add(new b.c(this.e, this.f, this.a, this.g));
        }
        this.h.a(0L);
    }
}
