package com.xiaomi.push;

import com.xiaomi.push.de;
import java.io.File;
import java.util.Date;
/* loaded from: classes10.dex */
public class df extends de.b {
    public final /* synthetic */ int a;

    /* renamed from: a  reason: collision with other field name */
    public final /* synthetic */ de f212a;

    /* renamed from: a  reason: collision with other field name */
    public File f213a;

    /* renamed from: a  reason: collision with other field name */
    public final /* synthetic */ String f214a;

    /* renamed from: a  reason: collision with other field name */
    public final /* synthetic */ Date f215a;

    /* renamed from: a  reason: collision with other field name */
    public final /* synthetic */ boolean f216a;
    public final /* synthetic */ String b;

    /* renamed from: b  reason: collision with other field name */
    public final /* synthetic */ Date f217b;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public df(de deVar, int i, Date date, Date date2, String str, String str2, boolean z) {
        super();
        this.f212a = deVar;
        this.a = i;
        this.f215a = date;
        this.f217b = date2;
        this.f214a = str;
        this.b = str2;
        this.f216a = z;
    }

    @Override // com.xiaomi.push.de.b, com.xiaomi.push.am.b
    public void b() {
        if (aa.d()) {
            try {
                File file = new File(this.f212a.f205a.getExternalFilesDir(null) + "/.logcache");
                file.mkdirs();
                if (file.isDirectory()) {
                    dd ddVar = new dd();
                    ddVar.a(this.a);
                    this.f213a = ddVar.a(this.f212a.f205a, this.f215a, this.f217b, file);
                }
            } catch (NullPointerException unused) {
            }
        }
    }

    @Override // com.xiaomi.push.am.b
    /* renamed from: c */
    public void mo369c() {
        File file = this.f213a;
        if (file != null && file.exists()) {
            this.f212a.f206a.add(new de.c(this.f214a, this.b, this.f213a, this.f216a));
        }
        this.f212a.a(0L);
    }
}
