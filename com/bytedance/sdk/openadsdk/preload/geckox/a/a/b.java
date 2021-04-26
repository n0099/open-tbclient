package com.bytedance.sdk.openadsdk.preload.geckox.a.a;

import android.annotation.SuppressLint;
import java.io.File;
import java.util.List;
@SuppressLint({"CI_StaticFieldLeak"})
/* loaded from: classes5.dex */
public abstract class b {

    /* renamed from: a  reason: collision with root package name */
    public static final b f30809a = new d();

    /* renamed from: b  reason: collision with root package name */
    public static final b f30810b = new f();

    /* renamed from: c  reason: collision with root package name */
    public static final b f30811c = new e();

    /* renamed from: d  reason: collision with root package name */
    public a f30812d;

    /* renamed from: e  reason: collision with root package name */
    public File f30813e;

    /* renamed from: f  reason: collision with root package name */
    public List<String> f30814f;

    public abstract void a();

    public void a(a aVar, File file, List<String> list) {
        this.f30812d = aVar;
        this.f30813e = file;
        this.f30814f = list;
    }
}
