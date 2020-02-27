package com.xiaomi.push;

import com.xiaomi.push.dd;
import java.io.File;
import java.util.Date;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes8.dex */
public class de extends dd.b {
    final /* synthetic */ int a;

    /* renamed from: a  reason: collision with other field name */
    final /* synthetic */ dd f229a;

    /* renamed from: a  reason: collision with other field name */
    File f230a;

    /* renamed from: a  reason: collision with other field name */
    final /* synthetic */ String f231a;

    /* renamed from: a  reason: collision with other field name */
    final /* synthetic */ Date f232a;

    /* renamed from: a  reason: collision with other field name */
    final /* synthetic */ boolean f233a;
    final /* synthetic */ String b;

    /* renamed from: b  reason: collision with other field name */
    final /* synthetic */ Date f234b;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public de(dd ddVar, int i, Date date, Date date2, String str, String str2, boolean z) {
        super();
        this.f229a = ddVar;
        this.a = i;
        this.f232a = date;
        this.f234b = date2;
        this.f231a = str;
        this.b = str2;
        this.f233a = z;
    }

    @Override // com.xiaomi.push.dd.b, com.xiaomi.push.al.b
    public void b() {
        if (aa.d()) {
            try {
                File file = new File(this.f229a.f222a.getExternalFilesDir(null) + "/.logcache");
                file.mkdirs();
                if (file.isDirectory()) {
                    dc dcVar = new dc();
                    dcVar.a(this.a);
                    this.f230a = dcVar.a(this.f229a.f222a, this.f232a, this.f234b, file);
                }
            } catch (NullPointerException e) {
            }
        }
    }

    @Override // com.xiaomi.push.al.b
    /* renamed from: c */
    public void mo220c() {
        if (this.f230a != null && this.f230a.exists()) {
            this.f229a.f223a.add(new dd.c(this.f231a, this.b, this.f230a, this.f233a));
        }
        this.f229a.a(0L);
    }
}
