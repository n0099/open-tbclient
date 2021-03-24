package com.bytedance.sdk.openadsdk.preload.geckox.a.a;

import android.annotation.SuppressLint;
import java.io.File;
import java.util.List;
@SuppressLint({"CI_StaticFieldLeak"})
/* loaded from: classes6.dex */
public abstract class b {

    /* renamed from: a  reason: collision with root package name */
    public static final b f30202a = new d();

    /* renamed from: b  reason: collision with root package name */
    public static final b f30203b = new f();

    /* renamed from: c  reason: collision with root package name */
    public static final b f30204c = new e();

    /* renamed from: d  reason: collision with root package name */
    public a f30205d;

    /* renamed from: e  reason: collision with root package name */
    public File f30206e;

    /* renamed from: f  reason: collision with root package name */
    public List<String> f30207f;

    public abstract void a();

    public void a(a aVar, File file, List<String> list) {
        this.f30205d = aVar;
        this.f30206e = file;
        this.f30207f = list;
    }
}
