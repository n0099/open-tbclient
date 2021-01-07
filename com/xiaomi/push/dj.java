package com.xiaomi.push;

import com.xiaomi.push.di;
import java.io.File;
import java.util.Date;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes6.dex */
public class dj extends di.b {

    /* renamed from: a  reason: collision with root package name */
    final /* synthetic */ int f14243a;

    /* renamed from: a  reason: collision with other field name */
    final /* synthetic */ di f294a;

    /* renamed from: a  reason: collision with other field name */
    File f295a;

    /* renamed from: a  reason: collision with other field name */
    final /* synthetic */ String f296a;

    /* renamed from: a  reason: collision with other field name */
    final /* synthetic */ Date f297a;

    /* renamed from: a  reason: collision with other field name */
    final /* synthetic */ boolean f298a;

    /* renamed from: b  reason: collision with root package name */
    final /* synthetic */ String f14244b;

    /* renamed from: b  reason: collision with other field name */
    final /* synthetic */ Date f299b;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public dj(di diVar, int i, Date date, Date date2, String str, String str2, boolean z) {
        super();
        this.f294a = diVar;
        this.f14243a = i;
        this.f297a = date;
        this.f299b = date2;
        this.f296a = str;
        this.f14244b = str2;
        this.f298a = z;
    }

    @Override // com.xiaomi.push.di.b, com.xiaomi.push.al.b
    public void b() {
        if (aa.d()) {
            try {
                File file = new File(this.f294a.f287a.getExternalFilesDir(null) + "/.logcache");
                file.mkdirs();
                if (file.isDirectory()) {
                    dh dhVar = new dh();
                    dhVar.a(this.f14243a);
                    this.f295a = dhVar.a(this.f294a.f287a, this.f297a, this.f299b, file);
                }
            } catch (NullPointerException e) {
            }
        }
    }

    @Override // com.xiaomi.push.al.b
    /* renamed from: c */
    public void mo259c() {
        if (this.f295a != null && this.f295a.exists()) {
            this.f294a.f288a.add(new di.c(this.f296a, this.f14244b, this.f295a, this.f298a));
        }
        this.f294a.a(0L);
    }
}
