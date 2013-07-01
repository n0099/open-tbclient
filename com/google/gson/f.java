package com.google.gson;

import java.util.HashMap;
import java.util.Map;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class f extends ThreadLocal {

    /* renamed from: a  reason: collision with root package name */
    final /* synthetic */ e f1614a;

    /* JADX INFO: Access modifiers changed from: package-private */
    public f(e eVar) {
        this.f1614a = eVar;
    }

    /* JADX DEBUG: Method merged with bridge method */
    /* JADX INFO: Access modifiers changed from: protected */
    @Override // java.lang.ThreadLocal
    /* renamed from: a */
    public Map initialValue() {
        return new HashMap();
    }
}
