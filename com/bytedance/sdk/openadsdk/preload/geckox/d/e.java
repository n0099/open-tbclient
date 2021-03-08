package com.bytedance.sdk.openadsdk.preload.geckox.d;

import android.util.Pair;
import com.bytedance.sdk.openadsdk.preload.geckox.utils.k;
import java.io.File;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
/* loaded from: classes6.dex */
public class e extends com.bytedance.sdk.openadsdk.preload.b.d<String, Map<String, List<Pair<String, Long>>>> {
    private File d;
    private List<String> e;

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.bytedance.sdk.openadsdk.preload.b.d
    public void a(Object... objArr) {
        super.a(objArr);
        this.d = (File) objArr[0];
        this.e = (List) objArr[1];
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.bytedance.sdk.openadsdk.preload.b.d
    /* renamed from: a */
    public Object a_(com.bytedance.sdk.openadsdk.preload.b.b<Map<String, List<Pair<String, Long>>>> bVar, String str) throws Exception {
        Long a2;
        com.bytedance.sdk.openadsdk.preload.geckox.h.b.a("gecko-debug-tag", "get local channel version:", str);
        HashMap hashMap = new HashMap();
        for (String str2 : this.e) {
            File file = new File(this.d, str2);
            String[] list = file.list();
            ArrayList arrayList = new ArrayList();
            if (list != null && list.length > 0) {
                for (String str3 : list) {
                    File file2 = new File(file, str3);
                    if (file2.isDirectory() && (a2 = k.a(file2)) != null) {
                        arrayList.add(new Pair<>(str3, a2));
                    }
                }
            }
            hashMap.put(str2, arrayList);
        }
        return bVar.a((com.bytedance.sdk.openadsdk.preload.b.b<Map<String, List<Pair<String, Long>>>>) hashMap);
    }
}
