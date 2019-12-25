package com.xiaomi.push;

import com.xiaomi.push.dd;
import java.io.File;
import java.util.Date;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes5.dex */
public class de extends dd.b {
    final /* synthetic */ int a;

    /* renamed from: a  reason: collision with other field name */
    final /* synthetic */ dd f233a;

    /* renamed from: a  reason: collision with other field name */
    File f234a;

    /* renamed from: a  reason: collision with other field name */
    final /* synthetic */ String f235a;

    /* renamed from: a  reason: collision with other field name */
    final /* synthetic */ Date f236a;

    /* renamed from: a  reason: collision with other field name */
    final /* synthetic */ boolean f237a;
    final /* synthetic */ String b;

    /* renamed from: b  reason: collision with other field name */
    final /* synthetic */ Date f238b;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public de(dd ddVar, int i, Date date, Date date2, String str, String str2, boolean z) {
        super();
        this.f233a = ddVar;
        this.a = i;
        this.f236a = date;
        this.f238b = date2;
        this.f235a = str;
        this.b = str2;
        this.f237a = z;
    }

    @Override // com.xiaomi.push.dd.b, com.xiaomi.push.al.b
    public void b() {
        if (aa.d()) {
            try {
                File file = new File(this.f233a.f226a.getExternalFilesDir(null) + "/.logcache");
                file.mkdirs();
                if (file.isDirectory()) {
                    dc dcVar = new dc();
                    dcVar.a(this.a);
                    this.f234a = dcVar.a(this.f233a.f226a, this.f236a, this.f238b, file);
                }
            } catch (NullPointerException e) {
            }
        }
    }

    @Override // com.xiaomi.push.al.b
    /* renamed from: c */
    public void mo206c() {
        if (this.f234a != null && this.f234a.exists()) {
            this.f233a.f227a.add(new dd.c(this.f235a, this.b, this.f234a, this.f237a));
        }
        this.f233a.a(0L);
    }
}
