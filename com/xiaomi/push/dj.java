package com.xiaomi.push;

import com.xiaomi.push.di;
import java.io.File;
import java.util.Date;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes8.dex */
public class dj extends di.b {
    final /* synthetic */ int a;

    /* renamed from: a  reason: collision with other field name */
    final /* synthetic */ di f213a;

    /* renamed from: a  reason: collision with other field name */
    File f214a;

    /* renamed from: a  reason: collision with other field name */
    final /* synthetic */ String f215a;

    /* renamed from: a  reason: collision with other field name */
    final /* synthetic */ Date f216a;

    /* renamed from: a  reason: collision with other field name */
    final /* synthetic */ boolean f217a;
    final /* synthetic */ String b;

    /* renamed from: b  reason: collision with other field name */
    final /* synthetic */ Date f218b;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public dj(di diVar, int i, Date date, Date date2, String str, String str2, boolean z) {
        super();
        this.f213a = diVar;
        this.a = i;
        this.f216a = date;
        this.f218b = date2;
        this.f215a = str;
        this.b = str2;
        this.f217a = z;
    }

    @Override // com.xiaomi.push.di.b, com.xiaomi.push.al.b
    public void b() {
        if (aa.d()) {
            try {
                File file = new File(this.f213a.f206a.getExternalFilesDir(null) + "/.logcache");
                file.mkdirs();
                if (file.isDirectory()) {
                    dh dhVar = new dh();
                    dhVar.a(this.a);
                    this.f214a = dhVar.a(this.f213a.f206a, this.f216a, this.f218b, file);
                }
            } catch (NullPointerException e) {
            }
        }
    }

    @Override // com.xiaomi.push.al.b
    /* renamed from: c */
    public void mo227c() {
        if (this.f214a != null && this.f214a.exists()) {
            this.f213a.f207a.add(new di.c(this.f215a, this.b, this.f214a, this.f217a));
        }
        this.f213a.a(0L);
    }
}
