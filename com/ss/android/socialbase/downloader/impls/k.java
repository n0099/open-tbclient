package com.ss.android.socialbase.downloader.impls;

import android.text.TextUtils;
import android.util.SparseArray;
import com.ss.android.socialbase.downloader.constants.DownloadStatus;
import com.ss.android.socialbase.downloader.model.DownloadInfo;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
/* loaded from: classes3.dex */
public class k implements com.ss.android.socialbase.downloader.downloader.j {
    public final SparseArray<DownloadInfo> a = new SparseArray<>();

    /* renamed from: b  reason: collision with root package name */
    public final SparseArray<List<com.ss.android.socialbase.downloader.model.b>> f62526b = new SparseArray<>();

    /* renamed from: c  reason: collision with root package name */
    public final SparseArray<Map<Long, com.ss.android.socialbase.downloader.f.i>> f62527c = new SparseArray<>();

    public SparseArray<DownloadInfo> a() {
        return this.a;
    }

    @Override // com.ss.android.socialbase.downloader.downloader.j
    public void a(int i2, int i3, int i4, int i5) {
    }

    @Override // com.ss.android.socialbase.downloader.downloader.j
    public synchronized DownloadInfo b(int i2) {
        DownloadInfo downloadInfo;
        try {
            downloadInfo = this.a.get(i2);
        } catch (Exception e2) {
            e2.printStackTrace();
            downloadInfo = null;
        }
        return downloadInfo;
    }

