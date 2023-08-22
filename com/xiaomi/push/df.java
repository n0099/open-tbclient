package com.xiaomi.push;

import com.xiaomi.push.de;
import java.io.File;
import java.util.Date;
/* loaded from: classes10.dex */
public class df extends de.b {
    public final /* synthetic */ int a;

    /* renamed from: a  reason: collision with other field name */
    public final /* synthetic */ de f217a;

    /* renamed from: a  reason: collision with other field name */
    public File f218a;

    /* renamed from: a  reason: collision with other field name */
    public final /* synthetic */ String f219a;

    /* renamed from: a  reason: collision with other field name */
    public final /* synthetic */ Date f220a;

    /* renamed from: a  reason: collision with other field name */
    public final /* synthetic */ boolean f221a;
    public final /* synthetic */ String b;

    /* renamed from: b  reason: collision with other field name */
    public final /* synthetic */ Date f222b;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public df(de deVar, int i, Date date, Date date2, String str, String str2, boolean z) {
        super();
        this.f217a = deVar;
        this.a = i;
        this.f220a = date;
        this.f222b = date2;
        this.f219a = str;
        this.b = str2;
        this.f221a = z;
    }

    @Override // com.xiaomi.push.de.b, com.xiaomi.push.am.b
    public void b() {
        if (aa.d()) {
            try {
                File file = new File(this.f217a.f210a.getExternalFilesDir(null) + "/.logcache");
                file.mkdirs();
                if (file.isDirectory()) {
                    dd ddVar = new dd();
                    ddVar.a(this.a);
                    this.f218a = ddVar.a(this.f217a.f210a, this.f220a, this.f222b, file);
                }
            } catch (NullPointerException unused) {
            }
        }
    }

    @Override // com.xiaomi.push.am.b
    /* renamed from: c */
    public void mo359c() {
        File file = this.f218a;
        if (file != null && file.exists()) {
            this.f217a.f211a.add(new de.c(this.f219a, this.b, this.f218a, this.f221a));
        }
        this.f217a.a(0L);
    }
}
