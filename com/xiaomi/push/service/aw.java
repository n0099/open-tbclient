package com.xiaomi.push.service;

import android.content.Context;
import android.text.TextUtils;
import com.xiaomi.push.service.av;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
/* loaded from: classes3.dex */
public class aw {
    private static aw a = new aw();
    private static ExecutorService b = Executors.newSingleThreadExecutor();
    private Context c;
    private String e;
    private Map<String, b> d = new HashMap();
    private final ArrayList<av.b> f = new ArrayList<>();

    /* loaded from: classes3.dex */
    public class a implements Runnable {
        b a;
        String b;

        public a() {
        }

        @Override // java.lang.Runnable
        public void run() {
            aw.this.d.put(this.b, this.a);
            aw.this.c("Add uploader, provider is " + this.b);
        }
    }

    /* loaded from: classes3.dex */
    public interface b {
        void a(ArrayList<av.b> arrayList);

        boolean a(av.b bVar);
    }

    /* loaded from: classes3.dex */
    public class c implements Runnable {
        private Context b;

        public c() {
        }

        @Override // java.lang.Runnable
        public void run() {
            if (aw.this.c != null) {
                com.xiaomi.channel.commonutils.logger.b.d("[TinyDataManager]: please do not init TinyDataManager repeatly.");
                return;
            }
            aw.this.c = this.b;
            aw.this.a(new av.a(this.b), "SHORT_UPLOADER_FROM_SELF");
            aw.this.c("Init");
        }
    }

    /* loaded from: classes3.dex */
    private class d implements Runnable {
        String a;

        public d(String str) {
            this.a = str;
        }

        @Override // java.lang.Runnable
        public void run() {
            aw.this.c(this.a);
        }
    }

    /* loaded from: classes3.dex */
    private class e implements Runnable {
        String a;

        private e() {
        }

        @Override // java.lang.Runnable
        public void run() {
            if (!TextUtils.isEmpty(aw.this.e)) {
                com.xiaomi.channel.commonutils.logger.b.d("[TinyDataManager]:channel is not null, please do not set repeatly.");
                return;
            }
            aw.this.e = this.a;
            int i = 0;
            while (true) {
                int i2 = i;
                if (i2 >= aw.this.f.size()) {
                    aw.this.c("Set channel to " + this.a);
                    return;
                }
                av.b bVar = (av.b) aw.this.f.get(i2);
                if (!bVar.c.f && bVar.c.a == null) {
                    bVar.c.a = this.a;
                }
                i = i2 + 1;
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes3.dex */
    public class f implements Runnable {
        av.b a;

        private f() {
        }

        @Override // java.lang.Runnable
        public void run() {
            String str;
            boolean z = true;
            if (this.a.c.f) {
                this.a.c.a = "push_sdk_channel";
            } else {
                this.a.c.a = aw.this.e;
            }
            this.a.a = av.a();
            b c = aw.this.c();
            String str2 = null;
            boolean z2 = false;
            if (c == null) {
                str2 = "uploader is null";
                z2 = true;
            }
            if (!z2 && aw.this.b()) {
                str2 = "TinyDataManager need init";
                z2 = true;
            }
            if (!z2 && this.a.c.a == null) {
                str2 = "request channel is null";
                z2 = true;
            }
            if (z2 || c.a(this.a)) {
                z = z2;
                str = str2;
            } else {
                str = "uploader refuse upload";
            }
            if (z) {
                com.xiaomi.channel.commonutils.logger.b.c(this.a.toString() + " is added to pending list. Pending Reason is " + str);
                aw.this.f.add(this.a);
                return;
            }
            com.xiaomi.channel.commonutils.logger.b.c(this.a.toString() + " is uploaded immediately.");
            ArrayList<av.b> arrayList = new ArrayList<>();
            arrayList.add(this.a);
            c.a(arrayList);
        }
    }

    private aw() {
    }

    public static aw a() {
        return a;
    }

    private void a(av.b bVar) {
        f fVar = new f();
        fVar.a = bVar;
        b.execute(fVar);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public b c() {
        b bVar = this.d.get("UPLOADER_FROM_MIPUSHCLIENT");
        if (bVar != null) {
            return bVar;
        }
        b bVar2 = this.d.get("UPLOADER_FROM_XMPUSHSERVICE");
        if (bVar2 == null) {
            return null;
        }
        return bVar2;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public boolean c(String str) {
        b c2;
        com.xiaomi.channel.commonutils.logger.b.c("TinyDataManager is checking and uploading tiny data, reason is " + str + ", the size of pending list is " + this.f.size());
        if (b() || (c2 = c()) == null) {
            return false;
        }
        ArrayList<av.b> arrayList = new ArrayList<>();
        Iterator<av.b> it = this.f.iterator();
        while (it.hasNext()) {
            av.b next = it.next();
            if (next.c.a != null && c2.a(next)) {
                arrayList.add(next);
            }
        }
        if (arrayList.size() != 0) {
            c2.a(arrayList);
            Iterator<av.b> it2 = arrayList.iterator();
            while (it2.hasNext()) {
                av.b next2 = it2.next();
                com.xiaomi.channel.commonutils.logger.b.c("Pending Data " + next2.toString() + " uploaded by TinyDataManager, reason is " + str);
                this.f.remove(next2);
            }
        }
        return true;
    }

    public void a(Context context) {
        if (context == null) {
            com.xiaomi.channel.commonutils.logger.b.d("[TinyDataManager]:context is null, TinyDataManager.init(Context, TinyDataUploader) failed.");
            return;
        }
        c cVar = new c();
        cVar.b = context;
        b.execute(cVar);
    }

    public void a(b bVar, String str) {
        if (bVar == null) {
            com.xiaomi.channel.commonutils.logger.b.d("[TinyDataManager]: please do not add null uploader to TinyDataManager.");
        } else if (TextUtils.isEmpty(str)) {
            com.xiaomi.channel.commonutils.logger.b.d("[TinyDataManager]: can not add a provider from unkown resource.");
        } else {
            a aVar = new a();
            aVar.b = str;
            aVar.a = bVar;
            b.execute(aVar);
        }
    }

    public void a(String str) {
        if (!TextUtils.isEmpty(this.e)) {
            com.xiaomi.channel.commonutils.logger.b.d("[TinyDataManager]:channel is not null, please do not set repeatly.");
            return;
        }
        e eVar = new e();
        eVar.a = str;
        b.execute(eVar);
    }

    public boolean a(int i, String str, String str2, long j, String str3) {
        return a(i, str, str2, j, str3, true);
    }

    public boolean a(int i, String str, String str2, long j, String str3, boolean z) {
        if (av.a(str, str2, j, str3)) {
            return false;
        }
        av.b bVar = new av.b();
        bVar.b = i;
        bVar.c.g = str;
        bVar.c.c = str2;
        bVar.c.d = j;
        bVar.c.b = str3;
        bVar.c.f = z;
        bVar.c.e = System.currentTimeMillis();
        a(bVar);
        return true;
    }

    public boolean a(String str, String str2, long j, String str3) {
        return a(0, str, str2, j, str3);
    }

    public void b(String str) {
        b.execute(new d(str));
    }

    public boolean b() {
        return this.c == null;
    }
}
