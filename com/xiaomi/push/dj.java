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
    final /* synthetic */ di f215a;

    /* renamed from: a  reason: collision with other field name */
    File f216a;

    /* renamed from: a  reason: collision with other field name */
    final /* synthetic */ String f217a;

    /* renamed from: a  reason: collision with other field name */
    final /* synthetic */ Date f218a;

    /* renamed from: a  reason: collision with other field name */
    final /* synthetic */ boolean f219a;
    final /* synthetic */ String b;

    /* renamed from: b  reason: collision with other field name */
    final /* synthetic */ Date f220b;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public dj(di diVar, int i, Date date, Date date2, String str, String str2, boolean z) {
        super();
        this.f215a = diVar;
        this.f4859a = i;
        this.f218a = date;
        this.f220b = date2;
        this.f217a = str;
        this.b = str2;
        this.f219a = z;
    }

    @Override // com.xiaomi.push.di.b, com.xiaomi.push.al.b
    public void b() {
        if (aa.d()) {
            try {
                File file = new File(this.f215a.f208a.getExternalFilesDir(null) + "/.logcache");
                file.mkdirs();
                if (file.isDirectory()) {
                    dh dhVar = new dh();
                    dhVar.a(this.f4859a);
                    this.f216a = dhVar.a(this.f215a.f208a, this.f218a, this.f220b, file);
                }
            } catch (NullPointerException e) {
            }
        }
    }

    @Override // com.xiaomi.push.al.b
    /* renamed from: c */
    public void mo230c() {
        if (this.f216a != null && this.f216a.exists()) {
            this.f215a.f209a.add(new di.c(this.f217a, this.b, this.f216a, this.f219a));
        }
        this.f215a.a(0L);
    }
}
