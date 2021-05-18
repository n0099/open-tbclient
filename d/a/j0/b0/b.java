package d.a.j0.b0;

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
    public Queue<C1095b> f48876a = new ConcurrentLinkedQueue();

    /* renamed from: b  reason: collision with root package name */
    public volatile c f48877b;

    /* renamed from: d.a.j0.b0.b$b  reason: collision with other inner class name */
    /* loaded from: classes3.dex */
    public class C1095b {

        /* renamed from: a  reason: collision with root package name */
        public ImageFileInfo f48878a;

        /* renamed from: b  reason: collision with root package name */
        public d.a.j0.a0.b f48879b;

        /* renamed from: c  reason: collision with root package name */
        public boolean f48880c;

        /* renamed from: d  reason: collision with root package name */
        public d.a.c.j.d.a f48881d;

        /* renamed from: e  reason: collision with root package name */
        public boolean f48882e;

        public C1095b(b bVar) {
        }
    }

    /* loaded from: classes3.dex */
    public class c extends BdAsyncTask<Void, C1095b, C1095b> {

        /* renamed from: a  reason: collision with root package name */
        public final Queue<C1095b> f48883a;

        public c(Queue<C1095b> queue) {
            this.f48883a = queue;
            super.setPriority(2);
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
        /* renamed from: b */
        public C1095b doInBackground(Void... voidArr) {
            int i2;
            while (true) {
                C1095b poll = this.f48883a.poll();
                Bitmap bitmap = null;
                if (poll == null) {
                    return null;
                }
                if (isCancelled()) {
                    this.f48883a.add(poll);
                    return null;
                }
                d.a.c.j.d.a m = d.a.j0.a0.c.k().m(poll.f48878a.toCachedKey(poll.f48880c));
                if (m != null) {
                    poll.f48881d = m;
                    poll.f48882e = true;
                } else {
                    Bitmap f2 = b.this.f(poll.f48878a, poll.f48880c);
                    if (f2 != null) {
                        try {
                            i2 = BitmapHelper.readPictureDegree(poll.f48878a.getFilePath());
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
                            poll.f48881d = new d.a.c.j.d.a(bitmap, poll.f48878a.isGif(), poll.f48878a.getFilePath());
                        } else {
                            poll.f48881d = new d.a.c.j.d.a(f2, poll.f48878a.isGif(), poll.f48878a.getFilePath());
                        }
                    }
                }
                publishProgress(poll);
            }
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
        /* renamed from: c */
        public void onPostExecute(C1095b c1095b) {
            super.onPostExecute(c1095b);
            b.this.f48877b = null;
            b.this.g();
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
        /* renamed from: d */
        public void onProgressUpdate(C1095b... c1095bArr) {
            if (c1095bArr != null) {
                for (C1095b c1095b : c1095bArr) {
                    d.a.c.j.d.a aVar = c1095b.f48881d;
                    if (aVar != null && !c1095b.f48882e) {
                        d.a.j0.a0.c.k().d(c1095b.f48878a.toCachedKey(c1095b.f48880c), aVar);
                    }
                    d.a.j0.a0.b bVar = c1095b.f48879b;
                    if (bVar != null) {
                        bVar.a(aVar, c1095b.f48878a.toCachedKey(c1095b.f48880c), c1095b.f48882e);
                    }
                }
            }
        }

        @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
        public void onCancelled() {
            super.onCancelled();
            b.this.f48877b = null;
            while (true) {
                C1095b poll = this.f48883a.poll();
                if (poll == null) {
                    return;
                }
                d.a.j0.a0.b bVar = poll.f48879b;
                if (bVar != null) {
                    bVar.a(null, poll.f48878a.toCachedKey(poll.f48880c), false);
                }
            }
        }
    }

    public void b() {
        this.f48876a = new ConcurrentLinkedQueue();
        if (this.f48877b != null) {
            this.f48877b.cancel(true);
            this.f48877b = null;
        }
    }

    public d.a.c.j.d.a c(ImageFileInfo imageFileInfo, boolean z) {
        if (imageFileInfo == null) {
            return null;
        }
        return d.a.j0.a0.c.k().m(imageFileInfo.toCachedKey(z));
    }

    public d.a.c.j.d.a d(ImageFileInfo imageFileInfo, d.a.j0.a0.b bVar, boolean z) {
        return e(imageFileInfo, bVar, z, false);
    }

    public d.a.c.j.d.a e(ImageFileInfo imageFileInfo, d.a.j0.a0.b bVar, boolean z, boolean z2) {
        d.a.c.j.d.a c2 = c(imageFileInfo, z);
        if (c2 != null) {
            return c2;
        }
        if (z2) {
            return null;
        }
        C1095b c1095b = new C1095b();
        c1095b.f48879b = bVar;
        c1095b.f48878a = imageFileInfo;
        c1095b.f48880c = z;
        this.f48876a.add(c1095b);
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
                return d.a.j0.b0.g.c.d().b(imageFileInfo.getOrginalBitmap(), !imageFileInfo.isOrginalBitmapShared(), linkedList, imageFileInfo);
            } catch (Exception e2) {
                e2.printStackTrace();
                return null;
            }
        } else if (imageFileInfo.hasActions(z)) {
            try {
                return d.a.j0.b0.g.c.d().c(imageFileInfo.getFilePath(), linkedList, imageFileInfo);
            } catch (Exception e3) {
                e3.printStackTrace();
                return null;
            }
        } else {
            return BitmapHelper.loadBitmap(imageFileInfo.getFilePath());
        }
    }

    public void g() {
        if (this.f48877b != null || this.f48876a.isEmpty()) {
            return;
        }
        this.f48877b = new c(this.f48876a);
        this.f48877b.execute(new Void[0]);
    }
}
