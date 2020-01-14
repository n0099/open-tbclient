package com.xiaomi.push;

import com.xiaomi.push.dd;
import java.io.File;
import java.util.Date;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes6.dex */
public class de extends dd.b {
    final /* synthetic */ int a;

    /* renamed from: a  reason: collision with other field name */
    final /* synthetic */ dd f232a;

    /* renamed from: a  reason: collision with other field name */
    File f233a;

    /* renamed from: a  reason: collision with other field name */
    final /* synthetic */ String f234a;

    /* renamed from: a  reason: collision with other field name */
    final /* synthetic */ Date f235a;

    /* renamed from: a  reason: collision with other field name */
    final /* synthetic */ boolean f236a;
    final /* synthetic */ String b;

    /* renamed from: b  reason: collision with other field name */
    final /* synthetic */ Date f237b;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public de(dd ddVar, int i, Date date, Date date2, String str, String str2, boolean z) {
        super();
        this.f232a = ddVar;
        this.a = i;
        this.f235a = date;
        this.f237b = date2;
        this.f234a = str;
        this.b = str2;
        this.f236a = z;
    }

    @Override // com.xiaomi.push.dd.b, com.xiaomi.push.al.b
    public void b() {
        if (aa.d()) {
            try {
                File file = new File(this.f232a.f225a.getExternalFilesDir(null) + "/.logcache");
                file.mkdirs();
                if (file.isDirectory()) {
                    dc dcVar = new dc();
                    dcVar.a(this.a);
                    this.f233a = dcVar.a(this.f232a.f225a, this.f235a, this.f237b, file);
                }
            } catch (NullPointerException e) {
            }
        }
    }

    @Override // com.xiaomi.push.al.b
    /* renamed from: c */
    public void mo215c() {
        if (this.f233a != null && this.f233a.exists()) {
            this.f232a.f226a.add(new dd.c(this.f234a, this.b, this.f233a, this.f236a));
        }
        this.f232a.a(0L);
    }
}
