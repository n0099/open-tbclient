package com.xiaomi.push;

import com.xiaomi.push.di;
import java.io.File;
import java.util.Date;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes6.dex */
public class dj extends di.b {

    /* renamed from: a  reason: collision with root package name */
    final /* synthetic */ int f14242a;

    /* renamed from: a  reason: collision with other field name */
    final /* synthetic */ di f293a;

    /* renamed from: a  reason: collision with other field name */
    File f294a;

    /* renamed from: a  reason: collision with other field name */
    final /* synthetic */ String f295a;

    /* renamed from: a  reason: collision with other field name */
    final /* synthetic */ Date f296a;

    /* renamed from: a  reason: collision with other field name */
    final /* synthetic */ boolean f297a;

    /* renamed from: b  reason: collision with root package name */
    final /* synthetic */ String f14243b;

    /* renamed from: b  reason: collision with other field name */
    final /* synthetic */ Date f298b;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public dj(di diVar, int i, Date date, Date date2, String str, String str2, boolean z) {
        super();
        this.f293a = diVar;
        this.f14242a = i;
        this.f296a = date;
        this.f298b = date2;
        this.f295a = str;
        this.f14243b = str2;
        this.f297a = z;
    }

    @Override // com.xiaomi.push.di.b, com.xiaomi.push.al.b
    public void b() {
        if (aa.d()) {
            try {
                File file = new File(this.f293a.f286a.getExternalFilesDir(null) + "/.logcache");
                file.mkdirs();
                if (file.isDirectory()) {
                    dh dhVar = new dh();
                    dhVar.a(this.f14242a);
                    this.f294a = dhVar.a(this.f293a.f286a, this.f296a, this.f298b, file);
                }
            } catch (NullPointerException e) {
            }
        }
    }

    @Override // com.xiaomi.push.al.b
    /* renamed from: c */
    public void mo248c() {
        if (this.f294a != null && this.f294a.exists()) {
            this.f293a.f287a.add(new di.c(this.f295a, this.f14243b, this.f294a, this.f297a));
        }
        this.f293a.a(0L);
    }
}
