package com.google.gson.internal.a;

import java.sql.Timestamp;
import java.util.Date;
/* loaded from: classes.dex */
class ao extends com.google.gson.aa {

    /* renamed from: a  reason: collision with root package name */
    final /* synthetic */ com.google.gson.aa f1620a;
    final /* synthetic */ an b;

    /* JADX INFO: Access modifiers changed from: package-private */
    public ao(an anVar, com.google.gson.aa aaVar) {
        this.b = anVar;
        this.f1620a = aaVar;
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.google.gson.aa
    /* renamed from: a */
    public Timestamp b(com.google.gson.stream.a aVar) {
        Date date = (Date) this.f1620a.b(aVar);
        if (date != null) {
            return new Timestamp(date.getTime());
        }
        return null;
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.google.gson.aa
    public void a(com.google.gson.stream.d dVar, Timestamp timestamp) {
        this.f1620a.a(dVar, timestamp);
    }
}
