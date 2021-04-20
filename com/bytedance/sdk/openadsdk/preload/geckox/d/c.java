package com.bytedance.sdk.openadsdk.preload.geckox.d;

import android.accounts.NetworkErrorException;
import android.content.Context;
import android.util.Pair;
import com.bytedance.sdk.openadsdk.preload.geckox.model.CheckRequestBodyModel;
import com.bytedance.sdk.openadsdk.preload.geckox.model.Common;
import com.bytedance.sdk.openadsdk.preload.geckox.model.ComponentModel;
import com.bytedance.sdk.openadsdk.preload.geckox.model.Response;
import com.bytedance.sdk.openadsdk.preload.geckox.model.UpdatePackage;
import java.io.File;
import java.io.FileFilter;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
/* loaded from: classes5.dex */
public class c extends com.bytedance.sdk.openadsdk.preload.b.d<Map<String, List<Pair<String, Long>>>, List<UpdatePackage>> {

    /* renamed from: d  reason: collision with root package name */
    public com.bytedance.sdk.openadsdk.preload.geckox.b f29944d;

    /* renamed from: e  reason: collision with root package name */
    public Map<String, Map<String, Object>> f29945e;

    /* renamed from: f  reason: collision with root package name */
    public Map<String, List<CheckRequestBodyModel.TargetChannel>> f29946f;

    /* renamed from: g  reason: collision with root package name */
    public com.bytedance.sdk.openadsdk.preload.geckox.e.a f29947g;

    /* renamed from: h  reason: collision with root package name */
    public String f29948h;
    public com.bytedance.sdk.openadsdk.preload.geckox.statistic.model.b i = new com.bytedance.sdk.openadsdk.preload.geckox.statistic.model.b();

    /* loaded from: classes5.dex */
    public static class a extends RuntimeException {
        public a(String str) {
            super(str);
        }
    }

    /* loaded from: classes5.dex */
    public static class b extends RuntimeException {
        public b(String str, Throwable th) {
            super(str, th);
        }
    }

    /* renamed from: com.bytedance.sdk.openadsdk.preload.geckox.d.c$c  reason: collision with other inner class name */
    /* loaded from: classes5.dex */
    public static class C0337c extends RuntimeException {
        public C0337c(String str, Throwable th) {
            super(str, th);
        }
    }

    private void b(List<Pair<String, com.bytedance.sdk.openadsdk.preload.geckox.g.a>> list) {
        if (list == null) {
            return;
        }
        for (Pair<String, com.bytedance.sdk.openadsdk.preload.geckox.g.a> pair : list) {
            try {
                ((com.bytedance.sdk.openadsdk.preload.geckox.g.a) pair.second).a();
            } catch (Exception e2) {
                com.bytedance.sdk.openadsdk.preload.geckox.h.b.b("gecko-debug-tag", "releaseLock:", e2);
            }
        }
    }

    private List<Pair<String, com.bytedance.sdk.openadsdk.preload.geckox.g.a>> c(List<UpdatePackage> list) {
        if (list != null && !list.isEmpty()) {
            ArrayList arrayList = new ArrayList();
            ArrayList arrayList2 = new ArrayList();
            for (UpdatePackage updatePackage : list) {
                try {
                    File file = new File(new File(this.f29944d.m(), updatePackage.getAccessKey()), updatePackage.getChannel());
                    if (file.isFile()) {
                        com.bytedance.sdk.openadsdk.preload.geckox.utils.d.a(file);
                    }
                    if (!file.mkdirs() && !file.isDirectory()) {
                        com.bytedance.sdk.openadsdk.preload.geckox.h.b.a("gecko-debug-tag", "can not create channel dir：", file.getAbsolutePath());
                        throw new RuntimeException("can not create channel dir:" + file.getAbsolutePath());
                        break;
                    }
                    com.bytedance.sdk.openadsdk.preload.geckox.g.a a2 = com.bytedance.sdk.openadsdk.preload.geckox.g.a.a(file.getAbsolutePath() + File.separator + "update.lock");
                    if (a2 != null) {
                        arrayList.add(new Pair(updatePackage.getChannel(), a2));
                        arrayList2.add(updatePackage);
                    } else {
                        a(this.f29947g, updatePackage.getChannel());
                    }
                } catch (Exception e2) {
                    com.bytedance.sdk.openadsdk.preload.geckox.h.b.b("gecko-debug-tag", "filterChannel:", e2);
                    a(updatePackage.getChannel(), this.f29947g, e2);
                }
            }
            list.clear();
            list.addAll(arrayList2);
            return arrayList;
        }
        return Collections.emptyList();
    }

