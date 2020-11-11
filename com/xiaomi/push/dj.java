package com.xiaomi.push;

import com.xiaomi.push.di;
import java.io.File;
import java.util.Date;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes12.dex */
public class dj extends di.b {

    /* renamed from: a  reason: collision with root package name */
    final /* synthetic */ int f4859a;

    /* renamed from: a  reason: collision with other field name */
    final /* synthetic */ di f214a;

    /* renamed from: a  reason: collision with other field name */
    File f215a;

    /* renamed from: a  reason: collision with other field name */
    final /* synthetic */ String f216a;

    /* renamed from: a  reason: collision with other field name */
    final /* synthetic */ Date f217a;

    /* renamed from: a  reason: collision with other field name */
    final /* synthetic */ boolean f218a;
    final /* synthetic */ String b;

    /* renamed from: b  reason: collision with other field name */
    final /* synthetic */ Date f219b;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public dj(di diVar, int i, Date date, Date date2, String str, String str2, boolean z) {
        super();
        this.f214a = diVar;
        this.f4859a = i;
        this.f217a = date;
        this.f219b = date2;
        this.f216a = str;
        this.b = str2;
        this.f218a = z;
    }

    @Override // com.xiaomi.push.di.b, com.xiaomi.push.al.b
    public void b() {
        if (aa.d()) {
            try {
                File file = new File(this.f214a.f207a.getExternalFilesDir(null) + "/.logcache");
                file.mkdirs();
                if (file.isDirectory()) {
                    dh dhVar = new dh();
                    dhVar.a(this.f4859a);
                    this.f215a = dhVar.a(this.f214a.f207a, this.f217a, this.f219b, file);
                }
            } catch (NullPointerException e) {
            }
        }
    }

    @Override // com.xiaomi.push.al.b
    /* renamed from: c */
    public void mo229c() {
        if (this.f215a != null && this.f215a.exists()) {
            this.f214a.f208a.add(new di.c(this.f216a, this.b, this.f215a, this.f218a));
        }
        this.f214a.a(0L);
    }
}
