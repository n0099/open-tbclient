package com.xiaomi.push;

import com.xiaomi.push.di;
import java.io.File;
import java.util.Date;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes12.dex */
public class dj extends di.b {

    /* renamed from: a  reason: collision with root package name */
    final /* synthetic */ int f4857a;

    /* renamed from: a  reason: collision with other field name */
    final /* synthetic */ di f212a;

    /* renamed from: a  reason: collision with other field name */
    File f213a;

    /* renamed from: a  reason: collision with other field name */
    final /* synthetic */ String f214a;

    /* renamed from: a  reason: collision with other field name */
    final /* synthetic */ Date f215a;

    /* renamed from: a  reason: collision with other field name */
    final /* synthetic */ boolean f216a;
    final /* synthetic */ String b;

    /* renamed from: b  reason: collision with other field name */
    final /* synthetic */ Date f217b;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public dj(di diVar, int i, Date date, Date date2, String str, String str2, boolean z) {
        super();
        this.f212a = diVar;
        this.f4857a = i;
        this.f215a = date;
        this.f217b = date2;
        this.f214a = str;
        this.b = str2;
        this.f216a = z;
    }

    @Override // com.xiaomi.push.di.b, com.xiaomi.push.al.b
    public void b() {
        if (aa.d()) {
            try {
                File file = new File(this.f212a.f205a.getExternalFilesDir(null) + "/.logcache");
                file.mkdirs();
                if (file.isDirectory()) {
                    dh dhVar = new dh();
                    dhVar.a(this.f4857a);
                    this.f213a = dhVar.a(this.f212a.f205a, this.f215a, this.f217b, file);
                }
            } catch (NullPointerException e) {
            }
        }
    }

    @Override // com.xiaomi.push.al.b
    /* renamed from: c */
    public void mo229c() {
        if (this.f213a != null && this.f213a.exists()) {
            this.f212a.f206a.add(new di.c(this.f214a, this.b, this.f213a, this.f216a));
        }
        this.f212a.a(0L);
    }
}