    @Override // com.ss.android.socialbase.downloader.downloader.j
    public void b(int i2, List<com.ss.android.socialbase.downloader.model.b> list) {
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
        for (int i2 = 0; i2 < this.a.size(); i2++) {
            DownloadInfo downloadInfo = this.a.get(this.a.keyAt(i2));
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
        for (int i2 = 0; i2 < this.a.size(); i2++) {
            DownloadInfo downloadInfo = this.a.get(this.a.keyAt(i2));
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
    public synchronized boolean e(int i2) {
        this.a.remove(i2);
        return true;
    }

    public SparseArray<List<com.ss.android.socialbase.downloader.model.b>> f() {
        return this.f62526b;
    }

    @Override // com.ss.android.socialbase.downloader.downloader.j
    public DownloadInfo g(int i2) {
        DownloadInfo b2 = b(i2);
        if (b2 != null) {
            b2.setStatus(2);
        }
        return b2;
    }

    @Override // com.ss.android.socialbase.downloader.downloader.j
    public DownloadInfo h(int i2) {
        DownloadInfo b2 = b(i2);
        if (b2 != null) {
            b2.setStatus(5);
            b2.setFirstDownload(false);
        }
        return b2;
    }

    @Override // com.ss.android.socialbase.downloader.downloader.j
    public DownloadInfo i(int i2) {
        DownloadInfo b2 = b(i2);
        if (b2 != null) {
            b2.setStatus(1);
        }
        return b2;
    }

    @Override // com.ss.android.socialbase.downloader.downloader.j
    public DownloadInfo j(int i2) {
        DownloadInfo b2 = b(i2);
        if (b2 != null) {
            b2.setStatus(-7);
        }
        return b2;
    }

    @Override // com.ss.android.socialbase.downloader.downloader.j
    public synchronized Map<Long, com.ss.android.socialbase.downloader.f.i> l(int i2) {
        return this.f62527c.get(i2);
    }

    @Override // com.ss.android.socialbase.downloader.downloader.j
    public synchronized void m(int i2) {
        this.f62527c.remove(i2);
    }

    @Override // com.ss.android.socialbase.downloader.downloader.j
    public synchronized List<com.ss.android.socialbase.downloader.f.i> n(int i2) {
        Map<Long, com.ss.android.socialbase.downloader.f.i> map = this.f62527c.get(i2);
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
            for (int i2 = 0; i2 < size; i2++) {
                DownloadInfo valueAt = this.a.valueAt(i2);
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
    public boolean f(int i2) {
        e(i2);
        d(i2);
        m(i2);
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
        for (int i2 = 0; i2 < this.a.size(); i2++) {
            DownloadInfo downloadInfo = this.a.get(this.a.keyAt(i2));
            if (downloadInfo != null && !TextUtils.isEmpty(downloadInfo.getMimeType()) && downloadInfo.getMimeType().equals(str) && DownloadStatus.isFailedStatus(downloadInfo.getStatus())) {
                arrayList.add(downloadInfo);
            }
        }
        return arrayList;
    }

    @Override // com.ss.android.socialbase.downloader.downloader.j
    public void a(com.ss.android.socialbase.downloader.model.b bVar) {
        int k2 = bVar.k();
        List<com.ss.android.socialbase.downloader.model.b> list = this.f62526b.get(k2);
        if (list == null) {
            list = new ArrayList<>();
            this.f62526b.put(k2, list);
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
    public synchronized void a(int i2, int i3, long j2) {
        List<com.ss.android.socialbase.downloader.model.b> c2 = c(i2);
        if (c2 == null) {
            return;
        }
        Iterator<com.ss.android.socialbase.downloader.model.b> it = c2.iterator();
        while (true) {
            if (!it.hasNext()) {
                break;
            }
            com.ss.android.socialbase.downloader.model.b next = it.next();
            if (next != null && next.s() == i3) {
                break;
            }
        }
    }

    @Override // com.ss.android.socialbase.downloader.downloader.j
    public synchronized List<com.ss.android.socialbase.downloader.model.b> c(int i2) {
        return this.f62526b.get(i2);
    }

    @Override // com.ss.android.socialbase.downloader.downloader.j
    public synchronized void d(int i2) {
        this.f62526b.remove(i2);
    }

    @Override // com.ss.android.socialbase.downloader.downloader.j
    public synchronized void c() {
        this.a.clear();
        this.f62526b.clear();
    }

    @Override // com.ss.android.socialbase.downloader.downloader.j
    public DownloadInfo d(int i2, long j2) {
        DownloadInfo b2 = b(i2);
        if (b2 != null) {
            b2.setCurBytes(j2, false);
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
        for (int i2 = 0; i2 < this.a.size(); i2++) {
            DownloadInfo valueAt = this.a.valueAt(i2);
            if (valueAt != null) {
                arrayList.add(valueAt);
            }
        }
        return arrayList;
    }

    @Override // com.ss.android.socialbase.downloader.downloader.j
    public DownloadInfo c(int i2, long j2) {
        DownloadInfo b2 = b(i2);
        if (b2 != null) {
            b2.setCurBytes(j2, false);
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
    public synchronized void a(int i2, int i3, int i4, long j2) {
        List<com.ss.android.socialbase.downloader.model.b> c2 = c(i2);
        if (c2 == null) {
            return;
        }
        Iterator<com.ss.android.socialbase.downloader.model.b> it = c2.iterator();
        while (true) {
            if (!it.hasNext()) {
                break;
            }
            com.ss.android.socialbase.downloader.model.b next = it.next();
            if (next != null && next.s() == i4 && !next.f()) {
                break;
            }
        }
    }

    @Override // com.ss.android.socialbase.downloader.downloader.j
    public DownloadInfo b(int i2, long j2) {
        DownloadInfo b2 = b(i2);
        if (b2 != null) {
            b2.setCurBytes(j2, false);
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
    public synchronized DownloadInfo a(int i2, int i3) {
        DownloadInfo b2;
        b2 = b(i2);
        if (b2 != null) {
            b2.setChunkCount(i3);
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
    public DownloadInfo a(int i2, long j2, String str, String str2) {
        DownloadInfo b2 = b(i2);
        if (b2 != null) {
            b2.setTotalBytes(j2);
            b2.seteTag(str);
            if (TextUtils.isEmpty(b2.getName()) && !TextUtils.isEmpty(str2)) {
                b2.setName(str2);
            }
            b2.setStatus(3);
        }
        return b2;
    }

    @Override // com.ss.android.socialbase.downloader.downloader.j
    public DownloadInfo a(int i2, long j2) {
        DownloadInfo b2 = b(i2);
        if (b2 != null) {
            b2.setCurBytes(j2, false);
            if (b2.getStatus() != -3 && b2.getStatus() != -2 && !DownloadStatus.isFailedStatus(b2.getStatus()) && b2.getStatus() != -4) {
                b2.setStatus(4);
            }
        }
        return b2;
    }

    @Override // com.ss.android.socialbase.downloader.downloader.j
    public synchronized void a(int i2, List<com.ss.android.socialbase.downloader.model.b> list) {
        if (list == null) {
            return;
        }
        d(i2);
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
    public synchronized boolean a(int i2, Map<Long, com.ss.android.socialbase.downloader.f.i> map) {
        this.f62527c.put(i2, map);
        return false;
    }
}
