package com.xiaomi.push;

import com.xiaomi.push.dd;
import java.io.File;
import java.util.Date;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes6.dex */
public class de extends dd.b {
    final /* synthetic */ int a;

    /* renamed from: a  reason: collision with other field name */
    final /* synthetic */ dd f231a;

    /* renamed from: a  reason: collision with other field name */
    File f232a;

    /* renamed from: a  reason: collision with other field name */
    final /* synthetic */ String f233a;

    /* renamed from: a  reason: collision with other field name */
    final /* synthetic */ Date f234a;

    /* renamed from: a  reason: collision with other field name */
    final /* synthetic */ boolean f235a;
    final /* synthetic */ String b;

    /* renamed from: b  reason: collision with other field name */
    final /* synthetic */ Date f236b;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public de(dd ddVar, int i, Date date, Date date2, String str, String str2, boolean z) {
        super();
        this.f231a = ddVar;
        this.a = i;
        this.f234a = date;
        this.f236b = date2;
        this.f233a = str;
        this.b = str2;
        this.f235a = z;
    }

    @Override // com.xiaomi.push.dd.b, com.xiaomi.push.al.b
    public void b() {
        if (aa.d()) {
            try {
                File file = new File(this.f231a.f224a.getExternalFilesDir(null) + "/.logcache");
                file.mkdirs();
                if (file.isDirectory()) {
                    dc dcVar = new dc();
                    dcVar.a(this.a);
                    this.f232a = dcVar.a(this.f231a.f224a, this.f234a, this.f236b, file);
                }
            } catch (NullPointerException e) {
            }
        }
    }

    @Override // com.xiaomi.push.al.b
    /* renamed from: c */
    public void mo215c() {
        if (this.f232a != null && this.f232a.exists()) {
            this.f231a.f225a.add(new dd.c(this.f233a, this.b, this.f232a, this.f235a));
        }
        this.f231a.a(0L);
    }
}
