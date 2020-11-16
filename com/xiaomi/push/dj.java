package com.xiaomi.push;

import com.xiaomi.push.di;
import java.io.File;
import java.util.Date;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes18.dex */
public class dj extends di.b {

    /* renamed from: a  reason: collision with root package name */
    final /* synthetic */ int f4859a;

    /* renamed from: a  reason: collision with other field name */
    final /* synthetic */ di f217a;

    /* renamed from: a  reason: collision with other field name */
    File f218a;

    /* renamed from: a  reason: collision with other field name */
    final /* synthetic */ String f219a;

    /* renamed from: a  reason: collision with other field name */
    final /* synthetic */ Date f220a;

    /* renamed from: a  reason: collision with other field name */
    final /* synthetic */ boolean f221a;
    final /* synthetic */ String b;

    /* renamed from: b  reason: collision with other field name */
    final /* synthetic */ Date f222b;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public dj(di diVar, int i, Date date, Date date2, String str, String str2, boolean z) {
        super();
        this.f217a = diVar;
        this.f4859a = i;
        this.f220a = date;
        this.f222b = date2;
        this.f219a = str;
        this.b = str2;
        this.f221a = z;
    }

    @Override // com.xiaomi.push.di.b, com.xiaomi.push.al.b
    public void b() {
        if (aa.d()) {
            try {
                File file = new File(this.f217a.f210a.getExternalFilesDir(null) + "/.logcache");
                file.mkdirs();
                if (file.isDirectory()) {
                    dh dhVar = new dh();
                    dhVar.a(this.f4859a);
                    this.f218a = dhVar.a(this.f217a.f210a, this.f220a, this.f222b, file);
                }
            } catch (NullPointerException e) {
            }
        }
    }

    @Override // com.xiaomi.push.al.b
    /* renamed from: c */
    public void mo232c() {
        if (this.f218a != null && this.f218a.exists()) {
            this.f217a.f211a.add(new di.c(this.f219a, this.b, this.f218a, this.f221a));
        }
        this.f217a.a(0L);
    }
}
