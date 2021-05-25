package d.a.m0.b0;

import android.graphics.Bitmap;
import com.baidu.adp.lib.asyncTask.BdAsyncTask;
import com.baidu.tbadk.core.util.BitmapHelper;
import com.baidu.tbadk.img.ImageFileInfo;
import java.util.LinkedList;
import java.util.Queue;
import java.util.concurrent.ConcurrentLinkedQueue;
/* loaded from: classes3.dex */
public class b {

    /* renamed from: a  reason: collision with root package name */
    public Queue<C1102b> f48901a = new ConcurrentLinkedQueue();

    /* renamed from: b  reason: collision with root package name */
    public volatile c f48902b;

    /* renamed from: d.a.m0.b0.b$b  reason: collision with other inner class name */
    /* loaded from: classes3.dex */
    public class C1102b {

        /* renamed from: a  reason: collision with root package name */
        public ImageFileInfo f48903a;

        /* renamed from: b  reason: collision with root package name */
        public d.a.m0.a0.b f48904b;

        /* renamed from: c  reason: collision with root package name */
        public boolean f48905c;

        /* renamed from: d  reason: collision with root package name */
        public d.a.c.j.d.a f48906d;

        /* renamed from: e  reason: collision with root package name */
        public boolean f48907e;

        public C1102b(b bVar) {
        }
    }

    /* loaded from: classes3.dex */
    public class c extends BdAsyncTask<Void, C1102b, C1102b> {

        /* renamed from: a  reason: collision with root package name */
        public final Queue<C1102b> f48908a;

        public c(Queue<C1102b> queue) {
            this.f48908a = queue;
            super.setPriority(2);
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
        /* renamed from: b */
        public C1102b doInBackground(Void... voidArr) {
            int i2;
            while (true) {
                C1102b poll = this.f48908a.poll();
                Bitmap bitmap = null;
                if (poll == null) {
                    return null;
                }
                if (isCancelled()) {
                    this.f48908a.add(poll);
                    return null;
                }
                d.a.c.j.d.a m = d.a.m0.a0.c.k().m(poll.f48903a.toCachedKey(poll.f48905c));
                if (m != null) {
                    poll.f48906d = m;
                    poll.f48907e = true;
                } else {
                    Bitmap f2 = b.this.f(poll.f48903a, poll.f48905c);
                    if (f2 != null) {
                        try {
                            i2 = BitmapHelper.readPictureDegree(poll.f48903a.getFilePath());
                            if (i2 != 0) {
                                try {
                                    Bitmap rotateBitmapBydegree = BitmapHelper.rotateBitmapBydegree(f2, i2);
                                    if (f2 != rotateBitmapBydegree) {
                                        try {
                                            f2.recycle();
                                            f2 = null;
                                        } catch (Exception unused) {
                                        }
                                    }
                                    bitmap = rotateBitmapBydegree;
                                } catch (Exception unused2) {
                                }
                            }
                        } catch (Exception unused3) {
                            i2 = 0;
                        }
                        if (i2 != 0 && bitmap != null) {
                            poll.f48906d = new d.a.c.j.d.a(bitmap, poll.f48903a.isGif(), poll.f48903a.getFilePath());
                        } else {
                            poll.f48906d = new d.a.c.j.d.a(f2, poll.f48903a.isGif(), poll.f48903a.getFilePath());
                        }
                    }
                }
                publishProgress(poll);
            }
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
        /* renamed from: c */
        public void onPostExecute(C1102b c1102b) {
            super.onPostExecute(c1102b);
            b.this.f48902b = null;
            b.this.g();
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
        /* renamed from: d */
        public void onProgressUpdate(C1102b... c1102bArr) {
            if (c1102bArr != null) {
                for (C1102b c1102b : c1102bArr) {
                    d.a.c.j.d.a aVar = c1102b.f48906d;
                    if (aVar != null && !c1102b.f48907e) {
                        d.a.m0.a0.c.k().d(c1102b.f48903a.toCachedKey(c1102b.f48905c), aVar);
                    }
                    d.a.m0.a0.b bVar = c1102b.f48904b;
                    if (bVar != null) {
                        bVar.a(aVar, c1102b.f48903a.toCachedKey(c1102b.f48905c), c1102b.f48907e);
                    }
                }
            }
        }

        @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
        public void onCancelled() {
            super.onCancelled();
            b.this.f48902b = null;
            while (true) {
                C1102b poll = this.f48908a.poll();
                if (poll == null) {
                    return;
                }
                d.a.m0.a0.b bVar = poll.f48904b;
                if (bVar != null) {
                    bVar.a(null, poll.f48903a.toCachedKey(poll.f48905c), false);
                }
            }
        }
    }

    public void b() {
        this.f48901a = new ConcurrentLinkedQueue();
        if (this.f48902b != null) {
            this.f48902b.cancel(true);
            this.f48902b = null;
        }
    }

    public d.a.c.j.d.a c(ImageFileInfo imageFileInfo, boolean z) {
        if (imageFileInfo == null) {
            return null;
        }
        return d.a.m0.a0.c.k().m(imageFileInfo.toCachedKey(z));
    }

    public d.a.c.j.d.a d(ImageFileInfo imageFileInfo, d.a.m0.a0.b bVar, boolean z) {
        return e(imageFileInfo, bVar, z, false);
    }

    public d.a.c.j.d.a e(ImageFileInfo imageFileInfo, d.a.m0.a0.b bVar, boolean z, boolean z2) {
        d.a.c.j.d.a c2 = c(imageFileInfo, z);
        if (c2 != null) {
            return c2;
        }
        if (z2) {
            return null;
        }
        C1102b c1102b = new C1102b();
        c1102b.f48904b = bVar;
        c1102b.f48903a = imageFileInfo;
        c1102b.f48905c = z;
        this.f48901a.add(c1102b);
        g();
        return null;
    }

    public Bitmap f(ImageFileInfo imageFileInfo, boolean z) {
        if (imageFileInfo == null) {
            return null;
        }
        LinkedList linkedList = new LinkedList();
        if (z && imageFileInfo.getPersistActionsList() != null) {
            linkedList.addAll(imageFileInfo.getPersistActionsList());
        }
        if (imageFileInfo.getPageActionsList() != null) {
            linkedList.addAll(imageFileInfo.getPageActionsList());
        }
        if (imageFileInfo.getOrginalBitmap() != null) {
            try {
                return d.a.m0.b0.g.c.d().b(imageFileInfo.getOrginalBitmap(), !imageFileInfo.isOrginalBitmapShared(), linkedList, imageFileInfo);
            } catch (Exception e2) {
                e2.printStackTrace();
                return null;
            }
        } else if (imageFileInfo.hasActions(z)) {
            try {
                return d.a.m0.b0.g.c.d().c(imageFileInfo.getFilePath(), linkedList, imageFileInfo);
            } catch (Exception e3) {
                e3.printStackTrace();
                return null;
            }
        } else {
            return BitmapHelper.loadBitmap(imageFileInfo.getFilePath());
        }
    }

    public void g() {
        if (this.f48902b != null || this.f48901a.isEmpty()) {
            return;
        }
        this.f48902b = new c(this.f48901a);
        this.f48902b.execute(new Void[0]);
    }
}
