package com.ss.android.socialbase.downloader.impls;

import android.text.TextUtils;
import android.util.SparseArray;
import com.ss.android.socialbase.downloader.constants.DownloadStatus;
import com.ss.android.socialbase.downloader.model.DownloadInfo;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
/* loaded from: classes7.dex */
public class k implements com.ss.android.socialbase.downloader.downloader.j {
    public final SparseArray<DownloadInfo> a = new SparseArray<>();

    /* renamed from: b  reason: collision with root package name */
    public final SparseArray<List<com.ss.android.socialbase.downloader.model.b>> f43429b = new SparseArray<>();

    /* renamed from: c  reason: collision with root package name */
    public final SparseArray<Map<Long, com.ss.android.socialbase.downloader.f.i>> f43430c = new SparseArray<>();

    public SparseArray<DownloadInfo> a() {
        return this.a;
    }

    @Override // com.ss.android.socialbase.downloader.downloader.j
    public void a(int i, int i2, int i3, int i4) {
    }

    @Override // com.ss.android.socialbase.downloader.downloader.j
    public synchronized DownloadInfo b(int i) {
        DownloadInfo downloadInfo;
        try {
            downloadInfo = this.a.get(i);
        } catch (Exception e2) {
            e2.printStackTrace();
            downloadInfo = null;
        }
        return downloadInfo;
    }

    @Override // com.ss.android.socialbase.downloader.downloader.j
    public void b(int i, List<com.ss.android.socialbase.downloader.model.b> list) {
    }

    @Override // com.ss.android.socialbase.downloader.downloader.j
    public void b(com.ss.android.socialbase.downloader.model.b bVar) {
    }

    @Override // com.ss.android.socialbase.downloader.downloader.j
    public synchronized List<DownloadInfo> c(String str) {
        if (TextUtils.isEmpty(str)) {
            return null;
        }
        if (this.a.size() == 0) {
            return null;
        }
        ArrayList arrayList = new ArrayList();
        for (int i = 0; i < this.a.size(); i++) {
            DownloadInfo downloadInfo = this.a.get(this.a.keyAt(i));
            if (downloadInfo != null && !TextUtils.isEmpty(downloadInfo.getMimeType()) && downloadInfo.getMimeType().equals(str) && downloadInfo.getStatus() == -3) {
                arrayList.add(downloadInfo);
            }
        }
        return arrayList;
    }

    @Override // com.ss.android.socialbase.downloader.downloader.j
    public synchronized List<DownloadInfo> d(String str) {
        if (TextUtils.isEmpty(str)) {
            return null;
        }
        if (this.a.size() == 0) {
            return null;
        }
        ArrayList arrayList = new ArrayList();
        for (int i = 0; i < this.a.size(); i++) {
            DownloadInfo downloadInfo = this.a.get(this.a.keyAt(i));
            if (downloadInfo != null && !TextUtils.isEmpty(downloadInfo.getMimeType()) && downloadInfo.getMimeType().equals(str) && DownloadStatus.isUnCompletedStatus(downloadInfo.getStatus())) {
                arrayList.add(downloadInfo);
            }
        }
        return arrayList;
    }

    @Override // com.ss.android.socialbase.downloader.downloader.j
    public boolean d() {
        return false;
    }

    @Override // com.ss.android.socialbase.downloader.downloader.j
    public boolean e() {
        return false;
    }

    @Override // com.ss.android.socialbase.downloader.downloader.j
    public synchronized boolean e(int i) {
        this.a.remove(i);
        return true;
    }

    public SparseArray<List<com.ss.android.socialbase.downloader.model.b>> f() {
        return this.f43429b;
    }

    @Override // com.ss.android.socialbase.downloader.downloader.j
    public DownloadInfo g(int i) {
        DownloadInfo b2 = b(i);
        if (b2 != null) {
            b2.setStatus(2);
        }
        return b2;
    }

    @Override // com.ss.android.socialbase.downloader.downloader.j
    public DownloadInfo h(int i) {
        DownloadInfo b2 = b(i);
        if (b2 != null) {
            b2.setStatus(5);
            b2.setFirstDownload(false);
        }
        return b2;
    }

    @Override // com.ss.android.socialbase.downloader.downloader.j
    public DownloadInfo i(int i) {
        DownloadInfo b2 = b(i);
        if (b2 != null) {
            b2.setStatus(1);
        }
        return b2;
    }

    @Override // com.ss.android.socialbase.downloader.downloader.j
    public DownloadInfo j(int i) {
        DownloadInfo b2 = b(i);
        if (b2 != null) {
            b2.setStatus(-7);
        }
        return b2;
    }

