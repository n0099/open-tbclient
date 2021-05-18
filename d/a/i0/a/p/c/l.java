package d.a.i0.a.p.c;

import android.app.Activity;
import android.app.Dialog;
import android.content.Context;
import android.os.Bundle;
import android.os.Handler;
import android.os.Message;
import android.text.TextUtils;
import android.util.Log;
import com.baidu.swan.apps.SwanAppActivity;
import com.baidu.swan.apps.media.chooser.activity.SwanAppAlbumActivity;
import com.baidu.swan.apps.media.chooser.activity.SwanAppAlbumPreviewActivity;
import com.baidu.swan.apps.media.chooser.model.ImageModel;
import com.baidu.swan.apps.media.chooser.model.MediaModel;
import com.baidu.swan.apps.media.chooser.model.VideoModel;
import java.io.File;
import java.lang.ref.WeakReference;
import java.util.ArrayList;
import java.util.Iterator;
/* loaded from: classes2.dex */
public class l implements d.a.i0.a.p.d.x {

    /* loaded from: classes2.dex */
    public static class b implements Runnable {

        /* renamed from: e  reason: collision with root package name */
        public Context f43789e;

        /* renamed from: f  reason: collision with root package name */
        public ArrayList<MediaModel> f43790f;

        /* renamed from: g  reason: collision with root package name */
        public boolean f43791g;

        /* renamed from: h  reason: collision with root package name */
        public String f43792h;

        /* renamed from: i  reason: collision with root package name */
        public d.a.i0.a.i1.d.d.d f43793i;
        public HandlerC0775b j;
        public a k;

        /* loaded from: classes2.dex */
        public class a extends d.a.i0.a.g1.a {

            /* renamed from: e  reason: collision with root package name */
            public HandlerC0775b f43794e;

            public a(HandlerC0775b handlerC0775b) {
                this.f43794e = handlerC0775b;
            }

            @Override // d.a.i0.a.g1.a, android.app.Application.ActivityLifecycleCallbacks
            public void onActivityDestroyed(Activity activity) {
                if ((activity instanceof SwanAppActivity) || (activity instanceof SwanAppAlbumActivity) || (activity instanceof SwanAppAlbumPreviewActivity)) {
                    if (this.f43794e.f43797b != null && this.f43794e.f43797b.isShowing()) {
                        this.f43794e.f43797b.cancel();
                        this.f43794e.f43797b = null;
                    }
                    HandlerC0775b handlerC0775b = this.f43794e;
                    if (handlerC0775b != null) {
                        handlerC0775b.removeMessages(1);
                        this.f43794e.removeMessages(2);
                        this.f43794e = null;
                    }
                    b.this.f();
                }
            }
        }

        /* renamed from: d.a.i0.a.p.c.l$b$b  reason: collision with other inner class name */
        /* loaded from: classes2.dex */
        public static class HandlerC0775b extends Handler {

            /* renamed from: a  reason: collision with root package name */
            public WeakReference<Context> f43796a;

            /* renamed from: b  reason: collision with root package name */
            public Dialog f43797b;

            @Override // android.os.Handler
            public void handleMessage(Message message) {
                Dialog dialog;
                int i2 = message.what;
                if (i2 != 1) {
                    if (i2 == 2 && (dialog = this.f43797b) != null && dialog.isShowing()) {
                        Context context = this.f43796a.get();
                        if ((context instanceof Activity) && !((Activity) context).isFinishing()) {
                            this.f43797b.cancel();
                        }
                        this.f43797b = null;
                        return;
                    }
                    return;
                }
                Context context2 = this.f43796a.get();
                if (!(context2 instanceof Activity) || ((Activity) context2).isFinishing()) {
                    return;
                }
                Dialog dialog2 = new Dialog(this.f43796a.get(), d.a.i0.a.i.SwanAppCompressDialog);
                this.f43797b = dialog2;
                dialog2.setContentView(d.a.i0.a.g.swanapp_progress_dialog);
                this.f43797b.findViewById(d.a.i0.a.f.layer_night).setVisibility(d.a.i0.a.c1.a.H().a() ? 0 : 8);
                this.f43797b.setCancelable(false);
                this.f43797b.show();
            }

