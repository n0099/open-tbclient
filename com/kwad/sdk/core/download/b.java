package com.kwad.sdk.core.download;

import android.content.Context;
import android.text.TextUtils;
import com.kwad.sdk.DownloadTask;
import com.kwad.sdk.core.response.model.AdTemplate;
import com.kwad.sdk.utils.LruHashMap;
import com.kwad.sdk.utils.ad;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.WeakHashMap;
/* loaded from: classes10.dex */
public final class b {
    public static final Map<String, Integer> asi = Collections.synchronizedMap(new LruHashMap(10));
    public static final Map<String, String> asj = new LruHashMap(10);
    public final WeakHashMap<c, AdTemplate> asg;
    public final Map<c, AdTemplate> ash;
    public final com.kwad.sdk.b.a ask;
    public volatile boolean mHasInit;

    /* loaded from: classes10.dex */
    public static final class a {
        public static final b ass = new b((byte) 0);
    }

    public b() {
        WeakHashMap<c, AdTemplate> weakHashMap = new WeakHashMap<>();
        this.asg = weakHashMap;
        this.ash = Collections.synchronizedMap(weakHashMap);
        this.mHasInit = false;
        this.ask = new com.kwad.sdk.b.a() { // from class: com.kwad.sdk.core.download.b.6
            @Override // com.kwad.sdk.b.a
            public final void N(String str) {
                b.this.di(str);
            }

            @Override // com.kwad.sdk.b.a
            public final void O(String str) {
                b.this.cb(str);
            }
        };
    }

    public static b BU() {
        return a.ass;
    }

    public final List<AdTemplate> yj() {
        ArrayList arrayList = new ArrayList();
        synchronized (this.ash) {
            for (AdTemplate adTemplate : this.ash.values()) {
                if (adTemplate != null) {
                    arrayList.add(adTemplate);
                }
            }
        }
        return arrayList;
    }

    public /* synthetic */ b(byte b) {
        this();
    }

    private void N(final String str) {
        final e eVar = new e();
        b(str, new com.kwad.sdk.g.a<c>() { // from class: com.kwad.sdk.core.download.b.2
            /* JADX DEBUG: Method merged with bridge method */
            /* JADX INFO: Access modifiers changed from: private */
            @Override // com.kwad.sdk.g.a
            /* renamed from: b */
            public void accept(c cVar) {
                String nN = cVar.nN();
                b.asi.put(nN, 12);
                cVar.b(nN, str, eVar);
            }
        });
    }

