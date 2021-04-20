package d.b.h0.b0;

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
    public Queue<C1058b> f50158a = new ConcurrentLinkedQueue();

    /* renamed from: b  reason: collision with root package name */
    public volatile c f50159b;

    /* renamed from: d.b.h0.b0.b$b  reason: collision with other inner class name */
    /* loaded from: classes3.dex */
    public class C1058b {

        /* renamed from: a  reason: collision with root package name */
        public ImageFileInfo f50160a;

        /* renamed from: b  reason: collision with root package name */
        public d.b.h0.a0.b f50161b;

        /* renamed from: c  reason: collision with root package name */
        public boolean f50162c;

        /* renamed from: d  reason: collision with root package name */
        public d.b.c.j.d.a f50163d;

        /* renamed from: e  reason: collision with root package name */
        public boolean f50164e;

        public C1058b(b bVar) {
        }
    }

    /* loaded from: classes3.dex */
    public class c extends BdAsyncTask<Void, C1058b, C1058b> {

        /* renamed from: a  reason: collision with root package name */
        public final Queue<C1058b> f50165a;

        public c(Queue<C1058b> queue) {
            this.f50165a = queue;
            super.setPriority(2);
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
        /* renamed from: b */
        public C1058b doInBackground(Void... voidArr) {
            int i;
            while (true) {
                C1058b poll = this.f50165a.poll();
                Bitmap bitmap = null;
                if (poll == null) {
                    return null;
                }
                if (isCancelled()) {
                    this.f50165a.add(poll);
                    return null;
                }
                d.b.c.j.d.a m = d.b.h0.a0.c.k().m(poll.f50160a.toCachedKey(poll.f50162c));
                if (m != null) {
                    poll.f50163d = m;
                    poll.f50164e = true;
                } else {
                    Bitmap f2 = b.this.f(poll.f50160a, poll.f50162c);
                    if (f2 != null) {
                        try {
                            i = BitmapHelper.readPictureDegree(poll.f50160a.getFilePath());
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
                            poll.f50163d = new d.b.c.j.d.a(bitmap, poll.f50160a.isGif(), poll.f50160a.getFilePath());
                        } else {
                            poll.f50163d = new d.b.c.j.d.a(f2, poll.f50160a.isGif(), poll.f50160a.getFilePath());
                        }
                    }
                }
                publishProgress(poll);
            }
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
        /* renamed from: c */
        public void onPostExecute(C1058b c1058b) {
            super.onPostExecute(c1058b);
            b.this.f50159b = null;
            b.this.g();
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
        /* renamed from: d */
        public void onProgressUpdate(C1058b... c1058bArr) {
            if (c1058bArr != null) {
                for (C1058b c1058b : c1058bArr) {
                    d.b.c.j.d.a aVar = c1058b.f50163d;
                    if (aVar != null && !c1058b.f50164e) {
                        d.b.h0.a0.c.k().d(c1058b.f50160a.toCachedKey(c1058b.f50162c), aVar);
                    }
                    d.b.h0.a0.b bVar = c1058b.f50161b;
                    if (bVar != null) {
                        bVar.a(aVar, c1058b.f50160a.toCachedKey(c1058b.f50162c), c1058b.f50164e);
                    }
                }
            }
        }

        @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
        public void onCancelled() {
            super.onCancelled();
            b.this.f50159b = null;
            while (true) {
                C1058b poll = this.f50165a.poll();
                if (poll == null) {
                    return;
                }
                d.b.h0.a0.b bVar = poll.f50161b;
                if (bVar != null) {
                    bVar.a(null, poll.f50160a.toCachedKey(poll.f50162c), false);
                }
            }
        }
    }

    public void b() {
        this.f50158a = new ConcurrentLinkedQueue();
        if (this.f50159b != null) {
            this.f50159b.cancel(true);
            this.f50159b = null;
        }
    }

    public d.b.c.j.d.a c(ImageFileInfo imageFileInfo, boolean z) {
        if (imageFileInfo == null) {
            return null;
        }
        return d.b.h0.a0.c.k().m(imageFileInfo.toCachedKey(z));
    }

    public d.b.c.j.d.a d(ImageFileInfo imageFileInfo, d.b.h0.a0.b bVar, boolean z) {
        return e(imageFileInfo, bVar, z, false);
    }

    public d.b.c.j.d.a e(ImageFileInfo imageFileInfo, d.b.h0.a0.b bVar, boolean z, boolean z2) {
        d.b.c.j.d.a c2 = c(imageFileInfo, z);
        if (c2 != null) {
            return c2;
        }
        if (z2) {
            return null;
        }
        C1058b c1058b = new C1058b();
        c1058b.f50161b = bVar;
        c1058b.f50160a = imageFileInfo;
        c1058b.f50162c = z;
        this.f50158a.add(c1058b);
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
                return d.b.h0.b0.g.c.d().b(imageFileInfo.getOrginalBitmap(), !imageFileInfo.isOrginalBitmapShared(), linkedList, imageFileInfo);
            } catch (Exception e2) {
                e2.printStackTrace();
                return null;
            }
        } else if (imageFileInfo.hasActions(z)) {
            try {
                return d.b.h0.b0.g.c.d().c(imageFileInfo.getFilePath(), linkedList, imageFileInfo);
            } catch (Exception e3) {
                e3.printStackTrace();
                return null;
            }
        } else {
            return BitmapHelper.loadBitmap(imageFileInfo.getFilePath());
        }
    }

    public void g() {
        if (this.f50159b != null || this.f50158a.isEmpty()) {
            return;
        }
        this.f50159b = new c(this.f50158a);
        this.f50159b.execute(new Void[0]);
    }
}