    @Override // com.ss.android.socialbase.downloader.downloader.j
    public synchronized Map<Long, com.ss.android.socialbase.downloader.f.i> l(int i) {
        return this.f43430c.get(i);
    }

    @Override // com.ss.android.socialbase.downloader.downloader.j
    public synchronized void m(int i) {
        this.f43430c.remove(i);
    }

    @Override // com.ss.android.socialbase.downloader.downloader.j
    public synchronized List<com.ss.android.socialbase.downloader.f.i> n(int i) {
        Map<Long, com.ss.android.socialbase.downloader.f.i> map = this.f43430c.get(i);
        if (map != null && !map.isEmpty()) {
            return new ArrayList(map.values());
        }
        return null;
    }

    @Override // com.ss.android.socialbase.downloader.downloader.j
    public synchronized List<DownloadInfo> a(String str) {
        ArrayList arrayList;
        arrayList = new ArrayList();
        try {
            int size = this.a.size();
            for (int i = 0; i < size; i++) {
                DownloadInfo valueAt = this.a.valueAt(i);
                if (str != null && str.equals(valueAt.getUrl())) {
                    arrayList.add(valueAt);
                }
            }
        } catch (Exception e2) {
            e2.printStackTrace();
        }
        return arrayList;
    }

    @Override // com.ss.android.socialbase.downloader.downloader.j
    public boolean f(int i) {
        e(i);
        d(i);
        m(i);
        return true;
    }

    @Override // com.ss.android.socialbase.downloader.downloader.j
    public synchronized List<DownloadInfo> b(String str) {
        if (TextUtils.isEmpty(str)) {
            return null;
        }
        if (this.a.size() == 0) {
            return null;
        }
        ArrayList arrayList = new ArrayList();
        for (int i = 0; i < this.a.size(); i++) {
            DownloadInfo downloadInfo = this.a.get(this.a.keyAt(i));
            if (downloadInfo != null && !TextUtils.isEmpty(downloadInfo.getMimeType()) && downloadInfo.getMimeType().equals(str) && DownloadStatus.isFailedStatus(downloadInfo.getStatus())) {
                arrayList.add(downloadInfo);
            }
        }
        return arrayList;
    }

    @Override // com.ss.android.socialbase.downloader.downloader.j
    public void a(com.ss.android.socialbase.downloader.model.b bVar) {
        int k = bVar.k();
        List<com.ss.android.socialbase.downloader.model.b> list = this.f43429b.get(k);
        if (list == null) {
            list = new ArrayList<>();
            this.f43429b.put(k, list);
        }
        list.add(bVar);
    }

    /* JADX WARN: Code restructure failed: missing block: B:14:0x0021, code lost:
        r0.b(r5);
     */
    @Override // com.ss.android.socialbase.downloader.downloader.j
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public synchronized void a(int i, int i2, long j) {
        List<com.ss.android.socialbase.downloader.model.b> c2 = c(i);
        if (c2 == null) {
            return;
        }
        Iterator<com.ss.android.socialbase.downloader.model.b> it = c2.iterator();
        while (true) {
            if (!it.hasNext()) {
                break;
            }
            com.ss.android.socialbase.downloader.model.b next = it.next();
            if (next != null && next.s() == i2) {
                break;
            }
        }
    }

    @Override // com.ss.android.socialbase.downloader.downloader.j
    public synchronized List<com.ss.android.socialbase.downloader.model.b> c(int i) {
        return this.f43429b.get(i);
    }

    @Override // com.ss.android.socialbase.downloader.downloader.j
    public synchronized void d(int i) {
        this.f43429b.remove(i);
    }

    @Override // com.ss.android.socialbase.downloader.downloader.j
    public synchronized void c() {
        this.a.clear();
        this.f43429b.clear();
    }

    @Override // com.ss.android.socialbase.downloader.downloader.j
    public DownloadInfo d(int i, long j) {
        DownloadInfo b2 = b(i);
        if (b2 != null) {
            b2.setCurBytes(j, false);
            b2.setStatus(-2);
        }
        return b2;
    }

    @Override // com.ss.android.socialbase.downloader.downloader.j
    public synchronized List<DownloadInfo> b() {
        if (this.a.size() == 0) {
            return null;
        }
        ArrayList arrayList = new ArrayList(this.a.size());
        for (int i = 0; i < this.a.size(); i++) {
            DownloadInfo valueAt = this.a.valueAt(i);
            if (valueAt != null) {
                arrayList.add(valueAt);
            }
        }
        return arrayList;
    }

