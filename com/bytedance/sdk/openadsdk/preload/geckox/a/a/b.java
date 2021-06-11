package com.bytedance.sdk.openadsdk.preload.geckox.a.a;

import android.annotation.SuppressLint;
import java.io.File;
import java.util.List;
@SuppressLint({"CI_StaticFieldLeak"})
/* loaded from: classes6.dex */
public abstract class b {

    /* renamed from: a  reason: collision with root package name */
    public static final b f30086a = new d();

    /* renamed from: b  reason: collision with root package name */
    public static final b f30087b = new f();

    /* renamed from: c  reason: collision with root package name */
    public static final b f30088c = new e();

    /* renamed from: d  reason: collision with root package name */
    public a f30089d;

    /* renamed from: e  reason: collision with root package name */
    public File f30090e;

    /* renamed from: f  reason: collision with root package name */
    public List<String> f30091f;

    public abstract void a();

    public void a(a aVar, File file, List<String> list) {
        this.f30089d = aVar;
        this.f30090e = file;
        this.f30091f = list;
    }
}