            public HandlerC0775b(Context context) {
                this.f43796a = new WeakReference<>(context);
            }
        }

        public b(Context context, Bundle bundle, d.a.i0.a.i1.d.d.d dVar) {
            this.f43789e = context;
            this.f43790f = bundle.getParcelableArrayList("mediaModels");
            d.a.i0.a.v2.v.g(bundle, "swanAppId");
            this.f43791g = d.a.i0.a.v2.v.c(bundle, "compressed", false);
            this.f43792h = d.a.i0.a.v2.v.g(bundle, "swanTmpPath");
            this.f43793i = dVar;
            this.j = new HandlerC0775b(context);
        }

        public final void b(MediaModel mediaModel, int i2) {
            if (mediaModel == null) {
                return;
            }
            if (d.a.i0.a.i1.d.c.c.f42689a) {
                Log.d("CompressTask", "compressImg : " + mediaModel.b());
            }
            File file = new File(mediaModel.b());
            File l = d.a.i0.a.v2.u.l(this.f43792h, file.getName());
            if (l == null) {
                return;
            }
            mediaModel.h(l.getAbsolutePath());
            d.a.i0.a.v2.u.n(file, l, i2);
            mediaModel.g(l.length());
        }

        public final void c(VideoModel videoModel) {
            if (videoModel == null) {
                return;
            }
            if (d.a.i0.a.i1.d.c.c.f42689a) {
                Log.d("CompressTask", "compressVideo : " + videoModel.b());
            }
            File l = d.a.i0.a.v2.u.l(this.f43792h, new File(videoModel.b()).getName());
            if (l == null) {
                return;
            }
            d.a.i0.t.d.f(new File(videoModel.b()), l);
            videoModel.h(l.getPath());
            videoModel.g(l.length());
        }

        public final void d(MediaModel mediaModel) {
            if (mediaModel == null) {
                return;
            }
            File file = new File(mediaModel.b());
            File l = d.a.i0.a.v2.u.l(this.f43792h, file.getName());
            if (l == null || !l.exists() || d.a.i0.t.d.f(file, l) == 0) {
                return;
            }
            mediaModel.h(l.getPath());
        }

        public final void e() {
            this.k = new a(this.j);
            d.a.i0.a.c1.a.b().registerActivityLifecycleCallbacks(this.k);
        }

        public final void f() {
            if (this.k != null) {
                d.a.i0.a.c1.a.b().unregisterActivityLifecycleCallbacks(this.k);
                this.k = null;
            }
        }

        @Override // java.lang.Runnable
        public void run() {
            e();
            HandlerC0775b handlerC0775b = this.j;
            if (handlerC0775b != null) {
                handlerC0775b.sendEmptyMessage(1);
            }
            if (this.f43791g) {
                Iterator<MediaModel> it = this.f43790f.iterator();
                while (it.hasNext()) {
                    MediaModel next = it.next();
                    if (next != null) {
                        if (next instanceof ImageModel) {
                            if (TextUtils.equals(d.a.i0.t.d.s(next.b()), "gif")) {
                                d(next);
                            } else {
                                b(next, 20);
                            }
                        } else if (next instanceof VideoModel) {
                            c((VideoModel) next);
                        }
                    }
                }
            } else {
                Iterator<MediaModel> it2 = this.f43790f.iterator();
                while (it2.hasNext()) {
                    MediaModel next2 = it2.next();
                    if (next2 != null) {
                        if (next2 instanceof ImageModel) {
                            b(next2, 100);
                        } else {
                            d(next2);
                        }
                    }
                }
            }
            HandlerC0775b handlerC0775b2 = this.j;
            if (handlerC0775b2 != null) {
                handlerC0775b2.sendEmptyMessage(2);
            }
            d.a.i0.a.i1.d.d.d dVar = this.f43793i;
            if (dVar != null) {
                dVar.a(true, null, this.f43790f);
            }
            f();
        }
    }

    @Override // d.a.i0.a.p.d.x
    public void a(Activity activity, Bundle bundle, d.a.i0.a.i1.d.d.d dVar) {
        d.a.i0.a.v2.q.j(new b(activity, bundle, dVar), "main process compress files");
    }
}
