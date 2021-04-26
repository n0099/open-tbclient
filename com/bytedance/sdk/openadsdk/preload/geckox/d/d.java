package com.bytedance.sdk.openadsdk.preload.geckox.d;

import android.util.Pair;
import com.bytedance.sdk.openadsdk.preload.geckox.utils.k;
import java.io.File;
import java.util.ArrayList;
import java.util.List;
/* loaded from: classes5.dex */
public class d extends com.bytedance.sdk.openadsdk.preload.b.d<List<String>, List<Pair<String, Long>>> {

    /* renamed from: d  reason: collision with root package name */
    public File f30877d;

    /* renamed from: e  reason: collision with root package name */
    public String f30878e;

    @Override // com.bytedance.sdk.openadsdk.preload.b.d
    public void a(Object... objArr) {
        super.a(objArr);
        this.f30877d = (File) objArr[0];
        this.f30878e = (String) objArr[1];
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.bytedance.sdk.openadsdk.preload.b.d
    /* renamed from: a */
    public Object a_(com.bytedance.sdk.openadsdk.preload.b.b<List<Pair<String, Long>>> bVar, List<String> list) throws Exception {
        com.bytedance.sdk.openadsdk.preload.geckox.h.b.a("gecko-debug-tag", "get local channel version:", list);
        File file = new File(this.f30877d, this.f30878e);
        ArrayList arrayList = new ArrayList();
        for (String str : list) {
            Long a2 = k.a(new File(file, str));
            arrayList.add(new Pair<>(str, Long.valueOf(a2 == null ? 0L : a2.longValue())));
        }
        return bVar.a((com.bytedance.sdk.openadsdk.preload.b.b<List<Pair<String, Long>>>) arrayList);
    }
}
