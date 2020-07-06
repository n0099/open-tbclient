package com.xiaomi.push;

import com.xiaomi.push.di;
import java.io.File;
import java.util.Date;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes8.dex */
public class dj extends di.b {
    final /* synthetic */ int a;

    /* renamed from: a  reason: collision with other field name */
    final /* synthetic */ di f220a;

    /* renamed from: a  reason: collision with other field name */
    File f221a;

    /* renamed from: a  reason: collision with other field name */
    final /* synthetic */ String f222a;

    /* renamed from: a  reason: collision with other field name */
    final /* synthetic */ Date f223a;

    /* renamed from: a  reason: collision with other field name */
    final /* synthetic */ boolean f224a;
    final /* synthetic */ String b;

    /* renamed from: b  reason: collision with other field name */
    final /* synthetic */ Date f225b;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public dj(di diVar, int i, Date date, Date date2, String str, String str2, boolean z) {
        super();
        this.f220a = diVar;
        this.a = i;
        this.f223a = date;
        this.f225b = date2;
        this.f222a = str;
        this.b = str2;
        this.f224a = z;
    }

    @Override // com.xiaomi.push.di.b, com.xiaomi.push.al.b
    public void b() {
        if (aa.d()) {
            try {
                File file = new File(this.f220a.f213a.getExternalFilesDir(null) + "/.logcache");
                file.mkdirs();
                if (file.isDirectory()) {
                    dh dhVar = new dh();
                    dhVar.a(this.a);
                    this.f221a = dhVar.a(this.f220a.f213a, this.f223a, this.f225b, file);
                }
            } catch (NullPointerException e) {
            }
        }
    }

    @Override // com.xiaomi.push.al.b
    /* renamed from: c */
    public void mo223c() {
        if (this.f221a != null && this.f221a.exists()) {
            this.f220a.f214a.add(new di.c(this.f222a, this.b, this.f221a, this.f224a));
        }
        this.f220a.a(0L);
    }
}
