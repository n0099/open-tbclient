package com.xiaomi.push;

import com.xiaomi.push.de;
import java.io.File;
import java.util.Date;
/* loaded from: classes10.dex */
public class df extends de.b {
    public final /* synthetic */ int a;

    /* renamed from: a  reason: collision with other field name */
    public final /* synthetic */ de f216a;

    /* renamed from: a  reason: collision with other field name */
    public File f217a;

    /* renamed from: a  reason: collision with other field name */
    public final /* synthetic */ String f218a;

    /* renamed from: a  reason: collision with other field name */
    public final /* synthetic */ Date f219a;

    /* renamed from: a  reason: collision with other field name */
    public final /* synthetic */ boolean f220a;
    public final /* synthetic */ String b;

    /* renamed from: b  reason: collision with other field name */
    public final /* synthetic */ Date f221b;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public df(de deVar, int i, Date date, Date date2, String str, String str2, boolean z) {
        super();
        this.f216a = deVar;
        this.a = i;
        this.f219a = date;
        this.f221b = date2;
        this.f218a = str;
        this.b = str2;
        this.f220a = z;
    }

    @Override // com.xiaomi.push.de.b, com.xiaomi.push.am.b
    public void b() {
        if (aa.d()) {
            try {
                File file = new File(this.f216a.f209a.getExternalFilesDir(null) + "/.logcache");
                file.mkdirs();
                if (file.isDirectory()) {
                    dd ddVar = new dd();
                    ddVar.a(this.a);
                    this.f217a = ddVar.a(this.f216a.f209a, this.f219a, this.f221b, file);
                }
            } catch (NullPointerException unused) {
            }
        }
    }

    @Override // com.xiaomi.push.am.b
    /* renamed from: c */
    public void mo354c() {
        File file = this.f217a;
        if (file != null && file.exists()) {
            this.f216a.f210a.add(new de.c(this.f218a, this.b, this.f217a, this.f220a));
        }
        this.f216a.a(0L);
    }
}
