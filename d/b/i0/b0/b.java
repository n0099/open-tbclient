package d.b.i0.b0;

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
    public Queue<C1080b> f50494a = new ConcurrentLinkedQueue();

    /* renamed from: b  reason: collision with root package name */
    public volatile c f50495b;

    /* renamed from: d.b.i0.b0.b$b  reason: collision with other inner class name */
    /* loaded from: classes3.dex */
    public class C1080b {

        /* renamed from: a  reason: collision with root package name */
        public ImageFileInfo f50496a;

        /* renamed from: b  reason: collision with root package name */
        public d.b.i0.a0.b f50497b;

        /* renamed from: c  reason: collision with root package name */
        public boolean f50498c;

        /* renamed from: d  reason: collision with root package name */
        public d.b.c.j.d.a f50499d;

        /* renamed from: e  reason: collision with root package name */
        public boolean f50500e;

        public C1080b(b bVar) {
        }
    }

    /* loaded from: classes3.dex */
    public class c extends BdAsyncTask<Void, C1080b, C1080b> {

        /* renamed from: a  reason: collision with root package name */
        public final Queue<C1080b> f50501a;

        public c(Queue<C1080b> queue) {
            this.f50501a = queue;
            super.setPriority(2);
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
        /* renamed from: b */
        public C1080b doInBackground(Void... voidArr) {
            int i;
            while (true) {
                C1080b poll = this.f50501a.poll();
                Bitmap bitmap = null;
                if (poll == null) {
                    return null;
                }
                if (isCancelled()) {
                    this.f50501a.add(poll);
                    return null;
                }
                d.b.c.j.d.a m = d.b.i0.a0.c.k().m(poll.f50496a.toCachedKey(poll.f50498c));
                if (m != null) {
                    poll.f50499d = m;
                    poll.f50500e = true;
                } else {
                    Bitmap f2 = b.this.f(poll.f50496a, poll.f50498c);
                    if (f2 != null) {
                        try {
                            i = BitmapHelper.readPictureDegree(poll.f50496a.getFilePath());
                            if (i != 0) {
                                try {
                                    Bitmap rotateBitmapBydegree = BitmapHelper.rotateBitmapBydegree(f2, i);
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
                            i = 0;
                        }
                        if (i != 0 && bitmap != null) {
                            poll.f50499d = new d.b.c.j.d.a(bitmap, poll.f50496a.isGif(), poll.f50496a.getFilePath());
                        } else {
                            poll.f50499d = new d.b.c.j.d.a(f2, poll.f50496a.isGif(), poll.f50496a.getFilePath());
                        }
                    }
                }
                publishProgress(poll);
            }
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
        /* renamed from: c */
        public void onPostExecute(C1080b c1080b) {
            super.onPostExecute(c1080b);
            b.this.f50495b = null;
            b.this.g();
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
        /* renamed from: d */
        public void onProgressUpdate(C1080b... c1080bArr) {
            if (c1080bArr != null) {
                for (C1080b c1080b : c1080bArr) {
                    d.b.c.j.d.a aVar = c1080b.f50499d;
                    if (aVar != null && !c1080b.f50500e) {
                        d.b.i0.a0.c.k().d(c1080b.f50496a.toCachedKey(c1080b.f50498c), aVar);
                    }
                    d.b.i0.a0.b bVar = c1080b.f50497b;
                    if (bVar != null) {
                        bVar.a(aVar, c1080b.f50496a.toCachedKey(c1080b.f50498c), c1080b.f50500e);
                    }
                }
            }
        }

        @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
        public void onCancelled() {
            super.onCancelled();
            b.this.f50495b = null;
            while (true) {
                C1080b poll = this.f50501a.poll();
                if (poll == null) {
                    return;
                }
                d.b.i0.a0.b bVar = poll.f50497b;
                if (bVar != null) {
                    bVar.a(null, poll.f50496a.toCachedKey(poll.f50498c), false);
                }
            }
        }
    }

    public void b() {
        this.f50494a = new ConcurrentLinkedQueue();
        if (this.f50495b != null) {
            this.f50495b.cancel(true);
            this.f50495b = null;
        }
    }

    public d.b.c.j.d.a c(ImageFileInfo imageFileInfo, boolean z) {
        if (imageFileInfo == null) {
            return null;
        }
        return d.b.i0.a0.c.k().m(imageFileInfo.toCachedKey(z));
    }

    public d.b.c.j.d.a d(ImageFileInfo imageFileInfo, d.b.i0.a0.b bVar, boolean z) {
        return e(imageFileInfo, bVar, z, false);
    }

    public d.b.c.j.d.a e(ImageFileInfo imageFileInfo, d.b.i0.a0.b bVar, boolean z, boolean z2) {
        d.b.c.j.d.a c2 = c(imageFileInfo, z);
        if (c2 != null) {
            return c2;
        }
        if (z2) {
            return null;
        }
        C1080b c1080b = new C1080b();
        c1080b.f50497b = bVar;
        c1080b.f50496a = imageFileInfo;
        c1080b.f50498c = z;
        this.f50494a.add(c1080b);
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
                return d.b.i0.b0.g.c.d().b(imageFileInfo.getOrginalBitmap(), !imageFileInfo.isOrginalBitmapShared(), linkedList, imageFileInfo);
            } catch (Exception e2) {
                e2.printStackTrace();
                return null;
            }
        } else if (imageFileInfo.hasActions(z)) {
            try {
                return d.b.i0.b0.g.c.d().c(imageFileInfo.getFilePath(), linkedList, imageFileInfo);
            } catch (Exception e3) {
                e3.printStackTrace();
                return null;
            }
        } else {
            return BitmapHelper.loadBitmap(imageFileInfo.getFilePath());
        }
    }

    public void g() {
        if (this.f50495b != null || this.f50494a.isEmpty()) {
            return;
        }
        this.f50495b = new c(this.f50494a);
        this.f50495b.execute(new Void[0]);
    }
}