    private void O(final String str) {
        final e eVar = new e();
        b(str, new com.kwad.sdk.g.a<c>() { // from class: com.kwad.sdk.core.download.b.3
            /* JADX DEBUG: Method merged with bridge method */
            /* JADX INFO: Access modifiers changed from: private */
            @Override // com.kwad.sdk.g.a
            /* renamed from: b */
            public void accept(c cVar) {
                String nN = cVar.nN();
                b.asi.put(nN, 0);
                cVar.f(nN, eVar);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void cb(String str) {
        if (TextUtils.isEmpty(str)) {
            return;
        }
        O(str);
    }

    public static int db(String str) {
        Integer num;
        if (!TextUtils.isEmpty(str) && (num = asi.get(str)) != null) {
            return num.intValue();
        }
        return 0;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void di(String str) {
        if (TextUtils.isEmpty(str)) {
            return;
        }
        N(str);
        com.kwad.sdk.d xC = com.kwad.sdk.c.xA().xC();
        if (xC != null) {
            xC.bM(str);
        }
    }

    public final void a(c cVar) {
        this.ash.remove(cVar);
    }

    public final synchronized void aW(Context context) {
        if (this.mHasInit && context != null) {
            com.kwad.sdk.b.b.zt().b(this.ask);
            this.ash.clear();
            this.mHasInit = false;
        }
    }

    public final void dc(final String str) {
        asi.put(str, 1);
        final e eVar = new e();
        a(str, new com.kwad.sdk.g.a<c>() { // from class: com.kwad.sdk.core.download.b.7
            /* JADX DEBUG: Method merged with bridge method */
            /* JADX INFO: Access modifiers changed from: private */
            @Override // com.kwad.sdk.g.a
            /* renamed from: b */
            public void accept(c cVar) {
                cVar.a(str, eVar);
            }
        });
    }

    public final void dd(final String str) {
        final e eVar = new e();
        asi.put(str, 4);
        a(str, new com.kwad.sdk.g.a<c>() { // from class: com.kwad.sdk.core.download.b.11
            /* JADX DEBUG: Method merged with bridge method */
            /* JADX INFO: Access modifiers changed from: private */
            @Override // com.kwad.sdk.g.a
            /* renamed from: b */
            public void accept(c cVar) {
                cVar.b(str, eVar);
            }
        });
    }

    public final void de(final String str) {
        final e eVar = new e();
        asi.put(str, 1);
        a(str, new com.kwad.sdk.g.a<c>() { // from class: com.kwad.sdk.core.download.b.12
            /* JADX DEBUG: Method merged with bridge method */
            /* JADX INFO: Access modifiers changed from: private */
            @Override // com.kwad.sdk.g.a
            /* renamed from: b */
            public void accept(c cVar) {
                cVar.c(str, eVar);
            }
        });
    }

    public final void df(final String str) {
        final e eVar = new e();
        asi.put(str, 5);
        a(str, new com.kwad.sdk.g.a<c>() { // from class: com.kwad.sdk.core.download.b.13
            /* JADX DEBUG: Method merged with bridge method */
            /* JADX INFO: Access modifiers changed from: private */
            @Override // com.kwad.sdk.g.a
            /* renamed from: b */
            public void accept(c cVar) {
                cVar.d(str, eVar);
            }
        });
    }

    public final void dg(final String str) {
        final e eVar = new e();
        asi.put(str, 9);
        a(str, new com.kwad.sdk.g.a<c>() { // from class: com.kwad.sdk.core.download.b.14
            /* JADX DEBUG: Method merged with bridge method */
            /* JADX INFO: Access modifiers changed from: private */
            @Override // com.kwad.sdk.g.a
            /* renamed from: b */
            public void accept(c cVar) {
                cVar.e(str, eVar);
            }
        });
    }

    public final void dh(final String str) {
        final e eVar = new e();
        a(str, new com.kwad.sdk.g.a<c>() { // from class: com.kwad.sdk.core.download.b.5
            /* JADX DEBUG: Method merged with bridge method */
            /* JADX INFO: Access modifiers changed from: private */
            @Override // com.kwad.sdk.g.a
            /* renamed from: b */
            public void accept(c cVar) {
                cVar.g(str, eVar);
            }
        });
    }

    public final synchronized void init(Context context) {
        if (!this.mHasInit && context != null) {
            com.kwad.sdk.c.xA().a(new com.kwad.sdk.b() { // from class: com.kwad.sdk.core.download.b.1
                public static String l(DownloadTask downloadTask) {
                    String url = downloadTask.getUrl();
                    String str = (String) b.asj.get(url);
                    if (TextUtils.isEmpty(str)) {
                        String bn = ad.bn(downloadTask.getUrl());
                        b.asj.put(url, bn);
                        return bn;
                    }
                    return str;
                }

                @Override // com.kwad.sdk.b, com.kwad.sdk.a
                public final void a(DownloadTask downloadTask) {
                    b.this.M(l(downloadTask), downloadTask.getTargetFilePath());
                }

                @Override // com.kwad.sdk.b, com.kwad.sdk.a
                public final void b(DownloadTask downloadTask) {
                    if (downloadTask.getSmallFileSoFarBytes() == 0) {
                        if (com.kwad.framework.a.a.mc.booleanValue()) {
                            com.kwad.sdk.core.e.c.d("DownloadStatusManager", "onDownloadStart(), id=" + l(downloadTask));
                        }
                        b.this.dc(l(downloadTask));
                    }
                }

                @Override // com.kwad.sdk.b, com.kwad.sdk.a
                public final void c(DownloadTask downloadTask) {
                    b.this.dd(l(downloadTask));
                }

                @Override // com.kwad.sdk.b, com.kwad.sdk.a
                public final void d(DownloadTask downloadTask) {
                    b.this.df(l(downloadTask));
                }

                @Override // com.kwad.sdk.b, com.kwad.sdk.a
                public final void e(DownloadTask downloadTask) {
                    b.this.de(l(downloadTask));
                }

                @Override // com.kwad.sdk.b, com.kwad.sdk.a
                public final void f(DownloadTask downloadTask) {
                    b.this.dh(l(downloadTask));
                }

                @Override // com.kwad.sdk.b, com.kwad.sdk.a
                public final void a(DownloadTask downloadTask, int i, int i2) {
                    int i3;
                    if (i2 > 0) {
                        i3 = (int) ((i * 100.0f) / i2);
                    } else {
                        i3 = 0;
                    }
                    b.this.a(l(downloadTask), i3, i, i2);
                }

                @Override // com.kwad.sdk.b, com.kwad.sdk.a
                public final void a(DownloadTask downloadTask, Throwable th) {
                    String str;
                    if (th != null && th.getStackTrace().length > 0) {
                        str = th.getMessage() + " @ " + th.getStackTrace()[0].getFileName() + th.getStackTrace()[0].getClassName() + th.getStackTrace()[0].getLineNumber();
                    } else {
                        str = "";
                    }
                    b.this.c(l(downloadTask), 0, str);
                }
            });
            com.kwad.sdk.b.b.zt().a(this.ask);
            this.mHasInit = true;
        }
    }

    public final void M(final String str, final String str2) {
        final e eVar = new e();
        asi.put(str, 8);
        a(str, new com.kwad.sdk.g.a<c>() { // from class: com.kwad.sdk.core.download.b.9
            /* JADX DEBUG: Method merged with bridge method */
            /* JADX INFO: Access modifiers changed from: private */
            @Override // com.kwad.sdk.g.a
            /* renamed from: b */
            public void accept(c cVar) {
                cVar.a(str, str2, eVar);
            }
        });
    }

    public final void f(final String str, final Throwable th) {
        final e eVar = new e();
        asi.put(str, 11);
        a(str, new com.kwad.sdk.g.a<c>() { // from class: com.kwad.sdk.core.download.b.4
            /* JADX DEBUG: Method merged with bridge method */
            /* JADX INFO: Access modifiers changed from: private */
            @Override // com.kwad.sdk.g.a
            /* renamed from: b */
            public void accept(c cVar) {
                cVar.a(str, th, eVar);
            }
        });
    }

    private void a(String str, com.kwad.sdk.g.a<c> aVar) {
        Set<c> keySet = this.ash.keySet();
        synchronized (this.ash) {
            for (c cVar : keySet) {
                if (cVar != null && TextUtils.equals(cVar.nN(), str)) {
                    try {
                        aVar.accept(cVar);
                    } catch (Exception e) {
                        com.kwad.sdk.core.e.c.printStackTrace(e);
                    }
                }
            }
        }
    }

    private void b(String str, com.kwad.sdk.g.a<c> aVar) {
        Set<c> keySet = this.ash.keySet();
        synchronized (this.ash) {
            for (c cVar : keySet) {
                if (cVar != null && TextUtils.equals(str, cVar.nO())) {
                    try {
                        aVar.accept(cVar);
                    } catch (Exception e) {
                        com.kwad.sdk.core.e.c.printStackTrace(e);
                    }
                }
            }
        }
    }

    public final void a(c cVar, AdTemplate adTemplate) {
        this.ash.put(cVar, adTemplate);
    }

    public final void a(final String str, final int i, final int i2, final int i3) {
        asi.put(str, 2);
        a(str, new com.kwad.sdk.g.a<c>() { // from class: com.kwad.sdk.core.download.b.8
            /* JADX DEBUG: Method merged with bridge method */
            /* JADX INFO: Access modifiers changed from: private */
            @Override // com.kwad.sdk.g.a
            /* renamed from: b */
            public void accept(c cVar) {
                cVar.a(str, i, i2, i3);
            }
        });
    }

    public final void c(final String str, int i, final String str2) {
        asi.put(str, 7);
        final e eVar = new e();
        a(str, new com.kwad.sdk.g.a<c>() { // from class: com.kwad.sdk.core.download.b.10
            /* JADX DEBUG: Method merged with bridge method */
            /* JADX INFO: Access modifiers changed from: private */
            @Override // com.kwad.sdk.g.a
            /* renamed from: b */
            public void accept(c cVar) {
                cVar.a(str, r3, str2, eVar);
            }
        });
    }
}
