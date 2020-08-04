package com.xiaomi.push;

import com.xiaomi.push.di;
import java.io.File;
import java.util.Date;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes9.dex */
public class dj extends di.b {
    final /* synthetic */ int a;

    /* renamed from: a  reason: collision with other field name */
    final /* synthetic */ di f219a;

    /* renamed from: a  reason: collision with other field name */
    File f220a;

    /* renamed from: a  reason: collision with other field name */
    final /* synthetic */ String f221a;

    /* renamed from: a  reason: collision with other field name */
    final /* synthetic */ Date f222a;

    /* renamed from: a  reason: collision with other field name */
    final /* synthetic */ boolean f223a;
    final /* synthetic */ String b;

    /* renamed from: b  reason: collision with other field name */
    final /* synthetic */ Date f224b;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public dj(di diVar, int i, Date date, Date date2, String str, String str2, boolean z) {
        super();
        this.f219a = diVar;
        this.a = i;
        this.f222a = date;
        this.f224b = date2;
        this.f221a = str;
        this.b = str2;
        this.f223a = z;
    }

    @Override // com.xiaomi.push.di.b, com.xiaomi.push.al.b
    public void b() {
        if (aa.d()) {
            try {
                File file = new File(this.f219a.f212a.getExternalFilesDir(null) + "/.logcache");
                file.mkdirs();
                if (file.isDirectory()) {
                    dh dhVar = new dh();
                    dhVar.a(this.a);
                    this.f220a = dhVar.a(this.f219a.f212a, this.f222a, this.f224b, file);
                }
            } catch (NullPointerException e) {
            }
        }
    }

    @Override // com.xiaomi.push.al.b
    /* renamed from: c */
    public void mo224c() {
        if (this.f220a != null && this.f220a.exists()) {
            this.f219a.f213a.add(new di.c(this.f221a, this.b, this.f220a, this.f223a));
        }
        this.f219a.a(0L);
    }
}
