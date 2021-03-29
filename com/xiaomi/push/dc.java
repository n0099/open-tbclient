package com.xiaomi.push;

import com.xiaomi.push.db;
import java.io.File;
import java.util.Date;
/* loaded from: classes7.dex */
public class dc extends db.b {

    /* renamed from: a  reason: collision with root package name */
    public final /* synthetic */ int f40354a;

    /* renamed from: a  reason: collision with other field name */
    public final /* synthetic */ db f221a;

    /* renamed from: a  reason: collision with other field name */
    public File f222a;

    /* renamed from: a  reason: collision with other field name */
    public final /* synthetic */ String f223a;

    /* renamed from: a  reason: collision with other field name */
    public final /* synthetic */ Date f224a;

    /* renamed from: a  reason: collision with other field name */
    public final /* synthetic */ boolean f225a;

    /* renamed from: b  reason: collision with root package name */
    public final /* synthetic */ String f40355b;

    /* renamed from: b  reason: collision with other field name */
    public final /* synthetic */ Date f226b;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public dc(db dbVar, int i, Date date, Date date2, String str, String str2, boolean z) {
        super();
        this.f221a = dbVar;
        this.f40354a = i;
        this.f224a = date;
        this.f226b = date2;
        this.f223a = str;
        this.f40355b = str2;
        this.f225a = z;
    }

    @Override // com.xiaomi.push.db.b, com.xiaomi.push.al.b
    public void b() {
        if (aa.d()) {
            try {
                File file = new File(this.f221a.f214a.getExternalFilesDir(null) + "/.logcache");
                file.mkdirs();
                if (file.isDirectory()) {
                    da daVar = new da();
                    daVar.a(this.f40354a);
                    this.f222a = daVar.a(this.f221a.f214a, this.f224a, this.f226b, file);
                }
            } catch (NullPointerException unused) {
            }
        }
    }

    @Override // com.xiaomi.push.al.b
    /* renamed from: c */
    public void mo223c() {
        File file = this.f222a;
        if (file != null && file.exists()) {
            this.f221a.f215a.add(new db.c(this.f223a, this.f40355b, this.f222a, this.f225a));
        }
        this.f221a.a(0L);
    }
}