    @Override // com.bytedance.sdk.openadsdk.preload.b.d
    public void a(Object... objArr) {
        super.a(objArr);
        this.f29944d = (com.bytedance.sdk.openadsdk.preload.geckox.b) objArr[0];
        this.f29945e = (Map) objArr[1];
        this.f29946f = (Map) objArr[2];
        this.f29947g = (com.bytedance.sdk.openadsdk.preload.geckox.e.a) objArr[3];
        this.f29948h = (String) objArr[4];
    }

    private Map<String, List<UpdatePackage>> b(Map<String, List<Pair<String, Long>>> map) throws Exception {
        String c2 = c(map);
        String str = "https://" + this.f29944d.i() + "/gecko/server/v3/package";
        try {
            this.i.f30024f = com.bytedance.sdk.openadsdk.preload.geckox.utils.i.a(this.f29944d.a());
            com.bytedance.sdk.openadsdk.preload.geckox.i.c a2 = this.f29944d.h().a(str, c2);
            this.i.f30025g = a2.f29986c;
            this.i.f30022d = a2.f29987d;
            this.i.f30023e = com.bytedance.sdk.openadsdk.preload.geckox.statistic.model.b.a(a2.f29984a);
            if (a2.f29986c == 200) {
                String str2 = a2.f29985b;
                com.bytedance.sdk.openadsdk.preload.geckox.h.b.a("gecko-debug-tag", "response:", str2);
                try {
                    Response response = (Response) com.bytedance.sdk.openadsdk.preload.geckox.c.b.a().b().a(str2, new com.bytedance.sdk.openadsdk.preload.a.c.a<Response<ComponentModel>>() { // from class: com.bytedance.sdk.openadsdk.preload.geckox.d.c.3
                    }.b());
                    int i = response.status;
                    if (i == 0) {
                        if (response.data != 0) {
                            com.bytedance.sdk.openadsdk.preload.geckox.a.a.a(this.f29944d.a(), ((ComponentModel) response.data).getUniversalStrategies(), this.f29944d.m(), this.f29947g);
                            Map<String, List<UpdatePackage>> packages = ((ComponentModel) response.data).getPackages();
                            if (packages != null && !packages.isEmpty()) {
                                for (String str3 : this.f29944d.e()) {
                                    List<UpdatePackage> list = packages.get(str3);
                                    if (list != null && !list.isEmpty()) {
                                        for (UpdatePackage updatePackage : list) {
                                            updatePackage.setAccessKey(str3);
                                            updatePackage.setLocalVersion(a(map.get(str3), updatePackage.getChannel()));
                                        }
                                    }
                                }
                                return packages;
                            }
                            com.bytedance.sdk.openadsdk.preload.geckox.a.a.a(this.f29944d);
                            return new HashMap();
                        } else {
                            com.bytedance.sdk.openadsdk.preload.geckox.statistic.model.b bVar = this.i;
                            bVar.f30022d = "check update error：response.data==null";
                            com.bytedance.sdk.openadsdk.preload.geckox.statistic.e.a(this.f29944d, bVar);
                            throw new a("check update error：response.data==null");
                        }
                    }
                    if (i == 2000) {
                        com.bytedance.sdk.openadsdk.preload.geckox.a.a.a(this.f29944d);
                        return new HashMap();
                    }
                    String str4 = "check update error，unknow status code，response.status：" + response.status;
                    com.bytedance.sdk.openadsdk.preload.geckox.statistic.model.b bVar2 = this.i;
                    bVar2.f30022d = str4;
                    com.bytedance.sdk.openadsdk.preload.geckox.statistic.e.a(this.f29944d, bVar2);
                    throw new a(str4);
                } catch (Exception e2) {
                    this.i.f30022d = "json parse failed：" + e2.getMessage();
                    com.bytedance.sdk.openadsdk.preload.geckox.statistic.e.a(this.f29944d, this.i);
                    throw new b("json parse failed：" + str2 + " caused by:" + e2.getMessage(), e2);
                }
            }
            throw new NetworkErrorException("net work get failed, code: " + a2.f29986c + ", url:" + str);
        } catch (Exception e3) {
            com.bytedance.sdk.openadsdk.preload.geckox.statistic.e.a(this.f29944d, this.i);
            throw new C0337c("request failed：url:" + str + ", caused by:" + e3.getMessage(), e3);
        }
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.bytedance.sdk.openadsdk.preload.b.d
    /* renamed from: a */
    public Object a_(com.bytedance.sdk.openadsdk.preload.b.b<List<UpdatePackage>> bVar, Map<String, List<Pair<String, Long>>> map) throws Throwable {
        List<Pair<String, com.bytedance.sdk.openadsdk.preload.geckox.g.a>> list;
        com.bytedance.sdk.openadsdk.preload.geckox.h.b.a("gecko-debug-tag", "start get server channel version[v3]... local channel version:", map);
        Map<String, List<UpdatePackage>> b2 = b(map);
        com.bytedance.sdk.openadsdk.preload.geckox.statistic.e.a(this.f29944d, this.i);
        a(b2);
        ArrayList arrayList = new ArrayList();
        for (Map.Entry<String, List<UpdatePackage>> entry : b2.entrySet()) {
            arrayList.addAll(entry.getValue());
        }
        Object obj = null;
        try {
            list = c(arrayList);
            try {
                obj = bVar.a((com.bytedance.sdk.openadsdk.preload.b.b<List<UpdatePackage>>) arrayList);
                b(list);
                com.bytedance.sdk.openadsdk.preload.geckox.h.b.a("gecko-debug-tag", "all channel update finished");
            } catch (Throwable th) {
                th = th;
                try {
                    com.bytedance.sdk.openadsdk.preload.geckox.h.b.b("gecko-debug-tag", "filterChannel:", th);
                    b(list);
                    com.bytedance.sdk.openadsdk.preload.geckox.h.b.a("gecko-debug-tag", "all channel update finished");
                    a(arrayList);
                    return obj;
                } catch (Throwable th2) {
                    b(list);
                    com.bytedance.sdk.openadsdk.preload.geckox.h.b.a("gecko-debug-tag", "all channel update finished");
                    throw th2;
                }
            }
        } catch (Throwable th3) {
            th = th3;
            list = null;
        }
        a(arrayList);
        return obj;
    }

    private String c(Map<String, List<Pair<String, Long>>> map) {
        List<CheckRequestBodyModel.TargetChannel> list;
        CheckRequestBodyModel checkRequestBodyModel = new CheckRequestBodyModel();
        Context a2 = this.f29944d.a();
        checkRequestBodyModel.setCommon(new Common(this.f29944d.j(), this.f29944d.n(), this.f29944d.q(), com.bytedance.sdk.openadsdk.preload.geckox.utils.a.b(a2), com.bytedance.sdk.openadsdk.preload.geckox.utils.i.a(a2), this.f29944d.k(), this.f29944d.l()));
        HashMap hashMap = new HashMap();
        for (Map.Entry<String, List<Pair<String, Long>>> entry : map.entrySet()) {
            HashMap hashMap2 = new HashMap();
            for (Pair<String, Long> pair : entry.getValue()) {
                CheckRequestBodyModel.LocalChannel localChannel = new CheckRequestBodyModel.LocalChannel();
                localChannel.localVersion = (Long) pair.second;
                hashMap2.put(pair.first, localChannel);
            }
            hashMap.put(entry.getKey(), hashMap2);
        }
        this.i.f30019a = com.bytedance.sdk.openadsdk.preload.geckox.c.b.a().b().a(hashMap);
        checkRequestBodyModel.setLocal(hashMap);
        HashMap hashMap3 = new HashMap();
        for (String str : this.f29944d.e()) {
            CheckRequestBodyModel.Group group = new CheckRequestBodyModel.Group();
            group.groupName = this.f29948h;
            Map<String, List<CheckRequestBodyModel.TargetChannel>> map2 = this.f29946f;
            if (map2 != null && !map2.isEmpty() && (list = this.f29946f.get(str)) != null && !list.isEmpty()) {
                ArrayList arrayList = new ArrayList();
                group.targetChannels = arrayList;
                arrayList.addAll(list);
            }
            hashMap3.put(str, group);
        }
        this.i.f30020b = com.bytedance.sdk.openadsdk.preload.geckox.c.b.a().b().a(hashMap3);
        checkRequestBodyModel.setDeployments(hashMap3);
        if (this.f29945e != null) {
            this.i.f30021c = com.bytedance.sdk.openadsdk.preload.geckox.c.b.a().b().a(this.f29945e);
            checkRequestBodyModel.setCustom(this.f29945e);
        }
        return com.bytedance.sdk.openadsdk.preload.geckox.c.b.a().b().a(checkRequestBodyModel);
    }

    private void a(List<UpdatePackage> list) {
        if (list == null || list.isEmpty()) {
            return;
        }
        for (UpdatePackage updatePackage : list) {
            com.bytedance.sdk.openadsdk.preload.geckox.a.c.a(new File(new File(this.f29944d.m(), updatePackage.getAccessKey()), updatePackage.getChannel()).getAbsolutePath());
        }
    }

    private void a(com.bytedance.sdk.openadsdk.preload.geckox.e.a aVar, String str) {
        if (aVar == null) {
            return;
        }
        try {
            aVar.a(str);
        } catch (Throwable th) {
            com.bytedance.sdk.openadsdk.preload.geckox.h.b.a("gecko-debug-tag", "onUpdating:", th);
        }
    }

    private void a(String str, com.bytedance.sdk.openadsdk.preload.geckox.e.a aVar, Exception exc) {
        if (aVar == null) {
            return;
        }
        try {
            aVar.a(str, exc);
        } catch (Throwable th) {
            com.bytedance.sdk.openadsdk.preload.geckox.h.b.a("gecko-debug-tag", "onUpdateFailed:", th);
        }
    }

    private void a(Map<String, List<UpdatePackage>> map) {
        for (Map.Entry<String, List<UpdatePackage>> entry : map.entrySet()) {
            Iterator<UpdatePackage> it = entry.getValue().iterator();
            while (it.hasNext()) {
                UpdatePackage next = it.next();
                long localVersion = next.getLocalVersion();
                long version = next.getVersion();
                if (version < localVersion) {
                    a(it, next, localVersion, version);
                }
            }
        }
    }

    private void a(Iterator<UpdatePackage> it, UpdatePackage updatePackage, long j, long j2) {
        com.bytedance.sdk.openadsdk.preload.geckox.h.b.a("gecko-debug-tag", updatePackage.getChannel(), "rollback：", Long.valueOf(j), "->", Long.valueOf(j2));
        File[] listFiles = new File(this.f29944d.m(), updatePackage.getAccessKey() + File.separator + updatePackage.getChannel()).listFiles(new FileFilter() { // from class: com.bytedance.sdk.openadsdk.preload.geckox.d.c.1
            @Override // java.io.FileFilter
            public boolean accept(File file) {
                return file.isDirectory();
            }
        });
        if (listFiles == null || listFiles.length == 0) {
            return;
        }
        for (File file : listFiles) {
            try {
                int i = (Long.parseLong(file.getName()) > j2 ? 1 : (Long.parseLong(file.getName()) == j2 ? 0 : -1));
                if (i > 0) {
                    final File file2 = new File(file.getParent(), file.getName() + "--pending-delete");
                    file.renameTo(file2);
                    com.bytedance.sdk.openadsdk.preload.geckox.utils.f.a().execute(new Runnable() { // from class: com.bytedance.sdk.openadsdk.preload.geckox.d.c.2
                        @Override // java.lang.Runnable
                        public void run() {
                            com.bytedance.sdk.openadsdk.preload.geckox.utils.d.a(file2);
                        }
                    });
                } else if (i == 0) {
                    it.remove();
                }
            } catch (Exception unused) {
            }
        }
    }

    private long a(List<Pair<String, Long>> list, String str) {
        for (Pair<String, Long> pair : list) {
            if (((String) pair.first).equals(str)) {
                return ((Long) pair.second).longValue();
            }
        }
        return 0L;
    }
}
