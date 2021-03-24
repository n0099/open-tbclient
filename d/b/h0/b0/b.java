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
    public Queue<C1045b> f49764a = new ConcurrentLinkedQueue();

    /* renamed from: b  reason: collision with root package name */
    public volatile c f49765b;

    /* renamed from: d.b.h0.b0.b$b  reason: collision with other inner class name */
    /* loaded from: classes3.dex */
    public class C1045b {

        /* renamed from: a  reason: collision with root package name */
        public ImageFileInfo f49766a;

        /* renamed from: b  reason: collision with root package name */
        public d.b.h0.a0.b f49767b;

        /* renamed from: c  reason: collision with root package name */
        public boolean f49768c;

        /* renamed from: d  reason: collision with root package name */
        public d.b.b.j.d.a f49769d;

        /* renamed from: e  reason: collision with root package name */
        public boolean f49770e;

        public C1045b(b bVar) {
        }
    }

    /* loaded from: classes3.dex */
    public class c extends BdAsyncTask<Void, C1045b, C1045b> {

        /* renamed from: a  reason: collision with root package name */
        public final Queue<C1045b> f49771a;

        public c(Queue<C1045b> queue) {
            this.f49771a = queue;
            super.setPriority(2);
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
        /* renamed from: b */
        public C1045b doInBackground(Void... voidArr) {
            int i;
            while (true) {
                C1045b poll = this.f49771a.poll();
                Bitmap bitmap = null;
                if (poll == null) {
                    return null;
                }
                if (isCancelled()) {
                    this.f49771a.add(poll);
                    return null;
                }
                d.b.b.j.d.a l = d.b.h0.a0.c.j().l(poll.f49766a.toCachedKey(poll.f49768c));
                if (l != null) {
                    poll.f49769d = l;
                    poll.f49770e = true;
                } else {
                    Bitmap f2 = b.this.f(poll.f49766a, poll.f49768c);
                    if (f2 != null) {
                        try {
                            i = BitmapHelper.readPictureDegree(poll.f49766a.getFilePath());
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
                            poll.f49769d = new d.b.b.j.d.a(bitmap, poll.f49766a.isGif(), poll.f49766a.getFilePath());
                        } else {
                            poll.f49769d = new d.b.b.j.d.a(f2, poll.f49766a.isGif(), poll.f49766a.getFilePath());
                        }
                    }
                }
                publishProgress(poll);
            }
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
        /* renamed from: c */
        public void onPostExecute(C1045b c1045b) {
            super.onPostExecute(c1045b);
            b.this.f49765b = null;
            b.this.g();
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
        /* renamed from: d */
        public void onProgressUpdate(C1045b... c1045bArr) {
            if (c1045bArr != null) {
                for (C1045b c1045b : c1045bArr) {
                    d.b.b.j.d.a aVar = c1045b.f49769d;
                    if (aVar != null && !c1045b.f49770e) {
                        d.b.h0.a0.c.j().d(c1045b.f49766a.toCachedKey(c1045b.f49768c), aVar);
                    }
                    d.b.h0.a0.b bVar = c1045b.f49767b;
                    if (bVar != null) {
                        bVar.a(aVar, c1045b.f49766a.toCachedKey(c1045b.f49768c), c1045b.f49770e);
                    }
                }
            }
        }

        @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
        public void onCancelled() {
            super.onCancelled();
            b.this.f49765b = null;
            while (true) {
                C1045b poll = this.f49771a.poll();
                if (poll == null) {
                    return;
                }
                d.b.h0.a0.b bVar = poll.f49767b;
                if (bVar != null) {
                    bVar.a(null, poll.f49766a.toCachedKey(poll.f49768c), false);
                }
            }
        }
    }

    public void b() {
        this.f49764a = new ConcurrentLinkedQueue();
        if (this.f49765b != null) {
            this.f49765b.cancel(true);
            this.f49765b = null;
        }
    }

    public d.b.b.j.d.a c(ImageFileInfo imageFileInfo, boolean z) {
        if (imageFileInfo == null) {
            return null;
        }
        return d.b.h0.a0.c.j().l(imageFileInfo.toCachedKey(z));
    }

    public d.b.b.j.d.a d(ImageFileInfo imageFileInfo, d.b.h0.a0.b bVar, boolean z) {
        return e(imageFileInfo, bVar, z, false);
    }

    public d.b.b.j.d.a e(ImageFileInfo imageFileInfo, d.b.h0.a0.b bVar, boolean z, boolean z2) {
        d.b.b.j.d.a c2 = c(imageFileInfo, z);
        if (c2 != null) {
            return c2;
        }
        if (z2) {
            return null;
        }
        C1045b c1045b = new C1045b();
        c1045b.f49767b = bVar;
        c1045b.f49766a = imageFileInfo;
        c1045b.f49768c = z;
        this.f49764a.add(c1045b);
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
        if (this.f49765b != null || this.f49764a.isEmpty()) {
            return;
        }
        this.f49765b = new c(this.f49764a);
        this.f49765b.execute(new Void[0]);
    }
}
