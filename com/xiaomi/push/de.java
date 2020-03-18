package com.xiaomi.push;

import com.xiaomi.push.dd;
import java.io.File;
import java.util.Date;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes8.dex */
public class de extends dd.b {
    final /* synthetic */ int a;

    /* renamed from: a  reason: collision with other field name */
    final /* synthetic */ dd f228a;

    /* renamed from: a  reason: collision with other field name */
    File f229a;

    /* renamed from: a  reason: collision with other field name */
    final /* synthetic */ String f230a;

    /* renamed from: a  reason: collision with other field name */
    final /* synthetic */ Date f231a;

    /* renamed from: a  reason: collision with other field name */
    final /* synthetic */ boolean f232a;
    final /* synthetic */ String b;

    /* renamed from: b  reason: collision with other field name */
    final /* synthetic */ Date f233b;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public de(dd ddVar, int i, Date date, Date date2, String str, String str2, boolean z) {
        super();
        this.f228a = ddVar;
        this.a = i;
        this.f231a = date;
        this.f233b = date2;
        this.f230a = str;
        this.b = str2;
        this.f232a = z;
    }

    @Override // com.xiaomi.push.dd.b, com.xiaomi.push.al.b
    public void b() {
        if (aa.d()) {
            try {
                File file = new File(this.f228a.f221a.getExternalFilesDir(null) + "/.logcache");
                file.mkdirs();
                if (file.isDirectory()) {
                    dc dcVar = new dc();
                    dcVar.a(this.a);
                    this.f229a = dcVar.a(this.f228a.f221a, this.f231a, this.f233b, file);
                }
            } catch (NullPointerException e) {
            }
        }
    }

    @Override // com.xiaomi.push.al.b
    /* renamed from: c */
    public void mo218c() {
        if (this.f229a != null && this.f229a.exists()) {
            this.f228a.f222a.add(new dd.c(this.f230a, this.b, this.f229a, this.f232a));
        }
        this.f228a.a(0L);
    }
}
