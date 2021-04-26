package d.a.i0.b0;

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
    public Queue<C1019b> f48048a = new ConcurrentLinkedQueue();

    /* renamed from: b  reason: collision with root package name */
    public volatile c f48049b;

    /* renamed from: d.a.i0.b0.b$b  reason: collision with other inner class name */
    /* loaded from: classes3.dex */
    public class C1019b {

        /* renamed from: a  reason: collision with root package name */
        public ImageFileInfo f48050a;

        /* renamed from: b  reason: collision with root package name */
        public d.a.i0.a0.b f48051b;

        /* renamed from: c  reason: collision with root package name */
        public boolean f48052c;

        /* renamed from: d  reason: collision with root package name */
        public d.a.c.j.d.a f48053d;

        /* renamed from: e  reason: collision with root package name */
        public boolean f48054e;

        public C1019b(b bVar) {
        }
    }

    /* loaded from: classes3.dex */
    public class c extends BdAsyncTask<Void, C1019b, C1019b> {

        /* renamed from: a  reason: collision with root package name */
        public final Queue<C1019b> f48055a;

        public c(Queue<C1019b> queue) {
            this.f48055a = queue;
            super.setPriority(2);
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
        /* renamed from: b */
        public C1019b doInBackground(Void... voidArr) {
            int i2;
            while (true) {
                C1019b poll = this.f48055a.poll();
                Bitmap bitmap = null;
                if (poll == null) {
                    return null;
                }
                if (isCancelled()) {
                    this.f48055a.add(poll);
                    return null;
                }
                d.a.c.j.d.a m = d.a.i0.a0.c.k().m(poll.f48050a.toCachedKey(poll.f48052c));
                if (m != null) {
                    poll.f48053d = m;
                    poll.f48054e = true;
                } else {
                    Bitmap f2 = b.this.f(poll.f48050a, poll.f48052c);
                    if (f2 != null) {
                        try {
                            i2 = BitmapHelper.readPictureDegree(poll.f48050a.getFilePath());
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
                            poll.f48053d = new d.a.c.j.d.a(bitmap, poll.f48050a.isGif(), poll.f48050a.getFilePath());
                        } else {
                            poll.f48053d = new d.a.c.j.d.a(f2, poll.f48050a.isGif(), poll.f48050a.getFilePath());
                        }
                    }
                }
                publishProgress(poll);
            }
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
        /* renamed from: c */
        public void onPostExecute(C1019b c1019b) {
            super.onPostExecute(c1019b);
            b.this.f48049b = null;
            b.this.g();
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
        /* renamed from: d */
        public void onProgressUpdate(C1019b... c1019bArr) {
            if (c1019bArr != null) {
                for (C1019b c1019b : c1019bArr) {
                    d.a.c.j.d.a aVar = c1019b.f48053d;
                    if (aVar != null && !c1019b.f48054e) {
                        d.a.i0.a0.c.k().d(c1019b.f48050a.toCachedKey(c1019b.f48052c), aVar);
                    }
                    d.a.i0.a0.b bVar = c1019b.f48051b;
                    if (bVar != null) {
                        bVar.a(aVar, c1019b.f48050a.toCachedKey(c1019b.f48052c), c1019b.f48054e);
                    }
                }
            }
        }

        @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
        public void onCancelled() {
            super.onCancelled();
            b.this.f48049b = null;
            while (true) {
                C1019b poll = this.f48055a.poll();
                if (poll == null) {
                    return;
                }
                d.a.i0.a0.b bVar = poll.f48051b;
                if (bVar != null) {
                    bVar.a(null, poll.f48050a.toCachedKey(poll.f48052c), false);
                }
            }
        }
    }

    public void b() {
        this.f48048a = new ConcurrentLinkedQueue();
        if (this.f48049b != null) {
            this.f48049b.cancel(true);
            this.f48049b = null;
        }
    }

    public d.a.c.j.d.a c(ImageFileInfo imageFileInfo, boolean z) {
        if (imageFileInfo == null) {
            return null;
        }
        return d.a.i0.a0.c.k().m(imageFileInfo.toCachedKey(z));
    }

    public d.a.c.j.d.a d(ImageFileInfo imageFileInfo, d.a.i0.a0.b bVar, boolean z) {
        return e(imageFileInfo, bVar, z, false);
    }

    public d.a.c.j.d.a e(ImageFileInfo imageFileInfo, d.a.i0.a0.b bVar, boolean z, boolean z2) {
        d.a.c.j.d.a c2 = c(imageFileInfo, z);
        if (c2 != null) {
            return c2;
        }
        if (z2) {
            return null;
        }
        C1019b c1019b = new C1019b();
        c1019b.f48051b = bVar;
        c1019b.f48050a = imageFileInfo;
        c1019b.f48052c = z;
        this.f48048a.add(c1019b);
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
                return d.a.i0.b0.g.c.d().b(imageFileInfo.getOrginalBitmap(), !imageFileInfo.isOrginalBitmapShared(), linkedList, imageFileInfo);
            } catch (Exception e2) {
                e2.printStackTrace();
                return null;
            }
        } else if (imageFileInfo.hasActions(z)) {
            try {
                return d.a.i0.b0.g.c.d().c(imageFileInfo.getFilePath(), linkedList, imageFileInfo);
            } catch (Exception e3) {
                e3.printStackTrace();
                return null;
            }
        } else {
            return BitmapHelper.loadBitmap(imageFileInfo.getFilePath());
        }
    }

    public void g() {
        if (this.f48049b != null || this.f48048a.isEmpty()) {
            return;
        }
        this.f48049b = new c(this.f48048a);
        this.f48049b.execute(new Void[0]);
    }
}