    @Override // com.ss.android.socialbase.downloader.downloader.j
    public DownloadInfo c(int i, long j) {
        DownloadInfo b2 = b(i);
        if (b2 != null) {
            b2.setCurBytes(j, false);
            b2.setStatus(-3);
            b2.setFirstDownload(false);
            b2.setFirstSuccess(false);
        }
        return b2;
    }

    /* JADX WARN: Code restructure failed: missing block: B:17:0x002b, code lost:
        if (r0.g() != null) goto L25;
     */
    /* JADX WARN: Code restructure failed: missing block: B:19:0x002e, code lost:
        r3 = r0.g().iterator();
     */
    /* JADX WARN: Code restructure failed: missing block: B:21:0x003a, code lost:
        if (r3.hasNext() == false) goto L39;
     */
    /* JADX WARN: Code restructure failed: missing block: B:22:0x003c, code lost:
        r5 = r3.next();
     */
    /* JADX WARN: Code restructure failed: missing block: B:23:0x0042, code lost:
        if (r5 == null) goto L38;
     */
    /* JADX WARN: Code restructure failed: missing block: B:25:0x0048, code lost:
        if (r5.s() != r4) goto L36;
     */
    /* JADX WARN: Code restructure failed: missing block: B:26:0x004a, code lost:
        r5.b(r6);
     */
    @Override // com.ss.android.socialbase.downloader.downloader.j
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public synchronized void a(int i, int i2, int i3, long j) {
        List<com.ss.android.socialbase.downloader.model.b> c2 = c(i);
        if (c2 == null) {
            return;
        }
        Iterator<com.ss.android.socialbase.downloader.model.b> it = c2.iterator();
        while (true) {
            if (!it.hasNext()) {
                break;
            }
            com.ss.android.socialbase.downloader.model.b next = it.next();
            if (next != null && next.s() == i3 && !next.f()) {
                break;
            }
        }
    }

    @Override // com.ss.android.socialbase.downloader.downloader.j
    public DownloadInfo b(int i, long j) {
        DownloadInfo b2 = b(i);
        if (b2 != null) {
            b2.setCurBytes(j, false);
            b2.setStatus(-1);
            b2.setFirstDownload(false);
        }
        return b2;
    }

    @Override // com.ss.android.socialbase.downloader.downloader.j
    public void b(DownloadInfo downloadInfo) {
        a(downloadInfo);
    }

    @Override // com.ss.android.socialbase.downloader.downloader.j
    public synchronized DownloadInfo a(int i, int i2) {
        DownloadInfo b2;
        b2 = b(i);
        if (b2 != null) {
            b2.setChunkCount(i2);
        }
        return b2;
    }

    @Override // com.ss.android.socialbase.downloader.downloader.j
    public synchronized boolean a(DownloadInfo downloadInfo) {
        boolean z = true;
        if (downloadInfo == null) {
            return true;
        }
        if (this.a.get(downloadInfo.getId()) == null) {
            z = false;
        }
        this.a.put(downloadInfo.getId(), downloadInfo);
        return z;
    }

    @Override // com.ss.android.socialbase.downloader.downloader.j
    public DownloadInfo a(int i, long j, String str, String str2) {
        DownloadInfo b2 = b(i);
        if (b2 != null) {
            b2.setTotalBytes(j);
            b2.seteTag(str);
            if (TextUtils.isEmpty(b2.getName()) && !TextUtils.isEmpty(str2)) {
                b2.setName(str2);
            }
            b2.setStatus(3);
        }
        return b2;
    }

    @Override // com.ss.android.socialbase.downloader.downloader.j
    public DownloadInfo a(int i, long j) {
        DownloadInfo b2 = b(i);
        if (b2 != null) {
            b2.setCurBytes(j, false);
            if (b2.getStatus() != -3 && b2.getStatus() != -2 && !DownloadStatus.isFailedStatus(b2.getStatus()) && b2.getStatus() != -4) {
                b2.setStatus(4);
            }
        }
        return b2;
    }

    @Override // com.ss.android.socialbase.downloader.downloader.j
    public synchronized void a(int i, List<com.ss.android.socialbase.downloader.model.b> list) {
        if (list == null) {
            return;
        }
        d(i);
        for (com.ss.android.socialbase.downloader.model.b bVar : list) {
            if (bVar != null) {
                a(bVar);
                if (bVar.f()) {
                    for (com.ss.android.socialbase.downloader.model.b bVar2 : bVar.g()) {
                        a(bVar2);
                    }
                }
            }
        }
    }

    @Override // com.ss.android.socialbase.downloader.downloader.j
    public synchronized boolean a(int i, Map<Long, com.ss.android.socialbase.downloader.f.i> map) {
        this.f43430c.put(i, map);
        return false;
    }
}
