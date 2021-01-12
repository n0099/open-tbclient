package com.bytedance.sdk.openadsdk.preload.geckox.a.a;

import android.annotation.SuppressLint;
import java.io.File;
import java.util.List;
@SuppressLint({"CI_StaticFieldLeak"})
/* loaded from: classes4.dex */
public abstract class b {

    /* renamed from: a  reason: collision with root package name */
    public static final b f7446a = new d();

    /* renamed from: b  reason: collision with root package name */
    public static final b f7447b = new f();
    public static final b c = new e();
    protected a d;
    protected File e;
    protected List<String> f;

    public abstract void a();

    public void a(a aVar, File file, List<String> list) {
        this.d = aVar;
        this.e = file;
        this.f = list;
    }
}
