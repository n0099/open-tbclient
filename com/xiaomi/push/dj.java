package com.xiaomi.push;

import com.xiaomi.push.di;
import java.io.File;
import java.util.Date;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes7.dex */
public class dj extends di.b {
    final /* synthetic */ int a;

    /* renamed from: a  reason: collision with other field name */
    final /* synthetic */ di f216a;

    /* renamed from: a  reason: collision with other field name */
    File f217a;

    /* renamed from: a  reason: collision with other field name */
    final /* synthetic */ String f218a;

    /* renamed from: a  reason: collision with other field name */
    final /* synthetic */ Date f219a;

    /* renamed from: a  reason: collision with other field name */
    final /* synthetic */ boolean f220a;
    final /* synthetic */ String b;

    /* renamed from: b  reason: collision with other field name */
    final /* synthetic */ Date f221b;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public dj(di diVar, int i, Date date, Date date2, String str, String str2, boolean z) {
        super();
        this.f216a = diVar;
        this.a = i;
        this.f219a = date;
        this.f221b = date2;
        this.f218a = str;
        this.b = str2;
        this.f220a = z;
    }

    @Override // com.xiaomi.push.di.b, com.xiaomi.push.al.b
    public void b() {
        if (aa.d()) {
            try {
                File file = new File(this.f216a.f209a.getExternalFilesDir(null) + "/.logcache");
                file.mkdirs();
                if (file.isDirectory()) {
                    dh dhVar = new dh();
                    dhVar.a(this.a);
                    this.f217a = dhVar.a(this.f216a.f209a, this.f219a, this.f221b, file);
                }
            } catch (NullPointerException e) {
            }
        }
    }

    @Override // com.xiaomi.push.al.b
    /* renamed from: c */
    public void mo229c() {
        if (this.f217a != null && this.f217a.exists()) {
            this.f216a.f210a.add(new di.c(this.f218a, this.b, this.f217a, this.f220a));
        }
        this.f216a.a(0L);
    }
}
